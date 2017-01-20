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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends j {
    private com.baidu.tieba.tbadkCore.m bKD;
    private TextView bKE;
    private com.baidu.tbadk.core.data.t bKF;
    private ViewStub bKG;
    private TextView bKH;
    private TextView bKI;
    private ImageView bKJ;

    public u(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bKD = null;
        this.bKF = null;
        if (this.aPq != null) {
            this.aPq.setPadding(0, 0, 0, 0);
        }
        this.bKE = (TextView) this.Fo.findViewById(r.h.sign_done_bg);
        this.Fo.findViewById(r.h.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View Zu() {
        return LayoutInflater.from(this.bHh.getPageContext().getPageActivity()).inflate(r.j.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            this.bKD = nVar.bfM();
            this.bKF = nVar.bgk();
        }
        super.a(forumData, nVar);
        this.mImageUrl = this.bKD.bgw();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void ZI() {
        if (this.bKD != null && this.bXu != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bKD.bgv());
            this.bXu.rG().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bKD.bgw());
            this.bXu.rG().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void ZL() {
        if (this.bMf != null) {
            if (this.bKF == null || StringUtils.isNull(this.bKF.pL(), true)) {
                if (this.bKG != null) {
                    this.bKG.setVisibility(8);
                }
                this.bWY = true;
                if (this.bMf.bfN() == null || this.bMf.bfN().ps() == null || (this.bMf.bfN().ps().size() <= 0 && this.bKD != null)) {
                    this.bWR.setVisibility(8);
                    ArrayList<com.baidu.tbadk.core.data.s> arrayList = new ArrayList<>();
                    String str = "";
                    if (this.bMf.aJY() != null && this.bMf.aJY().getFrsBannerData() != null) {
                        str = this.bMf.aJY().getFrsBannerData().getValue();
                    }
                    com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s(this.bKD.bgv(), str, null);
                    sVar.an(true);
                    arrayList.add(sVar);
                    com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                    qVar.g(arrayList);
                    a(qVar);
                    return;
                }
                this.bWR.setVisibility(0);
                a(this.bMf.bfN());
                return;
            }
            ZP();
        }
    }

    private void ZP() {
        if (this.bHh != null && this.bKF != null && !StringUtils.isNull(this.bKF.pL(), true)) {
            if (this.bKG == null) {
                this.bKG = (ViewStub) this.Fo.findViewById(r.h.frs_star_cover_info);
            }
            this.bKG.setVisibility(0);
            if (this.bKH == null) {
                this.bKH = (TextView) this.Fo.findViewById(r.h.frs_star_cover_pic_author);
            }
            if (this.bKI == null) {
                this.bKI = (TextView) this.Fo.findViewById(r.h.frs_star_cover_post_author);
            }
            if (this.bKJ == null) {
                this.bKJ = (ImageView) this.Fo.findViewById(r.h.frs_star_cover_goto_h5);
            }
            this.bWY = false;
            if (this.bKF.pH()) {
                this.bKI.setVisibility(4);
            } else {
                this.bKI.setText(String.format(this.Fp.getString(r.l.star_cover_post_author), this.bKF.pJ()));
                this.bKI.setVisibility(0);
            }
            if (this.bKF.pI()) {
                this.bKH.setVisibility(4);
            } else {
                this.bKH.setText(String.format(this.Fp.getString(r.l.star_cover_pic_author), this.bKF.pK()));
                this.bKH.setVisibility(0);
            }
            ZQ();
            this.bKJ.setOnClickListener(new v(this));
            this.bWR.setVisibility(8);
            a(this.bKF.pN());
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(com.baidu.tbadk.core.data.q qVar) {
        super.a(qVar);
        if (this.bKF != null && !StringUtils.isNull(this.bKF.pL(), true)) {
            this.bWQ.setCallback(new w(this));
        }
    }

    private void ZQ() {
        if (this.bKF != null) {
            if (!this.bKF.pG()) {
                ap.j(this.bKJ, r.g.btn_frs_toutiao_n);
            } else {
                ap.j(this.bKJ, r.g.btn_frs_enter_n);
            }
            ap.i((View) this.bKH, r.e.cp_cont_i);
            ap.i((View) this.bKI, r.e.cp_cont_i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Mm() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bHh.getPageContext().getPageActivity(), "consume_6", "click");
        super.c(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(r.l.cancel_text, new x(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(r.l.open_now, new y(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void ZH() {
        ap.c(this.Fk, r.g.frs_text_color_selector, 1);
        ap.j(this.bWA, r.g.frs_star_btn_like);
        this.bWB.setVisibility(8);
        this.Fk.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.c(this.bWE, r.g.frs_text_color_selector, 1);
        ap.j(this.bWC, r.g.frs_star_btn_like);
        this.bWD.setVisibility(8);
        this.bWE.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.bWA.setOnClickListener(onClickListener);
        this.bWC.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void ZJ() {
        if (this.bXz > 0) {
            if (com.baidu.adp.lib.util.k.I(this.Fp.getPageActivity()) >= 480) {
                this.bWH.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            ap.c(this.bWH, r.g.frs_text_color_selector, 1);
            ap.j((View) this.bKE, r.g.frs_star_btn_like);
            this.bWH.setText(String.format(this.Fp.getString(r.l.miss_sign_days), Integer.valueOf(this.bXz)));
        } else {
            this.bWH.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.j((View) this.bKE, r.g.btn_frs_signed_bg_selector);
            ap.c(this.bWH, r.e.cp_link_tip_a, 1);
            if (this.bXy <= 0) {
                this.bWH.setText(this.Fp.getString(r.l.signed));
            } else {
                this.bWH.setText(String.format(this.Fp.getString(r.l.continuous_sign_days), Integer.valueOf(this.bXy)));
            }
        }
        this.bWG.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void ZN() {
        this.bXm.c(this.bWA, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void Mn() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.bKF != null && !StringUtils.isNull(this.bKF.pL(), true)) {
            ZQ();
        }
    }
}
