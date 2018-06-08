package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.m;
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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
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
    private String afv;
    private RelativeLayout bkk;
    private final LinearLayout dnf;
    private TextView dng;
    private TextView dnh;
    private ImageView dni;
    private String dnj;
    private String dnk;
    private FrsHeaderPraiseView dnm;
    private String dnn;
    private int mTabId;
    private boolean isFirst = true;
    private int[] dno = {d.f.icon_frs_emotion_level1, d.f.icon_frs_emotion_level2, d.f.icon_frs_emotion_level3, d.f.icon_frs_emotion_level4, d.f.icon_frs_emotion_level5};
    private CustomMessageListener dnp = new CustomMessageListener(2003018) { // from class: com.baidu.tieba.frs.entelechy.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.dDe != null && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    c.this.ckY.setVisibility(8);
                } else {
                    c.this.ckY.setVisibility(0);
                }
            }
        }
    };
    private View.OnClickListener dnq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.8
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
                    if (StringUtils.isNull(c.this.dnk)) {
                        ay.zG().c(c.this.mContext, new String[]{c.this.dnj});
                        z = false;
                    } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(NovelMainActivityConfig.class)) {
                        if (!c.this.aaO()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921334, c.this.dnk));
                        }
                    } else if (PluginPackageManager.lL().bI("com.baidu.tieba.baiduNovel")) {
                        BdToast.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.k.plugin_video_installing), 0).xi();
                        z = false;
                    } else {
                        ay.zG().c(c.this.mContext, new String[]{c.this.dnj});
                        z = false;
                    }
                    am amVar = new am("c12838");
                    amVar.ah(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                    amVar.ah(VideoPlayActivityConfig.OBJ_ID, c.this.dnk);
                    amVar.ah("obj_type", c.this.mTabId != 201 ? "1" : "2");
                    amVar.ah("obj_param1", !z ? "1" : "0");
                    TiebaStatic.log(amVar);
                }
                ay.zG().c(c.this.mContext, new String[]{c.this.dnj});
                z = false;
                am amVar2 = new am("c12838");
                amVar2.ah(ImageViewerConfig.FORUM_NAME, c.this.mForumName);
                amVar2.ah(VideoPlayActivityConfig.OBJ_ID, c.this.dnk);
                amVar2.ah("obj_type", c.this.mTabId != 201 ? "1" : "2");
                amVar2.ah("obj_param1", !z ? "1" : "0");
                TiebaStatic.log(amVar2);
            }
        }
    };
    private ArrayList<TbImageView> dnl = new ArrayList<>();

    public c(FrsFragment frsFragment, String str, String str2, int i) {
        this.bkk = null;
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.diZ = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.dCV = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.dCW = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.dCX = l.e(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = avB();
        this.bkk = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.dDq = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.i.frs_show_experience, (ViewGroup) null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.mParent.setVisibility(8);
        }
        this.dDt = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.dng = (TextView) this.mParent.findViewById(d.g.member_image);
        this.dnh = (TextView) this.mParent.findViewById(d.g.post_image);
        this.dDc = (TextView) this.mParent.findViewById(d.g.level_name);
        this.dDX = (TextView) this.mParent.findViewById(d.g.level);
        this.dDa = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.dDb = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.dDb.setContentDescription(frsFragment.getResources().getString(d.k.sign));
        this.dDd = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.dCY = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.dCZ = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.dDv = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.dgL = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.dDv.setPageId(this.diZ.getUniqueId());
        this.dDv.setContentDescription(frsFragment.getResources().getString(d.k.bar_header));
        this.dDv.setGifIconSupport(false);
        this.dDv.setDrawerType(0);
        this.dDe = LayoutInflater.from(this.diZ.getPageContext().getPageActivity()).inflate(d.i.frs_header_extra_entelechy, (ViewGroup) null);
        avs();
        avy();
        this.dDf = (ViewGroup) this.dDe.findViewById(d.g.frs_header_games);
        this.dDg = (TextView) this.dDe.findViewById(d.g.top_item_title);
        this.dDn = (LinearLayout) this.dDe.findViewById(d.g.frs_present_root);
        this.dDZ = (TextView) this.bkk.findViewById(d.g.new_chapter_btn);
        this.ckY = this.dDe.findViewById(d.g.divider_bottom);
        this.dDz = new e(this.mContext, this.dDe);
        this.dDy = new com.baidu.tieba.frs.f.b(this.mContext);
        this.dDj = (ViewGroup) this.dDe.findViewById(d.g.frs_headline);
        this.dDk = (TextView) this.dDj.findViewById(d.g.headline_title);
        this.dDl = (TextView) this.dDj.findViewById(d.g.headline_text);
        this.dDm = (TbImageView) this.dDj.findViewById(d.g.headline_image);
        this.dDm.setPageId(this.diZ.getUniqueId());
        this.dDj.setVisibility(8);
        this.dDW = this.mParent.findViewById(d.g.level_container);
        this.dDV = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.dDU = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.dDY = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.dni = (ImageView) this.mParent.findViewById(d.g.single_bar_level);
        this.dni.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new am("c12487"));
                if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) c.this.mContext.getPageActivity(), (String) null, true, (int) IEventCenterService.EventId.EventMode.SAPIWEBVIEW_BACK)));
                } else if (!j.jD()) {
                    l.showToast(c.this.mContext.getPageActivity(), d.k.neterror);
                } else if (!StringUtils.isNull(c.this.dnn) && !StringUtils.isNull(c.this.mForumId)) {
                    ay.zG().c(c.this.mContext, new String[]{c.this.dnn + "?forum_id=" + c.this.mForumId});
                }
            }
        });
        avz();
        this.diZ.registerListener(this.dnp);
        this.dnd = (FrsStarRankAndTaskContainer) this.mParent.findViewById(d.g.frs_star_rank_container);
        this.dnd.setContext(this.mContext);
        this.dnf = new LinearLayout(this.diZ.getContext());
        this.dnf.setOrientation(1);
        this.dnf.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dnf.addView(this.dDi);
    }

    @Override // com.baidu.tieba.frs.view.b
    public View avx() {
        return this.dnf;
    }

    private void avy() {
        this.dnm = (FrsHeaderPraiseView) this.dDe.findViewById(d.g.frs_praise_layout);
    }

    private void avz() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016468, (BdUniqueId) null), ae.class);
        if (runTask != null && runTask.getData() != null) {
            this.dDA = (ae) runTask.getData();
            this.dDA.a(this.mContext, this.mParent, 1, false, this.diZ.getUniqueId());
            this.dDA.hide();
        }
    }

    private void avA() {
        final m bvy = this.dBg.bvy();
        if (bvy != null && this.dBg.bam() != null) {
            final String id = this.dBg.bam().getId();
            final String name = this.dBg.bam().getName();
            if (this.dDS.add(bvy.tR())) {
                a.C0234a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "VIEW_TRUE", bvy.tR(), id, name, null);
                b.cl("obj_url", bvy.getUrl());
                b.save();
            }
            this.dDj.setVisibility(0);
            this.dDk.setText(bvy.getText());
            this.dDl.setText(bvy.getTitle());
            this.dDm.startLoad(bvy.tQ(), 10, false);
            this.dDj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.C0234a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0130", "ad_plat", "CLICK", bvy.tR(), id, name, null);
                    b2.cl("obj_url", bvy.getUrl());
                    b2.save();
                    ay.zG().c(c.this.diZ.getPageContext(), new String[]{bvy.getUrl()});
                }
            });
        }
    }

    protected View avB() {
        return LayoutInflater.from(this.diZ.getPageContext().getPageActivity()).inflate(d.i.frs_normal_header, (ViewGroup) null);
    }

    private void kx(int i) {
        if (i <= 0 || i > 5) {
            this.dni.setVisibility(8);
            this.dgL.setMaxWidth(l.e(this.mContext.getPageActivity(), d.e.ds370));
            return;
        }
        this.dni.setVisibility(0);
        Drawable drawable = al.getDrawable(this.dno[i - 1]);
        this.dni.setImageDrawable(drawable);
        this.dgL.setMaxWidth((l.e(this.mContext.getPageActivity(), d.e.ds370) - drawable.getIntrinsicWidth()) - ((LinearLayout.LayoutParams) this.dni.getLayoutParams()).leftMargin);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void n(View.OnClickListener onClickListener) {
        this.dDv.setOnClickListener(onClickListener);
        this.dgL.setOnClickListener(onClickListener);
        this.dDb.setOnClickListener(onClickListener);
        this.dDa.setOnClickListener(onClickListener);
        this.dDW.setOnClickListener(onClickListener);
        if (this.dDf != null) {
            this.dDf.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.dDq);
        this.mContext.getLayoutMode().onModeChanged(this.dDe);
        if (this.dDM) {
            lK(1);
        } else {
            lK(0);
        }
        this.dDv.invalidate();
        al.j(this.bkk, d.C0141d.cp_bg_line_d);
        al.j(this.ckY, d.C0141d.cp_bg_line_e);
        al.h(this.dDX, d.C0141d.cp_cont_j);
        al.h(this.dDc, d.C0141d.cp_cont_j);
        al.h(this.dng, d.C0141d.cp_cont_j);
        al.h(this.dCY, d.C0141d.cp_cont_j);
        al.h(this.dnh, d.C0141d.cp_cont_j);
        al.h(this.dCZ, d.C0141d.cp_cont_j);
        this.dDv.setBorderWidth(l.e(this.mContext.getPageActivity(), d.e.tbds1));
        this.dDv.setBorderColor(al.getColor(d.C0141d.black_alpha15));
        avF();
        if (this.dDf != null) {
            al.i(this.dDf, d.f.frs_top_item_bg);
        }
        if (this.mMemberType != 0) {
            al.c(this.dDt, d.f.icon_sml_speed_orange);
        } else {
            al.c(this.dDt, d.f.icon_sml_speed_gray);
        }
        if (this.dDz != null) {
            this.dDz.changeSkinType(i);
        }
        if (this.dDA != null) {
            this.dDA.changeSkinType(i);
        }
        if (this.dDw != null) {
            this.dDw.dC(i);
        }
        Iterator<TbImageView> it = this.dnl.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        avt();
        al.i(this.dDj, d.f.home_thread_card_item_bg);
        al.h(this.dgL, d.C0141d.cp_cont_b);
        if (this.dnc != null) {
            com.baidu.tbadk.n.a.a(this.diZ.getPageContext(), this.dnc);
        }
        if (this.dnm.getVisibility() == 0) {
            this.dnm.changeSkinType(i);
        }
        al.i(this.dDZ, d.f.btn_round_cont_d);
        al.h(this.dDZ, d.C0141d.btn_cont_j_alpha_20_selector);
        if (this.dDi != null) {
            al.j(this.dDi, d.C0141d.cp_bg_line_e);
        }
        if (this.dnd != null && this.dnd.getVisibility() == 0) {
            this.dnd.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.l lVar) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.dDF = forumData.getPost_num();
            this.dDC = forumData.getTag_color();
            this.afv = forumData.getImage_url();
            this.dDB = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.dDG = forumData.getSignData().count_sign_num;
                this.dDH = forumData.getSignData().miss_sign_num;
            }
            this.dDI = forumData.getCurScore();
            this.dAC = forumData.getLevelupScore();
            this.dDx = forumData.getBadgeData();
            this.dDo = forumData.getTopCode();
            this.dDp = forumData.getNewsInfo();
            this.dDD = forumData.getAccelerateContent();
            this.dBg = lVar;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.dDE = new bd();
            avC();
            avG();
            avA();
            this.dnm.setVisibility(8);
            if (lVar != null && lVar.buW() != null) {
                kx(lVar.buW().grade.intValue());
                this.dnn = lVar.buW().url;
            }
            if (lVar != null && lVar.gHl != null) {
                FrsTabInfo frsTabInfo = lVar.gHl;
                this.dnj = frsTabInfo.tab_url;
                this.mTabId = frsTabInfo.tab_id.intValue();
                this.dnk = frsTabInfo.tab_gid;
                this.dDZ.setVisibility(0);
                if (!StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.dDZ.setText(frsTabInfo.tab_name);
                    if (this.isFirst) {
                        this.isFirst = false;
                        am amVar = new am("c12837");
                        amVar.ah(ImageViewerConfig.FORUM_NAME, this.mForumName);
                        amVar.ah(VideoPlayActivityConfig.OBJ_ID, this.dnk);
                        amVar.ah("obj_type", this.mTabId == 201 ? "1" : "2");
                        TiebaStatic.log(amVar);
                    }
                }
                this.dDZ.setOnClickListener(this.dnq);
            } else {
                this.dDZ.setVisibility(8);
            }
            if (lVar != null && lVar.gHm != null) {
                this.dnd.setData(lVar.gHm);
                this.dnd.setVisibility(0);
                this.dDY.setPadding(0, this.dDY.getPaddingTop(), 0, 0);
                return;
            }
            this.dnd.setVisibility(8);
        }
    }

    protected void avC() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.afv);
        this.dDE.vw().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void avD() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        if (this.dDH > 0) {
            al.c(this.dDb, d.C0141d.cp_cont_i, 1);
            Drawable drawable = al.getDrawable(d.f.icon_public_sign_bu_n);
            drawable.setBounds(0, 0, e, e);
            int e2 = l.e(this.mContext.getPageActivity(), d.e.tbds24);
            this.dDb.setPadding(e2, 0, e2, 0);
            this.dDb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dDb.setText(String.format(this.mContext.getString(d.k.miss_sign_days), Integer.valueOf(this.dDH)));
            al.i(this.dDb, d.f.frs_attention_btn_bg_selector);
        } else {
            Drawable drawable2 = al.getDrawable(d.f.icon_public_sign_blue);
            drawable2.setBounds(0, 0, e, e);
            this.dDb.setCompoundDrawables(drawable2, null, null, null);
            al.c(this.dDb, d.C0141d.cp_cont_e, 1);
            this.dDb.setText(this.mContext.getString(d.k.signed));
            this.dDb.setPadding(0, 0, 0, 0);
            this.dDb.setBackgroundDrawable(null);
        }
        this.dDb.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.dDb.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void avE() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = al.getDrawable(d.f.icon_public_sign_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dDb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dDb.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        al.c(this.dDb, d.C0141d.cp_cont_i, 1);
        al.i(this.dDb, d.f.frs_attention_btn_bg_selector);
    }

    protected void avF() {
        int e = l.e(this.mContext.getPageActivity(), d.e.tbds32);
        Drawable drawable = al.getDrawable(d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, e, e);
        this.dDa.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.dDa.setTextSize(0, l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        al.c(this.dDa, d.C0141d.cp_cont_g, 1);
        al.i(this.dDa, d.f.frs_attention_btn_bg_selector);
    }

    protected void avG() {
        List<g> list = null;
        if (this.dCY != null) {
            this.dCY.setText(ao.B(this.mMemberNum));
        }
        if (this.dCZ != null) {
            this.dCZ.setText(ao.B(this.dDF));
        }
        if (this.dDx != null && this.dDx.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        }
        if (!StringUtils.isNull(this.mForumName)) {
            if (this.mTitleText != null) {
                this.mTitleText.setText(this.mForumName + this.mContext.getString(d.k.forum));
            }
            if (this.dgL != null) {
                this.dgL.setText(this.mForumName + this.mContext.getString(d.k.forum));
            }
        }
        if (this.dDf != null && this.dDg != null) {
            if (this.dBg != null && this.dBg.bvi()) {
                if (n.et(this.dBg.bvk()) == 1 && !o.aoC) {
                    this.dDf.setVisibility(8);
                } else {
                    this.dDf.setVisibility(0);
                    if (!TextUtils.isEmpty(this.dBg.getGameName()) && !TextUtils.isEmpty(this.dBg.getGameName().trim())) {
                        this.dDg.setText(UtilHelper.getFixedText(this.dBg.getGameName(), 10));
                        String tX = com.baidu.tieba.tbadkCore.util.b.tX(this.dBg.bvk());
                        if (!StringUtils.isNull(tX)) {
                            TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", tX, "ref_id", "1000601", "ref_type", "603");
                        }
                    } else {
                        this.dDg.setText(this.mContext.getResources().getString(d.k.frsgame_title));
                    }
                }
            } else {
                this.dDf.setVisibility(8);
            }
        }
        this.dDn.setVisibility(8);
        this.dDz.a(null, null);
        if (this.dDf != null) {
            this.dDh = this.dDf.findViewById(d.g.top_item_divider);
        }
        avH();
        if (this.dBg != null && !w.z(this.dBg.bvj())) {
            list = this.dBg.bvj();
            bz(list);
        }
        bl(list);
    }

    protected void avH() {
        this.dDv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dDv.startLoad(this.afv, 15, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void j(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.dDT);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.dDq);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds100));
                this.dDr = (TextView) this.dDq.findViewById(d.g.cur_experience);
                this.dDs = (TextView) this.dDq.findViewById(d.g.levelup_experience);
                a(this.dDr, this.dDs);
            }
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.dDr, this.dDs);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.g.g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.dDT, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            al.c((TextView) inflate.findViewById(d.g.experience_txt), d.C0141d.cp_cont_b, 1);
            al.c(textView, d.C0141d.cp_cont_b, 1);
            al.c(textView2, d.C0141d.cp_cont_b, 1);
            al.c(textView3, d.C0141d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.w(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.dDD) && !TextUtils.isEmpty(this.dDD.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.dDD);
            } else {
                textView3.setVisibility(8);
            }
            aVar.cd(d.C0141d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.xa();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.c.5
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
    public void avI() {
        View contentView;
        if (this.dDu == null) {
            this.dDu = new PopupWindow(this.mContext.getPageActivity());
            contentView = LayoutInflater.from(this.mContext.getContext()).inflate(d.i.speed_tip, (ViewGroup) null);
            this.dDu.setContentView(contentView);
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.mContext != null && c.this.mContext.getPageActivity() != null) {
                        com.baidu.adp.lib.g.g.a(c.this.dDu, c.this.mContext.getPageActivity());
                        c.this.diZ.dhq = false;
                        com.baidu.tbadk.browser.a.a(c.this.mContext.getPageActivity(), c.this.mContext.getResources().getString(d.k.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.dDu.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds300));
            this.dDu.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds88));
            this.dDu.setBackgroundDrawable(new BitmapDrawable());
            this.dDu.setOutsideTouchable(true);
            this.dDu.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.c.7
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.g.g.a(c.this.dDu);
                        c.this.diZ.dhq = false;
                    }
                    return false;
                }
            });
        } else {
            contentView = this.dDu.getContentView();
        }
        this.mContext.getLayoutMode().onModeChanged(contentView);
        int[] iArr = new int[2];
        this.dDt.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.g.showPopupWindowAtLocation(this.dDu, this.mParent, 0, (iArr[0] - (this.dDu.getWidth() / 2)) + (this.dDt.getWidth() / 2), iArr[1] + this.dDt.getWidth());
        this.dDu.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.dDN = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && cashBitmap.getWidth() > 0) {
            if (this.dDN) {
                this.dDc.setText(d.k.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                com.baidu.tieba.tbadkCore.l atI = this.diZ.atI();
                if (atI != null && atI.bam() != null) {
                    atI.bam().setUser_level(i);
                }
                this.dDX.setText(this.mContext.getResources().getString(d.k.lv_num, Integer.valueOf(i)));
            } else {
                this.dDc.setText(this.dDB);
                this.dDX.setText(this.mContext.getResources().getString(d.k.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.dDd.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ky(this.mLevel)));
            if (this.dDN) {
                if (f >= 1.0f) {
                    a(this.diZ.getBaseFragmentActivity(), this.dDd, this.dDO, f);
                } else {
                    b(this.diZ.getBaseFragmentActivity(), this.dDd, this.dDO, f);
                }
            } else {
                a(this.diZ.getBaseFragmentActivity(), this.dDd, this.dDO, f);
            }
            this.dDO = f;
        }
    }

    private int[] ky(int i) {
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
    protected void avJ() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void avK() {
        if (this.mMemberType != 0) {
            al.c(this.dDt, d.f.icon_sml_speed_orange);
        } else {
            al.c(this.dDt, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        MessageManager.getInstance().unRegisterListener(this.dnp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaO() {
        Activity pageActivity = this.mContext.getPageActivity();
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.zU();
        aVar.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.a(new a.InterfaceC0105a() { // from class: com.baidu.tieba.frs.entelechy.c.9
            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0105a
            public void eZ(String str) {
                ay.zG().c(c.this.mContext, new String[]{c.this.dnj});
            }

            @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0105a
            public void fa(String str) {
            }
        });
        return aVar.u(pageActivity);
    }

    public String tV() {
        return this.dnk;
    }

    public String avL() {
        return this.dnj;
    }
}
