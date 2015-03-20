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
public class aw extends BaseAdapter {
    private String aKE;
    private int aKF = 0;
    private ArrayList<com.baidu.tbadk.core.data.l> auC;
    private Context mContext;

    public aw(Context context, ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        this.mContext = context;
        this.auC = arrayList;
        this.aKE = this.mContext.getText(com.baidu.tieba.y.frs_good).toString();
        JL();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void p(ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        this.auC = arrayList;
        JL();
    }

    private void JL() {
        int i = 0;
        if (this.auC != null) {
            ArrayList<com.baidu.tbadk.core.data.l> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
            lVar.bm(0);
            lVar.bR(this.aKE);
            arrayList.add(lVar);
            if (this.auC != null && this.auC.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.auC.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.l lVar2 = this.auC.get(i2);
                    if (lVar2.qc() != 0) {
                        arrayList.add(lVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.auC = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auC == null) {
            return 0;
        }
        return this.auC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.auC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        ax axVar;
        View view3;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.dialog_good_item, null);
                try {
                    axVar = new ax(this, null);
                    axVar.auE = (TextView) view3.findViewById(com.baidu.tieba.v.frs_dia_good_text);
                    axVar.mDivider = (ImageView) view3.findViewById(com.baidu.tieba.v.frs_dia_divider);
                    axVar.aKG = (ImageView) view3.findViewById(com.baidu.tieba.v.frs_btm_divider);
                    axVar.aKH = (ImageView) view3.findViewById(com.baidu.tieba.v.frs_btm_divider_s);
                    view3.setTag(axVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    return view2;
                }
            } else {
                axVar = (ax) view.getTag();
                view3 = view;
            }
            com.baidu.tbadk.core.util.ba.i(axVar.mDivider, com.baidu.tieba.s.frs_goodheader_line);
            com.baidu.tbadk.core.util.ba.i(axVar.aKG, com.baidu.tieba.s.frs_goodheader_line);
            if (this.aKF == i) {
                com.baidu.tbadk.core.util.ba.b(axVar.auE, com.baidu.tieba.s.frs_goodheader_text_S, 1);
                axVar.aKH.setVisibility(0);
                com.baidu.tbadk.core.util.ba.i(axVar.aKH, com.baidu.tieba.s.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.ba.b(axVar.auE, com.baidu.tieba.s.frs_goodheader_text, 1);
                axVar.aKH.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                axVar.mDivider.setVisibility(4);
            } else {
                axVar.mDivider.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                axVar.aKG.setVisibility(8);
            } else {
                axVar.aKG.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            axVar.auE.setText(((com.baidu.tbadk.core.data.l) item).qb());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void eI(int i) {
        this.aKF = i;
    }
}
