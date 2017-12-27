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
import com.baidu.tbadk.core.data.be;
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
    private String aKN;
    private RelativeLayout bPH;
    private TextView dBD;
    private TextView dBE;
    private ImageView dBF;
    private String dBG;
    private FrsHeaderPraiseView dBI;
    private String dBJ;
    private int mTabId;
    private int[] dBK = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dBL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dOQ != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.cHG.setVisibility(8);
                } else {
                    c.this.cHG.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dBM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!StringUtils.isNull(c.this.dBG)) {
                if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                    ak akVar = new ak("c11500");
                    akVar.ab("obj_param1", c.this.mTabId == 201 ? "2" : "1").ab("obj_param2", "1");
                    TiebaStatic.log(akVar);
                }
                av.Di().c(c.this.aQq, new String[]{c.this.dBG});
            }
        }
    };
    private ArrayList<TbImageView> dBH = new ArrayList<>();

    public c(i iVar, String str, String str2, int i) {
        this.bPH = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dxW = iVar;
        this.aQq = iVar.getPageContext();
        this.dOH = l.s(iVar.getPageContext().getPageActivity(), d.e.ds20);
        this.dOI = l.s(iVar.getPageContext().getPageActivity(), d.e.ds72);
        this.dOJ = l.s(iVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = auS();
        this.bPH = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dPc = LayoutInflater.from(iVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dPf = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dBD = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dBE = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dOO = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dPK = (TextView) this.mParent.findViewById(d.g.level);
        this.dOM = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dON = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dON.setContentDescription(iVar.getResources().getString(d.j.sign));
        this.dOP = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dOK = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dOL = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dPh = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dvT = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dPh.setPageId(this.dxW.getUniqueId());
        this.dPh.setContentDescription(iVar.getResources().getString(d.j.bar_header));
        this.dPh.setGifIconSupport(false);
        this.dPh.setDrawerType(0);
        this.dOQ = LayoutInflater.from(this.dxW.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        auL();
        auP();
        this.dOR = (ViewGroup) this.dOQ.findViewById(d.g.frs_header_games);
        this.dOS = (TextView) this.dOQ.findViewById(d.g.top_item_title);
        this.dOZ = (LinearLayout) this.dOQ.findViewById(d.g.frs_present_root);
        this.dPM = (TextView) this.bPH.findViewById(d.g.new_chapter_btn);
        this.cHG = this.dOQ.findViewById(d.g.divider_bottom);
        this.dPl = new f(this.aQq, this.dOQ);
        this.dPk = new com.baidu.tieba.frs.e.b(this.aQq);
        this.dOV = (ViewGroup) this.dOQ.findViewById(d.g.frs_headline);
        this.dOW = (TextView) this.dOV.findViewById(d.g.headline_title);
        this.dOX = (TextView) this.dOV.findViewById(d.g.headline_text);
        this.dOY = (TbImageView) this.dOV.findViewById(d.g.headline_image);
        this.dOY.setPageId(this.dxW.getUniqueId());
        this.dOV.setVisibility(8);
        this.dPJ = this.mParent.findViewById(d.g.level_container);
        this.dPI = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dPH = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dPL = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dBF = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.aQq.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.oI()) {
                    l.showToast(c.this.aQq.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.dBJ) && !StringUtils.isNull(c.this.mForumId)) {
                    av.Di().c(c.this.aQq, new String[]{c.this.dBJ + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        auQ();
        this.dxW.registerListener(this.dBL);
    }

    private void auP() {
        this.dBI = (FrsHeaderPraiseView) this.dOQ.findViewById(d.g.frs_praise_layout);
    }

    private void auQ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ai.class);
        if (runTask != null && runTask.getData() != null) {
            this.dPm = (ai) runTask.getData();
            this.dPm.a(this.aQq, this.mParent, 1, false, this.dxW.getUniqueId());
            this.dPm.hide();
        }
    }

    private void auR() {
        final com.baidu.tbadk.core.data.l bAH = this.dNG.bAH();
        if (bAH != null && this.dNG.aYy() != null) {
            final String id = this.dNG.aYy().getId();
            final String name = this.dNG.aYy().getName();
            if (this.dPF.add(bAH.xj())) {
                a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bAH.xj(), id, name, null);
                b.ch("obj_url", bAH.getUrl());
                b.save();
            }
            this.dOV.setVisibility(0);
            this.dOW.setText(bAH.getText());
            this.dOX.setText(bAH.getTitle());
            this.dOY.startLoad(bAH.xi(), 10, false);
            this.dOV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.i */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0155a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bAH.xj(), id, name, null);
                    b2.ch("obj_url", bAH.getUrl());
                    b2.save();
                    av.Di().c(c.this.dxW.getPageContext(), new String[]{bAH.getUrl()});
                }
            });
        }
    }

    protected View auS() {
        return LayoutInflater.from(this.dxW.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void ne(int i) {
        if (i <= 0 || i > 5) {
            this.dBF.setVisibility(8);
            this.dvT.setMaxWidth(l.s(this.aQq.getPageActivity(), d.e.ds370));
            return;
        }
        this.dBF.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.dBK[i - 1]);
        this.dBF.setImageDrawable(drawable);
        this.dvT.setMaxWidth((l.s(this.aQq.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dBF.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.dPh.setOnClickListener(onClickListener);
        this.dvT.setOnClickListener(onClickListener);
        this.dON.setOnClickListener(onClickListener);
        this.dOM.setOnClickListener(onClickListener);
        this.dPJ.setOnClickListener(onClickListener);
        if (this.dOR != null) {
            this.dOR.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aQq.getLayoutMode().aM(i == 1);
        this.aQq.getLayoutMode().aM(this.mParent);
        this.aQq.getLayoutMode().aM(this.dPc);
        this.aQq.getLayoutMode().aM(this.dOQ);
        if (this.dPz) {
            ob(1);
        } else {
            ob(0);
        }
        this.dPh.invalidate();
        aj.t(this.bPH, d.C0108d.cp_bg_line_d);
        aj.t(this.cHG, d.C0108d.cp_bg_line_e);
        aj.r(this.dPK, d.C0108d.cp_cont_j);
        aj.r(this.dOO, d.C0108d.cp_cont_j);
        aj.r(this.dBD, d.C0108d.cp_cont_j);
        aj.r(this.dOK, d.C0108d.cp_cont_j);
        aj.r(this.dBE, d.C0108d.cp_cont_j);
        aj.r(this.dOL, d.C0108d.cp_cont_j);
        this.dPh.setBorderWidth(l.s(this.aQq.getPageActivity(), d.e.tbds1));
        this.dPh.setBorderColor(aj.getColor(d.C0108d.black_alpha15));
        auW();
        if (this.dOR != null) {
            aj.s(this.dOR, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.dPf, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dPf, d.f.icon_sml_speed_gray);
        }
        if (this.dPl != null) {
            this.dPl.changeSkinType(i);
        }
        if (this.dPm != null) {
            this.dPm.changeSkinType(i);
        }
        if (this.dPi != null) {
            this.dPi.gC(i);
        }
        Iterator<TbImageView> it = this.dBH.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        auM();
        aj.s(this.dOV, d.f.home_thread_card_item_bg);
        aj.r(this.dvT, d.C0108d.cp_cont_b);
        if (this.dBB != null) {
            com.baidu.tbadk.n.a.a(this.dxW.getPageContext(), this.dBB);
        }
        if (this.dBI.getVisibility() == 0) {
            this.dBI.changeSkinType(i);
        }
        aj.s(this.dPM, d.f.btn_round_cont_d);
        aj.r(this.dPM, d.C0108d.btn_cont_j_alpha_20_selector);
        if (this.dOU != null) {
            aj.t(this.dOU, d.C0108d.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dPr = forumData.getPost_num();
            this.dPo = forumData.getTag_color();
            this.aKN = forumData.getImage_url();
            this.dPn = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dPs = forumData.getSignData().count_sign_num;
                this.dPt = forumData.getSignData().miss_sign_num;
            }
            this.dPu = forumData.getCurScore();
            this.dNi = forumData.getLevelupScore();
            this.dPj = forumData.getBadgeData();
            this.dPa = forumData.getTopCode();
            this.dPb = forumData.getNewsInfo();
            this.dPp = forumData.getAccelerateContent();
            this.dNG = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dPq = new be();
            auT();
            auX();
            auR();
            this.dBI.setVisibility(8);
            if (lVar != null && lVar.bAc() != null) {
                ne(lVar.bAc().grade.intValue());
                this.dBJ = lVar.bAc().url;
            }
            if (lVar != null && lVar.hgY != null) {
                FrsTabInfo frsTabInfo = lVar.hgY;
                this.dBG = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dPM.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dPM.setText(frsTabInfo.tab_name);
                }
                this.dPM.setOnClickListener(this.dBM);
                return;
            }
            this.dPM.setVisibility(8);
        }
    }

    protected void auT() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.aKN);
        this.dPq.zi().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void auU() {
        int s = l.s(this.aQq.getPageActivity(), d.e.tbds32);
        if (this.dPt > 0) {
            aj.e(this.dON, d.C0108d.cp_cont_i, 1);
            Drawable drawable = aj.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, s, s);
            int s2 = l.s(this.aQq.getPageActivity(), d.e.tbds24);
            this.dON.setPadding(s2, 0, s2, 0);
            this.dON.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dON.setText(String.format(this.aQq.getString(d.j.miss_sign_days), Integer.valueOf(this.dPt)));
            aj.s(this.dON, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = aj.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, s, s);
            this.dON.setCompoundDrawables(drawable2, null, null, null);
            aj.e(this.dON, d.C0108d.cp_cont_e, 1);
            this.dON.setText(this.aQq.getString(d.j.signed));
            this.dON.setPadding(0, 0, 0, 0);
            this.dON.setBackgroundDrawable(null);
        }
        this.dON.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dON.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void auV() {
        int s = l.s(this.aQq.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, s, s);
        this.dON.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dON.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dON, d.C0108d.cp_cont_i, 1);
        aj.s(this.dON, d.f.frs_attention_btn_bg_selector);
    }

    protected void auW() {
        int s = l.s(this.aQq.getPageActivity(), d.e.tbds32);
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, s, s);
        this.dOM.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dOM.setTextSize(0, l.s(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        aj.e(this.dOM, d.C0108d.cp_cont_g, 1);
        aj.s(this.dOM, d.f.frs_attention_btn_bg_selector);
    }

    protected void auX() {
        List<g> list = null;
        if (this.dOK != null) {
            this.dOK.setText(am.E(this.mMemberNum));
        }
        if (this.dOL != null) {
            this.dOL.setText(am.E(this.dPr));
        }
        if (this.dPj != null && this.dPj.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aQq.getString(d.j.forum));
            }
            if (this.dvT != null) {
                this.dvT.setText(this.mForumName + this.aQq.getString(d.j.forum));
            }
        }
        if (this.dOR != null && this.dOS != null) {
            if (this.dNG != null && this.dNG.bAo()) {
                if (m.dK(this.dNG.bAr()) == 1 && !n.aTF) {
                    this.dOR.setVisibility(8);
                } else {
                    this.dOR.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dNG.getGameName()) && !TextUtils.isEmpty(this.dNG.getGameName().trim())) {
                        this.dOS.setText(UtilHelper.getFixedText(this.dNG.getGameName(), 10));
                        String tk = com.baidu.tieba.tbadkCore.util.b.tk(this.dNG.bAr());
                        if (!StringUtils.isNull(tk)) {
                            TiebaStatic.eventStat(this.aQq.getPageActivity(), "game_show", "show", 1, "dev_id", tk, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dOS.setText(this.aQq.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dOR.setVisibility(8);
            }
        }
        this.dOZ.setVisibility(8);
        this.dPl.a(null, null);
        this.dOT = this.dOR.findViewById(d.g.top_item_divider);
        auY();
        if (this.dNG != null && !v.G(this.dNG.bAp())) {
            list = this.dNG.bAp();
            bz(list);
        }
        bl(list);
    }

    protected void auY() {
        this.dPh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dPh.startLoad(this.aKN, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.c
    @SuppressLint({"ResourceAsColor"})
    public void p(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dPG);
            if (this.QK == null) {
                this.QK = new PopupWindow(this.aQq.getPageActivity());
                this.QK.setContentView(this.dPc);
                this.QK.setBackgroundDrawable(new BitmapDrawable());
                this.QK.setOutsideTouchable(true);
                this.QK.setFocusable(true);
                this.QK.setWidth(this.aQq.getResources().getDimensionPixelSize(d.e.ds228));
                this.QK.setHeight(this.aQq.getResources().getDimensionPixelSize(d.e.ds100));
                this.dPd = (TextView) this.dPc.findViewById(d.g.cur_experience);
                this.dPe = (TextView) this.dPc.findViewById(d.g.levelup_experience);
                a(this.dPd, this.dPe);
            }
            if (this.QK.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.QK, this.aQq.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dPd, this.dPe);
            if (iArr[1] - this.QK.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.QK, this.aQq.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.QK, this.mParent, 0, iArr[0], iArr[1] - this.QK.getHeight());
            this.QK.update();
            this.mHandler.postDelayed(this.dPG, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aQq.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.e((TextView) inflate.findViewById(d.g.experience_txt), d.C0108d.cp_cont_b, 1);
            aj.e(textView, d.C0108d.cp_cont_b, 1);
            aj.e(textView2, d.C0108d.cp_cont_b, 1);
            aj.e(textView3, d.C0108d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQq.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dPp) && !TextUtils.isEmpty(this.dPp.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dPp);
            } else {
                textView3.setVisibility(8);
            }
            aVar.fe(d.C0108d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aQq);
            aVar.AI();
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
                if (c.this.aQq != null && c.this.aQq.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aQq.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.c
    public void auZ() {
        View contentView;
        if (this.dPg == null) {
            this.dPg = new PopupWindow(this.aQq.getPageActivity());
            contentView = LayoutInflater.from(this.aQq.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dPg.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aQq != null && c.this.aQq.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dPg, c.this.aQq.getPageActivity());
                        c.this.dxW.dww = false;
                        com.baidu.tbadk.browser.a.a(c.this.aQq.getPageActivity(), c.this.aQq.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dPg.setWidth(this.aQq.getResources().getDimensionPixelSize(d.e.ds300));
            this.dPg.setHeight(this.aQq.getResources().getDimensionPixelSize(d.e.ds88));
            this.dPg.setBackgroundDrawable(new BitmapDrawable());
            this.dPg.setOutsideTouchable(true);
            this.dPg.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.b(c.this.dPg);
                        c.this.dxW.dww = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dPg.getContentView();
        }
        this.aQq.getLayoutMode().aM(contentView);
        int[] iArr = new int[2];
        this.dPf.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dPg, this.mParent, 0, (iArr[0] - (this.dPg.getWidth() / 2)) + (this.dPf.getWidth() / 2), iArr[1] + this.dPf.getWidth());
        this.dPg.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.dPA = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dPA) {
                this.dOO.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l atn = this.dxW.atn();
                if (atn != null && atn.aYy() != null) {
                    atn.aYy().setUser_level(i);
                }
                this.dPK.setText(this.aQq.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dOO.setText(this.dPn);
                this.dPK.setText(this.aQq.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dOP.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, nf(this.mLevel)));
            if (this.dPA) {
                if (f >= 1.0f) {
                    a(this.dxW.getBaseFragmentActivity(), this.dOP, this.dPB, f);
                } else {
                    b(this.dxW.getBaseFragmentActivity(), this.dOP, this.dPB, f);
                }
            } else {
                a(this.dxW.getBaseFragmentActivity(), this.dOP, this.dPB, f);
            }
            this.dPB = f;
        }
    }

    private int[] nf(int i) {
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
    protected void ava() {
    }

    @Override // com.baidu.tieba.frs.view.c
    public void avb() {
        if (this.mMemberType != 0) {
            aj.c(this.dPf, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.dPf, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dBL);
    }
}
