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
public class bf extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.core.data.k> Xn;
    private String aWF;
    private int aWG = 0;
    private Context mContext;

    public bf(Context context, ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.mContext = context;
        this.Xn = arrayList;
        this.aWF = this.mContext.getText(i.h.frs_good).toString();
        LG();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.Xn = arrayList;
        LG();
    }

    private void LG() {
        int i = 0;
        if (this.Xn != null) {
            ArrayList<com.baidu.tbadk.core.data.k> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
            kVar.bt(0);
            kVar.ci(this.aWF);
            arrayList.add(kVar);
            if (this.Xn != null && this.Xn.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Xn.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.k kVar2 = this.Xn.get(i2);
                    if (kVar2.rJ() != 0) {
                        arrayList.add(kVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.Xn = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xn == null) {
            return 0;
        }
        return this.Xn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xn.get(i);
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
                    aVar.aFo = (TextView) view3.findViewById(i.f.frs_dia_good_text);
                    aVar.aWH = (ImageView) view3.findViewById(i.f.frs_dia_divider);
                    aVar.aWI = (ImageView) view3.findViewById(i.f.frs_btm_divider);
                    aVar.aWJ = (ImageView) view3.findViewById(i.f.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.al.h(aVar.aWH, i.c.frs_goodheader_line);
            com.baidu.tbadk.core.util.al.h(aVar.aWI, i.c.frs_goodheader_line);
            if (this.aWG == i) {
                com.baidu.tbadk.core.util.al.b(aVar.aFo, i.c.frs_goodheader_text_S, 1);
                aVar.aWJ.setVisibility(0);
                com.baidu.tbadk.core.util.al.h(aVar.aWJ, i.c.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.al.b(aVar.aFo, i.c.frs_goodheader_text, 1);
                aVar.aWJ.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                aVar.aWH.setVisibility(4);
            } else {
                aVar.aWH.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                aVar.aWI.setVisibility(8);
            } else {
                aVar.aWI.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            aVar.aFo.setText(((com.baidu.tbadk.core.data.k) item).rI());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aFo;
        ImageView aWH;
        ImageView aWI;
        ImageView aWJ;

        private a() {
        }

        /* synthetic */ a(bf bfVar, a aVar) {
            this();
        }
    }

    public void fr(int i) {
        this.aWG = i;
    }
}
