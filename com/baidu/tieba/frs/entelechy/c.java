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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
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
    private RelativeLayout bmp;
    private final LinearLayout dtd;
    private TextView dte;
    private TextView dtf;
    private ImageView dtg;
    private String dth;
    private String dti;
    private FrsHeaderPraiseView dtk;
    private String dtl;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dtm = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private View.OnClickListener dtn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dti)) {
                        ay.zK().c(c.this.mContext, new String[]{c.this.dth});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.abJ()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dti));
                        }
                    } else if (PluginPackageManager.lN().bL("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.j.plugin_video_installing), 0).xn();
                        z = false;
                    } else {
                        ay.zK().c(c.this.mContext, new String[]{c.this.dth});
                        z = false;
                    }
                    an anVar = new an("c12838");
                    anVar.af(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    anVar.af(VideoPlayActivityConfig.OBJ_ID, c.this.dti);
                    anVar.af("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    anVar.af("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(anVar);
                }
                ay.zK().c(c.this.mContext, new String[]{c.this.dth});
                z = false;
                an anVar2 = new an("c12838");
                anVar2.af(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                anVar2.af(VideoPlayActivityConfig.OBJ_ID, c.this.dti);
                anVar2.af("obj_type", c.this.mTabId != 201 ? "1" : "2");
                anVar2.af("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(anVar2);
            }
        }
    };
    private ArrayList<TbImageView> dtj = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bmp = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dnR = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dIX = l.f(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.dIY = l.f(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.dIZ = l.f(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = awI();
        this.bmp = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dJt = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dJw = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dte = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dtf = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dJe = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dKc = (TextView) this.mParent.findViewById(d.g.level);
        this.dJc = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dJd = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dJd.setContentDescription(frsFragment.getResources().getString(d.j.sign));
        this.dJf = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dJg = (ImageView) this.mParent.findViewById(d.g.love_level_bg);
        this.dJa = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dJb = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dJy = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dls = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dJT = (TextView) this.mParent.findViewById(d.g.brand_label);
        this.dJy.setPageId(this.dnR.getUniqueId());
        this.dJy.setContentDescription(frsFragment.getResources().getString(d.j.bar_header));
        this.dJy.setGifIconSupport(false);
        this.dJy.setDrawerType(0);
        this.dJh = LayoutInflater.from(this.dnR.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        awz();
        awF();
        this.dJi = (ViewGroup) this.dJh.findViewById(d.g.frs_header_games);
        this.dJj = (TextView) this.dJh.findViewById(d.g.top_item_title);
        this.dJq = (LinearLayout) this.dJh.findViewById(d.g.frs_present_root);
        this.dKe = (TextView) this.bmp.findViewById(d.g.new_chapter_btn);
        this.dJC = new e(this.mContext, this.dJh);
        this.dJB = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dJm = (ViewGroup) this.dJh.findViewById(d.g.frs_headline);
        this.dJn = (TextView) this.dJm.findViewById(d.g.headline_title);
        this.dJo = (TextView) this.dJm.findViewById(d.g.headline_text);
        this.dJp = (TbImageView) this.dJm.findViewById(d.g.headline_image);
        this.dJp.setPageId(this.dnR.getUniqueId());
        this.dJm.setVisibility(8);
        this.dKb = this.mParent.findViewById(d.g.level_container);
        this.dKa = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dJZ = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dKd = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dtg = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dtg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.jE()) {
                    l.showToast(c.this.mContext.getPageActivity(), d.j.neterror);
                } else if (!StringUtils.isNull(c.this.dtl) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.zK().c(c.this.mContext, new String[]{c.this.dtl + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        awG();
        this.dta = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dta.setContext(this.mContext);
        this.dtd = new LinearLayout(this.dnR.getContext());
        this.dtd.setOrientation(1);
        this.dtd.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dtd.addView(this.dJl);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View awE() {
        return this.dtd;
    }

    private void awF() {
        this.dtk = (FrsHeaderPraiseView) this.dJh.findViewById(d.g.frs_praise_layout);
    }

    private void awG() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.dJD = (ag) runTask.getData();
            this.dJD.a(this.mContext, this.mParent, 1, false, this.dnR.getUniqueId());
            this.dJD.hide();
        }
    }

    private void awH() {
        final com.baidu.tbadk.core.data.l buC = this.dHe.buC();
        if (buC != null && this.dHe.aZl() != null) {
            final String id = this.dHe.aZl().getId();
            final String name = this.dHe.aZl().getName();
            if (this.dJX.add(buC.tJ())) {
                a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", buC.tJ(), id, name, null);
                b.cm("obj_url", buC.getUrl());
                b.save();
            }
            this.dJm.setVisibility(0);
            this.dJn.setText(buC.getText());
            this.dJo.setText(buC.getTitle());
            this.dJp.startLoad(buC.tI(), 10, false);
            this.dJm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0236a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", buC.tJ(), id, name, null);
                    b2.cm("obj_url", buC.getUrl());
                    b2.save();
                    ay.zK().c(c.this.dnR.getPageContext(), new String[]{buC.getUrl()});
                }
            });
        }
    }

    protected View awI() {
        return LayoutInflater.from(this.dnR.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    private void kP(int i) {
        if (i <= 0 || i > 5 || this.dJR) {
            this.dtg.setVisibility(8);
            this.dls.setMaxWidth(l.f(this.mContext.getPageActivity(), d.e.ds370));
            return;
        }
        this.dtg.setVisibility(0);
        Drawable drawable = am.getDrawable(this.dtm[i - 1]);
        this.dtg.setImageDrawable(drawable);
        this.dls.setMaxWidth((l.f(this.mContext.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dtg.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void q(View.OnClickListener onClickListener) {
        this.dJy.setOnClickListener(onClickListener);
        this.dls.setOnClickListener(onClickListener);
        this.dJd.setOnClickListener(onClickListener);
        this.dJc.setOnClickListener(onClickListener);
        this.dKb.setOnClickListener(onClickListener);
        if (this.dJi != null) {
            this.dJi.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awJ() {
        am.j(this.dKd, d.C0140d.black_alpha0);
        am.j(this.bmp, d.C0140d.black_alpha0);
        am.h(this.dls, d.C0140d.cp_cont_i);
        am.h(this.dJe, d.C0140d.cp_cont_i);
        am.h(this.dKc, d.C0140d.cp_cont_i);
        am.i(this.dJT, d.f.enter_forum_brand_label_bg_shape);
        am.h(this.dJT, d.C0140d.cp_cont_i);
        am.h(this.dte, d.C0140d.cp_cont_i);
        am.h(this.dJa, d.C0140d.cp_cont_i);
        am.h(this.dtf, d.C0140d.cp_cont_i);
        am.h(this.dJb, d.C0140d.cp_cont_i);
        am.j(this.dJg, d.C0140d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awK() {
        this.dJT.setVisibility(0);
        this.dtg.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.dJt);
        this.mContext.getLayoutMode().onModeChanged(this.dJh);
        if (this.dJP) {
            md(1);
        } else {
            md(0);
        }
        this.dJy.invalidate();
        am.j(this.bmp, d.C0140d.cp_bg_line_d);
        am.h(this.dKc, d.C0140d.cp_cont_j);
        am.h(this.dJe, d.C0140d.cp_cont_j);
        am.h(this.dte, d.C0140d.cp_cont_j);
        am.h(this.dJa, d.C0140d.cp_cont_j);
        am.h(this.dtf, d.C0140d.cp_cont_j);
        am.h(this.dJb, d.C0140d.cp_cont_j);
        this.dJy.setBorderWidth(l.f(this.mContext.getPageActivity(), d.e.tbds1));
        this.dJy.setBorderColor(am.getColor(d.C0140d.black_alpha15));
        awO();
        if (this.dJi != null) {
            am.i(this.dJi, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            am.c(this.dJw, d.f.icon_sml_speed_orange);
        } else {
            am.c(this.dJw, d.f.icon_sml_speed_gray);
        }
        if (this.dJC != null) {
            this.dJC.changeSkinType(i);
        }
        if (this.dJD != null) {
            this.dJD.changeSkinType(i);
        }
        if (this.dJz != null) {
            this.dJz.dG(i);
        }
        Iterator<TbImageView> it = this.dtj.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        awA();
        am.i(this.dJm, d.f.home_thread_card_item_bg);
        am.h(this.dls, d.C0140d.cp_cont_b);
        if (this.dsZ != null) {
            com.baidu.tbadk.o.a.a(this.dnR.getPageContext(), this.dsZ);
        }
        if (this.dtk.getVisibility() == 0) {
            this.dtk.changeSkinType(i);
        }
        am.i(this.dKe, d.f.btn_round_cont_d);
        am.h(this.dKe, d.C0140d.btn_cont_j_alpha_20_selector);
        am.j(this.dJg, d.C0140d.common_color_10043);
        if (this.dta != null && this.dta.getVisibility() == 0) {
            this.dta.onChangeSkinType();
        }
        if (this.dJR) {
            awJ();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dJI = forumData.getPost_num();
            this.dJF = forumData.getTag_color();
            this.afe = forumData.getImage_url();
            this.dJE = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dJJ = forumData.getSignData().count_sign_num;
                this.dJK = forumData.getSignData().miss_sign_num;
            }
            this.dJL = forumData.getCurScore();
            this.dGz = forumData.getLevelupScore();
            this.dJA = forumData.getBadgeData();
            this.dJr = forumData.getTopCode();
            this.dJs = forumData.getNewsInfo();
            this.dJG = forumData.getAccelerateContent();
            this.dJR = forumData.isBrandForum;
            this.dHe = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dJH = new bb();
            awL();
            awP();
            awH();
            this.dtk.setVisibility(8);
            if (lVar != null && lVar.bua() != null) {
                kP(lVar.bua().grade.intValue());
                this.dtl = lVar.bua().url;
            }
            if (lVar != null && lVar.gMd != null) {
                FrsTabInfo frsTabInfo = lVar.gMd;
                this.dth = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dti = frsTabInfo.tab_gid;
                this.dKe.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dKe.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        an anVar = new an("c12837");
                        anVar.af(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        anVar.af(VideoPlayActivityConfig.OBJ_ID, this.dti);
                        anVar.af("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(anVar);
                    }
                }
                this.dKe.setOnClickListener(this.dtn);
            } else {
                this.dKe.setVisibility(8);
            }
            if (lVar != null && lVar.gMe != null) {
                this.dta.setData(lVar.gMe);
                this.dta.setVisibility(0);
                this.dKd.setPadding(0, this.dKd.getPaddingTop(), 0, 0);
                return;
            }
            this.dta.setVisibility(8);
        }
    }

    protected void awL() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.afe);
        this.dJH.vv().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void awM() {
        Drawable drawable;
        int f = l.f(this.mContext.getPageActivity(), d.e.tbds32);
        if (this.dJK > 0) {
            am.c(this.dJd, d.C0140d.cp_cont_i, 1);
            Drawable drawable2 = am.getDrawable(d.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, f, f);
            int f2 = l.f(this.mContext.getPageActivity(), d.e.tbds24);
            this.dJd.setPadding(f2, 0, f2, 0);
            this.dJd.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dJd.setText(String.format(this.mContext.getString(d.j.miss_sign_days), Integer.valueOf(this.dJK)));
            am.i(this.dJd, d.f.frs_attention_btn_bg_selector);
        } else {
            if (this.dJR) {
                drawable = am.getDrawable(d.f.icon_frs_sign_h_white);
                am.c(this.dJd, d.C0140d.cp_cont_i, 1);
            } else {
                drawable = am.getDrawable(d.f.icon_public_sign_blue);
                am.c(this.dJd, d.C0140d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, f, f);
            this.dJd.setCompoundDrawables(drawable, null, null, null);
            this.dJd.setText(this.mContext.getString(d.j.signed));
            this.dJd.setPadding(0, 0, 0, 0);
            this.dJd.setBackgroundDrawable(null);
        }
        this.dJd.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dJd.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void awN() {
        int f = l.f(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = am.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dJd.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dJd.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        am.c(this.dJd, d.C0140d.cp_cont_i, 1);
        am.i(this.dJd, d.f.frs_attention_btn_bg_selector);
    }

    protected void awO() {
        int f = l.f(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = am.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, f, f);
        this.dJc.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dJc.setTextSize(0, l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        am.c(this.dJc, d.C0140d.cp_cont_g, 1);
        am.i(this.dJc, d.f.frs_attention_btn_bg_selector);
    }

    protected void awP() {
        List<g> list = null;
        if (this.dJa != null) {
            this.dJa.setText(ap.D(this.mMemberNum));
        }
        if (this.dJb != null) {
            this.dJb.setText(ap.D(this.dJI));
        }
        if (this.dJA != null && this.dJA.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.cYc != null) {
                this.cYc.setText(this.mForumName + this.mContext.getString(d.j.forum));
            }
            if (this.dls != null) {
                this.dls.setText(this.mForumName + this.mContext.getString(d.j.forum));
            }
        }
        if (this.dJi != null && this.dJj != null) {
            if (this.dHe != null && this.dHe.bum()) {
                if (n.eu(this.dHe.buo()) == 1 && !o.aoC) {
                    this.dJi.setVisibility(8);
                } else {
                    this.dJi.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dHe.getGameName()) && !TextUtils.isEmpty(this.dHe.getGameName().trim())) {
                        this.dJj.setText(UtilHelper.getFixedText(this.dHe.getGameName(), 10));
                        String tV = com.baidu.tieba.tbadkCore.util.b.tV(this.dHe.buo());
                        if (!StringUtils.isNull(tV)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", tV, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dJj.setText(this.mContext.getResources().getString(d.j.frsgame_title));
                    }
                }
            } else {
                this.dJi.setVisibility(8);
            }
        }
        this.dJq.setVisibility(8);
        this.dJC.a(null, null);
        if (this.dJi != null) {
            this.dJk = this.dJi.findViewById(d.g.top_item_divider);
        }
        awQ();
        if (this.dHe != null && !w.z(this.dHe.bun())) {
            list = this.dHe.bun();
            bC(list);
        }
        bn(list);
    }

    protected void awQ() {
        this.dJy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dJy.startLoad(this.afe, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dJY);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dJt);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds100));
                this.dJu = (TextView) this.dJt.findViewById(d.g.cur_experience);
                this.dJv = (TextView) this.dJt.findViewById(d.g.levelup_experience);
                a(this.dJu, this.dJv);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dJu, this.dJv);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dJY, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            am.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0140d.cp_cont_b, 1);
            am.c(textView, d.C0140d.cp_cont_b, 1);
            am.c(textView2, d.C0140d.cp_cont_b, 1);
            am.c(textView3, d.C0140d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.w(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dJG) && !TextUtils.isEmpty(this.dJG.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dJG);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cg(d.C0140d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.xf();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
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
    public void awR() {
        View contentView;
        if (this.dJx == null) {
            this.dJx = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.dJx.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dJx, c.this.mContext.getPageActivity());
                        c.this.dnR.dmd = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dJx.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds300));
            this.dJx.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds88));
            this.dJx.setBackgroundDrawable(new BitmapDrawable());
            this.dJx.setOutsideTouchable(true);
            this.dJx.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dJx);
                        c.this.dnR.dmd = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dJx.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.dJw.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dJx, this.mParent, 0, (iArr[0] - (this.dJx.getWidth() / 2)) + (this.dJw.getWidth() / 2), iArr[1] + this.dJw.getWidth());
        this.dJx.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.dJQ = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dJQ) {
                this.dJe.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l auD = this.dnR.auD();
                if (auD != null && auD.aZl() != null) {
                    auD.aZl().setUser_level(i);
                }
                this.dKc.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dJe.setText(this.dJE);
                this.dKc.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dJf.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, kQ(this.mLevel)));
            if (this.dJQ) {
                if (f >= 1.0f) {
                    a(this.dnR.getBaseFragmentActivity(), this.dJf, this.dJS, f);
                } else {
                    b(this.dnR.getBaseFragmentActivity(), this.dJf, this.dJS, f);
                }
            } else {
                a(this.dnR.getBaseFragmentActivity(), this.dJf, this.dJS, f);
            }
            this.dJS = f;
        }
    }

    private int[] kQ(int i) {
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
    protected void awS() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void awT() {
        if (this.mMemberType != 0) {
            am.c(this.dJw, d.f.icon_sml_speed_orange);
        } else {
            am.c(this.dJw, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abJ() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zY();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fa(String str) {
                ay.zK().c(c.this.mContext, new String[]{c.this.dth});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fb(String str) {
            }
        });
        return aVar.u(pageActivity);
    }

    public String tN() {
        return this.dti;
    }

    public String awU() {
        return this.dth;
    }
}
