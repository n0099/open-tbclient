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
    private RelativeLayout bAw;
    private final LinearLayout dPj;
    private TextView dPk;
    private TextView dPl;
    private ImageView dPm;
    private String dPn;
    private String dPo;
    private FrsHeaderPraiseView dPq;
    private String dPr;
    private AdapterLinearLayout dPs;
    private com.baidu.tieba.frs.g.b.a dPt;
    private AdapterLinearLayout dPu;
    private com.baidu.tieba.frs.g.a.a dPv;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dPw = {e.f.icon_frs_emotion_level1, e.f.icon_frs_emotion_level2, e.f.icon_frs_emotion_level3, e.f.icon_frs_emotion_level4, e.f.icon_frs_emotion_level5};
    private View.OnClickListener dPx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dPo)) {
                        ay.Ef().c(c.this.mContext, new String[]{c.this.dPn});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.ahL()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dPo));
                        }
                    } else if (PluginPackageManager.na().cb("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).BN();
                        z = false;
                    } else {
                        ay.Ef().c(c.this.mContext, new String[]{c.this.dPn});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.aA(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.aA(VideoPlayActivityConfig.OBJ_ID, c.this.dPo);
                    amVar.aA("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.aA("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.Ef().c(c.this.mContext, new String[]{c.this.dPn});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.aA(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.aA(VideoPlayActivityConfig.OBJ_ID, c.this.dPo);
                amVar2.aA("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.aA("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dPp = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bAw = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dJE = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.efV = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds20);
        this.efW = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds72);
        this.efX = l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = aDv();
        this.bAw = (RelativeLayout) this.mParent.findViewById(e.g.container);
        this.egr = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(e.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.egu = (ImageView) this.mParent.findViewById(e.g.speed_icon);
        this.dPk = (TextView) this.mParent.findViewById(e.g.member_image);
        this.dPl = (TextView) this.mParent.findViewById(e.g.post_image);
        this.egc = (TextView) this.mParent.findViewById(e.g.level_name);
        this.eha = (TextView) this.mParent.findViewById(e.g.level);
        this.ega = (TextView) this.mParent.findViewById(e.g.tv_love);
        this.egb = (TextView) this.mParent.findViewById(e.g.tv_sign);
        this.egb.setContentDescription(frsFragment.getResources().getString(e.j.sign));
        this.egd = (ImageView) this.mParent.findViewById(e.g.love_level_top);
        this.ege = (ImageView) this.mParent.findViewById(e.g.love_level_bg);
        this.efY = (TextView) this.mParent.findViewById(e.g.member_num_text);
        this.efZ = (TextView) this.mParent.findViewById(e.g.post_num_text);
        this.egw = (BarImageView) this.mParent.findViewById(e.g.frs_image);
        this.dHa = (TextView) this.mParent.findViewById(e.g.forum_name);
        this.egR = (TextView) this.mParent.findViewById(e.g.brand_label);
        this.egw.setPageId(this.dJE.getUniqueId());
        this.egw.setContentDescription(frsFragment.getResources().getString(e.j.bar_header));
        this.egw.setGifIconSupport(false);
        this.egw.setDrawerType(0);
        this.egf = LayoutInflater.from(this.dJE.getPageContext().getPageActivity()).inflate(e.h.frs_header_extra_entelechy, (ViewGroup) null);
        aDk();
        aDq();
        aDs();
        this.egg = (ViewGroup) this.egf.findViewById(e.g.frs_header_games);
        this.egh = (TextView) this.egf.findViewById(e.g.top_item_title);
        this.ego = (LinearLayout) this.egf.findViewById(e.g.frs_present_root);
        this.ehc = (TextView) this.bAw.findViewById(e.g.new_chapter_btn);
        this.egA = new com.baidu.tieba.frs.view.e(this.mContext, this.egf);
        this.egz = new com.baidu.tieba.frs.f.b(this.mContext);
        this.egk = (ViewGroup) this.egf.findViewById(e.g.frs_headline);
        this.egl = (TextView) this.egk.findViewById(e.g.headline_title);
        this.egm = (TextView) this.egk.findViewById(e.g.headline_text);
        this.egn = (TbImageView) this.egk.findViewById(e.g.headline_image);
        this.egn.setPageId(this.dJE.getUniqueId());
        this.egk.setVisibility(8);
        this.egZ = this.mParent.findViewById(e.g.level_container);
        this.egY = (RelativeLayout) this.mParent.findViewById(e.g.has_focused_container);
        this.egX = (RelativeLayout) this.mParent.findViewById(e.g.not_focused_container);
        this.ehb = (RelativeLayout) this.mParent.findViewById(e.g.head_content_container);
        this.dPm = (ImageView) this.mParent.findViewById(e.g.single_bar_level);
        this.dPm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.kV()) {
                    l.showToast(c.this.mContext.getPageActivity(), e.j.neterror);
                } else if (!StringUtils.isNull(c.this.dPr) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.Ef().c(c.this.mContext, new String[]{c.this.dPr + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        aDt();
        this.dPg = (FrsStarRankAndTaskContainer) this.mParent.findViewById(e.g.frs_star_rank_container);
        this.dPg.setContext(this.mContext);
        this.dPj = new LinearLayout(this.dJE.getContext());
        this.dPj.setOrientation(1);
        this.dPj.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dPj.addView(this.egj);
        aDp();
    }

    private void aDp() {
        this.dPj.addView(this.dPs);
        this.dPj.addView(this.dPu);
    }

    private void gZ(boolean z) {
        this.dPs.setVisibility(z ? 0 : 8);
        this.dPu.setVisibility(z ? 0 : 8);
    }

    private void aDq() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds16);
        this.dPs = new AdapterLinearLayout(this.dJE.getPageContext().getPageActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        this.dPs.setLayoutParams(layoutParams);
        this.dPs.setOrientation(1);
        this.dPt = new com.baidu.tieba.frs.g.b.a(this.dJE.getPageContext());
        this.dPs.setAdapter(this.dPt);
        this.dPu = new AdapterLinearLayout(this.dJE.getPageContext().getPageActivity());
        this.dPu.setLayoutParams(layoutParams);
        this.dPu.setOrientation(1);
        this.dPv = new com.baidu.tieba.frs.g.a.a(this.dJE.getTbPageContext());
        this.dPu.setAdapter(this.dPv);
        this.dPu.setPadding(0, 0, 0, h);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View aDr() {
        return this.dPj;
    }

    private void aDs() {
        this.dPq = (FrsHeaderPraiseView) this.egf.findViewById(e.g.frs_praise_layout);
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar == null) {
            gZ(false);
            return;
        }
        NebulaHotThreads bCr = lVar.bCr();
        if (bCr == null || v.I(bCr.threads)) {
            gZ(false);
            return;
        }
        gZ(true);
        List<NebulaHotThread> list = bCr.threads;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.baidu.tieba.frs.g.b.b(bCr.url));
        this.dPt.setData(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (NebulaHotThread nebulaHotThread : list) {
            com.baidu.tieba.frs.g.a.b bVar = new com.baidu.tieba.frs.g.a.b();
            bVar.nV(nebulaHotThread.comment_number.intValue()).bX(nebulaHotThread.content).nX(nebulaHotThread.thread_thumbnail_type.intValue()).oW(nebulaHotThread.group_name).oV(nebulaHotThread.thread_thumbnail).oU(nebulaHotThread.url).nW(nebulaHotThread.rank.intValue());
            arrayList2.add(bVar);
        }
        this.dPv.setData(arrayList2);
    }

    private void aDt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.egB = (ag) runTask.getData();
            this.egB.a(this.mContext, this.mParent, 1, false, this.dJE.getUniqueId());
            this.egB.hide();
        }
    }

    private void aDu() {
        final com.baidu.tbadk.core.data.l bBN = this.edR.bBN();
        if (bBN != null && this.edR.bgh() != null) {
            final String id = this.edR.bgh().getId();
            final String name = this.edR.bgh().getName();
            if (this.egV.add(bBN.yg())) {
                a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bBN.yg(), id, name, null);
                b.cM("obj_url", bBN.getUrl());
                b.save();
            }
            this.egk.setVisibility(0);
            this.egl.setText(bBN.getText());
            this.egm.setText(bBN.getTitle());
            this.egn.startLoad(bBN.yf(), 10, false);
            this.egk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0316a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bBN.yg(), id, name, null);
                    b2.cM("obj_url", bBN.getUrl());
                    b2.save();
                    ay.Ef().c(c.this.dJE.getPageContext(), new String[]{bBN.getUrl()});
                }
            });
        }
    }

    protected View aDv() {
        return LayoutInflater.from(this.dJE.getPageContext().getPageActivity()).inflate(e.h.frs_normal_header, (ViewGroup) null);
    }

    private void mw(int i) {
        if (i <= 0 || i > 5 || this.egP) {
            this.dPm.setVisibility(8);
            this.dHa.setMaxWidth(l.h(this.mContext.getPageActivity(), e.C0210e.ds370));
            return;
        }
        this.dPm.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dPw[i - 1]);
        this.dPm.setImageDrawable(drawable);
        this.dHa.setMaxWidth((l.h(this.mContext.getPageActivity(), e.C0210e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dPm.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void s(View.OnClickListener onClickListener) {
        this.egw.setOnClickListener(onClickListener);
        this.dHa.setOnClickListener(onClickListener);
        this.egb.setOnClickListener(onClickListener);
        this.ega.setOnClickListener(onClickListener);
        this.egZ.setOnClickListener(onClickListener);
        if (this.egg != null) {
            this.egg.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aDw() {
        al.j(this.ehb, e.d.black_alpha0);
        al.j(this.bAw, e.d.black_alpha0);
        al.h(this.dHa, e.d.cp_cont_i);
        al.h(this.egc, e.d.cp_cont_i);
        al.h(this.eha, e.d.cp_cont_i);
        al.i(this.egR, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.egR, e.d.cp_cont_i);
        al.h(this.dPk, e.d.cp_cont_i);
        al.h(this.efY, e.d.cp_cont_i);
        al.h(this.dPl, e.d.cp_cont_i);
        al.h(this.efZ, e.d.cp_cont_i);
        al.j(this.ege, e.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aDx() {
        this.egR.setVisibility(0);
        this.dPm.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.egr);
        this.mContext.getLayoutMode().onModeChanged(this.egf);
        if (this.egN) {
            nN(1);
        } else {
            nN(0);
        }
        this.egw.invalidate();
        al.j(this.bAw, e.d.cp_bg_line_d);
        al.h(this.eha, e.d.cp_cont_j);
        al.h(this.egc, e.d.cp_cont_j);
        al.h(this.dPk, e.d.cp_cont_j);
        al.h(this.efY, e.d.cp_cont_j);
        al.h(this.dPl, e.d.cp_cont_j);
        al.h(this.efZ, e.d.cp_cont_j);
        this.egw.setBorderWidth(l.h(this.mContext.getPageActivity(), e.C0210e.tbds1));
        this.egw.setBorderColor(al.getColor(e.d.black_alpha15));
        aDB();
        if (this.egg != null) {
            al.i(this.egg, e.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.egu, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.egu, e.f.icon_sml_speed_gray);
        }
        if (this.egA != null) {
            this.egA.changeSkinType(i);
        }
        if (this.egB != null) {
            this.egB.changeSkinType(i);
        }
        if (this.egx != null) {
            this.egx.eC(i);
        }
        Iterator<TbImageView> it = this.dPp.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aDl();
        al.i(this.egk, e.f.home_thread_card_item_bg);
        al.h(this.dHa, e.d.cp_cont_b);
        if (this.dPf != null) {
            com.baidu.tbadk.o.a.a(this.dJE.getPageContext(), this.dPf);
        }
        if (this.dPq.getVisibility() == 0) {
            this.dPq.changeSkinType(i);
        }
        al.i(this.ehc, e.f.btn_round_cont_d);
        al.h(this.ehc, e.d.btn_cont_j_alpha_20_selector);
        al.j(this.ege, e.d.common_color_10043);
        if (this.dPg != null && this.dPg.getVisibility() == 0) {
            this.dPg.onChangeSkinType();
        }
        if (this.egP) {
            aDw();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.egG = forumData.getPost_num();
            this.egD = forumData.getTag_color();
            this.aqP = forumData.getImage_url();
            this.egC = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.egH = forumData.getSignData().count_sign_num;
                this.egI = forumData.getSignData().miss_sign_num;
            }
            this.egJ = forumData.getCurScore();
            this.edi = forumData.getLevelupScore();
            this.egy = forumData.getBadgeData();
            this.egp = forumData.getTopCode();
            this.egq = forumData.getNewsInfo();
            this.egE = forumData.getAccelerateContent();
            this.egP = forumData.isBrandForum;
            this.edR = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.egF = new bb();
            aDy();
            aDC();
            aDu();
            this.dPq.setVisibility(8);
            if (lVar != null && lVar.bBl() != null) {
                mw(lVar.bBl().grade.intValue());
                this.dPr = lVar.bBl().url;
            }
            if (lVar != null && lVar.hjt != null) {
                FrsTabInfo frsTabInfo = lVar.hjt;
                this.dPn = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dPo = frsTabInfo.tab_gid;
                this.ehc.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.ehc.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.aA(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.dPo);
                        amVar.aA("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.ehc.setOnClickListener(this.dPx);
            } else {
                this.ehc.setVisibility(8);
            }
            if (lVar != null && lVar.hju != null) {
                this.dPg.setData(lVar.hju);
                this.dPg.setVisibility(0);
                this.ehb.setPadding(0, this.ehb.getPaddingTop(), 0, 0);
                return;
            }
            this.dPg.setVisibility(8);
        }
    }

    protected void aDy() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aqP);
        this.egF.zR().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aDz() {
        Drawable drawable;
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        if (this.egI > 0) {
            al.c(this.egb, e.d.cp_cont_i, 1);
            Drawable drawable2 = al.getDrawable(e.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), e.C0210e.tbds24);
            this.egb.setPadding(h2, 0, h2, 0);
            this.egb.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.egb.setText(String.format(this.mContext.getString(e.j.miss_sign_days), Integer.valueOf(this.egI)));
            al.i(this.egb, e.f.frs_attention_btn_bg_selector);
        } else {
            if (this.egP) {
                drawable = al.getDrawable(e.f.icon_frs_sign_h_white);
                al.c(this.egb, e.d.cp_cont_i, 1);
            } else {
                drawable = al.getDrawable(e.f.icon_public_sign_blue);
                al.c(this.egb, e.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, h, h);
            this.egb.setCompoundDrawables(drawable, null, null, null);
            this.egb.setText(this.mContext.getString(e.j.signed));
            this.egb.setPadding(0, 0, 0, 0);
            this.egb.setBackgroundDrawable(null);
        }
        this.egb.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        this.egb.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aDA() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.egb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.egb.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.egb, e.d.cp_cont_i, 1);
        al.i(this.egb, e.f.frs_attention_btn_bg_selector);
    }

    protected void aDB() {
        int h = l.h(this.mContext.getPageActivity(), e.C0210e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.ega.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ega.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds34));
        al.c(this.ega, e.d.cp_cont_g, 1);
        al.i(this.ega, e.f.frs_attention_btn_bg_selector);
    }

    protected void aDC() {
        List<g> list = null;
        if (this.efY != null) {
            this.efY.setText(ao.S(this.mMemberNum));
        }
        if (this.efZ != null) {
            this.efZ.setText(ao.S(this.egG));
        }
        if (this.egy != null && this.egy.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.dtG != null) {
                this.dtG.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
            if (this.dHa != null) {
                this.dHa.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
        }
        if (this.egg != null && this.egh != null) {
            if (this.edR != null && this.edR.bBx()) {
                if (m.ft(this.edR.bBz()) == 1 && !n.aAe) {
                    this.egg.setVisibility(8);
                } else {
                    this.egg.setVisibility(0);
                    if (!TextUtils.isEmpty(this.edR.getGameName()) && !TextUtils.isEmpty(this.edR.getGameName().trim())) {
                        this.egh.setText(UtilHelper.getFixedText(this.edR.getGameName(), 10));
                        String vO = com.baidu.tieba.tbadkCore.util.b.vO(this.edR.bBz());
                        if (!StringUtils.isNull(vO)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", vO, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.egh.setText(this.mContext.getResources().getString(e.j.frsgame_title));
                    }
                }
            } else {
                this.egg.setVisibility(8);
            }
        }
        this.ego.setVisibility(8);
        this.egA.a(null, null);
        if (this.egg != null) {
            this.egi = this.egg.findViewById(e.g.top_item_divider);
        }
        aDD();
        if (this.edR != null && !v.I(this.edR.bBy())) {
            list = this.edR.bBy();
            bT(list);
        }
        bE(list);
        c(this.edR);
    }

    protected void aDD() {
        this.egw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.egw.startLoad(this.aqP, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.egW);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.egr);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds100));
                this.egs = (TextView) this.egr.findViewById(e.g.cur_experience);
                this.egt = (TextView) this.egr.findViewById(e.g.levelup_experience);
                a(this.egs, this.egt);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.egs, this.egt);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.egW, SystemScreenshotManager.DELAY_TIME);
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
            if (!TextUtils.isEmpty(this.egE) && !TextUtils.isEmpty(this.egE.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.egE);
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
    public void aDE() {
        View contentView;
        if (this.egv == null) {
            this.egv = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.speed_tip, (ViewGroup) null);
            this.egv.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.egv, c.this.mContext.getPageActivity());
                        c.this.dJE.dHQ = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.egv.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds300));
            this.egv.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds88));
            this.egv.setBackgroundDrawable(new BitmapDrawable());
            this.egv.setOutsideTouchable(true);
            this.egv.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.egv);
                        c.this.dJE.dHQ = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.egv.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.egu.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.egv, this.mParent, 0, (iArr[0] - (this.egv.getWidth() / 2)) + (this.egu.getWidth() / 2), iArr[1] + this.egu.getWidth());
        this.egv.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.egO = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(e.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.egO) {
                this.egc.setText(e.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l aAZ = this.dJE.aAZ();
                if (aAZ != null && aAZ.bgh() != null) {
                    aAZ.bgh().setUser_level(i);
                }
                this.eha.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(i)));
            } else {
                this.egc.setText(this.egC);
                this.eha.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.egd.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, mx(this.mLevel)));
            if (this.egO) {
                if (f >= 1.0f) {
                    a(this.dJE.getBaseFragmentActivity(), this.egd, this.egQ, f);
                } else {
                    b(this.dJE.getBaseFragmentActivity(), this.egd, this.egQ, f);
                }
            } else {
                a(this.dJE.getBaseFragmentActivity(), this.egd, this.egQ, f);
            }
            this.egQ = f;
        }
    }

    private int[] mx(int i) {
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
    protected void aDF() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aDG() {
        if (this.mMemberType != 0) {
            al.c(this.egu, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.egu, e.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahL() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Et();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fY(String str) {
                ay.Ef().c(c.this.mContext, new String[]{c.this.dPn});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fZ(String str) {
            }
        });
        return aVar.A(pageActivity);
    }

    public String yl() {
        return this.dPo;
    }

    public String aDH() {
        return this.dPn;
    }
}
