package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context a;
    private ArrayList b;
    private String c;
    private String d;
    private int e = 0;

    public a(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(R.string.frs_all).toString();
        this.d = this.a.getText(R.string.frs_good).toString();
        a();
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        a();
    }

    private void a() {
        int i = 0;
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.a.t tVar = new com.baidu.tieba.a.t();
            tVar.a(-1);
            tVar.a(this.c);
            com.baidu.tieba.a.t tVar2 = new com.baidu.tieba.a.t();
            tVar2.a(0);
            tVar2.a(this.d);
            arrayList.add(tVar);
            arrayList.add(tVar2);
            if (this.b != null && this.b.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b.size()) {
                        break;
                    }
                    com.baidu.tieba.a.t tVar3 = (com.baidu.tieba.a.t) this.b.get(i2);
                    if (tVar3.b() != 0) {
                        arrayList.add(tVar3);
                    }
                    i = i2 + 1;
                }
            }
            this.b = arrayList;
        }
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
        b bVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.dialog_good_item, (ViewGroup) null);
                try {
                    bVar = new b(this, null);
                    bVar.a = (TextView) view3.findViewById(R.id.frs_dia_good_text);
                    view3.setTag(bVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.c.ag.b(getClass().getName(), "", "DialogGoodAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                bVar = (b) view.getTag();
                view3 = view;
            }
            if (this.e == 1) {
                bVar.a.setTextColor(this.a.getResources().getColor(R.color.skin_1_common_color));
            } else {
                bVar.a.setTextColor(this.a.getResources().getColor(R.color.white));
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            bVar.a.setText(((com.baidu.tieba.a.t) item).a());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void a(int i) {
        this.e = i;
    }
}
