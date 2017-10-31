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
    private RelativeLayout aYw;
    private TextView cCP;
    private TextView cCQ;
    private View cCR;
    private ImageView cCS;
    private g cCT;
    private FrsHeaderPraiseView cCV;
    private FrsEntranceStoryListWrapperView cCW;
    private String cCX;
    private int[] cCY = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener cCZ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cRV != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bKG.setVisibility(8);
                } else {
                    c.this.bKG.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cCU = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aYw = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cyR = fVar;
        this.abI = fVar.getPageContext();
        this.cRM = l.f(fVar.getPageContext().getPageActivity(), d.e.ds20);
        this.cRN = l.f(fVar.getPageContext().getPageActivity(), d.e.ds72);
        this.cRO = l.f(fVar.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.baW = akV();
        this.aYw = (RelativeLayout) this.baW.findViewById(d.g.container);
        this.aYw.setPadding(0, 0, 0, 0);
        this.cSg = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.baW.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, l.f(this.abI.getPageActivity(), d.e.ds60)).setMargins(0, l.f(this.abI.getPageActivity(), d.e.ds220), 0, 0);
        this.cSj = (ImageView) this.baW.findViewById(d.g.speed_icon);
        this.cCP = (TextView) this.baW.findViewById(d.g.member_image);
        this.cCQ = (TextView) this.baW.findViewById(d.g.post_image);
        this.cRT = (TextView) this.baW.findViewById(d.g.level_name);
        this.cSO = (TextView) this.baW.findViewById(d.g.level);
        this.cRR = (TextView) this.baW.findViewById(d.g.tv_love);
        this.cRS = (TextView) this.baW.findViewById(d.g.tv_sign);
        this.cRS.setContentDescription(fVar.getResources().getString(d.j.sign));
        this.cRU = (ImageView) this.baW.findViewById(d.g.love_level_top);
        this.cRP = (TextView) this.baW.findViewById(d.g.member_num_text);
        this.cRQ = (TextView) this.baW.findViewById(d.g.post_num_text);
        this.cSl = (BarImageView) this.baW.findViewById(d.g.frs_image);
        this.cwS = (TextView) this.baW.findViewById(d.g.forum_name);
        this.cSl.setPageId(this.cyR.getUniqueId());
        this.cSl.setContentDescription(fVar.getResources().getString(d.j.bar_header));
        this.cSl.setGifIconSupport(false);
        this.cSl.setDrawerType(0);
        this.cRV = LayoutInflater.from(this.cyR.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        akL();
        akS();
        akR();
        this.cRW = (ViewGroup) this.cRV.findViewById(d.g.frs_header_games);
        this.cRX = (TextView) this.cRV.findViewById(d.g.top_item_title);
        this.cSc = (LinearLayout) this.cRV.findViewById(d.g.frs_present_root);
        this.bKG = this.cRV.findViewById(d.g.divider_bottom);
        this.cCR = this.cRV.findViewById(d.g.stroy_divider_bottom);
        this.cSp = new e(this.abI, this.cRV);
        this.cSo = new com.baidu.tieba.frs.f.b(this.abI);
        this.cRY = (ViewGroup) this.cRV.findViewById(d.g.frs_headline);
        this.cRZ = (TextView) this.cRY.findViewById(d.g.headline_title);
        this.cSa = (TextView) this.cRY.findViewById(d.g.headline_text);
        this.cSb = (TbImageView) this.cRY.findViewById(d.g.headline_image);
        this.cSb.setPageId(this.cyR.getUniqueId());
        this.cRY.setVisibility(8);
        this.cSN = this.baW.findViewById(d.g.level_container);
        this.cSM = (RelativeLayout) this.baW.findViewById(d.g.has_focused_container);
        this.cSL = (RelativeLayout) this.baW.findViewById(d.g.not_focused_container);
        this.cSP = (RelativeLayout) this.baW.findViewById(d.g.head_content_container);
        this.cCS = (ImageView) this.baW.findViewById(d.g.single_bar_level);
        this.cCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.abI.getPageActivity(), (String) null, true, 11003)));
                } else if (!j.hh()) {
                    l.showToast(c.this.abI.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.cCX) && !StringUtils.isNull(c.this.mForumId)) {
                    av.vI().c(c.this.abI, new String[]{c.this.cCX + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        akT();
        this.cyR.registerListener(this.cCZ);
    }

    private void akR() {
        this.cCV = (FrsHeaderPraiseView) this.cRV.findViewById(d.g.frs_praise_layout);
    }

    private void akS() {
        this.cCW = (FrsEntranceStoryListWrapperView) this.cRV.findViewById(d.g.listview_story_wrapper_view);
        this.cCW.m(this.cyR.getPageContext());
    }

    private void akT() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ah.class);
        if (runTask != null && runTask.getData() != null) {
            this.cSq = (ah) runTask.getData();
            this.cSq.a(this.abI, this.baW, 1, false, this.cyR.getUniqueId());
            this.cSq.hide();
        }
    }

    private void akU() {
        final m bsX = this.cET.bsX();
        if (bsX != null && this.cET.aPM() != null) {
            final String id = this.cET.aPM().getId();
            final String name = this.cET.aPM().getName();
            if (this.cSJ.add(bsX.pB())) {
                a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bsX.pB(), id, name, null);
                b.ca("obj_url", bsX.getUrl());
                b.save();
            }
            this.cRY.setVisibility(0);
            this.cRZ.setText(bsX.getText());
            this.cSa.setText(bsX.getTitle());
            this.cSb.startLoad(bsX.pA(), 10, false);
            this.cRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0126a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bsX.pB(), id, name, null);
                    b2.ca("obj_url", bsX.getUrl());
                    b2.save();
                    av.vI().c(c.this.cyR.getPageContext(), new String[]{bsX.getUrl()});
                }
            });
        }
    }

    protected View akV() {
        return LayoutInflater.from(this.cyR.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void jE(int i) {
        if (i <= 0 || i > 5) {
            this.cCS.setVisibility(8);
            this.cwS.setMaxWidth(l.f(this.abI.getPageActivity(), d.e.ds370));
            return;
        }
        this.cCS.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.cCY[i - 1]);
        this.cCS.setImageDrawable(drawable);
        this.cwS.setMaxWidth((l.f(this.abI.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.cCS.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cSl.setOnClickListener(onClickListener);
        this.cwS.setOnClickListener(onClickListener);
        this.cRS.setOnClickListener(onClickListener);
        this.cRR.setOnClickListener(onClickListener);
        this.cSN.setOnClickListener(onClickListener);
        if (this.cRW != null) {
            this.cRW.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.abI.getLayoutMode().ag(i == 1);
        this.abI.getLayoutMode().t(this.baW);
        this.abI.getLayoutMode().t(this.cSg);
        this.abI.getLayoutMode().t(this.cRV);
        if (this.cSD) {
            kE(1);
        } else {
            kE(0);
        }
        this.cSl.invalidate();
        aj.k(this.aYw, d.C0080d.cp_bg_line_d);
        aj.k(this.bKG, d.C0080d.cp_bg_line_c);
        aj.i(this.cSO, d.C0080d.cp_cont_f);
        aj.i(this.cRT, d.C0080d.cp_cont_f);
        aj.i(this.cCP, d.C0080d.cp_cont_d);
        aj.i(this.cRP, d.C0080d.cp_cont_b);
        aj.i(this.cCQ, d.C0080d.cp_cont_d);
        aj.i(this.cRQ, d.C0080d.cp_cont_b);
        if (this.cCW != null) {
            aj.k(this.cCW, d.C0080d.cp_bg_line_d);
        }
        akW();
        if (this.cRW != null) {
            aj.j(this.cRW, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.cSj, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.cSj, d.f.icon_sml_speed_gray);
        }
        if (this.cSp != null) {
            this.cSp.changeSkinType(i);
        }
        if (this.cSq != null) {
            this.cSq.changeSkinType(i);
        }
        if (this.cSm != null) {
            this.cSm.dE(i);
        }
        Iterator<TbImageView> it = this.cCU.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        akN();
        aj.j(this.cRY, d.f.home_thread_card_item_bg);
        aj.i(this.cwS, d.C0080d.cp_cont_b);
        if (this.cCL != null) {
            com.baidu.tbadk.o.a.a(this.cyR.getPageContext(), this.cCL);
        }
        if (this.cCW.getVisibility() == 0) {
            this.cCW.changeSkinType(i);
        }
        aj.k(this.cCR, d.C0080d.cp_bg_line_c);
        if (this.cCV.getVisibility() == 0) {
            this.cCV.changeSkinType(i);
        }
    }

    protected void akW() {
        Drawable drawable = aj.getDrawable(d.f.icon_add_follow_blue_selector);
        int f = l.f(this.abI.getPageActivity(), d.e.ds8);
        int f2 = l.f(this.abI.getPageActivity(), d.e.ds18);
        drawable.setBounds(0, f, f2, f2);
        this.cRR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aj.c(this.cRR, d.f.frs_head_attention_text_bg, 1);
        aj.j(this.cRR, d.f.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.j jVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cSv = forumData.getPost_num();
            this.cSs = forumData.getTag_color();
            this.VW = forumData.getImage_url();
            this.cSr = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cSw = forumData.getSignData().count_sign_num;
                this.cSx = forumData.getSignData().miss_sign_num;
            }
            this.cSy = forumData.getCurScore();
            this.cRc = forumData.getLevelupScore();
            this.cSn = forumData.getBadgeData();
            this.cSd = forumData.getTopCode();
            this.cSe = forumData.getNewsInfo();
            this.cSt = forumData.getAccelerateContent();
            this.cET = jVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.baW.setVisibility(8);
            } else {
                this.baW.setVisibility(0);
            }
            this.cSu = new bh();
            akX();
            ala();
            akU();
            if (this.cET != null) {
                this.cCW.b(this.cET.bsq(), this.cyR.getForumId(), "0");
            } else {
                this.cCW.setVisibility(8);
                this.cCR.setVisibility(8);
            }
            this.cCV.setVisibility(8);
            if (this.cCT == null) {
                this.cCT = new g(this.cyR.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cCW.setOnClick(this.cCT);
            }
            if (jVar != null && jVar.bss() != null) {
                jE(jVar.bss().grade.intValue());
                this.cCX = jVar.bss().url;
            }
        }
    }

    protected void akX() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.VW);
        this.cSu.rE().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void akY() {
        if (this.cSx > 0) {
            aj.c(this.cRS, d.f.frs_head_text_btn_bg, 1);
            this.cRS.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cRS.setText(String.format(this.abI.getString(d.j.miss_sign_days), Integer.valueOf(this.cSx)));
        } else {
            this.cRS.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.c(this.cRS, d.C0080d.cp_cont_e, 1);
            this.cRS.setText(this.abI.getString(d.j.signed));
        }
        this.cRS.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds28));
        this.cRS.setBackgroundDrawable(null);
        this.cRS.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void akZ() {
        aj.c(this.cRS, d.f.frs_head_attention_text_bg, 1);
        this.cRS.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds24));
        this.cRS.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.cRS, d.f.frs_attention_btn_bg_selector);
    }

    protected void ala() {
        if (this.cRP != null) {
            this.cRP.setText(am.u(this.mMemberNum));
        }
        if (this.cRQ != null) {
            this.cRQ.setText(am.u(this.cSv));
        }
        if (this.cSn != null && this.cSn.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.abI.getString(d.j.forum));
            }
            if (this.cwS != null) {
                this.cwS.setText(this.mForumName + this.abI.getString(d.j.forum));
            }
        }
        if (this.cRW != null && this.cRX != null) {
            if (this.cET != null && this.cET.bsD()) {
                if (com.baidu.tbadk.core.util.m.dD(this.cET.bsG()) == 1 && !n.afa) {
                    this.cRW.setVisibility(8);
                } else {
                    this.cRW.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cET.getGameName()) && !TextUtils.isEmpty(this.cET.getGameName().trim())) {
                        this.cRX.setText(UtilHelper.getFixedText(this.cET.getGameName(), 10));
                        String sD = com.baidu.tieba.tbadkCore.util.b.sD(this.cET.bsG());
                        if (!StringUtils.isNull(sD)) {
                            TiebaStatic.eventStat(this.abI.getPageActivity(), "game_show", "show", 1, "dev_id", sD, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cRX.setText(this.abI.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.cRW.setVisibility(8);
            }
        }
        this.cCN.clearData();
        if (this.cET != null && !v.v(this.cET.bsE())) {
            List<com.baidu.tieba.tbadkCore.e> bsE = this.cET.bsE();
            bb(bsE);
            this.cCN.ba(bsE);
        }
        this.cSc.setVisibility(8);
        this.cSp.a(null, null);
        alb();
        alc();
        akM();
    }

    protected void alb() {
        this.cSl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cSl.startLoad(this.VW, 15, false);
    }

    protected void alc() {
        this.cCJ.fj(false);
        if (this.cRW.getVisibility() == 0) {
            View findViewById = this.cRW.findViewById(d.g.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.cCJ.fj(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cSK);
            if (this.cSf == null) {
                this.cSf = new PopupWindow(this.abI.getPageActivity());
                this.cSf.setContentView(this.cSg);
                this.cSf.setBackgroundDrawable(new BitmapDrawable());
                this.cSf.setOutsideTouchable(true);
                this.cSf.setFocusable(true);
                this.cSf.setWidth(this.abI.getResources().getDimensionPixelSize(d.e.ds228));
                this.cSf.setHeight(this.abI.getResources().getDimensionPixelSize(d.e.ds100));
                this.cSh = (TextView) this.cSg.findViewById(d.g.cur_experience);
                this.cSi = (TextView) this.cSg.findViewById(d.g.levelup_experience);
                a(this.cSh, this.cSi);
            }
            if (this.cSf.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cSf, this.abI.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cSh, this.cSi);
            if (iArr[1] - this.cSf.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cSf, this.abI.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cSf, this.baW, 0, iArr[0], iArr[1] - this.cSf.getHeight());
            this.cSf.update();
            this.mHandler.postDelayed(this.cSK, 2000L);
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
            if (!TextUtils.isEmpty(this.cSt) && !TextUtils.isEmpty(this.cSt.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cSt);
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
    public void ald() {
        View contentView;
        if (this.cSk == null) {
            this.cSk = new PopupWindow(this.abI.getPageActivity());
            contentView = LayoutInflater.from(this.abI.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.cSk.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.abI != null && c.this.abI.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cSk, c.this.abI.getPageActivity());
                        c.this.cyR.cxq = false;
                        com.baidu.tbadk.browser.a.a(c.this.abI.getPageActivity(), c.this.abI.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cSk.setWidth(this.abI.getResources().getDimensionPixelSize(d.e.ds300));
            this.cSk.setHeight(this.abI.getResources().getDimensionPixelSize(d.e.ds88));
            this.cSk.setBackgroundDrawable(new BitmapDrawable());
            this.cSk.setOutsideTouchable(true);
            this.cSk.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cSk);
                        c.this.cyR.cxq = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cSk.getContentView();
        }
        this.abI.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cSj.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cSk, this.baW, 0, (iArr[0] - (this.cSk.getWidth() / 2)) + (this.cSj.getWidth() / 2), iArr[1] + this.cSj.getWidth());
        this.cSk.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cSE = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cSE) {
                this.cRT.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.j ajn = this.cyR.ajn();
                if (ajn != null && ajn.aPM() != null) {
                    ajn.aPM().setUser_level(i);
                }
                this.cSO.setText(this.abI.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.cRT.setText(this.cSr);
                this.cSO.setText(this.abI.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.cRU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, jF(this.mLevel)));
            if (this.cSE) {
                if (f >= 1.0f) {
                    a(this.cyR.getBaseFragmentActivity(), this.cRU, this.cSF, f);
                } else {
                    b(this.cyR.getBaseFragmentActivity(), this.cRU, this.cSF, f);
                }
            } else {
                a(this.cyR.getBaseFragmentActivity(), this.cRU, this.cSF, f);
            }
            this.cSF = f;
        }
    }

    private int[] jF(int i) {
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
    protected void ale() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void alf() {
        if (this.mMemberType != 0) {
            aj.c(this.cSj, d.f.icon_sml_speed_orange);
        } else {
            aj.c(this.cSj, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cCZ);
    }

    public FrsEntranceStoryListWrapperView alg() {
        return this.cCW;
    }
}
