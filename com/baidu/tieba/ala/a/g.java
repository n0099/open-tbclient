package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public abstract class g {
    private h fmM;

    public abstract float getProgress();

    public abstract boolean gt();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.fmM = hVar;
        onAttach();
    }

    public void detach() {
        this.fmM = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bsz() {
        return this.fmM;
    }
}
