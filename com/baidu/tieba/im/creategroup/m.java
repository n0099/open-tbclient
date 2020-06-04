package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    private String[] iyf;
    private GroupAddressLocateActivity iyr;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.iyf = null;
        this.iyr = null;
        this.iyr = groupAddressLocateActivity;
        this.iyf = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iyf != null) {
            return this.iyf.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iyf == null || i <= -1 || i >= this.iyf.length) ? "" : this.iyf[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iyr);
            view = aVar.bvV();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.ckk() != null) {
            if (i + 1 == getCount()) {
                aVar.ckk().setVisibility(8);
            } else {
                aVar.ckk().setVisibility(0);
            }
        }
        aVar.FX(getItem(i).toString());
        if (this.iyr.getSelectedPosition() == i) {
            aVar.oS(true);
        } else {
            aVar.oS(false);
        }
        cf(view);
        return view;
    }

    private void cf(View view) {
        this.iyr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iyr.getLayoutMode().onModeChanged(view);
    }
}
