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

    public a(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(R.string.frs_all).toString();
        this.d = this.a.getText(R.string.frs_good).toString();
        a();
    }

    private void a() {
        int i = 0;
        if (this.b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.a.s sVar = new com.baidu.tieba.a.s();
        sVar.a(-1);
        sVar.a(this.c);
        com.baidu.tieba.a.s sVar2 = new com.baidu.tieba.a.s();
        sVar2.a(0);
        sVar2.a(this.d);
        arrayList.add(sVar);
        arrayList.add(sVar2);
        if (this.b != null && this.b.size() > 0) {
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    break;
                }
                com.baidu.tieba.a.s sVar3 = (com.baidu.tieba.a.s) this.b.get(i2);
                if (sVar3.b() != 0) {
                    arrayList.add(sVar3);
                }
                i = i2 + 1;
            }
        }
        this.b = arrayList;
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        a();
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
                view = LayoutInflater.from(this.a).inflate(R.layout.dialog_good_item, (ViewGroup) null);
                b bVar2 = new b(this, null);
                bVar2.a = (TextView) view.findViewById(R.id.frs_dia_good_text);
                view.setTag(bVar2);
                bVar = bVar2;
                view3 = view;
            } else {
                bVar = (b) view.getTag();
                view3 = view;
            }
            try {
                Object item = getItem(i);
                if (item == null) {
                    return view3;
                }
                bVar.a.setText(((com.baidu.tieba.a.s) item).a());
                return view3;
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.c.ae.b(getClass().getName(), "", "DialogGoodAdapter.getView error = " + exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }
}
