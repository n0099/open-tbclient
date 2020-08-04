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
    private d hNM;
    private FrsCommonTabRequestData hNT;
    private FrsCommonTabNetModel hNU;
    private FrsDynamicRequestData hNV;
    private FrsDynamicModel hNW;
    private boolean hNX;
    private FrsCommonTabFragment hNr;
    private boolean isDynamic;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> hNY = new HashSet<>();
    private int mPn = 1;
    private long hNZ = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2, String str, int i3) {
        if (frsCommonTabFragment != null) {
            this.hNr = frsCommonTabFragment;
            if (i2 == 89) {
                this.isDynamic = true;
                this.hNV = new FrsDynamicRequestData();
                this.hNV.forumId = i;
                this.hNV.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.hNV.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.hNV.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.hNW = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.hNV);
                this.hNW.a(this);
                this.hNW.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.isDynamic = false;
            this.hNT = new FrsCommonTabRequestData();
            this.hNT.fid = i;
            this.hNT.tabId = i2;
            this.hNT.isDefaultNavTab = vm(i2) ? 1 : 0;
            this.hNT.tabName = str;
            this.hNT.isGeneralTab = i3;
            this.hNU = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.hNT);
            this.hNU.a(this);
            this.hNU.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void setTabType(int i) {
        if (this.hNT != null) {
            this.hNT.tabType = i;
        }
    }

    private boolean vm(int i) {
        return (this.hNr == null || this.hNr.hNE == null || this.hNr.hNE.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void vn(int i) {
        this.hNX = true;
        if (!this.isDynamic) {
            if (!this.hNU.isLoading()) {
                this.mPn = 1;
                this.hNT.pn = this.mPn;
                this.hNT.sortType = i;
                if (this.hNZ >= 0) {
                    this.hNT.lastThreadId = this.hNZ;
                }
                this.hNU.loadData();
            }
        } else if (!this.hNW.isLoading()) {
            if (at.baS().baT()) {
                this.hNV.qType = 2;
            } else {
                this.hNV.qType = 1;
            }
            this.hNV.lastThreadId = 0L;
            this.hNW.loadData();
        }
    }

    public void vo(int i) {
        this.hNX = false;
        if (!this.isDynamic) {
            if (!this.hNU.isLoading()) {
                this.mPn++;
                this.hNT.pn = this.mPn;
                this.hNT.sortType = i;
                this.hNT.lastThreadId = -1L;
                this.hNU.loadData();
            }
        } else if (!this.hNW.isLoading()) {
            if (at.baS().baT()) {
                this.hNV.qType = 2;
            } else {
                this.hNV.qType = 1;
            }
            this.hNW.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.hNX) {
            this.hNM = dVar;
            this.hNY.clear();
            Iterator<q> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (next instanceof bv) {
                    String tid = ((bv) next).getTid();
                    if (!this.hNY.contains(tid)) {
                        this.hNY.add(tid);
                    }
                }
            }
        } else {
            this.hNM.hasMore = dVar.hasMore;
            this.hNM.userMap.putAll(dVar.userMap);
            Iterator<q> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                q next2 = it2.next();
                if (next2 instanceof bv) {
                    String tid2 = ((bv) next2).getTid();
                    if (!this.hNY.contains(tid2)) {
                        ((bv) next2).dUu = this.hNr.isBrandForum;
                        this.hNM.threadList.add(next2);
                        this.hNY.add(tid2);
                    }
                }
            }
        }
        this.hNr.a(this.hNM);
        return true;
    }

    public void am(bv bvVar) {
        if (bvVar != null && this.hNM != null && this.hNM.threadList != null) {
            if (x.isEmpty(this.hNM.threadList)) {
                this.hNM.threadList.add(bvVar);
            } else {
                if (this.hNM.threadList.size() == 1 && (this.hNM.threadList.get(0) instanceof r)) {
                    this.hNM.threadList.remove(0);
                }
                this.hNM.threadList.add(0, bvVar);
            }
            this.hNr.a(this.hNM);
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
                            this.hNV.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bv) qVar).getId(), 0L);
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
                    this.hNr.a(errorData);
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
                            this.hNV.lastThreadId = com.baidu.adp.lib.f.b.toLong(((bv) qVar).getId(), 0L);
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
                    this.hNr.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.hNM == null || x.isEmpty(this.hNM.threadList)) ? false : true;
    }

    public d ceH() {
        return this.hNM;
    }

    public void ew(long j) {
        this.hNZ = j;
    }

    public boolean ceI() {
        return this.hNX;
    }
}
