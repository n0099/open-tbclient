package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class c implements NetModel.b {
    private d hNK;
    private FrsCommonTabRequestData hNR;
    private FrsCommonTabNetModel hNS;
    private FrsDynamicRequestData hNT;
    private FrsDynamicModel hNU;
    private boolean hNV;
    private FrsCommonTabFragment hNp;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> hNW = new HashSet<>();
    private int mPn = 1;
    private long hNX = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.hNp = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.hNT = new FrsDynamicRequestData();
                this.hNT.forumId = i;
                this.hNT.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.hNT.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.hNT.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.hNU = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.hNT);
                this.hNU.a(this);
                this.hNU.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.hNR = new FrsCommonTabRequestData();
            this.hNR.fid = i;
            this.hNR.tabId = i2;
            this.hNR.isDefaultNavTab = vm(i2) ? 1 : 0;
            this.hNR.tabName = str;
            this.hNR.isGeneralTab = i3;
            this.hNS = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.hNR);
            this.hNS.a(this);
            this.hNS.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.hNR != null) {
            this.hNR.tabType = i;
        }
    }

    private boolean vm(int i) {
        return (this.hNp == null || this.hNp.hNC == null || this.hNp.hNC.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void vn(int i) {
        this.hNV = true;
        if (!this.isDynamic) {
            if (!this.hNS.isLoading()) {
                this.mPn = 1;
                this.hNR.pn = this.mPn;
                this.hNR.sortType = i;
                if (this.hNX >= 0) {
                    this.hNR.lastThreadId = this.hNX;
                }
                this.hNS.loadData();
            }
        } else if (!this.hNU.isLoading()) {
            if (at.baS().baT()) {
                this.hNT.qType = 2;
            } else {
                this.hNT.qType = 1;
            }
            this.hNT.lastThreadId = 0L;
            this.hNU.loadData();
        }
    }

    public void vo(int i) {
        this.hNV = false;
        if (!this.isDynamic) {
            if (!this.hNS.isLoading()) {
                this.mPn++;
                this.hNR.pn = this.mPn;
                this.hNR.sortType = i;
                this.hNR.lastThreadId = -1L;
                this.hNS.loadData();
            }
        } else if (!this.hNU.isLoading()) {
            if (at.baS().baT()) {
                this.hNT.qType = 2;
            } else {
                this.hNT.qType = 1;
            }
            this.hNU.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.hNV) {
            this.hNK = dVar;
            this.hNW.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bv) {
                    String tid = ((bv) next).getTid();
                    if (!this.hNW.contains(tid)) {
                        this.hNW.add(tid);
                    }
                }
            }
        } else {
            this.hNK.hasMore = dVar.hasMore;
            this.hNK.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bv) {
                    String tid2 = ((bv) next2).getTid();
                    if (!this.hNW.contains(tid2)) {
                        ((bv) next2).dUu = this.hNp.isBrandForum;
                        this.hNK.threadList.add(next2);
                        this.hNW.add(tid2);
                    }
                }
            }
        }
        this.hNp.a(this.hNK);
        return true;
    }

    public void am(bv bvVar) {
        if (bvVar != null && this.hNK != null && this.hNK.threadList != null) {
            if (x.isEmpty(this.hNK.threadList)) {
                this.hNK.threadList.add(bvVar);
            } else {
                if (this.hNK.threadList.size() == 1 && (this.hNK.threadList.get(0) instanceof r)) {
                    this.hNK.threadList.remove(0);
                }
                this.hNK.threadList.add(0, bvVar);
            }
            this.hNp.a(this.hNK);
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
                        q qVar = (q) x.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bv) {
                            this.hNT.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bv) qVar).getId(), 0L);
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
                    this.hNp.a(errorData);
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
                        q qVar = (q) x.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (qVar instanceof bv) {
                            this.hNT.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bv) qVar).getId(), 0L);
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
                    this.hNp.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.hNK == null || x.isEmpty(this.hNK.threadList)) ? false : true;
    }

    public d ceH() {
        return this.hNK;
    }

    public void ew(long j) {
        this.hNX = j;
    }

    public boolean ceI() {
        return this.hNV;
    }
}
