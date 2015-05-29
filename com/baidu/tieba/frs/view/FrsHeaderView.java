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
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FrsHeaderView extends a {
    private View aGF;
    private String mImageUrl;

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (aRx) with 'values()' method */
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
        this.aGF = null;
        this.aRb = i;
        this.mHandler = new Handler();
        this.aMk = frsActivity;
        this.LH = frsActivity.getPageContext();
        this.mForumName = str;
        this.mForumId = str2;
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(frsActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.frs_header, null);
        this.aGF = this.LG.findViewById(com.baidu.tieba.q.container);
        this.aQE = com.baidu.adp.lib.g.b.hr().inflate(frsActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.frs_show_experience, null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.LG.setVisibility(8);
        }
        this.aQr = (RelativeLayout) this.LG.findViewById(com.baidu.tieba.q.btn_love_content);
        this.aQH = (ImageView) this.LG.findViewById(com.baidu.tieba.q.speed_icon);
        this.aQN = new g(this.LG, this.LH.getPageActivity());
        this.aQs = (TextView) this.LG.findViewById(com.baidu.tieba.q.level_name);
        this.aQt = (ImageView) this.LG.findViewById(com.baidu.tieba.q.level);
        this.aQu = (ImageView) this.LG.findViewById(com.baidu.tieba.q.love_level_top);
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
        this.aQJ = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_tag_text);
        this.aQI = (BarImageView) this.LG.findViewById(com.baidu.tieba.q.frs_image);
        this.aQI.setGifIconSupport(false);
        this.aQK = (UserIconBox) this.LG.findViewById(com.baidu.tieba.q.frs_badge_box);
        this.aQv = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_groups);
        this.aQw = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_header_groups_text);
        this.aQx = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_games);
        this.aQy = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_header_games_text);
        this.aQz = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_enter_root);
        this.aQO = new w(this.LH, this.LG);
        this.aQM = new ao(this.LH);
        this.aQC = (U9InfoView) this.LG.findViewById(com.baidu.tieba.q.frs_header_enter_u9);
    }

    public void n(View.OnClickListener onClickListener) {
        this.aQI.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aQk.setOnClickListener(onClickListener);
        this.aQm.setOnClickListener(onClickListener);
        this.aQr.setOnClickListener(onClickListener);
        this.aQv.setOnClickListener(onClickListener);
        if (this.aQx != null) {
            this.aQx.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.b.f.gD().ai("frs_to_bar_detail") == 0) {
            this.LG.setOnClickListener(new i(this));
        }
        this.aQN.setOnClickListener(onClickListener);
        this.aQJ.setOnClickListener(new j(this));
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
        this.aQI.invalidate();
        ay.c(this.aQt, com.baidu.tbadk.core.util.c.bU(this.aQW));
        ay.j(this.aGF, com.baidu.tieba.n.cp_bg_line_d);
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
        this.mForumName = forumData.getName();
        this.mForumId = forumData.getId();
        this.aQX = forumData.getMember_num();
        this.aQY = forumData.getPost_num();
        this.aQQ = forumData.getTag_color();
        this.aQR = forumData.getTag_name();
        this.mImageUrl = forumData.getImage_url();
        this.aQP = forumData.getLevelName();
        this.aQW = forumData.getUser_level();
        this.aQZ = forumData.getSignData().getCountSignNum();
        this.aRa = forumData.getCurScore();
        this.aPW = forumData.getLevelupScore();
        this.aQL = forumData.getBadgeData();
        this.aQA = forumData.getTopCode();
        this.aQB = forumData.getNewsInfo();
        this.aQS = forumData.getAccelerateContent();
        this.aQT = wVar;
        if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
            this.LG.setVisibility(8);
        } else {
            this.LG.setVisibility(0);
        }
        this.aQU = new com.baidu.tbadk.core.data.w();
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.aQU.getMedias().add(mediaData);
        this.aQN.setForumName(forumData.getName());
        MH();
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
            if (!StringUtils.isNull(this.mForumName)) {
                this.mTitleText.setText(String.valueOf(this.mForumName) + this.LH.getString(com.baidu.tieba.t.forum));
            }
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
        if (this.aQT != null) {
            this.aQO.a(this.aQT.amp(), this.aQT.aar());
        } else {
            this.aQO.a(null, null);
        }
        this.aQI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aQI.c(this.mImageUrl, 15, false);
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
            this.aQK.a(linkedList, 2, this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_badge_width), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_badge_height), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_badge_margin));
        }
        this.aQC.a(this.aQA, this.aQB);
    }

    public void c(View view, boolean z) {
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
            if (iArr[1] - this.aQD.getHeight() <= 50) {
                com.baidu.adp.lib.g.k.a(this.aQD, this.LH.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aQD, this.LG, 0, iArr[0], iArr[1] - this.aQD.getHeight());
            this.aQD.update();
            this.mHandler.postDelayed(this.aRk, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.LH.getContext(), com.baidu.tieba.r.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.q.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.q.speed_tip);
            ay.b((TextView) inflate.findViewById(com.baidu.tieba.q.experience_txt), com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(textView, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(textView2, com.baidu.tieba.n.cp_cont_b, 1);
            ay.b(textView3, com.baidu.tieba.n.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.LH.getPageActivity());
            aVar.l(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.aQS) && !TextUtils.isEmpty(this.aQS.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aQS);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bv(com.baidu.tieba.n.cp_link_tip_d);
            aVar.b(com.baidu.tieba.t.cancel_text, new k(this));
            aVar.a(com.baidu.tieba.t.open_now, new l(this));
            aVar.b(this.LH);
            aVar.rL();
        }
    }

    public void Mg() {
        PopupWindow popupWindow = new PopupWindow(this.LH.getPageActivity());
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.LH.getContext(), com.baidu.tieba.r.speed_tip, null);
        this.LH.getLayoutMode().j(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new m(this, popupWindow));
        popupWindow.setWidth(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds300));
        popupWindow.setHeight(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new n(this, popupWindow));
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
                this.aQs.setText(com.baidu.tieba.t.level_up);
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
}
