package com.baidu.tieba.flist;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    b f1054a;
    Activity b;
    private com.baidu.tieba.square.s c;
    private int d = 0;

    public a(Activity activity) {
        this.b = activity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.c.e == null) {
            return 0;
        }
        return this.c.e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || this.c.e == null) {
            return null;
        }
        return this.c.e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = b();
        }
        if (this.c != null) {
            com.baidu.tieba.square.s sVar = this.c.e.get(i);
            this.f1054a = (b) view.getTag();
            if (sVar != null) {
                a(this.f1054a, sVar, view, i);
            }
        }
        return view;
    }

    public void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.square.s sVar) {
        this.c = sVar;
    }

    public com.baidu.tieba.square.s a() {
        return this.c;
    }

    private View b() {
        View inflate = this.b.getLayoutInflater().inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.f1054a = new b(this);
        this.f1054a.f1055a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f1054a.b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f1054a);
        return inflate;
    }

    private void a(b bVar, com.baidu.tieba.square.s sVar, View view, int i) {
        if (bVar != null && sVar != null) {
            bVar.b.setText("");
            if (i == 0) {
                bVar.b.setText(String.valueOf(this.b.getString(R.string.forum_list_menu_all)) + sVar.b);
            } else {
                bVar.b.setText(sVar.b);
            }
            if (i != this.d) {
                bVar.f1055a.setVisibility(4);
                bVar.b.setTextColor(this.b.getResources().getColor(R.color.forum_list_menu_notselected));
                return;
            }
            bVar.f1055a.setVisibility(0);
            bVar.b.setTextColor(this.b.getResources().getColor(R.color.forum_list_menu_selected));
        }
    }
}
