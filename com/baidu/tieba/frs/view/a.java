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
    private ArrayList<com.baidu.adp.widget.ListView.f> bpe;
    private View cHJ;
    private com.baidu.adp.widget.ListView.f cHK;
    private h cHL;
    private View.OnClickListener cHM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cHK instanceof bj) {
                bj bjVar = (bj) a.this.cHK;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.so(bjVar.getId());
                    }
                    aj.i(aVar.cJJ, d.e.cp_cont_c);
                }
                if (a.this.cHL != null) {
                    a.this.cHL.a(view, bjVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private f cuL;
    private ExpandLayout cuO;
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.yi().getPageActivity();
        this.cuO = expandLayout;
        this.cuL = fVar2;
        this.cuL.a(hashSet);
        this.cuO.cHP.setAdapter(fVar2);
    }

    public void aW(List<bj> list) {
        if (this.bpe == null) {
            this.bpe = new ArrayList<>();
        }
        this.bpe.addAll(list);
    }

    public void aX(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bpe == null) {
            this.bpe = new ArrayList<>();
        }
        if (!v.v(list)) {
            int size = list.size();
            this.bpe.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void amb() {
        if (this.cuO != null && !v.v(this.bpe)) {
            if (this.cHJ != null) {
                this.cuO.cHO.removeView(this.cHJ);
            }
            this.cuO.cHP.removeAllViews();
            this.cuO.cHQ.setVisibility(8);
            this.cuO.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bpe.size(); i++) {
                if (i == 0) {
                    this.cHK = this.bpe.get(i);
                    this.cHJ = this.cuL.g(this.cHK);
                    if (this.cHJ != null) {
                        if (this.cHK instanceof bj) {
                            this.cuL.cJC = true;
                            this.cHJ.setOnClickListener(this.cHM);
                        } else {
                            this.cuL.cJC = false;
                        }
                        this.cuO.cHO.addView(this.cHJ, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bpe.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!v.v(arrayList) && this.cuL != null) {
                this.cuO.cHQ.setVisibility(0);
                aj.c(this.cuO.cHQ, d.g.icon_arrow_gray_down);
                this.cuL.setData(arrayList);
                this.cuL.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bpe != null) {
            this.bpe.clear();
        }
        if (this.cuO != null) {
            this.cuO.reset();
            this.cuO.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.cuL.b(hVar);
        this.cHL = hVar;
    }
}
