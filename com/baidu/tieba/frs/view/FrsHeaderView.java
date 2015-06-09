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
    private View aGG;
    private String mImageUrl;

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (aRy) with 'values()' method */
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
        this.aGG = null;
        this.aRc = i;
        this.mHandler = new Handler();
        this.aMl = frsActivity;
        this.LH = frsActivity.getPageContext();
        this.mForumName = str;
        this.mForumId = str2;
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(frsActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.frs_header, null);
        this.aGG = this.LG.findViewById(com.baidu.tieba.q.container);
        this.aQF = com.baidu.adp.lib.g.b.hr().inflate(frsActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.frs_show_experience, null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.LG.setVisibility(8);
        }
        this.aQs = (RelativeLayout) this.LG.findViewById(com.baidu.tieba.q.btn_love_content);
        this.aQI = (ImageView) this.LG.findViewById(com.baidu.tieba.q.speed_icon);
        this.aQO = new g(this.LG, this.LH.getPageActivity());
        this.aQt = (TextView) this.LG.findViewById(com.baidu.tieba.q.level_name);
        this.aQu = (ImageView) this.LG.findViewById(com.baidu.tieba.q.level);
        this.aQv = (ImageView) this.LG.findViewById(com.baidu.tieba.q.love_level_top);
        this.aQk = (FrameLayout) this.LG.findViewById(com.baidu.tieba.q.love);
        this.aQl = (Button) this.LG.findViewById(com.baidu.tieba.q.btn_love);
        this.LB = (TextView) this.LG.findViewById(com.baidu.tieba.q.tv_love);
        this.aQm = (FrameLayout) this.LG.findViewById(com.baidu.tieba.q.sign);
        this.aQn = (Button) this.LG.findViewById(com.baidu.tieba.q.btn_sign);
        this.aQo = (TextView) this.LG.findViewById(com.baidu.tieba.q.tv_sign);
        this.aQp = (ProgressBar) this.LG.findViewById(com.baidu.tieba.q.sign_progress);
        this.aQq = (FrameLayout) this.LG.findViewById(com.baidu.tieba.q.sign_done);
        this.aQr = (TextView) this.LG.findViewById(com.baidu.tieba.q.sign_done_text);
        this.Lz = (TextView) this.LG.findViewById(com.baidu.tieba.q.member_num_text);
        this.LA = (TextView) this.LG.findViewById(com.baidu.tieba.q.post_num_text);
        this.mTitleText = (TextView) this.LG.findViewById(com.baidu.tieba.q.title_text);
        this.aQK = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_tag_text);
        this.aQJ = (BarImageView) this.LG.findViewById(com.baidu.tieba.q.frs_image);
        this.aQJ.setGifIconSupport(false);
        this.aQL = (UserIconBox) this.LG.findViewById(com.baidu.tieba.q.frs_badge_box);
        this.aQw = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_groups);
        this.aQx = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_header_groups_text);
        this.aQy = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_games);
        this.aQz = (TextView) this.LG.findViewById(com.baidu.tieba.q.frs_header_games_text);
        this.aQA = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.frs_header_enter_root);
        this.aQP = new w(this.LH, this.LG);
        this.aQN = new ao(this.LH);
        this.aQD = (U9InfoView) this.LG.findViewById(com.baidu.tieba.q.frs_header_enter_u9);
    }

    public void n(View.OnClickListener onClickListener) {
        this.aQJ.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aQl.setOnClickListener(onClickListener);
        this.aQn.setOnClickListener(onClickListener);
        this.aQs.setOnClickListener(onClickListener);
        this.aQw.setOnClickListener(onClickListener);
        if (this.aQy != null) {
            this.aQy.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.b.f.gD().ai("frs_to_bar_detail") == 0) {
            this.LG.setOnClickListener(new i(this));
        }
        this.aQO.setOnClickListener(onClickListener);
        this.aQK.setOnClickListener(new j(this));
    }

    public void changeSkinType(int i) {
        this.LH.getLayoutMode().ab(i == 1);
        this.LH.getLayoutMode().j(this.LG);
        this.LH.getLayoutMode().j(this.aQF);
        if (this.aRi) {
            fp(1);
        } else {
            fp(0);
        }
        this.aQJ.invalidate();
        ay.c(this.aQu, com.baidu.tbadk.core.util.c.bU(this.aQX));
        ay.j(this.aGG, com.baidu.tieba.n.cp_bg_line_d);
        this.LB.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aQo.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.LB.setShadowLayer(1.0f, 0.0f, 1.0f, ay.getColor(com.baidu.tieba.n.frs_like_shadow));
        this.aQo.setShadowLayer(1.0f, 0.0f, 1.0f, ay.getColor(com.baidu.tieba.n.frs_sign_shadow));
        ay.i(this.aQw, com.baidu.tieba.p.frs_top_item_bg);
        if (this.aQy != null) {
            ay.i(this.aQy, com.baidu.tieba.p.frs_top_item_bg);
        }
        if (this.aRc != 0) {
            ay.c(this.aQI, com.baidu.tieba.p.icon_speed_orange);
        } else {
            ay.c(this.aQI, com.baidu.tieba.p.icon_speed_gray);
        }
        if (this.aQP != null) {
            this.aQP.changeSkinType(i);
        }
        if (this.aQD != null) {
            this.aQD.c(this.LH, i);
        }
        if (this.aQL != null) {
            this.aQL.cz(i);
        }
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.w wVar) {
        this.mForumName = forumData.getName();
        this.mForumId = forumData.getId();
        this.aQY = forumData.getMember_num();
        this.aQZ = forumData.getPost_num();
        this.aQR = forumData.getTag_color();
        this.aQS = forumData.getTag_name();
        this.mImageUrl = forumData.getImage_url();
        this.aQQ = forumData.getLevelName();
        this.aQX = forumData.getUser_level();
        this.aRa = forumData.getSignData().getCountSignNum();
        this.aRb = forumData.getCurScore();
        this.aPX = forumData.getLevelupScore();
        this.aQM = forumData.getBadgeData();
        this.aQB = forumData.getTopCode();
        this.aQC = forumData.getNewsInfo();
        this.aQT = forumData.getAccelerateContent();
        this.aQU = wVar;
        if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
            this.LG.setVisibility(8);
        } else {
            this.LG.setVisibility(0);
        }
        this.aQV = new com.baidu.tbadk.core.data.w();
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.aQV.getMedias().add(mediaData);
        this.aQO.setForumName(forumData.getName());
        MI();
    }

    private void MI() {
        if (this.Lz != null) {
            this.Lz.setText(String.valueOf(this.aQY));
        }
        if (this.LA != null) {
            this.LA.setText(String.valueOf(this.aQZ));
        }
        if (this.mTitleText != null) {
            if (this.aQM != null && this.aQM.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.mTitleText.setText(String.valueOf(this.mForumName) + this.LH.getString(com.baidu.tieba.t.forum));
            }
        }
        boolean z = MessageManager.getInstance().findTask(2902025) != null;
        if (this.aQS != null && this.aQS.length() > 0 && z) {
            if (this.aQK != null) {
                this.aQK.setText(this.aQS);
            }
            if (this.aQK != null && this.aQR != null && this.aQR.length() > 0) {
                this.aRd = com.baidu.adp.lib.g.c.toInt(this.aQR, -1);
                if (this.aRd >= 0 && this.aRd < aQj.length) {
                    ay.i((View) this.aQK, aQj[this.aRd]);
                }
            }
            if (this.aQK != null) {
                this.aQK.setVisibility(0);
            }
        } else if (this.aQK != null) {
            this.aQK.setVisibility(8);
        }
        if (this.aQU != null && this.aQU.qK() != null && this.aQU.qK().getIfpost() == 0) {
            if (this.aQU.getThreadList().isEmpty()) {
                this.aQw.setVisibility(8);
            } else {
                this.aQw.setVisibility(0);
                if (this.aQU.amv().amn() > 0) {
                    this.aQx.setText(" (" + this.aQU.amv().amn() + ")");
                } else {
                    this.aQx.setText("");
                }
            }
        } else {
            this.aQw.setVisibility(0);
            if (this.aQU != null && this.aQU.amv().amn() > 0) {
                this.aQx.setText(" (" + this.aQU.amv().amn() + ")");
            } else {
                this.aQx.setText("");
            }
        }
        if (this.aRo && this.LH != null && this.LH.getOrignalPage() != null && this.LH.getOrignalPage().isLogin()) {
            this.aQw.setVisibility(0);
        } else {
            this.aQw.setVisibility(8);
        }
        if (this.aQy != null && this.aQz != null) {
            if (this.aQU != null && this.aQU.amw()) {
                this.aQy.setVisibility(0);
                if (!TextUtils.isEmpty(this.aQU.getGameName()) && !TextUtils.isEmpty(this.aQU.getGameName().trim())) {
                    this.aQz.setText(UtilHelper.getFixedText(this.aQU.getGameName(), 10));
                    String jJ = com.baidu.tieba.tbadkCore.util.k.jJ(this.aQU.amz());
                    if (!StringUtils.isNull(jJ)) {
                        TiebaStatic.eventStat(this.LH.getPageActivity(), "game_show", "show", 1, "dev_id", jJ, "ref_id", "1000601", "ref_type", "603");
                    }
                } else {
                    this.aQz.setText("");
                }
            } else {
                this.aQy.setVisibility(8);
            }
        }
        if (this.aQU != null && this.aQU.amx() != null && this.aQU.amx().size() > 0) {
            List<com.baidu.tieba.tbadkCore.o> amx = this.aQU.amx();
            Z(amx);
            int size = amx.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.aQA.setVisibility(0);
                this.aQA.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.hr().inflate(this.LH.getPageActivity(), com.baidu.tieba.r.frs_header_enter_lay, null);
                    TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.q.frs_header_enters_icon);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    tbImageView.setDrawerType(1);
                    tbImageView.setRadius(com.baidu.adp.lib.util.n.d(this.LH.getPageActivity(), com.baidu.tieba.o.ds6));
                    tbImageView.c(amx.get(i2).getIcon(), 21, false);
                    ((TextView) linearLayout.findViewById(com.baidu.tieba.q.frs_header_enters_text)).setText(UtilHelper.getFixedText(amx.get(i2).getTitle(), 10));
                    applyNightMode(linearLayout);
                    linearLayout.setTag(amx.get(i2).getUrl());
                    linearLayout.setOnClickListener(this.aRm);
                    this.aQA.addView(linearLayout);
                }
            } else {
                this.aQA.setVisibility(8);
            }
        } else {
            this.aQA.setVisibility(8);
        }
        if (this.aQU != null) {
            this.aQP.a(this.aQU.amq(), this.aQU.aas());
        } else {
            this.aQP.a(null, null);
        }
        this.aQJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aQJ.c(this.mImageUrl, 15, false);
        if (this.aQL != null && this.aQM != null && this.aQM.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.aQM.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.aQM.get(i3).qy());
                iconData.setIcon(this.aQM.get(i3).qx());
                this.aQW = this.aQM.get(i3).qz();
                linkedList.add(iconData);
            }
            this.aQL.setOnClickListener(this.aRn);
            this.aQL.a(linkedList, 2, this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_badge_width), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_badge_height), this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_badge_margin));
        }
        this.aQD.a(this.aQB, this.aQC);
    }

    public void c(View view, boolean z) {
        if (this.aRc != 0 || TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.aQE == null) {
                this.aQE = new PopupWindow(this.LH.getPageActivity());
                this.aQE.setContentView(this.aQF);
                this.aQE.setBackgroundDrawable(new BitmapDrawable());
                this.aQE.setOutsideTouchable(true);
                this.aQE.setFocusable(true);
                this.aQE.setWidth(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_btn_width));
                this.aQE.setHeight(this.LH.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_exp_height));
                this.aQG = (TextView) this.aQF.findViewById(com.baidu.tieba.q.cur_experience);
                this.aQH = (TextView) this.aQF.findViewById(com.baidu.tieba.q.levelup_experience);
                a(this.aQG, this.aQH);
            }
            if (this.aQE.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.aQE, this.LH.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aQG, this.aQH);
            if (iArr[1] - this.aQE.getHeight() <= 50) {
                com.baidu.adp.lib.g.k.a(this.aQE, this.LH.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aQE, this.LG, 0, iArr[0], iArr[1] - this.aQE.getHeight());
            this.aQE.update();
            this.mHandler.postDelayed(this.aRl, 2000L);
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
            if (!TextUtils.isEmpty(this.aQT) && !TextUtils.isEmpty(this.aQT.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aQT);
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

    public void Mh() {
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
        this.aQI.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, this.LG, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aQI.getWidth() / 2), iArr[1] + this.aQI.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aRj = z;
        Bitmap bR = com.baidu.tbadk.core.util.c.bR(com.baidu.tieba.p.bg_frs_signin_bar_down);
        if (bR != null && bR.getWidth() > 0) {
            if (this.aRj) {
                this.aQt.setText(com.baidu.tieba.t.level_up);
                ay.c(this.aQu, com.baidu.tbadk.core.util.c.bU(this.aQX + 1));
            } else {
                this.aQt.setText(this.aQQ);
                ay.c(this.aQu, com.baidu.tbadk.core.util.c.bU(this.aQX));
            }
            if (this.aRj) {
                b(this.LH.getOrignalPage(), this.aQv, this.aRk, f);
            } else {
                a(this.LH.getOrignalPage(), this.aQv, this.aRk, f);
            }
            this.aRk = f;
        }
    }
}
