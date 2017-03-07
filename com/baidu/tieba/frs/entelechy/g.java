package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.tieba.frs.view.c {
    protected com.baidu.adp.widget.ListView.w bNR;
    protected com.baidu.adp.widget.ListView.x bNS;
    protected TextView bRA;
    private View.OnClickListener bRB = new h(this);
    protected AdapterLinearLayout bRr;
    protected TextView bRs;
    protected com.baidu.tieba.frs.view.w bRt;
    protected ViewStub bRu;
    protected View bRv;
    protected ViewGroup bRw;
    protected TbImageView bRx;
    protected TextView bRy;
    protected TextView bRz;
    private String fid;

    public void aav() {
        this.bRr = (AdapterLinearLayout) this.cek.findViewById(w.h.top_layout);
        this.bRs = (TextView) this.cek.findViewById(w.h.top_item_type);
        this.bRs.setText(TbadkCoreApplication.m9getInst().getString(w.l.game));
        this.bRt = new com.baidu.tieba.frs.view.w(this.aaI.getPageActivity());
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bNR = wVar;
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bNS = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaw() {
        if (this.bOq != null && this.bOq.YV() != null && this.bRt != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> bgE = this.bOq.YV().bgE();
            if (bgE != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.x.p(bgE); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(bgE, i);
                    if (vVar instanceof bj) {
                        arrayList.add((bj) vVar);
                    }
                }
            }
            this.bRr.setAdapter(this.bRt);
            if (this.bRt instanceof com.baidu.tieba.frs.e.e) {
                com.baidu.tieba.frs.view.w wVar = this.bRt;
                if (com.baidu.tieba.frs.e.e.cav != null && this.bOq.YV() != null) {
                    if (this.bOq.YV().frI == 1) {
                        com.baidu.tieba.frs.e.e.cav.cal = true;
                    } else {
                        com.baidu.tieba.frs.e.e.cav.cal = false;
                    }
                    if (this.bOq.YV().aJp() != null) {
                        com.baidu.tieba.frs.e.e.cav.can = this.bOq.YV().aJp().getId();
                    }
                    if (this.bOq != null && this.bOq.Yy() != null) {
                        com.baidu.tieba.frs.e.e.cav.cam = this.bOq.Yx().acX();
                    }
                }
            }
            this.bRt.b(this.bNR);
            this.bRt.b(this.bNS);
            this.bRt.setData(arrayList);
            this.bRt.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aax() {
        if (this.bRt != null) {
            this.bRt.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void aay() {
        if (this.bRt != null) {
            this.bRt.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaz() {
        if (this.bOq != null && this.bOq.YV() != null && this.bOq.YV().fsh != null) {
            aa aaVar = this.bOq.YV().fsh;
            this.fid = this.bOq.YV().aJp().getId();
            if (aaVar != null && aaVar.VK == 1) {
                if (this.bRu == null) {
                    this.bRu = (ViewStub) this.cek.findViewById(w.h.frs_header_recommend_book);
                    this.bRu.setVisibility(0);
                }
                if (this.bRw == null) {
                    this.bRw = (ViewGroup) this.cek.findViewById(w.h.root_recommend_book);
                }
                if (this.bRv == null) {
                    this.bRv = this.cek.findViewById(w.h.divider_book);
                }
                if (this.bRx == null) {
                    this.bRx = (TbImageView) this.cek.findViewById(w.h.book_image);
                }
                if (this.bRy == null) {
                    this.bRy = (TextView) this.cek.findViewById(w.h.book_title);
                }
                if (this.bRz == null) {
                    this.bRz = (TextView) this.cek.findViewById(w.h.book_desc_1);
                }
                if (this.bRA == null) {
                    this.bRA = (TextView) this.cek.findViewById(w.h.book_desc_2);
                }
                this.bRw.setVisibility(0);
                this.bRv.setVisibility(0);
                this.bRw.setTag(aaVar);
                this.bRw.setOnClickListener(this.bRB);
                this.bRx.c(aaVar.image, 10, false);
                this.bRy.setText(aaVar.title);
                if (aaVar.VL.size() > 0 && !StringUtils.isNull(aaVar.VL.get(0))) {
                    this.bRz.setText(aaVar.VL.get(0));
                } else {
                    this.bRz.setVisibility(4);
                }
                if (aaVar.VL.size() > 1 && !StringUtils.isNull(aaVar.VL.get(1))) {
                    this.bRA.setText(aaVar.VL.get(1));
                } else {
                    this.bRA.setVisibility(4);
                }
                com.baidu.tbadk.i.a.a(this.bOq.getPageContext(), this.bRw);
                return;
            }
            if (this.bRw != null) {
                this.bRw.setVisibility(8);
            }
            if (this.bRv != null) {
                this.bRv.setVisibility(8);
            }
        }
    }
}
