package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity epI;
    private String[] epw;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.epw = null;
        this.epI = null;
        this.epI = groupAddressLocateActivity;
        this.epw = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.epw != null) {
            return this.epw.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.epw == null || i <= -1 || i >= this.epw.length) ? "" : this.epw[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.epI);
            view = aVar.ahb();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aHX() != null) {
            if (i + 1 == getCount()) {
                aVar.aHX().setVisibility(8);
            } else {
                aVar.aHX().setVisibility(0);
            }
        }
        aVar.nP(getItem(i).toString());
        if (this.epI.getSelectedPosition() == i) {
            aVar.hk(true);
        } else {
            aVar.hk(false);
        }
        aI(view);
        return view;
    }

    private void aI(View view) {
        this.epI.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.epI.getLayoutMode().onModeChanged(view);
    }
}
