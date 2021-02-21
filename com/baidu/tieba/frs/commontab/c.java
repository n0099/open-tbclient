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
    private d jpD;
    private FrsCommonTabRequestData jpK;
    private FrsCommonTabNetModel jpL;
    private FrsDynamicRequestData jpM;
    private FrsDynamicModel jpN;
    private boolean jpO;
    private String jpR;
    private FrsCommonTabFragment jpe;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> jpP = new HashSet<>();
    private int mPn = 1;
    private long jpQ = -1;

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.funAdController = aVar;
    }

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.jpe = frsCommonTabFragment;
            this.jpR = "FRS_GENERAL_TAB" + i2;
            if (i2 == 89) {
                this.isDynamic = true;
                this.jpM = new FrsDynamicRequestData();
                this.jpM.forumId = i;
                this.jpM.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.jpM.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.jpM.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.jpN = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.jpM);
                this.jpN.a(this);
                this.jpN.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.jpK = new FrsCommonTabRequestData();
            this.jpK.fid = i;
            this.jpK.tabId = i2;
            this.jpK.isDefaultNavTab = zi(i2) ? 1 : 0;
            this.jpK.tabName = str;
            this.jpK.isGeneralTab = i3;
            this.jpL = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.jpK);
            this.jpL.a(this);
            this.jpL.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.jpK != null) {
            this.jpK.tabType = i;
        }
    }

    private boolean zi(int i) {
        return (this.jpe == null || this.jpe.jpt == null || this.jpe.jpt.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void zj(int i) {
        this.jpO = true;
        if (!this.isDynamic) {
            if (!this.jpL.isLoading()) {
                this.mPn = 1;
                this.jpK.pn = this.mPn;
                this.jpK.sortType = i;
                if (this.jpQ >= 0) {
                    this.jpK.lastThreadId = this.jpQ;
                }
                this.jpK.adExtParams = cFW();
                this.jpL.loadData();
            }
        } else if (!this.jpN.isLoading()) {
            if (av.bsS().bsT()) {
                this.jpM.qType = 2;
            } else {
                this.jpM.qType = 1;
            }
            this.jpM.lastThreadId = 0L;
            this.jpN.loadData();
        }
    }

    public void zk(int i) {
        this.jpO = false;
        if (!this.isDynamic) {
            if (!this.jpL.isLoading()) {
                this.mPn++;
                this.jpK.pn = this.mPn;
                this.jpK.sortType = i;
                this.jpK.lastThreadId = -1L;
                this.jpK.adExtParams = cFW();
                this.jpL.loadData();
            }
        } else if (!this.jpN.isLoading()) {
            if (av.bsS().bsT()) {
                this.jpM.qType = 2;
            } else {
                this.jpM.qType = 1;
            }
            this.jpN.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.jpO) {
            this.jpD = dVar;
            this.jpP.clear();
            Iterator<n> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof cb) {
                    String tid = ((cb) next).getTid();
                    if (!this.jpP.contains(tid)) {
                        this.jpP.add(tid);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cNu()) {
                if (this.funAdController != null) {
                    this.funAdController.r(this.jpD.threadList, this.jpO);
                }
            } else {
                v(dVar.gcA, this.jpD.threadList);
            }
        } else {
            this.jpD.hasMore = dVar.hasMore;
            this.jpD.userMap.putAll(dVar.userMap);
            ArrayList arrayList = new ArrayList();
            Iterator<n> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof cb) {
                    String tid2 = ((cb) next2).getTid();
                    if (!this.jpP.contains(tid2)) {
                        ((cb) next2).eTo = this.jpe.isBrandForum;
                        arrayList.add(next2);
                        this.jpP.add(tid2);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cNu()) {
                if (this.funAdController != null) {
                    this.funAdController.r(arrayList, this.jpO);
                }
            } else {
                v(dVar.gcA, arrayList);
            }
            this.jpD.threadList.addAll(arrayList);
        }
        this.jpe.a(this.jpD);
        return true;
    }

    public void aq(cb cbVar) {
        if (cbVar != null && this.jpD != null && this.jpD.threadList != null) {
            if (y.isEmpty(this.jpD.threadList)) {
                this.jpD.threadList.add(cbVar);
            } else {
                if (this.jpD.threadList.size() == 1 && (this.jpD.threadList.get(0) instanceof s)) {
                    this.jpD.threadList.remove(0);
                }
                this.jpD.threadList.add(0, cbVar);
            }
            this.jpe.a(this.jpD);
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
                            this.jpM.lastThreadId = com.baidu.adp.lib.f.b.toLong(((cb) nVar).getId(), 0L);
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
                    this.jpe.a(errorData);
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
                            this.jpM.lastThreadId = com.baidu.adp.lib.f.b.toLong(((cb) nVar).getId(), 0L);
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
                    this.jpe.a(errorData);
                }
            }
        }
    }

    private String cFW() {
        return AdExtParam.a.bEU().rC(this.jpO ? 0 : com.baidu.tieba.recapp.a.fJ(this.jpD.threadList)).DH(com.baidu.tieba.recapp.a.y(this.jpD == null ? null : this.jpD.threadList, this.jpO)).DF(this.jpO ? "" : com.baidu.tieba.recapp.report.b.dEt().RR(this.jpR)).DG(this.jpe.forumName).bEV();
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
            com.baidu.tieba.recapp.report.b.dEt().q(this.jpR, arrayList);
        }
    }

    public boolean hasData() {
        return (this.jpD == null || y.isEmpty(this.jpD.threadList)) ? false : true;
    }

    public d cFX() {
        return this.jpD;
    }

    public void gs(long j) {
        this.jpQ = j;
    }

    public boolean cFY() {
        return this.jpO;
    }

    public int getPn() {
        return this.mPn;
    }

    public void Ks(String str) {
        if (this.jpD != null && !com.baidu.tieba.lego.card.c.a.isEmpty(this.jpD.threadList)) {
            com.baidu.tieba.recapp.a.i(str, this.jpD.threadList);
            this.jpe.a(this.jpD);
        }
    }
}
