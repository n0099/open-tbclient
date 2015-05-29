package com.baidu.tieba.frs.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends a implements com.baidu.tbadk.imageManager.d {
    private FrsOfficalBanner aOc;
    private com.baidu.tieba.tbadkCore.v aRy = null;
    private final TbImageView aRz;
    private com.baidu.tbadk.coreExtra.view.b afa;

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.afa = bVar;
        this.aOc.setBannerViewClickListener(bVar);
    }

    public void Mf() {
        this.aOc.setVisibility(8);
    }

    public o(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.aRb = i;
        this.aMk = tbPageContext.getOrignalPage();
        this.LH = tbPageContext;
        this.mHandler = new Handler();
        this.mForumName = str;
        this.mForumId = str2;
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(tbPageContext.getContext(), com.baidu.tieba.r.frs_star_title, null);
        this.aQE = com.baidu.adp.lib.g.b.hr().inflate(tbPageContext.getContext(), com.baidu.tieba.r.frs_show_experience, null);
        if (this.mForumName == null || this.mForumId == null) {
            this.LG.setVisibility(8);
        }
        this.aOc = (FrsOfficalBanner) this.LG.findViewById(com.baidu.tieba.q.frs_offical_banner);
        this.aOc.setVisibility(8);
        this.aQr = (RelativeLayout) this.LG.findViewById(com.baidu.tieba.q.btn_love_content);
        this.aQH = (ImageView) this.LG.findViewById(com.baidu.tieba.q.speed_icon);
        this.aQs = (TextView) this.LG.findViewById(com.baidu.tieba.q.level_name);
        this.aQt = (ImageView) this.LG.findViewById(com.baidu.tieba.q.level);
        this.aQu = (ImageView) this.LG.findViewById(com.baidu.tieba.q.love_level_top);
        this.aQJ = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_tag_text);
        this.aQN = new g(this.LG, this.LH.getPageActivity());
        this.aQj = (FrameLayout) this.LG.findViewById(com.baidu.tieba.q.love);
        this.aQk = (Button) this.LG.findViewById(com.baidu.tieba.q.btn_love);
        this.LB = (TextView) this.LG.findViewById(com.baidu.tieba.q.tv_love);
        this.aQl = (FrameLayout) this.LG.findViewById(com.baidu.tieba.q.sign);
        this.aQm = (Button) this.LG.findViewById(com.baidu.tieba.q.btn_sign);
        this.aQn = (TextView) this.LG.findViewById(com.baidu.tieba.q.tv_sign);
        this.aQo = (ProgressBar) this.LG.findViewById(com.baidu.tieba.q.sign_progress);
        this.aQp = (FrameLayout) this.LG.findViewById(com.baidu.tieba.q.sign_done);
        this.aQq = (TextView) this.LG.findViewById(com.baidu.tieba.q.sign_done_text);
        this.Lz = (TextView) this.LG.findViewById(com.baidu.tieba.q.member_num_text);
        this.LA = (TextView) this.LG.findViewById(com.baidu.tieba.q.post_num_text);
        this.mTitleText = (TextView) this.LG.findViewById(com.baidu.tieba.q.title_text);
        this.aRz = (TbImageView) this.LG.findViewById(com.baidu.tieba.q.frs_star_top_pic);
        this.aRz.setOnClickListener(new p(this));
        this.aQI = (BarImageView) this.LG.findViewById(com.baidu.tieba.q.frs_star_bottom_photo);
        this.aQI.setGifIconSupport(false);
        this.aQK = (UserIconBox) this.LG.findViewById(com.baidu.tieba.q.frs_badge_box);
        this.aQv = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_groups);
        this.aQw = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_header_groups_text);
        this.aQx = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_games);
        this.aQy = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_header_games_text);
        this.aQM = new ao(this.LH);
        this.aQz = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_enter_root);
        this.aQO = new w(this.LH, this.LG);
        this.aQC = (U9InfoView) this.LG.findViewById(com.baidu.tieba.q.frs_header_enter_u9);
    }

    public void n(View.OnClickListener onClickListener) {
        this.aQI.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aQr.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.gD().ai("frs_to_bar_detail") == 0) {
            this.LG.setOnClickListener(new q(this));
        }
        this.aQN.setOnClickListener(onClickListener);
        this.aQk.setOnClickListener(onClickListener);
        this.aQm.setOnClickListener(onClickListener);
        this.aQv.setOnClickListener(onClickListener);
        if (this.aQx != null) {
            this.aQx.setOnClickListener(onClickListener);
        }
        this.aQJ.setOnClickListener(new r(this));
    }

    public void changeSkinType(int i) {
        this.LH.getLayoutMode().ab(i == 1);
        this.LH.getLayoutMode().j(this.LG);
        this.LH.getLayoutMode().j(this.aQE);
        if (this.aRh) {
            fp(1);
        } else {
            fp(0);
        }
        ay.c(this.aQt, com.baidu.tbadk.core.util.c.bU(this.aQW));
        this.aQI.invalidate();
        this.aRz.invalidate();
        this.LB.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aQn.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LB.setShadowLayer(1.0f, 0.0f, 1.0f, ay.getColor(com.baidu.tieba.n.frs_like_shadow));
        this.aQn.setShadowLayer(1.0f, 0.0f, 1.0f, ay.getColor(com.baidu.tieba.n.frs_sign_shadow));
        ay.i(this.aQv, com.baidu.tieba.p.frs_top_item_bg);
        if (this.aQx != null) {
            ay.i(this.aQx, com.baidu.tieba.p.frs_top_item_bg);
        }
        if (this.aRb != 0) {
            ay.c(this.aQH, com.baidu.tieba.p.icon_speed_orange);
        } else {
            ay.c(this.aQH, com.baidu.tieba.p.icon_speed_gray);
        }
        if (this.aQO != null) {
            this.aQO.changeSkinType(i);
        }
        if (this.aQC != null) {
            this.aQC.c(this.LH, i);
        }
        if (this.aQK != null) {
            this.aQK.cz(i);
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.aQX = forumData.getMember_num();
            this.aQY = forumData.getPost_num();
            this.aQQ = forumData.getTag_color();
            this.aQR = forumData.getTag_name();
            this.aQZ = forumData.getSignData().getCountSignNum();
            this.aRa = forumData.getCurScore();
            this.aQS = forumData.getAccelerateContent();
            this.aPW = forumData.getLevelupScore();
            this.aQT = wVar;
            this.aRy = wVar.amp();
            this.aQL = forumData.getBadgeData();
            this.aQU = new com.baidu.tbadk.core.data.w();
            this.aQA = forumData.getTopCode();
            this.aQB = forumData.getNewsInfo();
            if (this.aRy != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.aRy.amA());
                this.aQU.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.aRy.amB());
                this.aQU.getMedias().add(mediaData2);
            }
            this.LG.setVisibility(0);
            this.aQN.setForumName(forumData.getName());
            MH();
        }
    }

    private void MH() {
        if (this.Lz != null) {
            this.Lz.setText(String.valueOf(this.aQX));
        }
        if (this.LA != null) {
            this.LA.setText(String.valueOf(this.aQY));
        }
        if (this.mTitleText != null) {
            if (this.aQL != null && this.aQL.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.mTitleText.setText(String.valueOf(this.mForumName) + this.LH.getString(com.baidu.tieba.t.forum));
        }
        boolean z = MessageManager.getInstance().findTask(2902025) != null;
        if (this.aQR != null && this.aQR.length() > 0 && z) {
            if (this.aQJ != null) {
                this.aQJ.setText(this.aQR);
            }
            if (this.aQJ != null && this.aQQ != null && this.aQQ.length() > 0) {
                this.aRc = com.baidu.adp.lib.g.c.toInt(this.aQQ, -1);
                if (this.aRc >= 0 && this.aRc < aQi.length) {
                    ay.i((View) this.aQJ, aQi[this.aRc]);
                }
            }
            if (this.aQJ != null) {
                this.aQJ.setVisibility(0);
            }
        } else if (this.aQJ != null) {
            this.aQJ.setVisibility(8);
        }
        if (this.aQT != null && this.aQT.qK() != null && this.aQT.qK().getIfpost() == 0) {
            if (this.aQT.getThreadList().isEmpty()) {
                this.aQv.setVisibility(8);
            } else {
                this.aQv.setVisibility(0);
                if (this.aQT.amu().amm() > 0) {
                    this.aQw.setText(" (" + this.aQT.amu().amm() + ")");
                } else {
                    this.aQw.setText("");
                }
            }
        } else {
            this.aQv.setVisibility(0);
            if (this.aQT != null && this.aQT.amu().amm() > 0) {
                this.aQw.setText(" (" + this.aQT.amu().amm() + ")");
            } else {
                this.aQw.setText("");
            }
        }
        if (this.aRn && this.LH != null && this.LH.getOrignalPage() != null && this.LH.getOrignalPage().isLogin()) {
            this.aQv.setVisibility(0);
        } else {
            this.aQv.setVisibility(8);
        }
        if (this.aQx != null && this.aQy != null) {
            if (this.aQT != null && this.aQT.amv()) {
                this.aQx.setVisibility(0);
                if (!TextUtils.isEmpty(this.aQT.getGameName()) && !TextUtils.isEmpty(this.aQT.getGameName().trim())) {
                    this.aQy.setText(UtilHelper.getFixedText(this.aQT.getGameName(), 10));
                    String jJ = com.baidu.tieba.tbadkCore.util.k.jJ(this.aQT.amy());
                    if (!StringUtils.isNull(jJ)) {
                        TiebaStatic.eventStat(this.LH.getPageActivity(), "game_show", "show", 1, "dev_id", jJ, "ref_id", "1000601", "ref_type", "603");
                    }
                } else {
                    this.aQy.setText("");
                }
            } else {
                this.aQx.setVisibility(8);
            }
        }
        if (this.aQT != null && this.aQT.amw() != null && this.aQT.amw().size() > 0) {
            List<com.baidu.tieba.tbadkCore.o> amw = this.aQT.amw();
            Z(amw);
            int size = amw.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.aQz.setVisibility(0);
                this.aQz.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.hr().inflate(this.LH.getPageActivity(), com.baidu.tieba.r.frs_header_enter_lay, null);
                    TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.q.frs_header_enters_icon);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    tbImageView.setDrawerType(1);
                    tbImageView.setRadius(com.baidu.adp.lib.util.n.d(this.LH.getPageActivity(), com.baidu.tieba.o.ds6));
                    tbImageView.c(amw.get(i2).getIcon(), 21, false);
                    ((TextView) linearLayout.findViewById(com.baidu.tieba.q.frs_header_enters_text)).setText(UtilHelper.getFixedText(amw.get(i2).getTitle(), 10));
                    applyNightMode(linearLayout);
                    linearLayout.setTag(amw.get(i2).getUrl());
                    linearLayout.setOnClickListener(this.aRl);
                    this.aQz.addView(linearLayout);
                }
            } else {
                this.aQz.setVisibility(8);
            }
        } else {
            this.aQz.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aRz.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.n.M(this.LH.getContext());
        layoutParams.height = this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds300);
        this.aRz.setLayoutParams(layoutParams);
        this.aRz.setDefaultResource(com.baidu.tieba.p.def_star_top_pic);
        this.aRz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aQI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        int amC = this.aRy.amC();
        int amD = this.aRy.amD();
        if (amC == 0 || amD == 0) {
            amC = layoutParams.width;
            amD = layoutParams.height;
        }
        this.aRz.a(this.aRy.amA(), 16, amC, amD, false);
        this.aQI.c(this.aRy.amB(), 16, false);
        if (this.aQK != null && this.aQL != null && this.aQL.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.aQL.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.aQL.get(i3).qy());
                iconData.setIcon(this.aQL.get(i3).qx());
                this.aQV = this.aQL.get(i3).qz();
                linkedList.add(iconData);
            }
            this.aQK.setOnClickListener(this.aRm);
            this.aQK.a(linkedList, 2, this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_starheader_badge_width), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_starheader_badge_height), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_starheader_badge_margin));
        }
        if (this.aQT != null) {
            this.aQO.a(this.aQT.amp(), this.aQT.aar());
        } else {
            this.aQO.a(null, null);
        }
        this.aQC.a(this.aQA, this.aQB);
    }

    public void Mg() {
        PopupWindow popupWindow = new PopupWindow(this.LH.getPageActivity());
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.LH.getContext(), com.baidu.tieba.r.speed_tip, null);
        this.LH.getLayoutMode().j(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new s(this, popupWindow));
        popupWindow.setWidth(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds300));
        popupWindow.setHeight(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new t(this, popupWindow));
        int[] iArr = new int[2];
        this.aQH.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, this.LG, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aQH.getWidth() / 2), iArr[1] + this.aQH.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aRi = z;
        Bitmap bR = com.baidu.tbadk.core.util.c.bR(com.baidu.tieba.p.bg_frs_signin_bar_down);
        if (bR != null && bR.getWidth() > 0) {
            if (this.aRi) {
                this.aQs.setText(com.baidu.tieba.t.star_bar_level_up);
                ay.c(this.aQt, com.baidu.tbadk.core.util.c.bU(this.aQW + 1));
            } else {
                this.aQs.setText(this.aQP);
                ay.c(this.aQt, com.baidu.tbadk.core.util.c.bU(this.aQW));
            }
            if (this.aRi) {
                b(this.LH.getOrignalPage(), this.aQu, this.aRj, f);
            } else {
                a(this.LH.getOrignalPage(), this.aQu, this.aRj, f);
            }
            this.aRj = f;
        }
    }

    public void c(View view, boolean z) {
        TiebaStatic.eventStat(this.aMk.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.aRb != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.aQD == null) {
                this.aQD = new PopupWindow(this.LH.getPageActivity());
                this.aQD.setContentView(this.aQE);
                this.aQD.setBackgroundDrawable(new BitmapDrawable());
                this.aQD.setOutsideTouchable(true);
                this.aQD.setFocusable(true);
                this.aQD.setWidth(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_btn_width));
                this.aQD.setHeight(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_exp_height));
                this.aQF = (TextView) this.aQE.findViewById(com.baidu.tieba.q.cur_experience);
                this.aQG = (TextView) this.aQE.findViewById(com.baidu.tieba.q.levelup_experience);
                a(this.aQF, this.aQG);
            }
            if (this.aQD.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.aQD, this.LH.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aQF, this.aQG);
            int height = iArr[1] - this.aQD.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.k.a(this.aQD, this.LH.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aQD, this.LG, 0, iArr[0], height);
            this.aQD.update();
            this.mHandler.postDelayed(this.aRk, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.LH.getPageActivity(), com.baidu.tieba.r.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.q.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.q.speed_tip);
            ay.b((TextView) inflate.findViewById(com.baidu.tieba.q.experience), com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(textView2, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(textView3, com.baidu.tieba.n.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.aQS) && !TextUtils.isEmpty(this.aQS.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aQS);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.LH.getPageActivity());
            aVar.l(inflate);
            aVar.bv(com.baidu.tieba.n.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(com.baidu.tieba.t.cancel_text, new u(this));
            aVar.a(com.baidu.tieba.t.open_now, new v(this));
            aVar.b(this.LH).rL();
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.LG.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
