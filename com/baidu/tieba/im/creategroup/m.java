package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity gxB;
    private String[] gxp;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.gxp = null;
        this.gxB = null;
        this.gxB = groupAddressLocateActivity;
        this.gxp = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gxp != null) {
            return this.gxp.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gxp == null || i <= -1 || i >= this.gxp.length) ? "" : this.gxp[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gxB);
            view = aVar.aUT();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.byp() != null) {
            if (i + 1 == getCount()) {
                aVar.byp().setVisibility(8);
            } else {
                aVar.byp().setVisibility(0);
            }
        }
        aVar.xO(getItem(i).toString());
        if (this.gxB.getSelectedPosition() == i) {
            aVar.lE(true);
        } else {
            aVar.lE(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.gxB.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gxB.getLayoutMode().onModeChanged(view);
    }
}
