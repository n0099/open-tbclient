package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String[] eQm;
    private GroupAddressLocateActivity eQy;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.eQm = null;
        this.eQy = null;
        this.eQy = groupAddressLocateActivity;
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
            aVar = new a(this.eQy);
            view = aVar.anZ();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aQb() != null) {
            if (i + 1 == getCount()) {
                aVar.aQb().setVisibility(8);
            } else {
                aVar.aQb().setVisibility(0);
            }
        }
        aVar.pW(getItem(i).toString());
        if (this.eQy.getSelectedPosition() == i) {
            aVar.ip(true);
        } else {
            aVar.ip(false);
        }
        bb(view);
        return view;
    }

    private void bb(View view) {
        this.eQy.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eQy.getLayoutMode().onModeChanged(view);
    }
}
