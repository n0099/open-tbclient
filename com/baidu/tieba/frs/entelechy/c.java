package com.baidu.tieba.frs.entelechy;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends a {
    private RelativeLayout aTp;
    private TextView bXA;
    private FrsHeaderPraiseView bXC;
    private TextView bXz;
    private String mImageUrl;
    private CustomMessageListener bXD = new d(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bXB = new ArrayList<>();

    public c(r rVar, String str, String str2, int i) {
        this.aTp = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bVm = rVar;
        this.aas = rVar.getPageContext();
        this.cij = k.g(rVar.getPageContext().getPageActivity(), w.f.ds20);
        this.cik = k.g(rVar.getPageContext().getPageActivity(), w.f.ds72);
        this.cil = k.g(rVar.getPageContext().getPageActivity(), w.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aVm = abr();
        this.aTp = (RelativeLayout) this.aVm.findViewById(w.h.container);
        this.aTp.setPadding(0, 0, 0, 0);
        this.ciE = LayoutInflater.from(rVar.getPageContext().getPageActivity()).inflate(w.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aVm.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, k.g(this.aas.getPageActivity(), w.f.ds60)).setMargins(0, k.g(this.aas.getPageActivity(), w.f.ds220), 0, 0);
        this.ciH = (ImageView) this.aVm.findViewById(w.h.speed_icon);
        this.bXz = (TextView) this.aVm.findViewById(w.h.member_image);
        this.bXA = (TextView) this.aVm.findViewById(w.h.post_image);
        this.ciq = (TextView) this.aVm.findViewById(w.h.level_name);
        this.cjm = (TextView) this.aVm.findViewById(w.h.level);
        this.cio = (TextView) this.aVm.findViewById(w.h.tv_love);
        this.cip = (TextView) this.aVm.findViewById(w.h.tv_sign);
        this.cip.setContentDescription(rVar.getResources().getString(w.l.sign));
        this.cir = (ImageView) this.aVm.findViewById(w.h.love_level_top);
        this.cim = (TextView) this.aVm.findViewById(w.h.member_num_text);
        this.cin = (TextView) this.aVm.findViewById(w.h.post_num_text);
        this.ciJ = (BarImageView) this.aVm.findViewById(w.h.frs_image);
        this.ciJ.setPageId(this.bVm.getUniqueId());
        this.ciJ.setContentDescription(rVar.getResources().getString(w.l.bar_header));
        this.ciJ.setGifIconSupport(false);
        this.ciJ.setDrawerType(0);
        this.cis = LayoutInflater.from(this.bVm.getPageContext().getPageActivity()).inflate(w.j.frs_header_extra_entelechy, (ViewGroup) null);
        abj();
        abo();
        this.cit = (ViewGroup) this.cis.findViewById(w.h.frs_header_games);
        this.ciu = (TextView) this.cis.findViewById(w.h.top_item_title);
        this.ciz = (LinearLayout) this.cis.findViewById(w.h.frs_header_enter_root);
        this.ciA = (LinearLayout) this.cis.findViewById(w.h.frs_present_root);
        this.bqy = this.cis.findViewById(w.h.divider_bottom);
        this.ciN = new com.baidu.tieba.frs.view.j(this.aas, this.cis);
        this.ciM = new com.baidu.tieba.frs.e.b(this.aas);
        this.civ = (ViewGroup) this.cis.findViewById(w.h.frs_headline);
        this.ciw = (TextView) this.civ.findViewById(w.h.headline_title);
        this.cix = (TextView) this.civ.findViewById(w.h.headline_text);
        this.ciy = (TbImageView) this.civ.findViewById(w.h.headline_image);
        this.ciy.setPageId(this.bVm.getUniqueId());
        this.civ.setVisibility(8);
        this.cjl = this.aVm.findViewById(w.h.level_container);
        this.cjk = (RelativeLayout) this.aVm.findViewById(w.h.has_focused_container);
        this.cjj = (RelativeLayout) this.aVm.findViewById(w.h.not_focused_container);
        this.cjn = (RelativeLayout) this.aVm.findViewById(w.h.head_content_container);
        abp();
        this.bVm.registerListener(this.bXD);
    }

    private void abo() {
        this.bXC = (FrsHeaderPraiseView) this.cis.findViewById(w.h.frs_praise_layout);
    }

    private void abp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), bw.class);
        if (runTask != null && runTask.getData() != null) {
            this.ciO = (bw) runTask.getData();
            this.ciO.a(this.aas, this.aVm, 1, false, this.bVm.getUniqueId());
            this.ciO.hide();
        }
    }

    private void abq() {
        m bgN = this.bZb.bgN();
        if (bgN != null && this.bZb.aIz() != null) {
            String id = this.bZb.aIz().getId();
            String name = this.bZb.aIz().getName();
            if (this.cjh.add(bgN.px())) {
                a.C0082a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bgN.px(), id, name, null);
                a.cb("obj_url", bgN.getUrl());
                a.save();
            }
            this.civ.setVisibility(0);
            this.ciw.setText(bgN.getText());
            this.cix.setText(bgN.getTitle());
            this.ciy.c(bgN.pw(), 10, false);
            this.civ.setOnClickListener(new e(this, bgN, id, name));
        }
    }

    protected View abr() {
        return LayoutInflater.from(this.bVm.getPageContext().getPageActivity()).inflate(w.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.ciJ.setOnClickListener(onClickListener);
        this.cip.setOnClickListener(onClickListener);
        this.cio.setOnClickListener(onClickListener);
        this.cjl.setOnClickListener(onClickListener);
        if (this.cit != null) {
            this.cit.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.aas.getLayoutMode().ah(i == 1);
        this.aas.getLayoutMode().t(this.aVm);
        this.aas.getLayoutMode().t(this.ciE);
        this.aas.getLayoutMode().t(this.cis);
        if (this.cjb) {
            jh(1);
        } else {
            jh(0);
        }
        this.ciJ.invalidate();
        aq.k(this.aTp, w.e.cp_bg_line_d);
        aq.k(this.bqy, w.e.cp_bg_line_c);
        aq.i(this.cjm, w.e.cp_cont_f);
        aq.i(this.ciq, w.e.cp_cont_f);
        aq.i(this.bXz, w.e.cp_cont_d);
        aq.i(this.cim, w.e.cp_cont_b);
        aq.i(this.bXA, w.e.cp_cont_d);
        aq.i(this.cin, w.e.cp_cont_b);
        abs();
        if (this.cit != null) {
            aq.j(this.cit, w.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aq.c(this.ciH, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.ciH, w.g.icon_sml_speed_gray);
        }
        if (this.ciN != null) {
            this.ciN.changeSkinType(i);
        }
        if (this.ciO != null) {
            this.ciO.changeSkinType(i);
        }
        if (this.ciK != null) {
            this.ciK.dn(i);
        }
        Iterator<TbImageView> it = this.bXB.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        abl();
        aq.j(this.civ, w.g.home_thread_card_item_bg);
        if (this.bXy != null) {
            com.baidu.tbadk.m.a.a(this.bVm.getPageContext(), this.bXy);
        }
        if (this.bXC.getVisibility() == 0) {
            this.bXC.changeSkinType(i);
        }
    }

    protected void abs() {
        Drawable drawable = aq.getDrawable(w.g.icon_add_follow_blue_selector);
        int g = k.g(this.aas.getPageActivity(), w.f.ds8);
        int g2 = k.g(this.aas.getPageActivity(), w.f.ds18);
        drawable.setBounds(0, g, g2, g2);
        this.cio.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aq.c(this.cio, w.g.frs_head_attention_text_bg, 1);
        aq.j(this.cio, w.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, n nVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ciT = forumData.getPost_num();
            this.ciQ = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.ciP = forumData.getLevelName();
            this.biB = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ciU = forumData.getSignData().count_sign_num;
                this.ciV = forumData.getSignData().miss_sign_num;
            }
            this.ciW = forumData.getCurScore();
            this.chM = forumData.getLevelupScore();
            this.ciL = forumData.getBadgeData();
            this.ciB = forumData.getTopCode();
            this.ciC = forumData.getNewsInfo();
            this.ciR = forumData.getAccelerateContent();
            this.bZb = nVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aVm.setVisibility(8);
            } else {
                this.aVm.setVisibility(0);
            }
            this.ciS = new bl();
            abt();
            abw();
            abq();
            if (this.bZb != null) {
                this.bXC.setData(this.bZb.bgi());
            } else {
                this.bXC.setVisibility(8);
            }
        }
    }

    protected void abt() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.ciS.rE().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void abu() {
        if (this.ciV > 0) {
            aq.c(this.cip, w.g.frs_head_text_btn_bg, 1);
            this.cip.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cip.setText(String.format(this.aas.getString(w.l.miss_sign_days), Integer.valueOf(this.ciV)));
        } else {
            this.cip.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.c(this.cip, w.e.cp_cont_e, 1);
            this.cip.setText(this.aas.getString(w.l.signed));
        }
        this.cip.setTextSize(0, k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds28));
        this.cip.setBackgroundDrawable(null);
        this.cip.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void abv() {
        aq.c(this.cip, w.g.frs_head_attention_text_bg, 1);
        this.cip.setTextSize(0, k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds24));
        this.cip.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.j(this.cip, w.g.frs_attention_btn_bg_selector);
    }

    protected void abw() {
        if (this.cim != null) {
            this.cim.setText(au.t(this.mMemberNum));
        }
        if (this.cin != null) {
            this.cin.setText(au.t(this.ciT));
        }
        if (this.bPO != null) {
            if (this.ciL != null && this.ciL.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.bPO.setText(String.valueOf(this.mForumName) + this.aas.getString(w.l.forum));
            }
        }
        if (this.cit != null && this.ciu != null) {
            if (this.bZb != null && this.bZb.bgt()) {
                if (com.baidu.tbadk.core.util.m.dh(this.bZb.bgw()) == 1 && !p.adB) {
                    this.cit.setVisibility(8);
                } else {
                    this.cit.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bZb.getGameName()) && !TextUtils.isEmpty(this.bZb.getGameName().trim())) {
                        this.ciu.setText(UtilHelper.getFixedText(this.bZb.getGameName(), 10));
                        String qt = com.baidu.tieba.tbadkCore.util.m.qt(this.bZb.bgw());
                        if (!StringUtils.isNull(qt)) {
                            TiebaStatic.eventStat(this.aas.getPageActivity(), "game_show", "show", 1, "dev_id", qt, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.ciu.setText(this.aas.getResources().getString(w.l.frsgame_title));
                    }
                }
            } else {
                this.cit.setVisibility(8);
            }
        }
        if (this.bZb != null && !x.r(this.bZb.bgu())) {
            List<com.baidu.tieba.tbadkCore.g> bgu = this.bZb.bgu();
            at(bgu);
            int size = bgu.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.ciz.setVisibility(0);
                this.ciz.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = bgu.get(i2);
                    if (gVar != null) {
                        String jb = jb(gVar.aAz());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.frs_header_top_item, (ViewGroup) null);
                        TextView textView = (TextView) viewGroup.findViewById(w.h.top_item_title);
                        TextView textView2 = (TextView) viewGroup.findViewById(w.h.top_item_rank);
                        textView.setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(w.h.top_item_type)).setText(jb);
                        if (gVar.aJc() != 0) {
                            textView2.setVisibility(0);
                            if (gVar.aJc() == -1) {
                                textView2.setText(this.aas.getString(w.l.no_rank));
                            } else if (gVar.aJc() > 999) {
                                textView2.setText(this.aas.getString(w.l.rang_orer_thousand));
                            } else {
                                textView2.setText(String.valueOf(this.aas.getString(w.l.rang_identify)) + String.valueOf(gVar.aJc()));
                            }
                            if (!StringUtils.isNull(gVar.getTitle())) {
                                textView.setText(au.d(gVar.getTitle(), 30, "..."));
                            }
                        } else {
                            textView2.setVisibility(8);
                        }
                        ai(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.cjo);
                        this.ciz.addView(viewGroup);
                        if (this.cjh.add(gVar.bgg())) {
                            a.C0082a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bgg(), this.bVm.getForumId(), this.bVm.getForumName(), null);
                            a.cb("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.ciz.setVisibility(8);
            }
        } else {
            this.ciz.setVisibility(8);
        }
        this.ciA.setVisibility(8);
        this.ciN.a(null, null);
        abx();
        aby();
        abk();
    }

    protected void abx() {
        this.ciJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ciJ.c(this.mImageUrl, 15, false);
    }

    protected void aby() {
        ViewGroup aen;
        View aeo;
        View findViewById;
        this.bXw.eD(false);
        if (this.cit.getVisibility() == 0) {
            View findViewById2 = this.cit.findViewById(w.h.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.cit.getVisibility() == 8 && this.ciz.getVisibility() == 0) {
            if (this.ciz.getChildCount() > 0 && (findViewById = ((ViewGroup) this.ciz.getChildAt(0)).findViewById(w.h.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.ciz.getVisibility() == 8 && (aen = this.ciN.aen()) != null && aen.getVisibility() == 0 && (aeo = this.ciN.aeo()) != null) {
            aeo.setVisibility(8);
        } else {
            this.bXw.eD(true);
        }
    }

    private String jb(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(w.l.frs_forum_member_icon_text);
        }
        return str;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cji);
            if (this.ciD == null) {
                this.ciD = new PopupWindow(this.aas.getPageActivity());
                this.ciD.setContentView(this.ciE);
                this.ciD.setBackgroundDrawable(new BitmapDrawable());
                this.ciD.setOutsideTouchable(true);
                this.ciD.setFocusable(true);
                this.ciD.setWidth(this.aas.getResources().getDimensionPixelSize(w.f.ds228));
                this.ciD.setHeight(this.aas.getResources().getDimensionPixelSize(w.f.ds100));
                this.ciF = (TextView) this.ciE.findViewById(w.h.cur_experience);
                this.ciG = (TextView) this.ciE.findViewById(w.h.levelup_experience);
                a(this.ciF, this.ciG);
            }
            if (this.ciD.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.ciD, this.aas.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.ciF, this.ciG);
            if (iArr[1] - this.ciD.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.ciD, this.aas.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.ciD, this.aVm, 0, iArr[0], iArr[1] - this.ciD.getHeight());
            this.ciD.update();
            this.mHandler.postDelayed(this.cji, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aas.getContext()).inflate(w.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(w.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(w.h.speed_tip);
            aq.c((TextView) inflate.findViewById(w.h.experience_txt), w.e.cp_cont_b, 1);
            aq.c(textView, w.e.cp_cont_b, 1);
            aq.c(textView2, w.e.cp_cont_b, 1);
            aq.c(textView3, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aas.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.ciR) && !TextUtils.isEmpty(this.ciR.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ciR);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bZ(w.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aas);
            aVar.tc();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(w.l.cancel, new f(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(w.l.open_now, new g(this));
    }

    @Override // com.baidu.tieba.frs.view.b
    public void abz() {
        View contentView;
        if (this.ciI == null) {
            this.ciI = new PopupWindow(this.aas.getPageActivity());
            contentView = LayoutInflater.from(this.aas.getContext()).inflate(w.j.speed_tip, (ViewGroup) null);
            this.ciI.setContentView(contentView);
            contentView.setOnClickListener(new h(this));
            this.ciI.setWidth(this.aas.getResources().getDimensionPixelSize(w.f.ds300));
            this.ciI.setHeight(this.aas.getResources().getDimensionPixelSize(w.f.ds88));
            this.ciI.setBackgroundDrawable(new BitmapDrawable());
            this.ciI.setOutsideTouchable(true);
            this.ciI.setTouchInterceptor(new i(this));
        } else {
            contentView = this.ciI.getContentView();
        }
        this.aas.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.ciH.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.ciI, this.aVm, 0, (iArr[0] - (this.ciI.getWidth() / 2)) + (this.ciH.getWidth() / 2), iArr[1] + this.ciH.getWidth());
        this.ciI.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cjc = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(w.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cjc) {
                this.ciq.setText(w.l.level_up);
                if (f >= 1.0f) {
                    i = this.biB;
                } else {
                    i = this.biB + 1;
                }
                n aau = this.bVm.aau();
                if (aau != null && aau.aIz() != null) {
                    aau.aIz().setUser_level(i);
                }
                this.cjm.setText(this.aas.getResources().getString(w.l.lv_num, Integer.valueOf(i)));
            } else {
                this.ciq.setText(this.ciP);
                this.cjm.setText(this.aas.getResources().getString(w.l.lv_num, Integer.valueOf(this.biB)));
            }
            this.cir.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, is(this.biB)));
            if (this.cjc) {
                if (f >= 1.0f) {
                    a(this.bVm.getBaseFragmentActivity(), this.cir, this.cjd, f);
                } else {
                    b(this.bVm.getBaseFragmentActivity(), this.cir, this.cjd, f);
                }
            } else {
                a(this.bVm.getBaseFragmentActivity(), this.cir, this.cjd, f);
            }
            this.cjd = f;
        }
    }

    private int[] is(int i) {
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
    protected void abA() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void abB() {
        if (this.mMemberType != 0) {
            aq.c(this.ciH, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.ciH, w.g.icon_sml_speed_gray);
        }
    }
}
