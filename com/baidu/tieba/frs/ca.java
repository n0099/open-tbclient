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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ca extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.core.data.m> XX;
    private String bcm;
    private int bcn = 0;
    private Context mContext;

    public ca(Context context, ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        this.mContext = context;
        this.XX = arrayList;
        this.bcm = this.mContext.getText(n.i.frs_good).toString();
        Nr();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        this.XX = arrayList;
        Nr();
    }

    private void Nr() {
        int i = 0;
        if (this.XX != null) {
            ArrayList<com.baidu.tbadk.core.data.m> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.bA(0);
            mVar.cp(this.bcm);
            arrayList.add(mVar);
            if (this.XX != null && this.XX.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.XX.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.m mVar2 = this.XX.get(i2);
                    if (mVar2.rY() != 0) {
                        arrayList.add(mVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.XX = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XX == null) {
            return 0;
        }
        return this.XX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.XX.get(i);
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
                view3 = LayoutInflater.from(this.mContext).inflate(n.g.dialog_good_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.aGw = (TextView) view3.findViewById(n.f.frs_dia_good_text);
                    aVar.bco = (ImageView) view3.findViewById(n.f.frs_dia_divider);
                    aVar.bcp = (ImageView) view3.findViewById(n.f.frs_btm_divider);
                    aVar.bcq = (ImageView) view3.findViewById(n.f.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.as.i(aVar.bco, n.c.frs_goodheader_line);
            com.baidu.tbadk.core.util.as.i(aVar.bcp, n.c.frs_goodheader_line);
            if (this.bcn == i) {
                com.baidu.tbadk.core.util.as.b(aVar.aGw, n.c.frs_goodheader_text_S, 1);
                aVar.bcq.setVisibility(0);
                com.baidu.tbadk.core.util.as.i(aVar.bcq, n.c.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.as.b(aVar.aGw, n.c.frs_goodheader_text, 1);
                aVar.bcq.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.bco.setVisibility(4);
            } else {
                aVar.bco.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.bcp.setVisibility(8);
            } else {
                aVar.bcp.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aGw.setText(((com.baidu.tbadk.core.data.m) item).rX());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aGw;
        ImageView bco;
        ImageView bcp;
        ImageView bcq;

        private a() {
        }

        /* synthetic */ a(ca caVar, a aVar) {
            this();
        }
    }

    public void gb(int i) {
        this.bcn = i;
    }
}
