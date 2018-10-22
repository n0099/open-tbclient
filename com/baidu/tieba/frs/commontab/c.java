package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c implements NetModel.b<FrsCommonTabRequestData, d> {
    private FrsCommonTabFragment dGO;
    private d dHb;
    private FrsCommonTabRequestData dHc;
    private FrsCommonTabNetModel dHd;
    private boolean dHe;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> dHf = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.dGO = frsCommonTabFragment;
            this.dHc = new FrsCommonTabRequestData();
            this.dHc.fid = i;
            this.dHc.tabId = i2;
            this.dHd = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.dHc);
            this.dHd.a(this);
            this.dHd.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void aCc() {
        if (!this.dHd.DU()) {
            this.mPn = 1;
            this.dHe = true;
            this.dHc.pn = this.mPn;
            this.dHd.Nj();
        }
    }

    public void YL() {
        if (!this.dHd.DU()) {
            this.mPn++;
            this.dHe = false;
            this.dHc.pn = this.mPn;
            this.dHd.Nj();
        }
    }

    private boolean a(FrsCommonTabRequestData frsCommonTabRequestData, d dVar) {
        if (frsCommonTabRequestData == null || dVar == null) {
            return false;
        }
        if (this.dHe) {
            this.dHb = dVar;
            this.dHf.clear();
            Iterator<h> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof bb) {
                    String tid = ((bb) next).getTid();
                    if (!this.dHf.contains(tid)) {
                        this.dHf.add(tid);
                    }
                }
            }
        } else {
            this.dHb.hasMore = dVar.hasMore;
            this.dHb.userMap.putAll(dVar.userMap);
            Iterator<h> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    String tid2 = ((bb) next2).getTid();
                    if (!this.dHf.contains(tid2)) {
                        ((bb) next2).arq = this.dGO.isBrandForum;
                        this.dHb.threadList.add(next2);
                        this.dHf.add(tid2);
                    }
                }
            }
        }
        this.dGO.a(this.dHb);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<d> mvcHttpResponsedMessage, MvcHttpMessage<FrsCommonTabRequestData, d> mvcHttpMessage, MvcNetMessage<FrsCommonTabRequestData, d> mvcNetMessage) {
        d dVar;
        if (mvcHttpResponsedMessage != null) {
            if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
                dVar = null;
            } else {
                dVar = mvcHttpResponsedMessage.getData();
                r1 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r1 = mvcNetMessage.getRequestData();
                }
            }
            if (r1 == null || dVar == null || !a(r1, dVar)) {
                if (mvcHttpResponsedMessage != null) {
                    this.mErrorCode = mvcHttpResponsedMessage.getError();
                    this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.dGO.a(errorData);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<d, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsCommonTabRequestData, d> mvcSocketMessage, MvcNetMessage<FrsCommonTabRequestData, d> mvcNetMessage) {
        d dVar;
        if (mvcSocketResponsedMessage != null) {
            if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
                dVar = null;
            } else {
                dVar = mvcSocketResponsedMessage.getData();
                r1 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r1 = mvcNetMessage.getRequestData();
                }
            }
            if (r1 == null || dVar == null || !a(r1, dVar)) {
                if (mvcSocketResponsedMessage != null) {
                    this.mErrorCode = mvcSocketResponsedMessage.getError();
                    this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                if (this.mErrorCode != 0) {
                    this.dGO.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.dHb == null || v.J(this.dHb.threadList)) ? false : true;
    }
}
