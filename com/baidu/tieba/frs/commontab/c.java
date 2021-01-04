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
    private FrsCommonTabFragment jnQ;
    private boolean joA;
    private String joD;
    private d jop;
    private FrsCommonTabRequestData jow;
    private FrsCommonTabNetModel jox;
    private FrsDynamicRequestData joy;
    private FrsDynamicModel joz;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> joB = new HashSet<>();
    private int mPn = 1;
    private long joC = -1;

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.funAdController = aVar;
    }

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.jnQ = frsCommonTabFragment;
            this.joD = "FRS_GENERAL_TAB" + i2;
            if (i2 == 89) {
                this.isDynamic = true;
                this.joy = new FrsDynamicRequestData();
                this.joy.forumId = i;
                this.joy.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.joy.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.joy.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.joz = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.joy);
                this.joz.a(this);
                this.joz.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.jow = new FrsCommonTabRequestData();
            this.jow.fid = i;
            this.jow.tabId = i2;
            this.jow.isDefaultNavTab = AE(i2) ? 1 : 0;
            this.jow.tabName = str;
            this.jow.isGeneralTab = i3;
            this.jox = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.jow);
            this.jox.a(this);
            this.jox.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.jow != null) {
            this.jow.tabType = i;
        }
    }

    private boolean AE(int i) {
        return (this.jnQ == null || this.jnQ.jof == null || this.jnQ.jof.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void AF(int i) {
        this.joA = true;
        if (!this.isDynamic) {
            if (!this.jox.isLoading()) {
                this.mPn = 1;
                this.jow.pn = this.mPn;
                this.jow.sortType = i;
                if (this.joC >= 0) {
                    this.jow.lastThreadId = this.joC;
                }
                this.jow.adExtParams = cIt();
                this.jox.loadData();
            }
        } else if (!this.joz.isLoading()) {
            if (au.bwr().bws()) {
                this.joy.qType = 2;
            } else {
                this.joy.qType = 1;
            }
            this.joy.lastThreadId = 0L;
            this.joz.loadData();
        }
    }

    public void AG(int i) {
        this.joA = false;
        if (!this.isDynamic) {
            if (!this.jox.isLoading()) {
                this.mPn++;
                this.jow.pn = this.mPn;
                this.jow.sortType = i;
                this.jow.lastThreadId = -1L;
                this.jow.adExtParams = cIt();
                this.jox.loadData();
            }
        } else if (!this.joz.isLoading()) {
            if (au.bwr().bws()) {
                this.joy.qType = 2;
            } else {
                this.joy.qType = 1;
            }
            this.joz.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.joA) {
            this.jop = dVar;
            this.joB.clear();
            Iterator<n> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof bz) {
                    String tid = ((bz) next).getTid();
                    if (!this.joB.contains(tid)) {
                        this.joB.add(tid);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cPq()) {
                if (this.funAdController != null) {
                    this.funAdController.q(this.jop.threadList, this.joA);
                }
            } else {
                w(dVar.geM, this.jop.threadList);
            }
        } else {
            this.jop.hasMore = dVar.hasMore;
            this.jop.userMap.putAll(dVar.userMap);
            ArrayList arrayList = new ArrayList();
            Iterator<n> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 instanceof bz) {
                    String tid2 = ((bz) next2).getTid();
                    if (!this.joB.contains(tid2)) {
                        ((bz) next2).eVN = this.jnQ.isBrandForum;
                        arrayList.add(next2);
                        this.joB.add(tid2);
                    }
                }
            }
            if (com.baidu.tieba.funad.a.cPq()) {
                if (this.funAdController != null) {
                    this.funAdController.q(arrayList, this.joA);
                }
            } else {
                w(dVar.geM, arrayList);
            }
            this.jop.threadList.addAll(arrayList);
        }
        this.jnQ.a(this.jop);
        return true;
    }

    public void ap(bz bzVar) {
        if (bzVar != null && this.jop != null && this.jop.threadList != null) {
            if (x.isEmpty(this.jop.threadList)) {
                this.jop.threadList.add(bzVar);
            } else {
                if (this.jop.threadList.size() == 1 && (this.jop.threadList.get(0) instanceof s)) {
                    this.jop.threadList.remove(0);
                }
                this.jop.threadList.add(0, bzVar);
            }
            this.jnQ.a(this.jop);
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
                            this.joy.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bz) nVar).getId(), 0L);
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
                    this.jnQ.a(errorData);
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
                            this.joy.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bz) nVar).getId(), 0L);
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
                    this.jnQ.a(errorData);
                }
            }
        }
    }

    private String cIt() {
        return AdExtParam.a.bIs().td(this.joA ? 0 : com.baidu.tieba.recapp.a.fL(this.jop.threadList)).EC(com.baidu.tieba.recapp.report.b.dFU().RU(this.joD)).ED(this.jnQ.forumName).bIt();
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
                if ((nVar instanceof bz) && (f = com.baidu.tieba.recapp.report.b.f(((bz) nVar).btu())) != null) {
                    arrayList.add(f);
                }
            }
            com.baidu.tieba.recapp.report.b.dFU().q(this.joD, arrayList);
        }
    }

    public boolean hasData() {
        return (this.jop == null || x.isEmpty(this.jop.threadList)) ? false : true;
    }

    public d cIu() {
        return this.jop;
    }

    public void gn(long j) {
        this.joC = j;
    }

    public boolean cIv() {
        return this.joA;
    }

    public int getPn() {
        return this.mPn;
    }

    public void KR(String str) {
        if (this.jop != null && !com.baidu.tieba.lego.card.c.a.isEmpty(this.jop.threadList)) {
            com.baidu.tieba.recapp.a.i(str, this.jop.threadList);
            this.jnQ.a(this.jop);
        }
    }
}
