package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public abstract class g {
    private h gCz;

    public abstract float getProgress();

    public abstract boolean ik();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.gCz = hVar;
        onAttach();
    }

    public void detach() {
        this.gCz = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bTI() {
        return this.gCz;
    }
}
