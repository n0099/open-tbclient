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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends j {
    private com.baidu.tieba.tbadkCore.n bEf;
    private TextView bEg;
    private com.baidu.tbadk.core.data.s bEh;
    private ViewStub bEi;
    private TextView bEj;
    private TextView bEk;
    private ImageView bEl;

    public u(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bEf = null;
        this.bEh = null;
        if (this.aTY != null) {
            this.aTY.setPadding(0, 0, 0, 0);
        }
        this.bEg = (TextView) this.Ge.findViewById(r.g.sign_done_bg);
        this.Ge.findViewById(r.g.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View Yq() {
        return LayoutInflater.from(this.bzH.getPageContext().getPageActivity()).inflate(r.h.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            this.bEf = oVar.bdY();
            this.bEh = oVar.bew();
        }
        super.a(forumData, oVar);
        this.mImageUrl = this.bEf.beI();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void YE() {
        if (this.bEf != null && this.bQQ != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bEf.beH());
            this.bQQ.rP().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bEf.beI());
            this.bQQ.rP().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void YH() {
        if (this.bFO != null) {
            if (this.bEh == null || StringUtils.isNull(this.bEh.pS(), true)) {
                if (this.bEi != null) {
                    this.bEi.setVisibility(8);
                }
                this.bQu = true;
                if (this.bFO.bdZ() == null || this.bFO.bdZ().pz() == null || (this.bFO.bdZ().pz().size() <= 0 && this.bEf != null)) {
                    this.bQn.setVisibility(8);
                    ArrayList<com.baidu.tbadk.core.data.r> arrayList = new ArrayList<>();
                    String str = "";
                    if (this.bFO.aIk() != null && this.bFO.aIk().getFrsBannerData() != null) {
                        str = this.bFO.aIk().getFrsBannerData().getValue();
                    }
                    com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r(this.bEf.beH(), str, null);
                    rVar.an(true);
                    arrayList.add(rVar);
                    com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                    pVar.g(arrayList);
                    a(pVar);
                    return;
                }
                this.bQn.setVisibility(0);
                a(this.bFO.bdZ());
                return;
            }
            YN();
        }
    }

    private void YN() {
        if (this.bzH != null && this.bEh != null && !StringUtils.isNull(this.bEh.pS(), true)) {
            if (this.bEi == null) {
                this.bEi = (ViewStub) this.Ge.findViewById(r.g.frs_star_cover_info);
            }
            this.bEi.setVisibility(0);
            if (this.bEj == null) {
                this.bEj = (TextView) this.Ge.findViewById(r.g.frs_star_cover_pic_author);
            }
            if (this.bEk == null) {
                this.bEk = (TextView) this.Ge.findViewById(r.g.frs_star_cover_post_author);
            }
            if (this.bEl == null) {
                this.bEl = (ImageView) this.Ge.findViewById(r.g.frs_star_cover_goto_h5);
            }
            this.bQu = false;
            if (this.bEh.pO()) {
                this.bEk.setVisibility(4);
            } else {
                this.bEk.setText(String.format(this.Gf.getString(r.j.star_cover_post_author), this.bEh.pQ()));
                this.bEk.setVisibility(0);
            }
            if (this.bEh.pP()) {
                this.bEj.setVisibility(4);
            } else {
                this.bEj.setText(String.format(this.Gf.getString(r.j.star_cover_pic_author), this.bEh.pR()));
                this.bEj.setVisibility(0);
            }
            YO();
            this.bEl.setOnClickListener(new v(this));
            this.bQn.setVisibility(8);
            a(this.bEh.pU());
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(com.baidu.tbadk.core.data.p pVar) {
        super.a(pVar);
        if (this.bEh != null && !StringUtils.isNull(this.bEh.pS(), true)) {
            this.bQm.setCallback(new w(this));
        }
    }

    private void YO() {
        if (this.bEh != null) {
            if (!this.bEh.pN()) {
                ar.k(this.bEl, r.f.btn_frs_toutiao_n);
            } else {
                ar.k(this.bEl, r.f.btn_frs_enter_n);
            }
            ar.j((View) this.bEj, r.d.cp_cont_i);
            ar.j((View) this.bEk, r.d.cp_cont_i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void YI() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bzH.getPageContext().getPageActivity(), "consume_6", "click");
        super.c(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(r.j.cancel_text, new x(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(r.j.open_now, new y(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void YD() {
        ar.c(this.Ga, r.f.frs_text_color_selector, 1);
        ar.k(this.bPV, r.f.frs_star_btn_like);
        this.bPW.setVisibility(8);
        this.Ga.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        ar.c(this.bPZ, r.f.frs_text_color_selector, 1);
        ar.k(this.bPX, r.f.frs_star_btn_like);
        this.bPY.setVisibility(8);
        this.bPZ.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.bPV.setOnClickListener(onClickListener);
        this.bPX.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void YF() {
        if (this.bQV > 0) {
            if (com.baidu.adp.lib.util.k.I(this.Gf.getPageActivity()) >= 480) {
                this.bQc.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            ar.c(this.bQc, r.f.frs_text_color_selector, 1);
            ar.k(this.bEg, r.f.frs_star_btn_like);
            this.bQc.setText(String.format(this.Gf.getString(r.j.miss_sign_days), Integer.valueOf(this.bQV)));
        } else {
            this.bQc.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            ar.k(this.bEg, r.f.btn_frs_signed_bg_selector);
            ar.c(this.bQc, r.d.cp_link_tip_a, 1);
            if (this.bQU <= 0) {
                this.bQc.setText(this.Gf.getString(r.j.signed));
            } else {
                this.bQc.setText(String.format(this.Gf.getString(r.j.continuous_sign_days), Integer.valueOf(this.bQU)));
            }
        }
        this.bQb.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void YL() {
        this.bQI.c(this.bPV, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void YJ() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.bEh != null && !StringUtils.isNull(this.bEh.pS(), true)) {
            YO();
        }
    }
}
