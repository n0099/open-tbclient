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
    private String Xu;
    private RelativeLayout bbZ;
    private final LinearLayout ddR;
    private TextView ddS;
    private TextView ddT;
    private ImageView ddU;
    private String ddV;
    private String ddW;
    private FrsHeaderPraiseView ddY;
    private String ddZ;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dea = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener deb = new CustomMessageListener(2003018) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dtR != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.ccV.setVisibility(8);
                } else {
                    c.this.ccV.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dec = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
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
                    if (StringUtils.isNull(c.this.ddW)) {
                        ax.wf().c(c.this.mContext, new String[]{c.this.ddV});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.Xp()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.ddW));
                        }
                    } else if (PluginPackageManager.iX().bw("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).tK();
                        z = false;
                    } else {
                        ax.wf().c(c.this.mContext, new String[]{c.this.ddV});
                        z = false;
                    }
                    al alVar = new al("c12838");
                    alVar.ac(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    alVar.ac(VideoPlayActivityConfig.OBJ_ID, c.this.ddW);
                    alVar.ac("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    alVar.ac("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(alVar);
                }
                ax.wf().c(c.this.mContext, new String[]{c.this.ddV});
                z = false;
                al alVar2 = new al("c12838");
                alVar2.ac(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                alVar2.ac(VideoPlayActivityConfig.OBJ_ID, c.this.ddW);
                alVar2.ac("obj_type", c.this.mTabId != 201 ? "1" : "2");
                alVar2.ac("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(alVar2);
            }
        }
    };
    private ArrayList<TbImageView> ddX = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bbZ = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cZJ = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dtI = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.dtJ = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.dtK = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = arw();
        this.bbZ = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dud = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.i.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dug = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.ddS = (TextView) this.mParent.findViewById(d.g.member_image);
        this.ddT = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dtP = (TextView) this.mParent.findViewById(d.g.level_name);
        this.duK = (TextView) this.mParent.findViewById(d.g.level);
        this.dtN = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dtO = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dtO.setContentDescription(frsFragment.getResources().getString(d.k.sign));
        this.dtQ = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dtL = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dtM = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dui = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.cXy = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dui.setPageId(this.cZJ.getUniqueId());
        this.dui.setContentDescription(frsFragment.getResources().getString(d.k.bar_header));
        this.dui.setGifIconSupport(false);
        this.dui.setDrawerType(0);
        this.dtR = LayoutInflater.from(this.cZJ.getPageContext().getPageActivity()).inflate(d.i.frs_header_extra_entelechy, (ViewGroup) null);
        arn();
        art();
        this.dtS = (ViewGroup) this.dtR.findViewById(d.g.frs_header_games);
        this.dtT = (TextView) this.dtR.findViewById(d.g.top_item_title);
        this.dua = (LinearLayout) this.dtR.findViewById(d.g.frs_present_root);
        this.duM = (TextView) this.bbZ.findViewById(d.g.new_chapter_btn);
        this.ccV = this.dtR.findViewById(d.g.divider_bottom);
        this.dum = new e(this.mContext, this.dtR);
        this.dul = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dtW = (ViewGroup) this.dtR.findViewById(d.g.frs_headline);
        this.dtX = (TextView) this.dtW.findViewById(d.g.headline_title);
        this.dtY = (TextView) this.dtW.findViewById(d.g.headline_text);
        this.dtZ = (TbImageView) this.dtW.findViewById(d.g.headline_image);
        this.dtZ.setPageId(this.cZJ.getUniqueId());
        this.dtW.setVisibility(8);
        this.duJ = this.mParent.findViewById(d.g.level_container);
        this.duI = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.duH = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.duL = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.ddU = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.ddU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new al("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.mContext.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.gP()) {
                    l.showToast(c.this.mContext.getPageActivity(), d.k.neterror);
                } else if (!StringUtils.isNull(c.this.ddZ) && !StringUtils.isNull(c.this.mForumId)) {
                    ax.wf().c(c.this.mContext, new String[]{c.this.ddZ + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        aru();
        this.cZJ.registerListener(this.deb);
        this.ddP = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.ddP.setContext(this.mContext);
        this.ddR = new LinearLayout(this.cZJ.getContext());
        this.ddR.setOrientation(1);
        this.ddR.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ddR.addView(this.dtV);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View ars() {
        return this.ddR;
    }

    private void art() {
        this.ddY = (FrsHeaderPraiseView) this.dtR.findViewById(d.g.frs_praise_layout);
    }

    private void aru() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ae.class);
        if (runTask != null && runTask.getData() != null) {
            this.dun = (ae) runTask.getData();
            this.dun.a(this.mContext, this.mParent, 1, false, this.cZJ.getUniqueId());
            this.dun.hide();
        }
    }

    private void arv() {
        final m bqy = this.drT.bqy();
        if (bqy != null && this.drT.aVq() != null) {
            final String id = this.drT.aVq().getId();
            final String name = this.drT.aVq().getName();
            if (this.duF.add(bqy.qv())) {
                a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bqy.qv(), id, name, null);
                b.cd("obj_url", bqy.getUrl());
                b.save();
            }
            this.dtW.setVisibility(0);
            this.dtX.setText(bqy.getText());
            this.dtY.setText(bqy.getTitle());
            this.dtZ.startLoad(bqy.qu(), 10, false);
            this.dtW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.C0217a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bqy.qv(), id, name, null);
                    b2.cd("obj_url", bqy.getUrl());
                    b2.save();
                    ax.wf().c(c.this.cZJ.getPageContext(), new String[]{bqy.getUrl()});
                }
            });
        }
    }

    protected View arw() {
        return LayoutInflater.from(this.cZJ.getPageContext().getPageActivity()).inflate(d.i.frs_normal_header, (ViewGroup) null);
    }

    private void ks(int i) {
        if (i <= 0 || i > 5) {
            this.ddU.setVisibility(8);
            this.cXy.setMaxWidth(l.e(this.mContext.getPageActivity(), d.e.ds370));
            return;
        }
        this.ddU.setVisibility(0);
        Drawable drawable = ak.getDrawable(this.dea[i - 1]);
        this.ddU.setImageDrawable(drawable);
        this.cXy.setMaxWidth((l.e(this.mContext.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.ddU.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void n(View.OnClickListener onClickListener) {
        this.dui.setOnClickListener(onClickListener);
        this.cXy.setOnClickListener(onClickListener);
        this.dtO.setOnClickListener(onClickListener);
        this.dtN.setOnClickListener(onClickListener);
        this.duJ.setOnClickListener(onClickListener);
        if (this.dtS != null) {
            this.dtS.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().u(this.mParent);
        this.mContext.getLayoutMode().u(this.dud);
        this.mContext.getLayoutMode().u(this.dtR);
        if (this.duz) {
            lD(1);
        } else {
            lD(0);
        }
        this.dui.invalidate();
        ak.j(this.bbZ, d.C0126d.cp_bg_line_d);
        ak.j(this.ccV, d.C0126d.cp_bg_line_e);
        ak.h(this.duK, d.C0126d.cp_cont_j);
        ak.h(this.dtP, d.C0126d.cp_cont_j);
        ak.h(this.ddS, d.C0126d.cp_cont_j);
        ak.h(this.dtL, d.C0126d.cp_cont_j);
        ak.h(this.ddT, d.C0126d.cp_cont_j);
        ak.h(this.dtM, d.C0126d.cp_cont_j);
        this.dui.setBorderWidth(l.e(this.mContext.getPageActivity(), d.e.tbds1));
        this.dui.setBorderColor(ak.getColor(d.C0126d.black_alpha15));
        arA();
        if (this.dtS != null) {
            ak.i(this.dtS, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ak.c(this.dug, d.f.icon_sml_speed_orange);
        } else {
            ak.c(this.dug, d.f.icon_sml_speed_gray);
        }
        if (this.dum != null) {
            this.dum.changeSkinType(i);
        }
        if (this.dun != null) {
            this.dun.changeSkinType(i);
        }
        if (this.duj != null) {
            this.duj.dA(i);
        }
        Iterator<TbImageView> it = this.ddX.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aro();
        ak.i(this.dtW, d.f.home_thread_card_item_bg);
        ak.h(this.cXy, d.C0126d.cp_cont_b);
        if (this.ddO != null) {
            com.baidu.tbadk.n.a.a(this.cZJ.getPageContext(), this.ddO);
        }
        if (this.ddY.getVisibility() == 0) {
            this.ddY.changeSkinType(i);
        }
        ak.i(this.duM, d.f.btn_round_cont_d);
        ak.h(this.duM, d.C0126d.btn_cont_j_alpha_20_selector);
        if (this.dtV != null) {
            ak.j(this.dtV, d.C0126d.cp_bg_line_e);
        }
        if (this.ddP != null && this.ddP.getVisibility() == 0) {
            this.ddP.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dus = forumData.getPost_num();
            this.dup = forumData.getTag_color();
            this.Xu = forumData.getImage_url();
            this.duo = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dut = forumData.getSignData().count_sign_num;
                this.duu = forumData.getSignData().miss_sign_num;
            }
            this.duv = forumData.getCurScore();
            this.drp = forumData.getLevelupScore();
            this.duk = forumData.getBadgeData();
            this.dub = forumData.getTopCode();
            this.duc = forumData.getNewsInfo();
            this.duq = forumData.getAccelerateContent();
            this.drT = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dur = new bd();
            arx();
            arB();
            arv();
            this.ddY.setVisibility(8);
            if (lVar != null && lVar.bpV() != null) {
                ks(lVar.bpV().grade.intValue());
                this.ddZ = lVar.bpV().url;
            }
            if (lVar != null && lVar.gvO != null) {
                FrsTabInfo frsTabInfo = lVar.gvO;
                this.ddV = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.ddW = frsTabInfo.tab_gid;
                this.duM.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.duM.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        al alVar = new al("c12837");
                        alVar.ac(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.ddW);
                        alVar.ac("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(alVar);
                    }
                }
                this.duM.setOnClickListener(this.dec);
            } else {
                this.duM.setVisibility(8);
            }
            if (lVar != null && lVar.gvP != null) {
                this.ddP.setData(lVar.gvP);
                this.ddP.setVisibility(0);
                this.duL.setPadding(0, this.duL.getPaddingTop(), 0, 0);
                return;
            }
            this.ddP.setVisibility(8);
        }
    }

    protected void arx() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.Xu);
        this.dur.rZ().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void ary() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        if (this.duu > 0) {
            ak.c(this.dtO, d.C0126d.cp_cont_i, 1);
            Drawable drawable = ak.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, e, e);
            int e2 = l.e(this.mContext.getPageActivity(), d.e.tbds24);
            this.dtO.setPadding(e2, 0, e2, 0);
            this.dtO.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dtO.setText(String.format(this.mContext.getString(d.k.miss_sign_days), Integer.valueOf(this.duu)));
            ak.i(this.dtO, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = ak.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, e, e);
            this.dtO.setCompoundDrawables(drawable2, null, null, null);
            ak.c(this.dtO, d.C0126d.cp_cont_e, 1);
            this.dtO.setText(this.mContext.getString(d.k.signed));
            this.dtO.setPadding(0, 0, 0, 0);
            this.dtO.setBackgroundDrawable(null);
        }
        this.dtO.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dtO.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void arz() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = ak.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dtO.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dtO.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        ak.c(this.dtO, d.C0126d.cp_cont_i, 1);
        ak.i(this.dtO, d.f.frs_attention_btn_bg_selector);
    }

    protected void arA() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = ak.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dtN.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dtN.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        ak.c(this.dtN, d.C0126d.cp_cont_g, 1);
        ak.i(this.dtN, d.f.frs_attention_btn_bg_selector);
    }

    protected void arB() {
        List<g> list = null;
        if (this.dtL != null) {
            this.dtL.setText(an.y(this.mMemberNum));
        }
        if (this.dtM != null) {
            this.dtM.setText(an.y(this.dus));
        }
        if (this.duk != null && this.duk.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.mContext.getString(d.k.forum));
            }
            if (this.cXy != null) {
                this.cXy.setText(this.mForumName + this.mContext.getString(d.k.forum));
            }
        }
        if (this.dtS != null && this.dtT != null) {
            if (this.drT != null && this.drT.bqh()) {
                if (com.baidu.tbadk.core.util.m.dT(this.drT.bqj()) == 1 && !n.agw) {
                    this.dtS.setVisibility(8);
                } else {
                    this.dtS.setVisibility(0);
                    if (!TextUtils.isEmpty(this.drT.getGameName()) && !TextUtils.isEmpty(this.drT.getGameName().trim())) {
                        this.dtT.setText(UtilHelper.getFixedText(this.drT.getGameName(), 10));
                        String td = com.baidu.tieba.tbadkCore.util.b.td(this.drT.bqj());
                        if (!StringUtils.isNull(td)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", td, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dtT.setText(this.mContext.getResources().getString(d.k.frsgame_title));
                    }
                }
            } else {
                this.dtS.setVisibility(8);
            }
        }
        this.dua.setVisibility(8);
        this.dum.a(null, null);
        if (this.dtS != null) {
            this.dtU = this.dtS.findViewById(d.g.top_item_divider);
        }
        arC();
        if (this.drT != null && !v.w(this.drT.bqi())) {
            list = this.drT.bqi();
            bw(list);
        }
        bi(list);
    }

    protected void arC() {
        this.dui.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dui.startLoad(this.Xu, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void j(View view2, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.duG);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dud);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds100));
                this.due = (TextView) this.dud.findViewById(d.g.cur_experience);
                this.duf = (TextView) this.dud.findViewById(d.g.levelup_experience);
                a(this.due, this.duf);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            a(this.due, this.duf);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.duG, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            ak.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0126d.cp_cont_b, 1);
            ak.c(textView, d.C0126d.cp_cont_b, 1);
            ak.c(textView2, d.C0126d.cp_cont_b, 1);
            ak.c(textView3, d.C0126d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.w(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.duq) && !TextUtils.isEmpty(this.duq.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.duq);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cb(d.C0126d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.tC();
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
    public void arD() {
        View contentView;
        if (this.duh == null) {
            this.duh = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.speed_tip, (ViewGroup) null);
            this.duh.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.duh, c.this.mContext.getPageActivity());
                        c.this.cZJ.cYc = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.k.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.duh.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds300));
            this.duh.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds88));
            this.duh.setBackgroundDrawable(new BitmapDrawable());
            this.duh.setOutsideTouchable(true);
            this.duh.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.duh);
                        c.this.cZJ.cYc = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.duh.getContentView();
        }
        this.mContext.getLayoutMode().u(contentView);
        int[] iArr = new int[2];
        this.dug.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.duh, this.mParent, 0, (iArr[0] - (this.duh.getWidth() / 2)) + (this.dug.getWidth() / 2), iArr[1] + this.dug.getWidth());
        this.duh.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.duA = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.duA) {
                this.dtP.setText(d.k.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l apD = this.cZJ.apD();
                if (apD != null && apD.aVq() != null) {
                    apD.aVq().setUser_level(i);
                }
                this.duK.setText(this.mContext.getResources().getString(d.k.lv_num, Integer.valueOf(i)));
            } else {
                this.dtP.setText(this.duo);
                this.duK.setText(this.mContext.getResources().getString(d.k.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dtQ.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, kt(this.mLevel)));
            if (this.duA) {
                if (f >= 1.0f) {
                    a(this.cZJ.getBaseFragmentActivity(), this.dtQ, this.duB, f);
                } else {
                    b(this.cZJ.getBaseFragmentActivity(), this.dtQ, this.duB, f);
                }
            } else {
                a(this.cZJ.getBaseFragmentActivity(), this.dtQ, this.duB, f);
            }
            this.duB = f;
        }
    }

    private int[] kt(int i) {
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
    protected void arE() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void arF() {
        if (this.mMemberType != 0) {
            ak.c(this.dug, d.f.icon_sml_speed_orange);
        } else {
            ak.c(this.dug, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.deb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Xp() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.wt();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.c.9
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0088a
            public void eA(String str) {
                ax.wf().c(c.this.mContext, new String[]{c.this.ddV});
            }

            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0088a
            public void eB(String str) {
            }
        });
        return aVar.v(pageActivity);
    }

    public String qz() {
        return this.ddW;
    }

    public String arG() {
        return this.ddV;
    }
}
