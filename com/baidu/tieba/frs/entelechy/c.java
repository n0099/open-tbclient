package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.NovelMainActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.e;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c extends a {
    private String afK;
    private RelativeLayout blJ;
    private final LinearLayout dqq;
    private TextView dqr;
    private TextView dqs;
    private ImageView dqt;
    private String dqu;
    private String dqv;
    private FrsHeaderPraiseView dqx;
    private String dqy;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dqz = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private View.OnClickListener dqA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
        /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            boolean z = true;
            if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                if (c.this.mTabId == 202) {
                    if (StringUtils.isNull(c.this.dqv)) {
                        az.zV().c(c.this.mContext, new String[]{c.this.dqu});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.abu()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dqv));
                        }
                    } else if (PluginPackageManager.lL().bK("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xv();
                        z = false;
                    } else {
                        az.zV().c(c.this.mContext, new String[]{c.this.dqu});
                        z = false;
                    }
                    an anVar = new an("c12838");
                    anVar.ah(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    anVar.ah(VideoPlayActivityConfig.OBJ_ID, c.this.dqv);
                    anVar.ah("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    anVar.ah("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(anVar);
                }
                az.zV().c(c.this.mContext, new String[]{c.this.dqu});
                z = false;
                an anVar2 = new an("c12838");
                anVar2.ah(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                anVar2.ah(VideoPlayActivityConfig.OBJ_ID, c.this.dqv);
                anVar2.ah("obj_type", c.this.mTabId != 201 ? "1" : "2");
                anVar2.ah("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(anVar2);
            }
        }
    };
    private ArrayList<TbImageView> dqw = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.blJ = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dla = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dGi = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.dGj = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.dGk = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = awd();
        this.blJ = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dGE = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.i.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dGH = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dqr = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dqs = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dGp = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dHn = (TextView) this.mParent.findViewById(d.g.level);
        this.dGn = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dGo = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dGo.setContentDescription(frsFragment.getResources().getString(d.k.sign));
        this.dGq = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dGr = (ImageView) this.mParent.findViewById(d.g.love_level_bg);
        this.dGl = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dGm = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dGJ = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.diC = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dHe = (TextView) this.mParent.findViewById(d.g.brand_label);
        this.dGJ.setPageId(this.dla.getUniqueId());
        this.dGJ.setContentDescription(frsFragment.getResources().getString(d.k.bar_header));
        this.dGJ.setGifIconSupport(false);
        this.dGJ.setDrawerType(0);
        this.dGs = LayoutInflater.from(this.dla.getPageContext().getPageActivity()).inflate(d.i.frs_header_extra_entelechy, (ViewGroup) null);
        avU();
        awa();
        this.dGt = (ViewGroup) this.dGs.findViewById(d.g.frs_header_games);
        this.dGu = (TextView) this.dGs.findViewById(d.g.top_item_title);
        this.dGB = (LinearLayout) this.dGs.findViewById(d.g.frs_present_root);
        this.dHp = (TextView) this.blJ.findViewById(d.g.new_chapter_btn);
        this.dGN = new e(this.mContext, this.dGs);
        this.dGM = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dGx = (ViewGroup) this.dGs.findViewById(d.g.frs_headline);
        this.dGy = (TextView) this.dGx.findViewById(d.g.headline_title);
        this.dGz = (TextView) this.dGx.findViewById(d.g.headline_text);
        this.dGA = (TbImageView) this.dGx.findViewById(d.g.headline_image);
        this.dGA.setPageId(this.dla.getUniqueId());
        this.dGx.setVisibility(8);
        this.dHm = this.mParent.findViewById(d.g.level_container);
        this.dHl = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dHk = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dHo = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dqt = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dqt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.jD()) {
                    l.showToast(c.this.mContext.getPageActivity(), d.k.neterror);
                } else if (!StringUtils.isNull(c.this.dqy) && !StringUtils.isNull(c.this.mForumId)) {
                    az.zV().c(c.this.mContext, new String[]{c.this.dqy + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        awb();
        this.dqn = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dqn.setContext(this.mContext);
        this.dqq = new LinearLayout(this.dla.getContext());
        this.dqq.setOrientation(1);
        this.dqq.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dqq.addView(this.dGw);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View avZ() {
        return this.dqq;
    }

    private void awa() {
        this.dqx = (FrsHeaderPraiseView) this.dGs.findViewById(d.g.frs_praise_layout);
    }

    private void awb() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.dGO = (ag) runTask.getData();
            this.dGO.a(this.mContext, this.mParent, 1, false, this.dla.getUniqueId());
            this.dGO.hide();
        }
    }

    private void awc() {
        final m bvY = this.dEs.bvY();
        if (bvY != null && this.dEs.baT() != null) {
            final String id = this.dEs.baT().getId();
            final String name = this.dEs.baT().getName();
            if (this.dHi.add(bvY.tX())) {
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bvY.tX(), id, name, null);
                b.cp("obj_url", bvY.getUrl());
                b.save();
            }
            this.dGx.setVisibility(0);
            this.dGy.setText(bvY.getText());
            this.dGz.setText(bvY.getTitle());
            this.dGA.startLoad(bvY.tW(), 10, false);
            this.dGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0236a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bvY.tX(), id, name, null);
                    b2.cp("obj_url", bvY.getUrl());
                    b2.save();
                    az.zV().c(c.this.dla.getPageContext(), new String[]{bvY.getUrl()});
                }
            });
        }
    }

    protected View awd() {
        return LayoutInflater.from(this.dla.getPageContext().getPageActivity()).inflate(d.i.frs_normal_header, (ViewGroup) null);
    }

    private void kE(int i) {
        if (i <= 0 || i > 5 || this.dHc) {
            this.dqt.setVisibility(8);
            this.diC.setMaxWidth(l.e(this.mContext.getPageActivity(), d.e.ds370));
            return;
        }
        this.dqt.setVisibility(0);
        Drawable drawable = am.getDrawable(this.dqz[i - 1]);
        this.dqt.setImageDrawable(drawable);
        this.diC.setMaxWidth((l.e(this.mContext.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dqt.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void q(View.OnClickListener onClickListener) {
        this.dGJ.setOnClickListener(onClickListener);
        this.diC.setOnClickListener(onClickListener);
        this.dGo.setOnClickListener(onClickListener);
        this.dGn.setOnClickListener(onClickListener);
        this.dHm.setOnClickListener(onClickListener);
        if (this.dGt != null) {
            this.dGt.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awe() {
        am.j(this.dHo, d.C0142d.black_alpha0);
        am.j(this.blJ, d.C0142d.black_alpha0);
        am.h(this.diC, d.C0142d.cp_cont_i);
        am.h(this.dGp, d.C0142d.cp_cont_i);
        am.h(this.dHn, d.C0142d.cp_cont_i);
        am.i(this.dHe, d.f.enter_forum_brand_label_bg_shape);
        am.h(this.dHe, d.C0142d.cp_cont_i);
        am.h(this.dqr, d.C0142d.cp_cont_i);
        am.h(this.dGl, d.C0142d.cp_cont_i);
        am.h(this.dqs, d.C0142d.cp_cont_i);
        am.h(this.dGm, d.C0142d.cp_cont_i);
        am.j(this.dGr, d.C0142d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awf() {
        this.dHe.setVisibility(0);
        this.dqt.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.dGE);
        this.mContext.getLayoutMode().onModeChanged(this.dGs);
        if (this.dHa) {
            lR(1);
        } else {
            lR(0);
        }
        this.dGJ.invalidate();
        am.j(this.blJ, d.C0142d.cp_bg_line_d);
        am.h(this.dHn, d.C0142d.cp_cont_j);
        am.h(this.dGp, d.C0142d.cp_cont_j);
        am.h(this.dqr, d.C0142d.cp_cont_j);
        am.h(this.dGl, d.C0142d.cp_cont_j);
        am.h(this.dqs, d.C0142d.cp_cont_j);
        am.h(this.dGm, d.C0142d.cp_cont_j);
        this.dGJ.setBorderWidth(l.e(this.mContext.getPageActivity(), d.e.tbds1));
        this.dGJ.setBorderColor(am.getColor(d.C0142d.black_alpha15));
        awj();
        if (this.dGt != null) {
            am.i(this.dGt, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            am.c(this.dGH, d.f.icon_sml_speed_orange);
        } else {
            am.c(this.dGH, d.f.icon_sml_speed_gray);
        }
        if (this.dGN != null) {
            this.dGN.changeSkinType(i);
        }
        if (this.dGO != null) {
            this.dGO.changeSkinType(i);
        }
        if (this.dGK != null) {
            this.dGK.dD(i);
        }
        Iterator<TbImageView> it = this.dqw.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        avV();
        am.i(this.dGx, d.f.home_thread_card_item_bg);
        am.h(this.diC, d.C0142d.cp_cont_b);
        if (this.dqm != null) {
            com.baidu.tbadk.n.a.a(this.dla.getPageContext(), this.dqm);
        }
        if (this.dqx.getVisibility() == 0) {
            this.dqx.changeSkinType(i);
        }
        am.i(this.dHp, d.f.btn_round_cont_d);
        am.h(this.dHp, d.C0142d.btn_cont_j_alpha_20_selector);
        am.j(this.dGr, d.C0142d.common_color_10043);
        if (this.dqn != null && this.dqn.getVisibility() == 0) {
            this.dqn.onChangeSkinType();
        }
        if (this.dHc) {
            awe();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dGT = forumData.getPost_num();
            this.dGQ = forumData.getTag_color();
            this.afK = forumData.getImage_url();
            this.dGP = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dGU = forumData.getSignData().count_sign_num;
                this.dGV = forumData.getSignData().miss_sign_num;
            }
            this.dGW = forumData.getCurScore();
            this.dDN = forumData.getLevelupScore();
            this.dGL = forumData.getBadgeData();
            this.dGC = forumData.getTopCode();
            this.dGD = forumData.getNewsInfo();
            this.dGR = forumData.getAccelerateContent();
            this.dHc = forumData.isBrandForum;
            this.dEs = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dGS = new bc();
            awg();
            awk();
            awc();
            this.dqx.setVisibility(8);
            if (lVar != null && lVar.bvw() != null) {
                kE(lVar.bvw().grade.intValue());
                this.dqy = lVar.bvw().url;
            }
            if (lVar != null && lVar.gLg != null) {
                FrsTabInfo frsTabInfo = lVar.gLg;
                this.dqu = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dqv = frsTabInfo.tab_gid;
                this.dHp.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dHp.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        an anVar = new an("c12837");
                        anVar.ah(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        anVar.ah(VideoPlayActivityConfig.OBJ_ID, this.dqv);
                        anVar.ah("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(anVar);
                    }
                }
                this.dHp.setOnClickListener(this.dqA);
            } else {
                this.dHp.setVisibility(8);
            }
            if (lVar != null && lVar.gLh != null) {
                this.dqn.setData(lVar.gLh);
                this.dqn.setVisibility(0);
                this.dHo.setPadding(0, this.dHo.getPaddingTop(), 0, 0);
                return;
            }
            this.dqn.setVisibility(8);
        }
    }

    protected void awg() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.afK);
        this.dGS.vG().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void awh() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        if (this.dGV > 0) {
            am.c(this.dGo, d.C0142d.cp_cont_i, 1);
            Drawable drawable = am.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, e, e);
            int e2 = l.e(this.mContext.getPageActivity(), d.e.tbds24);
            this.dGo.setPadding(e2, 0, e2, 0);
            this.dGo.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dGo.setText(String.format(this.mContext.getString(d.k.miss_sign_days), Integer.valueOf(this.dGV)));
            am.i(this.dGo, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = am.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, e, e);
            this.dGo.setCompoundDrawables(drawable2, null, null, null);
            am.c(this.dGo, d.C0142d.cp_cont_e, 1);
            this.dGo.setText(this.mContext.getString(d.k.signed));
            this.dGo.setPadding(0, 0, 0, 0);
            this.dGo.setBackgroundDrawable(null);
        }
        this.dGo.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dGo.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void awi() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = am.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dGo.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dGo.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        am.c(this.dGo, d.C0142d.cp_cont_i, 1);
        am.i(this.dGo, d.f.frs_attention_btn_bg_selector);
    }

    protected void awj() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = am.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dGn.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dGn.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        am.c(this.dGn, d.C0142d.cp_cont_g, 1);
        am.i(this.dGn, d.f.frs_attention_btn_bg_selector);
    }

    protected void awk() {
        List<g> list = null;
        if (this.dGl != null) {
            this.dGl.setText(ap.C(this.mMemberNum));
        }
        if (this.dGm != null) {
            this.dGm.setText(ap.C(this.dGT));
        }
        if (this.dGL != null && this.dGL.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.cVn != null) {
                this.cVn.setText(this.mForumName + this.mContext.getString(d.k.forum));
            }
            if (this.diC != null) {
                this.diC.setText(this.mForumName + this.mContext.getString(d.k.forum));
            }
        }
        if (this.dGt != null && this.dGu != null) {
            if (this.dEs != null && this.dEs.bvI()) {
                if (n.ew(this.dEs.bvK()) == 1 && !o.apb) {
                    this.dGt.setVisibility(8);
                } else {
                    this.dGt.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dEs.getGameName()) && !TextUtils.isEmpty(this.dEs.getGameName().trim())) {
                        this.dGu.setText(UtilHelper.getFixedText(this.dEs.getGameName(), 10));
                        String tX = com.baidu.tieba.tbadkCore.util.b.tX(this.dEs.bvK());
                        if (!StringUtils.isNull(tX)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", tX, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dGu.setText(this.mContext.getResources().getString(d.k.frsgame_title));
                    }
                }
            } else {
                this.dGt.setVisibility(8);
            }
        }
        this.dGB.setVisibility(8);
        this.dGN.a(null, null);
        if (this.dGt != null) {
            this.dGv = this.dGt.findViewById(d.g.top_item_divider);
        }
        awl();
        if (this.dEs != null && !w.A(this.dEs.bvJ())) {
            list = this.dEs.bvJ();
            bD(list);
        }
        bo(list);
    }

    protected void awl() {
        this.dGJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dGJ.startLoad(this.afK, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void j(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dHj);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dGE);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds100));
                this.dGF = (TextView) this.dGE.findViewById(d.g.cur_experience);
                this.dGG = (TextView) this.dGE.findViewById(d.g.levelup_experience);
                a(this.dGF, this.dGG);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dGF, this.dGG);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dHj, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            am.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0142d.cp_cont_b, 1);
            am.c(textView, d.C0142d.cp_cont_b, 1);
            am.c(textView2, d.C0142d.cp_cont_b, 1);
            am.c(textView3, d.C0142d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.w(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dGR) && !TextUtils.isEmpty(this.dGR.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dGR);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ce(d.C0142d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.xn();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.mContext.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awm() {
        View contentView;
        if (this.dGI == null) {
            this.dGI = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.speed_tip, (ViewGroup) null);
            this.dGI.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dGI, c.this.mContext.getPageActivity());
                        c.this.dla.djn = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.k.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dGI.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds300));
            this.dGI.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds88));
            this.dGI.setBackgroundDrawable(new BitmapDrawable());
            this.dGI.setOutsideTouchable(true);
            this.dGI.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dGI);
                        c.this.dla.djn = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dGI.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.dGH.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dGI, this.mParent, 0, (iArr[0] - (this.dGI.getWidth() / 2)) + (this.dGH.getWidth() / 2), iArr[1] + this.dGH.getWidth());
        this.dGI.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.dHb = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dHb) {
                this.dGp.setText(d.k.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l atZ = this.dla.atZ();
                if (atZ != null && atZ.baT() != null) {
                    atZ.baT().setUser_level(i);
                }
                this.dHn.setText(this.mContext.getResources().getString(d.k.lv_num, Integer.valueOf(i)));
            } else {
                this.dGp.setText(this.dGP);
                this.dHn.setText(this.mContext.getResources().getString(d.k.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dGq.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, kF(this.mLevel)));
            if (this.dHb) {
                if (f >= 1.0f) {
                    a(this.dla.getBaseFragmentActivity(), this.dGq, this.dHd, f);
                } else {
                    b(this.dla.getBaseFragmentActivity(), this.dGq, this.dHd, f);
                }
            } else {
                a(this.dla.getBaseFragmentActivity(), this.dGq, this.dHd, f);
            }
            this.dHd = f;
        }
    }

    private int[] kF(int i) {
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
    protected void awn() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awo() {
        if (this.mMemberType != 0) {
            am.c(this.dGH, d.f.icon_sml_speed_orange);
        } else {
            am.c(this.dGH, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abu() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Aj();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0106a() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0106a
            public void fc(String str) {
                az.zV().c(c.this.mContext, new String[]{c.this.dqu});
            }

            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0106a
            public void fd(String str) {
            }
        });
        return aVar.u(pageActivity);
    }

    public String ub() {
        return this.dqv;
    }

    public String awp() {
        return this.dqu;
    }
}
