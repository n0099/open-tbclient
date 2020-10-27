package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private String[] jVu;
    private GroupAddressEditActivity jVw;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.jVu = null;
        this.jVw = null;
        this.jVw = groupAddressEditActivity;
        this.jVu = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jVu != null) {
            return this.jVu.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.jVu == null || i <= -1 || i >= this.jVu.length) ? "" : this.jVu[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.jVw);
            view = aVar.bSY();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.LV(getItem(i).toString());
        if (this.jVw.cNY() == i) {
            aVar.rw(true);
        } else {
            aVar.rw(false);
        }
        cF(view);
        return view;
    }

    private void cF(View view) {
        this.jVw.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jVw.getLayoutMode().onModeChanged(view);
    }
}
