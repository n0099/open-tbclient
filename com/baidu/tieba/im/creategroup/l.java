package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes23.dex */
public class l extends BaseAdapter {
    private String[] kpF;
    private GroupAddressEditActivity kpH;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.kpF = null;
        this.kpH = null;
        this.kpH = groupAddressEditActivity;
        this.kpF = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kpF != null) {
            return this.kpF.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.kpF == null || i <= -1 || i >= this.kpF.length) ? "" : this.kpF[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.kpH);
            view = aVar.bYz();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.MV(getItem(i).toString());
        if (this.kpH.cVt() == i) {
            aVar.sk(true);
        } else {
            aVar.sk(false);
        }
        cV(view);
        return view;
    }

    private void cV(View view) {
        this.kpH.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kpH.getLayoutMode().onModeChanged(view);
    }
}
