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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends j {
    private com.baidu.tieba.tbadkCore.o bVk;
    private TextView bVl;
    private com.baidu.tbadk.core.data.s bVm;
    private ViewStub bVn;
    private TextView bVo;
    private TextView bVp;
    private ImageView bVq;

    public u(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bVk = null;
        this.bVm = null;
        if (this.aSG != null) {
            this.aSG.setPadding(0, 0, 0, 0);
        }
        this.bVl = (TextView) this.Gc.findViewById(r.g.sign_done_bg);
        this.Gc.findViewById(r.g.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View acK() {
        return LayoutInflater.from(this.bRi.getPageContext().getPageActivity()).inflate(r.h.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            this.bVk = pVar.bhN();
            this.bVm = pVar.bil();
        }
        super.a(forumData, pVar);
        this.mImageUrl = this.bVk.biu();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void acY() {
        if (this.bVk != null && this.cgA != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bVk.bit());
            this.cgA.rW().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bVk.biu());
            this.cgA.rW().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void adb() {
        if (this.bWN != null) {
            if (this.bVm == null || StringUtils.isNull(this.bVm.pO(), true)) {
                if (this.bVn != null) {
                    this.bVn.setVisibility(8);
                }
                this.cgf = true;
                if (this.bWN.bhO() == null || this.bWN.bhO().pw() == null || (this.bWN.bhO().pw().size() <= 0 && this.bVk != null)) {
                    this.cfY.setVisibility(8);
                    ArrayList<com.baidu.tbadk.core.data.r> arrayList = new ArrayList<>();
                    String str = "";
                    if (this.bWN.aMr() != null && this.bWN.aMr().getFrsBannerData() != null) {
                        str = this.bWN.aMr().getFrsBannerData().getValue();
                    }
                    com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r(this.bVk.bit(), str, null);
                    rVar.al(true);
                    arrayList.add(rVar);
                    com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                    pVar.g(arrayList);
                    a(pVar);
                    return;
                }
                this.cfY.setVisibility(0);
                a(this.bWN.bhO());
                return;
            }
            adh();
        }
    }

    private void adh() {
        if (this.bRi != null && this.bVm != null && !StringUtils.isNull(this.bVm.pO(), true)) {
            if (this.bVn == null) {
                this.bVn = (ViewStub) this.Gc.findViewById(r.g.frs_star_cover_info);
            }
            this.bVn.setVisibility(0);
            if (this.bVo == null) {
                this.bVo = (TextView) this.Gc.findViewById(r.g.frs_star_cover_pic_author);
            }
            if (this.bVp == null) {
                this.bVp = (TextView) this.Gc.findViewById(r.g.frs_star_cover_post_author);
            }
            if (this.bVq == null) {
                this.bVq = (ImageView) this.Gc.findViewById(r.g.frs_star_cover_goto_h5);
            }
            this.cgf = false;
            if (this.bVm.pK()) {
                this.bVp.setVisibility(4);
            } else {
                this.bVp.setText(String.format(this.Gd.getString(r.j.star_cover_post_author), this.bVm.pM()));
                this.bVp.setVisibility(0);
            }
            if (this.bVm.pL()) {
                this.bVo.setVisibility(4);
            } else {
                this.bVo.setText(String.format(this.Gd.getString(r.j.star_cover_pic_author), this.bVm.pN()));
                this.bVo.setVisibility(0);
            }
            adi();
            this.bVq.setOnClickListener(new v(this));
            this.cfY.setVisibility(8);
            a(this.bVm.pQ());
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(com.baidu.tbadk.core.data.p pVar) {
        super.a(pVar);
        if (this.bVm != null && !StringUtils.isNull(this.bVm.pO(), true)) {
            this.bAe.setCallback(new w(this));
        }
    }

    private void adi() {
        if (this.bVm != null) {
            if (!this.bVm.pJ()) {
                av.k(this.bVq, r.f.btn_frs_toutiao_n);
            } else {
                av.k(this.bVq, r.f.btn_frs_enter_n);
            }
            av.j((View) this.bVo, r.d.cp_cont_i);
            av.j((View) this.bVp, r.d.cp_cont_i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void adc() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bRi.getPageContext().getPageActivity(), "consume_6", "click");
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
    protected void acX() {
        av.c(this.FY, r.f.frs_text_color_selector, 1);
        av.k(this.cfI, r.f.frs_star_btn_like);
        this.cfJ.setVisibility(8);
        this.FY.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        av.c(this.cfM, r.f.frs_text_color_selector, 1);
        av.k(this.cfK, r.f.frs_star_btn_like);
        this.cfL.setVisibility(8);
        this.cfM.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.cfI.setOnClickListener(onClickListener);
        this.cfK.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void acZ() {
        if (this.cgF > 0) {
            if (com.baidu.adp.lib.util.k.K(this.Gd.getPageActivity()) >= 480) {
                this.cfP.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.cfP, r.f.frs_text_color_selector, 1);
            av.k(this.bVl, r.f.frs_star_btn_like);
            this.cfP.setText(String.format(this.Gd.getString(r.j.miss_sign_days), Integer.valueOf(this.cgF)));
        } else {
            this.cfP.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.k(this.bVl, r.f.btn_frs_signed_bg_selector);
            av.c(this.cfP, r.d.cp_link_tip_a, 1);
            if (this.cgE <= 0) {
                this.cfP.setText(this.Gd.getString(r.j.signed));
            } else {
                this.cfP.setText(String.format(this.Gd.getString(r.j.continuous_sign_days), Integer.valueOf(this.cgE)));
            }
        }
        this.cfO.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void adf() {
        this.cgs.c(this.cfI, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void add() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        super.changeSkinType(i);
        if (this.bVm != null && !StringUtils.isNull(this.bVm.pO(), true)) {
            adi();
        }
    }
}
