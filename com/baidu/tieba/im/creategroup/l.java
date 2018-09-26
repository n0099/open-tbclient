package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] ewL;
    private GroupAddressEditActivity ewN;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.ewL = null;
        this.ewN = null;
        this.ewN = groupAddressEditActivity;
        this.ewL = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ewL != null) {
            return this.ewL.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.ewL == null || i <= -1 || i >= this.ewL.length) ? "" : this.ewL[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.ewN);
            view = aVar.aiP();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.oy(getItem(i).toString());
        if (this.ewN.aLp() == i) {
            aVar.hI(true);
        } else {
            aVar.hI(false);
        }
        aW(view);
        return view;
    }

    private void aW(View view) {
        this.ewN.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ewN.getLayoutMode().onModeChanged(view);
    }
}
