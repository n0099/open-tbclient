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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends g {
    private static final String DEFAULT_BADGE_URL = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected RelativeLayout aSG;
    private BlurDrawable bVd;
    protected Runnable bVe;
    protected String mImageUrl;
    private CustomMessageListener bVf = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bVc = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aSG = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bRi = frsActivity;
        this.Gd = frsActivity.getPageContext();
        this.cfF = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds20);
        this.cfG = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds72);
        this.cfH = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Gc = acK();
        this.aSG = (RelativeLayout) this.Gc.findViewById(r.g.container);
        this.aSG.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds150), 0, 0);
        this.cgv = (ForumMemberIconView) this.Gc.findViewById(r.g.forum_member_icon_layout);
        this.cgv.setVisibility(8);
        this.cgk = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.Gc.setVisibility(8);
        }
        this.cfY = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds220), 0, 0);
        this.cfY.setLayoutParams(layoutParams);
        this.bAe = (CoverFlowView) this.Gc.findViewById(r.g.nomal_frs_coverflowview);
        this.cga = (ForumHeadSdkView) this.Gc.findViewById(r.g.frs_head_sdk);
        this.cbI = (ForumHeadVideoView) this.Gc.findViewById(r.g.frs_head_video_list);
        VE();
        this.cfQ = (RelativeLayout) this.Gc.findViewById(r.g.btn_love_content);
        this.cgn = (ImageView) this.Gc.findViewById(r.g.speed_icon);
        this.cfR = (TextView) this.Gc.findViewById(r.g.level_name);
        this.cfS = (ImageView) this.Gc.findViewById(r.g.level);
        this.cfT = (ImageView) this.Gc.findViewById(r.g.love_level_top);
        this.cfI = (FrameLayout) this.Gc.findViewById(r.g.love);
        this.cfJ = (Button) this.Gc.findViewById(r.g.btn_love);
        this.cfJ.setContentDescription(frsActivity.getResources().getString(r.j.attention));
        this.FY = (TextView) this.Gc.findViewById(r.g.tv_love);
        this.cfK = (FrameLayout) this.Gc.findViewById(r.g.sign);
        this.cfL = (Button) this.Gc.findViewById(r.g.btn_sign);
        this.cfM = (TextView) this.Gc.findViewById(r.g.tv_sign);
        this.cfM.setContentDescription(frsActivity.getResources().getString(r.j.sign));
        this.cfN = (ProgressBar) this.Gc.findViewById(r.g.sign_progress);
        this.cfO = (FrameLayout) this.Gc.findViewById(r.g.sign_done);
        this.cfP = (TextView) this.Gc.findViewById(r.g.sign_done_text);
        this.FV = (TextView) this.Gc.findViewById(r.g.member_num_text);
        this.FW = (TextView) this.Gc.findViewById(r.g.post_num_text);
        this.FX = (TextView) this.Gc.findViewById(r.g.title_text);
        this.cgp = (BarImageView) this.Gc.findViewById(r.g.frs_image);
        this.cgp.setContentDescription(frsActivity.getResources().getString(r.j.bar_header));
        this.cgp.setGifIconSupport(false);
        this.cgp.setDrawerType(0);
        this.cgq = (UserIconBox) this.Gc.findViewById(r.g.frs_badge_box);
        this.cfU = LayoutInflater.from(this.bRi.getPageContext().getPageActivity()).inflate(r.h.frs_header_extra_entelechy, (ViewGroup) null);
        acO();
        this.cfV = (ViewGroup) this.cfU.findViewById(r.g.frs_header_games);
        this.cfW = (TextView) this.cfU.findViewById(r.g.top_item_title);
        this.cgg = (LinearLayout) this.cfU.findViewById(r.g.frs_header_enter_root);
        this.cgt = new com.baidu.tieba.frs.view.o(this.Gd, this.cfU);
        this.cgs = new bb(this.Gd);
        this.cgb = (ViewGroup) this.cfU.findViewById(r.g.frs_headline);
        this.cgc = (TextView) this.cgb.findViewById(r.g.headline_title);
        this.cgd = (TextView) this.cgb.findViewById(r.g.headline_text);
        this.cge = (TbImageView) this.cgb.findViewById(r.g.headline_image);
        this.cgb.setVisibility(8);
        acV();
        MessageManager.getInstance().registerListener(this.bVf);
    }

    private void acV() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), df.class);
        if (runTask != null && runTask.getData() != null) {
            this.cgu = (df) runTask.getData();
            this.cgu.a(this.Gd, this.Gc, 1, false);
            this.cgu.hide();
        }
    }

    private void acW() {
        com.baidu.tbadk.core.data.l bip = this.bWN.bip();
        if (bip != null && this.bWN.aMr() != null) {
            String id = this.bWN.aMr().getId();
            String name = this.bWN.aMr().getName();
            if (this.cgS.add(bip.pt())) {
                a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bip.pt(), id, name, null);
                a.bT("obj_url", bip.getUrl());
                a.save();
            }
            this.cgb.setVisibility(0);
            this.cgc.setText(bip.getText());
            this.cgd.setText(bip.getTitle());
            this.cge.c(bip.ps(), 10, false);
            this.cgb.setOnClickListener(new l(this, bip, id, name));
        }
    }

    protected View acK() {
        return LayoutInflater.from(this.bRi.getPageContext().getPageActivity()).inflate(r.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cgp.setOnClickListener(onClickListener);
        this.FX.setOnClickListener(onClickListener);
        this.cfJ.setOnClickListener(onClickListener);
        this.cfL.setOnClickListener(onClickListener);
        this.cfO.setOnClickListener(onClickListener);
        this.cfQ.setOnClickListener(onClickListener);
        if (this.cfV != null) {
            this.cfV.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.c.e.dN().ac("frs_to_bar_detail") == 0) {
            this.Gc.setOnClickListener(new m(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.Gd.getLayoutMode().ah(i == 1);
        this.Gd.getLayoutMode().x(this.Gc);
        this.Gd.getLayoutMode().x(this.cgk);
        this.Gd.getLayoutMode().x(this.cfU);
        if (this.cgL) {
            iJ(1);
        } else {
            iJ(0);
        }
        if (this.bAe != null) {
            this.bAe.tx();
        }
        if (this.cga != null) {
            this.cga.d(this.Gd, i);
        }
        this.cgp.invalidate();
        av.c(this.cfS, BitmapHelper.getSmallGradeResourceIdNew(this.cgC));
        if (this.bVd != null && this.bVd.getBlurredBitmap() != null && !this.bVd.getBlurredBitmap().isRecycled()) {
            this.aSG.setBackgroundDrawable(new BitmapDrawable(this.bVd.getBlurredBitmap()));
        } else {
            av.l(this.aSG, r.d.cp_bg_line_d);
        }
        acX();
        if (this.cfV != null) {
            av.k(this.cfV, r.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            av.c(this.cgn, r.f.icon_sml_speed_orange);
        } else {
            av.c(this.cgn, r.f.icon_sml_speed_gray);
        }
        if (this.cgt != null) {
            this.cgt.changeSkinType(i);
        }
        if (this.cgu != null) {
            this.cgu.changeSkinType(i);
        }
        if (this.cgq != null) {
            this.cgq.dl(i);
        }
        if (this.cgv != null) {
            this.cgv.d(this.Gd, i);
        }
        Iterator<TbImageView> it = this.bVc.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        acQ();
        if (this.cbI != null) {
            this.cbI.onChangeSkinType(this.Gd, i);
        }
        av.k(this.cgb, r.f.home_thread_card_item_bg);
        if (this.bUV != null) {
            com.baidu.tbadk.i.a.a(this.bRi.getPageContext(), this.bUV);
        }
    }

    protected void acX() {
        this.FY.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.cfM.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cgD = forumData.getPost_num();
            this.cgy = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.cgx = forumData.getLevelName();
            this.cgC = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cgE = forumData.getSignData().count_sign_num;
                this.cgF = forumData.getSignData().miss_sign_num;
            }
            this.cgG = forumData.getCurScore();
            this.cfk = forumData.getLevelupScore();
            this.cgr = forumData.getBadgeData();
            this.cgh = forumData.getTopCode();
            this.cgi = forumData.getNewsInfo();
            this.cgz = forumData.getAccelerateContent();
            this.cgw = forumData.getMemberShowIconData();
            this.bWN = pVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.Gc.setVisibility(8);
            } else {
                this.Gc.setVisibility(0);
            }
            this.cgA = new bi();
            acY();
            acL();
            acW();
        }
    }

    protected void acY() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.cgA.rW().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void acZ() {
        if (this.cgF > 0) {
            if (com.baidu.adp.lib.util.k.K(this.Gd.getPageActivity()) >= 480) {
                this.cfP.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            av.c(this.cfP, r.d.cp_cont_i, 1);
            this.cfP.setText(String.format(this.Gd.getString(r.j.miss_sign_days), Integer.valueOf(this.cgF)));
        } else {
            this.cfP.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(r.f.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            av.c(this.cfP, r.d.common_color_10061, 1);
            if (this.cgE <= 0) {
                this.cfP.setText(this.Gd.getString(r.j.signed));
            } else {
                this.cfP.setText(String.format(this.Gd.getString(r.j.continuous_sign_days), Integer.valueOf(this.cgE)));
            }
        }
        this.cfO.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void ada() {
    }

    protected void adb() {
        a(this.bWN.bhO());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acL() {
        if (this.bWN != null) {
            adb();
        }
        if (this.bWN != null && this.bWN.bij() != null) {
            a(this.bWN.bij());
        }
        if (this.FV != null) {
            this.FV.setText(az.w(this.mMemberNum));
        }
        if (this.FW != null) {
            this.FW.setText(az.w(this.cgD));
        }
        if (this.FX != null) {
            if (this.cgr != null && this.cgr.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.FX.setText(String.valueOf(this.mForumName) + this.Gd.getString(r.j.forum));
            }
        }
        if (this.cfV != null && this.cfW != null) {
            if (this.bWN != null && this.bWN.bhU()) {
                int dl = com.baidu.tbadk.core.util.n.dl(this.bWN.bhX());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dl == 1 && !z) {
                    this.cfV.setVisibility(8);
                } else {
                    this.cfV.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bWN.getGameName()) && !TextUtils.isEmpty(this.bWN.getGameName().trim())) {
                        this.cfW.setText(UtilHelper.getFixedText(this.bWN.getGameName(), 10));
                        String rq = com.baidu.tieba.tbadkCore.util.n.rq(this.bWN.bhX());
                        if (!StringUtils.isNull(rq)) {
                            TiebaStatic.eventStat(this.Gd.getPageActivity(), "game_show", "show", 1, "dev_id", rq, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cfW.setText(this.Gd.getResources().getString(r.j.frsgame_title));
                    }
                }
            } else {
                this.cfV.setVisibility(8);
            }
        }
        if (this.bWN != null && this.bWN.bhV() != null && this.bWN.bhV().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> bhV = this.bWN.bhV();
            aC(bhV);
            int size = bhV.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.cgg.setVisibility(0);
                this.cgg.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar = bhV.get(i2);
                    if (hVar != null) {
                        String jW = jW(hVar.aEO());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.Gd.getPageActivity()).inflate(r.h.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(r.g.top_item_title)).setText(hVar.getTitle());
                        ((TextView) viewGroup.findViewById(r.g.top_item_type)).setText(jW);
                        u(viewGroup);
                        viewGroup.setTag(hVar);
                        viewGroup.setOnClickListener(this.cgU);
                        this.cgg.addView(viewGroup);
                        if (this.cgS.add(hVar.bhI())) {
                            a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.bhI(), this.bRi.getForumId(), this.bRi.getForumName(), null);
                            a.bT("obj_url", hVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.cgg.setVisibility(8);
            }
        } else {
            this.cgg.setVisibility(8);
        }
        if (this.bWN != null) {
            this.cgt.a(this.bWN.bhN(), this.bWN.aMr());
        } else {
            this.cgt.a(null, null);
        }
        acM();
        if (this.cgq != null && this.cgr != null && this.cgr.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.cgr.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.cgr.get(i3).pq());
                iconData.setIcon(this.cgr.get(i3).pp());
                this.cgB = this.cgr.get(i3).pr();
                linkedList.add(iconData);
            }
            this.cgq.setOnClickListener(this.ahC);
            this.cgq.a(linkedList, 2, this.Gd.getResources().getDimensionPixelSize(r.e.ds40), this.Gd.getResources().getDimensionPixelSize(r.e.ds40), this.Gd.getResources().getDimensionPixelSize(r.e.ds14));
        }
        if (this.cgu != null && this.bWN != null) {
            this.cgu.c(this.bWN);
        }
        String icon = this.cgw.getIcon();
        String url = this.cgw.getUrl();
        if (this.cgw != null && this.cgv != null) {
            this.cgv.setIcon(icon);
            this.cgv.setUrl(url);
        }
        acN();
        acP();
        acS();
        if (this.bWN != null) {
            c(com.baidu.adp.lib.h.b.c(this.mForumId, 0L), this.bWN.biq());
        }
    }

    protected void acM() {
        this.cgp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cgp.c(this.mImageUrl, 15, false);
        if (this.cgp.getBdImage() == null || this.cgp.getBdImage().jV() == null) {
            adc();
            return;
        }
        if (this.bVe == null) {
            this.bVe = new n(this);
        }
        this.cgp.postDelayed(this.bVe, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adc() {
        this.cgp.setEvent(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void add() {
        if (this.bRi != null && this.bRi.getActivity() != null) {
            try {
                if (this.bVd == null) {
                    this.bVd = new BlurDrawable(this.bRi.getActivity());
                    if (this.cgp != null && this.cgp.getBdImage() != null && this.cgp.getBdImage().jV() != null && !this.cgp.getBdImage().jV().isRecycled()) {
                        this.bVd.init(12, 8, this.cgp.getBdImage().jV());
                    }
                }
                if (this.bVd != null && this.bVd.getBlurredBitmap() == null && this.bVd.drawBlur()) {
                    this.aSG.setBackgroundDrawable(new BitmapDrawable(this.bVd.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String jW(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(r.j.tequan);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acN() {
        ViewGroup agd;
        View age;
        View findViewById;
        this.bUS.eo(false);
        if (this.cfV.getVisibility() == 0) {
            View findViewById2 = this.cfV.findViewById(r.g.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.cfV.getVisibility() == 8 && this.cgg.getVisibility() == 0) {
            if (this.cgg.getChildCount() > 0 && (findViewById = ((ViewGroup) this.cgg.getChildAt(0)).findViewById(r.g.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.cgg.getVisibility() == 8 && (agd = this.cgt.agd()) != null && agd.getVisibility() == 0 && (age = this.cgt.age()) != null) {
            age.setVisibility(8);
        } else {
            this.bUS.eo(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cgT);
            if (this.cgj == null) {
                this.cgj = new PopupWindow(this.Gd.getPageActivity());
                this.cgj.setContentView(this.cgk);
                this.cgj.setBackgroundDrawable(new BitmapDrawable());
                this.cgj.setOutsideTouchable(true);
                this.cgj.setFocusable(true);
                this.cgj.setWidth(this.Gd.getResources().getDimensionPixelSize(r.e.ds228));
                this.cgj.setHeight(this.Gd.getResources().getDimensionPixelSize(r.e.ds100));
                this.cgl = (TextView) this.cgk.findViewById(r.g.cur_experience);
                this.cgm = (TextView) this.cgk.findViewById(r.g.levelup_experience);
                a(this.cgl, this.cgm);
            }
            if (this.cgj.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.cgj, this.Gd.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cgl, this.cgm);
            if (iArr[1] - this.cgj.getHeight() <= 50) {
                com.baidu.adp.lib.h.j.a(this.cgj, this.Gd.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.cgj, this.Gc, 0, iArr[0], iArr[1] - this.cgj.getHeight());
            this.cgj.update();
            this.mHandler.postDelayed(this.cgT, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.Gd.getContext()).inflate(r.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(r.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(r.g.speed_tip);
            av.c((TextView) inflate.findViewById(r.g.experience_txt), r.d.cp_cont_b, 1);
            av.c(textView, r.d.cp_cont_b, 1);
            av.c(textView2, r.d.cp_cont_b, 1);
            av.c(textView3, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Gd.getPageActivity());
            aVar.z(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cgz) && !TextUtils.isEmpty(this.cgz.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cgz);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ca(r.d.cp_link_tip_d);
            a(aVar);
            b(aVar);
            aVar.b(this.Gd);
            aVar.tm();
        }
    }

    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(r.j.cancel_text, new p(this));
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(r.j.open_now, new q(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void ade() {
        View contentView;
        if (this.cgo == null) {
            this.cgo = new PopupWindow(this.Gd.getPageActivity());
            contentView = LayoutInflater.from(this.Gd.getContext()).inflate(r.h.speed_tip, (ViewGroup) null);
            this.cgo.setContentView(contentView);
            contentView.setOnClickListener(new r(this));
            this.cgo.setWidth(this.Gd.getResources().getDimensionPixelSize(r.e.ds300));
            this.cgo.setHeight(this.Gd.getResources().getDimensionPixelSize(r.e.ds88));
            this.cgo.setBackgroundDrawable(new BitmapDrawable());
            this.cgo.setOutsideTouchable(true);
            this.cgo.setTouchInterceptor(new s(this));
        } else {
            contentView = this.cgo.getContentView();
        }
        this.Gd.getLayoutMode().x(contentView);
        int[] iArr = new int[2];
        this.cgn.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.cgo, this.Gc, 0, (iArr[0] - (this.cgo.getWidth() / 2)) + (this.cgn.getWidth() / 2), iArr[1] + this.cgn.getWidth());
        this.cgo.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(boolean z, float f) {
        int i;
        this.cgM = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(r.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cgM) {
                this.cfR.setText(r.j.level_up);
                if (f >= 1.0f) {
                    i = this.cgC;
                } else {
                    i = this.cgC + 1;
                }
                com.baidu.tieba.tbadkCore.p abe = this.bRi.abe();
                if (abe != null && abe.aMr() != null) {
                    abe.aMr().setUser_level(i);
                }
                av.c(this.cfS, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.cfR.setText(this.cgx);
                av.c(this.cfS, BitmapHelper.getSmallGradeResourceIdNew(this.cgC));
            }
            this.cfT.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ie(this.cgC)));
            if (this.cgM) {
                if (f >= 1.0f) {
                    a(this.Gd.getOrignalPage(), this.cfT, this.cgN, f);
                } else {
                    b(this.Gd.getOrignalPage(), this.cfT, this.cgN, f);
                }
            } else {
                a(this.Gd.getOrignalPage(), this.cfT, this.cgN, f);
            }
            this.cgN = f;
        }
    }

    private int[] ie(int i) {
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
    protected void adf() {
        this.cgs.c(this.cfI, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void adg() {
        if (this.mMemberType != 0) {
            av.c(this.cgn, r.f.icon_sml_speed_orange);
        } else {
            av.c(this.cgn, r.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bVf);
        if (this.bVd != null) {
            this.bVd.onDestroy();
        }
        if (this.cbI != null) {
            this.cbI.onDestory();
        }
        if (this.cgp != null) {
            this.cgp.removeCallbacks(this.bVe);
        }
    }
}
