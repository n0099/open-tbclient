package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.tieba.frs.view.c {
    private String aMb;
    protected w bEG;
    protected x bEH;
    protected AdapterLinearLayout bJJ;
    protected TextView bJK;
    protected com.baidu.tieba.frs.view.x bJL;
    protected ViewStub bJM;
    protected View bJN;
    protected ViewGroup bJO;
    protected TbImageView bJP;
    protected TextView bJQ;
    protected TextView bJR;
    protected TextView bJS;
    private View.OnClickListener bJT = new c(this);

    public void XN() {
        this.bJJ = (AdapterLinearLayout) this.bUP.findViewById(u.g.top_layout);
        this.bJK = (TextView) this.bUP.findViewById(u.g.top_item_type);
        this.bJK.setText(TbadkCoreApplication.m10getInst().getString(u.j.game));
        this.bJL = new com.baidu.tieba.frs.view.x(this.DQ.getPageActivity());
    }

    public void b(w wVar) {
        this.bEG = wVar;
    }

    public void b(x xVar) {
        this.bEH = xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XO() {
        if (this.bGh != null && this.bGh.VU() != null && this.bJL != null) {
            ArrayList arrayList = new ArrayList();
            List<v> bex = this.bGh.VU().bex();
            if (bex != null) {
                for (int i = 0; i < y.s(bex); i++) {
                    v vVar = (v) y.c(bex, i);
                    if (vVar instanceof be) {
                        arrayList.add((be) vVar);
                    }
                }
            }
            this.bJJ.setAdapter(this.bJL);
            if (this.bJL instanceof com.baidu.tieba.frs.h.e) {
                com.baidu.tieba.frs.view.x xVar = this.bJL;
                if (com.baidu.tieba.frs.h.e.bSh != null && this.bGh.VU() != null) {
                    if (this.bGh.VU().fig == 1) {
                        com.baidu.tieba.frs.h.e.bSh.bRX = true;
                    } else {
                        com.baidu.tieba.frs.h.e.bSh.bRX = false;
                    }
                    if (this.bGh.VU().aGX() != null) {
                        com.baidu.tieba.frs.h.e.bSh.bRZ = this.bGh.VU().aGX().getId();
                    }
                    if (this.bGh != null && this.bGh.Wa() != null) {
                        com.baidu.tieba.frs.h.e.bSh.bRY = this.bGh.VY().Xi();
                    }
                }
            }
            this.bJL.c(this.bEG);
            this.bJL.c(this.bEH);
            this.bJL.setData(arrayList);
            this.bJL.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XP() {
        if (this.bJL != null) {
            this.bJL.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void XQ() {
        if (this.bJL != null) {
            this.bJL.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XR() {
        if (this.bGh != null && this.bGh.VU() != null && this.bGh.VU().fiF != null) {
            com.baidu.tbadk.core.data.u uVar = this.bGh.VU().fiF;
            this.aMb = this.bGh.VU().aGX().getId();
            if (uVar != null && uVar.Oe == 1) {
                if (this.bJM == null) {
                    this.bJM = (ViewStub) this.bUP.findViewById(u.g.frs_header_recommend_book);
                    this.bJM.setVisibility(0);
                }
                if (this.bJO == null) {
                    this.bJO = (ViewGroup) this.bUP.findViewById(u.g.root_recommend_book);
                }
                if (this.bJN == null) {
                    this.bJN = this.bUP.findViewById(u.g.divider_book);
                }
                if (this.bJP == null) {
                    this.bJP = (TbImageView) this.bUP.findViewById(u.g.book_image);
                }
                if (this.bJQ == null) {
                    this.bJQ = (TextView) this.bUP.findViewById(u.g.book_title);
                }
                if (this.bJR == null) {
                    this.bJR = (TextView) this.bUP.findViewById(u.g.book_desc_1);
                }
                if (this.bJS == null) {
                    this.bJS = (TextView) this.bUP.findViewById(u.g.book_desc_2);
                }
                this.bJO.setVisibility(0);
                this.bJN.setVisibility(0);
                this.bJO.setTag(uVar);
                this.bJO.setOnClickListener(this.bJT);
                this.bJP.c(uVar.image, 10, false);
                this.bJQ.setText(uVar.title);
                if (uVar.Of.size() > 0 && !StringUtils.isNull(uVar.Of.get(0))) {
                    this.bJR.setText(uVar.Of.get(0));
                } else {
                    this.bJR.setVisibility(4);
                }
                if (uVar.Of.size() > 1 && !StringUtils.isNull(uVar.Of.get(1))) {
                    this.bJS.setText(uVar.Of.get(1));
                } else {
                    this.bJS.setVisibility(4);
                }
                com.baidu.tbadk.j.a.a(this.bGh.getPageContext(), this.bJO);
                return;
            }
            if (this.bJO != null) {
                this.bJO.setVisibility(8);
            }
            if (this.bJN != null) {
                this.bJN.setVisibility(8);
            }
        }
    }
}
