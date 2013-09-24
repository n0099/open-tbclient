package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class am extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1204a;
    private ArrayList<String> b;
    private String c;
    private boolean d = true;

    public am(Context context, ArrayList<String> arrayList) {
        this.f1204a = context;
        this.b = arrayList;
        this.c = this.f1204a.getText(R.string.forum).toString();
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
        an anVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f1204a).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                try {
                    anVar = new an(this, null);
                    anVar.f1205a = (TextView) view3.findViewById(R.id.home_lv_search_forum);
                    view3.setTag(anVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    av.b(getClass().getName(), "", "SearchAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                anVar = (an) view.getTag();
                view3 = view;
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            com.baidu.tieba.util.as.b(anVar.f1205a, TiebaApplication.g().ap());
            String str = (String) item;
            if (this.d) {
                anVar.f1205a.setText(str.concat(this.c));
                return view3;
            }
            anVar.f1205a.setText(str);
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }
}
