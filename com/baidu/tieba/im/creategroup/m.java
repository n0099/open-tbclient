package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class m extends BaseAdapter {
    private String[] ggd;
    private GroupAddressLocateActivity ggp;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.ggd = null;
        this.ggp = null;
        this.ggp = groupAddressLocateActivity;
        this.ggd = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ggd != null) {
            return this.ggd.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.ggd == null || i <= -1 || i >= this.ggd.length) ? "" : this.ggd[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.ggp);
            view = aVar.aOH();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.bqD() != null) {
            if (i + 1 == getCount()) {
                aVar.bqD().setVisibility(8);
            } else {
                aVar.bqD().setVisibility(0);
            }
        }
        aVar.wz(getItem(i).toString());
        if (this.ggp.getSelectedPosition() == i) {
            aVar.kP(true);
        } else {
            aVar.kP(false);
        }
        bP(view);
        return view;
    }

    private void bP(View view) {
        this.ggp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ggp.getLayoutMode().onModeChanged(view);
    }
}
