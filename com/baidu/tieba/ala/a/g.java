package com.baidu.tieba.ala.a;
/* loaded from: classes4.dex */
public abstract class g {
    private h fDs;

    public abstract boolean gJ();

    public abstract float getProgress();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.fDs = hVar;
        onAttach();
    }

    public void detach() {
        this.fDs = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h byG() {
        return this.fDs;
    }
}
