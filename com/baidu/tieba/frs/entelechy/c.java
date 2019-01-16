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
    private String arr;
    private RelativeLayout bBm;
    private final LinearLayout dSG;
    private TextView dSH;
    private TextView dSI;
    private ImageView dSJ;
    private String dSK;
    private String dSL;
    private FrsHeaderPraiseView dSN;
    private String dSO;
    private AdapterLinearLayout dSP;
    private com.baidu.tieba.frs.g.b.a dSQ;
    private AdapterLinearLayout dSR;
    private com.baidu.tieba.frs.g.a.a dSS;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dST = {e.f.icon_frs_emotion_level1, e.f.icon_frs_emotion_level2, e.f.icon_frs_emotion_level3, e.f.icon_frs_emotion_level4, e.f.icon_frs_emotion_level5};
    private View.OnClickListener dSU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dSL)) {
                        ay.Es().c(c.this.mContext, new String[]{c.this.dSK});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.aiy()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dSL));
                        }
                    } else if (PluginPackageManager.nd().cc("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).Ca();
                        z = false;
                    } else {
                        ay.Es().c(c.this.mContext, new String[]{c.this.dSK});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.aB(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.aB(VideoPlayActivityConfig.OBJ_ID, c.this.dSL);
                    amVar.aB("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.aB("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.Es().c(c.this.mContext, new String[]{c.this.dSK});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.aB(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.aB(VideoPlayActivityConfig.OBJ_ID, c.this.dSL);
                amVar2.aB("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.aB("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dSM = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bBm = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dNb = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.ejs = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.ejt = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds72);
        this.eju = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = aEH();
        this.bBm = (RelativeLayout) this.mParent.findViewById(e.g.container);
        this.ejO = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(e.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.ejR = (ImageView) this.mParent.findViewById(e.g.speed_icon);
        this.dSH = (TextView) this.mParent.findViewById(e.g.member_image);
        this.dSI = (TextView) this.mParent.findViewById(e.g.post_image);
        this.ejz = (TextView) this.mParent.findViewById(e.g.level_name);
        this.ekx = (TextView) this.mParent.findViewById(e.g.level);
        this.ejx = (TextView) this.mParent.findViewById(e.g.tv_love);
        this.ejy = (TextView) this.mParent.findViewById(e.g.tv_sign);
        this.ejy.setContentDescription(frsFragment.getResources().getString(e.j.sign));
        this.ejA = (ImageView) this.mParent.findViewById(e.g.love_level_top);
        this.ejB = (ImageView) this.mParent.findViewById(e.g.love_level_bg);
        this.ejv = (TextView) this.mParent.findViewById(e.g.member_num_text);
        this.ejw = (TextView) this.mParent.findViewById(e.g.post_num_text);
        this.ejT = (BarImageView) this.mParent.findViewById(e.g.frs_image);
        this.dKx = (TextView) this.mParent.findViewById(e.g.forum_name);
        this.eko = (TextView) this.mParent.findViewById(e.g.brand_label);
        this.ejT.setPageId(this.dNb.getUniqueId());
        this.ejT.setContentDescription(frsFragment.getResources().getString(e.j.bar_header));
        this.ejT.setGifIconSupport(false);
        this.ejT.setDrawerType(0);
        this.ejC = LayoutInflater.from(this.dNb.getPageContext().getPageActivity()).inflate(e.h.frs_header_extra_entelechy, (ViewGroup) null);
        aEw();
        aEC();
        aEE();
        this.ejD = (ViewGroup) this.ejC.findViewById(e.g.frs_header_games);
        this.ejE = (TextView) this.ejC.findViewById(e.g.top_item_title);
        this.ejL = (LinearLayout) this.ejC.findViewById(e.g.frs_present_root);
        this.ekz = (TextView) this.bBm.findViewById(e.g.new_chapter_btn);
        this.ejX = new com.baidu.tieba.frs.view.e(this.mContext, this.ejC);
        this.ejW = new com.baidu.tieba.frs.f.b(this.mContext);
        this.ejH = (ViewGroup) this.ejC.findViewById(e.g.frs_headline);
        this.ejI = (TextView) this.ejH.findViewById(e.g.headline_title);
        this.ejJ = (TextView) this.ejH.findViewById(e.g.headline_text);
        this.ejK = (TbImageView) this.ejH.findViewById(e.g.headline_image);
        this.ejK.setPageId(this.dNb.getUniqueId());
        this.ejH.setVisibility(8);
        this.ekw = this.mParent.findViewById(e.g.level_container);
        this.ekv = (RelativeLayout) this.mParent.findViewById(e.g.has_focused_container);
        this.eku = (RelativeLayout) this.mParent.findViewById(e.g.not_focused_container);
        this.eky = (RelativeLayout) this.mParent.findViewById(e.g.head_content_container);
        this.dSJ = (ImageView) this.mParent.findViewById(e.g.single_bar_level);
        this.dSJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.kV()) {
                    l.showToast(c.this.mContext.getPageActivity(), e.j.neterror);
                } else if (!StringUtils.isNull(c.this.dSO) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.Es().c(c.this.mContext, new String[]{c.this.dSO + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        aEF();
        this.dSD = (FrsStarRankAndTaskContainer) this.mParent.findViewById(e.g.frs_star_rank_container);
        this.dSD.setContext(this.mContext);
        this.dSG = new LinearLayout(this.dNb.getContext());
        this.dSG.setOrientation(1);
        this.dSG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dSG.addView(this.ejG);
        aEB();
    }

    private void aEB() {
        this.dSG.addView(this.dSP);
        this.dSG.addView(this.dSR);
    }

    private void hf(boolean z) {
        this.dSP.setVisibility(z ? 0 : 8);
        this.dSR.setVisibility(z ? 0 : 8);
    }

    private void aEC() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds16);
        this.dSP = new AdapterLinearLayout(this.dNb.getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        this.dSP.setLayoutParams(layoutParams);
        this.dSP.setOrientation(1);
        this.dSQ = new com.baidu.tieba.frs.g.b.a(this.dNb.getPageContext());
        this.dSP.setAdapter(this.dSQ);
        this.dSR = new AdapterLinearLayout(this.dNb.getPageContext().getPageActivity());
        this.dSR.setLayoutParams(layoutParams);
        this.dSR.setOrientation(1);
        this.dSS = new com.baidu.tieba.frs.g.a.a(this.dNb.getTbPageContext());
        this.dSR.setAdapter(this.dSS);
        this.dSR.setPadding(0, 0, 0, h);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View aED() {
        return this.dSG;
    }

    private void aEE() {
        this.dSN = (FrsHeaderPraiseView) this.ejC.findViewById(e.g.frs_praise_layout);
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
        this.dSQ.setData(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (NebulaHotThread nebulaHotThread : list) {
            com.baidu.tieba.frs.g.a.b bVar = new com.baidu.tieba.frs.g.a.b();
            bVar.oj(nebulaHotThread.comment_number.intValue()).bZ(nebulaHotThread.content).ol(nebulaHotThread.thread_thumbnail_type.intValue()).pp(nebulaHotThread.group_name).po(nebulaHotThread.thread_thumbnail).pn(nebulaHotThread.url).ok(nebulaHotThread.rank.intValue());
            arrayList2.add(bVar);
        }
        this.dSS.setData(arrayList2);
    }

    private void aEF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.ejY = (ag) runTask.getData();
            this.ejY.a(this.mContext, this.mParent, 1, false, this.dNb.getUniqueId());
            this.ejY.hide();
        }
    }

    private void aEG() {
        final com.baidu.tbadk.core.data.l bDo = this.eho.bDo();
        if (bDo != null && this.eho.bhx() != null) {
            final String id = this.eho.bhx().getId();
            final String name = this.eho.bhx().getName();
            if (this.eks.add(bDo.yt())) {
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bDo.yt(), id, name, null);
                b.cO("obj_url", bDo.getUrl());
                b.save();
            }
            this.ejH.setVisibility(0);
            this.ejI.setText(bDo.getText());
            this.ejJ.setText(bDo.getTitle());
            this.ejK.startLoad(bDo.ys(), 10, false);
            this.ejH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0316a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bDo.yt(), id, name, null);
                    b2.cO("obj_url", bDo.getUrl());
                    b2.save();
                    ay.Es().c(c.this.dNb.getPageContext(), new String[]{bDo.getUrl()});
                }
            });
        }
    }

    protected View aEH() {
        return LayoutInflater.from(this.dNb.getPageContext().getPageActivity()).inflate(e.h.frs_normal_header, (ViewGroup) null);
    }

    private void mK(int i) {
        if (i <= 0 || i > 5 || this.ekm) {
            this.dSJ.setVisibility(8);
            this.dKx.setMaxWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds370));
            return;
        }
        this.dSJ.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dST[i - 1]);
        this.dSJ.setImageDrawable(drawable);
        this.dKx.setMaxWidth((l.h(this.mContext.getPageActivity(), e.C0210e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dSJ.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void s(View.OnClickListener onClickListener) {
        this.ejT.setOnClickListener(onClickListener);
        this.dKx.setOnClickListener(onClickListener);
        this.ejy.setOnClickListener(onClickListener);
        this.ejx.setOnClickListener(onClickListener);
        this.ekw.setOnClickListener(onClickListener);
        if (this.ejD != null) {
            this.ejD.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEI() {
        al.j(this.eky, e.d.black_alpha0);
        al.j(this.bBm, e.d.black_alpha0);
        al.h(this.dKx, e.d.cp_cont_i);
        al.h(this.ejz, e.d.cp_cont_i);
        al.h(this.ekx, e.d.cp_cont_i);
        al.i(this.eko, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.eko, e.d.cp_cont_i);
        al.h(this.dSH, e.d.cp_cont_i);
        al.h(this.ejv, e.d.cp_cont_i);
        al.h(this.dSI, e.d.cp_cont_i);
        al.h(this.ejw, e.d.cp_cont_i);
        al.j(this.ejB, e.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEJ() {
        this.eko.setVisibility(0);
        this.dSJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.ejO);
        this.mContext.getLayoutMode().onModeChanged(this.ejC);
        if (this.ekk) {
            ob(1);
        } else {
            ob(0);
        }
        this.ejT.invalidate();
        al.j(this.bBm, e.d.cp_bg_line_d);
        al.h(this.ekx, e.d.cp_cont_j);
        al.h(this.ejz, e.d.cp_cont_j);
        al.h(this.dSH, e.d.cp_cont_j);
        al.h(this.ejv, e.d.cp_cont_j);
        al.h(this.dSI, e.d.cp_cont_j);
        al.h(this.ejw, e.d.cp_cont_j);
        this.ejT.setBorderWidth(l.h(this.mContext.getPageActivity(), e.C0210e.tbds1));
        this.ejT.setBorderColor(al.getColor(e.d.black_alpha15));
        aEN();
        if (this.ejD != null) {
            al.i(this.ejD, e.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.ejR, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.ejR, e.f.icon_sml_speed_gray);
        }
        if (this.ejX != null) {
            this.ejX.changeSkinType(i);
        }
        if (this.ejY != null) {
            this.ejY.changeSkinType(i);
        }
        if (this.ejU != null) {
            this.ejU.eD(i);
        }
        Iterator<TbImageView> it = this.dSM.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aEx();
        al.i(this.ejH, e.f.home_thread_card_item_bg);
        al.h(this.dKx, e.d.cp_cont_b);
        if (this.dSC != null) {
            com.baidu.tbadk.o.a.a(this.dNb.getPageContext(), this.dSC);
        }
        if (this.dSN.getVisibility() == 0) {
            this.dSN.changeSkinType(i);
        }
        al.i(this.ekz, e.f.btn_round_cont_d);
        al.h(this.ekz, e.d.btn_cont_j_alpha_20_selector);
        al.j(this.ejB, e.d.common_color_10043);
        if (this.dSD != null && this.dSD.getVisibility() == 0) {
            this.dSD.onChangeSkinType();
        }
        if (this.ekm) {
            aEI();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ekd = forumData.getPost_num();
            this.eka = forumData.getTag_color();
            this.arr = forumData.getImage_url();
            this.ejZ = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.eke = forumData.getSignData().count_sign_num;
                this.ekf = forumData.getSignData().miss_sign_num;
            }
            this.ekg = forumData.getCurScore();
            this.egF = forumData.getLevelupScore();
            this.ejV = forumData.getBadgeData();
            this.ejM = forumData.getTopCode();
            this.ejN = forumData.getNewsInfo();
            this.ekb = forumData.getAccelerateContent();
            this.ekm = forumData.isBrandForum;
            this.eho = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.ekc = new bb();
            aEK();
            aEO();
            aEG();
            this.dSN.setVisibility(8);
            if (lVar != null && lVar.bCM() != null) {
                mK(lVar.bCM().grade.intValue());
                this.dSO = lVar.bCM().url;
            }
            if (lVar != null && lVar.hnJ != null) {
                FrsTabInfo frsTabInfo = lVar.hnJ;
                this.dSK = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dSL = frsTabInfo.tab_gid;
                this.ekz.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.ekz.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.aB(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.dSL);
                        amVar.aB("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.ekz.setOnClickListener(this.dSU);
            } else {
                this.ekz.setVisibility(8);
            }
            if (lVar != null && lVar.hnK != null) {
                this.dSD.setData(lVar.hnK);
                this.dSD.setVisibility(0);
                this.eky.setPadding(0, this.eky.getPaddingTop(), 0, 0);
                return;
            }
            this.dSD.setVisibility(8);
        }
    }

    protected void aEK() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.arr);
        this.ekc.Ae().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aEL() {
        Drawable drawable;
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        if (this.ekf > 0) {
            al.c(this.ejy, e.d.cp_cont_i, 1);
            Drawable drawable2 = al.getDrawable(e.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), e.C0210e.tbds24);
            this.ejy.setPadding(h2, 0, h2, 0);
            this.ejy.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ejy.setText(String.format(this.mContext.getString(e.j.miss_sign_days), Integer.valueOf(this.ekf)));
            al.i(this.ejy, e.f.frs_attention_btn_bg_selector);
        } else {
            if (this.ekm) {
                drawable = al.getDrawable(e.f.icon_frs_sign_h_white);
                al.c(this.ejy, e.d.cp_cont_i, 1);
            } else {
                drawable = al.getDrawable(e.f.icon_public_sign_blue);
                al.c(this.ejy, e.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, h, h);
            this.ejy.setCompoundDrawables(drawable, null, null, null);
            this.ejy.setText(this.mContext.getString(e.j.signed));
            this.ejy.setPadding(0, 0, 0, 0);
            this.ejy.setBackgroundDrawable(null);
        }
        this.ejy.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        this.ejy.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aEM() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.ejy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ejy.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.ejy, e.d.cp_cont_i, 1);
        al.i(this.ejy, e.f.frs_attention_btn_bg_selector);
    }

    protected void aEN() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.ejx.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ejx.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.ejx, e.d.cp_cont_g, 1);
        al.i(this.ejx, e.f.frs_attention_btn_bg_selector);
    }

    protected void aEO() {
        List<g> list = null;
        if (this.ejv != null) {
            this.ejv.setText(ao.T(this.mMemberNum));
        }
        if (this.ejw != null) {
            this.ejw.setText(ao.T(this.ekd));
        }
        if (this.ejV != null && this.ejV.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.dxd != null) {
                this.dxd.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
            if (this.dKx != null) {
                this.dKx.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
        }
        if (this.ejD != null && this.ejE != null) {
            if (this.eho != null && this.eho.bCY()) {
                if (m.fG(this.eho.bDa()) == 1 && !n.aAG) {
                    this.ejD.setVisibility(8);
                } else {
                    this.ejD.setVisibility(0);
                    if (!TextUtils.isEmpty(this.eho.getGameName()) && !TextUtils.isEmpty(this.eho.getGameName().trim())) {
                        this.ejE.setText(UtilHelper.getFixedText(this.eho.getGameName(), 10));
                        String wh = com.baidu.tieba.tbadkCore.util.b.wh(this.eho.bDa());
                        if (!StringUtils.isNull(wh)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", wh, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.ejE.setText(this.mContext.getResources().getString(e.j.frsgame_title));
                    }
                }
            } else {
                this.ejD.setVisibility(8);
            }
        }
        this.ejL.setVisibility(8);
        this.ejX.a(null, null);
        if (this.ejD != null) {
            this.ejF = this.ejD.findViewById(e.g.top_item_divider);
        }
        aEP();
        if (this.eho != null && !v.I(this.eho.bCZ())) {
            list = this.eho.bCZ();
            bV(list);
        }
        bG(list);
        c(this.eho);
    }

    protected void aEP() {
        this.ejT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejT.startLoad(this.arr, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.ekt);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.ejO);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds100));
                this.ejP = (TextView) this.ejO.findViewById(e.g.cur_experience);
                this.ejQ = (TextView) this.ejO.findViewById(e.g.levelup_experience);
                a(this.ejP, this.ejQ);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.ejP, this.ejQ);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.ekt, SystemScreenshotManager.DELAY_TIME);
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
            if (!TextUtils.isEmpty(this.ekb) && !TextUtils.isEmpty(this.ekb.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ekb);
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
        if (this.ejS == null) {
            this.ejS = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.speed_tip, (ViewGroup) null);
            this.ejS.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.ejS, c.this.mContext.getPageActivity());
                        c.this.dNb.dLn = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.ejS.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds300));
            this.ejS.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds88));
            this.ejS.setBackgroundDrawable(new BitmapDrawable());
            this.ejS.setOutsideTouchable(true);
            this.ejS.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.ejS);
                        c.this.dNb.dLn = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.ejS.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.ejR.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.ejS, this.mParent, 0, (iArr[0] - (this.ejS.getWidth() / 2)) + (this.ejR.getWidth() / 2), iArr[1] + this.ejR.getWidth());
        this.ejS.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.ekl = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(e.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.ekl) {
                this.ejz.setText(e.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l aCl = this.dNb.aCl();
                if (aCl != null && aCl.bhx() != null) {
                    aCl.bhx().setUser_level(i);
                }
                this.ekx.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(i)));
            } else {
                this.ejz.setText(this.ejZ);
                this.ekx.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.ejA.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, mL(this.mLevel)));
            if (this.ekl) {
                if (f >= 1.0f) {
                    a(this.dNb.getBaseFragmentActivity(), this.ejA, this.ekn, f);
                } else {
                    b(this.dNb.getBaseFragmentActivity(), this.ejA, this.ekn, f);
                }
            } else {
                a(this.dNb.getBaseFragmentActivity(), this.ejA, this.ekn, f);
            }
            this.ekn = f;
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
            al.c(this.ejR, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.ejR, e.f.icon_sml_speed_gray);
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
                ay.Es().c(c.this.mContext, new String[]{c.this.dSK});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void gn(String str) {
            }
        });
        return aVar.B(pageActivity);
    }

    public String yy() {
        return this.dSL;
    }

    public String aET() {
        return this.dSK;
    }
}
