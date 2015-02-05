package com.baidu.tieba;
/* loaded from: classes.dex */
class ae {
    final /* synthetic */ SnowView alu;
    public int speed;
    public int x;
    public int y;

    private ae(SnowView snowView) {
        this.alu = snowView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(SnowView snowView, ae aeVar) {
        this(snowView);
    }

    public String toString() {
        return "Coordinate: [" + this.x + "," + this.y + "," + this.speed + "]";
    }
}
