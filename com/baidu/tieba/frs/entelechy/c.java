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
    private String aKL;
    private RelativeLayout bPO;
    private TextView dGe;
    private TextView dGf;
    private ImageView dGg;
    private String dGh;
    private FrsHeaderPraiseView dGj;
    private String dGk;
    private int mTabId;
    private int[] dGl = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dGm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dTE != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cHQ.setVisibility(8);
                } else {
                    c.this.cHQ.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dGn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.dGh)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ab("obj_param1", c.this.mTabId == 201 ? "2" : "1").ab("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                av.CZ().c(c.this.aQp, new String[]{c.this.dGh});
            }
        }
    };
    private ArrayList<TbImageView> dGi = new ArrayList<>();

    public c(i iVar, String str, String str2, int i) {
        this.bPO = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dCx = iVar;
        this.aQp = iVar.getPageContext();
        this.dTv = l.s(iVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dTw = l.s(iVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dTx = l.s(iVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = avV();
        this.bPO = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dTQ = LayoutInflater.from(iVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dTT = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dGe = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dGf = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dTC = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dUy = (TextView) this.mParent.findViewById(d.g.level);
        this.dTA = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dTB = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dTB.setContentDescription(iVar.getResources().getString(d.j.sign));
        this.dTD = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dTy = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dTz = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dTV = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dAu = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dTV.setPageId(this.dCx.getUniqueId());
        this.dTV.setContentDescription(iVar.getResources().getString(d.j.bar_header));
        this.dTV.setGifIconSupport(false);
        this.dTV.setDrawerType(0);
        this.dTE = LayoutInflater.from(this.dCx.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        avO();
        avS();
        this.dTF = (ViewGroup) this.dTE.findViewById(d.g.frs_header_games);
        this.dTG = (TextView) this.dTE.findViewById(d.g.top_item_title);
        this.dTN = (LinearLayout) this.dTE.findViewById(d.g.frs_present_root);
        this.dUA = (TextView) this.bPO.findViewById(d.g.new_chapter_btn);
        this.cHQ = this.dTE.findViewById(d.g.divider_bottom);
        this.dTZ = new f(this.aQp, this.dTE);
        this.dTY = new com.baidu.tieba.frs.e.b(this.aQp);
        this.dTJ = (ViewGroup) this.dTE.findViewById(d.g.frs_headline);
        this.dTK = (TextView) this.dTJ.findViewById(d.g.headline_title);
        this.dTL = (TextView) this.dTJ.findViewById(d.g.headline_text);
        this.dTM = (TbImageView) this.dTJ.findViewById(d.g.headline_image);
        this.dTM.setPageId(this.dCx.getUniqueId());
        this.dTJ.setVisibility(8);
        this.dUx = this.mParent.findViewById(d.g.level_container);
        this.dUw = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dUv = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dUz = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dGg = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.aQp.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.oI()) {
                    l.showToast(c.this.aQp.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.dGk) && !StringUtils.isNull(c.this.mForumId)) {
                    av.CZ().c(c.this.aQp, new String[]{c.this.dGk + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        avT();
        this.dCx.registerListener(this.dGm);
    }

    private void avS() {
        this.dGj = (FrsHeaderPraiseView) this.dTE.findViewById(d.g.frs_praise_layout);
    }

    private void avT() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.dUa = (ai) runTask.getData();
            this.dUa.a(this.aQp, this.mParent, 1, false, this.dCx.getUniqueId());
            this.dUa.hide();
        }
    }

    private void avU() {
        final com.baidu.tbadk.core.data.l bud = this.dSi.bud();
        if (bud != null && this.dSi.aYE() != null) {
            final String id = this.dSi.aYE().getId();
            final String name = this.dSi.aYE().getName();
            if (this.dUt.add(bud.xi())) {
                a.C0154a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bud.xi(), id, name, null);
                b.cd("obj_url", bud.getUrl());
                b.save();
            }
            this.dTJ.setVisibility(0);
            this.dTK.setText(bud.getText());
            this.dTL.setText(bud.getTitle());
            this.dTM.startLoad(bud.xh(), 10, false);
            this.dTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0154a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bud.xi(), id, name, null);
                    b2.cd("obj_url", bud.getUrl());
                    b2.save();
                    av.CZ().c(c.this.dCx.getPageContext(), new String[]{bud.getUrl()});
                }
            });
        }
    }

    protected View avV() {
        return LayoutInflater.from(this.dCx.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void nh(int i) {
        if (i <= 0 || i > 5) {
            this.dGg.setVisibility(8);
            this.dAu.setMaxWidth(l.s(this.aQp.getPageActivity(), d.e.ds370));
            return;
        }
        this.dGg.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.dGl[i - 1]);
        this.dGg.setImageDrawable(drawable);
        this.dAu.setMaxWidth((l.s(this.aQp.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dGg.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void l(View.OnClickListener onClickListener) {
        this.dTV.setOnClickListener(onClickListener);
        this.dAu.setOnClickListener(onClickListener);
        this.dTB.setOnClickListener(onClickListener);
        this.dTA.setOnClickListener(onClickListener);
        this.dUx.setOnClickListener(onClickListener);
        if (this.dTF != null) {
            this.dTF.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aQp.getLayoutMode().aM(i == 1);
        this.aQp.getLayoutMode().aM(this.mParent);
        this.aQp.getLayoutMode().aM(this.dTQ);
        this.aQp.getLayoutMode().aM(this.dTE);
        if (this.dUn) {
            oe(1);
        } else {
            oe(0);
        }
        this.dTV.invalidate();
        aj.t(this.bPO, d.C0107d.cp_bg_line_d);
        aj.t(this.cHQ, d.C0107d.cp_bg_line_e);
        aj.r(this.dUy, d.C0107d.cp_cont_j);
        aj.r(this.dTC, d.C0107d.cp_cont_j);
        aj.r(this.dGe, d.C0107d.cp_cont_j);
        aj.r(this.dTy, d.C0107d.cp_cont_j);
        aj.r(this.dGf, d.C0107d.cp_cont_j);
        aj.r(this.dTz, d.C0107d.cp_cont_j);
        this.dTV.setBorderWidth(l.s(this.aQp.getPageActivity(), d.e.tbds1));
        this.dTV.setBorderColor(aj.getColor(d.C0107d.black_alpha15));
        avZ();
        if (this.dTF != null) {
            aj.s(this.dTF, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dTT, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dTT, d.f.icon_sml_speed_gray);
        }
        if (this.dTZ != null) {
            this.dTZ.changeSkinType(i);
        }
        if (this.dUa != null) {
            this.dUa.changeSkinType(i);
        }
        if (this.dTW != null) {
            this.dTW.gz(i);
        }
        Iterator<TbImageView> it = this.dGi.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        avP();
        aj.s(this.dTJ, d.f.home_thread_card_item_bg);
        aj.r(this.dAu, d.C0107d.cp_cont_b);
        if (this.dGc != null) {
            com.baidu.tbadk.n.a.a(this.dCx.getPageContext(), this.dGc);
        }
        if (this.dGj.getVisibility() == 0) {
            this.dGj.changeSkinType(i);
        }
        aj.s(this.dUA, d.f.btn_round_cont_d);
        aj.r(this.dUA, d.C0107d.btn_cont_j_alpha_20_selector);
        if (this.dTI != null) {
            aj.t(this.dTI, d.C0107d.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dUf = forumData.getPost_num();
            this.dUc = forumData.getTag_color();
            this.aKL = forumData.getImage_url();
            this.dUb = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dUg = forumData.getSignData().count_sign_num;
                this.dUh = forumData.getSignData().miss_sign_num;
            }
            this.dUi = forumData.getCurScore();
            this.dRK = forumData.getLevelupScore();
            this.dTX = forumData.getBadgeData();
            this.dTO = forumData.getTopCode();
            this.dTP = forumData.getNewsInfo();
            this.dUd = forumData.getAccelerateContent();
            this.dSi = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dUe = new bd();
            avW();
            awa();
            avU();
            this.dGj.setVisibility(8);
            if (lVar != null && lVar.bty() != null) {
                nh(lVar.bty().grade.intValue());
                this.dGk = lVar.bty().url;
            }
            if (lVar != null && lVar.gWy != null) {
                FrsTabInfo frsTabInfo = lVar.gWy;
                this.dGh = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dUA.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dUA.setText(frsTabInfo.tab_name);
                }
                this.dUA.setOnClickListener(this.dGn);
                return;
            }
            this.dUA.setVisibility(8);
        }
    }

    protected void avW() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aKL);
        this.dUe.zd().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void avX() {
        int s = l.s(this.aQp.getPageActivity(), d.e.tbds32);
        if (this.dUh > 0) {
            aj.e(this.dTB, d.C0107d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, s, s);
            int s2 = l.s(this.aQp.getPageActivity(), d.e.tbds24);
            this.dTB.setPadding(s2, 0, s2, 0);
            this.dTB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dTB.setText(String.format(this.aQp.getString(d.j.miss_sign_days), Integer.valueOf(this.dUh)));
            aj.s(this.dTB, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, s, s);
            this.dTB.setCompoundDrawables(drawable2, null, null, null);
            aj.e(this.dTB, d.C0107d.cp_cont_e, 1);
            this.dTB.setText(this.aQp.getString(d.j.signed));
            this.dTB.setPadding(0, 0, 0, 0);
            this.dTB.setBackgroundDrawable(null);
        }
        this.dTB.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dTB.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void avY() {
        int s = l.s(this.aQp.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, s, s);
        this.dTB.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dTB.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dTB, d.C0107d.cp_cont_i, 1);
        aj.s(this.dTB, d.f.frs_attention_btn_bg_selector);
    }

    protected void avZ() {
        int s = l.s(this.aQp.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, s, s);
        this.dTA.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dTA.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dTA, d.C0107d.cp_cont_g, 1);
        aj.s(this.dTA, d.f.frs_attention_btn_bg_selector);
    }

    protected void awa() {
        List<g> list = null;
        if (this.dTy != null) {
            this.dTy.setText(am.F(this.mMemberNum));
        }
        if (this.dTz != null) {
            this.dTz.setText(am.F(this.dUf));
        }
        if (this.dTX != null && this.dTX.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aQp.getString(d.j.forum));
            }
            if (this.dAu != null) {
                this.dAu.setText(this.mForumName + this.aQp.getString(d.j.forum));
            }
        }
        if (this.dTF != null && this.dTG != null) {
            if (this.dSi != null && this.dSi.btK()) {
                if (m.dK(this.dSi.btN()) == 1 && !n.aTE) {
                    this.dTF.setVisibility(8);
                } else {
                    this.dTF.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dSi.getGameName()) && !TextUtils.isEmpty(this.dSi.getGameName().trim())) {
                        this.dTG.setText(UtilHelper.getFixedText(this.dSi.getGameName(), 10));
                        String sE = com.baidu.tieba.tbadkCore.util.b.sE(this.dSi.btN());
                        if (!StringUtils.isNull(sE)) {
                            TiebaStatic.eventStat(this.aQp.getPageActivity(), "game_show", "show", 1, "dev_id", sE, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dTG.setText(this.aQp.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dTF.setVisibility(8);
            }
        }
        this.dTN.setVisibility(8);
        this.dTZ.a(null, null);
        this.dTH = this.dTF.findViewById(d.g.top_item_divider);
        awb();
        if (this.dSi != null && !v.E(this.dSi.btL())) {
            list = this.dSi.btL();
            bx(list);
        }
        bj(list);
    }

    protected void awb() {
        this.dTV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dTV.startLoad(this.aKL, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void p(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dUu);
            if (this.QK == null) {
                this.QK = new PopupWindow(this.aQp.getPageActivity());
                this.QK.setContentView(this.dTQ);
                this.QK.setBackgroundDrawable(new BitmapDrawable());
                this.QK.setOutsideTouchable(true);
                this.QK.setFocusable(true);
                this.QK.setWidth(this.aQp.getResources().getDimensionPixelSize(d.e.ds228));
                this.QK.setHeight(this.aQp.getResources().getDimensionPixelSize(d.e.ds100));
                this.dTR = (TextView) this.dTQ.findViewById(d.g.cur_experience);
                this.dTS = (TextView) this.dTQ.findViewById(d.g.levelup_experience);
                a(this.dTR, this.dTS);
            }
            if (this.QK.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.QK, this.aQp.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dTR, this.dTS);
            if (iArr[1] - this.QK.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.QK, this.aQp.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.QK, this.mParent, 0, iArr[0], iArr[1] - this.QK.getHeight());
            this.QK.update();
            this.mHandler.postDelayed(this.dUu, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aQp.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.e((TextView) inflate.findViewById(d.g.experience_txt), d.C0107d.cp_cont_b, 1);
            aj.e(textView, d.C0107d.cp_cont_b, 1);
            aj.e(textView2, d.C0107d.cp_cont_b, 1);
            aj.e(textView3, d.C0107d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQp.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dUd) && !TextUtils.isEmpty(this.dUd.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dUd);
            } else {
                textView3.setVisibility(8);
            }
            aVar.fc(d.C0107d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aQp);
            aVar.AA();
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
                if (c.this.aQp != null && c.this.aQp.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aQp.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void awc() {
        View contentView;
        if (this.dTU == null) {
            this.dTU = new PopupWindow(this.aQp.getPageActivity());
            contentView = LayoutInflater.from(this.aQp.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dTU.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aQp != null && c.this.aQp.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dTU, c.this.aQp.getPageActivity());
                        c.this.dCx.dAX = false;
                        com.baidu.tbadk.browser.a.a(c.this.aQp.getPageActivity(), c.this.aQp.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dTU.setWidth(this.aQp.getResources().getDimensionPixelSize(d.e.ds300));
            this.dTU.setHeight(this.aQp.getResources().getDimensionPixelSize(d.e.ds88));
            this.dTU.setBackgroundDrawable(new BitmapDrawable());
            this.dTU.setOutsideTouchable(true);
            this.dTU.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.b(c.this.dTU);
                        c.this.dCx.dAX = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dTU.getContentView();
        }
        this.aQp.getLayoutMode().aM(contentView);
        int[] iArr = new int[2];
        this.dTT.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dTU, this.mParent, 0, (iArr[0] - (this.dTU.getWidth() / 2)) + (this.dTT.getWidth() / 2), iArr[1] + this.dTT.getWidth());
        this.dTU.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.dUo = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dUo) {
                this.dTC.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l auq = this.dCx.auq();
                if (auq != null && auq.aYE() != null) {
                    auq.aYE().setUser_level(i);
                }
                this.dUy.setText(this.aQp.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dTC.setText(this.dUb);
                this.dUy.setText(this.aQp.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dTD.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ni(this.mLevel)));
            if (this.dUo) {
                if (f >= 1.0f) {
                    a(this.dCx.getBaseFragmentActivity(), this.dTD, this.dUp, f);
                } else {
                    b(this.dCx.getBaseFragmentActivity(), this.dTD, this.dUp, f);
                }
            } else {
                a(this.dCx.getBaseFragmentActivity(), this.dTD, this.dUp, f);
            }
            this.dUp = f;
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
    protected void awd() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void awe() {
        if (this.mMemberType != 0) {
            aj.c(this.dTT, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dTT, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dGm);
    }
}
