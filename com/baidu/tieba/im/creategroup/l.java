package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes17.dex */
public class l extends BaseAdapter {
    private String[] jlu;
    private GroupAddressEditActivity jlw;

    public l(GroupAddressEditActivity groupAddressEditActivity, String[] strArr) {
        this.jlu = null;
        this.jlw = null;
        this.jlw = groupAddressEditActivity;
        this.jlu = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jlu != null) {
            return this.jlu.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.jlu == null || i <= -1 || i >= this.jlu.length) ? "" : this.jlu[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.jlw);
            view = aVar.bLA();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.Kg(getItem(i).toString());
        if (this.jlw.cDC() == i) {
            aVar.qq(true);
        } else {
            aVar.qq(false);
        }
        co(view);
        return view;
    }

    private void co(View view) {
        this.jlw.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jlw.getLayoutMode().onModeChanged(view);
    }
}
