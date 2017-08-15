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
    private ArrayList<com.baidu.adp.widget.ListView.f> bos;
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
                        readThreadHistory.sm(blVar.getId());
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
    private f cnn;
    private ExpandLayout cnq;
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.yg().getPageActivity();
        this.cnq = expandLayout;
        this.cnn = fVar2;
        this.cnn.a(hashSet);
        this.cnq.cAF.setAdapter(fVar2);
    }

    public void aS(List<bl> list) {
        if (this.bos == null) {
            this.bos = new ArrayList<>();
        }
        this.bos.addAll(list);
    }

    public void aT(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bos == null) {
            this.bos = new ArrayList<>();
        }
        if (!u.v(list)) {
            int size = list.size();
            this.bos.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void ako() {
        if (this.cnq != null && !u.v(this.bos)) {
            if (this.cAz != null) {
                this.cnq.cAE.removeView(this.cAz);
            }
            this.cnq.cAF.removeAllViews();
            this.cnq.cAG.setVisibility(8);
            this.cnq.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bos.size(); i++) {
                if (i == 0) {
                    this.cAA = this.bos.get(i);
                    this.cAz = this.cnn.g(this.cAA);
                    if (this.cAz != null) {
                        if (this.cAA instanceof bl) {
                            this.cnn.cCs = true;
                            this.cAz.setOnClickListener(this.cAC);
                        } else {
                            this.cnn.cCs = false;
                        }
                        this.cnq.cAE.addView(this.cAz, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bos.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!u.v(arrayList) && this.cnn != null) {
                this.cnq.cAG.setVisibility(0);
                ai.c(this.cnq.cAG, d.g.icon_arrow_gray_down);
                this.cnn.setData(arrayList);
                this.cnn.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bos != null) {
            this.bos.clear();
        }
        if (this.cnq != null) {
            this.cnq.reset();
            this.cnq.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.cnn.b(hVar);
        this.cAB = hVar;
    }
}
