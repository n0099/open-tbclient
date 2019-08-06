package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bh;
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
    private FrsCommonTabFragment fBJ;
    private boolean fBP;
    private d fCc;
    private FrsCommonTabRequestData fCf;
    private FrsCommonTabNetModel fCg;
    private FrsDynamicRequestData fCh;
    private FrsDynamicModel fCi;
    private boolean fCj;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fCk = new HashSet<>();
    private int mPn = 1;
    private long fCl = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.fBJ = frsCommonTabFragment;
            if (i2 == 89) {
                this.fBP = true;
                this.fCh = new FrsDynamicRequestData();
                this.fCh.forumId = i;
                this.fCh.scrH = l.ah(TbadkCoreApplication.getInst());
                this.fCh.scrW = l.af(TbadkCoreApplication.getInst());
                this.fCh.scrDip = l.ai(TbadkCoreApplication.getInst());
                this.fCi = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fCh);
                this.fCi.a(this);
                this.fCi.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fBP = false;
            this.fCf = new FrsCommonTabRequestData();
            this.fCf.fid = i;
            this.fCf.tabId = i2;
            this.fCg = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fCf);
            this.fCg.a(this);
            this.fCg.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void boK() {
        this.fCj = true;
        if (!this.fBP) {
            if (!this.fCg.pP()) {
                this.mPn = 1;
                this.fCf.pn = this.mPn;
                if (this.fCl >= 0) {
                    this.fCf.lastThreadId = this.fCl;
                }
                this.fCg.auF();
            }
        } else if (!this.fCi.pP()) {
            if (as.ajq().ajs()) {
                this.fCh.qType = 2;
            } else {
                this.fCh.qType = 1;
            }
            this.fCh.lastThreadId = 0L;
            this.fCi.auF();
        }
    }

    public void aIS() {
        this.fCj = false;
        if (!this.fBP) {
            if (!this.fCg.pP()) {
                this.mPn++;
                this.fCf.pn = this.mPn;
                this.fCf.lastThreadId = -1L;
                this.fCg.auF();
            }
        } else if (!this.fCi.pP()) {
            if (as.ajq().ajs()) {
                this.fCh.qType = 2;
            } else {
                this.fCh.qType = 1;
            }
            this.fCi.auF();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fCj) {
            this.fCc = dVar;
            this.fCk.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bh) {
                    String tid = ((bh) next).getTid();
                    if (!this.fCk.contains(tid)) {
                        this.fCk.add(tid);
                    }
                }
            }
        } else {
            this.fCc.hasMore = dVar.hasMore;
            this.fCc.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bh) {
                    String tid2 = ((bh) next2).getTid();
                    if (!this.fCk.contains(tid2)) {
                        ((bh) next2).bMg = this.fBJ.isBrandForum;
                        this.fCc.threadList.add(next2);
                        this.fCk.add(tid2);
                    }
                }
            }
        }
        this.fBJ.a(this.fCc);
        return true;
    }

    public void ad(bh bhVar) {
        if (bhVar != null && this.fCc != null && this.fCc.threadList != null) {
            if (v.aa(this.fCc.threadList)) {
                this.fCc.threadList.add(bhVar);
            } else {
                this.fCc.threadList.add(0, bhVar);
            }
            this.fBJ.a(this.fCc);
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
                        if (mVar instanceof bh) {
                            this.fCh.lastThreadId = com.baidu.adp.lib.g.b.c(((bh) mVar).getId(), 0L);
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
                    this.fBJ.a(errorData);
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
                        if (mVar instanceof bh) {
                            this.fCh.lastThreadId = com.baidu.adp.lib.g.b.c(((bh) mVar).getId(), 0L);
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
                    this.fBJ.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fCc == null || v.aa(this.fCc.threadList)) ? false : true;
    }

    public void dj(long j) {
        this.fCl = j;
    }

    public boolean boP() {
        return this.fCj;
    }
}
