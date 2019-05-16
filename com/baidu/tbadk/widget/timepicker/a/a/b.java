package com.baidu.tbadk.widget.timepicker.a.a;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private int cMA;
    private int cMB;

    public b(int i, int i2) {
        this.cMA = i;
        this.cMB = i2;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.cMA + i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return (this.cMB - this.cMA) + 1;
    }
}
