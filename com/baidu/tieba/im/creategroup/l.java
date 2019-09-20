package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private String[] gGn;
    private GroupAddressEditActivity gGp;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.gGn = null;
        this.gGp = null;
        this.gGp = groupAddressEditActivity;
        this.gGn = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gGn != null) {
            return this.gGn.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gGn == null || i <= -1 || i >= this.gGn.length) ? "" : this.gGn[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gGp);
            view = aVar.aXx();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.za(getItem(i).toString());
        if (this.gGp.bDf() == i) {
            aVar.lW(true);
        } else {
            aVar.lW(false);
        }
        ca(view);
        return view;
    }

    private void ca(View view) {
        this.gGp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gGp.getLayoutMode().onModeChanged(view);
    }
}
