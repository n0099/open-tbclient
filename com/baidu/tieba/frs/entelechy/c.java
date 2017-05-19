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
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends a {
    private RelativeLayout aVN;
    private TextView bRJ;
    private TextView bRK;
    private String mImageUrl;
    private CustomMessageListener bRM = new d(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bRL = new ArrayList<>();

    public c(r rVar, String str, String str2, int i) {
        this.aVN = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bPw = rVar;
        this.aat = rVar.getPageContext();
        this.cbV = k.g(rVar.getPageContext().getPageActivity(), w.f.ds20);
        this.cbW = k.g(rVar.getPageContext().getPageActivity(), w.f.ds72);
        this.cbX = k.g(rVar.getPageContext().getPageActivity(), w.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aXK = aao();
        this.aVN = (RelativeLayout) this.aXK.findViewById(w.h.container);
        this.aVN.setPadding(0, 0, 0, 0);
        this.ccq = LayoutInflater.from(rVar.getPageContext().getPageActivity()).inflate(w.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aXK.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, k.g(this.aat.getPageActivity(), w.f.ds60)).setMargins(0, k.g(this.aat.getPageActivity(), w.f.ds220), 0, 0);
        this.cct = (ImageView) this.aXK.findViewById(w.h.speed_icon);
        this.bRJ = (TextView) this.aXK.findViewById(w.h.member_image);
        this.bRK = (TextView) this.aXK.findViewById(w.h.post_image);
        this.ccc = (TextView) this.aXK.findViewById(w.h.level_name);
        this.ccY = (TextView) this.aXK.findViewById(w.h.level);
        this.cca = (TextView) this.aXK.findViewById(w.h.tv_love);
        this.ccb = (TextView) this.aXK.findViewById(w.h.tv_sign);
        this.ccb.setContentDescription(rVar.getResources().getString(w.l.sign));
        this.ccd = (ImageView) this.aXK.findViewById(w.h.love_level_top);
        this.cbY = (TextView) this.aXK.findViewById(w.h.member_num_text);
        this.cbZ = (TextView) this.aXK.findViewById(w.h.post_num_text);
        this.ccv = (BarImageView) this.aXK.findViewById(w.h.frs_image);
        this.ccv.setPageId(this.bPw.getUniqueId());
        this.ccv.setContentDescription(rVar.getResources().getString(w.l.bar_header));
        this.ccv.setGifIconSupport(false);
        this.ccv.setDrawerType(0);
        this.cce = LayoutInflater.from(this.bPw.getPageContext().getPageActivity()).inflate(w.j.frs_header_extra_entelechy, (ViewGroup) null);
        aah();
        this.ccf = (ViewGroup) this.cce.findViewById(w.h.frs_header_games);
        this.ccg = (TextView) this.cce.findViewById(w.h.top_item_title);
        this.ccl = (LinearLayout) this.cce.findViewById(w.h.frs_header_enter_root);
        this.ccm = (LinearLayout) this.cce.findViewById(w.h.frs_present_root);
        this.bpr = this.cce.findViewById(w.h.divider_bottom);
        this.ccz = new com.baidu.tieba.frs.view.j(this.aat, this.cce);
        this.ccy = new com.baidu.tieba.frs.d.b(this.aat);
        this.cch = (ViewGroup) this.cce.findViewById(w.h.frs_headline);
        this.cci = (TextView) this.cch.findViewById(w.h.headline_title);
        this.ccj = (TextView) this.cch.findViewById(w.h.headline_text);
        this.cck = (TbImageView) this.cch.findViewById(w.h.headline_image);
        this.cck.setPageId(this.bPw.getUniqueId());
        this.cch.setVisibility(8);
        this.ccX = this.aXK.findViewById(w.h.level_container);
        this.ccW = (RelativeLayout) this.aXK.findViewById(w.h.has_focused_container);
        this.ccV = (RelativeLayout) this.aXK.findViewById(w.h.not_focused_container);
        this.ccZ = (RelativeLayout) this.aXK.findViewById(w.h.head_content_container);
        aam();
        this.bPw.registerListener(this.bRM);
    }

    private void aam() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), bv.class);
        if (runTask != null && runTask.getData() != null) {
            this.ccA = (bv) runTask.getData();
            this.ccA.a(this.aat, this.aXK, 1, false, this.bPw.getUniqueId());
            this.ccA.hide();
        }
    }

    private void aan() {
        m bfs = this.bTj.bfs();
        if (bfs != null && this.bTj.aHE() != null) {
            String id = this.bTj.aHE().getId();
            String name = this.bTj.aHE().getName();
            if (this.ccT.add(bfs.pF())) {
                a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bfs.pF(), id, name, null);
                a.cb("obj_url", bfs.getUrl());
                a.save();
            }
            this.cch.setVisibility(0);
            this.cci.setText(bfs.getText());
            this.ccj.setText(bfs.getTitle());
            this.cck.c(bfs.pE(), 10, false);
            this.cch.setOnClickListener(new e(this, bfs, id, name));
        }
    }

    protected View aao() {
        return LayoutInflater.from(this.bPw.getPageContext().getPageActivity()).inflate(w.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.ccv.setOnClickListener(onClickListener);
        this.ccb.setOnClickListener(onClickListener);
        this.cca.setOnClickListener(onClickListener);
        this.ccX.setOnClickListener(onClickListener);
        if (this.ccf != null) {
            this.ccf.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.aat.getLayoutMode().ai(i == 1);
        this.aat.getLayoutMode().t(this.aXK);
        this.aat.getLayoutMode().t(this.ccq);
        this.aat.getLayoutMode().t(this.cce);
        if (this.ccN) {
            iJ(1);
        } else {
            iJ(0);
        }
        this.ccv.invalidate();
        aq.k(this.aVN, w.e.cp_bg_line_d);
        aq.k(this.bpr, w.e.cp_bg_line_c);
        aq.i(this.ccY, w.e.cp_cont_f);
        aq.i(this.ccc, w.e.cp_cont_f);
        aq.i(this.bRJ, w.e.cp_cont_d);
        aq.i(this.cbY, w.e.cp_cont_b);
        aq.i(this.bRK, w.e.cp_cont_d);
        aq.i(this.cbZ, w.e.cp_cont_b);
        aap();
        if (this.ccf != null) {
            aq.j(this.ccf, w.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aq.c(this.cct, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.cct, w.g.icon_sml_speed_gray);
        }
        if (this.ccz != null) {
            this.ccz.changeSkinType(i);
        }
        if (this.ccA != null) {
            this.ccA.changeSkinType(i);
        }
        if (this.ccw != null) {
            this.ccw.dm(i);
        }
        Iterator<TbImageView> it = this.bRL.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aaj();
        aq.j(this.cch, w.g.home_thread_card_item_bg);
        if (this.bRI != null) {
            com.baidu.tbadk.m.a.a(this.bPw.getPageContext(), this.bRI);
        }
    }

    protected void aap() {
        Drawable drawable = aq.getDrawable(w.g.icon_add_follow_blue_selector);
        int g = k.g(this.aat.getPageActivity(), w.f.ds8);
        int g2 = k.g(this.aat.getPageActivity(), w.f.ds18);
        drawable.setBounds(0, g, g2, g2);
        this.cca.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aq.c(this.cca, w.g.frs_head_attention_text_bg, 1);
        aq.j(this.cca, w.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, n nVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ccF = forumData.getPost_num();
            this.ccC = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.ccB = forumData.getLevelName();
            this.bhs = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ccG = forumData.getSignData().count_sign_num;
                this.ccH = forumData.getSignData().miss_sign_num;
            }
            this.ccI = forumData.getCurScore();
            this.cbA = forumData.getLevelupScore();
            this.ccx = forumData.getBadgeData();
            this.ccn = forumData.getTopCode();
            this.cco = forumData.getNewsInfo();
            this.ccD = forumData.getAccelerateContent();
            this.bTj = nVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aXK.setVisibility(8);
            } else {
                this.aXK.setVisibility(0);
            }
            this.ccE = new bk();
            aaq();
            aat();
            aan();
        }
    }

    protected void aaq() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.ccE.rI().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aar() {
        if (this.ccH > 0) {
            aq.c(this.ccb, w.g.frs_head_text_btn_bg, 1);
            this.ccb.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.ccb.setText(String.format(this.aat.getString(w.l.miss_sign_days), Integer.valueOf(this.ccH)));
        } else {
            this.ccb.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.c(this.ccb, w.e.cp_cont_e, 1);
            this.ccb.setText(this.aat.getString(w.l.signed));
        }
        this.ccb.setTextSize(0, k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds28));
        this.ccb.setBackgroundDrawable(null);
        this.ccb.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aas() {
        aq.c(this.ccb, w.g.frs_head_attention_text_bg, 1);
        this.ccb.setTextSize(0, k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds24));
        this.ccb.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aq.j(this.ccb, w.g.frs_attention_btn_bg_selector);
    }

    protected void aat() {
        if (this.cbY != null) {
            this.cbY.setText(au.t(this.mMemberNum));
        }
        if (this.cbZ != null) {
            this.cbZ.setText(au.t(this.ccF));
        }
        if (this.bKb != null) {
            if (this.ccx != null && this.ccx.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.bKb.setText(String.valueOf(this.mForumName) + this.aat.getString(w.l.forum));
            }
        }
        if (this.ccf != null && this.ccg != null) {
            if (this.bTj != null && this.bTj.beY()) {
                if (com.baidu.tbadk.core.util.m.dk(this.bTj.bfb()) == 1 && !p.adJ) {
                    this.ccf.setVisibility(8);
                } else {
                    this.ccf.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bTj.getGameName()) && !TextUtils.isEmpty(this.bTj.getGameName().trim())) {
                        this.ccg.setText(UtilHelper.getFixedText(this.bTj.getGameName(), 10));
                        String qf = com.baidu.tieba.tbadkCore.util.m.qf(this.bTj.bfb());
                        if (!StringUtils.isNull(qf)) {
                            TiebaStatic.eventStat(this.aat.getPageActivity(), "game_show", "show", 1, "dev_id", qf, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.ccg.setText(this.aat.getResources().getString(w.l.frsgame_title));
                    }
                }
            } else {
                this.ccf.setVisibility(8);
            }
        }
        if (this.bTj != null && !x.r(this.bTj.beZ())) {
            List<com.baidu.tieba.tbadkCore.g> beZ = this.bTj.beZ();
            at(beZ);
            int size = beZ.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.ccl.setVisibility(0);
                this.ccl.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = beZ.get(i2);
                    if (gVar != null) {
                        String iT = iT(gVar.azE());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(w.h.top_item_title)).setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(w.h.top_item_type)).setText(iT);
                        ai(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.cda);
                        this.ccl.addView(viewGroup);
                        if (this.ccT.add(gVar.beM())) {
                            a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.beM(), this.bPw.getForumId(), this.bPw.getForumName(), null);
                            a.cb("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.ccl.setVisibility(8);
            }
        } else {
            this.ccl.setVisibility(8);
        }
        this.ccm.setVisibility(8);
        this.ccz.a(null, null);
        aau();
        aav();
        aai();
    }

    protected void aau() {
        this.ccv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ccv.c(this.mImageUrl, 15, false);
    }

    protected void aav() {
        ViewGroup adk;
        View adl;
        View findViewById;
        this.bRG.en(false);
        if (this.ccf.getVisibility() == 0) {
            View findViewById2 = this.ccf.findViewById(w.h.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.ccf.getVisibility() == 8 && this.ccl.getVisibility() == 0) {
            if (this.ccl.getChildCount() > 0 && (findViewById = ((ViewGroup) this.ccl.getChildAt(0)).findViewById(w.h.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.ccl.getVisibility() == 8 && (adk = this.ccz.adk()) != null && adk.getVisibility() == 0 && (adl = this.ccz.adl()) != null) {
            adl.setVisibility(8);
        } else {
            this.bRG.en(true);
        }
    }

    private String iT(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(w.l.frs_forum_member_icon_text);
        }
        return str;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.ccU);
            if (this.ccp == null) {
                this.ccp = new PopupWindow(this.aat.getPageActivity());
                this.ccp.setContentView(this.ccq);
                this.ccp.setBackgroundDrawable(new BitmapDrawable());
                this.ccp.setOutsideTouchable(true);
                this.ccp.setFocusable(true);
                this.ccp.setWidth(this.aat.getResources().getDimensionPixelSize(w.f.ds228));
                this.ccp.setHeight(this.aat.getResources().getDimensionPixelSize(w.f.ds100));
                this.ccr = (TextView) this.ccq.findViewById(w.h.cur_experience);
                this.ccs = (TextView) this.ccq.findViewById(w.h.levelup_experience);
                a(this.ccr, this.ccs);
            }
            if (this.ccp.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.ccp, this.aat.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.ccr, this.ccs);
            if (iArr[1] - this.ccp.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.ccp, this.aat.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.ccp, this.aXK, 0, iArr[0], iArr[1] - this.ccp.getHeight());
            this.ccp.update();
            this.mHandler.postDelayed(this.ccU, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aat.getContext()).inflate(w.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(w.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(w.h.speed_tip);
            aq.c((TextView) inflate.findViewById(w.h.experience_txt), w.e.cp_cont_b, 1);
            aq.c(textView, w.e.cp_cont_b, 1);
            aq.c(textView2, w.e.cp_cont_b, 1);
            aq.c(textView3, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aat.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.ccD) && !TextUtils.isEmpty(this.ccD.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ccD);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bY(w.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aat);
            aVar.td();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(w.l.cancel, new f(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(w.l.open_now, new g(this));
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aaw() {
        View contentView;
        if (this.ccu == null) {
            this.ccu = new PopupWindow(this.aat.getPageActivity());
            contentView = LayoutInflater.from(this.aat.getContext()).inflate(w.j.speed_tip, (ViewGroup) null);
            this.ccu.setContentView(contentView);
            contentView.setOnClickListener(new h(this));
            this.ccu.setWidth(this.aat.getResources().getDimensionPixelSize(w.f.ds300));
            this.ccu.setHeight(this.aat.getResources().getDimensionPixelSize(w.f.ds88));
            this.ccu.setBackgroundDrawable(new BitmapDrawable());
            this.ccu.setOutsideTouchable(true);
            this.ccu.setTouchInterceptor(new i(this));
        } else {
            contentView = this.ccu.getContentView();
        }
        this.aat.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cct.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.ccu, this.aXK, 0, (iArr[0] - (this.ccu.getWidth() / 2)) + (this.cct.getWidth() / 2), iArr[1] + this.cct.getWidth());
        this.ccu.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.ccO = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(w.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.ccO) {
                this.ccc.setText(w.l.level_up);
                if (f >= 1.0f) {
                    i = this.bhs;
                } else {
                    i = this.bhs + 1;
                }
                n Zq = this.bPw.Zq();
                if (Zq != null && Zq.aHE() != null) {
                    Zq.aHE().setUser_level(i);
                }
                this.ccY.setText(this.aat.getResources().getString(w.l.lv_num, Integer.valueOf(i)));
            } else {
                this.ccc.setText(this.ccB);
                this.ccY.setText(this.aat.getResources().getString(w.l.lv_num, Integer.valueOf(this.bhs)));
            }
            this.ccd.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, hU(this.bhs)));
            if (this.ccO) {
                if (f >= 1.0f) {
                    a(this.bPw.getBaseFragmentActivity(), this.ccd, this.ccP, f);
                } else {
                    b(this.bPw.getBaseFragmentActivity(), this.ccd, this.ccP, f);
                }
            } else {
                a(this.bPw.getBaseFragmentActivity(), this.ccd, this.ccP, f);
            }
            this.ccP = f;
        }
    }

    private int[] hU(int i) {
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
    protected void aax() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aay() {
        if (this.mMemberType != 0) {
            aq.c(this.cct, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.cct, w.g.icon_sml_speed_gray);
        }
    }
}
