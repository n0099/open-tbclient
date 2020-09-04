package com.baidu.tbadk.mvc.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.mvc.b.j;
/* loaded from: classes.dex */
public abstract class MvcHttpResponsedMessage<D extends j> extends TbHttpResponsedMessage {
    protected D data;

    public MvcHttpResponsedMessage(int i) {
        super(i);
    }

    public void setData(D d) {
        this.data = d;
    }

    public D getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object createData(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
