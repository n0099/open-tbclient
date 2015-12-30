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
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends a implements com.baidu.tbadk.imageManager.b {
    private com.baidu.tieba.tbadkCore.o boN = null;
    private ArrayList<TbImageView> bov = new ArrayList<>();

    public q(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.mMemberType = i;
        this.beB = tbPageContext.getOrignalPage();
        this.mContext = tbPageContext;
        this.mHandler = new Handler();
        this.bni = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), n.e.ds20);
        this.bnj = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), n.e.ds72);
        this.bnk = com.baidu.adp.lib.util.k.d(tbPageContext.getPageActivity(), n.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.MA = LayoutInflater.from(tbPageContext.getContext()).inflate(n.h.frs_star_title, (ViewGroup) null);
        this.bnJ = LayoutInflater.from(tbPageContext.getContext()).inflate(n.h.frs_show_experience, (ViewGroup) null);
        if (this.mForumName == null || this.mForumId == null) {
            this.MA.setVisibility(8);
        }
        this.bnt = (RelativeLayout) this.MA.findViewById(n.g.btn_love_content);
        this.bnM = (ImageView) this.MA.findViewById(n.g.speed_icon);
        this.bnu = (TextView) this.MA.findViewById(n.g.level_name);
        this.bnv = (ImageView) this.MA.findViewById(n.g.level);
        this.bnw = (ImageView) this.MA.findViewById(n.g.love_level_top);
        this.bnS = new i(this.MA, this.mContext.getPageActivity());
        this.bnl = (FrameLayout) this.MA.findViewById(n.g.love);
        this.bnm = (Button) this.MA.findViewById(n.g.btn_love);
        this.Mw = (TextView) this.MA.findViewById(n.g.tv_love);
        this.bnn = (FrameLayout) this.MA.findViewById(n.g.sign);
        this.bno = (Button) this.MA.findViewById(n.g.btn_sign);
        this.bnp = (TextView) this.MA.findViewById(n.g.tv_sign);
        this.bnq = (ProgressBar) this.MA.findViewById(n.g.sign_progress);
        this.bnr = (FrameLayout) this.MA.findViewById(n.g.sign_done);
        this.bns = (TextView) this.MA.findViewById(n.g.sign_done_text);
        this.Mt = (TextView) this.MA.findViewById(n.g.member_num_text);
        this.Mu = (TextView) this.MA.findViewById(n.g.post_num_text);
        this.Mv = (TextView) this.MA.findViewById(n.g.title_text);
        this.bnC = (TextView) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.e.ds280), 0, 0);
        this.bnC.setLayoutParams(layoutParams);
        this.bnB = (CoverFlowView) this.MA.findViewById(n.g.frs_coverflowview);
        Qq();
        this.bnB.tr();
        this.bnO = (BarImageView) this.MA.findViewById(n.g.frs_star_bottom_photo);
        this.bnO.setGifIconSupport(false);
        this.bnP = (UserIconBox) this.MA.findViewById(n.g.frs_badge_box);
        this.bnx = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(n.h.frs_header_extra, (ViewGroup) null);
        this.bny = (LinearLayout) this.bnx.findViewById(n.g.frs_bawu_center);
        this.bnz = (LinearLayout) this.bnx.findViewById(n.g.frs_header_games);
        this.bnA = (TextView) this.bnx.findViewById(n.g.frs_header_games_text);
        this.bfX = new br(this.mContext, this.MA, 1);
        this.bfX.hide();
        this.bnR = new bg(this.mContext);
        this.bnE = (LinearLayout) this.bnx.findViewById(n.g.frs_header_enter_root);
        this.bnT = new w(this.mContext, this.bnx);
        this.bnH = (U9InfoView) this.bnx.findViewById(n.g.frs_header_enter_u9);
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnO.setOnClickListener(onClickListener);
        this.Mv.setOnClickListener(onClickListener);
        this.bnt.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.c.e.gw().aj("frs_to_bar_detail") == 0) {
            this.MA.setOnClickListener(new r(this));
        }
        this.bnS.setOnClickListener(onClickListener);
        this.bnm.setOnClickListener(onClickListener);
        this.bno.setOnClickListener(onClickListener);
        this.bnr.setOnClickListener(onClickListener);
        if (this.bny != null) {
            this.bny.setOnClickListener(onClickListener);
        }
        if (this.bnz != null) {
            this.bnz.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ac(i == 1);
        this.mContext.getLayoutMode().k(this.MA);
        this.mContext.getLayoutMode().k(this.bnJ);
        this.mContext.getLayoutMode().k(this.bnx);
        if (this.bnB != null) {
            this.bnB.tr();
        }
        if (this.boj) {
            gE(1);
        } else {
            gE(0);
        }
        as.c(this.bnv, com.baidu.tbadk.core.util.c.cj(this.boa));
        this.bnO.invalidate();
        this.Mw.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bnp.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Mw.setShadowLayer(1.0f, 0.0f, 1.0f, as.getColor(n.d.frs_like_shadow));
        this.bnp.setShadowLayer(1.0f, 0.0f, 1.0f, as.getColor(n.d.frs_sign_shadow));
        if (this.bny != null) {
            as.i(this.bny, n.f.frs_top_item_bg);
        }
        if (this.bnz != null) {
            as.i(this.bnz, n.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            as.c(this.bnM, n.f.icon_speed_orange);
        } else {
            as.c(this.bnM, n.f.icon_speed_gray);
        }
        if (this.bnT != null) {
            this.bnT.changeSkinType(i);
        }
        if (this.bfX != null) {
            this.bfX.changeSkinType(i);
        }
        if (this.bnH != null) {
            this.bnH.d(this.mContext, i);
        }
        if (this.bnP != null) {
            this.bnP.cR(i);
        }
        Iterator<TbImageView> it = this.bov.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (pVar != null && forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bob = forumData.getPost_num();
            this.bnV = forumData.getTag_color();
            this.bnU = forumData.getLevelName();
            this.boa = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.boc = forumData.getSignData().getCountSignNum();
                this.bod = forumData.getSignData().getMissSignNum();
            }
            this.boe = forumData.getCurScore();
            this.bnW = forumData.getAccelerateContent();
            this.bmM = forumData.getLevelupScore();
            this.bnX = pVar;
            this.boN = pVar.aDK();
            this.bnQ = forumData.getBadgeData();
            this.bnY = new z();
            this.bnF = forumData.getTopCode();
            this.bnG = forumData.getNewsInfo();
            if (this.boN != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.boN.aEf());
                this.bnY.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.boN.aEg());
                this.bnY.getMedias().add(mediaData2);
            }
            this.MA.setVisibility(0);
            this.bnS.setForumName(forumData.getName());
            Qr();
        }
    }

    private void Qr() {
        if (this.bnX != null) {
            if (this.bnX.aDL() == null || this.bnX.aDL().rs() == null || this.bnX.aDL().rs().size() <= 0) {
                this.bnC.setVisibility(8);
                ArrayList<com.baidu.tbadk.core.data.i> arrayList = new ArrayList<>();
                String str = "";
                if (this.bnX.akG() != null && this.bnX.akG().getFrsBannerData() != null) {
                    str = this.bnX.akG().getFrsBannerData().getValue();
                }
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i(this.boN.aEf(), str, null);
                iVar.ag(true);
                arrayList.add(iVar);
                com.baidu.tbadk.core.data.h hVar = new com.baidu.tbadk.core.data.h();
                hVar.h(arrayList);
                a(hVar);
            } else {
                this.bnC.setVisibility(0);
                a(this.bnX.aDL());
            }
        }
        if (this.Mt != null) {
            this.Mt.setText(ax.z(this.mMemberNum));
        }
        if (this.Mu != null) {
            this.Mu.setText(ax.z(this.bob));
        }
        if (this.Mv != null) {
            if (this.bnQ != null && this.bnQ.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.Mv.setText(String.valueOf(this.mForumName) + this.mContext.getString(n.j.forum));
        }
        if (this.bny != null) {
            if (this.bnX != null && this.bnX.getUserData() != null && this.bnX.getUserData().isBawu()) {
                this.bny.setVisibility(0);
            } else {
                this.bny.setVisibility(8);
            }
        }
        if (this.bnz != null && this.bnA != null) {
            if (this.bnX != null && this.bnX.aDR()) {
                int dl = com.baidu.tbadk.core.util.o.dl(this.bnX.aDV());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dl == 1 && !z) {
                    this.bnz.setVisibility(8);
                } else {
                    this.bnz.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bnX.getGameName()) && !TextUtils.isEmpty(this.bnX.getGameName().trim())) {
                        this.bnA.setText(UtilHelper.getFixedText(this.bnX.getGameName(), 10));
                        String mz = com.baidu.tieba.tbadkCore.util.n.mz(this.bnX.aDV());
                        if (!StringUtils.isNull(mz)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", mz, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bnA.setText(this.mContext.getResources().getString(n.j.frsgame_title));
                    }
                }
            } else {
                this.bnz.setVisibility(8);
            }
        }
        if (this.bnX != null && this.bnX.aDS() != null && this.bnX.aDS().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> aDS = this.bnX.aDS();
            ak(aDS);
            int size = aDS.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bnE.setVisibility(0);
                this.bnE.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar2 = aDS.get(i2);
                    if (hVar2 != null && !hw(hVar2.getUrl())) {
                        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.frs_header_enter_lay, (ViewGroup) null);
                        TbImageView tbImageView = (TbImageView) linearLayout.findViewById(n.g.frs_header_enters_icon);
                        tbImageView.setGifIconSupport(false);
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        tbImageView.setDrawerType(1);
                        tbImageView.setRadius(com.baidu.adp.lib.util.k.d(this.mContext.getPageActivity(), n.e.ds6));
                        tbImageView.d(hVar2.getIcon(), 21, false);
                        this.bov.add(tbImageView);
                        ((TextView) linearLayout.findViewById(n.g.frs_header_enters_text)).setText(UtilHelper.getFixedText(hVar2.getTitle(), 10));
                        applyNightMode(linearLayout);
                        linearLayout.setTag(hVar2.getUrl());
                        linearLayout.setOnClickListener(this.bon);
                        this.bnE.addView(linearLayout);
                    }
                }
            } else {
                this.bnE.setVisibility(8);
            }
        } else {
            this.bnE.setVisibility(8);
        }
        this.bnO.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bnO.d(this.boN.aEg(), 16, false);
        if (this.bnP != null && this.bnQ != null && this.bnQ.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bnQ.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bnQ.get(i3).ro());
                iconData.setIcon(this.bnQ.get(i3).rn());
                this.bnZ = this.bnQ.get(i3).rp();
                linkedList.add(iconData);
            }
            this.bnP.setOnClickListener(this.agX);
            this.bnP.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(n.e.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(n.e.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(n.e.frs_starheader_badge_margin));
        }
        if (this.bnX != null) {
            this.bnT.a(this.bnX.aDK(), this.bnX.akG());
        } else {
            this.bnT.a(null, null);
        }
        if (this.bnX != null) {
            this.bfX.b(this.bnX);
        }
        this.bnH.a(this.bnF, this.bnG);
        Qs();
    }

    private void Qs() {
        View Qv;
        if (this.bnH.getTopCodeView() != null && this.bnH.getNewsInfoView() != null && this.bnH.getTopCodeViewDivider() != null && this.bnH.getTopCodeView().getVisibility() != 0) {
            if (this.bnH.getTopCodeView().getVisibility() == 8 && this.bnH.getNewsInfoView().getVisibility() == 0) {
                this.bnH.getTopCodeViewDivider().setVisibility(8);
            } else if (this.bnH.getNewsInfoView().getVisibility() == 8 && this.bnz.getVisibility() == 0) {
                this.bnx.findViewById(n.g.frs_header_divider_games).setVisibility(8);
            } else if (this.bnz.getVisibility() == 8 && this.bnE.getVisibility() == 0) {
                if (this.bnE.getChildCount() > 0) {
                    ((LinearLayout) this.bnE.getChildAt(0)).findViewById(n.g.frs_header_divider_enters).setVisibility(8);
                }
            } else if (this.bnE.getVisibility() == 8 && this.bnT.Qu() != null && (Qv = this.bnT.Qv()) != null) {
                Qv.setVisibility(8);
            }
        }
    }

    public void PI() {
        View contentView;
        if (this.bnN == null) {
            this.bnN = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(n.h.speed_tip, (ViewGroup) null);
            this.bnN.setContentView(contentView);
            contentView.setOnClickListener(new s(this));
            this.bnN.setWidth(this.mContext.getResources().getDimensionPixelSize(n.e.ds300));
            this.bnN.setHeight(this.mContext.getResources().getDimensionPixelSize(n.e.ds88));
            this.bnN.setBackgroundDrawable(new BitmapDrawable());
            this.bnN.setOutsideTouchable(true);
            this.bnN.setTouchInterceptor(new t(this));
        } else {
            contentView = this.bnN.getContentView();
        }
        this.mContext.getLayoutMode().k(contentView);
        int[] iArr = new int[2];
        this.bnM.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bnN, this.MA, 0, (iArr[0] - (this.bnN.getWidth() / 2)) + (this.bnM.getWidth() / 2), iArr[1] + this.bnM.getWidth());
        this.bnN.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        int i;
        this.bok = z;
        Bitmap cg = com.baidu.tbadk.core.util.c.cg(n.f.bg_frs_signin_bar_down);
        if (cg != null && cg.getWidth() > 0) {
            if (this.bok) {
                this.bnu.setText(n.j.star_bar_level_up);
                this.bnu.setText(n.j.level_up);
                if (f >= 1.0f) {
                    i = this.boa;
                } else {
                    i = this.boa + 1;
                }
                com.baidu.tieba.tbadkCore.p Nn = this.beB.Nn();
                if (Nn != null && Nn.akG() != null) {
                    Nn.akG().setUser_level(i);
                }
                as.c(this.bnv, com.baidu.tbadk.core.util.c.cj(i));
            } else {
                this.bnu.setText(this.bnU);
                as.c(this.bnv, com.baidu.tbadk.core.util.c.cj(this.boa));
            }
            if (this.bok) {
                if (f >= 1.0f) {
                    a(this.mContext.getOrignalPage(), this.bnw, this.bol, f);
                } else {
                    b(this.mContext.getOrignalPage(), this.bnw, this.bol, f);
                }
            } else {
                a(this.mContext.getOrignalPage(), this.bnw, this.bol, f);
            }
            this.bol = f;
        }
    }

    public void e(View view, boolean z) {
        TiebaStatic.eventStat(this.beB.getPageContext().getPageActivity(), "consume_6", "click");
        if (this.mMemberType != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bom);
            if (this.bnI == null) {
                this.bnI = new PopupWindow(this.mContext.getPageActivity());
                this.bnI.setContentView(this.bnJ);
                this.bnI.setBackgroundDrawable(new BitmapDrawable());
                this.bnI.setOutsideTouchable(true);
                this.bnI.setFocusable(true);
                this.bnI.setWidth(this.mContext.getResources().getDimensionPixelSize(n.e.frs_header_btn_width));
                this.bnI.setHeight(this.mContext.getResources().getDimensionPixelSize(n.e.frs_header_exp_height));
                this.bnK = (TextView) this.bnJ.findViewById(n.g.cur_experience);
                this.bnL = (TextView) this.bnJ.findViewById(n.g.levelup_experience);
                a(this.bnK, this.bnL);
            }
            if (this.bnI.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bnI, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bnK, this.bnL);
            int height = iArr[1] - this.bnI.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.h.j.a(this.bnI, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bnI, this.MA, 0, iArr[0], height);
            this.bnI.update();
            this.mHandler.postDelayed(this.bom, 2000L);
        } else if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(n.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(n.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(n.g.speed_tip);
            as.b((TextView) inflate.findViewById(n.g.experience), n.d.cp_cont_b, 1);
            as.b(textView, n.d.cp_cont_b, 1);
            as.b(textView2, n.d.cp_cont_b, 1);
            as.b(textView3, n.d.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.bnW) && !TextUtils.isEmpty(this.bnW.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bnW);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.m(inflate);
            aVar.bH(n.d.cp_link_tip_d);
            a(textView, textView2);
            aVar.b(n.j.cancel_text, new u(this));
            aVar.a(n.j.open_now, new v(this));
            aVar.b(this.mContext).tf();
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.MA.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }
}
