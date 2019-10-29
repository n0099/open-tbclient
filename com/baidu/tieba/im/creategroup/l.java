package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes5.dex */
public class l extends BaseAdapter {
    private String[] gEm;
    private GroupAddressEditActivity gEo;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.gEm = null;
        this.gEo = null;
        this.gEo = groupAddressEditActivity;
        this.gEm = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gEm != null) {
            return this.gEm.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.gEm == null || i <= -1 || i >= this.gEm.length) ? "" : this.gEm[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.gEo);
            view = aVar.aMx();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.xt(getItem(i).toString());
        if (this.gEo.bzQ() == i) {
            aVar.lK(true);
        } else {
            aVar.lK(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.gEo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gEo.getLayoutMode().onModeChanged(view);
    }
}
