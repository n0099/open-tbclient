package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String[] eMI;
    private GroupAddressLocateActivity eMU;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.eMI = null;
        this.eMU = null;
        this.eMU = groupAddressLocateActivity;
        this.eMI = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eMI != null) {
            return this.eMI.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eMI == null || i <= -1 || i >= this.eMI.length) ? "" : this.eMI[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eMU);
            view = aVar.ana();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aOO() != null) {
            if (i + 1 == getCount()) {
                aVar.aOO().setVisibility(8);
            } else {
                aVar.aOO().setVisibility(0);
            }
        }
        aVar.pD(getItem(i).toString());
        if (this.eMU.getSelectedPosition() == i) {
            aVar.im(true);
        } else {
            aVar.im(false);
        }
        aY(view);
        return view;
    }

    private void aY(View view) {
        this.eMU.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eMU.getLayoutMode().onModeChanged(view);
    }
}
