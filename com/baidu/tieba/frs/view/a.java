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
    private ArrayList<com.baidu.adp.widget.ListView.f> bnT;
    private f cmC;
    private ExpandLayout cmF;
    private com.baidu.adp.widget.ListView.f cyA;
    private h cyB;
    private View.OnClickListener cyC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cyA instanceof bl) {
                bl blVar = (bl) a.this.cyA;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sk(blVar.getId());
                    }
                    ai.i(aVar.cAC, d.e.cp_cont_c);
                }
                if (a.this.cyB != null) {
                    a.this.cyB.a(view, blVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private View cyz;
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.yg().getPageActivity();
        this.cmF = expandLayout;
        this.cmC = fVar2;
        this.cmC.a(hashSet);
        this.cmF.cyF.setAdapter(fVar2);
    }

    public void aP(List<bl> list) {
        if (this.bnT == null) {
            this.bnT = new ArrayList<>();
        }
        this.bnT.addAll(list);
    }

    public void aQ(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bnT == null) {
            this.bnT = new ArrayList<>();
        }
        if (!u.v(list)) {
            int size = list.size();
            this.bnT.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void ajJ() {
        if (this.cmF != null && !u.v(this.bnT)) {
            if (this.cyz != null) {
                this.cmF.cyE.removeView(this.cyz);
            }
            this.cmF.cyF.removeAllViews();
            this.cmF.cyG.setVisibility(8);
            this.cmF.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bnT.size(); i++) {
                if (i == 0) {
                    this.cyA = this.bnT.get(i);
                    this.cyz = this.cmC.g(this.cyA);
                    if (this.cyz != null) {
                        if (this.cyA instanceof bl) {
                            this.cmC.cAu = true;
                            this.cyz.setOnClickListener(this.cyC);
                        } else {
                            this.cmC.cAu = false;
                        }
                        this.cmF.cyE.addView(this.cyz, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bnT.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!u.v(arrayList) && this.cmC != null) {
                this.cmF.cyG.setVisibility(0);
                ai.c(this.cmF.cyG, d.g.icon_arrow_gray_down);
                this.cmC.setData(arrayList);
                this.cmC.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bnT != null) {
            this.bnT.clear();
        }
        if (this.cmF != null) {
            this.cmF.reset();
            this.cmF.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.cmC.b(hVar);
        this.cyB = hVar;
    }
}
