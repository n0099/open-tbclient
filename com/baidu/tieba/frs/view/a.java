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
    private ArrayList<com.baidu.adp.widget.ListView.f> bqN;
    private com.baidu.adp.widget.ListView.f cIA;
    private h cIB;
    private View.OnClickListener cIC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cIA instanceof bh) {
                bh bhVar = (bh) a.this.cIA;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.rY(bhVar.getId());
                    }
                    aj.i(aVar.cKz, d.e.cp_cont_c);
                }
                if (a.this.cIB != null) {
                    a.this.cIB.a(view, bhVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private View cIz;
    private f cvp;
    private ExpandLayout cvs;
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.xH().getPageActivity();
        this.cvs = expandLayout;
        this.cvp = fVar2;
        this.cvp.a(hashSet);
        this.cvs.cIF.setAdapter(fVar2);
    }

    public void aW(List<bh> list) {
        if (this.bqN == null) {
            this.bqN = new ArrayList<>();
        }
        this.bqN.addAll(list);
    }

    public void aX(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bqN == null) {
            this.bqN = new ArrayList<>();
        }
        if (!v.u(list)) {
            int size = list.size();
            this.bqN.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void amf() {
        if (this.cvs != null && !v.u(this.bqN)) {
            if (this.cIz != null) {
                this.cvs.cIE.removeView(this.cIz);
            }
            this.cvs.cIF.removeAllViews();
            this.cvs.cIG.setVisibility(8);
            this.cvs.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bqN.size(); i++) {
                if (i == 0) {
                    this.cIA = this.bqN.get(i);
                    this.cIz = this.cvp.g(this.cIA);
                    if (this.cIz != null) {
                        if (this.cIA instanceof bh) {
                            this.cvp.cKs = true;
                            this.cIz.setOnClickListener(this.cIC);
                        } else {
                            this.cvp.cKs = false;
                        }
                        this.cvs.cIE.addView(this.cIz, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bqN.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!v.u(arrayList) && this.cvp != null) {
                this.cvs.cIG.setVisibility(0);
                aj.c(this.cvs.cIG, d.g.icon_arrow_gray_down);
                this.cvp.setData(arrayList);
                this.cvp.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bqN != null) {
            this.bqN.clear();
        }
        if (this.cvs != null) {
            this.cvs.reset();
            this.cvs.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.cvp.b(hVar);
        this.cIB = hVar;
    }
}
