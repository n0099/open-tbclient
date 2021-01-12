package com.baidu.tieba.ala.b;
/* loaded from: classes9.dex */
public abstract class g {
    private h gJF;

    public abstract float getProgress();

    public abstract boolean isCompleted();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.gJF = hVar;
        onAttach();
    }

    public void detach() {
        this.gJF = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bSw() {
        return this.gJF;
    }
}
