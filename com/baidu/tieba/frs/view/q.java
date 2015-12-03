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
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends a implements com.baidu.tbadk.imageManager.b {
    private com.baidu.tieba.tbadkCore.o bkW = null;
    private ArrayList<TbImageView> bkE = new ArrayList<>();

    public q(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.baC = tbPageContext.getOrignalPage();
        this.mContext = tbPageContext;
        this.mHandler = new Handler();
        this.bjr = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), n.d.ds20);
        this.bjs = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), n.d.ds72);
        this.bjt = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), n.d.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Mk = LayoutInflater.from(tbPageContext.getContext()).inflate(n.g.frs_star_title, (ViewGroup) null);
        this.bjS = LayoutInflater.from(tbPageContext.getContext()).inflate(n.g.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.Mk.setVisibility(8);
        }
        this.bjC = (RelativeLayout) this.Mk.findViewById(n.f.btn_love_content);
        this.bjV = (ImageView) this.Mk.findViewById(n.f.speed_icon);
        this.bjD = (TextView) this.Mk.findViewById(n.f.level_name);
        this.bjE = (ImageView) this.Mk.findViewById(n.f.level);
        this.bjF = (ImageView) this.Mk.findViewById(n.f.love_level_top);
        this.bkb = new i(this.Mk, this.mContext.getPageActivity());
        this.bju = (FrameLayout) this.Mk.findViewById(n.f.love);
        this.bjv = (Button) this.Mk.findViewById(n.f.btn_love);
        this.Mg = (TextView) this.Mk.findViewById(n.f.tv_love);
        this.bjw = (FrameLayout) this.Mk.findViewById(n.f.sign);
        this.bjx = (Button) this.Mk.findViewById(n.f.btn_sign);
        this.bjy = (TextView) this.Mk.findViewById(n.f.tv_sign);
        this.bjz = (ProgressBar) this.Mk.findViewById(n.f.sign_progress);
        this.bjA = (FrameLayout) this.Mk.findViewById(n.f.sign_done);
        this.bjB = (TextView) this.Mk.findViewById(n.f.sign_done_text);
        this.Md = (TextView) this.Mk.findViewById(n.f.member_num_text);
        this.Me = (TextView) this.Mk.findViewById(n.f.post_num_text);
        this.Mf = (TextView) this.Mk.findViewById(n.f.title_text);
        this.bjL = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.g.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.d.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.d.ds280), 0, 0);
        this.bjL.setLayoutParams(layoutParams);
        this.bjK = (CoverFlowView) this.Mk.findViewById(n.f.frs_coverflowview);
        PY();
        this.bjK.tH();
        this.bjX = (BarImageView) this.Mk.findViewById(n.f.frs_star_bottom_photo);
        this.bjX.setGifIconSupport(false);
        this.bjY = (UserIconBox) this.Mk.findViewById(n.f.frs_badge_box);
        this.bjG = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.g.frs_header_extra, (ViewGroup) null);
        this.bjH = (LinearLayout) this.bjG.findViewById(n.f.frs_bawu_center);
        this.bjI = (LinearLayout) this.bjG.findViewById(n.f.frs_header_games);
        this.bjJ = (TextView) this.bjG.findViewById(n.f.frs_header_games_text);
        this.bbY = new bo(this.mContext, this.Mk, 1);
        this.bbY.hide();
        this.bka = new bd(this.mContext);
        this.bjN = (LinearLayout) this.bjG.findViewById(n.f.frs_header_enter_root);
        this.bkc = new w(this.mContext, this.bjG);
        this.bjQ = (U9InfoView) this.bjG.findViewById(n.f.frs_header_enter_u9);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bjX.setOnClickListener(onClickListener);
        this.Mf.setOnClickListener(onClickListener);
        this.bjC.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.c.e.gw().aj("frs_to_bar_detail") == 0) {
            this.Mk.setOnClickListener(new r(this));
        }
        this.bkb.setOnClickListener(onClickListener);
        this.bjv.setOnClickListener(onClickListener);
        this.bjx.setOnClickListener(onClickListener);
        if (this.bjH != null) {
            this.bjH.setOnClickListener(onClickListener);
        }
        if (this.bjI != null) {
            this.bjI.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().af(i == 1);
        this.mContext.getLayoutMode().k(this.Mk);
        this.mContext.getLayoutMode().k(this.bjS);
        this.mContext.getLayoutMode().k(this.bjG);
        if (this.bjK != null) {
            this.bjK.tH();
        }
        if (this.bkr) {
            gL(1);
        } else {
            gL(0);
        }
        as.c(this.bjE, com.baidu.tbadk.core.util.c.cq(this.bkj));
        this.bjX.invalidate();
        this.Mg.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bjy.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Mg.setShadowLayer(1.0f, 0.0f, 1.0f, as.getColor(n.c.frs_like_shadow));
        this.bjy.setShadowLayer(1.0f, 0.0f, 1.0f, as.getColor(n.c.frs_sign_shadow));
        if (this.bjH != null) {
            as.i(this.bjH, n.e.frs_top_item_bg);
        }
        if (this.bjI != null) {
            as.i(this.bjI, n.e.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            as.c(this.bjV, n.e.icon_speed_orange);
        } else {
            as.c(this.bjV, n.e.icon_speed_gray);
        }
        if (this.bkc != null) {
            this.bkc.changeSkinType(i);
        }
        if (this.bbY != null) {
            this.bbY.changeSkinType(i);
        }
        if (this.bjQ != null) {
            this.bjQ.d(this.mContext, i);
        }
        if (this.bjY != null) {
            this.bjY.cX(i);
        }
        Iterator<TbImageView> it = this.bkE.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bkk = forumData.getPost_num();
            this.bke = forumData.getTag_color();
            this.bkl = forumData.getSignData().getCountSignNum();
            this.bkm = forumData.getCurScore();
            this.bkf = forumData.getAccelerateContent();
            this.biV = forumData.getLevelupScore();
            this.bkg = pVar;
            this.bkW = pVar.aBC();
            this.bjZ = forumData.getBadgeData();
            this.bkh = new z();
            this.bjO = forumData.getTopCode();
            this.bjP = forumData.getNewsInfo();
            if (this.bkW != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.bkW.aBX());
                this.bkh.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.bkW.aBY());
                this.bkh.getMedias().add(mediaData2);
            }
            this.Mk.setVisibility(0);
            this.bkb.setForumName(forumData.getName());
            PZ();
        }
    }

    private void PZ() {
        if (this.bkg != null) {
            if (this.bkg.aBD() == null || this.bkg.aBD().rJ() == null || this.bkg.aBD().rJ().size() <= 0) {
                this.bjL.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.i> arrayList = new ArrayList<>();
                String str = "";
                if (this.bkg.ajy() != null && this.bkg.ajy().getFrsBannerData() != null) {
                    str = this.bkg.ajy().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i(this.bkW.aBX(), str, null);
                iVar.aj(true);
                arrayList.add(iVar);
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.h(arrayList);
                a(hVar);
            } else {
                this.bjL.setVisibility(0);
                a(this.bkg.aBD());
            }
        }
        if (this.Md != null) {
            this.Md.setText(ax.y(this.mMemberNum));
        }
        if (this.Me != null) {
            this.Me.setText(ax.y(this.bkk));
        }
        if (this.Mf != null) {
            if (this.bjZ != null && this.bjZ.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.Mf.setText(String.valueOf(this.mForumName) + this.mContext.getString(n.i.forum));
        }
        if (this.bjH != null) {
            if (this.bkg != null && this.bkg.getUserData() != null && this.bkg.getUserData().isBawu()) {
                this.bjH.setVisibility(0);
            } else {
                this.bjH.setVisibility(8);
            }
        }
        if (this.bjI != null && this.bjJ != null) {
            if (this.bkg != null && this.bkg.aBJ()) {
                int di = com.baidu.tbadk.core.util.o.di(this.bkg.aBN());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (di == 1 && !z) {
                    this.bjI.setVisibility(8);
                } else {
                    this.bjI.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bkg.getGameName()) && !TextUtils.isEmpty(this.bkg.getGameName().trim())) {
                        this.bjJ.setText(UtilHelper.getFixedText(this.bkg.getGameName(), 10));
                        String mC = com.baidu.tieba.tbadkCore.util.n.mC(this.bkg.aBN());
                        if (!StringUtils.isNull(mC)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", mC, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bjJ.setText(this.mContext.getResources().getString(n.i.frsgame_title));
                    }
                }
            } else {
                this.bjI.setVisibility(8);
            }
        }
        if (this.bkg != null && this.bkg.aBK() != null && this.bkg.aBK().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> aBK = this.bkg.aBK();
            ak(aBK);
            int size = aBK.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bjN.setVisibility(0);
                this.bjN.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar2 = aBK.get(i2);
                    if (hVar2 != null && !hl(hVar2.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(n.f.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.d.ds6));
                        tbImageView.d(hVar2.getIcon(), 21, false);
                        this.bkE.add(tbImageView);
                        ((TextView) linearLayout.findViewById(n.f.frs_header_enters_text)).setText(UtilHelper.getFixedText(hVar2.getTitle(), 10));
                        applyNightMode(linearLayout);
                        linearLayout.setTag(hVar2.getUrl());
                        linearLayout.setOnClickListener(this.bkv);
                        this.bjN.addView(linearLayout);
                    }
                }
            } else {
                this.bjN.setVisibility(8);
            }
        } else {
            this.bjN.setVisibility(8);
        }
        this.bjX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bjX.d(this.bkW.aBY(), 16, false);
        if (this.bjY != null && this.bjZ != null && this.bjZ.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bjZ.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bjZ.get(i3).rF());
                iconData.setIcon(this.bjZ.get(i3).rE());
                this.bki = this.bjZ.get(i3).rG();
                linkedList.add(iconData);
            }
            this.bjY.setOnClickListener(this.bkw);
            this.bjY.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(n.d.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(n.d.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(n.d.frs_starheader_badge_margin));
        }
        if (this.bkg != null) {
            this.bkc.a(this.bkg.aBC(), this.bkg.ajy());
        } else {
            this.bkc.a(null, null);
        }
        if (this.bkg != null) {
            this.bbY.b(this.bkg);
        }
        this.bjQ.a(this.bjO, this.bjP);
        Qa();
    }

    private void Qa() {
        View Qd;
        if (this.bjQ.getTopCodeView() != null && this.bjQ.getNewsInfoView() != null && this.bjQ.getTopCodeViewDivider() != null && this.bjQ.getTopCodeView().getVisibility() != 0) {
            if (this.bjQ.getTopCodeView().getVisibility() == 8 && this.bjQ.getNewsInfoView().getVisibility() == 0) {
                this.bjQ.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bjQ.getNewsInfoView().getVisibility() == 8 && this.bjI.getVisibility() == 0) {
                this.bjG.findViewById(n.f.frs_header_divider_games).setVisibility(8);
            } else if (this.bjI.getVisibility() == 8 && this.bjN.getVisibility() == 0) {
                if (this.bjN.getChildCount() > 0) {
                    ((LinearLayout) this.bjN.getChildAt(0)).findViewById(n.f.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bjN.getVisibility() == 8 && this.bkc.Qc() != null && (Qd = this.bkc.Qd()) != null) {
                Qd.setVisibility(8);
            }
        }
    }

    public void Pq() {
        View contentView;
        if (this.bjW == null) {
            this.bjW = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(n.g.speed_tip, (ViewGroup) null);
            this.bjW.setContentView(contentView);
            contentView.setOnClickListener(new s(this));
            this.bjW.setWidth(this.mContext.getResources().getDimensionPixelSize(n.d.ds300));
            this.bjW.setHeight(this.mContext.getResources().getDimensionPixelSize(n.d.ds88));
            this.bjW.setBackgroundDrawable(new BitmapDrawable());
            this.bjW.setOutsideTouchable(true);
            this.bjW.setTouchInterceptor(new t(this));
        } else {
            contentView = this.bjW.getContentView();
        }
        this.mContext.getLayoutMode().k(contentView);
        int[] iArr = new int[2];
        this.bjV.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bjW, this.Mk, 0, (iArr[0] - (this.bjW.getWidth() / 2)) + (this.bjV.getWidth() / 2), iArr[1] + this.bjV.getWidth());
        this.bjW.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.bks = z;
        Bitmap cn = com.baidu.tbadk.core.util.c.cn(n.e.bg_frs_signin_bar_down);
        if (cn != null && cn.getWidth() > 0) {
            if (this.bks) {
                this.bjD.setText(n.i.star_bar_level_up);
                as.c(this.bjE, com.baidu.tbadk.core.util.c.cq(this.bkj + 1));
            } else {
                this.bjD.setText(this.bkd);
                as.c(this.bjE, com.baidu.tbadk.core.util.c.cq(this.bkj));
            }
            if (this.bks) {
                b(this.mContext.getOrignalPage(), this.bjF, this.bkt, f);
            } else {
                a(this.mContext.getOrignalPage(), this.bjF, this.bkt, f);
            }
            this.bkt = f;
        }
    }

    public void e(View view, boolean z) {
        TiebaStatic.eventStat(this.baC.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bku);
            if (this.bjR == null) {
                this.bjR = new PopupWindow(this.mContext.getPageActivity());
                this.bjR.setContentView(this.bjS);
                this.bjR.setBackgroundDrawable(new BitmapDrawable());
                this.bjR.setOutsideTouchable(true);
                this.bjR.setFocusable(true);
                this.bjR.setWidth(this.mContext.getResources().getDimensionPixelSize(n.d.frs_header_btn_width));
                this.bjR.setHeight(this.mContext.getResources().getDimensionPixelSize(n.d.frs_header_exp_height));
                this.bjT = (TextView) this.bjS.findViewById(n.f.cur_experience);
                this.bjU = (TextView) this.bjS.findViewById(n.f.levelup_experience);
                a(this.bjT, this.bjU);
            }
            if (this.bjR.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bjR, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bjT, this.bjU);
            int height = iArr[1] - this.bjR.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.h.j.a(this.bjR, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bjR, this.Mk, 0, iArr[0], height);
            this.bjR.update();
            this.mHandler.postDelayed(this.bku, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.f.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(n.f.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(n.f.speed_tip);
            as.b((TextView) inflate.findViewById(n.f.experience), n.c.cp_cont_b, 1);
            as.b(textView, n.c.cp_cont_b, 1);
            as.b(textView2, n.c.cp_cont_b, 1);
            as.b(textView3, n.c.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bkf) && !TextUtils.isEmpty(this.bkf.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bkf);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.m(inflate);
            aVar.bO(n.c.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(n.i.cancel_text, new u(this));
            aVar.a(n.i.open_now, new v(this));
            aVar.b(this.mContext).tv();
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.Mk.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
