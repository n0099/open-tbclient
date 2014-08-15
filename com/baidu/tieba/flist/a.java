package com.baidu.tieba.flist;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    b a;
    Activity b;
    private com.baidu.tieba.square.w c;
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
            com.baidu.tieba.square.w wVar = this.c.e.get(i);
            this.a = (b) view.getTag();
            if (wVar != null) {
                a(this.a, wVar, view, i);
            }
        }
        return view;
    }

    public void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.square.w wVar) {
        this.c = wVar;
    }

    public com.baidu.tieba.square.w a() {
        return this.c;
    }

    private View b() {
        View inflate = this.b.getLayoutInflater().inflate(com.baidu.tieba.v.forum_list_dir_menu_item, (ViewGroup) null);
        this.a = new b(this);
        this.a.a = (ImageView) inflate.findViewById(com.baidu.tieba.u.menu_choose);
        this.a.b = (TextView) inflate.findViewById(com.baidu.tieba.u.menu_name);
        inflate.setTag(this.a);
        return inflate;
    }

    private void a(b bVar, com.baidu.tieba.square.w wVar, View view, int i) {
        if (bVar != null && wVar != null) {
            bVar.b.setText("");
            if (i == 0) {
                bVar.b.setText(String.valueOf(this.b.getString(com.baidu.tieba.x.forum_list_menu_all)) + wVar.b);
            } else {
                bVar.b.setText(wVar.b);
            }
            if (i != this.d) {
                bVar.a.setVisibility(4);
                bVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.forum_list_menu_notselected));
                return;
            }
            bVar.a.setVisibility(0);
            bVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.forum_list_menu_selected));
        }
    }
}
