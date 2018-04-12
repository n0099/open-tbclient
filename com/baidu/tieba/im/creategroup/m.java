package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity dVF;
    private String[] dVt;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.dVt = null;
        this.dVF = null;
        this.dVF = groupAddressLocateActivity;
        this.dVt = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dVt != null) {
            return this.dVt.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.dVt == null || i <= -1 || i >= this.dVt.length) ? "" : this.dVt[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a(this.dVF);
            view2 = aVar.acD();
        } else {
            aVar = (a) view2.getTag();
        }
        if (aVar.aBx() != null) {
            if (i + 1 == getCount()) {
                aVar.aBx().setVisibility(8);
            } else {
                aVar.aBx().setVisibility(0);
            }
        }
        aVar.mX(getItem(i).toString());
        if (this.dVF.getSelectedPosition() == i) {
            aVar.gQ(true);
        } else {
            aVar.gQ(false);
        }
        aA(view2);
        return view2;
    }

    private void aA(View view2) {
        this.dVF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dVF.getLayoutMode().u(view2);
    }
}
