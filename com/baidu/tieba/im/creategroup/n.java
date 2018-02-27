package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class n extends BaseAdapter {
    private GroupAddressLocateActivity eAL;
    private String[] eAz;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.eAz = null;
        this.eAL = null;
        this.eAL = groupAddressLocateActivity;
        this.eAz = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAz != null) {
            return this.eAz.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eAz == null || i <= -1 || i >= this.eAz.length) ? "" : this.eAz[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eAL);
            view = aVar.aiw();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aGw() != null) {
            if (i + 1 == getCount()) {
                aVar.aGw().setVisibility(8);
            } else {
                aVar.aGw().setVisibility(0);
            }
        }
        aVar.mT(getItem(i).toString());
        if (this.eAL.getSelectedPosition() == i) {
            aVar.hl(true);
        } else {
            aVar.hl(false);
        }
        bU(view);
        return view;
    }

    private void bU(View view) {
        this.eAL.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eAL.getLayoutMode().aM(view);
    }
}
