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
    private com.baidu.tieba.tbadkCore.n ber = null;
    private ArrayList<TbImageView> bdY = new ArrayList<>();

    public q(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.aVn = tbPageContext.getOrignalPage();
        this.mContext = tbPageContext;
        this.mHandler = new Handler();
        this.bcN = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds20);
        this.bcO = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds72);
        this.bcP = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), i.d.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.LT = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_star_title, (ViewGroup) null);
        this.bdn = LayoutInflater.from(tbPageContext.getContext()).inflate(i.g.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.LT.setVisibility(8);
        }
        this.bcY = (RelativeLayout) this.LT.findViewById(i.f.btn_love_content);
        this.bdq = (ImageView) this.LT.findViewById(i.f.speed_icon);
        this.bcZ = (TextView) this.LT.findViewById(i.f.level_name);
        this.bda = (ImageView) this.LT.findViewById(i.f.level);
        this.bdb = (ImageView) this.LT.findViewById(i.f.love_level_top);
        this.bdv = new i(this.LT, this.mContext.getPageActivity());
        this.bcQ = (FrameLayout) this.LT.findViewById(i.f.love);
        this.bcR = (Button) this.LT.findViewById(i.f.btn_love);
        this.LP = (TextView) this.LT.findViewById(i.f.tv_love);
        this.bcS = (FrameLayout) this.LT.findViewById(i.f.sign);
        this.bcT = (Button) this.LT.findViewById(i.f.btn_sign);
        this.bcU = (TextView) this.LT.findViewById(i.f.tv_sign);
        this.bcV = (ProgressBar) this.LT.findViewById(i.f.sign_progress);
        this.bcW = (FrameLayout) this.LT.findViewById(i.f.sign_done);
        this.bcX = (TextView) this.LT.findViewById(i.f.sign_done_text);
        this.LM = (TextView) this.LT.findViewById(i.f.member_num_text);
        this.LN = (TextView) this.LT.findViewById(i.f.post_num_text);
        this.LO = (TextView) this.LT.findViewById(i.f.title_text);
        this.bdg = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds280), 0, 0);
        this.bdg.setLayoutParams(layoutParams);
        this.bdf = (CoverFlowView) this.LT.findViewById(i.f.frs_coverflowview);
        Os();
        this.bdf.tc();
        this.bdr = (BarImageView) this.LT.findViewById(i.f.frs_star_bottom_photo);
        this.bdr.setGifIconSupport(false);
        this.bds = (UserIconBox) this.LT.findViewById(i.f.frs_badge_box);
        this.bdc = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(i.g.frs_header_extra, (ViewGroup) null);
        this.bdd = (LinearLayout) this.bdc.findViewById(i.f.frs_header_games);
        this.bde = (TextView) this.bdc.findViewById(i.f.frs_header_games_text);
        this.bdu = new be(this.mContext);
        this.bdi = (LinearLayout) this.bdc.findViewById(i.f.frs_header_enter_root);
        this.bdw = new w(this.mContext, this.bdc);
        this.bdl = (U9InfoView) this.bdc.findViewById(i.f.frs_header_enter_u9);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bdr.setOnClickListener(onClickListener);
        this.LO.setOnClickListener(onClickListener);
        this.bcY.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.e.gv().af("frs_to_bar_detail") == 0) {
            this.LT.setOnClickListener(new r(this));
        }
        this.bdv.setOnClickListener(onClickListener);
        this.bcR.setOnClickListener(onClickListener);
        this.bcT.setOnClickListener(onClickListener);
        if (this.bdd != null) {
            this.bdd.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ad(i == 1);
        this.mContext.getLayoutMode().k(this.LT);
        this.mContext.getLayoutMode().k(this.bdn);
        this.mContext.getLayoutMode().k(this.bdc);
        if (this.bdf != null) {
            this.bdf.tc();
        }
        if (this.bdL) {
            gp(1);
        } else {
            gp(0);
        }
        an.c(this.bda, com.baidu.tbadk.core.util.c.ci(this.bdD));
        this.bdr.invalidate();
        this.LP.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bcU.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LP.setShadowLayer(1.0f, 0.0f, 1.0f, an.getColor(i.c.frs_like_shadow));
        this.bcU.setShadowLayer(1.0f, 0.0f, 1.0f, an.getColor(i.c.frs_sign_shadow));
        if (this.bdd != null) {
            an.i(this.bdd, i.e.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            an.c(this.bdq, i.e.icon_speed_orange);
        } else {
            an.c(this.bdq, i.e.icon_speed_gray);
        }
        if (this.bdw != null) {
            this.bdw.changeSkinType(i);
        }
        if (this.bdl != null) {
            this.bdl.d(this.mContext, i);
        }
        if (this.bds != null) {
            this.bds.cP(i);
        }
        Iterator<TbImageView> it = this.bdY.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (oVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bdE = forumData.getPost_num();
            this.bdy = forumData.getTag_color();
            this.bdF = forumData.getSignData().getCountSignNum();
            this.bdG = forumData.getCurScore();
            this.bdz = forumData.getAccelerateContent();
            this.bcq = forumData.getLevelupScore();
            this.bdA = oVar;
            this.ber = oVar.avX();
            this.bdt = forumData.getBadgeData();
            this.bdB = new com.baidu.tbadk.core.data.w();
            this.bdj = forumData.getTopCode();
            this.bdk = forumData.getNewsInfo();
            if (this.ber != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.ber.awp());
                this.bdB.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.ber.awq());
                this.bdB.getMedias().add(mediaData2);
            }
            this.LT.setVisibility(0);
            this.bdv.setForumName(forumData.getName());
            Ot();
        }
    }

    private void Ot() {
        if (this.bdA != null) {
            if (this.bdA.avY() == null || this.bdA.avY().rv() == null || this.bdA.avY().rv().size() <= 0) {
                this.bdg.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.i> arrayList = new ArrayList<>();
                String str = "";
                if (this.bdA.afg() != null && this.bdA.afg().getFrsBannerData() != null) {
                    str = this.bdA.afg().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i(this.ber.awp(), str, null);
                iVar.ah(true);
                arrayList.add(iVar);
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.h(arrayList);
                a(hVar);
            } else {
                this.bdg.setVisibility(0);
                a(this.bdA.avY());
            }
        }
        if (this.LM != null) {
            this.LM.setText(String.valueOf(this.mMemberNum));
        }
        if (this.LN != null) {
            this.LN.setText(String.valueOf(this.bdE));
        }
        if (this.LO != null) {
            if (this.bdt != null && this.bdt.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.LO.setText(String.valueOf(this.mForumName) + this.mContext.getString(i.h.forum));
        }
        if (this.bdd != null && this.bde != null) {
            if (this.bdA != null && this.bdA.awe()) {
                int da = com.baidu.tbadk.core.util.o.da(this.bdA.awi());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (da == 1 && !z) {
                    this.bdd.setVisibility(8);
                } else {
                    this.bdd.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bdA.getGameName()) && !TextUtils.isEmpty(this.bdA.getGameName().trim())) {
                        this.bde.setText(UtilHelper.getFixedText(this.bdA.getGameName(), 10));
                        String lO = com.baidu.tieba.tbadkCore.util.n.lO(this.bdA.awi());
                        if (!StringUtils.isNull(lO)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", lO, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bde.setText("");
                    }
                }
            } else {
                this.bdd.setVisibility(8);
            }
        }
        if (this.bdA != null && this.bdA.awf() != null && this.bdA.awf().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> awf = this.bdA.awf();
            ae(awf);
            int size = awf.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bdi.setVisibility(0);
                this.bdi.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar2 = awf.get(i2);
                    if (hVar2 != null && !gS(hVar2.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(i.f.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), i.d.ds6));
                        tbImageView.d(hVar2.getIcon(), 21, false);
                        this.bdY.add(tbImageView);
                        ((TextView) linearLayout.findViewById(i.f.frs_header_enters_text)).setText(UtilHelper.getFixedText(hVar2.getTitle(), 10));
                        applyNightMode(linearLayout);
                        linearLayout.setTag(hVar2.getUrl());
                        linearLayout.setOnClickListener(this.bdP);
                        this.bdi.addView(linearLayout);
                    }
                }
            } else {
                this.bdi.setVisibility(8);
            }
        } else {
            this.bdi.setVisibility(8);
        }
        this.bdr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bdr.d(this.ber.awq(), 16, false);
        if (this.bds != null && this.bdt != null && this.bdt.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bdt.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bdt.get(i3).rr());
                iconData.setIcon(this.bdt.get(i3).rq());
                this.bdC = this.bdt.get(i3).rs();
                linkedList.add(iconData);
            }
            this.bds.setOnClickListener(this.bdQ);
            this.bds.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(i.d.frs_starheader_badge_margin));
        }
        if (this.bdA != null) {
            this.bdw.a(this.bdA.avX(), this.bdA.afg());
        } else {
            this.bdw.a(null, null);
        }
        this.bdl.a(this.bdj, this.bdk);
        Ou();
    }

    private void Ou() {
        View Ox;
        if (this.bdl.getTopCodeView() != null && this.bdl.getNewsInfoView() != null && this.bdl.getTopCodeViewDivider() != null && this.bdl.getTopCodeView().getVisibility() != 0) {
            if (this.bdl.getTopCodeView().getVisibility() == 8 && this.bdl.getNewsInfoView().getVisibility() == 0) {
                this.bdl.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bdl.getNewsInfoView().getVisibility() == 8 && this.bdd.getVisibility() == 0) {
                this.bdc.findViewById(i.f.frs_header_divider_games).setVisibility(8);
            } else if (this.bdd.getVisibility() == 8 && this.bdi.getVisibility() == 0) {
                if (this.bdi.getChildCount() > 0) {
                    ((LinearLayout) this.bdi.getChildAt(0)).findViewById(i.f.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bdi.getVisibility() == 8 && this.bdw.Ow() != null && (Ox = this.bdw.Ox()) != null) {
                Ox.setVisibility(8);
            }
        }
    }

    public void NK() {
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
        this.bdq.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, this.LT, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.bdq.getWidth() / 2), iArr[1] + this.bdq.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.bdM = z;
        Bitmap cf = com.baidu.tbadk.core.util.c.cf(i.e.bg_frs_signin_bar_down);
        if (cf != null && cf.getWidth() > 0) {
            if (this.bdM) {
                this.bcZ.setText(i.h.star_bar_level_up);
                an.c(this.bda, com.baidu.tbadk.core.util.c.ci(this.bdD + 1));
            } else {
                this.bcZ.setText(this.bdx);
                an.c(this.bda, com.baidu.tbadk.core.util.c.ci(this.bdD));
            }
            if (this.bdM) {
                b(this.mContext.getOrignalPage(), this.bdb, this.bdN, f);
            } else {
                a(this.mContext.getOrignalPage(), this.bdb, this.bdN, f);
            }
            this.bdN = f;
        }
    }

    public void e(View view, boolean z) {
        TiebaStatic.eventStat(this.aVn.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.bdm == null) {
                this.bdm = new PopupWindow(this.mContext.getPageActivity());
                this.bdm.setContentView(this.bdn);
                this.bdm.setBackgroundDrawable(new BitmapDrawable());
                this.bdm.setOutsideTouchable(true);
                this.bdm.setFocusable(true);
                this.bdm.setWidth(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_btn_width));
                this.bdm.setHeight(this.mContext.getResources().getDimensionPixelSize(i.d.frs_header_exp_height));
                this.bdo = (TextView) this.bdn.findViewById(i.f.cur_experience);
                this.bdp = (TextView) this.bdn.findViewById(i.f.levelup_experience);
                a(this.bdo, this.bdp);
            }
            if (this.bdm.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bdm, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bdo, this.bdp);
            int height = iArr[1] - this.bdm.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.j.a(this.bdm, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.bdm, this.LT, 0, iArr[0], height);
            this.bdm.update();
            this.mHandler.postDelayed(this.bdO, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(i.f.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(i.f.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(i.f.speed_tip);
            an.b((TextView) inflate.findViewById(i.f.experience), i.c.cp_cont_b, 1);
            an.b(textView, i.c.cp_cont_b, 1);
            an.b(textView2, i.c.cp_cont_b, 1);
            an.b(textView3, i.c.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bdz) && !TextUtils.isEmpty(this.bdz.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bdz);
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
        if (aVar != null && (imageView = (ImageView) this.LT.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
