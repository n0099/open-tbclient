package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.frs.r;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements NetModel.b {
    private d hHL;
    private FrsCommonTabRequestData hHR;
    private FrsCommonTabNetModel hHS;
    private FrsDynamicRequestData hHT;
    private FrsDynamicModel hHU;
    private boolean hHV;
    private FrsCommonTabFragment hHq;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> hHW = new HashSet<>();
    private int mPn = 1;
    private long hHX = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.hHq = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.hHT = new FrsDynamicRequestData();
                this.hHT.forumId = i;
                this.hHT.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.hHT.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.hHT.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.hHU = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.hHT);
                this.hHU.a(this);
                this.hHU.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.hHR = new FrsCommonTabRequestData();
            this.hHR.fid = i;
            this.hHR.tabId = i2;
            this.hHR.isDefaultNavTab = uU(i2) ? 1 : 0;
            this.hHR.tabName = str;
            this.hHR.isGeneralTab = i3;
            this.hHS = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.hHR);
            this.hHS.a(this);
            this.hHS.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.hHR != null) {
            this.hHR.tabType = i;
        }
    }

    private boolean uU(int i) {
        return (this.hHq == null || this.hHq.hHD == null || this.hHq.hHD.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void uV(int i) {
        this.hHV = true;
        if (!this.isDynamic) {
            if (!this.hHS.isLoading()) {
                this.mPn = 1;
                this.hHR.pn = this.mPn;
                this.hHR.sortType = i;
                if (this.hHX >= 0) {
                    this.hHR.lastThreadId = this.hHX;
                }
                this.hHS.loadData();
            }
        } else if (!this.hHU.isLoading()) {
            if (as.aWR().aWS()) {
                this.hHT.qType = 2;
            } else {
                this.hHT.qType = 1;
            }
            this.hHT.lastThreadId = 0L;
            this.hHU.loadData();
        }
    }

    public void uW(int i) {
        this.hHV = false;
        if (!this.isDynamic) {
            if (!this.hHS.isLoading()) {
                this.mPn++;
                this.hHR.pn = this.mPn;
                this.hHR.sortType = i;
                this.hHR.lastThreadId = -1L;
                this.hHS.loadData();
            }
        } else if (!this.hHU.isLoading()) {
            if (as.aWR().aWS()) {
                this.hHT.qType = 2;
            } else {
                this.hHT.qType = 1;
            }
            this.hHU.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.hHV) {
            this.hHL = dVar;
            this.hHW.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bu) {
                    String tid = ((bu) next).getTid();
                    if (!this.hHW.contains(tid)) {
                        this.hHW.add(tid);
                    }
                }
            }
        } else {
            this.hHL.hasMore = dVar.hasMore;
            this.hHL.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bu) {
                    String tid2 = ((bu) next2).getTid();
                    if (!this.hHW.contains(tid2)) {
                        ((bu) next2).dOj = this.hHq.isBrandForum;
                        this.hHL.threadList.add(next2);
                        this.hHW.add(tid2);
                    }
                }
            }
        }
        this.hHq.a(this.hHL);
        return true;
    }

    public void ap(bu buVar) {
        if (buVar != null && this.hHL != null && this.hHL.threadList != null) {
            if (w.isEmpty(this.hHL.threadList)) {
                this.hHL.threadList.add(buVar);
            } else {
                if (this.hHL.threadList.size() == 1 && (this.hHL.threadList.get(0) instanceof r)) {
                    this.hHL.threadList.remove(0);
                }
                this.hHL.threadList.add(0, buVar);
            }
            this.hHq.a(this.hHL);
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
                    if (!w.isEmpty(dVar2.threadList)) {
                        q qVar = (q) w.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bu) {
                            this.hHT.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bu) qVar).getId(), 0L);
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
                    this.hHq.a(errorData);
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
                    if (!w.isEmpty(dVar2.threadList)) {
                        q qVar = (q) w.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bu) {
                            this.hHT.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bu) qVar).getId(), 0L);
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
                    this.hHq.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.hHL == null || w.isEmpty(this.hHL.threadList)) ? false : true;
    }

    public d cbi() {
        return this.hHL;
    }

    public void ej(long j) {
        this.hHX = j;
    }

    public boolean cbj() {
        return this.hHV;
    }
}
