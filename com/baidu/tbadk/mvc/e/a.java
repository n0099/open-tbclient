package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> avL;
    protected String sQ;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.sQ = str;
        this.avL = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T Dh() {
        try {
            return this.avL.newInstance();
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
