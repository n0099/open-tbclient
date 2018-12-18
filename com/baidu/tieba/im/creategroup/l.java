package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] eMI;
    private GroupAddressEditActivity eMK;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eMI = null;
        this.eMK = null;
        this.eMK = groupAddressEditActivity;
        this.eMI = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eMI != null) {
            return this.eMI.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eMI == null || i <= -1 || i >= this.eMI.length) ? "" : this.eMI[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eMK);
            view = aVar.ana();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pD(getItem(i).toString());
        if (this.eMK.aPS() == i) {
            aVar.im(true);
        } else {
            aVar.im(false);
        }
        aY(view);
        return view;
    }

    private void aY(View view) {
        this.eMK.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eMK.getLayoutMode().onModeChanged(view);
    }
}
