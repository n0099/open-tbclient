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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
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
    private String VC;
    private RelativeLayout aWF;
    private TextView cuR;
    private TextView cuS;
    private View cuT;
    private g cuU;
    private FrsHeaderPraiseView cuW;
    private FrsEntranceStoryListWrapperView cuX;
    private CustomMessageListener cuY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cIf != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bBX.setVisibility(8);
                } else {
                    c.this.bBX.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cuV = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aWF = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.crm = fVar;
        this.aby = fVar.getPageContext();
        this.cHW = k.f(fVar.getPageContext().getPageActivity(), d.f.ds20);
        this.cHX = k.f(fVar.getPageContext().getPageActivity(), d.f.ds72);
        this.cHY = k.f(fVar.getPageContext().getPageActivity(), d.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aYR = aiK();
        this.aWF = (RelativeLayout) this.aYR.findViewById(d.h.container);
        this.aWF.setPadding(0, 0, 0, 0);
        this.cIq = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aYR.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, k.f(this.aby.getPageActivity(), d.f.ds60)).setMargins(0, k.f(this.aby.getPageActivity(), d.f.ds220), 0, 0);
        this.cIt = (ImageView) this.aYR.findViewById(d.h.speed_icon);
        this.cuR = (TextView) this.aYR.findViewById(d.h.member_image);
        this.cuS = (TextView) this.aYR.findViewById(d.h.post_image);
        this.cId = (TextView) this.aYR.findViewById(d.h.level_name);
        this.cIY = (TextView) this.aYR.findViewById(d.h.level);
        this.cIb = (TextView) this.aYR.findViewById(d.h.tv_love);
        this.cIc = (TextView) this.aYR.findViewById(d.h.tv_sign);
        this.cIc.setContentDescription(fVar.getResources().getString(d.l.sign));
        this.cIe = (ImageView) this.aYR.findViewById(d.h.love_level_top);
        this.cHZ = (TextView) this.aYR.findViewById(d.h.member_num_text);
        this.cIa = (TextView) this.aYR.findViewById(d.h.post_num_text);
        this.cIv = (BarImageView) this.aYR.findViewById(d.h.frs_image);
        this.cpl = (TextView) this.aYR.findViewById(d.h.forum_name);
        this.cIv.setPageId(this.crm.getUniqueId());
        this.cIv.setContentDescription(fVar.getResources().getString(d.l.bar_header));
        this.cIv.setGifIconSupport(false);
        this.cIv.setDrawerType(0);
        this.cIf = LayoutInflater.from(this.crm.getPageContext().getPageActivity()).inflate(d.j.frs_header_extra_entelechy, (ViewGroup) null);
        aiA();
        aiH();
        aiG();
        this.cIg = (ViewGroup) this.cIf.findViewById(d.h.frs_header_games);
        this.cIh = (TextView) this.cIf.findViewById(d.h.top_item_title);
        this.cIm = (LinearLayout) this.cIf.findViewById(d.h.frs_present_root);
        this.bBX = this.cIf.findViewById(d.h.divider_bottom);
        this.cuT = this.cIf.findViewById(d.h.stroy_divider_bottom);
        this.cIz = new e(this.aby, this.cIf);
        this.cIy = new com.baidu.tieba.frs.g.b(this.aby);
        this.cIi = (ViewGroup) this.cIf.findViewById(d.h.frs_headline);
        this.cIj = (TextView) this.cIi.findViewById(d.h.headline_title);
        this.cIk = (TextView) this.cIi.findViewById(d.h.headline_text);
        this.cIl = (TbImageView) this.cIi.findViewById(d.h.headline_image);
        this.cIl.setPageId(this.crm.getUniqueId());
        this.cIi.setVisibility(8);
        this.cIX = this.aYR.findViewById(d.h.level_container);
        this.cIW = (RelativeLayout) this.aYR.findViewById(d.h.has_focused_container);
        this.cIV = (RelativeLayout) this.aYR.findViewById(d.h.not_focused_container);
        this.cIZ = (RelativeLayout) this.aYR.findViewById(d.h.head_content_container);
        aiI();
        this.crm.registerListener(this.cuY);
    }

    private void aiG() {
        this.cuW = (FrsHeaderPraiseView) this.cIf.findViewById(d.h.frs_praise_layout);
    }

    private void aiH() {
        this.cuX = (FrsEntranceStoryListWrapperView) this.cIf.findViewById(d.h.listview_story_wrapper_view);
        this.cuX.p(this.crm.getPageContext());
    }

    private void aiI() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.cIA = (ag) runTask.getData();
            this.cIA.a(this.aby, this.aYR, 1, false, this.crm.getUniqueId());
            this.cIA.hide();
        }
    }

    private void aiJ() {
        final m bre = this.cwy.bre();
        if (bre != null && this.cwy.aPg() != null) {
            final String id = this.cwy.aPg().getId();
            final String name = this.cwy.aPg().getName();
            if (this.cIT.add(bre.pC())) {
                a.C0123a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bre.pC(), id, name, null);
                b.cj("obj_url", bre.getUrl());
                b.save();
            }
            this.cIi.setVisibility(0);
            this.cIj.setText(bre.getText());
            this.cIk.setText(bre.getTitle());
            this.cIl.c(bre.pB(), 10, false);
            this.cIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0123a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bre.pC(), id, name, null);
                    b2.cj("obj_url", bre.getUrl());
                    b2.save();
                    au.wd().c(c.this.crm.getPageContext(), new String[]{bre.getUrl()});
                }
            });
        }
    }

    protected View aiK() {
        return LayoutInflater.from(this.crm.getPageContext().getPageActivity()).inflate(d.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cIv.setOnClickListener(onClickListener);
        this.cpl.setOnClickListener(onClickListener);
        this.cIc.setOnClickListener(onClickListener);
        this.cIb.setOnClickListener(onClickListener);
        this.cIX.setOnClickListener(onClickListener);
        if (this.cIg != null) {
            this.cIg.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.aby.getLayoutMode().ah(i == 1);
        this.aby.getLayoutMode().t(this.aYR);
        this.aby.getLayoutMode().t(this.cIq);
        this.aby.getLayoutMode().t(this.cIf);
        if (this.cIN) {
            kb(1);
        } else {
            kb(0);
        }
        this.cIv.invalidate();
        aj.k(this.aWF, d.e.cp_bg_line_d);
        aj.k(this.bBX, d.e.cp_bg_line_c);
        aj.i(this.cIY, d.e.cp_cont_f);
        aj.i(this.cId, d.e.cp_cont_f);
        aj.i(this.cuR, d.e.cp_cont_d);
        aj.i(this.cHZ, d.e.cp_cont_b);
        aj.i(this.cuS, d.e.cp_cont_d);
        aj.i(this.cIa, d.e.cp_cont_b);
        if (this.cuX != null) {
            aj.k(this.cuX, d.e.cp_bg_line_d);
        }
        aiL();
        if (this.cIg != null) {
            aj.j(this.cIg, d.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.cIt, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cIt, d.g.icon_sml_speed_gray);
        }
        if (this.cIz != null) {
            this.cIz.changeSkinType(i);
        }
        if (this.cIA != null) {
            this.cIA.changeSkinType(i);
        }
        if (this.cIw != null) {
            this.cIw.du(i);
        }
        Iterator<TbImageView> it = this.cuV.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aiC();
        aj.j(this.cIi, d.g.home_thread_card_item_bg);
        aj.i(this.cpl, d.e.cp_cont_b);
        if (this.cuN != null) {
            com.baidu.tbadk.o.a.a(this.crm.getPageContext(), this.cuN);
        }
        if (this.cuX.getVisibility() == 0) {
            this.cuX.changeSkinType(i);
            aj.k(this.cuT, d.e.cp_bg_line_c);
        }
        if (this.cuW.getVisibility() == 0) {
            this.cuW.changeSkinType(i);
        }
    }

    protected void aiL() {
        Drawable drawable = aj.getDrawable(d.g.icon_add_follow_blue_selector);
        int f = k.f(this.aby.getPageActivity(), d.f.ds8);
        int f2 = k.f(this.aby.getPageActivity(), d.f.ds18);
        drawable.setBounds(0, f, f2, f2);
        this.cIb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aj.c(this.cIb, d.g.frs_head_attention_text_bg, 1);
        aj.j(this.cIb, d.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, i iVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cIF = forumData.getPost_num();
            this.cIC = forumData.getTag_color();
            this.VC = forumData.getImage_url();
            this.cIB = forumData.getLevelName();
            this.bth = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cIG = forumData.getSignData().count_sign_num;
                this.cIH = forumData.getSignData().miss_sign_num;
            }
            this.cII = forumData.getCurScore();
            this.cHn = forumData.getLevelupScore();
            this.cIx = forumData.getBadgeData();
            this.cIn = forumData.getTopCode();
            this.cIo = forumData.getNewsInfo();
            this.cID = forumData.getAccelerateContent();
            this.cwy = iVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aYR.setVisibility(8);
            } else {
                this.aYR.setVisibility(0);
            }
            this.cIE = new bj();
            aiM();
            aiP();
            aiJ();
            if (this.cwy != null) {
                this.cuX.b(this.cwy.bqy(), this.crm.getForumId(), "0");
            } else {
                this.cuX.setVisibility(8);
                this.cuT.setVisibility(8);
            }
            this.cuW.setVisibility(8);
            if (this.cuU == null) {
                this.cuU = new g(this.crm.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cuX.setOnClick(this.cuU);
            }
        }
    }

    protected void aiM() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.VC);
        this.cIE.rL().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiN() {
        if (this.cIH > 0) {
            aj.c(this.cIc, d.g.frs_head_text_btn_bg, 1);
            this.cIc.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cIc.setText(String.format(this.aby.getString(d.l.miss_sign_days), Integer.valueOf(this.cIH)));
        } else {
            this.cIc.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.c(this.cIc, d.e.cp_cont_e, 1);
            this.cIc.setText(this.aby.getString(d.l.signed));
        }
        this.cIc.setTextSize(0, k.f(TbadkCoreApplication.getInst().getContext(), d.f.ds28));
        this.cIc.setBackgroundDrawable(null);
        this.cIc.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiO() {
        aj.c(this.cIc, d.g.frs_head_attention_text_bg, 1);
        this.cIc.setTextSize(0, k.f(TbadkCoreApplication.getInst().getContext(), d.f.ds24));
        this.cIc.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.cIc, d.g.frs_attention_btn_bg_selector);
    }

    protected void aiP() {
        if (this.cHZ != null) {
            this.cHZ.setText(am.u(this.mMemberNum));
        }
        if (this.cIa != null) {
            this.cIa.setText(am.u(this.cIF));
        }
        if (this.cIx != null && this.cIx.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aby.getString(d.l.forum));
            }
            if (this.cpl != null) {
                this.cpl.setText(this.mForumName + this.aby.getString(d.l.forum));
            }
        }
        if (this.cIg != null && this.cIh != null) {
            if (this.cwy != null && this.cwy.bqK()) {
                if (com.baidu.tbadk.core.util.m.dF(this.cwy.bqN()) == 1 && !n.afu) {
                    this.cIg.setVisibility(8);
                } else {
                    this.cIg.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cwy.getGameName()) && !TextUtils.isEmpty(this.cwy.getGameName().trim())) {
                        this.cIh.setText(UtilHelper.getFixedText(this.cwy.getGameName(), 10));
                        String sm = com.baidu.tieba.tbadkCore.util.b.sm(this.cwy.bqN());
                        if (!StringUtils.isNull(sm)) {
                            TiebaStatic.eventStat(this.aby.getPageActivity(), "game_show", "show", 1, "dev_id", sm, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cIh.setText(this.aby.getResources().getString(d.l.frsgame_title));
                    }
                }
            } else {
                this.cIg.setVisibility(8);
            }
        }
        this.cuP.clearData();
        if (this.cwy != null && !v.v(this.cwy.bqL())) {
            List<com.baidu.tieba.tbadkCore.e> bqL = this.cwy.bqL();
            aY(bqL);
            this.cuP.aX(bqL);
        }
        this.cIm.setVisibility(8);
        this.cIz.a(null, null);
        aiQ();
        aiR();
        aiB();
    }

    protected void aiQ() {
        this.cIv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cIv.c(this.VC, 15, false);
    }

    protected void aiR() {
        this.cuL.fr(false);
        if (this.cIg.getVisibility() == 0) {
            View findViewById = this.cIg.findViewById(d.h.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.cuL.fr(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void g(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cIU);
            if (this.cIp == null) {
                this.cIp = new PopupWindow(this.aby.getPageActivity());
                this.cIp.setContentView(this.cIq);
                this.cIp.setBackgroundDrawable(new BitmapDrawable());
                this.cIp.setOutsideTouchable(true);
                this.cIp.setFocusable(true);
                this.cIp.setWidth(this.aby.getResources().getDimensionPixelSize(d.f.ds228));
                this.cIp.setHeight(this.aby.getResources().getDimensionPixelSize(d.f.ds100));
                this.cIr = (TextView) this.cIq.findViewById(d.h.cur_experience);
                this.cIs = (TextView) this.cIq.findViewById(d.h.levelup_experience);
                a(this.cIr, this.cIs);
            }
            if (this.cIp.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cIp, this.aby.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cIr, this.cIs);
            if (iArr[1] - this.cIp.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cIp, this.aby.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cIp, this.aYR, 0, iArr[0], iArr[1] - this.cIp.getHeight());
            this.cIp.update();
            this.mHandler.postDelayed(this.cIU, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aby.getContext()).inflate(d.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.h.speed_tip);
            aj.c((TextView) inflate.findViewById(d.h.experience_txt), d.e.cp_cont_b, 1);
            aj.c(textView, d.e.cp_cont_b, 1);
            aj.c(textView2, d.e.cp_cont_b, 1);
            aj.c(textView3, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aby.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cID) && !TextUtils.isEmpty(this.cID.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cID);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cd(d.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aby);
            aVar.to();
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
                if (c.this.aby != null && c.this.aby.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.aby.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiS() {
        View contentView;
        if (this.cIu == null) {
            this.cIu = new PopupWindow(this.aby.getPageActivity());
            contentView = LayoutInflater.from(this.aby.getContext()).inflate(d.j.speed_tip, (ViewGroup) null);
            this.cIu.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aby != null && c.this.aby.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cIu, c.this.aby.getPageActivity());
                        c.this.crm.cpJ = false;
                        com.baidu.tbadk.browser.a.a(c.this.aby.getPageActivity(), c.this.aby.getResources().getString(d.l.experion_speed), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cIu.setWidth(this.aby.getResources().getDimensionPixelSize(d.f.ds300));
            this.cIu.setHeight(this.aby.getResources().getDimensionPixelSize(d.f.ds88));
            this.cIu.setBackgroundDrawable(new BitmapDrawable());
            this.cIu.setOutsideTouchable(true);
            this.cIu.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cIu);
                        c.this.crm.cpJ = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cIu.getContentView();
        }
        this.aby.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cIt.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cIu, this.aYR, 0, (iArr[0] - (this.cIu.getWidth() / 2)) + (this.cIt.getWidth() / 2), iArr[1] + this.cIt.getWidth());
        this.cIu.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cIO = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cIO) {
                this.cId.setText(d.l.level_up);
                if (f >= 1.0f) {
                    i = this.bth;
                } else {
                    i = this.bth + 1;
                }
                i ahq = this.crm.ahq();
                if (ahq != null && ahq.aPg() != null) {
                    ahq.aPg().setUser_level(i);
                }
                this.cIY.setText(this.aby.getResources().getString(d.l.lv_num, Integer.valueOf(i)));
            } else {
                this.cId.setText(this.cIB);
                this.cIY.setText(this.aby.getResources().getString(d.l.lv_num, Integer.valueOf(this.bth)));
            }
            this.cIe.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, jg(this.bth)));
            if (this.cIO) {
                if (f >= 1.0f) {
                    a(this.crm.getBaseFragmentActivity(), this.cIe, this.cIP, f);
                } else {
                    b(this.crm.getBaseFragmentActivity(), this.cIe, this.cIP, f);
                }
            } else {
                a(this.crm.getBaseFragmentActivity(), this.cIe, this.cIP, f);
            }
            this.cIP = f;
        }
    }

    private int[] jg(int i) {
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
    protected void aiT() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiU() {
        if (this.mMemberType != 0) {
            aj.c(this.cIt, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cIt, d.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cuY);
    }

    public FrsEntranceStoryListWrapperView aiV() {
        return this.cuX;
    }
}
