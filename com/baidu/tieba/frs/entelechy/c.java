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
    private final LinearLayout dcM;
    private TextView dcN;
    private TextView dcO;
    private ImageView dcP;
    private String dcQ;
    private String dcR;
    private FrsHeaderPraiseView dcT;
    private String dcU;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dcV = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dcW = new CustomMessageListener(2003018) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dsM != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.ccb.setVisibility(8);
                } else {
                    c.this.ccb.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dcX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
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
                    if (StringUtils.isNull(c.this.dcR)) {
                        ax.wg().c(c.this.adf, new String[]{c.this.dcQ});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.Xn()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dcR));
                        }
                    } else if (PluginPackageManager.iX().bw("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.adf.getPageActivity(), c.this.adf.getResources().getString(d.k.plugin_video_installing), 0).tL();
                        z = false;
                    } else {
                        ax.wg().c(c.this.adf, new String[]{c.this.dcQ});
                        z = false;
                    }
                    al alVar = new al("c12838");
                    alVar.ac(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    alVar.ac(VideoPlayActivityConfig.OBJ_ID, c.this.dcR);
                    alVar.ac("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    alVar.ac("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(alVar);
                }
                ax.wg().c(c.this.adf, new String[]{c.this.dcQ});
                z = false;
                al alVar2 = new al("c12838");
                alVar2.ac(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                alVar2.ac(VideoPlayActivityConfig.OBJ_ID, c.this.dcR);
                alVar2.ac("obj_type", c.this.mTabId != 201 ? "1" : "2");
                alVar2.ac("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(alVar2);
            }
        }
    };
    private ArrayList<TbImageView> dcS = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bbY = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cYF = frsFragment;
        this.adf = frsFragment.getPageContext();
        this.dsD = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.dsE = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.dsF = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = arx();
        this.bbY = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dsY = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.i.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dtb = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dcN = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dcO = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dsK = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dtF = (TextView) this.mParent.findViewById(d.g.level);
        this.dsI = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dsJ = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dsJ.setContentDescription(frsFragment.getResources().getString(d.k.sign));
        this.dsL = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dsG = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dsH = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dtd = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.cWu = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dtd.setPageId(this.cYF.getUniqueId());
        this.dtd.setContentDescription(frsFragment.getResources().getString(d.k.bar_header));
        this.dtd.setGifIconSupport(false);
        this.dtd.setDrawerType(0);
        this.dsM = LayoutInflater.from(this.cYF.getPageContext().getPageActivity()).inflate(d.i.frs_header_extra_entelechy, (ViewGroup) null);
        aro();
        aru();
        this.dsN = (ViewGroup) this.dsM.findViewById(d.g.frs_header_games);
        this.dsO = (TextView) this.dsM.findViewById(d.g.top_item_title);
        this.dsV = (LinearLayout) this.dsM.findViewById(d.g.frs_present_root);
        this.dtH = (TextView) this.bbY.findViewById(d.g.new_chapter_btn);
        this.ccb = this.dsM.findViewById(d.g.divider_bottom);
        this.dth = new e(this.adf, this.dsM);
        this.dtg = new com.baidu.tieba.frs.f.b(this.adf);
        this.dsR = (ViewGroup) this.dsM.findViewById(d.g.frs_headline);
        this.dsS = (TextView) this.dsR.findViewById(d.g.headline_title);
        this.dsT = (TextView) this.dsR.findViewById(d.g.headline_text);
        this.dsU = (TbImageView) this.dsR.findViewById(d.g.headline_image);
        this.dsU.setPageId(this.cYF.getUniqueId());
        this.dsR.setVisibility(8);
        this.dtE = this.mParent.findViewById(d.g.level_container);
        this.dtD = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dtC = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dtG = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dcP = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dcP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.adf.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.gP()) {
                    l.showToast(c.this.adf.getPageActivity(), d.k.neterror);
                } else if (!StringUtils.isNull(c.this.dcU) && !StringUtils.isNull(c.this.mForumId)) {
                    ax.wg().c(c.this.adf, new String[]{c.this.dcU + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        arv();
        this.cYF.registerListener(this.dcW);
        this.dcK = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dcK.setContext(this.adf);
        this.dcM = new LinearLayout(this.cYF.getContext());
        this.dcM.setOrientation(1);
        this.dcM.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dcM.addView(this.dsQ);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View art() {
        return this.dcM;
    }

    private void aru() {
        this.dcT = (FrsHeaderPraiseView) this.dsM.findViewById(d.g.frs_praise_layout);
    }

    private void arv() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ae.class);
        if (runTask != null && runTask.getData() != null) {
            this.dti = (ae) runTask.getData();
            this.dti.a(this.adf, this.mParent, 1, false, this.cYF.getUniqueId());
            this.dti.hide();
        }
    }

    private void arw() {
        final m bqA = this.dqO.bqA();
        if (bqA != null && this.dqO.aVq() != null) {
            final String id = this.dqO.aVq().getId();
            final String name = this.dqO.aVq().getName();
            if (this.dtA.add(bqA.qw())) {
                a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bqA.qw(), id, name, null);
                b.cd("obj_url", bqA.getUrl());
                b.save();
            }
            this.dsR.setVisibility(0);
            this.dsS.setText(bqA.getText());
            this.dsT.setText(bqA.getTitle());
            this.dsU.startLoad(bqA.qv(), 10, false);
            this.dsR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.C0217a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bqA.qw(), id, name, null);
                    b2.cd("obj_url", bqA.getUrl());
                    b2.save();
                    ax.wg().c(c.this.cYF.getPageContext(), new String[]{bqA.getUrl()});
                }
            });
        }
    }

    protected View arx() {
        return LayoutInflater.from(this.cYF.getPageContext().getPageActivity()).inflate(d.i.frs_normal_header, (ViewGroup) null);
    }

    private void ku(int i) {
        if (i <= 0 || i > 5) {
            this.dcP.setVisibility(8);
            this.cWu.setMaxWidth(l.e(this.adf.getPageActivity(), d.e.ds370));
            return;
        }
        this.dcP.setVisibility(0);
        Drawable drawable = ak.getDrawable(this.dcV[i - 1]);
        this.dcP.setImageDrawable(drawable);
        this.cWu.setMaxWidth((l.e(this.adf.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dcP.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void n(View.OnClickListener onClickListener) {
        this.dtd.setOnClickListener(onClickListener);
        this.cWu.setOnClickListener(onClickListener);
        this.dsJ.setOnClickListener(onClickListener);
        this.dsI.setOnClickListener(onClickListener);
        this.dtE.setOnClickListener(onClickListener);
        if (this.dsN != null) {
            this.dsN.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.adf.getLayoutMode().setNightMode(i == 1);
        this.adf.getLayoutMode().u(this.mParent);
        this.adf.getLayoutMode().u(this.dsY);
        this.adf.getLayoutMode().u(this.dsM);
        if (this.dtu) {
            lF(1);
        } else {
            lF(0);
        }
        this.dtd.invalidate();
        ak.j(this.bbY, d.C0126d.cp_bg_line_d);
        ak.j(this.ccb, d.C0126d.cp_bg_line_e);
        ak.h(this.dtF, d.C0126d.cp_cont_j);
        ak.h(this.dsK, d.C0126d.cp_cont_j);
        ak.h(this.dcN, d.C0126d.cp_cont_j);
        ak.h(this.dsG, d.C0126d.cp_cont_j);
        ak.h(this.dcO, d.C0126d.cp_cont_j);
        ak.h(this.dsH, d.C0126d.cp_cont_j);
        this.dtd.setBorderWidth(l.e(this.adf.getPageActivity(), d.e.tbds1));
        this.dtd.setBorderColor(ak.getColor(d.C0126d.black_alpha15));
        arB();
        if (this.dsN != null) {
            ak.i(this.dsN, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ak.c(this.dtb, d.f.icon_sml_speed_orange);
        } else {
            ak.c(this.dtb, d.f.icon_sml_speed_gray);
        }
        if (this.dth != null) {
            this.dth.changeSkinType(i);
        }
        if (this.dti != null) {
            this.dti.changeSkinType(i);
        }
        if (this.dte != null) {
            this.dte.dA(i);
        }
        Iterator<TbImageView> it = this.dcS.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        arp();
        ak.i(this.dsR, d.f.home_thread_card_item_bg);
        ak.h(this.cWu, d.C0126d.cp_cont_b);
        if (this.dcJ != null) {
            com.baidu.tbadk.n.a.a(this.cYF.getPageContext(), this.dcJ);
        }
        if (this.dcT.getVisibility() == 0) {
            this.dcT.changeSkinType(i);
        }
        ak.i(this.dtH, d.f.btn_round_cont_d);
        ak.h(this.dtH, d.C0126d.btn_cont_j_alpha_20_selector);
        if (this.dsQ != null) {
            ak.j(this.dsQ, d.C0126d.cp_bg_line_e);
        }
        if (this.dcK != null && this.dcK.getVisibility() == 0) {
            this.dcK.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dtn = forumData.getPost_num();
            this.dtk = forumData.getTag_color();
            this.Xt = forumData.getImage_url();
            this.dtj = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dto = forumData.getSignData().count_sign_num;
                this.dtp = forumData.getSignData().miss_sign_num;
            }
            this.dtq = forumData.getCurScore();
            this.dqk = forumData.getLevelupScore();
            this.dtf = forumData.getBadgeData();
            this.dsW = forumData.getTopCode();
            this.dsX = forumData.getNewsInfo();
            this.dtl = forumData.getAccelerateContent();
            this.dqO = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dtm = new bd();
            ary();
            arC();
            arw();
            this.dcT.setVisibility(8);
            if (lVar != null && lVar.bpX() != null) {
                ku(lVar.bpX().grade.intValue());
                this.dcU = lVar.bpX().url;
            }
            if (lVar != null && lVar.guN != null) {
                FrsTabInfo frsTabInfo = lVar.guN;
                this.dcQ = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dcR = frsTabInfo.tab_gid;
                this.dtH.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dtH.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        al alVar = new al("c12837");
                        alVar.ac(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.dcR);
                        alVar.ac("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(alVar);
                    }
                }
                this.dtH.setOnClickListener(this.dcX);
            } else {
                this.dtH.setVisibility(8);
            }
            if (lVar != null && lVar.guO != null) {
                this.dcK.setData(lVar.guO);
                this.dcK.setVisibility(0);
                this.dtG.setPadding(0, this.dtG.getPaddingTop(), 0, 0);
                return;
            }
            this.dcK.setVisibility(8);
        }
    }

    protected void ary() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.Xt);
        this.dtm.sa().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void arz() {
        int e = l.e(this.adf.getPageActivity(), d.e.tbds32);
        if (this.dtp > 0) {
            ak.c(this.dsJ, d.C0126d.cp_cont_i, 1);
            Drawable drawable = ak.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, e, e);
            int e2 = l.e(this.adf.getPageActivity(), d.e.tbds24);
            this.dsJ.setPadding(e2, 0, e2, 0);
            this.dsJ.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dsJ.setText(String.format(this.adf.getString(d.k.miss_sign_days), Integer.valueOf(this.dtp)));
            ak.i(this.dsJ, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = ak.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, e, e);
            this.dsJ.setCompoundDrawables(drawable2, null, null, null);
            ak.c(this.dsJ, d.C0126d.cp_cont_e, 1);
            this.dsJ.setText(this.adf.getString(d.k.signed));
            this.dsJ.setPadding(0, 0, 0, 0);
            this.dsJ.setBackgroundDrawable(null);
        }
        this.dsJ.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dsJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void arA() {
        int e = l.e(this.adf.getPageActivity(), d.e.tbds32);
        Drawable drawable = ak.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dsJ.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dsJ.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        ak.c(this.dsJ, d.C0126d.cp_cont_i, 1);
        ak.i(this.dsJ, d.f.frs_attention_btn_bg_selector);
    }

    protected void arB() {
        int e = l.e(this.adf.getPageActivity(), d.e.tbds32);
        Drawable drawable = ak.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dsI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dsI.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        ak.c(this.dsI, d.C0126d.cp_cont_g, 1);
        ak.i(this.dsI, d.f.frs_attention_btn_bg_selector);
    }

    protected void arC() {
        List<g> list = null;
        if (this.dsG != null) {
            this.dsG.setText(an.y(this.mMemberNum));
        }
        if (this.dsH != null) {
            this.dsH.setText(an.y(this.dtn));
        }
        if (this.dtf != null && this.dtf.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.adf.getString(d.k.forum));
            }
            if (this.cWu != null) {
                this.cWu.setText(this.mForumName + this.adf.getString(d.k.forum));
            }
        }
        if (this.dsN != null && this.dsO != null) {
            if (this.dqO != null && this.dqO.bqj()) {
                if (com.baidu.tbadk.core.util.m.dT(this.dqO.bql()) == 1 && !n.agw) {
                    this.dsN.setVisibility(8);
                } else {
                    this.dsN.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dqO.getGameName()) && !TextUtils.isEmpty(this.dqO.getGameName().trim())) {
                        this.dsO.setText(UtilHelper.getFixedText(this.dqO.getGameName(), 10));
                        String ta = com.baidu.tieba.tbadkCore.util.b.ta(this.dqO.bql());
                        if (!StringUtils.isNull(ta)) {
                            TiebaStatic.eventStat(this.adf.getPageActivity(), "game_show", "show", 1, "dev_id", ta, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dsO.setText(this.adf.getResources().getString(d.k.frsgame_title));
                    }
                }
            } else {
                this.dsN.setVisibility(8);
            }
        }
        this.dsV.setVisibility(8);
        this.dth.a(null, null);
        if (this.dsN != null) {
            this.dsP = this.dsN.findViewById(d.g.top_item_divider);
        }
        arD();
        if (this.dqO != null && !v.w(this.dqO.bqk())) {
            list = this.dqO.bqk();
            bt(list);
        }
        bf(list);
    }

    protected void arD() {
        this.dtd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dtd.startLoad(this.Xt, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void j(View view2, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dtB);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.adf.getPageActivity());
                this.mPopup.setContentView(this.dsY);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.adf.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.adf.getResources().getDimensionPixelSize(d.e.ds100));
                this.dsZ = (TextView) this.dsY.findViewById(d.g.cur_experience);
                this.dta = (TextView) this.dsY.findViewById(d.g.levelup_experience);
                a(this.dsZ, this.dta);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.adf.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            a(this.dsZ, this.dta);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.adf.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dtB, 2000L);
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
            if (!TextUtils.isEmpty(this.dtl) && !TextUtils.isEmpty(this.dtl.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dtl);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cb(d.C0126d.cp_link_tip_d);
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
        if (this.dtc == null) {
            this.dtc = new PopupWindow(this.adf.getPageActivity());
            contentView = LayoutInflater.from(this.adf.getContext()).inflate(d.i.speed_tip, (ViewGroup) null);
            this.dtc.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.adf != null && c.this.adf.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dtc, c.this.adf.getPageActivity());
                        c.this.cYF.cWY = false;
                        com.baidu.tbadk.browser.a.a(c.this.adf.getPageActivity(), c.this.adf.getResources().getString(d.k.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dtc.setWidth(this.adf.getResources().getDimensionPixelSize(d.e.ds300));
            this.dtc.setHeight(this.adf.getResources().getDimensionPixelSize(d.e.ds88));
            this.dtc.setBackgroundDrawable(new BitmapDrawable());
            this.dtc.setOutsideTouchable(true);
            this.dtc.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dtc);
                        c.this.cYF.cWY = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dtc.getContentView();
        }
        this.adf.getLayoutMode().u(contentView);
        int[] iArr = new int[2];
        this.dtb.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dtc, this.mParent, 0, (iArr[0] - (this.dtc.getWidth() / 2)) + (this.dtb.getWidth() / 2), iArr[1] + this.dtb.getWidth());
        this.dtc.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.dtv = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dtv) {
                this.dsK.setText(d.k.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l apE = this.cYF.apE();
                if (apE != null && apE.aVq() != null) {
                    apE.aVq().setUser_level(i);
                }
                this.dtF.setText(this.adf.getResources().getString(d.k.lv_num, Integer.valueOf(i)));
            } else {
                this.dsK.setText(this.dtj);
                this.dtF.setText(this.adf.getResources().getString(d.k.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dsL.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, kv(this.mLevel)));
            if (this.dtv) {
                if (f >= 1.0f) {
                    a(this.cYF.getBaseFragmentActivity(), this.dsL, this.dtw, f);
                } else {
                    b(this.cYF.getBaseFragmentActivity(), this.dsL, this.dtw, f);
                }
            } else {
                a(this.cYF.getBaseFragmentActivity(), this.dsL, this.dtw, f);
            }
            this.dtw = f;
        }
    }

    private int[] kv(int i) {
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
            ak.c(this.dtb, d.f.icon_sml_speed_orange);
        } else {
            ak.c(this.dtb, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dcW);
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
                ax.wg().c(c.this.adf, new String[]{c.this.dcQ});
            }

            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0088a
            public void eB(String str) {
            }
        });
        return aVar.v(pageActivity);
    }

    public String qA() {
        return this.dcR;
    }

    public String arH() {
        return this.dcQ;
    }
}
