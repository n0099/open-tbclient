package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String[] eFT;
    private GroupAddressLocateActivity eGf;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.eFT = null;
        this.eGf = null;
        this.eGf = groupAddressLocateActivity;
        this.eFT = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eFT != null) {
            return this.eFT.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eFT == null || i <= -1 || i >= this.eFT.length) ? "" : this.eFT[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eGf);
            view = aVar.alT();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aMW() != null) {
            if (i + 1 == getCount()) {
                aVar.aMW().setVisibility(8);
            } else {
                aVar.aMW().setVisibility(0);
            }
        }
        aVar.pb(getItem(i).toString());
        if (this.eGf.getSelectedPosition() == i) {
            aVar.ij(true);
        } else {
            aVar.ij(false);
        }
        aY(view);
        return view;
    }

    private void aY(View view) {
        this.eGf.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eGf.getLayoutMode().onModeChanged(view);
    }
}
