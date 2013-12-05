package com.baidu.tieba.frs;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ap extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1372a;
    private ArrayList<com.baidu.tieba.data.z> b;
    private String c;
    private int d = 0;
    private int e = 0;

    public ap(Context context, ArrayList<com.baidu.tieba.data.z> arrayList) {
        this.f1372a = context;
        this.b = arrayList;
        this.c = this.f1372a.getText(R.string.frs_good).toString();
        a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.z> arrayList) {
        this.b = arrayList;
        a();
    }

    private void a() {
        int i = 0;
        if (this.b != null) {
            ArrayList<com.baidu.tieba.data.z> arrayList = new ArrayList<>();
            com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
            zVar.a(0);
            zVar.a(this.c);
            arrayList.add(zVar);
            if (this.b != null && this.b.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b.size()) {
                        break;
                    }
                    com.baidu.tieba.data.z zVar2 = this.b.get(i2);
                    if (zVar2.b() != 0) {
                        arrayList.add(zVar2);
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
        ar arVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f1372a).inflate(R.layout.dialog_good_item, (ViewGroup) null);
                try {
                    arVar = new ar(this);
                    arVar.f1373a = (TextView) view3.findViewById(R.id.frs_dia_good_text);
                    arVar.b = (ImageView) view3.findViewById(R.id.frs_dia_divider);
                    arVar.c = (ImageView) view3.findViewById(R.id.frs_btm_divider);
                    arVar.d = (ImageView) view3.findViewById(R.id.frs_btm_divider_s);
                    view3.setTag(arVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.util.bd.b(getClass().getName(), "", "DialogGoodAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                arVar = (ar) view.getTag();
                view3 = view;
            }
            if (TiebaApplication.h().an() == 1) {
                arVar.b.setBackgroundResource(R.color.frs_goodheader_line_1);
                arVar.c.setBackgroundResource(R.color.frs_goodheader_line_1);
                if (this.e == i) {
                    arVar.f1373a.setTextColor(this.f1372a.getResources().getColor(R.color.frs_goodheader_text_S_1));
                    arVar.d.setVisibility(0);
                    arVar.d.setBackgroundResource(R.color.frs_goodheader_line_S_1);
                } else {
                    arVar.f1373a.setTextColor(this.f1372a.getResources().getColor(R.color.frs_goodheader_text_1));
                    arVar.d.setVisibility(8);
                }
            } else {
                arVar.b.setBackgroundResource(R.color.frs_goodheader_line);
                arVar.c.setBackgroundResource(R.color.frs_goodheader_line);
                if (this.e == i) {
                    arVar.f1373a.setTextColor(this.f1372a.getResources().getColor(R.color.frs_goodheader_text_S));
                    arVar.d.setVisibility(0);
                    arVar.d.setBackgroundResource(R.color.frs_goodheader_line_S);
                } else {
                    arVar.f1373a.setTextColor(this.f1372a.getResources().getColor(R.color.frs_goodheader_text));
                    arVar.d.setVisibility(8);
                }
            }
            if (i % 4 == 3 || i == getCount() - 1) {
                arVar.b.setVisibility(4);
            } else {
                arVar.b.setVisibility(0);
            }
            if (i / 4 == (getCount() - 1) / 4) {
                arVar.c.setVisibility(8);
            } else {
                arVar.c.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            arVar.f1373a.setText(((com.baidu.tieba.data.z) item).a());
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
