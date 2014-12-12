package com.baidu.tieba.frs;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bj extends BaseAdapter {
    private String aDK;
    private int aDL = 0;
    private Context mContext;
    private ArrayList<com.baidu.tbadk.core.data.j> mData;

    public bj(Context context, ArrayList<com.baidu.tbadk.core.data.j> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
        this.aDK = this.mContext.getText(com.baidu.tieba.z.frs_good).toString();
        FY();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void r(ArrayList<com.baidu.tbadk.core.data.j> arrayList) {
        this.mData = arrayList;
        FY();
    }

    private void FY() {
        int i = 0;
        if (this.mData != null) {
            ArrayList<com.baidu.tbadk.core.data.j> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
            jVar.bi(0);
            jVar.bP(this.aDK);
            arrayList.add(jVar);
            if (this.mData != null && this.mData.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mData.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.j jVar2 = this.mData.get(i2);
                    if (jVar2.mM() != 0) {
                        arrayList.add(jVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.mData = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        bk bkVar;
        View view3;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.dialog_good_item, null);
                try {
                    bkVar = new bk(this, null);
                    bkVar.alX = (TextView) view3.findViewById(com.baidu.tieba.w.frs_dia_good_text);
                    bkVar.mDivider = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_dia_divider);
                    bkVar.aDM = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_btm_divider);
                    bkVar.aDN = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_btm_divider_s);
                    view3.setTag(bkVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    return view2;
                }
            } else {
                bkVar = (bk) view.getTag();
                view3 = view;
            }
            com.baidu.tbadk.core.util.ax.i(bkVar.mDivider, com.baidu.tieba.t.frs_goodheader_line);
            com.baidu.tbadk.core.util.ax.i(bkVar.aDM, com.baidu.tieba.t.frs_goodheader_line);
            if (this.aDL == i) {
                com.baidu.tbadk.core.util.ax.b(bkVar.alX, com.baidu.tieba.t.frs_goodheader_text_S, 1);
                bkVar.aDN.setVisibility(0);
                com.baidu.tbadk.core.util.ax.i(bkVar.aDN, com.baidu.tieba.t.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.ax.b(bkVar.alX, com.baidu.tieba.t.frs_goodheader_text, 1);
                bkVar.aDN.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                bkVar.mDivider.setVisibility(4);
            } else {
                bkVar.mDivider.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                bkVar.aDM.setVisibility(8);
            } else {
                bkVar.aDM.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            bkVar.alX.setText(((com.baidu.tbadk.core.data.j) item).mL());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void eH(int i) {
        this.aDL = i;
    }
}
