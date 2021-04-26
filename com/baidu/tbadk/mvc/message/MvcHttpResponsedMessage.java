package com.baidu.tbadk.mvc.message;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import d.a.i0.g0.b.h;
/* loaded from: classes3.dex */
public abstract class MvcHttpResponsedMessage<D extends h> extends TbHttpResponsedMessage {
    public D data;

    public MvcHttpResponsedMessage(int i2) {
        super(i2);
    }

    public Object createData(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (ExceptionInInitializerError e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (InstantiationException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public D getData() {
        return this.data;
    }

    public void setData(D d2) {
        this.data = d2;
    }
}
