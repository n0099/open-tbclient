package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] eEA;
    private GroupAddressEditActivity eEC;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eEA = null;
        this.eEC = null;
        this.eEC = groupAddressEditActivity;
        this.eEA = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eEA != null) {
            return this.eEA.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eEA == null || i <= -1 || i >= this.eEA.length) ? "" : this.eEA[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eEC);
            view = aVar.amu();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pa(getItem(i).toString());
        if (this.eEC.aOE() == i) {
            aVar.ia(true);
        } else {
            aVar.ia(false);
        }
        aW(view);
        return view;
    }

    private void aW(View view) {
        this.eEC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eEC.getLayoutMode().onModeChanged(view);
    }
}
