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
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
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
    protected RelativeLayout aVc;
    private BlurDrawable bbY;
    protected Runnable bbZ;
    protected String mImageUrl;
    private CustomMessageListener bRE = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bRD = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aVc = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bOq = frsActivity;
        this.aaI = frsActivity.getPageContext();
        this.cdS = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds20);
        this.cdT = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds72);
        this.cdU = com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.aWX = aar();
        this.aVc = (RelativeLayout) this.aWX.findViewById(w.h.container);
        this.aVc.setPadding(0, com.baidu.adp.lib.util.k.g(frsActivity.getPageContext().getPageActivity(), w.f.ds150), 0, 0);
        this.ceN = (ForumMemberIconView) this.aWX.findViewById(w.h.forum_member_icon_layout);
        this.ceN.setVisibility(8);
        this.ceC = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(w.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.aWX.setVisibility(8);
        }
        this.cep = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(w.j.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.g(this.aaI.getPageActivity(), w.f.ds220), 0, 0);
        this.cep.setLayoutParams(layoutParams);
        this.ceo = (CoverFlowView) this.aWX.findViewById(w.h.nomal_frs_coverflowview);
        this.cer = (ForumHeadSdkView) this.aWX.findViewById(w.h.frs_head_sdk);
        if (this.aWX.findViewById(w.h.frs_head_video_list) != null) {
            this.bYo = (ForumHeadVideoView) this.aWX.findViewById(w.h.frs_head_video_list);
        }
        aeC();
        this.ceg = (RelativeLayout) this.aWX.findViewById(w.h.btn_love_content);
        this.ceF = (ImageView) this.aWX.findViewById(w.h.speed_icon);
        this.ceh = (TextView) this.aWX.findViewById(w.h.level_name);
        this.cei = (ImageView) this.aWX.findViewById(w.h.level);
        this.cej = (ImageView) this.aWX.findViewById(w.h.love_level_top);
        this.cdX = (FrameLayout) this.aWX.findViewById(w.h.love);
        this.cdY = (Button) this.aWX.findViewById(w.h.btn_love);
        this.cdY.setContentDescription(frsActivity.getResources().getString(w.l.attention));
        this.cdZ = (TextView) this.aWX.findViewById(w.h.tv_love);
        this.cea = (FrameLayout) this.aWX.findViewById(w.h.sign);
        this.ceb = (Button) this.aWX.findViewById(w.h.btn_sign);
        this.cec = (TextView) this.aWX.findViewById(w.h.tv_sign);
        this.cec.setContentDescription(frsActivity.getResources().getString(w.l.sign));
        this.ced = (ProgressBar) this.aWX.findViewById(w.h.sign_progress);
        this.cee = (FrameLayout) this.aWX.findViewById(w.h.sign_done);
        this.cef = (TextView) this.aWX.findViewById(w.h.sign_done_text);
        this.cdV = (TextView) this.aWX.findViewById(w.h.member_num_text);
        this.cdW = (TextView) this.aWX.findViewById(w.h.post_num_text);
        this.bIN = (TextView) this.aWX.findViewById(w.h.title_text);
        this.ceH = (BarImageView) this.aWX.findViewById(w.h.frs_image);
        this.ceH.setContentDescription(frsActivity.getResources().getString(w.l.bar_header));
        this.ceH.setGifIconSupport(false);
        this.ceH.setDrawerType(0);
        this.ceI = (UserIconBox) this.aWX.findViewById(w.h.frs_badge_box);
        this.cek = LayoutInflater.from(this.bOq.getPageContext().getPageActivity()).inflate(w.j.frs_header_extra_entelechy, (ViewGroup) null);
        this.cel = this.cek.findViewById(w.h.extra_mask_view);
        aq.k(this.cel, w.e.black_alpha0);
        aav();
        this.cem = (ViewGroup) this.cek.findViewById(w.h.frs_header_games);
        this.cen = (TextView) this.cek.findViewById(w.h.top_item_title);
        this.cex = (LinearLayout) this.cek.findViewById(w.h.frs_header_enter_root);
        this.cey = (LinearLayout) this.cek.findViewById(w.h.frs_present_root);
        this.ceL = new com.baidu.tieba.frs.view.p(this.aaI, this.cek);
        this.ceK = new com.baidu.tieba.frs.utils.b(this.aaI);
        this.ces = (ViewGroup) this.cek.findViewById(w.h.frs_headline);
        this.cet = (TextView) this.ces.findViewById(w.h.headline_title);
        this.ceu = (TextView) this.ces.findViewById(w.h.headline_text);
        this.cev = (TbImageView) this.ces.findViewById(w.h.headline_image);
        this.ces.setVisibility(8);
        aaC();
        MessageManager.getInstance().registerListener(this.bRE);
    }

    private void aaC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ca.class);
        if (runTask != null && runTask.getData() != null) {
            this.ceM = (ca) runTask.getData();
            this.ceM.a(this.aaI, this.aWX, 1, false);
            this.ceM.hide();
        }
    }

    private void aaD() {
        com.baidu.tbadk.core.data.m bgb = this.bTl.bgb();
        if (bgb != null && this.bTl.aJp() != null) {
            String id = this.bTl.aJp().getId();
            String name = this.bTl.aJp().getName();
            if (this.cfj.add(bgb.pD())) {
                a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bgb.pD(), id, name, null);
                a.cb("obj_url", bgb.getUrl());
                a.save();
            }
            this.ces.setVisibility(0);
            this.cet.setText(bgb.getText());
            this.ceu.setText(bgb.getTitle());
            this.cev.c(bgb.pC(), 10, false);
            this.ces.setOnClickListener(new l(this, bgb, id, name));
        }
    }

    protected View aar() {
        return LayoutInflater.from(this.bOq.getPageContext().getPageActivity()).inflate(w.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.ceH.setOnClickListener(onClickListener);
        this.bIN.setOnClickListener(onClickListener);
        this.cdY.setOnClickListener(onClickListener);
        this.ceb.setOnClickListener(onClickListener);
        this.cee.setOnClickListener(onClickListener);
        this.ceg.setOnClickListener(onClickListener);
        if (this.cem != null) {
            this.cem.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.b.e.eT().ab("frs_to_bar_detail") == 0) {
            this.aWX.setOnClickListener(new m(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.aaI.getLayoutMode().ah(i == 1);
        this.aaI.getLayoutMode().t(this.aWX);
        this.aaI.getLayoutMode().t(this.ceC);
        this.aaI.getLayoutMode().t(this.cek);
        if (this.cfc) {
            iK(1);
        } else {
            iK(0);
        }
        if (this.ceo != null) {
            this.ceo.tD();
        }
        if (this.cer != null) {
            this.cer.d(this.aaI, i);
        }
        this.ceH.invalidate();
        aq.c(this.cei, BitmapHelper.getSmallGradeResourceIdNew(this.bfq));
        if (this.bbY != null && this.bbY.getBlurredBitmap() != null && !this.bbY.getBlurredBitmap().isRecycled()) {
            this.aVc.setBackgroundDrawable(new BitmapDrawable(this.bbY.getBlurredBitmap()));
        } else {
            aq.k(this.aVc, w.e.cp_bg_line_d);
        }
        aaE();
        if (this.cem != null) {
            aq.j(this.cem, w.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            aq.c(this.ceF, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.ceF, w.g.icon_sml_speed_gray);
        }
        if (this.ceL != null) {
            this.ceL.changeSkinType(i);
        }
        if (this.ceM != null) {
            this.ceM.changeSkinType(i);
        }
        if (this.ceI != null) {
            this.ceI.dl(i);
        }
        if (this.ceN != null) {
            this.ceN.d(this.aaI, i);
        }
        Iterator<TbImageView> it = this.bRD.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aax();
        if (this.bYo != null) {
            this.bYo.onChangeSkinType(this.aaI, i);
        }
        aq.j(this.ces, w.g.home_thread_card_item_bg);
        if (this.bRw != null) {
            com.baidu.tbadk.i.a.a(this.bOq.getPageContext(), this.bRw);
        }
    }

    protected void aaE() {
        this.cdZ.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.cec.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ceU = forumData.getPost_num();
            this.ceQ = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.ceP = forumData.getLevelName();
            this.bfq = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ceV = forumData.getSignData().count_sign_num;
                this.ceW = forumData.getSignData().miss_sign_num;
            }
            this.ceX = forumData.getCurScore();
            this.ccX = forumData.getLevelupScore();
            this.ceJ = forumData.getBadgeData();
            this.cez = forumData.getTopCode();
            this.ceA = forumData.getNewsInfo();
            this.ceR = forumData.getAccelerateContent();
            this.ceO = forumData.getMemberShowIconData();
            this.bTl = nVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.aWX.setVisibility(8);
            } else {
                this.aWX.setVisibility(0);
            }
            this.ceS = new bj();
            aaF();
            aas();
            aaD();
        }
    }

    protected void aaF() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.ceS.sa().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void aaG() {
        if (this.ceW > 0) {
            if (com.baidu.adp.lib.util.k.ag(this.aaI.getPageActivity()) >= 480) {
                this.cef.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            aq.c(this.cef, w.e.cp_cont_i, 1);
            this.cef.setText(String.format(this.aaI.getString(w.l.miss_sign_days), Integer.valueOf(this.ceW)));
        } else {
            this.cef.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            aq.c(this.cef, w.e.common_color_10061, 1);
            if (this.ceV <= 0) {
                this.cef.setText(this.aaI.getString(w.l.signed));
            } else {
                this.cef.setText(String.format(this.aaI.getString(w.l.continuous_sign_days), Integer.valueOf(this.ceV)));
            }
        }
        this.cee.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void aaH() {
    }

    protected void aaI() {
        a(this.bTl.bfA());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aas() {
        if (this.bTl != null) {
            aaI();
        }
        if (this.bTl != null && this.bTl.bfV() != null) {
            a(this.bTl.bfV());
        }
        if (this.cdV != null) {
            this.cdV.setText(au.t(this.mMemberNum));
        }
        if (this.cdW != null) {
            this.cdW.setText(au.t(this.ceU));
        }
        if (this.bIN != null) {
            if (this.ceJ != null && this.ceJ.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.bIN.setText(String.valueOf(this.mForumName) + this.aaI.getString(w.l.forum));
            }
        }
        if (this.cem != null && this.cen != null) {
            if (this.bTl != null && this.bTl.bfG()) {
                if (com.baidu.tbadk.core.util.m.df(this.bTl.bfJ()) == 1 && !com.baidu.tbadk.core.util.p.aec) {
                    this.cem.setVisibility(8);
                } else {
                    this.cem.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bTl.getGameName()) && !TextUtils.isEmpty(this.bTl.getGameName().trim())) {
                        this.cen.setText(UtilHelper.getFixedText(this.bTl.getGameName(), 10));
                        String pT = com.baidu.tieba.tbadkCore.util.m.pT(this.bTl.bfJ());
                        if (!StringUtils.isNull(pT)) {
                            TiebaStatic.eventStat(this.aaI.getPageActivity(), "game_show", "show", 1, "dev_id", pT, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cen.setText(this.aaI.getResources().getString(w.l.frsgame_title));
                    }
                }
            } else {
                this.cem.setVisibility(8);
            }
        }
        if (this.bTl != null && this.bTl.bfH() != null && this.bTl.bfH().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> bfH = this.bTl.bfH();
            ax(bfH);
            int size = bfH.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.cex.setVisibility(0);
                this.cex.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = bfH.get(i2);
                    if (gVar != null) {
                        String iH = iH(gVar.aBV());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(w.h.top_item_title)).setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(w.h.top_item_type)).setText(iH);
                        am(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.cfl);
                        this.cex.addView(viewGroup);
                        if (this.cfj.add(gVar.bfu())) {
                            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bfu(), this.bOq.getForumId(), this.bOq.getForumName(), null);
                            a.cb("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.cex.setVisibility(8);
            }
        } else {
            this.cex.setVisibility(8);
        }
        if (this.bTl != null && this.bTl.fsk != null && this.bTl.fsk.Vr.length() > 0) {
            this.cey.setVisibility(0);
            this.cey.removeAllViews();
            com.baidu.tbadk.core.data.w wVar = this.bTl.fsk;
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.aaI.getPageActivity()).inflate(w.j.frs_header_gift_item, (ViewGroup) null);
            TextView textView = (TextView) viewGroup2.findViewById(w.h.top_item_title);
            TextView textView2 = (TextView) viewGroup2.findViewById(w.h.top_item_type);
            HeadImageView headImageView = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_1);
            HeadImageView headImageView2 = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_2);
            HeadImageView headImageView3 = (HeadImageView) viewGroup2.findViewById(w.h.item_portrait_3);
            headImageView.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bOq.getBaseContext(), 25.0f));
            headImageView2.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bOq.getBaseContext(), 25.0f));
            headImageView3.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bOq.getBaseContext(), 25.0f));
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
            textView.setText(wVar.Vr);
            textView2.setText(w.l.gift);
            am(viewGroup2);
            viewGroup2.setTag(wVar);
            viewGroup2.setOnClickListener(this.cfm);
            this.cey.addView(viewGroup2);
        } else {
            this.cey.setVisibility(8);
        }
        if (this.bTl != null) {
            this.ceL.a(this.bTl.bfz(), this.bTl.aJp());
        } else {
            this.ceL.a(null, null);
        }
        aat();
        if (this.ceI != null && this.ceJ != null && this.ceJ.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.ceJ.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.ceJ.get(i4).pA());
                iconData.setIcon(this.ceJ.get(i4).pz());
                this.ceT = this.ceJ.get(i4).pB();
                linkedList.add(iconData);
                i3 = i4 + 1;
            }
            this.ceI.setOnClickListener(this.amn);
            this.ceI.a(linkedList, 2, this.aaI.getResources().getDimensionPixelSize(w.f.ds40), this.aaI.getResources().getDimensionPixelSize(w.f.ds40), this.aaI.getResources().getDimensionPixelSize(w.f.ds14));
        }
        if (this.ceM != null && this.bTl != null) {
            this.ceM.b(this.bTl);
        }
        String icon = this.ceO.getIcon();
        String url = this.ceO.getUrl();
        if (this.ceO != null && this.ceN != null) {
            this.ceN.setIcon(icon);
            this.ceN.setUrl(url);
        }
        aau();
        aaw();
        aaz();
        if (this.bTl != null) {
            b(com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.bTl.bgc());
        }
    }

    protected void aat() {
        this.ceH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ceH.c(this.mImageUrl, 15, false);
        if (this.ceH.getBdImage() == null || this.ceH.getBdImage().kN() == null) {
            MY();
            return;
        }
        if (this.bbZ == null) {
            this.bbZ = new n(this);
        }
        this.ceH.postDelayed(this.bbZ, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MY() {
        this.ceH.setEvent(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MZ() {
        if (this.bOq != null && this.bOq.getActivity() != null) {
            try {
                if (this.bbY == null) {
                    this.bbY = new BlurDrawable(this.bOq.getActivity());
                    if (this.ceH != null && this.ceH.getBdImage() != null && this.ceH.getBdImage().kN() != null && !this.ceH.getBdImage().kN().isRecycled()) {
                        this.bbY.init(12, 8, this.ceH.getBdImage().kN());
                    }
                }
                if (this.bbY != null && this.bbY.getBlurredBitmap() == null && this.bbY.drawBlur()) {
                    this.aVc.setBackgroundDrawable(new BitmapDrawable(this.bbY.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String iH(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(w.l.frs_forum_member_icon_text);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aau() {
        ViewGroup aeG;
        View aeH;
        View findViewById;
        this.bRt.er(false);
        if (this.cem.getVisibility() == 0) {
            View findViewById2 = this.cem.findViewById(w.h.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.cem.getVisibility() == 8 && this.cex.getVisibility() == 0) {
            if (this.cex.getChildCount() > 0 && (findViewById = ((ViewGroup) this.cex.getChildAt(0)).findViewById(w.h.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.cex.getVisibility() == 8 && (aeG = this.ceL.aeG()) != null && aeG.getVisibility() == 0 && (aeH = this.ceL.aeH()) != null) {
            aeH.setVisibility(8);
        } else {
            this.bRt.er(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.cfk);
            if (this.ceB == null) {
                this.ceB = new PopupWindow(this.aaI.getPageActivity());
                this.ceB.setContentView(this.ceC);
                this.ceB.setBackgroundDrawable(new BitmapDrawable());
                this.ceB.setOutsideTouchable(true);
                this.ceB.setFocusable(true);
                this.ceB.setWidth(this.aaI.getResources().getDimensionPixelSize(w.f.ds228));
                this.ceB.setHeight(this.aaI.getResources().getDimensionPixelSize(w.f.ds100));
                this.ceD = (TextView) this.ceC.findViewById(w.h.cur_experience);
                this.ceE = (TextView) this.ceC.findViewById(w.h.levelup_experience);
                a(this.ceD, this.ceE);
            }
            if (this.ceB.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.ceB, this.aaI.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.ceD, this.ceE);
            if (iArr[1] - this.ceB.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.ceB, this.aaI.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.ceB, this.aWX, 0, iArr[0], iArr[1] - this.ceB.getHeight());
            this.ceB.update();
            this.mHandler.postDelayed(this.cfk, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.aaI.getContext()).inflate(w.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(w.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(w.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(w.h.speed_tip);
            aq.c((TextView) inflate.findViewById(w.h.experience_txt), w.e.cp_cont_b, 1);
            aq.c(textView, w.e.cp_cont_b, 1);
            aq.c(textView2, w.e.cp_cont_b, 1);
            aq.c(textView3, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aaI.getPageActivity());
            aVar.v(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.ceR) && !TextUtils.isEmpty(this.ceR.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ceR);
            } else {
                textView3.setVisibility(8);
            }
            aVar.bX(w.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.aaI);
            aVar.ts();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(w.l.cancel_text, new p(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(w.l.open_now, new q(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void aaJ() {
        View contentView;
        if (this.ceG == null) {
            this.ceG = new PopupWindow(this.aaI.getPageActivity());
            contentView = LayoutInflater.from(this.aaI.getContext()).inflate(w.j.speed_tip, (ViewGroup) null);
            this.ceG.setContentView(contentView);
            contentView.setOnClickListener(new r(this));
            this.ceG.setWidth(this.aaI.getResources().getDimensionPixelSize(w.f.ds300));
            this.ceG.setHeight(this.aaI.getResources().getDimensionPixelSize(w.f.ds88));
            this.ceG.setBackgroundDrawable(new BitmapDrawable());
            this.ceG.setOutsideTouchable(true);
            this.ceG.setTouchInterceptor(new s(this));
        } else {
            contentView = this.ceG.getContentView();
        }
        this.aaI.getLayoutMode().t(contentView);
        int[] iArr = new int[2];
        this.ceF.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.ceG, this.aWX, 0, (iArr[0] - (this.ceG.getWidth() / 2)) + (this.ceF.getWidth() / 2), iArr[1] + this.ceF.getWidth());
        this.ceG.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(boolean z, float f) {
        int i;
        this.cfd = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(w.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.cfd) {
                this.ceh.setText(w.l.level_up);
                if (f >= 1.0f) {
                    i = this.bfq;
                } else {
                    i = this.bfq + 1;
                }
                com.baidu.tieba.tbadkCore.n YV = this.bOq.YV();
                if (YV != null && YV.aJp() != null) {
                    YV.aJp().setUser_level(i);
                }
                aq.c(this.cei, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.ceh.setText(this.ceP);
                aq.c(this.cei, BitmapHelper.getSmallGradeResourceIdNew(this.bfq));
            }
            this.cej.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, hV(this.bfq)));
            if (this.cfd) {
                if (f >= 1.0f) {
                    a(this.aaI.getOrignalPage(), this.cej, this.cfe, f);
                } else {
                    b(this.aaI.getOrignalPage(), this.cej, this.cfe, f);
                }
            } else {
                a(this.aaI.getOrignalPage(), this.cej, this.cfe, f);
            }
            this.cfe = f;
        }
    }

    private int[] hV(int i) {
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
    protected void aaK() {
        this.ceK.c(this.cdX, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void aaL() {
        if (this.mMemberType != 0) {
            aq.c(this.ceF, w.g.icon_sml_speed_orange);
        } else {
            aq.c(this.ceF, w.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bRE);
        if (this.bbY != null) {
            this.bbY.onDestroy();
        }
        if (this.bYo != null) {
            this.bYo.onDestory();
        }
        if (this.ceH != null) {
            this.ceH.removeCallbacks(this.bbZ);
        }
    }
}
