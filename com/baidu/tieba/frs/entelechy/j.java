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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.view.ForumHeadSdkView;
import com.baidu.tieba.frs.view.ForumMemberIconView;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends g {
    private static final String DEFAULT_BADGE_URL = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected RelativeLayout aVp;
    private BlurDrawable bbR;
    protected Runnable bbS;
    protected String mImageUrl;
    private CustomMessageListener bRt = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bRs = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aVp = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bOf = frsActivity;
        this.aaX = frsActivity.getPageContext();
        this.cct = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds20);
        this.ccu = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds72);
        this.ccv = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aXl = aaP();
        this.aVp = (RelativeLayout) this.aXl.findViewById(w.h.container);
        this.aVp.setPadding(0, com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds150), 0, 0);
        this.cdn = (ForumMemberIconView) this.aXl.findViewById(w.h.forum_member_icon_layout);
        this.cdn.setVisibility(8);
        this.cdc = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(w.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aXl.setVisibility(8);
        }
        this.ccQ = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(w.j.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.g(this.aaX.getPageActivity(), w.f.ds220), 0, 0);
        this.ccQ.setLayoutParams(layoutParams);
        this.ccP = (CoverFlowView) this.aXl.findViewById(w.h.nomal_frs_coverflowview);
        this.ccS = (ForumHeadSdkView) this.aXl.findViewById(w.h.frs_head_sdk);
        aew();
        this.ccH = (RelativeLayout) this.aXl.findViewById(w.h.btn_love_content);
        this.cdf = (ImageView) this.aXl.findViewById(w.h.speed_icon);
        this.ccI = (TextView) this.aXl.findViewById(w.h.level_name);
        this.ccJ = (ImageView) this.aXl.findViewById(w.h.level);
        this.ccK = (ImageView) this.aXl.findViewById(w.h.love_level_top);
        this.ccy = (FrameLayout) this.aXl.findViewById(w.h.love);
        this.ccz = (Button) this.aXl.findViewById(w.h.btn_love);
        this.ccz.setContentDescription(frsActivity.getResources().getString(w.l.attention));
        this.ccA = (TextView) this.aXl.findViewById(w.h.tv_love);
        this.ccB = (FrameLayout) this.aXl.findViewById(w.h.sign);
        this.ccC = (Button) this.aXl.findViewById(w.h.btn_sign);
        this.ccD = (TextView) this.aXl.findViewById(w.h.tv_sign);
        this.ccD.setContentDescription(frsActivity.getResources().getString(w.l.sign));
        this.ccE = (ProgressBar) this.aXl.findViewById(w.h.sign_progress);
        this.ccF = (FrameLayout) this.aXl.findViewById(w.h.sign_done);
        this.ccG = (TextView) this.aXl.findViewById(w.h.sign_done_text);
        this.ccw = (TextView) this.aXl.findViewById(w.h.member_num_text);
        this.ccx = (TextView) this.aXl.findViewById(w.h.post_num_text);
        this.bIG = (TextView) this.aXl.findViewById(w.h.title_text);
        this.cdh = (BarImageView) this.aXl.findViewById(w.h.frs_image);
        this.cdh.setContentDescription(frsActivity.getResources().getString(w.l.bar_header));
        this.cdh.setGifIconSupport(false);
        this.cdh.setDrawerType(0);
        this.cdi = (UserIconBox) this.aXl.findViewById(w.h.frs_badge_box);
        this.ccL = LayoutInflater.from(this.bOf.getPageContext().getPageActivity()).inflate(w.j.frs_header_extra_entelechy, (ViewGroup) null);
        this.ccM = this.ccL.findViewById(w.h.extra_mask_view);
        aq.k(this.ccM, w.e.black_alpha0);
        aaT();
        this.ccN = (ViewGroup) this.ccL.findViewById(w.h.frs_header_games);
        this.ccO = (TextView) this.ccL.findViewById(w.h.top_item_title);
        this.ccX = (LinearLayout) this.ccL.findViewById(w.h.frs_header_enter_root);
        this.ccY = (LinearLayout) this.ccL.findViewById(w.h.frs_present_root);
        this.cdl = new com.baidu.tieba.frs.view.p(this.aaX, this.ccL);
        this.cdk = new com.baidu.tieba.frs.f.b(this.aaX);
        this.ccT = (ViewGroup) this.ccL.findViewById(w.h.frs_headline);
        this.ccU = (TextView) this.ccT.findViewById(w.h.headline_title);
        this.ccV = (TextView) this.ccT.findViewById(w.h.headline_text);
        this.ccW = (TbImageView) this.ccT.findViewById(w.h.headline_image);
        this.ccT.setVisibility(8);
        aba();
        MessageManager.getInstance().registerListener(this.bRt);
    }

    private void aba() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), cc.class);
        if (runTask != null && runTask.getData() != null) {
            this.cdm = (cc) runTask.getData();
            this.cdm.a(this.aaX, this.aXl, 1, false);
            this.cdm.hide();
        }
    }

    private void abb() {
        com.baidu.tbadk.core.data.m bgO = this.bSZ.bgO();
        if (bgO != null && this.bSZ.aJw() != null) {
            String id = this.bSZ.aJw().getId();
            String name = this.bSZ.aJw().getName();
            if (this.cdJ.add(bgO.qb())) {
                a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bgO.qb(), id, name, null);
                a.cc("obj_url", bgO.getUrl());
                a.save();
            }
            this.ccT.setVisibility(0);
            this.ccU.setText(bgO.getText());
            this.ccV.setText(bgO.getTitle());
            this.ccW.c(bgO.qa(), 10, false);
            this.ccT.setOnClickListener(new l(this, bgO, id, name));
        }
    }

    protected View aaP() {
        return LayoutInflater.from(this.bOf.getPageContext().getPageActivity()).inflate(w.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cdh.setOnClickListener(onClickListener);
        this.bIG.setOnClickListener(onClickListener);
        this.ccz.setOnClickListener(onClickListener);
        this.ccC.setOnClickListener(onClickListener);
        this.ccF.setOnClickListener(onClickListener);
        this.ccH.setOnClickListener(onClickListener);
        if (this.ccN != null) {
            this.ccN.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aaX.getLayoutMode().aj(i == 1);
        this.aaX.getLayoutMode().t(this.aXl);
        this.aaX.getLayoutMode().t(this.cdc);
        this.aaX.getLayoutMode().t(this.ccL);
        if (this.cdC) {
            iL(1);
        } else {
            iL(0);
        }
        if (this.ccP != null) {
            this.ccP.onChangeSkinType();
        }
        if (this.ccS != null) {
            this.ccS.d(this.aaX, i);
        }
        this.cdh.invalidate();
        aq.c(this.ccJ, BitmapHelper.getSmallGradeResourceIdNew(this.bfk));
        if (this.bbR != null && this.bbR.getBlurredBitmap() != null && !this.bbR.getBlurredBitmap().isRecycled()) {
            this.aVp.setBackgroundDrawable(new BitmapDrawable(this.bbR.getBlurredBitmap()));
        } else {
            aq.k(this.aVp, w.e.cp_bg_line_d);
        }
        abc();
        if (this.ccN != null) {
            aq.j(this.ccN, w.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aq.c(this.cdf, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.cdf, w.g.icon_sml_speed_gray);
        }
        if (this.cdl != null) {
            this.cdl.changeSkinType(i);
        }
        if (this.cdm != null) {
            this.cdm.changeSkinType(i);
        }
        if (this.cdi != null) {
            this.cdi.m12do(i);
        }
        if (this.cdn != null) {
            this.cdn.d(this.aaX, i);
        }
        Iterator<TbImageView> it = this.bRs.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aaV();
        aq.j(this.ccT, w.g.home_thread_card_item_bg);
        if (this.bRl != null) {
            com.baidu.tbadk.m.a.a(this.bOf.getPageContext(), this.bRl);
        }
    }

    protected void abc() {
        this.ccA.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.ccD.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cdu = forumData.getPost_num();
            this.cdq = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.cdp = forumData.getLevelName();
            this.bfk = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cdv = forumData.getSignData().count_sign_num;
                this.cdw = forumData.getSignData().miss_sign_num;
            }
            this.cdx = forumData.getCurScore();
            this.cby = forumData.getLevelupScore();
            this.cdj = forumData.getBadgeData();
            this.ccZ = forumData.getTopCode();
            this.cda = forumData.getNewsInfo();
            this.cdr = forumData.getAccelerateContent();
            this.cdo = forumData.getMemberShowIconData();
            this.bSZ = nVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aXl.setVisibility(8);
            } else {
                this.aXl.setVisibility(0);
            }
            this.cds = new bi();
            abd();
            aaQ();
            abb();
        }
    }

    protected void abd() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.cds.sy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void abe() {
        if (this.cdw > 0) {
            if (com.baidu.adp.lib.util.k.af(this.aaX.getPageActivity()) >= 480) {
                this.ccG.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            aq.c(this.ccG, w.e.cp_cont_i, 1);
            this.ccG.setText(String.format(this.aaX.getString(w.l.miss_sign_days), Integer.valueOf(this.cdw)));
        } else {
            this.ccG.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.c(this.ccG, w.e.common_color_10061, 1);
            if (this.cdv <= 0) {
                this.ccG.setText(this.aaX.getString(w.l.signed));
            } else {
                this.ccG.setText(String.format(this.aaX.getString(w.l.continuous_sign_days), Integer.valueOf(this.cdv)));
            }
        }
        this.ccF.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void abf() {
    }

    protected void abg() {
        a(this.bSZ.bgo());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaQ() {
        if (this.bSZ != null) {
            abg();
        }
        if (this.bSZ != null && this.bSZ.bgI() != null) {
            a(this.bSZ.bgI());
        }
        if (this.ccw != null) {
            this.ccw.setText(au.t(this.mMemberNum));
        }
        if (this.ccx != null) {
            this.ccx.setText(au.t(this.cdu));
        }
        if (this.bIG != null) {
            if (this.cdj != null && this.cdj.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.bIG.setText(String.valueOf(this.mForumName) + this.aaX.getString(w.l.forum));
            }
        }
        if (this.ccN != null && this.ccO != null) {
            if (this.bSZ != null && this.bSZ.bgu()) {
                if (com.baidu.tbadk.core.util.m.dm(this.bSZ.bgx()) == 1 && !com.baidu.tbadk.core.util.p.aeq) {
                    this.ccN.setVisibility(8);
                } else {
                    this.ccN.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bSZ.getGameName()) && !TextUtils.isEmpty(this.bSZ.getGameName().trim())) {
                        this.ccO.setText(UtilHelper.getFixedText(this.bSZ.getGameName(), 10));
                        String qk = com.baidu.tieba.tbadkCore.util.m.qk(this.bSZ.bgx());
                        if (!StringUtils.isNull(qk)) {
                            TiebaStatic.eventStat(this.aaX.getPageActivity(), "game_show", "show", 1, "dev_id", qk, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.ccO.setText(this.aaX.getResources().getString(w.l.frsgame_title));
                    }
                }
            } else {
                this.ccN.setVisibility(8);
            }
        }
        if (this.bSZ != null && this.bSZ.bgv() != null && this.bSZ.bgv().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> bgv = this.bSZ.bgv();
            aw(bgv);
            int size = bgv.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.ccX.setVisibility(0);
                this.ccX.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = bgv.get(i2);
                    if (gVar != null) {
                        String iL = iL(gVar.aBz());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(w.h.top_item_title)).setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(w.h.top_item_type)).setText(iL);
                        ak(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.cdL);
                        this.ccX.addView(viewGroup);
                        if (this.cdJ.add(gVar.bgi())) {
                            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bgi(), this.bOf.getForumId(), this.bOf.getForumName(), null);
                            a.cc("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.ccX.setVisibility(8);
            }
        } else {
            this.ccX.setVisibility(8);
        }
        if (this.bSZ != null && this.bSZ.ftU != null && this.bSZ.ftU.VJ.length() > 0) {
            this.ccY.setVisibility(0);
            this.ccY.removeAllViews();
            com.baidu.tbadk.core.data.w wVar = this.bSZ.ftU;
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.frs_header_gift_item, (ViewGroup) null);
            TextView textView = (TextView) viewGroup2.findViewById(w.h.top_item_title);
            TextView textView2 = (TextView) viewGroup2.findViewById(w.h.top_item_type);
            HeadImageView headImageView = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_1);
            HeadImageView headImageView2 = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_2);
            HeadImageView headImageView3 = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_3);
            headImageView.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bOf.getBaseContext(), 25.0f));
            headImageView2.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bOf.getBaseContext(), 25.0f));
            headImageView3.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bOf.getBaseContext(), 25.0f));
            ImageView imageView = (ImageView) viewGroup2.findViewById(w.h.item_rank_1);
            ImageView imageView2 = (ImageView) viewGroup2.findViewById(w.h.item_rank_2);
            ImageView imageView3 = (ImageView) viewGroup2.findViewById(w.h.item_rank_3);
            ArrayList<w.a> arrayList = wVar.users;
            if (arrayList.size() > 0) {
                headImageView.setVisibility(0);
                headImageView.c(arrayList.get(0).userPortrait, 10, false);
                imageView.setVisibility(0);
                if (arrayList.size() > 1) {
                    headImageView2.setVisibility(0);
                    headImageView2.c(arrayList.get(1).userPortrait, 10, false);
                    imageView2.setVisibility(0);
                    if (arrayList.size() > 2) {
                        headImageView3.setVisibility(0);
                        headImageView3.c(arrayList.get(2).userPortrait, 10, false);
                        imageView3.setVisibility(0);
                    } else {
                        headImageView3.setVisibility(8);
                        imageView3.setVisibility(8);
                    }
                } else {
                    headImageView2.setVisibility(8);
                    headImageView3.setVisibility(8);
                    imageView2.setVisibility(8);
                    imageView3.setVisibility(8);
                }
            } else {
                headImageView.setVisibility(8);
                headImageView2.setVisibility(8);
                headImageView3.setVisibility(8);
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
                imageView3.setVisibility(8);
            }
            textView.setText(wVar.VJ);
            textView2.setText(w.l.gift);
            ak(viewGroup2);
            viewGroup2.setTag(wVar);
            viewGroup2.setOnClickListener(this.cdM);
            this.ccY.addView(viewGroup2);
        } else {
            this.ccY.setVisibility(8);
        }
        if (this.bSZ != null) {
            this.cdl.a(this.bSZ.bgn(), this.bSZ.aJw());
        } else {
            this.cdl.a(null, null);
        }
        aaR();
        if (this.cdi != null && this.cdj != null && this.cdj.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.cdj.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.cdj.get(i4).pY());
                iconData.setIcon(this.cdj.get(i4).pX());
                this.cdt = this.cdj.get(i4).pZ();
                linkedList.add(iconData);
                i3 = i4 + 1;
            }
            this.cdi.setOnClickListener(this.amB);
            this.cdi.a(linkedList, 2, this.aaX.getResources().getDimensionPixelSize(w.f.ds40), this.aaX.getResources().getDimensionPixelSize(w.f.ds40), this.aaX.getResources().getDimensionPixelSize(w.f.ds14));
        }
        if (this.cdm != null && this.bSZ != null) {
            this.cdm.b(this.bSZ);
        }
        String icon = this.cdo.getIcon();
        String url = this.cdo.getUrl();
        if (this.cdo != null && this.cdn != null) {
            this.cdn.setIcon(icon);
            this.cdn.setUrl(url);
        }
        aaS();
        aaU();
        aaX();
    }

    protected void aaR() {
        this.cdh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cdh.c(this.mImageUrl, 15, false);
        if (this.cdh.getBdImage() == null || this.cdh.getBdImage().kR() == null) {
            Nw();
            return;
        }
        if (this.bbS == null) {
            this.bbS = new m(this);
        }
        this.cdh.postDelayed(this.bbS, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nw() {
        this.cdh.setEvent(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Nx() {
        if (this.bOf != null && this.bOf.getActivity() != null) {
            try {
                if (this.bbR == null) {
                    this.bbR = new BlurDrawable(this.bOf.getActivity());
                    if (this.cdh != null && this.cdh.getBdImage() != null && this.cdh.getBdImage().kR() != null && !this.cdh.getBdImage().kR().isRecycled()) {
                        this.bbR.init(12, 8, this.cdh.getBdImage().kR());
                    }
                }
                if (this.bbR != null && this.bbR.getBlurredBitmap() == null && this.bbR.drawBlur()) {
                    this.aVp.setBackgroundDrawable(new BitmapDrawable(this.bbR.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String iL(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(w.l.frs_forum_member_icon_text);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaS() {
        ViewGroup aeA;
        View aeB;
        View findViewById;
        this.bRi.er(false);
        if (this.ccN.getVisibility() == 0) {
            View findViewById2 = this.ccN.findViewById(w.h.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.ccN.getVisibility() == 8 && this.ccX.getVisibility() == 0) {
            if (this.ccX.getChildCount() > 0 && (findViewById = ((ViewGroup) this.ccX.getChildAt(0)).findViewById(w.h.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.ccX.getVisibility() == 8 && (aeA = this.cdl.aeA()) != null && aeA.getVisibility() == 0 && (aeB = this.cdl.aeB()) != null) {
            aeB.setVisibility(8);
        } else {
            this.bRi.er(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cdK);
            if (this.cdb == null) {
                this.cdb = new PopupWindow(this.aaX.getPageActivity());
                this.cdb.setContentView(this.cdc);
                this.cdb.setBackgroundDrawable(new BitmapDrawable());
                this.cdb.setOutsideTouchable(true);
                this.cdb.setFocusable(true);
                this.cdb.setWidth(this.aaX.getResources().getDimensionPixelSize(w.f.ds228));
                this.cdb.setHeight(this.aaX.getResources().getDimensionPixelSize(w.f.ds100));
                this.cdd = (TextView) this.cdc.findViewById(w.h.cur_experience);
                this.cde = (TextView) this.cdc.findViewById(w.h.levelup_experience);
                a(this.cdd, this.cde);
            }
            if (this.cdb.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.cdb, this.aaX.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cdd, this.cde);
            if (iArr[1] - this.cdb.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.cdb, this.aaX.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.cdb, this.aXl, 0, iArr[0], iArr[1] - this.cdb.getHeight());
            this.cdb.update();
            this.mHandler.postDelayed(this.cdK, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aaX.getContext()).inflate(w.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(w.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(w.h.speed_tip);
            aq.c((TextView) inflate.findViewById(w.h.experience_txt), w.e.cp_cont_b, 1);
            aq.c(textView, w.e.cp_cont_b, 1);
            aq.c(textView2, w.e.cp_cont_b, 1);
            aq.c(textView3, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaX.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cdr) && !TextUtils.isEmpty(this.cdr.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cdr);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ca(w.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aaX);
            aVar.tQ();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(w.l.cancel, new o(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(w.l.open_now, new p(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void abh() {
        View contentView;
        if (this.cdg == null) {
            this.cdg = new PopupWindow(this.aaX.getPageActivity());
            contentView = LayoutInflater.from(this.aaX.getContext()).inflate(w.j.speed_tip, (ViewGroup) null);
            this.cdg.setContentView(contentView);
            contentView.setOnClickListener(new q(this));
            this.cdg.setWidth(this.aaX.getResources().getDimensionPixelSize(w.f.ds300));
            this.cdg.setHeight(this.aaX.getResources().getDimensionPixelSize(w.f.ds88));
            this.cdg.setBackgroundDrawable(new BitmapDrawable());
            this.cdg.setOutsideTouchable(true);
            this.cdg.setTouchInterceptor(new r(this));
        } else {
            contentView = this.cdg.getContentView();
        }
        this.aaX.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cdf.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.cdg, this.aXl, 0, (iArr[0] - (this.cdg.getWidth() / 2)) + (this.cdf.getWidth() / 2), iArr[1] + this.cdf.getWidth());
        this.cdg.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.cdD = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(w.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cdD) {
                this.ccI.setText(w.l.level_up);
                if (f >= 1.0f) {
                    i = this.bfk;
                } else {
                    i = this.bfk + 1;
                }
                com.baidu.tieba.tbadkCore.n Zr = this.bOf.Zr();
                if (Zr != null && Zr.aJw() != null) {
                    Zr.aJw().setUser_level(i);
                }
                aq.c(this.ccJ, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.ccI.setText(this.cdp);
                aq.c(this.ccJ, BitmapHelper.getSmallGradeResourceIdNew(this.bfk));
            }
            this.ccK.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, hY(this.bfk)));
            if (this.cdD) {
                if (f >= 1.0f) {
                    a(this.aaX.getOrignalPage(), this.ccK, this.cdE, f);
                } else {
                    b(this.aaX.getOrignalPage(), this.ccK, this.cdE, f);
                }
            } else {
                a(this.aaX.getOrignalPage(), this.ccK, this.cdE, f);
            }
            this.cdE = f;
        }
    }

    private int[] hY(int i) {
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

    @Override // com.baidu.tieba.frs.view.c
    protected void abi() {
        this.cdk.c(this.ccy, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void abj() {
        if (this.mMemberType != 0) {
            aq.c(this.cdf, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.cdf, w.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bRt);
        if (this.bbR != null) {
            this.bbR.onDestroy();
        }
        if (this.cdh != null) {
            this.cdh.removeCallbacks(this.bbS);
        }
    }
}
