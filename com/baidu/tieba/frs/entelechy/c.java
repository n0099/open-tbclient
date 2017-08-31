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
    private RelativeLayout aWI;
    private TextView ctZ;
    private TextView cua;
    private View cub;
    private g cuc;
    private FrsHeaderPraiseView cue;
    private FrsEntranceStoryListWrapperView cuf;
    private CustomMessageListener cug = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cHl != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bBg.setVisibility(8);
                } else {
                    c.this.bBg.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cud = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aWI = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cqt = fVar;
        this.aby = fVar.getPageContext();
        this.cHc = k.g(fVar.getPageContext().getPageActivity(), d.f.ds20);
        this.cHd = k.g(fVar.getPageContext().getPageActivity(), d.f.ds72);
        this.cHe = k.g(fVar.getPageContext().getPageActivity(), d.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aYU = aiz();
        this.aWI = (RelativeLayout) this.aYU.findViewById(d.h.container);
        this.aWI.setPadding(0, 0, 0, 0);
        this.cHw = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aYU.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, k.g(this.aby.getPageActivity(), d.f.ds60)).setMargins(0, k.g(this.aby.getPageActivity(), d.f.ds220), 0, 0);
        this.cHz = (ImageView) this.aYU.findViewById(d.h.speed_icon);
        this.ctZ = (TextView) this.aYU.findViewById(d.h.member_image);
        this.cua = (TextView) this.aYU.findViewById(d.h.post_image);
        this.cHj = (TextView) this.aYU.findViewById(d.h.level_name);
        this.cIe = (TextView) this.aYU.findViewById(d.h.level);
        this.cHh = (TextView) this.aYU.findViewById(d.h.tv_love);
        this.cHi = (TextView) this.aYU.findViewById(d.h.tv_sign);
        this.cHi.setContentDescription(fVar.getResources().getString(d.l.sign));
        this.cHk = (ImageView) this.aYU.findViewById(d.h.love_level_top);
        this.cHf = (TextView) this.aYU.findViewById(d.h.member_num_text);
        this.cHg = (TextView) this.aYU.findViewById(d.h.post_num_text);
        this.cHB = (BarImageView) this.aYU.findViewById(d.h.frs_image);
        this.cot = (TextView) this.aYU.findViewById(d.h.forum_name);
        this.cHB.setPageId(this.cqt.getUniqueId());
        this.cHB.setContentDescription(fVar.getResources().getString(d.l.bar_header));
        this.cHB.setGifIconSupport(false);
        this.cHB.setDrawerType(0);
        this.cHl = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(d.j.frs_header_extra_entelechy, (ViewGroup) null);
        aip();
        aiw();
        aiv();
        this.cHm = (ViewGroup) this.cHl.findViewById(d.h.frs_header_games);
        this.cHn = (TextView) this.cHl.findViewById(d.h.top_item_title);
        this.cHs = (LinearLayout) this.cHl.findViewById(d.h.frs_present_root);
        this.bBg = this.cHl.findViewById(d.h.divider_bottom);
        this.cub = this.cHl.findViewById(d.h.stroy_divider_bottom);
        this.cHF = new e(this.aby, this.cHl);
        this.cHE = new com.baidu.tieba.frs.g.b(this.aby);
        this.cHo = (ViewGroup) this.cHl.findViewById(d.h.frs_headline);
        this.cHp = (TextView) this.cHo.findViewById(d.h.headline_title);
        this.cHq = (TextView) this.cHo.findViewById(d.h.headline_text);
        this.cHr = (TbImageView) this.cHo.findViewById(d.h.headline_image);
        this.cHr.setPageId(this.cqt.getUniqueId());
        this.cHo.setVisibility(8);
        this.cId = this.aYU.findViewById(d.h.level_container);
        this.cIc = (RelativeLayout) this.aYU.findViewById(d.h.has_focused_container);
        this.cIb = (RelativeLayout) this.aYU.findViewById(d.h.not_focused_container);
        this.cIf = (RelativeLayout) this.aYU.findViewById(d.h.head_content_container);
        aix();
        this.cqt.registerListener(this.cug);
    }

    private void aiv() {
        this.cue = (FrsHeaderPraiseView) this.cHl.findViewById(d.h.frs_praise_layout);
    }

    private void aiw() {
        this.cuf = (FrsEntranceStoryListWrapperView) this.cHl.findViewById(d.h.listview_story_wrapper_view);
        this.cuf.p(this.cqt.getPageContext());
    }

    private void aix() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.cHG = (ag) runTask.getData();
            this.cHG.a(this.aby, this.aYU, 1, false, this.cqt.getUniqueId());
            this.cHG.hide();
        }
    }

    private void aiy() {
        final m bqT = this.cvG.bqT();
        if (bqT != null && this.cvG.aOV() != null) {
            final String id = this.cvG.aOV().getId();
            final String name = this.cvG.aOV().getName();
            if (this.cHZ.add(bqT.pC())) {
                a.C0124a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bqT.pC(), id, name, null);
                b.cj("obj_url", bqT.getUrl());
                b.save();
            }
            this.cHo.setVisibility(0);
            this.cHp.setText(bqT.getText());
            this.cHq.setText(bqT.getTitle());
            this.cHr.c(bqT.pB(), 10, false);
            this.cHo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0124a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bqT.pC(), id, name, null);
                    b2.cj("obj_url", bqT.getUrl());
                    b2.save();
                    au.wd().c(c.this.cqt.getPageContext(), new String[]{bqT.getUrl()});
                }
            });
        }
    }

    protected View aiz() {
        return LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(d.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cHB.setOnClickListener(onClickListener);
        this.cot.setOnClickListener(onClickListener);
        this.cHi.setOnClickListener(onClickListener);
        this.cHh.setOnClickListener(onClickListener);
        this.cId.setOnClickListener(onClickListener);
        if (this.cHm != null) {
            this.cHm.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.aby.getLayoutMode().ah(i == 1);
        this.aby.getLayoutMode().t(this.aYU);
        this.aby.getLayoutMode().t(this.cHw);
        this.aby.getLayoutMode().t(this.cHl);
        if (this.cHT) {
            jZ(1);
        } else {
            jZ(0);
        }
        this.cHB.invalidate();
        aj.k(this.aWI, d.e.cp_bg_line_d);
        aj.k(this.bBg, d.e.cp_bg_line_c);
        aj.i(this.cIe, d.e.cp_cont_f);
        aj.i(this.cHj, d.e.cp_cont_f);
        aj.i(this.ctZ, d.e.cp_cont_d);
        aj.i(this.cHf, d.e.cp_cont_b);
        aj.i(this.cua, d.e.cp_cont_d);
        aj.i(this.cHg, d.e.cp_cont_b);
        if (this.cuf != null) {
            aj.k(this.cuf, d.e.cp_bg_line_d);
        }
        aiA();
        if (this.cHm != null) {
            aj.j(this.cHm, d.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.cHz, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cHz, d.g.icon_sml_speed_gray);
        }
        if (this.cHF != null) {
            this.cHF.changeSkinType(i);
        }
        if (this.cHG != null) {
            this.cHG.changeSkinType(i);
        }
        if (this.cHC != null) {
            this.cHC.du(i);
        }
        Iterator<TbImageView> it = this.cud.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        air();
        aj.j(this.cHo, d.g.home_thread_card_item_bg);
        aj.i(this.cot, d.e.cp_cont_b);
        if (this.ctV != null) {
            com.baidu.tbadk.o.a.a(this.cqt.getPageContext(), this.ctV);
        }
        if (this.cuf.getVisibility() == 0) {
            this.cuf.changeSkinType(i);
            aj.k(this.cub, d.e.cp_bg_line_c);
        }
        if (this.cue.getVisibility() == 0) {
            this.cue.changeSkinType(i);
        }
    }

    protected void aiA() {
        Drawable drawable = aj.getDrawable(d.g.icon_add_follow_blue_selector);
        int g = k.g(this.aby.getPageActivity(), d.f.ds8);
        int g2 = k.g(this.aby.getPageActivity(), d.f.ds18);
        drawable.setBounds(0, g, g2, g2);
        this.cHh.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aj.c(this.cHh, d.g.frs_head_attention_text_bg, 1);
        aj.j(this.cHh, d.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, i iVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cHL = forumData.getPost_num();
            this.cHI = forumData.getTag_color();
            this.VC = forumData.getImage_url();
            this.cHH = forumData.getLevelName();
            this.bsN = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cHM = forumData.getSignData().count_sign_num;
                this.cHN = forumData.getSignData().miss_sign_num;
            }
            this.cHO = forumData.getCurScore();
            this.cGt = forumData.getLevelupScore();
            this.cHD = forumData.getBadgeData();
            this.cHt = forumData.getTopCode();
            this.cHu = forumData.getNewsInfo();
            this.cHJ = forumData.getAccelerateContent();
            this.cvG = iVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aYU.setVisibility(8);
            } else {
                this.aYU.setVisibility(0);
            }
            this.cHK = new bj();
            aiB();
            aiE();
            aiy();
            if (this.cvG != null) {
                this.cuf.b(this.cvG.bqn(), this.cqt.getForumId(), "0");
            } else {
                this.cuf.setVisibility(8);
                this.cub.setVisibility(8);
            }
            this.cue.setVisibility(8);
            if (this.cuc == null) {
                this.cuc = new g(this.cqt.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cuf.setOnClick(this.cuc);
            }
        }
    }

    protected void aiB() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.VC);
        this.cHK.rL().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiC() {
        if (this.cHN > 0) {
            aj.c(this.cHi, d.g.frs_head_text_btn_bg, 1);
            this.cHi.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cHi.setText(String.format(this.aby.getString(d.l.miss_sign_days), Integer.valueOf(this.cHN)));
        } else {
            this.cHi.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.c(this.cHi, d.e.cp_cont_e, 1);
            this.cHi.setText(this.aby.getString(d.l.signed));
        }
        this.cHi.setTextSize(0, k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds28));
        this.cHi.setBackgroundDrawable(null);
        this.cHi.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiD() {
        aj.c(this.cHi, d.g.frs_head_attention_text_bg, 1);
        this.cHi.setTextSize(0, k.g(TbadkCoreApplication.getInst().getContext(), d.f.ds24));
        this.cHi.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.cHi, d.g.frs_attention_btn_bg_selector);
    }

    protected void aiE() {
        if (this.cHf != null) {
            this.cHf.setText(am.u(this.mMemberNum));
        }
        if (this.cHg != null) {
            this.cHg.setText(am.u(this.cHL));
        }
        if (this.cHD != null && this.cHD.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.aby.getString(d.l.forum));
            }
            if (this.cot != null) {
                this.cot.setText(this.mForumName + this.aby.getString(d.l.forum));
            }
        }
        if (this.cHm != null && this.cHn != null) {
            if (this.cvG != null && this.cvG.bqz()) {
                if (com.baidu.tbadk.core.util.m.dF(this.cvG.bqC()) == 1 && !n.afv) {
                    this.cHm.setVisibility(8);
                } else {
                    this.cHm.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cvG.getGameName()) && !TextUtils.isEmpty(this.cvG.getGameName().trim())) {
                        this.cHn.setText(UtilHelper.getFixedText(this.cvG.getGameName(), 10));
                        String sk = com.baidu.tieba.tbadkCore.util.b.sk(this.cvG.bqC());
                        if (!StringUtils.isNull(sk)) {
                            TiebaStatic.eventStat(this.aby.getPageActivity(), "game_show", "show", 1, "dev_id", sk, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cHn.setText(this.aby.getResources().getString(d.l.frsgame_title));
                    }
                }
            } else {
                this.cHm.setVisibility(8);
            }
        }
        this.ctX.clearData();
        if (this.cvG != null && !v.v(this.cvG.bqA())) {
            List<com.baidu.tieba.tbadkCore.e> bqA = this.cvG.bqA();
            aY(bqA);
            this.ctX.aX(bqA);
        }
        this.cHs.setVisibility(8);
        this.cHF.a(null, null);
        aiF();
        aiG();
        aiq();
    }

    protected void aiF() {
        this.cHB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cHB.c(this.VC, 15, false);
    }

    protected void aiG() {
        this.ctT.fq(false);
        if (this.cHm.getVisibility() == 0) {
            View findViewById = this.cHm.findViewById(d.h.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.ctT.fq(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cIa);
            if (this.cHv == null) {
                this.cHv = new PopupWindow(this.aby.getPageActivity());
                this.cHv.setContentView(this.cHw);
                this.cHv.setBackgroundDrawable(new BitmapDrawable());
                this.cHv.setOutsideTouchable(true);
                this.cHv.setFocusable(true);
                this.cHv.setWidth(this.aby.getResources().getDimensionPixelSize(d.f.ds228));
                this.cHv.setHeight(this.aby.getResources().getDimensionPixelSize(d.f.ds100));
                this.cHx = (TextView) this.cHw.findViewById(d.h.cur_experience);
                this.cHy = (TextView) this.cHw.findViewById(d.h.levelup_experience);
                a(this.cHx, this.cHy);
            }
            if (this.cHv.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cHv, this.aby.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cHx, this.cHy);
            if (iArr[1] - this.cHv.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cHv, this.aby.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cHv, this.aYU, 0, iArr[0], iArr[1] - this.cHv.getHeight());
            this.cHv.update();
            this.mHandler.postDelayed(this.cIa, 2000L);
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
            if (!TextUtils.isEmpty(this.cHJ) && !TextUtils.isEmpty(this.cHJ.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cHJ);
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
    public void aiH() {
        View contentView;
        if (this.cHA == null) {
            this.cHA = new PopupWindow(this.aby.getPageActivity());
            contentView = LayoutInflater.from(this.aby.getContext()).inflate(d.j.speed_tip, (ViewGroup) null);
            this.cHA.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.aby != null && c.this.aby.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cHA, c.this.aby.getPageActivity());
                        c.this.cqt.coR = false;
                        com.baidu.tbadk.browser.a.a(c.this.aby.getPageActivity(), c.this.aby.getResources().getString(d.l.experion_speed), com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cHA.setWidth(this.aby.getResources().getDimensionPixelSize(d.f.ds300));
            this.cHA.setHeight(this.aby.getResources().getDimensionPixelSize(d.f.ds88));
            this.cHA.setBackgroundDrawable(new BitmapDrawable());
            this.cHA.setOutsideTouchable(true);
            this.cHA.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cHA);
                        c.this.cqt.coR = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cHA.getContentView();
        }
        this.aby.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cHz.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cHA, this.aYU, 0, (iArr[0] - (this.cHA.getWidth() / 2)) + (this.cHz.getWidth() / 2), iArr[1] + this.cHz.getWidth());
        this.cHA.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cHU = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cHU) {
                this.cHj.setText(d.l.level_up);
                if (f >= 1.0f) {
                    i = this.bsN;
                } else {
                    i = this.bsN + 1;
                }
                i ahf = this.cqt.ahf();
                if (ahf != null && ahf.aOV() != null) {
                    ahf.aOV().setUser_level(i);
                }
                this.cIe.setText(this.aby.getResources().getString(d.l.lv_num, Integer.valueOf(i)));
            } else {
                this.cHj.setText(this.cHH);
                this.cIe.setText(this.aby.getResources().getString(d.l.lv_num, Integer.valueOf(this.bsN)));
            }
            this.cHk.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, je(this.bsN)));
            if (this.cHU) {
                if (f >= 1.0f) {
                    a(this.cqt.getBaseFragmentActivity(), this.cHk, this.cHV, f);
                } else {
                    b(this.cqt.getBaseFragmentActivity(), this.cHk, this.cHV, f);
                }
            } else {
                a(this.cqt.getBaseFragmentActivity(), this.cHk, this.cHV, f);
            }
            this.cHV = f;
        }
    }

    private int[] je(int i) {
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
    protected void aiI() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiJ() {
        if (this.mMemberType != 0) {
            aj.c(this.cHz, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cHz, d.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cug);
    }

    public FrsEntranceStoryListWrapperView aiK() {
        return this.cuf;
    }
}
