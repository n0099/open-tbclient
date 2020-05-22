package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> eqU;
    protected String tableName;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.tableName = str;
        this.eqU = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T bfi() {
        try {
            return this.eqU.newInstance();
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
