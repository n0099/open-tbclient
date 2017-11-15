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
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c extends a {
    private String VW;
    private RelativeLayout aYF;
    private TextView cDi;
    private TextView cDj;
    private View cDk;
    private ImageView cDl;
    private g cDm;
    private FrsHeaderPraiseView cDo;
    private FrsEntranceStoryListWrapperView cDp;
    private String cDq;
    private int[] cDr = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener cDs = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cSp != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bKT.setVisibility(8);
                } else {
                    c.this.bKT.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cDn = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aYF = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.czk = fVar;
        this.abI = fVar.getPageContext();
        this.cSg = l.f(fVar.getPageContext().getPageActivity(), d.e.ds20);
        this.cSh = l.f(fVar.getPageContext().getPageActivity(), d.e.ds72);
        this.cSi = l.f(fVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.bbf = alj();
        this.aYF = (RelativeLayout) this.bbf.findViewById(d.g.container);
        this.aYF.setPadding(0, 0, 0, 0);
        this.cSA = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.bbf.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, l.f(this.abI.getPageActivity(), d.e.ds60)).setMargins(0, l.f(this.abI.getPageActivity(), d.e.ds220), 0, 0);
        this.cSD = (ImageView) this.bbf.findViewById(d.g.speed_icon);
        this.cDi = (TextView) this.bbf.findViewById(d.g.member_image);
        this.cDj = (TextView) this.bbf.findViewById(d.g.post_image);
        this.cSn = (TextView) this.bbf.findViewById(d.g.level_name);
        this.cTi = (TextView) this.bbf.findViewById(d.g.level);
        this.cSl = (TextView) this.bbf.findViewById(d.g.tv_love);
        this.cSm = (TextView) this.bbf.findViewById(d.g.tv_sign);
        this.cSm.setContentDescription(fVar.getResources().getString(d.j.sign));
        this.cSo = (ImageView) this.bbf.findViewById(d.g.love_level_top);
        this.cSj = (TextView) this.bbf.findViewById(d.g.member_num_text);
        this.cSk = (TextView) this.bbf.findViewById(d.g.post_num_text);
        this.cSF = (BarImageView) this.bbf.findViewById(d.g.frs_image);
        this.cxl = (TextView) this.bbf.findViewById(d.g.forum_name);
        this.cSF.setPageId(this.czk.getUniqueId());
        this.cSF.setContentDescription(fVar.getResources().getString(d.j.bar_header));
        this.cSF.setGifIconSupport(false);
        this.cSF.setDrawerType(0);
        this.cSp = LayoutInflater.from(this.czk.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        akZ();
        alg();
        alf();
        this.cSq = (ViewGroup) this.cSp.findViewById(d.g.frs_header_games);
        this.cSr = (TextView) this.cSp.findViewById(d.g.top_item_title);
        this.cSw = (LinearLayout) this.cSp.findViewById(d.g.frs_present_root);
        this.bKT = this.cSp.findViewById(d.g.divider_bottom);
        this.cDk = this.cSp.findViewById(d.g.stroy_divider_bottom);
        this.cSJ = new e(this.abI, this.cSp);
        this.cSI = new com.baidu.tieba.frs.f.b(this.abI);
        this.cSs = (ViewGroup) this.cSp.findViewById(d.g.frs_headline);
        this.cSt = (TextView) this.cSs.findViewById(d.g.headline_title);
        this.cSu = (TextView) this.cSs.findViewById(d.g.headline_text);
        this.cSv = (TbImageView) this.cSs.findViewById(d.g.headline_image);
        this.cSv.setPageId(this.czk.getUniqueId());
        this.cSs.setVisibility(8);
        this.cTh = this.bbf.findViewById(d.g.level_container);
        this.cTg = (RelativeLayout) this.bbf.findViewById(d.g.has_focused_container);
        this.cTf = (RelativeLayout) this.bbf.findViewById(d.g.not_focused_container);
        this.cTj = (RelativeLayout) this.bbf.findViewById(d.g.head_content_container);
        this.cDl = (ImageView) this.bbf.findViewById(d.g.single_bar_level);
        this.cDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.abI.getPageActivity(), (String) null, true, 11003)));
                } else if (!j.hh()) {
                    l.showToast(c.this.abI.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.cDq) && !StringUtils.isNull(c.this.mForumId)) {
                    av.vI().c(c.this.abI, new String[]{c.this.cDq + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        alh();
        this.czk.registerListener(this.cDs);
    }

    private void alf() {
        this.cDo = (FrsHeaderPraiseView) this.cSp.findViewById(d.g.frs_praise_layout);
    }

    private void alg() {
        this.cDp = (FrsEntranceStoryListWrapperView) this.cSp.findViewById(d.g.listview_story_wrapper_view);
        this.cDp.m(this.czk.getPageContext());
    }

    private void alh() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ah.class);
        if (runTask != null && runTask.getData() != null) {
            this.cSK = (ah) runTask.getData();
            this.cSK.a(this.abI, this.bbf, 1, false, this.czk.getUniqueId());
            this.cSK.hide();
        }
    }

    private void ali() {
        final m bti = this.cFm.bti();
        if (bti != null && this.cFm.aPU() != null) {
            final String id = this.cFm.aPU().getId();
            final String name = this.cFm.aPU().getName();
            if (this.cTd.add(bti.pB())) {
                a.C0129a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bti.pB(), id, name, null);
                b.ce("obj_url", bti.getUrl());
                b.save();
            }
            this.cSs.setVisibility(0);
            this.cSt.setText(bti.getText());
            this.cSu.setText(bti.getTitle());
            this.cSv.startLoad(bti.pA(), 10, false);
            this.cSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0129a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bti.pB(), id, name, null);
                    b2.ce("obj_url", bti.getUrl());
                    b2.save();
                    av.vI().c(c.this.czk.getPageContext(), new String[]{bti.getUrl()});
                }
            });
        }
    }

    protected View alj() {
        return LayoutInflater.from(this.czk.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void jD(int i) {
        if (i <= 0 || i > 5) {
            this.cDl.setVisibility(8);
            this.cxl.setMaxWidth(l.f(this.abI.getPageActivity(), d.e.ds370));
            return;
        }
        this.cDl.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.cDr[i - 1]);
        this.cDl.setImageDrawable(drawable);
        this.cxl.setMaxWidth((l.f(this.abI.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.cDl.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cSF.setOnClickListener(onClickListener);
        this.cxl.setOnClickListener(onClickListener);
        this.cSm.setOnClickListener(onClickListener);
        this.cSl.setOnClickListener(onClickListener);
        this.cTh.setOnClickListener(onClickListener);
        if (this.cSq != null) {
            this.cSq.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.abI.getLayoutMode().ag(i == 1);
        this.abI.getLayoutMode().t(this.bbf);
        this.abI.getLayoutMode().t(this.cSA);
        this.abI.getLayoutMode().t(this.cSp);
        if (this.cSX) {
            kE(1);
        } else {
            kE(0);
        }
        this.cSF.invalidate();
        aj.k(this.aYF, d.C0080d.cp_bg_line_d);
        aj.k(this.bKT, d.C0080d.cp_bg_line_c);
        aj.i(this.cTi, d.C0080d.cp_cont_f);
        aj.i(this.cSn, d.C0080d.cp_cont_f);
        aj.i(this.cDi, d.C0080d.cp_cont_d);
        aj.i(this.cSj, d.C0080d.cp_cont_b);
        aj.i(this.cDj, d.C0080d.cp_cont_d);
        aj.i(this.cSk, d.C0080d.cp_cont_b);
        if (this.cDp != null) {
            aj.k(this.cDp, d.C0080d.cp_bg_line_d);
        }
        alk();
        if (this.cSq != null) {
            aj.j(this.cSq, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.cSD, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.cSD, d.f.icon_sml_speed_gray);
        }
        if (this.cSJ != null) {
            this.cSJ.changeSkinType(i);
        }
        if (this.cSK != null) {
            this.cSK.changeSkinType(i);
        }
        if (this.cSG != null) {
            this.cSG.dD(i);
        }
        Iterator<TbImageView> it = this.cDn.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        alb();
        aj.j(this.cSs, d.f.home_thread_card_item_bg);
        aj.i(this.cxl, d.C0080d.cp_cont_b);
        if (this.cDe != null) {
            com.baidu.tbadk.o.a.a(this.czk.getPageContext(), this.cDe);
        }
        if (this.cDp.getVisibility() == 0) {
            this.cDp.changeSkinType(i);
        }
        aj.k(this.cDk, d.C0080d.cp_bg_line_c);
        if (this.cDo.getVisibility() == 0) {
            this.cDo.changeSkinType(i);
        }
    }

    protected void alk() {
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_selector);
        int f = l.f(this.abI.getPageActivity(), d.e.ds8);
        int f2 = l.f(this.abI.getPageActivity(), d.e.ds18);
        drawable.setBounds(0, f, f2, f2);
        this.cSl.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aj.c(this.cSl, d.f.frs_head_attention_text_bg, 1);
        aj.j(this.cSl, d.f.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.j jVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cSP = forumData.getPost_num();
            this.cSM = forumData.getTag_color();
            this.VW = forumData.getImage_url();
            this.cSL = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cSQ = forumData.getSignData().count_sign_num;
                this.cSR = forumData.getSignData().miss_sign_num;
            }
            this.cSS = forumData.getCurScore();
            this.cRw = forumData.getLevelupScore();
            this.cSH = forumData.getBadgeData();
            this.cSx = forumData.getTopCode();
            this.cSy = forumData.getNewsInfo();
            this.cSN = forumData.getAccelerateContent();
            this.cFm = jVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.bbf.setVisibility(8);
            } else {
                this.bbf.setVisibility(0);
            }
            this.cSO = new bh();
            all();
            alo();
            ali();
            if (this.cFm != null) {
                this.cDp.b(this.cFm.bsB(), this.czk.getForumId(), "0");
            } else {
                this.cDp.setVisibility(8);
                this.cDk.setVisibility(8);
            }
            this.cDo.setVisibility(8);
            if (this.cDm == null) {
                this.cDm = new g(this.czk.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cDp.setOnClick(this.cDm);
            }
            if (jVar != null && jVar.bsD() != null) {
                jD(jVar.bsD().grade.intValue());
                this.cDq = jVar.bsD().url;
            }
        }
    }

    protected void all() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.VW);
        this.cSO.rE().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void alm() {
        if (this.cSR > 0) {
            aj.c(this.cSm, d.f.frs_head_text_btn_bg, 1);
            this.cSm.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cSm.setText(String.format(this.abI.getString(d.j.miss_sign_days), Integer.valueOf(this.cSR)));
        } else {
            this.cSm.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.c(this.cSm, d.C0080d.cp_cont_e, 1);
            this.cSm.setText(this.abI.getString(d.j.signed));
        }
        this.cSm.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds28));
        this.cSm.setBackgroundDrawable(null);
        this.cSm.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aln() {
        aj.c(this.cSm, d.f.frs_head_attention_text_bg, 1);
        this.cSm.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds24));
        this.cSm.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.cSm, d.f.frs_attention_btn_bg_selector);
    }

    protected void alo() {
        if (this.cSj != null) {
            this.cSj.setText(am.u(this.mMemberNum));
        }
        if (this.cSk != null) {
            this.cSk.setText(am.u(this.cSP));
        }
        if (this.cSH != null && this.cSH.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.abI.getString(d.j.forum));
            }
            if (this.cxl != null) {
                this.cxl.setText(this.mForumName + this.abI.getString(d.j.forum));
            }
        }
        if (this.cSq != null && this.cSr != null) {
            if (this.cFm != null && this.cFm.bsO()) {
                if (com.baidu.tbadk.core.util.m.dD(this.cFm.bsR()) == 1 && !n.afa) {
                    this.cSq.setVisibility(8);
                } else {
                    this.cSq.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cFm.getGameName()) && !TextUtils.isEmpty(this.cFm.getGameName().trim())) {
                        this.cSr.setText(UtilHelper.getFixedText(this.cFm.getGameName(), 10));
                        String sJ = com.baidu.tieba.tbadkCore.util.b.sJ(this.cFm.bsR());
                        if (!StringUtils.isNull(sJ)) {
                            TiebaStatic.eventStat(this.abI.getPageActivity(), "game_show", "show", 1, "dev_id", sJ, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cSr.setText(this.abI.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.cSq.setVisibility(8);
            }
        }
        this.cDg.clearData();
        if (this.cFm != null && !v.v(this.cFm.bsP())) {
            List<com.baidu.tieba.tbadkCore.e> bsP = this.cFm.bsP();
            bb(bsP);
            this.cDg.ba(bsP);
        }
        this.cSw.setVisibility(8);
        this.cSJ.a(null, null);
        alp();
        alq();
        ala();
    }

    protected void alp() {
        this.cSF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cSF.startLoad(this.VW, 15, false);
    }

    protected void alq() {
        this.cDc.fp(false);
        if (this.cSq.getVisibility() == 0) {
            View findViewById = this.cSq.findViewById(d.g.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.cDc.fp(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cTe);
            if (this.cSz == null) {
                this.cSz = new PopupWindow(this.abI.getPageActivity());
                this.cSz.setContentView(this.cSA);
                this.cSz.setBackgroundDrawable(new BitmapDrawable());
                this.cSz.setOutsideTouchable(true);
                this.cSz.setFocusable(true);
                this.cSz.setWidth(this.abI.getResources().getDimensionPixelSize(d.e.ds228));
                this.cSz.setHeight(this.abI.getResources().getDimensionPixelSize(d.e.ds100));
                this.cSB = (TextView) this.cSA.findViewById(d.g.cur_experience);
                this.cSC = (TextView) this.cSA.findViewById(d.g.levelup_experience);
                a(this.cSB, this.cSC);
            }
            if (this.cSz.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cSz, this.abI.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cSB, this.cSC);
            if (iArr[1] - this.cSz.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cSz, this.abI.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cSz, this.bbf, 0, iArr[0], iArr[1] - this.cSz.getHeight());
            this.cSz.update();
            this.mHandler.postDelayed(this.cTe, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.abI.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            aj.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0080d.cp_cont_b, 1);
            aj.c(textView, d.C0080d.cp_cont_b, 1);
            aj.c(textView2, d.C0080d.cp_cont_b, 1);
            aj.c(textView3, d.C0080d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abI.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cSN) && !TextUtils.isEmpty(this.cSN.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cSN);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cd(d.C0080d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.abI);
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
                if (c.this.abI != null && c.this.abI.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.abI.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void alr() {
        View contentView;
        if (this.cSE == null) {
            this.cSE = new PopupWindow(this.abI.getPageActivity());
            contentView = LayoutInflater.from(this.abI.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.cSE.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.abI != null && c.this.abI.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cSE, c.this.abI.getPageActivity());
                        c.this.czk.cxJ = false;
                        com.baidu.tbadk.browser.a.a(c.this.abI.getPageActivity(), c.this.abI.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cSE.setWidth(this.abI.getResources().getDimensionPixelSize(d.e.ds300));
            this.cSE.setHeight(this.abI.getResources().getDimensionPixelSize(d.e.ds88));
            this.cSE.setBackgroundDrawable(new BitmapDrawable());
            this.cSE.setOutsideTouchable(true);
            this.cSE.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cSE);
                        c.this.czk.cxJ = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cSE.getContentView();
        }
        this.abI.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cSD.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cSE, this.bbf, 0, (iArr[0] - (this.cSE.getWidth() / 2)) + (this.cSD.getWidth() / 2), iArr[1] + this.cSD.getWidth());
        this.cSE.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cSY = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cSY) {
                this.cSn.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.j ajB = this.czk.ajB();
                if (ajB != null && ajB.aPU() != null) {
                    ajB.aPU().setUser_level(i);
                }
                this.cTi.setText(this.abI.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.cSn.setText(this.cSL);
                this.cTi.setText(this.abI.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.cSo.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, jE(this.mLevel)));
            if (this.cSY) {
                if (f >= 1.0f) {
                    a(this.czk.getBaseFragmentActivity(), this.cSo, this.cSZ, f);
                } else {
                    b(this.czk.getBaseFragmentActivity(), this.cSo, this.cSZ, f);
                }
            } else {
                a(this.czk.getBaseFragmentActivity(), this.cSo, this.cSZ, f);
            }
            this.cSZ = f;
        }
    }

    private int[] jE(int i) {
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
    protected void als() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void alt() {
        if (this.mMemberType != 0) {
            aj.c(this.cSD, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.cSD, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cDs);
    }

    public FrsEntranceStoryListWrapperView alu() {
        return this.cDp;
    }
}
