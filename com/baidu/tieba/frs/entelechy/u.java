package com.baidu.tieba.frs.entelechy;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends j {
    private com.baidu.tieba.tbadkCore.o bVr;
    private TextView bVs;

    public u(FrsActivity frsActivity, String str, String str2, int i) {
        super(frsActivity, str, str2, i);
        this.bVr = null;
        if (this.aRB != null) {
            this.aRB.setPadding(0, 0, 0, 0);
        }
        this.bVs = (TextView) this.Gc.findViewById(t.g.sign_done_bg);
        this.Gc.findViewById(t.g.frs_header_divider).setVisibility(4);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected View acy() {
        return LayoutInflater.from(this.bRp.getPageContext().getPageActivity()).inflate(t.h.frs_star_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            this.bVr = pVar.bhf();
        }
        super.a(forumData, pVar);
        this.mImageUrl = this.bVr.bhK();
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void acM() {
        if (this.bVr != null && this.cgC != null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.bVr.bhJ());
            this.cgC.rK().add(mediaData);
            MediaData mediaData2 = new MediaData();
            mediaData2.setType(3);
            mediaData2.setPic(this.bVr.bhK());
            this.cgC.rK().add(mediaData2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void acP() {
        if (this.bWN != null) {
            if (this.bWN.bhg() == null || this.bWN.bhg().pv() == null || (this.bWN.bhg().pv().size() <= 0 && this.bVr != null)) {
                this.cgb.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.r> arrayList = new ArrayList<>();
                String str = "";
                if (this.bWN.aLP() != null && this.bWN.aLP().getFrsBannerData() != null) {
                    str = this.bWN.aLP().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r(this.bVr.bhJ(), str, null);
                rVar.al(true);
                arrayList.add(rVar);
                com.baidu.tbadk.core.data.p pVar = new com.baidu.tbadk.core.data.p();
                pVar.g(arrayList);
                a(pVar);
                return;
            }
            this.cgb.setVisibility(0);
            a(this.bWN.bhg());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void acQ() {
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.bRp.getPageContext().getPageActivity(), "consume_6", "click");
        super.c(view, z);
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(t.j.cancel_text, new v(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(t.j.open_now, new w(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.j
    protected void acL() {
        av.c(this.FY, t.f.frs_text_color_selector, 1);
        av.k(this.cfL, t.f.frs_star_btn_like);
        this.cfM.setVisibility(8);
        this.FY.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        av.c(this.cfP, t.f.frs_text_color_selector, 1);
        av.k(this.cfN, t.f.frs_star_btn_like);
        this.cfO.setVisibility(8);
        this.cfP.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_star_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        super.setCommonClickListener(onClickListener);
        this.cfL.setOnClickListener(onClickListener);
        this.cfN.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void acN() {
        if (this.cgH > 0) {
            if (com.baidu.adp.lib.util.k.K(this.Gd.getPageActivity()) >= 480) {
                this.cfS.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.frs_star_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.cfS, t.f.frs_text_color_selector, 1);
            av.k(this.bVs, t.f.frs_star_btn_like);
            this.cfS.setText(String.format(this.Gd.getString(t.j.miss_sign_days), Integer.valueOf(this.cgH)));
        } else {
            this.cfS.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_sign_blue_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.k(this.bVs, t.f.btn_frs_signed_bg_selector);
            av.c(this.cfS, t.d.cp_link_tip_a, 1);
            if (this.cgG <= 0) {
                this.cfS.setText(this.Gd.getString(t.j.signed));
            } else {
                this.cfS.setText(String.format(this.Gd.getString(t.j.continuous_sign_days), Integer.valueOf(this.cgG)));
            }
        }
        this.cfR.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.entelechy.j, com.baidu.tieba.frs.view.c
    protected void acT() {
        this.cgu.c(this.cfL, "frs_page");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.entelechy.j
    public void acR() {
    }
}
