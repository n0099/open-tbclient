package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.tieba.frs.view.c {
    protected com.baidu.adp.widget.ListView.w bGI;
    protected com.baidu.adp.widget.ListView.x bGJ;
    protected AdapterLinearLayout bKl;
    protected TextView bKm;
    protected com.baidu.tieba.frs.view.w bKn;
    protected ViewStub bKo;
    protected View bKp;
    protected ViewGroup bKq;
    protected TbImageView bKr;
    protected TextView bKs;
    protected TextView bKt;
    protected TextView bKu;
    private View.OnClickListener bKv = new h(this);
    private String fid;

    public void Zy() {
        this.bKl = (AdapterLinearLayout) this.bWM.findViewById(r.h.top_layout);
        this.bKm = (TextView) this.bWM.findViewById(r.h.top_item_type);
        this.bKm.setText(TbadkCoreApplication.m9getInst().getString(r.l.game));
        this.bKn = new com.baidu.tieba.frs.view.w(this.Fp.getPageActivity());
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bGI = wVar;
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bGJ = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zz() {
        if (this.bHh != null && this.bHh.XW() != null && this.bKn != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> bgR = this.bHh.XW().bgR();
            if (bgR != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.w.r(bgR); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.w.c(bgR, i);
                    if (vVar instanceof bh) {
                        arrayList.add((bh) vVar);
                    }
                }
            }
            this.bKl.setAdapter(this.bKn);
            if (this.bKn instanceof com.baidu.tieba.frs.e.e) {
                com.baidu.tieba.frs.view.w wVar = this.bKn;
                if (com.baidu.tieba.frs.e.e.bTj != null && this.bHh.XW() != null) {
                    if (this.bHh.XW().fnk == 1) {
                        com.baidu.tieba.frs.e.e.bTj.bSZ = true;
                    } else {
                        com.baidu.tieba.frs.e.e.bTj.bSZ = false;
                    }
                    if (this.bHh.XW().aJY() != null) {
                        com.baidu.tieba.frs.e.e.bTj.bTb = this.bHh.XW().aJY().getId();
                    }
                    if (this.bHh != null && this.bHh.Xz() != null) {
                        com.baidu.tieba.frs.e.e.bTj.bTa = this.bHh.Xy().aca();
                    }
                }
            }
            this.bKn.b(this.bGI);
            this.bKn.b(this.bGJ);
            this.bKn.setData(arrayList);
            this.bKn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZA() {
        if (this.bKn != null) {
            this.bKn.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void ZB() {
        if (this.bKn != null) {
            this.bKn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZC() {
        if (this.bHh != null && this.bHh.XW() != null && this.bHh.XW().fnJ != null) {
            z zVar = this.bHh.XW().fnJ;
            this.fid = this.bHh.XW().aJY().getId();
            if (zVar != null && zVar.Qx == 1) {
                if (this.bKo == null) {
                    this.bKo = (ViewStub) this.bWM.findViewById(r.h.frs_header_recommend_book);
                    this.bKo.setVisibility(0);
                }
                if (this.bKq == null) {
                    this.bKq = (ViewGroup) this.bWM.findViewById(r.h.root_recommend_book);
                }
                if (this.bKp == null) {
                    this.bKp = this.bWM.findViewById(r.h.divider_book);
                }
                if (this.bKr == null) {
                    this.bKr = (TbImageView) this.bWM.findViewById(r.h.book_image);
                }
                if (this.bKs == null) {
                    this.bKs = (TextView) this.bWM.findViewById(r.h.book_title);
                }
                if (this.bKt == null) {
                    this.bKt = (TextView) this.bWM.findViewById(r.h.book_desc_1);
                }
                if (this.bKu == null) {
                    this.bKu = (TextView) this.bWM.findViewById(r.h.book_desc_2);
                }
                this.bKq.setVisibility(0);
                this.bKp.setVisibility(0);
                this.bKq.setTag(zVar);
                this.bKq.setOnClickListener(this.bKv);
                this.bKr.c(zVar.image, 10, false);
                this.bKs.setText(zVar.title);
                if (zVar.Qy.size() > 0 && !StringUtils.isNull(zVar.Qy.get(0))) {
                    this.bKt.setText(zVar.Qy.get(0));
                } else {
                    this.bKt.setVisibility(4);
                }
                if (zVar.Qy.size() > 1 && !StringUtils.isNull(zVar.Qy.get(1))) {
                    this.bKu.setText(zVar.Qy.get(1));
                } else {
                    this.bKu.setVisibility(4);
                }
                com.baidu.tbadk.i.a.a(this.bHh.getPageContext(), this.bKq);
                return;
            }
            if (this.bKq != null) {
                this.bKq.setVisibility(8);
            }
            if (this.bKp != null) {
                this.bKp.setVisibility(8);
            }
        }
    }
}
