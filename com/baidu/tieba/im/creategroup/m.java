package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes17.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity iWB;
    private String[] iWp;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.iWp = null;
        this.iWB = null;
        this.iWB = groupAddressLocateActivity;
        this.iWp = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iWp != null) {
            return this.iWp.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iWp == null || i <= -1 || i >= this.iWp.length) ? "" : this.iWp[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iWB);
            view = aVar.bCf();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.crF() != null) {
            if (i + 1 == getCount()) {
                aVar.crF().setVisibility(8);
            } else {
                aVar.crF().setVisibility(0);
            }
        }
        aVar.Hn(getItem(i).toString());
        if (this.iWB.getSelectedPosition() == i) {
            aVar.pI(true);
        } else {
            aVar.pI(false);
        }
        cm(view);
        return view;
    }

    private void cm(View view) {
        this.iWB.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iWB.getLayoutMode().onModeChanged(view);
    }
}
