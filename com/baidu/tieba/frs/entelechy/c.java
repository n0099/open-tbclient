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
    private String aqP;
    private RelativeLayout bAz;
    private final LinearLayout dRX;
    private TextView dRY;
    private TextView dRZ;
    private ImageView dSa;
    private String dSb;
    private String dSc;
    private FrsHeaderPraiseView dSe;
    private String dSf;
    private AdapterLinearLayout dSg;
    private com.baidu.tieba.frs.g.b.a dSh;
    private AdapterLinearLayout dSi;
    private com.baidu.tieba.frs.g.a.a dSj;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dSk = {e.f.icon_frs_emotion_level1, e.f.icon_frs_emotion_level2, e.f.icon_frs_emotion_level3, e.f.icon_frs_emotion_level4, e.f.icon_frs_emotion_level5};
    private View.OnClickListener dSl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dSc)) {
                        ay.Ef().c(c.this.mContext, new String[]{c.this.dSb});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.aib()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dSc));
                        }
                    } else if (PluginPackageManager.na().cb("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).BN();
                        z = false;
                    } else {
                        ay.Ef().c(c.this.mContext, new String[]{c.this.dSb});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.aA(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.aA(VideoPlayActivityConfig.OBJ_ID, c.this.dSc);
                    amVar.aA("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.aA("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.Ef().c(c.this.mContext, new String[]{c.this.dSb});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.aA(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.aA(VideoPlayActivityConfig.OBJ_ID, c.this.dSc);
                amVar2.aA("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.aA("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dSd = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bAz = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dMs = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.eiM = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.eiN = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds72);
        this.eiO = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = aEk();
        this.bAz = (RelativeLayout) this.mParent.findViewById(e.g.container);
        this.eji = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(e.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.ejl = (ImageView) this.mParent.findViewById(e.g.speed_icon);
        this.dRY = (TextView) this.mParent.findViewById(e.g.member_image);
        this.dRZ = (TextView) this.mParent.findViewById(e.g.post_image);
        this.eiT = (TextView) this.mParent.findViewById(e.g.level_name);
        this.ejR = (TextView) this.mParent.findViewById(e.g.level);
        this.eiR = (TextView) this.mParent.findViewById(e.g.tv_love);
        this.eiS = (TextView) this.mParent.findViewById(e.g.tv_sign);
        this.eiS.setContentDescription(frsFragment.getResources().getString(e.j.sign));
        this.eiU = (ImageView) this.mParent.findViewById(e.g.love_level_top);
        this.eiV = (ImageView) this.mParent.findViewById(e.g.love_level_bg);
        this.eiP = (TextView) this.mParent.findViewById(e.g.member_num_text);
        this.eiQ = (TextView) this.mParent.findViewById(e.g.post_num_text);
        this.ejn = (BarImageView) this.mParent.findViewById(e.g.frs_image);
        this.dJO = (TextView) this.mParent.findViewById(e.g.forum_name);
        this.ejI = (TextView) this.mParent.findViewById(e.g.brand_label);
        this.ejn.setPageId(this.dMs.getUniqueId());
        this.ejn.setContentDescription(frsFragment.getResources().getString(e.j.bar_header));
        this.ejn.setGifIconSupport(false);
        this.ejn.setDrawerType(0);
        this.eiW = LayoutInflater.from(this.dMs.getPageContext().getPageActivity()).inflate(e.h.frs_header_extra_entelechy, (ViewGroup) null);
        aDZ();
        aEf();
        aEh();
        this.eiX = (ViewGroup) this.eiW.findViewById(e.g.frs_header_games);
        this.eiY = (TextView) this.eiW.findViewById(e.g.top_item_title);
        this.ejf = (LinearLayout) this.eiW.findViewById(e.g.frs_present_root);
        this.ejT = (TextView) this.bAz.findViewById(e.g.new_chapter_btn);
        this.ejr = new com.baidu.tieba.frs.view.e(this.mContext, this.eiW);
        this.ejq = new com.baidu.tieba.frs.f.b(this.mContext);
        this.ejb = (ViewGroup) this.eiW.findViewById(e.g.frs_headline);
        this.ejc = (TextView) this.ejb.findViewById(e.g.headline_title);
        this.ejd = (TextView) this.ejb.findViewById(e.g.headline_text);
        this.eje = (TbImageView) this.ejb.findViewById(e.g.headline_image);
        this.eje.setPageId(this.dMs.getUniqueId());
        this.ejb.setVisibility(8);
        this.ejQ = this.mParent.findViewById(e.g.level_container);
        this.ejP = (RelativeLayout) this.mParent.findViewById(e.g.has_focused_container);
        this.ejO = (RelativeLayout) this.mParent.findViewById(e.g.not_focused_container);
        this.ejS = (RelativeLayout) this.mParent.findViewById(e.g.head_content_container);
        this.dSa = (ImageView) this.mParent.findViewById(e.g.single_bar_level);
        this.dSa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.kV()) {
                    l.showToast(c.this.mContext.getPageActivity(), e.j.neterror);
                } else if (!StringUtils.isNull(c.this.dSf) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.Ef().c(c.this.mContext, new String[]{c.this.dSf + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        aEi();
        this.dRU = (FrsStarRankAndTaskContainer) this.mParent.findViewById(e.g.frs_star_rank_container);
        this.dRU.setContext(this.mContext);
        this.dRX = new LinearLayout(this.dMs.getContext());
        this.dRX.setOrientation(1);
        this.dRX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dRX.addView(this.eja);
        aEe();
    }

    private void aEe() {
        this.dRX.addView(this.dSg);
        this.dRX.addView(this.dSi);
    }

    private void hc(boolean z) {
        this.dSg.setVisibility(z ? 0 : 8);
        this.dSi.setVisibility(z ? 0 : 8);
    }

    private void aEf() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds16);
        this.dSg = new AdapterLinearLayout(this.dMs.getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        this.dSg.setLayoutParams(layoutParams);
        this.dSg.setOrientation(1);
        this.dSh = new com.baidu.tieba.frs.g.b.a(this.dMs.getPageContext());
        this.dSg.setAdapter(this.dSh);
        this.dSi = new AdapterLinearLayout(this.dMs.getPageContext().getPageActivity());
        this.dSi.setLayoutParams(layoutParams);
        this.dSi.setOrientation(1);
        this.dSj = new com.baidu.tieba.frs.g.a.a(this.dMs.getTbPageContext());
        this.dSi.setAdapter(this.dSj);
        this.dSi.setPadding(0, 0, 0, h);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View aEg() {
        return this.dRX;
    }

    private void aEh() {
        this.dSe = (FrsHeaderPraiseView) this.eiW.findViewById(e.g.frs_praise_layout);
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar == null) {
            hc(false);
            return;
        }
        NebulaHotThreads bDj = lVar.bDj();
        if (bDj == null || v.I(bDj.threads)) {
            hc(false);
            return;
        }
        hc(true);
        List<NebulaHotThread> list = bDj.threads;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tieba.frs.g.b.b(bDj.url));
        this.dSh.setData(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (NebulaHotThread nebulaHotThread : list) {
            com.baidu.tieba.frs.g.a.b bVar = new com.baidu.tieba.frs.g.a.b();
            bVar.oi(nebulaHotThread.comment_number.intValue()).bY(nebulaHotThread.content).ok(nebulaHotThread.thread_thumbnail_type.intValue()).oZ(nebulaHotThread.group_name).oY(nebulaHotThread.thread_thumbnail).oX(nebulaHotThread.url).oj(nebulaHotThread.rank.intValue());
            arrayList2.add(bVar);
        }
        this.dSj.setData(arrayList2);
    }

    private void aEi() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.ejs = (ag) runTask.getData();
            this.ejs.a(this.mContext, this.mParent, 1, false, this.dMs.getUniqueId());
            this.ejs.hide();
        }
    }

    private void aEj() {
        final com.baidu.tbadk.core.data.l bCF = this.egI.bCF();
        if (bCF != null && this.egI.bgT() != null) {
            final String id = this.egI.bgT().getId();
            final String name = this.egI.bgT().getName();
            if (this.ejM.add(bCF.yg())) {
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bCF.yg(), id, name, null);
                b.cM("obj_url", bCF.getUrl());
                b.save();
            }
            this.ejb.setVisibility(0);
            this.ejc.setText(bCF.getText());
            this.ejd.setText(bCF.getTitle());
            this.eje.startLoad(bCF.yf(), 10, false);
            this.ejb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0316a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bCF.yg(), id, name, null);
                    b2.cM("obj_url", bCF.getUrl());
                    b2.save();
                    ay.Ef().c(c.this.dMs.getPageContext(), new String[]{bCF.getUrl()});
                }
            });
        }
    }

    protected View aEk() {
        return LayoutInflater.from(this.dMs.getPageContext().getPageActivity()).inflate(e.h.frs_normal_header, (ViewGroup) null);
    }

    private void mJ(int i) {
        if (i <= 0 || i > 5 || this.ejG) {
            this.dSa.setVisibility(8);
            this.dJO.setMaxWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds370));
            return;
        }
        this.dSa.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dSk[i - 1]);
        this.dSa.setImageDrawable(drawable);
        this.dJO.setMaxWidth((l.h(this.mContext.getPageActivity(), e.C0210e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dSa.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void s(View.OnClickListener onClickListener) {
        this.ejn.setOnClickListener(onClickListener);
        this.dJO.setOnClickListener(onClickListener);
        this.eiS.setOnClickListener(onClickListener);
        this.eiR.setOnClickListener(onClickListener);
        this.ejQ.setOnClickListener(onClickListener);
        if (this.eiX != null) {
            this.eiX.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEl() {
        al.j(this.ejS, e.d.black_alpha0);
        al.j(this.bAz, e.d.black_alpha0);
        al.h(this.dJO, e.d.cp_cont_i);
        al.h(this.eiT, e.d.cp_cont_i);
        al.h(this.ejR, e.d.cp_cont_i);
        al.i(this.ejI, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.ejI, e.d.cp_cont_i);
        al.h(this.dRY, e.d.cp_cont_i);
        al.h(this.eiP, e.d.cp_cont_i);
        al.h(this.dRZ, e.d.cp_cont_i);
        al.h(this.eiQ, e.d.cp_cont_i);
        al.j(this.eiV, e.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEm() {
        this.ejI.setVisibility(0);
        this.dSa.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.eji);
        this.mContext.getLayoutMode().onModeChanged(this.eiW);
        if (this.ejE) {
            oa(1);
        } else {
            oa(0);
        }
        this.ejn.invalidate();
        al.j(this.bAz, e.d.cp_bg_line_d);
        al.h(this.ejR, e.d.cp_cont_j);
        al.h(this.eiT, e.d.cp_cont_j);
        al.h(this.dRY, e.d.cp_cont_j);
        al.h(this.eiP, e.d.cp_cont_j);
        al.h(this.dRZ, e.d.cp_cont_j);
        al.h(this.eiQ, e.d.cp_cont_j);
        this.ejn.setBorderWidth(l.h(this.mContext.getPageActivity(), e.C0210e.tbds1));
        this.ejn.setBorderColor(al.getColor(e.d.black_alpha15));
        aEq();
        if (this.eiX != null) {
            al.i(this.eiX, e.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.ejl, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.ejl, e.f.icon_sml_speed_gray);
        }
        if (this.ejr != null) {
            this.ejr.changeSkinType(i);
        }
        if (this.ejs != null) {
            this.ejs.changeSkinType(i);
        }
        if (this.ejo != null) {
            this.ejo.eD(i);
        }
        Iterator<TbImageView> it = this.dSd.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aEa();
        al.i(this.ejb, e.f.home_thread_card_item_bg);
        al.h(this.dJO, e.d.cp_cont_b);
        if (this.dRT != null) {
            com.baidu.tbadk.o.a.a(this.dMs.getPageContext(), this.dRT);
        }
        if (this.dSe.getVisibility() == 0) {
            this.dSe.changeSkinType(i);
        }
        al.i(this.ejT, e.f.btn_round_cont_d);
        al.h(this.ejT, e.d.btn_cont_j_alpha_20_selector);
        al.j(this.eiV, e.d.common_color_10043);
        if (this.dRU != null && this.dRU.getVisibility() == 0) {
            this.dRU.onChangeSkinType();
        }
        if (this.ejG) {
            aEl();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ejx = forumData.getPost_num();
            this.eju = forumData.getTag_color();
            this.aqP = forumData.getImage_url();
            this.ejt = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ejy = forumData.getSignData().count_sign_num;
                this.ejz = forumData.getSignData().miss_sign_num;
            }
            this.ejA = forumData.getCurScore();
            this.efZ = forumData.getLevelupScore();
            this.ejp = forumData.getBadgeData();
            this.ejg = forumData.getTopCode();
            this.ejh = forumData.getNewsInfo();
            this.ejv = forumData.getAccelerateContent();
            this.ejG = forumData.isBrandForum;
            this.egI = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.ejw = new bb();
            aEn();
            aEr();
            aEj();
            this.dSe.setVisibility(8);
            if (lVar != null && lVar.bCd() != null) {
                mJ(lVar.bCd().grade.intValue());
                this.dSf = lVar.bCd().url;
            }
            if (lVar != null && lVar.hmE != null) {
                FrsTabInfo frsTabInfo = lVar.hmE;
                this.dSb = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dSc = frsTabInfo.tab_gid;
                this.ejT.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.ejT.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.aA(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.dSc);
                        amVar.aA("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.ejT.setOnClickListener(this.dSl);
            } else {
                this.ejT.setVisibility(8);
            }
            if (lVar != null && lVar.hmF != null) {
                this.dRU.setData(lVar.hmF);
                this.dRU.setVisibility(0);
                this.ejS.setPadding(0, this.ejS.getPaddingTop(), 0, 0);
                return;
            }
            this.dRU.setVisibility(8);
        }
    }

    protected void aEn() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aqP);
        this.ejw.zR().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aEo() {
        Drawable drawable;
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        if (this.ejz > 0) {
            al.c(this.eiS, e.d.cp_cont_i, 1);
            Drawable drawable2 = al.getDrawable(e.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), e.C0210e.tbds24);
            this.eiS.setPadding(h2, 0, h2, 0);
            this.eiS.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eiS.setText(String.format(this.mContext.getString(e.j.miss_sign_days), Integer.valueOf(this.ejz)));
            al.i(this.eiS, e.f.frs_attention_btn_bg_selector);
        } else {
            if (this.ejG) {
                drawable = al.getDrawable(e.f.icon_frs_sign_h_white);
                al.c(this.eiS, e.d.cp_cont_i, 1);
            } else {
                drawable = al.getDrawable(e.f.icon_public_sign_blue);
                al.c(this.eiS, e.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, h, h);
            this.eiS.setCompoundDrawables(drawable, null, null, null);
            this.eiS.setText(this.mContext.getString(e.j.signed));
            this.eiS.setPadding(0, 0, 0, 0);
            this.eiS.setBackgroundDrawable(null);
        }
        this.eiS.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        this.eiS.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aEp() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.eiS.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eiS.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.eiS, e.d.cp_cont_i, 1);
        al.i(this.eiS, e.f.frs_attention_btn_bg_selector);
    }

    protected void aEq() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.eiR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eiR.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.eiR, e.d.cp_cont_g, 1);
        al.i(this.eiR, e.f.frs_attention_btn_bg_selector);
    }

    protected void aEr() {
        List<g> list = null;
        if (this.eiP != null) {
            this.eiP.setText(ao.T(this.mMemberNum));
        }
        if (this.eiQ != null) {
            this.eiQ.setText(ao.T(this.ejx));
        }
        if (this.ejp != null && this.ejp.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.dwu != null) {
                this.dwu.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
            if (this.dJO != null) {
                this.dJO.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
        }
        if (this.eiX != null && this.eiY != null) {
            if (this.egI != null && this.egI.bCp()) {
                if (m.ft(this.egI.bCr()) == 1 && !n.aAe) {
                    this.eiX.setVisibility(8);
                } else {
                    this.eiX.setVisibility(0);
                    if (!TextUtils.isEmpty(this.egI.getGameName()) && !TextUtils.isEmpty(this.egI.getGameName().trim())) {
                        this.eiY.setText(UtilHelper.getFixedText(this.egI.getGameName(), 10));
                        String vR = com.baidu.tieba.tbadkCore.util.b.vR(this.egI.bCr());
                        if (!StringUtils.isNull(vR)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", vR, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.eiY.setText(this.mContext.getResources().getString(e.j.frsgame_title));
                    }
                }
            } else {
                this.eiX.setVisibility(8);
            }
        }
        this.ejf.setVisibility(8);
        this.ejr.a(null, null);
        if (this.eiX != null) {
            this.eiZ = this.eiX.findViewById(e.g.top_item_divider);
        }
        aEs();
        if (this.egI != null && !v.I(this.egI.bCq())) {
            list = this.egI.bCq();
            bU(list);
        }
        bF(list);
        c(this.egI);
    }

    protected void aEs() {
        this.ejn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejn.startLoad(this.aqP, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.ejN);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.eji);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds100));
                this.ejj = (TextView) this.eji.findViewById(e.g.cur_experience);
                this.ejk = (TextView) this.eji.findViewById(e.g.levelup_experience);
                a(this.ejj, this.ejk);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.ejj, this.ejk);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.ejN, SystemScreenshotManager.DELAY_TIME);
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
            if (!TextUtils.isEmpty(this.ejv) && !TextUtils.isEmpty(this.ejv.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ejv);
            } else {
                textView3.setVisibility(8);
            }
            aVar.dc(e.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.BF();
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
    public void aEt() {
        View contentView;
        if (this.ejm == null) {
            this.ejm = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.speed_tip, (ViewGroup) null);
            this.ejm.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.ejm, c.this.mContext.getPageActivity());
                        c.this.dMs.dKE = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.ejm.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds300));
            this.ejm.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds88));
            this.ejm.setBackgroundDrawable(new BitmapDrawable());
            this.ejm.setOutsideTouchable(true);
            this.ejm.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.ejm);
                        c.this.dMs.dKE = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.ejm.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.ejl.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.ejm, this.mParent, 0, (iArr[0] - (this.ejm.getWidth() / 2)) + (this.ejl.getWidth() / 2), iArr[1] + this.ejl.getWidth());
        this.ejm.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.ejF = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(e.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.ejF) {
                this.eiT.setText(e.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l aBO = this.dMs.aBO();
                if (aBO != null && aBO.bgT() != null) {
                    aBO.bgT().setUser_level(i);
                }
                this.ejR.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(i)));
            } else {
                this.eiT.setText(this.ejt);
                this.ejR.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.eiU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, mK(this.mLevel)));
            if (this.ejF) {
                if (f >= 1.0f) {
                    a(this.dMs.getBaseFragmentActivity(), this.eiU, this.ejH, f);
                } else {
                    b(this.dMs.getBaseFragmentActivity(), this.eiU, this.ejH, f);
                }
            } else {
                a(this.dMs.getBaseFragmentActivity(), this.eiU, this.ejH, f);
            }
            this.ejH = f;
        }
    }

    private int[] mK(int i) {
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
    protected void aEu() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aEv() {
        if (this.mMemberType != 0) {
            al.c(this.ejl, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.ejl, e.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aib() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Et();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fZ(String str) {
                ay.Ef().c(c.this.mContext, new String[]{c.this.dSb});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void ga(String str) {
            }
        });
        return aVar.A(pageActivity);
    }

    public String yl() {
        return this.dSc;
    }

    public String aEw() {
        return this.dSb;
    }
}
