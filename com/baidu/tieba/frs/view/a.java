package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.ExpandLayout;
import com.baidu.tieba.frs.view.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private ArrayList<com.baidu.adp.widget.ListView.f> bzf;
    private f cMf;
    private ExpandLayout cMi;
    private View daX;
    private com.baidu.adp.widget.ListView.f daY;
    private h daZ;
    private View.OnClickListener dba = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.daY instanceof bd) {
                bd bdVar = (bd) a.this.daY;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.ti(bdVar.getId());
                    }
                    aj.i(aVar.dda, d.C0082d.cp_cont_c);
                }
                if (a.this.daZ != null) {
                    a.this.daZ.a(view, bdVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.cMi = expandLayout;
        this.cMf = fVar2;
        this.cMf.a(hashSet);
        this.cMi.dbd.setAdapter(fVar2);
    }

    public void bl(List<bd> list) {
        if (this.bzf == null) {
            this.bzf = new ArrayList<>();
        }
        this.bzf.addAll(list);
    }

    public void bm(List<com.baidu.tieba.tbadkCore.f> list) {
        if (this.bzf == null) {
            this.bzf = new ArrayList<>();
        }
        if (!v.w(list)) {
            int size = list.size();
            this.bzf.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void aqT() {
        if (this.cMi != null) {
            if (!v.w(this.bzf)) {
                if (this.daX != null) {
                    this.cMi.dbc.removeView(this.daX);
                }
                this.cMi.dbd.removeAllViews();
                this.cMi.dbe.setVisibility(8);
                this.cMi.setVisibility(0);
                ArrayList arrayList = null;
                for (int i = 0; i < this.bzf.size(); i++) {
                    if (i == 0) {
                        this.daY = this.bzf.get(i);
                        this.daX = this.cMf.g(this.daY);
                        if (this.daX != null) {
                            if (this.daY instanceof bd) {
                                this.cMf.dcU = true;
                                this.daX.setOnClickListener(this.dba);
                            } else {
                                this.cMf.dcU = false;
                            }
                            this.cMi.dbc.addView(this.daX, 0, new ViewGroup.LayoutParams(-1, -2));
                        }
                    } else {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(this.bzf.get(i));
                        arrayList = arrayList2;
                    }
                }
                if (!v.w(arrayList) && this.cMf != null) {
                    this.cMi.dbe.setVisibility(0);
                    aj.c(this.cMi.dbe, d.f.icon_arrow_gray_down);
                    this.cMf.setData(arrayList);
                    this.cMf.notifyDataSetChanged();
                }
            }
            this.cMi.setOnExpandListener(new ExpandLayout.a() { // from class: com.baidu.tieba.frs.view.a.1
                @Override // com.baidu.tieba.frs.view.ExpandLayout.a
                public void fD(boolean z) {
                    if (a.this.daX != null && (a.this.daX.getTag(d.g.menu_tag) instanceof f.a)) {
                        f.a aVar = (f.a) a.this.daX.getTag(d.g.menu_tag);
                        if (aVar.divider != null) {
                            aVar.divider.setVisibility(!z ? 0 : 8);
                        }
                    }
                }
            });
        }
    }

    public void onChangeSkinType() {
        aj.c(this.cMi.dbe, d.f.icon_arrow_gray_down);
    }

    public void clearData() {
        if (this.bzf != null) {
            this.bzf.clear();
        }
        if (this.cMi != null) {
            this.cMi.reset();
            this.cMi.setVisibility(8);
        }
    }

    public void c(h hVar) {
        this.cMf.c(hVar);
        this.daZ = hVar;
    }
}
