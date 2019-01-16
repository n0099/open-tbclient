package com.baidu.tbadk.widget.timepicker.a.a;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private int bte;
    private int btf;

    public b(int i, int i2) {
        this.bte = i;
        this.btf = i2;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.bte + i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return (this.btf - this.bte) + 1;
    }
}
