package com.baidu.tieba.frs.entelechy;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
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
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.view.ForumHeadSdkView;
import com.baidu.tieba.frs.view.ForumMemberIconView;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.w;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b {
    protected RelativeLayout aHR;
    private ArrayList<TbImageView> bnV = new ArrayList<>();
    private BlurDrawable bnW;
    private Runnable bnX;
    protected String mImageUrl;

    public d(FrsActivity frsActivity, FrsHeaderView.PAGE page, String str, String str2, int i) {
        this.aHR = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bjB = frsActivity;
        this.Do = frsActivity.getPageContext();
        this.buP = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), t.e.ds20);
        this.buQ = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), t.e.ds72);
        this.buR = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), t.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Dn = Si();
        this.aHR = (RelativeLayout) this.Dn.findViewById(t.g.container);
        this.aHR.setPadding(0, com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), t.e.ds150), 0, 0);
        this.bvD = (ForumMemberIconView) this.Dn.findViewById(t.g.forum_member_icon_layout);
        this.bvD.setVisibility(8);
        this.bvs = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(t.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.Dn.setVisibility(8);
        }
        this.bvl = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(t.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.Do.getPageActivity(), t.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.c(this.Do.getPageActivity(), t.e.ds220), 0, 0);
        this.bvl.setLayoutParams(layoutParams);
        this.bvk = (CoverFlowView) this.Dn.findViewById(t.g.nomal_frs_coverflowview);
        this.bvn = (ForumHeadSdkView) this.Dn.findViewById(t.g.frs_head_sdk);
        Ul();
        this.bva = (RelativeLayout) this.Dn.findViewById(t.g.btn_love_content);
        this.bvv = (ImageView) this.Dn.findViewById(t.g.speed_icon);
        this.bvB = new com.baidu.tieba.frs.view.l(this.Dn, this.Do.getPageActivity());
        this.bvb = (TextView) this.Dn.findViewById(t.g.level_name);
        this.bvc = (ImageView) this.Dn.findViewById(t.g.level);
        this.bvd = (ImageView) this.Dn.findViewById(t.g.love_level_top);
        this.buS = (FrameLayout) this.Dn.findViewById(t.g.love);
        this.buT = (Button) this.Dn.findViewById(t.g.btn_love);
        this.buT.setContentDescription(frsActivity.getResources().getString(t.j.attention));
        this.Dj = (TextView) this.Dn.findViewById(t.g.tv_love);
        this.buU = (FrameLayout) this.Dn.findViewById(t.g.sign);
        this.buV = (Button) this.Dn.findViewById(t.g.btn_sign);
        this.buW = (TextView) this.Dn.findViewById(t.g.tv_sign);
        this.buW.setContentDescription(frsActivity.getResources().getString(t.j.sign));
        this.buX = (ProgressBar) this.Dn.findViewById(t.g.sign_progress);
        this.buY = (FrameLayout) this.Dn.findViewById(t.g.sign_done);
        this.buZ = (TextView) this.Dn.findViewById(t.g.sign_done_text);
        this.Dg = (TextView) this.Dn.findViewById(t.g.member_num_text);
        this.Dh = (TextView) this.Dn.findViewById(t.g.post_num_text);
        this.Di = (TextView) this.Dn.findViewById(t.g.title_text);
        this.bvx = (BarImageView) this.Dn.findViewById(t.g.frs_image);
        this.bvx.setContentDescription(frsActivity.getResources().getString(t.j.bar_header));
        this.bvx.setGifIconSupport(false);
        this.bvx.setDrawerType(0);
        this.bvy = (UserIconBox) this.Dn.findViewById(t.g.frs_badge_box);
        this.bve = LayoutInflater.from(this.bjB.getPageContext().getPageActivity()).inflate(t.h.frs_header_extra_entelechy, (ViewGroup) null);
        Sc();
        this.bvh = (LinearLayout) this.bve.findViewById(t.g.frs_bawu_center);
        this.bvi = (ViewGroup) this.bve.findViewById(t.g.frs_header_games);
        this.bvj = (TextView) this.bve.findViewById(t.g.top_item_title);
        this.bvo = (LinearLayout) this.bve.findViewById(t.g.frs_header_enter_root);
        this.bvC = new w(this.Do, this.bve);
        this.biT = new by(this.Do, this.Dn, 1, false);
        this.biT.hide();
        this.bvA = new bj(this.Do);
    }

    protected View Si() {
        return LayoutInflater.from(this.bjB.getPageContext().getPageActivity()).inflate(t.h.frs_normal_header, (ViewGroup) null);
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
            this.Dn.setOnClickListener(new e(this));
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
            gW(1);
        } else {
            gW(0);
        }
        if (this.bvk != null) {
            this.bvk.sg();
        }
        if (this.bvn != null) {
            this.bvn.e(this.Do, i);
        }
        this.bvx.invalidate();
        at.c(this.bvc, BitmapHelper.getSmallGradeResourceIdNew(this.bvK));
        if (this.bnW != null && this.bnW.getBlurredBitmap() != null && !this.bnW.getBlurredBitmap().isRecycled()) {
            this.aHR.setBackgroundDrawable(new BitmapDrawable(this.bnW.getBlurredBitmap()));
        } else {
            at.l(this.aHR, t.d.cp_bg_line_d);
        }
        Sj();
        if (this.bvh != null) {
            at.k(this.bvh, t.f.frs_top_item_bg);
        }
        if (this.bvi != null) {
            at.k(this.bvi, t.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            at.c(this.bvv, t.f.icon_sml_speed_orange);
        } else {
            at.c(this.bvv, t.f.icon_sml_speed_gray);
        }
        if (this.bvC != null) {
            this.bvC.changeSkinType(i);
        }
        if (this.biT != null) {
            this.biT.changeSkinType(i);
        }
        if (this.bvy != null) {
            this.bvy.cV(i);
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
        Se();
    }

    protected void Sj() {
        this.Dj.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.buW.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
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
            Sk();
            this.bvB.setForumName(forumData.getName());
            So();
        }
    }

    protected void Sk() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.bvI.getMedias().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void Sl() {
        if (this.bvN > 0) {
            if (com.baidu.adp.lib.util.k.B(this.Do.getPageActivity()) >= 480) {
                this.buZ.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            at.c(this.buZ, t.d.cp_cont_g, 1);
            this.buZ.setText(String.format(this.Do.getString(t.j.miss_sign_days), Integer.valueOf(this.bvN)));
        } else {
            this.buZ.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            at.c(this.buZ, t.d.frs_signed_text, 1);
            if (this.bvM <= 0) {
                this.buZ.setText(this.Do.getString(t.j.signed));
            } else {
                this.buZ.setText(String.format(this.Do.getString(t.j.continuous_sign_days), Integer.valueOf(this.bvM)));
            }
        }
        this.buY.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void Sm() {
    }

    protected void Sn() {
        a(this.bpp.aSe());
    }

    protected void So() {
        ArrayList<com.baidu.tbadk.core.data.c> allAdvertList;
        if (this.bpp != null) {
            Sn();
        }
        if (this.bpp != null && this.bpp.aSy() != null) {
            a(this.bpp.aSy());
        }
        if (this.Dg != null) {
            this.Dg.setText(ay.A(this.mMemberNum));
        }
        if (this.Dh != null) {
            this.Dh.setText(ay.A(this.bvL));
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
        if (this.bpp != null && this.bpp.avD() != null && this.bpp.avD().getAdKillerData() != null) {
            BannerListData bannerListData = this.bpp.avD().getBannerListData();
            if (bannerListData == null || (allAdvertList = bannerListData.getAllAdvertList()) == null || allAdvertList.size() <= 0) {
                if (this.bvf == null) {
                    this.bvf = (RelativeLayout) ((ViewStub) this.bve.findViewById(t.g.frs_head_adkiller)).inflate();
                    com.baidu.tbadk.i.a.a(this.bjB.getPageContext(), this.bvf);
                    this.bvg = (TextView) this.bvf.findViewById(t.g.adkiller_tip);
                }
                com.baidu.tbadk.core.data.b adKillerData = this.bpp.avD().getAdKillerData();
                int oB = adKillerData.oB();
                String string = this.bjB.getResources().getString(t.j.adkiller_tip_success);
                if (oB > 0) {
                    string = this.bjB.getResources().getString(t.j.adkiller_tip_fail, Integer.valueOf(adKillerData.oB()));
                }
                String substring = string.substring(string.indexOf("("));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, substring, new ForegroundColorSpan(at.getColor(t.d.cp_cont_h)));
                this.bvg.setText(spannableString);
                this.bvf.setOnClickListener(new f(this, adKillerData));
            }
        }
        if (this.bvi != null && this.bvj != null) {
            if (this.bpp != null && this.bpp.aSk()) {
                int dj = com.baidu.tbadk.core.util.n.dj(this.bpp.aSn());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dj == 1 && !z) {
                    this.bvi.setVisibility(8);
                } else {
                    this.bvi.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bpp.getGameName()) && !TextUtils.isEmpty(this.bpp.getGameName().trim())) {
                        this.bvj.setText(UtilHelper.getFixedText(this.bpp.getGameName(), 10));
                        String nZ = com.baidu.tieba.tbadkCore.util.n.nZ(this.bpp.aSn());
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
        if (this.bpp != null && this.bpp.aSl() != null && this.bpp.aSl().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> aSl = this.bpp.aSl();
            ak(aSl);
            int size = aSl.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bvo.setVisibility(0);
                this.bvo.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = aSl.get(i2);
                    if (gVar != null && !hP(gVar.getUrl())) {
                        String hO = hO(gVar.aqy());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(t.g.top_item_title)).setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(t.g.top_item_type)).setText(hO);
                        u(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.bwb);
                        this.bvo.addView(viewGroup);
                        if (this.bvZ.add(gVar.aSa())) {
                            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.aSa(), this.bjB.getForumId(), this.bjB.getForumName(), null);
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
            this.bvC.a(this.bpp.aSd(), this.bpp.avD());
        } else {
            this.bvC.a(null, null);
        }
        this.bvx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bvx.c(this.mImageUrl, 15, false);
        if (this.bvx.getBdImage() == null || this.bvx.getBdImage().iY() == null) {
            Sp();
        } else {
            if (this.bnX == null) {
                this.bnX = new g(this);
            }
            this.bvx.postDelayed(this.bnX, 50L);
        }
        if (this.bvy != null && this.bvz != null && this.bvz.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bvz.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bvz.get(i3).oO());
                iconData.setIcon(this.bvz.get(i3).oN());
                this.bvJ = this.bvz.get(i3).oP();
                linkedList.add(iconData);
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
        Sd();
    }

    protected void Sp() {
        this.bvx.setEvent(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sq() {
        if (this.bjB != null && this.bjB.getActivity() != null) {
            if (this.bnW == null) {
                this.bnW = new BlurDrawable(this.bjB.getActivity());
                if (this.bvx != null && this.bvx.getBdImage() != null && this.bvx.getBdImage().iY() != null && !this.bvx.getBdImage().iY().isRecycled()) {
                    this.bnW.init(12, 8, this.bvx.getBdImage().iY());
                }
            }
            if (this.bnW != null && this.bnW.getBlurredBitmap() == null && this.bnW.drawBlur()) {
                this.aHR.setBackgroundDrawable(new BitmapDrawable(this.bnW.getBlurredBitmap()));
            }
        }
    }

    private String hO(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m11getInst().getString(t.j.tequan);
        }
        return str;
    }

    private void Sr() {
        ViewGroup Up;
        View Uq;
        View findViewById;
        if (this.bvi.getVisibility() == 0) {
            View findViewById2 = this.bvi.findViewById(t.g.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.bvi.getVisibility() == 8 && this.bvo.getVisibility() == 0) {
            if (this.bvo.getChildCount() > 0 && (findViewById = ((ViewGroup) this.bvo.getChildAt(0)).findViewById(t.g.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.bvo.getVisibility() == 8 && (Up = this.bvC.Up()) != null && Up.getVisibility() == 0 && (Uq = this.bvC.Uq()) != null) {
            Uq.setVisibility(8);
        } else {
            this.bnU.dr(true);
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
            aVar.bM(t.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.Do);
            aVar.rV();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(t.j.cancel_text, new i(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(t.j.open_now, new j(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Ss() {
        View contentView;
        if (this.bvw == null) {
            this.bvw = new PopupWindow(this.Do.getPageActivity());
            contentView = LayoutInflater.from(this.Do.getContext()).inflate(t.h.speed_tip, (ViewGroup) null);
            this.bvw.setContentView(contentView);
            contentView.setOnClickListener(new k(this));
            this.bvw.setWidth(this.Do.getResources().getDimensionPixelSize(t.e.ds300));
            this.bvw.setHeight(this.Do.getResources().getDimensionPixelSize(t.e.ds88));
            this.bvw.setBackgroundDrawable(new BitmapDrawable());
            this.bvw.setOutsideTouchable(true);
            this.bvw.setTouchInterceptor(new l(this));
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
                if (PZ != null && PZ.avD() != null) {
                    PZ.avD().setUser_level(i);
                }
                at.c(this.bvc, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bvb.setText(this.bvF);
                at.c(this.bvc, BitmapHelper.getSmallGradeResourceIdNew(this.bvK));
            }
            this.bvd.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, gw(this.bvK)));
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

    private int[] gw(int i) {
        if (i <= 3) {
            return new int[]{-8331843, -10499102};
        }
        if (i <= 9) {
            return new int[]{-10499102, -154262};
        }
        if (i <= 15) {
            return new int[]{-154262, -148180};
        }
        return new int[]{-148180, -100818};
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void St() {
        this.bvA.c(this.buS, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Su() {
        if (this.mMemberType != 0) {
            at.c(this.bvv, t.f.icon_sml_speed_orange);
        } else {
            at.c(this.bvv, t.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        if (this.bnW != null) {
            this.bnW.onDestroy();
        }
        this.bvx.removeCallbacks(this.bnX);
    }
}
