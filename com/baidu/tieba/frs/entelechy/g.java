package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.tieba.frs.view.c {
    protected com.baidu.adp.widget.ListView.w bSX;
    protected com.baidu.adp.widget.ListView.x bSY;
    protected AdapterLinearLayout bXY;
    protected TextView bXZ;
    protected com.baidu.tieba.frs.view.y bYa;
    protected ViewStub bYb;
    protected View bYc;
    protected ViewGroup bYd;
    protected TbImageView bYe;
    protected TextView bYf;
    protected TextView bYg;
    protected TextView bYh;
    private View.OnClickListener bYi = new h(this);
    private String fid;

    public void aeb() {
        this.bXY = (AdapterLinearLayout) this.ckX.findViewById(r.g.top_layout);
        this.bXZ = (TextView) this.ckX.findViewById(r.g.top_item_type);
        this.bXZ.setText(TbadkCoreApplication.m9getInst().getString(r.j.game));
        this.bYa = new com.baidu.tieba.frs.view.y(this.Gf.getPageActivity());
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.bSX = wVar;
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.bSY = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aec() {
        if (this.bTA != null && this.bTA.acr() != null && this.bYa != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> bln = this.bTA.acr().bln();
            if (bln != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.x.s(bln); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(bln, i);
                    if (vVar instanceof bk) {
                        arrayList.add((bk) vVar);
                    }
                }
            }
            this.bXY.setAdapter(this.bYa);
            if (this.bYa instanceof com.baidu.tieba.frs.h.e) {
                com.baidu.tieba.frs.view.y yVar = this.bYa;
                if (com.baidu.tieba.frs.h.e.chm != null && this.bTA.acr() != null) {
                    if (this.bTA.acr().fzN == 1) {
                        com.baidu.tieba.frs.h.e.chm.chc = true;
                    } else {
                        com.baidu.tieba.frs.h.e.chm.chc = false;
                    }
                    if (this.bTA.acr().aOk() != null) {
                        com.baidu.tieba.frs.h.e.chm.che = this.bTA.acr().aOk().getId();
                    }
                    if (this.bTA != null && this.bTA.abT() != null) {
                        com.baidu.tieba.frs.h.e.chm.chd = this.bTA.abS().agx();
                    }
                }
            }
            this.bYa.c(this.bSX);
            this.bYa.c(this.bSY);
            this.bYa.setData(arrayList);
            this.bYa.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aed() {
        if (this.bYa != null) {
            this.bYa.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void aee() {
        if (this.bYa != null) {
            this.bYa.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aef() {
        if (this.bTA != null && this.bTA.acr() != null && this.bTA.acr().fAm != null) {
            z zVar = this.bTA.acr().fAm;
            this.fid = this.bTA.acr().aOk().getId();
            if (zVar != null && zVar.Rr == 1) {
                if (this.bYb == null) {
                    this.bYb = (ViewStub) this.ckX.findViewById(r.g.frs_header_recommend_book);
                    this.bYb.setVisibility(0);
                }
                if (this.bYd == null) {
                    this.bYd = (ViewGroup) this.ckX.findViewById(r.g.root_recommend_book);
                }
                if (this.bYc == null) {
                    this.bYc = this.ckX.findViewById(r.g.divider_book);
                }
                if (this.bYe == null) {
                    this.bYe = (TbImageView) this.ckX.findViewById(r.g.book_image);
                }
                if (this.bYf == null) {
                    this.bYf = (TextView) this.ckX.findViewById(r.g.book_title);
                }
                if (this.bYg == null) {
                    this.bYg = (TextView) this.ckX.findViewById(r.g.book_desc_1);
                }
                if (this.bYh == null) {
                    this.bYh = (TextView) this.ckX.findViewById(r.g.book_desc_2);
                }
                this.bYd.setVisibility(0);
                this.bYc.setVisibility(0);
                this.bYd.setTag(zVar);
                this.bYd.setOnClickListener(this.bYi);
                this.bYe.c(zVar.image, 10, false);
                this.bYf.setText(zVar.title);
                if (zVar.Rs.size() > 0 && !StringUtils.isNull(zVar.Rs.get(0))) {
                    this.bYg.setText(zVar.Rs.get(0));
                } else {
                    this.bYg.setVisibility(4);
                }
                if (zVar.Rs.size() > 1 && !StringUtils.isNull(zVar.Rs.get(1))) {
                    this.bYh.setText(zVar.Rs.get(1));
                } else {
                    this.bYh.setVisibility(4);
                }
                com.baidu.tbadk.i.a.a(this.bTA.getPageContext(), this.bYd);
                return;
            }
            if (this.bYd != null) {
                this.bYd.setVisibility(8);
            }
            if (this.bYc != null) {
                this.bYc.setVisibility(8);
            }
        }
    }
}
