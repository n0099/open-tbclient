package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private String[] gDD;
    private GroupAddressEditActivity gDF;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.gDD = null;
        this.gDF = null;
        this.gDF = groupAddressEditActivity;
        this.gDD = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gDD != null) {
            return this.gDD.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gDD == null || i <= -1 || i >= this.gDD.length) ? "" : this.gDD[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gDF);
            view = aVar.aWR();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.yA(getItem(i).toString());
        if (this.gDF.bCd() == i) {
            aVar.lT(true);
        } else {
            aVar.lT(false);
        }
        bZ(view);
        return view;
    }

    private void bZ(View view) {
        this.gDF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gDF.getLayoutMode().onModeChanged(view);
    }
}
