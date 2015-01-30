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
    private String aEL;
    private int aEM = 0;
    private ArrayList<com.baidu.tbadk.core.data.k> amP;
    private Context mContext;

    public bi(Context context, ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.mContext = context;
        this.amP = arrayList;
        this.aEL = this.mContext.getText(com.baidu.tieba.z.frs_good).toString();
        Gv();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void s(ArrayList<com.baidu.tbadk.core.data.k> arrayList) {
        this.amP = arrayList;
        Gv();
    }

    private void Gv() {
        int i = 0;
        if (this.amP != null) {
            ArrayList<com.baidu.tbadk.core.data.k> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
            kVar.bn(0);
            kVar.bN(this.aEL);
            arrayList.add(kVar);
            if (this.amP != null && this.amP.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.amP.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.k kVar2 = this.amP.get(i2);
                    if (kVar2.mO() != 0) {
                        arrayList.add(kVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.amP = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amP == null) {
            return 0;
        }
        return this.amP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.amP.get(i);
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
                    bjVar.amR = (TextView) view3.findViewById(com.baidu.tieba.w.frs_dia_good_text);
                    bjVar.mDivider = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_dia_divider);
                    bjVar.aEN = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_btm_divider);
                    bjVar.aEO = (ImageView) view3.findViewById(com.baidu.tieba.w.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.bc.i(bjVar.aEN, com.baidu.tieba.t.frs_goodheader_line);
            if (this.aEM == i) {
                com.baidu.tbadk.core.util.bc.b(bjVar.amR, com.baidu.tieba.t.frs_goodheader_text_S, 1);
                bjVar.aEO.setVisibility(0);
                com.baidu.tbadk.core.util.bc.i(bjVar.aEO, com.baidu.tieba.t.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.bc.b(bjVar.amR, com.baidu.tieba.t.frs_goodheader_text, 1);
                bjVar.aEO.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                bjVar.mDivider.setVisibility(4);
            } else {
                bjVar.mDivider.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                bjVar.aEN.setVisibility(8);
            } else {
                bjVar.aEN.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            bjVar.amR.setText(((com.baidu.tbadk.core.data.k) item).mN());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void eN(int i) {
        this.aEM = i;
    }
}
