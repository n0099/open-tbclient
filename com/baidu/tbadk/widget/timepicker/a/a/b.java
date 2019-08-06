package com.baidu.tbadk.widget.timepicker.a.a;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private int cOc;
    private int cOd;

    public b(int i, int i2) {
        this.cOc = i;
        this.cOd = i2;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.cOc + i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return (this.cOd - this.cOc) + 1;
    }
}
