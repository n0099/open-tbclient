package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private GroupAddressEditActivity ePB;
    private String[] ePz;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.ePz = null;
        this.ePB = null;
        this.ePB = groupAddressEditActivity;
        this.ePz = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ePz != null) {
            return this.ePz.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.ePz == null || i <= -1 || i >= this.ePz.length) ? "" : this.ePz[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.ePB);
            view = aVar.anC();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pG(getItem(i).toString());
        if (this.ePB.aQG() == i) {
            aVar.ip(true);
        } else {
            aVar.ip(false);
        }
        bb(view);
        return view;
    }

    private void bb(View view) {
        this.ePB.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ePB.getLayoutMode().onModeChanged(view);
    }
}
