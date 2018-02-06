package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class n extends BaseAdapter {
    private String[] eAL;
    private GroupAddressLocateActivity eAX;

    public n(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.eAL = null;
        this.eAX = null;
        this.eAX = groupAddressLocateActivity;
        this.eAL = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eAL != null) {
            return this.eAL.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eAL == null || i <= -1 || i >= this.eAL.length) ? "" : this.eAL[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eAX);
            view = aVar.aix();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aGx() != null) {
            if (i + 1 == getCount()) {
                aVar.aGx().setVisibility(8);
            } else {
                aVar.aGx().setVisibility(0);
            }
        }
        aVar.mT(getItem(i).toString());
        if (this.eAX.getSelectedPosition() == i) {
            aVar.hl(true);
        } else {
            aVar.hl(false);
        }
        bU(view);
        return view;
    }

    private void bU(View view) {
        this.eAX.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eAX.getLayoutMode().aM(view);
    }
}
