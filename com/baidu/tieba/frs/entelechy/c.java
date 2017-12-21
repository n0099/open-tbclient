package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.entelechy.view.FrsEntranceStoryListWrapperView;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.story.g;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c extends a {
    private String Wq;
    private RelativeLayout bbW;
    private TextView cMA;
    private TextView cMB;
    private View cMC;
    private ImageView cMD;
    private g cME;
    private String cMF;
    private FrsHeaderPraiseView cMH;
    private FrsEntranceStoryListWrapperView cMI;
    private String cMJ;
    private int mTabId;
    private int[] cMK = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener cML = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dcF != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bSZ.setVisibility(8);
                } else {
                    c.this.bSZ.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener cMM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.cMF)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ac("obj_param1", c.this.mTabId == 201 ? "2" : "1").ac("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                av.vI().c(c.this.aca, new String[]{c.this.cMF});
            }
        }
    };
    private ArrayList<TbImageView> cMG = new ArrayList<>();

    public c(com.baidu.tieba.frs.g gVar, String str, String str2, int i) {
        this.bbW = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cIC = gVar;
        this.aca = gVar.getPageContext();
        this.dcw = l.f(gVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dcx = l.f(gVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dcy = l.f(gVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.bev = ano();
        this.bbW = (RelativeLayout) this.bev.findViewById(d.g.container);
        this.dcR = LayoutInflater.from(gVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.bev.setVisibility(8);
        }
        this.dcU = (ImageView) this.bev.findViewById(d.g.speed_icon);
        this.cMA = (TextView) this.bev.findViewById(d.g.member_image);
        this.cMB = (TextView) this.bev.findViewById(d.g.post_image);
        this.dcD = (TextView) this.bev.findViewById(d.g.level_name);
        this.ddA = (TextView) this.bev.findViewById(d.g.level);
        this.dcB = (TextView) this.bev.findViewById(d.g.tv_love);
        this.dcC = (TextView) this.bev.findViewById(d.g.tv_sign);
        this.dcC.setContentDescription(gVar.getResources().getString(d.j.sign));
        this.dcE = (ImageView) this.bev.findViewById(d.g.love_level_top);
        this.dcz = (TextView) this.bev.findViewById(d.g.member_num_text);
        this.dcA = (TextView) this.bev.findViewById(d.g.post_num_text);
        this.dcW = (BarImageView) this.bev.findViewById(d.g.frs_image);
        this.cGD = (TextView) this.bev.findViewById(d.g.forum_name);
        this.dcW.setPageId(this.cIC.getUniqueId());
        this.dcW.setContentDescription(gVar.getResources().getString(d.j.bar_header));
        this.dcW.setGifIconSupport(false);
        this.dcW.setDrawerType(0);
        this.dcF = LayoutInflater.from(this.cIC.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        ane();
        anl();
        ank();
        this.dcG = (ViewGroup) this.dcF.findViewById(d.g.frs_header_games);
        this.dcH = (TextView) this.dcF.findViewById(d.g.top_item_title);
        this.dcN = (LinearLayout) this.dcF.findViewById(d.g.frs_present_root);
        this.ddC = (TextView) this.bbW.findViewById(d.g.new_chapter_btn);
        this.bSZ = this.dcF.findViewById(d.g.divider_bottom);
        this.cMC = this.dcF.findViewById(d.g.stroy_divider_bottom);
        this.dda = new f(this.aca, this.dcF);
        this.dcZ = new com.baidu.tieba.frs.f.b(this.aca);
        this.dcJ = (ViewGroup) this.dcF.findViewById(d.g.frs_headline);
        this.dcK = (TextView) this.dcJ.findViewById(d.g.headline_title);
        this.dcL = (TextView) this.dcJ.findViewById(d.g.headline_text);
        this.dcM = (TbImageView) this.dcJ.findViewById(d.g.headline_image);
        this.dcM.setPageId(this.cIC.getUniqueId());
        this.dcJ.setVisibility(8);
        this.ddz = this.bev.findViewById(d.g.level_container);
        this.ddy = (RelativeLayout) this.bev.findViewById(d.g.has_focused_container);
        this.ddx = (RelativeLayout) this.bev.findViewById(d.g.not_focused_container);
        this.ddB = (RelativeLayout) this.bev.findViewById(d.g.head_content_container);
        this.cMD = (ImageView) this.bev.findViewById(d.g.single_bar_level);
        this.cMD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.aca.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.hh()) {
                    l.showToast(c.this.aca.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.cMJ) && !StringUtils.isNull(c.this.mForumId)) {
                    av.vI().c(c.this.aca, new String[]{c.this.cMJ + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        anm();
        this.cIC.registerListener(this.cML);
    }

    private void ank() {
        this.cMH = (FrsHeaderPraiseView) this.dcF.findViewById(d.g.frs_praise_layout);
    }

    private void anl() {
        this.cMI = (FrsEntranceStoryListWrapperView) this.dcF.findViewById(d.g.listview_story_wrapper_view);
        this.cMI.l(this.cIC.getPageContext());
    }

    private void anm() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.ddb = (ai) runTask.getData();
            this.ddb.a(this.aca, this.bev, 1, false, this.cIC.getUniqueId());
            this.ddb.hide();
        }
    }

    private void ann() {
        final com.baidu.tbadk.core.data.l bvv = this.cOH.bvv();
        if (bvv != null && this.cOH.aRo() != null) {
            final String id = this.cOH.aRo().getId();
            final String name = this.cOH.aRo().getName();
            if (this.ddv.add(bvv.pG())) {
                a.C0142a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bvv.pG(), id, name, null);
                b.cg("obj_url", bvv.getUrl());
                b.save();
            }
            this.dcJ.setVisibility(0);
            this.dcK.setText(bvv.getText());
            this.dcL.setText(bvv.getTitle());
            this.dcM.startLoad(bvv.pF(), 10, false);
            this.dcJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0142a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bvv.pG(), id, name, null);
                    b2.cg("obj_url", bvv.getUrl());
                    b2.save();
                    av.vI().c(c.this.cIC.getPageContext(), new String[]{bvv.getUrl()});
                }
            });
        }
    }

    protected View ano() {
        return LayoutInflater.from(this.cIC.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void kd(int i) {
        if (i <= 0 || i > 5) {
            this.cMD.setVisibility(8);
            this.cGD.setMaxWidth(l.f(this.aca.getPageActivity(), d.e.ds370));
            return;
        }
        this.cMD.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.cMK[i - 1]);
        this.cMD.setImageDrawable(drawable);
        this.cGD.setMaxWidth((l.f(this.aca.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.cMD.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.dcW.setOnClickListener(onClickListener);
        this.cGD.setOnClickListener(onClickListener);
        this.dcC.setOnClickListener(onClickListener);
        this.dcB.setOnClickListener(onClickListener);
        this.ddz.setOnClickListener(onClickListener);
        if (this.dcG != null) {
            this.dcG.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aca.getLayoutMode().ag(i == 1);
        this.aca.getLayoutMode().t(this.bev);
        this.aca.getLayoutMode().t(this.dcR);
        this.aca.getLayoutMode().t(this.dcF);
        if (this.ddo) {
            lj(1);
        } else {
            lj(0);
        }
        this.dcW.invalidate();
        aj.k(this.bbW, d.C0095d.cp_bg_line_d);
        aj.k(this.bSZ, d.C0095d.cp_bg_line_e);
        aj.i(this.ddA, d.C0095d.cp_cont_j);
        aj.i(this.dcD, d.C0095d.cp_cont_j);
        aj.i(this.cMA, d.C0095d.cp_cont_j);
        aj.i(this.dcz, d.C0095d.cp_cont_j);
        aj.i(this.cMB, d.C0095d.cp_cont_j);
        aj.i(this.dcA, d.C0095d.cp_cont_j);
        if (this.cMI != null) {
            aj.k(this.cMI, d.C0095d.cp_bg_line_d);
        }
        this.dcW.setBorderWidth(l.f(this.aca.getPageActivity(), d.e.tbds1));
        this.dcW.setBorderColor(aj.getColor(d.C0095d.black_alpha15));
        ans();
        if (this.dcG != null) {
            aj.j(this.dcG, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dcU, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dcU, d.f.icon_sml_speed_gray);
        }
        if (this.dda != null) {
            this.dda.changeSkinType(i);
        }
        if (this.ddb != null) {
            this.ddb.changeSkinType(i);
        }
        if (this.dcX != null) {
            this.dcX.dE(i);
        }
        Iterator<TbImageView> it = this.cMG.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        ang();
        aj.j(this.dcJ, d.f.home_thread_card_item_bg);
        aj.i(this.cGD, d.C0095d.cp_cont_b);
        if (this.cMw != null) {
            com.baidu.tbadk.n.a.a(this.cIC.getPageContext(), this.cMw);
        }
        if (this.cMI.getVisibility() == 0) {
            this.cMI.changeSkinType(i);
        }
        aj.k(this.cMC, d.C0095d.cp_bg_line_c);
        if (this.cMH.getVisibility() == 0) {
            this.cMH.changeSkinType(i);
        }
        if (this.cMy != null) {
            this.cMy.onChangeSkinType();
        }
        aj.j(this.ddC, d.f.btn_round_cont_d);
        aj.i(this.ddC, d.C0095d.btn_cont_j_alpha_20_selector);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, k kVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ddg = forumData.getPost_num();
            this.ddd = forumData.getTag_color();
            this.Wq = forumData.getImage_url();
            this.ddc = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ddh = forumData.getSignData().count_sign_num;
                this.ddi = forumData.getSignData().miss_sign_num;
            }
            this.ddj = forumData.getCurScore();
            this.daS = forumData.getLevelupScore();
            this.dcY = forumData.getBadgeData();
            this.dcO = forumData.getTopCode();
            this.dcP = forumData.getNewsInfo();
            this.dde = forumData.getAccelerateContent();
            this.cOH = kVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.bev.setVisibility(8);
            } else {
                this.bev.setVisibility(0);
            }
            this.ddf = new bd();
            anp();
            ant();
            ann();
            if (this.cOH != null) {
                this.cMI.b(this.cOH.buO(), this.cIC.getForumId(), "0");
            } else {
                this.cMI.setVisibility(8);
                this.cMC.setVisibility(8);
            }
            this.cMH.setVisibility(8);
            if (this.cME == null) {
                this.cME = new g(this.cIC.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cMI.setOnClick(this.cME);
            }
            if (kVar != null && kVar.buQ() != null) {
                kd(kVar.buQ().grade.intValue());
                this.cMJ = kVar.buQ().url;
            }
            if (kVar != null && kVar.gAm != null) {
                FrsTabInfo frsTabInfo = kVar.gAm;
                this.cMF = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.ddC.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.ddC.setText(frsTabInfo.tab_name);
                }
                this.ddC.setOnClickListener(this.cMM);
                return;
            }
            this.ddC.setVisibility(8);
        }
    }

    protected void anp() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.Wq);
        this.ddf.rG().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void anq() {
        int f = l.f(this.aca.getPageActivity(), d.e.tbds32);
        if (this.ddi > 0) {
            aj.c(this.dcC, d.C0095d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, f, f);
            int f2 = l.f(this.aca.getPageActivity(), d.e.tbds24);
            this.dcC.setPadding(f2, 0, f2, 0);
            this.dcC.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dcC.setText(String.format(this.aca.getString(d.j.miss_sign_days), Integer.valueOf(this.ddi)));
            aj.j(this.dcC, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, f, f);
            this.dcC.setCompoundDrawables(drawable2, null, null, null);
            aj.c(this.dcC, d.C0095d.cp_cont_e, 1);
            this.dcC.setText(this.aca.getString(d.j.signed));
            this.dcC.setPadding(0, 0, 0, 0);
            this.dcC.setBackgroundDrawable(null);
        }
        this.dcC.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dcC.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void anr() {
        int f = l.f(this.aca.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dcC.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dcC.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.c(this.dcC, d.C0095d.cp_cont_i, 1);
        aj.j(this.dcC, d.f.frs_attention_btn_bg_selector);
    }

    protected void ans() {
        int f = l.f(this.aca.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dcB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dcB.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.c(this.dcB, d.C0095d.cp_cont_g, 1);
        aj.j(this.dcB, d.f.frs_attention_btn_bg_selector);
    }

    protected void ant() {
        if (this.dcz != null) {
            this.dcz.setText(am.w(this.mMemberNum));
        }
        if (this.dcA != null) {
            this.dcA.setText(am.w(this.ddg));
        }
        if (this.dcY != null && this.dcY.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aca.getString(d.j.forum));
            }
            if (this.cGD != null) {
                this.cGD.setText(this.mForumName + this.aca.getString(d.j.forum));
            }
        }
        if (this.dcG != null && this.dcH != null) {
            if (this.cOH != null && this.cOH.bvc()) {
                if (m.dD(this.cOH.bvf()) == 1 && !n.afu) {
                    this.dcG.setVisibility(8);
                } else {
                    this.dcG.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cOH.getGameName()) && !TextUtils.isEmpty(this.cOH.getGameName().trim())) {
                        this.dcH.setText(UtilHelper.getFixedText(this.cOH.getGameName(), 10));
                        String tl = com.baidu.tieba.tbadkCore.util.b.tl(this.cOH.bvf());
                        if (!StringUtils.isNull(tl)) {
                            TiebaStatic.eventStat(this.aca.getPageActivity(), "game_show", "show", 1, "dev_id", tl, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dcH.setText(this.aca.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dcG.setVisibility(8);
            }
        }
        this.cMy.clearData();
        if (this.cOH != null && !v.w(this.cOH.bvd())) {
            List<com.baidu.tieba.tbadkCore.f> bvd = this.cOH.bvd();
            bo(bvd);
            this.cMy.bm(bvd);
        }
        this.dcN.setVisibility(8);
        this.dda.a(null, null);
        this.dcI = this.dcG.findViewById(d.g.top_item_divider);
        anu();
        anf();
    }

    protected void anu() {
        this.dcW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dcW.startLoad(this.Wq, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.ddw);
            if (this.dcQ == null) {
                this.dcQ = new PopupWindow(this.aca.getPageActivity());
                this.dcQ.setContentView(this.dcR);
                this.dcQ.setBackgroundDrawable(new BitmapDrawable());
                this.dcQ.setOutsideTouchable(true);
                this.dcQ.setFocusable(true);
                this.dcQ.setWidth(this.aca.getResources().getDimensionPixelSize(d.e.ds228));
                this.dcQ.setHeight(this.aca.getResources().getDimensionPixelSize(d.e.ds100));
                this.dcS = (TextView) this.dcR.findViewById(d.g.cur_experience);
                this.dcT = (TextView) this.dcR.findViewById(d.g.levelup_experience);
                a(this.dcS, this.dcT);
            }
            if (this.dcQ.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.dcQ, this.aca.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dcS, this.dcT);
            if (iArr[1] - this.dcQ.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.dcQ, this.aca.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dcQ, this.bev, 0, iArr[0], iArr[1] - this.dcQ.getHeight());
            this.dcQ.update();
            this.mHandler.postDelayed(this.ddw, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aca.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0095d.cp_cont_b, 1);
            aj.c(textView, d.C0095d.cp_cont_b, 1);
            aj.c(textView2, d.C0095d.cp_cont_b, 1);
            aj.c(textView3, d.C0095d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aca.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dde) && !TextUtils.isEmpty(this.dde.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dde);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ce(d.C0095d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aca);
            aVar.th();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (c.this.aca != null && c.this.aca.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aca.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void anv() {
        View contentView;
        if (this.dcV == null) {
            this.dcV = new PopupWindow(this.aca.getPageActivity());
            contentView = LayoutInflater.from(this.aca.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dcV.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aca != null && c.this.aca.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dcV, c.this.aca.getPageActivity());
                        c.this.cIC.cHb = false;
                        com.baidu.tbadk.browser.a.a(c.this.aca.getPageActivity(), c.this.aca.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dcV.setWidth(this.aca.getResources().getDimensionPixelSize(d.e.ds300));
            this.dcV.setHeight(this.aca.getResources().getDimensionPixelSize(d.e.ds88));
            this.dcV.setBackgroundDrawable(new BitmapDrawable());
            this.dcV.setOutsideTouchable(true);
            this.dcV.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dcV);
                        c.this.cIC.cHb = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dcV.getContentView();
        }
        this.aca.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.dcU.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dcV, this.bev, 0, (iArr[0] - (this.dcV.getWidth() / 2)) + (this.dcU.getWidth() / 2), iArr[1] + this.dcU.getWidth());
        this.dcV.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.ddp = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.ddp) {
                this.dcD.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                k alE = this.cIC.alE();
                if (alE != null && alE.aRo() != null) {
                    alE.aRo().setUser_level(i);
                }
                this.ddA.setText(this.aca.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dcD.setText(this.ddc);
                this.ddA.setText(this.aca.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dcE.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ke(this.mLevel)));
            if (this.ddp) {
                if (f >= 1.0f) {
                    a(this.cIC.getBaseFragmentActivity(), this.dcE, this.ddq, f);
                } else {
                    b(this.cIC.getBaseFragmentActivity(), this.dcE, this.ddq, f);
                }
            } else {
                a(this.cIC.getBaseFragmentActivity(), this.dcE, this.ddq, f);
            }
            this.ddq = f;
        }
    }

    private int[] ke(int i) {
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
    protected void anw() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void anx() {
        if (this.mMemberType != 0) {
            aj.c(this.dcU, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dcU, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cML);
    }

    public FrsEntranceStoryListWrapperView any() {
        return this.cMI;
    }
}
