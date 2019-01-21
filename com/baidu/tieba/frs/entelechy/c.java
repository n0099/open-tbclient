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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.view.AdapterLinearLayout;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.NebulaHotThread;
import tbclient.FrsPage.NebulaHotThreads;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class c extends a {
    private String ars;
    private RelativeLayout bBn;
    private final LinearLayout dSH;
    private TextView dSI;
    private TextView dSJ;
    private ImageView dSK;
    private String dSL;
    private String dSM;
    private FrsHeaderPraiseView dSO;
    private String dSP;
    private AdapterLinearLayout dSQ;
    private com.baidu.tieba.frs.g.b.a dSR;
    private AdapterLinearLayout dSS;
    private com.baidu.tieba.frs.g.a.a dST;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dSU = {e.f.icon_frs_emotion_level1, e.f.icon_frs_emotion_level2, e.f.icon_frs_emotion_level3, e.f.icon_frs_emotion_level4, e.f.icon_frs_emotion_level5};
    private View.OnClickListener dSV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dSM)) {
                        ay.Es().c(c.this.mContext, new String[]{c.this.dSL});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.aiy()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dSM));
                        }
                    } else if (PluginPackageManager.nd().cc("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).Ca();
                        z = false;
                    } else {
                        ay.Es().c(c.this.mContext, new String[]{c.this.dSL});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.aB(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.aB(VideoPlayActivityConfig.OBJ_ID, c.this.dSM);
                    amVar.aB("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.aB("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.Es().c(c.this.mContext, new String[]{c.this.dSL});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.aB(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.aB(VideoPlayActivityConfig.OBJ_ID, c.this.dSM);
                amVar2.aB("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.aB("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dSN = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bBn = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dNc = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.ejt = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.eju = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds72);
        this.ejv = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = aEH();
        this.bBn = (RelativeLayout) this.mParent.findViewById(e.g.container);
        this.ejP = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(e.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.ejS = (ImageView) this.mParent.findViewById(e.g.speed_icon);
        this.dSI = (TextView) this.mParent.findViewById(e.g.member_image);
        this.dSJ = (TextView) this.mParent.findViewById(e.g.post_image);
        this.ejA = (TextView) this.mParent.findViewById(e.g.level_name);
        this.eky = (TextView) this.mParent.findViewById(e.g.level);
        this.ejy = (TextView) this.mParent.findViewById(e.g.tv_love);
        this.ejz = (TextView) this.mParent.findViewById(e.g.tv_sign);
        this.ejz.setContentDescription(frsFragment.getResources().getString(e.j.sign));
        this.ejB = (ImageView) this.mParent.findViewById(e.g.love_level_top);
        this.ejC = (ImageView) this.mParent.findViewById(e.g.love_level_bg);
        this.ejw = (TextView) this.mParent.findViewById(e.g.member_num_text);
        this.ejx = (TextView) this.mParent.findViewById(e.g.post_num_text);
        this.ejU = (BarImageView) this.mParent.findViewById(e.g.frs_image);
        this.dKy = (TextView) this.mParent.findViewById(e.g.forum_name);
        this.ekp = (TextView) this.mParent.findViewById(e.g.brand_label);
        this.ejU.setPageId(this.dNc.getUniqueId());
        this.ejU.setContentDescription(frsFragment.getResources().getString(e.j.bar_header));
        this.ejU.setGifIconSupport(false);
        this.ejU.setDrawerType(0);
        this.ejD = LayoutInflater.from(this.dNc.getPageContext().getPageActivity()).inflate(e.h.frs_header_extra_entelechy, (ViewGroup) null);
        aEw();
        aEC();
        aEE();
        this.ejE = (ViewGroup) this.ejD.findViewById(e.g.frs_header_games);
        this.ejF = (TextView) this.ejD.findViewById(e.g.top_item_title);
        this.ejM = (LinearLayout) this.ejD.findViewById(e.g.frs_present_root);
        this.ekA = (TextView) this.bBn.findViewById(e.g.new_chapter_btn);
        this.ejY = new com.baidu.tieba.frs.view.e(this.mContext, this.ejD);
        this.ejX = new com.baidu.tieba.frs.f.b(this.mContext);
        this.ejI = (ViewGroup) this.ejD.findViewById(e.g.frs_headline);
        this.ejJ = (TextView) this.ejI.findViewById(e.g.headline_title);
        this.ejK = (TextView) this.ejI.findViewById(e.g.headline_text);
        this.ejL = (TbImageView) this.ejI.findViewById(e.g.headline_image);
        this.ejL.setPageId(this.dNc.getUniqueId());
        this.ejI.setVisibility(8);
        this.ekx = this.mParent.findViewById(e.g.level_container);
        this.ekw = (RelativeLayout) this.mParent.findViewById(e.g.has_focused_container);
        this.ekv = (RelativeLayout) this.mParent.findViewById(e.g.not_focused_container);
        this.ekz = (RelativeLayout) this.mParent.findViewById(e.g.head_content_container);
        this.dSK = (ImageView) this.mParent.findViewById(e.g.single_bar_level);
        this.dSK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.kV()) {
                    l.showToast(c.this.mContext.getPageActivity(), e.j.neterror);
                } else if (!StringUtils.isNull(c.this.dSP) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.Es().c(c.this.mContext, new String[]{c.this.dSP + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        aEF();
        this.dSE = (FrsStarRankAndTaskContainer) this.mParent.findViewById(e.g.frs_star_rank_container);
        this.dSE.setContext(this.mContext);
        this.dSH = new LinearLayout(this.dNc.getContext());
        this.dSH.setOrientation(1);
        this.dSH.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dSH.addView(this.ejH);
        aEB();
    }

    private void aEB() {
        this.dSH.addView(this.dSQ);
        this.dSH.addView(this.dSS);
    }

    private void hf(boolean z) {
        this.dSQ.setVisibility(z ? 0 : 8);
        this.dSS.setVisibility(z ? 0 : 8);
    }

    private void aEC() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds16);
        this.dSQ = new AdapterLinearLayout(this.dNc.getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        this.dSQ.setLayoutParams(layoutParams);
        this.dSQ.setOrientation(1);
        this.dSR = new com.baidu.tieba.frs.g.b.a(this.dNc.getPageContext());
        this.dSQ.setAdapter(this.dSR);
        this.dSS = new AdapterLinearLayout(this.dNc.getPageContext().getPageActivity());
        this.dSS.setLayoutParams(layoutParams);
        this.dSS.setOrientation(1);
        this.dST = new com.baidu.tieba.frs.g.a.a(this.dNc.getTbPageContext());
        this.dSS.setAdapter(this.dST);
        this.dSS.setPadding(0, 0, 0, h);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View aED() {
        return this.dSH;
    }

    private void aEE() {
        this.dSO = (FrsHeaderPraiseView) this.ejD.findViewById(e.g.frs_praise_layout);
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar == null) {
            hf(false);
            return;
        }
        NebulaHotThreads bDS = lVar.bDS();
        if (bDS == null || v.I(bDS.threads)) {
            hf(false);
            return;
        }
        hf(true);
        List<NebulaHotThread> list = bDS.threads;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tieba.frs.g.b.b(bDS.url));
        this.dSR.setData(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (NebulaHotThread nebulaHotThread : list) {
            com.baidu.tieba.frs.g.a.b bVar = new com.baidu.tieba.frs.g.a.b();
            bVar.oj(nebulaHotThread.comment_number.intValue()).bZ(nebulaHotThread.content).ol(nebulaHotThread.thread_thumbnail_type.intValue()).pp(nebulaHotThread.group_name).po(nebulaHotThread.thread_thumbnail).pn(nebulaHotThread.url).ok(nebulaHotThread.rank.intValue());
            arrayList2.add(bVar);
        }
        this.dST.setData(arrayList2);
    }

    private void aEF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.ejZ = (ag) runTask.getData();
            this.ejZ.a(this.mContext, this.mParent, 1, false, this.dNc.getUniqueId());
            this.ejZ.hide();
        }
    }

    private void aEG() {
        final com.baidu.tbadk.core.data.l bDo = this.ehp.bDo();
        if (bDo != null && this.ehp.bhx() != null) {
            final String id = this.ehp.bhx().getId();
            final String name = this.ehp.bhx().getName();
            if (this.ekt.add(bDo.yt())) {
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bDo.yt(), id, name, null);
                b.cO("obj_url", bDo.getUrl());
                b.save();
            }
            this.ejI.setVisibility(0);
            this.ejJ.setText(bDo.getText());
            this.ejK.setText(bDo.getTitle());
            this.ejL.startLoad(bDo.ys(), 10, false);
            this.ejI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0316a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bDo.yt(), id, name, null);
                    b2.cO("obj_url", bDo.getUrl());
                    b2.save();
                    ay.Es().c(c.this.dNc.getPageContext(), new String[]{bDo.getUrl()});
                }
            });
        }
    }

    protected View aEH() {
        return LayoutInflater.from(this.dNc.getPageContext().getPageActivity()).inflate(e.h.frs_normal_header, (ViewGroup) null);
    }

    private void mK(int i) {
        if (i <= 0 || i > 5 || this.ekn) {
            this.dSK.setVisibility(8);
            this.dKy.setMaxWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds370));
            return;
        }
        this.dSK.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dSU[i - 1]);
        this.dSK.setImageDrawable(drawable);
        this.dKy.setMaxWidth((l.h(this.mContext.getPageActivity(), e.C0210e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dSK.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void s(View.OnClickListener onClickListener) {
        this.ejU.setOnClickListener(onClickListener);
        this.dKy.setOnClickListener(onClickListener);
        this.ejz.setOnClickListener(onClickListener);
        this.ejy.setOnClickListener(onClickListener);
        this.ekx.setOnClickListener(onClickListener);
        if (this.ejE != null) {
            this.ejE.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEI() {
        al.j(this.ekz, e.d.black_alpha0);
        al.j(this.bBn, e.d.black_alpha0);
        al.h(this.dKy, e.d.cp_cont_i);
        al.h(this.ejA, e.d.cp_cont_i);
        al.h(this.eky, e.d.cp_cont_i);
        al.i(this.ekp, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.ekp, e.d.cp_cont_i);
        al.h(this.dSI, e.d.cp_cont_i);
        al.h(this.ejw, e.d.cp_cont_i);
        al.h(this.dSJ, e.d.cp_cont_i);
        al.h(this.ejx, e.d.cp_cont_i);
        al.j(this.ejC, e.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEJ() {
        this.ekp.setVisibility(0);
        this.dSK.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.ejP);
        this.mContext.getLayoutMode().onModeChanged(this.ejD);
        if (this.ekl) {
            ob(1);
        } else {
            ob(0);
        }
        this.ejU.invalidate();
        al.j(this.bBn, e.d.cp_bg_line_d);
        al.h(this.eky, e.d.cp_cont_j);
        al.h(this.ejA, e.d.cp_cont_j);
        al.h(this.dSI, e.d.cp_cont_j);
        al.h(this.ejw, e.d.cp_cont_j);
        al.h(this.dSJ, e.d.cp_cont_j);
        al.h(this.ejx, e.d.cp_cont_j);
        this.ejU.setBorderWidth(l.h(this.mContext.getPageActivity(), e.C0210e.tbds1));
        this.ejU.setBorderColor(al.getColor(e.d.black_alpha15));
        aEN();
        if (this.ejE != null) {
            al.i(this.ejE, e.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.ejS, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.ejS, e.f.icon_sml_speed_gray);
        }
        if (this.ejY != null) {
            this.ejY.changeSkinType(i);
        }
        if (this.ejZ != null) {
            this.ejZ.changeSkinType(i);
        }
        if (this.ejV != null) {
            this.ejV.eD(i);
        }
        Iterator<TbImageView> it = this.dSN.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aEx();
        al.i(this.ejI, e.f.home_thread_card_item_bg);
        al.h(this.dKy, e.d.cp_cont_b);
        if (this.dSD != null) {
            com.baidu.tbadk.o.a.a(this.dNc.getPageContext(), this.dSD);
        }
        if (this.dSO.getVisibility() == 0) {
            this.dSO.changeSkinType(i);
        }
        al.i(this.ekA, e.f.btn_round_cont_d);
        al.h(this.ekA, e.d.btn_cont_j_alpha_20_selector);
        al.j(this.ejC, e.d.common_color_10043);
        if (this.dSE != null && this.dSE.getVisibility() == 0) {
            this.dSE.onChangeSkinType();
        }
        if (this.ekn) {
            aEI();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.eke = forumData.getPost_num();
            this.ekb = forumData.getTag_color();
            this.ars = forumData.getImage_url();
            this.eka = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ekf = forumData.getSignData().count_sign_num;
                this.ekg = forumData.getSignData().miss_sign_num;
            }
            this.ekh = forumData.getCurScore();
            this.egG = forumData.getLevelupScore();
            this.ejW = forumData.getBadgeData();
            this.ejN = forumData.getTopCode();
            this.ejO = forumData.getNewsInfo();
            this.ekc = forumData.getAccelerateContent();
            this.ekn = forumData.isBrandForum;
            this.ehp = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.ekd = new bb();
            aEK();
            aEO();
            aEG();
            this.dSO.setVisibility(8);
            if (lVar != null && lVar.bCM() != null) {
                mK(lVar.bCM().grade.intValue());
                this.dSP = lVar.bCM().url;
            }
            if (lVar != null && lVar.hnK != null) {
                FrsTabInfo frsTabInfo = lVar.hnK;
                this.dSL = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dSM = frsTabInfo.tab_gid;
                this.ekA.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.ekA.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.aB(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.dSM);
                        amVar.aB("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.ekA.setOnClickListener(this.dSV);
            } else {
                this.ekA.setVisibility(8);
            }
            if (lVar != null && lVar.hnL != null) {
                this.dSE.setData(lVar.hnL);
                this.dSE.setVisibility(0);
                this.ekz.setPadding(0, this.ekz.getPaddingTop(), 0, 0);
                return;
            }
            this.dSE.setVisibility(8);
        }
    }

    protected void aEK() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.ars);
        this.ekd.Ae().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aEL() {
        Drawable drawable;
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        if (this.ekg > 0) {
            al.c(this.ejz, e.d.cp_cont_i, 1);
            Drawable drawable2 = al.getDrawable(e.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), e.C0210e.tbds24);
            this.ejz.setPadding(h2, 0, h2, 0);
            this.ejz.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ejz.setText(String.format(this.mContext.getString(e.j.miss_sign_days), Integer.valueOf(this.ekg)));
            al.i(this.ejz, e.f.frs_attention_btn_bg_selector);
        } else {
            if (this.ekn) {
                drawable = al.getDrawable(e.f.icon_frs_sign_h_white);
                al.c(this.ejz, e.d.cp_cont_i, 1);
            } else {
                drawable = al.getDrawable(e.f.icon_public_sign_blue);
                al.c(this.ejz, e.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, h, h);
            this.ejz.setCompoundDrawables(drawable, null, null, null);
            this.ejz.setText(this.mContext.getString(e.j.signed));
            this.ejz.setPadding(0, 0, 0, 0);
            this.ejz.setBackgroundDrawable(null);
        }
        this.ejz.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        this.ejz.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aEM() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.ejz.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ejz.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.ejz, e.d.cp_cont_i, 1);
        al.i(this.ejz, e.f.frs_attention_btn_bg_selector);
    }

    protected void aEN() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.ejy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ejy.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.ejy, e.d.cp_cont_g, 1);
        al.i(this.ejy, e.f.frs_attention_btn_bg_selector);
    }

    protected void aEO() {
        List<g> list = null;
        if (this.ejw != null) {
            this.ejw.setText(ao.T(this.mMemberNum));
        }
        if (this.ejx != null) {
            this.ejx.setText(ao.T(this.eke));
        }
        if (this.ejW != null && this.ejW.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.dxe != null) {
                this.dxe.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
            if (this.dKy != null) {
                this.dKy.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
        }
        if (this.ejE != null && this.ejF != null) {
            if (this.ehp != null && this.ehp.bCY()) {
                if (m.fG(this.ehp.bDa()) == 1 && !n.aAH) {
                    this.ejE.setVisibility(8);
                } else {
                    this.ejE.setVisibility(0);
                    if (!TextUtils.isEmpty(this.ehp.getGameName()) && !TextUtils.isEmpty(this.ehp.getGameName().trim())) {
                        this.ejF.setText(UtilHelper.getFixedText(this.ehp.getGameName(), 10));
                        String wh = com.baidu.tieba.tbadkCore.util.b.wh(this.ehp.bDa());
                        if (!StringUtils.isNull(wh)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", wh, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.ejF.setText(this.mContext.getResources().getString(e.j.frsgame_title));
                    }
                }
            } else {
                this.ejE.setVisibility(8);
            }
        }
        this.ejM.setVisibility(8);
        this.ejY.a(null, null);
        if (this.ejE != null) {
            this.ejG = this.ejE.findViewById(e.g.top_item_divider);
        }
        aEP();
        if (this.ehp != null && !v.I(this.ehp.bCZ())) {
            list = this.ehp.bCZ();
            bV(list);
        }
        bG(list);
        c(this.ehp);
    }

    protected void aEP() {
        this.ejU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejU.startLoad(this.ars, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.eku);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.ejP);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds100));
                this.ejQ = (TextView) this.ejP.findViewById(e.g.cur_experience);
                this.ejR = (TextView) this.ejP.findViewById(e.g.levelup_experience);
                a(this.ejQ, this.ejR);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.ejQ, this.ejR);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.eku, SystemScreenshotManager.DELAY_TIME);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(e.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(e.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(e.g.speed_tip);
            al.c((TextView) inflate.findViewById(e.g.experience_txt), e.d.cp_cont_b, 1);
            al.c(textView, e.d.cp_cont_b, 1);
            al.c(textView2, e.d.cp_cont_b, 1);
            al.c(textView3, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.G(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.ekc) && !TextUtils.isEmpty(this.ekc.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ekc);
            } else {
                textView3.setVisibility(8);
            }
            aVar.dc(e.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.BS();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
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
    public void aEQ() {
        View contentView;
        if (this.ejT == null) {
            this.ejT = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.speed_tip, (ViewGroup) null);
            this.ejT.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.ejT, c.this.mContext.getPageActivity());
                        c.this.dNc.dLo = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.ejT.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds300));
            this.ejT.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds88));
            this.ejT.setBackgroundDrawable(new BitmapDrawable());
            this.ejT.setOutsideTouchable(true);
            this.ejT.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.ejT);
                        c.this.dNc.dLo = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.ejT.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.ejS.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.ejT, this.mParent, 0, (iArr[0] - (this.ejT.getWidth() / 2)) + (this.ejS.getWidth() / 2), iArr[1] + this.ejS.getWidth());
        this.ejT.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.ekm = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(e.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.ekm) {
                this.ejA.setText(e.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l aCl = this.dNc.aCl();
                if (aCl != null && aCl.bhx() != null) {
                    aCl.bhx().setUser_level(i);
                }
                this.eky.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(i)));
            } else {
                this.ejA.setText(this.eka);
                this.eky.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.ejB.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, mL(this.mLevel)));
            if (this.ekm) {
                if (f >= 1.0f) {
                    a(this.dNc.getBaseFragmentActivity(), this.ejB, this.eko, f);
                } else {
                    b(this.dNc.getBaseFragmentActivity(), this.ejB, this.eko, f);
                }
            } else {
                a(this.dNc.getBaseFragmentActivity(), this.ejB, this.eko, f);
            }
            this.eko = f;
        }
    }

    private int[] mL(int i) {
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
    protected void aER() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aES() {
        if (this.mMemberType != 0) {
            al.c(this.ejS, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.ejS, e.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiy() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.EG();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void gm(String str) {
                ay.Es().c(c.this.mContext, new String[]{c.this.dSL});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void gn(String str) {
            }
        });
        return aVar.B(pageActivity);
    }

    public String yy() {
        return this.dSM;
    }

    public String aET() {
        return this.dSL;
    }
}
