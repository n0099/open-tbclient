package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private GroupAddressEditActivity eAB;
    private String[] eAz;

    public m(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eAz = null;
        this.eAB = null;
        this.eAB = groupAddressEditActivity;
        this.eAz = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAz != null) {
            return this.eAz.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eAz == null || i <= -1 || i >= this.eAz.length) ? "" : this.eAz[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eAB);
            view = aVar.aiw();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mT(getItem(i).toString());
        if (this.eAB.aHC() == i) {
            aVar.hl(true);
        } else {
            aVar.hl(false);
        }
        bU(view);
        return view;
    }

    private void bU(View view) {
        this.eAB.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eAB.getLayoutMode().aM(view);
    }
}
