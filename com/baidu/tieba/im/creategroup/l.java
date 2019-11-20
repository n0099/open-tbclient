package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private String[] gDv;
    private GroupAddressEditActivity gDx;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.gDv = null;
        this.gDx = null;
        this.gDx = groupAddressEditActivity;
        this.gDv = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gDv != null) {
            return this.gDv.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gDv == null || i <= -1 || i >= this.gDv.length) ? "" : this.gDv[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gDx);
            view = aVar.aMv();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.xt(getItem(i).toString());
        if (this.gDx.bzO() == i) {
            aVar.lK(true);
        } else {
            aVar.lK(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.gDx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gDx.getLayoutMode().onModeChanged(view);
    }
}
