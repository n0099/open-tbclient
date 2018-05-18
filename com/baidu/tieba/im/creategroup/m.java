package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity dWJ;
    private String[] dWx;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.dWx = null;
        this.dWJ = null;
        this.dWJ = groupAddressLocateActivity;
        this.dWx = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx != null) {
            return this.dWx.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.dWx == null || i <= -1 || i >= this.dWx.length) ? "" : this.dWx[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a(this.dWJ);
            view2 = aVar.acD();
        } else {
            aVar = (a) view2.getTag();
        }
        if (aVar.aBv() != null) {
            if (i + 1 == getCount()) {
                aVar.aBv().setVisibility(8);
            } else {
                aVar.aBv().setVisibility(0);
            }
        }
        aVar.na(getItem(i).toString());
        if (this.dWJ.getSelectedPosition() == i) {
            aVar.gR(true);
        } else {
            aVar.gR(false);
        }
        aA(view2);
        return view2;
    }

    private void aA(View view2) {
        this.dWJ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dWJ.getLayoutMode().u(view2);
    }
}
