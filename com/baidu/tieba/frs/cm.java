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
public class cm extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.core.data.t> Xq;
    private String bnG;
    private int bnH = 0;
    private Context mContext;

    public cm(Context context, ArrayList<com.baidu.tbadk.core.data.t> arrayList) {
        this.mContext = context;
        this.Xq = arrayList;
        this.bnG = this.mContext.getText(t.j.frs_good).toString();
        Ry();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.t> arrayList) {
        this.Xq = arrayList;
        Ry();
    }

    private void Ry() {
        int i = 0;
        if (this.Xq != null) {
            ArrayList<com.baidu.tbadk.core.data.t> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
            tVar.bI(0);
            tVar.co(this.bnG);
            arrayList.add(tVar);
            if (this.Xq != null && this.Xq.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Xq.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.t tVar2 = this.Xq.get(i2);
                    if (tVar2.rR() != 0) {
                        arrayList.add(tVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.Xq = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xq == null) {
            return 0;
        }
        return this.Xq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xq.get(i);
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
                    aVar.aLW = (TextView) view3.findViewById(t.g.frs_dia_good_text);
                    aVar.bnI = (ImageView) view3.findViewById(t.g.frs_dia_divider);
                    aVar.bnJ = (ImageView) view3.findViewById(t.g.frs_btm_divider);
                    aVar.bnK = (ImageView) view3.findViewById(t.g.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.at.k(aVar.bnI, t.d.frs_goodheader_line);
            com.baidu.tbadk.core.util.at.k(aVar.bnJ, t.d.frs_goodheader_line);
            if (this.bnH == i) {
                com.baidu.tbadk.core.util.at.b(aVar.aLW, t.d.frs_goodheader_text_S, 1);
                aVar.bnK.setVisibility(0);
                com.baidu.tbadk.core.util.at.k(aVar.bnK, t.d.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.at.b(aVar.aLW, t.d.frs_goodheader_text, 1);
                aVar.bnK.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.bnI.setVisibility(4);
            } else {
                aVar.bnI.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.bnJ.setVisibility(8);
            } else {
                aVar.bnJ.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aLW.setText(((com.baidu.tbadk.core.data.t) item).rQ());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aLW;
        ImageView bnI;
        ImageView bnJ;
        ImageView bnK;

        private a() {
        }

        /* synthetic */ a(cm cmVar, a aVar) {
            this();
        }
    }

    public void gK(int i) {
        this.bnH = i;
    }
}
