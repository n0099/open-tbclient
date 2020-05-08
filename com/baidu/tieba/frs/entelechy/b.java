package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.g;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.e.d;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.frs.f.h;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String btq;
    private View fAb;
    private final TextView hgA;
    private final View hgB;
    private final ImageView hgC;
    private final TextView hgD;
    private HotRankEntryView hgE;
    private TextView hgn;
    private TextView hgo;
    private ar hgq;
    private boolean hgr;
    private LinearLayout hgt;
    private View hgu;
    private View hgv;
    private View hgw;
    private View hgx;
    private final View hgy;
    private final HeadImageView hgz;
    private RelativeLayout mContainer;
    private boolean hgs = false;
    private ArrayList<TbImageView> hgp = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.han = frsFragment;
        this.duK = frsFragment.getPageContext();
        this.hAG = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hAH = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.hAI = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bRx();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.hAT = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.hvz = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.hAU = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.hAU.setPageId(this.han.getUniqueId());
        this.hAU.setDefaultBgResource(R.color.transparent);
        this.hAU.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hAU.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.fAb = this.mParent.findViewById(R.id.header_top_cover);
        this.hgt = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.hgu = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.hgv = this.mParent.findViewById(R.id.no_service_space);
        this.hAV = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.hAW = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.hAY = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.hgw = this.mParent.findViewById(R.id.frs_topview_space);
        this.hgx = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.hAZ = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.hBd = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.hgn = (TextView) this.mParent.findViewById(R.id.member_image);
        this.hgo = (TextView) this.mParent.findViewById(R.id.post_image);
        this.hAL = (TextView) this.mParent.findViewById(R.id.level_name);
        this.hAR = (TextView) this.mParent.findViewById(R.id.level);
        this.hwV = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.hwV.setText(frsFragment.getResources().getString(R.string.attention));
        this.hwV.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lH(R.color.cp_cont_b);
        this.hwV.setConfig(cVar);
        this.hxc = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.hxc.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lH(R.color.cp_cont_b);
        cVar2.lD(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.hxc.setConfig(cVar2);
        this.hxc.setText(frsFragment.getResources().getString(R.string.sign));
        this.gVe = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.gVf = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.hAJ = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.hAK = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.gXi = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.hAN = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.hBf = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.hBf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hBf.setPageId(this.han.getUniqueId());
        this.hBf.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.hBf.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.hBf.setShowOval(true);
        this.hBf.setPlaceHolder(2);
        this.hAQ = this.mParent.findViewById(R.id.level_container);
        this.hAP = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.hAO = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.hAS = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.hgy = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.hgA = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.hgz = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.hgz.setIsRound(true);
        this.hgz.setDrawBorder(true);
        this.hgz.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hgz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hgB = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.hgC = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.hgD = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.aOR().a(this.hgC, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.hBa = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.hAM = LayoutInflater.from(this.han.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.hgE = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.hAM.setVisibility(8);
        this.hBi = new com.baidu.tieba.frs.f.b(this.duK);
    }

    protected View bRx() {
        return LayoutInflater.from(this.han.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void z(View.OnClickListener onClickListener) {
        this.hBf.setOnClickListener(onClickListener);
        this.gXi.setOnClickListener(onClickListener);
        this.hxc.setOnClickListener(onClickListener);
        this.hwV.setOnClickListener(onClickListener);
        this.hAQ.setOnClickListener(onClickListener);
        if (this.hgE != null) {
            this.hgE.setOnClickListener(onClickListener);
        }
        if (this.hgy != null) {
            this.hgy.setOnClickListener(onClickListener);
        }
        if (this.hgB != null) {
            this.hgB.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRy() {
        this.hAN.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.duK.getLayoutMode().setNightMode(i == 1);
        this.duK.getLayoutMode().onModeChanged(this.mParent);
        this.duK.getLayoutMode().onModeChanged(this.hBa);
        this.duK.getLayoutMode().onModeChanged(this.hAM);
        am.setBackgroundResource(this.gVe, R.drawable.frs_exp_progress);
        am.setBackgroundResource(this.hgu, R.drawable.bg_frs_header_round_corner);
        am.setBackgroundColor(this.hAZ, R.color.cp_bg_line_b);
        am.setBackgroundColor(this.hgw, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hgx, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gVf, R.color.cp_cont_a);
        am.setBackgroundColor(this.hAS, R.color.black_alpha0);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hAW, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hAY, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hgv, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gXi, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAR, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAL, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgn, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAJ, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgo, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAK, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgA, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgD, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAK, (int) R.color.cp_cont_a);
        if (this.hBf != null) {
            this.hBf.setBorderWidth(l.getDimens(this.duK.getPageActivity(), R.dimen.tbds1));
            this.hBf.setBorderColor(am.getColor(R.color.cp_mask_b_alpha16));
            this.hBf.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hBf.setPlaceHolder(2);
            this.hBf.invalidate();
        }
        if (this.hgz != null) {
            this.hgz.invalidate();
        }
        if (this.hBg != null) {
            this.hBg.onChangeSkin(i);
        }
        if (this.hvz != null) {
            this.hvz.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.hgp.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bRN();
        vl(this.hBt ? 1 : 0);
        bRC();
        tL(i);
        Q(bRG(), bRH());
        if (this.hAV != null) {
            this.hAV.onChangeSkinType(i);
        }
        if (this.hAY != null) {
            this.hAY.onChangeSkinType(i);
        }
        if (this.hAX != null) {
            this.hAX.onChangeSkinType(i);
        }
        if (this.hgE != null) {
            this.hgE.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void jb(boolean z) {
        super.jb(z);
        if (this.hAX != null) {
            this.hAX.jb(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.hBn = forumData.getPost_num();
            this.hBk = forumData.getTag_color();
            this.btq = forumData.getImage_url();
            this.hBj = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.hBo = forumData.getSignData().count_sign_num;
                this.hBp = forumData.getSignData().miss_sign_num;
            }
            this.hBq = forumData.getCurScore();
            this.hxf = forumData.getLevelupScore();
            this.hBh = forumData.getBadgeData();
            this.hBl = forumData.getAccelerateContent();
            this.hBv = forumData.isBrandForum;
            this.hyh = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.hyh != null && this.hyh.getHotUserRankData() != null && this.hyh.getHotUserRankData().hot_user != null && this.hyh.getHotUserRankData().hot_user.size() >= 3) {
                this.hgE.setVisibility(0);
                this.hgE.setData(this.hyh.getHotUserRankData(), this.hgr);
            } else {
                this.hgE.setVisibility(8);
            }
            if (this.hyh != null && this.hyh.serviceAreaData != null) {
                this.hAV.setVisibility(0);
                this.hAV.setData(this.hyh.serviceAreaData);
            } else {
                this.hAV.setVisibility(8);
            }
            this.hBm = new bj();
            bRz();
            bRD();
            b(forumData);
        }
    }

    private void b(ForumData forumData) {
        if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
            String str = forumData.getManagers().get(0).show_name;
            if (TextUtils.isEmpty(str)) {
                str = forumData.getManagers().get(0).name;
            }
            if (!TextUtils.isEmpty(str)) {
                this.hgA.setText(str);
                this.hgz.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.hgy.setVisibility(0);
            } else {
                this.hgy.setVisibility(8);
            }
            if (this.hgB.getVisibility() == 0) {
                this.hgB.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hgy.getVisibility() == 0) {
            this.hgy.setVisibility(8);
        }
        if (this.hgB.getVisibility() == 8) {
            this.hgB.setVisibility(0);
        }
    }

    protected void bRz() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.btq);
        this.hBm.aKM().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bRA() {
        if (this.hxs != null) {
            this.hxs.uL(this.hBp);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bRB() {
        if (this.hxs != null) {
            this.hxs.bRB();
        }
    }

    protected void bRC() {
        if (this.hxt != null) {
            this.hxt.bRC();
        }
    }

    protected void bRD() {
        if (this.hAJ != null) {
            this.hAJ.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.hAK != null) {
            this.hAK.setText(aq.numberUniformFormatExtra(this.hBn));
        }
        if (this.hBh != null && this.hBh.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.hBv) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.duK.getString(R.string.forum);
        if (this.aWU != null) {
            this.aWU.setText(str);
        }
        if (this.gXi != null) {
            this.gXi.setText(str);
        }
        bRK();
        this.hgr = bRJ();
        if (this.hgr) {
            this.hvz.setVisibility(8);
            this.fAb.setVisibility(0);
        } else {
            this.fAb.setVisibility(8);
            this.hvz.setVisibility(0);
            this.hAU.setOnClickListener(null);
        }
        bRI();
        tL(TbadkCoreApplication.getInst().getSkinType());
        bRE();
    }

    private void bRE() {
        boolean bRG = bRG();
        boolean bRH = bRH();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Dx = d.bUE().Dx(this.mForumName);
            if (Dx == null) {
                Dx = new e(this.hgs, bRG);
            } else {
                Dx.nl(this.hgs);
                Dx.nm(bRG);
            }
            d.bUE().a(this.mForumName, Dx);
        }
        P(bRG, bRH);
        Q(bRG, bRH);
    }

    private void P(boolean z, boolean z2) {
        if (this.han.bOt() != null) {
            if (!z && !z2) {
                this.hgt.setVisibility(8);
            } else {
                this.hgt.setVisibility(0);
            }
            this.han.bOt().R(z, z2);
        }
    }

    private void Q(boolean z, boolean z2) {
        int dimens;
        if (this.hAT != null && this.hAT.getLayoutParams() != null) {
            if (this.hgE.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.duK.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.hAS.getLayoutParams()).topMargin = l.getDimens(this.duK.getPageActivity(), R.dimen.tbds384);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.duK.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.hgr) {
                dimens -= l.getDimens(this.duK.getPageActivity(), R.dimen.tbds80);
            }
            if (!z && !z2 && this.hgr) {
                if (bRF() != null) {
                    bRF().setVisibility(8);
                }
            } else if (bRF() != null) {
                bRF().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.hAT.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.hAT.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearGradientView bRF() {
        if (this.han == null || this.han.bOt() == null) {
            return null;
        }
        View bVJ = this.han.bOt().bVJ();
        if (bVJ instanceof LinearGradientView) {
            return (LinearGradientView) bVJ;
        }
        return null;
    }

    private boolean bRG() {
        return this.hAY != null && this.hAY.getVisibility() == 0;
    }

    private boolean bRH() {
        return this.hAV != null && this.hAV.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRI() {
        if (this.han != null && this.hyh != null) {
            List<m> showTopThreadList = this.hyh.getShowTopThreadList();
            this.hgs = showTopThreadList.size() > 2;
            a(showTopThreadList, this.hyh.getBusinessPromot());
        }
    }

    private void a(List<m> list, i iVar) {
        if (this.hAY != null) {
            if (iVar != null) {
                this.hAX = new g(this.duK.getPageActivity());
                this.hAW.setVisibility(0);
                this.hAW.addView(this.hAX.getView());
                this.hAX.a(this.hyh != null ? this.hyh.getForum() : null, iVar);
            } else {
                this.hAW.setVisibility(8);
            }
            if (this.han != null && this.han.bOC()) {
                this.hAY.setVisibility(0);
                this.hAY.setFragmentUniqueId(this.han.getUniqueId());
                this.hAY.setForum(this.mForumId, this.mForumName, this.hyh != null ? this.hyh.getForum() : null);
                this.hAY.setDatas(list, iVar);
                if (this.hgq == null) {
                    this.hgq = new ar() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.ar
                        public void an(bj bjVar) {
                            h.a(b.this.han, b.this.hyh, bjVar);
                        }
                    };
                }
                this.hAY.setStatListener(this.hgq);
                return;
            }
            this.hAY.setVisibility(8);
        }
    }

    private boolean bRJ() {
        final t tVar;
        if (this.hyh == null) {
            return false;
        }
        final FrsViewData frsViewData = this.hyh;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cVD())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cVD());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aIL()) < 1) ? null : frsViewData.getActivityHeadData().aIL().get(0);
        }
        if (tVar != null) {
            if (this.hAU != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aIM())) {
                    an anVar = new an("c13326");
                    anVar.cI("fid", frsViewData.getForum().getId());
                    anVar.cI("obj_id", frsViewData.getActivityHeadData().aIM());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.cI("page_type", PageStayDurationConstants.PageName.FRS).af("obj_isad", 1).af("obj_floor", 1).cI("fid", frsViewData.getForum().getId()).cI("obj_id", frsViewData.getActivityHeadData().aIM()).af("obj_adlocate", 1).cI("first_dir", frsViewData.getForum().getFirst_class()).cI("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cI(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dMx);
                    }
                    com.baidu.tieba.s.c.cVo().a(this.han.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aIM(), "", null), anVar2);
                }
                this.hAU.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.hAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.duK != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aIM())) {
                                    String id = frsViewData.getForum().getId();
                                    String aIM = frsViewData.getActivityHeadData().aIM();
                                    an anVar3 = new an("c13330");
                                    anVar3.cI("fid", id);
                                    anVar3.cI("obj_id", aIM);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.cI("page_type", PageStayDurationConstants.PageName.FRS).af("obj_isad", 1).cI("fid", id).cI("obj_id", aIM).af("obj_adlocate", 1).af("obj_floor", 1).cI("first_dir", frsViewData.getForum().getFirst_class()).cI("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.cI(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dMx);
                                    }
                                    com.baidu.tieba.s.c.cVo().b(b.this.han.getUniqueId(), anVar4);
                                }
                                ba.aOV().a(b.this.duK, new String[]{tVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void tL(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hyh != null && (forum = this.hyh.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hgr) {
                LinearGradientView bRF = bRF();
                if (this.hvz != null && bRF != null) {
                    this.hvz.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bRF.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.hAU != null) {
                    this.hAU.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.hAV != null) {
                this.hAV.setThemeFontColor(com.baidu.tieba.lego.card.d.a.dA(themeElement.font_color));
            }
            if (this.hAY != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.hAY.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.dA(str));
            }
        }
    }

    protected void bRK() {
        this.hBf.startLoad(this.btq, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.hBB);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.duK.getPageActivity());
                this.mPopup.setContentView(this.hBa);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.duK.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.duK.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.hBb = (TextView) this.hBa.findViewById(R.id.cur_experience);
            this.hBc = (TextView) this.hBa.findViewById(R.id.levelup_experience);
            am.setBackgroundResource(this.hBa.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.setViewTextColor((TextView) this.hBa.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.setViewTextColor(this.hBb, R.color.common_color_10047, 1);
            am.setViewTextColor(this.hBc, R.color.cp_cont_g, 1);
            a(this.hBb, this.hBc);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.duK.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.duK.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.hBB, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.duK.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duK.getPageActivity());
            aVar.aP(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.hBl) && !TextUtils.isEmpty(this.hBl.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.hBl);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ke(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.duK);
            aVar.aMS();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (b.this.duK != null && b.this.duK.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.duK.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRL() {
        View contentView;
        if (this.hBe == null) {
            this.hBe = new PopupWindow(this.duK.getPageActivity());
            View inflate = LayoutInflater.from(this.duK.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.hBe.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.duK != null && b.this.duK.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hBe, b.this.duK.getPageActivity());
                        b.this.han.gYj = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.duK.getPageActivity(), b.this.duK.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.hBe.setWidth(this.duK.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.hBe.setHeight(this.duK.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.hBe.setBackgroundDrawable(new BitmapDrawable());
            this.hBe.setOutsideTouchable(true);
            this.hBe.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hBe);
                        b.this.han.gYj = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.hBe.getContentView();
        }
        am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.hBd.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.hBe, this.mParent, 0, (iArr[0] - (this.hBe.getWidth() / 2)) + (this.hBd.getWidth() / 2), iArr[1] + this.hBd.getWidth());
        this.hBe.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.hBu = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.hAL != null && this.gVe != null && this.hAR != null && cashBitmap.getWidth() > 0) {
            if (this.hBu) {
                this.hAL.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bOW = this.han.bOW();
                if (bOW != null && bOW.getForum() != null) {
                    bOW.getForum().setUser_level(i);
                }
                this.hAR.setText(this.duK.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.hAL.setText(this.hBj);
                this.hAR.setText(this.duK.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.gVe.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sQ(this.mLevel)));
            if (this.hBu) {
                if (f >= 1.0f) {
                    b(this.gVe, this.hBw, f);
                } else {
                    c(this.gVe, this.hBw, f);
                }
            } else {
                b(this.gVe, this.hBw, f);
            }
            this.hBw = f;
        }
    }

    private int[] sQ(int i) {
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
    protected void bRM() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRN() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hBd, R.drawable.icon_sml_speed_orange);
        } else {
            am.setImageResource(this.hBd, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hBe != null && this.hBe.isShowing()) {
            this.hBe.dismiss();
        }
        if (this.hAX != null) {
            this.hAX.onDestroy();
        }
    }
}
