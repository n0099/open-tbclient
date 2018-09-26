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
/* loaded from: classes2.dex */
public class c implements NetModel.b<FrsCommonTabRequestData, d> {
    private FrsCommonTabFragment dyO;
    private d dzb;
    private FrsCommonTabRequestData dzc;
    private FrsCommonTabNetModel dzd;
    private boolean dze;
    private int mErrorCode;
    private String mErrorString;
    private HashSet<String> dzf = new HashSet<>();
    private int mPn = 1;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i, int i2) {
        if (frsCommonTabFragment != null) {
            this.dyO = frsCommonTabFragment;
            this.dzc = new FrsCommonTabRequestData();
            this.dzc.fid = i;
            this.dzc.tabId = i2;
            this.dzd = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.dzc);
            this.dzd.a(this);
            this.dzd.setUniqueId(frsCommonTabFragment.getUniqueId());
        }
    }

    public void ayI() {
        if (!this.dzd.BO()) {
            this.mPn = 1;
            this.dze = true;
            this.dzc.pn = this.mPn;
            this.dzd.Ll();
        }
    }

    public void Vd() {
        if (!this.dzd.BO()) {
            this.mPn++;
            this.dze = false;
            this.dzc.pn = this.mPn;
            this.dzd.Ll();
        }
    }

    private boolean a(FrsCommonTabRequestData frsCommonTabRequestData, d dVar) {
        if (frsCommonTabRequestData == null || dVar == null) {
            return false;
        }
        if (this.dze) {
            this.dzb = dVar;
            this.dzf.clear();
            Iterator<h> it = dVar.threadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next instanceof bb) {
                    String tid = ((bb) next).getTid();
                    if (!this.dzf.contains(tid)) {
                        this.dzf.add(tid);
                    }
                }
            }
        } else {
            this.dzb.hasMore = dVar.hasMore;
            this.dzb.userMap.putAll(dVar.userMap);
            Iterator<h> it2 = dVar.threadList.iterator();
            while (it2.hasNext()) {
                h next2 = it2.next();
                if (next2 instanceof bb) {
                    String tid2 = ((bb) next2).getTid();
                    if (!this.dzf.contains(tid2)) {
                        ((bb) next2).amv = this.dyO.isBrandForum;
                        this.dzb.threadList.add(next2);
                        this.dzf.add(tid2);
                    }
                }
            }
        }
        this.dyO.a(this.dzb);
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
                    this.dyO.a(errorData);
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
                    this.dyO.a(errorData);
                }
            }
        }
    }

    public boolean hasData() {
        return (this.dzb == null || v.z(this.dzb.threadList)) ? false : true;
    }
}
