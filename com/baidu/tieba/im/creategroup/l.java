package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private String[] hxq;
    private GroupAddressEditActivity hxs;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.hxq = null;
        this.hxs = null;
        this.hxs = groupAddressEditActivity;
        this.hxq = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxq != null) {
            return this.hxq.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hxq == null || i <= -1 || i >= this.hxq.length) ? "" : this.hxq[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hxs);
            view = aVar.bgG();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.CD(getItem(i).toString());
        if (this.hxs.bTR() == i) {
            aVar.nm(true);
        } else {
            aVar.nm(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.hxs.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hxs.getLayoutMode().onModeChanged(view);
    }
}
