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
import com.baidu.tbadk.core.atomData.CommonEmotionManagerActivityConfig;
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
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c extends a {
    private String VE;
    private RelativeLayout aYg;
    private TextView cvj;
    private TextView cvk;
    private View cvl;
    private ImageView cvm;
    private g cvn;
    private FrsHeaderPraiseView cvp;
    private FrsEntranceStoryListWrapperView cvq;
    private String cvr;
    private int[] cvs = {d.g.icon_frs_emotion_level1, d.g.icon_frs_emotion_level2, d.g.icon_frs_emotion_level3, d.g.icon_frs_emotion_level4, d.g.icon_frs_emotion_level5};
    private CustomMessageListener cvt = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cIJ != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bDw.setVisibility(8);
                } else {
                    c.this.bDw.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cvo = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aYg = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.crw = fVar;
        this.abm = fVar.getPageContext();
        this.cIA = l.f(fVar.getPageContext().getPageActivity(), d.f.ds20);
        this.cIB = l.f(fVar.getPageContext().getPageActivity(), d.f.ds72);
        this.cIC = l.f(fVar.getPageContext().getPageActivity(), d.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.baq = aiJ();
        this.aYg = (RelativeLayout) this.baq.findViewById(d.h.container);
        this.aYg.setPadding(0, 0, 0, 0);
        this.cIU = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.baq.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, l.f(this.abm.getPageActivity(), d.f.ds60)).setMargins(0, l.f(this.abm.getPageActivity(), d.f.ds220), 0, 0);
        this.cIX = (ImageView) this.baq.findViewById(d.h.speed_icon);
        this.cvj = (TextView) this.baq.findViewById(d.h.member_image);
        this.cvk = (TextView) this.baq.findViewById(d.h.post_image);
        this.cIH = (TextView) this.baq.findViewById(d.h.level_name);
        this.cJC = (TextView) this.baq.findViewById(d.h.level);
        this.cIF = (TextView) this.baq.findViewById(d.h.tv_love);
        this.cIG = (TextView) this.baq.findViewById(d.h.tv_sign);
        this.cIG.setContentDescription(fVar.getResources().getString(d.l.sign));
        this.cII = (ImageView) this.baq.findViewById(d.h.love_level_top);
        this.cID = (TextView) this.baq.findViewById(d.h.member_num_text);
        this.cIE = (TextView) this.baq.findViewById(d.h.post_num_text);
        this.cIZ = (BarImageView) this.baq.findViewById(d.h.frs_image);
        this.cpy = (TextView) this.baq.findViewById(d.h.forum_name);
        this.cIZ.setPageId(this.crw.getUniqueId());
        this.cIZ.setContentDescription(fVar.getResources().getString(d.l.bar_header));
        this.cIZ.setGifIconSupport(false);
        this.cIZ.setDrawerType(0);
        this.cIJ = LayoutInflater.from(this.crw.getPageContext().getPageActivity()).inflate(d.j.frs_header_extra_entelechy, (ViewGroup) null);
        aiz();
        aiG();
        aiF();
        this.cIK = (ViewGroup) this.cIJ.findViewById(d.h.frs_header_games);
        this.cIL = (TextView) this.cIJ.findViewById(d.h.top_item_title);
        this.cIQ = (LinearLayout) this.cIJ.findViewById(d.h.frs_present_root);
        this.bDw = this.cIJ.findViewById(d.h.divider_bottom);
        this.cvl = this.cIJ.findViewById(d.h.stroy_divider_bottom);
        this.cJd = new e(this.abm, this.cIJ);
        this.cJc = new com.baidu.tieba.frs.g.b(this.abm);
        this.cIM = (ViewGroup) this.cIJ.findViewById(d.h.frs_headline);
        this.cIN = (TextView) this.cIM.findViewById(d.h.headline_title);
        this.cIO = (TextView) this.cIM.findViewById(d.h.headline_text);
        this.cIP = (TbImageView) this.cIM.findViewById(d.h.headline_image);
        this.cIP.setPageId(this.crw.getUniqueId());
        this.cIM.setVisibility(8);
        this.cJB = this.baq.findViewById(d.h.level_container);
        this.cJA = (RelativeLayout) this.baq.findViewById(d.h.has_focused_container);
        this.cJz = (RelativeLayout) this.baq.findViewById(d.h.not_focused_container);
        this.cJD = (RelativeLayout) this.baq.findViewById(d.h.head_content_container);
        this.cvm = (ImageView) this.baq.findViewById(d.h.single_bar_level);
        this.cvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.abm.getPageActivity(), (String) null, true, 11003)));
                } else if (!j.hh()) {
                    l.showToast(c.this.abm.getPageActivity(), d.l.neterror);
                } else if (!StringUtils.isNull(c.this.cvr) && !StringUtils.isNull(c.this.mForumId)) {
                    c.this.abm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(c.this.abm.getPageActivity(), c.this.cvr + "?forum_id=" + c.this.mForumId)));
                }
            }
        });
        aiH();
        this.crw.registerListener(this.cvt);
    }

    private void aiF() {
        this.cvp = (FrsHeaderPraiseView) this.cIJ.findViewById(d.h.frs_praise_layout);
    }

    private void aiG() {
        this.cvq = (FrsEntranceStoryListWrapperView) this.cIJ.findViewById(d.h.listview_story_wrapper_view);
        this.cvq.m(this.crw.getPageContext());
    }

    private void aiH() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ah.class);
        if (runTask != null && runTask.getData() != null) {
            this.cJe = (ah) runTask.getData();
            this.cJe.a(this.abm, this.baq, 1, false, this.crw.getUniqueId());
            this.cJe.hide();
        }
    }

    private void aiI() {
        final m bpT = this.cxc.bpT();
        if (bpT != null && this.cxc.aMU() != null) {
            final String id = this.cxc.aMU().getId();
            final String name = this.cxc.aMU().getName();
            if (this.cJx.add(bpT.pw())) {
                a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bpT.pw(), id, name, null);
                b.cd("obj_url", bpT.getUrl());
                b.save();
            }
            this.cIM.setVisibility(0);
            this.cIN.setText(bpT.getText());
            this.cIO.setText(bpT.getTitle());
            this.cIP.c(bpT.pv(), 10, false);
            this.cIM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0126a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bpT.pw(), id, name, null);
                    b2.cd("obj_url", bpT.getUrl());
                    b2.save();
                    av.vA().c(c.this.crw.getPageContext(), new String[]{bpT.getUrl()});
                }
            });
        }
    }

    protected View aiJ() {
        return LayoutInflater.from(this.crw.getPageContext().getPageActivity()).inflate(d.j.frs_normal_header, (ViewGroup) null);
    }

    private void jn(int i) {
        if (i <= 0 || i > 5) {
            this.cvm.setVisibility(8);
            this.cpy.setMaxWidth(l.f(this.abm.getPageActivity(), d.f.ds370));
            return;
        }
        this.cvm.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.cvs[i - 1]);
        this.cvm.setImageDrawable(drawable);
        this.cpy.setMaxWidth((l.f(this.abm.getPageActivity(), d.f.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.cvm.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cIZ.setOnClickListener(onClickListener);
        this.cpy.setOnClickListener(onClickListener);
        this.cIG.setOnClickListener(onClickListener);
        this.cIF.setOnClickListener(onClickListener);
        this.cJB.setOnClickListener(onClickListener);
        if (this.cIK != null) {
            this.cIK.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.abm.getLayoutMode().ah(i == 1);
        this.abm.getLayoutMode().t(this.baq);
        this.abm.getLayoutMode().t(this.cIU);
        this.abm.getLayoutMode().t(this.cIJ);
        if (this.cJr) {
            ki(1);
        } else {
            ki(0);
        }
        this.cIZ.invalidate();
        aj.k(this.aYg, d.e.cp_bg_line_d);
        aj.k(this.bDw, d.e.cp_bg_line_c);
        aj.i(this.cJC, d.e.cp_cont_f);
        aj.i(this.cIH, d.e.cp_cont_f);
        aj.i(this.cvj, d.e.cp_cont_d);
        aj.i(this.cID, d.e.cp_cont_b);
        aj.i(this.cvk, d.e.cp_cont_d);
        aj.i(this.cIE, d.e.cp_cont_b);
        if (this.cvq != null) {
            aj.k(this.cvq, d.e.cp_bg_line_d);
        }
        aiK();
        if (this.cIK != null) {
            aj.j(this.cIK, d.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.cIX, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cIX, d.g.icon_sml_speed_gray);
        }
        if (this.cJd != null) {
            this.cJd.changeSkinType(i);
        }
        if (this.cJe != null) {
            this.cJe.changeSkinType(i);
        }
        if (this.cJa != null) {
            this.cJa.dD(i);
        }
        Iterator<TbImageView> it = this.cvo.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aiB();
        aj.j(this.cIM, d.g.home_thread_card_item_bg);
        aj.i(this.cpy, d.e.cp_cont_b);
        if (this.cvf != null) {
            com.baidu.tbadk.n.a.a(this.crw.getPageContext(), this.cvf);
        }
        if (this.cvq.getVisibility() == 0) {
            this.cvq.changeSkinType(i);
            aj.k(this.cvl, d.e.cp_bg_line_c);
        }
        if (this.cvp.getVisibility() == 0) {
            this.cvp.changeSkinType(i);
        }
    }

    protected void aiK() {
        Drawable drawable = aj.getDrawable(d.g.icon_add_follow_blue_selector);
        int f = l.f(this.abm.getPageActivity(), d.f.ds8);
        int f2 = l.f(this.abm.getPageActivity(), d.f.ds18);
        drawable.setBounds(0, f, f2, f2);
        this.cIF.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aj.c(this.cIF, d.g.frs_head_attention_text_bg, 1);
        aj.j(this.cIF, d.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, i iVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cJj = forumData.getPost_num();
            this.cJg = forumData.getTag_color();
            this.VE = forumData.getImage_url();
            this.cJf = forumData.getLevelName();
            this.buH = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cJk = forumData.getSignData().count_sign_num;
                this.cJl = forumData.getSignData().miss_sign_num;
            }
            this.cJm = forumData.getCurScore();
            this.cHS = forumData.getLevelupScore();
            this.cJb = forumData.getBadgeData();
            this.cIR = forumData.getTopCode();
            this.cIS = forumData.getNewsInfo();
            this.cJh = forumData.getAccelerateContent();
            this.cxc = iVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.baq.setVisibility(8);
            } else {
                this.baq.setVisibility(0);
            }
            this.cJi = new bh();
            aiL();
            aiO();
            aiI();
            if (this.cxc != null) {
                this.cvq.b(this.cxc.bpm(), this.crw.getForumId(), "0");
            } else {
                this.cvq.setVisibility(8);
                this.cvl.setVisibility(8);
            }
            this.cvp.setVisibility(8);
            if (this.cvn == null) {
                this.cvn = new g(this.crw.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cvq.setOnClick(this.cvn);
            }
            if (iVar != null && iVar.bpo() != null) {
                jn(iVar.bpo().grade.intValue());
                this.cvr = iVar.bpo().url;
            }
        }
    }

    protected void aiL() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.VE);
        this.cJi.ry().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiM() {
        if (this.cJl > 0) {
            aj.c(this.cIG, d.g.frs_head_text_btn_bg, 1);
            this.cIG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cIG.setText(String.format(this.abm.getString(d.l.miss_sign_days), Integer.valueOf(this.cJl)));
        } else {
            this.cIG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.c(this.cIG, d.e.cp_cont_e, 1);
            this.cIG.setText(this.abm.getString(d.l.signed));
        }
        this.cIG.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.f.ds28));
        this.cIG.setBackgroundDrawable(null);
        this.cIG.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiN() {
        aj.c(this.cIG, d.g.frs_head_attention_text_bg, 1);
        this.cIG.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.f.ds24));
        this.cIG.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.cIG, d.g.frs_attention_btn_bg_selector);
    }

    protected void aiO() {
        if (this.cID != null) {
            this.cID.setText(am.u(this.mMemberNum));
        }
        if (this.cIE != null) {
            this.cIE.setText(am.u(this.cJj));
        }
        if (this.cJb != null && this.cJb.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.abm.getString(d.l.forum));
            }
            if (this.cpy != null) {
                this.cpy.setText(this.mForumName + this.abm.getString(d.l.forum));
            }
        }
        if (this.cIK != null && this.cIL != null) {
            if (this.cxc != null && this.cxc.bpz()) {
                if (com.baidu.tbadk.core.util.m.dx(this.cxc.bpC()) == 1 && !n.aeF) {
                    this.cIK.setVisibility(8);
                } else {
                    this.cIK.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cxc.getGameName()) && !TextUtils.isEmpty(this.cxc.getGameName().trim())) {
                        this.cIL.setText(UtilHelper.getFixedText(this.cxc.getGameName(), 10));
                        String rV = com.baidu.tieba.tbadkCore.util.b.rV(this.cxc.bpC());
                        if (!StringUtils.isNull(rV)) {
                            TiebaStatic.eventStat(this.abm.getPageActivity(), "game_show", "show", 1, "dev_id", rV, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cIL.setText(this.abm.getResources().getString(d.l.frsgame_title));
                    }
                }
            } else {
                this.cIK.setVisibility(8);
            }
        }
        this.cvh.clearData();
        if (this.cxc != null && !v.u(this.cxc.bpA())) {
            List<com.baidu.tieba.tbadkCore.e> bpA = this.cxc.bpA();
            aY(bpA);
            this.cvh.aX(bpA);
        }
        this.cIQ.setVisibility(8);
        this.cJd.a(null, null);
        aiP();
        aiQ();
        aiA();
    }

    protected void aiP() {
        this.cIZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cIZ.c(this.VE, 15, false);
    }

    protected void aiQ() {
        this.cvd.fk(false);
        if (this.cIK.getVisibility() == 0) {
            View findViewById = this.cIK.findViewById(d.h.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.cvd.fk(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void g(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cJy);
            if (this.cIT == null) {
                this.cIT = new PopupWindow(this.abm.getPageActivity());
                this.cIT.setContentView(this.cIU);
                this.cIT.setBackgroundDrawable(new BitmapDrawable());
                this.cIT.setOutsideTouchable(true);
                this.cIT.setFocusable(true);
                this.cIT.setWidth(this.abm.getResources().getDimensionPixelSize(d.f.ds228));
                this.cIT.setHeight(this.abm.getResources().getDimensionPixelSize(d.f.ds100));
                this.cIV = (TextView) this.cIU.findViewById(d.h.cur_experience);
                this.cIW = (TextView) this.cIU.findViewById(d.h.levelup_experience);
                a(this.cIV, this.cIW);
            }
            if (this.cIT.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cIT, this.abm.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cIV, this.cIW);
            if (iArr[1] - this.cIT.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cIT, this.abm.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cIT, this.baq, 0, iArr[0], iArr[1] - this.cIT.getHeight());
            this.cIT.update();
            this.mHandler.postDelayed(this.cJy, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.abm.getContext()).inflate(d.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.h.speed_tip);
            aj.c((TextView) inflate.findViewById(d.h.experience_txt), d.e.cp_cont_b, 1);
            aj.c(textView, d.e.cp_cont_b, 1);
            aj.c(textView2, d.e.cp_cont_b, 1);
            aj.c(textView3, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abm.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cJh) && !TextUtils.isEmpty(this.cJh.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cJh);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cd(d.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.abm);
            aVar.tb();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (c.this.abm != null && c.this.abm.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.abm.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiR() {
        View contentView;
        if (this.cIY == null) {
            this.cIY = new PopupWindow(this.abm.getPageActivity());
            contentView = LayoutInflater.from(this.abm.getContext()).inflate(d.j.speed_tip, (ViewGroup) null);
            this.cIY.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.abm != null && c.this.abm.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cIY, c.this.abm.getPageActivity());
                        c.this.crw.cpW = false;
                        com.baidu.tbadk.browser.a.a(c.this.abm.getPageActivity(), c.this.abm.getResources().getString(d.l.experion_speed), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cIY.setWidth(this.abm.getResources().getDimensionPixelSize(d.f.ds300));
            this.cIY.setHeight(this.abm.getResources().getDimensionPixelSize(d.f.ds88));
            this.cIY.setBackgroundDrawable(new BitmapDrawable());
            this.cIY.setOutsideTouchable(true);
            this.cIY.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cIY);
                        c.this.crw.cpW = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cIY.getContentView();
        }
        this.abm.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cIX.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cIY, this.baq, 0, (iArr[0] - (this.cIY.getWidth() / 2)) + (this.cIX.getWidth() / 2), iArr[1] + this.cIX.getWidth());
        this.cIY.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cJs = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cJs) {
                this.cIH.setText(d.l.level_up);
                if (f >= 1.0f) {
                    i = this.buH;
                } else {
                    i = this.buH + 1;
                }
                i ahf = this.crw.ahf();
                if (ahf != null && ahf.aMU() != null) {
                    ahf.aMU().setUser_level(i);
                }
                this.cJC.setText(this.abm.getResources().getString(d.l.lv_num, Integer.valueOf(i)));
            } else {
                this.cIH.setText(this.cJf);
                this.cJC.setText(this.abm.getResources().getString(d.l.lv_num, Integer.valueOf(this.buH)));
            }
            this.cII.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, jo(this.buH)));
            if (this.cJs) {
                if (f >= 1.0f) {
                    a(this.crw.getBaseFragmentActivity(), this.cII, this.cJt, f);
                } else {
                    b(this.crw.getBaseFragmentActivity(), this.cII, this.cJt, f);
                }
            } else {
                a(this.crw.getBaseFragmentActivity(), this.cII, this.cJt, f);
            }
            this.cJt = f;
        }
    }

    private int[] jo(int i) {
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
    protected void aiS() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiT() {
        if (this.mMemberType != 0) {
            aj.c(this.cIX, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cIX, d.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cvt);
    }

    public FrsEntranceStoryListWrapperView aiU() {
        return this.cvq;
    }
}
