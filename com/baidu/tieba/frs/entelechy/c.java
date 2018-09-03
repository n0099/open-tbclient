package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.NovelMainActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.frs.view.e;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class c extends a {
    private String afe;
    private RelativeLayout bmt;
    private final LinearLayout dta;
    private TextView dtb;
    private TextView dtc;
    private ImageView dtd;
    private String dte;
    private String dtf;
    private FrsHeaderPraiseView dth;
    private String dti;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dtj = {f.C0146f.icon_frs_emotion_level1, f.C0146f.icon_frs_emotion_level2, f.C0146f.icon_frs_emotion_level3, f.C0146f.icon_frs_emotion_level4, f.C0146f.icon_frs_emotion_level5};
    private View.OnClickListener dtk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
        /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            boolean z = true;
            if (c.this.mTabId == 201 || c.this.mTabId == 202) {
                if (c.this.mTabId == 202) {
                    if (StringUtils.isNull(c.this.dtf)) {
                        az.zI().c(c.this.mContext, new String[]{c.this.dte});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.abK()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dtf));
                        }
                    } else if (PluginPackageManager.lN().bL("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(f.j.plugin_video_installing), 0).xm();
                        z = false;
                    } else {
                        az.zI().c(c.this.mContext, new String[]{c.this.dte});
                        z = false;
                    }
                    an anVar = new an("c12838");
                    anVar.ae(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    anVar.ae(VideoPlayActivityConfig.OBJ_ID, c.this.dtf);
                    anVar.ae("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    anVar.ae("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(anVar);
                }
                az.zI().c(c.this.mContext, new String[]{c.this.dte});
                z = false;
                an anVar2 = new an("c12838");
                anVar2.ae(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                anVar2.ae(VideoPlayActivityConfig.OBJ_ID, c.this.dtf);
                anVar2.ae("obj_type", c.this.mTabId != 201 ? "1" : "2");
                anVar2.ae("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(anVar2);
            }
        }
    };
    private ArrayList<TbImageView> dtg = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bmt = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dnP = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dIT = l.f(frsFragment.getPageContext().getPageActivity(), f.e.ds20);
        this.dIU = l.f(frsFragment.getPageContext().getPageActivity(), f.e.ds72);
        this.dIV = l.f(frsFragment.getPageContext().getPageActivity(), f.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = awH();
        this.bmt = (RelativeLayout) this.mParent.findViewById(f.g.container);
        this.dJp = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(f.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dJs = (ImageView) this.mParent.findViewById(f.g.speed_icon);
        this.dtb = (TextView) this.mParent.findViewById(f.g.member_image);
        this.dtc = (TextView) this.mParent.findViewById(f.g.post_image);
        this.dJa = (TextView) this.mParent.findViewById(f.g.level_name);
        this.dJY = (TextView) this.mParent.findViewById(f.g.level);
        this.dIY = (TextView) this.mParent.findViewById(f.g.tv_love);
        this.dIZ = (TextView) this.mParent.findViewById(f.g.tv_sign);
        this.dIZ.setContentDescription(frsFragment.getResources().getString(f.j.sign));
        this.dJb = (ImageView) this.mParent.findViewById(f.g.love_level_top);
        this.dJc = (ImageView) this.mParent.findViewById(f.g.love_level_bg);
        this.dIW = (TextView) this.mParent.findViewById(f.g.member_num_text);
        this.dIX = (TextView) this.mParent.findViewById(f.g.post_num_text);
        this.dJu = (BarImageView) this.mParent.findViewById(f.g.frs_image);
        this.dlq = (TextView) this.mParent.findViewById(f.g.forum_name);
        this.dJP = (TextView) this.mParent.findViewById(f.g.brand_label);
        this.dJu.setPageId(this.dnP.getUniqueId());
        this.dJu.setContentDescription(frsFragment.getResources().getString(f.j.bar_header));
        this.dJu.setGifIconSupport(false);
        this.dJu.setDrawerType(0);
        this.dJd = LayoutInflater.from(this.dnP.getPageContext().getPageActivity()).inflate(f.h.frs_header_extra_entelechy, (ViewGroup) null);
        awy();
        awE();
        this.dJe = (ViewGroup) this.dJd.findViewById(f.g.frs_header_games);
        this.dJf = (TextView) this.dJd.findViewById(f.g.top_item_title);
        this.dJm = (LinearLayout) this.dJd.findViewById(f.g.frs_present_root);
        this.dKa = (TextView) this.bmt.findViewById(f.g.new_chapter_btn);
        this.dJy = new e(this.mContext, this.dJd);
        this.dJx = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dJi = (ViewGroup) this.dJd.findViewById(f.g.frs_headline);
        this.dJj = (TextView) this.dJi.findViewById(f.g.headline_title);
        this.dJk = (TextView) this.dJi.findViewById(f.g.headline_text);
        this.dJl = (TbImageView) this.dJi.findViewById(f.g.headline_image);
        this.dJl.setPageId(this.dnP.getUniqueId());
        this.dJi.setVisibility(8);
        this.dJX = this.mParent.findViewById(f.g.level_container);
        this.dJW = (RelativeLayout) this.mParent.findViewById(f.g.has_focused_container);
        this.dJV = (RelativeLayout) this.mParent.findViewById(f.g.not_focused_container);
        this.dJZ = (RelativeLayout) this.mParent.findViewById(f.g.head_content_container);
        this.dtd = (ImageView) this.mParent.findViewById(f.g.single_bar_level);
        this.dtd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.jE()) {
                    l.showToast(c.this.mContext.getPageActivity(), f.j.neterror);
                } else if (!StringUtils.isNull(c.this.dti) && !StringUtils.isNull(c.this.mForumId)) {
                    az.zI().c(c.this.mContext, new String[]{c.this.dti + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        awF();
        this.dsX = (FrsStarRankAndTaskContainer) this.mParent.findViewById(f.g.frs_star_rank_container);
        this.dsX.setContext(this.mContext);
        this.dta = new LinearLayout(this.dnP.getContext());
        this.dta.setOrientation(1);
        this.dta.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dta.addView(this.dJh);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View awD() {
        return this.dta;
    }

    private void awE() {
        this.dth = (FrsHeaderPraiseView) this.dJd.findViewById(f.g.frs_praise_layout);
    }

    private void awF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.dJz = (ag) runTask.getData();
            this.dJz.a(this.mContext, this.mParent, 1, false, this.dnP.getUniqueId());
            this.dJz.hide();
        }
    }

    private void awG() {
        final com.baidu.tbadk.core.data.l buD = this.dHa.buD();
        if (buD != null && this.dHa.aZg() != null) {
            final String id = this.dHa.aZg().getId();
            final String name = this.dHa.aZg().getName();
            if (this.dJT.add(buD.tI())) {
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", buD.tI(), id, name, null);
                b.cm("obj_url", buD.getUrl());
                b.save();
            }
            this.dJi.setVisibility(0);
            this.dJj.setText(buD.getText());
            this.dJk.setText(buD.getTitle());
            this.dJl.startLoad(buD.tH(), 10, false);
            this.dJi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0236a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", buD.tI(), id, name, null);
                    b2.cm("obj_url", buD.getUrl());
                    b2.save();
                    az.zI().c(c.this.dnP.getPageContext(), new String[]{buD.getUrl()});
                }
            });
        }
    }

    protected View awH() {
        return LayoutInflater.from(this.dnP.getPageContext().getPageActivity()).inflate(f.h.frs_normal_header, (ViewGroup) null);
    }

    private void kO(int i) {
        if (i <= 0 || i > 5 || this.dJN) {
            this.dtd.setVisibility(8);
            this.dlq.setMaxWidth(l.f(this.mContext.getPageActivity(), f.e.ds370));
            return;
        }
        this.dtd.setVisibility(0);
        Drawable drawable = am.getDrawable(this.dtj[i - 1]);
        this.dtd.setImageDrawable(drawable);
        this.dlq.setMaxWidth((l.f(this.mContext.getPageActivity(), f.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dtd.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void q(View.OnClickListener onClickListener) {
        this.dJu.setOnClickListener(onClickListener);
        this.dlq.setOnClickListener(onClickListener);
        this.dIZ.setOnClickListener(onClickListener);
        this.dIY.setOnClickListener(onClickListener);
        this.dJX.setOnClickListener(onClickListener);
        if (this.dJe != null) {
            this.dJe.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awI() {
        am.j(this.dJZ, f.d.black_alpha0);
        am.j(this.bmt, f.d.black_alpha0);
        am.h(this.dlq, f.d.cp_cont_i);
        am.h(this.dJa, f.d.cp_cont_i);
        am.h(this.dJY, f.d.cp_cont_i);
        am.i(this.dJP, f.C0146f.enter_forum_brand_label_bg_shape);
        am.h(this.dJP, f.d.cp_cont_i);
        am.h(this.dtb, f.d.cp_cont_i);
        am.h(this.dIW, f.d.cp_cont_i);
        am.h(this.dtc, f.d.cp_cont_i);
        am.h(this.dIX, f.d.cp_cont_i);
        am.j(this.dJc, f.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awJ() {
        this.dJP.setVisibility(0);
        this.dtd.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.dJp);
        this.mContext.getLayoutMode().onModeChanged(this.dJd);
        if (this.dJL) {
            md(1);
        } else {
            md(0);
        }
        this.dJu.invalidate();
        am.j(this.bmt, f.d.cp_bg_line_d);
        am.h(this.dJY, f.d.cp_cont_j);
        am.h(this.dJa, f.d.cp_cont_j);
        am.h(this.dtb, f.d.cp_cont_j);
        am.h(this.dIW, f.d.cp_cont_j);
        am.h(this.dtc, f.d.cp_cont_j);
        am.h(this.dIX, f.d.cp_cont_j);
        this.dJu.setBorderWidth(l.f(this.mContext.getPageActivity(), f.e.tbds1));
        this.dJu.setBorderColor(am.getColor(f.d.black_alpha15));
        awN();
        if (this.dJe != null) {
            am.i(this.dJe, f.C0146f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            am.c(this.dJs, f.C0146f.icon_sml_speed_orange);
        } else {
            am.c(this.dJs, f.C0146f.icon_sml_speed_gray);
        }
        if (this.dJy != null) {
            this.dJy.changeSkinType(i);
        }
        if (this.dJz != null) {
            this.dJz.changeSkinType(i);
        }
        if (this.dJv != null) {
            this.dJv.dF(i);
        }
        Iterator<TbImageView> it = this.dtg.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        awz();
        am.i(this.dJi, f.C0146f.home_thread_card_item_bg);
        am.h(this.dlq, f.d.cp_cont_b);
        if (this.dsW != null) {
            com.baidu.tbadk.o.a.a(this.dnP.getPageContext(), this.dsW);
        }
        if (this.dth.getVisibility() == 0) {
            this.dth.changeSkinType(i);
        }
        am.i(this.dKa, f.C0146f.btn_round_cont_d);
        am.h(this.dKa, f.d.btn_cont_j_alpha_20_selector);
        am.j(this.dJc, f.d.common_color_10043);
        if (this.dsX != null && this.dsX.getVisibility() == 0) {
            this.dsX.onChangeSkinType();
        }
        if (this.dJN) {
            awI();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dJE = forumData.getPost_num();
            this.dJB = forumData.getTag_color();
            this.afe = forumData.getImage_url();
            this.dJA = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dJF = forumData.getSignData().count_sign_num;
                this.dJG = forumData.getSignData().miss_sign_num;
            }
            this.dJH = forumData.getCurScore();
            this.dGv = forumData.getLevelupScore();
            this.dJw = forumData.getBadgeData();
            this.dJn = forumData.getTopCode();
            this.dJo = forumData.getNewsInfo();
            this.dJC = forumData.getAccelerateContent();
            this.dJN = forumData.isBrandForum;
            this.dHa = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dJD = new bb();
            awK();
            awO();
            awG();
            this.dth.setVisibility(8);
            if (lVar != null && lVar.bub() != null) {
                kO(lVar.bub().grade.intValue());
                this.dti = lVar.bub().url;
            }
            if (lVar != null && lVar.gMf != null) {
                FrsTabInfo frsTabInfo = lVar.gMf;
                this.dte = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dtf = frsTabInfo.tab_gid;
                this.dKa.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dKa.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        an anVar = new an("c12837");
                        anVar.ae(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        anVar.ae(VideoPlayActivityConfig.OBJ_ID, this.dtf);
                        anVar.ae("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(anVar);
                    }
                }
                this.dKa.setOnClickListener(this.dtk);
            } else {
                this.dKa.setVisibility(8);
            }
            if (lVar != null && lVar.gMg != null) {
                this.dsX.setData(lVar.gMg);
                this.dsX.setVisibility(0);
                this.dJZ.setPadding(0, this.dJZ.getPaddingTop(), 0, 0);
                return;
            }
            this.dsX.setVisibility(8);
        }
    }

    protected void awK() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.afe);
        this.dJD.vu().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void awL() {
        Drawable drawable;
        int f = l.f(this.mContext.getPageActivity(), f.e.tbds32);
        if (this.dJG > 0) {
            am.c(this.dIZ, f.d.cp_cont_i, 1);
            Drawable drawable2 = am.getDrawable(f.C0146f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, f, f);
            int f2 = l.f(this.mContext.getPageActivity(), f.e.tbds24);
            this.dIZ.setPadding(f2, 0, f2, 0);
            this.dIZ.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dIZ.setText(String.format(this.mContext.getString(f.j.miss_sign_days), Integer.valueOf(this.dJG)));
            am.i(this.dIZ, f.C0146f.frs_attention_btn_bg_selector);
        } else {
            if (this.dJN) {
                drawable = am.getDrawable(f.C0146f.icon_frs_sign_h_white);
                am.c(this.dIZ, f.d.cp_cont_i, 1);
            } else {
                drawable = am.getDrawable(f.C0146f.icon_public_sign_blue);
                am.c(this.dIZ, f.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, f, f);
            this.dIZ.setCompoundDrawables(drawable, null, null, null);
            this.dIZ.setText(this.mContext.getString(f.j.signed));
            this.dIZ.setPadding(0, 0, 0, 0);
            this.dIZ.setBackgroundDrawable(null);
        }
        this.dIZ.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds34));
        this.dIZ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void awM() {
        int f = l.f(this.mContext.getPageActivity(), f.e.tbds32);
        Drawable drawable = am.getDrawable(f.C0146f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dIZ.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dIZ.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds34));
        am.c(this.dIZ, f.d.cp_cont_i, 1);
        am.i(this.dIZ, f.C0146f.frs_attention_btn_bg_selector);
    }

    protected void awN() {
        int f = l.f(this.mContext.getPageActivity(), f.e.tbds32);
        Drawable drawable = am.getDrawable(f.C0146f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dIY.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dIY.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds34));
        am.c(this.dIY, f.d.cp_cont_g, 1);
        am.i(this.dIY, f.C0146f.frs_attention_btn_bg_selector);
    }

    protected void awO() {
        List<g> list = null;
        if (this.dIW != null) {
            this.dIW.setText(ap.D(this.mMemberNum));
        }
        if (this.dIX != null) {
            this.dIX.setText(ap.D(this.dJE));
        }
        if (this.dJw != null && this.dJw.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.cXY != null) {
                this.cXY.setText(this.mForumName + this.mContext.getString(f.j.forum));
            }
            if (this.dlq != null) {
                this.dlq.setText(this.mForumName + this.mContext.getString(f.j.forum));
            }
        }
        if (this.dJe != null && this.dJf != null) {
            if (this.dHa != null && this.dHa.bun()) {
                if (n.eu(this.dHa.bup()) == 1 && !o.aoD) {
                    this.dJe.setVisibility(8);
                } else {
                    this.dJe.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dHa.getGameName()) && !TextUtils.isEmpty(this.dHa.getGameName().trim())) {
                        this.dJf.setText(UtilHelper.getFixedText(this.dHa.getGameName(), 10));
                        String tZ = com.baidu.tieba.tbadkCore.util.b.tZ(this.dHa.bup());
                        if (!StringUtils.isNull(tZ)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", tZ, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dJf.setText(this.mContext.getResources().getString(f.j.frsgame_title));
                    }
                }
            } else {
                this.dJe.setVisibility(8);
            }
        }
        this.dJm.setVisibility(8);
        this.dJy.a(null, null);
        if (this.dJe != null) {
            this.dJg = this.dJe.findViewById(f.g.top_item_divider);
        }
        awP();
        if (this.dHa != null && !w.z(this.dHa.buo())) {
            list = this.dHa.buo();
            bC(list);
        }
        bn(list);
    }

    protected void awP() {
        this.dJu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dJu.startLoad(this.afe, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dJU);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dJp);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(f.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(f.e.ds100));
                this.dJq = (TextView) this.dJp.findViewById(f.g.cur_experience);
                this.dJr = (TextView) this.dJp.findViewById(f.g.levelup_experience);
                a(this.dJq, this.dJr);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dJq, this.dJr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dJU, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(f.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(f.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(f.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(f.g.speed_tip);
            am.c((TextView) inflate.findViewById(f.g.experience_txt), f.d.cp_cont_b, 1);
            am.c(textView, f.d.cp_cont_b, 1);
            am.c(textView2, f.d.cp_cont_b, 1);
            am.c(textView3, f.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.w(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dJC) && !TextUtils.isEmpty(this.dJC.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dJC);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cg(f.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.xe();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(f.j.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(c.this.mContext.getPageActivity(), c.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awQ() {
        View contentView;
        if (this.dJt == null) {
            this.dJt = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(f.h.speed_tip, (ViewGroup) null);
            this.dJt.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dJt, c.this.mContext.getPageActivity());
                        c.this.dnP.dmb = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(f.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dJt.setWidth(this.mContext.getResources().getDimensionPixelSize(f.e.ds300));
            this.dJt.setHeight(this.mContext.getResources().getDimensionPixelSize(f.e.ds88));
            this.dJt.setBackgroundDrawable(new BitmapDrawable());
            this.dJt.setOutsideTouchable(true);
            this.dJt.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dJt);
                        c.this.dnP.dmb = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dJt.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.dJs.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dJt, this.mParent, 0, (iArr[0] - (this.dJt.getWidth() / 2)) + (this.dJs.getWidth() / 2), iArr[1] + this.dJs.getWidth());
        this.dJt.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.dJM = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(f.C0146f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dJM) {
                this.dJa.setText(f.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l auC = this.dnP.auC();
                if (auC != null && auC.aZg() != null) {
                    auC.aZg().setUser_level(i);
                }
                this.dJY.setText(this.mContext.getResources().getString(f.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dJa.setText(this.dJA);
                this.dJY.setText(this.mContext.getResources().getString(f.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dJb.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, kP(this.mLevel)));
            if (this.dJM) {
                if (f >= 1.0f) {
                    a(this.dnP.getBaseFragmentActivity(), this.dJb, this.dJO, f);
                } else {
                    b(this.dnP.getBaseFragmentActivity(), this.dJb, this.dJO, f);
                }
            } else {
                a(this.dnP.getBaseFragmentActivity(), this.dJb, this.dJO, f);
            }
            this.dJO = f;
        }
    }

    private int[] kP(int i) {
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
    protected void awR() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awS() {
        if (this.mMemberType != 0) {
            am.c(this.dJs, f.C0146f.icon_sml_speed_orange);
        } else {
            am.c(this.dJs, f.C0146f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abK() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zW();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fa(String str) {
                az.zI().c(c.this.mContext, new String[]{c.this.dte});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fb(String str) {
            }
        });
        return aVar.u(pageActivity);
    }

    public String tM() {
        return this.dtf;
    }

    public String awT() {
        return this.dte;
    }
}
