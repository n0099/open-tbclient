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
    private ArrayList<com.baidu.adp.widget.ListView.f> bsq;
    private f cCJ;
    private ExpandLayout cCM;
    private com.baidu.adp.widget.ListView.f cRA;
    private h cRB;
    private View.OnClickListener cRC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cRA instanceof bh) {
                bh bhVar = (bh) a.this.cRA;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sF(bhVar.getId());
                    }
                    aj.i(aVar.cTy, d.C0080d.cp_cont_c);
                }
                if (a.this.cRB != null) {
                    a.this.cRB.a(view, bhVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private View cRz;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.cCM = expandLayout;
        this.cCJ = fVar2;
        this.cCJ.a(hashSet);
        this.cCM.cRF.setAdapter(fVar2);
    }

    public void aZ(List<bh> list) {
        if (this.bsq == null) {
            this.bsq = new ArrayList<>();
        }
        this.bsq.addAll(list);
    }

    public void ba(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bsq == null) {
            this.bsq = new ArrayList<>();
        }
        if (!v.v(list)) {
            int size = list.size();
            this.bsq.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void aoL() {
        if (this.cCM != null && !v.v(this.bsq)) {
            if (this.cRz != null) {
                this.cCM.cRE.removeView(this.cRz);
            }
            this.cCM.cRF.removeAllViews();
            this.cCM.cRG.setVisibility(8);
            this.cCM.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bsq.size(); i++) {
                if (i == 0) {
                    this.cRA = this.bsq.get(i);
                    this.cRz = this.cCJ.g(this.cRA);
                    if (this.cRz != null) {
                        if (this.cRA instanceof bh) {
                            this.cCJ.cTs = true;
                            this.cRz.setOnClickListener(this.cRC);
                        } else {
                            this.cCJ.cTs = false;
                        }
                        this.cCM.cRE.addView(this.cRz, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bsq.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!v.v(arrayList) && this.cCJ != null) {
                this.cCM.cRG.setVisibility(0);
                aj.c(this.cCM.cRG, d.f.icon_arrow_gray_down);
                this.cCJ.setData(arrayList);
                this.cCJ.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bsq != null) {
            this.bsq.clear();
        }
        if (this.cCM != null) {
            this.cCM.reset();
            this.cCM.setVisibility(8);
        }
    }

    public void c(h hVar) {
        this.cCJ.c(hVar);
        this.cRB = hVar;
    }
}
