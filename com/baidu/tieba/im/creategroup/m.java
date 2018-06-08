package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String[] ehK;
    private GroupAddressLocateActivity ehW;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.ehK = null;
        this.ehW = null;
        this.ehW = groupAddressLocateActivity;
        this.ehK = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ehK != null) {
            return this.ehK.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.ehK == null || i <= -1 || i >= this.ehK.length) ? "" : this.ehK[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.ehW);
            view = aVar.aga();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aGq() != null) {
            if (i + 1 == getCount()) {
                aVar.aGq().setVisibility(8);
            } else {
                aVar.aGq().setVisibility(0);
            }
        }
        aVar.nM(getItem(i).toString());
        if (this.ehW.getSelectedPosition() == i) {
            aVar.gX(true);
        } else {
            aVar.gX(false);
        }
        aD(view);
        return view;
    }

    private void aD(View view) {
        this.ehW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ehW.getLayoutMode().onModeChanged(view);
    }
}
