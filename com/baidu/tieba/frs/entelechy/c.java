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
    private String Wn;
    private RelativeLayout bbS;
    private g cMA;
    private String cMB;
    private FrsHeaderPraiseView cMD;
    private FrsEntranceStoryListWrapperView cME;
    private String cMF;
    private TextView cMw;
    private TextView cMx;
    private View cMy;
    private ImageView cMz;
    private int mTabId;
    private int[] cMG = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener cMH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dcB != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bSV.setVisibility(8);
                } else {
                    c.this.bSV.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener cMI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.cMB)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ac("obj_param1", c.this.mTabId == 201 ? "2" : "1").ac("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                av.vI().c(c.this.abX, new String[]{c.this.cMB});
            }
        }
    };
    private ArrayList<TbImageView> cMC = new ArrayList<>();

    public c(com.baidu.tieba.frs.g gVar, String str, String str2, int i) {
        this.bbS = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cIy = gVar;
        this.abX = gVar.getPageContext();
        this.dcr = l.f(gVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dcs = l.f(gVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dct = l.f(gVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.beq = ann();
        this.bbS = (RelativeLayout) this.beq.findViewById(d.g.container);
        this.dcN = LayoutInflater.from(gVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.beq.setVisibility(8);
        }
        this.dcQ = (ImageView) this.beq.findViewById(d.g.speed_icon);
        this.cMw = (TextView) this.beq.findViewById(d.g.member_image);
        this.cMx = (TextView) this.beq.findViewById(d.g.post_image);
        this.dcz = (TextView) this.beq.findViewById(d.g.level_name);
        this.ddw = (TextView) this.beq.findViewById(d.g.level);
        this.dcx = (TextView) this.beq.findViewById(d.g.tv_love);
        this.dcy = (TextView) this.beq.findViewById(d.g.tv_sign);
        this.dcy.setContentDescription(gVar.getResources().getString(d.j.sign));
        this.dcA = (ImageView) this.beq.findViewById(d.g.love_level_top);
        this.dcv = (TextView) this.beq.findViewById(d.g.member_num_text);
        this.dcw = (TextView) this.beq.findViewById(d.g.post_num_text);
        this.dcS = (BarImageView) this.beq.findViewById(d.g.frs_image);
        this.cGz = (TextView) this.beq.findViewById(d.g.forum_name);
        this.dcS.setPageId(this.cIy.getUniqueId());
        this.dcS.setContentDescription(gVar.getResources().getString(d.j.bar_header));
        this.dcS.setGifIconSupport(false);
        this.dcS.setDrawerType(0);
        this.dcB = LayoutInflater.from(this.cIy.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        and();
        ank();
        anj();
        this.dcC = (ViewGroup) this.dcB.findViewById(d.g.frs_header_games);
        this.dcD = (TextView) this.dcB.findViewById(d.g.top_item_title);
        this.dcJ = (LinearLayout) this.dcB.findViewById(d.g.frs_present_root);
        this.ddy = (TextView) this.bbS.findViewById(d.g.new_chapter_btn);
        this.bSV = this.dcB.findViewById(d.g.divider_bottom);
        this.cMy = this.dcB.findViewById(d.g.stroy_divider_bottom);
        this.dcW = new f(this.abX, this.dcB);
        this.dcV = new com.baidu.tieba.frs.f.b(this.abX);
        this.dcF = (ViewGroup) this.dcB.findViewById(d.g.frs_headline);
        this.dcG = (TextView) this.dcF.findViewById(d.g.headline_title);
        this.dcH = (TextView) this.dcF.findViewById(d.g.headline_text);
        this.dcI = (TbImageView) this.dcF.findViewById(d.g.headline_image);
        this.dcI.setPageId(this.cIy.getUniqueId());
        this.dcF.setVisibility(8);
        this.ddv = this.beq.findViewById(d.g.level_container);
        this.ddt = (RelativeLayout) this.beq.findViewById(d.g.has_focused_container);
        this.dds = (RelativeLayout) this.beq.findViewById(d.g.not_focused_container);
        this.ddx = (RelativeLayout) this.beq.findViewById(d.g.head_content_container);
        this.cMz = (ImageView) this.beq.findViewById(d.g.single_bar_level);
        this.cMz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.abX.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.hh()) {
                    l.showToast(c.this.abX.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.cMF) && !StringUtils.isNull(c.this.mForumId)) {
                    av.vI().c(c.this.abX, new String[]{c.this.cMF + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        anl();
        this.cIy.registerListener(this.cMH);
    }

    private void anj() {
        this.cMD = (FrsHeaderPraiseView) this.dcB.findViewById(d.g.frs_praise_layout);
    }

    private void ank() {
        this.cME = (FrsEntranceStoryListWrapperView) this.dcB.findViewById(d.g.listview_story_wrapper_view);
        this.cME.l(this.cIy.getPageContext());
    }

    private void anl() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.dcX = (ai) runTask.getData();
            this.dcX.a(this.abX, this.beq, 1, false, this.cIy.getUniqueId());
            this.dcX.hide();
        }
    }

    private void anm() {
        final com.baidu.tbadk.core.data.l bvu = this.cOD.bvu();
        if (bvu != null && this.cOD.aRn() != null) {
            final String id = this.cOD.aRn().getId();
            final String name = this.cOD.aRn().getName();
            if (this.ddq.add(bvu.pG())) {
                a.C0143a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bvu.pG(), id, name, null);
                b.cg("obj_url", bvu.getUrl());
                b.save();
            }
            this.dcF.setVisibility(0);
            this.dcG.setText(bvu.getText());
            this.dcH.setText(bvu.getTitle());
            this.dcI.startLoad(bvu.pF(), 10, false);
            this.dcF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0143a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bvu.pG(), id, name, null);
                    b2.cg("obj_url", bvu.getUrl());
                    b2.save();
                    av.vI().c(c.this.cIy.getPageContext(), new String[]{bvu.getUrl()});
                }
            });
        }
    }

    protected View ann() {
        return LayoutInflater.from(this.cIy.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void kd(int i) {
        if (i <= 0 || i > 5) {
            this.cMz.setVisibility(8);
            this.cGz.setMaxWidth(l.f(this.abX.getPageActivity(), d.e.ds370));
            return;
        }
        this.cMz.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.cMG[i - 1]);
        this.cMz.setImageDrawable(drawable);
        this.cGz.setMaxWidth((l.f(this.abX.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.cMz.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.dcS.setOnClickListener(onClickListener);
        this.cGz.setOnClickListener(onClickListener);
        this.dcy.setOnClickListener(onClickListener);
        this.dcx.setOnClickListener(onClickListener);
        this.ddv.setOnClickListener(onClickListener);
        if (this.dcC != null) {
            this.dcC.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.abX.getLayoutMode().ag(i == 1);
        this.abX.getLayoutMode().t(this.beq);
        this.abX.getLayoutMode().t(this.dcN);
        this.abX.getLayoutMode().t(this.dcB);
        if (this.ddk) {
            lj(1);
        } else {
            lj(0);
        }
        this.dcS.invalidate();
        aj.k(this.bbS, d.C0096d.cp_bg_line_d);
        aj.k(this.bSV, d.C0096d.cp_bg_line_e);
        aj.i(this.ddw, d.C0096d.cp_cont_j);
        aj.i(this.dcz, d.C0096d.cp_cont_j);
        aj.i(this.cMw, d.C0096d.cp_cont_j);
        aj.i(this.dcv, d.C0096d.cp_cont_j);
        aj.i(this.cMx, d.C0096d.cp_cont_j);
        aj.i(this.dcw, d.C0096d.cp_cont_j);
        if (this.cME != null) {
            aj.k(this.cME, d.C0096d.cp_bg_line_d);
        }
        this.dcS.setBorderWidth(l.f(this.abX.getPageActivity(), d.e.tbds1));
        this.dcS.setBorderColor(aj.getColor(d.C0096d.black_alpha15));
        anr();
        if (this.dcC != null) {
            aj.j(this.dcC, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dcQ, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dcQ, d.f.icon_sml_speed_gray);
        }
        if (this.dcW != null) {
            this.dcW.changeSkinType(i);
        }
        if (this.dcX != null) {
            this.dcX.changeSkinType(i);
        }
        if (this.dcT != null) {
            this.dcT.dE(i);
        }
        Iterator<TbImageView> it = this.cMC.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        anf();
        aj.j(this.dcF, d.f.home_thread_card_item_bg);
        aj.i(this.cGz, d.C0096d.cp_cont_b);
        if (this.cMs != null) {
            com.baidu.tbadk.n.a.a(this.cIy.getPageContext(), this.cMs);
        }
        if (this.cME.getVisibility() == 0) {
            this.cME.changeSkinType(i);
        }
        aj.k(this.cMy, d.C0096d.cp_bg_line_c);
        if (this.cMD.getVisibility() == 0) {
            this.cMD.changeSkinType(i);
        }
        if (this.cMu != null) {
            this.cMu.onChangeSkinType();
        }
        aj.j(this.ddy, d.f.btn_round_cont_d);
        aj.i(this.ddy, d.C0096d.btn_cont_j_alpha_20_selector);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, k kVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ddc = forumData.getPost_num();
            this.dcZ = forumData.getTag_color();
            this.Wn = forumData.getImage_url();
            this.dcY = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ddd = forumData.getSignData().count_sign_num;
                this.dde = forumData.getSignData().miss_sign_num;
            }
            this.ddf = forumData.getCurScore();
            this.daO = forumData.getLevelupScore();
            this.dcU = forumData.getBadgeData();
            this.dcK = forumData.getTopCode();
            this.dcL = forumData.getNewsInfo();
            this.dda = forumData.getAccelerateContent();
            this.cOD = kVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.beq.setVisibility(8);
            } else {
                this.beq.setVisibility(0);
            }
            this.ddb = new bd();
            ano();
            ans();
            anm();
            if (this.cOD != null) {
                this.cME.b(this.cOD.buN(), this.cIy.getForumId(), "0");
            } else {
                this.cME.setVisibility(8);
                this.cMy.setVisibility(8);
            }
            this.cMD.setVisibility(8);
            if (this.cMA == null) {
                this.cMA = new g(this.cIy.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cME.setOnClick(this.cMA);
            }
            if (kVar != null && kVar.buP() != null) {
                kd(kVar.buP().grade.intValue());
                this.cMF = kVar.buP().url;
            }
            if (kVar != null && kVar.gAh != null) {
                FrsTabInfo frsTabInfo = kVar.gAh;
                this.cMB = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.ddy.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.ddy.setText(frsTabInfo.tab_name);
                }
                this.ddy.setOnClickListener(this.cMI);
                return;
            }
            this.ddy.setVisibility(8);
        }
    }

    protected void ano() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.Wn);
        this.ddb.rG().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void anp() {
        int f = l.f(this.abX.getPageActivity(), d.e.tbds32);
        if (this.dde > 0) {
            aj.c(this.dcy, d.C0096d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, f, f);
            int f2 = l.f(this.abX.getPageActivity(), d.e.tbds24);
            this.dcy.setPadding(f2, 0, f2, 0);
            this.dcy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dcy.setText(String.format(this.abX.getString(d.j.miss_sign_days), Integer.valueOf(this.dde)));
            aj.j(this.dcy, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, f, f);
            this.dcy.setCompoundDrawables(drawable2, null, null, null);
            aj.c(this.dcy, d.C0096d.cp_cont_e, 1);
            this.dcy.setText(this.abX.getString(d.j.signed));
            this.dcy.setPadding(0, 0, 0, 0);
            this.dcy.setBackgroundDrawable(null);
        }
        this.dcy.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dcy.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void anq() {
        int f = l.f(this.abX.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dcy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dcy.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.c(this.dcy, d.C0096d.cp_cont_i, 1);
        aj.j(this.dcy, d.f.frs_attention_btn_bg_selector);
    }

    protected void anr() {
        int f = l.f(this.abX.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dcx.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dcx.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.c(this.dcx, d.C0096d.cp_cont_g, 1);
        aj.j(this.dcx, d.f.frs_attention_btn_bg_selector);
    }

    protected void ans() {
        if (this.dcv != null) {
            this.dcv.setText(am.w(this.mMemberNum));
        }
        if (this.dcw != null) {
            this.dcw.setText(am.w(this.ddc));
        }
        if (this.dcU != null && this.dcU.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.abX.getString(d.j.forum));
            }
            if (this.cGz != null) {
                this.cGz.setText(this.mForumName + this.abX.getString(d.j.forum));
            }
        }
        if (this.dcC != null && this.dcD != null) {
            if (this.cOD != null && this.cOD.bvb()) {
                if (m.dD(this.cOD.bve()) == 1 && !n.afr) {
                    this.dcC.setVisibility(8);
                } else {
                    this.dcC.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cOD.getGameName()) && !TextUtils.isEmpty(this.cOD.getGameName().trim())) {
                        this.dcD.setText(UtilHelper.getFixedText(this.cOD.getGameName(), 10));
                        String tl = com.baidu.tieba.tbadkCore.util.b.tl(this.cOD.bve());
                        if (!StringUtils.isNull(tl)) {
                            TiebaStatic.eventStat(this.abX.getPageActivity(), "game_show", "show", 1, "dev_id", tl, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dcD.setText(this.abX.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dcC.setVisibility(8);
            }
        }
        this.cMu.clearData();
        if (this.cOD != null && !v.w(this.cOD.bvc())) {
            List<com.baidu.tieba.tbadkCore.f> bvc = this.cOD.bvc();
            bo(bvc);
            this.cMu.bm(bvc);
        }
        this.dcJ.setVisibility(8);
        this.dcW.a(null, null);
        this.dcE = this.dcC.findViewById(d.g.top_item_divider);
        ant();
        ane();
    }

    protected void ant() {
        this.dcS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dcS.startLoad(this.Wn, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.ddr);
            if (this.dcM == null) {
                this.dcM = new PopupWindow(this.abX.getPageActivity());
                this.dcM.setContentView(this.dcN);
                this.dcM.setBackgroundDrawable(new BitmapDrawable());
                this.dcM.setOutsideTouchable(true);
                this.dcM.setFocusable(true);
                this.dcM.setWidth(this.abX.getResources().getDimensionPixelSize(d.e.ds228));
                this.dcM.setHeight(this.abX.getResources().getDimensionPixelSize(d.e.ds100));
                this.dcO = (TextView) this.dcN.findViewById(d.g.cur_experience);
                this.dcP = (TextView) this.dcN.findViewById(d.g.levelup_experience);
                a(this.dcO, this.dcP);
            }
            if (this.dcM.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.dcM, this.abX.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dcO, this.dcP);
            if (iArr[1] - this.dcM.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.dcM, this.abX.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dcM, this.beq, 0, iArr[0], iArr[1] - this.dcM.getHeight());
            this.dcM.update();
            this.mHandler.postDelayed(this.ddr, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.abX.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0096d.cp_cont_b, 1);
            aj.c(textView, d.C0096d.cp_cont_b, 1);
            aj.c(textView2, d.C0096d.cp_cont_b, 1);
            aj.c(textView3, d.C0096d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abX.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dda) && !TextUtils.isEmpty(this.dda.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dda);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ce(d.C0096d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.abX);
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
                if (c.this.abX != null && c.this.abX.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.abX.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void anu() {
        View contentView;
        if (this.dcR == null) {
            this.dcR = new PopupWindow(this.abX.getPageActivity());
            contentView = LayoutInflater.from(this.abX.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dcR.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.abX != null && c.this.abX.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dcR, c.this.abX.getPageActivity());
                        c.this.cIy.cGX = false;
                        com.baidu.tbadk.browser.a.a(c.this.abX.getPageActivity(), c.this.abX.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dcR.setWidth(this.abX.getResources().getDimensionPixelSize(d.e.ds300));
            this.dcR.setHeight(this.abX.getResources().getDimensionPixelSize(d.e.ds88));
            this.dcR.setBackgroundDrawable(new BitmapDrawable());
            this.dcR.setOutsideTouchable(true);
            this.dcR.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dcR);
                        c.this.cIy.cGX = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dcR.getContentView();
        }
        this.abX.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.dcQ.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dcR, this.beq, 0, (iArr[0] - (this.dcR.getWidth() / 2)) + (this.dcQ.getWidth() / 2), iArr[1] + this.dcQ.getWidth());
        this.dcR.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.ddl = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.ddl) {
                this.dcz.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                k alE = this.cIy.alE();
                if (alE != null && alE.aRn() != null) {
                    alE.aRn().setUser_level(i);
                }
                this.ddw.setText(this.abX.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dcz.setText(this.dcY);
                this.ddw.setText(this.abX.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dcA.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ke(this.mLevel)));
            if (this.ddl) {
                if (f >= 1.0f) {
                    a(this.cIy.getBaseFragmentActivity(), this.dcA, this.ddm, f);
                } else {
                    b(this.cIy.getBaseFragmentActivity(), this.dcA, this.ddm, f);
                }
            } else {
                a(this.cIy.getBaseFragmentActivity(), this.dcA, this.ddm, f);
            }
            this.ddm = f;
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
    protected void anv() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void anw() {
        if (this.mMemberType != 0) {
            aj.c(this.dcQ, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dcQ, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cMH);
    }

    public FrsEntranceStoryListWrapperView anx() {
        return this.cME;
    }
}
