package com.baidu.tieba.im.creategroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    private String[] a;
    private GroupAddressLocateActivity b;

    public t(GroupAddressLocateActivity groupAddressLocateActivity, String[] strArr) {
        this.a = null;
        this.b = null;
        this.b = groupAddressLocateActivity;
        this.a = strArr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a != null) {
            return this.a.length;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return (this.a == null || i <= -1 || i >= this.a.length) ? "" : this.a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this.b);
            view = aVar.a();
        } else {
            aVar = (a) view.getTag();
        }
        aVar.a(getItem(i).toString());
        if (this.b.c() == i) {
            aVar.a(true);
        } else {
            aVar.a(false);
        }
        a(view);
        return view;
    }

    private void a(View view) {
        this.b.getLayoutMode().a(TiebaApplication.g().al() == 1);
        this.b.getLayoutMode().a(view);
    }
}
