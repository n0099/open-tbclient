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
import com.baidu.tbadk.core.util.m;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c extends a {
    private String aMi;
    private RelativeLayout bSe;
    private TextView dJG;
    private TextView dJH;
    private ImageView dJI;
    private String dJJ;
    private FrsHeaderPraiseView dJL;
    private String dJM;
    private int mTabId;
    private int[] dJN = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dJO = new CustomMessageListener(2003018) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dXO != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cMb.setVisibility(8);
                } else {
                    c.this.cMb.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dJP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.dJJ)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ab("obj_param1", c.this.mTabId == 201 ? "2" : "1").ab("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                aw.Du().c(c.this.aRR, new String[]{c.this.dJJ});
            }
        }
    };
    private ArrayList<TbImageView> dJK = new ArrayList<>();

    public c(i iVar, String str, String str2, int i) {
        this.bSe = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dFP = iVar;
        this.aRR = iVar.getPageContext();
        this.dXF = l.t(iVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dXG = l.t(iVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dXH = l.t(iVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = awZ();
        this.bSe = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dYa = LayoutInflater.from(iVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dYd = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dJG = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dJH = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dXM = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dYI = (TextView) this.mParent.findViewById(d.g.level);
        this.dXK = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dXL = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dXL.setContentDescription(iVar.getResources().getString(d.j.sign));
        this.dXN = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dXI = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dXJ = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dYf = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dDI = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dYf.setPageId(this.dFP.getUniqueId());
        this.dYf.setContentDescription(iVar.getResources().getString(d.j.bar_header));
        this.dYf.setGifIconSupport(false);
        this.dYf.setDrawerType(0);
        this.dXO = LayoutInflater.from(this.dFP.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        awS();
        awW();
        this.dXP = (ViewGroup) this.dXO.findViewById(d.g.frs_header_games);
        this.dXQ = (TextView) this.dXO.findViewById(d.g.top_item_title);
        this.dXX = (LinearLayout) this.dXO.findViewById(d.g.frs_present_root);
        this.dYK = (TextView) this.bSe.findViewById(d.g.new_chapter_btn);
        this.cMb = this.dXO.findViewById(d.g.divider_bottom);
        this.dYj = new g(this.aRR, this.dXO);
        this.dYi = new com.baidu.tieba.frs.f.b(this.aRR);
        this.dXT = (ViewGroup) this.dXO.findViewById(d.g.frs_headline);
        this.dXU = (TextView) this.dXT.findViewById(d.g.headline_title);
        this.dXV = (TextView) this.dXT.findViewById(d.g.headline_text);
        this.dXW = (TbImageView) this.dXT.findViewById(d.g.headline_image);
        this.dXW.setPageId(this.dFP.getUniqueId());
        this.dXT.setVisibility(8);
        this.dYH = this.mParent.findViewById(d.g.level_container);
        this.dYG = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dYF = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dYJ = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dJI = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dJI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.aRR.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.oJ()) {
                    l.showToast(c.this.aRR.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.dJM) && !StringUtils.isNull(c.this.mForumId)) {
                    aw.Du().c(c.this.aRR, new String[]{c.this.dJM + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        awX();
        this.dFP.registerListener(this.dJO);
        this.dJE = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dJE.setContext(this.aRR);
    }

    private void awW() {
        this.dJL = (FrsHeaderPraiseView) this.dXO.findViewById(d.g.frs_praise_layout);
    }

    private void awX() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.dYk = (ai) runTask.getData();
            this.dYk.a(this.aRR, this.mParent, 1, false, this.dFP.getUniqueId());
            this.dYk.hide();
        }
    }

    private void awY() {
        final com.baidu.tbadk.core.data.l bvu = this.dVU.bvu();
        if (bvu != null && this.dVU.bas() != null) {
            final String id = this.dVU.bas().getId();
            final String name = this.dVU.bas().getName();
            if (this.dYD.add(bvu.xP())) {
                a.C0235a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bvu.xP(), id, name, null);
                b.ce("obj_url", bvu.getUrl());
                b.save();
            }
            this.dXT.setVisibility(0);
            this.dXU.setText(bvu.getText());
            this.dXV.setText(bvu.getTitle());
            this.dXW.startLoad(bvu.xO(), 10, false);
            this.dXT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0235a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bvu.xP(), id, name, null);
                    b2.ce("obj_url", bvu.getUrl());
                    b2.save();
                    aw.Du().c(c.this.dFP.getPageContext(), new String[]{bvu.getUrl()});
                }
            });
        }
    }

    protected View awZ() {
        return LayoutInflater.from(this.dFP.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void nf(int i) {
        if (i <= 0 || i > 5) {
            this.dJI.setVisibility(8);
            this.dDI.setMaxWidth(l.t(this.aRR.getPageActivity(), d.e.ds370));
            return;
        }
        this.dJI.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.dJN[i - 1]);
        this.dJI.setImageDrawable(drawable);
        this.dDI.setMaxWidth((l.t(this.aRR.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dJI.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void l(View.OnClickListener onClickListener) {
        this.dYf.setOnClickListener(onClickListener);
        this.dDI.setOnClickListener(onClickListener);
        this.dXL.setOnClickListener(onClickListener);
        this.dXK.setOnClickListener(onClickListener);
        this.dYH.setOnClickListener(onClickListener);
        if (this.dXP != null) {
            this.dXP.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aRR.getLayoutMode().aQ(i == 1);
        this.aRR.getLayoutMode().aM(this.mParent);
        this.aRR.getLayoutMode().aM(this.dYa);
        this.aRR.getLayoutMode().aM(this.dXO);
        if (this.dYx) {
            oe(1);
        } else {
            oe(0);
        }
        this.dYf.invalidate();
        aj.t(this.bSe, d.C0140d.cp_bg_line_d);
        aj.t(this.cMb, d.C0140d.cp_bg_line_e);
        aj.r(this.dYI, d.C0140d.cp_cont_j);
        aj.r(this.dXM, d.C0140d.cp_cont_j);
        aj.r(this.dJG, d.C0140d.cp_cont_j);
        aj.r(this.dXI, d.C0140d.cp_cont_j);
        aj.r(this.dJH, d.C0140d.cp_cont_j);
        aj.r(this.dXJ, d.C0140d.cp_cont_j);
        this.dYf.setBorderWidth(l.t(this.aRR.getPageActivity(), d.e.tbds1));
        this.dYf.setBorderColor(aj.getColor(d.C0140d.black_alpha15));
        axd();
        if (this.dXP != null) {
            aj.s(this.dXP, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dYd, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dYd, d.f.icon_sml_speed_gray);
        }
        if (this.dYj != null) {
            this.dYj.changeSkinType(i);
        }
        if (this.dYk != null) {
            this.dYk.changeSkinType(i);
        }
        if (this.dYg != null) {
            this.dYg.gB(i);
        }
        Iterator<TbImageView> it = this.dJK.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        awT();
        aj.s(this.dXT, d.f.home_thread_card_item_bg);
        aj.r(this.dDI, d.C0140d.cp_cont_b);
        if (this.dJD != null) {
            com.baidu.tbadk.n.a.a(this.dFP.getPageContext(), this.dJD);
        }
        if (this.dJL.getVisibility() == 0) {
            this.dJL.changeSkinType(i);
        }
        aj.s(this.dYK, d.f.btn_round_cont_d);
        aj.r(this.dYK, d.C0140d.btn_cont_j_alpha_20_selector);
        if (this.dXS != null) {
            aj.t(this.dXS, d.C0140d.cp_bg_line_e);
        }
        if (this.dJE != null && this.dJE.getVisibility() == 0) {
            this.dJE.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dYp = forumData.getPost_num();
            this.dYm = forumData.getTag_color();
            this.aMi = forumData.getImage_url();
            this.dYl = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dYq = forumData.getSignData().count_sign_num;
                this.dYr = forumData.getSignData().miss_sign_num;
            }
            this.dYs = forumData.getCurScore();
            this.dVr = forumData.getLevelupScore();
            this.dYh = forumData.getBadgeData();
            this.dXY = forumData.getTopCode();
            this.dXZ = forumData.getNewsInfo();
            this.dYn = forumData.getAccelerateContent();
            this.dVU = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dYo = new bd();
            axa();
            axe();
            awY();
            this.dJL.setVisibility(8);
            if (lVar != null && lVar.buP() != null) {
                nf(lVar.buP().grade.intValue());
                this.dJM = lVar.buP().url;
            }
            if (lVar != null && lVar.gZl != null) {
                FrsTabInfo frsTabInfo = lVar.gZl;
                this.dJJ = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dYK.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dYK.setText(frsTabInfo.tab_name);
                }
                this.dYK.setOnClickListener(this.dJP);
            } else {
                this.dYK.setVisibility(8);
            }
            if (lVar != null && lVar.gZn != null) {
                this.dJE.setData(lVar.gZn);
                this.dJE.setVisibility(0);
                this.dYJ.setPadding(0, this.dYJ.getPaddingTop(), 0, 0);
                return;
            }
            this.dJE.setVisibility(8);
        }
    }

    protected void axa() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aMi);
        this.dYo.zy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void axb() {
        int t = l.t(this.aRR.getPageActivity(), d.e.tbds32);
        if (this.dYr > 0) {
            aj.e(this.dXL, d.C0140d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, t, t);
            int t2 = l.t(this.aRR.getPageActivity(), d.e.tbds24);
            this.dXL.setPadding(t2, 0, t2, 0);
            this.dXL.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dXL.setText(String.format(this.aRR.getString(d.j.miss_sign_days), Integer.valueOf(this.dYr)));
            aj.s(this.dXL, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, t, t);
            this.dXL.setCompoundDrawables(drawable2, null, null, null);
            aj.e(this.dXL, d.C0140d.cp_cont_e, 1);
            this.dXL.setText(this.aRR.getString(d.j.signed));
            this.dXL.setPadding(0, 0, 0, 0);
            this.dXL.setBackgroundDrawable(null);
        }
        this.dXL.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dXL.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void axc() {
        int t = l.t(this.aRR.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, t, t);
        this.dXL.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dXL.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dXL, d.C0140d.cp_cont_i, 1);
        aj.s(this.dXL, d.f.frs_attention_btn_bg_selector);
    }

    protected void axd() {
        int t = l.t(this.aRR.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, t, t);
        this.dXK.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dXK.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dXK, d.C0140d.cp_cont_g, 1);
        aj.s(this.dXK, d.f.frs_attention_btn_bg_selector);
    }

    protected void axe() {
        List<com.baidu.tieba.tbadkCore.g> list = null;
        if (this.dXI != null) {
            this.dXI.setText(am.F(this.mMemberNum));
        }
        if (this.dXJ != null) {
            this.dXJ.setText(am.F(this.dYp));
        }
        if (this.dYh != null && this.dYh.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aRR.getString(d.j.forum));
            }
            if (this.dDI != null) {
                this.dDI.setText(this.mForumName + this.aRR.getString(d.j.forum));
            }
        }
        if (this.dXP != null && this.dXQ != null) {
            if (this.dVU != null && this.dVU.bvb()) {
                if (m.eb(this.dVU.bve()) == 1 && !n.aVm) {
                    this.dXP.setVisibility(8);
                } else {
                    this.dXP.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dVU.getGameName()) && !TextUtils.isEmpty(this.dVU.getGameName().trim())) {
                        this.dXQ.setText(UtilHelper.getFixedText(this.dVU.getGameName(), 10));
                        String sT = com.baidu.tieba.tbadkCore.util.b.sT(this.dVU.bve());
                        if (!StringUtils.isNull(sT)) {
                            TiebaStatic.eventStat(this.aRR.getPageActivity(), "game_show", "show", 1, "dev_id", sT, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dXQ.setText(this.aRR.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dXP.setVisibility(8);
            }
        }
        this.dXX.setVisibility(8);
        this.dYj.a(null, null);
        if (this.dXP != null) {
            this.dXR = this.dXP.findViewById(d.g.top_item_divider);
        }
        axf();
        if (this.dVU != null && !v.E(this.dVU.bvc())) {
            list = this.dVU.bvc();
            bz(list);
        }
        bl(list);
    }

    protected void axf() {
        this.dYf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dYf.startLoad(this.aMi, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void p(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dYE);
            if (this.QJ == null) {
                this.QJ = new PopupWindow(this.aRR.getPageActivity());
                this.QJ.setContentView(this.dYa);
                this.QJ.setBackgroundDrawable(new BitmapDrawable());
                this.QJ.setOutsideTouchable(true);
                this.QJ.setFocusable(true);
                this.QJ.setWidth(this.aRR.getResources().getDimensionPixelSize(d.e.ds228));
                this.QJ.setHeight(this.aRR.getResources().getDimensionPixelSize(d.e.ds100));
                this.dYb = (TextView) this.dYa.findViewById(d.g.cur_experience);
                this.dYc = (TextView) this.dYa.findViewById(d.g.levelup_experience);
                a(this.dYb, this.dYc);
            }
            if (this.QJ.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.QJ, this.aRR.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dYb, this.dYc);
            if (iArr[1] - this.QJ.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.QJ, this.aRR.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.QJ, this.mParent, 0, iArr[0], iArr[1] - this.QJ.getHeight());
            this.QJ.update();
            this.mHandler.postDelayed(this.dYE, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aRR.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.e((TextView) inflate.findViewById(d.g.experience_txt), d.C0140d.cp_cont_b, 1);
            aj.e(textView, d.C0140d.cp_cont_b, 1);
            aj.e(textView2, d.C0140d.cp_cont_b, 1);
            aj.e(textView3, d.C0140d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dYn) && !TextUtils.isEmpty(this.dYn.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dYn);
            } else {
                textView3.setVisibility(8);
            }
            aVar.fc(d.C0140d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aRR);
            aVar.AU();
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
                if (c.this.aRR != null && c.this.aRR.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aRR.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void axg() {
        View contentView;
        if (this.dYe == null) {
            this.dYe = new PopupWindow(this.aRR.getPageActivity());
            contentView = LayoutInflater.from(this.aRR.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dYe.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aRR != null && c.this.aRR.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dYe, c.this.aRR.getPageActivity());
                        c.this.dFP.dEl = false;
                        com.baidu.tbadk.browser.b.a(c.this.aRR.getPageActivity(), c.this.aRR.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dYe.setWidth(this.aRR.getResources().getDimensionPixelSize(d.e.ds300));
            this.dYe.setHeight(this.aRR.getResources().getDimensionPixelSize(d.e.ds88));
            this.dYe.setBackgroundDrawable(new BitmapDrawable());
            this.dYe.setOutsideTouchable(true);
            this.dYe.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.b(c.this.dYe);
                        c.this.dFP.dEl = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dYe.getContentView();
        }
        this.aRR.getLayoutMode().aM(contentView);
        int[] iArr = new int[2];
        this.dYd.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dYe, this.mParent, 0, (iArr[0] - (this.dYe.getWidth() / 2)) + (this.dYd.getWidth() / 2), iArr[1] + this.dYd.getWidth());
        this.dYe.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.dYy = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dYy) {
                this.dXM.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l avl = this.dFP.avl();
                if (avl != null && avl.bas() != null) {
                    avl.bas().setUser_level(i);
                }
                this.dYI.setText(this.aRR.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dXM.setText(this.dYl);
                this.dYI.setText(this.aRR.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dXN.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ng(this.mLevel)));
            if (this.dYy) {
                if (f >= 1.0f) {
                    a(this.dFP.getBaseFragmentActivity(), this.dXN, this.dYz, f);
                } else {
                    b(this.dFP.getBaseFragmentActivity(), this.dXN, this.dYz, f);
                }
            } else {
                a(this.dFP.getBaseFragmentActivity(), this.dXN, this.dYz, f);
            }
            this.dYz = f;
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
    protected void axh() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void axi() {
        if (this.mMemberType != 0) {
            aj.c(this.dYd, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dYd, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dJO);
    }
}
