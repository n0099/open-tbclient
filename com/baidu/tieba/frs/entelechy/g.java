package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.tieba.frs.view.c {
    protected com.baidu.adp.widget.ListView.w bQd;
    protected com.baidu.adp.widget.ListView.x bQe;
    protected AdapterLinearLayout bUQ;
    protected TextView bUR;
    protected com.baidu.tieba.frs.view.x bUS;
    protected ViewStub bUT;
    protected View bUU;
    protected ViewGroup bUV;
    protected TbImageView bUW;
    protected TextView bUX;
    protected TextView bUY;
    protected TextView bUZ;
    private View.OnClickListener bVa = new h(this);
    private String fid;

    public void acO() {
        this.bUQ = (AdapterLinearLayout) this.cfU.findViewById(r.g.top_layout);
        this.bUR = (TextView) this.cfU.findViewById(r.g.top_item_type);
        this.bUR.setText(TbadkCoreApplication.m9getInst().getString(r.j.game));
        this.bUS = new com.baidu.tieba.frs.view.x(this.Gd.getPageActivity());
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.bQd = wVar;
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        this.bQe = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acP() {
        if (this.bRi != null && this.bRi.abe() != null && this.bUS != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> biO = this.bRi.abe().biO();
            if (biO != null) {
                for (int i = 0; i < com.baidu.tbadk.core.util.y.s(biO); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(biO, i);
                    if (vVar instanceof bi) {
                        arrayList.add((bi) vVar);
                    }
                }
            }
            this.bUQ.setAdapter(this.bUS);
            if (this.bUS instanceof com.baidu.tieba.frs.g.e) {
                com.baidu.tieba.frs.view.x xVar = this.bUS;
                if (com.baidu.tieba.frs.g.e.cdl != null && this.bRi.abe() != null) {
                    if (this.bRi.abe().fsD == 1) {
                        com.baidu.tieba.frs.g.e.cdl.cdb = true;
                    } else {
                        com.baidu.tieba.frs.g.e.cdl.cdb = false;
                    }
                    if (this.bRi.abe().aMr() != null) {
                        com.baidu.tieba.frs.g.e.cdl.cdd = this.bRi.abe().aMr().getId();
                    }
                    if (this.bRi != null && this.bRi.abk() != null) {
                        com.baidu.tieba.frs.g.e.cdl.cdc = this.bRi.abi().acs();
                    }
                }
            }
            this.bUS.c(this.bQd);
            this.bUS.c(this.bQe);
            this.bUS.setData(arrayList);
            this.bUS.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acQ() {
        if (this.bUS != null) {
            this.bUS.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void acR() {
        if (this.bUS != null) {
            this.bUS.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acS() {
        if (this.bRi != null && this.bRi.abe() != null && this.bRi.abe().ftc != null) {
            com.baidu.tbadk.core.data.x xVar = this.bRi.abe().ftc;
            this.fid = this.bRi.abe().aMr().getId();
            if (xVar != null && xVar.QW == 1) {
                if (this.bUT == null) {
                    this.bUT = (ViewStub) this.cfU.findViewById(r.g.frs_header_recommend_book);
                    this.bUT.setVisibility(0);
                }
                if (this.bUV == null) {
                    this.bUV = (ViewGroup) this.cfU.findViewById(r.g.root_recommend_book);
                }
                if (this.bUU == null) {
                    this.bUU = this.cfU.findViewById(r.g.divider_book);
                }
                if (this.bUW == null) {
                    this.bUW = (TbImageView) this.cfU.findViewById(r.g.book_image);
                }
                if (this.bUX == null) {
                    this.bUX = (TextView) this.cfU.findViewById(r.g.book_title);
                }
                if (this.bUY == null) {
                    this.bUY = (TextView) this.cfU.findViewById(r.g.book_desc_1);
                }
                if (this.bUZ == null) {
                    this.bUZ = (TextView) this.cfU.findViewById(r.g.book_desc_2);
                }
                this.bUV.setVisibility(0);
                this.bUU.setVisibility(0);
                this.bUV.setTag(xVar);
                this.bUV.setOnClickListener(this.bVa);
                this.bUW.c(xVar.image, 10, false);
                this.bUX.setText(xVar.title);
                if (xVar.QX.size() > 0 && !StringUtils.isNull(xVar.QX.get(0))) {
                    this.bUY.setText(xVar.QX.get(0));
                } else {
                    this.bUY.setVisibility(4);
                }
                if (xVar.QX.size() > 1 && !StringUtils.isNull(xVar.QX.get(1))) {
                    this.bUZ.setText(xVar.QX.get(1));
                } else {
                    this.bUZ.setVisibility(4);
                }
                com.baidu.tbadk.i.a.a(this.bRi.getPageContext(), this.bUV);
                return;
            }
            if (this.bUV != null) {
                this.bUV.setVisibility(8);
            }
            if (this.bUU != null) {
                this.bUU.setVisibility(8);
            }
        }
    }
}
