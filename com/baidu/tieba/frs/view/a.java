package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.adp.widget.ListView.f> bou;
    private com.baidu.adp.widget.ListView.f cAA;
    private h cAB;
    private View.OnClickListener cAC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cAA instanceof bl) {
                bl blVar = (bl) a.this.cAA;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sr(blVar.getId());
                    }
                    ai.i(aVar.cCz, d.e.cp_cont_c);
                }
                if (a.this.cAB != null) {
                    a.this.cAB.a(view, blVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private View cAz;
    private f cno;
    private ExpandLayout cnr;
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.yg().getPageActivity();
        this.cnr = expandLayout;
        this.cno = fVar2;
        this.cno.a(hashSet);
        this.cnr.cAF.setAdapter(fVar2);
    }

    public void aS(List<bl> list) {
        if (this.bou == null) {
            this.bou = new ArrayList<>();
        }
        this.bou.addAll(list);
    }

    public void aT(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bou == null) {
            this.bou = new ArrayList<>();
        }
        if (!u.v(list)) {
            int size = list.size();
            this.bou.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void aki() {
        if (this.cnr != null && !u.v(this.bou)) {
            if (this.cAz != null) {
                this.cnr.cAE.removeView(this.cAz);
            }
            this.cnr.cAF.removeAllViews();
            this.cnr.cAG.setVisibility(8);
            this.cnr.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bou.size(); i++) {
                if (i == 0) {
                    this.cAA = this.bou.get(i);
                    this.cAz = this.cno.g(this.cAA);
                    if (this.cAz != null) {
                        if (this.cAA instanceof bl) {
                            this.cno.cCs = true;
                            this.cAz.setOnClickListener(this.cAC);
                        } else {
                            this.cno.cCs = false;
                        }
                        this.cnr.cAE.addView(this.cAz, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bou.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!u.v(arrayList) && this.cno != null) {
                this.cnr.cAG.setVisibility(0);
                ai.c(this.cnr.cAG, d.g.icon_arrow_gray_down);
                this.cno.setData(arrayList);
                this.cno.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bou != null) {
            this.bou.clear();
        }
        if (this.cnr != null) {
            this.cnr.reset();
            this.cnr.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.cno.b(hVar);
        this.cAB = hVar;
    }
}
