package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes17.dex */
public class m extends BaseAdapter {
    private String[] iWn;
    private GroupAddressLocateActivity iWz;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.iWn = null;
        this.iWz = null;
        this.iWz = groupAddressLocateActivity;
        this.iWn = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iWn != null) {
            return this.iWn.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iWn == null || i <= -1 || i >= this.iWn.length) ? "" : this.iWn[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iWz);
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
        if (this.iWz.getSelectedPosition() == i) {
            aVar.pI(true);
        } else {
            aVar.pI(false);
        }
        cm(view);
        return view;
    }

    private void cm(View view) {
        this.iWz.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iWz.getLayoutMode().onModeChanged(view);
    }
}
