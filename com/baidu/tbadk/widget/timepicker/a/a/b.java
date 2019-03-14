package com.baidu.tbadk.widget.timepicker.a.a;
/* loaded from: classes3.dex */
public class b implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private int cEo;
    private int cEp;

    public b(int i, int i2) {
        this.cEo = i;
        this.cEp = i2;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.cEo + i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return (this.cEp - this.cEo) + 1;
    }
}
