package com.baidu.tbadk.widget.timepicker.a.a;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private int cYk;
    private int cYl;

    public b(int i, int i2) {
        this.cYk = i;
        this.cYl = i2;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.cYk + i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return (this.cYl - this.cYk) + 1;
    }
}
