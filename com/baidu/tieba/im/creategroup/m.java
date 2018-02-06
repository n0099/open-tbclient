package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String[] eAL;
    private GroupAddressEditActivity eAN;

    public m(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eAL = null;
        this.eAN = null;
        this.eAN = groupAddressEditActivity;
        this.eAL = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAL != null) {
            return this.eAL.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eAL == null || i <= -1 || i >= this.eAL.length) ? "" : this.eAL[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eAN);
            view = aVar.aix();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mT(getItem(i).toString());
        if (this.eAN.aHD() == i) {
            aVar.hl(true);
        } else {
            aVar.hl(false);
        }
        bU(view);
        return view;
    }

    private void bU(View view) {
        this.eAN.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eAN.getLayoutMode().aM(view);
    }
}
