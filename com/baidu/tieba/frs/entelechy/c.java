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
    private String VQ;
    private RelativeLayout aYt;
    private FrsHeaderPraiseView cvB;
    private FrsEntranceStoryListWrapperView cvC;
    private String cvD;
    private TextView cvv;
    private TextView cvw;
    private View cvx;
    private ImageView cvy;
    private g cvz;
    private int[] cvE = {d.g.icon_frs_emotion_level1, d.g.icon_frs_emotion_level2, d.g.icon_frs_emotion_level3, d.g.icon_frs_emotion_level4, d.g.icon_frs_emotion_level5};
    private CustomMessageListener cvF = new CustomMessageListener(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.cIV != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.bDI.setVisibility(8);
                } else {
                    c.this.bDI.setVisibility(0);
                }
            }
        }
    };
    private ArrayList<TbImageView> cvA = new ArrayList<>();

    public c(f fVar, String str, String str2, int i) {
        this.aYt = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.crI = fVar;
        this.abz = fVar.getPageContext();
        this.cIM = l.f(fVar.getPageContext().getPageActivity(), d.f.ds20);
        this.cIN = l.f(fVar.getPageContext().getPageActivity(), d.f.ds72);
        this.cIO = l.f(fVar.getPageContext().getPageActivity(), d.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.baE = aiO();
        this.aYt = (RelativeLayout) this.baE.findViewById(d.h.container);
        this.aYt.setPadding(0, 0, 0, 0);
        this.cJg = LayoutInflater.from(fVar.getPageContext().getPageActivity()).inflate(d.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.baE.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, l.f(this.abz.getPageActivity(), d.f.ds60)).setMargins(0, l.f(this.abz.getPageActivity(), d.f.ds220), 0, 0);
        this.cJj = (ImageView) this.baE.findViewById(d.h.speed_icon);
        this.cvv = (TextView) this.baE.findViewById(d.h.member_image);
        this.cvw = (TextView) this.baE.findViewById(d.h.post_image);
        this.cIT = (TextView) this.baE.findViewById(d.h.level_name);
        this.cJO = (TextView) this.baE.findViewById(d.h.level);
        this.cIR = (TextView) this.baE.findViewById(d.h.tv_love);
        this.cIS = (TextView) this.baE.findViewById(d.h.tv_sign);
        this.cIS.setContentDescription(fVar.getResources().getString(d.l.sign));
        this.cIU = (ImageView) this.baE.findViewById(d.h.love_level_top);
        this.cIP = (TextView) this.baE.findViewById(d.h.member_num_text);
        this.cIQ = (TextView) this.baE.findViewById(d.h.post_num_text);
        this.cJl = (BarImageView) this.baE.findViewById(d.h.frs_image);
        this.cpK = (TextView) this.baE.findViewById(d.h.forum_name);
        this.cJl.setPageId(this.crI.getUniqueId());
        this.cJl.setContentDescription(fVar.getResources().getString(d.l.bar_header));
        this.cJl.setGifIconSupport(false);
        this.cJl.setDrawerType(0);
        this.cIV = LayoutInflater.from(this.crI.getPageContext().getPageActivity()).inflate(d.j.frs_header_extra_entelechy, (ViewGroup) null);
        aiE();
        aiL();
        aiK();
        this.cIW = (ViewGroup) this.cIV.findViewById(d.h.frs_header_games);
        this.cIX = (TextView) this.cIV.findViewById(d.h.top_item_title);
        this.cJc = (LinearLayout) this.cIV.findViewById(d.h.frs_present_root);
        this.bDI = this.cIV.findViewById(d.h.divider_bottom);
        this.cvx = this.cIV.findViewById(d.h.stroy_divider_bottom);
        this.cJp = new e(this.abz, this.cIV);
        this.cJo = new com.baidu.tieba.frs.g.b(this.abz);
        this.cIY = (ViewGroup) this.cIV.findViewById(d.h.frs_headline);
        this.cIZ = (TextView) this.cIY.findViewById(d.h.headline_title);
        this.cJa = (TextView) this.cIY.findViewById(d.h.headline_text);
        this.cJb = (TbImageView) this.cIY.findViewById(d.h.headline_image);
        this.cJb.setPageId(this.crI.getUniqueId());
        this.cIY.setVisibility(8);
        this.cJN = this.baE.findViewById(d.h.level_container);
        this.cJM = (RelativeLayout) this.baE.findViewById(d.h.has_focused_container);
        this.cJL = (RelativeLayout) this.baE.findViewById(d.h.not_focused_container);
        this.cJP = (RelativeLayout) this.baE.findViewById(d.h.head_content_container);
        this.cvy = (ImageView) this.baE.findViewById(d.h.single_bar_level);
        this.cvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ak("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) c.this.abz.getPageActivity(), (String) null, true, 11003)));
                } else if (!j.hh()) {
                    l.showToast(c.this.abz.getPageActivity(), d.l.neterror);
                } else if (!StringUtils.isNull(c.this.cvD) && !StringUtils.isNull(c.this.mForumId)) {
                    c.this.abz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonEmotionManagerActivityConfig(c.this.abz.getPageActivity(), c.this.cvD + "?forum_id=" + c.this.mForumId)));
                }
            }
        });
        aiM();
        this.crI.registerListener(this.cvF);
    }

    private void aiK() {
        this.cvB = (FrsHeaderPraiseView) this.cIV.findViewById(d.h.frs_praise_layout);
    }

    private void aiL() {
        this.cvC = (FrsEntranceStoryListWrapperView) this.cIV.findViewById(d.h.listview_story_wrapper_view);
        this.cvC.m(this.crI.getPageContext());
    }

    private void aiM() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ah.class);
        if (runTask != null && runTask.getData() != null) {
            this.cJq = (ah) runTask.getData();
            this.cJq.a(this.abz, this.baE, 1, false, this.crI.getUniqueId());
            this.cJq.hide();
        }
    }

    private void aiN() {
        final m bqa = this.cxo.bqa();
        if (bqa != null && this.cxo.aMZ() != null) {
            final String id = this.cxo.aMZ().getId();
            final String name = this.cxo.aMZ().getName();
            if (this.cJJ.add(bqa.pD())) {
                a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bqa.pD(), id, name, null);
                b.ce("obj_url", bqa.getUrl());
                b.save();
            }
            this.cIY.setVisibility(0);
            this.cIZ.setText(bqa.getText());
            this.cJa.setText(bqa.getTitle());
            this.cJb.c(bqa.pC(), 10, false);
            this.cIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0126a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bqa.pD(), id, name, null);
                    b2.ce("obj_url", bqa.getUrl());
                    b2.save();
                    av.vH().c(c.this.crI.getPageContext(), new String[]{bqa.getUrl()});
                }
            });
        }
    }

    protected View aiO() {
        return LayoutInflater.from(this.crI.getPageContext().getPageActivity()).inflate(d.j.frs_normal_header, (ViewGroup) null);
    }

    private void jo(int i) {
        if (i <= 0 || i > 5) {
            this.cvy.setVisibility(8);
            this.cpK.setMaxWidth(l.f(this.abz.getPageActivity(), d.f.ds370));
            return;
        }
        this.cvy.setVisibility(0);
        Drawable drawable = aj.getDrawable(this.cvE[i - 1]);
        this.cvy.setImageDrawable(drawable);
        this.cpK.setMaxWidth((l.f(this.abz.getPageActivity(), d.f.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.cvy.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cJl.setOnClickListener(onClickListener);
        this.cpK.setOnClickListener(onClickListener);
        this.cIS.setOnClickListener(onClickListener);
        this.cIR.setOnClickListener(onClickListener);
        this.cJN.setOnClickListener(onClickListener);
        if (this.cIW != null) {
            this.cIW.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.abz.getLayoutMode().ai(i == 1);
        this.abz.getLayoutMode().t(this.baE);
        this.abz.getLayoutMode().t(this.cJg);
        this.abz.getLayoutMode().t(this.cIV);
        if (this.cJD) {
            kj(1);
        } else {
            kj(0);
        }
        this.cJl.invalidate();
        aj.k(this.aYt, d.e.cp_bg_line_d);
        aj.k(this.bDI, d.e.cp_bg_line_c);
        aj.i(this.cJO, d.e.cp_cont_f);
        aj.i(this.cIT, d.e.cp_cont_f);
        aj.i(this.cvv, d.e.cp_cont_d);
        aj.i(this.cIP, d.e.cp_cont_b);
        aj.i(this.cvw, d.e.cp_cont_d);
        aj.i(this.cIQ, d.e.cp_cont_b);
        if (this.cvC != null) {
            aj.k(this.cvC, d.e.cp_bg_line_d);
        }
        aiP();
        if (this.cIW != null) {
            aj.j(this.cIW, d.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aj.c(this.cJj, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cJj, d.g.icon_sml_speed_gray);
        }
        if (this.cJp != null) {
            this.cJp.changeSkinType(i);
        }
        if (this.cJq != null) {
            this.cJq.changeSkinType(i);
        }
        if (this.cJm != null) {
            this.cJm.dE(i);
        }
        Iterator<TbImageView> it = this.cvA.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aiG();
        aj.j(this.cIY, d.g.home_thread_card_item_bg);
        aj.i(this.cpK, d.e.cp_cont_b);
        if (this.cvr != null) {
            com.baidu.tbadk.n.a.a(this.crI.getPageContext(), this.cvr);
        }
        if (this.cvC.getVisibility() == 0) {
            this.cvC.changeSkinType(i);
            aj.k(this.cvx, d.e.cp_bg_line_c);
        }
        if (this.cvB.getVisibility() == 0) {
            this.cvB.changeSkinType(i);
        }
    }

    protected void aiP() {
        Drawable drawable = aj.getDrawable(d.g.icon_add_follow_blue_selector);
        int f = l.f(this.abz.getPageActivity(), d.f.ds8);
        int f2 = l.f(this.abz.getPageActivity(), d.f.ds18);
        drawable.setBounds(0, f, f2, f2);
        this.cIR.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        aj.c(this.cIR, d.g.frs_head_attention_text_bg, 1);
        aj.j(this.cIR, d.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, i iVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cJv = forumData.getPost_num();
            this.cJs = forumData.getTag_color();
            this.VQ = forumData.getImage_url();
            this.cJr = forumData.getLevelName();
            this.buT = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cJw = forumData.getSignData().count_sign_num;
                this.cJx = forumData.getSignData().miss_sign_num;
            }
            this.cJy = forumData.getCurScore();
            this.cIe = forumData.getLevelupScore();
            this.cJn = forumData.getBadgeData();
            this.cJd = forumData.getTopCode();
            this.cJe = forumData.getNewsInfo();
            this.cJt = forumData.getAccelerateContent();
            this.cxo = iVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.baE.setVisibility(8);
            } else {
                this.baE.setVisibility(0);
            }
            this.cJu = new bh();
            aiQ();
            aiT();
            aiN();
            if (this.cxo != null) {
                this.cvC.b(this.cxo.bpt(), this.crI.getForumId(), "0");
            } else {
                this.cvC.setVisibility(8);
                this.cvx.setVisibility(8);
            }
            this.cvB.setVisibility(8);
            if (this.cvz == null) {
                this.cvz = new g(this.crI.getPageContext(), 2, com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.mForumName);
                this.cvC.setOnClick(this.cvz);
            }
            if (iVar != null && iVar.bpv() != null) {
                jo(iVar.bpv().grade.intValue());
                this.cvD = iVar.bpv().url;
            }
        }
    }

    protected void aiQ() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.VQ);
        this.cJu.rF().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiR() {
        if (this.cJx > 0) {
            aj.c(this.cIS, d.g.frs_head_text_btn_bg, 1);
            this.cIS.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cIS.setText(String.format(this.abz.getString(d.l.miss_sign_days), Integer.valueOf(this.cJx)));
        } else {
            this.cIS.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.c(this.cIS, d.e.cp_cont_e, 1);
            this.cIS.setText(this.abz.getString(d.l.signed));
        }
        this.cIS.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.f.ds28));
        this.cIS.setBackgroundDrawable(null);
        this.cIS.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aiS() {
        aj.c(this.cIS, d.g.frs_head_attention_text_bg, 1);
        this.cIS.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.f.ds24));
        this.cIS.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.cIS, d.g.frs_attention_btn_bg_selector);
    }

    protected void aiT() {
        if (this.cIP != null) {
            this.cIP.setText(am.t(this.mMemberNum));
        }
        if (this.cIQ != null) {
            this.cIQ.setText(am.t(this.cJv));
        }
        if (this.cJn != null && this.cJn.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.abz.getString(d.l.forum));
            }
            if (this.cpK != null) {
                this.cpK.setText(this.mForumName + this.abz.getString(d.l.forum));
            }
        }
        if (this.cIW != null && this.cIX != null) {
            if (this.cxo != null && this.cxo.bpG()) {
                if (com.baidu.tbadk.core.util.m.dy(this.cxo.bpJ()) == 1 && !n.aeR) {
                    this.cIW.setVisibility(8);
                } else {
                    this.cIW.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cxo.getGameName()) && !TextUtils.isEmpty(this.cxo.getGameName().trim())) {
                        this.cIX.setText(UtilHelper.getFixedText(this.cxo.getGameName(), 10));
                        String rW = com.baidu.tieba.tbadkCore.util.b.rW(this.cxo.bpJ());
                        if (!StringUtils.isNull(rW)) {
                            TiebaStatic.eventStat(this.abz.getPageActivity(), "game_show", "show", 1, "dev_id", rW, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cIX.setText(this.abz.getResources().getString(d.l.frsgame_title));
                    }
                }
            } else {
                this.cIW.setVisibility(8);
            }
        }
        this.cvt.clearData();
        if (this.cxo != null && !v.u(this.cxo.bpH())) {
            List<com.baidu.tieba.tbadkCore.e> bpH = this.cxo.bpH();
            aY(bpH);
            this.cvt.aX(bpH);
        }
        this.cJc.setVisibility(8);
        this.cJp.a(null, null);
        aiU();
        aiV();
        aiF();
    }

    protected void aiU() {
        this.cJl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cJl.c(this.VQ, 15, false);
    }

    protected void aiV() {
        this.cvp.fl(false);
        if (this.cIW.getVisibility() == 0) {
            View findViewById = this.cIW.findViewById(d.h.top_item_divider);
            if (findViewById != null) {
                findViewById.setVisibility(8);
                return;
            }
            return;
        }
        this.cvp.fl(true);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void g(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cJK);
            if (this.cJf == null) {
                this.cJf = new PopupWindow(this.abz.getPageActivity());
                this.cJf.setContentView(this.cJg);
                this.cJf.setBackgroundDrawable(new BitmapDrawable());
                this.cJf.setOutsideTouchable(true);
                this.cJf.setFocusable(true);
                this.cJf.setWidth(this.abz.getResources().getDimensionPixelSize(d.f.ds228));
                this.cJf.setHeight(this.abz.getResources().getDimensionPixelSize(d.f.ds100));
                this.cJh = (TextView) this.cJg.findViewById(d.h.cur_experience);
                this.cJi = (TextView) this.cJg.findViewById(d.h.levelup_experience);
                a(this.cJh, this.cJi);
            }
            if (this.cJf.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.cJf, this.abz.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cJh, this.cJi);
            if (iArr[1] - this.cJf.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.cJf, this.abz.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cJf, this.baE, 0, iArr[0], iArr[1] - this.cJf.getHeight());
            this.cJf.update();
            this.mHandler.postDelayed(this.cJK, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.abz.getContext()).inflate(d.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.h.speed_tip);
            aj.c((TextView) inflate.findViewById(d.h.experience_txt), d.e.cp_cont_b, 1);
            aj.c(textView, d.e.cp_cont_b, 1);
            aj.c(textView2, d.e.cp_cont_b, 1);
            aj.c(textView3, d.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abz.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cJt) && !TextUtils.isEmpty(this.cJt.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cJt);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ce(d.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.abz);
            aVar.ti();
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
                if (c.this.abz != null && c.this.abz.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.abz.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiW() {
        View contentView;
        if (this.cJk == null) {
            this.cJk = new PopupWindow(this.abz.getPageActivity());
            contentView = LayoutInflater.from(this.abz.getContext()).inflate(d.j.speed_tip, (ViewGroup) null);
            this.cJk.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.abz != null && c.this.abz.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.cJk, c.this.abz.getPageActivity());
                        c.this.crI.cqi = false;
                        com.baidu.tbadk.browser.a.a(c.this.abz.getPageActivity(), c.this.abz.getResources().getString(d.l.experion_speed), com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.cJk.setWidth(this.abz.getResources().getDimensionPixelSize(d.f.ds300));
            this.cJk.setHeight(this.abz.getResources().getDimensionPixelSize(d.f.ds88));
            this.cJk.setBackgroundDrawable(new BitmapDrawable());
            this.cJk.setOutsideTouchable(true);
            this.cJk.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.cJk);
                        c.this.crI.cqi = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.cJk.getContentView();
        }
        this.abz.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cJj.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.cJk, this.baE, 0, (iArr[0] - (this.cJk.getWidth() / 2)) + (this.cJj.getWidth() / 2), iArr[1] + this.cJj.getWidth());
        this.cJk.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.cJE = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cJE) {
                this.cIT.setText(d.l.level_up);
                if (f >= 1.0f) {
                    i = this.buT;
                } else {
                    i = this.buT + 1;
                }
                i ahk = this.crI.ahk();
                if (ahk != null && ahk.aMZ() != null) {
                    ahk.aMZ().setUser_level(i);
                }
                this.cJO.setText(this.abz.getResources().getString(d.l.lv_num, Integer.valueOf(i)));
            } else {
                this.cIT.setText(this.cJr);
                this.cJO.setText(this.abz.getResources().getString(d.l.lv_num, Integer.valueOf(this.buT)));
            }
            this.cIU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, jp(this.buT)));
            if (this.cJE) {
                if (f >= 1.0f) {
                    a(this.crI.getBaseFragmentActivity(), this.cIU, this.cJF, f);
                } else {
                    b(this.crI.getBaseFragmentActivity(), this.cIU, this.cJF, f);
                }
            } else {
                a(this.crI.getBaseFragmentActivity(), this.cIU, this.cJF, f);
            }
            this.cJF = f;
        }
    }

    private int[] jp(int i) {
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
    protected void aiX() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aiY() {
        if (this.mMemberType != 0) {
            aj.c(this.cJj, d.g.icon_sml_speed_orange);
        } else {
            aj.c(this.cJj, d.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.cvF);
    }

    public FrsEntranceStoryListWrapperView aiZ() {
        return this.cvC;
    }
}
