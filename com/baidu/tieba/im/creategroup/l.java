package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class l extends BaseAdapter {
    private String[] eQm;
    private GroupAddressEditActivity eQo;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.eQm = null;
        this.eQo = null;
        this.eQo = groupAddressEditActivity;
        this.eQm = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eQm != null) {
            return this.eQm.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eQm == null || i <= -1 || i >= this.eQm.length) ? "" : this.eQm[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eQo);
            view = aVar.anZ();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.pW(getItem(i).toString());
        if (this.eQo.aRg() == i) {
            aVar.ip(true);
        } else {
            aVar.ip(false);
        }
        bb(view);
        return view;
    }

    private void bb(View view) {
        this.eQo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eQo.getLayoutMode().onModeChanged(view);
    }
}
