package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
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
    private String Xt;
    private RelativeLayout bbY;
    private final LinearLayout dcJ;
    private TextView dcK;
    private TextView dcL;
    private ImageView dcM;
    private String dcN;
    private String dcO;
    private FrsHeaderPraiseView dcQ;
    private String dcR;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dcS = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dcT = new CustomMessageListener(2003018) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dsJ != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cbY.setVisibility(8);
                } else {
                    c.this.cbY.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dcU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            boolean z = true;
            if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                if (c.this.mTabId == 202) {
                    if (StringUtils.isNull(c.this.dcO)) {
                        ax.wg().c(c.this.adf, new String[]{c.this.dcN});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.Xn()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dcO));
                        }
                    } else if (PluginPackageManager.iX().bw("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.adf.getPageActivity(), c.this.adf.getResources().getString(d.k.plugin_video_installing), 0).tL();
                        z = false;
                    } else {
                        ax.wg().c(c.this.adf, new String[]{c.this.dcN});
                        z = false;
                    }
                    al alVar = new al("c12838");
                    alVar.ac(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    alVar.ac(VideoPlayActivityConfig.OBJ_ID, c.this.dcO);
                    alVar.ac("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    alVar.ac("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(alVar);
                }
                ax.wg().c(c.this.adf, new String[]{c.this.dcN});
                z = false;
                al alVar2 = new al("c12838");
                alVar2.ac(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                alVar2.ac(VideoPlayActivityConfig.OBJ_ID, c.this.dcO);
                alVar2.ac("obj_type", c.this.mTabId != 201 ? "1" : "2");
                alVar2.ac("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(alVar2);
            }
        }
    };
    private ArrayList<TbImageView> dcP = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bbY = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cYC = frsFragment;
        this.adf = frsFragment.getPageContext();
        this.dsA = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.dsB = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.dsC = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = arx();
        this.bbY = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dsV = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.i.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dsY = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dcK = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dcL = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dsH = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dtC = (TextView) this.mParent.findViewById(d.g.level);
        this.dsF = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dsG = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dsG.setContentDescription(frsFragment.getResources().getString(d.k.sign));
        this.dsI = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dsD = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dsE = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dta = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.cWr = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dta.setPageId(this.cYC.getUniqueId());
        this.dta.setContentDescription(frsFragment.getResources().getString(d.k.bar_header));
        this.dta.setGifIconSupport(false);
        this.dta.setDrawerType(0);
        this.dsJ = LayoutInflater.from(this.cYC.getPageContext().getPageActivity()).inflate(d.i.frs_header_extra_entelechy, (ViewGroup) null);
        aro();
        aru();
        this.dsK = (ViewGroup) this.dsJ.findViewById(d.g.frs_header_games);
        this.dsL = (TextView) this.dsJ.findViewById(d.g.top_item_title);
        this.dsS = (LinearLayout) this.dsJ.findViewById(d.g.frs_present_root);
        this.dtE = (TextView) this.bbY.findViewById(d.g.new_chapter_btn);
        this.cbY = this.dsJ.findViewById(d.g.divider_bottom);
        this.dte = new e(this.adf, this.dsJ);
        this.dtd = new com.baidu.tieba.frs.f.b(this.adf);
        this.dsO = (ViewGroup) this.dsJ.findViewById(d.g.frs_headline);
        this.dsP = (TextView) this.dsO.findViewById(d.g.headline_title);
        this.dsQ = (TextView) this.dsO.findViewById(d.g.headline_text);
        this.dsR = (TbImageView) this.dsO.findViewById(d.g.headline_image);
        this.dsR.setPageId(this.cYC.getUniqueId());
        this.dsO.setVisibility(8);
        this.dtB = this.mParent.findViewById(d.g.level_container);
        this.dtA = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dtz = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dtD = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dcM = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dcM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.adf.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.gP()) {
                    l.showToast(c.this.adf.getPageActivity(), d.k.neterror);
                } else if (!StringUtils.isNull(c.this.dcR) && !StringUtils.isNull(c.this.mForumId)) {
                    ax.wg().c(c.this.adf, new String[]{c.this.dcR + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        arv();
        this.cYC.registerListener(this.dcT);
        this.dcH = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dcH.setContext(this.adf);
        this.dcJ = new LinearLayout(this.cYC.getContext());
        this.dcJ.setOrientation(1);
        this.dcJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dcJ.addView(this.dsN);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View art() {
        return this.dcJ;
    }

    private void aru() {
        this.dcQ = (FrsHeaderPraiseView) this.dsJ.findViewById(d.g.frs_praise_layout);
    }

    private void arv() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ae.class);
        if (runTask != null && runTask.getData() != null) {
            this.dtf = (ae) runTask.getData();
            this.dtf.a(this.adf, this.mParent, 1, false, this.cYC.getUniqueId());
            this.dtf.hide();
        }
    }

    private void arw() {
        final m bqA = this.dqL.bqA();
        if (bqA != null && this.dqL.aVq() != null) {
            final String id = this.dqL.aVq().getId();
            final String name = this.dqL.aVq().getName();
            if (this.dtx.add(bqA.qw())) {
                a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bqA.qw(), id, name, null);
                b.cd("obj_url", bqA.getUrl());
                b.save();
            }
            this.dsO.setVisibility(0);
            this.dsP.setText(bqA.getText());
            this.dsQ.setText(bqA.getTitle());
            this.dsR.startLoad(bqA.qv(), 10, false);
            this.dsO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.C0217a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bqA.qw(), id, name, null);
                    b2.cd("obj_url", bqA.getUrl());
                    b2.save();
                    ax.wg().c(c.this.cYC.getPageContext(), new String[]{bqA.getUrl()});
                }
            });
        }
    }

    protected View arx() {
        return LayoutInflater.from(this.cYC.getPageContext().getPageActivity()).inflate(d.i.frs_normal_header, (ViewGroup) null);
    }

    private void kt(int i) {
        if (i <= 0 || i > 5) {
            this.dcM.setVisibility(8);
            this.cWr.setMaxWidth(l.e(this.adf.getPageActivity(), d.e.ds370));
            return;
        }
        this.dcM.setVisibility(0);
        Drawable drawable = ak.getDrawable(this.dcS[i - 1]);
        this.dcM.setImageDrawable(drawable);
        this.cWr.setMaxWidth((l.e(this.adf.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dcM.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void n(View.OnClickListener onClickListener) {
        this.dta.setOnClickListener(onClickListener);
        this.cWr.setOnClickListener(onClickListener);
        this.dsG.setOnClickListener(onClickListener);
        this.dsF.setOnClickListener(onClickListener);
        this.dtB.setOnClickListener(onClickListener);
        if (this.dsK != null) {
            this.dsK.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.adf.getLayoutMode().setNightMode(i == 1);
        this.adf.getLayoutMode().u(this.mParent);
        this.adf.getLayoutMode().u(this.dsV);
        this.adf.getLayoutMode().u(this.dsJ);
        if (this.dtr) {
            lE(1);
        } else {
            lE(0);
        }
        this.dta.invalidate();
        ak.j(this.bbY, d.C0126d.cp_bg_line_d);
        ak.j(this.cbY, d.C0126d.cp_bg_line_e);
        ak.h(this.dtC, d.C0126d.cp_cont_j);
        ak.h(this.dsH, d.C0126d.cp_cont_j);
        ak.h(this.dcK, d.C0126d.cp_cont_j);
        ak.h(this.dsD, d.C0126d.cp_cont_j);
        ak.h(this.dcL, d.C0126d.cp_cont_j);
        ak.h(this.dsE, d.C0126d.cp_cont_j);
        this.dta.setBorderWidth(l.e(this.adf.getPageActivity(), d.e.tbds1));
        this.dta.setBorderColor(ak.getColor(d.C0126d.black_alpha15));
        arB();
        if (this.dsK != null) {
            ak.i(this.dsK, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ak.c(this.dsY, d.f.icon_sml_speed_orange);
        } else {
            ak.c(this.dsY, d.f.icon_sml_speed_gray);
        }
        if (this.dte != null) {
            this.dte.changeSkinType(i);
        }
        if (this.dtf != null) {
            this.dtf.changeSkinType(i);
        }
        if (this.dtb != null) {
            this.dtb.dz(i);
        }
        Iterator<TbImageView> it = this.dcP.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        arp();
        ak.i(this.dsO, d.f.home_thread_card_item_bg);
        ak.h(this.cWr, d.C0126d.cp_cont_b);
        if (this.dcG != null) {
            com.baidu.tbadk.n.a.a(this.cYC.getPageContext(), this.dcG);
        }
        if (this.dcQ.getVisibility() == 0) {
            this.dcQ.changeSkinType(i);
        }
        ak.i(this.dtE, d.f.btn_round_cont_d);
        ak.h(this.dtE, d.C0126d.btn_cont_j_alpha_20_selector);
        if (this.dsN != null) {
            ak.j(this.dsN, d.C0126d.cp_bg_line_e);
        }
        if (this.dcH != null && this.dcH.getVisibility() == 0) {
            this.dcH.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dtk = forumData.getPost_num();
            this.dth = forumData.getTag_color();
            this.Xt = forumData.getImage_url();
            this.dtg = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dtl = forumData.getSignData().count_sign_num;
                this.dtm = forumData.getSignData().miss_sign_num;
            }
            this.dtn = forumData.getCurScore();
            this.dqh = forumData.getLevelupScore();
            this.dtc = forumData.getBadgeData();
            this.dsT = forumData.getTopCode();
            this.dsU = forumData.getNewsInfo();
            this.dti = forumData.getAccelerateContent();
            this.dqL = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dtj = new bd();
            ary();
            arC();
            arw();
            this.dcQ.setVisibility(8);
            if (lVar != null && lVar.bpX() != null) {
                kt(lVar.bpX().grade.intValue());
                this.dcR = lVar.bpX().url;
            }
            if (lVar != null && lVar.guK != null) {
                FrsTabInfo frsTabInfo = lVar.guK;
                this.dcN = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dcO = frsTabInfo.tab_gid;
                this.dtE.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dtE.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        al alVar = new al("c12837");
                        alVar.ac(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.dcO);
                        alVar.ac("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(alVar);
                    }
                }
                this.dtE.setOnClickListener(this.dcU);
            } else {
                this.dtE.setVisibility(8);
            }
            if (lVar != null && lVar.guL != null) {
                this.dcH.setData(lVar.guL);
                this.dcH.setVisibility(0);
                this.dtD.setPadding(0, this.dtD.getPaddingTop(), 0, 0);
                return;
            }
            this.dcH.setVisibility(8);
        }
    }

    protected void ary() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.Xt);
        this.dtj.sa().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void arz() {
        int e = l.e(this.adf.getPageActivity(), d.e.tbds32);
        if (this.dtm > 0) {
            ak.c(this.dsG, d.C0126d.cp_cont_i, 1);
            Drawable drawable = ak.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, e, e);
            int e2 = l.e(this.adf.getPageActivity(), d.e.tbds24);
            this.dsG.setPadding(e2, 0, e2, 0);
            this.dsG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dsG.setText(String.format(this.adf.getString(d.k.miss_sign_days), Integer.valueOf(this.dtm)));
            ak.i(this.dsG, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = ak.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, e, e);
            this.dsG.setCompoundDrawables(drawable2, null, null, null);
            ak.c(this.dsG, d.C0126d.cp_cont_e, 1);
            this.dsG.setText(this.adf.getString(d.k.signed));
            this.dsG.setPadding(0, 0, 0, 0);
            this.dsG.setBackgroundDrawable(null);
        }
        this.dsG.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dsG.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void arA() {
        int e = l.e(this.adf.getPageActivity(), d.e.tbds32);
        Drawable drawable = ak.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dsG.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dsG.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        ak.c(this.dsG, d.C0126d.cp_cont_i, 1);
        ak.i(this.dsG, d.f.frs_attention_btn_bg_selector);
    }

    protected void arB() {
        int e = l.e(this.adf.getPageActivity(), d.e.tbds32);
        Drawable drawable = ak.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dsF.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dsF.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        ak.c(this.dsF, d.C0126d.cp_cont_g, 1);
        ak.i(this.dsF, d.f.frs_attention_btn_bg_selector);
    }

    protected void arC() {
        List<g> list = null;
        if (this.dsD != null) {
            this.dsD.setText(an.y(this.mMemberNum));
        }
        if (this.dsE != null) {
            this.dsE.setText(an.y(this.dtk));
        }
        if (this.dtc != null && this.dtc.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.adf.getString(d.k.forum));
            }
            if (this.cWr != null) {
                this.cWr.setText(this.mForumName + this.adf.getString(d.k.forum));
            }
        }
        if (this.dsK != null && this.dsL != null) {
            if (this.dqL != null && this.dqL.bqj()) {
                if (com.baidu.tbadk.core.util.m.dT(this.dqL.bql()) == 1 && !n.agw) {
                    this.dsK.setVisibility(8);
                } else {
                    this.dsK.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dqL.getGameName()) && !TextUtils.isEmpty(this.dqL.getGameName().trim())) {
                        this.dsL.setText(UtilHelper.getFixedText(this.dqL.getGameName(), 10));
                        String ta = com.baidu.tieba.tbadkCore.util.b.ta(this.dqL.bql());
                        if (!StringUtils.isNull(ta)) {
                            TiebaStatic.eventStat(this.adf.getPageActivity(), "game_show", "show", 1, "dev_id", ta, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dsL.setText(this.adf.getResources().getString(d.k.frsgame_title));
                    }
                }
            } else {
                this.dsK.setVisibility(8);
            }
        }
        this.dsS.setVisibility(8);
        this.dte.a(null, null);
        if (this.dsK != null) {
            this.dsM = this.dsK.findViewById(d.g.top_item_divider);
        }
        arD();
        if (this.dqL != null && !v.w(this.dqL.bqk())) {
            list = this.dqL.bqk();
            bt(list);
        }
        bf(list);
    }

    protected void arD() {
        this.dta.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dta.startLoad(this.Xt, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void j(View view2, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dty);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.adf.getPageActivity());
                this.mPopup.setContentView(this.dsV);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.adf.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.adf.getResources().getDimensionPixelSize(d.e.ds100));
                this.dsW = (TextView) this.dsV.findViewById(d.g.cur_experience);
                this.dsX = (TextView) this.dsV.findViewById(d.g.levelup_experience);
                a(this.dsW, this.dsX);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.adf.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            a(this.dsW, this.dsX);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.adf.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dty, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.adf.getContext()).inflate(d.i.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            ak.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0126d.cp_cont_b, 1);
            ak.c(textView, d.C0126d.cp_cont_b, 1);
            ak.c(textView2, d.C0126d.cp_cont_b, 1);
            ak.c(textView3, d.C0126d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
            aVar.w(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dti) && !TextUtils.isEmpty(this.dti.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dti);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ca(d.C0126d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.adf);
            aVar.tD();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (c.this.adf != null && c.this.adf.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.adf.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void arE() {
        View contentView;
        if (this.dsZ == null) {
            this.dsZ = new PopupWindow(this.adf.getPageActivity());
            contentView = LayoutInflater.from(this.adf.getContext()).inflate(d.i.speed_tip, (ViewGroup) null);
            this.dsZ.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.adf != null && c.this.adf.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dsZ, c.this.adf.getPageActivity());
                        c.this.cYC.cWV = false;
                        com.baidu.tbadk.browser.a.a(c.this.adf.getPageActivity(), c.this.adf.getResources().getString(d.k.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dsZ.setWidth(this.adf.getResources().getDimensionPixelSize(d.e.ds300));
            this.dsZ.setHeight(this.adf.getResources().getDimensionPixelSize(d.e.ds88));
            this.dsZ.setBackgroundDrawable(new BitmapDrawable());
            this.dsZ.setOutsideTouchable(true);
            this.dsZ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dsZ);
                        c.this.cYC.cWV = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dsZ.getContentView();
        }
        this.adf.getLayoutMode().u(contentView);
        int[] iArr = new int[2];
        this.dsY.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dsZ, this.mParent, 0, (iArr[0] - (this.dsZ.getWidth() / 2)) + (this.dsY.getWidth() / 2), iArr[1] + this.dsY.getWidth());
        this.dsZ.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.dts = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dts) {
                this.dsH.setText(d.k.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l apE = this.cYC.apE();
                if (apE != null && apE.aVq() != null) {
                    apE.aVq().setUser_level(i);
                }
                this.dtC.setText(this.adf.getResources().getString(d.k.lv_num, Integer.valueOf(i)));
            } else {
                this.dsH.setText(this.dtg);
                this.dtC.setText(this.adf.getResources().getString(d.k.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dsI.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ku(this.mLevel)));
            if (this.dts) {
                if (f >= 1.0f) {
                    a(this.cYC.getBaseFragmentActivity(), this.dsI, this.dtt, f);
                } else {
                    b(this.cYC.getBaseFragmentActivity(), this.dsI, this.dtt, f);
                }
            } else {
                a(this.cYC.getBaseFragmentActivity(), this.dsI, this.dtt, f);
            }
            this.dtt = f;
        }
    }

    private int[] ku(int i) {
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
    protected void arF() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void arG() {
        if (this.mMemberType != 0) {
            ak.c(this.dsY, d.f.icon_sml_speed_orange);
        } else {
            ak.c(this.dsY, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dcT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xn() {
        Activity pageActivity = this.adf.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.wu();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.c.9
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0088a
            public void eA(String str) {
                ax.wg().c(c.this.adf, new String[]{c.this.dcN});
            }

            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0088a
            public void eB(String str) {
            }
        });
        return aVar.v(pageActivity);
    }

    public String qA() {
        return this.dcO;
    }

    public String arH() {
        return this.dcN;
    }
}
