package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class l extends BaseAdapter {
    private String[] hyQ;
    private GroupAddressEditActivity hyS;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.hyQ = null;
        this.hyS = null;
        this.hyS = groupAddressEditActivity;
        this.hyQ = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hyQ != null) {
            return this.hyQ.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hyQ == null || i <= -1 || i >= this.hyQ.length) ? "" : this.hyQ[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hyS);
            view = aVar.bgL();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.CC(getItem(i).toString());
        if (this.hyS.bUj() == i) {
            aVar.ns(true);
        } else {
            aVar.ns(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.hyS.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hyS.getLayoutMode().onModeChanged(view);
    }
}
