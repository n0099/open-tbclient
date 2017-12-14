package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> aIO;
    protected String sB;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.sB = str;
        this.aIO = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T FL() {
        try {
            return this.aIO.newInstance();
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
