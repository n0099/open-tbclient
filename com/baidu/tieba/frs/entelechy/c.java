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
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.view.f;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c extends a {
    private String aKO;
    private RelativeLayout bPW;
    private TextView dGA;
    private ImageView dGB;
    private String dGC;
    private FrsHeaderPraiseView dGE;
    private String dGF;
    private TextView dGz;
    private int mTabId;
    private int[] dGG = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dGH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dTZ != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cId.setVisibility(8);
                } else {
                    c.this.cId.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dGI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.dGC)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.aa("obj_param1", c.this.mTabId == 201 ? "2" : "1").aa("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                av.Da().c(c.this.aQs, new String[]{c.this.dGC});
            }
        }
    };
    private ArrayList<TbImageView> dGD = new ArrayList<>();

    public c(i iVar, String str, String str2, int i) {
        this.bPW = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dCS = iVar;
        this.aQs = iVar.getPageContext();
        this.dTQ = l.s(iVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dTR = l.s(iVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dTS = l.s(iVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = awa();
        this.bPW = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dUl = LayoutInflater.from(iVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dUo = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dGz = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dGA = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dTX = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dUT = (TextView) this.mParent.findViewById(d.g.level);
        this.dTV = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dTW = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dTW.setContentDescription(iVar.getResources().getString(d.j.sign));
        this.dTY = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dTT = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dTU = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dUq = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dAP = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dUq.setPageId(this.dCS.getUniqueId());
        this.dUq.setContentDescription(iVar.getResources().getString(d.j.bar_header));
        this.dUq.setGifIconSupport(false);
        this.dUq.setDrawerType(0);
        this.dTZ = LayoutInflater.from(this.dCS.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        avT();
        avX();
        this.dUa = (ViewGroup) this.dTZ.findViewById(d.g.frs_header_games);
        this.dUb = (TextView) this.dTZ.findViewById(d.g.top_item_title);
        this.dUi = (LinearLayout) this.dTZ.findViewById(d.g.frs_present_root);
        this.dUV = (TextView) this.bPW.findViewById(d.g.new_chapter_btn);
        this.cId = this.dTZ.findViewById(d.g.divider_bottom);
        this.dUu = new f(this.aQs, this.dTZ);
        this.dUt = new com.baidu.tieba.frs.e.b(this.aQs);
        this.dUe = (ViewGroup) this.dTZ.findViewById(d.g.frs_headline);
        this.dUf = (TextView) this.dUe.findViewById(d.g.headline_title);
        this.dUg = (TextView) this.dUe.findViewById(d.g.headline_text);
        this.dUh = (TbImageView) this.dUe.findViewById(d.g.headline_image);
        this.dUh.setPageId(this.dCS.getUniqueId());
        this.dUe.setVisibility(8);
        this.dUS = this.mParent.findViewById(d.g.level_container);
        this.dUR = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dUQ = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dUU = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dGB = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.aQs.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.oJ()) {
                    l.showToast(c.this.aQs.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.dGF) && !StringUtils.isNull(c.this.mForumId)) {
                    av.Da().c(c.this.aQs, new String[]{c.this.dGF + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        avY();
        this.dCS.registerListener(this.dGH);
    }

    private void avX() {
        this.dGE = (FrsHeaderPraiseView) this.dTZ.findViewById(d.g.frs_praise_layout);
    }

    private void avY() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.dUv = (ai) runTask.getData();
            this.dUv.a(this.aQs, this.mParent, 1, false, this.dCS.getUniqueId());
            this.dUv.hide();
        }
    }

    private void avZ() {
        final com.baidu.tbadk.core.data.l buf = this.dSD.buf();
        if (buf != null && this.dSD.aYJ() != null) {
            final String id = this.dSD.aYJ().getId();
            final String name = this.dSD.aYJ().getName();
            if (this.dUO.add(buf.xj())) {
                a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", buf.xj(), id, name, null);
                b.cc("obj_url", buf.getUrl());
                b.save();
            }
            this.dUe.setVisibility(0);
            this.dUf.setText(buf.getText());
            this.dUg.setText(buf.getTitle());
            this.dUh.startLoad(buf.xi(), 10, false);
            this.dUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0155a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", buf.xj(), id, name, null);
                    b2.cc("obj_url", buf.getUrl());
                    b2.save();
                    av.Da().c(c.this.dCS.getPageContext(), new String[]{buf.getUrl()});
                }
            });
        }
    }

    protected View awa() {
        return LayoutInflater.from(this.dCS.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void nh(int i) {
        if (i <= 0 || i > 5) {
            this.dGB.setVisibility(8);
            this.dAP.setMaxWidth(l.s(this.aQs.getPageActivity(), d.e.ds370));
            return;
        }
        this.dGB.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.dGG[i - 1]);
        this.dGB.setImageDrawable(drawable);
        this.dAP.setMaxWidth((l.s(this.aQs.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dGB.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void l(View.OnClickListener onClickListener) {
        this.dUq.setOnClickListener(onClickListener);
        this.dAP.setOnClickListener(onClickListener);
        this.dTW.setOnClickListener(onClickListener);
        this.dTV.setOnClickListener(onClickListener);
        this.dUS.setOnClickListener(onClickListener);
        if (this.dUa != null) {
            this.dUa.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aQs.getLayoutMode().aN(i == 1);
        this.aQs.getLayoutMode().aM(this.mParent);
        this.aQs.getLayoutMode().aM(this.dUl);
        this.aQs.getLayoutMode().aM(this.dTZ);
        if (this.dUI) {
            oe(1);
        } else {
            oe(0);
        }
        this.dUq.invalidate();
        aj.t(this.bPW, d.C0108d.cp_bg_line_d);
        aj.t(this.cId, d.C0108d.cp_bg_line_e);
        aj.r(this.dUT, d.C0108d.cp_cont_j);
        aj.r(this.dTX, d.C0108d.cp_cont_j);
        aj.r(this.dGz, d.C0108d.cp_cont_j);
        aj.r(this.dTT, d.C0108d.cp_cont_j);
        aj.r(this.dGA, d.C0108d.cp_cont_j);
        aj.r(this.dTU, d.C0108d.cp_cont_j);
        this.dUq.setBorderWidth(l.s(this.aQs.getPageActivity(), d.e.tbds1));
        this.dUq.setBorderColor(aj.getColor(d.C0108d.black_alpha15));
        awe();
        if (this.dUa != null) {
            aj.s(this.dUa, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dUo, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dUo, d.f.icon_sml_speed_gray);
        }
        if (this.dUu != null) {
            this.dUu.changeSkinType(i);
        }
        if (this.dUv != null) {
            this.dUv.changeSkinType(i);
        }
        if (this.dUr != null) {
            this.dUr.gz(i);
        }
        Iterator<TbImageView> it = this.dGD.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        avU();
        aj.s(this.dUe, d.f.home_thread_card_item_bg);
        aj.r(this.dAP, d.C0108d.cp_cont_b);
        if (this.dGx != null) {
            com.baidu.tbadk.n.a.a(this.dCS.getPageContext(), this.dGx);
        }
        if (this.dGE.getVisibility() == 0) {
            this.dGE.changeSkinType(i);
        }
        aj.s(this.dUV, d.f.btn_round_cont_d);
        aj.r(this.dUV, d.C0108d.btn_cont_j_alpha_20_selector);
        if (this.dUd != null) {
            aj.t(this.dUd, d.C0108d.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dUA = forumData.getPost_num();
            this.dUx = forumData.getTag_color();
            this.aKO = forumData.getImage_url();
            this.dUw = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dUB = forumData.getSignData().count_sign_num;
                this.dUC = forumData.getSignData().miss_sign_num;
            }
            this.dUD = forumData.getCurScore();
            this.dSf = forumData.getLevelupScore();
            this.dUs = forumData.getBadgeData();
            this.dUj = forumData.getTopCode();
            this.dUk = forumData.getNewsInfo();
            this.dUy = forumData.getAccelerateContent();
            this.dSD = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dUz = new bd();
            awb();
            awf();
            avZ();
            this.dGE.setVisibility(8);
            if (lVar != null && lVar.btA() != null) {
                nh(lVar.btA().grade.intValue());
                this.dGF = lVar.btA().url;
            }
            if (lVar != null && lVar.gWS != null) {
                FrsTabInfo frsTabInfo = lVar.gWS;
                this.dGC = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dUV.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dUV.setText(frsTabInfo.tab_name);
                }
                this.dUV.setOnClickListener(this.dGI);
                return;
            }
            this.dUV.setVisibility(8);
        }
    }

    protected void awb() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aKO);
        this.dUz.ze().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void awc() {
        int s = l.s(this.aQs.getPageActivity(), d.e.tbds32);
        if (this.dUC > 0) {
            aj.e(this.dTW, d.C0108d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, s, s);
            int s2 = l.s(this.aQs.getPageActivity(), d.e.tbds24);
            this.dTW.setPadding(s2, 0, s2, 0);
            this.dTW.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dTW.setText(String.format(this.aQs.getString(d.j.miss_sign_days), Integer.valueOf(this.dUC)));
            aj.s(this.dTW, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, s, s);
            this.dTW.setCompoundDrawables(drawable2, null, null, null);
            aj.e(this.dTW, d.C0108d.cp_cont_e, 1);
            this.dTW.setText(this.aQs.getString(d.j.signed));
            this.dTW.setPadding(0, 0, 0, 0);
            this.dTW.setBackgroundDrawable(null);
        }
        this.dTW.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dTW.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void awd() {
        int s = l.s(this.aQs.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, s, s);
        this.dTW.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dTW.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dTW, d.C0108d.cp_cont_i, 1);
        aj.s(this.dTW, d.f.frs_attention_btn_bg_selector);
    }

    protected void awe() {
        int s = l.s(this.aQs.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, s, s);
        this.dTV.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dTV.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dTV, d.C0108d.cp_cont_g, 1);
        aj.s(this.dTV, d.f.frs_attention_btn_bg_selector);
    }

    protected void awf() {
        List<g> list = null;
        if (this.dTT != null) {
            this.dTT.setText(am.F(this.mMemberNum));
        }
        if (this.dTU != null) {
            this.dTU.setText(am.F(this.dUA));
        }
        if (this.dUs != null && this.dUs.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aQs.getString(d.j.forum));
            }
            if (this.dAP != null) {
                this.dAP.setText(this.mForumName + this.aQs.getString(d.j.forum));
            }
        }
        if (this.dUa != null && this.dUb != null) {
            if (this.dSD != null && this.dSD.btM()) {
                if (m.dP(this.dSD.btP()) == 1 && !n.aTH) {
                    this.dUa.setVisibility(8);
                } else {
                    this.dUa.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dSD.getGameName()) && !TextUtils.isEmpty(this.dSD.getGameName().trim())) {
                        this.dUb.setText(UtilHelper.getFixedText(this.dSD.getGameName(), 10));
                        String sL = com.baidu.tieba.tbadkCore.util.b.sL(this.dSD.btP());
                        if (!StringUtils.isNull(sL)) {
                            TiebaStatic.eventStat(this.aQs.getPageActivity(), "game_show", "show", 1, "dev_id", sL, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dUb.setText(this.aQs.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dUa.setVisibility(8);
            }
        }
        this.dUi.setVisibility(8);
        this.dUu.a(null, null);
        this.dUc = this.dUa.findViewById(d.g.top_item_divider);
        awg();
        if (this.dSD != null && !v.E(this.dSD.btN())) {
            list = this.dSD.btN();
            bx(list);
        }
        bj(list);
    }

    protected void awg() {
        this.dUq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dUq.startLoad(this.aKO, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void p(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dUP);
            if (this.QK == null) {
                this.QK = new PopupWindow(this.aQs.getPageActivity());
                this.QK.setContentView(this.dUl);
                this.QK.setBackgroundDrawable(new BitmapDrawable());
                this.QK.setOutsideTouchable(true);
                this.QK.setFocusable(true);
                this.QK.setWidth(this.aQs.getResources().getDimensionPixelSize(d.e.ds228));
                this.QK.setHeight(this.aQs.getResources().getDimensionPixelSize(d.e.ds100));
                this.dUm = (TextView) this.dUl.findViewById(d.g.cur_experience);
                this.dUn = (TextView) this.dUl.findViewById(d.g.levelup_experience);
                a(this.dUm, this.dUn);
            }
            if (this.QK.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.QK, this.aQs.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dUm, this.dUn);
            if (iArr[1] - this.QK.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.QK, this.aQs.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.QK, this.mParent, 0, iArr[0], iArr[1] - this.QK.getHeight());
            this.QK.update();
            this.mHandler.postDelayed(this.dUP, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aQs.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.e((TextView) inflate.findViewById(d.g.experience_txt), d.C0108d.cp_cont_b, 1);
            aj.e(textView, d.C0108d.cp_cont_b, 1);
            aj.e(textView2, d.C0108d.cp_cont_b, 1);
            aj.e(textView3, d.C0108d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQs.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dUy) && !TextUtils.isEmpty(this.dUy.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dUy);
            } else {
                textView3.setVisibility(8);
            }
            aVar.fc(d.C0108d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aQs);
            aVar.AB();
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
                if (c.this.aQs != null && c.this.aQs.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aQs.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void awh() {
        View contentView;
        if (this.dUp == null) {
            this.dUp = new PopupWindow(this.aQs.getPageActivity());
            contentView = LayoutInflater.from(this.aQs.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dUp.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aQs != null && c.this.aQs.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dUp, c.this.aQs.getPageActivity());
                        c.this.dCS.dBs = false;
                        com.baidu.tbadk.browser.a.a(c.this.aQs.getPageActivity(), c.this.aQs.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dUp.setWidth(this.aQs.getResources().getDimensionPixelSize(d.e.ds300));
            this.dUp.setHeight(this.aQs.getResources().getDimensionPixelSize(d.e.ds88));
            this.dUp.setBackgroundDrawable(new BitmapDrawable());
            this.dUp.setOutsideTouchable(true);
            this.dUp.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.b(c.this.dUp);
                        c.this.dCS.dBs = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dUp.getContentView();
        }
        this.aQs.getLayoutMode().aM(contentView);
        int[] iArr = new int[2];
        this.dUo.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dUp, this.mParent, 0, (iArr[0] - (this.dUp.getWidth() / 2)) + (this.dUo.getWidth() / 2), iArr[1] + this.dUo.getWidth());
        this.dUp.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.dUJ = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dUJ) {
                this.dTX.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l auv = this.dCS.auv();
                if (auv != null && auv.aYJ() != null) {
                    auv.aYJ().setUser_level(i);
                }
                this.dUT.setText(this.aQs.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dTX.setText(this.dUw);
                this.dUT.setText(this.aQs.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dTY.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ni(this.mLevel)));
            if (this.dUJ) {
                if (f >= 1.0f) {
                    a(this.dCS.getBaseFragmentActivity(), this.dTY, this.dUK, f);
                } else {
                    b(this.dCS.getBaseFragmentActivity(), this.dTY, this.dUK, f);
                }
            } else {
                a(this.dCS.getBaseFragmentActivity(), this.dTY, this.dUK, f);
            }
            this.dUK = f;
        }
    }

    private int[] ni(int i) {
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
    protected void awi() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void awj() {
        if (this.mMemberType != 0) {
            aj.c(this.dUo, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dUo, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dGH);
    }
}
