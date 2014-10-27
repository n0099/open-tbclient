package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.b.g;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.core.MvcActivity;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* loaded from: classes.dex */
public abstract class a<T extends g, R extends i> extends com.baidu.tbadk.mvc.core.a implements com.baidu.tbadk.mvc.c.a, com.baidu.tbadk.mvc.model.i<T, R> {
    protected abstract boolean tx();

    public a(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
    }

    protected boolean a(T t, R r) {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean ti() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.tp() == 16777216) {
            if (tx()) {
                de(33554435);
                return true;
            }
            de(33554436);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.j
    public void a(MvcHttpResponsedMessage<R> mvcHttpResponsedMessage, MvcHttpMessage<T, R> mvcHttpMessage, MvcNetMessage<T, R> mvcNetMessage) {
        T t;
        if (mvcHttpResponsedMessage != null) {
            R data = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                t = mvcHttpMessage.getRequestData();
                r0 = (T) data;
            } else {
                t = r0;
                r0 = (T) data;
            }
        } else {
            t = null;
        }
        if (t == null || r0 == null || !a(t, r0)) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.a(errorData));
        }
    }

    @Override // com.baidu.tbadk.mvc.model.k
    public void a(MvcSocketResponsedMessage<R, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, R> mvcSocketMessage, MvcNetMessage<T, R> mvcNetMessage) {
        T t;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            t = null;
        } else {
            R data = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                t = mvcSocketMessage.getRequestData();
                r0 = (T) data;
            } else {
                t = r0;
                r0 = (T) data;
            }
        }
        if (t == null || r0 == null || !a(t, r0)) {
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.a(errorData));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.e.c cVar) {
        dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.c(cVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.b(aVar));
    }
}
