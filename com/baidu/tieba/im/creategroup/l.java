package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private String[] iiD;
    private GroupAddressEditActivity iiF;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.iiD = null;
        this.iiF = null;
        this.iiF = groupAddressEditActivity;
        this.iiD = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iiD != null) {
            return this.iiD.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iiD == null || i <= -1 || i >= this.iiD.length) ? "" : this.iiD[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iiF);
            view = aVar.bqc();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.El(getItem(i).toString());
        if (this.iiF.ceK() == i) {
            aVar.ow(true);
        } else {
            aVar.ow(false);
        }
        cf(view);
        return view;
    }

    private void cf(View view) {
        this.iiF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iiF.getLayoutMode().onModeChanged(view);
    }
}
