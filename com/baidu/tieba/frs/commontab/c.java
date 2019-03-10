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
    private FrsCommonTabFragment ffZ;
    private boolean fgA;
    private boolean fgf;
    private d fgs;
    private FrsCommonTabRequestData fgw;
    private FrsCommonTabNetModel fgx;
    private FrsDynamicRequestData fgy;
    private FrsDynamicModel fgz;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fgB = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.ffZ = frsCommonTabFragment;
            if (i2 == 89) {
                this.fgf = true;
                this.fgy = new FrsDynamicRequestData();
                this.fgy.forumId = i;
                this.fgy.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.fgy.scrW = l.aO(TbadkCoreApplication.getInst());
                this.fgy.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.fgz = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fgy);
                this.fgz.a(this);
                this.fgz.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fgf = false;
            this.fgw = new FrsCommonTabRequestData();
            this.fgw.fid = i;
            this.fgw.tabId = i2;
            this.fgx = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fgw);
            this.fgx.a(this);
            this.fgx.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void bff() {
        this.fgA = true;
        if (!this.fgf) {
            if (!this.fgx.qz()) {
                this.mPn = 1;
                this.fgw.pn = this.mPn;
                this.fgx.aov();
            }
        } else if (!this.fgz.qz()) {
            if (ar.adp().adr()) {
                this.fgy.qType = 2;
            } else {
                this.fgy.qType = 1;
            }
            this.fgy.lastThreadId = 0L;
            this.fgz.aov();
        }
    }

    public void aBd() {
        this.fgA = false;
        if (!this.fgf) {
            if (!this.fgx.qz()) {
                this.mPn++;
                this.fgw.pn = this.mPn;
                this.fgx.aov();
            }
        } else if (!this.fgz.qz()) {
            if (ar.adp().adr()) {
                this.fgy.qType = 2;
            } else {
                this.fgy.qType = 1;
            }
            this.fgz.aov();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fgA) {
            this.fgs = dVar;
            this.fgB.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bg) {
                    String tid = ((bg) next).getTid();
                    if (!this.fgB.contains(tid)) {
                        this.fgB.add(tid);
                    }
                }
            }
        } else {
            this.fgs.hasMore = dVar.hasMore;
            this.fgs.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    String tid2 = ((bg) next2).getTid();
                    if (!this.fgB.contains(tid2)) {
                        ((bg) next2).bDD = this.ffZ.isBrandForum;
                        this.fgs.threadList.add(next2);
                        this.fgB.add(tid2);
                    }
                }
            }
        }
        this.ffZ.a(this.fgs);
        return true;
    }

    public void ad(bg bgVar) {
        if (bgVar != null && this.fgs != null && this.fgs.threadList != null) {
            if (v.T(this.fgs.threadList)) {
                this.fgs.threadList.add(bgVar);
            } else {
                this.fgs.threadList.add(0, bgVar);
            }
            this.ffZ.a(this.fgs);
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
                            this.fgy.lastThreadId = com.baidu.adp.lib.g.b.d(((bg) mVar).getId(), 0L);
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
                    this.ffZ.a(errorData);
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
                            this.fgy.lastThreadId = com.baidu.adp.lib.g.b.d(((bg) mVar).getId(), 0L);
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
                    this.ffZ.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fgs == null || v.T(this.fgs.threadList)) ? false : true;
    }
}
