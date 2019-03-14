package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private String[] ggp;
    private GroupAddressEditActivity ggr;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.ggp = null;
        this.ggr = null;
        this.ggr = groupAddressEditActivity;
        this.ggp = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ggp != null) {
            return this.ggp.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.ggp == null || i <= -1 || i >= this.ggp.length) ? "" : this.ggp[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.ggr);
            view = aVar.aOM();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.wA(getItem(i).toString());
        if (this.ggr.brL() == i) {
            aVar.kP(true);
        } else {
            aVar.kP(false);
        }
        bP(view);
        return view;
    }

    private void bP(View view) {
        this.ggr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ggr.getLayoutMode().onModeChanged(view);
    }
}
