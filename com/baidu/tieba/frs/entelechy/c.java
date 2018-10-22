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
    private String amB;
    private RelativeLayout bwo;
    private final LinearLayout dHG;
    private TextView dHH;
    private TextView dHI;
    private ImageView dHJ;
    private String dHK;
    private String dHL;
    private FrsHeaderPraiseView dHN;
    private String dHO;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dHP = {e.f.icon_frs_emotion_level1, e.f.icon_frs_emotion_level2, e.f.icon_frs_emotion_level3, e.f.icon_frs_emotion_level4, e.f.icon_frs_emotion_level5};
    private View.OnClickListener dHQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dHL)) {
                        ay.CU().c(c.this.mContext, new String[]{c.this.dHK});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.ahd()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dHL));
                        }
                    } else if (PluginPackageManager.nd().cb("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).AC();
                        z = false;
                    } else {
                        ay.CU().c(c.this.mContext, new String[]{c.this.dHK});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.ax(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.ax(VideoPlayActivityConfig.OBJ_ID, c.this.dHL);
                    amVar.ax("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.ax("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.CU().c(c.this.mContext, new String[]{c.this.dHK});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.ax(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.ax(VideoPlayActivityConfig.OBJ_ID, c.this.dHL);
                amVar2.ax("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.ax("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dHM = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bwo = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dBO = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dXZ = l.h(frsFragment.getPageContext().getPageActivity(), e.C0175e.ds20);
        this.dYa = l.h(frsFragment.getPageContext().getPageActivity(), e.C0175e.ds72);
        this.dYb = l.h(frsFragment.getPageContext().getPageActivity(), e.C0175e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = aCp();
        this.bwo = (RelativeLayout) this.mParent.findViewById(e.g.container);
        this.dYv = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(e.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dYy = (ImageView) this.mParent.findViewById(e.g.speed_icon);
        this.dHH = (TextView) this.mParent.findViewById(e.g.member_image);
        this.dHI = (TextView) this.mParent.findViewById(e.g.post_image);
        this.dYg = (TextView) this.mParent.findViewById(e.g.level_name);
        this.dZe = (TextView) this.mParent.findViewById(e.g.level);
        this.dYe = (TextView) this.mParent.findViewById(e.g.tv_love);
        this.dYf = (TextView) this.mParent.findViewById(e.g.tv_sign);
        this.dYf.setContentDescription(frsFragment.getResources().getString(e.j.sign));
        this.dYh = (ImageView) this.mParent.findViewById(e.g.love_level_top);
        this.dYi = (ImageView) this.mParent.findViewById(e.g.love_level_bg);
        this.dYc = (TextView) this.mParent.findViewById(e.g.member_num_text);
        this.dYd = (TextView) this.mParent.findViewById(e.g.post_num_text);
        this.dYA = (BarImageView) this.mParent.findViewById(e.g.frs_image);
        this.dzk = (TextView) this.mParent.findViewById(e.g.forum_name);
        this.dYV = (TextView) this.mParent.findViewById(e.g.brand_label);
        this.dYA.setPageId(this.dBO.getUniqueId());
        this.dYA.setContentDescription(frsFragment.getResources().getString(e.j.bar_header));
        this.dYA.setGifIconSupport(false);
        this.dYA.setDrawerType(0);
        this.dYj = LayoutInflater.from(this.dBO.getPageContext().getPageActivity()).inflate(e.h.frs_header_extra_entelechy, (ViewGroup) null);
        aCg();
        aCm();
        this.dYk = (ViewGroup) this.dYj.findViewById(e.g.frs_header_games);
        this.dYl = (TextView) this.dYj.findViewById(e.g.top_item_title);
        this.dYs = (LinearLayout) this.dYj.findViewById(e.g.frs_present_root);
        this.dZg = (TextView) this.bwo.findViewById(e.g.new_chapter_btn);
        this.dYE = new com.baidu.tieba.frs.view.e(this.mContext, this.dYj);
        this.dYD = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dYo = (ViewGroup) this.dYj.findViewById(e.g.frs_headline);
        this.dYp = (TextView) this.dYo.findViewById(e.g.headline_title);
        this.dYq = (TextView) this.dYo.findViewById(e.g.headline_text);
        this.dYr = (TbImageView) this.dYo.findViewById(e.g.headline_image);
        this.dYr.setPageId(this.dBO.getUniqueId());
        this.dYo.setVisibility(8);
        this.dZd = this.mParent.findViewById(e.g.level_container);
        this.dZc = (RelativeLayout) this.mParent.findViewById(e.g.has_focused_container);
        this.dZb = (RelativeLayout) this.mParent.findViewById(e.g.not_focused_container);
        this.dZf = (RelativeLayout) this.mParent.findViewById(e.g.head_content_container);
        this.dHJ = (ImageView) this.mParent.findViewById(e.g.single_bar_level);
        this.dHJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.kX()) {
                    l.showToast(c.this.mContext.getPageActivity(), e.j.neterror);
                } else if (!StringUtils.isNull(c.this.dHO) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.CU().c(c.this.mContext, new String[]{c.this.dHO + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        aCn();
        this.dHD = (FrsStarRankAndTaskContainer) this.mParent.findViewById(e.g.frs_star_rank_container);
        this.dHD.setContext(this.mContext);
        this.dHG = new LinearLayout(this.dBO.getContext());
        this.dHG.setOrientation(1);
        this.dHG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dHG.addView(this.dYn);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View aCl() {
        return this.dHG;
    }

    private void aCm() {
        this.dHN = (FrsHeaderPraiseView) this.dYj.findViewById(e.g.frs_praise_layout);
    }

    private void aCn() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.dYF = (ag) runTask.getData();
            this.dYF.a(this.mContext, this.mParent, 1, false, this.dBO.getUniqueId());
            this.dYF.hide();
        }
    }

    private void aCo() {
        final com.baidu.tbadk.core.data.l bAy = this.dWh.bAy();
        if (bAy != null && this.dWh.beT() != null) {
            final String id = this.dWh.beT().getId();
            final String name = this.dWh.beT().getName();
            if (this.dYZ.add(bAy.wU())) {
                a.C0277a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bAy.wU(), id, name, null);
                b.cH("obj_url", bAy.getUrl());
                b.save();
            }
            this.dYo.setVisibility(0);
            this.dYp.setText(bAy.getText());
            this.dYq.setText(bAy.getTitle());
            this.dYr.startLoad(bAy.wT(), 10, false);
            this.dYo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0277a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bAy.wU(), id, name, null);
                    b2.cH("obj_url", bAy.getUrl());
                    b2.save();
                    ay.CU().c(c.this.dBO.getPageContext(), new String[]{bAy.getUrl()});
                }
            });
        }
    }

    protected View aCp() {
        return LayoutInflater.from(this.dBO.getPageContext().getPageActivity()).inflate(e.h.frs_normal_header, (ViewGroup) null);
    }

    private void lP(int i) {
        if (i <= 0 || i > 5 || this.dYT) {
            this.dHJ.setVisibility(8);
            this.dzk.setMaxWidth(l.h(this.mContext.getPageActivity(), e.C0175e.ds370));
            return;
        }
        this.dHJ.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dHP[i - 1]);
        this.dHJ.setImageDrawable(drawable);
        this.dzk.setMaxWidth((l.h(this.mContext.getPageActivity(), e.C0175e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dHJ.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void q(View.OnClickListener onClickListener) {
        this.dYA.setOnClickListener(onClickListener);
        this.dzk.setOnClickListener(onClickListener);
        this.dYf.setOnClickListener(onClickListener);
        this.dYe.setOnClickListener(onClickListener);
        this.dZd.setOnClickListener(onClickListener);
        if (this.dYk != null) {
            this.dYk.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aCq() {
        al.j(this.dZf, e.d.black_alpha0);
        al.j(this.bwo, e.d.black_alpha0);
        al.h(this.dzk, e.d.cp_cont_i);
        al.h(this.dYg, e.d.cp_cont_i);
        al.h(this.dZe, e.d.cp_cont_i);
        al.i(this.dYV, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.dYV, e.d.cp_cont_i);
        al.h(this.dHH, e.d.cp_cont_i);
        al.h(this.dYc, e.d.cp_cont_i);
        al.h(this.dHI, e.d.cp_cont_i);
        al.h(this.dYd, e.d.cp_cont_i);
        al.j(this.dYi, e.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aCr() {
        this.dYV.setVisibility(0);
        this.dHJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.dYv);
        this.mContext.getLayoutMode().onModeChanged(this.dYj);
        if (this.dYR) {
            nf(1);
        } else {
            nf(0);
        }
        this.dYA.invalidate();
        al.j(this.bwo, e.d.cp_bg_line_d);
        al.h(this.dZe, e.d.cp_cont_j);
        al.h(this.dYg, e.d.cp_cont_j);
        al.h(this.dHH, e.d.cp_cont_j);
        al.h(this.dYc, e.d.cp_cont_j);
        al.h(this.dHI, e.d.cp_cont_j);
        al.h(this.dYd, e.d.cp_cont_j);
        this.dYA.setBorderWidth(l.h(this.mContext.getPageActivity(), e.C0175e.tbds1));
        this.dYA.setBorderColor(al.getColor(e.d.black_alpha15));
        aCv();
        if (this.dYk != null) {
            al.i(this.dYk, e.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.dYy, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.dYy, e.f.icon_sml_speed_gray);
        }
        if (this.dYE != null) {
            this.dYE.changeSkinType(i);
        }
        if (this.dYF != null) {
            this.dYF.changeSkinType(i);
        }
        if (this.dYB != null) {
            this.dYB.ea(i);
        }
        Iterator<TbImageView> it = this.dHM.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aCh();
        al.i(this.dYo, e.f.home_thread_card_item_bg);
        al.h(this.dzk, e.d.cp_cont_b);
        if (this.dHC != null) {
            com.baidu.tbadk.o.a.a(this.dBO.getPageContext(), this.dHC);
        }
        if (this.dHN.getVisibility() == 0) {
            this.dHN.changeSkinType(i);
        }
        al.i(this.dZg, e.f.btn_round_cont_d);
        al.h(this.dZg, e.d.btn_cont_j_alpha_20_selector);
        al.j(this.dYi, e.d.common_color_10043);
        if (this.dHD != null && this.dHD.getVisibility() == 0) {
            this.dHD.onChangeSkinType();
        }
        if (this.dYT) {
            aCq();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dYK = forumData.getPost_num();
            this.dYH = forumData.getTag_color();
            this.amB = forumData.getImage_url();
            this.dYG = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dYL = forumData.getSignData().count_sign_num;
                this.dYM = forumData.getSignData().miss_sign_num;
            }
            this.dYN = forumData.getCurScore();
            this.dVy = forumData.getLevelupScore();
            this.dYC = forumData.getBadgeData();
            this.dYt = forumData.getTopCode();
            this.dYu = forumData.getNewsInfo();
            this.dYI = forumData.getAccelerateContent();
            this.dYT = forumData.isBrandForum;
            this.dWh = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dYJ = new bb();
            aCs();
            aCw();
            aCo();
            this.dHN.setVisibility(8);
            if (lVar != null && lVar.bzW() != null) {
                lP(lVar.bzW().grade.intValue());
                this.dHO = lVar.bzW().url;
            }
            if (lVar != null && lVar.hbd != null) {
                FrsTabInfo frsTabInfo = lVar.hbd;
                this.dHK = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dHL = frsTabInfo.tab_gid;
                this.dZg.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dZg.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.ax(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.dHL);
                        amVar.ax("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.dZg.setOnClickListener(this.dHQ);
            } else {
                this.dZg.setVisibility(8);
            }
            if (lVar != null && lVar.hbe != null) {
                this.dHD.setData(lVar.hbe);
                this.dHD.setVisibility(0);
                this.dZf.setPadding(0, this.dZf.getPaddingTop(), 0, 0);
                return;
            }
            this.dHD.setVisibility(8);
        }
    }

    protected void aCs() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.amB);
        this.dYJ.yG().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aCt() {
        Drawable drawable;
        int h = l.h(this.mContext.getPageActivity(), e.C0175e.tbds32);
        if (this.dYM > 0) {
            al.c(this.dYf, e.d.cp_cont_i, 1);
            Drawable drawable2 = al.getDrawable(e.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), e.C0175e.tbds24);
            this.dYf.setPadding(h2, 0, h2, 0);
            this.dYf.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dYf.setText(String.format(this.mContext.getString(e.j.miss_sign_days), Integer.valueOf(this.dYM)));
            al.i(this.dYf, e.f.frs_attention_btn_bg_selector);
        } else {
            if (this.dYT) {
                drawable = al.getDrawable(e.f.icon_frs_sign_h_white);
                al.c(this.dYf, e.d.cp_cont_i, 1);
            } else {
                drawable = al.getDrawable(e.f.icon_public_sign_blue);
                al.c(this.dYf, e.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, h, h);
            this.dYf.setCompoundDrawables(drawable, null, null, null);
            this.dYf.setText(this.mContext.getString(e.j.signed));
            this.dYf.setPadding(0, 0, 0, 0);
            this.dYf.setBackgroundDrawable(null);
        }
        this.dYf.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds34));
        this.dYf.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aCu() {
        int h = l.h(this.mContext.getPageActivity(), e.C0175e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.dYf.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dYf.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds34));
        al.c(this.dYf, e.d.cp_cont_i, 1);
        al.i(this.dYf, e.f.frs_attention_btn_bg_selector);
    }

    protected void aCv() {
        int h = l.h(this.mContext.getPageActivity(), e.C0175e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.dYe.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dYe.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.tbds34));
        al.c(this.dYe, e.d.cp_cont_g, 1);
        al.i(this.dYe, e.f.frs_attention_btn_bg_selector);
    }

    protected void aCw() {
        List<g> list = null;
        if (this.dYc != null) {
            this.dYc.setText(ao.J(this.mMemberNum));
        }
        if (this.dYd != null) {
            this.dYd.setText(ao.J(this.dYK));
        }
        if (this.dYC != null && this.dYC.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.dma != null) {
                this.dma.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
            if (this.dzk != null) {
                this.dzk.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
        }
        if (this.dYk != null && this.dYl != null) {
            if (this.dWh != null && this.dWh.bAi()) {
                if (m.fb(this.dWh.bAk()) == 1 && !n.avR) {
                    this.dYk.setVisibility(8);
                } else {
                    this.dYk.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dWh.getGameName()) && !TextUtils.isEmpty(this.dWh.getGameName().trim())) {
                        this.dYl.setText(UtilHelper.getFixedText(this.dWh.getGameName(), 10));
                        String vi = com.baidu.tieba.tbadkCore.util.b.vi(this.dWh.bAk());
                        if (!StringUtils.isNull(vi)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", vi, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dYl.setText(this.mContext.getResources().getString(e.j.frsgame_title));
                    }
                }
            } else {
                this.dYk.setVisibility(8);
            }
        }
        this.dYs.setVisibility(8);
        this.dYE.a(null, null);
        if (this.dYk != null) {
            this.dYm = this.dYk.findViewById(e.g.top_item_divider);
        }
        aCx();
        if (this.dWh != null && !v.J(this.dWh.bAj())) {
            list = this.dWh.bAj();
            bT(list);
        }
        bE(list);
    }

    protected void aCx() {
        this.dYA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dYA.startLoad(this.amB, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dZa);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dYv);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds100));
                this.dYw = (TextView) this.dYv.findViewById(e.g.cur_experience);
                this.dYx = (TextView) this.dYv.findViewById(e.g.levelup_experience);
                a(this.dYw, this.dYx);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dYw, this.dYx);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dZa, SystemScreenshotManager.DELAY_TIME);
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
            if (!TextUtils.isEmpty(this.dYI) && !TextUtils.isEmpty(this.dYI.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dYI);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cA(e.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.Au();
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
    public void aCy() {
        View contentView;
        if (this.dYz == null) {
            this.dYz = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.speed_tip, (ViewGroup) null);
            this.dYz.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dYz, c.this.mContext.getPageActivity());
                        c.this.dBO.dAa = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dYz.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds300));
            this.dYz.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds88));
            this.dYz.setBackgroundDrawable(new BitmapDrawable());
            this.dYz.setOutsideTouchable(true);
            this.dYz.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dYz);
                        c.this.dBO.dAa = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dYz.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.dYy.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dYz, this.mParent, 0, (iArr[0] - (this.dYz.getWidth() / 2)) + (this.dYy.getWidth() / 2), iArr[1] + this.dYy.getWidth());
        this.dYz.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.dYS = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(e.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dYS) {
                this.dYg.setText(e.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l azS = this.dBO.azS();
                if (azS != null && azS.beT() != null) {
                    azS.beT().setUser_level(i);
                }
                this.dZe.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dYg.setText(this.dYG);
                this.dZe.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dYh.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, lQ(this.mLevel)));
            if (this.dYS) {
                if (f >= 1.0f) {
                    a(this.dBO.getBaseFragmentActivity(), this.dYh, this.dYU, f);
                } else {
                    b(this.dBO.getBaseFragmentActivity(), this.dYh, this.dYU, f);
                }
            } else {
                a(this.dBO.getBaseFragmentActivity(), this.dYh, this.dYU, f);
            }
            this.dYU = f;
        }
    }

    private int[] lQ(int i) {
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
    protected void aCz() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void aCA() {
        if (this.mMemberType != 0) {
            al.c(this.dYy, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.dYy, e.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahd() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Di();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fG(String str) {
                ay.CU().c(c.this.mContext, new String[]{c.this.dHK});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fH(String str) {
            }
        });
        return aVar.z(pageActivity);
    }

    public String wY() {
        return this.dHL;
    }

    public String aCB() {
        return this.dHK;
    }
}
