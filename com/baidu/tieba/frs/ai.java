package com.baidu.tieba.frs;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1071a;
    private ArrayList b;
    private String c;
    private int d = 0;
    private int e = 0;

    public ai(Context context, ArrayList arrayList) {
        this.f1071a = context;
        this.b = arrayList;
        this.c = this.f1071a.getText(R.string.frs_good).toString();
        a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void a(ArrayList arrayList) {
        this.b = arrayList;
        a();
    }

    private void a() {
        int i = 0;
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            com.baidu.tieba.data.aa aaVar = new com.baidu.tieba.data.aa();
            aaVar.a(0);
            aaVar.a(this.c);
            arrayList.add(aaVar);
            if (this.b != null && this.b.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b.size()) {
                        break;
                    }
                    com.baidu.tieba.data.aa aaVar2 = (com.baidu.tieba.data.aa) this.b.get(i2);
                    if (aaVar2.b() != 0) {
                        arrayList.add(aaVar2);
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
        aj ajVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f1071a).inflate(R.layout.dialog_good_item, (ViewGroup) null);
                try {
                    ajVar = new aj(this, null);
                    ajVar.f1072a = (TextView) view3.findViewById(R.id.frs_dia_good_text);
                    ajVar.b = (ImageView) view3.findViewById(R.id.frs_dia_divider);
                    view3.setTag(ajVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.util.aq.b(getClass().getName(), "", "DialogGoodAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                ajVar = (aj) view.getTag();
                view3 = view;
            }
            if (this.d == 1) {
                ajVar.b.setBackgroundColor(-14078410);
                if (this.e == i) {
                    ajVar.f1072a.setTextColor(-11433787);
                } else {
                    ajVar.f1072a.setTextColor(-10523526);
                }
            } else {
                ajVar.b.setBackgroundColor(-8947849);
                if (this.e == i) {
                    ajVar.f1072a.setTextColor(-12809526);
                } else {
                    ajVar.f1072a.setTextColor(-8947849);
                }
            }
            if (this.e == i) {
                ajVar.f1072a.setTextColor(-12809526);
            } else {
                ajVar.f1072a.setTextColor(-8947849);
            }
            if (i % 4 == 3 || i == getCount() - 1) {
                ajVar.b.setVisibility(4);
            } else {
                ajVar.b.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            ajVar.f1072a.setText(((com.baidu.tieba.data.aa) item).a());
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
