package com.baidu.tbadk.mvc.e;
/* loaded from: classes.dex */
public abstract class a<T> extends b<T> {
    protected Class<T> cxx;
    protected String yf;

    public a(int i, String str, Class<T> cls) {
        super(i);
        this.yf = str;
        this.cxx = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T atF() {
        try {
            return this.cxx.newInstance();
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
