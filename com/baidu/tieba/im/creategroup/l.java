package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes22.dex */
public class l extends BaseAdapter {
    private String[] jtY;
    private GroupAddressEditActivity jua;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.jtY = null;
        this.jua = null;
        this.jua = groupAddressEditActivity;
        this.jtY = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jtY != null) {
            return this.jtY.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.jtY == null || i <= -1 || i >= this.jtY.length) ? "" : this.jtY[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.jua);
            view = aVar.bMK();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.KI(getItem(i).toString());
        if (this.jua.cHi() == i) {
            aVar.qy(true);
        } else {
            aVar.qy(false);
        }
        cx(view);
        return view;
    }

    private void cx(View view) {
        this.jua.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jua.getLayoutMode().onModeChanged(view);
    }
}
