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
public final class au extends BaseAdapter {
    private Context a;
    private ArrayList<com.baidu.tieba.data.z> b;
    private String c;
    private int d = 0;
    private int e = 0;

    public au(Context context, ArrayList<com.baidu.tieba.data.z> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(R.string.frs_good).toString();
        a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public final void a(ArrayList<com.baidu.tieba.data.z> arrayList) {
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
    public final int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        av avVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.dialog_good_item, (ViewGroup) null);
                try {
                    avVar = new av(this, (byte) 0);
                    avVar.a = (TextView) view3.findViewById(R.id.frs_dia_good_text);
                    avVar.b = (ImageView) view3.findViewById(R.id.frs_dia_divider);
                    avVar.c = (ImageView) view3.findViewById(R.id.frs_btm_divider);
                    avVar.d = (ImageView) view3.findViewById(R.id.frs_btm_divider_s);
                    view3.setTag(avVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "", "DialogGoodAdapter.getView error = " + exc.getMessage());
                    return view2;
                }
            } else {
                avVar = (av) view.getTag();
                view3 = view;
            }
            if (TiebaApplication.g().ae() == 1) {
                avVar.b.setBackgroundResource(R.color.frs_goodheader_line_1);
                avVar.c.setBackgroundResource(R.color.frs_goodheader_line_1);
                if (this.e == i) {
                    avVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text_S_1));
                    avVar.d.setVisibility(0);
                    avVar.d.setBackgroundResource(R.color.frs_goodheader_line_S_1);
                } else {
                    avVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text_1));
                    avVar.d.setVisibility(8);
                }
            } else {
                avVar.b.setBackgroundResource(R.color.frs_goodheader_line);
                avVar.c.setBackgroundResource(R.color.frs_goodheader_line);
                if (this.e == i) {
                    avVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text_S));
                    avVar.d.setVisibility(0);
                    avVar.d.setBackgroundResource(R.color.frs_goodheader_line_S);
                } else {
                    avVar.a.setTextColor(this.a.getResources().getColor(R.color.frs_goodheader_text));
                    avVar.d.setVisibility(8);
                }
            }
            if (i % 4 == 3 || i == getCount() - 1) {
                avVar.b.setVisibility(4);
            } else {
                avVar.b.setVisibility(0);
            }
            if (i / 4 == (getCount() - 1) / 4) {
                avVar.c.setVisibility(8);
            } else {
                avVar.c.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            avVar.a.setText(((com.baidu.tieba.data.z) item).a());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public final void a(int i) {
        this.e = i;
    }
}
