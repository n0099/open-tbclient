package com.baidu.tieba.ala.b;
/* loaded from: classes9.dex */
public abstract class g {
    private h gOi;

    public abstract float getProgress();

    public abstract boolean isCompleted();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.gOi = hVar;
        onAttach();
    }

    public void detach() {
        this.gOi = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bTm() {
        return this.gOi;
    }
}
