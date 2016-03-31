package com.baidu.tieba.frs.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.as;
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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bk;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends b implements com.baidu.tbadk.imageManager.b {
    private com.baidu.tieba.tbadkCore.n bwS = null;
    private ArrayList<TbImageView> bwx = new ArrayList<>();

    public u(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.blH = tbPageContext.getOrignalPage();
        this.MX = tbPageContext;
        this.mHandler = new Handler();
        this.bva = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds20);
        this.bvb = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds72);
        this.bvc = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.MW = LayoutInflater.from(tbPageContext.getContext()).inflate(t.h.frs_star_title, (ViewGroup) null);
        this.bvE = LayoutInflater.from(tbPageContext.getContext()).inflate(t.h.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.MW.setVisibility(8);
        }
        this.bvl = (RelativeLayout) this.MW.findViewById(t.g.btn_love_content);
        this.bvH = (ImageView) this.MW.findViewById(t.g.speed_icon);
        this.bvm = (TextView) this.MW.findViewById(t.g.level_name);
        this.bvn = (ImageView) this.MW.findViewById(t.g.level);
        this.bvo = (ImageView) this.MW.findViewById(t.g.love_level_top);
        this.bvN = new k(this.MW, this.MX.getPageActivity());
        this.bvd = (FrameLayout) this.MW.findViewById(t.g.love);
        this.bve = (Button) this.MW.findViewById(t.g.btn_love);
        this.bve.setContentDescription(tbPageContext.getResources().getString(t.j.attention));
        this.MS = (TextView) this.MW.findViewById(t.g.tv_love);
        this.bvf = (FrameLayout) this.MW.findViewById(t.g.sign);
        this.bvg = (Button) this.MW.findViewById(t.g.btn_sign);
        this.bvh = (TextView) this.MW.findViewById(t.g.tv_sign);
        this.bvi = (ProgressBar) this.MW.findViewById(t.g.sign_progress);
        this.bvj = (FrameLayout) this.MW.findViewById(t.g.sign_done);
        this.bvk = (TextView) this.MW.findViewById(t.g.sign_done_text);
        this.MP = (TextView) this.MW.findViewById(t.g.member_num_text);
        this.MQ = (TextView) this.MW.findViewById(t.g.post_num_text);
        this.MR = (TextView) this.MW.findViewById(t.g.title_text);
        this.bvw = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.MX.getPageActivity(), t.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.c(this.MX.getPageActivity(), t.e.ds280), 0, 0);
        this.bvw.setLayoutParams(layoutParams);
        this.bvv = (CoverFlowView) this.MW.findViewById(t.g.frs_coverflowview);
        Uj();
        this.bvv.uA();
        this.bvy = (ForumHeadSdkView) this.MW.findViewById(t.g.frs_head_sdk);
        this.bvJ = (BarImageView) this.MW.findViewById(t.g.frs_star_bottom_photo);
        this.bvJ.setContentDescription(tbPageContext.getResources().getString(t.j.bar_header));
        this.bvJ.setGifIconSupport(false);
        this.bvK = (UserIconBox) this.MW.findViewById(t.g.frs_badge_box);
        this.bvp = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.frs_header_extra, (ViewGroup) null);
        this.bvs = (LinearLayout) this.bvp.findViewById(t.g.frs_bawu_center);
        this.bvt = (LinearLayout) this.bvp.findViewById(t.g.frs_header_games);
        this.bvu = (TextView) this.bvp.findViewById(t.g.frs_header_games_text);
        this.bnq = new bz(this.MX, this.MW, 1);
        this.bnq.hide();
        this.bvM = new bk(this.MX);
        this.bvz = (LinearLayout) this.bvp.findViewById(t.g.frs_header_enter_root);
        this.bvO = new ab(this.MX, this.bvp);
        this.bvC = (U9InfoView) this.bvp.findViewById(t.g.frs_header_enter_u9);
        this.bvP = (ForumMemberIconView) this.MW.findViewById(t.g.forum_member_icon_layout);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bvJ.setOnClickListener(onClickListener);
        this.MR.setOnClickListener(onClickListener);
        this.bvl.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.c.e.gE().ai("frs_to_bar_detail") == 0) {
            this.MW.setOnClickListener(new v(this));
        }
        this.bvN.setOnClickListener(onClickListener);
        this.bve.setOnClickListener(onClickListener);
        this.bvg.setOnClickListener(onClickListener);
        this.bvj.setOnClickListener(onClickListener);
        if (this.bvs != null) {
            this.bvs.setOnClickListener(onClickListener);
        }
        if (this.bvt != null) {
            this.bvt.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.MX.getLayoutMode().ab(i == 1);
        this.MX.getLayoutMode().x(this.MW);
        this.MX.getLayoutMode().x(this.bvE);
        this.MX.getLayoutMode().x(this.bvp);
        if (this.bvv != null) {
            this.bvv.uA();
        }
        if (this.bvy != null) {
            this.bvy.e(this.MX, i);
        }
        if (this.bwg) {
            hu(1);
        } else {
            hu(0);
        }
        at.c(this.bvn, BitmapHelper.getSmallGradeResourceIdNew(this.bvX));
        this.bvJ.invalidate();
        this.MS.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bvh.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.MS.setShadowLayer(1.0f, 0.0f, 1.0f, at.getColor(t.d.frs_like_shadow));
        this.bvh.setShadowLayer(1.0f, 0.0f, 1.0f, at.getColor(t.d.frs_sign_shadow));
        if (this.bvs != null) {
            at.k(this.bvs, t.f.frs_top_item_bg);
        }
        if (this.bvt != null) {
            at.k(this.bvt, t.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            at.c(this.bvH, t.f.icon_speed_orange);
        } else {
            at.c(this.bvH, t.f.icon_speed_gray);
        }
        if (this.bvO != null) {
            this.bvO.changeSkinType(i);
        }
        if (this.bnq != null) {
            this.bnq.changeSkinType(i);
        }
        if (this.bvC != null) {
            this.bvC.e(this.MX, i);
        }
        if (this.bvK != null) {
            this.bvK.dn(i);
        }
        Iterator<TbImageView> it = this.bwx.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        if (this.bvP != null) {
            this.bvP.e(this.MX, i);
        }
        if (this.bvq != null) {
            com.baidu.tbadk.i.a.a(this.blH.getPageContext(), this.bvq);
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bvY = forumData.getPost_num();
            this.bvS = forumData.getTag_color();
            this.bvR = forumData.getLevelName();
            this.bvX = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.bvZ = forumData.getSignData().getCountSignNum();
                this.bwa = forumData.getSignData().getMissSignNum();
            }
            this.bwb = forumData.getCurScore();
            this.bvT = forumData.getAccelerateContent();
            this.bvQ = forumData.getMemberShowIconData();
            this.buC = forumData.getLevelupScore();
            this.bvU = oVar;
            this.bwS = oVar.aRE();
            this.bvL = forumData.getBadgeData();
            this.bvV = new as();
            this.bvA = forumData.getTopCode();
            this.bvB = forumData.getNewsInfo();
            if (this.bwS != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.bwS.aSb());
                this.bvV.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.bwS.aSc());
                this.bvV.getMedias().add(mediaData2);
            }
            this.MW.setVisibility(0);
            this.bvN.setForumName(forumData.getName());
            Um();
        }
    }

    private void Um() {
        ArrayList<com.baidu.tbadk.core.data.c> allAdvertList;
        if (this.bvU != null) {
            if (this.bvU.aRF() == null || this.bvU.aRF().ry() == null || this.bvU.aRF().ry().size() <= 0) {
                this.bvw.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.n> arrayList = new ArrayList<>();
                String str = "";
                if (this.bvU.avu() != null && this.bvU.avu().getFrsBannerData() != null) {
                    str = this.bvU.avu().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n(this.bwS.aSb(), str, null);
                nVar.ag(true);
                arrayList.add(nVar);
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.f(arrayList);
                a(mVar);
            } else {
                this.bvw.setVisibility(0);
                a(this.bvU.aRF());
            }
            if (this.bvU.aRZ() != null) {
                a(this.bvU.aRZ());
            }
        }
        if (this.MP != null) {
            this.MP.setText(ay.C(this.mMemberNum));
        }
        if (this.MQ != null) {
            this.MQ.setText(ay.C(this.bvY));
        }
        if (this.MR != null) {
            if (this.bvL != null && this.bvL.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.MR.setText(String.valueOf(this.mForumName) + this.MX.getString(t.j.forum));
        }
        if (this.bvs != null) {
            if (this.bvU != null && this.bvU.getUserData() != null && this.bvU.getUserData().isBawu()) {
                this.bvs.setVisibility(0);
            } else {
                this.bvs.setVisibility(8);
            }
        }
        if (this.bvU != null && this.bvU.avu() != null && this.bvU.avu().getAdKillerData() != null) {
            BannerListData bannerListData = this.bvU.avu().getBannerListData();
            if (bannerListData == null || (allAdvertList = bannerListData.getAllAdvertList()) == null || allAdvertList.size() <= 0) {
                if (this.bvq == null) {
                    this.bvq = (RelativeLayout) ((ViewStub) this.bvp.findViewById(t.g.frs_head_adkiller)).inflate();
                    com.baidu.tbadk.i.a.a(this.blH.getPageContext(), this.bvq);
                    this.bvr = (TextView) this.bvq.findViewById(t.g.adkiller_tip);
                }
                com.baidu.tbadk.core.data.b adKillerData = this.bvU.avu().getAdKillerData();
                int rg = adKillerData.rg();
                String string = this.blH.getResources().getString(t.j.adkiller_tip_success);
                if (rg > 0) {
                    string = this.blH.getResources().getString(t.j.adkiller_tip_fail, Integer.valueOf(adKillerData.rg()));
                }
                String substring = string.substring(string.indexOf("("));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, substring, new ForegroundColorSpan(at.getColor(t.d.cp_cont_h)));
                this.bvr.setText(spannableString);
                this.bvq.setOnClickListener(new w(this, adKillerData));
            }
        }
        if (this.bvt != null && this.bvu != null) {
            if (this.bvU != null && this.bvU.aRL()) {
                int dl = com.baidu.tbadk.core.util.n.dl(this.bvU.aRO());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dl == 1 && !z) {
                    this.bvt.setVisibility(8);
                } else {
                    this.bvt.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bvU.getGameName()) && !TextUtils.isEmpty(this.bvU.getGameName().trim())) {
                        this.bvu.setText(UtilHelper.getFixedText(this.bvU.getGameName(), 10));
                        String oc = com.baidu.tieba.tbadkCore.util.n.oc(this.bvU.aRO());
                        if (!StringUtils.isNull(oc)) {
                            TiebaStatic.eventStat(this.MX.getPageActivity(), "game_show", "show", 1, "dev_id", oc, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bvu.setText(this.MX.getResources().getString(t.j.frsgame_title));
                    }
                }
            } else {
                this.bvt.setVisibility(8);
            }
        }
        if (this.bvU != null && this.bvU.aRM() != null && this.bvU.aRM().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> aRM = this.bvU.aRM();
            am(aRM);
            int size = aRM.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bvz.setVisibility(0);
                this.bvz.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = aRM.get(i2);
                    if (gVar != null && !hM(gVar.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(t.g.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.c(this.MX.getPageActivity(), t.e.ds6));
                        tbImageView.c(gVar.getIcon(), 21, false);
                        this.bwx.add(tbImageView);
                        ((TextView) linearLayout.findViewById(t.g.frs_header_enters_text)).setText(UtilHelper.getFixedText(gVar.getTitle(), 10));
                        u(linearLayout);
                        linearLayout.setTag(gVar.getUrl());
                        linearLayout.setOnClickListener(this.bwo);
                        this.bvz.addView(linearLayout);
                    }
                }
            } else {
                this.bvz.setVisibility(8);
            }
        } else {
            this.bvz.setVisibility(8);
        }
        this.bvJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bvJ.c(this.bwS.aSc(), 16, false);
        if (this.bvK != null && this.bvL != null && this.bvL.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bvL.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bvL.get(i3).ru());
                iconData.setIcon(this.bvL.get(i3).rt());
                this.bvW = this.bvL.get(i3).rv();
                linkedList.add(iconData);
            }
            this.bvK.setOnClickListener(this.ahR);
            this.bvK.a(linkedList, 2, this.MX.getResources().getDimensionPixelSize(t.e.frs_starheader_badge_width), this.MX.getResources().getDimensionPixelSize(t.e.frs_starheader_badge_height), this.MX.getResources().getDimensionPixelSize(t.e.frs_starheader_badge_margin));
        }
        if (this.bvU != null) {
            this.bvO.a(this.bvU.aRE(), this.bvU.avu());
        } else {
            this.bvO.a(null, null);
        }
        if (this.bvU != null) {
            this.bnq.b(this.bvU);
        }
        this.bvC.a(this.bvA, this.bvB);
        String icon = this.bvQ.getIcon();
        String url = this.bvQ.getUrl();
        if (this.bvQ != null && this.bvP != null) {
            this.bvP.setIcon(icon);
            this.bvP.setUrl(url);
        }
        Un();
    }

    private void Un() {
        View Uq;
        if (this.bvC.getTopCodeView() != null && this.bvC.getNewsInfoView() != null && this.bvC.getTopCodeViewDivider() != null && this.bvC.getTopCodeView().getVisibility() != 0) {
            if (this.bvC.getTopCodeView().getVisibility() == 8 && this.bvC.getNewsInfoView().getVisibility() == 0) {
                this.bvC.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bvC.getNewsInfoView().getVisibility() == 8 && this.bvt.getVisibility() == 0) {
                this.bvp.findViewById(t.g.frs_header_divider_games).setVisibility(8);
            } else if (this.bvt.getVisibility() == 8 && this.bvz.getVisibility() == 0) {
                if (this.bvz.getChildCount() > 0) {
                    ((LinearLayout) this.bvz.getChildAt(0)).findViewById(t.g.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bvz.getVisibility() == 8 && this.bvO.Up() != null && (Uq = this.bvO.Uq()) != null) {
                Uq.setVisibility(8);
            }
        }
    }

    public void TA() {
        View contentView;
        if (this.bvI == null) {
            this.bvI = new PopupWindow(this.MX.getPageActivity());
            contentView = LayoutInflater.from(this.MX.getContext()).inflate(t.h.speed_tip, (ViewGroup) null);
            this.bvI.setContentView(contentView);
            contentView.setOnClickListener(new x(this));
            this.bvI.setWidth(this.MX.getResources().getDimensionPixelSize(t.e.ds300));
            this.bvI.setHeight(this.MX.getResources().getDimensionPixelSize(t.e.ds88));
            this.bvI.setBackgroundDrawable(new BitmapDrawable());
            this.bvI.setOutsideTouchable(true);
            this.bvI.setTouchInterceptor(new y(this));
        } else {
            contentView = this.bvI.getContentView();
        }
        this.MX.getLayoutMode().x(contentView);
        int[] iArr = new int[2];
        this.bvH.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bvI, this.MW, 0, (iArr[0] - (this.bvI.getWidth() / 2)) + (this.bvH.getWidth() / 2), iArr[1] + this.bvH.getWidth());
        this.bvI.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(boolean z, float f) {
        int i;
        this.bwh = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(t.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.bwh) {
                this.bvm.setText(t.j.star_bar_level_up);
                this.bvm.setText(t.j.level_up);
                if (f >= 1.0f) {
                    i = this.bvX;
                } else {
                    i = this.bvX + 1;
                }
                com.baidu.tieba.tbadkCore.o QZ = this.blH.QZ();
                if (QZ != null && QZ.avu() != null) {
                    QZ.avu().setUser_level(i);
                }
                at.c(this.bvn, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bvm.setText(this.bvR);
                at.c(this.bvn, BitmapHelper.getSmallGradeResourceIdNew(this.bvX));
            }
            if (this.bwh) {
                if (f >= 1.0f) {
                    a(this.MX.getOrignalPage(), this.bvo, this.bwi, f);
                } else {
                    b(this.MX.getOrignalPage(), this.bvo, this.bwi, f);
                }
            } else {
                a(this.MX.getOrignalPage(), this.bvo, this.bwi, f);
            }
            this.bwi = f;
        }
    }

    public void f(View view, boolean z) {
        TiebaStatic.eventStat(this.blH.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bwn);
            if (this.bvD == null) {
                this.bvD = new PopupWindow(this.MX.getPageActivity());
                this.bvD.setContentView(this.bvE);
                this.bvD.setBackgroundDrawable(new BitmapDrawable());
                this.bvD.setOutsideTouchable(true);
                this.bvD.setFocusable(true);
                this.bvD.setWidth(this.MX.getResources().getDimensionPixelSize(t.e.frs_header_btn_width));
                this.bvD.setHeight(this.MX.getResources().getDimensionPixelSize(t.e.frs_header_exp_height));
                this.bvF = (TextView) this.bvE.findViewById(t.g.cur_experience);
                this.bvG = (TextView) this.bvE.findViewById(t.g.levelup_experience);
                a(this.bvF, this.bvG);
            }
            if (this.bvD.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bvD, this.MX.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bvF, this.bvG);
            int height = iArr[1] - this.bvD.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.h.j.a(this.bvD, this.MX.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bvD, this.MW, 0, iArr[0], height);
            this.bvD.update();
            this.mHandler.postDelayed(this.bwn, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(t.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(t.g.speed_tip);
            at.b((TextView) inflate.findViewById(t.g.experience), t.d.cp_cont_b, 1);
            at.b(textView, t.d.cp_cont_b, 1);
            at.b(textView2, t.d.cp_cont_b, 1);
            at.b(textView3, t.d.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bvT) && !TextUtils.isEmpty(this.bvT.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bvT);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.MX.getPageActivity());
            aVar.z(inflate);
            aVar.cb(t.d.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(t.j.cancel_text, new z(this));
            aVar.a(t.j.open_now, new aa(this));
            aVar.b(this.MX).up();
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.MW.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
