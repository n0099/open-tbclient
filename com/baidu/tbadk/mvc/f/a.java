package com.baidu.tbadk.mvc.f;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> Yf;
    protected String fj;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.fj = str;
        this.Yf = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T ua() {
        try {
            return this.Yf.newInstance();
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
