package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private String[] ixs;
    private GroupAddressEditActivity ixu;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.ixs = null;
        this.ixu = null;
        this.ixu = groupAddressEditActivity;
        this.ixs = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ixs != null) {
            return this.ixs.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.ixs == null || i <= -1 || i >= this.ixs.length) ? "" : this.ixs[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.ixu);
            view = aVar.bvT();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.FX(getItem(i).toString());
        if (this.ixu.clg() == i) {
            aVar.oS(true);
        } else {
            aVar.oS(false);
        }
        cf(view);
        return view;
    }

    private void cf(View view) {
        this.ixu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ixu.getLayoutMode().onModeChanged(view);
    }
}
