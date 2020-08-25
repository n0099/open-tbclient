package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes17.dex */
public class m extends BaseAdapter {
    private GroupAddressLocateActivity jlA;
    private String[] jlo;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.jlo = null;
        this.jlA = null;
        this.jlA = groupAddressLocateActivity;
        this.jlo = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jlo != null) {
            return this.jlo.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.jlo == null || i <= -1 || i >= this.jlo.length) ? "" : this.jlo[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.jlA);
            view = aVar.bLz();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cCx() != null) {
            if (i + 1 == getCount()) {
                aVar.cCx().setVisibility(8);
            } else {
                aVar.cCx().setVisibility(0);
            }
        }
        aVar.Kf(getItem(i).toString());
        if (this.jlA.getSelectedPosition() == i) {
            aVar.qo(true);
        } else {
            aVar.qo(false);
        }
        co(view);
        return view;
    }

    private void co(View view) {
        this.jlA.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jlA.getLayoutMode().onModeChanged(view);
    }
}
