package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public abstract class g {
    private h fac;

    public abstract float getProgress();

    public abstract boolean gt();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.fac = hVar;
        onAttach();
    }

    public void detach() {
        this.fac = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bnb() {
        return this.fac;
    }
}
