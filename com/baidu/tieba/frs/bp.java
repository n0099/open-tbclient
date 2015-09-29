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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bp extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.core.data.j> Xf;
    private String aVY;
    private int aVZ = 0;
    private Context mContext;

    public bp(Context context, ArrayList<com.baidu.tbadk.core.data.j> arrayList) {
        this.mContext = context;
        this.Xf = arrayList;
        this.aVY = this.mContext.getText(i.h.frs_good).toString();
        LE();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.j> arrayList) {
        this.Xf = arrayList;
        LE();
    }

    private void LE() {
        int i = 0;
        if (this.Xf != null) {
            ArrayList<com.baidu.tbadk.core.data.j> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.bt(0);
            jVar.ci(this.aVY);
            arrayList.add(jVar);
            if (this.Xf != null && this.Xf.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Xf.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.j jVar2 = this.Xf.get(i2);
                    if (jVar2.rE() != 0) {
                        arrayList.add(jVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.Xf = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xf == null) {
            return 0;
        }
        return this.Xf.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        a aVar;
        View view3;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.mContext).inflate(i.g.dialog_good_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.aEt = (TextView) view3.findViewById(i.f.frs_dia_good_text);
                    aVar.aWa = (ImageView) view3.findViewById(i.f.frs_dia_divider);
                    aVar.aWb = (ImageView) view3.findViewById(i.f.frs_btm_divider);
                    aVar.aWc = (ImageView) view3.findViewById(i.f.frs_btm_divider_s);
                    view3.setTag(aVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    return view2;
                }
            } else {
                aVar = (a) view.getTag();
                view3 = view;
            }
            com.baidu.tbadk.core.util.am.i(aVar.aWa, i.c.frs_goodheader_line);
            com.baidu.tbadk.core.util.am.i(aVar.aWb, i.c.frs_goodheader_line);
            if (this.aVZ == i) {
                com.baidu.tbadk.core.util.am.b(aVar.aEt, i.c.frs_goodheader_text_S, 1);
                aVar.aWc.setVisibility(0);
                com.baidu.tbadk.core.util.am.i(aVar.aWc, i.c.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.am.b(aVar.aEt, i.c.frs_goodheader_text, 1);
                aVar.aWc.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.aWa.setVisibility(4);
            } else {
                aVar.aWa.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.aWb.setVisibility(8);
            } else {
                aVar.aWb.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aEt.setText(((com.baidu.tbadk.core.data.j) item).rD());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aEt;
        ImageView aWa;
        ImageView aWb;
        ImageView aWc;

        private a() {
        }

        /* synthetic */ a(bp bpVar, a aVar) {
            this();
        }
    }

    public void fw(int i) {
        this.aVZ = i;
    }
}
