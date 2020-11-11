package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private String[] kbr;
    private GroupAddressEditActivity kbt;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.kbr = null;
        this.kbt = null;
        this.kbt = groupAddressEditActivity;
        this.kbr = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kbr != null) {
            return this.kbr.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.kbr == null || i <= -1 || i >= this.kbr.length) ? "" : this.kbr[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.kbt);
            view = aVar.bVx();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Mm(getItem(i).toString());
        if (this.kbt.cQz() == i) {
            aVar.rF(true);
        } else {
            aVar.rF(false);
        }
        cK(view);
        return view;
    }

    private void cK(View view) {
        this.kbt.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kbt.getLayoutMode().onModeChanged(view);
    }
}
