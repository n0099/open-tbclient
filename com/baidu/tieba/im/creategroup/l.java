package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] elD;
    private GroupAddressEditActivity elF;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.elD = null;
        this.elF = null;
        this.elF = groupAddressEditActivity;
        this.elD = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.elD != null) {
            return this.elD.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.elD == null || i <= -1 || i >= this.elD.length) ? "" : this.elD[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.elF);
            view = aVar.agG();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nN(getItem(i).toString());
        if (this.elF.aIc() == i) {
            aVar.hh(true);
        } else {
            aVar.hh(false);
        }
        aF(view);
        return view;
    }

    private void aF(View view) {
        this.elF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.elF.getLayoutMode().onModeChanged(view);
    }
}
