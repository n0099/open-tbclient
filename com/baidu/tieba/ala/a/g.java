package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public abstract class g {
    private h fyl;

    public abstract boolean gJ();

    public abstract float getProgress();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.fyl = hVar;
        onAttach();
    }

    public void detach() {
        this.fyl = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bvw() {
        return this.fyl;
    }
}
