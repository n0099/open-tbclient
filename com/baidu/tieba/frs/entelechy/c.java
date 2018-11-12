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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.entelechy.view.FrsHeaderPraiseView;
import com.baidu.tieba.frs.view.FrsStarRankAndTaskContainer;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class c extends a {
    private String ano;
    private RelativeLayout bwZ;
    private final LinearLayout dIK;
    private TextView dIL;
    private TextView dIM;
    private ImageView dIN;
    private String dIO;
    private String dIP;
    private FrsHeaderPraiseView dIR;
    private String dIS;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dIT = {e.f.icon_frs_emotion_level1, e.f.icon_frs_emotion_level2, e.f.icon_frs_emotion_level3, e.f.icon_frs_emotion_level4, e.f.icon_frs_emotion_level5};
    private View.OnClickListener dIU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dIP)) {
                        ay.Db().c(c.this.mContext, new String[]{c.this.dIO});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.agD()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dIP));
                        }
                    } else if (PluginPackageManager.nb().cb("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AJ();
                        z = false;
                    } else {
                        ay.Db().c(c.this.mContext, new String[]{c.this.dIO});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.ax(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.ax(VideoPlayActivityConfig.OBJ_ID, c.this.dIP);
                    amVar.ax("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.ax("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.Db().c(c.this.mContext, new String[]{c.this.dIO});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.ax(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.ax(VideoPlayActivityConfig.OBJ_ID, c.this.dIP);
                amVar2.ax("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.ax("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dIQ = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bwZ = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dDf = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dZs = l.h(frsFragment.getPageContext().getPageActivity(), e.C0200e.ds20);
        this.dZt = l.h(frsFragment.getPageContext().getPageActivity(), e.C0200e.ds72);
        this.dZu = l.h(frsFragment.getPageContext().getPageActivity(), e.C0200e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = aBJ();
        this.bwZ = (RelativeLayout) this.mParent.findViewById(e.g.container);
        this.dZO = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(e.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dZR = (ImageView) this.mParent.findViewById(e.g.speed_icon);
        this.dIL = (TextView) this.mParent.findViewById(e.g.member_image);
        this.dIM = (TextView) this.mParent.findViewById(e.g.post_image);
        this.dZz = (TextView) this.mParent.findViewById(e.g.level_name);
        this.eax = (TextView) this.mParent.findViewById(e.g.level);
        this.dZx = (TextView) this.mParent.findViewById(e.g.tv_love);
        this.dZy = (TextView) this.mParent.findViewById(e.g.tv_sign);
        this.dZy.setContentDescription(frsFragment.getResources().getString(e.j.sign));
        this.dZA = (ImageView) this.mParent.findViewById(e.g.love_level_top);
        this.dZB = (ImageView) this.mParent.findViewById(e.g.love_level_bg);
        this.dZv = (TextView) this.mParent.findViewById(e.g.member_num_text);
        this.dZw = (TextView) this.mParent.findViewById(e.g.post_num_text);
        this.dZT = (BarImageView) this.mParent.findViewById(e.g.frs_image);
        this.dAB = (TextView) this.mParent.findViewById(e.g.forum_name);
        this.eao = (TextView) this.mParent.findViewById(e.g.brand_label);
        this.dZT.setPageId(this.dDf.getUniqueId());
        this.dZT.setContentDescription(frsFragment.getResources().getString(e.j.bar_header));
        this.dZT.setGifIconSupport(false);
        this.dZT.setDrawerType(0);
        this.dZC = LayoutInflater.from(this.dDf.getPageContext().getPageActivity()).inflate(e.h.frs_header_extra_entelechy, (ViewGroup) null);
        aBA();
        aBG();
        this.dZD = (ViewGroup) this.dZC.findViewById(e.g.frs_header_games);
        this.dZE = (TextView) this.dZC.findViewById(e.g.top_item_title);
        this.dZL = (LinearLayout) this.dZC.findViewById(e.g.frs_present_root);
        this.eaz = (TextView) this.bwZ.findViewById(e.g.new_chapter_btn);
        this.dZX = new com.baidu.tieba.frs.view.e(this.mContext, this.dZC);
        this.dZW = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dZH = (ViewGroup) this.dZC.findViewById(e.g.frs_headline);
        this.dZI = (TextView) this.dZH.findViewById(e.g.headline_title);
        this.dZJ = (TextView) this.dZH.findViewById(e.g.headline_text);
        this.dZK = (TbImageView) this.dZH.findViewById(e.g.headline_image);
        this.dZK.setPageId(this.dDf.getUniqueId());
        this.dZH.setVisibility(8);
        this.eaw = this.mParent.findViewById(e.g.level_container);
        this.eav = (RelativeLayout) this.mParent.findViewById(e.g.has_focused_container);
        this.eau = (RelativeLayout) this.mParent.findViewById(e.g.not_focused_container);
        this.eay = (RelativeLayout) this.mParent.findViewById(e.g.head_content_container);
        this.dIN = (ImageView) this.mParent.findViewById(e.g.single_bar_level);
        this.dIN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.kV()) {
                    l.showToast(c.this.mContext.getPageActivity(), e.j.neterror);
                } else if (!StringUtils.isNull(c.this.dIS) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.Db().c(c.this.mContext, new String[]{c.this.dIS + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        aBH();
        this.dIH = (FrsStarRankAndTaskContainer) this.mParent.findViewById(e.g.frs_star_rank_container);
        this.dIH.setContext(this.mContext);
        this.dIK = new LinearLayout(this.dDf.getContext());
        this.dIK.setOrientation(1);
        this.dIK.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dIK.addView(this.dZG);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View aBF() {
        return this.dIK;
    }

    private void aBG() {
        this.dIR = (FrsHeaderPraiseView) this.dZC.findViewById(e.g.frs_praise_layout);
    }

    private void aBH() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.dZY = (ag) runTask.getData();
            this.dZY.a(this.mContext, this.mParent, 1, false, this.dDf.getUniqueId());
            this.dZY.hide();
        }
    }

    private void aBI() {
        final com.baidu.tbadk.core.data.l bzU = this.dXn.bzU();
        if (bzU != null && this.dXn.ber() != null) {
            final String id = this.dXn.ber().getId();
            final String name = this.dXn.ber().getName();
            if (this.eas.add(bzU.xc())) {
                a.C0305a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bzU.xc(), id, name, null);
                b.cH("obj_url", bzU.getUrl());
                b.save();
            }
            this.dZH.setVisibility(0);
            this.dZI.setText(bzU.getText());
            this.dZJ.setText(bzU.getTitle());
            this.dZK.startLoad(bzU.xb(), 10, false);
            this.dZH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0305a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bzU.xc(), id, name, null);
                    b2.cH("obj_url", bzU.getUrl());
                    b2.save();
                    ay.Db().c(c.this.dDf.getPageContext(), new String[]{bzU.getUrl()});
                }
            });
        }
    }

    protected View aBJ() {
        return LayoutInflater.from(this.dDf.getPageContext().getPageActivity()).inflate(e.h.frs_normal_header, (ViewGroup) null);
    }

    private void mg(int i) {
        if (i <= 0 || i > 5 || this.eam) {
            this.dIN.setVisibility(8);
            this.dAB.setMaxWidth(l.h(this.mContext.getPageActivity(), e.C0200e.ds370));
            return;
        }
        this.dIN.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dIT[i - 1]);
        this.dIN.setImageDrawable(drawable);
        this.dAB.setMaxWidth((l.h(this.mContext.getPageActivity(), e.C0200e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dIN.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void s(View.OnClickListener onClickListener) {
        this.dZT.setOnClickListener(onClickListener);
        this.dAB.setOnClickListener(onClickListener);
        this.dZy.setOnClickListener(onClickListener);
        this.dZx.setOnClickListener(onClickListener);
        this.eaw.setOnClickListener(onClickListener);
        if (this.dZD != null) {
            this.dZD.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aBK() {
        al.j(this.eay, e.d.black_alpha0);
        al.j(this.bwZ, e.d.black_alpha0);
        al.h(this.dAB, e.d.cp_cont_i);
        al.h(this.dZz, e.d.cp_cont_i);
        al.h(this.eax, e.d.cp_cont_i);
        al.i(this.eao, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.eao, e.d.cp_cont_i);
        al.h(this.dIL, e.d.cp_cont_i);
        al.h(this.dZv, e.d.cp_cont_i);
        al.h(this.dIM, e.d.cp_cont_i);
        al.h(this.dZw, e.d.cp_cont_i);
        al.j(this.dZB, e.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aBL() {
        this.eao.setVisibility(0);
        this.dIN.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.dZO);
        this.mContext.getLayoutMode().onModeChanged(this.dZC);
        if (this.eak) {
            nx(1);
        } else {
            nx(0);
        }
        this.dZT.invalidate();
        al.j(this.bwZ, e.d.cp_bg_line_d);
        al.h(this.eax, e.d.cp_cont_j);
        al.h(this.dZz, e.d.cp_cont_j);
        al.h(this.dIL, e.d.cp_cont_j);
        al.h(this.dZv, e.d.cp_cont_j);
        al.h(this.dIM, e.d.cp_cont_j);
        al.h(this.dZw, e.d.cp_cont_j);
        this.dZT.setBorderWidth(l.h(this.mContext.getPageActivity(), e.C0200e.tbds1));
        this.dZT.setBorderColor(al.getColor(e.d.black_alpha15));
        aBP();
        if (this.dZD != null) {
            al.i(this.dZD, e.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.dZR, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.dZR, e.f.icon_sml_speed_gray);
        }
        if (this.dZX != null) {
            this.dZX.changeSkinType(i);
        }
        if (this.dZY != null) {
            this.dZY.changeSkinType(i);
        }
        if (this.dZU != null) {
            this.dZU.eo(i);
        }
        Iterator<TbImageView> it = this.dIQ.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aBB();
        al.i(this.dZH, e.f.home_thread_card_item_bg);
        al.h(this.dAB, e.d.cp_cont_b);
        if (this.dIG != null) {
            com.baidu.tbadk.o.a.a(this.dDf.getPageContext(), this.dIG);
        }
        if (this.dIR.getVisibility() == 0) {
            this.dIR.changeSkinType(i);
        }
        al.i(this.eaz, e.f.btn_round_cont_d);
        al.h(this.eaz, e.d.btn_cont_j_alpha_20_selector);
        al.j(this.dZB, e.d.common_color_10043);
        if (this.dIH != null && this.dIH.getVisibility() == 0) {
            this.dIH.onChangeSkinType();
        }
        if (this.eam) {
            aBK();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ead = forumData.getPost_num();
            this.eaa = forumData.getTag_color();
            this.ano = forumData.getImage_url();
            this.dZZ = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.eae = forumData.getSignData().count_sign_num;
                this.eaf = forumData.getSignData().miss_sign_num;
            }
            this.eag = forumData.getCurScore();
            this.dWE = forumData.getLevelupScore();
            this.dZV = forumData.getBadgeData();
            this.dZM = forumData.getTopCode();
            this.dZN = forumData.getNewsInfo();
            this.eab = forumData.getAccelerateContent();
            this.eam = forumData.isBrandForum;
            this.dXn = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.eac = new bb();
            aBM();
            aBQ();
            aBI();
            this.dIR.setVisibility(8);
            if (lVar != null && lVar.bzs() != null) {
                mg(lVar.bzs().grade.intValue());
                this.dIS = lVar.bzs().url;
            }
            if (lVar != null && lVar.hcA != null) {
                FrsTabInfo frsTabInfo = lVar.hcA;
                this.dIO = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dIP = frsTabInfo.tab_gid;
                this.eaz.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.eaz.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.ax(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.dIP);
                        amVar.ax("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.eaz.setOnClickListener(this.dIU);
            } else {
                this.eaz.setVisibility(8);
            }
            if (lVar != null && lVar.hcB != null) {
                this.dIH.setData(lVar.hcB);
                this.dIH.setVisibility(0);
                this.eay.setPadding(0, this.eay.getPaddingTop(), 0, 0);
                return;
            }
            this.dIH.setVisibility(8);
        }
    }

    protected void aBM() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.ano);
        this.eac.yN().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aBN() {
        Drawable drawable;
        int h = l.h(this.mContext.getPageActivity(), e.C0200e.tbds32);
        if (this.eaf > 0) {
            al.c(this.dZy, e.d.cp_cont_i, 1);
            Drawable drawable2 = al.getDrawable(e.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), e.C0200e.tbds24);
            this.dZy.setPadding(h2, 0, h2, 0);
            this.dZy.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dZy.setText(String.format(this.mContext.getString(e.j.miss_sign_days), Integer.valueOf(this.eaf)));
            al.i(this.dZy, e.f.frs_attention_btn_bg_selector);
        } else {
            if (this.eam) {
                drawable = al.getDrawable(e.f.icon_frs_sign_h_white);
                al.c(this.dZy, e.d.cp_cont_i, 1);
            } else {
                drawable = al.getDrawable(e.f.icon_public_sign_blue);
                al.c(this.dZy, e.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, h, h);
            this.dZy.setCompoundDrawables(drawable, null, null, null);
            this.dZy.setText(this.mContext.getString(e.j.signed));
            this.dZy.setPadding(0, 0, 0, 0);
            this.dZy.setBackgroundDrawable(null);
        }
        this.dZy.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds34));
        this.dZy.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aBO() {
        int h = l.h(this.mContext.getPageActivity(), e.C0200e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.dZy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dZy.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds34));
        al.c(this.dZy, e.d.cp_cont_i, 1);
        al.i(this.dZy, e.f.frs_attention_btn_bg_selector);
    }

    protected void aBP() {
        int h = l.h(this.mContext.getPageActivity(), e.C0200e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.dZx.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dZx.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds34));
        al.c(this.dZx, e.d.cp_cont_g, 1);
        al.i(this.dZx, e.f.frs_attention_btn_bg_selector);
    }

    protected void aBQ() {
        List<g> list = null;
        if (this.dZv != null) {
            this.dZv.setText(ao.L(this.mMemberNum));
        }
        if (this.dZw != null) {
            this.dZw.setText(ao.L(this.ead));
        }
        if (this.dZV != null && this.dZV.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.dne != null) {
                this.dne.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
            if (this.dAB != null) {
                this.dAB.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
        }
        if (this.dZD != null && this.dZE != null) {
            if (this.dXn != null && this.dXn.bzE()) {
                if (m.fb(this.dXn.bzG()) == 1 && !n.awE) {
                    this.dZD.setVisibility(8);
                } else {
                    this.dZD.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dXn.getGameName()) && !TextUtils.isEmpty(this.dXn.getGameName().trim())) {
                        this.dZE.setText(UtilHelper.getFixedText(this.dXn.getGameName(), 10));
                        String vn = com.baidu.tieba.tbadkCore.util.b.vn(this.dXn.bzG());
                        if (!StringUtils.isNull(vn)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", vn, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dZE.setText(this.mContext.getResources().getString(e.j.frsgame_title));
                    }
                }
            } else {
                this.dZD.setVisibility(8);
            }
        }
        this.dZL.setVisibility(8);
        this.dZX.a(null, null);
        if (this.dZD != null) {
            this.dZF = this.dZD.findViewById(e.g.top_item_divider);
        }
        aBR();
        if (this.dXn != null && !v.I(this.dXn.bzF())) {
            list = this.dXn.bzF();
            bR(list);
        }
        bC(list);
    }

    protected void aBR() {
        this.dZT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dZT.startLoad(this.ano, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void h(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.eat);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dZO);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds100));
                this.dZP = (TextView) this.dZO.findViewById(e.g.cur_experience);
                this.dZQ = (TextView) this.dZO.findViewById(e.g.levelup_experience);
                a(this.dZP, this.dZQ);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dZP, this.dZQ);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.eat, SystemScreenshotManager.DELAY_TIME);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(e.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(e.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(e.g.speed_tip);
            al.c((TextView) inflate.findViewById(e.g.experience_txt), e.d.cp_cont_b, 1);
            al.c(textView, e.d.cp_cont_b, 1);
            al.c(textView2, e.d.cp_cont_b, 1);
            al.c(textView3, e.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.G(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.eab) && !TextUtils.isEmpty(this.eab.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.eab);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cO(e.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.AB();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
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
    public void aBS() {
        View contentView;
        if (this.dZS == null) {
            this.dZS = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.speed_tip, (ViewGroup) null);
            this.dZS.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dZS, c.this.mContext.getPageActivity());
                        c.this.dDf.dBr = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dZS.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds300));
            this.dZS.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds88));
            this.dZS.setBackgroundDrawable(new BitmapDrawable());
            this.dZS.setOutsideTouchable(true);
            this.dZS.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dZS);
                        c.this.dDf.dBr = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dZS.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.dZR.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dZS, this.mParent, 0, (iArr[0] - (this.dZS.getWidth() / 2)) + (this.dZR.getWidth() / 2), iArr[1] + this.dZR.getWidth());
        this.dZS.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.eal = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(e.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.eal) {
                this.dZz.setText(e.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l azp = this.dDf.azp();
                if (azp != null && azp.ber() != null) {
                    azp.ber().setUser_level(i);
                }
                this.eax.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dZz.setText(this.dZZ);
                this.eax.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dZA.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, mh(this.mLevel)));
            if (this.eal) {
                if (f >= 1.0f) {
                    a(this.dDf.getBaseFragmentActivity(), this.dZA, this.ean, f);
                } else {
                    b(this.dDf.getBaseFragmentActivity(), this.dZA, this.ean, f);
                }
            } else {
                a(this.dDf.getBaseFragmentActivity(), this.dZA, this.ean, f);
            }
            this.ean = f;
        }
    }

    private int[] mh(int i) {
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
    protected void aBT() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aBU() {
        if (this.mMemberType != 0) {
            al.c(this.dZR, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.dZR, e.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agD() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Dp();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fG(String str) {
                ay.Db().c(c.this.mContext, new String[]{c.this.dIO});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fH(String str) {
            }
        });
        return aVar.A(pageActivity);
    }

    public String xg() {
        return this.dIP;
    }

    public String aBV() {
        return this.dIO;
    }
}
