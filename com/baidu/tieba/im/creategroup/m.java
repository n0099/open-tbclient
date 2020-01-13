package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes8.dex */
public class m extends BaseAdapter {
    private String[] hvd;
    private GroupAddressLocateActivity hvp;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.hvd = null;
        this.hvp = null;
        this.hvp = groupAddressLocateActivity;
        this.hvd = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hvd != null) {
            return this.hvd.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hvd == null || i <= -1 || i >= this.hvd.length) ? "" : this.hvd[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hvp);
            view = aVar.bet();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.bRi() != null) {
            if (i + 1 == getCount()) {
                aVar.bRi().setVisibility(8);
            } else {
                aVar.bRi().setVisibility(0);
            }
        }
        aVar.Cm(getItem(i).toString());
        if (this.hvp.getSelectedPosition() == i) {
            aVar.nk(true);
        } else {
            aVar.nk(false);
        }
        bX(view);
        return view;
    }

    private void bX(View view) {
        this.hvp.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hvp.getLayoutMode().onModeChanged(view);
    }
}
