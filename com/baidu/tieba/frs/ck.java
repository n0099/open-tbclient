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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ck extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.core.data.p> YX;
    private String biW;
    private int biX = 0;
    private Context mContext;

    public ck(Context context, ArrayList<com.baidu.tbadk.core.data.p> arrayList) {
        this.mContext = context;
        this.YX = arrayList;
        this.biW = this.mContext.getText(t.j.frs_good).toString();
        PJ();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.p> arrayList) {
        this.YX = arrayList;
        PJ();
    }

    private void PJ() {
        int i = 0;
        if (this.YX != null) {
            ArrayList<com.baidu.tbadk.core.data.p> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
            pVar.bJ(0);
            pVar.cr(this.biW);
            arrayList.add(pVar);
            if (this.YX != null && this.YX.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.YX.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.p pVar2 = this.YX.get(i2);
                    if (pVar2.sl() != 0) {
                        arrayList.add(pVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.YX = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YX == null) {
            return 0;
        }
        return this.YX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.YX.get(i);
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
                view3 = LayoutInflater.from(this.mContext).inflate(t.h.dialog_good_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.aJa = (TextView) view3.findViewById(t.g.frs_dia_good_text);
                    aVar.biY = (ImageView) view3.findViewById(t.g.frs_dia_divider);
                    aVar.biZ = (ImageView) view3.findViewById(t.g.frs_btm_divider);
                    aVar.bja = (ImageView) view3.findViewById(t.g.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.ar.k(aVar.biY, t.d.frs_goodheader_line);
            com.baidu.tbadk.core.util.ar.k(aVar.biZ, t.d.frs_goodheader_line);
            if (this.biX == i) {
                com.baidu.tbadk.core.util.ar.b(aVar.aJa, t.d.frs_goodheader_text_S, 1);
                aVar.bja.setVisibility(0);
                com.baidu.tbadk.core.util.ar.k(aVar.bja, t.d.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.ar.b(aVar.aJa, t.d.frs_goodheader_text, 1);
                aVar.bja.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.biY.setVisibility(4);
            } else {
                aVar.biY.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.biZ.setVisibility(8);
            } else {
                aVar.biZ.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aJa.setText(((com.baidu.tbadk.core.data.p) item).sk());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aJa;
        ImageView biY;
        ImageView biZ;
        ImageView bja;

        private a() {
        }

        /* synthetic */ a(ck ckVar, a aVar) {
            this();
        }
    }

    public void gt(int i) {
        this.biX = i;
    }
}
