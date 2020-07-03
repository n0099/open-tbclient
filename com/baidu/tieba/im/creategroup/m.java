package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes10.dex */
public class m extends BaseAdapter {
    private String[] iPk;
    private GroupAddressLocateActivity iPw;

    public m(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.iPk = null;
        this.iPw = null;
        this.iPw = groupAddressLocateActivity;
        this.iPk = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iPk != null) {
            return this.iPk.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.iPk == null || i <= -1 || i >= this.iPk.length) ? "" : this.iPk[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.iPw);
            view = aVar.byQ();
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.cnZ() != null) {
            if (i + 1 == getCount()) {
                aVar.cnZ().setVisibility(8);
            } else {
                aVar.cnZ().setVisibility(0);
            }
        }
        aVar.Gz(getItem(i).toString());
        if (this.iPw.getSelectedPosition() == i) {
            aVar.pc(true);
        } else {
            aVar.pc(false);
        }
        cg(view);
        return view;
    }

    private void cg(View view) {
        this.iPw.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iPw.getLayoutMode().onModeChanged(view);
    }
}
