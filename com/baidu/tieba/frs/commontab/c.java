package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.as;
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
    private FrsCommonTabFragment fAV;
    private boolean fBb;
    private d fBo;
    private FrsCommonTabRequestData fBr;
    private FrsCommonTabNetModel fBs;
    private FrsDynamicRequestData fBt;
    private FrsDynamicModel fBu;
    private boolean fBv;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fBw = new HashSet<>();
    private int mPn = 1;
    private long fBx = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.fAV = frsCommonTabFragment;
            if (i2 == 89) {
                this.fBb = true;
                this.fBt = new FrsDynamicRequestData();
                this.fBt.forumId = i;
                this.fBt.scrH = l.ah(TbadkCoreApplication.getInst());
                this.fBt.scrW = l.af(TbadkCoreApplication.getInst());
                this.fBt.scrDip = l.ai(TbadkCoreApplication.getInst());
                this.fBu = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fBt);
                this.fBu.a(this);
                this.fBu.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fBb = false;
            this.fBr = new FrsCommonTabRequestData();
            this.fBr.fid = i;
            this.fBr.tabId = i2;
            this.fBs = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fBr);
            this.fBs.a(this);
            this.fBs.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void box() {
        this.fBv = true;
        if (!this.fBb) {
            if (!this.fBs.pP()) {
                this.mPn = 1;
                this.fBr.pn = this.mPn;
                if (this.fBx >= 0) {
                    this.fBr.lastThreadId = this.fBx;
                }
                this.fBs.auD();
            }
        } else if (!this.fBu.pP()) {
            if (as.ajo().ajq()) {
                this.fBt.qType = 2;
            } else {
                this.fBt.qType = 1;
            }
            this.fBt.lastThreadId = 0L;
            this.fBu.auD();
        }
    }

    public void aIQ() {
        this.fBv = false;
        if (!this.fBb) {
            if (!this.fBs.pP()) {
                this.mPn++;
                this.fBr.pn = this.mPn;
                this.fBr.lastThreadId = -1L;
                this.fBs.auD();
            }
        } else if (!this.fBu.pP()) {
            if (as.ajo().ajq()) {
                this.fBt.qType = 2;
            } else {
                this.fBt.qType = 1;
            }
            this.fBu.auD();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fBv) {
            this.fBo = dVar;
            this.fBw.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bg) {
                    String tid = ((bg) next).getTid();
                    if (!this.fBw.contains(tid)) {
                        this.fBw.add(tid);
                    }
                }
            }
        } else {
            this.fBo.hasMore = dVar.hasMore;
            this.fBo.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    String tid2 = ((bg) next2).getTid();
                    if (!this.fBw.contains(tid2)) {
                        ((bg) next2).bMb = this.fAV.isBrandForum;
                        this.fBo.threadList.add(next2);
                        this.fBw.add(tid2);
                    }
                }
            }
        }
        this.fAV.a(this.fBo);
        return true;
    }

    public void ac(bg bgVar) {
        if (bgVar != null && this.fBo != null && this.fBo.threadList != null) {
            if (v.aa(this.fBo.threadList)) {
                this.fBo.threadList.add(bgVar);
            } else {
                this.fBo.threadList.add(0, bgVar);
            }
            this.fAV.a(this.fBo);
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
                    if (!v.aa(dVar2.threadList)) {
                        m mVar = (m) v.c(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bg) {
                            this.fBt.lastThreadId = com.baidu.adp.lib.g.b.c(((bg) mVar).getId(), 0L);
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
                    this.fAV.a(errorData);
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
                    if (!v.aa(dVar2.threadList)) {
                        m mVar = (m) v.c(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bg) {
                            this.fBt.lastThreadId = com.baidu.adp.lib.g.b.c(((bg) mVar).getId(), 0L);
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
                    this.fAV.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fBo == null || v.aa(this.fBo.threadList)) ? false : true;
    }

    public void dj(long j) {
        this.fBx = j;
    }

    public boolean boC() {
        return this.fBv;
    }
}
