package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    private String[] aUl;
    private GroupAddressEditActivity aUn;

    public r(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.aUl = null;
        this.aUn = null;
        this.aUn = groupAddressEditActivity;
        this.aUl = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aUl != null) {
            return this.aUl.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.aUl == null || i <= -1 || i >= this.aUl.length) ? "" : this.aUl[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.aUn);
            view = aVar.KO();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.fL(getItem(i).toString());
        if (this.aUn.LU() == i) {
            aVar.cO(true);
        } else {
            aVar.cO(false);
        }
        F(view);
        return view;
    }

    private void F(View view) {
        this.aUn.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aUn.getLayoutMode().h(view);
    }
}
