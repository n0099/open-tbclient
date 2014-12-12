package com.baidu.tbadk.mvc.d;

import android.os.Bundle;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.core.e;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.q;
/* loaded from: classes.dex */
public abstract class a<T extends h, R extends j> extends com.baidu.tbadk.mvc.core.b implements q<T, R> {
    protected abstract boolean kK();

    public a(e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        wx().addEventDelegate(this);
    }

    @Override // com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean wy() {
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xc() == 16777216) {
            if (kK()) {
                dz(33554435);
                return true;
            }
            dz(33554436);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<R> mvcHttpResponsedMessage, MvcHttpMessage<T, R> mvcHttpMessage, MvcNetMessage<T, R> mvcNetMessage) {
        T t;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            t = null;
        } else {
            R data = mvcHttpResponsedMessage.getData();
            r0 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                t = mvcNetMessage.getRequestData();
                r0 = (T) data;
            } else {
                t = r0;
                r0 = (T) data;
            }
        }
        if (t == null || r0 == null || !a(t, r0)) {
            if (mvcHttpResponsedMessage != null) {
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.a(errorData));
        }
    }

    @Override // com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<R, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, R> mvcSocketMessage, MvcNetMessage<T, R> mvcNetMessage) {
        T t;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            t = null;
        } else {
            R data = mvcSocketResponsedMessage.getData();
            r0 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                t = mvcNetMessage.getRequestData();
                r0 = (T) data;
            } else {
                t = r0;
                r0 = (T) data;
            }
        }
        if (t == null || r0 == null || !a(t, r0)) {
            if (mvcSocketResponsedMessage != null) {
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.mErrorCode);
            errorData.setError_msg(this.mErrorString);
            dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.a(errorData));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(T t, R r) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.e.c cVar) {
        dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.c(cVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.b.a aVar) {
        dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b.b(aVar));
    }
}
