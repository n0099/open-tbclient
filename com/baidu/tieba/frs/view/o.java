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
    private FrsOfficalBanner aLS;
    private com.baidu.tieba.tbadkCore.v aPo = null;
    private final TbImageView aPp;
    private com.baidu.tbadk.coreExtra.view.b adW;

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.adW = bVar;
        this.aLS.setBannerViewClickListener(bVar);
    }

    public void La() {
        this.aLS.setVisibility(8);
    }

    public o(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.aOQ = i;
        this.LP = tbPageContext;
        this.mHandler = new Handler();
        this.mForumName = str;
        this.mForumId = str2;
        this.LO = com.baidu.adp.lib.g.b.hH().inflate(tbPageContext.getContext(), com.baidu.tieba.w.frs_star_title, null);
        this.aOt = com.baidu.adp.lib.g.b.hH().inflate(tbPageContext.getContext(), com.baidu.tieba.w.frs_show_experience, null);
        if (this.mForumName == null || this.mForumId == null) {
            this.LO.setVisibility(8);
        }
        this.aLS = (FrsOfficalBanner) this.LO.findViewById(com.baidu.tieba.v.frs_offical_banner);
        this.aLS.setVisibility(8);
        this.aOg = (RelativeLayout) this.LO.findViewById(com.baidu.tieba.v.btn_love_content);
        this.aOw = (ImageView) this.LO.findViewById(com.baidu.tieba.v.speed_icon);
        this.aOh = (TextView) this.LO.findViewById(com.baidu.tieba.v.level_name);
        this.aOi = (ImageView) this.LO.findViewById(com.baidu.tieba.v.level);
        this.aOj = (ImageView) this.LO.findViewById(com.baidu.tieba.v.love_level_top);
        this.aOy = (TextView) this.LO.findViewById(com.baidu.tieba.v.frs_tag_text);
        this.aOC = new g(this.LO, this.LP.getPageActivity());
        this.aNY = (FrameLayout) this.LO.findViewById(com.baidu.tieba.v.love);
        this.aNZ = (Button) this.LO.findViewById(com.baidu.tieba.v.btn_love);
        this.LK = (TextView) this.LO.findViewById(com.baidu.tieba.v.tv_love);
        this.aOa = (FrameLayout) this.LO.findViewById(com.baidu.tieba.v.sign);
        this.aOb = (Button) this.LO.findViewById(com.baidu.tieba.v.btn_sign);
        this.aOc = (TextView) this.LO.findViewById(com.baidu.tieba.v.tv_sign);
        this.aOd = (ProgressBar) this.LO.findViewById(com.baidu.tieba.v.sign_progress);
        this.aOe = (FrameLayout) this.LO.findViewById(com.baidu.tieba.v.sign_done);
        this.aOf = (TextView) this.LO.findViewById(com.baidu.tieba.v.sign_done_text);
        this.LI = (TextView) this.LO.findViewById(com.baidu.tieba.v.member_num_text);
        this.LJ = (TextView) this.LO.findViewById(com.baidu.tieba.v.post_num_text);
        this.mTitleText = (TextView) this.LO.findViewById(com.baidu.tieba.v.title_text);
        this.aPp = (TbImageView) this.LO.findViewById(com.baidu.tieba.v.frs_star_top_pic);
        this.aPp.setOnClickListener(new p(this));
        this.aOx = (BarImageView) this.LO.findViewById(com.baidu.tieba.v.frs_star_bottom_photo);
        this.aOx.setGifIconSupport(false);
        this.aOz = (UserIconBox) this.LO.findViewById(com.baidu.tieba.v.frs_badge_box);
        this.aOk = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.frs_header_groups);
        this.aOl = (TextView) this.LO.findViewById(com.baidu.tieba.v.frs_header_groups_text);
        this.aOm = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.frs_header_games);
        this.aOn = (TextView) this.LO.findViewById(com.baidu.tieba.v.frs_header_games_text);
        this.aOB = new ao(this.LP);
        this.aOo = (LinearLayout) this.LO.findViewById(com.baidu.tieba.v.frs_header_enter_root);
        this.aOD = new w(this.LO);
        this.aOr = (U9InfoView) this.LO.findViewById(com.baidu.tieba.v.frs_header_enter_u9);
    }

    public void n(View.OnClickListener onClickListener) {
        this.aOx.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aOg.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.gz().ag("frs_to_bar_detail") == 0) {
            this.LO.setOnClickListener(new q(this));
        }
        this.aOC.setOnClickListener(onClickListener);
        this.aNZ.setOnClickListener(onClickListener);
        this.aOb.setOnClickListener(onClickListener);
        this.aOk.setOnClickListener(onClickListener);
        if (this.aOm != null) {
            this.aOm.setOnClickListener(onClickListener);
        }
        this.aOy.setOnClickListener(new r(this));
    }

    public void changeSkinType(int i) {
        this.LP.getLayoutMode().X(i == 1);
        this.LP.getLayoutMode().h(this.LO);
        this.LP.getLayoutMode().h(this.aOt);
        if (this.aOW) {
            fb(1);
        } else {
            fb(0);
        }
        ba.c(this.aOi, com.baidu.tbadk.core.util.c.bR(this.aOL));
        this.aOx.invalidate();
        this.aPp.invalidate();
        this.LK.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aOc.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LK.setShadowLayer(1.0f, 0.0f, 1.0f, ba.getColor(com.baidu.tieba.s.frs_like_shadow));
        this.aOc.setShadowLayer(1.0f, 0.0f, 1.0f, ba.getColor(com.baidu.tieba.s.frs_sign_shadow));
        ba.i(this.aOk, com.baidu.tieba.u.frs_top_item_bg);
        if (this.aOm != null) {
            ba.i(this.aOm, com.baidu.tieba.u.frs_top_item_bg);
        }
        if (this.aOQ != 0) {
            ba.c(this.aOw, com.baidu.tieba.u.icon_speed_orange);
        } else {
            ba.c(this.aOw, com.baidu.tieba.u.icon_speed_gray);
        }
        if (this.aOD != null) {
            this.aOD.changeSkinType(i);
        }
        if (this.aOr != null) {
            this.aOr.c(this.LP, i);
        }
        if (this.aOz != null) {
            this.aOz.cu(i);
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.w wVar) {
        if (wVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.aOM = forumData.getMember_num();
            this.aON = forumData.getPost_num();
            this.aOF = forumData.getTag_color();
            this.aOG = forumData.getTag_name();
            this.aOO = forumData.getSignData().getCountSignNum();
            this.aOP = forumData.getCurScore();
            this.aOH = forumData.getAccelerateContent();
            this.aNK = forumData.getLevelupScore();
            this.aOI = wVar;
            this.aPo = wVar.akF();
            this.aOA = forumData.getBadgeData();
            this.aOJ = new com.baidu.tbadk.core.data.w();
            this.aOp = forumData.getTopCode();
            this.aOq = forumData.getNewsInfo();
            if (this.aPo != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.aPo.akP());
                this.aOJ.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.aPo.akQ());
                this.aOJ.getMedias().add(mediaData2);
            }
            this.LO.setVisibility(0);
            this.aOC.setForumName(forumData.getName());
            LC();
        }
    }

    private void LC() {
        if (this.LI != null) {
            this.LI.setText(String.valueOf(this.aOM));
        }
        if (this.LJ != null) {
            this.LJ.setText(String.valueOf(this.aON));
        }
        if (this.mTitleText != null) {
            if (this.aOA != null && this.aOA.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.mTitleText.setText(String.valueOf(this.mForumName) + this.LP.getString(y.forum));
        }
        boolean z = MessageManager.getInstance().findTask(2902025) != null;
        if (this.aOG != null && this.aOG.length() > 0 && z) {
            if (this.aOy != null) {
                this.aOy.setText(this.aOG);
            }
            if (this.aOy != null && this.aOF != null && this.aOF.length() > 0) {
                this.aOR = com.baidu.adp.lib.g.c.toInt(this.aOF, -1);
                if (this.aOR >= 0 && this.aOR < aNX.length) {
                    ba.i((View) this.aOy, aNX[this.aOR]);
                }
            }
            if (this.aOy != null) {
                this.aOy.setVisibility(0);
            }
        } else if (this.aOy != null) {
            this.aOy.setVisibility(8);
        }
        if (this.aOI != null && this.aOI.qe() != null && this.aOI.qe().getIfpost() == 0) {
            if (this.aOI.getThreadList().isEmpty()) {
                this.aOk.setVisibility(8);
            } else {
                this.aOk.setVisibility(0);
                if (this.aOI.akJ().akB() > 0) {
                    this.aOl.setText(" (" + this.aOI.akJ().akB() + ")");
                } else {
                    this.aOl.setText("");
                }
            }
        } else {
            this.aOk.setVisibility(0);
            if (this.aOI != null && this.aOI.akJ().akB() > 0) {
                this.aOl.setText(" (" + this.aOI.akJ().akB() + ")");
            } else {
                this.aOl.setText("");
            }
        }
        if (this.aPc) {
            this.aOk.setVisibility(0);
        } else {
            this.aOk.setVisibility(8);
        }
        if (this.aOm != null && this.aOn != null) {
            if (this.aOI != null && this.aOI.akK()) {
                this.aOm.setVisibility(0);
                if (!TextUtils.isEmpty(this.aOI.getGameName()) && !TextUtils.isEmpty(this.aOI.getGameName().trim())) {
                    this.aOn.setText(UtilHelper.getFixedText(this.aOI.getGameName(), 10));
                    String iP = com.baidu.tieba.tbadkCore.util.k.iP(this.aOI.akN());
                    if (!StringUtils.isNull(iP)) {
                        TiebaStatic.eventStat(this.LP.getPageActivity(), "game_show", "show", 1, "dev_id", iP, "ref_id", "1000601", "ref_type", "603");
                    }
                } else {
                    this.aOn.setText("");
                }
            } else {
                this.aOm.setVisibility(8);
            }
        }
        if (this.aOI != null && this.aOI.akL() != null && this.aOI.akL().size() > 0) {
            List<com.baidu.tieba.tbadkCore.o> akL = this.aOI.akL();
            W(akL);
            int size = akL.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.aOo.setVisibility(0);
                this.aOo.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.hH().inflate(this.LP.getPageActivity(), com.baidu.tieba.w.frs_header_enter_lay, null);
                    TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.v.frs_header_enters_icon);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    tbImageView.setDrawerType(1);
                    tbImageView.setRadius(com.baidu.adp.lib.util.n.d(this.LP.getPageActivity(), com.baidu.tieba.t.ds6));
                    tbImageView.c(akL.get(i2).getIcon(), 21, false);
                    ((TextView) linearLayout.findViewById(com.baidu.tieba.v.frs_header_enters_text)).setText(UtilHelper.getFixedText(akL.get(i2).getTitle(), 10));
                    applyNightMode(linearLayout);
                    linearLayout.setTag(akL.get(i2).getUrl());
                    linearLayout.setOnClickListener(this.aPa);
                    this.aOo.addView(linearLayout);
                }
            } else {
                this.aOo.setVisibility(8);
            }
        } else {
            this.aOo.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aPp.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.n.M(this.LP.getContext());
        layoutParams.height = this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300);
        this.aPp.setLayoutParams(layoutParams);
        this.aPp.setDefaultResource(com.baidu.tieba.u.def_star_top_pic);
        this.aPp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aOx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        int akR = this.aPo.akR();
        int akS = this.aPo.akS();
        if (akR == 0 || akS == 0) {
            akR = layoutParams.width;
            akS = layoutParams.height;
        }
        this.aPp.a(this.aPo.akP(), 16, akR, akS, false);
        this.aOx.c(this.aPo.akQ(), 16, false);
        if (this.aOz != null && this.aOA != null && this.aOA.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.aOA.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.aOA.get(i3).pS());
                iconData.setIcon(this.aOA.get(i3).pR());
                this.aOK = this.aOA.get(i3).pT();
                linkedList.add(iconData);
            }
            this.aOz.setOnClickListener(this.aPb);
            this.aOz.a(linkedList, 2, this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_width), this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_height), this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_margin));
        }
        if (this.aOI != null) {
            this.aOD.a(this.aOI.akF(), this.aOI.Za());
        } else {
            this.aOD.a(null, null);
        }
        this.aOr.a(this.aOp, this.aOq);
    }

    public void Lb() {
        PopupWindow popupWindow = new PopupWindow(this.LP.getPageActivity());
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.LP.getContext(), com.baidu.tieba.w.speed_tip, null);
        this.LP.getLayoutMode().h(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new s(this, popupWindow));
        popupWindow.setWidth(this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300));
        popupWindow.setHeight(this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new t(this, popupWindow));
        int[] iArr = new int[2];
        this.aOw.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, this.LO, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aOw.getWidth() / 2), iArr[1] + this.aOw.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aOX = z;
        Bitmap bO = com.baidu.tbadk.core.util.c.bO(com.baidu.tieba.u.bg_frs_signin_bar_down);
        if (bO != null && bO.getWidth() > 0) {
            if (this.aOX) {
                this.aOh.setText(y.star_bar_level_up);
                ba.c(this.aOi, com.baidu.tbadk.core.util.c.bR(this.aOL + 1));
            } else {
                this.aOh.setText(this.aOE);
                ba.c(this.aOi, com.baidu.tbadk.core.util.c.bR(this.aOL));
            }
            if (this.aOX) {
                b(this.LP.getOrignalPage(), this.aOj, this.aOY, f);
            } else {
                a(this.LP.getOrignalPage(), this.aOj, this.aOY, f);
            }
            this.aOY = f;
        }
    }

    public void c(View view, boolean z) {
        if (this.aOQ != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.aOs == null) {
                this.aOs = new PopupWindow(this.LP.getPageActivity());
                this.aOs.setContentView(this.aOt);
                this.aOs.setBackgroundDrawable(new BitmapDrawable());
                this.aOs.setOutsideTouchable(true);
                this.aOs.setFocusable(true);
                this.aOs.setWidth(this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_btn_width));
                this.aOs.setHeight(this.LP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_exp_height));
                this.aOu = (TextView) this.aOt.findViewById(com.baidu.tieba.v.cur_experience);
                this.aOv = (TextView) this.aOt.findViewById(com.baidu.tieba.v.levelup_experience);
                a(this.aOu, this.aOv);
            }
            if (this.aOs.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.aOs, this.LP.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aOu, this.aOv);
            int height = iArr[1] - this.aOs.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.k.a(this.aOs, this.LP.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aOs, this.LO, 0, iArr[0], height);
            this.aOs.update();
            this.mHandler.postDelayed(this.aOZ, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.LP.getPageActivity(), com.baidu.tieba.w.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.v.speed_tip);
            ba.b((TextView) inflate.findViewById(com.baidu.tieba.v.experience), com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
            ba.b(textView3, com.baidu.tieba.s.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.aOH) && !TextUtils.isEmpty(this.aOH.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aOH);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.LP.getPageActivity());
            aVar.j(inflate);
            a(textView, textView2);
            aVar.b(y.cancel_text, new u(this));
            aVar.a(y.open_now, new v(this));
            aVar.b(this.LP).re();
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.LO.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
