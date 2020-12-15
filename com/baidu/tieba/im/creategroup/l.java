package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private String[] kpH;
    private GroupAddressEditActivity kpJ;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.kpH = null;
        this.kpJ = null;
        this.kpJ = groupAddressEditActivity;
        this.kpH = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kpH != null) {
            return this.kpH.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.kpH == null || i <= -1 || i >= this.kpH.length) ? "" : this.kpH[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.kpJ);
            view = aVar.bYA();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.MV(getItem(i).toString());
        if (this.kpJ.cVu() == i) {
            aVar.sk(true);
        } else {
            aVar.sk(false);
        }
        cV(view);
        return view;
    }

    private void cV(View view) {
        this.kpJ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kpJ.getLayoutMode().onModeChanged(view);
    }
}
