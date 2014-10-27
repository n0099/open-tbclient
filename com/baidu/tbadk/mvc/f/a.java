package com.baidu.tbadk.mvc.f;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> Yb;
    protected String fj;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.fj = str;
        this.Yb = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T tY() {
        try {
            return this.Yb.newInstance();
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
