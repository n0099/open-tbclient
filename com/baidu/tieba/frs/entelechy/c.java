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
    private String aLX;
    private RelativeLayout bRR;
    private String dJA;
    private TextView dJu;
    private TextView dJv;
    private ImageView dJw;
    private String dJx;
    private FrsHeaderPraiseView dJz;
    private int mTabId;
    private int[] dJB = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dJC = new CustomMessageListener(2003018) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dXC != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cLP.setVisibility(8);
                } else {
                    c.this.cLP.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dJD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.dJx)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ab("obj_param1", c.this.mTabId == 201 ? "2" : "1").ab("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                aw.Dt().c(c.this.aRG, new String[]{c.this.dJx});
            }
        }
    };
    private ArrayList<TbImageView> dJy = new ArrayList<>();

    public c(i iVar, String str, String str2, int i) {
        this.bRR = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dFD = iVar;
        this.aRG = iVar.getPageContext();
        this.dXt = l.t(iVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dXu = l.t(iVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dXv = l.t(iVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = awY();
        this.bRR = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dXO = LayoutInflater.from(iVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dXR = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dJu = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dJv = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dXA = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dYw = (TextView) this.mParent.findViewById(d.g.level);
        this.dXy = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dXz = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dXz.setContentDescription(iVar.getResources().getString(d.j.sign));
        this.dXB = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dXw = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dXx = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dXT = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dDw = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dXT.setPageId(this.dFD.getUniqueId());
        this.dXT.setContentDescription(iVar.getResources().getString(d.j.bar_header));
        this.dXT.setGifIconSupport(false);
        this.dXT.setDrawerType(0);
        this.dXC = LayoutInflater.from(this.dFD.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        awR();
        awV();
        this.dXD = (ViewGroup) this.dXC.findViewById(d.g.frs_header_games);
        this.dXE = (TextView) this.dXC.findViewById(d.g.top_item_title);
        this.dXL = (LinearLayout) this.dXC.findViewById(d.g.frs_present_root);
        this.dYy = (TextView) this.bRR.findViewById(d.g.new_chapter_btn);
        this.cLP = this.dXC.findViewById(d.g.divider_bottom);
        this.dXX = new g(this.aRG, this.dXC);
        this.dXW = new com.baidu.tieba.frs.f.b(this.aRG);
        this.dXH = (ViewGroup) this.dXC.findViewById(d.g.frs_headline);
        this.dXI = (TextView) this.dXH.findViewById(d.g.headline_title);
        this.dXJ = (TextView) this.dXH.findViewById(d.g.headline_text);
        this.dXK = (TbImageView) this.dXH.findViewById(d.g.headline_image);
        this.dXK.setPageId(this.dFD.getUniqueId());
        this.dXH.setVisibility(8);
        this.dYv = this.mParent.findViewById(d.g.level_container);
        this.dYu = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dYt = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dYx = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dJw = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.aRG.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.oJ()) {
                    l.showToast(c.this.aRG.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.dJA) && !StringUtils.isNull(c.this.mForumId)) {
                    aw.Dt().c(c.this.aRG, new String[]{c.this.dJA + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        awW();
        this.dFD.registerListener(this.dJC);
        this.dJs = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dJs.setContext(this.aRG);
    }

    private void awV() {
        this.dJz = (FrsHeaderPraiseView) this.dXC.findViewById(d.g.frs_praise_layout);
    }

    private void awW() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.dXY = (ai) runTask.getData();
            this.dXY.a(this.aRG, this.mParent, 1, false, this.dFD.getUniqueId());
            this.dXY.hide();
        }
    }

    private void awX() {
        final com.baidu.tbadk.core.data.l bvt = this.dVI.bvt();
        if (bvt != null && this.dVI.bar() != null) {
            final String id = this.dVI.bar().getId();
            final String name = this.dVI.bar().getName();
            if (this.dYr.add(bvt.xP())) {
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bvt.xP(), id, name, null);
                b.ce("obj_url", bvt.getUrl());
                b.save();
            }
            this.dXH.setVisibility(0);
            this.dXI.setText(bvt.getText());
            this.dXJ.setText(bvt.getTitle());
            this.dXK.startLoad(bvt.xO(), 10, false);
            this.dXH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0236a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bvt.xP(), id, name, null);
                    b2.ce("obj_url", bvt.getUrl());
                    b2.save();
                    aw.Dt().c(c.this.dFD.getPageContext(), new String[]{bvt.getUrl()});
                }
            });
        }
    }

    protected View awY() {
        return LayoutInflater.from(this.dFD.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void nf(int i) {
        if (i <= 0 || i > 5) {
            this.dJw.setVisibility(8);
            this.dDw.setMaxWidth(l.t(this.aRG.getPageActivity(), d.e.ds370));
            return;
        }
        this.dJw.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.dJB[i - 1]);
        this.dJw.setImageDrawable(drawable);
        this.dDw.setMaxWidth((l.t(this.aRG.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dJw.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void l(View.OnClickListener onClickListener) {
        this.dXT.setOnClickListener(onClickListener);
        this.dDw.setOnClickListener(onClickListener);
        this.dXz.setOnClickListener(onClickListener);
        this.dXy.setOnClickListener(onClickListener);
        this.dYv.setOnClickListener(onClickListener);
        if (this.dXD != null) {
            this.dXD.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aRG.getLayoutMode().aQ(i == 1);
        this.aRG.getLayoutMode().aM(this.mParent);
        this.aRG.getLayoutMode().aM(this.dXO);
        this.aRG.getLayoutMode().aM(this.dXC);
        if (this.dYl) {
            oe(1);
        } else {
            oe(0);
        }
        this.dXT.invalidate();
        aj.t(this.bRR, d.C0141d.cp_bg_line_d);
        aj.t(this.cLP, d.C0141d.cp_bg_line_e);
        aj.r(this.dYw, d.C0141d.cp_cont_j);
        aj.r(this.dXA, d.C0141d.cp_cont_j);
        aj.r(this.dJu, d.C0141d.cp_cont_j);
        aj.r(this.dXw, d.C0141d.cp_cont_j);
        aj.r(this.dJv, d.C0141d.cp_cont_j);
        aj.r(this.dXx, d.C0141d.cp_cont_j);
        this.dXT.setBorderWidth(l.t(this.aRG.getPageActivity(), d.e.tbds1));
        this.dXT.setBorderColor(aj.getColor(d.C0141d.black_alpha15));
        axc();
        if (this.dXD != null) {
            aj.s(this.dXD, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dXR, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dXR, d.f.icon_sml_speed_gray);
        }
        if (this.dXX != null) {
            this.dXX.changeSkinType(i);
        }
        if (this.dXY != null) {
            this.dXY.changeSkinType(i);
        }
        if (this.dXU != null) {
            this.dXU.gB(i);
        }
        Iterator<TbImageView> it = this.dJy.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        awS();
        aj.s(this.dXH, d.f.home_thread_card_item_bg);
        aj.r(this.dDw, d.C0141d.cp_cont_b);
        if (this.dJr != null) {
            com.baidu.tbadk.n.a.a(this.dFD.getPageContext(), this.dJr);
        }
        if (this.dJz.getVisibility() == 0) {
            this.dJz.changeSkinType(i);
        }
        aj.s(this.dYy, d.f.btn_round_cont_d);
        aj.r(this.dYy, d.C0141d.btn_cont_j_alpha_20_selector);
        if (this.dXG != null) {
            aj.t(this.dXG, d.C0141d.cp_bg_line_e);
        }
        if (this.dJs != null && this.dJs.getVisibility() == 0) {
            this.dJs.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dYd = forumData.getPost_num();
            this.dYa = forumData.getTag_color();
            this.aLX = forumData.getImage_url();
            this.dXZ = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dYe = forumData.getSignData().count_sign_num;
                this.dYf = forumData.getSignData().miss_sign_num;
            }
            this.dYg = forumData.getCurScore();
            this.dVf = forumData.getLevelupScore();
            this.dXV = forumData.getBadgeData();
            this.dXM = forumData.getTopCode();
            this.dXN = forumData.getNewsInfo();
            this.dYb = forumData.getAccelerateContent();
            this.dVI = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dYc = new bd();
            awZ();
            axd();
            awX();
            this.dJz.setVisibility(8);
            if (lVar != null && lVar.buO() != null) {
                nf(lVar.buO().grade.intValue());
                this.dJA = lVar.buO().url;
            }
            if (lVar != null && lVar.gYW != null) {
                FrsTabInfo frsTabInfo = lVar.gYW;
                this.dJx = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dYy.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dYy.setText(frsTabInfo.tab_name);
                }
                this.dYy.setOnClickListener(this.dJD);
            } else {
                this.dYy.setVisibility(8);
            }
            if (lVar != null && lVar.gYY != null) {
                this.dJs.setData(lVar.gYY);
                this.dJs.setVisibility(0);
                this.dYx.setPadding(0, this.dYx.getPaddingTop(), 0, 0);
                return;
            }
            this.dJs.setVisibility(8);
        }
    }

    protected void awZ() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aLX);
        this.dYc.zy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void axa() {
        int t = l.t(this.aRG.getPageActivity(), d.e.tbds32);
        if (this.dYf > 0) {
            aj.e(this.dXz, d.C0141d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, t, t);
            int t2 = l.t(this.aRG.getPageActivity(), d.e.tbds24);
            this.dXz.setPadding(t2, 0, t2, 0);
            this.dXz.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dXz.setText(String.format(this.aRG.getString(d.j.miss_sign_days), Integer.valueOf(this.dYf)));
            aj.s(this.dXz, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, t, t);
            this.dXz.setCompoundDrawables(drawable2, null, null, null);
            aj.e(this.dXz, d.C0141d.cp_cont_e, 1);
            this.dXz.setText(this.aRG.getString(d.j.signed));
            this.dXz.setPadding(0, 0, 0, 0);
            this.dXz.setBackgroundDrawable(null);
        }
        this.dXz.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dXz.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void axb() {
        int t = l.t(this.aRG.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, t, t);
        this.dXz.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dXz.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dXz, d.C0141d.cp_cont_i, 1);
        aj.s(this.dXz, d.f.frs_attention_btn_bg_selector);
    }

    protected void axc() {
        int t = l.t(this.aRG.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, t, t);
        this.dXy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dXy.setTextSize(0, l.t(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dXy, d.C0141d.cp_cont_g, 1);
        aj.s(this.dXy, d.f.frs_attention_btn_bg_selector);
    }

    protected void axd() {
        List<com.baidu.tieba.tbadkCore.g> list = null;
        if (this.dXw != null) {
            this.dXw.setText(am.F(this.mMemberNum));
        }
        if (this.dXx != null) {
            this.dXx.setText(am.F(this.dYd));
        }
        if (this.dXV != null && this.dXV.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aRG.getString(d.j.forum));
            }
            if (this.dDw != null) {
                this.dDw.setText(this.mForumName + this.aRG.getString(d.j.forum));
            }
        }
        if (this.dXD != null && this.dXE != null) {
            if (this.dVI != null && this.dVI.bva()) {
                if (m.eb(this.dVI.bvd()) == 1 && !n.aVa) {
                    this.dXD.setVisibility(8);
                } else {
                    this.dXD.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dVI.getGameName()) && !TextUtils.isEmpty(this.dVI.getGameName().trim())) {
                        this.dXE.setText(UtilHelper.getFixedText(this.dVI.getGameName(), 10));
                        String sT = com.baidu.tieba.tbadkCore.util.b.sT(this.dVI.bvd());
                        if (!StringUtils.isNull(sT)) {
                            TiebaStatic.eventStat(this.aRG.getPageActivity(), "game_show", "show", 1, "dev_id", sT, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dXE.setText(this.aRG.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dXD.setVisibility(8);
            }
        }
        this.dXL.setVisibility(8);
        this.dXX.a(null, null);
        if (this.dXD != null) {
            this.dXF = this.dXD.findViewById(d.g.top_item_divider);
        }
        axe();
        if (this.dVI != null && !v.E(this.dVI.bvb())) {
            list = this.dVI.bvb();
            bz(list);
        }
        bl(list);
    }

    protected void axe() {
        this.dXT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dXT.startLoad(this.aLX, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void p(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dYs);
            if (this.QE == null) {
                this.QE = new PopupWindow(this.aRG.getPageActivity());
                this.QE.setContentView(this.dXO);
                this.QE.setBackgroundDrawable(new BitmapDrawable());
                this.QE.setOutsideTouchable(true);
                this.QE.setFocusable(true);
                this.QE.setWidth(this.aRG.getResources().getDimensionPixelSize(d.e.ds228));
                this.QE.setHeight(this.aRG.getResources().getDimensionPixelSize(d.e.ds100));
                this.dXP = (TextView) this.dXO.findViewById(d.g.cur_experience);
                this.dXQ = (TextView) this.dXO.findViewById(d.g.levelup_experience);
                a(this.dXP, this.dXQ);
            }
            if (this.QE.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.QE, this.aRG.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dXP, this.dXQ);
            if (iArr[1] - this.QE.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.QE, this.aRG.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.QE, this.mParent, 0, iArr[0], iArr[1] - this.QE.getHeight());
            this.QE.update();
            this.mHandler.postDelayed(this.dYs, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aRG.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.e((TextView) inflate.findViewById(d.g.experience_txt), d.C0141d.cp_cont_b, 1);
            aj.e(textView, d.C0141d.cp_cont_b, 1);
            aj.e(textView2, d.C0141d.cp_cont_b, 1);
            aj.e(textView3, d.C0141d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dYb) && !TextUtils.isEmpty(this.dYb.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dYb);
            } else {
                textView3.setVisibility(8);
            }
            aVar.fc(d.C0141d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aRG);
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
                if (c.this.aRG != null && c.this.aRG.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aRG.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void axf() {
        View contentView;
        if (this.dXS == null) {
            this.dXS = new PopupWindow(this.aRG.getPageActivity());
            contentView = LayoutInflater.from(this.aRG.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dXS.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aRG != null && c.this.aRG.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dXS, c.this.aRG.getPageActivity());
                        c.this.dFD.dDZ = false;
                        com.baidu.tbadk.browser.b.a(c.this.aRG.getPageActivity(), c.this.aRG.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dXS.setWidth(this.aRG.getResources().getDimensionPixelSize(d.e.ds300));
            this.dXS.setHeight(this.aRG.getResources().getDimensionPixelSize(d.e.ds88));
            this.dXS.setBackgroundDrawable(new BitmapDrawable());
            this.dXS.setOutsideTouchable(true);
            this.dXS.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.b(c.this.dXS);
                        c.this.dFD.dDZ = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dXS.getContentView();
        }
        this.aRG.getLayoutMode().aM(contentView);
        int[] iArr = new int[2];
        this.dXR.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dXS, this.mParent, 0, (iArr[0] - (this.dXS.getWidth() / 2)) + (this.dXR.getWidth() / 2), iArr[1] + this.dXR.getWidth());
        this.dXS.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.dYm = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dYm) {
                this.dXA.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l avk = this.dFD.avk();
                if (avk != null && avk.bar() != null) {
                    avk.bar().setUser_level(i);
                }
                this.dYw.setText(this.aRG.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dXA.setText(this.dXZ);
                this.dYw.setText(this.aRG.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dXB.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ng(this.mLevel)));
            if (this.dYm) {
                if (f >= 1.0f) {
                    a(this.dFD.getBaseFragmentActivity(), this.dXB, this.dYn, f);
                } else {
                    b(this.dFD.getBaseFragmentActivity(), this.dXB, this.dYn, f);
                }
            } else {
                a(this.dFD.getBaseFragmentActivity(), this.dXB, this.dYn, f);
            }
            this.dYn = f;
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
    protected void axg() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void axh() {
        if (this.mMemberType != 0) {
            aj.c(this.dXR, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dXR, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dJC);
    }
}
