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
public class be extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.core.data.k> Xe;
    private String aWo;
    private int aWp = 0;
    private Context mContext;

    public be(Context context, ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.mContext = context;
        this.Xe = arrayList;
        this.aWo = this.mContext.getText(i.C0057i.frs_good).toString();
        LM();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.Xe = arrayList;
        LM();
    }

    private void LM() {
        int i = 0;
        if (this.Xe != null) {
            ArrayList<com.baidu.tbadk.core.data.k> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
            kVar.bs(0);
            kVar.ce(this.aWo);
            arrayList.add(kVar);
            if (this.Xe != null && this.Xe.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Xe.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.k kVar2 = this.Xe.get(i2);
                    if (kVar2.rK() != 0) {
                        arrayList.add(kVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.Xe = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xe == null) {
            return 0;
        }
        return this.Xe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xe.get(i);
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
                    aVar.aDG = (TextView) view3.findViewById(i.f.frs_dia_good_text);
                    aVar.aWq = (ImageView) view3.findViewById(i.f.frs_dia_divider);
                    aVar.aWr = (ImageView) view3.findViewById(i.f.frs_btm_divider);
                    aVar.aWs = (ImageView) view3.findViewById(i.f.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.al.i(aVar.aWq, i.c.frs_goodheader_line);
            com.baidu.tbadk.core.util.al.i(aVar.aWr, i.c.frs_goodheader_line);
            if (this.aWp == i) {
                com.baidu.tbadk.core.util.al.b(aVar.aDG, i.c.frs_goodheader_text_S, 1);
                aVar.aWs.setVisibility(0);
                com.baidu.tbadk.core.util.al.i(aVar.aWs, i.c.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.al.b(aVar.aDG, i.c.frs_goodheader_text, 1);
                aVar.aWs.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.aWq.setVisibility(4);
            } else {
                aVar.aWq.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.aWr.setVisibility(8);
            } else {
                aVar.aWr.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aDG.setText(((com.baidu.tbadk.core.data.k) item).rJ());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aDG;
        ImageView aWq;
        ImageView aWr;
        ImageView aWs;

        private a() {
        }

        /* synthetic */ a(be beVar, a aVar) {
            this();
        }
    }

    public void fj(int i) {
        this.aWp = i;
    }
}
