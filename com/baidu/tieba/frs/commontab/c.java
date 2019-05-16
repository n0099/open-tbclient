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
    private FrsCommonTabFragment fvY;
    private boolean fwe;
    private d fwr;
    private FrsCommonTabRequestData fwu;
    private FrsCommonTabNetModel fwv;
    private FrsDynamicRequestData fww;
    private FrsDynamicModel fwx;
    private boolean fwy;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> fwz = new HashSet<>();
    private int mPn = 1;
    private long fwA = -1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.fvY = frsCommonTabFragment;
            if (i2 == 89) {
                this.fwe = true;
                this.fww = new FrsDynamicRequestData();
                this.fww.forumId = i;
                this.fww.scrH = l.ah(TbadkCoreApplication.getInst());
                this.fww.scrW = l.af(TbadkCoreApplication.getInst());
                this.fww.scrDip = l.ai(TbadkCoreApplication.getInst());
                this.fwx = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.fww);
                this.fwx.a(this);
                this.fwx.setUniqueId(frsCommonTabFragment.getUniqueId());
                return;
            }
            this.fwe = false;
            this.fwu = new FrsCommonTabRequestData();
            this.fwu.fid = i;
            this.fwu.tabId = i2;
            this.fwv = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.fwu);
            this.fwv.a(this);
            this.fwv.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void bmt() {
        this.fwy = true;
        if (!this.fwe) {
            if (!this.fwv.pu()) {
                this.mPn = 1;
                this.fwu.pn = this.mPn;
                if (this.fwA >= 0) {
                    this.fwu.lastThreadId = this.fwA;
                }
                this.fwv.atv();
            }
        } else if (!this.fwx.pu()) {
            if (ar.ail().ain()) {
                this.fww.qType = 2;
            } else {
                this.fww.qType = 1;
            }
            this.fww.lastThreadId = 0L;
            this.fwx.atv();
        }
    }

    public void aHq() {
        this.fwy = false;
        if (!this.fwe) {
            if (!this.fwv.pu()) {
                this.mPn++;
                this.fwu.pn = this.mPn;
                this.fwu.lastThreadId = -1L;
                this.fwv.atv();
            }
        } else if (!this.fwx.pu()) {
            if (ar.ail().ain()) {
                this.fww.qType = 2;
            } else {
                this.fww.qType = 1;
            }
            this.fwx.atv();
        }
    }

    private boolean b(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.fwy) {
            this.fwr = dVar;
            this.fwz.clear();
            Iterator<m> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next instanceof bg) {
                    String tid = ((bg) next).getTid();
                    if (!this.fwz.contains(tid)) {
                        this.fwz.add(tid);
                    }
                }
            }
        } else {
            this.fwr.hasMore = dVar.hasMore;
            this.fwr.userMap.putAll(dVar.userMap);
            Iterator<m> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                m next2 = it2.next();
                if (next2 instanceof bg) {
                    String tid2 = ((bg) next2).getTid();
                    if (!this.fwz.contains(tid2)) {
                        ((bg) next2).bLa = this.fvY.isBrandForum;
                        this.fwr.threadList.add(next2);
                        this.fwz.add(tid2);
                    }
                }
            }
        }
        this.fvY.a(this.fwr);
        return true;
    }

    public void ac(bg bgVar) {
        if (bgVar != null && this.fwr != null && this.fwr.threadList != null) {
            if (v.aa(this.fwr.threadList)) {
                this.fwr.threadList.add(bgVar);
            } else {
                this.fwr.threadList.add(0, bgVar);
            }
            this.fvY.a(this.fwr);
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
                            this.fww.lastThreadId = com.baidu.adp.lib.g.b.c(((bg) mVar).getId(), 0L);
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
                    this.fvY.a(errorData);
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
                            this.fww.lastThreadId = com.baidu.adp.lib.g.b.c(((bg) mVar).getId(), 0L);
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
                    this.fvY.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.fwr == null || v.aa(this.fwr.threadList)) ? false : true;
    }

    public void dc(long j) {
        this.fwA = j;
    }

    public boolean bmy() {
        return this.fwy;
    }
}
