package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class r extends BaseAdapter {
    private GroupAddressEditActivity aUB;
    private String[] aUz;

    public r(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.aUz = null;
        this.aUB = null;
        this.aUB = groupAddressEditActivity;
        this.aUz = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aUz != null) {
            return this.aUz.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.aUz == null || i <= -1 || i >= this.aUz.length) ? "" : this.aUz[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.aUB);
            view = aVar.KS();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.fL(getItem(i).toString());
        if (this.aUB.LY() == i) {
            aVar.cO(true);
        } else {
            aVar.cO(false);
        }
        F(view);
        return view;
    }

    private void F(View view) {
        this.aUB.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aUB.getLayoutMode().h(view);
    }
}
