package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] eQl;
    private GroupAddressEditActivity eQn;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eQl = null;
        this.eQn = null;
        this.eQn = groupAddressEditActivity;
        this.eQl = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eQl != null) {
            return this.eQl.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eQl == null || i <= -1 || i >= this.eQl.length) ? "" : this.eQl[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eQn);
            view = aVar.anZ();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pW(getItem(i).toString());
        if (this.eQn.aRg() == i) {
            aVar.ip(true);
        } else {
            aVar.ip(false);
        }
        bb(view);
        return view;
    }

    private void bb(View view) {
        this.eQn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eQn.getLayoutMode().onModeChanged(view);
    }
}
