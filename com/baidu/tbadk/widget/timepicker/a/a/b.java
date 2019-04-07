package com.baidu.tbadk.widget.timepicker.a.a;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private int cEq;
    private int cEr;

    public b(int i, int i2) {
        this.cEq = i;
        this.cEr = i2;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.cEq + i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return (this.cEr - this.cEq) + 1;
    }
}
