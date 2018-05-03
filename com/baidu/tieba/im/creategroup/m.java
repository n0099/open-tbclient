package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity dVC;
    private String[] dVq;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.dVq = null;
        this.dVC = null;
        this.dVC = groupAddressLocateActivity;
        this.dVq = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dVq != null) {
            return this.dVq.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.dVq == null || i <= -1 || i >= this.dVq.length) ? "" : this.dVq[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a(this.dVC);
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
        if (this.dVC.getSelectedPosition() == i) {
            aVar.gQ(true);
        } else {
            aVar.gQ(false);
        }
        aA(view2);
        return view2;
    }

    private void aA(View view2) {
        this.dVC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.dVC.getLayoutMode().u(view2);
    }
}
