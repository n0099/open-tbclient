package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] dVt;
    private GroupAddressEditActivity dVv;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.dVt = null;
        this.dVv = null;
        this.dVv = groupAddressEditActivity;
        this.dVt = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dVt != null) {
            return this.dVt.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.dVt == null || i <= -1 || i >= this.dVt.length) ? "" : this.dVt[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a(this.dVv);
            view2 = aVar.acD();
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.mX(getItem(i).toString());
        if (this.dVv.aCC() == i) {
            aVar.gQ(true);
        } else {
            aVar.gQ(false);
        }
        aA(view2);
        return view2;
    }

    private void aA(View view2) {
        this.dVv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dVv.getLayoutMode().u(view2);
    }
}
