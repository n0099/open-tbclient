package com.baidu.tieba.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ao extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private String c;

    public ao(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(R.string.forum).toString();
    }

    public void a(int i) {
        this.b.remove(i);
        this.b.add(0, (String) this.b.get(i));
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
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
        ap apVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                try {
                    apVar = new ap(this, null);
                    apVar.a = (TextView) view3.findViewById(R.id.home_lv_search_forum);
                    view3.setTag(apVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.c.ae.b(getClass().getName(), "", "PbAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                apVar = (ap) view.getTag();
                view3 = view;
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            apVar.a.setText(((String) item).concat(this.c));
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }
}
