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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cc;
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
    protected RelativeLayout aTY;
    private BlurDrawable bDZ;
    protected Runnable bEa;
    protected String mImageUrl;
    private CustomMessageListener bEb = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bDY = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aTY = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bzH = frsActivity;
        this.Gf = frsActivity.getPageContext();
        this.bPS = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds20);
        this.bPT = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds72);
        this.bPU = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Ge = Yq();
        this.aTY = (RelativeLayout) this.Ge.findViewById(r.g.container);
        this.aTY.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.e.ds150), 0, 0);
        this.bQL = (ForumMemberIconView) this.Ge.findViewById(r.g.forum_member_icon_layout);
        this.bQL.setVisibility(8);
        this.bQA = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.h.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.Ge.setVisibility(8);
        }
        this.bQn = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.h.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.e(this.Gf.getPageActivity(), r.e.ds220), 0, 0);
        this.bQn.setLayoutParams(layoutParams);
        this.bQm = (CoverFlowView) this.Ge.findViewById(r.g.nomal_frs_coverflowview);
        this.bQp = (ForumHeadSdkView) this.Ge.findViewById(r.g.frs_head_sdk);
        if (this.Ge.findViewById(r.g.frs_head_video_list) != null) {
            this.bKN = (ForumHeadVideoView) this.Ge.findViewById(r.g.frs_head_video_list);
        }
        act();
        this.bQd = (RelativeLayout) this.Ge.findViewById(r.g.btn_love_content);
        this.bQD = (ImageView) this.Ge.findViewById(r.g.speed_icon);
        this.bQe = (TextView) this.Ge.findViewById(r.g.level_name);
        this.bQf = (ImageView) this.Ge.findViewById(r.g.level);
        this.bQg = (ImageView) this.Ge.findViewById(r.g.love_level_top);
        this.bPV = (FrameLayout) this.Ge.findViewById(r.g.love);
        this.bPW = (Button) this.Ge.findViewById(r.g.btn_love);
        this.bPW.setContentDescription(frsActivity.getResources().getString(r.j.attention));
        this.Ga = (TextView) this.Ge.findViewById(r.g.tv_love);
        this.bPX = (FrameLayout) this.Ge.findViewById(r.g.sign);
        this.bPY = (Button) this.Ge.findViewById(r.g.btn_sign);
        this.bPZ = (TextView) this.Ge.findViewById(r.g.tv_sign);
        this.bPZ.setContentDescription(frsActivity.getResources().getString(r.j.sign));
        this.bQa = (ProgressBar) this.Ge.findViewById(r.g.sign_progress);
        this.bQb = (FrameLayout) this.Ge.findViewById(r.g.sign_done);
        this.bQc = (TextView) this.Ge.findViewById(r.g.sign_done_text);
        this.FX = (TextView) this.Ge.findViewById(r.g.member_num_text);
        this.FY = (TextView) this.Ge.findViewById(r.g.post_num_text);
        this.FZ = (TextView) this.Ge.findViewById(r.g.title_text);
        this.bQF = (BarImageView) this.Ge.findViewById(r.g.frs_image);
        this.bQF.setContentDescription(frsActivity.getResources().getString(r.j.bar_header));
        this.bQF.setGifIconSupport(false);
        this.bQF.setDrawerType(0);
        this.bQG = (UserIconBox) this.Ge.findViewById(r.g.frs_badge_box);
        this.bQh = LayoutInflater.from(this.bzH.getPageContext().getPageActivity()).inflate(r.h.frs_header_extra_entelechy, (ViewGroup) null);
        this.bQi = this.bQh.findViewById(r.g.extra_mask_view);
        ar.l(this.bQi, r.d.black_alpha0);
        Yu();
        this.bQj = (ViewGroup) this.bQh.findViewById(r.g.frs_header_games);
        this.bQk = (TextView) this.bQh.findViewById(r.g.top_item_title);
        this.bQv = (LinearLayout) this.bQh.findViewById(r.g.frs_header_enter_root);
        this.bQw = (LinearLayout) this.bQh.findViewById(r.g.frs_present_root);
        this.bQJ = new com.baidu.tieba.frs.view.p(this.Gf, this.bQh);
        this.bQI = new com.baidu.tieba.frs.utils.b(this.Gf);
        this.bQq = (ViewGroup) this.bQh.findViewById(r.g.frs_headline);
        this.bQr = (TextView) this.bQq.findViewById(r.g.headline_title);
        this.bQs = (TextView) this.bQq.findViewById(r.g.headline_text);
        this.bQt = (TbImageView) this.bQq.findViewById(r.g.headline_image);
        this.bQq.setVisibility(8);
        YB();
        MessageManager.getInstance().registerListener(this.bEb);
    }

    private void YB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), cc.class);
        if (runTask != null && runTask.getData() != null) {
            this.bQK = (cc) runTask.getData();
            this.bQK.a(this.Gf, this.Ge, 1, false);
            this.bQK.hide();
        }
    }

    private void YC() {
        com.baidu.tbadk.core.data.m beA = this.bFO.beA();
        if (beA != null && this.bFO.aIk() != null) {
            String id = this.bFO.aIk().getId();
            String name = this.bFO.aIk().getName();
            if (this.bRi.add(beA.pw())) {
                a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", beA.pw(), id, name, null);
                a.bY("obj_url", beA.getUrl());
                a.save();
            }
            this.bQq.setVisibility(0);
            this.bQr.setText(beA.getText());
            this.bQs.setText(beA.getTitle());
            this.bQt.c(beA.pv(), 10, false);
            this.bQq.setOnClickListener(new l(this, beA, id, name));
        }
    }

    protected View Yq() {
        return LayoutInflater.from(this.bzH.getPageContext().getPageActivity()).inflate(r.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bQF.setOnClickListener(onClickListener);
        this.FZ.setOnClickListener(onClickListener);
        this.bPW.setOnClickListener(onClickListener);
        this.bPY.setOnClickListener(onClickListener);
        this.bQb.setOnClickListener(onClickListener);
        this.bQd.setOnClickListener(onClickListener);
        if (this.bQj != null) {
            this.bQj.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.c.e.dN().ac("frs_to_bar_detail") == 0) {
            this.Ge.setOnClickListener(new m(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.Gf.getLayoutMode().ai(i == 1);
        this.Gf.getLayoutMode().x(this.Ge);
        this.Gf.getLayoutMode().x(this.bQA);
        this.Gf.getLayoutMode().x(this.bQh);
        if (this.bRb) {
            ia(1);
        } else {
            ia(0);
        }
        if (this.bQm != null) {
            this.bQm.tm();
        }
        if (this.bQp != null) {
            this.bQp.d(this.Gf, i);
        }
        this.bQF.invalidate();
        ar.c(this.bQf, BitmapHelper.getSmallGradeResourceIdNew(this.bQS));
        if (this.bDZ != null && this.bDZ.getBlurredBitmap() != null && !this.bDZ.getBlurredBitmap().isRecycled()) {
            this.aTY.setBackgroundDrawable(new BitmapDrawable(this.bDZ.getBlurredBitmap()));
        } else {
            ar.l(this.aTY, r.d.cp_bg_line_d);
        }
        YD();
        if (this.bQj != null) {
            ar.k(this.bQj, r.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ar.c(this.bQD, r.f.icon_sml_speed_orange);
        } else {
            ar.c(this.bQD, r.f.icon_sml_speed_gray);
        }
        if (this.bQJ != null) {
            this.bQJ.changeSkinType(i);
        }
        if (this.bQK != null) {
            this.bQK.changeSkinType(i);
        }
        if (this.bQG != null) {
            this.bQG.m12do(i);
        }
        if (this.bQL != null) {
            this.bQL.d(this.Gf, i);
        }
        Iterator<TbImageView> it = this.bDY.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        Yw();
        if (this.bKN != null) {
            this.bKN.onChangeSkinType(this.Gf, i);
        }
        ar.k(this.bQq, r.f.home_thread_card_item_bg);
        if (this.bDR != null) {
            com.baidu.tbadk.i.a.a(this.bzH.getPageContext(), this.bDR);
        }
    }

    protected void YD() {
        this.Ga.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bPZ.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.o oVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bQT = forumData.getPost_num();
            this.bQO = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.bQN = forumData.getLevelName();
            this.bQS = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.bQU = forumData.getSignData().count_sign_num;
                this.bQV = forumData.getSignData().miss_sign_num;
            }
            this.bQW = forumData.getCurScore();
            this.bPe = forumData.getLevelupScore();
            this.bQH = forumData.getBadgeData();
            this.bQx = forumData.getTopCode();
            this.bQy = forumData.getNewsInfo();
            this.bQP = forumData.getAccelerateContent();
            this.bQM = forumData.getMemberShowIconData();
            this.bFO = oVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.Ge.setVisibility(8);
            } else {
                this.Ge.setVisibility(0);
            }
            this.bQQ = new bg();
            YE();
            Yr();
            YC();
        }
    }

    protected void YE() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.bQQ.rP().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void YF() {
        if (this.bQV > 0) {
            if (com.baidu.adp.lib.util.k.I(this.Gf.getPageActivity()) >= 480) {
                this.bQc.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            ar.c(this.bQc, r.d.cp_cont_i, 1);
            this.bQc.setText(String.format(this.Gf.getString(r.j.miss_sign_days), Integer.valueOf(this.bQV)));
        } else {
            this.bQc.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            ar.c(this.bQc, r.d.common_color_10061, 1);
            if (this.bQU <= 0) {
                this.bQc.setText(this.Gf.getString(r.j.signed));
            } else {
                this.bQc.setText(String.format(this.Gf.getString(r.j.continuous_sign_days), Integer.valueOf(this.bQU)));
            }
        }
        this.bQb.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void YG() {
    }

    protected void YH() {
        a(this.bFO.bdZ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yr() {
        if (this.bFO != null) {
            YH();
        }
        if (this.bFO != null && this.bFO.beu() != null) {
            a(this.bFO.beu());
        }
        if (this.FX != null) {
            this.FX.setText(av.v(this.mMemberNum));
        }
        if (this.FY != null) {
            this.FY.setText(av.v(this.bQT));
        }
        if (this.FZ != null) {
            if (this.bQH != null && this.bQH.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.FZ.setText(String.valueOf(this.mForumName) + this.Gf.getString(r.j.forum));
            }
        }
        if (this.bQj != null && this.bQk != null) {
            if (this.bFO != null && this.bFO.bef()) {
                int m11do = com.baidu.tbadk.core.util.n.m11do(this.bFO.bei());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (m11do == 1 && !z) {
                    this.bQj.setVisibility(8);
                } else {
                    this.bQj.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bFO.getGameName()) && !TextUtils.isEmpty(this.bFO.getGameName().trim())) {
                        this.bQk.setText(UtilHelper.getFixedText(this.bFO.getGameName(), 10));
                        String qr = com.baidu.tieba.tbadkCore.util.m.qr(this.bFO.bei());
                        if (!StringUtils.isNull(qr)) {
                            TiebaStatic.eventStat(this.Gf.getPageActivity(), "game_show", "show", 1, "dev_id", qr, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bQk.setText(this.Gf.getResources().getString(r.j.frsgame_title));
                    }
                }
            } else {
                this.bQj.setVisibility(8);
            }
        }
        if (this.bFO != null && this.bFO.beg() != null && this.bFO.beg().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> beg = this.bFO.beg();
            aw(beg);
            int size = beg.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bQv.setVisibility(0);
                this.bQv.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = beg.get(i2);
                    if (gVar != null) {
                        String iE = iE(gVar.aAH());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(r.g.top_item_title)).setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(r.g.top_item_type)).setText(iE);
                        u(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.bRk);
                        this.bQv.addView(viewGroup);
                        if (this.bRi.add(gVar.bdU())) {
                            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bdU(), this.bzH.getForumId(), this.bzH.getForumName(), null);
                            a.bY("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.bQv.setVisibility(8);
            }
        } else {
            this.bQv.setVisibility(8);
        }
        if (this.bFO != null && this.bFO.fes != null && this.bFO.fes.QV.length() > 0) {
            this.bQw.setVisibility(0);
            this.bQw.removeAllViews();
            com.baidu.tbadk.core.data.u uVar = this.bFO.fes;
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.frs_header_gift_item, (ViewGroup) null);
            TextView textView = (TextView) viewGroup2.findViewById(r.g.top_item_title);
            TextView textView2 = (TextView) viewGroup2.findViewById(r.g.top_item_type);
            HeadImageView headImageView = (HeadImageView) viewGroup2.findViewById(r.g.item_portrait_1);
            HeadImageView headImageView2 = (HeadImageView) viewGroup2.findViewById(r.g.item_portrait_2);
            HeadImageView headImageView3 = (HeadImageView) viewGroup2.findViewById(r.g.item_portrait_3);
            headImageView.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bzH.getBaseContext(), 25.0f));
            headImageView2.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bzH.getBaseContext(), 25.0f));
            headImageView3.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bzH.getBaseContext(), 25.0f));
            ImageView imageView = (ImageView) viewGroup2.findViewById(r.g.item_rank_1);
            ImageView imageView2 = (ImageView) viewGroup2.findViewById(r.g.item_rank_2);
            ImageView imageView3 = (ImageView) viewGroup2.findViewById(r.g.item_rank_3);
            ArrayList<u.a> arrayList = uVar.users;
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
            textView.setText(uVar.QV);
            textView2.setText(r.j.gift);
            u(viewGroup2);
            viewGroup2.setTag(uVar);
            viewGroup2.setOnClickListener(this.bRl);
            this.bQw.addView(viewGroup2);
        } else {
            this.bQw.setVisibility(8);
        }
        if (this.bFO != null) {
            this.bQJ.a(this.bFO.bdY(), this.bFO.aIk());
        } else {
            this.bQJ.a(null, null);
        }
        Ys();
        if (this.bQG != null && this.bQH != null && this.bQH.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.bQH.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.bQH.get(i4).pt());
                iconData.setIcon(this.bQH.get(i4).ps());
                this.bQR = this.bQH.get(i4).pu();
                linkedList.add(iconData);
                i3 = i4 + 1;
            }
            this.bQG.setOnClickListener(this.ahE);
            this.bQG.a(linkedList, 2, this.Gf.getResources().getDimensionPixelSize(r.e.ds40), this.Gf.getResources().getDimensionPixelSize(r.e.ds40), this.Gf.getResources().getDimensionPixelSize(r.e.ds14));
        }
        if (this.bQK != null && this.bFO != null) {
            this.bQK.b(this.bFO);
        }
        String icon = this.bQM.getIcon();
        String url = this.bQM.getUrl();
        if (this.bQM != null && this.bQL != null) {
            this.bQL.setIcon(icon);
            this.bQL.setUrl(url);
        }
        Yt();
        Yv();
        Yy();
        if (this.bFO != null) {
            c(com.baidu.adp.lib.h.b.c(this.mForumId, 0L), this.bFO.beB());
        }
    }

    protected void Ys() {
        this.bQF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bQF.c(this.mImageUrl, 15, false);
        if (this.bQF.getBdImage() == null || this.bQF.getBdImage().jV() == null) {
            YI();
            return;
        }
        if (this.bEa == null) {
            this.bEa = new n(this);
        }
        this.bQF.postDelayed(this.bEa, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void YI() {
        this.bQF.setEvent(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void YJ() {
        if (this.bzH != null && this.bzH.getActivity() != null) {
            try {
                if (this.bDZ == null) {
                    this.bDZ = new BlurDrawable(this.bzH.getActivity());
                    if (this.bQF != null && this.bQF.getBdImage() != null && this.bQF.getBdImage().jV() != null && !this.bQF.getBdImage().jV().isRecycled()) {
                        this.bDZ.init(12, 8, this.bQF.getBdImage().jV());
                    }
                }
                if (this.bDZ != null && this.bDZ.getBlurredBitmap() == null && this.bDZ.drawBlur()) {
                    this.aTY.setBackgroundDrawable(new BitmapDrawable(this.bDZ.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String iE(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(r.j.tequan);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yt() {
        ViewGroup acw;
        View acx;
        View findViewById;
        this.bDO.en(false);
        if (this.bQj.getVisibility() == 0) {
            View findViewById2 = this.bQj.findViewById(r.g.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.bQj.getVisibility() == 8 && this.bQv.getVisibility() == 0) {
            if (this.bQv.getChildCount() > 0 && (findViewById = ((ViewGroup) this.bQv.getChildAt(0)).findViewById(r.g.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.bQv.getVisibility() == 8 && (acw = this.bQJ.acw()) != null && acw.getVisibility() == 0 && (acx = this.bQJ.acx()) != null) {
            acx.setVisibility(8);
        } else {
            this.bDO.en(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bRj);
            if (this.bQz == null) {
                this.bQz = new PopupWindow(this.Gf.getPageActivity());
                this.bQz.setContentView(this.bQA);
                this.bQz.setBackgroundDrawable(new BitmapDrawable());
                this.bQz.setOutsideTouchable(true);
                this.bQz.setFocusable(true);
                this.bQz.setWidth(this.Gf.getResources().getDimensionPixelSize(r.e.ds228));
                this.bQz.setHeight(this.Gf.getResources().getDimensionPixelSize(r.e.ds100));
                this.bQB = (TextView) this.bQA.findViewById(r.g.cur_experience);
                this.bQC = (TextView) this.bQA.findViewById(r.g.levelup_experience);
                a(this.bQB, this.bQC);
            }
            if (this.bQz.isShowing()) {
                com.baidu.adp.lib.h.j.a(this.bQz, this.Gf.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bQB, this.bQC);
            if (iArr[1] - this.bQz.getHeight() <= 50) {
                com.baidu.adp.lib.h.j.a(this.bQz, this.Gf.getPageActivity());
                return;
            }
            com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bQz, this.Ge, 0, iArr[0], iArr[1] - this.bQz.getHeight());
            this.bQz.update();
            this.mHandler.postDelayed(this.bRj, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.Gf.getContext()).inflate(r.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(r.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(r.g.speed_tip);
            ar.c((TextView) inflate.findViewById(r.g.experience_txt), r.d.cp_cont_b, 1);
            ar.c(textView, r.d.cp_cont_b, 1);
            ar.c(textView2, r.d.cp_cont_b, 1);
            ar.c(textView3, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Gf.getPageActivity());
            aVar.z(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.bQP) && !TextUtils.isEmpty(this.bQP.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bQP);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cc(r.d.cp_link_tip_d);
            a(aVar);
            b(aVar);
            aVar.b(this.Gf);
            aVar.tb();
        }
    }

    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(r.j.cancel_text, new p(this));
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(r.j.open_now, new q(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void YK() {
        View contentView;
        if (this.bQE == null) {
            this.bQE = new PopupWindow(this.Gf.getPageActivity());
            contentView = LayoutInflater.from(this.Gf.getContext()).inflate(r.h.speed_tip, (ViewGroup) null);
            this.bQE.setContentView(contentView);
            contentView.setOnClickListener(new r(this));
            this.bQE.setWidth(this.Gf.getResources().getDimensionPixelSize(r.e.ds300));
            this.bQE.setHeight(this.Gf.getResources().getDimensionPixelSize(r.e.ds88));
            this.bQE.setBackgroundDrawable(new BitmapDrawable());
            this.bQE.setOutsideTouchable(true);
            this.bQE.setTouchInterceptor(new s(this));
        } else {
            contentView = this.bQE.getContentView();
        }
        this.Gf.getLayoutMode().x(contentView);
        int[] iArr = new int[2];
        this.bQD.getLocationOnScreen(iArr);
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this.bQE, this.Ge, 0, (iArr[0] - (this.bQE.getWidth() / 2)) + (this.bQD.getWidth() / 2), iArr[1] + this.bQD.getWidth());
        this.bQE.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(boolean z, float f) {
        int i;
        this.bRc = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(r.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.bRc) {
                this.bQe.setText(r.j.level_up);
                if (f >= 1.0f) {
                    i = this.bQS;
                } else {
                    i = this.bQS + 1;
                }
                com.baidu.tieba.tbadkCore.o WF = this.bzH.WF();
                if (WF != null && WF.aIk() != null) {
                    WF.aIk().setUser_level(i);
                }
                ar.c(this.bQf, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bQe.setText(this.bQN);
                ar.c(this.bQf, BitmapHelper.getSmallGradeResourceIdNew(this.bQS));
            }
            this.bQg.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, hn(this.bQS)));
            if (this.bRc) {
                if (f >= 1.0f) {
                    a(this.Gf.getOrignalPage(), this.bQg, this.bRd, f);
                } else {
                    b(this.Gf.getOrignalPage(), this.bQg, this.bRd, f);
                }
            } else {
                a(this.Gf.getOrignalPage(), this.bQg, this.bRd, f);
            }
            this.bRd = f;
        }
    }

    private int[] hn(int i) {
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
    protected void YL() {
        this.bQI.c(this.bPV, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void YM() {
        if (this.mMemberType != 0) {
            ar.c(this.bQD, r.f.icon_sml_speed_orange);
        } else {
            ar.c(this.bQD, r.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bEb);
        if (this.bDZ != null) {
            this.bDZ.onDestroy();
        }
        if (this.bKN != null) {
            this.bKN.onDestory();
        }
        if (this.bQF != null) {
            this.bQF.removeCallbacks(this.bEa);
        }
    }
}
