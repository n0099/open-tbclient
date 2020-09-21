package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public abstract class g {
    private h fRY;

    public abstract float getProgress();

    public abstract boolean ij();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.fRY = hVar;
        onAttach();
    }

    public void detach() {
        this.fRY = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bIS() {
        return this.fRY;
    }
}
