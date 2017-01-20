package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> azm;
    protected String lM;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.lM = str;
        this.azm = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T ES() {
        try {
            return this.azm.newInstance();
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
