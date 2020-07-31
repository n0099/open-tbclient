package com.baidu.tbadk.widget.timepicker.a.a;

import java.util.List;
/* loaded from: classes15.dex */
public class a<T> implements com.baidu.tbadk.widget.timepicker.wheel.a.a {
    private List<T> items;

    public a(List<T> list) {
        this.items = list;
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public Object getItem(int i) {
        return (i < 0 || i >= this.items.size()) ? "" : this.items.get(i);
    }

    @Override // com.baidu.tbadk.widget.timepicker.wheel.a.a
    public int getItemsCount() {
        return this.items.size();
    }
}
