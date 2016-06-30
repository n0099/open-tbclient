package com.baidu.tieba.frs.entelechy;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
import com.baidu.tieba.frs.view.ForumHeadSdkView;
import com.baidu.tieba.frs.view.ForumMemberIconView;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends b {
    private static final String DEFAULT_BADGE_URL = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected RelativeLayout aLn;
    private ArrayList<TbImageView> bIr = new ArrayList<>();
    private BlurDrawable bIs;
    private Runnable bIt;
    protected String mImageUrl;

    public d(FrsActivity frsActivity, String str, String str2, int i) {
        this.aLn = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bET = frsActivity;
        this.Dp = frsActivity.getPageContext();
        this.bSA = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds20);
        this.bSB = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds72);
        this.bSC = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Do = XD();
        this.aLn = (RelativeLayout) this.Do.findViewById(u.g.container);
        this.aLn.setPadding(0, com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds150), 0, 0);
        this.bTo = (ForumMemberIconView) this.Do.findViewById(u.g.forum_member_icon_layout);
        this.bTo.setVisibility(8);
        this.bTd = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(u.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.Do.setVisibility(8);
        }
        this.bSS = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(u.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.c(this.Dp.getPageActivity(), u.e.ds220), 0, 0);
        this.bSS.setLayoutParams(layoutParams);
        this.bmX = (CoverFlowView) this.Do.findViewById(u.g.nomal_frs_coverflowview);
        this.bSU = (ForumHeadSdkView) this.Do.findViewById(u.g.frs_head_sdk);
        this.bOM = (ForumHeadVideoView) this.Do.findViewById(u.g.frs_head_video_list);
        PV();
        this.bSL = (RelativeLayout) this.Do.findViewById(u.g.btn_love_content);
        this.bTg = (ImageView) this.Do.findViewById(u.g.speed_icon);
        this.bSM = (TextView) this.Do.findViewById(u.g.level_name);
        this.bSN = (ImageView) this.Do.findViewById(u.g.level);
        this.bSO = (ImageView) this.Do.findViewById(u.g.love_level_top);
        this.bSD = (FrameLayout) this.Do.findViewById(u.g.love);
        this.bSE = (Button) this.Do.findViewById(u.g.btn_love);
        this.bSE.setContentDescription(frsActivity.getResources().getString(u.j.attention));
        this.Dk = (TextView) this.Do.findViewById(u.g.tv_love);
        this.bSF = (FrameLayout) this.Do.findViewById(u.g.sign);
        this.bSG = (Button) this.Do.findViewById(u.g.btn_sign);
        this.bSH = (TextView) this.Do.findViewById(u.g.tv_sign);
        this.bSH.setContentDescription(frsActivity.getResources().getString(u.j.sign));
        this.bSI = (ProgressBar) this.Do.findViewById(u.g.sign_progress);
        this.bSJ = (FrameLayout) this.Do.findViewById(u.g.sign_done);
        this.bSK = (TextView) this.Do.findViewById(u.g.sign_done_text);
        this.Dh = (TextView) this.Do.findViewById(u.g.member_num_text);
        this.Di = (TextView) this.Do.findViewById(u.g.post_num_text);
        this.Dj = (TextView) this.Do.findViewById(u.g.title_text);
        this.bTi = (BarImageView) this.Do.findViewById(u.g.frs_image);
        this.bTi.setContentDescription(frsActivity.getResources().getString(u.j.bar_header));
        this.bTi.setGifIconSupport(false);
        this.bTi.setDrawerType(0);
        this.bTj = (UserIconBox) this.Do.findViewById(u.g.frs_badge_box);
        this.bSP = LayoutInflater.from(this.bET.getPageContext().getPageActivity()).inflate(u.h.frs_header_extra_entelechy, (ViewGroup) null);
        Xv();
        this.bSQ = (ViewGroup) this.bSP.findViewById(u.g.frs_header_games);
        this.bSR = (TextView) this.bSP.findViewById(u.g.top_item_title);
        this.bSZ = (LinearLayout) this.bSP.findViewById(u.g.frs_header_enter_root);
        this.bTm = new com.baidu.tieba.frs.view.o(this.Dp, this.bSP);
        this.bTl = new bb(this.Dp);
        this.bSV = (ViewGroup) this.bSP.findViewById(u.g.frs_headline);
        this.bSW = (TextView) this.bSV.findViewById(u.g.headline_title);
        this.bSX = (TextView) this.bSV.findViewById(u.g.headline_text);
        this.bSY = (TbImageView) this.bSV.findViewById(u.g.headline_image);
        this.bSV.setVisibility(8);
        XB();
    }

    private void XB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), dj.class);
        if (runTask != null && runTask.getData() != null) {
            this.bTn = (dj) runTask.getData();
            this.bTn.a(this.Dp, this.Do, 1, false);
            this.bTn.hide();
        }
    }

    private void XC() {
        com.baidu.tbadk.core.data.k baM = this.bJX.baM();
        if (baM != null && this.bJX.aDN() != null) {
            String id = this.bJX.aDN().getId();
            String name = this.bJX.aDN().getName();
            if (this.bTK.add(baM.oH())) {
                a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", baM.oH(), id, name, null);
                a.bM("obj_url", baM.getUrl());
                a.save();
            }
            this.bSV.setVisibility(0);
            this.bSW.setText(baM.getText());
            this.bSX.setText(baM.getTitle());
            this.bSY.c(baM.oG(), 10, false);
            this.bSV.setOnClickListener(new e(this, baM, id, name));
        }
    }

    protected View XD() {
        return LayoutInflater.from(this.bET.getPageContext().getPageActivity()).inflate(u.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bTi.setOnClickListener(onClickListener);
        this.Dj.setOnClickListener(onClickListener);
        this.bSE.setOnClickListener(onClickListener);
        this.bSG.setOnClickListener(onClickListener);
        this.bSJ.setOnClickListener(onClickListener);
        this.bSL.setOnClickListener(onClickListener);
        if (this.bSQ != null) {
            this.bSQ.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.c.e.cT().Z("frs_to_bar_detail") == 0) {
            this.Do.setOnClickListener(new f(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.Dp.getLayoutMode().ad(i == 1);
        this.Dp.getLayoutMode().w(this.Do);
        this.Dp.getLayoutMode().w(this.bTd);
        this.Dp.getLayoutMode().w(this.bSP);
        if (this.bTE) {
            ib(1);
        } else {
            ib(0);
        }
        if (this.bmX != null) {
            this.bmX.se();
        }
        if (this.bSU != null) {
            this.bSU.e(this.Dp, i);
        }
        this.bTi.invalidate();
        av.c(this.bSN, BitmapHelper.getSmallGradeResourceIdNew(this.bTv));
        if (this.bIs != null && this.bIs.getBlurredBitmap() != null && !this.bIs.getBlurredBitmap().isRecycled()) {
            this.aLn.setBackgroundDrawable(new BitmapDrawable(this.bIs.getBlurredBitmap()));
        } else {
            av.l(this.aLn, u.d.cp_bg_line_d);
        }
        XE();
        if (this.bSQ != null) {
            av.k(this.bSQ, u.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            av.c(this.bTg, u.f.icon_sml_speed_orange);
        } else {
            av.c(this.bTg, u.f.icon_sml_speed_gray);
        }
        if (this.bTm != null) {
            this.bTm.changeSkinType(i);
        }
        if (this.bTn != null) {
            this.bTn.changeSkinType(i);
        }
        if (this.bTj != null) {
            this.bTj.cX(i);
        }
        if (this.bTo != null) {
            this.bTo.e(this.Dp, i);
        }
        Iterator<TbImageView> it = this.bIr.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        Xx();
        if (this.bOM != null) {
            this.bOM.onChangeSkinType(this.Dp, i);
        }
        av.k(this.bSV, u.f.home_thread_card_item_bg);
    }

    protected void XE() {
        this.Dk.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bSH.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bTw = forumData.getPost_num();
            this.bTr = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.bTq = forumData.getLevelName();
            this.bTv = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.bTx = forumData.getSignData().count_sign_num;
                this.bTy = forumData.getSignData().miss_sign_num;
            }
            this.bTz = forumData.getCurScore();
            this.bSf = forumData.getLevelupScore();
            this.bTk = forumData.getBadgeData();
            this.bTa = forumData.getTopCode();
            this.bTb = forumData.getNewsInfo();
            this.bTs = forumData.getAccelerateContent();
            this.bTp = forumData.getMemberShowIconData();
            this.bJX = pVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.Do.setVisibility(8);
            } else {
                this.Do.setVisibility(0);
            }
            this.bTt = new az();
            XF();
            XJ();
            XC();
        }
    }

    protected void XF() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.bTt.getMedias().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void XG() {
        if (this.bTy > 0) {
            if (com.baidu.adp.lib.util.k.A(this.Dp.getPageActivity()) >= 480) {
                this.bSK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.bSK, u.d.cp_cont_g, 1);
            this.bSK.setText(String.format(this.Dp.getString(u.j.miss_sign_days), Integer.valueOf(this.bTy)));
        } else {
            this.bSK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.c(this.bSK, u.d.common_color_10061, 1);
            if (this.bTx <= 0) {
                this.bSK.setText(this.Dp.getString(u.j.signed));
            } else {
                this.bSK.setText(String.format(this.Dp.getString(u.j.continuous_sign_days), Integer.valueOf(this.bTx)));
            }
        }
        this.bSJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void XH() {
    }

    protected void XI() {
        a(this.bJX.bao());
    }

    protected void XJ() {
        if (this.bJX != null) {
            XI();
        }
        if (this.bJX != null && this.bJX.baI() != null) {
            a(this.bJX.baI());
        }
        if (this.Dh != null) {
            this.Dh.setText(ba.B(this.mMemberNum));
        }
        if (this.Di != null) {
            this.Di.setText(ba.B(this.bTw));
        }
        if (this.Dj != null) {
            if (this.bTk != null && this.bTk.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.Dj.setText(String.valueOf(this.mForumName) + this.Dp.getString(u.j.forum));
            }
        }
        if (this.bSQ != null && this.bSR != null) {
            if (this.bJX != null && this.bJX.bau()) {
                int dh = com.baidu.tbadk.core.util.n.dh(this.bJX.bax());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dh == 1 && !z) {
                    this.bSQ.setVisibility(8);
                } else {
                    this.bSQ.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bJX.getGameName()) && !TextUtils.isEmpty(this.bJX.getGameName().trim())) {
                        this.bSR.setText(UtilHelper.getFixedText(this.bJX.getGameName(), 10));
                        String pH = com.baidu.tieba.tbadkCore.util.n.pH(this.bJX.bax());
                        if (!StringUtils.isNull(pH)) {
                            TiebaStatic.eventStat(this.Dp.getPageActivity(), "game_show", "show", 1, "dev_id", pH, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bSR.setText(this.Dp.getResources().getString(u.j.frsgame_title));
                    }
                }
            } else {
                this.bSQ.setVisibility(8);
            }
        }
        if (this.bJX != null && this.bJX.bav() != null && this.bJX.bav().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> bav = this.bJX.bav();
            aw(bav);
            int size = bav.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bSZ.setVisibility(0);
                this.bSZ.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar = bav.get(i2);
                    if (hVar != null) {
                        String ja = ja(hVar.ayw());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.Dp.getPageActivity()).inflate(u.h.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(u.g.top_item_title)).setText(hVar.getTitle());
                        ((TextView) viewGroup.findViewById(u.g.top_item_type)).setText(ja);
                        u(viewGroup);
                        viewGroup.setTag(hVar);
                        viewGroup.setOnClickListener(this.bTM);
                        this.bSZ.addView(viewGroup);
                        if (this.bTK.add(hVar.bai())) {
                            a.C0077a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.bai(), this.bET.getForumId(), this.bET.getForumName(), null);
                            a.bM("obj_url", hVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.bSZ.setVisibility(8);
            }
        } else {
            this.bSZ.setVisibility(8);
        }
        if (this.bJX != null) {
            this.bTm.a(this.bJX.ban(), this.bJX.aDN());
        } else {
            this.bTm.a(null, null);
        }
        this.bTi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bTi.c(this.mImageUrl, 15, false);
        if (this.bTi.getBdImage() == null || this.bTi.getBdImage().jb() == null) {
            XK();
        } else {
            if (this.bIt == null) {
                this.bIt = new g(this);
            }
            this.bTi.postDelayed(this.bIt, 50L);
        }
        if (this.bTj != null && this.bTk != null && this.bTk.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bTk.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bTk.get(i3).oE());
                iconData.setIcon(this.bTk.get(i3).oD());
                this.bTu = this.bTk.get(i3).oF();
                linkedList.add(iconData);
            }
            this.bTj.setOnClickListener(this.ael);
            this.bTj.a(linkedList, 2, this.Dp.getResources().getDimensionPixelSize(u.e.ds40), this.Dp.getResources().getDimensionPixelSize(u.e.ds40), this.Dp.getResources().getDimensionPixelSize(u.e.ds14));
        }
        if (this.bTn != null && this.bJX != null) {
            this.bTn.c(this.bJX);
        }
        String icon = this.bTp.getIcon();
        String url = this.bTp.getUrl();
        if (this.bTp != null && this.bTo != null) {
            this.bTo.setIcon(icon);
            this.bTo.setUrl(url);
        }
        XM();
        Xw();
        if (this.bJX != null) {
            c(com.baidu.adp.lib.h.b.c(this.mForumId, 0L), this.bJX.baN());
        }
    }

    protected void XK() {
        this.bTi.setEvent(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XL() {
        if (this.bET != null && this.bET.getActivity() != null) {
            try {
                if (this.bIs == null) {
                    this.bIs = new BlurDrawable(this.bET.getActivity());
                    if (this.bTi != null && this.bTi.getBdImage() != null && this.bTi.getBdImage().jb() != null && !this.bTi.getBdImage().jb().isRecycled()) {
                        this.bIs.init(12, 8, this.bTi.getBdImage().jb());
                    }
                }
                if (this.bIs != null && this.bIs.getBlurredBitmap() == null && this.bIs.drawBlur()) {
                    this.aLn.setBackgroundDrawable(new BitmapDrawable(this.bIs.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String ja(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(u.j.tequan);
        }
        return str;
    }

    private void XM() {
        ViewGroup aaC;
        View aaD;
        View findViewById;
        if (this.bSQ.getVisibility() == 0) {
            View findViewById2 = this.bSQ.findViewById(u.g.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.bSQ.getVisibility() == 8 && this.bSZ.getVisibility() == 0) {
            if (this.bSZ.getChildCount() > 0 && (findViewById = ((ViewGroup) this.bSZ.getChildAt(0)).findViewById(u.g.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.bSZ.getVisibility() == 8 && (aaC = this.bTm.aaC()) != null && aaC.getVisibility() == 0 && (aaD = this.bTm.aaD()) != null) {
            aaD.setVisibility(8);
        } else {
            this.bIq.dR(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bTL);
            if (this.bTc == null) {
                this.bTc = new PopupWindow(this.Dp.getPageActivity());
                this.bTc.setContentView(this.bTd);
                this.bTc.setBackgroundDrawable(new BitmapDrawable());
                this.bTc.setOutsideTouchable(true);
                this.bTc.setFocusable(true);
                this.bTc.setWidth(this.Dp.getResources().getDimensionPixelSize(u.e.ds228));
                this.bTc.setHeight(this.Dp.getResources().getDimensionPixelSize(u.e.ds100));
                this.bTe = (TextView) this.bTd.findViewById(u.g.cur_experience);
                this.bTf = (TextView) this.bTd.findViewById(u.g.levelup_experience);
                a(this.bTe, this.bTf);
            }
            if (this.bTc.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bTc, this.Dp.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bTe, this.bTf);
            if (iArr[1] - this.bTc.getHeight() <= 50) {
                com.baidu.adp.lib.h.j.a(this.bTc, this.Dp.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bTc, this.Do, 0, iArr[0], iArr[1] - this.bTc.getHeight());
            this.bTc.update();
            this.mHandler.postDelayed(this.bTL, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.Dp.getContext()).inflate(u.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(u.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(u.g.speed_tip);
            av.c((TextView) inflate.findViewById(u.g.experience_txt), u.d.cp_cont_b, 1);
            av.c(textView, u.d.cp_cont_b, 1);
            av.c(textView2, u.d.cp_cont_b, 1);
            av.c(textView3, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Dp.getPageActivity());
            aVar.y(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.bTs) && !TextUtils.isEmpty(this.bTs.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bTs);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bN(u.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.Dp);
            aVar.rT();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(u.j.cancel_text, new i(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(u.j.open_now, new j(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void XN() {
        View contentView;
        if (this.bTh == null) {
            this.bTh = new PopupWindow(this.Dp.getPageActivity());
            contentView = LayoutInflater.from(this.Dp.getContext()).inflate(u.h.speed_tip, (ViewGroup) null);
            this.bTh.setContentView(contentView);
            contentView.setOnClickListener(new k(this));
            this.bTh.setWidth(this.Dp.getResources().getDimensionPixelSize(u.e.ds300));
            this.bTh.setHeight(this.Dp.getResources().getDimensionPixelSize(u.e.ds88));
            this.bTh.setBackgroundDrawable(new BitmapDrawable());
            this.bTh.setOutsideTouchable(true);
            this.bTh.setTouchInterceptor(new l(this));
        } else {
            contentView = this.bTh.getContentView();
        }
        this.Dp.getLayoutMode().w(contentView);
        int[] iArr = new int[2];
        this.bTg.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bTh, this.Do, 0, (iArr[0] - (this.bTh.getWidth() / 2)) + (this.bTg.getWidth() / 2), iArr[1] + this.bTg.getWidth());
        this.bTh.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(boolean z, float f) {
        int i;
        this.bTF = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(u.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.bTF) {
                this.bSM.setText(u.j.level_up);
                if (f >= 1.0f) {
                    i = this.bTv;
                } else {
                    i = this.bTv + 1;
                }
                com.baidu.tieba.tbadkCore.p VC = this.bET.VC();
                if (VC != null && VC.aDN() != null) {
                    VC.aDN().setUser_level(i);
                }
                av.c(this.bSN, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bSM.setText(this.bTq);
                av.c(this.bSN, BitmapHelper.getSmallGradeResourceIdNew(this.bTv));
            }
            this.bSO.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, hy(this.bTv)));
            if (this.bTF) {
                if (f >= 1.0f) {
                    a(this.Dp.getOrignalPage(), this.bSO, this.bTG, f);
                } else {
                    b(this.Dp.getOrignalPage(), this.bSO, this.bTG, f);
                }
            } else {
                a(this.Dp.getOrignalPage(), this.bSO, this.bTG, f);
            }
            this.bTG = f;
        }
    }

    private int[] hy(int i) {
        if (i <= 3) {
            return new int[]{-8331843, -10499102};
        }
        if (i <= 9) {
            return new int[]{-10499102, -154262};
        }
        if (i <= 15) {
            return new int[]{-154262, -148180};
        }
        return new int[]{-148180, -100818};
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void XO() {
        this.bTl.c(this.bSD, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void XP() {
        if (this.mMemberType != 0) {
            av.c(this.bTg, u.f.icon_sml_speed_orange);
        } else {
            av.c(this.bTg, u.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        if (this.bIs != null) {
            this.bIs.onDestroy();
        }
        if (this.bOM != null) {
            this.bOM.onDestory();
        }
        if (this.bTi != null) {
            this.bTi.removeCallbacks(this.bIt);
        }
    }
}
