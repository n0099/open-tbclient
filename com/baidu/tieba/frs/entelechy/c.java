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
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.entelechy.view.FrsEntranceStoryListWrapperView;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.view.e;
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
    private String Wt;
    private RelativeLayout bbR;
    private TextView cMl;
    private TextView cMm;
    private View cMn;
    private ImageView cMo;
    private g cMp;
    private String cMq;
    private FrsHeaderPraiseView cMs;
    private FrsEntranceStoryListWrapperView cMt;
    private String cMu;
    private int mTabId;
    private int[] cMv = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener cMw = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dbu != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bSR.setVisibility(8);
                } else {
                    c.this.bSR.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener cMx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.cMq)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ac("obj_param1", c.this.mTabId == 201 ? "2" : "1").ac("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                av.vL().c(c.this.acd, new String[]{c.this.cMq});
            }
        }
    };
    private ArrayList<TbImageView> cMr = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.bbR = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cIp = fVar;
        this.acd = fVar.getPageContext();
        this.dbl = l.f(fVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dbm = l.f(fVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dbn = l.f(fVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.bep = anf();
        this.bbR = (RelativeLayout) this.bep.findViewById(d.g.container);
        this.dbG = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.bep.setVisibility(8);
        }
        this.dbJ = (ImageView) this.bep.findViewById(d.g.speed_icon);
        this.cMl = (TextView) this.bep.findViewById(d.g.member_image);
        this.cMm = (TextView) this.bep.findViewById(d.g.post_image);
        this.dbs = (TextView) this.bep.findViewById(d.g.level_name);
        this.dco = (TextView) this.bep.findViewById(d.g.level);
        this.dbq = (TextView) this.bep.findViewById(d.g.tv_love);
        this.dbr = (TextView) this.bep.findViewById(d.g.tv_sign);
        this.dbr.setContentDescription(fVar.getResources().getString(d.j.sign));
        this.dbt = (ImageView) this.bep.findViewById(d.g.love_level_top);
        this.dbo = (TextView) this.bep.findViewById(d.g.member_num_text);
        this.dbp = (TextView) this.bep.findViewById(d.g.post_num_text);
        this.dbL = (BarImageView) this.bep.findViewById(d.g.frs_image);
        this.cGr = (TextView) this.bep.findViewById(d.g.forum_name);
        this.dbL.setPageId(this.cIp.getUniqueId());
        this.dbL.setContentDescription(fVar.getResources().getString(d.j.bar_header));
        this.dbL.setGifIconSupport(false);
        this.dbL.setDrawerType(0);
        this.dbu = LayoutInflater.from(this.cIp.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        amV();
        anc();
        anb();
        this.dbv = (ViewGroup) this.dbu.findViewById(d.g.frs_header_games);
        this.dbw = (TextView) this.dbu.findViewById(d.g.top_item_title);
        this.dbC = (LinearLayout) this.dbu.findViewById(d.g.frs_present_root);
        this.dcq = (TextView) this.bbR.findViewById(d.g.new_chapter_btn);
        this.bSR = this.dbu.findViewById(d.g.divider_bottom);
        this.cMn = this.dbu.findViewById(d.g.stroy_divider_bottom);
        this.dbP = new e(this.acd, this.dbu);
        this.dbO = new com.baidu.tieba.frs.f.b(this.acd);
        this.dby = (ViewGroup) this.dbu.findViewById(d.g.frs_headline);
        this.dbz = (TextView) this.dby.findViewById(d.g.headline_title);
        this.dbA = (TextView) this.dby.findViewById(d.g.headline_text);
        this.dbB = (TbImageView) this.dby.findViewById(d.g.headline_image);
        this.dbB.setPageId(this.cIp.getUniqueId());
        this.dby.setVisibility(8);
        this.dcn = this.bep.findViewById(d.g.level_container);
        this.dcm = (RelativeLayout) this.bep.findViewById(d.g.has_focused_container);
        this.dcl = (RelativeLayout) this.bep.findViewById(d.g.not_focused_container);
        this.dcp = (RelativeLayout) this.bep.findViewById(d.g.head_content_container);
        this.cMo = (ImageView) this.bep.findViewById(d.g.single_bar_level);
        this.cMo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.acd.getPageActivity(), (String) null, true, 11003)));
                } else if (!j.hh()) {
                    l.showToast(c.this.acd.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.cMu) && !StringUtils.isNull(c.this.mForumId)) {
                    av.vL().c(c.this.acd, new String[]{c.this.cMu + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        and();
        this.cIp.registerListener(this.cMw);
    }

    private void anb() {
        this.cMs = (FrsHeaderPraiseView) this.dbu.findViewById(d.g.frs_praise_layout);
    }

    private void anc() {
        this.cMt = (FrsEntranceStoryListWrapperView) this.dbu.findViewById(d.g.listview_story_wrapper_view);
        this.cMt.l(this.cIp.getPageContext());
    }

    private void and() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ah.class);
        if (runTask != null && runTask.getData() != null) {
            this.dbQ = (ah) runTask.getData();
            this.dbQ.a(this.acd, this.bep, 1, false, this.cIp.getUniqueId());
            this.dbQ.hide();
        }
    }

    private void ane() {
        final com.baidu.tbadk.core.data.l buO = this.cOs.buO();
        if (buO != null && this.cOs.aRf() != null) {
            final String id = this.cOs.aRf().getId();
            final String name = this.cOs.aRf().getName();
            if (this.dcj.add(buO.pI())) {
                a.C0128a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", buO.pI(), id, name, null);
                b.cf("obj_url", buO.getUrl());
                b.save();
            }
            this.dby.setVisibility(0);
            this.dbz.setText(buO.getText());
            this.dbA.setText(buO.getTitle());
            this.dbB.startLoad(buO.pH(), 10, false);
            this.dby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0128a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", buO.pI(), id, name, null);
                    b2.cf("obj_url", buO.getUrl());
                    b2.save();
                    av.vL().c(c.this.cIp.getPageContext(), new String[]{buO.getUrl()});
                }
            });
        }
    }

    protected View anf() {
        return LayoutInflater.from(this.cIp.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void kb(int i) {
        if (i <= 0 || i > 5) {
            this.cMo.setVisibility(8);
            this.cGr.setMaxWidth(l.f(this.acd.getPageActivity(), d.e.ds370));
            return;
        }
        this.cMo.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.cMv[i - 1]);
        this.cMo.setImageDrawable(drawable);
        this.cGr.setMaxWidth((l.f(this.acd.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.cMo.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.dbL.setOnClickListener(onClickListener);
        this.cGr.setOnClickListener(onClickListener);
        this.dbr.setOnClickListener(onClickListener);
        this.dbq.setOnClickListener(onClickListener);
        this.dcn.setOnClickListener(onClickListener);
        if (this.dbv != null) {
            this.dbv.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.acd.getLayoutMode().ag(i == 1);
        this.acd.getLayoutMode().t(this.bep);
        this.acd.getLayoutMode().t(this.dbG);
        this.acd.getLayoutMode().t(this.dbu);
        if (this.dcd) {
            lc(1);
        } else {
            lc(0);
        }
        this.dbL.invalidate();
        aj.k(this.bbR, d.C0082d.cp_bg_line_d);
        aj.k(this.bSR, d.C0082d.cp_bg_line_e);
        aj.i(this.dco, d.C0082d.cp_cont_j);
        aj.i(this.dbs, d.C0082d.cp_cont_j);
        aj.i(this.cMl, d.C0082d.cp_cont_j);
        aj.i(this.dbo, d.C0082d.cp_cont_j);
        aj.i(this.cMm, d.C0082d.cp_cont_j);
        aj.i(this.dbp, d.C0082d.cp_cont_j);
        if (this.cMt != null) {
            aj.k(this.cMt, d.C0082d.cp_bg_line_d);
        }
        this.dbL.setBorderWidth(l.f(this.acd.getPageActivity(), d.e.tbds1));
        this.dbL.setBorderColor(aj.getColor(d.C0082d.black_alpha15));
        anj();
        if (this.dbv != null) {
            aj.j(this.dbv, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dbJ, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dbJ, d.f.icon_sml_speed_gray);
        }
        if (this.dbP != null) {
            this.dbP.changeSkinType(i);
        }
        if (this.dbQ != null) {
            this.dbQ.changeSkinType(i);
        }
        if (this.dbM != null) {
            this.dbM.dE(i);
        }
        Iterator<TbImageView> it = this.cMr.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        amX();
        aj.j(this.dby, d.f.home_thread_card_item_bg);
        aj.i(this.cGr, d.C0082d.cp_cont_b);
        if (this.cMh != null) {
            com.baidu.tbadk.n.a.a(this.cIp.getPageContext(), this.cMh);
        }
        if (this.cMt.getVisibility() == 0) {
            this.cMt.changeSkinType(i);
        }
        aj.k(this.cMn, d.C0082d.cp_bg_line_c);
        if (this.cMs.getVisibility() == 0) {
            this.cMs.changeSkinType(i);
        }
        if (this.cMj != null) {
            this.cMj.onChangeSkinType();
        }
        aj.j(this.dcq, d.f.btn_round_cont_d);
        aj.i(this.dcq, d.C0082d.btn_cont_j_alpha_20_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, k kVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dbV = forumData.getPost_num();
            this.dbS = forumData.getTag_color();
            this.Wt = forumData.getImage_url();
            this.dbR = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dbW = forumData.getSignData().count_sign_num;
                this.dbX = forumData.getSignData().miss_sign_num;
            }
            this.dbY = forumData.getCurScore();
            this.daA = forumData.getLevelupScore();
            this.dbN = forumData.getBadgeData();
            this.dbD = forumData.getTopCode();
            this.dbE = forumData.getNewsInfo();
            this.dbT = forumData.getAccelerateContent();
            this.cOs = kVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.bep.setVisibility(8);
            } else {
                this.bep.setVisibility(0);
            }
            this.dbU = new bd();
            ang();
            ank();
            ane();
            if (this.cOs != null) {
                this.cMt.b(this.cOs.bui(), this.cIp.getForumId(), "0");
            } else {
                this.cMt.setVisibility(8);
                this.cMn.setVisibility(8);
            }
            this.cMs.setVisibility(8);
            if (this.cMp == null) {
                this.cMp = new g(this.cIp.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cMt.setOnClick(this.cMp);
            }
            if (kVar != null && kVar.buk() != null) {
                kb(kVar.buk().grade.intValue());
                this.cMu = kVar.buk().url;
            }
            if (kVar != null && kVar.gxz != null) {
                FrsTabInfo frsTabInfo = kVar.gxz;
                this.cMq = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dcq.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dcq.setText(frsTabInfo.tab_name);
                }
                this.dcq.setOnClickListener(this.cMx);
                return;
            }
            this.dcq.setVisibility(8);
        }
    }

    protected void ang() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.Wt);
        this.dbU.rI().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void anh() {
        int f = l.f(this.acd.getPageActivity(), d.e.tbds32);
        if (this.dbX > 0) {
            aj.c(this.dbr, d.C0082d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, f, f);
            int f2 = l.f(this.acd.getPageActivity(), d.e.tbds24);
            this.dbr.setPadding(f2, 0, f2, 0);
            this.dbr.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dbr.setText(String.format(this.acd.getString(d.j.miss_sign_days), Integer.valueOf(this.dbX)));
            aj.j(this.dbr, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, f, f);
            this.dbr.setCompoundDrawables(drawable2, null, null, null);
            aj.c(this.dbr, d.C0082d.cp_cont_e, 1);
            this.dbr.setText(this.acd.getString(d.j.signed));
            this.dbr.setPadding(0, 0, 0, 0);
            this.dbr.setBackgroundDrawable(null);
        }
        this.dbr.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dbr.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void ani() {
        int f = l.f(this.acd.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dbr.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dbr.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.c(this.dbr, d.C0082d.cp_cont_i, 1);
        aj.j(this.dbr, d.f.frs_attention_btn_bg_selector);
    }

    protected void anj() {
        int f = l.f(this.acd.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dbq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dbq.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.c(this.dbq, d.C0082d.cp_cont_g, 1);
        aj.j(this.dbq, d.f.frs_attention_btn_bg_selector);
    }

    protected void ank() {
        if (this.dbo != null) {
            this.dbo.setText(am.w(this.mMemberNum));
        }
        if (this.dbp != null) {
            this.dbp.setText(am.w(this.dbV));
        }
        if (this.dbN != null && this.dbN.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.acd.getString(d.j.forum));
            }
            if (this.cGr != null) {
                this.cGr.setText(this.mForumName + this.acd.getString(d.j.forum));
            }
        }
        if (this.dbv != null && this.dbw != null) {
            if (this.cOs != null && this.cOs.buv()) {
                if (m.dD(this.cOs.buy()) == 1 && !n.afx) {
                    this.dbv.setVisibility(8);
                } else {
                    this.dbv.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cOs.getGameName()) && !TextUtils.isEmpty(this.cOs.getGameName().trim())) {
                        this.dbw.setText(UtilHelper.getFixedText(this.cOs.getGameName(), 10));
                        String tg = com.baidu.tieba.tbadkCore.util.b.tg(this.cOs.buy());
                        if (!StringUtils.isNull(tg)) {
                            TiebaStatic.eventStat(this.acd.getPageActivity(), "game_show", "show", 1, "dev_id", tg, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dbw.setText(this.acd.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dbv.setVisibility(8);
            }
        }
        this.cMj.clearData();
        if (this.cOs != null && !v.w(this.cOs.buw())) {
            List<com.baidu.tieba.tbadkCore.f> buw = this.cOs.buw();
            bn(buw);
            this.cMj.bm(buw);
        }
        this.dbC.setVisibility(8);
        this.dbP.a(null, null);
        this.dbx = this.dbv.findViewById(d.g.top_item_divider);
        anl();
        amW();
    }

    protected void anl() {
        this.dbL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dbL.startLoad(this.Wt, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dck);
            if (this.dbF == null) {
                this.dbF = new PopupWindow(this.acd.getPageActivity());
                this.dbF.setContentView(this.dbG);
                this.dbF.setBackgroundDrawable(new BitmapDrawable());
                this.dbF.setOutsideTouchable(true);
                this.dbF.setFocusable(true);
                this.dbF.setWidth(this.acd.getResources().getDimensionPixelSize(d.e.ds228));
                this.dbF.setHeight(this.acd.getResources().getDimensionPixelSize(d.e.ds100));
                this.dbH = (TextView) this.dbG.findViewById(d.g.cur_experience);
                this.dbI = (TextView) this.dbG.findViewById(d.g.levelup_experience);
                a(this.dbH, this.dbI);
            }
            if (this.dbF.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.dbF, this.acd.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dbH, this.dbI);
            if (iArr[1] - this.dbF.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.dbF, this.acd.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dbF, this.bep, 0, iArr[0], iArr[1] - this.dbF.getHeight());
            this.dbF.update();
            this.mHandler.postDelayed(this.dck, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.acd.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0082d.cp_cont_b, 1);
            aj.c(textView, d.C0082d.cp_cont_b, 1);
            aj.c(textView2, d.C0082d.cp_cont_b, 1);
            aj.c(textView3, d.C0082d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.acd.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dbT) && !TextUtils.isEmpty(this.dbT.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dbT);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ce(d.C0082d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.acd);
            aVar.tk();
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
                if (c.this.acd != null && c.this.acd.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.acd.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void anm() {
        View contentView;
        if (this.dbK == null) {
            this.dbK = new PopupWindow(this.acd.getPageActivity());
            contentView = LayoutInflater.from(this.acd.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dbK.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.acd != null && c.this.acd.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dbK, c.this.acd.getPageActivity());
                        c.this.cIp.cGP = false;
                        com.baidu.tbadk.browser.a.a(c.this.acd.getPageActivity(), c.this.acd.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dbK.setWidth(this.acd.getResources().getDimensionPixelSize(d.e.ds300));
            this.dbK.setHeight(this.acd.getResources().getDimensionPixelSize(d.e.ds88));
            this.dbK.setBackgroundDrawable(new BitmapDrawable());
            this.dbK.setOutsideTouchable(true);
            this.dbK.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dbK);
                        c.this.cIp.cGP = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dbK.getContentView();
        }
        this.acd.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.dbJ.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dbK, this.bep, 0, (iArr[0] - (this.dbK.getWidth() / 2)) + (this.dbJ.getWidth() / 2), iArr[1] + this.dbJ.getWidth());
        this.dbK.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.dce = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dce) {
                this.dbs.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                k alv = this.cIp.alv();
                if (alv != null && alv.aRf() != null) {
                    alv.aRf().setUser_level(i);
                }
                this.dco.setText(this.acd.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dbs.setText(this.dbR);
                this.dco.setText(this.acd.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dbt.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, kc(this.mLevel)));
            if (this.dce) {
                if (f >= 1.0f) {
                    a(this.cIp.getBaseFragmentActivity(), this.dbt, this.dcf, f);
                } else {
                    b(this.cIp.getBaseFragmentActivity(), this.dbt, this.dcf, f);
                }
            } else {
                a(this.cIp.getBaseFragmentActivity(), this.dbt, this.dcf, f);
            }
            this.dcf = f;
        }
    }

    private int[] kc(int i) {
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
    protected void ann() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ano() {
        if (this.mMemberType != 0) {
            aj.c(this.dbJ, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dbJ, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cMw);
    }

    public FrsEntranceStoryListWrapperView anp() {
        return this.cMt;
    }
}
