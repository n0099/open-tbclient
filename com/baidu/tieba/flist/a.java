package com.baidu.tieba.flist;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class a extends BaseAdapter {
    b a;
    Activity b;
    private com.baidu.tieba.square.ab c;
    private int d = 0;

    public a(Activity activity) {
        this.b = activity;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null || this.c.e == null) {
            return 0;
        }
        return this.c.e.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.c == null || this.c.e == null) {
            return null;
        }
        return this.c.e.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.b.getLayoutInflater().inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
            this.a = new b(this);
            this.a.a = (ImageView) view.findViewById(R.id.menu_choose);
            this.a.b = (TextView) view.findViewById(R.id.menu_name);
            view.setTag(this.a);
        }
        if (this.c != null) {
            com.baidu.tieba.square.ab abVar = this.c.e.get(i);
            this.a = (b) view.getTag();
            if (abVar != null && (bVar = this.a) != null && abVar != null) {
                bVar.b.setText("");
                if (i == 0) {
                    bVar.b.setText(String.valueOf(this.b.getString(R.string.forum_list_menu_all)) + abVar.b);
                } else {
                    bVar.b.setText(abVar.b);
                }
                if (i != this.d) {
                    bVar.a.setVisibility(4);
                    bVar.b.setTextColor(this.b.getResources().getColor(R.color.forum_list_menu_notselected));
                } else {
                    bVar.a.setVisibility(0);
                    bVar.b.setTextColor(this.b.getResources().getColor(R.color.forum_list_menu_selected));
                }
            }
        }
        return view;
    }

    public final void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public final void a(com.baidu.tieba.square.ab abVar) {
        this.c = abVar;
    }

    public final com.baidu.tieba.square.ab a() {
        return this.c;
    }
}
