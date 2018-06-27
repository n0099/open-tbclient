package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String[] elD;
    private GroupAddressLocateActivity elP;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.elD = null;
        this.elP = null;
        this.elP = groupAddressLocateActivity;
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
            aVar = new a(this.elP);
            view = aVar.agG();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aGX() != null) {
            if (i + 1 == getCount()) {
                aVar.aGX().setVisibility(8);
            } else {
                aVar.aGX().setVisibility(0);
            }
        }
        aVar.nN(getItem(i).toString());
        if (this.elP.getSelectedPosition() == i) {
            aVar.hh(true);
        } else {
            aVar.hh(false);
        }
        aF(view);
        return view;
    }

    private void aF(View view) {
        this.elP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.elP.getLayoutMode().onModeChanged(view);
    }
}
