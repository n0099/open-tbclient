package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.entelechy.view.FrsEntranceStoryListWrapperView;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.view.e;
import com.baidu.tieba.story.g;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c extends a {
    private RelativeLayout aWV;
    protected CoverFlowView<t> bdl;
    protected Runnable blA;
    private BlurDrawable bly;
    private TextView cmI;
    private TextView cmJ;
    private g cmK;
    private FrsHeaderPraiseView cmM;
    private FrsEntranceStoryListWrapperView cmN;
    protected TextView cmO;
    protected ImageView cmP;
    protected ProgressBar cmQ;
    protected View cmR;
    private String mImageUrl;
    private CustomMessageListener cmS = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.czb != null && customResponsedMessage != null) {
                boolean booleanValue = (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue();
                c.this.bzE = c.this.czb.findViewById(d.h.divider_bottom);
                if (booleanValue) {
                    c.this.bzE.setVisibility(8);
                } else {
                    c.this.bzE.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cmL = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        ViewGroup.LayoutParams layoutParams;
        this.aWV = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.ckn = fVar;
        this.acp = fVar.getPageContext();
        this.cyM = k.g(fVar.getPageContext().getPageActivity(), d.f.ds20);
        this.cyN = k.g(fVar.getPageContext().getPageActivity(), d.f.ds72);
        this.cyO = k.g(fVar.getPageContext().getPageActivity(), d.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aZg = agy();
        this.aWV = (RelativeLayout) this.aZg.findViewById(d.h.container);
        if (this.aWV.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = this.aWV.getLayoutParams();
            layoutParams.height = k.g(fVar.getPageContext().getPageActivity(), d.f.ds350) + UtilHelper.getImmersiveStickyBarHeight();
        } else {
            layoutParams = new AbsListView.LayoutParams(-1, k.g(fVar.getPageContext().getPageActivity(), d.f.ds350) + UtilHelper.getImmersiveStickyBarHeight());
        }
        this.aWV.setLayoutParams(layoutParams);
        this.czm = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aZg.setVisibility(8);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, k.g(this.acp.getPageActivity(), d.f.ds60));
        layoutParams2.setMargins(0, k.g(this.acp.getPageActivity(), d.f.ds220), 0, 0);
        this.cmO = (TextView) LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.forum_activity_head_title_layout, (ViewGroup) null);
        this.cmO.setLayoutParams(layoutParams2);
        this.bdl = (CoverFlowView) this.aZg.findViewById(d.h.nomal_frs_coverflowview);
        this.cmP = (ImageView) this.aZg.findViewById(d.h.level);
        this.cyU = (ImageView) this.aZg.findViewById(d.h.love_level_top);
        this.cyZ = (FrameLayout) this.aZg.findViewById(d.h.love);
        this.cgo = (TextView) this.aZg.findViewById(d.h.btn_love);
        this.cgo.setContentDescription(fVar.getResources().getString(d.l.attention));
        this.cyX = (FrameLayout) this.aZg.findViewById(d.h.sign);
        this.cyY = (TextView) this.aZg.findViewById(d.h.btn_sign);
        this.cmQ = (ProgressBar) this.aZg.findViewById(d.h.sign_progress);
        this.cyV = (FrameLayout) this.aZg.findViewById(d.h.sign_done);
        this.cyW = (TextView) this.aZg.findViewById(d.h.sign_done_text);
        this.cdk = (TextView) this.aZg.findViewById(d.h.title_text);
        this.czs = (UserIconBox) this.aZg.findViewById(d.h.frs_badge_box);
        this.czb = LayoutInflater.from(this.ckn.getPageContext().getPageActivity()).inflate(d.j.frs_header_extra_entelechy, (ViewGroup) null);
        this.cmR = this.czb.findViewById(d.h.extra_mask_view);
        ai.k(this.cmR, d.e.black_alpha0);
        this.cza = (RelativeLayout) this.aZg.findViewById(d.h.btn_love_content);
        this.czp = (ImageView) this.aZg.findViewById(d.h.speed_icon);
        this.cmI = (TextView) this.aZg.findViewById(d.h.member_image);
        this.cmJ = (TextView) this.aZg.findViewById(d.h.post_image);
        this.cyT = (TextView) this.aZg.findViewById(d.h.level_name);
        this.czR = (ImageView) this.aZg.findViewById(d.h.level);
        this.cyR = (TextView) this.aZg.findViewById(d.h.tv_love);
        this.cyS = (TextView) this.aZg.findViewById(d.h.tv_sign);
        this.cyS.setContentDescription(fVar.getResources().getString(d.l.sign));
        this.cyU = (ImageView) this.aZg.findViewById(d.h.love_level_top);
        this.cyP = (TextView) this.aZg.findViewById(d.h.member_num_text);
        this.cyQ = (TextView) this.aZg.findViewById(d.h.post_num_text);
        this.czr = (BarImageView) this.aZg.findViewById(d.h.frs_image);
        this.czr.setPageId(this.ckn.getUniqueId());
        this.czr.setContentDescription(fVar.getResources().getString(d.l.bar_header));
        this.czr.setGifIconSupport(false);
        this.czr.setDrawerType(0);
        ago();
        agv();
        agu();
        this.czc = (ViewGroup) this.czb.findViewById(d.h.frs_header_games);
        this.czd = (TextView) this.czb.findViewById(d.h.top_item_title);
        this.czi = (LinearLayout) this.czb.findViewById(d.h.frs_present_root);
        this.bzE = this.czb.findViewById(d.h.divider_bottom);
        this.czv = new e(this.acp, this.czb);
        this.czu = new com.baidu.tieba.frs.f.b(this.acp);
        this.cze = (ViewGroup) this.czb.findViewById(d.h.frs_headline);
        this.czf = (TextView) this.cze.findViewById(d.h.headline_title);
        this.czg = (TextView) this.cze.findViewById(d.h.headline_text);
        this.czh = (TbImageView) this.cze.findViewById(d.h.headline_image);
        this.czh.setPageId(this.ckn.getUniqueId());
        this.cze.setVisibility(8);
        this.czS = (RelativeLayout) this.aZg.findViewById(d.h.head_content_container);
        agw();
        this.ckn.registerListener(this.cmS);
    }

    private void agu() {
        this.cmM = (FrsHeaderPraiseView) this.czb.findViewById(d.h.frs_praise_layout);
    }

    private void agv() {
        this.cmN = (FrsEntranceStoryListWrapperView) this.czb.findViewById(d.h.listview_story_wrapper_view);
        this.cmN.p(this.ckn.getPageContext());
    }

    private void agw() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.czw = (ag) runTask.getData();
            this.czw.a(this.acp, this.aZg, 1, false, this.ckn.getUniqueId());
            this.czw.hide();
        }
    }

    private void agx() {
        final m brd = this.cos.brd();
        if (brd != null && this.cos.aPh() != null) {
            final String id = this.cos.aPh().getId();
            final String name = this.cos.aPh().getName();
            if (this.czP.add(brd.pH())) {
                a.C0120a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", brd.pH(), id, name, null);
                a.ch("obj_url", brd.getUrl());
                a.save();
            }
            this.cze.setVisibility(0);
            this.czf.setText(brd.getText());
            this.czg.setText(brd.getTitle());
            this.czh.c(brd.pG(), 10, false);
            this.cze.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0120a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", brd.pH(), id, name, null);
                    a2.ch("obj_url", brd.getUrl());
                    a2.save();
                    at.wf().c(c.this.ckn.getPageContext(), new String[]{brd.getUrl()});
                }
            });
        }
    }

    protected View agy() {
        return LayoutInflater.from(this.ckn.getPageContext().getPageActivity()).inflate(d.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.czr.setOnClickListener(onClickListener);
        this.cdk.setOnClickListener(onClickListener);
        this.cyZ.setOnClickListener(onClickListener);
        this.cyX.setOnClickListener(onClickListener);
        this.cyV.setOnClickListener(onClickListener);
        this.cza.setOnClickListener(onClickListener);
        if (this.czc != null) {
            this.czc.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.acp.getLayoutMode().ah(i == 1);
        this.acp.getLayoutMode().t(this.aZg);
        this.acp.getLayoutMode().t(this.czm);
        this.acp.getLayoutMode().t(this.czb);
        if (this.czJ) {
            jB(1);
        } else {
            jB(0);
        }
        if (this.bdl != null) {
            this.bdl.onChangeSkinType();
        }
        this.czr.invalidate();
        ai.c(this.cmP, BitmapHelper.getSmallGradeResourceIdNew(this.bri));
        if (this.bly != null && this.bly.getBlurredBitmap() != null && !this.bly.getBlurredBitmap().isRecycled()) {
            this.aWV.setBackgroundDrawable(new BitmapDrawable(this.bly.getBlurredBitmap()));
        } else {
            ai.k(this.aWV, d.e.cp_bg_line_d);
        }
        agz();
        if (this.czc != null) {
            ai.j(this.czc, d.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ai.c(this.czp, d.g.icon_sml_speed_orange);
        } else {
            ai.c(this.czp, d.g.icon_sml_speed_gray);
        }
        if (this.czv != null) {
            this.czv.changeSkinType(i);
        }
        if (this.czw != null) {
            this.czw.changeSkinType(i);
        }
        if (this.czs != null) {
            this.czs.dt(i);
        }
        Iterator<TbImageView> it = this.cmL.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        agq();
        ai.j(this.cze, d.g.home_thread_card_item_bg);
        if (this.cmE != null) {
            com.baidu.tbadk.o.a.a(this.ckn.getPageContext(), this.cmE);
        }
        if (this.cmN.getVisibility() == 0) {
            this.cmN.changeSkinType(i);
        }
        if (this.cmM.getVisibility() == 0) {
            this.cmM.changeSkinType(i);
        }
    }

    protected void agz() {
        this.cyR.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.frs_header_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.c(this.cyR, d.e.frs_header_white_btn_selector, 1);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, i iVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.czB = forumData.getPost_num();
            this.czy = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.czx = forumData.getLevelName();
            this.bri = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.czC = forumData.getSignData().count_sign_num;
                this.czD = forumData.getSignData().miss_sign_num;
            }
            this.czE = forumData.getCurScore();
            this.cyd = forumData.getLevelupScore();
            this.czt = forumData.getBadgeData();
            this.czj = forumData.getTopCode();
            this.czk = forumData.getNewsInfo();
            this.czz = forumData.getAccelerateContent();
            this.cos = iVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aZg.setVisibility(8);
            } else {
                this.aZg.setVisibility(0);
            }
            this.czA = new bl();
            agA();
            agD();
            agx();
            if (this.cos != null) {
                this.cmN.b(this.cos.bqx(), this.ckn.getForumId(), "0");
                this.cmM.setData(this.cos.bqy());
            } else {
                this.cmN.setVisibility(8);
                this.cmM.setVisibility(8);
            }
            if (this.cmK == null) {
                this.cmK = new g(this.ckn.getPageContext(), this.ckn.getPageContext().getUniqueId(), 2, com.baidu.adp.lib.g.b.d(this.mForumId, 0L), this.mForumName);
                this.cmN.setOnClick(this.cmK);
            }
        }
    }

    protected void agA() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.czA.rP().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void agB() {
        if (this.czD > 0) {
            if (k.ag(this.acp.getPageActivity()) >= 480) {
                this.cyW.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.frs_header_sign_bu_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            ai.c(this.cyW, d.e.frs_header_white_btn_selector, 1);
            this.cyW.setText(String.format(this.acp.getString(d.l.miss_sign_days), Integer.valueOf(this.czD)));
        } else {
            this.cyW.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_frs_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.c(this.cyW, d.e.white_alpha70, 1);
            if (this.czC <= 0) {
                this.cyW.setText(this.acp.getString(d.l.signed));
            } else {
                this.cyW.setText(String.format(this.acp.getString(d.l.continuous_sign_days), Integer.valueOf(this.czC)));
            }
        }
        this.cyV.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void agC() {
        ai.j(this.cyY, d.g.bg_frs_header_button_selector);
        this.cyS.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.frs_header_sign_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.c(this.cyS, d.e.frs_header_white_btn_selector, 1);
    }

    protected void agD() {
        if (this.cyP != null) {
            this.cyP.setText(al.u(this.mMemberNum));
        }
        if (this.cyQ != null) {
            this.cyQ.setText(al.u(this.czB));
        }
        if (this.cdk != null) {
            if (this.czt != null && this.czt.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.cdk.setText(this.mForumName + this.acp.getString(d.l.forum));
            }
        }
        if (this.czc != null && this.czd != null) {
            if (this.cos != null && this.cos.bqJ()) {
                if (l.dK(this.cos.bqM()) == 1 && !com.baidu.tbadk.core.util.m.aga) {
                    this.czc.setVisibility(8);
                } else {
                    this.czc.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cos.getGameName()) && !TextUtils.isEmpty(this.cos.getGameName().trim())) {
                        this.czd.setText(UtilHelper.getFixedText(this.cos.getGameName(), 10));
                        String si = com.baidu.tieba.tbadkCore.util.b.si(this.cos.bqM());
                        if (!StringUtils.isNull(si)) {
                            TiebaStatic.eventStat(this.acp.getPageActivity(), "game_show", "show", 1, "dev_id", si, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.czd.setText(this.acp.getResources().getString(d.l.frsgame_title));
                    }
                }
            } else {
                this.czc.setVisibility(8);
            }
        }
        this.cmG.clearData();
        if (this.cos != null && !u.v(this.cos.bqK())) {
            List<com.baidu.tieba.tbadkCore.e> bqK = this.cos.bqK();
            aR(bqK);
            this.cmG.aQ(bqK);
        }
        this.czi.setVisibility(8);
        this.czv.a(null, null);
        agE();
        agF();
        agp();
    }

    protected void agE() {
        this.czr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.czr.c(this.mImageUrl, 15, false);
        if (this.czr.getBdImage() == null || this.czr.getBdImage().kX() == null) {
            OE();
            return;
        }
        if (this.blA == null) {
            this.blA = new Runnable() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.OF();
                }
            };
        }
        this.czr.postDelayed(this.blA, 50L);
    }

    protected void OE() {
        this.czr.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z) {
                    c.this.OF();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
    }

    protected void OF() {
        if (this.ckn != null && this.ckn.getActivity() != null) {
            try {
                if (this.bly == null) {
                    this.bly = new BlurDrawable(this.ckn.getActivity());
                    if (this.czr != null && this.czr.getBdImage() != null && this.czr.getBdImage().kX() != null && !this.czr.getBdImage().kX().isRecycled()) {
                        this.bly.init(12, 8, this.czr.getBdImage().kX());
                    }
                }
                if (this.bly != null && this.bly.getBlurredBitmap() == null && this.bly.drawBlur()) {
                    this.aWV.setBackgroundDrawable(new BitmapDrawable(this.bly.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    protected void agF() {
        this.cmC.ff(false);
        if (this.czc.getVisibility() == 0) {
            View findViewById = this.czc.findViewById(d.h.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.cmC.ff(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.czQ);
            if (this.czl == null) {
                this.czl = new PopupWindow(this.acp.getPageActivity());
                this.czl.setContentView(this.czm);
                this.czl.setBackgroundDrawable(new BitmapDrawable());
                this.czl.setOutsideTouchable(true);
                this.czl.setFocusable(true);
                this.czl.setWidth(this.acp.getResources().getDimensionPixelSize(d.f.ds228));
                this.czl.setHeight(this.acp.getResources().getDimensionPixelSize(d.f.ds100));
                this.czn = (TextView) this.czm.findViewById(d.h.cur_experience);
                this.czo = (TextView) this.czm.findViewById(d.h.levelup_experience);
                a(this.czn, this.czo);
            }
            if (this.czl.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.czl, this.acp.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.czn, this.czo);
            if (iArr[1] - this.czl.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.czl, this.acp.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.czl, this.aZg, 0, iArr[0], iArr[1] - this.czl.getHeight());
            this.czl.update();
            this.mHandler.postDelayed(this.czQ, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.acp.getContext()).inflate(d.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.h.speed_tip);
            ai.c((TextView) inflate.findViewById(d.h.experience_txt), d.e.cp_cont_b, 1);
            ai.c(textView, d.e.cp_cont_b, 1);
            ai.c(textView2, d.e.cp_cont_b, 1);
            ai.c(textView3, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.acp.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.czz) && !TextUtils.isEmpty(this.czz.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.czz);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cd(d.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.acp);
            aVar.tr();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.acp.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                memberPayActivityConfig.setSceneId("4004001000");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                aVar2.dismiss();
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agG() {
        View contentView;
        if (this.czq == null) {
            this.czq = new PopupWindow(this.acp.getPageActivity());
            contentView = LayoutInflater.from(this.acp.getContext()).inflate(d.j.speed_tip, (ViewGroup) null);
            this.czq.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.g.g.a(c.this.czq, c.this.acp.getPageActivity());
                    c.this.ckn.ciK = false;
                    com.baidu.tbadk.browser.a.a(c.this.acp.getPageActivity(), c.this.acp.getResources().getString(d.l.experion_speed), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                }
            });
            this.czq.setWidth(this.acp.getResources().getDimensionPixelSize(d.f.ds300));
            this.czq.setHeight(this.acp.getResources().getDimensionPixelSize(d.f.ds88));
            this.czq.setBackgroundDrawable(new BitmapDrawable());
            this.czq.setOutsideTouchable(true);
            this.czq.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.czq);
                        c.this.ckn.ciK = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.czq.getContentView();
        }
        this.acp.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.czp.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.czq, this.aZg, 0, (iArr[0] - (this.czq.getWidth() / 2)) + (this.czp.getWidth() / 2), iArr[1] + this.czp.getWidth());
        this.czq.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.czK = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.czK) {
                this.cyT.setText(d.l.level_up);
                if (f >= 1.0f) {
                    i = this.bri;
                } else {
                    i = this.bri + 1;
                }
                i afr = this.ckn.afr();
                if (afr != null && afr.aPh() != null) {
                    afr.aPh().setUser_level(i);
                }
                ai.c(this.cmP, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.cyT.setText(this.czx);
                ai.c(this.cmP, BitmapHelper.getSmallGradeResourceIdNew(this.bri));
            }
            this.cyU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iO(this.bri)));
            if (this.czK) {
                if (f >= 1.0f) {
                    a(this.ckn.getBaseFragmentActivity(), this.cyU, this.czL, f);
                } else {
                    b(this.ckn.getBaseFragmentActivity(), this.cyU, this.czL, f);
                }
            } else {
                a(this.ckn.getBaseFragmentActivity(), this.cyU, this.czL, f);
            }
            this.czL = f;
        }
    }

    private int[] iO(int i) {
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

    @Override // com.baidu.tieba.frs.view.b
    protected void agH() {
        this.czu.c(this.cyZ, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agI() {
        if (this.mMemberType != 0) {
            ai.c(this.czp, d.g.icon_sml_speed_orange);
        } else {
            ai.c(this.czp, d.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cmS);
        if (this.bly != null) {
            this.bly.onDestroy();
            this.bly = null;
        }
        if (this.aWV != null) {
            this.aWV.setBackgroundDrawable(null);
        }
        if (this.czr != null) {
            this.czr.removeCallbacks(this.blA);
        }
    }

    public FrsEntranceStoryListWrapperView agJ() {
        return this.cmN;
    }
}
