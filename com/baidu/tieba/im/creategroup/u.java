package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private GroupAddressLocateActivity aUM;
    private String[] aUz;

    public u(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.aUz = null;
        this.aUM = null;
        this.aUM = groupAddressLocateActivity;
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
            aVar = new a(this.aUM);
            view = aVar.KS();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.fL(getItem(i).toString());
        if (this.aUM.sg() == i) {
            aVar.cO(true);
        } else {
            aVar.cO(false);
        }
        F(view);
        return view;
    }

    private void F(View view) {
        this.aUM.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.aUM.getLayoutMode().h(view);
    }
}
