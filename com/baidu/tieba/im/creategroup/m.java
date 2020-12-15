package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes23.dex */
public class m extends BaseAdapter {
    private String[] kpH;
    private GroupAddressLocateActivity kpT;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.kpH = null;
        this.kpT = null;
        this.kpT = groupAddressLocateActivity;
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
            aVar = new a(this.kpT);
            view = aVar.bYA();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cUq() != null) {
            if (i + 1 == getCount()) {
                aVar.cUq().setVisibility(8);
            } else {
                aVar.cUq().setVisibility(0);
            }
        }
        aVar.MV(getItem(i).toString());
        if (this.kpT.getSelectedPosition() == i) {
            aVar.sk(true);
        } else {
            aVar.sk(false);
        }
        cV(view);
        return view;
    }

    private void cV(View view) {
        this.kpT.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kpT.getLayoutMode().onModeChanged(view);
    }
}
