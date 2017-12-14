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
    private ArrayList<com.baidu.adp.widget.ListView.f> bzh;
    private g cMq;
    private ExpandLayout cMt;
    private View dbP;
    private com.baidu.adp.widget.ListView.f dbQ;
    private com.baidu.adp.widget.ListView.h dbR;
    private View.OnClickListener dbS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.a aVar;
            if (a.this.dbQ instanceof bd) {
                bd bdVar = (bd) a.this.dbQ;
                view.setPressed(false);
                if ((view.getTag() instanceof g.a) && (aVar = (g.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tn(bdVar.getId());
                    }
                    aj.i(aVar.deh, d.C0096d.cp_cont_c);
                }
                if (a.this.dbR != null) {
                    a.this.dbR.a(view, bdVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };

    public a(com.baidu.tieba.frs.g gVar, ExpandLayout expandLayout, HashSet<String> hashSet, g gVar2) {
        this.cMt = expandLayout;
        this.cMq = gVar2;
        this.cMq.a(hashSet);
        this.cMt.dbV.setAdapter(gVar2);
    }

    public void bl(List<bd> list) {
        if (this.bzh == null) {
            this.bzh = new ArrayList<>();
        }
        this.bzh.addAll(list);
    }

    public void bm(List<com.baidu.tieba.tbadkCore.f> list) {
        if (this.bzh == null) {
            this.bzh = new ArrayList<>();
        }
        if (!v.w(list)) {
            int size = list.size();
            this.bzh.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void ard() {
        if (this.cMt != null) {
            if (!v.w(this.bzh)) {
                if (this.dbP != null) {
                    this.cMt.dbU.removeView(this.dbP);
                }
                this.cMt.dbV.removeAllViews();
                this.cMt.dbW.setVisibility(8);
                this.cMt.setVisibility(0);
                ArrayList arrayList = null;
                for (int i = 0; i < this.bzh.size(); i++) {
                    if (i == 0) {
                        this.dbQ = this.bzh.get(i);
                        this.dbP = this.cMq.g(this.dbQ);
                        if (this.dbP != null) {
                            if (this.dbQ instanceof bd) {
                                this.cMq.deb = true;
                                this.dbP.setOnClickListener(this.dbS);
                            } else {
                                this.cMq.deb = false;
                            }
                            this.cMt.dbU.addView(this.dbP, 0, new ViewGroup.LayoutParams(-1, -2));
                        }
                    } else {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(this.bzh.get(i));
                        arrayList = arrayList2;
                    }
                }
                if (!v.w(arrayList) && this.cMq != null) {
                    this.cMt.dbW.setVisibility(0);
                    aj.c(this.cMt.dbW, d.f.icon_arrow_gray_down);
                    this.cMq.setData(arrayList);
                    this.cMq.notifyDataSetChanged();
                }
            }
            this.cMt.setOnExpandListener(new ExpandLayout.a() { // from class: com.baidu.tieba.frs.view.a.1
                @Override // com.baidu.tieba.frs.view.ExpandLayout.a
                public void fE(boolean z) {
                    if (a.this.dbP != null && (a.this.dbP.getTag(d.g.menu_tag) instanceof g.a)) {
                        g.a aVar = (g.a) a.this.dbP.getTag(d.g.menu_tag);
                        if (aVar.divider != null) {
                            aVar.divider.setVisibility(!z ? 0 : 8);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        aj.c(this.cMt.dbW, d.f.icon_arrow_gray_down);
    }

    public void clearData() {
        if (this.bzh != null) {
            this.bzh.clear();
        }
        if (this.cMt != null) {
            this.cMt.reset();
            this.cMt.setVisibility(8);
        }
    }

    public void c(com.baidu.adp.widget.ListView.h hVar) {
        this.cMq.c(hVar);
        this.dbR = hVar;
    }
}
