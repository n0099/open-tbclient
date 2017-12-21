package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.adp.widget.ListView.f> bzl;
    private g cMu;
    private ExpandLayout cMx;
    private View dbT;
    private com.baidu.adp.widget.ListView.f dbU;
    private com.baidu.adp.widget.ListView.h dbV;
    private View.OnClickListener dbW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar;
            if (a.this.dbU instanceof bd) {
                bd bdVar = (bd) a.this.dbU;
                view.setPressed(false);
                if ((view.getTag() instanceof g.a) && (aVar = (g.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tn(bdVar.getId());
                    }
                    aj.i(aVar.del, d.C0095d.cp_cont_c);
                }
                if (a.this.dbV != null) {
                    a.this.dbV.a(view, bdVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };

    public a(com.baidu.tieba.frs.g gVar, ExpandLayout expandLayout, HashSet<String> hashSet, g gVar2) {
        this.cMx = expandLayout;
        this.cMu = gVar2;
        this.cMu.a(hashSet);
        this.cMx.dbZ.setAdapter(gVar2);
    }

    public void bl(List<bd> list) {
        if (this.bzl == null) {
            this.bzl = new ArrayList<>();
        }
        this.bzl.addAll(list);
    }

    public void bm(List<com.baidu.tieba.tbadkCore.f> list) {
        if (this.bzl == null) {
            this.bzl = new ArrayList<>();
        }
        if (!v.w(list)) {
            int size = list.size();
            this.bzl.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void ard() {
        if (this.cMx != null) {
            if (!v.w(this.bzl)) {
                if (this.dbT != null) {
                    this.cMx.dbY.removeView(this.dbT);
                }
                this.cMx.dbZ.removeAllViews();
                this.cMx.dca.setVisibility(8);
                this.cMx.setVisibility(0);
                ArrayList arrayList = null;
                for (int i = 0; i < this.bzl.size(); i++) {
                    if (i == 0) {
                        this.dbU = this.bzl.get(i);
                        this.dbT = this.cMu.g(this.dbU);
                        if (this.dbT != null) {
                            if (this.dbU instanceof bd) {
                                this.cMu.def = true;
                                this.dbT.setOnClickListener(this.dbW);
                            } else {
                                this.cMu.def = false;
                            }
                            this.cMx.dbY.addView(this.dbT, 0, new ViewGroup.LayoutParams(-1, -2));
                        }
                    } else {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(this.bzl.get(i));
                        arrayList = arrayList2;
                    }
                }
                if (!v.w(arrayList) && this.cMu != null) {
                    this.cMx.dca.setVisibility(0);
                    aj.c(this.cMx.dca, d.f.icon_arrow_gray_down);
                    this.cMu.setData(arrayList);
                    this.cMu.notifyDataSetChanged();
                }
            }
            this.cMx.setOnExpandListener(new ExpandLayout.a() { // from class: com.baidu.tieba.frs.view.a.1
                @Override // com.baidu.tieba.frs.view.ExpandLayout.a
                public void fE(boolean z) {
                    if (a.this.dbT != null && (a.this.dbT.getTag(d.g.menu_tag) instanceof g.a)) {
                        g.a aVar = (g.a) a.this.dbT.getTag(d.g.menu_tag);
                        if (aVar.divider != null) {
                            aVar.divider.setVisibility(!z ? 0 : 8);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        aj.c(this.cMx.dca, d.f.icon_arrow_gray_down);
    }

    public void clearData() {
        if (this.bzl != null) {
            this.bzl.clear();
        }
        if (this.cMx != null) {
            this.cMx.reset();
            this.cMx.setVisibility(8);
        }
    }

    public void c(com.baidu.adp.widget.ListView.h hVar) {
        this.cMu.c(hVar);
        this.dbV = hVar;
    }
}
