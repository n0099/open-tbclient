package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes2.dex */
public class c implements NetModel.b {
    private com.baidu.tieba.funad.a funAdController;
    private boolean isDynamic;
    private FrsCommonTabFragment jqN;
    private String jrA;
    private d jrm;
    private FrsCommonTabRequestData jrt;
    private FrsCommonTabNetModel jru;
    private FrsDynamicRequestData jrv;
    private FrsDynamicModel jrw;
    private boolean jrx;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> jry = new HashSet<>();
    private int mPn = 1;
    private long jrz = -1;

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.funAdController = aVar;
    }

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.jqN = frsCommonTabFragment;
            this.jrA = "FRS_GENERAL_TAB" + i2;
            if (i2 == 89) {
                this.isDynamic = true;
                this.jrv = new FrsDynamicRequestData();
                this.jrv.forumId = i;
                this.jrv.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.jrv.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.jrv.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.jrw = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.jrv);
                this.jrw.a(this);
                this.jrw.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.jrt = new FrsCommonTabRequestData();
            this.jrt.fid = i;
            this.jrt.tabId = i2;
            this.jrt.isDefaultNavTab = zj(i2) ? 1 : 0;
            this.jrt.tabName = str;
            this.jrt.isGeneralTab = i3;
            this.jru = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.jrt);
            this.jru.a(this);
            this.jru.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.jrt != null) {
            this.jrt.tabType = i;
        }
    }

    private boolean zj(int i) {
        return (this.jqN == null || this.jqN.jrc == null || this.jqN.jrc.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void zk(int i) {
        this.jrx = true;
        if (!this.isDynamic) {
            if (!this.jru.isLoading()) {
                this.mPn = 1;
                this.jrt.pn = this.mPn;
                this.jrt.sortType = i;
                if (this.jrz >= 0) {
                    this.jrt.lastThreadId = this.jrz;
                }
                this.jrt.adExtParams = cGc();
                this.jru.loadData();
            }
        } else if (!this.jrw.isLoading()) {
            if (av.bsV().bsW()) {
                this.jrv.qType = 2;
            } else {
                this.jrv.qType = 1;
            }
            this.jrv.lastThreadId = 0L;
            this.jrw.loadData();
        }
    }

    public void zl(int i) {
        this.jrx = false;
        if (!this.isDynamic) {
            if (!this.jru.isLoading()) {
                this.mPn++;
                this.jrt.pn = this.mPn;
                this.jrt.sortType = i;
                this.jrt.lastThreadId = -1L;
                this.jrt.adExtParams = cGc();
                this.jru.loadData();
            }
        } else if (!this.jrw.isLoading()) {
            if (av.bsV().bsW()) {
                this.jrv.qType = 2;
            } else {
                this.jrv.qType = 1;
            }
            this.jrw.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.jrx) {
            this.jrm = dVar;
            this.jry.clear();
            Iterator<n> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof cb) {
                    String tid = ((cb) next).getTid();
                    if (!this.jry.contains(tid)) {
                        this.jry.add(tid);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cNC()) {
                if (this.funAdController != null) {
                    this.funAdController.r(this.jrm.threadList, this.jrx);
                }
            } else {
                u(dVar.gea, this.jrm.threadList);
            }
        } else {
            this.jrm.hasMore = dVar.hasMore;
            this.jrm.userMap.putAll(dVar.userMap);
            ArrayList arrayList = new ArrayList();
            Iterator<n> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof cb) {
                    String tid2 = ((cb) next2).getTid();
                    if (!this.jry.contains(tid2)) {
                        ((cb) next2).eUP = this.jqN.isBrandForum;
                        arrayList.add(next2);
                        this.jry.add(tid2);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cNC()) {
                if (this.funAdController != null) {
                    this.funAdController.r(arrayList, this.jrx);
                }
            } else {
                u(dVar.gea, arrayList);
            }
            this.jrm.threadList.addAll(arrayList);
        }
        this.jqN.a(this.jrm);
        return true;
    }

    public void aq(cb cbVar) {
        if (cbVar != null && this.jrm != null && this.jrm.threadList != null) {
            if (y.isEmpty(this.jrm.threadList)) {
                this.jrm.threadList.add(cbVar);
            } else {
                if (this.jrm.threadList.size() == 1 && (this.jrm.threadList.get(0) instanceof s)) {
                    this.jrm.threadList.remove(0);
                }
                this.jrm.threadList.add(0, cbVar);
            }
            this.jqN.a(this.jrm);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcHttpResponsedMessage != null) {
            d dVar = null;
            if (!mvcHttpResponsedMessage.hasError()) {
                if (mvcHttpResponsedMessage.getData() instanceof d) {
                    dVar = (d) mvcHttpResponsedMessage.getData();
                } else if (mvcHttpResponsedMessage.getData() instanceof com.baidu.tieba.frs.dynamic.a) {
                    com.baidu.tieba.frs.dynamic.a aVar = (com.baidu.tieba.frs.dynamic.a) mvcHttpResponsedMessage.getData();
                    d dVar2 = new d();
                    dVar2.threadList = aVar.threadList;
                    dVar2.hasMore = aVar.hasMore;
                    dVar2.userMap = aVar.userMap;
                    if (!y.isEmpty(dVar2.threadList)) {
                        n nVar = (n) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (nVar instanceof cb) {
                            this.jrv.lastThreadId = com.baidu.adp.lib.f.b.toLong(((cb) nVar).getId(), 0L);
                        }
                    }
                    dVar = dVar2;
                }
            }
            if (dVar == null || !b(dVar)) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.jqN.a(errorData);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcSocketResponsedMessage != null) {
            d dVar = null;
            if (!mvcSocketResponsedMessage.hasError()) {
                if (mvcSocketResponsedMessage.getData() instanceof d) {
                    dVar = (d) mvcSocketResponsedMessage.getData();
                } else if (mvcSocketResponsedMessage.getData() instanceof com.baidu.tieba.frs.dynamic.a) {
                    com.baidu.tieba.frs.dynamic.a aVar = (com.baidu.tieba.frs.dynamic.a) mvcSocketResponsedMessage.getData();
                    d dVar2 = new d();
                    dVar2.threadList = aVar.threadList;
                    dVar2.hasMore = aVar.hasMore;
                    dVar2.userMap = aVar.userMap;
                    if (!y.isEmpty(dVar2.threadList)) {
                        n nVar = (n) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (nVar instanceof cb) {
                            this.jrv.lastThreadId = com.baidu.adp.lib.f.b.toLong(((cb) nVar).getId(), 0L);
                        }
                    }
                    dVar = dVar2;
                }
            }
            if (dVar == null || !b(dVar)) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.jqN.a(errorData);
                }
            }
        }
    }

    private String cGc() {
        return AdExtParam.a.bEY().rE(this.jrx ? 0 : com.baidu.tieba.recapp.a.fJ(this.jrm.threadList)).DO(com.baidu.tieba.recapp.a.y(this.jrm == null ? null : this.jrm.threadList, this.jrx)).DM(this.jrx ? "" : com.baidu.tieba.recapp.report.b.dEB().RX(this.jrA)).DN(this.jqN.forumName).bEZ();
    }

    private void u(List<App> list, List<n> list2) {
        dl(list2);
        com.baidu.tieba.recapp.a.b(com.baidu.tieba.recapp.a.p(list, "FRS_GENERAL_TAB"), list2, 0);
        com.baidu.tieba.recapp.a.a(list2, this.mPn, "FRS_GENERAL_TAB");
    }

    private void dl(List<n> list) {
        JSONObject f;
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if ((nVar instanceof cb) && (f = com.baidu.tieba.recapp.report.b.f(((cb) nVar).bpV())) != null) {
                    arrayList.add(f);
                }
            }
            com.baidu.tieba.recapp.report.b.dEB().q(this.jrA, arrayList);
        }
    }

    public boolean hasData() {
        return (this.jrm == null || y.isEmpty(this.jrm.threadList)) ? false : true;
    }

    public d cGd() {
        return this.jrm;
    }

    public void gs(long j) {
        this.jrz = j;
    }

    public boolean cGe() {
        return this.jrx;
    }

    public int getPn() {
        return this.mPn;
    }

    public void KB(String str) {
        if (this.jrm != null && !com.baidu.tieba.lego.card.c.a.isEmpty(this.jrm.threadList)) {
            com.baidu.tieba.recapp.a.i(str, this.jrm.threadList);
            this.jqN.a(this.jrm);
        }
    }
}
