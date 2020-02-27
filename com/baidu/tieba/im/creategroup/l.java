package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private String[] hxc;
    private GroupAddressEditActivity hxe;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.hxc = null;
        this.hxe = null;
        this.hxe = groupAddressEditActivity;
        this.hxc = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxc != null) {
            return this.hxc.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hxc == null || i <= -1 || i >= this.hxc.length) ? "" : this.hxc[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hxe);
            view = aVar.bgD();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.CC(getItem(i).toString());
        if (this.hxe.bTO() == i) {
            aVar.nm(true);
        } else {
            aVar.nm(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.hxe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hxe.getLayoutMode().onModeChanged(view);
    }
}
