package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    private String[] hxe;
    private GroupAddressLocateActivity hxq;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.hxe = null;
        this.hxq = null;
        this.hxq = groupAddressLocateActivity;
        this.hxe = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxe != null) {
            return this.hxe.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hxe == null || i <= -1 || i >= this.hxe.length) ? "" : this.hxe[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hxq);
            view = aVar.bgF();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.bSL() != null) {
            if (i + 1 == getCount()) {
                aVar.bSL().setVisibility(8);
            } else {
                aVar.bSL().setVisibility(0);
            }
        }
        aVar.CC(getItem(i).toString());
        if (this.hxq.getSelectedPosition() == i) {
            aVar.nm(true);
        } else {
            aVar.nm(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.hxq.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hxq.getLayoutMode().onModeChanged(view);
    }
}
