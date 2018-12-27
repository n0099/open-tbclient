package com.baidu.tbadk.widget.timepicker.a.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private int bsq;
    private int bsr;

    public b(int i, int i2) {
        this.bsq = i;
        this.bsr = i2;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.bsq + i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return (this.bsr - this.bsq) + 1;
    }
}
