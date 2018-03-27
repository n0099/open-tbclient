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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.g;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c extends a {
    private String aLY;
    private RelativeLayout bRU;
    private TextView dJA;
    private ImageView dJB;
    private String dJC;
    private FrsHeaderPraiseView dJE;
    private String dJF;
    private TextView dJz;
    private int mTabId;
    private boolean aQq = false;
    private int[] dJG = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dJH = new CustomMessageListener(2003018) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dXI != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cLS.setVisibility(8);
                } else {
                    c.this.cLS.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dJI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.dJC)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ab("obj_param1", c.this.mTabId == 201 ? "2" : "1").ab("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                aw.Du().c(c.this.aRI, new String[]{c.this.dJC});
            }
        }
    };
    private ArrayList<TbImageView> dJD = new ArrayList<>();

    public c(i iVar, String str, String str2, int i) {
        this.bRU = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dFH = iVar;
        this.aRI = iVar.getPageContext();
        this.dXz = l.t(iVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dXA = l.t(iVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dXB = l.t(iVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = axa();
        this.bRU = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dXU = LayoutInflater.from(iVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dXX = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dJz = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dJA = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dXG = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dYC = (TextView) this.mParent.findViewById(d.g.level);
        this.dXE = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dXF = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dXF.setContentDescription(iVar.getResources().getString(d.j.sign));
        this.dXH = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dXC = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dXD = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dXZ = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dDz = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dXZ.setPageId(this.dFH.getUniqueId());
        this.dXZ.setContentDescription(iVar.getResources().getString(d.j.bar_header));
        this.dXZ.setGifIconSupport(false);
        this.dXZ.setDrawerType(0);
        this.dXI = LayoutInflater.from(this.dFH.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        awT();
        awX();
        this.dXJ = (ViewGroup) this.dXI.findViewById(d.g.frs_header_games);
        this.dXK = (TextView) this.dXI.findViewById(d.g.top_item_title);
        this.dXR = (LinearLayout) this.dXI.findViewById(d.g.frs_present_root);
        this.dYE = (TextView) this.bRU.findViewById(d.g.new_chapter_btn);
        this.cLS = this.dXI.findViewById(d.g.divider_bottom);
        this.dYd = new g(this.aRI, this.dXI);
        this.dYc = new com.baidu.tieba.frs.f.b(this.aRI);
        this.dXN = (ViewGroup) this.dXI.findViewById(d.g.frs_headline);
        this.dXO = (TextView) this.dXN.findViewById(d.g.headline_title);
        this.dXP = (TextView) this.dXN.findViewById(d.g.headline_text);
        this.dXQ = (TbImageView) this.dXN.findViewById(d.g.headline_image);
        this.dXQ.setPageId(this.dFH.getUniqueId());
        this.dXN.setVisibility(8);
        this.dYB = this.mParent.findViewById(d.g.level_container);
        this.dYA = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dYz = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dYD = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dJB = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.aRI.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.oJ()) {
                    l.showToast(c.this.aRI.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.dJF) && !StringUtils.isNull(c.this.mForumId)) {
                    aw.Du().c(c.this.aRI, new String[]{c.this.dJF + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        awY();
        this.dFH.registerListener(this.dJH);
        this.dJx = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dJx.setContext(this.aRI);
    }

    private void awX() {
        this.dJE = (FrsHeaderPraiseView) this.dXI.findViewById(d.g.frs_praise_layout);
    }

    private void awY() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.dYe = (ai) runTask.getData();
            this.dYe.a(this.aRI, this.mParent, 1, false, this.dFH.getUniqueId());
            this.dYe.hide();
        }
    }

    private void awZ() {
        final com.baidu.tbadk.core.data.l bvw = this.dVO.bvw();
        if (bvw != null && this.dVO.bas() != null) {
            final String id = this.dVO.bas().getId();
            final String name = this.dVO.bas().getName();
            if (this.dYx.add(bvw.xP())) {
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bvw.xP(), id, name, null);
                b.ce("obj_url", bvw.getUrl());
                b.save();
            }
            this.dXN.setVisibility(0);
            this.dXO.setText(bvw.getText());
            this.dXP.setText(bvw.getTitle());
            this.dXQ.startLoad(bvw.xO(), 10, false);
            this.dXN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0236a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bvw.xP(), id, name, null);
                    b2.ce("obj_url", bvw.getUrl());
                    b2.save();
                    aw.Du().c(c.this.dFH.getPageContext(), new String[]{bvw.getUrl()});
                }
            });
        }
    }

    protected View axa() {
        return LayoutInflater.from(this.dFH.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void nf(int i) {
        if (i <= 0 || i > 5) {
            this.dJB.setVisibility(8);
            this.dDz.setMaxWidth(l.t(this.aRI.getPageActivity(), d.e.ds370));
            return;
        }
        this.dJB.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.dJG[i - 1]);
        this.dJB.setImageDrawable(drawable);
        this.dDz.setMaxWidth((l.t(this.aRI.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dJB.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void l(View.OnClickListener onClickListener) {
        this.dXZ.setOnClickListener(onClickListener);
        this.dDz.setOnClickListener(onClickListener);
        this.dXF.setOnClickListener(onClickListener);
        this.dXE.setOnClickListener(onClickListener);
        this.dYB.setOnClickListener(onClickListener);
        if (this.dXJ != null) {
            this.dXJ.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        boolean z = true;
        this.aRI.getLayoutMode().aQ(i == 1);
        this.aRI.getLayoutMode().aM(this.mParent);
        this.aRI.getLayoutMode().aM(this.dXU);
        this.aRI.getLayoutMode().aM(this.dXI);
        if (this.dYr) {
            oe(1);
        } else {
            oe(0);
        }
        this.dXZ.invalidate();
        aj.t(this.bRU, d.C0141d.cp_bg_line_d);
        aj.t(this.cLS, d.C0141d.cp_bg_line_e);
        aj.r(this.dYC, d.C0141d.cp_cont_j);
        aj.r(this.dXG, d.C0141d.cp_cont_j);
        aj.r(this.dJz, d.C0141d.cp_cont_j);
        aj.r(this.dXC, d.C0141d.cp_cont_j);
        aj.r(this.dJA, d.C0141d.cp_cont_j);
        aj.r(this.dXD, d.C0141d.cp_cont_j);
        this.dXZ.setBorderWidth(l.t(this.aRI.getPageActivity(), d.e.tbds1));
        this.dXZ.setBorderColor(aj.getColor(d.C0141d.black_alpha15));
        axe();
        if (this.dXJ != null) {
            aj.s(this.dXJ, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dXX, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dXX, d.f.icon_sml_speed_gray);
        }
        if (this.dYd != null) {
            this.dYd.changeSkinType(i);
        }
        if (this.dYe != null) {
            this.dYe.changeSkinType(i);
        }
        if (this.dYa != null) {
            this.dYa.gB(i);
        }
        Iterator<TbImageView> it = this.dJD.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        awU();
        aj.s(this.dXN, d.f.home_thread_card_item_bg);
        aj.r(this.dDz, d.C0141d.cp_cont_b);
        if (this.dJw != null) {
            com.baidu.tbadk.n.a.a(this.dFH.getPageContext(), this.dJw);
        }
        if (this.dJE.getVisibility() == 0) {
            this.dJE.changeSkinType(i);
        }
        aj.s(this.dYE, d.f.btn_round_cont_d);
        aj.r(this.dYE, d.C0141d.btn_cont_j_alpha_20_selector);
        if (this.dXM != null) {
            aj.t(this.dXM, d.C0141d.cp_bg_line_e);
        }
        if (this.dJx != null && this.dJx.getVisibility() == 0) {
            FrsStarRankAndTaskContainer frsStarRankAndTaskContainer = this.dJx;
            if (this.dVO == null || this.dVO.bvI() == null || this.dVO.bvI().getType() != 1) {
                z = false;
            }
            frsStarRankAndTaskContainer.gF(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, m mVar) {
        boolean z = true;
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dYj = forumData.getPost_num();
            this.dYg = forumData.getTag_color();
            this.aLY = forumData.getImage_url();
            this.dYf = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dYk = forumData.getSignData().count_sign_num;
                this.dYl = forumData.getSignData().miss_sign_num;
            }
            this.dYm = forumData.getCurScore();
            this.dVl = forumData.getLevelupScore();
            this.dYb = forumData.getBadgeData();
            this.dXS = forumData.getTopCode();
            this.dXT = forumData.getNewsInfo();
            this.dYh = forumData.getAccelerateContent();
            this.dVO = mVar;
            if (mVar.bvI() == null || mVar.bvI().getType() != 1) {
                z = false;
            }
            this.aQq = z;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dYi = new bd();
            axb();
            axf();
            awZ();
            this.dJE.setVisibility(8);
            if (mVar != null && mVar.buQ() != null) {
                nf(mVar.buQ().grade.intValue());
                this.dJF = mVar.buQ().url;
            }
            if (mVar != null && mVar.gZr != null) {
                FrsTabInfo frsTabInfo = mVar.gZr;
                this.dJC = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dYE.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dYE.setText(frsTabInfo.tab_name);
                }
                this.dYE.setOnClickListener(this.dJI);
            } else {
                this.dYE.setVisibility(8);
            }
            if (mVar != null && mVar.gZt != null) {
                this.dJx.a(mVar.gZt, this.aQq);
                this.dJx.setVisibility(0);
                this.dYD.setPadding(0, this.dYD.getPaddingTop(), 0, 0);
            } else {
                this.dJx.setVisibility(8);
            }
            axe();
        }
    }

    protected void axb() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aLY);
        this.dYi.zy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void axc() {
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        int t = l.t(this.aRI.getPageActivity(), d.e.tbds32);
        if (this.dYl > 0) {
            aj.e(this.dXF, d.C0141d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, t, t);
            int t2 = l.t(this.aRI.getPageActivity(), d.e.tbds24);
            this.dXF.setPadding(t2, 0, t2, 0);
            this.dXF.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dXF.setText(String.format(this.aRI.getString(d.j.miss_sign_days), Integer.valueOf(this.dYl)));
            aj.s(this.dXF, (z || !this.aQq) ? d.f.frs_attention_btn_bg_selector : d.f.frs_attention_btn_bg_gray_n);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, t, t);
            this.dXF.setCompoundDrawables(drawable2, null, null, null);
            aj.e(this.dXF, d.C0141d.cp_cont_e, 1);
            this.dXF.setText(this.aRI.getString(d.j.signed));
            this.dXF.setPadding(0, 0, 0, 0);
            this.dXF.setBackgroundDrawable(null);
        }
        this.dXF.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dXF.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void axd() {
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        int t = l.t(this.aRI.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, t, t);
        this.dXF.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dXF.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dXF, d.C0141d.cp_cont_i, 1);
        aj.s(this.dXF, (z || !this.aQq) ? d.f.frs_attention_btn_bg_selector : d.f.frs_attention_btn_bg_gray_n);
    }

    protected void axe() {
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        int t = l.t(this.aRI.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, t, t);
        this.dXE.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dXE.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dXE, d.C0141d.cp_cont_g, 1);
        aj.s(this.dXE, (z || !this.aQq) ? d.f.frs_attention_btn_bg_selector : d.f.frs_attention_btn_bg_gray_n);
    }

    protected void axf() {
        List<h> list = null;
        if (this.dXC != null) {
            this.dXC.setText(am.F(this.mMemberNum));
        }
        if (this.dXD != null) {
            this.dXD.setText(am.F(this.dYj));
        }
        if (this.dYb != null && this.dYb.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aRI.getString(d.j.forum));
            }
            if (this.dDz != null) {
                this.dDz.setText(this.mForumName + this.aRI.getString(d.j.forum));
            }
        }
        if (this.dXJ != null && this.dXK != null) {
            if (this.dVO != null && this.dVO.bvd()) {
                if (com.baidu.tbadk.core.util.m.eb(this.dVO.bvg()) == 1 && !n.aVc) {
                    this.dXJ.setVisibility(8);
                } else {
                    this.dXJ.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dVO.getGameName()) && !TextUtils.isEmpty(this.dVO.getGameName().trim())) {
                        this.dXK.setText(UtilHelper.getFixedText(this.dVO.getGameName(), 10));
                        String sT = com.baidu.tieba.tbadkCore.util.b.sT(this.dVO.bvg());
                        if (!StringUtils.isNull(sT)) {
                            TiebaStatic.eventStat(this.aRI.getPageActivity(), "game_show", "show", 1, "dev_id", sT, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dXK.setText(this.aRI.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dXJ.setVisibility(8);
            }
        }
        this.dXR.setVisibility(8);
        this.dYd.a(null, null);
        if (this.dXJ != null) {
            this.dXL = this.dXJ.findViewById(d.g.top_item_divider);
        }
        axg();
        if (this.dVO != null && !v.E(this.dVO.bve())) {
            list = this.dVO.bve();
            bz(list);
        }
        bl(list);
    }

    protected void axg() {
        this.dXZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.dVO != null && this.dVO.bvI() != null) {
            this.dXZ.changeGrayScaleMode(this.dVO.bvI().getType() == 1);
        }
        this.dXZ.startLoad(this.aLY, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void p(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dYy);
            if (this.QE == null) {
                this.QE = new PopupWindow(this.aRI.getPageActivity());
                this.QE.setContentView(this.dXU);
                this.QE.setBackgroundDrawable(new BitmapDrawable());
                this.QE.setOutsideTouchable(true);
                this.QE.setFocusable(true);
                this.QE.setWidth(this.aRI.getResources().getDimensionPixelSize(d.e.ds228));
                this.QE.setHeight(this.aRI.getResources().getDimensionPixelSize(d.e.ds100));
                this.dXV = (TextView) this.dXU.findViewById(d.g.cur_experience);
                this.dXW = (TextView) this.dXU.findViewById(d.g.levelup_experience);
                a(this.dXV, this.dXW);
            }
            if (this.QE.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.QE, this.aRI.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dXV, this.dXW);
            if (iArr[1] - this.QE.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.QE, this.aRI.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.QE, this.mParent, 0, iArr[0], iArr[1] - this.QE.getHeight());
            this.QE.update();
            this.mHandler.postDelayed(this.dYy, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aRI.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.e((TextView) inflate.findViewById(d.g.experience_txt), d.C0141d.cp_cont_b, 1);
            aj.e(textView, d.C0141d.cp_cont_b, 1);
            aj.e(textView2, d.C0141d.cp_cont_b, 1);
            aj.e(textView3, d.C0141d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dYh) && !TextUtils.isEmpty(this.dYh.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dYh);
            } else {
                textView3.setVisibility(8);
            }
            aVar.fc(d.C0141d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aRI);
            aVar.AV();
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
                if (c.this.aRI != null && c.this.aRI.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aRI.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void axh() {
        View contentView;
        if (this.dXY == null) {
            this.dXY = new PopupWindow(this.aRI.getPageActivity());
            contentView = LayoutInflater.from(this.aRI.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dXY.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aRI != null && c.this.aRI.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dXY, c.this.aRI.getPageActivity());
                        c.this.dFH.dEc = false;
                        com.baidu.tbadk.browser.b.a(c.this.aRI.getPageActivity(), c.this.aRI.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dXY.setWidth(this.aRI.getResources().getDimensionPixelSize(d.e.ds300));
            this.dXY.setHeight(this.aRI.getResources().getDimensionPixelSize(d.e.ds88));
            this.dXY.setBackgroundDrawable(new BitmapDrawable());
            this.dXY.setOutsideTouchable(true);
            this.dXY.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.b(c.this.dXY);
                        c.this.dFH.dEc = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dXY.getContentView();
        }
        this.aRI.getLayoutMode().aM(contentView);
        int[] iArr = new int[2];
        this.dXX.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dXY, this.mParent, 0, (iArr[0] - (this.dXY.getWidth() / 2)) + (this.dXX.getWidth() / 2), iArr[1] + this.dXX.getWidth());
        this.dXY.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.dYs = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dYs) {
                this.dXG.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                m avl = this.dFH.avl();
                if (avl != null && avl.bas() != null) {
                    avl.bas().setUser_level(i);
                }
                this.dYC.setText(this.aRI.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dXG.setText(this.dYf);
                this.dYC.setText(this.aRI.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dXH.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ng(this.mLevel)));
            if (this.dYs) {
                if (f >= 1.0f) {
                    a(this.dFH.getBaseFragmentActivity(), this.dXH, this.dYt, f);
                } else {
                    b(this.dFH.getBaseFragmentActivity(), this.dXH, this.dYt, f);
                }
            } else {
                a(this.dFH.getBaseFragmentActivity(), this.dXH, this.dYt, f);
            }
            this.dYt = f;
        }
    }

    private int[] ng(int i) {
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
    protected void axi() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void axj() {
        if (this.mMemberType != 0) {
            aj.c(this.dXX, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dXX, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dJH);
    }
}
