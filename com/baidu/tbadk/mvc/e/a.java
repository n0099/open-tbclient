package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected String agR;
    protected Class<T> byU;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.agR = str;
        this.byU = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T NG() {
        try {
            return this.byU.newInstance();
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
