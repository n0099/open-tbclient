package com.baidu.tieba.frs.entelechy;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends j {
    private com.baidu.tieba.tbadkCore.m bRJ;
    private TextView bRK;
    private com.baidu.tbadk.core.data.u bRL;
    private ViewStub bRM;
    private TextView bRN;
    private TextView bRO;
    private ImageView bRP;

    public u(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bRJ = null;
        this.bRL = null;
        if (this.aVc != null) {
            this.aVc.setPadding(0, 0, 0, 0);
        }
        this.bRK = (TextView) this.aWX.findViewById(w.h.sign_done_bg);
        this.aWX.findViewById(w.h.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View aar() {
        return LayoutInflater.from(this.bOq.getPageContext().getPageActivity()).inflate(w.j.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            this.bRJ = nVar.bfz();
            this.bRL = nVar.bfX();
        }
        super.a(forumData, nVar);
        this.mImageUrl = this.bRJ.bgj();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void aaF() {
        if (this.bRJ != null && this.ceS != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bRJ.bgi());
            this.ceS.sa().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bRJ.bgj());
            this.ceS.sa().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void aaI() {
        if (this.bTl != null) {
            if (this.bRL == null || StringUtils.isNull(this.bRL.qd(), true)) {
                if (this.bRM != null) {
                    this.bRM.setVisibility(8);
                }
                this.cew = true;
                if (this.bTl.bfA() == null || this.bTl.bfA().pK() == null || (this.bTl.bfA().pK().size() <= 0 && this.bRJ != null)) {
                    this.cep.setVisibility(8);
                    ArrayList<com.baidu.tbadk.core.data.t> arrayList = new ArrayList<>();
                    String str = "";
                    if (this.bTl.aJp() != null && this.bTl.aJp().getFrsBannerData() != null) {
                        str = this.bTl.aJp().getFrsBannerData().getValue();
                    }
                    com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t(this.bRJ.bgi(), str, null);
                    tVar.am(true);
                    arrayList.add(tVar);
                    com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r();
                    rVar.f(arrayList);
                    a(rVar);
                    return;
                }
                this.cep.setVisibility(0);
                a(this.bTl.bfA());
                return;
            }
            aaM();
        }
    }

    private void aaM() {
        if (this.bOq != null && this.bRL != null && !StringUtils.isNull(this.bRL.qd(), true)) {
            if (this.bRM == null) {
                this.bRM = (ViewStub) this.aWX.findViewById(w.h.frs_star_cover_info);
            }
            this.bRM.setVisibility(0);
            if (this.bRN == null) {
                this.bRN = (TextView) this.aWX.findViewById(w.h.frs_star_cover_pic_author);
            }
            if (this.bRO == null) {
                this.bRO = (TextView) this.aWX.findViewById(w.h.frs_star_cover_post_author);
            }
            if (this.bRP == null) {
                this.bRP = (ImageView) this.aWX.findViewById(w.h.frs_star_cover_goto_h5);
            }
            this.cew = false;
            if (this.bRL.pZ()) {
                this.bRO.setVisibility(4);
            } else {
                this.bRO.setText(String.format(this.aaI.getString(w.l.star_cover_post_author), this.bRL.qb()));
                this.bRO.setVisibility(0);
            }
            if (this.bRL.qa()) {
                this.bRN.setVisibility(4);
            } else {
                this.bRN.setText(String.format(this.aaI.getString(w.l.star_cover_pic_author), this.bRL.qc()));
                this.bRN.setVisibility(0);
            }
            aaN();
            this.bRP.setOnClickListener(new v(this));
            this.cep.setVisibility(8);
            a(this.bRL.qf());
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(com.baidu.tbadk.core.data.r rVar) {
        super.a(rVar);
        if (this.bRL != null && !StringUtils.isNull(this.bRL.qd(), true)) {
            this.ceo.setCallback(new w(this));
        }
    }

    private void aaN() {
        if (this.bRL != null) {
            if (!this.bRL.pY()) {
                aq.j(this.bRP, w.g.btn_frs_toutiao_n);
            } else {
                aq.j(this.bRP, w.g.btn_frs_enter_n);
            }
            aq.i((View) this.bRN, w.e.cp_cont_i);
            aq.i((View) this.bRO, w.e.cp_cont_i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void MY() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bOq.getPageContext().getPageActivity(), "consume_6", "click");
        super.c(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(w.l.cancel_text, new x(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(w.l.open_now, new y(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void aaE() {
        aq.c(this.cdZ, w.g.frs_text_color_selector, 1);
        aq.j(this.cdX, w.g.frs_star_btn_like);
        this.cdY.setVisibility(8);
        this.cdZ.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.c(this.cec, w.g.frs_text_color_selector, 1);
        aq.j(this.cea, w.g.frs_star_btn_like);
        this.ceb.setVisibility(8);
        this.cec.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.cdX.setOnClickListener(onClickListener);
        this.cea.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void aaG() {
        if (this.ceW > 0) {
            if (com.baidu.adp.lib.util.k.ag(this.aaI.getPageActivity()) >= 480) {
                this.cef.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            aq.c(this.cef, w.g.frs_text_color_selector, 1);
            aq.j(this.bRK, w.g.frs_star_btn_like);
            this.cef.setText(String.format(this.aaI.getString(w.l.miss_sign_days), Integer.valueOf(this.ceW)));
        } else {
            this.cef.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.j(this.bRK, w.g.btn_frs_signed_bg_selector);
            aq.c(this.cef, w.e.cp_link_tip_a, 1);
            if (this.ceV <= 0) {
                this.cef.setText(this.aaI.getString(w.l.signed));
            } else {
                this.cef.setText(String.format(this.aaI.getString(w.l.continuous_sign_days), Integer.valueOf(this.ceV)));
            }
        }
        this.cee.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void aaK() {
        this.ceK.c(this.cdX, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void MZ() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.bRL != null && !StringUtils.isNull(this.bRL.qd(), true)) {
            aaN();
        }
    }
}
