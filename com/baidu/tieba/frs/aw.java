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
    private ArrayList<com.baidu.tbadk.core.data.l> Sk;
    private String aMW;
    private int aMX = 0;
    private Context mContext;

    public aw(Context context, ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        this.mContext = context;
        this.Sk = arrayList;
        this.aMW = this.mContext.getText(com.baidu.tieba.t.frs_good).toString();
        KY();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        this.Sk = arrayList;
        KY();
    }

    private void KY() {
        int i = 0;
        if (this.Sk != null) {
            ArrayList<com.baidu.tbadk.core.data.l> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
            lVar.bj(0);
            lVar.ce(this.aMW);
            arrayList.add(lVar);
            if (this.Sk != null && this.Sk.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Sk.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.l lVar2 = this.Sk.get(i2);
                    if (lVar2.qI() != 0) {
                        arrayList.add(lVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.Sk = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Sk == null) {
            return 0;
        }
        return this.Sk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Sk.get(i);
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
                view3 = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.dialog_good_item, null);
                try {
                    axVar = new ax(this, null);
                    axVar.awp = (TextView) view3.findViewById(com.baidu.tieba.q.frs_dia_good_text);
                    axVar.mDivider = (ImageView) view3.findViewById(com.baidu.tieba.q.frs_dia_divider);
                    axVar.aMY = (ImageView) view3.findViewById(com.baidu.tieba.q.frs_btm_divider);
                    axVar.aMZ = (ImageView) view3.findViewById(com.baidu.tieba.q.frs_btm_divider_s);
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
            com.baidu.tbadk.core.util.ay.i(axVar.mDivider, com.baidu.tieba.n.frs_goodheader_line);
            com.baidu.tbadk.core.util.ay.i(axVar.aMY, com.baidu.tieba.n.frs_goodheader_line);
            if (this.aMX == i) {
                com.baidu.tbadk.core.util.ay.b(axVar.awp, com.baidu.tieba.n.frs_goodheader_text_S, 1);
                axVar.aMZ.setVisibility(0);
                com.baidu.tbadk.core.util.ay.i(axVar.aMZ, com.baidu.tieba.n.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.ay.b(axVar.awp, com.baidu.tieba.n.frs_goodheader_text, 1);
                axVar.aMZ.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                axVar.mDivider.setVisibility(4);
            } else {
                axVar.mDivider.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                axVar.aMY.setVisibility(8);
            } else {
                axVar.aMY.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            axVar.awp.setText(((com.baidu.tbadk.core.data.l) item).qH());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void eW(int i) {
        this.aMX = i;
    }
}
