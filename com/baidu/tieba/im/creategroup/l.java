package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes22.dex */
public class l extends BaseAdapter {
    private String[] kcb;
    private GroupAddressEditActivity kcd;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.kcb = null;
        this.kcd = null;
        this.kcd = groupAddressEditActivity;
        this.kcb = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kcb != null) {
            return this.kcb.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.kcb == null || i <= -1 || i >= this.kcb.length) ? "" : this.kcb[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.kcd);
            view = aVar.bUQ();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.LN(getItem(i).toString());
        if (this.kcd.cQf() == i) {
            aVar.rI(true);
        } else {
            aVar.rI(false);
        }
        cO(view);
        return view;
    }

    private void cO(View view) {
        this.kcd.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kcd.getLayoutMode().onModeChanged(view);
    }
}
