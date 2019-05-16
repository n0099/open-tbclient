package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private String[] gxp;
    private GroupAddressEditActivity gxr;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.gxp = null;
        this.gxr = null;
        this.gxr = groupAddressEditActivity;
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
            aVar = new a(this.gxr);
            view = aVar.aUT();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.xO(getItem(i).toString());
        if (this.gxr.bzu() == i) {
            aVar.lE(true);
        } else {
            aVar.lE(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.gxr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gxr.getLayoutMode().onModeChanged(view);
    }
}
