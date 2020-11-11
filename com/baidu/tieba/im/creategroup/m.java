package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes23.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity kbD;
    private String[] kbr;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.kbr = null;
        this.kbD = null;
        this.kbD = groupAddressLocateActivity;
        this.kbr = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kbr != null) {
            return this.kbr.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.kbr == null || i <= -1 || i >= this.kbr.length) ? "" : this.kbr[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.kbD);
            view = aVar.bVx();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cPv() != null) {
            if (i + 1 == getCount()) {
                aVar.cPv().setVisibility(8);
            } else {
                aVar.cPv().setVisibility(0);
            }
        }
        aVar.Mm(getItem(i).toString());
        if (this.kbD.getSelectedPosition() == i) {
            aVar.rF(true);
        } else {
            aVar.rF(false);
        }
        cK(view);
        return view;
    }

    private void cK(View view) {
        this.kbD.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kbD.getLayoutMode().onModeChanged(view);
    }
}
