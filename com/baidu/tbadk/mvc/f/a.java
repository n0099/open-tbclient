package com.baidu.tbadk.mvc.f;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> aeS;
    protected String hn;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.hn = str;
        this.aeS = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T yc() {
        try {
            return this.aeS.newInstance();
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
