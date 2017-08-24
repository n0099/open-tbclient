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
    private RelativeLayout aWX;
    private FrsHeaderPraiseView cnA;
    private FrsEntranceStoryListWrapperView cnB;
    private TextView cnv;
    private TextView cnw;
    private View cnx;
    private g cny;
    private String mImageUrl;
    private CustomMessageListener cnC = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cAV != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bAo.setVisibility(8);
                } else {
                    c.this.bAo.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cnz = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aWX = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cla = fVar;
        this.acr = fVar.getPageContext();
        this.cAM = k.g(fVar.getPageContext().getPageActivity(), d.f.ds20);
        this.cAN = k.g(fVar.getPageContext().getPageActivity(), d.f.ds72);
        this.cAO = k.g(fVar.getPageContext().getPageActivity(), d.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aZi = agN();
        this.aWX = (RelativeLayout) this.aZi.findViewById(d.h.container);
        this.aWX.setPadding(0, 0, 0, 0);
        this.cBg = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aZi.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, k.g(this.acr.getPageActivity(), d.f.ds60)).setMargins(0, k.g(this.acr.getPageActivity(), d.f.ds220), 0, 0);
        this.cBj = (ImageView) this.aZi.findViewById(d.h.speed_icon);
        this.cnv = (TextView) this.aZi.findViewById(d.h.member_image);
        this.cnw = (TextView) this.aZi.findViewById(d.h.post_image);
        this.cAT = (TextView) this.aZi.findViewById(d.h.level_name);
        this.cBO = (TextView) this.aZi.findViewById(d.h.level);
        this.cAR = (TextView) this.aZi.findViewById(d.h.tv_love);
        this.cAS = (TextView) this.aZi.findViewById(d.h.tv_sign);
        this.cAS.setContentDescription(fVar.getResources().getString(d.l.sign));
        this.cAU = (ImageView) this.aZi.findViewById(d.h.love_level_top);
        this.cAP = (TextView) this.aZi.findViewById(d.h.member_num_text);
        this.cAQ = (TextView) this.aZi.findViewById(d.h.post_num_text);
        this.cBl = (BarImageView) this.aZi.findViewById(d.h.frs_image);
        this.ciZ = (TextView) this.aZi.findViewById(d.h.forum_name);
        this.cBl.setPageId(this.cla.getUniqueId());
        this.cBl.setContentDescription(fVar.getResources().getString(d.l.bar_header));
        this.cBl.setGifIconSupport(false);
        this.cBl.setDrawerType(0);
        this.cAV = LayoutInflater.from(this.cla.getPageContext().getPageActivity()).inflate(d.j.frs_header_extra_entelechy, (ViewGroup) null);
        agD();
        agK();
        agJ();
        this.cAW = (ViewGroup) this.cAV.findViewById(d.h.frs_header_games);
        this.cAX = (TextView) this.cAV.findViewById(d.h.top_item_title);
        this.cBc = (LinearLayout) this.cAV.findViewById(d.h.frs_present_root);
        this.bAo = this.cAV.findViewById(d.h.divider_bottom);
        this.cnx = this.cAV.findViewById(d.h.stroy_divider_bottom);
        this.cBp = new e(this.acr, this.cAV);
        this.cBo = new com.baidu.tieba.frs.f.b(this.acr);
        this.cAY = (ViewGroup) this.cAV.findViewById(d.h.frs_headline);
        this.cAZ = (TextView) this.cAY.findViewById(d.h.headline_title);
        this.cBa = (TextView) this.cAY.findViewById(d.h.headline_text);
        this.cBb = (TbImageView) this.cAY.findViewById(d.h.headline_image);
        this.cBb.setPageId(this.cla.getUniqueId());
        this.cAY.setVisibility(8);
        this.cBN = this.aZi.findViewById(d.h.level_container);
        this.cBM = (RelativeLayout) this.aZi.findViewById(d.h.has_focused_container);
        this.cBL = (RelativeLayout) this.aZi.findViewById(d.h.not_focused_container);
        this.cBP = (RelativeLayout) this.aZi.findViewById(d.h.head_content_container);
        agL();
        this.cla.registerListener(this.cnC);
    }

    private void agJ() {
        this.cnA = (FrsHeaderPraiseView) this.cAV.findViewById(d.h.frs_praise_layout);
    }

    private void agK() {
        this.cnB = (FrsEntranceStoryListWrapperView) this.cAV.findViewById(d.h.listview_story_wrapper_view);
        this.cnB.p(this.cla.getPageContext());
    }

    private void agL() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.cBq = (ag) runTask.getData();
            this.cBq.a(this.acr, this.aZi, 1, false, this.cla.getUniqueId());
            this.cBq.hide();
        }
    }

    private void agM() {
        final m brE = this.cpb.brE();
        if (brE != null && this.cpb.aPJ() != null) {
            final String id = this.cpb.aPJ().getId();
            final String name = this.cpb.aPJ().getName();
            if (this.cBJ.add(brE.pI())) {
                a.C0121a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", brE.pI(), id, name, null);
                a.ck("obj_url", brE.getUrl());
                a.save();
            }
            this.cAY.setVisibility(0);
            this.cAZ.setText(brE.getText());
            this.cBa.setText(brE.getTitle());
            this.cBb.c(brE.pH(), 10, false);
            this.cAY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0121a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", brE.pI(), id, name, null);
                    a2.ck("obj_url", brE.getUrl());
                    a2.save();
                    at.wg().c(c.this.cla.getPageContext(), new String[]{brE.getUrl()});
                }
            });
        }
    }

    protected View agN() {
        return LayoutInflater.from(this.cla.getPageContext().getPageActivity()).inflate(d.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cBl.setOnClickListener(onClickListener);
        this.ciZ.setOnClickListener(onClickListener);
        this.cAS.setOnClickListener(onClickListener);
        this.cAR.setOnClickListener(onClickListener);
        this.cBN.setOnClickListener(onClickListener);
        if (this.cAW != null) {
            this.cAW.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.acr.getLayoutMode().ah(i == 1);
        this.acr.getLayoutMode().t(this.aZi);
        this.acr.getLayoutMode().t(this.cBg);
        this.acr.getLayoutMode().t(this.cAV);
        if (this.cBD) {
            jL(1);
        } else {
            jL(0);
        }
        this.cBl.invalidate();
        ai.k(this.aWX, d.e.cp_bg_line_d);
        ai.k(this.bAo, d.e.cp_bg_line_c);
        ai.i(this.cBO, d.e.cp_cont_f);
        ai.i(this.cAT, d.e.cp_cont_f);
        ai.i(this.cnv, d.e.cp_cont_d);
        ai.i(this.cAP, d.e.cp_cont_b);
        ai.i(this.cnw, d.e.cp_cont_d);
        ai.i(this.cAQ, d.e.cp_cont_b);
        if (this.cnB != null) {
            ai.k(this.cnB, d.e.cp_bg_line_d);
        }
        agO();
        if (this.cAW != null) {
            ai.j(this.cAW, d.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ai.c(this.cBj, d.g.icon_sml_speed_orange);
        } else {
            ai.c(this.cBj, d.g.icon_sml_speed_gray);
        }
        if (this.cBp != null) {
            this.cBp.changeSkinType(i);
        }
        if (this.cBq != null) {
            this.cBq.changeSkinType(i);
        }
        if (this.cBm != null) {
            this.cBm.dt(i);
        }
        Iterator<TbImageView> it = this.cnz.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        agF();
        ai.j(this.cAY, d.g.home_thread_card_item_bg);
        ai.i(this.ciZ, d.e.cp_cont_b);
        if (this.cnq != null) {
            com.baidu.tbadk.o.a.a(this.cla.getPageContext(), this.cnq);
        }
        if (this.cnB.getVisibility() == 0) {
            this.cnB.changeSkinType(i);
            ai.k(this.cnx, d.e.cp_bg_line_c);
        }
        if (this.cnA.getVisibility() == 0) {
            this.cnA.changeSkinType(i);
        }
    }

    protected void agO() {
        Drawable drawable = ai.getDrawable(d.g.icon_add_follow_blue_selector);
        int g = k.g(this.acr.getPageActivity(), d.f.ds8);
        int g2 = k.g(this.acr.getPageActivity(), d.f.ds18);
        drawable.setBounds(0, g, g2, g2);
        this.cAR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        ai.c(this.cAR, d.g.frs_head_attention_text_bg, 1);
        ai.j(this.cAR, d.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, i iVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cBv = forumData.getPost_num();
            this.cBs = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.cBr = forumData.getLevelName();
            this.bsj = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cBw = forumData.getSignData().count_sign_num;
                this.cBx = forumData.getSignData().miss_sign_num;
            }
            this.cBy = forumData.getCurScore();
            this.cAb = forumData.getLevelupScore();
            this.cBn = forumData.getBadgeData();
            this.cBd = forumData.getTopCode();
            this.cBe = forumData.getNewsInfo();
            this.cBt = forumData.getAccelerateContent();
            this.cpb = iVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aZi.setVisibility(8);
            } else {
                this.aZi.setVisibility(0);
            }
            this.cBu = new bl();
            agP();
            agS();
            agM();
            if (this.cpb != null) {
                this.cnB.b(this.cpb.bqY(), this.cla.getForumId(), "0");
            } else {
                this.cnB.setVisibility(8);
                this.cnx.setVisibility(8);
            }
            this.cnA.setVisibility(8);
            if (this.cny == null) {
                this.cny = new g(this.cla.getPageContext(), this.cla.getPageContext().getUniqueId(), 2, com.baidu.adp.lib.g.b.d(this.mForumId, 0L), this.mForumName);
                this.cnB.setOnClick(this.cny);
            }
        }
    }

    protected void agP() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.cBu.rQ().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void agQ() {
        if (this.cBx > 0) {
            ai.c(this.cAS, d.g.frs_head_text_btn_bg, 1);
            this.cAS.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cAS.setText(String.format(this.acr.getString(d.l.miss_sign_days), Integer.valueOf(this.cBx)));
        } else {
            this.cAS.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            ai.c(this.cAS, d.e.cp_cont_e, 1);
            this.cAS.setText(this.acr.getString(d.l.signed));
        }
        this.cAS.setTextSize(0, k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds28));
        this.cAS.setBackgroundDrawable(null);
        this.cAS.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void agR() {
        ai.c(this.cAS, d.g.frs_head_attention_text_bg, 1);
        this.cAS.setTextSize(0, k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds24));
        this.cAS.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.j(this.cAS, d.g.frs_attention_btn_bg_selector);
    }

    protected void agS() {
        if (this.cAP != null) {
            this.cAP.setText(al.u(this.mMemberNum));
        }
        if (this.cAQ != null) {
            this.cAQ.setText(al.u(this.cBv));
        }
        if (this.cBn != null && this.cBn.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.cdX != null) {
                this.cdX.setText(this.mForumName + this.acr.getString(d.l.forum));
            }
            if (this.ciZ != null) {
                this.ciZ.setText(this.mForumName + this.acr.getString(d.l.forum));
            }
        }
        if (this.cAW != null && this.cAX != null) {
            if (this.cpb != null && this.cpb.brk()) {
                if (l.dO(this.cpb.brn()) == 1 && !com.baidu.tbadk.core.util.m.agc) {
                    this.cAW.setVisibility(8);
                } else {
                    this.cAW.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cpb.getGameName()) && !TextUtils.isEmpty(this.cpb.getGameName().trim())) {
                        this.cAX.setText(UtilHelper.getFixedText(this.cpb.getGameName(), 10));
                        String sp = com.baidu.tieba.tbadkCore.util.b.sp(this.cpb.brn());
                        if (!StringUtils.isNull(sp)) {
                            TiebaStatic.eventStat(this.acr.getPageActivity(), "game_show", "show", 1, "dev_id", sp, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cAX.setText(this.acr.getResources().getString(d.l.frsgame_title));
                    }
                }
            } else {
                this.cAW.setVisibility(8);
            }
        }
        this.cns.clearData();
        if (this.cpb != null && !u.v(this.cpb.brl())) {
            List<com.baidu.tieba.tbadkCore.e> brl = this.cpb.brl();
            aU(brl);
            this.cns.aT(brl);
        }
        this.cBc.setVisibility(8);
        this.cBp.a(null, null);
        agT();
        agU();
        agE();
    }

    protected void agT() {
        this.cBl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cBl.c(this.mImageUrl, 15, false);
    }

    protected void agU() {
        this.cno.fi(false);
        if (this.cAW.getVisibility() == 0) {
            View findViewById = this.cAW.findViewById(d.h.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.cno.fi(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cBK);
            if (this.cBf == null) {
                this.cBf = new PopupWindow(this.acr.getPageActivity());
                this.cBf.setContentView(this.cBg);
                this.cBf.setBackgroundDrawable(new BitmapDrawable());
                this.cBf.setOutsideTouchable(true);
                this.cBf.setFocusable(true);
                this.cBf.setWidth(this.acr.getResources().getDimensionPixelSize(d.f.ds228));
                this.cBf.setHeight(this.acr.getResources().getDimensionPixelSize(d.f.ds100));
                this.cBh = (TextView) this.cBg.findViewById(d.h.cur_experience);
                this.cBi = (TextView) this.cBg.findViewById(d.h.levelup_experience);
                a(this.cBh, this.cBi);
            }
            if (this.cBf.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cBf, this.acr.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cBh, this.cBi);
            if (iArr[1] - this.cBf.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cBf, this.acr.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cBf, this.aZi, 0, iArr[0], iArr[1] - this.cBf.getHeight());
            this.cBf.update();
            this.mHandler.postDelayed(this.cBK, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.acr.getContext()).inflate(d.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.h.speed_tip);
            ai.c((TextView) inflate.findViewById(d.h.experience_txt), d.e.cp_cont_b, 1);
            ai.c(textView, d.e.cp_cont_b, 1);
            ai.c(textView2, d.e.cp_cont_b, 1);
            ai.c(textView3, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.acr.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cBt) && !TextUtils.isEmpty(this.cBt.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cBt);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cd(d.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.acr);
            aVar.ts();
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
                if (c.this.acr != null && c.this.acr.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.acr.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agV() {
        View contentView;
        if (this.cBk == null) {
            this.cBk = new PopupWindow(this.acr.getPageActivity());
            contentView = LayoutInflater.from(this.acr.getContext()).inflate(d.j.speed_tip, (ViewGroup) null);
            this.cBk.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.acr != null && c.this.acr.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cBk, c.this.acr.getPageActivity());
                        c.this.cla.cjy = false;
                        com.baidu.tbadk.browser.a.a(c.this.acr.getPageActivity(), c.this.acr.getResources().getString(d.l.experion_speed), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cBk.setWidth(this.acr.getResources().getDimensionPixelSize(d.f.ds300));
            this.cBk.setHeight(this.acr.getResources().getDimensionPixelSize(d.f.ds88));
            this.cBk.setBackgroundDrawable(new BitmapDrawable());
            this.cBk.setOutsideTouchable(true);
            this.cBk.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cBk);
                        c.this.cla.cjy = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cBk.getContentView();
        }
        this.acr.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cBj.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cBk, this.aZi, 0, (iArr[0] - (this.cBk.getWidth() / 2)) + (this.cBj.getWidth() / 2), iArr[1] + this.cBj.getWidth());
        this.cBk.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cBE = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cBE) {
                this.cAT.setText(d.l.level_up);
                if (f >= 1.0f) {
                    i = this.bsj;
                } else {
                    i = this.bsj + 1;
                }
                i afH = this.cla.afH();
                if (afH != null && afH.aPJ() != null) {
                    afH.aPJ().setUser_level(i);
                }
                this.cBO.setText(this.acr.getResources().getString(d.l.lv_num, Integer.valueOf(i)));
            } else {
                this.cAT.setText(this.cBr);
                this.cBO.setText(this.acr.getResources().getString(d.l.lv_num, Integer.valueOf(this.bsj)));
            }
            this.cAU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iQ(this.bsj)));
            if (this.cBE) {
                if (f >= 1.0f) {
                    a(this.cla.getBaseFragmentActivity(), this.cAU, this.cBF, f);
                } else {
                    b(this.cla.getBaseFragmentActivity(), this.cAU, this.cBF, f);
                }
            } else {
                a(this.cla.getBaseFragmentActivity(), this.cAU, this.cBF, f);
            }
            this.cBF = f;
        }
    }

    private int[] iQ(int i) {
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
    protected void agW() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void agX() {
        if (this.mMemberType != 0) {
            ai.c(this.cBj, d.g.icon_sml_speed_orange);
        } else {
            ai.c(this.cBj, d.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cnC);
    }

    public FrsEntranceStoryListWrapperView agY() {
        return this.cnB;
    }
}
