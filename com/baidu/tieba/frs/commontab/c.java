package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c implements NetModel.b {
    private FrsCommonTabFragment fBW;
    private boolean fCc;
    private d fCp;
    private FrsCommonTabRequestData fCs;
    private FrsCommonTabNetModel fCt;
    private FrsDynamicRequestData fCu;
    private FrsDynamicModel fCv;
    private boolean fCw;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fCx = new HashSet<>();
    private int mPn = 1;
    private long fCy = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.fBW = frsCommonTabFragment;
            if (i2 == 89) {
                this.fCc = true;
                this.fCu = new FrsDynamicRequestData();
                this.fCu.forumId = i;
                this.fCu.scrH = l.getEquipmentHeight(TbadkCoreApplication.getInst());
                this.fCu.scrW = l.getEquipmentWidth(TbadkCoreApplication.getInst());
                this.fCu.scrDip = l.getEquipmentDensity(TbadkCoreApplication.getInst());
                this.fCv = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fCu);
                this.fCv.a(this);
                this.fCv.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fCc = false;
            this.fCs = new FrsCommonTabRequestData();
            this.fCs.fid = i;
            this.fCs.tabId = i2;
            this.fCs.isDefaultNavTab = qR(i2) ? 1 : 0;
            this.fCt = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fCs);
            this.fCt.a(this);
            this.fCt.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    private boolean qR(int i) {
        return (this.fBW == null || this.fBW.fCh == null || this.fBW.fCh.mHeadLineDefaultNavTabId != i) ? false : true;
    }

    public void bmy() {
        this.fCw = true;
        if (!this.fCc) {
            if (!this.fCt.isLoading()) {
                this.mPn = 1;
                this.fCs.pn = this.mPn;
                if (this.fCy >= 0) {
                    this.fCs.lastThreadId = this.fCy;
                }
                this.fCt.loadData();
            }
        } else if (!this.fCv.isLoading()) {
            if (ar.amM().isFrsShowBigImage()) {
                this.fCu.qType = 2;
            } else {
                this.fCu.qType = 1;
            }
            this.fCu.lastThreadId = 0L;
            this.fCv.loadData();
        }
    }

    public void aIU() {
        this.fCw = false;
        if (!this.fCc) {
            if (!this.fCt.isLoading()) {
                this.mPn++;
                this.fCs.pn = this.mPn;
                this.fCs.lastThreadId = -1L;
                this.fCt.loadData();
            }
        } else if (!this.fCv.isLoading()) {
            if (ar.amM().isFrsShowBigImage()) {
                this.fCu.qType = 2;
            } else {
                this.fCu.qType = 1;
            }
            this.fCv.loadData();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fCw) {
            this.fCp = dVar;
            this.fCx.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bh) {
                    String tid = ((bh) next).getTid();
                    if (!this.fCx.contains(tid)) {
                        this.fCx.add(tid);
                    }
                }
            }
        } else {
            this.fCp.hasMore = dVar.hasMore;
            this.fCp.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bh) {
                    String tid2 = ((bh) next2).getTid();
                    if (!this.fCx.contains(tid2)) {
                        ((bh) next2).cdw = this.fBW.isBrandForum;
                        this.fCp.threadList.add(next2);
                        this.fCx.add(tid2);
                    }
                }
            }
        }
        this.fBW.a(this.fCp);
        return true;
    }

    public void ac(bh bhVar) {
        if (bhVar != null && this.fCp != null && this.fCp.threadList != null) {
            if (v.isEmpty(this.fCp.threadList)) {
                this.fCp.threadList.add(bhVar);
            } else {
                this.fCp.threadList.add(0, bhVar);
            }
            this.fBW.a(this.fCp);
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
                    if (!v.isEmpty(dVar2.threadList)) {
                        m mVar = (m) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bh) {
                            this.fCu.lastThreadId = com.baidu.adp.lib.g.b.toLong(((bh) mVar).getId(), 0L);
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
                    this.fBW.a(errorData);
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
                    if (!v.isEmpty(dVar2.threadList)) {
                        m mVar = (m) v.getItem(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bh) {
                            this.fCu.lastThreadId = com.baidu.adp.lib.g.b.toLong(((bh) mVar).getId(), 0L);
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
                    this.fBW.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fCp == null || v.isEmpty(this.fCp.threadList)) ? false : true;
    }

    public void cL(long j) {
        this.fCy = j;
    }

    public boolean bmD() {
        return this.fCw;
    }
}
