package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private String[] hxe;
    private GroupAddressEditActivity hxg;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.hxe = null;
        this.hxg = null;
        this.hxg = groupAddressEditActivity;
        this.hxe = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxe != null) {
            return this.hxe.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hxe == null || i <= -1 || i >= this.hxe.length) ? "" : this.hxe[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hxg);
            view = aVar.bgF();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.CC(getItem(i).toString());
        if (this.hxg.bTQ() == i) {
            aVar.nm(true);
        } else {
            aVar.nm(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.hxg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hxg.getLayoutMode().onModeChanged(view);
    }
}
