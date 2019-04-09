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
    private FrsCommonTabFragment ffL;
    private boolean ffR;
    private d fge;
    private FrsCommonTabRequestData fgi;
    private FrsCommonTabNetModel fgj;
    private FrsDynamicRequestData fgk;
    private FrsDynamicModel fgl;
    private boolean fgm;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fgn = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.ffL = frsCommonTabFragment;
            if (i2 == 89) {
                this.ffR = true;
                this.fgk = new FrsDynamicRequestData();
                this.fgk.forumId = i;
                this.fgk.scrH = l.aQ(TbadkCoreApplication.getInst());
                this.fgk.scrW = l.aO(TbadkCoreApplication.getInst());
                this.fgk.scrDip = l.aR(TbadkCoreApplication.getInst());
                this.fgl = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fgk);
                this.fgl.a(this);
                this.fgl.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.ffR = false;
            this.fgi = new FrsCommonTabRequestData();
            this.fgi.fid = i;
            this.fgi.tabId = i2;
            this.fgj = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fgi);
            this.fgj.a(this);
            this.fgj.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void bfc() {
        this.fgm = true;
        if (!this.ffR) {
            if (!this.fgj.qz()) {
                this.mPn = 1;
                this.fgi.pn = this.mPn;
                this.fgj.aor();
            }
        } else if (!this.fgl.qz()) {
            if (ar.adm().ado()) {
                this.fgk.qType = 2;
            } else {
                this.fgk.qType = 1;
            }
            this.fgk.lastThreadId = 0L;
            this.fgl.aor();
        }
    }

    public void aAZ() {
        this.fgm = false;
        if (!this.ffR) {
            if (!this.fgj.qz()) {
                this.mPn++;
                this.fgi.pn = this.mPn;
                this.fgj.aor();
            }
        } else if (!this.fgl.qz()) {
            if (ar.adm().ado()) {
                this.fgk.qType = 2;
            } else {
                this.fgk.qType = 1;
            }
            this.fgl.aor();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fgm) {
            this.fge = dVar;
            this.fgn.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bg) {
                    String tid = ((bg) next).getTid();
                    if (!this.fgn.contains(tid)) {
                        this.fgn.add(tid);
                    }
                }
            }
        } else {
            this.fge.hasMore = dVar.hasMore;
            this.fge.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    String tid2 = ((bg) next2).getTid();
                    if (!this.fgn.contains(tid2)) {
                        ((bg) next2).bDJ = this.ffL.isBrandForum;
                        this.fge.threadList.add(next2);
                        this.fgn.add(tid2);
                    }
                }
            }
        }
        this.ffL.a(this.fge);
        return true;
    }

    public void ac(bg bgVar) {
        if (bgVar != null && this.fge != null && this.fge.threadList != null) {
            if (v.T(this.fge.threadList)) {
                this.fge.threadList.add(bgVar);
            } else {
                this.fge.threadList.add(0, bgVar);
            }
            this.ffL.a(this.fge);
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
                            this.fgk.lastThreadId = com.baidu.adp.lib.g.b.d(((bg) mVar).getId(), 0L);
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
                    this.ffL.a(errorData);
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
                            this.fgk.lastThreadId = com.baidu.adp.lib.g.b.d(((bg) mVar).getId(), 0L);
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
                    this.ffL.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fge == null || v.T(this.fge.threadList)) ? false : true;
    }
}
