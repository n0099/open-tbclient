package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] dWx;
    private GroupAddressEditActivity dWz;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.dWx = null;
        this.dWz = null;
        this.dWz = groupAddressEditActivity;
        this.dWx = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx != null) {
            return this.dWx.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.dWx == null || i <= -1 || i >= this.dWx.length) ? "" : this.dWx[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a(this.dWz);
            view2 = aVar.acD();
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.na(getItem(i).toString());
        if (this.dWz.aCA() == i) {
            aVar.gR(true);
        } else {
            aVar.gR(false);
        }
        aA(view2);
        return view2;
    }

    private void aA(View view2) {
        this.dWz.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dWz.getLayoutMode().u(view2);
    }
}
