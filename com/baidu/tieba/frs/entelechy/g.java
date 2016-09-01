package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class g extends com.baidu.tieba.frs.view.c {
    private String aRv;
    protected com.baidu.adp.widget.ListView.w bQk;
    protected x bQl;
    protected AdapterLinearLayout bUX;
    protected TextView bUY;
    protected com.baidu.tieba.frs.view.x bUZ;
    protected ViewStub bVa;
    protected View bVb;
    protected ViewGroup bVc;
    protected TbImageView bVd;
    protected TextView bVe;
    protected TextView bVf;
    protected TextView bVg;
    private View.OnClickListener bVh = new h(this);

    public void acC() {
        this.bUX = (AdapterLinearLayout) this.cfX.findViewById(t.g.top_layout);
        this.bUY = (TextView) this.cfX.findViewById(t.g.top_item_type);
        this.bUY.setText(TbadkCoreApplication.m9getInst().getString(t.j.game));
        this.bUZ = new com.baidu.tieba.frs.view.x(this.Gd.getPageActivity());
    }

    public void b(com.baidu.adp.widget.ListView.w wVar) {
        this.bQk = wVar;
    }

    public void b(x xVar) {
        this.bQl = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acD() {
        if (this.bRp != null && this.bRp.aaR() != null && this.bUZ != null) {
            ArrayList arrayList = new ArrayList();
            List<com.baidu.adp.widget.ListView.v> bid = this.bRp.aaR().bid();
            if (bid != null) {
                for (int i = 0; i < y.s(bid); i++) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) y.c(bid, i);
                    if (vVar instanceof bg) {
                        arrayList.add((bg) vVar);
                    }
                }
            }
            this.bUX.setAdapter(this.bUZ);
            if (this.bUZ instanceof com.baidu.tieba.frs.g.e) {
                com.baidu.tieba.frs.view.x xVar = this.bUZ;
                if (com.baidu.tieba.frs.g.e.cdn != null && this.bRp.aaR() != null) {
                    if (this.bRp.aaR().fpX == 1) {
                        com.baidu.tieba.frs.g.e.cdn.cdd = true;
                    } else {
                        com.baidu.tieba.frs.g.e.cdn.cdd = false;
                    }
                    if (this.bRp.aaR().aLP() != null) {
                        com.baidu.tieba.frs.g.e.cdn.cdf = this.bRp.aaR().aLP().getId();
                    }
                    if (this.bRp != null && this.bRp.aaX() != null) {
                        com.baidu.tieba.frs.g.e.cdn.cde = this.bRp.aaV().acf();
                    }
                }
            }
            this.bUZ.c(this.bQk);
            this.bUZ.c(this.bQl);
            this.bUZ.setData(arrayList);
            this.bUZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acE() {
        if (this.bUZ != null) {
            this.bUZ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void acF() {
        if (this.bUZ != null) {
            this.bUZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acG() {
        if (this.bRp != null && this.bRp.aaR() != null && this.bRp.aaR().fqv != null) {
            com.baidu.tbadk.core.data.v vVar = this.bRp.aaR().fqv;
            this.aRv = this.bRp.aaR().aLP().getId();
            if (vVar != null && vVar.QP == 1) {
                if (this.bVa == null) {
                    this.bVa = (ViewStub) this.cfX.findViewById(t.g.frs_header_recommend_book);
                    this.bVa.setVisibility(0);
                }
                if (this.bVc == null) {
                    this.bVc = (ViewGroup) this.cfX.findViewById(t.g.root_recommend_book);
                }
                if (this.bVb == null) {
                    this.bVb = this.cfX.findViewById(t.g.divider_book);
                }
                if (this.bVd == null) {
                    this.bVd = (TbImageView) this.cfX.findViewById(t.g.book_image);
                }
                if (this.bVe == null) {
                    this.bVe = (TextView) this.cfX.findViewById(t.g.book_title);
                }
                if (this.bVf == null) {
                    this.bVf = (TextView) this.cfX.findViewById(t.g.book_desc_1);
                }
                if (this.bVg == null) {
                    this.bVg = (TextView) this.cfX.findViewById(t.g.book_desc_2);
                }
                this.bVc.setVisibility(0);
                this.bVb.setVisibility(0);
                this.bVc.setTag(vVar);
                this.bVc.setOnClickListener(this.bVh);
                this.bVd.c(vVar.image, 10, false);
                this.bVe.setText(vVar.title);
                if (vVar.QR.size() > 0 && !StringUtils.isNull(vVar.QR.get(0))) {
                    this.bVf.setText(vVar.QR.get(0));
                } else {
                    this.bVf.setVisibility(4);
                }
                if (vVar.QR.size() > 1 && !StringUtils.isNull(vVar.QR.get(1))) {
                    this.bVg.setText(vVar.QR.get(1));
                } else {
                    this.bVg.setVisibility(4);
                }
                com.baidu.tbadk.j.a.a(this.bRp.getPageContext(), this.bVc);
                return;
            }
            if (this.bVc != null) {
                this.bVc.setVisibility(8);
            }
            if (this.bVb != null) {
                this.bVb.setVisibility(8);
            }
        }
    }
}
