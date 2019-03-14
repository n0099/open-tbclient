package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bg;
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
    private FrsCommonTabFragment ffY;
    private boolean fge;
    private d fgr;
    private FrsCommonTabRequestData fgv;
    private FrsCommonTabNetModel fgw;
    private FrsDynamicRequestData fgx;
    private FrsDynamicModel fgy;
    private boolean fgz;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fgA = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.ffY = frsCommonTabFragment;
            if (i2 == 89) {
                this.fge = true;
                this.fgx = new FrsDynamicRequestData();
                this.fgx.forumId = i;
                this.fgx.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.fgx.scrW = l.aO(TbadkCoreApplication.getInst());
                this.fgx.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.fgy = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fgx);
                this.fgy.a(this);
                this.fgy.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fge = false;
            this.fgv = new FrsCommonTabRequestData();
            this.fgv.fid = i;
            this.fgv.tabId = i2;
            this.fgw = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fgv);
            this.fgw.a(this);
            this.fgw.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void bfe() {
        this.fgz = true;
        if (!this.fge) {
            if (!this.fgw.qz()) {
                this.mPn = 1;
                this.fgv.pn = this.mPn;
                this.fgw.aou();
            }
        } else if (!this.fgy.qz()) {
            if (ar.adp().adr()) {
                this.fgx.qType = 2;
            } else {
                this.fgx.qType = 1;
            }
            this.fgx.lastThreadId = 0L;
            this.fgy.aou();
        }
    }

    public void aBc() {
        this.fgz = false;
        if (!this.fge) {
            if (!this.fgw.qz()) {
                this.mPn++;
                this.fgv.pn = this.mPn;
                this.fgw.aou();
            }
        } else if (!this.fgy.qz()) {
            if (ar.adp().adr()) {
                this.fgx.qType = 2;
            } else {
                this.fgx.qType = 1;
            }
            this.fgy.aou();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fgz) {
            this.fgr = dVar;
            this.fgA.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bg) {
                    String tid = ((bg) next).getTid();
                    if (!this.fgA.contains(tid)) {
                        this.fgA.add(tid);
                    }
                }
            }
        } else {
            this.fgr.hasMore = dVar.hasMore;
            this.fgr.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    String tid2 = ((bg) next2).getTid();
                    if (!this.fgA.contains(tid2)) {
                        ((bg) next2).bDF = this.ffY.isBrandForum;
                        this.fgr.threadList.add(next2);
                        this.fgA.add(tid2);
                    }
                }
            }
        }
        this.ffY.a(this.fgr);
        return true;
    }

    public void ad(bg bgVar) {
        if (bgVar != null && this.fgr != null && this.fgr.threadList != null) {
            if (v.T(this.fgr.threadList)) {
                this.fgr.threadList.add(bgVar);
            } else {
                this.fgr.threadList.add(0, bgVar);
            }
            this.ffY.a(this.fgr);
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
                    if (!v.T(dVar2.threadList)) {
                        m mVar = (m) v.c(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bg) {
                            this.fgx.lastThreadId = com.baidu.adp.lib.g.b.d(((bg) mVar).getId(), 0L);
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
                    this.ffY.a(errorData);
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
                    if (!v.T(dVar2.threadList)) {
                        m mVar = (m) v.c(dVar2.threadList, dVar2.threadList.size() - 1);
                        if (mVar instanceof bg) {
                            this.fgx.lastThreadId = com.baidu.adp.lib.g.b.d(((bg) mVar).getId(), 0L);
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
                    this.ffY.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fgr == null || v.T(this.fgr.threadList)) ? false : true;
    }
}
