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
    protected com.baidu.adp.widget.ListView.w bPX;
    protected com.baidu.adp.widget.ListView.x bPY;
    protected ViewStub bTA;
    protected View bTB;
    protected ViewGroup bTC;
    protected TbImageView bTD;
    protected TextView bTE;
    protected TextView bTF;
    protected TextView bTG;
    private View.OnClickListener bTH = new h(this);
    protected AdapterLinearLayout bTx;
    protected TextView bTy;
    protected com.baidu.tieba.frs.view.w bTz;
    private String fid;

    public void abU() {
        this.bTx = (AdapterLinearLayout) this.cfc.findViewById(w.h.top_layout);
        this.bTy = (TextView) this.cfc.findViewById(w.h.top_item_type);
        this.bTy.setText(TbadkCoreApplication.m9getInst().getString(w.l.game));
        this.bTz = new com.baidu.tieba.frs.view.w(this.aaY.getPageActivity());
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bPX = wVar;
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bPY = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abV() {
        if (this.bQw != null && this.bQw.aas() != null && this.bTz != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> biq = this.bQw.aas().biq();
            if (biq != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.x.p(biq); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(biq, i);
                    if (vVar instanceof bi) {
                        arrayList.add((bi) vVar);
                    }
                }
            }
            this.bTx.setAdapter(this.bTz);
            if (this.bTz instanceof com.baidu.tieba.frs.e.e) {
                com.baidu.tieba.frs.view.w wVar = this.bTz;
                if (com.baidu.tieba.frs.e.e.cbn != null && this.bQw.aas() != null) {
                    if (this.bQw.aas().fvK == 1) {
                        com.baidu.tieba.frs.e.e.cbn.cbd = true;
                    } else {
                        com.baidu.tieba.frs.e.e.cbn.cbd = false;
                    }
                    if (this.bQw.aas().aKx() != null) {
                        com.baidu.tieba.frs.e.e.cbn.cbf = this.bQw.aas().aKx().getId();
                    }
                    if (this.bQw != null && this.bQw.ZV() != null) {
                        com.baidu.tieba.frs.e.e.cbn.cbe = this.bQw.ZU().adS();
                    }
                }
            }
            this.bTz.b(this.bPX);
            this.bTz.b(this.bPY);
            this.bTz.setData(arrayList);
            this.bTz.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abW() {
        if (this.bTz != null) {
            this.bTz.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void abX() {
        if (this.bTz != null) {
            this.bTz.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abY() {
        if (this.bQw != null && this.bQw.aas() != null && this.bQw.aas().fwi != null) {
            aa aaVar = this.bQw.aas().fwi;
            this.fid = this.bQw.aas().aKx().getId();
            if (aaVar != null && aaVar.Wd == 1) {
                if (this.bTA == null) {
                    this.bTA = (ViewStub) this.cfc.findViewById(w.h.frs_header_recommend_book);
                    this.bTA.setVisibility(0);
                }
                if (this.bTC == null) {
                    this.bTC = (ViewGroup) this.cfc.findViewById(w.h.root_recommend_book);
                }
                if (this.bTB == null) {
                    this.bTB = this.cfc.findViewById(w.h.divider_book);
                }
                if (this.bTD == null) {
                    this.bTD = (TbImageView) this.cfc.findViewById(w.h.book_image);
                }
                if (this.bTE == null) {
                    this.bTE = (TextView) this.cfc.findViewById(w.h.book_title);
                }
                if (this.bTF == null) {
                    this.bTF = (TextView) this.cfc.findViewById(w.h.book_desc_1);
                }
                if (this.bTG == null) {
                    this.bTG = (TextView) this.cfc.findViewById(w.h.book_desc_2);
                }
                this.bTC.setVisibility(0);
                this.bTB.setVisibility(0);
                this.bTC.setTag(aaVar);
                this.bTC.setOnClickListener(this.bTH);
                this.bTD.c(aaVar.image, 10, false);
                this.bTE.setText(aaVar.title);
                if (aaVar.We.size() > 0 && !StringUtils.isNull(aaVar.We.get(0))) {
                    this.bTF.setText(aaVar.We.get(0));
                } else {
                    this.bTF.setVisibility(4);
                }
                if (aaVar.We.size() > 1 && !StringUtils.isNull(aaVar.We.get(1))) {
                    this.bTG.setText(aaVar.We.get(1));
                } else {
                    this.bTG.setVisibility(4);
                }
                com.baidu.tbadk.m.a.a(this.bQw.getPageContext(), this.bTC);
                return;
            }
            if (this.bTC != null) {
                this.bTC.setVisibility(8);
            }
            if (this.bTB != null) {
                this.bTB.setVisibility(8);
            }
        }
    }
}
