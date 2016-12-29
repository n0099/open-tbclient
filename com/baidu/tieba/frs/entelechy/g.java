package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.tieba.frs.view.c {
    protected AdapterLinearLayout bDM;
    protected TextView bDN;
    protected com.baidu.tieba.frs.view.y bDO;
    protected ViewStub bDP;
    protected View bDQ;
    protected ViewGroup bDR;
    protected TbImageView bDS;
    protected TextView bDT;
    protected TextView bDU;
    protected TextView bDV;
    private View.OnClickListener bDW = new h(this);
    protected com.baidu.adp.widget.ListView.w bzi;
    protected com.baidu.adp.widget.ListView.x bzj;
    private String fid;

    public void Yu() {
        this.bDM = (AdapterLinearLayout) this.bQh.findViewById(r.g.top_layout);
        this.bDN = (TextView) this.bQh.findViewById(r.g.top_item_type);
        this.bDN.setText(TbadkCoreApplication.m9getInst().getString(r.j.game));
        this.bDO = new com.baidu.tieba.frs.view.y(this.Gf.getPageActivity());
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.bzi = wVar;
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.bzj = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yv() {
        if (this.bzH != null && this.bzH.WF() != null && this.bDO != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> bfc = this.bzH.WF().bfc();
            if (bfc != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.x.s(bfc); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(bfc, i);
                    if (vVar instanceof bg) {
                        arrayList.add((bg) vVar);
                    }
                }
            }
            this.bDM.setAdapter(this.bDO);
            if (this.bDO instanceof com.baidu.tieba.frs.g.e) {
                com.baidu.tieba.frs.view.y yVar = this.bDO;
                if (com.baidu.tieba.frs.g.e.bMV != null && this.bzH.WF() != null) {
                    if (this.bzH.WF().fdP == 1) {
                        com.baidu.tieba.frs.g.e.bMV.bML = true;
                    } else {
                        com.baidu.tieba.frs.g.e.bMV.bML = false;
                    }
                    if (this.bzH.WF().aIk() != null) {
                        com.baidu.tieba.frs.g.e.bMV.bMN = this.bzH.WF().aIk().getId();
                    }
                    if (this.bzH != null && this.bzH.Wi() != null) {
                        com.baidu.tieba.frs.g.e.bMV.bMM = this.bzH.Wh().aaU();
                    }
                }
            }
            this.bDO.c(this.bzi);
            this.bDO.c(this.bzj);
            this.bDO.setData(arrayList);
            this.bDO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yw() {
        if (this.bDO != null) {
            this.bDO.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Yx() {
        if (this.bDO != null) {
            this.bDO.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yy() {
        if (this.bzH != null && this.bzH.WF() != null && this.bzH.WF().fep != null) {
            com.baidu.tbadk.core.data.y yVar = this.bzH.WF().fep;
            this.fid = this.bzH.WF().aIk().getId();
            if (yVar != null && yVar.Ro == 1) {
                if (this.bDP == null) {
                    this.bDP = (ViewStub) this.bQh.findViewById(r.g.frs_header_recommend_book);
                    this.bDP.setVisibility(0);
                }
                if (this.bDR == null) {
                    this.bDR = (ViewGroup) this.bQh.findViewById(r.g.root_recommend_book);
                }
                if (this.bDQ == null) {
                    this.bDQ = this.bQh.findViewById(r.g.divider_book);
                }
                if (this.bDS == null) {
                    this.bDS = (TbImageView) this.bQh.findViewById(r.g.book_image);
                }
                if (this.bDT == null) {
                    this.bDT = (TextView) this.bQh.findViewById(r.g.book_title);
                }
                if (this.bDU == null) {
                    this.bDU = (TextView) this.bQh.findViewById(r.g.book_desc_1);
                }
                if (this.bDV == null) {
                    this.bDV = (TextView) this.bQh.findViewById(r.g.book_desc_2);
                }
                this.bDR.setVisibility(0);
                this.bDQ.setVisibility(0);
                this.bDR.setTag(yVar);
                this.bDR.setOnClickListener(this.bDW);
                this.bDS.c(yVar.image, 10, false);
                this.bDT.setText(yVar.title);
                if (yVar.Rp.size() > 0 && !StringUtils.isNull(yVar.Rp.get(0))) {
                    this.bDU.setText(yVar.Rp.get(0));
                } else {
                    this.bDU.setVisibility(4);
                }
                if (yVar.Rp.size() > 1 && !StringUtils.isNull(yVar.Rp.get(1))) {
                    this.bDV.setText(yVar.Rp.get(1));
                } else {
                    this.bDV.setVisibility(4);
                }
                com.baidu.tbadk.i.a.a(this.bzH.getPageContext(), this.bDR);
                return;
            }
            if (this.bDR != null) {
                this.bDR.setVisibility(8);
            }
            if (this.bDQ != null) {
                this.bDQ.setVisibility(8);
            }
        }
    }
}
