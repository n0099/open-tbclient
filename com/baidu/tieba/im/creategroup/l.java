package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private String[] jIV;
    private GroupAddressEditActivity jIX;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.jIV = null;
        this.jIX = null;
        this.jIX = groupAddressEditActivity;
        this.jIV = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jIV != null) {
            return this.jIV.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.jIV == null || i <= -1 || i >= this.jIV.length) ? "" : this.jIV[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.jIX);
            view = aVar.bQb();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Lx(getItem(i).toString());
        if (this.jIX.cKR() == i) {
            aVar.re(true);
        } else {
            aVar.re(false);
        }
        cB(view);
        return view;
    }

    private void cB(View view) {
        this.jIX.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jIX.getLayoutMode().onModeChanged(view);
    }
}
