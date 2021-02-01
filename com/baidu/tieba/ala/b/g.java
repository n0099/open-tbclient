package com.baidu.tieba.ala.b;
/* loaded from: classes10.dex */
public abstract class g {
    private h gMl;

    public abstract float getProgress();

    public abstract boolean isCompleted();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.gMl = hVar;
        onAttach();
    }

    public void detach() {
        this.gMl = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bSZ() {
        return this.gMl;
    }
}
