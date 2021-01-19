package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
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
    private d jjI;
    private FrsCommonTabRequestData jjP;
    private FrsCommonTabNetModel jjQ;
    private FrsDynamicRequestData jjR;
    private FrsDynamicModel jjS;
    private boolean jjT;
    private String jjW;
    private FrsCommonTabFragment jjj;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> jjU = new HashSet<>();
    private int mPn = 1;
    private long jjV = -1;

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.funAdController = aVar;
    }

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.jjj = frsCommonTabFragment;
            this.jjW = "FRS_GENERAL_TAB" + i2;
            if (i2 == 89) {
                this.isDynamic = true;
                this.jjR = new FrsDynamicRequestData();
                this.jjR.forumId = i;
                this.jjR.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.jjR.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.jjR.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.jjS = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.jjR);
                this.jjS.a(this);
                this.jjS.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.jjP = new FrsCommonTabRequestData();
            this.jjP.fid = i;
            this.jjP.tabId = i2;
            this.jjP.isDefaultNavTab = yY(i2) ? 1 : 0;
            this.jjP.tabName = str;
            this.jjP.isGeneralTab = i3;
            this.jjQ = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.jjP);
            this.jjQ.a(this);
            this.jjQ.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.jjP != null) {
            this.jjP.tabType = i;
        }
    }

    private boolean yY(int i) {
        return (this.jjj == null || this.jjj.jjy == null || this.jjj.jjy.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void yZ(int i) {
        this.jjT = true;
        if (!this.isDynamic) {
            if (!this.jjQ.isLoading()) {
                this.mPn = 1;
                this.jjP.pn = this.mPn;
                this.jjP.sortType = i;
                if (this.jjV >= 0) {
                    this.jjP.lastThreadId = this.jjV;
                }
                this.jjP.adExtParams = cEC();
                this.jjQ.loadData();
            }
        } else if (!this.jjS.isLoading()) {
            if (au.bsy().bsz()) {
                this.jjR.qType = 2;
            } else {
                this.jjR.qType = 1;
            }
            this.jjR.lastThreadId = 0L;
            this.jjS.loadData();
        }
    }

    public void za(int i) {
        this.jjT = false;
        if (!this.isDynamic) {
            if (!this.jjQ.isLoading()) {
                this.mPn++;
                this.jjP.pn = this.mPn;
                this.jjP.sortType = i;
                this.jjP.lastThreadId = -1L;
                this.jjP.adExtParams = cEC();
                this.jjQ.loadData();
            }
        } else if (!this.jjS.isLoading()) {
            if (au.bsy().bsz()) {
                this.jjR.qType = 2;
            } else {
                this.jjR.qType = 1;
            }
            this.jjS.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.jjT) {
            this.jjI = dVar;
            this.jjU.clear();
            Iterator<n> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof bz) {
                    String tid = ((bz) next).getTid();
                    if (!this.jjU.contains(tid)) {
                        this.jjU.add(tid);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cLz()) {
                if (this.funAdController != null) {
                    this.funAdController.q(this.jjI.threadList, this.jjT);
                }
            } else {
                w(dVar.gac, this.jjI.threadList);
            }
        } else {
            this.jjI.hasMore = dVar.hasMore;
            this.jjI.userMap.putAll(dVar.userMap);
            ArrayList arrayList = new ArrayList();
            Iterator<n> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof bz) {
                    String tid2 = ((bz) next2).getTid();
                    if (!this.jjU.contains(tid2)) {
                        ((bz) next2).eRc = this.jjj.isBrandForum;
                        arrayList.add(next2);
                        this.jjU.add(tid2);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cLz()) {
                if (this.funAdController != null) {
                    this.funAdController.q(arrayList, this.jjT);
                }
            } else {
                w(dVar.gac, arrayList);
            }
            this.jjI.threadList.addAll(arrayList);
        }
        this.jjj.a(this.jjI);
        return true;
    }

    public void ap(bz bzVar) {
        if (bzVar != null && this.jjI != null && this.jjI.threadList != null) {
            if (x.isEmpty(this.jjI.threadList)) {
                this.jjI.threadList.add(bzVar);
            } else {
                if (this.jjI.threadList.size() == 1 && (this.jjI.threadList.get(0) instanceof s)) {
                    this.jjI.threadList.remove(0);
                }
                this.jjI.threadList.add(0, bzVar);
            }
            this.jjj.a(this.jjI);
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
                    if (!x.isEmpty(dVar2.threadList)) {
                        n nVar = (n) x.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (nVar instanceof bz) {
                            this.jjR.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bz) nVar).getId(), 0L);
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
                    this.jjj.a(errorData);
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
                    if (!x.isEmpty(dVar2.threadList)) {
                        n nVar = (n) x.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (nVar instanceof bz) {
                            this.jjR.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bz) nVar).getId(), 0L);
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
                    this.jjj.a(errorData);
                }
            }
        }
    }

    private String cEC() {
        return AdExtParam.a.bEB().rx(this.jjT ? 0 : com.baidu.tieba.recapp.a.fL(this.jjI.threadList)).Dq(com.baidu.tieba.recapp.report.b.dCd().QM(this.jjW)).Dr(this.jjj.forumName).bEC();
    }

    private void w(List<App> list, List<n> list2) {
        dq(list2);
        com.baidu.tieba.recapp.a.b(com.baidu.tieba.recapp.a.r(list, "FRS_GENERAL_TAB"), list2, 0);
        com.baidu.tieba.recapp.a.a(list2, this.mPn, "FRS_GENERAL_TAB");
    }

    private void dq(List<n> list) {
        JSONObject f;
        if (!com.baidu.tieba.lego.card.c.a.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if ((nVar instanceof bz) && (f = com.baidu.tieba.recapp.report.b.f(((bz) nVar).bpB())) != null) {
                    arrayList.add(f);
                }
            }
            com.baidu.tieba.recapp.report.b.dCd().q(this.jjW, arrayList);
        }
    }

    public boolean hasData() {
        return (this.jjI == null || x.isEmpty(this.jjI.threadList)) ? false : true;
    }

    public d cED() {
        return this.jjI;
    }

    public void gn(long j) {
        this.jjV = j;
    }

    public boolean cEE() {
        return this.jjT;
    }

    public int getPn() {
        return this.mPn;
    }

    public void JG(String str) {
        if (this.jjI != null && !com.baidu.tieba.lego.card.c.a.isEmpty(this.jjI.threadList)) {
            com.baidu.tieba.recapp.a.i(str, this.jjI.threadList);
            this.jjj.a(this.jjI);
        }
    }
}
