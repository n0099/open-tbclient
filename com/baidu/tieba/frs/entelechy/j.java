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
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoView;
import com.baidu.tieba.frs.view.ForumHeadSdkView;
import com.baidu.tieba.frs.view.ForumMemberIconView;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends g {
    private static final String DEFAULT_BADGE_URL = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected RelativeLayout aUH;
    private BlurDrawable bYl;
    protected Runnable bYm;
    protected String mImageUrl;
    private CustomMessageListener bYn = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bYk = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aUH = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bTA = frsActivity;
        this.Gf = frsActivity.getPageContext();
        this.ckI = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds20);
        this.ckJ = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds72);
        this.ckK = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Ge = adX();
        this.aUH = (RelativeLayout) this.Ge.findViewById(r.g.container);
        this.aUH.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds150), 0, 0);
        this.clA = (ForumMemberIconView) this.Ge.findViewById(r.g.forum_member_icon_layout);
        this.clA.setVisibility(8);
        this.clp = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.Ge.setVisibility(8);
        }
        this.clc = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds220), 0, 0);
        this.clc.setLayoutParams(layoutParams);
        this.bCZ = (CoverFlowView) this.Ge.findViewById(r.g.nomal_frs_coverflowview);
        this.cle = (ForumHeadSdkView) this.Ge.findViewById(r.g.frs_head_sdk);
        if (this.Ge.findViewById(r.g.frs_head_video_list) != null) {
            this.cfe = (ForumHeadVideoView) this.Ge.findViewById(r.g.frs_head_video_list);
        }
        WG();
        this.ckT = (RelativeLayout) this.Ge.findViewById(r.g.btn_love_content);
        this.cls = (ImageView) this.Ge.findViewById(r.g.speed_icon);
        this.ckU = (TextView) this.Ge.findViewById(r.g.level_name);
        this.ckV = (ImageView) this.Ge.findViewById(r.g.level);
        this.ckW = (ImageView) this.Ge.findViewById(r.g.love_level_top);
        this.ckL = (FrameLayout) this.Ge.findViewById(r.g.love);
        this.ckM = (Button) this.Ge.findViewById(r.g.btn_love);
        this.ckM.setContentDescription(frsActivity.getResources().getString(r.j.attention));
        this.Ga = (TextView) this.Ge.findViewById(r.g.tv_love);
        this.ckN = (FrameLayout) this.Ge.findViewById(r.g.sign);
        this.ckO = (Button) this.Ge.findViewById(r.g.btn_sign);
        this.ckP = (TextView) this.Ge.findViewById(r.g.tv_sign);
        this.ckP.setContentDescription(frsActivity.getResources().getString(r.j.sign));
        this.ckQ = (ProgressBar) this.Ge.findViewById(r.g.sign_progress);
        this.ckR = (FrameLayout) this.Ge.findViewById(r.g.sign_done);
        this.ckS = (TextView) this.Ge.findViewById(r.g.sign_done_text);
        this.FX = (TextView) this.Ge.findViewById(r.g.member_num_text);
        this.FY = (TextView) this.Ge.findViewById(r.g.post_num_text);
        this.FZ = (TextView) this.Ge.findViewById(r.g.title_text);
        this.clu = (BarImageView) this.Ge.findViewById(r.g.frs_image);
        this.clu.setContentDescription(frsActivity.getResources().getString(r.j.bar_header));
        this.clu.setGifIconSupport(false);
        this.clu.setDrawerType(0);
        this.clv = (UserIconBox) this.Ge.findViewById(r.g.frs_badge_box);
        this.ckX = LayoutInflater.from(this.bTA.getPageContext().getPageActivity()).inflate(r.h.frs_header_extra_entelechy, (ViewGroup) null);
        this.ckY = this.ckX.findViewById(r.g.extra_mask_view);
        at.l(this.ckY, r.d.black_alpha0);
        aeb();
        this.ckZ = (ViewGroup) this.ckX.findViewById(r.g.frs_header_games);
        this.cla = (TextView) this.ckX.findViewById(r.g.top_item_title);
        this.clk = (LinearLayout) this.ckX.findViewById(r.g.frs_header_enter_root);
        this.cll = (LinearLayout) this.ckX.findViewById(r.g.frs_present_root);
        this.cly = new com.baidu.tieba.frs.view.p(this.Gf, this.ckX);
        this.clx = new com.baidu.tieba.frs.utils.b(this.Gf);
        this.clf = (ViewGroup) this.ckX.findViewById(r.g.frs_headline);
        this.clg = (TextView) this.clf.findViewById(r.g.headline_title);
        this.clh = (TextView) this.clf.findViewById(r.g.headline_text);
        this.cli = (TbImageView) this.clf.findViewById(r.g.headline_image);
        this.clf.setVisibility(8);
        aei();
        MessageManager.getInstance().registerListener(this.bYn);
    }

    private void aei() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), cd.class);
        if (runTask != null && runTask.getData() != null) {
            this.clz = (cd) runTask.getData();
            this.clz.a(this.Gf, this.Ge, 1, false);
            this.clz.hide();
        }
    }

    private void aej() {
        com.baidu.tbadk.core.data.m bkK = this.cae.bkK();
        if (bkK != null && this.cae.aOk() != null) {
            String id = this.cae.aOk().getId();
            String name = this.cae.aOk().getName();
            if (this.clX.add(bkK.pw())) {
                a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bkK.pw(), id, name, null);
                a.bV("obj_url", bkK.getUrl());
                a.save();
            }
            this.clf.setVisibility(0);
            this.clg.setText(bkK.getText());
            this.clh.setText(bkK.getTitle());
            this.cli.c(bkK.pv(), 10, false);
            this.clf.setOnClickListener(new l(this, bkK, id, name));
        }
    }

    protected View adX() {
        return LayoutInflater.from(this.bTA.getPageContext().getPageActivity()).inflate(r.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.clu.setOnClickListener(onClickListener);
        this.FZ.setOnClickListener(onClickListener);
        this.ckM.setOnClickListener(onClickListener);
        this.ckO.setOnClickListener(onClickListener);
        this.ckR.setOnClickListener(onClickListener);
        this.ckT.setOnClickListener(onClickListener);
        if (this.ckZ != null) {
            this.ckZ.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.c.e.dN().ac("frs_to_bar_detail") == 0) {
            this.Ge.setOnClickListener(new m(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.Gf.getLayoutMode().ai(i == 1);
        this.Gf.getLayoutMode().x(this.Ge);
        this.Gf.getLayoutMode().x(this.clp);
        this.Gf.getLayoutMode().x(this.ckX);
        if (this.clQ) {
            iQ(1);
        } else {
            iQ(0);
        }
        if (this.bCZ != null) {
            this.bCZ.tB();
        }
        if (this.cle != null) {
            this.cle.d(this.Gf, i);
        }
        this.clu.invalidate();
        at.c(this.ckV, BitmapHelper.getSmallGradeResourceIdNew(this.clH));
        if (this.bYl != null && this.bYl.getBlurredBitmap() != null && !this.bYl.getBlurredBitmap().isRecycled()) {
            this.aUH.setBackgroundDrawable(new BitmapDrawable(this.bYl.getBlurredBitmap()));
        } else {
            at.l(this.aUH, r.d.cp_bg_line_d);
        }
        aek();
        if (this.ckZ != null) {
            at.k(this.ckZ, r.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            at.c(this.cls, r.f.icon_sml_speed_orange);
        } else {
            at.c(this.cls, r.f.icon_sml_speed_gray);
        }
        if (this.cly != null) {
            this.cly.changeSkinType(i);
        }
        if (this.clz != null) {
            this.clz.changeSkinType(i);
        }
        if (this.clv != null) {
            this.clv.dm(i);
        }
        if (this.clA != null) {
            this.clA.d(this.Gf, i);
        }
        Iterator<TbImageView> it = this.bYk.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        aed();
        if (this.cfe != null) {
            this.cfe.onChangeSkinType(this.Gf, i);
        }
        at.k(this.clf, r.f.home_thread_card_item_bg);
        if (this.bYd != null) {
            com.baidu.tbadk.i.a.a(this.bTA.getPageContext(), this.bYd);
        }
    }

    protected void aek() {
        this.Ga.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.ckP.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.p pVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.clI = forumData.getPost_num();
            this.clD = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.clC = forumData.getLevelName();
            this.clH = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.clJ = forumData.getSignData().count_sign_num;
                this.clK = forumData.getSignData().miss_sign_num;
            }
            this.clL = forumData.getCurScore();
            this.cjV = forumData.getLevelupScore();
            this.clw = forumData.getBadgeData();
            this.clm = forumData.getTopCode();
            this.cln = forumData.getNewsInfo();
            this.clE = forumData.getAccelerateContent();
            this.clB = forumData.getMemberShowIconData();
            this.cae = pVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.Ge.setVisibility(8);
            } else {
                this.Ge.setVisibility(0);
            }
            this.clF = new bk();
            ael();
            adY();
            aej();
        }
    }

    protected void ael() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.clF.rY().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void aem() {
        if (this.clK > 0) {
            if (com.baidu.adp.lib.util.k.K(this.Gf.getPageActivity()) >= 480) {
                this.ckS.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            at.c(this.ckS, r.d.cp_cont_i, 1);
            this.ckS.setText(String.format(this.Gf.getString(r.j.miss_sign_days), Integer.valueOf(this.clK)));
        } else {
            this.ckS.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            at.c(this.ckS, r.d.common_color_10061, 1);
            if (this.clJ <= 0) {
                this.ckS.setText(this.Gf.getString(r.j.signed));
            } else {
                this.ckS.setText(String.format(this.Gf.getString(r.j.continuous_sign_days), Integer.valueOf(this.clJ)));
            }
        }
        this.ckR.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void aen() {
    }

    protected void aeo() {
        a(this.cae.bkj());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adY() {
        if (this.cae != null) {
            aeo();
        }
        if (this.cae != null && this.cae.bkE() != null) {
            a(this.cae.bkE());
        }
        if (this.FX != null) {
            this.FX.setText(ax.v(this.mMemberNum));
        }
        if (this.FY != null) {
            this.FY.setText(ax.v(this.clI));
        }
        if (this.FZ != null) {
            if (this.clw != null && this.clw.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.FZ.setText(String.valueOf(this.mForumName) + this.Gf.getString(r.j.forum));
            }
        }
        if (this.ckZ != null && this.cla != null) {
            if (this.cae != null && this.cae.bkp()) {
                int dn = com.baidu.tbadk.core.util.n.dn(this.cae.bks());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dn == 1 && !z) {
                    this.ckZ.setVisibility(8);
                } else {
                    this.ckZ.setVisibility(0);
                    if (!TextUtils.isEmpty(this.cae.getGameName()) && !TextUtils.isEmpty(this.cae.getGameName().trim())) {
                        this.cla.setText(UtilHelper.getFixedText(this.cae.getGameName(), 10));
                        String rL = com.baidu.tieba.tbadkCore.util.m.rL(this.cae.bks());
                        if (!StringUtils.isNull(rL)) {
                            TiebaStatic.eventStat(this.Gf.getPageActivity(), "game_show", "show", 1, "dev_id", rL, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.cla.setText(this.Gf.getResources().getString(r.j.frsgame_title));
                    }
                }
            } else {
                this.ckZ.setVisibility(8);
            }
        }
        if (this.cae != null && this.cae.bkq() != null && this.cae.bkq().size() > 0) {
            List<com.baidu.tieba.tbadkCore.h> bkq = this.cae.bkq();
            aE(bkq);
            int size = bkq.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.clk.setVisibility(0);
                this.clk.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.h hVar = bkq.get(i2);
                    if (hVar != null) {
                        String ka = ka(hVar.aGJ());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(r.g.top_item_title)).setText(hVar.getTitle());
                        ((TextView) viewGroup.findViewById(r.g.top_item_type)).setText(ka);
                        u(viewGroup);
                        viewGroup.setTag(hVar);
                        viewGroup.setOnClickListener(this.clZ);
                        this.clk.addView(viewGroup);
                        if (this.clX.add(hVar.bke())) {
                            a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.bke(), this.bTA.getForumId(), this.bTA.getForumName(), null);
                            a.bV("obj_url", hVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.clk.setVisibility(8);
            }
        } else {
            this.clk.setVisibility(8);
        }
        if (this.cae != null && this.cae.fAp != null && this.cae.fAp.QY.length() > 0) {
            this.cll.setVisibility(0);
            this.cll.removeAllViews();
            com.baidu.tbadk.core.data.v vVar = this.cae.fAp;
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.frs_header_gift_item, (ViewGroup) null);
            TextView textView = (TextView) viewGroup2.findViewById(r.g.top_item_title);
            TextView textView2 = (TextView) viewGroup2.findViewById(r.g.top_item_type);
            HeadImageView headImageView = (HeadImageView) viewGroup2.findViewById(r.g.item_portrait_1);
            HeadImageView headImageView2 = (HeadImageView) viewGroup2.findViewById(r.g.item_portrait_2);
            HeadImageView headImageView3 = (HeadImageView) viewGroup2.findViewById(r.g.item_portrait_3);
            headImageView.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bTA.getBaseContext(), 25.0f));
            headImageView2.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bTA.getBaseContext(), 25.0f));
            headImageView3.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bTA.getBaseContext(), 25.0f));
            ImageView imageView = (ImageView) viewGroup2.findViewById(r.g.item_rank_1);
            ImageView imageView2 = (ImageView) viewGroup2.findViewById(r.g.item_rank_2);
            ImageView imageView3 = (ImageView) viewGroup2.findViewById(r.g.item_rank_3);
            ArrayList<v.a> arrayList = vVar.users;
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
            textView.setText(vVar.QY);
            textView2.setText(r.j.gift);
            u(viewGroup2);
            viewGroup2.setTag(vVar);
            viewGroup2.setOnClickListener(this.cma);
            this.cll.addView(viewGroup2);
        } else {
            this.cll.setVisibility(8);
        }
        if (this.cae != null) {
            this.cly.a(this.cae.bki(), this.cae.aOk());
        } else {
            this.cly.a(null, null);
        }
        adZ();
        if (this.clv != null && this.clw != null && this.clw.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.clw.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.clw.get(i4).pt());
                iconData.setIcon(this.clw.get(i4).ps());
                this.clG = this.clw.get(i4).pu();
                linkedList.add(iconData);
                i3 = i4 + 1;
            }
            this.clv.setOnClickListener(this.aid);
            this.clv.a(linkedList, 2, this.Gf.getResources().getDimensionPixelSize(r.e.ds40), this.Gf.getResources().getDimensionPixelSize(r.e.ds40), this.Gf.getResources().getDimensionPixelSize(r.e.ds14));
        }
        if (this.clz != null && this.cae != null) {
            this.clz.b(this.cae);
        }
        String icon = this.clB.getIcon();
        String url = this.clB.getUrl();
        if (this.clB != null && this.clA != null) {
            this.clA.setIcon(icon);
            this.clA.setUrl(url);
        }
        aea();
        aec();
        aef();
        if (this.cae != null) {
            c(com.baidu.adp.lib.h.b.c(this.mForumId, 0L), this.cae.bkL());
        }
    }

    protected void adZ() {
        this.clu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.clu.c(this.mImageUrl, 15, false);
        if (this.clu.getBdImage() == null || this.clu.getBdImage().jV() == null) {
            aep();
            return;
        }
        if (this.bYm == null) {
            this.bYm = new n(this);
        }
        this.clu.postDelayed(this.bYm, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aep() {
        this.clu.setEvent(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeq() {
        if (this.bTA != null && this.bTA.getActivity() != null) {
            try {
                if (this.bYl == null) {
                    this.bYl = new BlurDrawable(this.bTA.getActivity());
                    if (this.clu != null && this.clu.getBdImage() != null && this.clu.getBdImage().jV() != null && !this.clu.getBdImage().jV().isRecycled()) {
                        this.bYl.init(12, 8, this.clu.getBdImage().jV());
                    }
                }
                if (this.bYl != null && this.bYl.getBlurredBitmap() == null && this.bYl.drawBlur()) {
                    this.aUH.setBackgroundDrawable(new BitmapDrawable(this.bYl.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String ka(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(r.j.tequan);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aea() {
        ViewGroup ahY;
        View ahZ;
        View findViewById;
        this.bYa.eD(false);
        if (this.ckZ.getVisibility() == 0) {
            View findViewById2 = this.ckZ.findViewById(r.g.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.ckZ.getVisibility() == 8 && this.clk.getVisibility() == 0) {
            if (this.clk.getChildCount() > 0 && (findViewById = ((ViewGroup) this.clk.getChildAt(0)).findViewById(r.g.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.clk.getVisibility() == 8 && (ahY = this.cly.ahY()) != null && ahY.getVisibility() == 0 && (ahZ = this.cly.ahZ()) != null) {
            ahZ.setVisibility(8);
        } else {
            this.bYa.eD(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.clY);
            if (this.clo == null) {
                this.clo = new PopupWindow(this.Gf.getPageActivity());
                this.clo.setContentView(this.clp);
                this.clo.setBackgroundDrawable(new BitmapDrawable());
                this.clo.setOutsideTouchable(true);
                this.clo.setFocusable(true);
                this.clo.setWidth(this.Gf.getResources().getDimensionPixelSize(r.e.ds228));
                this.clo.setHeight(this.Gf.getResources().getDimensionPixelSize(r.e.ds100));
                this.clq = (TextView) this.clp.findViewById(r.g.cur_experience);
                this.clr = (TextView) this.clp.findViewById(r.g.levelup_experience);
                a(this.clq, this.clr);
            }
            if (this.clo.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.clo, this.Gf.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.clq, this.clr);
            if (iArr[1] - this.clo.getHeight() <= 50) {
                com.baidu.adp.lib.h.j.a(this.clo, this.Gf.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.clo, this.Ge, 0, iArr[0], iArr[1] - this.clo.getHeight());
            this.clo.update();
            this.mHandler.postDelayed(this.clY, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.Gf.getContext()).inflate(r.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(r.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(r.g.speed_tip);
            at.c((TextView) inflate.findViewById(r.g.experience_txt), r.d.cp_cont_b, 1);
            at.c(textView, r.d.cp_cont_b, 1);
            at.c(textView2, r.d.cp_cont_b, 1);
            at.c(textView3, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Gf.getPageActivity());
            aVar.z(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.clE) && !TextUtils.isEmpty(this.clE.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.clE);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cb(r.d.cp_link_tip_d);
            a(aVar);
            b(aVar);
            aVar.b(this.Gf);
            aVar.tq();
        }
    }

    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(r.j.cancel_text, new p(this));
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(r.j.open_now, new q(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void aer() {
        View contentView;
        if (this.clt == null) {
            this.clt = new PopupWindow(this.Gf.getPageActivity());
            contentView = LayoutInflater.from(this.Gf.getContext()).inflate(r.h.speed_tip, (ViewGroup) null);
            this.clt.setContentView(contentView);
            contentView.setOnClickListener(new r(this));
            this.clt.setWidth(this.Gf.getResources().getDimensionPixelSize(r.e.ds300));
            this.clt.setHeight(this.Gf.getResources().getDimensionPixelSize(r.e.ds88));
            this.clt.setBackgroundDrawable(new BitmapDrawable());
            this.clt.setOutsideTouchable(true);
            this.clt.setTouchInterceptor(new s(this));
        } else {
            contentView = this.clt.getContentView();
        }
        this.Gf.getLayoutMode().x(contentView);
        int[] iArr = new int[2];
        this.cls.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.clt, this.Ge, 0, (iArr[0] - (this.clt.getWidth() / 2)) + (this.cls.getWidth() / 2), iArr[1] + this.cls.getWidth());
        this.clt.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(boolean z, float f) {
        int i;
        this.clR = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(r.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.clR) {
                this.ckU.setText(r.j.level_up);
                if (f >= 1.0f) {
                    i = this.clH;
                } else {
                    i = this.clH + 1;
                }
                com.baidu.tieba.tbadkCore.p acr = this.bTA.acr();
                if (acr != null && acr.aOk() != null) {
                    acr.aOk().setUser_level(i);
                }
                at.c(this.ckV, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.ckU.setText(this.clC);
                at.c(this.ckV, BitmapHelper.getSmallGradeResourceIdNew(this.clH));
            }
            this.ckW.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, id(this.clH)));
            if (this.clR) {
                if (f >= 1.0f) {
                    a(this.Gf.getOrignalPage(), this.ckW, this.clS, f);
                } else {
                    b(this.Gf.getOrignalPage(), this.ckW, this.clS, f);
                }
            } else {
                a(this.Gf.getOrignalPage(), this.ckW, this.clS, f);
            }
            this.clS = f;
        }
    }

    private int[] id(int i) {
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
    protected void aes() {
        this.clx.c(this.ckL, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void aet() {
        if (this.mMemberType != 0) {
            at.c(this.cls, r.f.icon_sml_speed_orange);
        } else {
            at.c(this.cls, r.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bYn);
        if (this.bYl != null) {
            this.bYl.onDestroy();
        }
        if (this.cfe != null) {
            this.cfe.onDestory();
        }
        if (this.clu != null) {
            this.clu.removeCallbacks(this.bYm);
        }
    }
}
