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
import com.baidu.tbadk.core.data.be;
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
public class e extends b {
    private static final String DEFAULT_BADGE_URL = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected RelativeLayout aMh;
    private ArrayList<TbImageView> bJV = new ArrayList<>();
    private BlurDrawable bJW;
    private Runnable bJX;
    protected String mImageUrl;

    public e(FrsActivity frsActivity, String str, String str2, int i) {
        this.aMh = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bGh = frsActivity;
        this.DQ = frsActivity.getPageContext();
        this.bUA = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds20);
        this.bUB = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds72);
        this.bUC = com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.DP = XW();
        this.aMh = (RelativeLayout) this.DP.findViewById(u.g.container);
        this.aMh.setPadding(0, com.baidu.adp.lib.util.k.c(frsActivity.getPageContext().getPageActivity(), u.e.ds150), 0, 0);
        this.bVo = (ForumMemberIconView) this.DP.findViewById(u.g.forum_member_icon_layout);
        this.bVo.setVisibility(8);
        this.bVd = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(u.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.DP.setVisibility(8);
        }
        this.bUS = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(u.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.c(this.DQ.getPageActivity(), u.e.ds220), 0, 0);
        this.bUS.setLayoutParams(layoutParams);
        this.boF = (CoverFlowView) this.DP.findViewById(u.g.nomal_frs_coverflowview);
        this.bUU = (ForumHeadSdkView) this.DP.findViewById(u.g.frs_head_sdk);
        this.bQy = (ForumHeadVideoView) this.DP.findViewById(u.g.frs_head_video_list);
        Qz();
        this.bUL = (RelativeLayout) this.DP.findViewById(u.g.btn_love_content);
        this.bVg = (ImageView) this.DP.findViewById(u.g.speed_icon);
        this.bUM = (TextView) this.DP.findViewById(u.g.level_name);
        this.bUN = (ImageView) this.DP.findViewById(u.g.level);
        this.bUO = (ImageView) this.DP.findViewById(u.g.love_level_top);
        this.bUD = (FrameLayout) this.DP.findViewById(u.g.love);
        this.bUE = (Button) this.DP.findViewById(u.g.btn_love);
        this.bUE.setContentDescription(frsActivity.getResources().getString(u.j.attention));
        this.DL = (TextView) this.DP.findViewById(u.g.tv_love);
        this.bUF = (FrameLayout) this.DP.findViewById(u.g.sign);
        this.bUG = (Button) this.DP.findViewById(u.g.btn_sign);
        this.bUH = (TextView) this.DP.findViewById(u.g.tv_sign);
        this.bUH.setContentDescription(frsActivity.getResources().getString(u.j.sign));
        this.bUI = (ProgressBar) this.DP.findViewById(u.g.sign_progress);
        this.bUJ = (FrameLayout) this.DP.findViewById(u.g.sign_done);
        this.bUK = (TextView) this.DP.findViewById(u.g.sign_done_text);
        this.DI = (TextView) this.DP.findViewById(u.g.member_num_text);
        this.DJ = (TextView) this.DP.findViewById(u.g.post_num_text);
        this.DK = (TextView) this.DP.findViewById(u.g.title_text);
        this.bVi = (BarImageView) this.DP.findViewById(u.g.frs_image);
        this.bVi.setContentDescription(frsActivity.getResources().getString(u.j.bar_header));
        this.bVi.setGifIconSupport(false);
        this.bVi.setDrawerType(0);
        this.bVj = (UserIconBox) this.DP.findViewById(u.g.frs_badge_box);
        this.bUP = LayoutInflater.from(this.bGh.getPageContext().getPageActivity()).inflate(u.h.frs_header_extra_entelechy, (ViewGroup) null);
        XN();
        this.bUQ = (ViewGroup) this.bUP.findViewById(u.g.frs_header_games);
        this.bUR = (TextView) this.bUP.findViewById(u.g.top_item_title);
        this.bUZ = (LinearLayout) this.bUP.findViewById(u.g.frs_header_enter_root);
        this.bVm = new com.baidu.tieba.frs.view.o(this.DQ, this.bUP);
        this.bVl = new bb(this.DQ);
        this.bUV = (ViewGroup) this.bUP.findViewById(u.g.frs_headline);
        this.bUW = (TextView) this.bUV.findViewById(u.g.headline_title);
        this.bUX = (TextView) this.bUV.findViewById(u.g.headline_text);
        this.bUY = (TbImageView) this.bUV.findViewById(u.g.headline_image);
        this.bUV.setVisibility(8);
        XU();
    }

    private void XU() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), dj.class);
        if (runTask != null && runTask.getData() != null) {
            this.bVn = (dj) runTask.getData();
            this.bVn.a(this.DQ, this.DP, 1, false);
            this.bVn.hide();
        }
    }

    private void XV() {
        com.baidu.tbadk.core.data.l bea = this.bLD.bea();
        if (bea != null && this.bLD.aGX() != null) {
            String id = this.bLD.aGX().getId();
            String name = this.bLD.aGX().getName();
            if (this.bVK.add(bea.ow())) {
                a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bea.ow(), id, name, null);
                a.bR("obj_url", bea.getUrl());
                a.save();
            }
            this.bUV.setVisibility(0);
            this.bUW.setText(bea.getText());
            this.bUX.setText(bea.getTitle());
            this.bUY.c(bea.ov(), 10, false);
            this.bUV.setOnClickListener(new f(this, bea, id, name));
        }
    }

    protected View XW() {
        return LayoutInflater.from(this.bGh.getPageContext().getPageActivity()).inflate(u.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bVi.setOnClickListener(onClickListener);
        this.DK.setOnClickListener(onClickListener);
        this.bUE.setOnClickListener(onClickListener);
        this.bUG.setOnClickListener(onClickListener);
        this.bUJ.setOnClickListener(onClickListener);
        this.bUL.setOnClickListener(onClickListener);
        if (this.bUQ != null) {
            this.bUQ.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.c.e.cS().ab("frs_to_bar_detail") == 0) {
            this.DP.setOnClickListener(new g(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.DQ.getLayoutMode().af(i == 1);
        this.DQ.getLayoutMode().w(this.DP);
        this.DQ.getLayoutMode().w(this.bVd);
        this.DQ.getLayoutMode().w(this.bUP);
        if (this.bVE) {
            ic(1);
        } else {
            ic(0);
        }
        if (this.boF != null) {
            this.boF.sd();
        }
        if (this.bUU != null) {
            this.bUU.e(this.DQ, i);
        }
        this.bVi.invalidate();
        av.c(this.bUN, BitmapHelper.getSmallGradeResourceIdNew(this.bVv));
        if (this.bJW != null && this.bJW.getBlurredBitmap() != null && !this.bJW.getBlurredBitmap().isRecycled()) {
            this.aMh.setBackgroundDrawable(new BitmapDrawable(this.bJW.getBlurredBitmap()));
        } else {
            av.l(this.aMh, u.d.cp_bg_line_d);
        }
        XX();
        if (this.bUQ != null) {
            av.k(this.bUQ, u.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            av.c(this.bVg, u.f.icon_sml_speed_orange);
        } else {
            av.c(this.bVg, u.f.icon_sml_speed_gray);
        }
        if (this.bVm != null) {
            this.bVm.changeSkinType(i);
        }
        if (this.bVn != null) {
            this.bVn.changeSkinType(i);
        }
        if (this.bVj != null) {
            this.bVj.cX(i);
        }
        if (this.bVo != null) {
            this.bVo.e(this.DQ, i);
        }
        Iterator<TbImageView> it = this.bJV.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        XP();
        if (this.bQy != null) {
            this.bQy.onChangeSkinType(this.DQ, i);
        }
        av.k(this.bUV, u.f.home_thread_card_item_bg);
        if (this.bJO != null) {
            com.baidu.tbadk.j.a.a(this.bGh.getPageContext(), this.bJO);
        }
    }

    protected void XX() {
        this.DL.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bUH.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bVw = forumData.getPost_num();
            this.bVr = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.bVq = forumData.getLevelName();
            this.bVv = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.bVx = forumData.getSignData().count_sign_num;
                this.bVy = forumData.getSignData().miss_sign_num;
            }
            this.bVz = forumData.getCurScore();
            this.bUf = forumData.getLevelupScore();
            this.bVk = forumData.getBadgeData();
            this.bVa = forumData.getTopCode();
            this.bVb = forumData.getNewsInfo();
            this.bVs = forumData.getAccelerateContent();
            this.bVp = forumData.getMemberShowIconData();
            this.bLD = pVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.DP.setVisibility(8);
            } else {
                this.DP.setVisibility(0);
            }
            this.bVt = new be();
            XY();
            Yc();
            XV();
        }
    }

    protected void XY() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.bVt.qF().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void XZ() {
        if (this.bVy > 0) {
            if (com.baidu.adp.lib.util.k.A(this.DQ.getPageActivity()) >= 480) {
                this.bUK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.bUK, u.d.cp_cont_g, 1);
            this.bUK.setText(String.format(this.DQ.getString(u.j.miss_sign_days), Integer.valueOf(this.bVy)));
        } else {
            this.bUK.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.c(this.bUK, u.d.common_color_10061, 1);
            if (this.bVx <= 0) {
                this.bUK.setText(this.DQ.getString(u.j.signed));
            } else {
                this.bUK.setText(String.format(this.DQ.getString(u.j.continuous_sign_days), Integer.valueOf(this.bVx)));
            }
        }
        this.bUJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void Ya() {
    }

    protected void Yb() {
        a(this.bLD.bdC());
    }

    protected void Yc() {
        if (this.bLD != null) {
            Yb();
        }
        if (this.bLD != null && this.bLD.bdW() != null) {
            a(this.bLD.bdW());
        }
        if (this.DI != null) {
            this.DI.setText(ba.w(this.mMemberNum));
        }
        if (this.DJ != null) {
            this.DJ.setText(ba.w(this.bVw));
        }
        if (this.DK != null) {
            if (this.bVk != null && this.bVk.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.DK.setText(String.valueOf(this.mForumName) + this.DQ.getString(u.j.forum));
            }
        }
        if (this.bUQ != null && this.bUR != null) {
            if (this.bLD != null && this.bLD.bdI()) {
                int dg = com.baidu.tbadk.core.util.n.dg(this.bLD.bdL());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dg == 1 && !z) {
                    this.bUQ.setVisibility(8);
                } else {
                    this.bUQ.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bLD.getGameName()) && !TextUtils.isEmpty(this.bLD.getGameName().trim())) {
                        this.bUR.setText(UtilHelper.getFixedText(this.bLD.getGameName(), 10));
                        String qr = com.baidu.tieba.tbadkCore.util.n.qr(this.bLD.bdL());
                        if (!StringUtils.isNull(qr)) {
                            TiebaStatic.eventStat(this.DQ.getPageActivity(), "game_show", "show", 1, "dev_id", qr, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bUR.setText(this.DQ.getResources().getString(u.j.frsgame_title));
                    }
                }
            } else {
                this.bUQ.setVisibility(8);
            }
        }
        if (this.bLD != null && this.bLD.bdJ() != null && this.bLD.bdJ().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> bdJ = this.bLD.bdJ();
            aA(bdJ);
            int size = bdJ.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bUZ.setVisibility(0);
                this.bUZ.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar = bdJ.get(i2);
                    if (hVar != null) {
                        String jg = jg(hVar.azz());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.DQ.getPageActivity()).inflate(u.h.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(u.g.top_item_title)).setText(hVar.getTitle());
                        ((TextView) viewGroup.findViewById(u.g.top_item_type)).setText(jg);
                        u(viewGroup);
                        viewGroup.setTag(hVar);
                        viewGroup.setOnClickListener(this.bVM);
                        this.bUZ.addView(viewGroup);
                        if (this.bVK.add(hVar.bdw())) {
                            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.bdw(), this.bGh.getForumId(), this.bGh.getForumName(), null);
                            a.bR("obj_url", hVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.bUZ.setVisibility(8);
            }
        } else {
            this.bUZ.setVisibility(8);
        }
        if (this.bLD != null) {
            this.bVm.a(this.bLD.bdB(), this.bLD.aGX());
        } else {
            this.bVm.a(null, null);
        }
        this.bVi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bVi.c(this.mImageUrl, 15, false);
        if (this.bVi.getBdImage() == null || this.bVi.getBdImage().ja() == null) {
            Yd();
        } else {
            if (this.bJX == null) {
                this.bJX = new h(this);
            }
            this.bVi.postDelayed(this.bJX, 50L);
        }
        if (this.bVj != null && this.bVk != null && this.bVk.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.bVk.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.bVk.get(i3).ot());
                iconData.setIcon(this.bVk.get(i3).os());
                this.bVu = this.bVk.get(i3).ou();
                linkedList.add(iconData);
            }
            this.bVj.setOnClickListener(this.aeZ);
            this.bVj.a(linkedList, 2, this.DQ.getResources().getDimensionPixelSize(u.e.ds40), this.DQ.getResources().getDimensionPixelSize(u.e.ds40), this.DQ.getResources().getDimensionPixelSize(u.e.ds14));
        }
        if (this.bVn != null && this.bLD != null) {
            this.bVn.c(this.bLD);
        }
        String icon = this.bVp.getIcon();
        String url = this.bVp.getUrl();
        if (this.bVp != null && this.bVo != null) {
            this.bVo.setIcon(icon);
            this.bVo.setUrl(url);
        }
        Yf();
        XO();
        XR();
        if (this.bLD != null) {
            c(com.baidu.adp.lib.h.b.c(this.mForumId, 0L), this.bLD.beb());
        }
    }

    protected void Yd() {
        this.bVi.setEvent(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ye() {
        if (this.bGh != null && this.bGh.getActivity() != null) {
            try {
                if (this.bJW == null) {
                    this.bJW = new BlurDrawable(this.bGh.getActivity());
                    if (this.bVi != null && this.bVi.getBdImage() != null && this.bVi.getBdImage().ja() != null && !this.bVi.getBdImage().ja().isRecycled()) {
                        this.bJW.init(12, 8, this.bVi.getBdImage().ja());
                    }
                }
                if (this.bJW != null && this.bJW.getBlurredBitmap() == null && this.bJW.drawBlur()) {
                    this.aMh.setBackgroundDrawable(new BitmapDrawable(this.bJW.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String jg(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m10getInst().getString(u.j.tequan);
        }
        return str;
    }

    private void Yf() {
        ViewGroup abe;
        View abf;
        View findViewById;
        if (this.bUQ.getVisibility() == 0) {
            View findViewById2 = this.bUQ.findViewById(u.g.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.bUQ.getVisibility() == 8 && this.bUZ.getVisibility() == 0) {
            if (this.bUZ.getChildCount() > 0 && (findViewById = ((ViewGroup) this.bUZ.getChildAt(0)).findViewById(u.g.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.bUZ.getVisibility() == 8 && (abe = this.bVm.abe()) != null && abe.getVisibility() == 0 && (abf = this.bVm.abf()) != null) {
            abf.setVisibility(8);
        } else {
            this.bJL.dR(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void d(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m10getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bVL);
            if (this.bVc == null) {
                this.bVc = new PopupWindow(this.DQ.getPageActivity());
                this.bVc.setContentView(this.bVd);
                this.bVc.setBackgroundDrawable(new BitmapDrawable());
                this.bVc.setOutsideTouchable(true);
                this.bVc.setFocusable(true);
                this.bVc.setWidth(this.DQ.getResources().getDimensionPixelSize(u.e.ds228));
                this.bVc.setHeight(this.DQ.getResources().getDimensionPixelSize(u.e.ds100));
                this.bVe = (TextView) this.bVd.findViewById(u.g.cur_experience);
                this.bVf = (TextView) this.bVd.findViewById(u.g.levelup_experience);
                a(this.bVe, this.bVf);
            }
            if (this.bVc.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bVc, this.DQ.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bVe, this.bVf);
            if (iArr[1] - this.bVc.getHeight() <= 50) {
                com.baidu.adp.lib.h.j.a(this.bVc, this.DQ.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bVc, this.DP, 0, iArr[0], iArr[1] - this.bVc.getHeight());
            this.bVc.update();
            this.mHandler.postDelayed(this.bVL, 2000L);
        } else if (TbadkCoreApplication.m10getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.DQ.getContext()).inflate(u.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(u.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(u.g.speed_tip);
            av.c((TextView) inflate.findViewById(u.g.experience_txt), u.d.cp_cont_b, 1);
            av.c(textView, u.d.cp_cont_b, 1);
            av.c(textView2, u.d.cp_cont_b, 1);
            av.c(textView3, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.DQ.getPageActivity());
            aVar.y(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.bVs) && !TextUtils.isEmpty(this.bVs.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bVs);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bN(u.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.DQ);
            aVar.rS();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(u.j.cancel_text, new j(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(u.j.open_now, new k(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Yg() {
        View contentView;
        if (this.bVh == null) {
            this.bVh = new PopupWindow(this.DQ.getPageActivity());
            contentView = LayoutInflater.from(this.DQ.getContext()).inflate(u.h.speed_tip, (ViewGroup) null);
            this.bVh.setContentView(contentView);
            contentView.setOnClickListener(new l(this));
            this.bVh.setWidth(this.DQ.getResources().getDimensionPixelSize(u.e.ds300));
            this.bVh.setHeight(this.DQ.getResources().getDimensionPixelSize(u.e.ds88));
            this.bVh.setBackgroundDrawable(new BitmapDrawable());
            this.bVh.setOutsideTouchable(true);
            this.bVh.setTouchInterceptor(new m(this));
        } else {
            contentView = this.bVh.getContentView();
        }
        this.DQ.getLayoutMode().w(contentView);
        int[] iArr = new int[2];
        this.bVg.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bVh, this.DP, 0, (iArr[0] - (this.bVh.getWidth() / 2)) + (this.bVg.getWidth() / 2), iArr[1] + this.bVg.getWidth());
        this.bVh.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(boolean z, float f) {
        int i;
        this.bVF = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(u.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.bVF) {
                this.bUM.setText(u.j.level_up);
                if (f >= 1.0f) {
                    i = this.bVv;
                } else {
                    i = this.bVv + 1;
                }
                com.baidu.tieba.tbadkCore.p VU = this.bGh.VU();
                if (VU != null && VU.aGX() != null) {
                    VU.aGX().setUser_level(i);
                }
                av.c(this.bUN, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bUM.setText(this.bVq);
                av.c(this.bUN, BitmapHelper.getSmallGradeResourceIdNew(this.bVv));
            }
            this.bUO.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, hx(this.bVv)));
            if (this.bVF) {
                if (f >= 1.0f) {
                    a(this.DQ.getOrignalPage(), this.bUO, this.bVG, f);
                } else {
                    b(this.DQ.getOrignalPage(), this.bUO, this.bVG, f);
                }
            } else {
                a(this.DQ.getOrignalPage(), this.bUO, this.bVG, f);
            }
            this.bVG = f;
        }
    }

    private int[] hx(int i) {
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
    protected void Yh() {
        this.bVl.c(this.bUD, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void Yi() {
        if (this.mMemberType != 0) {
            av.c(this.bVg, u.f.icon_sml_speed_orange);
        } else {
            av.c(this.bVg, u.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        if (this.bJW != null) {
            this.bJW.onDestroy();
        }
        if (this.bQy != null) {
            this.bQy.onDestory();
        }
        if (this.bVi != null) {
            this.bVi.removeCallbacks(this.bJX);
        }
    }
}
