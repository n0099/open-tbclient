package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> aSO;
    protected String xw;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.xw = str;
        this.aSO = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T Kg() {
        try {
            return this.aSO.newInstance();
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
