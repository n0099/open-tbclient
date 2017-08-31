package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.adp.widget.ListView.f> boR;
    private View cGP;
    private com.baidu.adp.widget.ListView.f cGQ;
    private h cGR;
    private View.OnClickListener cGS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cGQ instanceof bj) {
                bj bjVar = (bj) a.this.cGQ;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sm(bjVar.getId());
                    }
                    aj.i(aVar.cIP, d.e.cp_cont_c);
                }
                if (a.this.cGR != null) {
                    a.this.cGR.a(view, bjVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private f ctT;
    private ExpandLayout ctW;
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.yi().getPageActivity();
        this.ctW = expandLayout;
        this.ctT = fVar2;
        this.ctT.a(hashSet);
        this.ctW.cGV.setAdapter(fVar2);
    }

    public void aW(List<bj> list) {
        if (this.boR == null) {
            this.boR = new ArrayList<>();
        }
        this.boR.addAll(list);
    }

    public void aX(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.boR == null) {
            this.boR = new ArrayList<>();
        }
        if (!v.v(list)) {
            int size = list.size();
            this.boR.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void alQ() {
        if (this.ctW != null && !v.v(this.boR)) {
            if (this.cGP != null) {
                this.ctW.cGU.removeView(this.cGP);
            }
            this.ctW.cGV.removeAllViews();
            this.ctW.cGW.setVisibility(8);
            this.ctW.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.boR.size(); i++) {
                if (i == 0) {
                    this.cGQ = this.boR.get(i);
                    this.cGP = this.ctT.g(this.cGQ);
                    if (this.cGP != null) {
                        if (this.cGQ instanceof bj) {
                            this.ctT.cII = true;
                            this.cGP.setOnClickListener(this.cGS);
                        } else {
                            this.ctT.cII = false;
                        }
                        this.ctW.cGU.addView(this.cGP, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.boR.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!v.v(arrayList) && this.ctT != null) {
                this.ctW.cGW.setVisibility(0);
                aj.c(this.ctW.cGW, d.g.icon_arrow_gray_down);
                this.ctT.setData(arrayList);
                this.ctT.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.boR != null) {
            this.boR.clear();
        }
        if (this.ctW != null) {
            this.ctW.reset();
            this.ctW.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.ctT.b(hVar);
        this.cGR = hVar;
    }
}
