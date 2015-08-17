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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a implements com.baidu.tbadk.imageManager.b {
    private com.baidu.tieba.tbadkCore.m bcX = null;

    public p(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.aVx = tbPageContext.getOrignalPage();
        this.LS = tbPageContext;
        this.mHandler = new Handler();
        this.bbJ = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds20);
        this.bbK = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds72);
        this.bbL = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.LR = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_star_title, (ViewGroup) null);
        this.bcj = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.LR.setVisibility(8);
        }
        this.bbU = (RelativeLayout) this.LR.findViewById(i.f.btn_love_content);
        this.bcm = (ImageView) this.LR.findViewById(i.f.speed_icon);
        this.bbV = (TextView) this.LR.findViewById(i.f.level_name);
        this.bbW = (ImageView) this.LR.findViewById(i.f.level);
        this.bbX = (ImageView) this.LR.findViewById(i.f.love_level_top);
        this.bcr = new i(this.LR, this.LS.getPageActivity());
        this.bbM = (FrameLayout) this.LR.findViewById(i.f.love);
        this.bbN = (Button) this.LR.findViewById(i.f.btn_love);
        this.LN = (TextView) this.LR.findViewById(i.f.tv_love);
        this.bbO = (FrameLayout) this.LR.findViewById(i.f.sign);
        this.bbP = (Button) this.LR.findViewById(i.f.btn_sign);
        this.bbQ = (TextView) this.LR.findViewById(i.f.tv_sign);
        this.bbR = (ProgressBar) this.LR.findViewById(i.f.sign_progress);
        this.bbS = (FrameLayout) this.LR.findViewById(i.f.sign_done);
        this.bbT = (TextView) this.LR.findViewById(i.f.sign_done_text);
        this.LK = (TextView) this.LR.findViewById(i.f.member_num_text);
        this.LL = (TextView) this.LR.findViewById(i.f.post_num_text);
        this.LM = (TextView) this.LR.findViewById(i.f.title_text);
        this.bcc = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.LS.getPageActivity(), i.d.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.d(this.LS.getPageActivity(), i.d.ds280), 0, 0);
        this.bcc.setLayoutParams(layoutParams);
        this.bcb = (CoverFlowView) this.LR.findViewById(i.f.frs_coverflowview);
        NZ();
        this.bcb.ta();
        this.bcn = (BarImageView) this.LR.findViewById(i.f.frs_star_bottom_photo);
        this.bcn.setGifIconSupport(false);
        this.bco = (UserIconBox) this.LR.findViewById(i.f.frs_badge_box);
        this.bbY = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.frs_header_extra, (ViewGroup) null);
        this.bbZ = (LinearLayout) this.bbY.findViewById(i.f.frs_header_games);
        this.bca = (TextView) this.bbY.findViewById(i.f.frs_header_games_text);
        this.bcq = new av(this.LS);
        this.bce = (LinearLayout) this.bbY.findViewById(i.f.frs_header_enter_root);
        this.bcs = new v(this.LS, this.bbY);
        this.bch = (U9InfoView) this.bbY.findViewById(i.f.frs_header_enter_u9);
    }

    public void n(View.OnClickListener onClickListener) {
        this.bcn.setOnClickListener(onClickListener);
        this.LM.setOnClickListener(onClickListener);
        this.bbU.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.e.gy().ah("frs_to_bar_detail") == 0) {
            this.LR.setOnClickListener(new q(this));
        }
        this.bcr.setOnClickListener(onClickListener);
        this.bbN.setOnClickListener(onClickListener);
        this.bbP.setOnClickListener(onClickListener);
        if (this.bbZ != null) {
            this.bbZ.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.LS.getLayoutMode().ad(i == 1);
        this.LS.getLayoutMode().k(this.LR);
        this.LS.getLayoutMode().k(this.bcj);
        this.LS.getLayoutMode().k(this.bbY);
        if (this.bcb != null) {
            this.bcb.ta();
        }
        if (this.bcH) {
            fO(1);
        } else {
            fO(0);
        }
        al.c(this.bbW, com.baidu.tbadk.core.util.c.cc(this.bcz));
        this.bcn.invalidate();
        this.LN.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bbQ.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LN.setShadowLayer(1.0f, 0.0f, 1.0f, al.getColor(i.c.frs_like_shadow));
        this.bbQ.setShadowLayer(1.0f, 0.0f, 1.0f, al.getColor(i.c.frs_sign_shadow));
        if (this.bbZ != null) {
            al.i(this.bbZ, i.e.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.bcm, i.e.icon_speed_orange);
        } else {
            al.c(this.bcm, i.e.icon_speed_gray);
        }
        if (this.bcs != null) {
            this.bcs.changeSkinType(i);
        }
        if (this.bch != null) {
            this.bch.d(this.LS, i);
        }
        if (this.bco != null) {
            this.bco.cI(i);
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bcA = forumData.getPost_num();
            this.bcu = forumData.getTag_color();
            this.bcB = forumData.getSignData().getCountSignNum();
            this.bcC = forumData.getCurScore();
            this.bcv = forumData.getAccelerateContent();
            this.bbn = forumData.getLevelupScore();
            this.bcw = nVar;
            this.bcX = nVar.aoR();
            this.bcp = forumData.getBadgeData();
            this.bcx = new com.baidu.tbadk.core.data.v();
            this.bcf = forumData.getTopCode();
            this.bcg = forumData.getNewsInfo();
            if (this.bcX != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.bcX.ape());
                this.bcx.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.bcX.apf());
                this.bcx.getMedias().add(mediaData2);
            }
            this.LR.setVisibility(0);
            this.bcr.setForumName(forumData.getName());
            Oa();
        }
    }

    private void Oa() {
        if (this.bcw != null) {
            if (this.bcw.aoS() == null || this.bcw.aoS().rD() == null || this.bcw.aoS().rD().size() <= 0) {
                this.bcc.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.i> arrayList = new ArrayList<>();
                String str = "";
                if (this.bcw.acG() != null && this.bcw.acG().getFrsBannerData() != null) {
                    str = this.bcw.acG().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i(this.bcX.ape(), str, null);
                iVar.ah(true);
                arrayList.add(iVar);
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.h(arrayList);
                a(hVar);
            } else {
                this.bcc.setVisibility(0);
                a(this.bcw.aoS());
            }
        }
        if (this.LK != null) {
            this.LK.setText(String.valueOf(this.mMemberNum));
        }
        if (this.LL != null) {
            this.LL.setText(String.valueOf(this.bcA));
        }
        if (this.LM != null) {
            if (this.bcp != null && this.bcp.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.LM.setText(String.valueOf(this.mForumName) + this.LS.getString(i.C0057i.forum));
        }
        if (this.bbZ != null && this.bca != null) {
            if (this.bcw != null && this.bcw.aoY()) {
                int cQ = com.baidu.tbadk.core.util.o.cQ(this.bcw.apb());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (cQ == 1 && !z) {
                    this.bbZ.setVisibility(8);
                } else {
                    this.bbZ.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bcw.getGameName()) && !TextUtils.isEmpty(this.bcw.getGameName().trim())) {
                        this.bca.setText(UtilHelper.getFixedText(this.bcw.getGameName(), 10));
                        String kC = com.baidu.tieba.tbadkCore.util.l.kC(this.bcw.apb());
                        if (!StringUtils.isNull(kC)) {
                            TiebaStatic.eventStat(this.LS.getPageActivity(), "game_show", "show", 1, "dev_id", kC, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bca.setText("");
                    }
                }
            } else {
                this.bbZ.setVisibility(8);
            }
        }
        if (this.bcw != null && this.bcw.aoZ() != null && this.bcw.aoZ().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> aoZ = this.bcw.aoZ();
            Z(aoZ);
            int size = aoZ.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bce.setVisibility(0);
                this.bce.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = aoZ.get(i2);
                    if (gVar != null && !gG(gVar.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.LS.getPageActivity()).inflate(i.g.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.d(this.LS.getPageActivity(), i.d.ds6));
                        tbImageView.d(gVar.getIcon(), 21, false);
                        ((TextView) linearLayout.findViewById(i.f.frs_header_enters_text)).setText(UtilHelper.getFixedText(gVar.getTitle(), 10));
                        applyNightMode(linearLayout);
                        linearLayout.setTag(gVar.getUrl());
                        linearLayout.setOnClickListener(this.bcL);
                        this.bce.addView(linearLayout);
                    }
                }
            } else {
                this.bce.setVisibility(8);
            }
        } else {
            this.bce.setVisibility(8);
        }
        this.bcn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcn.d(this.bcX.apf(), 16, false);
        if (this.bco != null && this.bcp != null && this.bcp.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bcp.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bcp.get(i3).rz());
                iconData.setIcon(this.bcp.get(i3).ry());
                this.bcy = this.bcp.get(i3).rA();
                linkedList.add(iconData);
            }
            this.bco.setOnClickListener(this.bcM);
            this.bco.a(linkedList, 2, this.LS.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_width), this.LS.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_height), this.LS.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_margin));
        }
        if (this.bcw != null) {
            this.bcs.a(this.bcw.aoR(), this.bcw.acG());
        } else {
            this.bcs.a(null, null);
        }
        this.bch.a(this.bcf, this.bcg);
        Ob();
    }

    private void Ob() {
        View Od;
        if (this.bch.getTopCodeView() != null && this.bch.getNewsInfoView() != null && this.bch.getTopCodeViewDivider() != null && this.bch.getTopCodeView().getVisibility() != 0) {
            if (this.bch.getTopCodeView().getVisibility() == 8 && this.bch.getNewsInfoView().getVisibility() == 0) {
                this.bch.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bch.getNewsInfoView().getVisibility() == 8 && this.bbZ.getVisibility() == 0) {
                this.bbY.findViewById(i.f.frs_header_divider_games).setVisibility(8);
            } else if (this.bbZ.getVisibility() == 8 && this.bce.getVisibility() == 0) {
                if (this.bce.getChildCount() > 0) {
                    ((LinearLayout) this.bce.getChildAt(0)).findViewById(i.f.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bce.getVisibility() == 8 && this.bcs.Oc() != null && (Od = this.bcs.Od()) != null) {
                Od.setVisibility(8);
            }
        }
    }

    public void Nr() {
        PopupWindow popupWindow = new PopupWindow(this.LS.getPageActivity());
        View inflate = LayoutInflater.from(this.LS.getContext()).inflate(i.g.speed_tip, (ViewGroup) null);
        this.LS.getLayoutMode().k(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new r(this, popupWindow));
        popupWindow.setWidth(this.LS.getResources().getDimensionPixelSize(i.d.ds300));
        popupWindow.setHeight(this.LS.getResources().getDimensionPixelSize(i.d.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new s(this, popupWindow));
        int[] iArr = new int[2];
        this.bcm.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, this.LR, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.bcm.getWidth() / 2), iArr[1] + this.bcm.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.bcI = z;
        Bitmap bZ = com.baidu.tbadk.core.util.c.bZ(i.e.bg_frs_signin_bar_down);
        if (bZ != null && bZ.getWidth() > 0) {
            if (this.bcI) {
                this.bbV.setText(i.C0057i.star_bar_level_up);
                al.c(this.bbW, com.baidu.tbadk.core.util.c.cc(this.bcz + 1));
            } else {
                this.bbV.setText(this.bct);
                al.c(this.bbW, com.baidu.tbadk.core.util.c.cc(this.bcz));
            }
            if (this.bcI) {
                b(this.LS.getOrignalPage(), this.bbX, this.bcJ, f);
            } else {
                a(this.LS.getOrignalPage(), this.bbX, this.bcJ, f);
            }
            this.bcJ = f;
        }
    }

    public void e(View view, boolean z) {
        TiebaStatic.eventStat(this.aVx.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.bci == null) {
                this.bci = new PopupWindow(this.LS.getPageActivity());
                this.bci.setContentView(this.bcj);
                this.bci.setBackgroundDrawable(new BitmapDrawable());
                this.bci.setOutsideTouchable(true);
                this.bci.setFocusable(true);
                this.bci.setWidth(this.LS.getResources().getDimensionPixelSize(i.d.frs_header_btn_width));
                this.bci.setHeight(this.LS.getResources().getDimensionPixelSize(i.d.frs_header_exp_height));
                this.bck = (TextView) this.bcj.findViewById(i.f.cur_experience);
                this.bcl = (TextView) this.bcj.findViewById(i.f.levelup_experience);
                a(this.bck, this.bcl);
            }
            if (this.bci.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bci, this.LS.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bck, this.bcl);
            int height = iArr[1] - this.bci.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.j.a(this.bci, this.LS.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.bci, this.LR, 0, iArr[0], height);
            this.bci.update();
            this.mHandler.postDelayed(this.bcK, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.LS.getPageActivity()).inflate(i.g.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(i.f.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(i.f.speed_tip);
            al.b((TextView) inflate.findViewById(i.f.experience), i.c.cp_cont_b, 1);
            al.b(textView, i.c.cp_cont_b, 1);
            al.b(textView2, i.c.cp_cont_b, 1);
            al.b(textView3, i.c.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bcv) && !TextUtils.isEmpty(this.bcv.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bcv);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.LS.getPageActivity());
            aVar.m(inflate);
            aVar.bD(i.c.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(i.C0057i.cancel_text, new t(this));
            aVar.a(i.C0057i.open_now, new u(this));
            aVar.b(this.LS).sP();
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.LR.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
