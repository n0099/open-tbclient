package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.tieba.frs.view.c {
    protected com.baidu.adp.widget.ListView.w bNG;
    protected com.baidu.adp.widget.ListView.x bNH;
    protected AdapterLinearLayout bRg;
    protected TextView bRh;
    protected com.baidu.tieba.frs.view.w bRi;
    protected ViewStub bRj;
    protected View bRk;
    protected ViewGroup bRl;
    protected TbImageView bRm;
    protected TextView bRn;
    protected TextView bRo;
    protected TextView bRp;
    private View.OnClickListener bRq = new h(this);
    private String fid;

    public void aaT() {
        this.bRg = (AdapterLinearLayout) this.ccL.findViewById(w.h.top_layout);
        this.bRh = (TextView) this.ccL.findViewById(w.h.top_item_type);
        this.bRh.setText(TbadkCoreApplication.m9getInst().getString(w.l.game));
        this.bRi = new com.baidu.tieba.frs.view.w(this.aaX.getPageActivity());
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bNG = wVar;
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bNH = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaU() {
        if (this.bOf != null && this.bOf.Zr() != null && this.bRi != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> bhp = this.bOf.Zr().bhp();
            if (bhp != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.x.p(bhp); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(bhp, i);
                    if (vVar instanceof bi) {
                        arrayList.add((bi) vVar);
                    }
                }
            }
            this.bRg.setAdapter(this.bRi);
            if (this.bRi instanceof com.baidu.tieba.frs.e.e) {
                com.baidu.tieba.frs.view.w wVar = this.bRi;
                if (com.baidu.tieba.frs.e.e.bYW != null && this.bOf.Zr() != null) {
                    if (this.bOf.Zr().ftt == 1) {
                        com.baidu.tieba.frs.e.e.bYW.bYM = true;
                    } else {
                        com.baidu.tieba.frs.e.e.bYW.bYM = false;
                    }
                    if (this.bOf.Zr().aJw() != null) {
                        com.baidu.tieba.frs.e.e.bYW.bYO = this.bOf.Zr().aJw().getId();
                    }
                    if (this.bOf != null && this.bOf.YU() != null) {
                        com.baidu.tieba.frs.e.e.bYW.bYN = this.bOf.YT().acR();
                    }
                }
            }
            this.bRi.b(this.bNG);
            this.bRi.b(this.bNH);
            this.bRi.setData(arrayList);
            this.bRi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaV() {
        if (this.bRi != null) {
            this.bRi.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void aaW() {
        if (this.bRi != null) {
            this.bRi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaX() {
        if (this.bOf != null && this.bOf.Zr() != null && this.bOf.Zr().ftR != null) {
            aa aaVar = this.bOf.Zr().ftR;
            this.fid = this.bOf.Zr().aJw().getId();
            if (aaVar != null && aaVar.Wb == 1) {
                if (this.bRj == null) {
                    this.bRj = (ViewStub) this.ccL.findViewById(w.h.frs_header_recommend_book);
                    this.bRj.setVisibility(0);
                }
                if (this.bRl == null) {
                    this.bRl = (ViewGroup) this.ccL.findViewById(w.h.root_recommend_book);
                }
                if (this.bRk == null) {
                    this.bRk = this.ccL.findViewById(w.h.divider_book);
                }
                if (this.bRm == null) {
                    this.bRm = (TbImageView) this.ccL.findViewById(w.h.book_image);
                }
                if (this.bRn == null) {
                    this.bRn = (TextView) this.ccL.findViewById(w.h.book_title);
                }
                if (this.bRo == null) {
                    this.bRo = (TextView) this.ccL.findViewById(w.h.book_desc_1);
                }
                if (this.bRp == null) {
                    this.bRp = (TextView) this.ccL.findViewById(w.h.book_desc_2);
                }
                this.bRl.setVisibility(0);
                this.bRk.setVisibility(0);
                this.bRl.setTag(aaVar);
                this.bRl.setOnClickListener(this.bRq);
                this.bRm.c(aaVar.image, 10, false);
                this.bRn.setText(aaVar.title);
                if (aaVar.Wc.size() > 0 && !StringUtils.isNull(aaVar.Wc.get(0))) {
                    this.bRo.setText(aaVar.Wc.get(0));
                } else {
                    this.bRo.setVisibility(4);
                }
                if (aaVar.Wc.size() > 1 && !StringUtils.isNull(aaVar.Wc.get(1))) {
                    this.bRp.setText(aaVar.Wc.get(1));
                } else {
                    this.bRp.setVisibility(4);
                }
                com.baidu.tbadk.m.a.a(this.bOf.getPageContext(), this.bRl);
                return;
            }
            if (this.bRl != null) {
                this.bRl.setVisibility(8);
            }
            if (this.bRk != null) {
                this.bRk.setVisibility(8);
            }
        }
    }
}
