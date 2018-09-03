package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity epE;
    private String[] eps;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.eps = null;
        this.epE = null;
        this.epE = groupAddressLocateActivity;
        this.eps = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eps != null) {
            return this.eps.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eps == null || i <= -1 || i >= this.eps.length) ? "" : this.eps[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.epE);
            view = aVar.ahd();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aHU() != null) {
            if (i + 1 == getCount()) {
                aVar.aHU().setVisibility(8);
            } else {
                aVar.aHU().setVisibility(0);
            }
        }
        aVar.nR(getItem(i).toString());
        if (this.epE.getSelectedPosition() == i) {
            aVar.hk(true);
        } else {
            aVar.hk(false);
        }
        aI(view);
        return view;
    }

    private void aI(View view) {
        this.epE.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.epE.getLayoutMode().onModeChanged(view);
    }
}
