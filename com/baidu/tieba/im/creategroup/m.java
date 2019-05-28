package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity gxC;
    private String[] gxq;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.gxq = null;
        this.gxC = null;
        this.gxC = groupAddressLocateActivity;
        this.gxq = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gxq != null) {
            return this.gxq.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gxq == null || i <= -1 || i >= this.gxq.length) ? "" : this.gxq[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gxC);
            view = aVar.aUW();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.bys() != null) {
            if (i + 1 == getCount()) {
                aVar.bys().setVisibility(8);
            } else {
                aVar.bys().setVisibility(0);
            }
        }
        aVar.xO(getItem(i).toString());
        if (this.gxC.getSelectedPosition() == i) {
            aVar.lE(true);
        } else {
            aVar.lE(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.gxC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gxC.getLayoutMode().onModeChanged(view);
    }
}
