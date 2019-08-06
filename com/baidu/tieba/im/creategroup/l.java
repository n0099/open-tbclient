package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private String[] gEv;
    private GroupAddressEditActivity gEx;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.gEv = null;
        this.gEx = null;
        this.gEx = groupAddressEditActivity;
        this.gEv = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gEv != null) {
            return this.gEv.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gEv == null || i <= -1 || i >= this.gEv.length) ? "" : this.gEv[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gEx);
            view = aVar.aWT();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.yB(getItem(i).toString());
        if (this.gEx.bCr() == i) {
            aVar.lT(true);
        } else {
            aVar.lT(false);
        }
        ca(view);
        return view;
    }

    private void ca(View view) {
        this.gEx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gEx.getLayoutMode().onModeChanged(view);
    }
}
