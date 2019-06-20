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
    private FrsCommonTabFragment fvZ;
    private boolean fwf;
    private d fws;
    private FrsCommonTabRequestData fwv;
    private FrsCommonTabNetModel fww;
    private FrsDynamicRequestData fwx;
    private FrsDynamicModel fwy;
    private boolean fwz;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fwA = new HashSet<>();
    private int mPn = 1;
    private long fwB = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.fvZ = frsCommonTabFragment;
            if (i2 == 89) {
                this.fwf = true;
                this.fwx = new FrsDynamicRequestData();
                this.fwx.forumId = i;
                this.fwx.scrH = l.ah(TbadkCoreApplication.getInst());
                this.fwx.scrW = l.af(TbadkCoreApplication.getInst());
                this.fwx.scrDip = l.ai(TbadkCoreApplication.getInst());
                this.fwy = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fwx);
                this.fwy.a(this);
                this.fwy.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fwf = false;
            this.fwv = new FrsCommonTabRequestData();
            this.fwv.fid = i;
            this.fwv.tabId = i2;
            this.fww = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fwv);
            this.fww.a(this);
            this.fww.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void bmw() {
        this.fwz = true;
        if (!this.fwf) {
            if (!this.fww.pu()) {
                this.mPn = 1;
                this.fwv.pn = this.mPn;
                if (this.fwB >= 0) {
                    this.fwv.lastThreadId = this.fwB;
                }
                this.fww.atv();
            }
        } else if (!this.fwy.pu()) {
            if (ar.ail().ain()) {
                this.fwx.qType = 2;
            } else {
                this.fwx.qType = 1;
            }
            this.fwx.lastThreadId = 0L;
            this.fwy.atv();
        }
    }

    public void aHt() {
        this.fwz = false;
        if (!this.fwf) {
            if (!this.fww.pu()) {
                this.mPn++;
                this.fwv.pn = this.mPn;
                this.fwv.lastThreadId = -1L;
                this.fww.atv();
            }
        } else if (!this.fwy.pu()) {
            if (ar.ail().ain()) {
                this.fwx.qType = 2;
            } else {
                this.fwx.qType = 1;
            }
            this.fwy.atv();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fwz) {
            this.fws = dVar;
            this.fwA.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bg) {
                    String tid = ((bg) next).getTid();
                    if (!this.fwA.contains(tid)) {
                        this.fwA.add(tid);
                    }
                }
            }
        } else {
            this.fws.hasMore = dVar.hasMore;
            this.fws.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    String tid2 = ((bg) next2).getTid();
                    if (!this.fwA.contains(tid2)) {
                        ((bg) next2).bLb = this.fvZ.isBrandForum;
                        this.fws.threadList.add(next2);
                        this.fwA.add(tid2);
                    }
                }
            }
        }
        this.fvZ.a(this.fws);
        return true;
    }

    public void ac(bg bgVar) {
        if (bgVar != null && this.fws != null && this.fws.threadList != null) {
            if (v.aa(this.fws.threadList)) {
                this.fws.threadList.add(bgVar);
            } else {
                this.fws.threadList.add(0, bgVar);
            }
            this.fvZ.a(this.fws);
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
                            this.fwx.lastThreadId = com.baidu.adp.lib.g.b.c(((bg) mVar).getId(), 0L);
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
                    this.fvZ.a(errorData);
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
                            this.fwx.lastThreadId = com.baidu.adp.lib.g.b.c(((bg) mVar).getId(), 0L);
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
                    this.fvZ.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fws == null || v.aa(this.fws.threadList)) ? false : true;
    }

    public void dc(long j) {
        this.fwB = j;
    }

    public boolean bmB() {
        return this.fwz;
    }
}
