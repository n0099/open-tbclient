package com.baidu.tbadk.mvc.f;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> anj;
    protected String sI;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.sI = str;
        this.anj = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T Bk() {
        try {
            return this.anj.newInstance();
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
