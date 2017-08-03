package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
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
    private RelativeLayout aVK;
    private TextView clA;
    private View clB;
    private g clC;
    private FrsHeaderPraiseView clE;
    private FrsEntranceStoryListWrapperView clF;
    private TextView clz;
    private String mImageUrl;
    private CustomMessageListener clG = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cxD != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.byu.setVisibility(8);
                } else {
                    c.this.byu.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> clD = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aVK = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cjg = fVar;
        this.aaS = fVar.getPageContext();
        this.cxu = k.g(fVar.getPageContext().getPageActivity(), d.f.ds20);
        this.cxv = k.g(fVar.getPageContext().getPageActivity(), d.f.ds72);
        this.cxw = k.g(fVar.getPageContext().getPageActivity(), d.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aXV = agr();
        this.aVK = (RelativeLayout) this.aXV.findViewById(d.h.container);
        this.aVK.setPadding(0, 0, 0, 0);
        this.cxO = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aXV.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, k.g(this.aaS.getPageActivity(), d.f.ds60)).setMargins(0, k.g(this.aaS.getPageActivity(), d.f.ds220), 0, 0);
        this.cxR = (ImageView) this.aXV.findViewById(d.h.speed_icon);
        this.clz = (TextView) this.aXV.findViewById(d.h.member_image);
        this.clA = (TextView) this.aXV.findViewById(d.h.post_image);
        this.cxB = (TextView) this.aXV.findViewById(d.h.level_name);
        this.cyw = (TextView) this.aXV.findViewById(d.h.level);
        this.cxz = (TextView) this.aXV.findViewById(d.h.tv_love);
        this.cxA = (TextView) this.aXV.findViewById(d.h.tv_sign);
        this.cxA.setContentDescription(fVar.getResources().getString(d.l.sign));
        this.cxC = (ImageView) this.aXV.findViewById(d.h.love_level_top);
        this.cxx = (TextView) this.aXV.findViewById(d.h.member_num_text);
        this.cxy = (TextView) this.aXV.findViewById(d.h.post_num_text);
        this.cxT = (BarImageView) this.aXV.findViewById(d.h.frs_image);
        this.chf = (TextView) this.aXV.findViewById(d.h.forum_name);
        this.cxT.setPageId(this.cjg.getUniqueId());
        this.cxT.setContentDescription(fVar.getResources().getString(d.l.bar_header));
        this.cxT.setGifIconSupport(false);
        this.cxT.setDrawerType(0);
        this.cxD = LayoutInflater.from(this.cjg.getPageContext().getPageActivity()).inflate(d.j.frs_header_extra_entelechy, (ViewGroup) null);
        agh();
        ago();
        agn();
        this.cxE = (ViewGroup) this.cxD.findViewById(d.h.frs_header_games);
        this.cxF = (TextView) this.cxD.findViewById(d.h.top_item_title);
        this.cxK = (LinearLayout) this.cxD.findViewById(d.h.frs_present_root);
        this.byu = this.cxD.findViewById(d.h.divider_bottom);
        this.clB = this.cxD.findViewById(d.h.stroy_divider_bottom);
        this.cxX = new e(this.aaS, this.cxD);
        this.cxW = new com.baidu.tieba.frs.g.b(this.aaS);
        this.cxG = (ViewGroup) this.cxD.findViewById(d.h.frs_headline);
        this.cxH = (TextView) this.cxG.findViewById(d.h.headline_title);
        this.cxI = (TextView) this.cxG.findViewById(d.h.headline_text);
        this.cxJ = (TbImageView) this.cxG.findViewById(d.h.headline_image);
        this.cxJ.setPageId(this.cjg.getUniqueId());
        this.cxG.setVisibility(8);
        this.cyv = this.aXV.findViewById(d.h.level_container);
        this.cyu = (RelativeLayout) this.aXV.findViewById(d.h.has_focused_container);
        this.cyt = (RelativeLayout) this.aXV.findViewById(d.h.not_focused_container);
        this.cyx = (RelativeLayout) this.aXV.findViewById(d.h.head_content_container);
        agp();
        this.cjg.registerListener(this.clG);
    }

    private void agn() {
        this.clE = (FrsHeaderPraiseView) this.cxD.findViewById(d.h.frs_praise_layout);
    }

    private void ago() {
        this.clF = (FrsEntranceStoryListWrapperView) this.cxD.findViewById(d.h.listview_story_wrapper_view);
        this.clF.p(this.cjg.getPageContext());
    }

    private void agp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.cxY = (ag) runTask.getData();
            this.cxY.a(this.aaS, this.aXV, 1, false, this.cjg.getUniqueId());
            this.cxY.hide();
        }
    }

    private void agq() {
        final m bqW = this.cng.bqW();
        if (bqW != null && this.cng.aOW() != null) {
            final String id = this.cng.aOW().getId();
            final String name = this.cng.aOW().getName();
            if (this.cyr.add(bqW.px())) {
                a.C0121a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bqW.px(), id, name, null);
                a.ch("obj_url", bqW.getUrl());
                a.save();
            }
            this.cxG.setVisibility(0);
            this.cxH.setText(bqW.getText());
            this.cxI.setText(bqW.getTitle());
            this.cxJ.c(bqW.pw(), 10, false);
            this.cxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0121a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bqW.px(), id, name, null);
                    a2.ch("obj_url", bqW.getUrl());
                    a2.save();
                    at.vV().c(c.this.cjg.getPageContext(), new String[]{bqW.getUrl()});
                }
            });
        }
    }

    protected View agr() {
        return LayoutInflater.from(this.cjg.getPageContext().getPageActivity()).inflate(d.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cxT.setOnClickListener(onClickListener);
        this.chf.setOnClickListener(onClickListener);
        this.cxA.setOnClickListener(onClickListener);
        this.cxz.setOnClickListener(onClickListener);
        this.cyv.setOnClickListener(onClickListener);
        if (this.cxE != null) {
            this.cxE.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.aaS.getLayoutMode().ah(i == 1);
        this.aaS.getLayoutMode().t(this.aXV);
        this.aaS.getLayoutMode().t(this.cxO);
        this.aaS.getLayoutMode().t(this.cxD);
        if (this.cyl) {
            jB(1);
        } else {
            jB(0);
        }
        this.cxT.invalidate();
        ai.k(this.aVK, d.e.cp_bg_line_d);
        ai.k(this.byu, d.e.cp_bg_line_c);
        ai.i(this.cyw, d.e.cp_cont_f);
        ai.i(this.cxB, d.e.cp_cont_f);
        ai.i(this.clz, d.e.cp_cont_d);
        ai.i(this.cxx, d.e.cp_cont_b);
        ai.i(this.clA, d.e.cp_cont_d);
        ai.i(this.cxy, d.e.cp_cont_b);
        if (this.clF != null) {
            ai.k(this.clF, d.e.cp_bg_line_d);
        }
        ags();
        if (this.cxE != null) {
            ai.j(this.cxE, d.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ai.c(this.cxR, d.g.icon_sml_speed_orange);
        } else {
            ai.c(this.cxR, d.g.icon_sml_speed_gray);
        }
        if (this.cxX != null) {
            this.cxX.changeSkinType(i);
        }
        if (this.cxY != null) {
            this.cxY.changeSkinType(i);
        }
        if (this.cxU != null) {
            this.cxU.dr(i);
        }
        Iterator<TbImageView> it = this.clD.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        agj();
        ai.j(this.cxG, d.g.home_thread_card_item_bg);
        ai.i(this.chf, d.e.cp_cont_b);
        if (this.clv != null) {
            com.baidu.tbadk.o.a.a(this.cjg.getPageContext(), this.clv);
        }
        if (this.clF.getVisibility() == 0) {
            this.clF.changeSkinType(i);
            ai.k(this.clB, d.e.cp_bg_line_c);
        }
        if (this.clE.getVisibility() == 0) {
            this.clE.changeSkinType(i);
        }
    }

    protected void ags() {
        Drawable drawable = ai.getDrawable(d.g.icon_add_follow_blue_selector);
        int g = k.g(this.aaS.getPageActivity(), d.f.ds8);
        int g2 = k.g(this.aaS.getPageActivity(), d.f.ds18);
        drawable.setBounds(0, g, g2, g2);
        this.cxz.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        ai.c(this.cxz, d.g.frs_head_attention_text_bg, 1);
        ai.j(this.cxz, d.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, i iVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cyd = forumData.getPost_num();
            this.cya = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.cxZ = forumData.getLevelName();
            this.bpY = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cye = forumData.getSignData().count_sign_num;
                this.cyf = forumData.getSignData().miss_sign_num;
            }
            this.cyg = forumData.getCurScore();
            this.cwJ = forumData.getLevelupScore();
            this.cxV = forumData.getBadgeData();
            this.cxL = forumData.getTopCode();
            this.cxM = forumData.getNewsInfo();
            this.cyb = forumData.getAccelerateContent();
            this.cng = iVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aXV.setVisibility(8);
            } else {
                this.aXV.setVisibility(0);
            }
            this.cyc = new bl();
            agt();
            agw();
            agq();
            if (this.cng != null) {
                this.clF.b(this.cng.bqq(), this.cjg.getForumId(), "0");
            } else {
                this.clF.setVisibility(8);
                this.clB.setVisibility(8);
            }
            this.clE.setVisibility(8);
            if (this.clC == null) {
                this.clC = new g(this.cjg.getPageContext(), this.cjg.getPageContext().getUniqueId(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.clF.setOnClick(this.clC);
            }
        }
    }

    protected void agt() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.cyc.rF().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void agu() {
        if (this.cyf > 0) {
            ai.c(this.cxA, d.g.frs_head_text_btn_bg, 1);
            this.cxA.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cxA.setText(String.format(this.aaS.getString(d.l.miss_sign_days), Integer.valueOf(this.cyf)));
        } else {
            this.cxA.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.c(this.cxA, d.e.cp_cont_e, 1);
            this.cxA.setText(this.aaS.getString(d.l.signed));
        }
        this.cxA.setTextSize(0, k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds28));
        this.cxA.setBackgroundDrawable(null);
        this.cxA.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void agv() {
        ai.c(this.cxA, d.g.frs_head_attention_text_bg, 1);
        this.cxA.setTextSize(0, k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds24));
        this.cxA.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.j(this.cxA, d.g.frs_attention_btn_bg_selector);
    }

    protected void agw() {
        if (this.cxx != null) {
            this.cxx.setText(al.u(this.mMemberNum));
        }
        if (this.cxy != null) {
            this.cxy.setText(al.u(this.cyd));
        }
        if (this.cxV != null && this.cxV.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.cce != null) {
                this.cce.setText(this.mForumName + this.aaS.getString(d.l.forum));
            }
            if (this.chf != null) {
                this.chf.setText(this.mForumName + this.aaS.getString(d.l.forum));
            }
        }
        if (this.cxE != null && this.cxF != null) {
            if (this.cng != null && this.cng.bqC()) {
                if (l.dE(this.cng.bqF()) == 1 && !com.baidu.tbadk.core.util.m.aeG) {
                    this.cxE.setVisibility(8);
                } else {
                    this.cxE.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cng.getGameName()) && !TextUtils.isEmpty(this.cng.getGameName().trim())) {
                        this.cxF.setText(UtilHelper.getFixedText(this.cng.getGameName(), 10));
                        String sd = com.baidu.tieba.tbadkCore.util.b.sd(this.cng.bqF());
                        if (!StringUtils.isNull(sd)) {
                            TiebaStatic.eventStat(this.aaS.getPageActivity(), "game_show", "show", 1, "dev_id", sd, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cxF.setText(this.aaS.getResources().getString(d.l.frsgame_title));
                    }
                }
            } else {
                this.cxE.setVisibility(8);
            }
        }
        this.clx.clearData();
        if (this.cng != null && !u.v(this.cng.bqD())) {
            List<com.baidu.tieba.tbadkCore.e> bqD = this.cng.bqD();
            aR(bqD);
            this.clx.aQ(bqD);
        }
        this.cxK.setVisibility(8);
        this.cxX.a(null, null);
        agx();
        agy();
        agi();
    }

    protected void agx() {
        this.cxT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cxT.c(this.mImageUrl, 15, false);
    }

    protected void agy() {
        this.clt.ff(false);
        if (this.cxE.getVisibility() == 0) {
            View findViewById = this.cxE.findViewById(d.h.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.clt.ff(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cys);
            if (this.cxN == null) {
                this.cxN = new PopupWindow(this.aaS.getPageActivity());
                this.cxN.setContentView(this.cxO);
                this.cxN.setBackgroundDrawable(new BitmapDrawable());
                this.cxN.setOutsideTouchable(true);
                this.cxN.setFocusable(true);
                this.cxN.setWidth(this.aaS.getResources().getDimensionPixelSize(d.f.ds228));
                this.cxN.setHeight(this.aaS.getResources().getDimensionPixelSize(d.f.ds100));
                this.cxP = (TextView) this.cxO.findViewById(d.h.cur_experience);
                this.cxQ = (TextView) this.cxO.findViewById(d.h.levelup_experience);
                a(this.cxP, this.cxQ);
            }
            if (this.cxN.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cxN, this.aaS.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cxP, this.cxQ);
            if (iArr[1] - this.cxN.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cxN, this.aaS.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cxN, this.aXV, 0, iArr[0], iArr[1] - this.cxN.getHeight());
            this.cxN.update();
            this.mHandler.postDelayed(this.cys, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aaS.getContext()).inflate(d.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.h.speed_tip);
            ai.c((TextView) inflate.findViewById(d.h.experience_txt), d.e.cp_cont_b, 1);
            ai.c(textView, d.e.cp_cont_b, 1);
            ai.c(textView2, d.e.cp_cont_b, 1);
            ai.c(textView3, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaS.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cyb) && !TextUtils.isEmpty(this.cyb.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cyb);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cb(d.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aaS);
            aVar.th();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.l.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (c.this.aaS != null && c.this.aaS.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aaS.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agz() {
        View contentView;
        if (this.cxS == null) {
            this.cxS = new PopupWindow(this.aaS.getPageActivity());
            contentView = LayoutInflater.from(this.aaS.getContext()).inflate(d.j.speed_tip, (ViewGroup) null);
            this.cxS.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aaS != null && c.this.aaS.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cxS, c.this.aaS.getPageActivity());
                        c.this.cjg.chD = false;
                        com.baidu.tbadk.browser.a.a(c.this.aaS.getPageActivity(), c.this.aaS.getResources().getString(d.l.experion_speed), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cxS.setWidth(this.aaS.getResources().getDimensionPixelSize(d.f.ds300));
            this.cxS.setHeight(this.aaS.getResources().getDimensionPixelSize(d.f.ds88));
            this.cxS.setBackgroundDrawable(new BitmapDrawable());
            this.cxS.setOutsideTouchable(true);
            this.cxS.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cxS);
                        c.this.cjg.chD = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cxS.getContentView();
        }
        this.aaS.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cxR.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cxS, this.aXV, 0, (iArr[0] - (this.cxS.getWidth() / 2)) + (this.cxR.getWidth() / 2), iArr[1] + this.cxR.getWidth());
        this.cxS.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cym = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cym) {
                this.cxB.setText(d.l.level_up);
                if (f >= 1.0f) {
                    i = this.bpY;
                } else {
                    i = this.bpY + 1;
                }
                i afm = this.cjg.afm();
                if (afm != null && afm.aOW() != null) {
                    afm.aOW().setUser_level(i);
                }
                this.cyw.setText(this.aaS.getResources().getString(d.l.lv_num, Integer.valueOf(i)));
            } else {
                this.cxB.setText(this.cxZ);
                this.cyw.setText(this.aaS.getResources().getString(d.l.lv_num, Integer.valueOf(this.bpY)));
            }
            this.cxC.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iO(this.bpY)));
            if (this.cym) {
                if (f >= 1.0f) {
                    a(this.cjg.getBaseFragmentActivity(), this.cxC, this.cyn, f);
                } else {
                    b(this.cjg.getBaseFragmentActivity(), this.cxC, this.cyn, f);
                }
            } else {
                a(this.cjg.getBaseFragmentActivity(), this.cxC, this.cyn, f);
            }
            this.cyn = f;
        }
    }

    private int[] iO(int i) {
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
    protected void agA() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agB() {
        if (this.mMemberType != 0) {
            ai.c(this.cxR, d.g.icon_sml_speed_orange);
        } else {
            ai.c(this.cxR, d.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.clG);
    }

    public FrsEntranceStoryListWrapperView agC() {
        return this.clF;
    }
}
