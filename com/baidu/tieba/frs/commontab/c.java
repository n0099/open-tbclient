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
    private FrsCommonTabFragment joQ;
    private boolean jpA;
    private String jpD;
    private d jpp;
    private FrsCommonTabRequestData jpw;
    private FrsCommonTabNetModel jpx;
    private FrsDynamicRequestData jpy;
    private FrsDynamicModel jpz;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> jpB = new HashSet<>();
    private int mPn = 1;
    private long jpC = -1;

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.funAdController = aVar;
    }

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.joQ = frsCommonTabFragment;
            this.jpD = "FRS_GENERAL_TAB" + i2;
            if (i2 == 89) {
                this.isDynamic = true;
                this.jpy = new FrsDynamicRequestData();
                this.jpy.forumId = i;
                this.jpy.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.jpy.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.jpy.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.jpz = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.jpy);
                this.jpz.a(this);
                this.jpz.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.jpw = new FrsCommonTabRequestData();
            this.jpw.fid = i;
            this.jpw.tabId = i2;
            this.jpw.isDefaultNavTab = zi(i2) ? 1 : 0;
            this.jpw.tabName = str;
            this.jpw.isGeneralTab = i3;
            this.jpx = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.jpw);
            this.jpx.a(this);
            this.jpx.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.jpw != null) {
            this.jpw.tabType = i;
        }
    }

    private boolean zi(int i) {
        return (this.joQ == null || this.joQ.jpf == null || this.joQ.jpf.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void zj(int i) {
        this.jpA = true;
        if (!this.isDynamic) {
            if (!this.jpx.isLoading()) {
                this.mPn = 1;
                this.jpw.pn = this.mPn;
                this.jpw.sortType = i;
                if (this.jpC >= 0) {
                    this.jpw.lastThreadId = this.jpC;
                }
                this.jpw.adExtParams = cFP();
                this.jpx.loadData();
            }
        } else if (!this.jpz.isLoading()) {
            if (av.bsS().bsT()) {
                this.jpy.qType = 2;
            } else {
                this.jpy.qType = 1;
            }
            this.jpy.lastThreadId = 0L;
            this.jpz.loadData();
        }
    }

    public void zk(int i) {
        this.jpA = false;
        if (!this.isDynamic) {
            if (!this.jpx.isLoading()) {
                this.mPn++;
                this.jpw.pn = this.mPn;
                this.jpw.sortType = i;
                this.jpw.lastThreadId = -1L;
                this.jpw.adExtParams = cFP();
                this.jpx.loadData();
            }
        } else if (!this.jpz.isLoading()) {
            if (av.bsS().bsT()) {
                this.jpy.qType = 2;
            } else {
                this.jpy.qType = 1;
            }
            this.jpz.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.jpA) {
            this.jpp = dVar;
            this.jpB.clear();
            Iterator<n> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof cb) {
                    String tid = ((cb) next).getTid();
                    if (!this.jpB.contains(tid)) {
                        this.jpB.add(tid);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cNn()) {
                if (this.funAdController != null) {
                    this.funAdController.r(this.jpp.threadList, this.jpA);
                }
            } else {
                v(dVar.gcv, this.jpp.threadList);
            }
        } else {
            this.jpp.hasMore = dVar.hasMore;
            this.jpp.userMap.putAll(dVar.userMap);
            ArrayList arrayList = new ArrayList();
            Iterator<n> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof cb) {
                    String tid2 = ((cb) next2).getTid();
                    if (!this.jpB.contains(tid2)) {
                        ((cb) next2).eTo = this.joQ.isBrandForum;
                        arrayList.add(next2);
                        this.jpB.add(tid2);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cNn()) {
                if (this.funAdController != null) {
                    this.funAdController.r(arrayList, this.jpA);
                }
            } else {
                v(dVar.gcv, arrayList);
            }
            this.jpp.threadList.addAll(arrayList);
        }
        this.joQ.a(this.jpp);
        return true;
    }

    public void aq(cb cbVar) {
        if (cbVar != null && this.jpp != null && this.jpp.threadList != null) {
            if (y.isEmpty(this.jpp.threadList)) {
                this.jpp.threadList.add(cbVar);
            } else {
                if (this.jpp.threadList.size() == 1 && (this.jpp.threadList.get(0) instanceof s)) {
                    this.jpp.threadList.remove(0);
                }
                this.jpp.threadList.add(0, cbVar);
            }
            this.joQ.a(this.jpp);
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
                            this.jpy.lastThreadId = com.baidu.adp.lib.f.b.toLong(((cb) nVar).getId(), 0L);
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
                    this.joQ.a(errorData);
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
                            this.jpy.lastThreadId = com.baidu.adp.lib.f.b.toLong(((cb) nVar).getId(), 0L);
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
                    this.joQ.a(errorData);
                }
            }
        }
    }

    private String cFP() {
        return AdExtParam.a.bEU().rC(this.jpA ? 0 : com.baidu.tieba.recapp.a.fJ(this.jpp.threadList)).DJ(com.baidu.tieba.recapp.a.y(this.jpp == null ? null : this.jpp.threadList, this.jpA)).DH(this.jpA ? "" : com.baidu.tieba.recapp.report.b.dEl().RF(this.jpD)).DI(this.joQ.forumName).bEV();
    }

    private void v(List<App> list, List<n> list2) {
        dl(list2);
        com.baidu.tieba.recapp.a.b(com.baidu.tieba.recapp.a.p(list, "FRS_GENERAL_TAB"), list2, 0);
        com.baidu.tieba.recapp.a.a(list2, this.mPn, "FRS_GENERAL_TAB");
    }

    private void dl(List<n> list) {
        JSONObject f;
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if ((nVar instanceof cb) && (f = com.baidu.tieba.recapp.report.b.f(((cb) nVar).bpT())) != null) {
                    arrayList.add(f);
                }
            }
            com.baidu.tieba.recapp.report.b.dEl().q(this.jpD, arrayList);
        }
    }

    public boolean hasData() {
        return (this.jpp == null || y.isEmpty(this.jpp.threadList)) ? false : true;
    }

    public d cFQ() {
        return this.jpp;
    }

    public void gs(long j) {
        this.jpC = j;
    }

    public boolean cFR() {
        return this.jpA;
    }

    public int getPn() {
        return this.mPn;
    }

    public void Kr(String str) {
        if (this.jpp != null && !com.baidu.tieba.lego.card.c.a.isEmpty(this.jpp.threadList)) {
            com.baidu.tieba.recapp.a.i(str, this.jpp.threadList);
            this.joQ.a(this.jpp);
        }
    }
}
