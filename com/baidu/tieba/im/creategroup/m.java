package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity ixE;
    private String[] ixs;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.ixs = null;
        this.ixE = null;
        this.ixE = groupAddressLocateActivity;
        this.ixs = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ixs != null) {
            return this.ixs.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.ixs == null || i <= -1 || i >= this.ixs.length) ? "" : this.ixs[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.ixE);
            view = aVar.bvT();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.ckb() != null) {
            if (i + 1 == getCount()) {
                aVar.ckb().setVisibility(8);
            } else {
                aVar.ckb().setVisibility(0);
            }
        }
        aVar.FX(getItem(i).toString());
        if (this.ixE.getSelectedPosition() == i) {
            aVar.oS(true);
        } else {
            aVar.oS(false);
        }
        cf(view);
        return view;
    }

    private void cf(View view) {
        this.ixE.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ixE.getLayoutMode().onModeChanged(view);
    }
}
