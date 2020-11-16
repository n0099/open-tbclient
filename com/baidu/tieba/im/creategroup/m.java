package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes22.dex */
public class m extends BaseAdapter {
    private String[] kcb;
    private GroupAddressLocateActivity kcn;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.kcb = null;
        this.kcn = null;
        this.kcn = groupAddressLocateActivity;
        this.kcb = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kcb != null) {
            return this.kcb.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.kcb == null || i <= -1 || i >= this.kcb.length) ? "" : this.kcb[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.kcn);
            view = aVar.bUQ();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cPb() != null) {
            if (i + 1 == getCount()) {
                aVar.cPb().setVisibility(8);
            } else {
                aVar.cPb().setVisibility(0);
            }
        }
        aVar.LN(getItem(i).toString());
        if (this.kcn.getSelectedPosition() == i) {
            aVar.rI(true);
        } else {
            aVar.rI(false);
        }
        cO(view);
        return view;
    }

    private void cO(View view) {
        this.kcn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kcn.getLayoutMode().onModeChanged(view);
    }
}
