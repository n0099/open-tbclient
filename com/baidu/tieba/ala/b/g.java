package com.baidu.tieba.ala.b;
/* loaded from: classes10.dex */
public abstract class g {
    private h gMz;

    public abstract float getProgress();

    public abstract boolean isCompleted();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.gMz = hVar;
        onAttach();
    }

    public void detach() {
        this.gMz = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bTg() {
        return this.gMz;
    }
}
