package com.baidu.tieba;
/* loaded from: classes.dex */
class ae {
    final /* synthetic */ SnowView alx;
    public int speed;
    public int x;
    public int y;

    private ae(SnowView snowView) {
        this.alx = snowView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(SnowView snowView, ae aeVar) {
        this(snowView);
    }

    public String toString() {
        return "Coordinate: [" + this.x + "," + this.y + "," + this.speed + "]";
    }
}
