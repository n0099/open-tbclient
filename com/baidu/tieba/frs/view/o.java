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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
import com.baidu.tieba.tbadkCore.U9InfoView;
import com.baidu.tieba.y;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends a implements com.baidu.tbadk.imageManager.d {
    private FrsOfficalBanner aLI;
    private com.baidu.tieba.tbadkCore.v aOX = null;
    private final TbImageView aOY;
    private com.baidu.tbadk.coreExtra.view.b adO;

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.adO = bVar;
        this.aLI.setBannerViewClickListener(bVar);
    }

    public void KO() {
        this.aLI.setVisibility(8);
    }

    public o(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.aOz = i;
        this.LN = tbPageContext;
        this.mHandler = new Handler();
        this.mForumName = str;
        this.mForumId = str2;
        this.LM = com.baidu.adp.lib.g.b.hH().inflate(tbPageContext.getContext(), com.baidu.tieba.w.frs_star_title, null);
        this.aOc = com.baidu.adp.lib.g.b.hH().inflate(tbPageContext.getContext(), com.baidu.tieba.w.frs_show_experience, null);
        if (this.mForumName == null || this.mForumId == null) {
            this.LM.setVisibility(8);
        }
        this.aLI = (FrsOfficalBanner) this.LM.findViewById(com.baidu.tieba.v.frs_offical_banner);
        this.aLI.setVisibility(8);
        this.aNP = (RelativeLayout) this.LM.findViewById(com.baidu.tieba.v.btn_love_content);
        this.aOf = (ImageView) this.LM.findViewById(com.baidu.tieba.v.speed_icon);
        this.aNQ = (TextView) this.LM.findViewById(com.baidu.tieba.v.level_name);
        this.aNR = (ImageView) this.LM.findViewById(com.baidu.tieba.v.level);
        this.aNS = (ImageView) this.LM.findViewById(com.baidu.tieba.v.love_level_top);
        this.aOh = (TextView) this.LM.findViewById(com.baidu.tieba.v.frs_tag_text);
        this.aOl = new g(this.LM, this.LN.getPageActivity());
        this.aNH = (FrameLayout) this.LM.findViewById(com.baidu.tieba.v.love);
        this.aNI = (Button) this.LM.findViewById(com.baidu.tieba.v.btn_love);
        this.LI = (TextView) this.LM.findViewById(com.baidu.tieba.v.tv_love);
        this.aNJ = (FrameLayout) this.LM.findViewById(com.baidu.tieba.v.sign);
        this.aNK = (Button) this.LM.findViewById(com.baidu.tieba.v.btn_sign);
        this.aNL = (TextView) this.LM.findViewById(com.baidu.tieba.v.tv_sign);
        this.aNM = (ProgressBar) this.LM.findViewById(com.baidu.tieba.v.sign_progress);
        this.aNN = (FrameLayout) this.LM.findViewById(com.baidu.tieba.v.sign_done);
        this.aNO = (TextView) this.LM.findViewById(com.baidu.tieba.v.sign_done_text);
        this.LG = (TextView) this.LM.findViewById(com.baidu.tieba.v.member_num_text);
        this.LH = (TextView) this.LM.findViewById(com.baidu.tieba.v.post_num_text);
        this.mTitleText = (TextView) this.LM.findViewById(com.baidu.tieba.v.title_text);
        this.aOY = (TbImageView) this.LM.findViewById(com.baidu.tieba.v.frs_star_top_pic);
        this.aOY.setOnClickListener(new p(this));
        this.aOg = (BarImageView) this.LM.findViewById(com.baidu.tieba.v.frs_star_bottom_photo);
        this.aOg.setGifIconSupport(false);
        this.aOi = (UserIconBox) this.LM.findViewById(com.baidu.tieba.v.frs_badge_box);
        this.aNT = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.frs_header_groups);
        this.aNU = (TextView) this.LM.findViewById(com.baidu.tieba.v.frs_header_groups_text);
        this.aNV = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.frs_header_games);
        this.aNW = (TextView) this.LM.findViewById(com.baidu.tieba.v.frs_header_games_text);
        this.aOk = new ao(this.LN);
        this.aNX = (LinearLayout) this.LM.findViewById(com.baidu.tieba.v.frs_header_enter_root);
        this.aOm = new w(this.LM);
        this.aOa = (U9InfoView) this.LM.findViewById(com.baidu.tieba.v.frs_header_enter_u9);
    }

    public void n(View.OnClickListener onClickListener) {
        this.aOg.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aNP.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.gz().ag("frs_to_bar_detail") == 0) {
            this.LM.setOnClickListener(new q(this));
        }
        this.aOl.setOnClickListener(onClickListener);
        this.aNI.setOnClickListener(onClickListener);
        this.aNK.setOnClickListener(onClickListener);
        this.aNT.setOnClickListener(onClickListener);
        if (this.aNV != null) {
            this.aNV.setOnClickListener(onClickListener);
        }
        this.aOh.setOnClickListener(new r(this));
    }

    public void changeSkinType(int i) {
        this.LN.getLayoutMode().X(i == 1);
        this.LN.getLayoutMode().h(this.LM);
        this.LN.getLayoutMode().h(this.aOc);
        if (this.aOF) {
            fa(1);
        } else {
            fa(0);
        }
        ba.c(this.aNR, com.baidu.tbadk.core.util.c.bR(this.aOu));
        this.aOg.invalidate();
        this.aOY.invalidate();
        this.LI.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aNL.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LI.setShadowLayer(1.0f, 0.0f, 1.0f, ba.getColor(com.baidu.tieba.s.frs_like_shadow));
        this.aNL.setShadowLayer(1.0f, 0.0f, 1.0f, ba.getColor(com.baidu.tieba.s.frs_sign_shadow));
        ba.i(this.aNT, com.baidu.tieba.u.frs_top_item_bg);
        if (this.aNV != null) {
            ba.i(this.aNV, com.baidu.tieba.u.frs_top_item_bg);
        }
        if (this.aOz != 0) {
            ba.c(this.aOf, com.baidu.tieba.u.icon_speed_orange);
        } else {
            ba.c(this.aOf, com.baidu.tieba.u.icon_speed_gray);
        }
        if (this.aOm != null) {
            this.aOm.changeSkinType(i);
        }
        if (this.aOa != null) {
            this.aOa.c(this.LN, i);
        }
        if (this.aOi != null) {
            this.aOi.cu(i);
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.aOv = forumData.getMember_num();
            this.aOw = forumData.getPost_num();
            this.aOo = forumData.getTag_color();
            this.aOp = forumData.getTag_name();
            this.aOx = forumData.getSignData().getCountSignNum();
            this.aOy = forumData.getCurScore();
            this.aOq = forumData.getAccelerateContent();
            this.aNt = forumData.getLevelupScore();
            this.aOr = wVar;
            this.aOX = wVar.akq();
            this.aOj = forumData.getBadgeData();
            this.aOs = new com.baidu.tbadk.core.data.w();
            this.aNY = forumData.getTopCode();
            this.aNZ = forumData.getNewsInfo();
            if (this.aOX != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.aOX.akA());
                this.aOs.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.aOX.akB());
                this.aOs.getMedias().add(mediaData2);
            }
            this.LM.setVisibility(0);
            this.aOl.setForumName(forumData.getName());
            Lq();
        }
    }

    private void Lq() {
        if (this.LG != null) {
            this.LG.setText(String.valueOf(this.aOv));
        }
        if (this.LH != null) {
            this.LH.setText(String.valueOf(this.aOw));
        }
        if (this.mTitleText != null) {
            if (this.aOj != null && this.aOj.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.mTitleText.setText(String.valueOf(this.mForumName) + this.LN.getString(y.forum));
        }
        boolean z = MessageManager.getInstance().findTask(2902025) != null;
        if (this.aOp != null && this.aOp.length() > 0 && z) {
            if (this.aOh != null) {
                this.aOh.setText(this.aOp);
            }
            if (this.aOh != null && this.aOo != null && this.aOo.length() > 0) {
                this.aOA = com.baidu.adp.lib.g.c.toInt(this.aOo, -1);
                if (this.aOA >= 0 && this.aOA < aNG.length) {
                    ba.i((View) this.aOh, aNG[this.aOA]);
                }
            }
            if (this.aOh != null) {
                this.aOh.setVisibility(0);
            }
        } else if (this.aOh != null) {
            this.aOh.setVisibility(8);
        }
        if (this.aOr != null && this.aOr.qe() != null && this.aOr.qe().getIfpost() == 0) {
            if (this.aOr.akp().isEmpty()) {
                this.aNT.setVisibility(8);
            } else {
                this.aNT.setVisibility(0);
                if (this.aOr.aku().akm() > 0) {
                    this.aNU.setText(" (" + this.aOr.aku().akm() + ")");
                } else {
                    this.aNU.setText("");
                }
            }
        } else {
            this.aNT.setVisibility(0);
            if (this.aOr != null && this.aOr.aku().akm() > 0) {
                this.aNU.setText(" (" + this.aOr.aku().akm() + ")");
            } else {
                this.aNU.setText("");
            }
        }
        if (this.aOL) {
            this.aNT.setVisibility(0);
        } else {
            this.aNT.setVisibility(8);
        }
        if (this.aNV != null && this.aNW != null) {
            if (this.aOr != null && this.aOr.akv()) {
                this.aNV.setVisibility(0);
                if (!TextUtils.isEmpty(this.aOr.getGameName()) && !TextUtils.isEmpty(this.aOr.getGameName().trim())) {
                    this.aNW.setText(UtilHelper.getFixedText(this.aOr.getGameName(), 10));
                    String iM = com.baidu.tieba.tbadkCore.util.k.iM(this.aOr.aky());
                    if (!StringUtils.isNull(iM)) {
                        TiebaStatic.eventStat(this.LN.getPageActivity(), "game_show", "show", 1, "dev_id", iM, "ref_id", "1000601", "ref_type", "603");
                    }
                } else {
                    this.aNW.setText("");
                }
            } else {
                this.aNV.setVisibility(8);
            }
        }
        if (this.aOr != null && this.aOr.akw() != null && this.aOr.akw().size() > 0) {
            List<com.baidu.tieba.tbadkCore.o> akw = this.aOr.akw();
            U(akw);
            int size = akw.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.aNX.setVisibility(0);
                this.aNX.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.hH().inflate(this.LN.getPageActivity(), com.baidu.tieba.w.frs_header_enter_lay, null);
                    TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.v.frs_header_enters_icon);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    tbImageView.setDrawerType(1);
                    tbImageView.setRadius(com.baidu.adp.lib.util.n.d(this.LN.getPageActivity(), com.baidu.tieba.t.ds6));
                    tbImageView.c(akw.get(i2).getIcon(), 21, false);
                    ((TextView) linearLayout.findViewById(com.baidu.tieba.v.frs_header_enters_text)).setText(UtilHelper.getFixedText(akw.get(i2).getTitle(), 10));
                    applyNightMode(linearLayout);
                    linearLayout.setTag(akw.get(i2).getUrl());
                    linearLayout.setOnClickListener(this.aOJ);
                    this.aNX.addView(linearLayout);
                }
            } else {
                this.aNX.setVisibility(8);
            }
        } else {
            this.aNX.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aOY.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.n.M(this.LN.getContext());
        layoutParams.height = this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300);
        this.aOY.setLayoutParams(layoutParams);
        this.aOY.setDefaultResource(com.baidu.tieba.u.def_star_top_pic);
        this.aOY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aOg.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        int akC = this.aOX.akC();
        int akD = this.aOX.akD();
        if (akC == 0 || akD == 0) {
            akC = layoutParams.width;
            akD = layoutParams.height;
        }
        this.aOY.a(this.aOX.akA(), 16, akC, akD, false);
        this.aOg.c(this.aOX.akB(), 16, false);
        if (this.aOi != null && this.aOj != null && this.aOj.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.aOj.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.aOj.get(i3).pS());
                iconData.setIcon(this.aOj.get(i3).pR());
                this.aOt = this.aOj.get(i3).pT();
                linkedList.add(iconData);
            }
            this.aOi.setOnClickListener(this.aOK);
            this.aOi.a(linkedList, 2, this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_width), this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_height), this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_margin));
        }
        if (this.aOr != null) {
            this.aOm.a(this.aOr.akq(), this.aOr.YO());
        } else {
            this.aOm.a(null, null);
        }
        this.aOa.a(this.aNY, this.aNZ);
    }

    public void KP() {
        PopupWindow popupWindow = new PopupWindow(this.LN.getPageActivity());
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.LN.getContext(), com.baidu.tieba.w.speed_tip, null);
        this.LN.getLayoutMode().h(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new s(this, popupWindow));
        popupWindow.setWidth(this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300));
        popupWindow.setHeight(this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new t(this, popupWindow));
        int[] iArr = new int[2];
        this.aOf.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, this.LM, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aOf.getWidth() / 2), iArr[1] + this.aOf.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aOG = z;
        Bitmap bO = com.baidu.tbadk.core.util.c.bO(com.baidu.tieba.u.bg_frs_signin_bar_down);
        if (bO != null && bO.getWidth() > 0) {
            if (this.aOG) {
                this.aNQ.setText(y.star_bar_level_up);
                ba.c(this.aNR, com.baidu.tbadk.core.util.c.bR(this.aOu + 1));
            } else {
                this.aNQ.setText(this.aOn);
                ba.c(this.aNR, com.baidu.tbadk.core.util.c.bR(this.aOu));
            }
            if (this.aOG) {
                b(this.LN.getOrignalPage(), this.aNS, this.aOH, f);
            } else {
                a(this.LN.getOrignalPage(), this.aNS, this.aOH, f);
            }
            this.aOH = f;
        }
    }

    public void c(View view, boolean z) {
        if (this.aOz != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.aOb == null) {
                this.aOb = new PopupWindow(this.LN.getPageActivity());
                this.aOb.setContentView(this.aOc);
                this.aOb.setBackgroundDrawable(new BitmapDrawable());
                this.aOb.setOutsideTouchable(true);
                this.aOb.setFocusable(true);
                this.aOb.setWidth(this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_btn_width));
                this.aOb.setHeight(this.LN.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_exp_height));
                this.aOd = (TextView) this.aOc.findViewById(com.baidu.tieba.v.cur_experience);
                this.aOe = (TextView) this.aOc.findViewById(com.baidu.tieba.v.levelup_experience);
                a(this.aOd, this.aOe);
            }
            if (this.aOb.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.aOb, this.LN.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aOd, this.aOe);
            int height = iArr[1] - this.aOb.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.k.a(this.aOb, this.LN.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aOb, this.LM, 0, iArr[0], height);
            this.aOb.update();
            this.mHandler.postDelayed(this.aOI, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.LN.getPageActivity(), com.baidu.tieba.w.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.v.speed_tip);
            ba.b((TextView) inflate.findViewById(com.baidu.tieba.v.experience), com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView3, com.baidu.tieba.s.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.aOq) && !TextUtils.isEmpty(this.aOq.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aOq);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.LN.getPageActivity());
            aVar.j(inflate);
            a(textView, textView2);
            aVar.b(y.cancel_text, new u(this));
            aVar.a(y.open_now, new v(this));
            aVar.b(this.LN).re();
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.LM.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
