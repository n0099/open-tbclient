package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public abstract class g {
    private h eZX;

    public abstract float getProgress();

    public abstract boolean gt();

    protected abstract void onAttach();

    protected abstract void onDetach();

    public void a(h hVar) {
        this.eZX = hVar;
        onAttach();
    }

    public void detach() {
        this.eZX = null;
        onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h bnd() {
        return this.eZX;
    }
}
