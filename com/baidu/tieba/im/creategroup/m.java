package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    private String[] iiJ;
    private GroupAddressLocateActivity iiV;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.iiJ = null;
        this.iiV = null;
        this.iiV = groupAddressLocateActivity;
        this.iiJ = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iiJ != null) {
            return this.iiJ.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iiJ == null || i <= -1 || i >= this.iiJ.length) ? "" : this.iiJ[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iiV);
            view = aVar.bqa();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cdC() != null) {
            if (i + 1 == getCount()) {
                aVar.cdC().setVisibility(8);
            } else {
                aVar.cdC().setVisibility(0);
            }
        }
        aVar.Eo(getItem(i).toString());
        if (this.iiV.getSelectedPosition() == i) {
            aVar.ow(true);
        } else {
            aVar.ow(false);
        }
        cf(view);
        return view;
    }

    private void cf(View view) {
        this.iiV.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iiV.getLayoutMode().onModeChanged(view);
    }
}
