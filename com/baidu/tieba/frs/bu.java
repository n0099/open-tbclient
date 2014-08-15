package com.baidu.tieba.frs;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bu extends BaseAdapter {
    private Context a;
    private ArrayList<com.baidu.tbadk.core.data.h> b;
    private String c;
    private int d = 0;

    public bu(Context context, ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        this.a = context;
        this.b = arrayList;
        this.c = this.a.getText(com.baidu.tieba.x.frs_good).toString();
        a();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        this.b = arrayList;
        a();
    }

    private void a() {
        int i = 0;
        if (this.b != null) {
            ArrayList<com.baidu.tbadk.core.data.h> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
            hVar.a(0);
            hVar.a(this.c);
            arrayList.add(hVar);
            if (this.b != null && this.b.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.h hVar2 = this.b.get(i2);
                    if (hVar2.b() != 0) {
                        arrayList.add(hVar2);
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
        bv bvVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.dialog_good_item, (ViewGroup) null);
                try {
                    bvVar = new bv(this, null);
                    bvVar.a = (TextView) view3.findViewById(com.baidu.tieba.u.frs_dia_good_text);
                    bvVar.b = (ImageView) view3.findViewById(com.baidu.tieba.u.frs_dia_divider);
                    bvVar.c = (ImageView) view3.findViewById(com.baidu.tieba.u.frs_btm_divider);
                    bvVar.d = (ImageView) view3.findViewById(com.baidu.tieba.u.frs_btm_divider_s);
                    view3.setTag(bvVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    return view2;
                }
            } else {
                bvVar = (bv) view.getTag();
                view3 = view;
            }
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                bvVar.b.setBackgroundResource(com.baidu.tieba.r.frs_goodheader_line_1);
                bvVar.c.setBackgroundResource(com.baidu.tieba.r.frs_goodheader_line_1);
                if (this.d == i) {
                    bvVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.frs_goodheader_text_S_1));
                    bvVar.d.setVisibility(0);
                    bvVar.d.setBackgroundResource(com.baidu.tieba.r.frs_goodheader_line_S_1);
                } else {
                    bvVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.frs_goodheader_text_1));
                    bvVar.d.setVisibility(8);
                }
            } else {
                bvVar.b.setBackgroundResource(com.baidu.tieba.r.frs_goodheader_line);
                bvVar.c.setBackgroundResource(com.baidu.tieba.r.frs_goodheader_line);
                if (this.d == i) {
                    bvVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.frs_goodheader_text_S));
                    bvVar.d.setVisibility(0);
                    bvVar.d.setBackgroundResource(com.baidu.tieba.r.frs_goodheader_line_S);
                } else {
                    bvVar.a.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.frs_goodheader_text));
                    bvVar.d.setVisibility(8);
                }
            }
            if (i % 4 == 3 || i == getCount() - 1) {
                bvVar.b.setVisibility(4);
            } else {
                bvVar.b.setVisibility(0);
            }
            if (i / 4 == (getCount() - 1) / 4) {
                bvVar.c.setVisibility(8);
            } else {
                bvVar.c.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            bvVar.a.setText(((com.baidu.tbadk.core.data.h) item).a());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void a(int i) {
        this.d = i;
    }
}
