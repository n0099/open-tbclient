package com.baidu.tieba.ala.a;
/* loaded from: classes4.dex */
public abstract class g {
    private h fON;

    public abstract float getProgress();

    public abstract boolean ij();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.fON = hVar;
        onAttach();
    }

    public void detach() {
        this.fON = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bHK() {
        return this.fON;
    }
}
