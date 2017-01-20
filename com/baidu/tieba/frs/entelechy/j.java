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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class j extends g {
    private static final String DEFAULT_BADGE_URL = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    protected RelativeLayout aPq;
    private BlurDrawable aVL;
    protected Runnable aVM;
    protected String mImageUrl;
    private CustomMessageListener bKy = new k(this, CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER);
    private ArrayList<TbImageView> bKx = new ArrayList<>();

    public j(FrsActivity frsActivity, String str, String str2, int i) {
        this.aPq = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.bHh = frsActivity;
        this.Fp = frsActivity.getPageContext();
        this.bWx = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.f.ds20);
        this.bWy = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.f.ds72);
        this.bWz = com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.f.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.Fo = Zu();
        this.aPq = (RelativeLayout) this.Fo.findViewById(r.h.container);
        this.aPq.setPadding(0, com.baidu.adp.lib.util.k.e(frsActivity.getPageContext().getPageActivity(), r.f.ds150), 0, 0);
        this.bXp = (ForumMemberIconView) this.Fo.findViewById(r.h.forum_member_icon_layout);
        this.bXp.setVisibility(8);
        this.bXe = LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.j.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.Fo.setVisibility(8);
        }
        this.bWR = (TextView) LayoutInflater.from(frsActivity.getPageContext().getPageActivity()).inflate(r.j.forum_activity_head_title_layout, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds60));
        layoutParams.setMargins(0, com.baidu.adp.lib.util.k.e(this.Fp.getPageActivity(), r.f.ds220), 0, 0);
        this.bWR.setLayoutParams(layoutParams);
        this.bWQ = (CoverFlowView) this.Fo.findViewById(r.h.nomal_frs_coverflowview);
        this.bWT = (ForumHeadSdkView) this.Fo.findViewById(r.h.frs_head_sdk);
        if (this.Fo.findViewById(r.h.frs_head_video_list) != null) {
            this.bRg = (ForumHeadVideoView) this.Fo.findViewById(r.h.frs_head_video_list);
        }
        adC();
        this.bWI = (RelativeLayout) this.Fo.findViewById(r.h.btn_love_content);
        this.bXh = (ImageView) this.Fo.findViewById(r.h.speed_icon);
        this.bWJ = (TextView) this.Fo.findViewById(r.h.level_name);
        this.bWK = (ImageView) this.Fo.findViewById(r.h.level);
        this.bWL = (ImageView) this.Fo.findViewById(r.h.love_level_top);
        this.bWA = (FrameLayout) this.Fo.findViewById(r.h.love);
        this.bWB = (Button) this.Fo.findViewById(r.h.btn_love);
        this.bWB.setContentDescription(frsActivity.getResources().getString(r.l.attention));
        this.Fk = (TextView) this.Fo.findViewById(r.h.tv_love);
        this.bWC = (FrameLayout) this.Fo.findViewById(r.h.sign);
        this.bWD = (Button) this.Fo.findViewById(r.h.btn_sign);
        this.bWE = (TextView) this.Fo.findViewById(r.h.tv_sign);
        this.bWE.setContentDescription(frsActivity.getResources().getString(r.l.sign));
        this.bWF = (ProgressBar) this.Fo.findViewById(r.h.sign_progress);
        this.bWG = (FrameLayout) this.Fo.findViewById(r.h.sign_done);
        this.bWH = (TextView) this.Fo.findViewById(r.h.sign_done_text);
        this.Fh = (TextView) this.Fo.findViewById(r.h.member_num_text);
        this.Fi = (TextView) this.Fo.findViewById(r.h.post_num_text);
        this.Fj = (TextView) this.Fo.findViewById(r.h.title_text);
        this.bXj = (BarImageView) this.Fo.findViewById(r.h.frs_image);
        this.bXj.setContentDescription(frsActivity.getResources().getString(r.l.bar_header));
        this.bXj.setGifIconSupport(false);
        this.bXj.setDrawerType(0);
        this.bXk = (UserIconBox) this.Fo.findViewById(r.h.frs_badge_box);
        this.bWM = LayoutInflater.from(this.bHh.getPageContext().getPageActivity()).inflate(r.j.frs_header_extra_entelechy, (ViewGroup) null);
        this.bWN = this.bWM.findViewById(r.h.extra_mask_view);
        ap.k(this.bWN, r.e.black_alpha0);
        Zy();
        this.bWO = (ViewGroup) this.bWM.findViewById(r.h.frs_header_games);
        this.bWP = (TextView) this.bWM.findViewById(r.h.top_item_title);
        this.bWZ = (LinearLayout) this.bWM.findViewById(r.h.frs_header_enter_root);
        this.bXa = (LinearLayout) this.bWM.findViewById(r.h.frs_present_root);
        this.bXn = new com.baidu.tieba.frs.view.p(this.Fp, this.bWM);
        this.bXm = new com.baidu.tieba.frs.utils.b(this.Fp);
        this.bWU = (ViewGroup) this.bWM.findViewById(r.h.frs_headline);
        this.bWV = (TextView) this.bWU.findViewById(r.h.headline_title);
        this.bWW = (TextView) this.bWU.findViewById(r.h.headline_text);
        this.bWX = (TbImageView) this.bWU.findViewById(r.h.headline_image);
        this.bWU.setVisibility(8);
        ZF();
        MessageManager.getInstance().registerListener(this.bKy);
    }

    private void ZF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_FRS_MORE_FEED_FORUMS_CONTROLLER, (BdUniqueId) null), ca.class);
        if (runTask != null && runTask.getData() != null) {
            this.bXo = (ca) runTask.getData();
            this.bXo.a(this.Fp, this.Fo, 1, false);
            this.bXo.hide();
        }
    }

    private void ZG() {
        com.baidu.tbadk.core.data.n bgo = this.bMf.bgo();
        if (bgo != null && this.bMf.aJY() != null) {
            String id = this.bMf.aJY().getId();
            String name = this.bMf.aJY().getName();
            if (this.bXM.add(bgo.pp())) {
                a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bgo.pp(), id, name, null);
                a.ch("obj_url", bgo.getUrl());
                a.save();
            }
            this.bWU.setVisibility(0);
            this.bWV.setText(bgo.getText());
            this.bWW.setText(bgo.getTitle());
            this.bWX.c(bgo.po(), 10, false);
            this.bWU.setOnClickListener(new l(this, bgo, id, name));
        }
    }

    protected View Zu() {
        return LayoutInflater.from(this.bHh.getPageContext().getPageActivity()).inflate(r.j.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bXj.setOnClickListener(onClickListener);
        this.Fj.setOnClickListener(onClickListener);
        this.bWB.setOnClickListener(onClickListener);
        this.bWD.setOnClickListener(onClickListener);
        this.bWG.setOnClickListener(onClickListener);
        this.bWI.setOnClickListener(onClickListener);
        if (this.bWO != null) {
            this.bWO.setOnClickListener(onClickListener);
        }
        if (com.baidu.adp.lib.b.e.dL().ac("frs_to_bar_detail") == 0) {
            this.Fo.setOnClickListener(new m(this));
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void changeSkinType(int i) {
        this.Fp.getLayoutMode().ai(i == 1);
        this.Fp.getLayoutMode().v(this.Fo);
        this.Fp.getLayoutMode().v(this.bXe);
        this.Fp.getLayoutMode().v(this.bWM);
        if (this.bXF) {
            iO(1);
        } else {
            iO(0);
        }
        if (this.bWQ != null) {
            this.bWQ.tg();
        }
        if (this.bWT != null) {
            this.bWT.d(this.Fp, i);
        }
        this.bXj.invalidate();
        ap.c(this.bWK, BitmapHelper.getSmallGradeResourceIdNew(this.bXw));
        if (this.aVL != null && this.aVL.getBlurredBitmap() != null && !this.aVL.getBlurredBitmap().isRecycled()) {
            this.aPq.setBackgroundDrawable(new BitmapDrawable(this.aVL.getBlurredBitmap()));
        } else {
            ap.k(this.aPq, r.e.cp_bg_line_d);
        }
        ZH();
        if (this.bWO != null) {
            ap.j(this.bWO, r.g.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            ap.c(this.bXh, r.g.icon_sml_speed_orange);
        } else {
            ap.c(this.bXh, r.g.icon_sml_speed_gray);
        }
        if (this.bXn != null) {
            this.bXn.changeSkinType(i);
        }
        if (this.bXo != null) {
            this.bXo.changeSkinType(i);
        }
        if (this.bXk != null) {
            this.bXk.dp(i);
        }
        if (this.bXp != null) {
            this.bXp.d(this.Fp, i);
        }
        Iterator<TbImageView> it = this.bKx.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        ZA();
        if (this.bRg != null) {
            this.bRg.onChangeSkinType(this.Fp, i);
        }
        ap.j(this.bWU, r.g.home_thread_card_item_bg);
        if (this.bKq != null) {
            com.baidu.tbadk.i.a.a(this.bHh.getPageContext(), this.bKq);
        }
    }

    protected void ZH() {
        this.Fk.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.bWE.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sml_sign), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tieba.frs.view.c
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.n nVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.bXx = forumData.getPost_num();
            this.bXs = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.bXr = forumData.getLevelName();
            this.bXw = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.bXy = forumData.getSignData().count_sign_num;
                this.bXz = forumData.getSignData().miss_sign_num;
            }
            this.bXA = forumData.getCurScore();
            this.bVF = forumData.getLevelupScore();
            this.bXl = forumData.getBadgeData();
            this.bXb = forumData.getTopCode();
            this.bXc = forumData.getNewsInfo();
            this.bXt = forumData.getAccelerateContent();
            this.bXq = forumData.getMemberShowIconData();
            this.bMf = nVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.Fo.setVisibility(8);
            } else {
                this.Fo.setVisibility(0);
            }
            this.bXu = new bh();
            ZI();
            Zv();
            ZG();
        }
    }

    protected void ZI() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.bXu.rG().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void ZJ() {
        if (this.bXz > 0) {
            if (com.baidu.adp.lib.util.k.I(this.Fp.getPageActivity()) >= 480) {
                this.bWH.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sml_bu), (Drawable) null, (Drawable) null, (Drawable) null);
            }
            ap.c(this.bWH, r.e.cp_cont_i, 1);
            this.bWH.setText(String.format(this.Fp.getString(r.l.miss_sign_days), Integer.valueOf(this.bXz)));
        } else {
            this.bWH.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sml_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.c(this.bWH, r.e.common_color_10061, 1);
            if (this.bXy <= 0) {
                this.bWH.setText(this.Fp.getString(r.l.signed));
            } else {
                this.bWH.setText(String.format(this.Fp.getString(r.l.continuous_sign_days), Integer.valueOf(this.bXy)));
            }
        }
        this.bWG.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.c
    protected void ZK() {
    }

    protected void ZL() {
        a(this.bMf.bfN());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zv() {
        if (this.bMf != null) {
            ZL();
        }
        if (this.bMf != null && this.bMf.bgi() != null) {
            a(this.bMf.bgi());
        }
        if (this.Fh != null) {
            this.Fh.setText(at.u(this.mMemberNum));
        }
        if (this.Fi != null) {
            this.Fi.setText(at.u(this.bXx));
        }
        if (this.Fj != null) {
            if (this.bXl != null && this.bXl.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.Fj.setText(String.valueOf(this.mForumName) + this.Fp.getString(r.l.forum));
            }
        }
        if (this.bWO != null && this.bWP != null) {
            if (this.bMf != null && this.bMf.bfT()) {
                int dm = com.baidu.tbadk.core.util.m.dm(this.bMf.bfW());
                boolean z = GameDetailActivityConfig.isHaveActivity;
                if (dm == 1 && !z) {
                    this.bWO.setVisibility(8);
                } else {
                    this.bWO.setVisibility(0);
                    if (!TextUtils.isEmpty(this.bMf.getGameName()) && !TextUtils.isEmpty(this.bMf.getGameName().trim())) {
                        this.bWP.setText(UtilHelper.getFixedText(this.bMf.getGameName(), 10));
                        String qL = com.baidu.tieba.tbadkCore.util.m.qL(this.bMf.bfW());
                        if (!StringUtils.isNull(qL)) {
                            TiebaStatic.eventStat(this.Fp.getPageActivity(), "game_show", "show", 1, "dev_id", qL, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.bWP.setText(this.Fp.getResources().getString(r.l.frsgame_title));
                    }
                }
            } else {
                this.bWO.setVisibility(8);
            }
        }
        if (this.bMf != null && this.bMf.bfU() != null && this.bMf.bfU().size() > 0) {
            List<com.baidu.tieba.tbadkCore.g> bfU = this.bMf.bfU();
            aA(bfU);
            int size = bfU.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.bWZ.setVisibility(0);
                this.bWZ.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    com.baidu.tieba.tbadkCore.g gVar = bfU.get(i2);
                    if (gVar != null) {
                        String iR = iR(gVar.aCw());
                        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.frs_header_top_item, (ViewGroup) null);
                        ((TextView) viewGroup.findViewById(r.h.top_item_title)).setText(gVar.getTitle());
                        ((TextView) viewGroup.findViewById(r.h.top_item_type)).setText(iR);
                        s(viewGroup);
                        viewGroup.setTag(gVar);
                        viewGroup.setOnClickListener(this.bXO);
                        this.bWZ.addView(viewGroup);
                        if (this.bXM.add(gVar.bfH())) {
                            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bfH(), this.bHh.getForumId(), this.bHh.getForumName(), null);
                            a.ch("obj_url", gVar.getUrl());
                            a.save();
                        }
                    }
                }
            } else {
                this.bWZ.setVisibility(8);
            }
        } else {
            this.bWZ.setVisibility(8);
        }
        if (this.bMf != null && this.bMf.fnM != null && this.bMf.fnM.Qe.length() > 0) {
            this.bXa.setVisibility(0);
            this.bXa.removeAllViews();
            com.baidu.tbadk.core.data.v vVar = this.bMf.fnM;
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.frs_header_gift_item, (ViewGroup) null);
            TextView textView = (TextView) viewGroup2.findViewById(r.h.top_item_title);
            TextView textView2 = (TextView) viewGroup2.findViewById(r.h.top_item_type);
            HeadImageView headImageView = (HeadImageView) viewGroup2.findViewById(r.h.item_portrait_1);
            HeadImageView headImageView2 = (HeadImageView) viewGroup2.findViewById(r.h.item_portrait_2);
            HeadImageView headImageView3 = (HeadImageView) viewGroup2.findViewById(r.h.item_portrait_3);
            headImageView.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bHh.getBaseContext(), 25.0f));
            headImageView2.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bHh.getBaseContext(), 25.0f));
            headImageView3.setRadius(com.baidu.adp.lib.util.k.dip2px(this.bHh.getBaseContext(), 25.0f));
            ImageView imageView = (ImageView) viewGroup2.findViewById(r.h.item_rank_1);
            ImageView imageView2 = (ImageView) viewGroup2.findViewById(r.h.item_rank_2);
            ImageView imageView3 = (ImageView) viewGroup2.findViewById(r.h.item_rank_3);
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
            textView.setText(vVar.Qe);
            textView2.setText(r.l.gift);
            s(viewGroup2);
            viewGroup2.setTag(vVar);
            viewGroup2.setOnClickListener(this.bXP);
            this.bXa.addView(viewGroup2);
        } else {
            this.bXa.setVisibility(8);
        }
        if (this.bMf != null) {
            this.bXn.a(this.bMf.bfM(), this.bMf.aJY());
        } else {
            this.bXn.a(null, null);
        }
        Zw();
        if (this.bXk != null && this.bXl != null && this.bXl.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.bXl.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.bXl.get(i4).pm());
                iconData.setIcon(this.bXl.get(i4).pl());
                this.bXv = this.bXl.get(i4).pn();
                linkedList.add(iconData);
                i3 = i4 + 1;
            }
            this.bXk.setOnClickListener(this.agS);
            this.bXk.a(linkedList, 2, this.Fp.getResources().getDimensionPixelSize(r.f.ds40), this.Fp.getResources().getDimensionPixelSize(r.f.ds40), this.Fp.getResources().getDimensionPixelSize(r.f.ds14));
        }
        if (this.bXo != null && this.bMf != null) {
            this.bXo.b(this.bMf);
        }
        String icon = this.bXq.getIcon();
        String url = this.bXq.getUrl();
        if (this.bXq != null && this.bXp != null) {
            this.bXp.setIcon(icon);
            this.bXp.setUrl(url);
        }
        Zx();
        Zz();
        ZC();
        if (this.bMf != null) {
            b(com.baidu.adp.lib.g.b.c(this.mForumId, 0L), this.bMf.bgp());
        }
    }

    protected void Zw() {
        this.bXj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bXj.c(this.mImageUrl, 15, false);
        if (this.bXj.getBdImage() == null || this.bXj.getBdImage().jT() == null) {
            Mm();
            return;
        }
        if (this.aVM == null) {
            this.aVM = new n(this);
        }
        this.bXj.postDelayed(this.aVM, 50L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mm() {
        this.bXj.setEvent(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mn() {
        if (this.bHh != null && this.bHh.getActivity() != null) {
            try {
                if (this.aVL == null) {
                    this.aVL = new BlurDrawable(this.bHh.getActivity());
                    if (this.bXj != null && this.bXj.getBdImage() != null && this.bXj.getBdImage().jT() != null && !this.bXj.getBdImage().jT().isRecycled()) {
                        this.aVL.init(12, 8, this.bXj.getBdImage().jT());
                    }
                }
                if (this.aVL != null && this.aVL.getBlurredBitmap() == null && this.aVL.drawBlur()) {
                    this.aPq.setBackgroundDrawable(new BitmapDrawable(this.aVL.getBlurredBitmap()));
                }
            } catch (OutOfMemoryError e) {
            }
        }
    }

    private String iR(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.m9getInst().getString(r.l.frs_forum_member_icon_text);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zx() {
        ViewGroup adG;
        View adH;
        View findViewById;
        this.bKn.er(false);
        if (this.bWO.getVisibility() == 0) {
            View findViewById2 = this.bWO.findViewById(r.h.top_item_divider);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        } else if (this.bWO.getVisibility() == 8 && this.bWZ.getVisibility() == 0) {
            if (this.bWZ.getChildCount() > 0 && (findViewById = ((ViewGroup) this.bWZ.getChildAt(0)).findViewById(r.h.top_item_divider)) != null) {
                findViewById.setVisibility(8);
            }
        } else if (this.bWZ.getVisibility() == 8 && (adG = this.bXn.adG()) != null && adG.getVisibility() == 0 && (adH = this.bXn.adH()) != null) {
            adH.setVisibility(8);
        } else {
            this.bKn.er(true);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void c(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.m9getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.bXN);
            if (this.bXd == null) {
                this.bXd = new PopupWindow(this.Fp.getPageActivity());
                this.bXd.setContentView(this.bXe);
                this.bXd.setBackgroundDrawable(new BitmapDrawable());
                this.bXd.setOutsideTouchable(true);
                this.bXd.setFocusable(true);
                this.bXd.setWidth(this.Fp.getResources().getDimensionPixelSize(r.f.ds228));
                this.bXd.setHeight(this.Fp.getResources().getDimensionPixelSize(r.f.ds100));
                this.bXf = (TextView) this.bXe.findViewById(r.h.cur_experience);
                this.bXg = (TextView) this.bXe.findViewById(r.h.levelup_experience);
                a(this.bXf, this.bXg);
            }
            if (this.bXd.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.bXd, this.Fp.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.bXf, this.bXg);
            if (iArr[1] - this.bXd.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.bXd, this.Fp.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.bXd, this.Fo, 0, iArr[0], iArr[1] - this.bXd.getHeight());
            this.bXd.update();
            this.mHandler.postDelayed(this.bXN, 2000L);
        } else if (TbadkCoreApplication.m9getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.Fp.getContext()).inflate(r.j.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.h.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(r.h.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(r.h.speed_tip);
            ap.c((TextView) inflate.findViewById(r.h.experience_txt), r.e.cp_cont_b, 1);
            ap.c(textView, r.e.cp_cont_b, 1);
            ap.c(textView2, r.e.cp_cont_b, 1);
            ap.c(textView3, r.e.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.Fp.getPageActivity());
            aVar.x(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.bXt) && !TextUtils.isEmpty(this.bXt.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.bXt);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cb(r.e.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.Fp);
            aVar.sV();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(r.l.cancel_text, new p(this));
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(r.l.open_now, new q(this));
    }

    @Override // com.baidu.tieba.frs.view.c
    public void ZM() {
        View contentView;
        if (this.bXi == null) {
            this.bXi = new PopupWindow(this.Fp.getPageActivity());
            contentView = LayoutInflater.from(this.Fp.getContext()).inflate(r.j.speed_tip, (ViewGroup) null);
            this.bXi.setContentView(contentView);
            contentView.setOnClickListener(new r(this));
            this.bXi.setWidth(this.Fp.getResources().getDimensionPixelSize(r.f.ds300));
            this.bXi.setHeight(this.Fp.getResources().getDimensionPixelSize(r.f.ds88));
            this.bXi.setBackgroundDrawable(new BitmapDrawable());
            this.bXi.setOutsideTouchable(true);
            this.bXi.setTouchInterceptor(new s(this));
        } else {
            contentView = this.bXi.getContentView();
        }
        this.Fp.getLayoutMode().v(contentView);
        int[] iArr = new int[2];
        this.bXh.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.bXi, this.Fo, 0, (iArr[0] - (this.bXi.getWidth() / 2)) + (this.bXh.getWidth() / 2), iArr[1] + this.bXh.getWidth());
        this.bXi.update();
    }

    @Override // com.baidu.tieba.frs.view.c
    public void d(boolean z, float f) {
        int i;
        this.bXG = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(r.g.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.bXG) {
                this.bWJ.setText(r.l.level_up);
                if (f >= 1.0f) {
                    i = this.bXw;
                } else {
                    i = this.bXw + 1;
                }
                com.baidu.tieba.tbadkCore.n XW = this.bHh.XW();
                if (XW != null && XW.aJY() != null) {
                    XW.aJY().setUser_level(i);
                }
                ap.c(this.bWK, BitmapHelper.getSmallGradeResourceIdNew(i));
            } else {
                this.bWJ.setText(this.bXr);
                ap.c(this.bWK, BitmapHelper.getSmallGradeResourceIdNew(this.bXw));
            }
            this.bWL.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, hZ(this.bXw)));
            if (this.bXG) {
                if (f >= 1.0f) {
                    a(this.Fp.getOrignalPage(), this.bWL, this.bXH, f);
                } else {
                    b(this.Fp.getOrignalPage(), this.bWL, this.bXH, f);
                }
            } else {
                a(this.Fp.getOrignalPage(), this.bWL, this.bXH, f);
            }
            this.bXH = f;
        }
    }

    private int[] hZ(int i) {
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
    protected void ZN() {
        this.bXm.c(this.bWA, "normal_page");
    }

    @Override // com.baidu.tieba.frs.view.c
    public void ZO() {
        if (this.mMemberType != 0) {
            ap.c(this.bXh, r.g.icon_sml_speed_orange);
        } else {
            ap.c(this.bXh, r.g.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.c
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.bKy);
        if (this.aVL != null) {
            this.aVL.onDestroy();
        }
        if (this.bRg != null) {
            this.bRg.onDestory();
        }
        if (this.bXj != null) {
            this.bXj.removeCallbacks(this.aVM);
        }
    }
}
