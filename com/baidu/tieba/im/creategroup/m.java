package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes22.dex */
public class m extends BaseAdapter {
    private String[] jtY;
    private GroupAddressLocateActivity juk;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.jtY = null;
        this.juk = null;
        this.juk = groupAddressLocateActivity;
        this.jtY = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jtY != null) {
            return this.jtY.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.jtY == null || i <= -1 || i >= this.jtY.length) ? "" : this.jtY[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.juk);
            view = aVar.bMK();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cGe() != null) {
            if (i + 1 == getCount()) {
                aVar.cGe().setVisibility(8);
            } else {
                aVar.cGe().setVisibility(0);
            }
        }
        aVar.KI(getItem(i).toString());
        if (this.juk.getSelectedPosition() == i) {
            aVar.qy(true);
        } else {
            aVar.qy(false);
        }
        cx(view);
        return view;
    }

    private void cx(View view) {
        this.juk.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.juk.getLayoutMode().onModeChanged(view);
    }
}
