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
public class bn extends BaseAdapter {
    private String aCi;
    private int aCj = 0;
    private ArrayList<com.baidu.tbadk.core.data.h> aeE;
    private Context mContext;

    public bn(Context context, ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        this.mContext = context;
        this.aeE = arrayList;
        this.aCi = this.mContext.getText(com.baidu.tieba.y.frs_good).toString();
        FS();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (dataSetObserver != null) {
            super.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.h> arrayList) {
        this.aeE = arrayList;
        FS();
    }

    private void FS() {
        int i = 0;
        if (this.aeE != null) {
            ArrayList<com.baidu.tbadk.core.data.h> arrayList = new ArrayList<>();
            com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
            hVar.aM(0);
            hVar.aY(this.aCi);
            arrayList.add(hVar);
            if (this.aeE != null && this.aeE.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aeE.size()) {
                        break;
                    }
                    com.baidu.tbadk.core.data.h hVar2 = this.aeE.get(i2);
                    if (hVar2.jX() != 0) {
                        arrayList.add(hVar2);
                    }
                    i = i2 + 1;
                }
            }
            this.aeE = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aeE == null) {
            return 0;
        }
        return this.aeE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.aeE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        bo boVar;
        View view3;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.dialog_good_item, null);
                try {
                    boVar = new bo(this, null);
                    boVar.aeG = (TextView) view3.findViewById(com.baidu.tieba.v.frs_dia_good_text);
                    boVar.aCk = (ImageView) view3.findViewById(com.baidu.tieba.v.frs_dia_divider);
                    boVar.aCl = (ImageView) view3.findViewById(com.baidu.tieba.v.frs_btm_divider);
                    boVar.aCm = (ImageView) view3.findViewById(com.baidu.tieba.v.frs_btm_divider_s);
                    view3.setTag(boVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    return view2;
                }
            } else {
                boVar = (bo) view.getTag();
                view3 = view;
            }
            com.baidu.tbadk.core.util.aw.h(boVar.aCk, com.baidu.tieba.s.frs_goodheader_line);
            com.baidu.tbadk.core.util.aw.h(boVar.aCl, com.baidu.tieba.s.frs_goodheader_line);
            if (this.aCj == i) {
                com.baidu.tbadk.core.util.aw.b(boVar.aeG, com.baidu.tieba.s.frs_goodheader_text_S, 1);
                boVar.aCm.setVisibility(0);
                com.baidu.tbadk.core.util.aw.h(boVar.aCm, com.baidu.tieba.s.frs_goodheader_line_S);
            } else {
                com.baidu.tbadk.core.util.aw.b(boVar.aeG, com.baidu.tieba.s.frs_goodheader_text, 1);
                boVar.aCm.setVisibility(8);
            }
            if (i % 3 == 2 || i == getCount() - 1) {
                boVar.aCk.setVisibility(4);
            } else {
                boVar.aCk.setVisibility(0);
            }
            if (i / 3 == (getCount() - 1) / 3) {
                boVar.aCl.setVisibility(8);
            } else {
                boVar.aCl.setVisibility(0);
            }
            Object item = getItem(i);
            if (item == null) {
                return view3;
            }
            boVar.aeG.setText(((com.baidu.tbadk.core.data.h) item).jW());
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void eJ(int i) {
        this.aCj = i;
    }
}
