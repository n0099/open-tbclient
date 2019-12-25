package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes7.dex */
public class l extends BaseAdapter {
    private String[] hrA;
    private GroupAddressEditActivity hrC;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.hrA = null;
        this.hrC = null;
        this.hrC = groupAddressEditActivity;
        this.hrA = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hrA != null) {
            return this.hrA.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.hrA == null || i <= -1 || i >= this.hrA.length) ? "" : this.hrA[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.hrC);
            view = aVar.bdY();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Cc(getItem(i).toString());
        if (this.hrC.bRe() == i) {
            aVar.mY(true);
        } else {
            aVar.mY(false);
        }
        bS(view);
        return view;
    }

    private void bS(View view) {
        this.hrC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hrC.getLayoutMode().onModeChanged(view);
    }
}
