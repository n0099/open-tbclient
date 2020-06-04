package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private String[] iyf;
    private GroupAddressEditActivity iyh;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.iyf = null;
        this.iyh = null;
        this.iyh = groupAddressEditActivity;
        this.iyf = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iyf != null) {
            return this.iyf.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iyf == null || i <= -1 || i >= this.iyf.length) ? "" : this.iyf[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iyh);
            view = aVar.bvV();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.FX(getItem(i).toString());
        if (this.iyh.clp() == i) {
            aVar.oS(true);
        } else {
            aVar.oS(false);
        }
        cf(view);
        return view;
    }

    private void cf(View view) {
        this.iyh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iyh.getLayoutMode().onModeChanged(view);
    }
}
