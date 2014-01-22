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
public class al extends BaseAdapter {
    private Context a;
    private ArrayList<com.baidu.tieba.data.aa> b;
    private String c;
    private int d = 0;
    private int e = 0;

    public al(Context context, ArrayList<com.baidu.tieba.data.aa> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(R.string.frs_good).toString();
        a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.aa> arrayList) {
        this.b = arrayList;
        a();
    }

    private void a() {
        int i = 0;
        if (this.b != null) {
            ArrayList<com.baidu.tieba.data.aa> arrayList = new ArrayList<>();
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
                    com.baidu.tieba.data.aa aaVar2 = this.b.get(i2);
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
        an anVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.dialog_good_item, (ViewGroup) null);
                try {
                    anVar = new an(this);
                    anVar.a = (TextView) view3.findViewById(R.id.frs_dia_good_text);
                    anVar.b = (ImageView) view3.findViewById(R.id.frs_dia_divider);
                    anVar.c = (ImageView) view3.findViewById(R.id.frs_btm_divider);
                    anVar.d = (ImageView) view3.findViewById(R.id.frs_btm_divider_s);
                    view3.setTag(anVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "", "DialogGoodAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                anVar = (an) view.getTag();
                view3 = view;
            }
            if (TiebaApplication.h().al() == 1) {
                anVar.b.setBackgroundResource(R.color.frs_goodheader_line_1);
                anVar.c.setBackgroundResource(R.color.frs_goodheader_line_1);
                if (this.e == i) {
                    anVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text_S_1));
                    anVar.d.setVisibility(0);
                    anVar.d.setBackgroundResource(R.color.frs_goodheader_line_S_1);
                } else {
                    anVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text_1));
                    anVar.d.setVisibility(8);
                }
            } else {
                anVar.b.setBackgroundResource(R.color.frs_goodheader_line);
                anVar.c.setBackgroundResource(R.color.frs_goodheader_line);
                if (this.e == i) {
                    anVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text_S));
                    anVar.d.setVisibility(0);
                    anVar.d.setBackgroundResource(R.color.frs_goodheader_line_S);
                } else {
                    anVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text));
                    anVar.d.setVisibility(8);
                }
            }
            if (i % 4 == 3 || i == getCount() - 1) {
                anVar.b.setVisibility(4);
            } else {
                anVar.b.setVisibility(0);
            }
            if (i / 4 == (getCount() - 1) / 4) {
                anVar.c.setVisibility(8);
            } else {
                anVar.c.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            anVar.a.setText(((com.baidu.tieba.data.aa) item).a());
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
