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
    private ArrayList<com.baidu.adp.widget.ListView.f> bmJ;
    private f clt;
    private ExpandLayout clw;
    private View cxh;
    private com.baidu.adp.widget.ListView.f cxi;
    private h cxj;
    private View.OnClickListener cxk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.a aVar;
            if (a.this.cxi instanceof bl) {
                bl blVar = (bl) a.this.cxi;
                view.setPressed(false);
                if ((view.getTag() instanceof f.a) && (aVar = (f.a) view.getTag()) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sf(blVar.getId());
                    }
                    ai.i(aVar.czh, d.e.cp_cont_c);
                }
                if (a.this.cxj != null) {
                    a.this.cxj.a(view, blVar, BdUniqueId.gen(), null, 0, 0L);
                }
            }
        }
    };
    private Context mContext;

    public a(com.baidu.tieba.frs.f fVar, ExpandLayout expandLayout, HashSet<String> hashSet, f fVar2) {
        this.mContext = fVar.xY().getPageActivity();
        this.clw = expandLayout;
        this.clt = fVar2;
        this.clt.a(hashSet);
        this.clw.cxn.setAdapter(fVar2);
    }

    public void aP(List<bl> list) {
        if (this.bmJ == null) {
            this.bmJ = new ArrayList<>();
        }
        this.bmJ.addAll(list);
    }

    public void aQ(List<com.baidu.tieba.tbadkCore.e> list) {
        if (this.bmJ == null) {
            this.bmJ = new ArrayList<>();
        }
        if (!u.v(list)) {
            int size = list.size();
            this.bmJ.addAll(list.subList(0, size <= 5 ? size : 5));
        }
    }

    public void ajv() {
        if (this.clw != null && !u.v(this.bmJ)) {
            if (this.cxh != null) {
                this.clw.cxm.removeView(this.cxh);
            }
            this.clw.cxn.removeAllViews();
            this.clw.cxo.setVisibility(8);
            this.clw.setVisibility(0);
            ArrayList arrayList = null;
            for (int i = 0; i < this.bmJ.size(); i++) {
                if (i == 0) {
                    this.cxi = this.bmJ.get(i);
                    this.cxh = this.clt.g(this.cxi);
                    if (this.cxh != null) {
                        if (this.cxi instanceof bl) {
                            this.clt.cza = true;
                            this.cxh.setOnClickListener(this.cxk);
                        } else {
                            this.clt.cza = false;
                        }
                        this.clw.cxm.addView(this.cxh, 0, new ViewGroup.LayoutParams(-1, -2));
                    }
                } else {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(this.bmJ.get(i));
                    arrayList = arrayList2;
                }
            }
            if (!u.v(arrayList) && this.clt != null) {
                this.clw.cxo.setVisibility(0);
                ai.c(this.clw.cxo, d.g.icon_arrow_gray_down);
                this.clt.setData(arrayList);
                this.clt.notifyDataSetChanged();
            }
        }
    }

    public void clearData() {
        if (this.bmJ != null) {
            this.bmJ.clear();
        }
        if (this.clw != null) {
            this.clw.reset();
            this.clw.setVisibility(8);
        }
    }

    public void b(h hVar) {
        this.clt.b(hVar);
        this.cxj = hVar;
    }
}
