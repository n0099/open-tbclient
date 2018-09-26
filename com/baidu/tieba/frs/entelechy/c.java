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
/* loaded from: classes2.dex */
public class c extends a {
    private String ahF;
    private RelativeLayout bsh;
    private final LinearLayout dzG;
    private TextView dzH;
    private TextView dzI;
    private ImageView dzJ;
    private String dzK;
    private String dzL;
    private FrsHeaderPraiseView dzN;
    private String dzO;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dzP = {e.f.icon_frs_emotion_level1, e.f.icon_frs_emotion_level2, e.f.icon_frs_emotion_level3, e.f.icon_frs_emotion_level4, e.f.icon_frs_emotion_level5};
    private View.OnClickListener dzQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
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
                    if (StringUtils.isNull(c.this.dzL)) {
                        ay.AN().c(c.this.mContext, new String[]{c.this.dzK});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.adw()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dzL));
                        }
                    } else if (PluginPackageManager.mT().cc("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.plugin_video_installing), 0).yt();
                        z = false;
                    } else {
                        ay.AN().c(c.this.mContext, new String[]{c.this.dzK});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.al(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.al(VideoPlayActivityConfig.OBJ_ID, c.this.dzL);
                    amVar.al("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.al("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.AN().c(c.this.mContext, new String[]{c.this.dzK});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.al(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.al(VideoPlayActivityConfig.OBJ_ID, c.this.dzL);
                amVar2.al("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.al("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dzM = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bsh = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.dtN = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dQd = l.h(frsFragment.getPageContext().getPageActivity(), e.C0141e.ds20);
        this.dQe = l.h(frsFragment.getPageContext().getPageActivity(), e.C0141e.ds72);
        this.dQf = l.h(frsFragment.getPageContext().getPageActivity(), e.C0141e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = ayV();
        this.bsh = (RelativeLayout) this.mParent.findViewById(e.g.container);
        this.dQz = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(e.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dQC = (ImageView) this.mParent.findViewById(e.g.speed_icon);
        this.dzH = (TextView) this.mParent.findViewById(e.g.member_image);
        this.dzI = (TextView) this.mParent.findViewById(e.g.post_image);
        this.dQk = (TextView) this.mParent.findViewById(e.g.level_name);
        this.dRi = (TextView) this.mParent.findViewById(e.g.level);
        this.dQi = (TextView) this.mParent.findViewById(e.g.tv_love);
        this.dQj = (TextView) this.mParent.findViewById(e.g.tv_sign);
        this.dQj.setContentDescription(frsFragment.getResources().getString(e.j.sign));
        this.dQl = (ImageView) this.mParent.findViewById(e.g.love_level_top);
        this.dQm = (ImageView) this.mParent.findViewById(e.g.love_level_bg);
        this.dQg = (TextView) this.mParent.findViewById(e.g.member_num_text);
        this.dQh = (TextView) this.mParent.findViewById(e.g.post_num_text);
        this.dQE = (BarImageView) this.mParent.findViewById(e.g.frs_image);
        this.drj = (TextView) this.mParent.findViewById(e.g.forum_name);
        this.dQZ = (TextView) this.mParent.findViewById(e.g.brand_label);
        this.dQE.setPageId(this.dtN.getUniqueId());
        this.dQE.setContentDescription(frsFragment.getResources().getString(e.j.bar_header));
        this.dQE.setGifIconSupport(false);
        this.dQE.setDrawerType(0);
        this.dQn = LayoutInflater.from(this.dtN.getPageContext().getPageActivity()).inflate(e.h.frs_header_extra_entelechy, (ViewGroup) null);
        ayM();
        ayS();
        this.dQo = (ViewGroup) this.dQn.findViewById(e.g.frs_header_games);
        this.dQp = (TextView) this.dQn.findViewById(e.g.top_item_title);
        this.dQw = (LinearLayout) this.dQn.findViewById(e.g.frs_present_root);
        this.dRk = (TextView) this.bsh.findViewById(e.g.new_chapter_btn);
        this.dQI = new com.baidu.tieba.frs.view.e(this.mContext, this.dQn);
        this.dQH = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dQs = (ViewGroup) this.dQn.findViewById(e.g.frs_headline);
        this.dQt = (TextView) this.dQs.findViewById(e.g.headline_title);
        this.dQu = (TextView) this.dQs.findViewById(e.g.headline_text);
        this.dQv = (TbImageView) this.dQs.findViewById(e.g.headline_image);
        this.dQv.setPageId(this.dtN.getUniqueId());
        this.dQs.setVisibility(8);
        this.dRh = this.mParent.findViewById(e.g.level_container);
        this.dRg = (RelativeLayout) this.mParent.findViewById(e.g.has_focused_container);
        this.dRf = (RelativeLayout) this.mParent.findViewById(e.g.not_focused_container);
        this.dRj = (RelativeLayout) this.mParent.findViewById(e.g.head_content_container);
        this.dzJ = (ImageView) this.mParent.findViewById(e.g.single_bar_level);
        this.dzJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig(c.this.mContext.getPageActivity(), true, 11003)));
                } else if (!j.kK()) {
                    l.showToast(c.this.mContext.getPageActivity(), e.j.neterror);
                } else if (!StringUtils.isNull(c.this.dzO) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.AN().c(c.this.mContext, new String[]{c.this.dzO + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        ayT();
        this.dzD = (FrsStarRankAndTaskContainer) this.mParent.findViewById(e.g.frs_star_rank_container);
        this.dzD.setContext(this.mContext);
        this.dzG = new LinearLayout(this.dtN.getContext());
        this.dzG.setOrientation(1);
        this.dzG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dzG.addView(this.dQr);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View ayR() {
        return this.dzG;
    }

    private void ayS() {
        this.dzN = (FrsHeaderPraiseView) this.dQn.findViewById(e.g.frs_praise_layout);
    }

    private void ayT() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ag.class);
        if (runTask != null && runTask.getData() != null) {
            this.dQJ = (ag) runTask.getData();
            this.dQJ.a(this.mContext, this.mParent, 1, false, this.dtN.getUniqueId());
            this.dQJ.hide();
        }
    }

    private void ayU() {
        final com.baidu.tbadk.core.data.l bxj = this.dOl.bxj();
        if (bxj != null && this.dOl.bbH() != null) {
            final String id = this.dOl.bbH().getId();
            final String name = this.dOl.bbH().getName();
            if (this.dRd.add(bxj.uL())) {
                a.C0242a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bxj.uL(), id, name, null);
                b.cw("obj_url", bxj.getUrl());
                b.save();
            }
            this.dQs.setVisibility(0);
            this.dQt.setText(bxj.getText());
            this.dQu.setText(bxj.getTitle());
            this.dQv.startLoad(bxj.uK(), 10, false);
            this.dQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0242a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bxj.uL(), id, name, null);
                    b2.cw("obj_url", bxj.getUrl());
                    b2.save();
                    ay.AN().c(c.this.dtN.getPageContext(), new String[]{bxj.getUrl()});
                }
            });
        }
    }

    protected View ayV() {
        return LayoutInflater.from(this.dtN.getPageContext().getPageActivity()).inflate(e.h.frs_normal_header, (ViewGroup) null);
    }

    private void lr(int i) {
        if (i <= 0 || i > 5 || this.dQX) {
            this.dzJ.setVisibility(8);
            this.drj.setMaxWidth(l.h(this.mContext.getPageActivity(), e.C0141e.ds370));
            return;
        }
        this.dzJ.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dzP[i - 1]);
        this.dzJ.setImageDrawable(drawable);
        this.drj.setMaxWidth((l.h(this.mContext.getPageActivity(), e.C0141e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dzJ.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void q(View.OnClickListener onClickListener) {
        this.dQE.setOnClickListener(onClickListener);
        this.drj.setOnClickListener(onClickListener);
        this.dQj.setOnClickListener(onClickListener);
        this.dQi.setOnClickListener(onClickListener);
        this.dRh.setOnClickListener(onClickListener);
        if (this.dQo != null) {
            this.dQo.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ayW() {
        al.j(this.dRj, e.d.black_alpha0);
        al.j(this.bsh, e.d.black_alpha0);
        al.h(this.drj, e.d.cp_cont_i);
        al.h(this.dQk, e.d.cp_cont_i);
        al.h(this.dRi, e.d.cp_cont_i);
        al.i(this.dQZ, e.f.enter_forum_brand_label_bg_shape);
        al.h(this.dQZ, e.d.cp_cont_i);
        al.h(this.dzH, e.d.cp_cont_i);
        al.h(this.dQg, e.d.cp_cont_i);
        al.h(this.dzI, e.d.cp_cont_i);
        al.h(this.dQh, e.d.cp_cont_i);
        al.j(this.dQm, e.d.white_alpha30);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ayX() {
        this.dQZ.setVisibility(0);
        this.dzJ.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.dQz);
        this.mContext.getLayoutMode().onModeChanged(this.dQn);
        if (this.dQV) {
            mH(1);
        } else {
            mH(0);
        }
        this.dQE.invalidate();
        al.j(this.bsh, e.d.cp_bg_line_d);
        al.h(this.dRi, e.d.cp_cont_j);
        al.h(this.dQk, e.d.cp_cont_j);
        al.h(this.dzH, e.d.cp_cont_j);
        al.h(this.dQg, e.d.cp_cont_j);
        al.h(this.dzI, e.d.cp_cont_j);
        al.h(this.dQh, e.d.cp_cont_j);
        this.dQE.setBorderWidth(l.h(this.mContext.getPageActivity(), e.C0141e.tbds1));
        this.dQE.setBorderColor(al.getColor(e.d.black_alpha15));
        azb();
        if (this.dQo != null) {
            al.i(this.dQo, e.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.dQC, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.dQC, e.f.icon_sml_speed_gray);
        }
        if (this.dQI != null) {
            this.dQI.changeSkinType(i);
        }
        if (this.dQJ != null) {
            this.dQJ.changeSkinType(i);
        }
        if (this.dQF != null) {
            this.dQF.dQ(i);
        }
        Iterator<TbImageView> it = this.dzM.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        ayN();
        al.i(this.dQs, e.f.home_thread_card_item_bg);
        al.h(this.drj, e.d.cp_cont_b);
        if (this.dzC != null) {
            com.baidu.tbadk.o.a.a(this.dtN.getPageContext(), this.dzC);
        }
        if (this.dzN.getVisibility() == 0) {
            this.dzN.changeSkinType(i);
        }
        al.i(this.dRk, e.f.btn_round_cont_d);
        al.h(this.dRk, e.d.btn_cont_j_alpha_20_selector);
        al.j(this.dQm, e.d.common_color_10043);
        if (this.dzD != null && this.dzD.getVisibility() == 0) {
            this.dzD.onChangeSkinType();
        }
        if (this.dQX) {
            ayW();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dQO = forumData.getPost_num();
            this.dQL = forumData.getTag_color();
            this.ahF = forumData.getImage_url();
            this.dQK = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dQP = forumData.getSignData().count_sign_num;
                this.dQQ = forumData.getSignData().miss_sign_num;
            }
            this.dQR = forumData.getCurScore();
            this.dNC = forumData.getLevelupScore();
            this.dQG = forumData.getBadgeData();
            this.dQx = forumData.getTopCode();
            this.dQy = forumData.getNewsInfo();
            this.dQM = forumData.getAccelerateContent();
            this.dQX = forumData.isBrandForum;
            this.dOl = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dQN = new bb();
            ayY();
            azc();
            ayU();
            this.dzN.setVisibility(8);
            if (lVar != null && lVar.bwH() != null) {
                lr(lVar.bwH().grade.intValue());
                this.dzO = lVar.bwH().url;
            }
            if (lVar != null && lVar.gTH != null) {
                FrsTabInfo frsTabInfo = lVar.gTH;
                this.dzK = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dzL = frsTabInfo.tab_gid;
                this.dRk.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dRk.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.al(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.al(VideoPlayActivityConfig.OBJ_ID, this.dzL);
                        amVar.al("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.dRk.setOnClickListener(this.dzQ);
            } else {
                this.dRk.setVisibility(8);
            }
            if (lVar != null && lVar.gTI != null) {
                this.dzD.setData(lVar.gTI);
                this.dzD.setVisibility(0);
                this.dRj.setPadding(0, this.dRj.getPaddingTop(), 0, 0);
                return;
            }
            this.dzD.setVisibility(8);
        }
    }

    protected void ayY() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.ahF);
        this.dQN.wx().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void ayZ() {
        Drawable drawable;
        int h = l.h(this.mContext.getPageActivity(), e.C0141e.tbds32);
        if (this.dQQ > 0) {
            al.c(this.dQj, e.d.cp_cont_i, 1);
            Drawable drawable2 = al.getDrawable(e.f.icon_public_sign_bu_n);
            drawable2.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), e.C0141e.tbds24);
            this.dQj.setPadding(h2, 0, h2, 0);
            this.dQj.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dQj.setText(String.format(this.mContext.getString(e.j.miss_sign_days), Integer.valueOf(this.dQQ)));
            al.i(this.dQj, e.f.frs_attention_btn_bg_selector);
        } else {
            if (this.dQX) {
                drawable = al.getDrawable(e.f.icon_frs_sign_h_white);
                al.c(this.dQj, e.d.cp_cont_i, 1);
            } else {
                drawable = al.getDrawable(e.f.icon_public_sign_blue);
                al.c(this.dQj, e.d.cp_cont_e, 1);
            }
            drawable.setBounds(0, 0, h, h);
            this.dQj.setCompoundDrawables(drawable, null, null, null);
            this.dQj.setText(this.mContext.getString(e.j.signed));
            this.dQj.setPadding(0, 0, 0, 0);
            this.dQj.setBackgroundDrawable(null);
        }
        this.dQj.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds34));
        this.dQj.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void aza() {
        int h = l.h(this.mContext.getPageActivity(), e.C0141e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.dQj.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dQj.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds34));
        al.c(this.dQj, e.d.cp_cont_i, 1);
        al.i(this.dQj, e.f.frs_attention_btn_bg_selector);
    }

    protected void azb() {
        int h = l.h(this.mContext.getPageActivity(), e.C0141e.tbds32);
        Drawable drawable = al.getDrawable(e.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        this.dQi.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dQi.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.tbds34));
        al.c(this.dQi, e.d.cp_cont_g, 1);
        al.i(this.dQi, e.f.frs_attention_btn_bg_selector);
    }

    protected void azc() {
        List<g> list = null;
        if (this.dQg != null) {
            this.dQg.setText(ao.H(this.mMemberNum));
        }
        if (this.dQh != null) {
            this.dQh.setText(ao.H(this.dQO));
        }
        if (this.dQG != null && this.dQG.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.ddU != null) {
                this.ddU.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
            if (this.drj != null) {
                this.drj.setText(this.mForumName + this.mContext.getString(e.j.forum));
            }
        }
        if (this.dQo != null && this.dQp != null) {
            if (this.dOl != null && this.dOl.bwT()) {
                if (m.eM(this.dOl.bwV()) == 1 && !n.arb) {
                    this.dQo.setVisibility(8);
                } else {
                    this.dQo.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dOl.getGameName()) && !TextUtils.isEmpty(this.dOl.getGameName().trim())) {
                        this.dQp.setText(UtilHelper.getFixedText(this.dOl.getGameName(), 10));
                        String uG = com.baidu.tieba.tbadkCore.util.b.uG(this.dOl.bwV());
                        if (!StringUtils.isNull(uG)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", uG, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dQp.setText(this.mContext.getResources().getString(e.j.frsgame_title));
                    }
                }
            } else {
                this.dQo.setVisibility(8);
            }
        }
        this.dQw.setVisibility(8);
        this.dQI.a(null, null);
        if (this.dQo != null) {
            this.dQq = this.dQo.findViewById(e.g.top_item_divider);
        }
        azd();
        if (this.dOl != null && !v.z(this.dOl.bwU())) {
            list = this.dOl.bwU();
            bD(list);
        }
        bo(list);
    }

    protected void azd() {
        this.dQE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dQE.startLoad(this.ahF, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dRe);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dQz);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds100));
                this.dQA = (TextView) this.dQz.findViewById(e.g.cur_experience);
                this.dQB = (TextView) this.dQz.findViewById(e.g.levelup_experience);
                a(this.dQA, this.dQB);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dQA, this.dQB);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dRe, 2000L);
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
            if (!TextUtils.isEmpty(this.dQM) && !TextUtils.isEmpty(this.dQM.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dQM);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cq(e.d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.yl();
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
    public void aze() {
        View contentView;
        if (this.dQD == null) {
            this.dQD = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(e.h.speed_tip, (ViewGroup) null);
            this.dQD.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dQD, c.this.mContext.getPageActivity());
                        c.this.dtN.drY = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(e.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dQD.setWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds300));
            this.dQD.setHeight(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds88));
            this.dQD.setBackgroundDrawable(new BitmapDrawable());
            this.dQD.setOutsideTouchable(true);
            this.dQD.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dQD);
                        c.this.dtN.drY = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dQD.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.dQC.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dQD, this.mParent, 0, (iArr[0] - (this.dQD.getWidth() / 2)) + (this.dQC.getWidth() / 2), iArr[1] + this.dQC.getWidth());
        this.dQD.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.dQW = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(e.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dQW) {
                this.dQk.setText(e.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l awv = this.dtN.awv();
                if (awv != null && awv.bbH() != null) {
                    awv.bbH().setUser_level(i);
                }
                this.dRi.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(i)));
            } else {
                this.dQk.setText(this.dQK);
                this.dRi.setText(this.mContext.getResources().getString(e.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dQl.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ls(this.mLevel)));
            if (this.dQW) {
                if (f >= 1.0f) {
                    a(this.dtN.getBaseFragmentActivity(), this.dQl, this.dQY, f);
                } else {
                    b(this.dtN.getBaseFragmentActivity(), this.dQl, this.dQY, f);
                }
            } else {
                a(this.dtN.getBaseFragmentActivity(), this.dQl, this.dQY, f);
            }
            this.dQY = f;
        }
    }

    private int[] ls(int i) {
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
    protected void azf() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void azg() {
        if (this.mMemberType != 0) {
            al.c(this.dQC, e.f.icon_sml_speed_orange);
        } else {
            al.c(this.dQC, e.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adw() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Bb();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.8
            @Override // com.baidu.tbadk.core.util.b.a.b
            public void fs(String str) {
                ay.AN().c(c.this.mContext, new String[]{c.this.dzK});
            }

            @Override // com.baidu.tbadk.core.util.b.a.b
            public void ft(String str) {
            }
        });
        return aVar.x(pageActivity);
    }

    public String uP() {
        return this.dzL;
    }

    public String azh() {
        return this.dzK;
    }
}
