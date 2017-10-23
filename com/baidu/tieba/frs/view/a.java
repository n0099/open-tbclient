package com.baidu.tieba.frs.view;

import android.content.Context;
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
    private ArrayList<com.baidu.adp.widget.ListView.f> bqB;
    private View cIn;
    private com.baidu.adp.widget.ListView.f cIo;
    private h cIp;
    private View.OnClickListener cIq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cIo instanceof bh) {
                bh bhVar = (bh) a.this.cIo;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.rX(bhVar.getId());
                    }
                    aj.i(aVar.cKn, d.e.cp_cont_c);
                }
                if (a.this.cIp != null) {
                    a.this.cIp.a(view, bhVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private f cvd;
    private ExpandLayout cvg;
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.xA().getPageActivity();
        this.cvg = expandLayout;
        this.cvd = fVar2;
        this.cvd.a(hashSet);
        this.cvg.cIt.setAdapter(fVar2);
    }

    public void aW(List<bh> list) {
        if (this.bqB == null) {
            this.bqB = new ArrayList<>();
        }
        this.bqB.addAll(list);
    }

    public void aX(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bqB == null) {
            this.bqB = new ArrayList<>();
        }
        if (!v.u(list)) {
            int size = list.size();
            this.bqB.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void ama() {
        if (this.cvg != null && !v.u(this.bqB)) {
            if (this.cIn != null) {
                this.cvg.cIs.removeView(this.cIn);
            }
            this.cvg.cIt.removeAllViews();
            this.cvg.cIu.setVisibility(8);
            this.cvg.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bqB.size(); i++) {
                if (i == 0) {
                    this.cIo = this.bqB.get(i);
                    this.cIn = this.cvd.g(this.cIo);
                    if (this.cIn != null) {
                        if (this.cIo instanceof bh) {
                            this.cvd.cKg = true;
                            this.cIn.setOnClickListener(this.cIq);
                        } else {
                            this.cvd.cKg = false;
                        }
                        this.cvg.cIs.addView(this.cIn, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bqB.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!v.u(arrayList) && this.cvd != null) {
                this.cvg.cIu.setVisibility(0);
                aj.c(this.cvg.cIu, d.g.icon_arrow_gray_down);
                this.cvd.setData(arrayList);
                this.cvd.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bqB != null) {
            this.bqB.clear();
        }
        if (this.cvg != null) {
            this.cvg.reset();
            this.cvg.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.cvd.b(hVar);
        this.cIp = hVar;
    }
}
