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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
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
import com.baidu.tieba.frs.df;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
import com.baidu.tieba.frs.view.ForumHeadSdkView;
import com.baidu.tieba.frs.view.ForumMemberIconView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends g {
    private static final String DEFAULT_BADGE_URL = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected RelativeLayout aRB;
    private BlurDrawable bVk;
    protected Runnable bVl;
    protected String mImageUrl;
    private CustomMessageListener bVm = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bVj = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aRB = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bRp = frsActivity;
        this.Gd = frsActivity.getPageContext();
        this.cfI = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), t.e.ds20);
        this.cfJ = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), t.e.ds72);
        this.cfK = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), t.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Gc = acy();
        this.aRB = (RelativeLayout) this.Gc.findViewById(t.g.container);
        this.aRB.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), t.e.ds150), 0, 0);
        this.cgx = (ForumMemberIconView) this.Gc.findViewById(t.g.forum_member_icon_layout);
        this.cgx.setVisibility(8);
        this.cgm = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(t.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.Gc.setVisibility(8);
        }
        this.cgb = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(t.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), t.e.ds220), 0, 0);
        this.cgb.setLayoutParams(layoutParams);
        this.bzS = (CoverFlowView) this.Gc.findViewById(t.g.nomal_frs_coverflowview);
        this.cgd = (ForumHeadSdkView) this.Gc.findViewById(t.g.frs_head_sdk);
        this.cbG = (ForumHeadVideoView) this.Gc.findViewById(t.g.frs_head_video_list);
        Vl();
        this.cfT = (RelativeLayout) this.Gc.findViewById(t.g.btn_love_content);
        this.cgp = (ImageView) this.Gc.findViewById(t.g.speed_icon);
        this.cfU = (TextView) this.Gc.findViewById(t.g.level_name);
        this.cfV = (ImageView) this.Gc.findViewById(t.g.level);
        this.cfW = (ImageView) this.Gc.findViewById(t.g.love_level_top);
        this.cfL = (FrameLayout) this.Gc.findViewById(t.g.love);
        this.cfM = (Button) this.Gc.findViewById(t.g.btn_love);
        this.cfM.setContentDescription(frsActivity.getResources().getString(t.j.attention));
        this.FY = (TextView) this.Gc.findViewById(t.g.tv_love);
        this.cfN = (FrameLayout) this.Gc.findViewById(t.g.sign);
        this.cfO = (Button) this.Gc.findViewById(t.g.btn_sign);
        this.cfP = (TextView) this.Gc.findViewById(t.g.tv_sign);
        this.cfP.setContentDescription(frsActivity.getResources().getString(t.j.sign));
        this.cfQ = (ProgressBar) this.Gc.findViewById(t.g.sign_progress);
        this.cfR = (FrameLayout) this.Gc.findViewById(t.g.sign_done);
        this.cfS = (TextView) this.Gc.findViewById(t.g.sign_done_text);
        this.FV = (TextView) this.Gc.findViewById(t.g.member_num_text);
        this.FW = (TextView) this.Gc.findViewById(t.g.post_num_text);
        this.FX = (TextView) this.Gc.findViewById(t.g.title_text);
        this.cgr = (BarImageView) this.Gc.findViewById(t.g.frs_image);
        this.cgr.setContentDescription(frsActivity.getResources().getString(t.j.bar_header));
        this.cgr.setGifIconSupport(false);
        this.cgr.setDrawerType(0);
        this.cgs = (UserIconBox) this.Gc.findViewById(t.g.frs_badge_box);
        this.cfX = LayoutInflater.from(this.bRp.getPageContext().getPageActivity()).inflate(t.h.frs_header_extra_entelechy, (ViewGroup) null);
        acC();
        this.cfY = (ViewGroup) this.cfX.findViewById(t.g.frs_header_games);
        this.cfZ = (TextView) this.cfX.findViewById(t.g.top_item_title);
        this.cgi = (LinearLayout) this.cfX.findViewById(t.g.frs_header_enter_root);
        this.cgv = new com.baidu.tieba.frs.view.o(this.Gd, this.cfX);
        this.cgu = new bb(this.Gd);
        this.cge = (ViewGroup) this.cfX.findViewById(t.g.frs_headline);
        this.cgf = (TextView) this.cge.findViewById(t.g.headline_title);
        this.cgg = (TextView) this.cge.findViewById(t.g.headline_text);
        this.cgh = (TbImageView) this.cge.findViewById(t.g.headline_image);
        this.cge.setVisibility(8);
        acJ();
        MessageManager.getInstance().registerListener(this.bVm);
    }

    private void acJ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), df.class);
        if (runTask != null && runTask.getData() != null) {
            this.cgw = (df) runTask.getData();
            this.cgw.a(this.Gd, this.Gc, 1, false);
            this.cgw.hide();
        }
    }

    private void acK() {
        com.baidu.tbadk.core.data.l bhF = this.bWN.bhF();
        if (bhF != null && this.bWN.aLP() != null) {
            String id = this.bWN.aLP().getId();
            String name = this.bWN.aLP().getName();
            if (this.cgU.add(bhF.ps())) {
                a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bhF.ps(), id, name, null);
                a.bS("obj_url", bhF.getUrl());
                a.save();
            }
            this.cge.setVisibility(0);
            this.cgf.setText(bhF.getText());
            this.cgg.setText(bhF.getTitle());
            this.cgh.c(bhF.pr(), 10, false);
            this.cge.setOnClickListener(new l(this, bhF, id, name));
        }
    }

    protected View acy() {
        return LayoutInflater.from(this.bRp.getPageContext().getPageActivity()).inflate(t.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cgr.setOnClickListener(onClickListener);
        this.FX.setOnClickListener(onClickListener);
        this.cfM.setOnClickListener(onClickListener);
        this.cfO.setOnClickListener(onClickListener);
        this.cfR.setOnClickListener(onClickListener);
        this.cfT.setOnClickListener(onClickListener);
        if (this.cfY != null) {
            this.cfY.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.c.e.dN().ac("frs_to_bar_detail") == 0) {
            this.Gc.setOnClickListener(new m(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.Gd.getLayoutMode().ah(i == 1);
        this.Gd.getLayoutMode().x(this.Gc);
        this.Gd.getLayoutMode().x(this.cgm);
        this.Gd.getLayoutMode().x(this.cfX);
        if (this.cgN) {
            iE(1);
        } else {
            iE(0);
        }
        if (this.bzS != null) {
            this.bzS.ti();
        }
        if (this.cgd != null) {
            this.cgd.d(this.Gd, i);
        }
        this.cgr.invalidate();
        av.c(this.cfV, BitmapHelper.getSmallGradeResourceIdNew(this.cgE));
        if (this.bVk != null && this.bVk.getBlurredBitmap() != null && !this.bVk.getBlurredBitmap().isRecycled()) {
            this.aRB.setBackgroundDrawable(new BitmapDrawable(this.bVk.getBlurredBitmap()));
        } else {
            av.l(this.aRB, t.d.cp_bg_line_d);
        }
        acL();
        if (this.cfY != null) {
            av.k(this.cfY, t.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            av.c(this.cgp, t.f.icon_sml_speed_orange);
        } else {
            av.c(this.cgp, t.f.icon_sml_speed_gray);
        }
        if (this.cgv != null) {
            this.cgv.changeSkinType(i);
        }
        if (this.cgw != null) {
            this.cgw.changeSkinType(i);
        }
        if (this.cgs != null) {
            this.cgs.dl(i);
        }
        if (this.cgx != null) {
            this.cgx.d(this.Gd, i);
        }
        Iterator<TbImageView> it = this.bVj.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        acE();
        if (this.cbG != null) {
            this.cbG.onChangeSkinType(this.Gd, i);
        }
        av.k(this.cge, t.f.home_thread_card_item_bg);
        if (this.bVc != null) {
            com.baidu.tbadk.j.a.a(this.bRp.getPageContext(), this.bVc);
        }
    }

    protected void acL() {
        this.FY.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.cfP.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cgF = forumData.getPost_num();
            this.cgA = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.cgz = forumData.getLevelName();
            this.cgE = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cgG = forumData.getSignData().count_sign_num;
                this.cgH = forumData.getSignData().miss_sign_num;
            }
            this.cgI = forumData.getCurScore();
            this.cfn = forumData.getLevelupScore();
            this.cgt = forumData.getBadgeData();
            this.cgj = forumData.getTopCode();
            this.cgk = forumData.getNewsInfo();
            this.cgB = forumData.getAccelerateContent();
            this.cgy = forumData.getMemberShowIconData();
            this.bWN = pVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.Gc.setVisibility(8);
            } else {
                this.Gc.setVisibility(0);
            }
            this.cgC = new bg();
            acM();
            acz();
            acK();
        }
    }

    protected void acM() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.cgC.rK().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void acN() {
        if (this.cgH > 0) {
            if (com.baidu.adp.lib.util.k.K(this.Gd.getPageActivity()) >= 480) {
                this.cfS.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.cfS, t.d.cp_cont_i, 1);
            this.cfS.setText(String.format(this.Gd.getString(t.j.miss_sign_days), Integer.valueOf(this.cgH)));
        } else {
            this.cfS.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.c(this.cfS, t.d.common_color_10061, 1);
            if (this.cgG <= 0) {
                this.cfS.setText(this.Gd.getString(t.j.signed));
            } else {
                this.cfS.setText(String.format(this.Gd.getString(t.j.continuous_sign_days), Integer.valueOf(this.cgG)));
            }
        }
        this.cfR.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void acO() {
    }

    protected void acP() {
        a(this.bWN.bhg());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acz() {
        if (this.bWN != null) {
            acP();
        }
        if (this.bWN != null && this.bWN.bhA() != null) {
            a(this.bWN.bhA());
        }
        if (this.FV != null) {
            this.FV.setText(ba.w(this.mMemberNum));
        }
        if (this.FW != null) {
            this.FW.setText(ba.w(this.cgF));
        }
        if (this.FX != null) {
            if (this.cgt != null && this.cgt.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.FX.setText(String.valueOf(this.mForumName) + this.Gd.getString(t.j.forum));
            }
        }
        if (this.cfY != null && this.cfZ != null) {
            if (this.bWN != null && this.bWN.bhm()) {
                int dj = com.baidu.tbadk.core.util.n.dj(this.bWN.bhp());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dj == 1 && !z) {
                    this.cfY.setVisibility(8);
                } else {
                    this.cfY.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bWN.getGameName()) && !TextUtils.isEmpty(this.bWN.getGameName().trim())) {
                        this.cfZ.setText(UtilHelper.getFixedText(this.bWN.getGameName(), 10));
                        String rb = com.baidu.tieba.tbadkCore.util.n.rb(this.bWN.bhp());
                        if (!StringUtils.isNull(rb)) {
                            TiebaStatic.eventStat(this.Gd.getPageActivity(), "game_show", "show", 1, "dev_id", rb, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cfZ.setText(this.Gd.getResources().getString(t.j.frsgame_title));
                    }
                }
            } else {
                this.cfY.setVisibility(8);
            }
        }
        if (this.bWN != null && this.bWN.bhn() != null && this.bWN.bhn().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> bhn = this.bWN.bhn();
            aC(bhn);
            int size = bhn.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.cgi.setVisibility(0);
                this.cgi.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar = bhn.get(i2);
                    if (hVar != null) {
                        String jP = jP(hVar.aEn());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.Gd.getPageActivity()).inflate(t.h.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(t.g.top_item_title)).setText(hVar.getTitle());
                        ((TextView) viewGroup.findViewById(t.g.top_item_type)).setText(jP);
                        u(viewGroup);
                        viewGroup.setTag(hVar);
                        viewGroup.setOnClickListener(this.cgW);
                        this.cgi.addView(viewGroup);
                        if (this.cgU.add(hVar.bha())) {
                            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.bha(), this.bRp.getForumId(), this.bRp.getForumName(), null);
                            a.bS("obj_url", hVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.cgi.setVisibility(8);
            }
        } else {
            this.cgi.setVisibility(8);
        }
        if (this.bWN != null) {
            this.cgv.a(this.bWN.bhf(), this.bWN.aLP());
        } else {
            this.cgv.a(null, null);
        }
        acA();
        if (this.cgs != null && this.cgt != null && this.cgt.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.cgt.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.cgt.get(i3).pp());
                iconData.setIcon(this.cgt.get(i3).po());
                this.cgD = this.cgt.get(i3).pq();
                linkedList.add(iconData);
            }
            this.cgs.setOnClickListener(this.ahU);
            this.cgs.a(linkedList, 2, this.Gd.getResources().getDimensionPixelSize(t.e.ds40), this.Gd.getResources().getDimensionPixelSize(t.e.ds40), this.Gd.getResources().getDimensionPixelSize(t.e.ds14));
        }
        if (this.cgw != null && this.bWN != null) {
            this.cgw.c(this.bWN);
        }
        String icon = this.cgy.getIcon();
        String url = this.cgy.getUrl();
        if (this.cgy != null && this.cgx != null) {
            this.cgx.setIcon(icon);
            this.cgx.setUrl(url);
        }
        acB();
        acD();
        acG();
        if (this.bWN != null) {
            c(com.baidu.adp.lib.h.b.c(this.mForumId, 0L), this.bWN.bhG());
        }
    }

    protected void acA() {
        this.cgr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cgr.c(this.mImageUrl, 15, false);
        if (this.cgr.getBdImage() == null || this.cgr.getBdImage().jV() == null) {
            acQ();
            return;
        }
        if (this.bVl == null) {
            this.bVl = new n(this);
        }
        this.cgr.postDelayed(this.bVl, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acQ() {
        this.cgr.setEvent(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acR() {
        if (this.bRp != null && this.bRp.getActivity() != null) {
            try {
                if (this.bVk == null) {
                    this.bVk = new BlurDrawable(this.bRp.getActivity());
                    if (this.cgr != null && this.cgr.getBdImage() != null && this.cgr.getBdImage().jV() != null && !this.cgr.getBdImage().jV().isRecycled()) {
                        this.bVk.init(12, 8, this.cgr.getBdImage().jV());
                    }
                }
                if (this.bVk != null && this.bVk.getBlurredBitmap() == null && this.bVk.drawBlur()) {
                    this.aRB.setBackgroundDrawable(new BitmapDrawable(this.bVk.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String jP(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(t.j.tequan);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acB() {
        ViewGroup afP;
        View afQ;
        View findViewById;
        this.bUZ.en(false);
        if (this.cfY.getVisibility() == 0) {
            View findViewById2 = this.cfY.findViewById(t.g.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.cfY.getVisibility() == 8 && this.cgi.getVisibility() == 0) {
            if (this.cgi.getChildCount() > 0 && (findViewById = ((ViewGroup) this.cgi.getChildAt(0)).findViewById(t.g.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.cgi.getVisibility() == 8 && (afP = this.cgv.afP()) != null && afP.getVisibility() == 0 && (afQ = this.cgv.afQ()) != null) {
            afQ.setVisibility(8);
        } else {
            this.bUZ.en(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cgV);
            if (this.cgl == null) {
                this.cgl = new PopupWindow(this.Gd.getPageActivity());
                this.cgl.setContentView(this.cgm);
                this.cgl.setBackgroundDrawable(new BitmapDrawable());
                this.cgl.setOutsideTouchable(true);
                this.cgl.setFocusable(true);
                this.cgl.setWidth(this.Gd.getResources().getDimensionPixelSize(t.e.ds228));
                this.cgl.setHeight(this.Gd.getResources().getDimensionPixelSize(t.e.ds100));
                this.cgn = (TextView) this.cgm.findViewById(t.g.cur_experience);
                this.cgo = (TextView) this.cgm.findViewById(t.g.levelup_experience);
                a(this.cgn, this.cgo);
            }
            if (this.cgl.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.cgl, this.Gd.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cgn, this.cgo);
            if (iArr[1] - this.cgl.getHeight() <= 50) {
                com.baidu.adp.lib.h.j.a(this.cgl, this.Gd.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.cgl, this.Gc, 0, iArr[0], iArr[1] - this.cgl.getHeight());
            this.cgl.update();
            this.mHandler.postDelayed(this.cgV, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.Gd.getContext()).inflate(t.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(t.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(t.g.speed_tip);
            av.c((TextView) inflate.findViewById(t.g.experience_txt), t.d.cp_cont_b, 1);
            av.c(textView, t.d.cp_cont_b, 1);
            av.c(textView2, t.d.cp_cont_b, 1);
            av.c(textView3, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Gd.getPageActivity());
            aVar.z(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cgB) && !TextUtils.isEmpty(this.cgB.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cgB);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ca(t.d.cp_link_tip_d);
            a(aVar);
            b(aVar);
            aVar.b(this.Gd);
            aVar.sX();
        }
    }

    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(t.j.cancel_text, new p(this));
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(t.j.open_now, new q(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void acS() {
        View contentView;
        if (this.cgq == null) {
            this.cgq = new PopupWindow(this.Gd.getPageActivity());
            contentView = LayoutInflater.from(this.Gd.getContext()).inflate(t.h.speed_tip, (ViewGroup) null);
            this.cgq.setContentView(contentView);
            contentView.setOnClickListener(new r(this));
            this.cgq.setWidth(this.Gd.getResources().getDimensionPixelSize(t.e.ds300));
            this.cgq.setHeight(this.Gd.getResources().getDimensionPixelSize(t.e.ds88));
            this.cgq.setBackgroundDrawable(new BitmapDrawable());
            this.cgq.setOutsideTouchable(true);
            this.cgq.setTouchInterceptor(new s(this));
        } else {
            contentView = this.cgq.getContentView();
        }
        this.Gd.getLayoutMode().x(contentView);
        int[] iArr = new int[2];
        this.cgp.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.cgq, this.Gc, 0, (iArr[0] - (this.cgq.getWidth() / 2)) + (this.cgp.getWidth() / 2), iArr[1] + this.cgp.getWidth());
        this.cgq.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(boolean z, float f) {
        int i;
        this.cgO = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(t.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cgO) {
                this.cfU.setText(t.j.level_up);
                if (f >= 1.0f) {
                    i = this.cgE;
                } else {
                    i = this.cgE + 1;
                }
                com.baidu.tieba.tbadkCore.p aaR = this.bRp.aaR();
                if (aaR != null && aaR.aLP() != null) {
                    aaR.aLP().setUser_level(i);
                }
                av.c(this.cfV, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.cfU.setText(this.cgz);
                av.c(this.cfV, BitmapHelper.getSmallGradeResourceIdNew(this.cgE));
            }
            this.cfW.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ia(this.cgE)));
            if (this.cgO) {
                if (f >= 1.0f) {
                    a(this.Gd.getOrignalPage(), this.cfW, this.cgP, f);
                } else {
                    b(this.Gd.getOrignalPage(), this.cfW, this.cgP, f);
                }
            } else {
                a(this.Gd.getOrignalPage(), this.cfW, this.cgP, f);
            }
            this.cgP = f;
        }
    }

    private int[] ia(int i) {
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
    protected void acT() {
        this.cgu.c(this.cfL, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void acU() {
        if (this.mMemberType != 0) {
            av.c(this.cgp, t.f.icon_sml_speed_orange);
        } else {
            av.c(this.cgp, t.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bVm);
        if (this.bVk != null) {
            this.bVk.onDestroy();
        }
        if (this.cbG != null) {
            this.cbG.onDestory();
        }
        if (this.cgr != null) {
            this.cgr.removeCallbacks(this.bVl);
        }
    }
}
