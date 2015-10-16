package com.baidu.tieba.frs.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends a implements com.baidu.tbadk.imageManager.b {
    private com.baidu.tieba.tbadkCore.n bdM = null;
    private ArrayList<TbImageView> bdt = new ArrayList<>();

    public q(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.aVf = tbPageContext.getOrignalPage();
        this.mContext = tbPageContext;
        this.mHandler = new Handler();
        this.bci = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds20);
        this.bcj = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds72);
        this.bck = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.LS = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_star_title, (ViewGroup) null);
        this.bcI = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.LS.setVisibility(8);
        }
        this.bct = (RelativeLayout) this.LS.findViewById(i.f.btn_love_content);
        this.bcL = (ImageView) this.LS.findViewById(i.f.speed_icon);
        this.bcu = (TextView) this.LS.findViewById(i.f.level_name);
        this.bcv = (ImageView) this.LS.findViewById(i.f.level);
        this.bcw = (ImageView) this.LS.findViewById(i.f.love_level_top);
        this.bcQ = new i(this.LS, this.mContext.getPageActivity());
        this.bcl = (FrameLayout) this.LS.findViewById(i.f.love);
        this.bcm = (Button) this.LS.findViewById(i.f.btn_love);
        this.LO = (TextView) this.LS.findViewById(i.f.tv_love);
        this.bcn = (FrameLayout) this.LS.findViewById(i.f.sign);
        this.bco = (Button) this.LS.findViewById(i.f.btn_sign);
        this.bcp = (TextView) this.LS.findViewById(i.f.tv_sign);
        this.bcq = (ProgressBar) this.LS.findViewById(i.f.sign_progress);
        this.bcr = (FrameLayout) this.LS.findViewById(i.f.sign_done);
        this.bcs = (TextView) this.LS.findViewById(i.f.sign_done_text);
        this.LL = (TextView) this.LS.findViewById(i.f.member_num_text);
        this.LM = (TextView) this.LS.findViewById(i.f.post_num_text);
        this.LN = (TextView) this.LS.findViewById(i.f.title_text);
        this.bcB = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds280), 0, 0);
        this.bcB.setLayoutParams(layoutParams);
        this.bcA = (CoverFlowView) this.LS.findViewById(i.f.frs_coverflowview);
        Oa();
        this.bcA.tc();
        this.bcM = (BarImageView) this.LS.findViewById(i.f.frs_star_bottom_photo);
        this.bcM.setGifIconSupport(false);
        this.bcN = (UserIconBox) this.LS.findViewById(i.f.frs_badge_box);
        this.bcx = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.frs_header_extra, (ViewGroup) null);
        this.bcy = (LinearLayout) this.bcx.findViewById(i.f.frs_header_games);
        this.bcz = (TextView) this.bcx.findViewById(i.f.frs_header_games_text);
        this.bcP = new be(this.mContext);
        this.bcD = (LinearLayout) this.bcx.findViewById(i.f.frs_header_enter_root);
        this.bcR = new w(this.mContext, this.bcx);
        this.bcG = (U9InfoView) this.bcx.findViewById(i.f.frs_header_enter_u9);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bcM.setOnClickListener(onClickListener);
        this.LN.setOnClickListener(onClickListener);
        this.bct.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.e.gv().ah("frs_to_bar_detail") == 0) {
            this.LS.setOnClickListener(new r(this));
        }
        this.bcQ.setOnClickListener(onClickListener);
        this.bcm.setOnClickListener(onClickListener);
        this.bco.setOnClickListener(onClickListener);
        if (this.bcy != null) {
            this.bcy.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ad(i == 1);
        this.mContext.getLayoutMode().k(this.LS);
        this.mContext.getLayoutMode().k(this.bcI);
        this.mContext.getLayoutMode().k(this.bcx);
        if (this.bcA != null) {
            this.bcA.tc();
        }
        if (this.bdg) {
            gc(1);
        } else {
            gc(0);
        }
        an.c(this.bcv, com.baidu.tbadk.core.util.c.ci(this.bcY));
        this.bcM.invalidate();
        this.LO.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bcp.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LO.setShadowLayer(1.0f, 0.0f, 1.0f, an.getColor(i.c.frs_like_shadow));
        this.bcp.setShadowLayer(1.0f, 0.0f, 1.0f, an.getColor(i.c.frs_sign_shadow));
        if (this.bcy != null) {
            an.i(this.bcy, i.e.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            an.c(this.bcL, i.e.icon_speed_orange);
        } else {
            an.c(this.bcL, i.e.icon_speed_gray);
        }
        if (this.bcR != null) {
            this.bcR.changeSkinType(i);
        }
        if (this.bcG != null) {
            this.bcG.d(this.mContext, i);
        }
        if (this.bcN != null) {
            this.bcN.cP(i);
        }
        Iterator<TbImageView> it = this.bdt.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bcZ = forumData.getPost_num();
            this.bcT = forumData.getTag_color();
            this.bda = forumData.getSignData().getCountSignNum();
            this.bdb = forumData.getCurScore();
            this.bcU = forumData.getAccelerateContent();
            this.bbM = forumData.getLevelupScore();
            this.bcV = oVar;
            this.bdM = oVar.avu();
            this.bcO = forumData.getBadgeData();
            this.bcW = new com.baidu.tbadk.core.data.w();
            this.bcE = forumData.getTopCode();
            this.bcF = forumData.getNewsInfo();
            if (this.bdM != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.bdM.avL());
                this.bcW.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.bdM.avM());
                this.bcW.getMedias().add(mediaData2);
            }
            this.LS.setVisibility(0);
            this.bcQ.setForumName(forumData.getName());
            Ob();
        }
    }

    private void Ob() {
        if (this.bcV != null) {
            if (this.bcV.avv() == null || this.bcV.avv().rx() == null || this.bcV.avv().rx().size() <= 0) {
                this.bcB.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.i> arrayList = new ArrayList<>();
                String str = "";
                if (this.bcV.aeN() != null && this.bcV.aeN().getFrsBannerData() != null) {
                    str = this.bcV.aeN().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i(this.bdM.avL(), str, null);
                iVar.ah(true);
                arrayList.add(iVar);
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.h(arrayList);
                a(hVar);
            } else {
                this.bcB.setVisibility(0);
                a(this.bcV.avv());
            }
        }
        if (this.LL != null) {
            this.LL.setText(String.valueOf(this.mMemberNum));
        }
        if (this.LM != null) {
            this.LM.setText(String.valueOf(this.bcZ));
        }
        if (this.LN != null) {
            if (this.bcO != null && this.bcO.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.LN.setText(String.valueOf(this.mForumName) + this.mContext.getString(i.h.forum));
        }
        if (this.bcy != null && this.bcz != null) {
            if (this.bcV != null && this.bcV.avB()) {
                int da = com.baidu.tbadk.core.util.o.da(this.bcV.avF());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (da == 1 && !z) {
                    this.bcy.setVisibility(8);
                } else {
                    this.bcy.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bcV.getGameName()) && !TextUtils.isEmpty(this.bcV.getGameName().trim())) {
                        this.bcz.setText(UtilHelper.getFixedText(this.bcV.getGameName(), 10));
                        String lI = com.baidu.tieba.tbadkCore.util.n.lI(this.bcV.avF());
                        if (!StringUtils.isNull(lI)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", lI, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bcz.setText("");
                    }
                }
            } else {
                this.bcy.setVisibility(8);
            }
        }
        if (this.bcV != null && this.bcV.avC() != null && this.bcV.avC().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> avC = this.bcV.avC();
            aa(avC);
            int size = avC.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bcD.setVisibility(0);
                this.bcD.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar2 = avC.get(i2);
                    if (hVar2 != null && !gQ(hVar2.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds6));
                        tbImageView.d(hVar2.getIcon(), 21, false);
                        this.bdt.add(tbImageView);
                        ((TextView) linearLayout.findViewById(i.f.frs_header_enters_text)).setText(UtilHelper.getFixedText(hVar2.getTitle(), 10));
                        applyNightMode(linearLayout);
                        linearLayout.setTag(hVar2.getUrl());
                        linearLayout.setOnClickListener(this.bdk);
                        this.bcD.addView(linearLayout);
                    }
                }
            } else {
                this.bcD.setVisibility(8);
            }
        } else {
            this.bcD.setVisibility(8);
        }
        this.bcM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcM.d(this.bdM.avM(), 16, false);
        if (this.bcN != null && this.bcO != null && this.bcO.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bcO.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bcO.get(i3).rt());
                iconData.setIcon(this.bcO.get(i3).rs());
                this.bcX = this.bcO.get(i3).ru();
                linkedList.add(iconData);
            }
            this.bcN.setOnClickListener(this.bdl);
            this.bcN.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_margin));
        }
        if (this.bcV != null) {
            this.bcR.a(this.bcV.avu(), this.bcV.aeN());
        } else {
            this.bcR.a(null, null);
        }
        this.bcG.a(this.bcE, this.bcF);
        Oc();
    }

    private void Oc() {
        View Of;
        if (this.bcG.getTopCodeView() != null && this.bcG.getNewsInfoView() != null && this.bcG.getTopCodeViewDivider() != null && this.bcG.getTopCodeView().getVisibility() != 0) {
            if (this.bcG.getTopCodeView().getVisibility() == 8 && this.bcG.getNewsInfoView().getVisibility() == 0) {
                this.bcG.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bcG.getNewsInfoView().getVisibility() == 8 && this.bcy.getVisibility() == 0) {
                this.bcx.findViewById(i.f.frs_header_divider_games).setVisibility(8);
            } else if (this.bcy.getVisibility() == 8 && this.bcD.getVisibility() == 0) {
                if (this.bcD.getChildCount() > 0) {
                    ((LinearLayout) this.bcD.getChildAt(0)).findViewById(i.f.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bcD.getVisibility() == 8 && this.bcR.Oe() != null && (Of = this.bcR.Of()) != null) {
                Of.setVisibility(8);
            }
        }
    }

    public void Ns() {
        PopupWindow popupWindow = new PopupWindow(this.mContext.getPageActivity());
        View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(i.g.speed_tip, (ViewGroup) null);
        this.mContext.getLayoutMode().k(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new s(this, popupWindow));
        popupWindow.setWidth(this.mContext.getResources().getDimensionPixelSize(i.d.ds300));
        popupWindow.setHeight(this.mContext.getResources().getDimensionPixelSize(i.d.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new t(this, popupWindow));
        int[] iArr = new int[2];
        this.bcL.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, this.LS, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.bcL.getWidth() / 2), iArr[1] + this.bcL.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.bdh = z;
        Bitmap cf = com.baidu.tbadk.core.util.c.cf(i.e.bg_frs_signin_bar_down);
        if (cf != null && cf.getWidth() > 0) {
            if (this.bdh) {
                this.bcu.setText(i.h.star_bar_level_up);
                an.c(this.bcv, com.baidu.tbadk.core.util.c.ci(this.bcY + 1));
            } else {
                this.bcu.setText(this.bcS);
                an.c(this.bcv, com.baidu.tbadk.core.util.c.ci(this.bcY));
            }
            if (this.bdh) {
                b(this.mContext.getOrignalPage(), this.bcw, this.bdi, f);
            } else {
                a(this.mContext.getOrignalPage(), this.bcw, this.bdi, f);
            }
            this.bdi = f;
        }
    }

    public void e(View view, boolean z) {
        TiebaStatic.eventStat(this.aVf.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.bcH == null) {
                this.bcH = new PopupWindow(this.mContext.getPageActivity());
                this.bcH.setContentView(this.bcI);
                this.bcH.setBackgroundDrawable(new BitmapDrawable());
                this.bcH.setOutsideTouchable(true);
                this.bcH.setFocusable(true);
                this.bcH.setWidth(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_btn_width));
                this.bcH.setHeight(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_exp_height));
                this.bcJ = (TextView) this.bcI.findViewById(i.f.cur_experience);
                this.bcK = (TextView) this.bcI.findViewById(i.f.levelup_experience);
                a(this.bcJ, this.bcK);
            }
            if (this.bcH.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bcH, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bcJ, this.bcK);
            int height = iArr[1] - this.bcH.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.j.a(this.bcH, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.bcH, this.LS, 0, iArr[0], height);
            this.bcH.update();
            this.mHandler.postDelayed(this.bdj, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(i.f.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(i.f.speed_tip);
            an.b((TextView) inflate.findViewById(i.f.experience), i.c.cp_cont_b, 1);
            an.b(textView, i.c.cp_cont_b, 1);
            an.b(textView2, i.c.cp_cont_b, 1);
            an.b(textView3, i.c.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bcU) && !TextUtils.isEmpty(this.bcU.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bcU);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.m(inflate);
            aVar.bG(i.c.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(i.h.cancel_text, new u(this));
            aVar.a(i.h.open_now, new v(this));
            aVar.b(this.mContext).sR();
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.LS.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
