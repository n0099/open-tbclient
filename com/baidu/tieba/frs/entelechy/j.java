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
    protected RelativeLayout aVr;
    private BlurDrawable bcO;
    protected Runnable bcQ;
    protected String mImageUrl;
    private CustomMessageListener bTK = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bTJ = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aVr = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bQw = frsActivity;
        this.aaY = frsActivity.getPageContext();
        this.ceK = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds20);
        this.ceL = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds72);
        this.ceM = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aXo = abQ();
        this.aVr = (RelativeLayout) this.aXo.findViewById(w.h.container);
        this.aVr.setPadding(0, com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds150), 0, 0);
        this.cfE = (ForumMemberIconView) this.aXo.findViewById(w.h.forum_member_icon_layout);
        this.cfE.setVisibility(8);
        this.cft = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(w.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aXo.setVisibility(8);
        }
        this.cfh = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(w.j.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.g(this.aaY.getPageActivity(), w.f.ds220), 0, 0);
        this.cfh.setLayoutParams(layoutParams);
        this.cfg = (CoverFlowView) this.aXo.findViewById(w.h.nomal_frs_coverflowview);
        this.cfj = (ForumHeadSdkView) this.aXo.findViewById(w.h.frs_head_sdk);
        afx();
        this.ceY = (RelativeLayout) this.aXo.findViewById(w.h.btn_love_content);
        this.cfw = (ImageView) this.aXo.findViewById(w.h.speed_icon);
        this.ceZ = (TextView) this.aXo.findViewById(w.h.level_name);
        this.cfa = (ImageView) this.aXo.findViewById(w.h.level);
        this.cfb = (ImageView) this.aXo.findViewById(w.h.love_level_top);
        this.ceP = (FrameLayout) this.aXo.findViewById(w.h.love);
        this.ceQ = (Button) this.aXo.findViewById(w.h.btn_love);
        this.ceQ.setContentDescription(frsActivity.getResources().getString(w.l.attention));
        this.ceR = (TextView) this.aXo.findViewById(w.h.tv_love);
        this.ceS = (FrameLayout) this.aXo.findViewById(w.h.sign);
        this.ceT = (Button) this.aXo.findViewById(w.h.btn_sign);
        this.ceU = (TextView) this.aXo.findViewById(w.h.tv_sign);
        this.ceU.setContentDescription(frsActivity.getResources().getString(w.l.sign));
        this.ceV = (ProgressBar) this.aXo.findViewById(w.h.sign_progress);
        this.ceW = (FrameLayout) this.aXo.findViewById(w.h.sign_done);
        this.ceX = (TextView) this.aXo.findViewById(w.h.sign_done_text);
        this.ceN = (TextView) this.aXo.findViewById(w.h.member_num_text);
        this.ceO = (TextView) this.aXo.findViewById(w.h.post_num_text);
        this.bKX = (TextView) this.aXo.findViewById(w.h.title_text);
        this.cfy = (BarImageView) this.aXo.findViewById(w.h.frs_image);
        this.cfy.setContentDescription(frsActivity.getResources().getString(w.l.bar_header));
        this.cfy.setGifIconSupport(false);
        this.cfy.setDrawerType(0);
        this.cfz = (UserIconBox) this.aXo.findViewById(w.h.frs_badge_box);
        this.cfc = LayoutInflater.from(this.bQw.getPageContext().getPageActivity()).inflate(w.j.frs_header_extra_entelechy, (ViewGroup) null);
        this.cfd = this.cfc.findViewById(w.h.extra_mask_view);
        aq.k(this.cfd, w.e.black_alpha0);
        abU();
        this.cfe = (ViewGroup) this.cfc.findViewById(w.h.frs_header_games);
        this.cff = (TextView) this.cfc.findViewById(w.h.top_item_title);
        this.cfo = (LinearLayout) this.cfc.findViewById(w.h.frs_header_enter_root);
        this.cfp = (LinearLayout) this.cfc.findViewById(w.h.frs_present_root);
        this.cfC = new com.baidu.tieba.frs.view.p(this.aaY, this.cfc);
        this.cfB = new com.baidu.tieba.frs.f.b(this.aaY);
        this.cfk = (ViewGroup) this.cfc.findViewById(w.h.frs_headline);
        this.cfl = (TextView) this.cfk.findViewById(w.h.headline_title);
        this.cfm = (TextView) this.cfk.findViewById(w.h.headline_text);
        this.cfn = (TbImageView) this.cfk.findViewById(w.h.headline_image);
        this.cfk.setVisibility(8);
        acb();
        MessageManager.getInstance().registerListener(this.bTK);
    }

    private void acb() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), cc.class);
        if (runTask != null && runTask.getData() != null) {
            this.cfD = (cc) runTask.getData();
            this.cfD.a(this.aaY, this.aXo, 1, false);
            this.cfD.hide();
        }
    }

    private void acc() {
        com.baidu.tbadk.core.data.m bhQ = this.bVq.bhQ();
        if (bhQ != null && this.bVq.aKx() != null) {
            String id = this.bVq.aKx().getId();
            String name = this.bVq.aKx().getName();
            if (this.cga.add(bhQ.qb())) {
                a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bhQ.qb(), id, name, null);
                a.cb("obj_url", bhQ.getUrl());
                a.save();
            }
            this.cfk.setVisibility(0);
            this.cfl.setText(bhQ.getText());
            this.cfm.setText(bhQ.getTitle());
            this.cfn.c(bhQ.qa(), 10, false);
            this.cfk.setOnClickListener(new l(this, bhQ, id, name));
        }
    }

    protected View abQ() {
        return LayoutInflater.from(this.bQw.getPageContext().getPageActivity()).inflate(w.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.cfy.setOnClickListener(onClickListener);
        this.bKX.setOnClickListener(onClickListener);
        this.ceQ.setOnClickListener(onClickListener);
        this.ceT.setOnClickListener(onClickListener);
        this.ceW.setOnClickListener(onClickListener);
        this.ceY.setOnClickListener(onClickListener);
        if (this.cfe != null) {
            this.cfe.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aaY.getLayoutMode().aj(i == 1);
        this.aaY.getLayoutMode().t(this.aXo);
        this.aaY.getLayoutMode().t(this.cft);
        this.aaY.getLayoutMode().t(this.cfc);
        if (this.cfT) {
            iR(1);
        } else {
            iR(0);
        }
        if (this.cfg != null) {
            this.cfg.onChangeSkinType();
        }
        if (this.cfj != null) {
            this.cfj.d(this.aaY, i);
        }
        this.cfy.invalidate();
        aq.c(this.cfa, BitmapHelper.getSmallGradeResourceIdNew(this.bgX));
        if (this.bcO != null && this.bcO.getBlurredBitmap() != null && !this.bcO.getBlurredBitmap().isRecycled()) {
            this.aVr.setBackgroundDrawable(new BitmapDrawable(this.bcO.getBlurredBitmap()));
        } else {
            aq.k(this.aVr, w.e.cp_bg_line_d);
        }
        acd();
        if (this.cfe != null) {
            aq.j(this.cfe, w.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aq.c(this.cfw, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.cfw, w.g.icon_sml_speed_gray);
        }
        if (this.cfC != null) {
            this.cfC.changeSkinType(i);
        }
        if (this.cfD != null) {
            this.cfD.changeSkinType(i);
        }
        if (this.cfz != null) {
            this.cfz.m12do(i);
        }
        if (this.cfE != null) {
            this.cfE.d(this.aaY, i);
        }
        Iterator<TbImageView> it = this.bTJ.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        abW();
        aq.j(this.cfk, w.g.home_thread_card_item_bg);
        if (this.bTC != null) {
            com.baidu.tbadk.m.a.a(this.bQw.getPageContext(), this.bTC);
        }
    }

    protected void acd() {
        this.ceR.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.ceU.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.cfL = forumData.getPost_num();
            this.cfH = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.cfG = forumData.getLevelName();
            this.bgX = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.cfM = forumData.getSignData().count_sign_num;
                this.cfN = forumData.getSignData().miss_sign_num;
            }
            this.cfO = forumData.getCurScore();
            this.cdP = forumData.getLevelupScore();
            this.cfA = forumData.getBadgeData();
            this.cfq = forumData.getTopCode();
            this.cfr = forumData.getNewsInfo();
            this.cfI = forumData.getAccelerateContent();
            this.cfF = forumData.getMemberShowIconData();
            this.bVq = nVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aXo.setVisibility(8);
            } else {
                this.aXo.setVisibility(0);
            }
            this.cfJ = new bi();
            ace();
            abR();
            acc();
        }
    }

    protected void ace() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.cfJ.sy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void acf() {
        if (this.cfN > 0) {
            if (com.baidu.adp.lib.util.k.af(this.aaY.getPageActivity()) >= 480) {
                this.ceX.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            aq.c(this.ceX, w.e.cp_cont_i, 1);
            this.ceX.setText(String.format(this.aaY.getString(w.l.miss_sign_days), Integer.valueOf(this.cfN)));
        } else {
            this.ceX.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.c(this.ceX, w.e.common_color_10061, 1);
            if (this.cfM <= 0) {
                this.ceX.setText(this.aaY.getString(w.l.signed));
            } else {
                this.ceX.setText(String.format(this.aaY.getString(w.l.continuous_sign_days), Integer.valueOf(this.cfM)));
            }
        }
        this.ceW.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void acg() {
    }

    protected void ach() {
        a(this.bVq.bhq());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abR() {
        if (this.bVq != null) {
            ach();
        }
        if (this.bVq != null && this.bVq.bhK() != null) {
            a(this.bVq.bhK());
        }
        if (this.ceN != null) {
            this.ceN.setText(au.t(this.mMemberNum));
        }
        if (this.ceO != null) {
            this.ceO.setText(au.t(this.cfL));
        }
        if (this.bKX != null) {
            if (this.cfA != null && this.cfA.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.bKX.setText(String.valueOf(this.mForumName) + this.aaY.getString(w.l.forum));
            }
        }
        if (this.cfe != null && this.cff != null) {
            if (this.bVq != null && this.bVq.bhw()) {
                if (com.baidu.tbadk.core.util.m.dm(this.bVq.bhz()) == 1 && !com.baidu.tbadk.core.util.p.aer) {
                    this.cfe.setVisibility(8);
                } else {
                    this.cfe.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bVq.getGameName()) && !TextUtils.isEmpty(this.bVq.getGameName().trim())) {
                        this.cff.setText(UtilHelper.getFixedText(this.bVq.getGameName(), 10));
                        String ql = com.baidu.tieba.tbadkCore.util.m.ql(this.bVq.bhz());
                        if (!StringUtils.isNull(ql)) {
                            TiebaStatic.eventStat(this.aaY.getPageActivity(), "game_show", "show", 1, "dev_id", ql, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cff.setText(this.aaY.getResources().getString(w.l.frsgame_title));
                    }
                }
            } else {
                this.cfe.setVisibility(8);
            }
        }
        if (this.bVq != null && this.bVq.bhx() != null && this.bVq.bhx().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> bhx = this.bVq.bhx();
            ax(bhx);
            int size = bhx.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.cfo.setVisibility(0);
                this.cfo.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = bhx.get(i2);
                    if (gVar != null) {
                        String iM = iM(gVar.aCA());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(w.h.top_item_title)).setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(w.h.top_item_type)).setText(iM);
                        ak(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.cgc);
                        this.cfo.addView(viewGroup);
                        if (this.cga.add(gVar.bhk())) {
                            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bhk(), this.bQw.getForumId(), this.bQw.getForumName(), null);
                            a.cb("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.cfo.setVisibility(8);
            }
        } else {
            this.cfo.setVisibility(8);
        }
        if (this.bVq != null && this.bVq.fwl != null && this.bVq.fwl.VL.length() > 0) {
            this.cfp.setVisibility(0);
            this.cfp.removeAllViews();
            com.baidu.tbadk.core.data.w wVar = this.bVq.fwl;
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.frs_header_gift_item, (ViewGroup) null);
            TextView textView = (TextView) viewGroup2.findViewById(w.h.top_item_title);
            TextView textView2 = (TextView) viewGroup2.findViewById(w.h.top_item_type);
            HeadImageView headImageView = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_1);
            HeadImageView headImageView2 = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_2);
            HeadImageView headImageView3 = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_3);
            headImageView.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bQw.getBaseContext(), 25.0f));
            headImageView2.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bQw.getBaseContext(), 25.0f));
            headImageView3.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bQw.getBaseContext(), 25.0f));
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
            textView.setText(wVar.VL);
            textView2.setText(w.l.gift);
            ak(viewGroup2);
            viewGroup2.setTag(wVar);
            viewGroup2.setOnClickListener(this.cgd);
            this.cfp.addView(viewGroup2);
        } else {
            this.cfp.setVisibility(8);
        }
        if (this.bVq != null) {
            this.cfC.a(this.bVq.bhp(), this.bVq.aKx());
        } else {
            this.cfC.a(null, null);
        }
        abS();
        if (this.cfz != null && this.cfA != null && this.cfA.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.cfA.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.cfA.get(i4).pY());
                iconData.setIcon(this.cfA.get(i4).pX());
                this.cfK = this.cfA.get(i4).pZ();
                linkedList.add(iconData);
                i3 = i4 + 1;
            }
            this.cfz.setOnClickListener(this.amB);
            this.cfz.a(linkedList, 2, this.aaY.getResources().getDimensionPixelSize(w.f.ds40), this.aaY.getResources().getDimensionPixelSize(w.f.ds40), this.aaY.getResources().getDimensionPixelSize(w.f.ds14));
        }
        if (this.cfD != null && this.bVq != null) {
            this.cfD.b(this.bVq);
        }
        String icon = this.cfF.getIcon();
        String url = this.cfF.getUrl();
        if (this.cfF != null && this.cfE != null) {
            this.cfE.setIcon(icon);
            this.cfE.setUrl(url);
        }
        abT();
        abV();
        abY();
    }

    protected void abS() {
        this.cfy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cfy.c(this.mImageUrl, 15, false);
        if (this.cfy.getBdImage() == null || this.cfy.getBdImage().kS() == null) {
            NE();
            return;
        }
        if (this.bcQ == null) {
            this.bcQ = new m(this);
        }
        this.cfy.postDelayed(this.bcQ, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NE() {
        this.cfy.setEvent(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void NF() {
        if (this.bQw != null && this.bQw.getActivity() != null) {
            try {
                if (this.bcO == null) {
                    this.bcO = new BlurDrawable(this.bQw.getActivity());
                    if (this.cfy != null && this.cfy.getBdImage() != null && this.cfy.getBdImage().kS() != null && !this.cfy.getBdImage().kS().isRecycled()) {
                        this.bcO.init(12, 8, this.cfy.getBdImage().kS());
                    }
                }
                if (this.bcO != null && this.bcO.getBlurredBitmap() == null && this.bcO.drawBlur()) {
                    this.aVr.setBackgroundDrawable(new BitmapDrawable(this.bcO.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String iM(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(w.l.frs_forum_member_icon_text);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abT() {
        ViewGroup afB;
        View afC;
        View findViewById;
        this.bTz.eB(false);
        if (this.cfe.getVisibility() == 0) {
            View findViewById2 = this.cfe.findViewById(w.h.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.cfe.getVisibility() == 8 && this.cfo.getVisibility() == 0) {
            if (this.cfo.getChildCount() > 0 && (findViewById = ((ViewGroup) this.cfo.getChildAt(0)).findViewById(w.h.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.cfo.getVisibility() == 8 && (afB = this.cfC.afB()) != null && afB.getVisibility() == 0 && (afC = this.cfC.afC()) != null) {
            afC.setVisibility(8);
        } else {
            this.bTz.eB(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cgb);
            if (this.cfs == null) {
                this.cfs = new PopupWindow(this.aaY.getPageActivity());
                this.cfs.setContentView(this.cft);
                this.cfs.setBackgroundDrawable(new BitmapDrawable());
                this.cfs.setOutsideTouchable(true);
                this.cfs.setFocusable(true);
                this.cfs.setWidth(this.aaY.getResources().getDimensionPixelSize(w.f.ds228));
                this.cfs.setHeight(this.aaY.getResources().getDimensionPixelSize(w.f.ds100));
                this.cfu = (TextView) this.cft.findViewById(w.h.cur_experience);
                this.cfv = (TextView) this.cft.findViewById(w.h.levelup_experience);
                a(this.cfu, this.cfv);
            }
            if (this.cfs.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.cfs, this.aaY.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.cfu, this.cfv);
            if (iArr[1] - this.cfs.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.cfs, this.aaY.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.cfs, this.aXo, 0, iArr[0], iArr[1] - this.cfs.getHeight());
            this.cfs.update();
            this.mHandler.postDelayed(this.cgb, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aaY.getContext()).inflate(w.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(w.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(w.h.speed_tip);
            aq.c((TextView) inflate.findViewById(w.h.experience_txt), w.e.cp_cont_b, 1);
            aq.c(textView, w.e.cp_cont_b, 1);
            aq.c(textView2, w.e.cp_cont_b, 1);
            aq.c(textView3, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaY.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.cfI) && !TextUtils.isEmpty(this.cfI.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.cfI);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ca(w.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aaY);
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
    public void aci() {
        View contentView;
        if (this.cfx == null) {
            this.cfx = new PopupWindow(this.aaY.getPageActivity());
            contentView = LayoutInflater.from(this.aaY.getContext()).inflate(w.j.speed_tip, (ViewGroup) null);
            this.cfx.setContentView(contentView);
            contentView.setOnClickListener(new q(this));
            this.cfx.setWidth(this.aaY.getResources().getDimensionPixelSize(w.f.ds300));
            this.cfx.setHeight(this.aaY.getResources().getDimensionPixelSize(w.f.ds88));
            this.cfx.setBackgroundDrawable(new BitmapDrawable());
            this.cfx.setOutsideTouchable(true);
            this.cfx.setTouchInterceptor(new r(this));
        } else {
            contentView = this.cfx.getContentView();
        }
        this.aaY.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.cfw.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.cfx, this.aXo, 0, (iArr[0] - (this.cfx.getWidth() / 2)) + (this.cfw.getWidth() / 2), iArr[1] + this.cfw.getWidth());
        this.cfx.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.cfU = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(w.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cfU) {
                this.ceZ.setText(w.l.level_up);
                if (f >= 1.0f) {
                    i = this.bgX;
                } else {
                    i = this.bgX + 1;
                }
                com.baidu.tieba.tbadkCore.n aas = this.bQw.aas();
                if (aas != null && aas.aKx() != null) {
                    aas.aKx().setUser_level(i);
                }
                aq.c(this.cfa, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.ceZ.setText(this.cfG);
                aq.c(this.cfa, BitmapHelper.getSmallGradeResourceIdNew(this.bgX));
            }
            this.cfb.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ie(this.bgX)));
            if (this.cfU) {
                if (f >= 1.0f) {
                    a(this.aaY.getOrignalPage(), this.cfb, this.cfV, f);
                } else {
                    b(this.aaY.getOrignalPage(), this.cfb, this.cfV, f);
                }
            } else {
                a(this.aaY.getOrignalPage(), this.cfb, this.cfV, f);
            }
            this.cfV = f;
        }
    }

    private int[] ie(int i) {
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
    protected void acj() {
        this.cfB.c(this.ceP, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void ack() {
        if (this.mMemberType != 0) {
            aq.c(this.cfw, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.cfw, w.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bTK);
        if (this.bcO != null) {
            this.bcO.onDestroy();
        }
        if (this.cfy != null) {
            this.cfy.removeCallbacks(this.bcQ);
        }
    }
}
