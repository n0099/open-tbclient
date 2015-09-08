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
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends a implements com.baidu.tbadk.imageManager.b {
    private com.baidu.tieba.tbadkCore.n bds = null;
    private ArrayList<TbImageView> bdo = new ArrayList<>();

    public p(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.aVM = tbPageContext.getOrignalPage();
        this.mContext = tbPageContext;
        this.mHandler = new Handler();
        this.bcd = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds20);
        this.bce = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds72);
        this.bcf = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.LR = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_star_title, (ViewGroup) null);
        this.bcD = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.LR.setVisibility(8);
        }
        this.bco = (RelativeLayout) this.LR.findViewById(i.f.btn_love_content);
        this.bcG = (ImageView) this.LR.findViewById(i.f.speed_icon);
        this.bcp = (TextView) this.LR.findViewById(i.f.level_name);
        this.bcq = (ImageView) this.LR.findViewById(i.f.level);
        this.bcr = (ImageView) this.LR.findViewById(i.f.love_level_top);
        this.bcL = new i(this.LR, this.mContext.getPageActivity());
        this.bcg = (FrameLayout) this.LR.findViewById(i.f.love);
        this.bch = (Button) this.LR.findViewById(i.f.btn_love);
        this.LN = (TextView) this.LR.findViewById(i.f.tv_love);
        this.bci = (FrameLayout) this.LR.findViewById(i.f.sign);
        this.bcj = (Button) this.LR.findViewById(i.f.btn_sign);
        this.bck = (TextView) this.LR.findViewById(i.f.tv_sign);
        this.bcl = (ProgressBar) this.LR.findViewById(i.f.sign_progress);
        this.bcm = (FrameLayout) this.LR.findViewById(i.f.sign_done);
        this.bcn = (TextView) this.LR.findViewById(i.f.sign_done_text);
        this.LK = (TextView) this.LR.findViewById(i.f.member_num_text);
        this.LL = (TextView) this.LR.findViewById(i.f.post_num_text);
        this.LM = (TextView) this.LR.findViewById(i.f.title_text);
        this.bcw = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds280), 0, 0);
        this.bcw.setLayoutParams(layoutParams);
        this.bcv = (CoverFlowView) this.LR.findViewById(i.f.frs_coverflowview);
        Oa();
        this.bcv.tf();
        this.bcH = (BarImageView) this.LR.findViewById(i.f.frs_star_bottom_photo);
        this.bcH.setGifIconSupport(false);
        this.bcI = (UserIconBox) this.LR.findViewById(i.f.frs_badge_box);
        this.bcs = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.frs_header_extra, (ViewGroup) null);
        this.bct = (LinearLayout) this.bcs.findViewById(i.f.frs_header_games);
        this.bcu = (TextView) this.bcs.findViewById(i.f.frs_header_games_text);
        this.bcK = new aw(this.mContext);
        this.bcy = (LinearLayout) this.bcs.findViewById(i.f.frs_header_enter_root);
        this.bcM = new v(this.mContext, this.bcs);
        this.bcB = (U9InfoView) this.bcs.findViewById(i.f.frs_header_enter_u9);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bcH.setOnClickListener(onClickListener);
        this.LM.setOnClickListener(onClickListener);
        this.bco.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.e.gv().ah("frs_to_bar_detail") == 0) {
            this.LR.setOnClickListener(new q(this));
        }
        this.bcL.setOnClickListener(onClickListener);
        this.bch.setOnClickListener(onClickListener);
        this.bcj.setOnClickListener(onClickListener);
        if (this.bct != null) {
            this.bct.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ad(i == 1);
        this.mContext.getLayoutMode().k(this.LR);
        this.mContext.getLayoutMode().k(this.bcD);
        this.mContext.getLayoutMode().k(this.bcs);
        if (this.bcv != null) {
            this.bcv.tf();
        }
        if (this.bdb) {
            fX(1);
        } else {
            fX(0);
        }
        al.c(this.bcq, com.baidu.tbadk.core.util.c.cg(this.bcT));
        this.bcH.invalidate();
        this.LN.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bck.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LN.setShadowLayer(1.0f, 0.0f, 1.0f, al.getColor(i.c.frs_like_shadow));
        this.bck.setShadowLayer(1.0f, 0.0f, 1.0f, al.getColor(i.c.frs_sign_shadow));
        if (this.bct != null) {
            al.h(this.bct, i.e.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.bcG, i.e.icon_speed_orange);
        } else {
            al.c(this.bcG, i.e.icon_speed_gray);
        }
        if (this.bcM != null) {
            this.bcM.changeSkinType(i);
        }
        if (this.bcB != null) {
            this.bcB.d(this.mContext, i);
        }
        if (this.bcI != null) {
            this.bcI.cO(i);
        }
        Iterator<TbImageView> it = this.bdo.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bcU = forumData.getPost_num();
            this.bcO = forumData.getTag_color();
            this.bcV = forumData.getSignData().getCountSignNum();
            this.bcW = forumData.getCurScore();
            this.bcP = forumData.getAccelerateContent();
            this.bbH = forumData.getLevelupScore();
            this.bcQ = oVar;
            this.bds = oVar.asY();
            this.bcJ = forumData.getBadgeData();
            this.bcR = new x();
            this.bcz = forumData.getTopCode();
            this.bcA = forumData.getNewsInfo();
            if (this.bds != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.bds.atp());
                this.bcR.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.bds.atq());
                this.bcR.getMedias().add(mediaData2);
            }
            this.LR.setVisibility(0);
            this.bcL.setForumName(forumData.getName());
            Ob();
        }
    }

    private void Ob() {
        if (this.bcQ != null) {
            if (this.bcQ.asZ() == null || this.bcQ.asZ().rC() == null || this.bcQ.asZ().rC().size() <= 0) {
                this.bcw.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.i> arrayList = new ArrayList<>();
                String str = "";
                if (this.bcQ.acP() != null && this.bcQ.acP().getFrsBannerData() != null) {
                    str = this.bcQ.acP().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i(this.bds.atp(), str, null);
                iVar.ah(true);
                arrayList.add(iVar);
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.h(arrayList);
                a(hVar);
            } else {
                this.bcw.setVisibility(0);
                a(this.bcQ.asZ());
            }
        }
        if (this.LK != null) {
            this.LK.setText(String.valueOf(this.mMemberNum));
        }
        if (this.LL != null) {
            this.LL.setText(String.valueOf(this.bcU));
        }
        if (this.LM != null) {
            if (this.bcJ != null && this.bcJ.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.LM.setText(String.valueOf(this.mForumName) + this.mContext.getString(i.h.forum));
        }
        if (this.bct != null && this.bcu != null) {
            if (this.bcQ != null && this.bcQ.atf()) {
                int cW = com.baidu.tbadk.core.util.o.cW(this.bcQ.atj());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (cW == 1 && !z) {
                    this.bct.setVisibility(8);
                } else {
                    this.bct.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bcQ.getGameName()) && !TextUtils.isEmpty(this.bcQ.getGameName().trim())) {
                        this.bcu.setText(UtilHelper.getFixedText(this.bcQ.getGameName(), 10));
                        String lh = com.baidu.tieba.tbadkCore.util.l.lh(this.bcQ.atj());
                        if (!StringUtils.isNull(lh)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", lh, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bcu.setText("");
                    }
                }
            } else {
                this.bct.setVisibility(8);
            }
        }
        if (this.bcQ != null && this.bcQ.atg() != null && this.bcQ.atg().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> atg = this.bcQ.atg();
            Z(atg);
            int size = atg.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bcy.setVisibility(0);
                this.bcy.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar2 = atg.get(i2);
                    if (hVar2 != null && !gN(hVar2.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds6));
                        tbImageView.d(hVar2.getIcon(), 21, false);
                        this.bdo.add(tbImageView);
                        ((TextView) linearLayout.findViewById(i.f.frs_header_enters_text)).setText(UtilHelper.getFixedText(hVar2.getTitle(), 10));
                        applyNightMode(linearLayout);
                        linearLayout.setTag(hVar2.getUrl());
                        linearLayout.setOnClickListener(this.bdf);
                        this.bcy.addView(linearLayout);
                    }
                }
            } else {
                this.bcy.setVisibility(8);
            }
        } else {
            this.bcy.setVisibility(8);
        }
        this.bcH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bcH.d(this.bds.atq(), 16, false);
        if (this.bcI != null && this.bcJ != null && this.bcJ.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bcJ.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bcJ.get(i3).ry());
                iconData.setIcon(this.bcJ.get(i3).rx());
                this.bcS = this.bcJ.get(i3).rz();
                linkedList.add(iconData);
            }
            this.bcI.setOnClickListener(this.bdg);
            this.bcI.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_margin));
        }
        if (this.bcQ != null) {
            this.bcM.a(this.bcQ.asY(), this.bcQ.acP());
        } else {
            this.bcM.a(null, null);
        }
        this.bcB.a(this.bcz, this.bcA);
        Oc();
    }

    private void Oc() {
        View Oe;
        if (this.bcB.getTopCodeView() != null && this.bcB.getNewsInfoView() != null && this.bcB.getTopCodeViewDivider() != null && this.bcB.getTopCodeView().getVisibility() != 0) {
            if (this.bcB.getTopCodeView().getVisibility() == 8 && this.bcB.getNewsInfoView().getVisibility() == 0) {
                this.bcB.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bcB.getNewsInfoView().getVisibility() == 8 && this.bct.getVisibility() == 0) {
                this.bcs.findViewById(i.f.frs_header_divider_games).setVisibility(8);
            } else if (this.bct.getVisibility() == 8 && this.bcy.getVisibility() == 0) {
                if (this.bcy.getChildCount() > 0) {
                    ((LinearLayout) this.bcy.getChildAt(0)).findViewById(i.f.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bcy.getVisibility() == 8 && this.bcM.Od() != null && (Oe = this.bcM.Oe()) != null) {
                Oe.setVisibility(8);
            }
        }
    }

    public void Ns() {
        PopupWindow popupWindow = new PopupWindow(this.mContext.getPageActivity());
        View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(i.g.speed_tip, (ViewGroup) null);
        this.mContext.getLayoutMode().k(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new r(this, popupWindow));
        popupWindow.setWidth(this.mContext.getResources().getDimensionPixelSize(i.d.ds300));
        popupWindow.setHeight(this.mContext.getResources().getDimensionPixelSize(i.d.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new s(this, popupWindow));
        int[] iArr = new int[2];
        this.bcG.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, this.LR, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.bcG.getWidth() / 2), iArr[1] + this.bcG.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.bdc = z;
        Bitmap cd = com.baidu.tbadk.core.util.c.cd(i.e.bg_frs_signin_bar_down);
        if (cd != null && cd.getWidth() > 0) {
            if (this.bdc) {
                this.bcp.setText(i.h.star_bar_level_up);
                al.c(this.bcq, com.baidu.tbadk.core.util.c.cg(this.bcT + 1));
            } else {
                this.bcp.setText(this.bcN);
                al.c(this.bcq, com.baidu.tbadk.core.util.c.cg(this.bcT));
            }
            if (this.bdc) {
                b(this.mContext.getOrignalPage(), this.bcr, this.bdd, f);
            } else {
                a(this.mContext.getOrignalPage(), this.bcr, this.bdd, f);
            }
            this.bdd = f;
        }
    }

    public void e(View view, boolean z) {
        TiebaStatic.eventStat(this.aVM.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.bcC == null) {
                this.bcC = new PopupWindow(this.mContext.getPageActivity());
                this.bcC.setContentView(this.bcD);
                this.bcC.setBackgroundDrawable(new BitmapDrawable());
                this.bcC.setOutsideTouchable(true);
                this.bcC.setFocusable(true);
                this.bcC.setWidth(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_btn_width));
                this.bcC.setHeight(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_exp_height));
                this.bcE = (TextView) this.bcD.findViewById(i.f.cur_experience);
                this.bcF = (TextView) this.bcD.findViewById(i.f.levelup_experience);
                a(this.bcE, this.bcF);
            }
            if (this.bcC.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bcC, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bcE, this.bcF);
            int height = iArr[1] - this.bcC.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.j.a(this.bcC, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.bcC, this.LR, 0, iArr[0], height);
            this.bcC.update();
            this.mHandler.postDelayed(this.bde, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(i.f.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(i.f.speed_tip);
            al.b((TextView) inflate.findViewById(i.f.experience), i.c.cp_cont_b, 1);
            al.b(textView, i.c.cp_cont_b, 1);
            al.b(textView2, i.c.cp_cont_b, 1);
            al.b(textView3, i.c.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bcP) && !TextUtils.isEmpty(this.bcP.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bcP);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.m(inflate);
            aVar.bG(i.c.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(i.h.cancel_text, new t(this));
            aVar.a(i.h.open_now, new u(this));
            aVar.b(this.mContext).sU();
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
