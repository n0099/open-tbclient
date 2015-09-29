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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
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
public class FrsHeaderView extends a {
    private View aNp;
    private ArrayList<TbImageView> bdi = new ArrayList<>();
    private String mImageUrl;

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (bdl) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PAGE[] valuesCustom() {
            PAGE[] valuesCustom = values();
            int length = valuesCustom.length;
            PAGE[] pageArr = new PAGE[length];
            System.arraycopy(valuesCustom, 0, pageArr, 0, length);
            return pageArr;
        }
    }

    public FrsHeaderView(FrsActivity frsActivity, PAGE page, String str, String str2, int i) {
        this.aNp = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.aUU = frsActivity;
        this.mContext = frsActivity.getPageContext();
        this.bbX = com.baidu.adp.lib.util.k.d(frsActivity.getPageContext().getPageActivity(), i.d.ds20);
        this.bbY = com.baidu.adp.lib.util.k.d(frsActivity.getPageContext().getPageActivity(), i.d.ds72);
        this.bbZ = com.baidu.adp.lib.util.k.d(frsActivity.getPageContext().getPageActivity(), i.d.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.LR = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(i.g.frs_normal_header, (ViewGroup) null);
        this.aNp = this.LR.findViewById(i.f.container);
        this.bcx = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(i.g.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.LR.setVisibility(8);
        }
        this.bcq = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(i.g.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds280), 0, 0);
        this.bcq.setLayoutParams(layoutParams);
        this.bcp = (CoverFlowView) this.LR.findViewById(i.f.nomal_frs_coverflowview);
        Oa();
        this.bci = (RelativeLayout) this.LR.findViewById(i.f.btn_love_content);
        this.bcA = (ImageView) this.LR.findViewById(i.f.speed_icon);
        this.bcF = new i(this.LR, this.mContext.getPageActivity());
        this.bcj = (TextView) this.LR.findViewById(i.f.level_name);
        this.bck = (ImageView) this.LR.findViewById(i.f.level);
        this.bcl = (ImageView) this.LR.findViewById(i.f.love_level_top);
        this.bca = (FrameLayout) this.LR.findViewById(i.f.love);
        this.bcb = (Button) this.LR.findViewById(i.f.btn_love);
        this.LN = (TextView) this.LR.findViewById(i.f.tv_love);
        this.bcc = (FrameLayout) this.LR.findViewById(i.f.sign);
        this.bcd = (Button) this.LR.findViewById(i.f.btn_sign);
        this.bce = (TextView) this.LR.findViewById(i.f.tv_sign);
        this.bcf = (ProgressBar) this.LR.findViewById(i.f.sign_progress);
        this.bcg = (FrameLayout) this.LR.findViewById(i.f.sign_done);
        this.bch = (TextView) this.LR.findViewById(i.f.sign_done_text);
        this.LK = (TextView) this.LR.findViewById(i.f.member_num_text);
        this.LL = (TextView) this.LR.findViewById(i.f.post_num_text);
        this.LM = (TextView) this.LR.findViewById(i.f.title_text);
        this.bcB = (BarImageView) this.LR.findViewById(i.f.frs_image);
        this.bcB.setGifIconSupport(false);
        this.bcC = (UserIconBox) this.LR.findViewById(i.f.frs_badge_box);
        this.bcm = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(i.g.frs_header_extra, (ViewGroup) null);
        this.bcn = (LinearLayout) this.bcm.findViewById(i.f.frs_header_games);
        this.bco = (TextView) this.bcm.findViewById(i.f.frs_header_games_text);
        this.bcs = (LinearLayout) this.bcm.findViewById(i.f.frs_header_enter_root);
        this.bcG = new w(this.mContext, this.bcm);
        this.bcE = new be(this.mContext);
        this.bcv = (U9InfoView) this.bcm.findViewById(i.f.frs_header_enter_u9);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bcB.setOnClickListener(onClickListener);
        this.LM.setOnClickListener(onClickListener);
        this.bcb.setOnClickListener(onClickListener);
        this.bcd.setOnClickListener(onClickListener);
        this.bci.setOnClickListener(onClickListener);
        if (this.bcn != null) {
            this.bcn.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.b.e.gv().ah("frs_to_bar_detail") == 0) {
            this.LR.setOnClickListener(new k(this));
        }
        this.bcF.setOnClickListener(onClickListener);
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ad(i == 1);
        this.mContext.getLayoutMode().k(this.LR);
        this.mContext.getLayoutMode().k(this.bcx);
        this.mContext.getLayoutMode().k(this.bcm);
        if (this.bcV) {
            gc(1);
        } else {
            gc(0);
        }
        if (this.bcp != null) {
            this.bcp.tc();
        }
        this.bcB.invalidate();
        am.c(this.bck, com.baidu.tbadk.core.util.c.ci(this.bcN));
        am.j(this.aNp, i.c.cp_bg_line_d);
        this.LN.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bce.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LN.setShadowLayer(1.0f, 0.0f, 1.0f, am.getColor(i.c.frs_like_shadow));
        this.bce.setShadowLayer(1.0f, 0.0f, 1.0f, am.getColor(i.c.frs_sign_shadow));
        if (this.bcn != null) {
            am.i(this.bcn, i.e.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            am.c(this.bcA, i.e.icon_speed_orange);
        } else {
            am.c(this.bcA, i.e.icon_speed_gray);
        }
        if (this.bcG != null) {
            this.bcG.changeSkinType(i);
        }
        if (this.bcv != null) {
            this.bcv.d(this.mContext, i);
        }
        if (this.bcC != null) {
            this.bcC.cP(i);
        }
        Iterator<TbImageView> it = this.bdi.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        this.mForumName = forumData.getName();
        this.mForumId = forumData.getId();
        this.mMemberNum = forumData.getMember_num();
        this.bcO = forumData.getPost_num();
        this.bcI = forumData.getTag_color();
        this.mImageUrl = forumData.getImage_url();
        this.bcH = forumData.getLevelName();
        this.bcN = forumData.getUser_level();
        this.bcP = forumData.getSignData().getCountSignNum();
        this.bcQ = forumData.getCurScore();
        this.bbB = forumData.getLevelupScore();
        this.bcD = forumData.getBadgeData();
        this.bct = forumData.getTopCode();
        this.bcu = forumData.getNewsInfo();
        this.bcJ = forumData.getAccelerateContent();
        this.bcK = oVar;
        if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
            this.LR.setVisibility(8);
        } else {
            this.LR.setVisibility(0);
        }
        this.bcL = new com.baidu.tbadk.core.data.v();
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.bcL.getMedias().add(mediaData);
        this.bcF.setForumName(forumData.getName());
        Ob();
    }

    private void Ob() {
        if (this.bcK != null) {
            a(this.bcK.avp());
        }
        if (this.LK != null) {
            this.LK.setText(String.valueOf(this.mMemberNum));
        }
        if (this.LL != null) {
            this.LL.setText(String.valueOf(this.bcO));
        }
        if (this.LM != null) {
            if (this.bcD != null && this.bcD.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.LM.setText(String.valueOf(this.mForumName) + this.mContext.getString(i.h.forum));
            }
        }
        if (this.bcn != null && this.bco != null) {
            if (this.bcK != null && this.bcK.avv()) {
                int cZ = com.baidu.tbadk.core.util.o.cZ(this.bcK.avz());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (cZ == 1 && !z) {
                    this.bcn.setVisibility(8);
                } else {
                    this.bcn.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bcK.getGameName()) && !TextUtils.isEmpty(this.bcK.getGameName().trim())) {
                        this.bco.setText(UtilHelper.getFixedText(this.bcK.getGameName(), 10));
                        String lF = com.baidu.tieba.tbadkCore.util.n.lF(this.bcK.avz());
                        if (!StringUtils.isNull(lF)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", lF, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bco.setText("");
                    }
                }
            } else {
                this.bcn.setVisibility(8);
            }
        }
        if (this.bcK != null && this.bcK.avw() != null && this.bcK.avw().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> avw = this.bcK.avw();
            aa(avw);
            int size = avw.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bcs.setVisibility(0);
                this.bcs.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar = avw.get(i2);
                    if (hVar != null && !gQ(hVar.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds6));
                        tbImageView.d(hVar.getIcon(), 21, false);
                        this.bdi.add(tbImageView);
                        ((TextView) linearLayout.findViewById(i.f.frs_header_enters_text)).setText(UtilHelper.getFixedText(hVar.getTitle(), 10));
                        applyNightMode(linearLayout);
                        linearLayout.setTag(hVar.getUrl());
                        linearLayout.setOnClickListener(this.bcZ);
                        this.bcs.addView(linearLayout);
                    }
                }
            } else {
                this.bcs.setVisibility(8);
            }
        } else {
            this.bcs.setVisibility(8);
        }
        if (this.bcK != null) {
            this.bcG.a(this.bcK.avo(), this.bcK.aeN());
        } else {
            this.bcG.a(null, null);
        }
        this.bcB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcB.d(this.mImageUrl, 15, false);
        if (this.bcC != null && this.bcD != null && this.bcD.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bcD.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bcD.get(i3).rt());
                iconData.setIcon(this.bcD.get(i3).rs());
                this.bcM = this.bcD.get(i3).ru();
                linkedList.add(iconData);
            }
            this.bcC.setOnClickListener(this.bda);
            this.bcC.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_badge_width), this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_badge_height), this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_badge_margin));
        }
        this.bcv.a(this.bct, this.bcu);
        Oc();
    }

    private void Oc() {
        View Of;
        if (this.bcv.getTopCodeView() != null && this.bcv.getNewsInfoView() != null && this.bcv.getTopCodeViewDivider() != null && this.bcv.getTopCodeView().getVisibility() != 0) {
            if (this.bcv.getTopCodeView().getVisibility() == 8 && this.bcv.getNewsInfoView().getVisibility() == 0) {
                this.bcv.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bcv.getNewsInfoView().getVisibility() == 8 && this.bcn.getVisibility() == 0) {
                this.bcm.findViewById(i.f.frs_header_divider_games).setVisibility(8);
            } else if (this.bcn.getVisibility() == 8 && this.bcs.getVisibility() == 0) {
                if (this.bcs.getChildCount() > 0) {
                    ((LinearLayout) this.bcs.getChildAt(0)).findViewById(i.f.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bcs.getVisibility() == 8 && this.bcG.Oe() != null && (Of = this.bcG.Of()) != null) {
                Of.setVisibility(8);
            }
        }
    }

    public void e(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.bcw == null) {
                this.bcw = new PopupWindow(this.mContext.getPageActivity());
                this.bcw.setContentView(this.bcx);
                this.bcw.setBackgroundDrawable(new BitmapDrawable());
                this.bcw.setOutsideTouchable(true);
                this.bcw.setFocusable(true);
                this.bcw.setWidth(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_btn_width));
                this.bcw.setHeight(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_exp_height));
                this.bcy = (TextView) this.bcx.findViewById(i.f.cur_experience);
                this.bcz = (TextView) this.bcx.findViewById(i.f.levelup_experience);
                a(this.bcy, this.bcz);
            }
            if (this.bcw.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bcw, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bcy, this.bcz);
            if (iArr[1] - this.bcw.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.bcw, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.bcw, this.LR, 0, iArr[0], iArr[1] - this.bcw.getHeight());
            this.bcw.update();
            this.mHandler.postDelayed(this.bcY, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(i.g.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(i.f.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(i.f.speed_tip);
            am.b((TextView) inflate.findViewById(i.f.experience_txt), i.c.cp_cont_b, 1);
            am.b(textView, i.c.cp_cont_b, 1);
            am.b(textView2, i.c.cp_cont_b, 1);
            am.b(textView3, i.c.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.m(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.bcJ) && !TextUtils.isEmpty(this.bcJ.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bcJ);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bG(i.c.cp_link_tip_d);
            aVar.b(i.h.cancel_text, new l(this));
            aVar.a(i.h.open_now, new m(this));
            aVar.b(this.mContext);
            aVar.sR();
        }
    }

    public void Ns() {
        PopupWindow popupWindow = new PopupWindow(this.mContext.getPageActivity());
        View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(i.g.speed_tip, (ViewGroup) null);
        this.mContext.getLayoutMode().k(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new n(this, popupWindow));
        popupWindow.setWidth(this.mContext.getResources().getDimensionPixelSize(i.d.ds300));
        popupWindow.setHeight(this.mContext.getResources().getDimensionPixelSize(i.d.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new o(this, popupWindow));
        int[] iArr = new int[2];
        this.bcA.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, this.LR, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.bcA.getWidth() / 2), iArr[1] + this.bcA.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.bcW = z;
        Bitmap cf = com.baidu.tbadk.core.util.c.cf(i.e.bg_frs_signin_bar_down);
        if (cf != null && cf.getWidth() > 0) {
            if (this.bcW) {
                this.bcj.setText(i.h.level_up);
                am.c(this.bck, com.baidu.tbadk.core.util.c.ci(this.bcN + 1));
            } else {
                this.bcj.setText(this.bcH);
                am.c(this.bck, com.baidu.tbadk.core.util.c.ci(this.bcN));
            }
            if (this.bcW) {
                b(this.mContext.getOrignalPage(), this.bcl, this.bcX, f);
            } else {
                a(this.mContext.getOrignalPage(), this.bcl, this.bcX, f);
            }
            this.bcX = f;
        }
    }
}
