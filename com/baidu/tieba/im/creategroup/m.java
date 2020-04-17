package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    private String[] iiD;
    private GroupAddressLocateActivity iiP;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.iiD = null;
        this.iiP = null;
        this.iiP = groupAddressLocateActivity;
        this.iiD = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iiD != null) {
            return this.iiD.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iiD == null || i <= -1 || i >= this.iiD.length) ? "" : this.iiD[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iiP);
            view = aVar.bqc();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cdE() != null) {
            if (i + 1 == getCount()) {
                aVar.cdE().setVisibility(8);
            } else {
                aVar.cdE().setVisibility(0);
            }
        }
        aVar.El(getItem(i).toString());
        if (this.iiP.getSelectedPosition() == i) {
            aVar.ow(true);
        } else {
            aVar.ow(false);
        }
        cf(view);
        return view;
    }

    private void cf(View view) {
        this.iiP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iiP.getLayoutMode().onModeChanged(view);
    }
}
