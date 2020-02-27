package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    private String[] hxc;
    private GroupAddressLocateActivity hxo;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.hxc = null;
        this.hxo = null;
        this.hxo = groupAddressLocateActivity;
        this.hxc = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxc != null) {
            return this.hxc.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hxc == null || i <= -1 || i >= this.hxc.length) ? "" : this.hxc[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hxo);
            view = aVar.bgD();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.bSJ() != null) {
            if (i + 1 == getCount()) {
                aVar.bSJ().setVisibility(8);
            } else {
                aVar.bSJ().setVisibility(0);
            }
        }
        aVar.CC(getItem(i).toString());
        if (this.hxo.getSelectedPosition() == i) {
            aVar.nm(true);
        } else {
            aVar.nm(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.hxo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hxo.getLayoutMode().onModeChanged(view);
    }
}
