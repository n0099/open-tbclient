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
    private ArrayList<com.baidu.tbadk.core.data.k> Xk;
    private String aWr;
    private int aWs = 0;
    private Context mContext;

    public bp(Context context, ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.mContext = context;
        this.Xk = arrayList;
        this.aWr = this.mContext.getText(i.h.frs_good).toString();
        LQ();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.Xk = arrayList;
        LQ();
    }

    private void LQ() {
        int i = 0;
        if (this.Xk != null) {
            ArrayList<com.baidu.tbadk.core.data.k> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
            kVar.bt(0);
            kVar.ch(this.aWr);
            arrayList.add(kVar);
            if (this.Xk != null && this.Xk.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Xk.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.k kVar2 = this.Xk.get(i2);
                    if (kVar2.rD() != 0) {
                        arrayList.add(kVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.Xk = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xk == null) {
            return 0;
        }
        return this.Xk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xk.get(i);
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
                    aVar.aDy = (TextView) view3.findViewById(i.f.frs_dia_good_text);
                    aVar.aWt = (ImageView) view3.findViewById(i.f.frs_dia_divider);
                    aVar.aWu = (ImageView) view3.findViewById(i.f.frs_btm_divider);
                    aVar.aWv = (ImageView) view3.findViewById(i.f.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.an.i(aVar.aWt, i.c.frs_goodheader_line);
            com.baidu.tbadk.core.util.an.i(aVar.aWu, i.c.frs_goodheader_line);
            if (this.aWs == i) {
                com.baidu.tbadk.core.util.an.b(aVar.aDy, i.c.frs_goodheader_text_S, 1);
                aVar.aWv.setVisibility(0);
                com.baidu.tbadk.core.util.an.i(aVar.aWv, i.c.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.an.b(aVar.aDy, i.c.frs_goodheader_text, 1);
                aVar.aWv.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.aWt.setVisibility(4);
            } else {
                aVar.aWt.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.aWu.setVisibility(8);
            } else {
                aVar.aWu.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aDy.setText(((com.baidu.tbadk.core.data.k) item).rC());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aDy;
        ImageView aWt;
        ImageView aWu;
        ImageView aWv;

        private a() {
        }

        /* synthetic */ a(bp bpVar, a aVar) {
            this();
        }
    }

    public void fE(int i) {
        this.aWs = i;
    }
}
