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
    b f1287a;
    Activity b;
    private com.baidu.tieba.square.z c;
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
            com.baidu.tieba.square.z zVar = this.c.e.get(i);
            this.f1287a = (b) view.getTag();
            if (zVar != null) {
                a(this.f1287a, zVar, view, i);
            }
        }
        return view;
    }

    public void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public void a(com.baidu.tieba.square.z zVar) {
        this.c = zVar;
    }

    public com.baidu.tieba.square.z a() {
        return this.c;
    }

    private View b() {
        View inflate = this.b.getLayoutInflater().inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.f1287a = new b(this);
        this.f1287a.f1298a = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.f1287a.b = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.f1287a);
        return inflate;
    }

    private void a(b bVar, com.baidu.tieba.square.z zVar, View view, int i) {
        if (bVar != null && zVar != null) {
            bVar.b.setText("");
            if (i == 0) {
                bVar.b.setText(this.b.getString(R.string.forum_list_menu_all) + zVar.b);
            } else {
                bVar.b.setText(zVar.b);
            }
            if (i != this.d) {
                bVar.f1298a.setVisibility(4);
                bVar.b.setTextColor(this.b.getResources().getColor(R.color.forum_list_menu_notselected));
                return;
            }
            bVar.f1298a.setVisibility(0);
            bVar.b.setTextColor(this.b.getResources().getColor(R.color.forum_list_menu_selected));
        }
    }
}
