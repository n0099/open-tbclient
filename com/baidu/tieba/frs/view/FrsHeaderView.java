package com.baidu.tieba.frs.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FrsHeaderView extends c {
    private View aZr;
    private ArrayList<TbImageView> bnV;
    private String mImageUrl;

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (bwj) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PAGE[] valuesCustom() {
            PAGE[] valuesCustom = values();
            int length = valuesCustom.length;
            PAGE[] pageArr = new PAGE[length];
            System.arraycopy(valuesCustom, 0, pageArr, 0, length);
            return pageArr;
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bvx.setOnClickListener(onClickListener);
        this.Di.setOnClickListener(onClickListener);
        this.buT.setOnClickListener(onClickListener);
        this.buV.setOnClickListener(onClickListener);
        this.buY.setOnClickListener(onClickListener);
        this.bva.setOnClickListener(onClickListener);
        if (this.bvh != null) {
            this.bvh.setOnClickListener(onClickListener);
        }
        if (this.bvi != null) {
            this.bvi.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.c.e.cS().Z("frs_to_bar_detail") == 0) {
            this.Dn.setOnClickListener(new m(this));
        }
        this.bvB.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.Do.getLayoutMode().ae(i == 1);
        this.Do.getLayoutMode().x(this.Dn);
        this.Do.getLayoutMode().x(this.bvs);
        this.Do.getLayoutMode().x(this.bve);
        if (this.bvT) {
            gX(1);
        } else {
            gX(0);
        }
        if (this.bvk != null) {
            this.bvk.sf();
        }
        if (this.bvn != null) {
            this.bvn.e(this.Do, i);
        }
        this.bvx.invalidate();
        at.c(this.bvc, BitmapHelper.getSmallGradeResourceIdNew(this.bvK));
        at.l(this.aZr, t.d.cp_bg_line_d);
        this.Dj.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.buW.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Dj.setShadowLayer(1.0f, 0.0f, 1.0f, at.getColor(t.d.frs_like_shadow));
        this.buW.setShadowLayer(1.0f, 0.0f, 1.0f, at.getColor(t.d.frs_sign_shadow));
        if (this.bvh != null) {
            at.k(this.bvh, t.f.frs_top_item_bg);
        }
        if (this.bvi != null) {
            at.k(this.bvi, t.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            at.c(this.bvv, t.f.icon_speed_orange);
        } else {
            at.c(this.bvv, t.f.icon_speed_gray);
        }
        if (this.bvC != null) {
            this.bvC.changeSkinType(i);
        }
        if (this.biT != null) {
            this.biT.changeSkinType(i);
        }
        if (this.bvy != null) {
            this.bvy.cW(i);
        }
        if (this.bvD != null) {
            this.bvD.e(this.Do, i);
        }
        Iterator<TbImageView> it = this.bnV.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        if (this.bvf != null) {
            com.baidu.tbadk.i.a.a(this.bjB.getPageContext(), this.bvf);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bvL = forumData.getPost_num();
            this.bvG = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.bvF = forumData.getLevelName();
            this.bvK = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.bvM = forumData.getSignData().getCountSignNum();
                this.bvN = forumData.getSignData().getMissSignNum();
            }
            this.bvO = forumData.getCurScore();
            this.bur = forumData.getLevelupScore();
            this.bvz = forumData.getBadgeData();
            this.bvp = forumData.getTopCode();
            this.bvq = forumData.getNewsInfo();
            this.bvH = forumData.getAccelerateContent();
            this.bvE = forumData.getMemberShowIconData();
            this.bpp = oVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.Dn.setVisibility(8);
            } else {
                this.Dn.setVisibility(0);
            }
            this.bvI = new ax();
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.mImageUrl);
            this.bvI.getMedias().add(mediaData);
            this.bvB.setForumName(forumData.getName());
            So();
        }
    }

    private void So() {
        ArrayList<com.baidu.tbadk.core.data.c> allAdvertList;
        if (this.bpp != null) {
            a(this.bpp.aSb());
        }
        if (this.bpp != null && this.bpp.aSv() != null) {
            a(this.bpp.aSv());
        }
        if (this.Dg != null) {
            this.Dg.setText(ay.D(this.mMemberNum));
        }
        if (this.Dh != null) {
            this.Dh.setText(ay.D(this.bvL));
        }
        if (this.Di != null) {
            if (this.bvz != null && this.bvz.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.Di.setText(String.valueOf(this.mForumName) + this.Do.getString(t.j.forum));
            }
        }
        if (this.bvh != null) {
            if (this.bpp != null && this.bpp.getUserData() != null && this.bpp.getUserData().isBawu()) {
                this.bvh.setVisibility(0);
            } else {
                this.bvh.setVisibility(8);
            }
        }
        if (this.bpp != null && this.bpp.avA() != null && this.bpp.avA().getAdKillerData() != null) {
            boolean z = true;
            BannerListData bannerListData = this.bpp.avA().getBannerListData();
            if (bannerListData != null && (allAdvertList = bannerListData.getAllAdvertList()) != null && allAdvertList.size() > 0) {
                z = false;
            }
            if (z) {
                if (this.bvf == null) {
                    this.bvf = (RelativeLayout) ((ViewStub) this.bve.findViewById(t.g.frs_head_adkiller)).inflate();
                    com.baidu.tbadk.i.a.a(this.bjB.getPageContext(), this.bvf);
                    this.bvg = (TextView) this.bvf.findViewById(t.g.adkiller_tip);
                }
                com.baidu.tbadk.core.data.b adKillerData = this.bpp.avA().getAdKillerData();
                int oB = adKillerData.oB();
                String string = this.bjB.getResources().getString(t.j.adkiller_tip_success);
                if (oB > 0) {
                    string = this.bjB.getResources().getString(t.j.adkiller_tip_fail, Integer.valueOf(adKillerData.oB()));
                }
                String substring = string.substring(string.indexOf("("));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, substring, new ForegroundColorSpan(at.getColor(t.d.cp_cont_h)));
                this.bvg.setText(spannableString);
                this.bvf.setOnClickListener(new n(this, adKillerData));
            }
        }
        if (this.bvi != null && this.bvj != null) {
            if (this.bpp != null && this.bpp.aSh()) {
                int dj = com.baidu.tbadk.core.util.n.dj(this.bpp.aSk());
                boolean z2 = GameDetailActivityConfig.isHaveActivity;
                if (dj == 1 && !z2) {
                    this.bvi.setVisibility(8);
                } else {
                    this.bvi.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bpp.getGameName()) && !TextUtils.isEmpty(this.bpp.getGameName().trim())) {
                        this.bvj.setText(UtilHelper.getFixedText(this.bpp.getGameName(), 10));
                        String nZ = com.baidu.tieba.tbadkCore.util.n.nZ(this.bpp.aSk());
                        if (!StringUtils.isNull(nZ)) {
                            TiebaStatic.eventStat(this.Do.getPageActivity(), "game_show", "show", 1, "dev_id", nZ, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bvj.setText(this.Do.getResources().getString(t.j.frsgame_title));
                    }
                }
            } else {
                this.bvi.setVisibility(8);
            }
        }
        if (this.bpp != null && this.bpp.aSi() != null && this.bpp.aSi().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> aSi = this.bpp.aSi();
            ak(aSi);
            int size = aSi.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bvo.setVisibility(0);
                this.bvo.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = aSi.get(i2);
                    if (gVar != null && !hP(gVar.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(t.g.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.c(this.Do.getPageActivity(), t.e.ds6));
                        tbImageView.c(gVar.getIcon(), 21, false);
                        this.bnV.add(tbImageView);
                        ((TextView) linearLayout.findViewById(t.g.frs_header_enters_text)).setText(UtilHelper.getFixedText(gVar.getTitle(), 10));
                        u(linearLayout);
                        linearLayout.setTag(gVar);
                        linearLayout.setOnClickListener(this.bwb);
                        this.bvo.addView(linearLayout);
                        if (this.bvZ.add(gVar.aRX())) {
                            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.aRX(), this.bjB.getForumId(), this.bjB.getForumName(), null);
                            a.bK("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.bvo.setVisibility(8);
            }
        } else {
            this.bvo.setVisibility(8);
        }
        if (this.bpp != null) {
            this.bvC.a(this.bpp.aSa(), this.bpp.avA());
        } else {
            this.bvC.a(null, null);
        }
        this.bvx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bvx.c(this.mImageUrl, 15, false);
        if (this.bvy != null && this.bvz != null && this.bvz.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.bvz.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.bvz.get(i4).oO());
                iconData.setIcon(this.bvz.get(i4).oN());
                this.bvJ = this.bvz.get(i4).oP();
                linkedList.add(iconData);
                i3 = i4 + 1;
            }
            this.bvy.setOnClickListener(this.adN);
            this.bvy.a(linkedList, 2, this.Do.getResources().getDimensionPixelSize(t.e.frs_header_badge_width), this.Do.getResources().getDimensionPixelSize(t.e.frs_header_badge_height), this.Do.getResources().getDimensionPixelSize(t.e.frs_header_badge_margin));
        }
        if (this.bpp != null) {
            this.biT.b(this.bpp);
        }
        String icon = this.bvE.getIcon();
        String url = this.bvE.getUrl();
        if (this.bvE != null && this.bvD != null) {
            this.bvD.setIcon(icon);
            this.bvD.setUrl(url);
        }
        Sr();
    }

    private void Sr() {
        View Uo;
        if (this.bvi.getVisibility() == 0) {
            this.bve.findViewById(t.g.frs_header_divider_games).setVisibility(8);
        } else if (this.bvi.getVisibility() == 8 && this.bvo.getVisibility() == 0) {
            if (this.bvo.getChildCount() > 0) {
                ((LinearLayout) this.bvo.getChildAt(0)).findViewById(t.g.frs_header_divider_enters).setVisibility(8);
            }
        } else if (this.bvo.getVisibility() == 8 && this.bvC.Un() != null && (Uo = this.bvC.Uo()) != null) {
            Uo.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m11getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bwa);
            if (this.bvr == null) {
                this.bvr = new PopupWindow(this.Do.getPageActivity());
                this.bvr.setContentView(this.bvs);
                this.bvr.setBackgroundDrawable(new BitmapDrawable());
                this.bvr.setOutsideTouchable(true);
                this.bvr.setFocusable(true);
                this.bvr.setWidth(this.Do.getResources().getDimensionPixelSize(t.e.frs_header_btn_width));
                this.bvr.setHeight(this.Do.getResources().getDimensionPixelSize(t.e.frs_header_exp_height));
                this.bvt = (TextView) this.bvs.findViewById(t.g.cur_experience);
                this.bvu = (TextView) this.bvs.findViewById(t.g.levelup_experience);
                a(this.bvt, this.bvu);
            }
            if (this.bvr.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bvr, this.Do.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bvt, this.bvu);
            if (iArr[1] - this.bvr.getHeight() <= 50) {
                com.baidu.adp.lib.h.j.a(this.bvr, this.Do.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bvr, this.Dn, 0, iArr[0], iArr[1] - this.bvr.getHeight());
            this.bvr.update();
            this.mHandler.postDelayed(this.bwa, 2000L);
        } else if (TbadkCoreApplication.m11getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.Do.getContext()).inflate(t.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(t.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(t.g.speed_tip);
            at.c((TextView) inflate.findViewById(t.g.experience_txt), t.d.cp_cont_b, 1);
            at.c(textView, t.d.cp_cont_b, 1);
            at.c(textView2, t.d.cp_cont_b, 1);
            at.c(textView3, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Do.getPageActivity());
            aVar.z(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.bvH) && !TextUtils.isEmpty(this.bvH.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bvH);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bN(t.d.cp_link_tip_d);
            aVar.b(t.j.cancel_text, new o(this));
            aVar.a(t.j.open_now, new p(this));
            aVar.b(this.Do);
            aVar.rU();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Ss() {
        View contentView;
        if (this.bvw == null) {
            this.bvw = new PopupWindow(this.Do.getPageActivity());
            contentView = LayoutInflater.from(this.Do.getContext()).inflate(t.h.speed_tip, (ViewGroup) null);
            this.bvw.setContentView(contentView);
            contentView.setOnClickListener(new q(this));
            this.bvw.setWidth(this.Do.getResources().getDimensionPixelSize(t.e.ds300));
            this.bvw.setHeight(this.Do.getResources().getDimensionPixelSize(t.e.ds88));
            this.bvw.setBackgroundDrawable(new BitmapDrawable());
            this.bvw.setOutsideTouchable(true);
            this.bvw.setTouchInterceptor(new r(this));
        } else {
            contentView = this.bvw.getContentView();
        }
        this.Do.getLayoutMode().x(contentView);
        int[] iArr = new int[2];
        this.bvv.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bvw, this.Dn, 0, (iArr[0] - (this.bvw.getWidth() / 2)) + (this.bvv.getWidth() / 2), iArr[1] + this.bvv.getWidth());
        this.bvw.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(boolean z, float f) {
        int i;
        this.bvU = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(t.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.bvU) {
                this.bvb.setText(t.j.level_up);
                if (f >= 1.0f) {
                    i = this.bvK;
                } else {
                    i = this.bvK + 1;
                }
                com.baidu.tieba.tbadkCore.o PZ = this.bjB.PZ();
                if (PZ != null && PZ.avA() != null) {
                    PZ.avA().setUser_level(i);
                }
                at.c(this.bvc, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bvb.setText(this.bvF);
                at.c(this.bvc, BitmapHelper.getSmallGradeResourceIdNew(this.bvK));
            }
            if (this.bvU) {
                if (f >= 1.0f) {
                    a(this.Do.getOrignalPage(), this.bvd, this.bvV, f);
                } else {
                    b(this.Do.getOrignalPage(), this.bvd, this.bvV, f);
                }
            } else {
                a(this.Do.getOrignalPage(), this.bvd, this.bvV, f);
            }
            this.bvV = f;
        }
    }
}
