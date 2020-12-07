package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public abstract class g {
    private h gCx;

    public abstract float getProgress();

    public abstract boolean ik();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.gCx = hVar;
        onAttach();
    }

    public void detach() {
        this.gCx = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bTH() {
        return this.gCx;
    }
}
