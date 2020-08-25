package com.baidu.tieba.ala.a;
/* loaded from: classes4.dex */
public abstract class g {
    private h fOJ;

    public abstract float getProgress();

    public abstract boolean ij();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.fOJ = hVar;
        onAttach();
    }

    public void detach() {
        this.fOJ = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bHJ() {
        return this.fOJ;
    }
}
