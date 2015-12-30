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
public class cd extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.core.data.m> YA;
    private String bgl;
    private int bgm = 0;
    private Context mContext;

    public cd(Context context, ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        this.mContext = context;
        this.YA = arrayList;
        this.bgl = this.mContext.getText(n.j.frs_good).toString();
        NK();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        this.YA = arrayList;
        NK();
    }

    private void NK() {
        int i = 0;
        if (this.YA != null) {
            ArrayList<com.baidu.tbadk.core.data.m> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.bt(0);
            mVar.cs(this.bgl);
            arrayList.add(mVar);
            if (this.YA != null && this.YA.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.YA.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.m mVar2 = this.YA.get(i2);
                    if (mVar2.rH() != 0) {
                        arrayList.add(mVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.YA = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YA == null) {
            return 0;
        }
        return this.YA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.YA.get(i);
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
                view3 = LayoutInflater.from(this.mContext).inflate(n.h.dialog_good_item, (ViewGroup) null);
                try {
                    aVar = new a(this, null);
                    aVar.aHX = (TextView) view3.findViewById(n.g.frs_dia_good_text);
                    aVar.bgn = (ImageView) view3.findViewById(n.g.frs_dia_divider);
                    aVar.bgo = (ImageView) view3.findViewById(n.g.frs_btm_divider);
                    aVar.bgp = (ImageView) view3.findViewById(n.g.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.as.i(aVar.bgn, n.d.frs_goodheader_line);
            com.baidu.tbadk.core.util.as.i(aVar.bgo, n.d.frs_goodheader_line);
            if (this.bgm == i) {
                com.baidu.tbadk.core.util.as.b(aVar.aHX, n.d.frs_goodheader_text_S, 1);
                aVar.bgp.setVisibility(0);
                com.baidu.tbadk.core.util.as.i(aVar.bgp, n.d.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.as.b(aVar.aHX, n.d.frs_goodheader_text, 1);
                aVar.bgp.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.bgn.setVisibility(4);
            } else {
                aVar.bgn.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.bgo.setVisibility(8);
            } else {
                aVar.bgo.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aHX.setText(((com.baidu.tbadk.core.data.m) item).rG());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aHX;
        ImageView bgn;
        ImageView bgo;
        ImageView bgp;

        private a() {
        }

        /* synthetic */ a(cd cdVar, a aVar) {
            this();
        }
    }

    public void fW(int i) {
        this.bgm = i;
    }
}
