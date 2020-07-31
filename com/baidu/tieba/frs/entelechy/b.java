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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.f;
import com.baidu.tieba.frs.ax;
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
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String bGf;
    private View gfn;
    private TextView hOe;
    private TextView hOf;
    private ax hOh;
    private boolean hOi;
    private LinearLayout hOk;
    private View hOl;
    private View hOm;
    private View hOn;
    private View hOo;
    private final View hOp;
    private final HeadImageView hOq;
    private final TextView hOr;
    private final View hOs;
    private final ImageView hOt;
    private final TextView hOu;
    private HotRankEntryView hOv;
    private List<q> hOw;
    private RelativeLayout mContainer;
    private boolean hOj = false;
    private ArrayList<TbImageView> hOg = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hHU = frsFragment;
        this.dVN = frsFragment.getPageContext();
        this.ijz = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.ijA = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.ijB = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = ceK();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.ijM = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.ien = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.ijN = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.ijN.setPageId(this.hHU.getUniqueId());
        this.ijN.setDefaultBgResource(R.color.transparent);
        this.ijN.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ijN.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.gfn = this.mParent.findViewById(R.id.header_top_cover);
        this.hOk = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.hOl = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.hOm = this.mParent.findViewById(R.id.no_service_space);
        this.ijO = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.ijP = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.ijR = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.hOn = this.mParent.findViewById(R.id.frs_topview_space);
        this.hOo = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.ijS = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.ijW = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.hOe = (TextView) this.mParent.findViewById(R.id.member_image);
        this.hOf = (TextView) this.mParent.findViewById(R.id.post_image);
        this.ijE = (TextView) this.mParent.findViewById(R.id.level_name);
        this.ijK = (TextView) this.mParent.findViewById(R.id.level);
        this.ifJ = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.ifJ.setText(frsFragment.getResources().getString(R.string.attention));
        this.ifJ.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mW(R.color.cp_cont_b);
        this.ifJ.setConfig(cVar);
        this.ifQ = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.ifQ.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.mW(R.color.cp_cont_b);
        cVar2.mR(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.ifQ.setConfig(cVar2);
        this.ifQ.setText(frsFragment.getResources().getString(R.string.sign));
        this.hBU = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hBV = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.ijC = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.ijD = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hEa = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.ijG = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.ijY = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.ijY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ijY.setPageId(this.hHU.getUniqueId());
        this.ijY.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.ijY.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.ijY.setShowOval(true);
        this.ijY.setPlaceHolder(2);
        this.ijJ = this.mParent.findViewById(R.id.level_container);
        this.ijI = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.ijH = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.ijL = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.hOp = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.hOr = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.hOq = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.hOq.setIsRound(true);
        this.hOq.setDrawBorder(true);
        this.hOq.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hOq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hOs = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.hOt = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.hOu = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.baR().a(this.hOt, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.ijT = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.ijF = LayoutInflater.from(this.hHU.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.hOv = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.ijF.setVisibility(8);
        this.ikb = new com.baidu.tieba.frs.f.b(this.dVN);
    }

    protected View ceK() {
        return LayoutInflater.from(this.hHU.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void z(View.OnClickListener onClickListener) {
        this.ijY.setOnClickListener(onClickListener);
        this.hEa.setOnClickListener(onClickListener);
        this.ifQ.setOnClickListener(onClickListener);
        this.ifJ.setOnClickListener(onClickListener);
        this.ijJ.setOnClickListener(onClickListener);
        if (this.hOv != null) {
            this.hOv.setOnClickListener(onClickListener);
        }
        if (this.hOp != null) {
            this.hOp.setOnClickListener(onClickListener);
        }
        if (this.hOs != null) {
            this.hOs.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ceL() {
        this.ijG.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.dVN.getLayoutMode().setNightMode(i == 1);
        this.dVN.getLayoutMode().onModeChanged(this.mParent);
        this.dVN.getLayoutMode().onModeChanged(this.ijT);
        this.dVN.getLayoutMode().onModeChanged(this.ijF);
        ao.setBackgroundResource(this.hBU, R.drawable.frs_exp_progress);
        ao.setBackgroundResource(this.hOl, R.drawable.bg_frs_header_round_corner);
        ao.setBackgroundColor(this.ijS, R.color.cp_bg_line_b);
        ao.setBackgroundColor(this.hOn, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hOo, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hBV, R.color.cp_cont_a);
        ao.setBackgroundColor(this.ijL, R.color.black_alpha0);
        ao.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.ijP, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.ijR, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hOm, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.hEa, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijK, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijE, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOe, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijC, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOf, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijD, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOr, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOu, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijD, R.color.cp_cont_a);
        if (this.ijY != null) {
            this.ijY.setBorderWidth(l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds1));
            this.ijY.setBorderColor(ao.getColor(R.color.cp_mask_b_alpha16));
            this.ijY.setStrokeColorResId(R.color.cp_bg_line_d);
            this.ijY.setPlaceHolder(2);
            this.ijY.invalidate();
        }
        if (this.hOq != null) {
            this.hOq.invalidate();
        }
        if (this.ijZ != null) {
            this.ijZ.onChangeSkin(i);
        }
        if (this.ien != null) {
            this.ien.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.hOg.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cfa();
        wR(this.ikm ? 1 : 0);
        ceP();
        vp(i);
        U(ceT(), ceU());
        if (this.ijO != null) {
            this.ijO.onChangeSkinType(i);
        }
        if (this.ijR != null) {
            this.ijR.onChangeSkinType(i);
        }
        if (this.ijQ != null) {
            this.ijQ.onChangeSkinType(i);
        }
        if (this.hOv != null) {
            this.hOv.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bE(boolean z) {
        super.bE(z);
        if (this.ijQ != null) {
            this.ijQ.bE(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.ikg = forumData.getPost_num();
            this.ikd = forumData.getTag_color();
            this.bGf = forumData.getImage_url();
            this.ikc = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ikh = forumData.getSignData().count_sign_num;
                this.iki = forumData.getSignData().miss_sign_num;
            }
            this.ikj = forumData.getCurScore();
            this.ifT = forumData.getLevelupScore();
            this.ika = forumData.getBadgeData();
            this.ike = forumData.getAccelerateContent();
            this.iko = forumData.isBrandForum;
            this.igV = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.igV != null && this.igV.getHotUserRankData() != null && this.igV.getHotUserRankData().hot_user != null && this.igV.getHotUserRankData().hot_user.size() >= 3) {
                this.hOv.setVisibility(0);
                this.hOv.setData(this.igV.getHotUserRankData(), this.hOi);
            } else {
                this.hOv.setVisibility(8);
            }
            if (this.igV != null && this.igV.serviceAreaData != null) {
                this.ijO.setVisibility(0);
                this.ijO.setData(this.igV.serviceAreaData);
            } else {
                this.ijO.setVisibility(8);
            }
            this.ikf = new bv();
            ceM();
            ceQ();
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
                this.hOr.setText(str);
                this.hOq.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.hOp.setVisibility(0);
            } else {
                this.hOp.setVisibility(8);
            }
            if (this.hOs.getVisibility() == 0) {
                this.hOs.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hOp.getVisibility() == 0) {
            this.hOp.setVisibility(8);
        }
        if (this.hOs.getVisibility() == 8) {
            this.hOs.setVisibility(0);
        }
    }

    protected void ceM() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bGf);
        this.ikf.aWu().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void ceN() {
        if (this.igg != null) {
            this.igg.wq(this.iki);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void ceO() {
        if (this.igg != null) {
            this.igg.ceO();
        }
    }

    protected void ceP() {
        if (this.igh != null) {
            this.igh.ceP();
        }
    }

    protected void ceQ() {
        if (this.ijC != null) {
            this.ijC.setText(as.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.ijD != null) {
            this.ijD.setText(as.numberUniformFormatExtra(this.ikg));
        }
        if (this.ika != null && this.ika.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.iko) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.dVN.getString(R.string.forum);
        if (this.bjS != null) {
            this.bjS.setText(str);
        }
        if (this.hEa != null) {
            this.hEa.setText(str);
        }
        ceX();
        this.hOi = ceW();
        if (this.hOi) {
            this.ien.setVisibility(8);
            this.gfn.setVisibility(0);
        } else {
            this.gfn.setVisibility(8);
            this.ien.setVisibility(0);
            this.ijN.setOnClickListener(null);
        }
        ceV();
        vp(TbadkCoreApplication.getInst().getSkinType());
        ceR();
    }

    private void ceR() {
        boolean ceT = ceT();
        boolean ceU = ceU();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Gt = d.cic().Gt(this.mForumName);
            if (Gt == null) {
                Gt = new e(this.hOj, ceT);
            } else {
                Gt.ox(this.hOj);
                Gt.oy(ceT);
            }
            d.cic().a(this.mForumName, Gt);
        }
        T(ceT, ceU);
        U(ceT, ceU);
    }

    private void T(boolean z, boolean z2) {
        if (this.hHU.cbu() != null) {
            if (!z && !z2) {
                this.hOk.setVisibility(8);
            } else {
                this.hOk.setVisibility(0);
            }
            this.hHU.cbu().W(z, z2);
        }
    }

    private void U(boolean z, boolean z2) {
        int dimens;
        if (this.ijM != null && this.ijM.getLayoutParams() != null) {
            if (this.hOv.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.ijL.getLayoutParams()).topMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.dVN.getPageActivity());
                ((RelativeLayout.LayoutParams) this.hOv.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.hOi) {
                dimens -= l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds80);
            } else if (this.hOi) {
                int dimens3 = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds782);
                int V = V(z, z2);
                int i = dimens3 + V;
                ((RelativeLayout.LayoutParams) this.ijN.getLayoutParams()).bottomMargin = V;
                ((RelativeLayout.LayoutParams) this.gfn.getLayoutParams()).bottomMargin = V;
                if (V != 0) {
                    ((RelativeLayout.LayoutParams) this.ijL.getLayoutParams()).topMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.ijL.getLayoutParams()).topMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.hOi) {
                if (ceS() != null) {
                    ceS().setVisibility(8);
                }
            } else if (ceS() != null) {
                ceS().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.ijM.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.ijM.setLayoutParams(layoutParams);
            }
        }
    }

    private int V(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.igV.serviceAreaData == null || this.igV.serviceAreaData.dataList == null || this.igV.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.hOw != null) {
            i += Math.min(this.hOw.size(), 2) * l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds83);
        }
        if (this.ijP.getVisibility() == 0) {
            i += l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.ijP.getVisibility() == 0) {
            return i + l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView ceS() {
        if (this.hHU == null || this.hHU.cbu() == null) {
            return null;
        }
        View cji = this.hHU.cbu().cji();
        if (cji instanceof LinearGradientView) {
            return (LinearGradientView) cji;
        }
        return null;
    }

    private boolean ceT() {
        return this.ijR != null && this.ijR.getVisibility() == 0;
    }

    private boolean ceU() {
        return this.ijO != null && this.ijO.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ceV() {
        if (this.hHU != null && this.igV != null) {
            List<q> showTopThreadList = this.igV.getShowTopThreadList();
            this.hOj = showTopThreadList.size() > 2;
            a(showTopThreadList, this.igV.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.ijR != null) {
            this.hOw = list;
            if (iVar != null) {
                this.ijQ = new f(this.dVN.getPageActivity());
                this.ijP.setVisibility(0);
                this.ijP.addView(this.ijQ.getView());
                this.ijQ.a(this.igV != null ? this.igV.getForum() : null, iVar);
            } else {
                this.ijP.setVisibility(8);
            }
            if (this.hHU != null && this.hHU.cbD()) {
                this.ijR.setVisibility(0);
                this.ijR.setFragmentUniqueId(this.hHU.getUniqueId());
                this.ijR.setForum(this.mForumId, this.mForumName, this.igV != null ? this.igV.getForum() : null);
                this.ijR.setDatas(list, iVar);
                if (this.hOh == null) {
                    this.hOh = new ax() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.ax
                        public void al(bv bvVar) {
                            h.a(b.this.hHU, b.this.igV, bvVar);
                        }
                    };
                }
                this.ijR.setStatListener(this.hOh);
                return;
            }
            this.ijR.setVisibility(8);
        }
    }

    private boolean ceW() {
        final x xVar;
        if (this.igV == null) {
            return false;
        }
        final FrsViewData frsViewData = this.igV;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dkv())) {
            xVar = new x();
            xVar.setLinkUrl("");
            xVar.setImageUrl(frsViewData.getStar().dkv());
        } else {
            xVar = (frsViewData.getActivityHeadData() == null || com.baidu.tbadk.core.util.x.getCount(frsViewData.getActivityHeadData().aUp()) < 1) ? null : frsViewData.getActivityHeadData().aUp().get(0);
        }
        if (xVar != null) {
            if (this.ijN != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aUq())) {
                    ap apVar = new ap("c13326");
                    apVar.dn("fid", frsViewData.getForum().getId());
                    apVar.dn("obj_id", frsViewData.getActivityHeadData().aUq());
                    TiebaStatic.log(apVar);
                    ap apVar2 = new ap("common_exp");
                    apVar2.dn("page_type", PageStayDurationConstants.PageName.FRS).ah("obj_isad", 1).ah("obj_floor", 1).dn("fid", frsViewData.getForum().getId()).dn("obj_id", frsViewData.getActivityHeadData().aUq()).ah("obj_adlocate", 1).dn("first_dir", frsViewData.getForum().getFirst_class()).dn("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        apVar.dn("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().epK);
                    }
                    com.baidu.tieba.s.c.dkh().a(this.hHU.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aUq(), "", (BaijiahaoData) null), apVar2);
                }
                this.ijN.startLoad(xVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(xVar.getLinkUrl())) {
                    this.ijN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.dVN != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aUq())) {
                                    String id = frsViewData.getForum().getId();
                                    String aUq = frsViewData.getActivityHeadData().aUq();
                                    ap apVar3 = new ap("c13330");
                                    apVar3.dn("fid", id);
                                    apVar3.dn("obj_id", aUq);
                                    TiebaStatic.log(apVar3);
                                    ap apVar4 = new ap("common_click");
                                    apVar4.dn("page_type", PageStayDurationConstants.PageName.FRS).ah("obj_isad", 1).dn("fid", id).dn("obj_id", aUq).ah("obj_adlocate", 1).ah("obj_floor", 1).dn("first_dir", frsViewData.getForum().getFirst_class()).dn("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        apVar3.dn("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().epK);
                                    }
                                    com.baidu.tieba.s.c.dkh().b(b.this.hHU.getUniqueId(), apVar4);
                                }
                                bd.baV().a(b.this.dVN, new String[]{xVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void vp(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.igV != null && (forum = this.igV.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hOi) {
                LinearGradientView ceS = ceS();
                if (this.ien != null && ceS != null) {
                    this.ien.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    ceS.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.ijN != null) {
                    this.ijN.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.ijO != null) {
                this.ijO.setThemeFontColor(com.baidu.tieba.lego.card.d.a.dU(themeElement.font_color));
            }
            if (this.ijR != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.ijR.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.dU(str));
            }
        }
    }

    protected void ceX() {
        this.ijY.startLoad(this.bGf, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.iku);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.dVN.getPageActivity());
                this.mPopup.setContentView(this.ijT);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.ijU = (TextView) this.ijT.findViewById(R.id.cur_experience);
            this.ijV = (TextView) this.ijT.findViewById(R.id.levelup_experience);
            ao.setBackgroundResource(this.ijT.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ao.setViewTextColor((TextView) this.ijT.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ao.setViewTextColor(this.ijU, R.color.common_color_10047, 1);
            ao.setViewTextColor(this.ijV, R.color.cp_cont_g, 1);
            a(this.ijU, this.ijV);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.dVN.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.dVN.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.iku, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.dVN.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            ao.setViewTextColor(textView, R.color.cp_cont_b, 1);
            ao.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            ao.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
            aVar.aV(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.ike) && !TextUtils.isEmpty(this.ike.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ike);
            } else {
                textView3.setVisibility(8);
            }
            aVar.lo(R.color.cp_link_tip_d);
            d(aVar);
            e(aVar);
            aVar.b(this.dVN);
            aVar.aYL();
        }
    }

    protected void d(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void e(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (b.this.dVN != null && b.this.dVN.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.dVN.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ceY() {
        View contentView;
        if (this.ijX == null) {
            this.ijX = new PopupWindow(this.dVN.getPageActivity());
            View inflate = LayoutInflater.from(this.dVN.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.ijX.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dVN != null && b.this.dVN.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.ijX, b.this.dVN.getPageActivity());
                        b.this.hHU.hFm = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.dVN.getPageActivity(), b.this.dVN.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.ijX.setWidth(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.ijX.setHeight(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.ijX.setBackgroundDrawable(new BitmapDrawable());
            this.ijX.setOutsideTouchable(true);
            this.ijX.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.ijX);
                        b.this.hHU.hFm = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.ijX.getContentView();
        }
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.ijW.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.ijX, this.mParent, 0, (iArr[0] - (this.ijX.getWidth() / 2)) + (this.ijW.getWidth() / 2), iArr[1] + this.ijW.getWidth());
        this.ijX.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.ikn = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.ijE != null && this.hBU != null && this.ijK != null && cashBitmap.getWidth() > 0) {
            if (this.ikn) {
                this.ijE.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cbZ = this.hHU.cbZ();
                if (cbZ != null && cbZ.getForum() != null) {
                    cbZ.getForum().setUser_level(i);
                }
                this.ijK.setText(this.dVN.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.ijE.setText(this.ikc);
                this.ijK.setText(this.dVN.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hBU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, uq(this.mLevel)));
            if (this.ikn) {
                if (f >= 1.0f) {
                    b(this.hBU, this.ikp, f);
                } else {
                    c(this.hBU, this.ikp, f);
                }
            } else {
                b(this.hBU, this.ikp, f);
            }
            this.ikp = f;
        }
    }

    private int[] uq(int i) {
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
    protected void ceZ() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cfa() {
        if (this.mMemberType != 0) {
            ao.setImageResource(this.ijW, R.drawable.icon_sml_speed_orange);
        } else {
            ao.setImageResource(this.ijW, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ijX != null && this.ijX.isShowing()) {
            this.ijX.dismiss();
        }
        if (this.ijQ != null) {
            this.ijQ.onDestroy();
        }
    }
}
