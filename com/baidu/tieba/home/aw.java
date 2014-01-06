package com.baidu.tieba.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aw extends BaseAdapter {
    private com.baidu.tieba.j a;
    private ArrayList<String> b;
    private String c;
    private boolean d = true;

    public aw(com.baidu.tieba.j jVar, ArrayList<String> arrayList) {
        this.a = jVar;
        this.b = arrayList;
        this.c = this.a.getText(R.string.forum).toString();
    }

    public void a(ArrayList<String> arrayList) {
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(int i) {
        this.b.remove(i);
        this.b.add(0, this.b.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        ay ayVar;
        View view3;
        Object item;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                try {
                    ayVar = new ay(this);
                    ayVar.a = (TextView) view3.findViewById(R.id.home_lv_search_forum);
                    view3.setTag(ayVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.util.bo.b(getClass().getName(), "", "SearchAdapter.getView error = " + exc.getMessage());
                    a(view2);
                    return view2;
                }
            } else {
                ayVar = (ay) view.getTag();
                view3 = view;
            }
            item = getItem(i);
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        if (item == null) {
            return view3;
        }
        com.baidu.tieba.util.bl.b(ayVar.a, TiebaApplication.g().an());
        String str = (String) item;
        if (this.d) {
            ayVar.a.setText(str.concat(this.c));
        } else {
            ayVar.a.setText(str);
        }
        view2 = view3;
        a(view2);
        return view2;
    }

    private void a(View view) {
        int an = TiebaApplication.g().an();
        this.a.getLayoutMode().a(an == 1);
        this.a.getLayoutMode().a(view);
        View findViewById = view.findViewById(R.id.parent);
        if (an == 1) {
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.common_list_item_bg_selector_1);
            }
        } else if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.common_list_item_bg_selector);
        }
    }
}
