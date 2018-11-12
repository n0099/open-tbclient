package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected String Aw;
    protected Class<T> bbq;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.Aw = str;
        this.bbq = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T NC() {
        try {
            return this.bbq.newInstance();
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
