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
    private String btm;
    private View fzW;
    private TextView hgh;
    private TextView hgi;
    private ar hgk;
    private boolean hgl;
    private LinearLayout hgn;
    private View hgo;
    private View hgp;
    private View hgq;
    private View hgr;
    private final View hgs;
    private final HeadImageView hgt;
    private final TextView hgu;
    private final View hgv;
    private final ImageView hgw;
    private final TextView hgx;
    private HotRankEntryView hgy;
    private RelativeLayout mContainer;
    private boolean hgm = false;
    private ArrayList<TbImageView> hgj = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hah = frsFragment;
        this.duG = frsFragment.getPageContext();
        this.hAA = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hAB = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.hAC = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bRz();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.hAN = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.hvt = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.hAO = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.hAO.setPageId(this.hah.getUniqueId());
        this.hAO.setDefaultBgResource(R.color.transparent);
        this.hAO.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hAO.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.fzW = this.mParent.findViewById(R.id.header_top_cover);
        this.hgn = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.hgo = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.hgp = this.mParent.findViewById(R.id.no_service_space);
        this.hAP = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.hAQ = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.hAS = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.hgq = this.mParent.findViewById(R.id.frs_topview_space);
        this.hgr = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.hAT = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.hAX = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.hgh = (TextView) this.mParent.findViewById(R.id.member_image);
        this.hgi = (TextView) this.mParent.findViewById(R.id.post_image);
        this.hAF = (TextView) this.mParent.findViewById(R.id.level_name);
        this.hAL = (TextView) this.mParent.findViewById(R.id.level);
        this.hwP = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.hwP.setText(frsFragment.getResources().getString(R.string.attention));
        this.hwP.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lH(R.color.cp_cont_b);
        this.hwP.setConfig(cVar);
        this.hwW = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.hwW.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lH(R.color.cp_cont_b);
        cVar2.lD(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.hwW.setConfig(cVar2);
        this.hwW.setText(frsFragment.getResources().getString(R.string.sign));
        this.gUY = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.gUZ = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.hAD = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.hAE = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.gXc = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.hAH = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.hAZ = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.hAZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hAZ.setPageId(this.hah.getUniqueId());
        this.hAZ.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.hAZ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.hAZ.setShowOval(true);
        this.hAZ.setPlaceHolder(2);
        this.hAK = this.mParent.findViewById(R.id.level_container);
        this.hAJ = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.hAI = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.hAM = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.hgs = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.hgu = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.hgt = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.hgt.setIsRound(true);
        this.hgt.setDrawBorder(true);
        this.hgt.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hgt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hgv = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.hgw = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.hgx = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.aOU().a(this.hgw, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.hAU = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.hAG = LayoutInflater.from(this.hah.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.hgy = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.hAG.setVisibility(8);
        this.hBc = new com.baidu.tieba.frs.f.b(this.duG);
    }

    protected View bRz() {
        return LayoutInflater.from(this.hah.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void z(View.OnClickListener onClickListener) {
        this.hAZ.setOnClickListener(onClickListener);
        this.gXc.setOnClickListener(onClickListener);
        this.hwW.setOnClickListener(onClickListener);
        this.hwP.setOnClickListener(onClickListener);
        this.hAK.setOnClickListener(onClickListener);
        if (this.hgy != null) {
            this.hgy.setOnClickListener(onClickListener);
        }
        if (this.hgs != null) {
            this.hgs.setOnClickListener(onClickListener);
        }
        if (this.hgv != null) {
            this.hgv.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRA() {
        this.hAH.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.duG.getLayoutMode().setNightMode(i == 1);
        this.duG.getLayoutMode().onModeChanged(this.mParent);
        this.duG.getLayoutMode().onModeChanged(this.hAU);
        this.duG.getLayoutMode().onModeChanged(this.hAG);
        am.setBackgroundResource(this.gUY, R.drawable.frs_exp_progress);
        am.setBackgroundResource(this.hgo, R.drawable.bg_frs_header_round_corner);
        am.setBackgroundColor(this.hAT, R.color.cp_bg_line_b);
        am.setBackgroundColor(this.hgq, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hgr, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gUZ, R.color.cp_cont_a);
        am.setBackgroundColor(this.hAM, R.color.black_alpha0);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hAQ, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hAS, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hgp, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gXc, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAL, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAF, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgh, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAD, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgi, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAE, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgu, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hgx, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hAE, (int) R.color.cp_cont_a);
        if (this.hAZ != null) {
            this.hAZ.setBorderWidth(l.getDimens(this.duG.getPageActivity(), R.dimen.tbds1));
            this.hAZ.setBorderColor(am.getColor(R.color.cp_mask_b_alpha16));
            this.hAZ.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hAZ.setPlaceHolder(2);
            this.hAZ.invalidate();
        }
        if (this.hgt != null) {
            this.hgt.invalidate();
        }
        if (this.hBa != null) {
            this.hBa.onChangeSkin(i);
        }
        if (this.hvt != null) {
            this.hvt.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.hgj.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bRP();
        vl(this.hBn ? 1 : 0);
        bRE();
        tL(i);
        Q(bRI(), bRJ());
        if (this.hAP != null) {
            this.hAP.onChangeSkinType(i);
        }
        if (this.hAS != null) {
            this.hAS.onChangeSkinType(i);
        }
        if (this.hAR != null) {
            this.hAR.onChangeSkinType(i);
        }
        if (this.hgy != null) {
            this.hgy.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void jb(boolean z) {
        super.jb(z);
        if (this.hAR != null) {
            this.hAR.jb(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.hBh = forumData.getPost_num();
            this.hBe = forumData.getTag_color();
            this.btm = forumData.getImage_url();
            this.hBd = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.hBi = forumData.getSignData().count_sign_num;
                this.hBj = forumData.getSignData().miss_sign_num;
            }
            this.hBk = forumData.getCurScore();
            this.hwZ = forumData.getLevelupScore();
            this.hBb = forumData.getBadgeData();
            this.hBf = forumData.getAccelerateContent();
            this.hBp = forumData.isBrandForum;
            this.hyb = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.hyb != null && this.hyb.getHotUserRankData() != null && this.hyb.getHotUserRankData().hot_user != null && this.hyb.getHotUserRankData().hot_user.size() >= 3) {
                this.hgy.setVisibility(0);
                this.hgy.setData(this.hyb.getHotUserRankData(), this.hgl);
            } else {
                this.hgy.setVisibility(8);
            }
            this.hBg = new bj();
            bRB();
            bRF();
            if (this.hyb != null && this.hyb.serviceAreaData != null) {
                this.hAP.setVisibility(0);
                this.hAP.setData(this.hyb.serviceAreaData);
            } else {
                this.hAP.setVisibility(8);
            }
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
                this.hgu.setText(str);
                this.hgt.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.hgs.setVisibility(0);
            } else {
                this.hgs.setVisibility(8);
            }
            if (this.hgv.getVisibility() == 0) {
                this.hgv.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hgs.getVisibility() == 0) {
            this.hgs.setVisibility(8);
        }
        if (this.hgv.getVisibility() == 8) {
            this.hgv.setVisibility(0);
        }
    }

    protected void bRB() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.btm);
        this.hBg.aKO().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bRC() {
        if (this.hxm != null) {
            this.hxm.uL(this.hBj);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bRD() {
        if (this.hxm != null) {
            this.hxm.bRD();
        }
    }

    protected void bRE() {
        if (this.hxn != null) {
            this.hxn.bRE();
        }
    }

    protected void bRF() {
        if (this.hAD != null) {
            this.hAD.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.hAE != null) {
            this.hAE.setText(aq.numberUniformFormatExtra(this.hBh));
        }
        if (this.hBb != null && this.hBb.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.hBp) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.duG.getString(R.string.forum);
        if (this.aWP != null) {
            this.aWP.setText(str);
        }
        if (this.gXc != null) {
            this.gXc.setText(str);
        }
        bRM();
        this.hgl = bRL();
        if (this.hgl) {
            this.hvt.setVisibility(8);
            this.fzW.setVisibility(0);
        } else {
            this.fzW.setVisibility(8);
            this.hvt.setVisibility(0);
            this.hAO.setOnClickListener(null);
        }
        bRK();
        tL(TbadkCoreApplication.getInst().getSkinType());
        bRG();
    }

    private void bRG() {
        boolean bRI = bRI();
        boolean bRJ = bRJ();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Du = d.bUG().Du(this.mForumName);
            if (Du == null) {
                Du = new e(this.hgm, bRI);
            } else {
                Du.nl(this.hgm);
                Du.nm(bRI);
            }
            d.bUG().a(this.mForumName, Du);
        }
        P(bRI, bRJ);
        Q(bRI, bRJ);
    }

    private void P(boolean z, boolean z2) {
        if (this.hah.bOv() != null) {
            if (!z && !z2) {
                this.hgn.setVisibility(8);
            } else {
                this.hgn.setVisibility(0);
            }
            this.hah.bOv().R(z, z2);
        }
    }

    private void Q(boolean z, boolean z2) {
        int dimens;
        if (this.hAN != null && this.hAN.getLayoutParams() != null) {
            if (this.hgy.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.duG.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.hAM.getLayoutParams()).topMargin = l.getDimens(this.duG.getPageActivity(), R.dimen.tbds384);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.duG.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.hgl) {
                dimens -= l.getDimens(this.duG.getPageActivity(), R.dimen.tbds80);
            }
            if (!z && !z2 && this.hgl) {
                if (bRH() != null) {
                    bRH().setVisibility(8);
                }
            } else if (bRH() != null) {
                bRH().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.hAN.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.hAN.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearGradientView bRH() {
        if (this.hah == null || this.hah.bOv() == null) {
            return null;
        }
        View bVL = this.hah.bOv().bVL();
        if (bVL instanceof LinearGradientView) {
            return (LinearGradientView) bVL;
        }
        return null;
    }

    private boolean bRI() {
        return this.hAS != null && this.hAS.getVisibility() == 0;
    }

    private boolean bRJ() {
        return this.hAP != null && this.hAP.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRK() {
        if (this.hah != null && this.hyb != null) {
            List<m> showTopThreadList = this.hyb.getShowTopThreadList();
            this.hgm = showTopThreadList.size() > 2;
            a(showTopThreadList, this.hyb.getBusinessPromot());
        }
    }

    private void a(List<m> list, i iVar) {
        if (this.hAS != null) {
            if (iVar != null) {
                this.hAR = new g(this.duG.getPageActivity());
                this.hAQ.setVisibility(0);
                this.hAQ.addView(this.hAR.getView());
                this.hAR.a(this.hyb != null ? this.hyb.getForum() : null, iVar);
            } else {
                this.hAQ.setVisibility(8);
            }
            if (this.hah != null && this.hah.bOE()) {
                this.hAS.setVisibility(0);
                this.hAS.setFragmentUniqueId(this.hah.getUniqueId());
                this.hAS.setForum(this.mForumId, this.mForumName, this.hyb != null ? this.hyb.getForum() : null);
                this.hAS.setDatas(list, iVar);
                if (this.hgk == null) {
                    this.hgk = new ar() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.ar
                        public void an(bj bjVar) {
                            h.a(b.this.hah, b.this.hyb, bjVar);
                        }
                    };
                }
                this.hAS.setStatListener(this.hgk);
                return;
            }
            this.hAS.setVisibility(8);
        }
    }

    private boolean bRL() {
        final t tVar;
        if (this.hyb == null) {
            return false;
        }
        final FrsViewData frsViewData = this.hyb;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cVG())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cVG());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aIN()) < 1) ? null : frsViewData.getActivityHeadData().aIN().get(0);
        }
        if (tVar != null) {
            if (this.hAO != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aIO())) {
                    an anVar = new an("c13326");
                    anVar.cI("fid", frsViewData.getForum().getId());
                    anVar.cI("obj_id", frsViewData.getActivityHeadData().aIO());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.cI("page_type", PageStayDurationConstants.PageName.FRS).af("obj_isad", 1).af("obj_floor", 1).cI("fid", frsViewData.getForum().getId()).cI("obj_id", frsViewData.getActivityHeadData().aIO()).af("obj_adlocate", 1).cI("first_dir", frsViewData.getForum().getFirst_class()).cI("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cI(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dMt);
                    }
                    com.baidu.tieba.s.c.cVr().a(this.hah.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aIO(), "", null), anVar2);
                }
                this.hAO.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.hAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.duG != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aIO())) {
                                    String id = frsViewData.getForum().getId();
                                    String aIO = frsViewData.getActivityHeadData().aIO();
                                    an anVar3 = new an("c13330");
                                    anVar3.cI("fid", id);
                                    anVar3.cI("obj_id", aIO);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.cI("page_type", PageStayDurationConstants.PageName.FRS).af("obj_isad", 1).cI("fid", id).cI("obj_id", aIO).af("obj_adlocate", 1).af("obj_floor", 1).cI("first_dir", frsViewData.getForum().getFirst_class()).cI("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.cI(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dMt);
                                    }
                                    com.baidu.tieba.s.c.cVr().b(b.this.hah.getUniqueId(), anVar4);
                                }
                                ba.aOY().a(b.this.duG, new String[]{tVar.getLinkUrl()}, true);
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
        if (this.hyb != null && (forum = this.hyb.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hgl) {
                LinearGradientView bRH = bRH();
                if (this.hvt != null && bRH != null) {
                    this.hvt.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bRH.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.hAO != null) {
                    this.hAO.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.hAP != null) {
                this.hAP.setThemeFontColor(com.baidu.tieba.lego.card.d.a.dA(themeElement.font_color));
            }
            if (this.hAS != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.hAS.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.dA(str));
            }
        }
    }

    protected void bRM() {
        this.hAZ.startLoad(this.btm, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.hBv);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.duG.getPageActivity());
                this.mPopup.setContentView(this.hAU);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.duG.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.duG.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.hAV = (TextView) this.hAU.findViewById(R.id.cur_experience);
            this.hAW = (TextView) this.hAU.findViewById(R.id.levelup_experience);
            am.setBackgroundResource(this.hAU.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.setViewTextColor((TextView) this.hAU.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.setViewTextColor(this.hAV, R.color.common_color_10047, 1);
            am.setViewTextColor(this.hAW, R.color.cp_cont_g, 1);
            a(this.hAV, this.hAW);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.duG.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.duG.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.hBv, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.duG.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
            aVar.aP(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.hBf) && !TextUtils.isEmpty(this.hBf.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.hBf);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ke(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.duG);
            aVar.aMU();
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
                if (b.this.duG != null && b.this.duG.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.duG.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRN() {
        View contentView;
        if (this.hAY == null) {
            this.hAY = new PopupWindow(this.duG.getPageActivity());
            View inflate = LayoutInflater.from(this.duG.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.hAY.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.duG != null && b.this.duG.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hAY, b.this.duG.getPageActivity());
                        b.this.hah.gYd = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.duG.getPageActivity(), b.this.duG.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.hAY.setWidth(this.duG.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.hAY.setHeight(this.duG.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.hAY.setBackgroundDrawable(new BitmapDrawable());
            this.hAY.setOutsideTouchable(true);
            this.hAY.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hAY);
                        b.this.hah.gYd = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.hAY.getContentView();
        }
        am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.hAX.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.hAY, this.mParent, 0, (iArr[0] - (this.hAY.getWidth() / 2)) + (this.hAX.getWidth() / 2), iArr[1] + this.hAX.getWidth());
        this.hAY.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.hBo = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.hAF != null && this.gUY != null && this.hAL != null && cashBitmap.getWidth() > 0) {
            if (this.hBo) {
                this.hAF.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bOY = this.hah.bOY();
                if (bOY != null && bOY.getForum() != null) {
                    bOY.getForum().setUser_level(i);
                }
                this.hAL.setText(this.duG.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.hAF.setText(this.hBd);
                this.hAL.setText(this.duG.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.gUY.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sQ(this.mLevel)));
            if (this.hBo) {
                if (f >= 1.0f) {
                    b(this.gUY, this.hBq, f);
                } else {
                    c(this.gUY, this.hBq, f);
                }
            } else {
                b(this.gUY, this.hBq, f);
            }
            this.hBq = f;
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
    protected void bRO() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bRP() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hAX, R.drawable.icon_sml_speed_orange);
        } else {
            am.setImageResource(this.hAX, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hAY != null && this.hAY.isShowing()) {
            this.hAY.dismiss();
        }
        if (this.hAR != null) {
            this.hAR.onDestroy();
        }
    }
}
