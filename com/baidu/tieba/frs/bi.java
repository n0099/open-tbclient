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
public class bi extends BaseAdapter {
    private String aEI;
    private int aEJ = 0;
    private ArrayList<com.baidu.tbadk.core.data.k> amM;
    private Context mContext;

    public bi(Context context, ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.mContext = context;
        this.amM = arrayList;
        this.aEI = this.mContext.getText(com.baidu.tieba.z.frs_good).toString();
        Gp();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void s(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.amM = arrayList;
        Gp();
    }

    private void Gp() {
        int i = 0;
        if (this.amM != null) {
            ArrayList<com.baidu.tbadk.core.data.k> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
            kVar.bn(0);
            kVar.bK(this.aEI);
            arrayList.add(kVar);
            if (this.amM != null && this.amM.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.amM.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.k kVar2 = this.amM.get(i2);
                    if (kVar2.mH() != 0) {
                        arrayList.add(kVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.amM = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amM == null) {
            return 0;
        }
        return this.amM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.amM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        bj bjVar;
        View view3;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.dialog_good_item, null);
                try {
                    bjVar = new bj(this, null);
                    bjVar.amO = (TextView) view3.findViewById(com.baidu.tieba.w.frs_dia_good_text);
                    bjVar.mDivider = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_dia_divider);
                    bjVar.aEK = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_btm_divider);
                    bjVar.aEL = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_btm_divider_s);
                    view3.setTag(bjVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    return view2;
                }
            } else {
                bjVar = (bj) view.getTag();
                view3 = view;
            }
            com.baidu.tbadk.core.util.bc.i(bjVar.mDivider, com.baidu.tieba.t.frs_goodheader_line);
            com.baidu.tbadk.core.util.bc.i(bjVar.aEK, com.baidu.tieba.t.frs_goodheader_line);
            if (this.aEJ == i) {
                com.baidu.tbadk.core.util.bc.b(bjVar.amO, com.baidu.tieba.t.frs_goodheader_text_S, 1);
                bjVar.aEL.setVisibility(0);
                com.baidu.tbadk.core.util.bc.i(bjVar.aEL, com.baidu.tieba.t.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.bc.b(bjVar.amO, com.baidu.tieba.t.frs_goodheader_text, 1);
                bjVar.aEL.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                bjVar.mDivider.setVisibility(4);
            } else {
                bjVar.mDivider.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                bjVar.aEK.setVisibility(8);
            } else {
                bjVar.aEK.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            bjVar.amO.setText(((com.baidu.tbadk.core.data.k) item).mG());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void eN(int i) {
        this.aEJ = i;
    }
}
