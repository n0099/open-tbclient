package com.baidu.tbadk.mvc.f;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> aev;
    protected String hl;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.hl = str;
        this.aev = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T xM() {
        try {
            return this.aev.newInstance();
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
