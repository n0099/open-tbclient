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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.util.m;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends a {
    private RelativeLayout aUI;
    private TextView cfI;
    private TextView cfJ;
    private FrsHeaderPraiseView cfL;
    private String mImageUrl;
    private CustomMessageListener cfM = new d(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> cfK = new ArrayList<>();

    public c(r rVar, String str, String str2, int i) {
        this.aUI = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.cdv = rVar;
        this.aat = rVar.getPageContext();
        this.cqj = k.g(rVar.getPageContext().getPageActivity(), w.f.ds20);
        this.cqk = k.g(rVar.getPageContext().getPageActivity(), w.f.ds72);
        this.cql = k.g(rVar.getPageContext().getPageActivity(), w.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aWF = afi();
        this.aUI = (RelativeLayout) this.aWF.findViewById(w.h.container);
        this.aUI.setPadding(0, 0, 0, 0);
        this.cqE = LayoutInflater.from(rVar.getPageContext().getPageActivity()).inflate(w.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aWF.setVisibility(8);
        }
        new FrameLayout.LayoutParams(-1, k.g(this.aat.getPageActivity(), w.f.ds60)).setMargins(0, k.g(this.aat.getPageActivity(), w.f.ds220), 0, 0);
        this.cqH = (ImageView) this.aWF.findViewById(w.h.speed_icon);
        this.cfI = (TextView) this.aWF.findViewById(w.h.member_image);
        this.cfJ = (TextView) this.aWF.findViewById(w.h.post_image);
        this.cqq = (TextView) this.aWF.findViewById(w.h.level_name);
        this.crn = (TextView) this.aWF.findViewById(w.h.level);
        this.cqo = (TextView) this.aWF.findViewById(w.h.tv_love);
        this.cqp = (TextView) this.aWF.findViewById(w.h.tv_sign);
        this.cqp.setContentDescription(rVar.getResources().getString(w.l.sign));
        this.cqr = (ImageView) this.aWF.findViewById(w.h.love_level_top);
        this.cqm = (TextView) this.aWF.findViewById(w.h.member_num_text);
        this.cqn = (TextView) this.aWF.findViewById(w.h.post_num_text);
        this.cqJ = (BarImageView) this.aWF.findViewById(w.h.frs_image);
        this.cqJ.setPageId(this.cdv.getUniqueId());
        this.cqJ.setContentDescription(rVar.getResources().getString(w.l.bar_header));
        this.cqJ.setGifIconSupport(false);
        this.cqJ.setDrawerType(0);
        this.cqs = LayoutInflater.from(this.cdv.getPageContext().getPageActivity()).inflate(w.j.frs_header_extra_entelechy, (ViewGroup) null);
        afa();
        aff();
        this.cqt = (ViewGroup) this.cqs.findViewById(w.h.frs_header_games);
        this.cqu = (TextView) this.cqs.findViewById(w.h.top_item_title);
        this.cqz = (LinearLayout) this.cqs.findViewById(w.h.frs_header_enter_root);
        this.cqA = (LinearLayout) this.cqs.findViewById(w.h.frs_present_root);
        this.buk = this.cqs.findViewById(w.h.divider_bottom);
        this.cqN = new com.baidu.tieba.frs.view.j(this.aat, this.cqs);
        this.cqM = new com.baidu.tieba.frs.e.b(this.aat);
        this.cqv = (ViewGroup) this.cqs.findViewById(w.h.frs_headline);
        this.cqw = (TextView) this.cqv.findViewById(w.h.headline_title);
        this.cqx = (TextView) this.cqv.findViewById(w.h.headline_text);
        this.cqy = (TbImageView) this.cqv.findViewById(w.h.headline_image);
        this.cqy.setPageId(this.cdv.getUniqueId());
        this.cqv.setVisibility(8);
        this.crm = this.aWF.findViewById(w.h.level_container);
        this.crl = (RelativeLayout) this.aWF.findViewById(w.h.has_focused_container);
        this.crk = (RelativeLayout) this.aWF.findViewById(w.h.not_focused_container);
        this.cro = (RelativeLayout) this.aWF.findViewById(w.h.head_content_container);
        afg();
        this.cdv.registerListener(this.cfM);
    }

    private void aff() {
        this.cfL = (FrsHeaderPraiseView) this.cqs.findViewById(w.h.frs_praise_layout);
    }

    private void afg() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), bx.class);
        if (runTask != null && runTask.getData() != null) {
            this.cqO = (bx) runTask.getData();
            this.cqO.a(this.aat, this.aWF, 1, false, this.cdv.getUniqueId());
            this.cqO.hide();
        }
    }

    private void afh() {
        n blb = this.chk.blb();
        if (blb != null && this.chk.aMt() != null) {
            String id = this.chk.aMt().getId();
            String name = this.chk.aMt().getName();
            if (this.cri.add(blb.pu())) {
                a.C0085a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", blb.pu(), id, name, null);
                a.cf("obj_url", blb.getUrl());
                a.save();
            }
            this.cqv.setVisibility(0);
            this.cqw.setText(blb.getText());
            this.cqx.setText(blb.getTitle());
            this.cqy.c(blb.pt(), 10, false);
            this.cqv.setOnClickListener(new e(this, blb, id, name));
        }
    }

    protected View afi() {
        return LayoutInflater.from(this.cdv.getPageContext().getPageActivity()).inflate(w.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cqJ.setOnClickListener(onClickListener);
        this.cqp.setOnClickListener(onClickListener);
        this.cqo.setOnClickListener(onClickListener);
        this.crm.setOnClickListener(onClickListener);
        if (this.cqt != null) {
            this.cqt.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.aat.getLayoutMode().ah(i == 1);
        this.aat.getLayoutMode().t(this.aWF);
        this.aat.getLayoutMode().t(this.cqE);
        this.aat.getLayoutMode().t(this.cqs);
        if (this.crb) {
            js(1);
        } else {
            js(0);
        }
        this.cqJ.invalidate();
        as.k(this.aUI, w.e.cp_bg_line_d);
        as.k(this.buk, w.e.cp_bg_line_c);
        as.i(this.crn, w.e.cp_cont_f);
        as.i(this.cqq, w.e.cp_cont_f);
        as.i(this.cfI, w.e.cp_cont_d);
        as.i(this.cqm, w.e.cp_cont_b);
        as.i(this.cfJ, w.e.cp_cont_d);
        as.i(this.cqn, w.e.cp_cont_b);
        afj();
        if (this.cqt != null) {
            as.j(this.cqt, w.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            as.c(this.cqH, w.g.icon_sml_speed_orange);
        } else {
            as.c(this.cqH, w.g.icon_sml_speed_gray);
        }
        if (this.cqN != null) {
            this.cqN.changeSkinType(i);
        }
        if (this.cqO != null) {
            this.cqO.changeSkinType(i);
        }
        if (this.cqK != null) {
            this.cqK.dp(i);
        }
        Iterator<TbImageView> it = this.cfK.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        afc();
        as.j(this.cqv, w.g.home_thread_card_item_bg);
        if (this.cfH != null) {
            com.baidu.tbadk.m.a.a(this.cdv.getPageContext(), this.cfH);
        }
        if (this.cfL.getVisibility() == 0) {
            this.cfL.changeSkinType(i);
        }
    }

    protected void afj() {
        Drawable drawable = as.getDrawable(w.g.icon_add_follow_blue_selector);
        int g = k.g(this.aat.getPageActivity(), w.f.ds8);
        int g2 = k.g(this.aat.getPageActivity(), w.f.ds18);
        drawable.setBounds(0, g, g2, g2);
        this.cqo.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        as.c(this.cqo, w.g.frs_head_attention_text_bg, 1);
        as.j(this.cqo, w.g.frs_attention_btn_bg_selector);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cqT = forumData.getPost_num();
            this.cqQ = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.cqP = forumData.getLevelName();
            this.bmb = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cqU = forumData.getSignData().count_sign_num;
                this.cqV = forumData.getSignData().miss_sign_num;
            }
            this.cqW = forumData.getCurScore();
            this.cpN = forumData.getLevelupScore();
            this.cqL = forumData.getBadgeData();
            this.cqB = forumData.getTopCode();
            this.cqC = forumData.getNewsInfo();
            this.cqR = forumData.getAccelerateContent();
            this.chk = nVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aWF.setVisibility(8);
            } else {
                this.aWF.setVisibility(0);
            }
            this.cqS = new bm();
            afk();
            afn();
            afh();
            if (this.chk != null) {
                this.cfL.setData(this.chk.bkw());
            } else {
                this.cfL.setVisibility(8);
            }
        }
    }

    protected void afk() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.cqS.rB().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void afl() {
        if (this.cqV > 0) {
            as.c(this.cqp, w.g.frs_head_text_btn_bg, 1);
            this.cqp.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.button_frs_bu_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.cqp.setText(String.format(this.aat.getString(w.l.miss_sign_days), Integer.valueOf(this.cqV)));
        } else {
            this.cqp.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.icon_public_sign_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            as.c(this.cqp, w.e.cp_cont_e, 1);
            this.cqp.setText(this.aat.getString(w.l.signed));
        }
        this.cqp.setTextSize(0, k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds28));
        this.cqp.setBackgroundDrawable(null);
        this.cqp.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void afm() {
        as.c(this.cqp, w.g.frs_head_attention_text_bg, 1);
        this.cqp.setTextSize(0, k.g(TbadkCoreApplication.m9getInst().getContext(), w.f.ds24));
        this.cqp.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.icon_public_sign_blue_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        as.j(this.cqp, w.g.frs_attention_btn_bg_selector);
    }

    protected void afn() {
        if (this.cqm != null) {
            this.cqm.setText(aw.t(this.mMemberNum));
        }
        if (this.cqn != null) {
            this.cqn.setText(aw.t(this.cqT));
        }
        if (this.bWL != null) {
            if (this.cqL != null && this.cqL.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.bWL.setText(String.valueOf(this.mForumName) + this.aat.getString(w.l.forum));
            }
        }
        if (this.cqt != null && this.cqu != null) {
            if (this.chk != null && this.chk.bkH()) {
                if (o.dB(this.chk.bkK()) == 1 && !com.baidu.tbadk.core.util.r.aek) {
                    this.cqt.setVisibility(8);
                } else {
                    this.cqt.setVisibility(0);
                    if (!TextUtils.isEmpty(this.chk.getGameName()) && !TextUtils.isEmpty(this.chk.getGameName().trim())) {
                        this.cqu.setText(UtilHelper.getFixedText(this.chk.getGameName(), 10));
                        String rr = m.rr(this.chk.bkK());
                        if (!StringUtils.isNull(rr)) {
                            TiebaStatic.eventStat(this.aat.getPageActivity(), "game_show", "show", 1, "dev_id", rr, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cqu.setText(this.aat.getResources().getString(w.l.frsgame_title));
                    }
                }
            } else {
                this.cqt.setVisibility(8);
            }
        }
        if (this.chk != null && !z.t(this.chk.bkI())) {
            List<com.baidu.tieba.tbadkCore.g> bkI = this.chk.bkI();
            aC(bkI);
            int size = bkI.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.cqz.setVisibility(0);
                this.cqz.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = bkI.get(i2);
                    if (gVar != null) {
                        String jY = jY(gVar.aEp());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.frs_header_top_item, (ViewGroup) null);
                        TextView textView = (TextView) viewGroup.findViewById(w.h.top_item_title);
                        TextView textView2 = (TextView) viewGroup.findViewById(w.h.top_item_rank);
                        textView.setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(w.h.top_item_type)).setText(jY);
                        if (gVar.aMW() != 0) {
                            textView2.setVisibility(0);
                            if (gVar.aMW() == -1) {
                                textView2.setText(this.aat.getString(w.l.no_rank));
                            } else if (gVar.aMW() > 999) {
                                textView2.setText(this.aat.getString(w.l.rang_orer_thousand));
                            } else {
                                textView2.setText(String.valueOf(this.aat.getString(w.l.rang_identify)) + String.valueOf(gVar.aMW()));
                            }
                            if (!StringUtils.isNull(gVar.getTitle())) {
                                textView.setText(aw.d(gVar.getTitle(), 30, "..."));
                            }
                        } else {
                            textView2.setVisibility(8);
                        }
                        ak(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.crp);
                        this.cqz.addView(viewGroup);
                        if (this.cri.add(gVar.bku())) {
                            a.C0085a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bku(), this.cdv.getForumId(), this.cdv.getForumName(), null);
                            a.cf("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.cqz.setVisibility(8);
            }
        } else {
            this.cqz.setVisibility(8);
        }
        this.cqA.setVisibility(8);
        this.cqN.a(null, null);
        afo();
        afp();
        afb();
    }

    protected void afo() {
        this.cqJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cqJ.c(this.mImageUrl, 15, false);
    }

    protected void afp() {
        ViewGroup aib;
        View aic;
        View findViewById;
        this.cfF.eU(false);
        if (this.cqt.getVisibility() == 0) {
            View findViewById2 = this.cqt.findViewById(w.h.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.cqt.getVisibility() == 8 && this.cqz.getVisibility() == 0) {
            if (this.cqz.getChildCount() > 0 && (findViewById = ((ViewGroup) this.cqz.getChildAt(0)).findViewById(w.h.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.cqz.getVisibility() == 8 && (aib = this.cqN.aib()) != null && aib.getVisibility() == 0 && (aic = this.cqN.aic()) != null) {
            aic.setVisibility(8);
        } else {
            this.cfF.eU(true);
        }
    }

    private String jY(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(w.l.frs_forum_member_icon_text);
        }
        return str;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void f(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.crj);
            if (this.cqD == null) {
                this.cqD = new PopupWindow(this.aat.getPageActivity());
                this.cqD.setContentView(this.cqE);
                this.cqD.setBackgroundDrawable(new BitmapDrawable());
                this.cqD.setOutsideTouchable(true);
                this.cqD.setFocusable(true);
                this.cqD.setWidth(this.aat.getResources().getDimensionPixelSize(w.f.ds228));
                this.cqD.setHeight(this.aat.getResources().getDimensionPixelSize(w.f.ds100));
                this.cqF = (TextView) this.cqE.findViewById(w.h.cur_experience);
                this.cqG = (TextView) this.cqE.findViewById(w.h.levelup_experience);
                a(this.cqF, this.cqG);
            }
            if (this.cqD.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.cqD, this.aat.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cqF, this.cqG);
            if (iArr[1] - this.cqD.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.cqD, this.aat.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.cqD, this.aWF, 0, iArr[0], iArr[1] - this.cqD.getHeight());
            this.cqD.update();
            this.mHandler.postDelayed(this.crj, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aat.getContext()).inflate(w.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(w.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(w.h.speed_tip);
            as.c((TextView) inflate.findViewById(w.h.experience_txt), w.e.cp_cont_b, 1);
            as.c(textView, w.e.cp_cont_b, 1);
            as.c(textView2, w.e.cp_cont_b, 1);
            as.c(textView3, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aat.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cqR) && !TextUtils.isEmpty(this.cqR.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cqR);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bZ(w.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aat);
            aVar.ta();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(w.l.cancel, new f(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(w.l.open_now, new g(this));
    }

    @Override // com.baidu.tieba.frs.view.b
    public void afq() {
        View contentView;
        if (this.cqI == null) {
            this.cqI = new PopupWindow(this.aat.getPageActivity());
            contentView = LayoutInflater.from(this.aat.getContext()).inflate(w.j.speed_tip, (ViewGroup) null);
            this.cqI.setContentView(contentView);
            contentView.setOnClickListener(new h(this));
            this.cqI.setWidth(this.aat.getResources().getDimensionPixelSize(w.f.ds300));
            this.cqI.setHeight(this.aat.getResources().getDimensionPixelSize(w.f.ds88));
            this.cqI.setBackgroundDrawable(new BitmapDrawable());
            this.cqI.setOutsideTouchable(true);
            this.cqI.setTouchInterceptor(new i(this));
        } else {
            contentView = this.cqI.getContentView();
        }
        this.aat.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cqH.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.cqI, this.aWF, 0, (iArr[0] - (this.cqI.getWidth() / 2)) + (this.cqH.getWidth() / 2), iArr[1] + this.cqH.getWidth());
        this.cqI.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.crd = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(w.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.crd) {
                this.cqq.setText(w.l.level_up);
                if (f >= 1.0f) {
                    i = this.bmb;
                } else {
                    i = this.bmb + 1;
                }
                com.baidu.tieba.tbadkCore.n aek = this.cdv.aek();
                if (aek != null && aek.aMt() != null) {
                    aek.aMt().setUser_level(i);
                }
                this.crn.setText(this.aat.getResources().getString(w.l.lv_num, Integer.valueOf(i)));
            } else {
                this.cqq.setText(this.cqP);
                this.crn.setText(this.aat.getResources().getString(w.l.lv_num, Integer.valueOf(this.bmb)));
            }
            this.cqr.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iE(this.bmb)));
            if (this.crd) {
                if (f >= 1.0f) {
                    a(this.cdv.getBaseFragmentActivity(), this.cqr, this.cre, f);
                } else {
                    b(this.cdv.getBaseFragmentActivity(), this.cqr, this.cre, f);
                }
            } else {
                a(this.cdv.getBaseFragmentActivity(), this.cqr, this.cre, f);
            }
            this.cre = f;
        }
    }

    private int[] iE(int i) {
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
    protected void afr() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void afs() {
        if (this.mMemberType != 0) {
            as.c(this.cqH, w.g.icon_sml_speed_orange);
        } else {
            as.c(this.cqH, w.g.icon_sml_speed_gray);
        }
    }
}
