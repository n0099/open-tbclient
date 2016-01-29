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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class t extends b implements com.baidu.tbadk.imageManager.b {
    private com.baidu.tieba.tbadkCore.n brK = null;
    private ArrayList<TbImageView> brp = new ArrayList<>();

    public t(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.bgW = tbPageContext.getOrignalPage();
        this.MR = tbPageContext;
        this.mHandler = new Handler();
        this.bpY = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds20);
        this.bpZ = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds72);
        this.bqa = com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.MQ = LayoutInflater.from(tbPageContext.getContext()).inflate(t.h.frs_star_title, (ViewGroup) null);
        this.bqB = LayoutInflater.from(tbPageContext.getContext()).inflate(t.h.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.MQ.setVisibility(8);
        }
        this.bqj = (RelativeLayout) this.MQ.findViewById(t.g.btn_love_content);
        this.bqE = (ImageView) this.MQ.findViewById(t.g.speed_icon);
        this.bqk = (TextView) this.MQ.findViewById(t.g.level_name);
        this.bql = (ImageView) this.MQ.findViewById(t.g.level);
        this.bqm = (ImageView) this.MQ.findViewById(t.g.love_level_top);
        this.bqK = new j(this.MQ, this.MR.getPageActivity());
        this.bqb = (FrameLayout) this.MQ.findViewById(t.g.love);
        this.bqc = (Button) this.MQ.findViewById(t.g.btn_love);
        this.MM = (TextView) this.MQ.findViewById(t.g.tv_love);
        this.bqd = (FrameLayout) this.MQ.findViewById(t.g.sign);
        this.bqe = (Button) this.MQ.findViewById(t.g.btn_sign);
        this.bqf = (TextView) this.MQ.findViewById(t.g.tv_sign);
        this.bqg = (ProgressBar) this.MQ.findViewById(t.g.sign_progress);
        this.bqh = (FrameLayout) this.MQ.findViewById(t.g.sign_done);
        this.bqi = (TextView) this.MQ.findViewById(t.g.sign_done_text);
        this.MJ = (TextView) this.MQ.findViewById(t.g.member_num_text);
        this.MK = (TextView) this.MQ.findViewById(t.g.post_num_text);
        this.ML = (TextView) this.MQ.findViewById(t.g.title_text);
        this.bqu = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.MR.getPageActivity(), t.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.c(this.MR.getPageActivity(), t.e.ds280), 0, 0);
        this.bqu.setLayoutParams(layoutParams);
        this.bqt = (CoverFlowView) this.MQ.findViewById(t.g.frs_coverflowview);
        Su();
        this.bqt.uv();
        this.bqG = (BarImageView) this.MQ.findViewById(t.g.frs_star_bottom_photo);
        this.bqG.setGifIconSupport(false);
        this.bqH = (UserIconBox) this.MQ.findViewById(t.g.frs_badge_box);
        this.bqn = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(t.h.frs_header_extra, (ViewGroup) null);
        this.bqq = (LinearLayout) this.bqn.findViewById(t.g.frs_bawu_center);
        this.bqr = (LinearLayout) this.bqn.findViewById(t.g.frs_header_games);
        this.bqs = (TextView) this.bqn.findViewById(t.g.frs_header_games_text);
        this.biF = new bx(this.MR, this.MQ, 1);
        this.biF.hide();
        this.bqJ = new bi(this.MR);
        this.bqw = (LinearLayout) this.bqn.findViewById(t.g.frs_header_enter_root);
        this.bqL = new aa(this.MR, this.bqn);
        this.bqz = (U9InfoView) this.bqn.findViewById(t.g.frs_header_enter_u9);
        this.bqM = (ForumMemberIconView) this.MQ.findViewById(t.g.forum_member_icon_layout);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bqG.setOnClickListener(onClickListener);
        this.ML.setOnClickListener(onClickListener);
        this.bqj.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.c.e.gE().ai("frs_to_bar_detail") == 0) {
            this.MQ.setOnClickListener(new u(this));
        }
        this.bqK.setOnClickListener(onClickListener);
        this.bqc.setOnClickListener(onClickListener);
        this.bqe.setOnClickListener(onClickListener);
        this.bqh.setOnClickListener(onClickListener);
        if (this.bqq != null) {
            this.bqq.setOnClickListener(onClickListener);
        }
        if (this.bqr != null) {
            this.bqr.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.MR.getLayoutMode().ac(i == 1);
        this.MR.getLayoutMode().x(this.MQ);
        this.MR.getLayoutMode().x(this.bqB);
        this.MR.getLayoutMode().x(this.bqn);
        if (this.bqt != null) {
            this.bqt.uv();
        }
        if (this.brd) {
            hb(1);
        } else {
            hb(0);
        }
        ar.c(this.bql, BitmapHelper.getSmallGradeResourceIdNew(this.bqU));
        this.bqG.invalidate();
        this.MM.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bqf.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.MM.setShadowLayer(1.0f, 0.0f, 1.0f, ar.getColor(t.d.frs_like_shadow));
        this.bqf.setShadowLayer(1.0f, 0.0f, 1.0f, ar.getColor(t.d.frs_sign_shadow));
        if (this.bqq != null) {
            ar.k(this.bqq, t.f.frs_top_item_bg);
        }
        if (this.bqr != null) {
            ar.k(this.bqr, t.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ar.c(this.bqE, t.f.icon_speed_orange);
        } else {
            ar.c(this.bqE, t.f.icon_speed_gray);
        }
        if (this.bqL != null) {
            this.bqL.changeSkinType(i);
        }
        if (this.biF != null) {
            this.biF.changeSkinType(i);
        }
        if (this.bqz != null) {
            this.bqz.e(this.MR, i);
        }
        if (this.bqH != null) {
            this.bqH.dk(i);
        }
        Iterator<TbImageView> it = this.brp.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        if (this.bqM != null) {
            this.bqM.e(this.MR, i);
        }
        if (this.bqo != null) {
            com.baidu.tbadk.i.a.a(this.bgW.getPageContext(), this.bqo);
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null && forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bqV = forumData.getPost_num();
            this.bqP = forumData.getTag_color();
            this.bqO = forumData.getLevelName();
            this.bqU = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.bqW = forumData.getSignData().getCountSignNum();
                this.bqX = forumData.getSignData().getMissSignNum();
            }
            this.bqY = forumData.getCurScore();
            this.bqQ = forumData.getAccelerateContent();
            this.bqN = forumData.getMemberShowIconData();
            this.bpB = forumData.getLevelupScore();
            this.bqR = oVar;
            this.brK = oVar.aKP();
            this.bqI = forumData.getBadgeData();
            this.bqS = new ah();
            this.bqx = forumData.getTopCode();
            this.bqy = forumData.getNewsInfo();
            if (this.brK != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.brK.aLj());
                this.bqS.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.brK.aLk());
                this.bqS.getMedias().add(mediaData2);
            }
            this.MQ.setVisibility(0);
            this.bqK.setForumName(forumData.getName());
            Sv();
        }
    }

    private void Sv() {
        ArrayList<com.baidu.tbadk.core.data.c> allAdvertList;
        if (this.bqR != null) {
            if (this.bqR.aKQ() == null || this.bqR.aKQ().rW() == null || this.bqR.aKQ().rW().size() <= 0) {
                this.bqu.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.k> arrayList = new ArrayList<>();
                String str = "";
                if (this.bqR.aoE() != null && this.bqR.aoE().getFrsBannerData() != null) {
                    str = this.bqR.aoE().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k(this.brK.aLj(), str, null);
                kVar.ah(true);
                arrayList.add(kVar);
                com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
                jVar.i(arrayList);
                a(jVar);
            } else {
                this.bqu.setVisibility(0);
                a(this.bqR.aKQ());
            }
        }
        if (this.MJ != null) {
            this.MJ.setText(aw.A(this.mMemberNum));
        }
        if (this.MK != null) {
            this.MK.setText(aw.A(this.bqV));
        }
        if (this.ML != null) {
            if (this.bqI != null && this.bqI.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.ML.setText(String.valueOf(this.mForumName) + this.MR.getString(t.j.forum));
        }
        if (this.bqq != null) {
            if (this.bqR != null && this.bqR.getUserData() != null && this.bqR.getUserData().isBawu()) {
                this.bqq.setVisibility(0);
            } else {
                this.bqq.setVisibility(8);
            }
        }
        if (this.bqR != null && this.bqR.aoE() != null && this.bqR.aoE().getAdKillerData() != null) {
            BannerListData bannerListData = this.bqR.aoE().getBannerListData();
            if (bannerListData == null || (allAdvertList = bannerListData.getAllAdvertList()) == null || allAdvertList.size() <= 0) {
                if (this.bqo == null) {
                    this.bqo = (RelativeLayout) ((ViewStub) this.bqn.findViewById(t.g.frs_head_adkiller)).inflate();
                    com.baidu.tbadk.i.a.a(this.bgW.getPageContext(), this.bqo);
                    this.bqp = (TextView) this.bqo.findViewById(t.g.adkiller_tip);
                }
                com.baidu.tbadk.core.data.b adKillerData = this.bqR.aoE().getAdKillerData();
                int rI = adKillerData.rI();
                String string = this.bgW.getResources().getString(t.j.adkiller_tip_success);
                if (rI > 0) {
                    string = this.bgW.getResources().getString(t.j.adkiller_tip_fail, Integer.valueOf(adKillerData.rI()));
                }
                String substring = string.substring(string.indexOf("("));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, substring, new ForegroundColorSpan(ar.getColor(t.d.cp_cont_h)));
                this.bqp.setText(spannableString);
                this.bqo.setOnClickListener(new v(this, adKillerData));
            }
        }
        if (this.bqr != null && this.bqs != null) {
            if (this.bqR != null && this.bqR.aKW()) {
                int di = com.baidu.tbadk.core.util.n.di(this.bqR.aKZ());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (di == 1 && !z) {
                    this.bqr.setVisibility(8);
                } else {
                    this.bqr.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bqR.getGameName()) && !TextUtils.isEmpty(this.bqR.getGameName().trim())) {
                        this.bqs.setText(UtilHelper.getFixedText(this.bqR.getGameName(), 10));
                        String mQ = com.baidu.tieba.tbadkCore.util.n.mQ(this.bqR.aKZ());
                        if (!StringUtils.isNull(mQ)) {
                            TiebaStatic.eventStat(this.MR.getPageActivity(), "game_show", "show", 1, "dev_id", mQ, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bqs.setText(this.MR.getResources().getString(t.j.frsgame_title));
                    }
                }
            } else {
                this.bqr.setVisibility(8);
            }
        }
        if (this.bqR != null && this.bqR.aKX() != null && this.bqR.aKX().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> aKX = this.bqR.aKX();
            ai(aKX);
            int size = aKX.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bqw.setVisibility(0);
                this.bqw.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = aKX.get(i2);
                    if (gVar != null && !hx(gVar.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(t.g.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.c(this.MR.getPageActivity(), t.e.ds6));
                        tbImageView.d(gVar.getIcon(), 21, false);
                        this.brp.add(tbImageView);
                        ((TextView) linearLayout.findViewById(t.g.frs_header_enters_text)).setText(UtilHelper.getFixedText(gVar.getTitle(), 10));
                        u(linearLayout);
                        linearLayout.setTag(gVar.getUrl());
                        linearLayout.setOnClickListener(this.brh);
                        this.bqw.addView(linearLayout);
                    }
                }
            } else {
                this.bqw.setVisibility(8);
            }
        } else {
            this.bqw.setVisibility(8);
        }
        this.bqG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bqG.d(this.brK.aLk(), 16, false);
        if (this.bqH != null && this.bqI != null && this.bqI.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bqI.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bqI.get(i3).rS());
                iconData.setIcon(this.bqI.get(i3).rR());
                this.bqT = this.bqI.get(i3).rT();
                linkedList.add(iconData);
            }
            this.bqH.setOnClickListener(this.ahM);
            this.bqH.a(linkedList, 2, this.MR.getResources().getDimensionPixelSize(t.e.frs_starheader_badge_width), this.MR.getResources().getDimensionPixelSize(t.e.frs_starheader_badge_height), this.MR.getResources().getDimensionPixelSize(t.e.frs_starheader_badge_margin));
        }
        if (this.bqR != null) {
            this.bqL.a(this.bqR.aKP(), this.bqR.aoE());
        } else {
            this.bqL.a(null, null);
        }
        if (this.bqR != null) {
            this.biF.b(this.bqR);
        }
        this.bqz.a(this.bqx, this.bqy);
        String icon = this.bqN.getIcon();
        String url = this.bqN.getUrl();
        if (this.bqN != null && this.bqM != null) {
            this.bqM.setIcon(icon);
            this.bqM.setUrl(url);
        }
        Sw();
    }

    private void Sw() {
        View Sz;
        if (this.bqz.getTopCodeView() != null && this.bqz.getNewsInfoView() != null && this.bqz.getTopCodeViewDivider() != null && this.bqz.getTopCodeView().getVisibility() != 0) {
            if (this.bqz.getTopCodeView().getVisibility() == 8 && this.bqz.getNewsInfoView().getVisibility() == 0) {
                this.bqz.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bqz.getNewsInfoView().getVisibility() == 8 && this.bqr.getVisibility() == 0) {
                this.bqn.findViewById(t.g.frs_header_divider_games).setVisibility(8);
            } else if (this.bqr.getVisibility() == 8 && this.bqw.getVisibility() == 0) {
                if (this.bqw.getChildCount() > 0) {
                    ((LinearLayout) this.bqw.getChildAt(0)).findViewById(t.g.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bqw.getVisibility() == 8 && this.bqL.Sy() != null && (Sz = this.bqL.Sz()) != null) {
                Sz.setVisibility(8);
            }
        }
    }

    public void RM() {
        View contentView;
        if (this.bqF == null) {
            this.bqF = new PopupWindow(this.MR.getPageActivity());
            contentView = LayoutInflater.from(this.MR.getContext()).inflate(t.h.speed_tip, (ViewGroup) null);
            this.bqF.setContentView(contentView);
            contentView.setOnClickListener(new w(this));
            this.bqF.setWidth(this.MR.getResources().getDimensionPixelSize(t.e.ds300));
            this.bqF.setHeight(this.MR.getResources().getDimensionPixelSize(t.e.ds88));
            this.bqF.setBackgroundDrawable(new BitmapDrawable());
            this.bqF.setOutsideTouchable(true);
            this.bqF.setTouchInterceptor(new x(this));
        } else {
            contentView = this.bqF.getContentView();
        }
        this.MR.getLayoutMode().x(contentView);
        int[] iArr = new int[2];
        this.bqE.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bqF, this.MQ, 0, (iArr[0] - (this.bqF.getWidth() / 2)) + (this.bqE.getWidth() / 2), iArr[1] + this.bqE.getWidth());
        this.bqF.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(boolean z, float f) {
        int i;
        this.bre = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(t.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.bre) {
                this.bqk.setText(t.j.star_bar_level_up);
                this.bqk.setText(t.j.level_up);
                if (f >= 1.0f) {
                    i = this.bqU;
                } else {
                    i = this.bqU + 1;
                }
                com.baidu.tieba.tbadkCore.o Pk = this.bgW.Pk();
                if (Pk != null && Pk.aoE() != null) {
                    Pk.aoE().setUser_level(i);
                }
                ar.c(this.bql, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bqk.setText(this.bqO);
                ar.c(this.bql, BitmapHelper.getSmallGradeResourceIdNew(this.bqU));
            }
            if (this.bre) {
                if (f >= 1.0f) {
                    a(this.MR.getOrignalPage(), this.bqm, this.brf, f);
                } else {
                    b(this.MR.getOrignalPage(), this.bqm, this.brf, f);
                }
            } else {
                a(this.MR.getOrignalPage(), this.bqm, this.brf, f);
            }
            this.brf = f;
        }
    }

    public void f(View view, boolean z) {
        TiebaStatic.eventStat(this.bgW.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.brg);
            if (this.bqA == null) {
                this.bqA = new PopupWindow(this.MR.getPageActivity());
                this.bqA.setContentView(this.bqB);
                this.bqA.setBackgroundDrawable(new BitmapDrawable());
                this.bqA.setOutsideTouchable(true);
                this.bqA.setFocusable(true);
                this.bqA.setWidth(this.MR.getResources().getDimensionPixelSize(t.e.frs_header_btn_width));
                this.bqA.setHeight(this.MR.getResources().getDimensionPixelSize(t.e.frs_header_exp_height));
                this.bqC = (TextView) this.bqB.findViewById(t.g.cur_experience);
                this.bqD = (TextView) this.bqB.findViewById(t.g.levelup_experience);
                a(this.bqC, this.bqD);
            }
            if (this.bqA.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bqA, this.MR.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bqC, this.bqD);
            int height = iArr[1] - this.bqA.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.h.j.a(this.bqA, this.MR.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bqA, this.MQ, 0, iArr[0], height);
            this.bqA.update();
            this.mHandler.postDelayed(this.brg, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(t.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(t.g.speed_tip);
            ar.b((TextView) inflate.findViewById(t.g.experience), t.d.cp_cont_b, 1);
            ar.b(textView, t.d.cp_cont_b, 1);
            ar.b(textView2, t.d.cp_cont_b, 1);
            ar.b(textView3, t.d.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bqQ) && !TextUtils.isEmpty(this.bqQ.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bqQ);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.MR.getPageActivity());
            aVar.z(inflate);
            aVar.bZ(t.d.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(t.j.cancel_text, new y(this));
            aVar.a(t.j.open_now, new z(this));
            aVar.b(this.MR).uj();
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.MQ.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
