package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity eEL;
    private String[] eEz;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.eEz = null;
        this.eEL = null;
        this.eEL = groupAddressLocateActivity;
        this.eEz = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eEz != null) {
            return this.eEz.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.eEz == null || i <= -1 || i >= this.eEz.length) ? "" : this.eEz[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.eEL);
            view = aVar.amt();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.aNz() != null) {
            if (i + 1 == getCount()) {
                aVar.aNz().setVisibility(8);
            } else {
                aVar.aNz().setVisibility(0);
            }
        }
        aVar.pa(getItem(i).toString());
        if (this.eEL.getSelectedPosition() == i) {
            aVar.ia(true);
        } else {
            aVar.ia(false);
        }
        aW(view);
        return view;
    }

    private void aW(View view) {
        this.eEL.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eEL.getLayoutMode().onModeChanged(view);
    }
}
