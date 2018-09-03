package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] eps;
    private GroupAddressEditActivity epu;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eps = null;
        this.epu = null;
        this.epu = groupAddressEditActivity;
        this.eps = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eps != null) {
            return this.eps.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eps == null || i <= -1 || i >= this.eps.length) ? "" : this.eps[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.epu);
            view = aVar.ahd();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nR(getItem(i).toString());
        if (this.epu.aJa() == i) {
            aVar.hk(true);
        } else {
            aVar.hk(false);
        }
        aI(view);
        return view;
    }

    private void aI(View view) {
        this.epu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.epu.getLayoutMode().onModeChanged(view);
    }
}
