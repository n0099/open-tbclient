package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.frs.s;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class c implements NetModel.b {
    private FrsCommonTabFragment iPW;
    private FrsDynamicRequestData iQA;
    private FrsDynamicModel iQB;
    private boolean iQC;
    private d iQr;
    private FrsCommonTabRequestData iQy;
    private FrsCommonTabNetModel iQz;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> iQD = new HashSet<>();
    private int mPn = 1;
    private long iQE = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.iPW = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.iQA = new FrsDynamicRequestData();
                this.iQA.forumId = i;
                this.iQA.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.iQA.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.iQA.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.iQB = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.iQA);
                this.iQB.a(this);
                this.iQB.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.iQy = new FrsCommonTabRequestData();
            this.iQy.fid = i;
            this.iQy.tabId = i2;
            this.iQy.isDefaultNavTab = zp(i2) ? 1 : 0;
            this.iQy.tabName = str;
            this.iQy.isGeneralTab = i3;
            this.iQz = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.iQy);
            this.iQz.a(this);
            this.iQz.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.iQy != null) {
            this.iQy.tabType = i;
        }
    }

    private boolean zp(int i) {
        return (this.iPW == null || this.iPW.iQj == null || this.iPW.iQj.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void zq(int i) {
        this.iQC = true;
        if (!this.isDynamic) {
            if (!this.iQz.isLoading()) {
                this.mPn = 1;
                this.iQy.pn = this.mPn;
                this.iQy.sortType = i;
                if (this.iQE >= 0) {
                    this.iQy.lastThreadId = this.iQE;
                }
                this.iQz.loadData();
            }
        } else if (!this.iQB.isLoading()) {
            if (au.bro().brp()) {
                this.iQA.qType = 2;
            } else {
                this.iQA.qType = 1;
            }
            this.iQA.lastThreadId = 0L;
            this.iQB.loadData();
        }
    }

    public void zr(int i) {
        this.iQC = false;
        if (!this.isDynamic) {
            if (!this.iQz.isLoading()) {
                this.mPn++;
                this.iQy.pn = this.mPn;
                this.iQy.sortType = i;
                this.iQy.lastThreadId = -1L;
                this.iQz.loadData();
            }
        } else if (!this.iQB.isLoading()) {
            if (au.bro().brp()) {
                this.iQA.qType = 2;
            } else {
                this.iQA.qType = 1;
            }
            this.iQB.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.iQC) {
            this.iQr = dVar;
            this.iQD.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bw) {
                    String tid = ((bw) next).getTid();
                    if (!this.iQD.contains(tid)) {
                        this.iQD.add(tid);
                    }
                }
            }
        } else {
            this.iQr.hasMore = dVar.hasMore;
            this.iQr.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bw) {
                    String tid2 = ((bw) next2).getTid();
                    if (!this.iQD.contains(tid2)) {
                        ((bw) next2).eGz = this.iPW.isBrandForum;
                        this.iQr.threadList.add(next2);
                        this.iQD.add(tid2);
                    }
                }
            }
        }
        this.iPW.a(this.iQr);
        return true;
    }

    public void an(bw bwVar) {
        if (bwVar != null && this.iQr != null && this.iQr.threadList != null) {
            if (y.isEmpty(this.iQr.threadList)) {
                this.iQr.threadList.add(bwVar);
            } else {
                if (this.iQr.threadList.size() == 1 && (this.iQr.threadList.get(0) instanceof s)) {
                    this.iQr.threadList.remove(0);
                }
                this.iQr.threadList.add(0, bwVar);
            }
            this.iPW.a(this.iQr);
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
                        q qVar = (q) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bw) {
                            this.iQA.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.iPW.a(errorData);
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
                        q qVar = (q) y.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bw) {
                            this.iQA.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bw) qVar).getId(), 0L);
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
                    this.iPW.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.iQr == null || y.isEmpty(this.iQr.threadList)) ? false : true;
    }

    public d cBE() {
        return this.iQr;
    }

    public void fG(long j) {
        this.iQE = j;
    }

    public boolean cBF() {
        return this.iQC;
    }
}
