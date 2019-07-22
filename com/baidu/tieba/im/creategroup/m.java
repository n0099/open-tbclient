package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class m extends BaseAdapter {
    private String[] gDD;
    private GroupAddressLocateActivity gDP;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.gDD = null;
        this.gDP = null;
        this.gDP = groupAddressLocateActivity;
        this.gDD = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gDD != null) {
            return this.gDD.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gDD == null || i <= -1 || i >= this.gDD.length) ? "" : this.gDD[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gDP);
            view = aVar.aWR();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.bAX() != null) {
            if (i + 1 == getCount()) {
                aVar.bAX().setVisibility(8);
            } else {
                aVar.bAX().setVisibility(0);
            }
        }
        aVar.yA(getItem(i).toString());
        if (this.gDP.getSelectedPosition() == i) {
            aVar.lT(true);
        } else {
            aVar.lT(false);
        }
        bZ(view);
        return view;
    }

    private void bZ(View view) {
        this.gDP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gDP.getLayoutMode().onModeChanged(view);
    }
}
