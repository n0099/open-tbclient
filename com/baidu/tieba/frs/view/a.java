package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.adp.widget.ListView.f> bsA;
    private f cDc;
    private ExpandLayout cDf;
    private View cRT;
    private com.baidu.adp.widget.ListView.f cRU;
    private h cRV;
    private View.OnClickListener cRW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cRU instanceof bh) {
                bh bhVar = (bh) a.this.cRU;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sL(bhVar.getId());
                    }
                    aj.i(aVar.cTS, d.C0080d.cp_cont_c);
                }
                if (a.this.cRV != null) {
                    a.this.cRV.a(view, bhVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.cDf = expandLayout;
        this.cDc = fVar2;
        this.cDc.a(hashSet);
        this.cDf.cRZ.setAdapter(fVar2);
    }

    public void aZ(List<bh> list) {
        if (this.bsA == null) {
            this.bsA = new ArrayList<>();
        }
        this.bsA.addAll(list);
    }

    public void ba(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bsA == null) {
            this.bsA = new ArrayList<>();
        }
        if (!v.v(list)) {
            int size = list.size();
            this.bsA.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void apa() {
        if (this.cDf != null && !v.v(this.bsA)) {
            if (this.cRT != null) {
                this.cDf.cRY.removeView(this.cRT);
            }
            this.cDf.cRZ.removeAllViews();
            this.cDf.cSa.setVisibility(8);
            this.cDf.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bsA.size(); i++) {
                if (i == 0) {
                    this.cRU = this.bsA.get(i);
                    this.cRT = this.cDc.g(this.cRU);
                    if (this.cRT != null) {
                        if (this.cRU instanceof bh) {
                            this.cDc.cTM = true;
                            this.cRT.setOnClickListener(this.cRW);
                        } else {
                            this.cDc.cTM = false;
                        }
                        this.cDf.cRY.addView(this.cRT, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bsA.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!v.v(arrayList) && this.cDc != null) {
                this.cDf.cSa.setVisibility(0);
                aj.c(this.cDf.cSa, d.f.icon_arrow_gray_down);
                this.cDc.setData(arrayList);
                this.cDc.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bsA != null) {
            this.bsA.clear();
        }
        if (this.cDf != null) {
            this.cDf.reset();
            this.cDf.setVisibility(8);
        }
    }

    public void c(h hVar) {
        this.cDc.c(hVar);
        this.cRV = hVar;
    }
}
