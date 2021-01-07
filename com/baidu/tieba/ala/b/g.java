package com.baidu.tieba.ala.b;
/* loaded from: classes10.dex */
public abstract class g {
    private h gOl;

    public abstract float getProgress();

    public abstract boolean isCompleted();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.gOl = hVar;
        onAttach();
    }

    public void detach() {
        this.gOl = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bWo() {
        return this.gOl;
    }
}
