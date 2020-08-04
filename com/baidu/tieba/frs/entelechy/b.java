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
import com.baidu.tieba.frs.ad.g;
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
    private TextView hOg;
    private TextView hOh;
    private ax hOj;
    private boolean hOk;
    private LinearLayout hOm;
    private View hOn;
    private View hOo;
    private View hOp;
    private View hOq;
    private final View hOr;
    private final HeadImageView hOs;
    private final TextView hOt;
    private final View hOu;
    private final ImageView hOv;
    private final TextView hOw;
    private HotRankEntryView hOx;
    private List<q> hOy;
    private RelativeLayout mContainer;
    private boolean hOl = false;
    private ArrayList<TbImageView> hOi = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hHU = frsFragment;
        this.dVN = frsFragment.getPageContext();
        this.ijB = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.ijC = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.ijD = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = ceK();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.ijO = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.iep = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.ijP = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.ijP.setPageId(this.hHU.getUniqueId());
        this.ijP.setDefaultBgResource(R.color.transparent);
        this.ijP.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ijP.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.gfn = this.mParent.findViewById(R.id.header_top_cover);
        this.hOm = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.hOn = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.hOo = this.mParent.findViewById(R.id.no_service_space);
        this.ijQ = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.ijR = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.ijT = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.hOp = this.mParent.findViewById(R.id.frs_topview_space);
        this.hOq = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.ijU = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.ijY = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.hOg = (TextView) this.mParent.findViewById(R.id.member_image);
        this.hOh = (TextView) this.mParent.findViewById(R.id.post_image);
        this.ijG = (TextView) this.mParent.findViewById(R.id.level_name);
        this.ijM = (TextView) this.mParent.findViewById(R.id.level);
        this.ifL = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.ifL.setText(frsFragment.getResources().getString(R.string.attention));
        this.ifL.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mW(R.color.cp_cont_b);
        this.ifL.setConfig(cVar);
        this.ifS = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.ifS.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.mW(R.color.cp_cont_b);
        cVar2.mR(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.ifS.setConfig(cVar2);
        this.ifS.setText(frsFragment.getResources().getString(R.string.sign));
        this.hBU = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hBV = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.ijE = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.ijF = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hEa = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.ijI = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.ika = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.ika.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ika.setPageId(this.hHU.getUniqueId());
        this.ika.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.ika.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.ika.setShowOval(true);
        this.ika.setPlaceHolder(2);
        this.ijL = this.mParent.findViewById(R.id.level_container);
        this.ijK = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.ijJ = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.ijN = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.hOr = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.hOt = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.hOs = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.hOs.setIsRound(true);
        this.hOs.setDrawBorder(true);
        this.hOs.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hOs.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hOu = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.hOv = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.hOw = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.baR().a(this.hOv, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.ijV = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.ijH = LayoutInflater.from(this.hHU.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.hOx = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.ijH.setVisibility(8);
        this.ikd = new com.baidu.tieba.frs.f.b(this.dVN);
    }

    protected View ceK() {
        return LayoutInflater.from(this.hHU.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void z(View.OnClickListener onClickListener) {
        this.ika.setOnClickListener(onClickListener);
        this.hEa.setOnClickListener(onClickListener);
        this.ifS.setOnClickListener(onClickListener);
        this.ifL.setOnClickListener(onClickListener);
        this.ijL.setOnClickListener(onClickListener);
        if (this.hOx != null) {
            this.hOx.setOnClickListener(onClickListener);
        }
        if (this.hOr != null) {
            this.hOr.setOnClickListener(onClickListener);
        }
        if (this.hOu != null) {
            this.hOu.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ceL() {
        this.ijI.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.dVN.getLayoutMode().setNightMode(i == 1);
        this.dVN.getLayoutMode().onModeChanged(this.mParent);
        this.dVN.getLayoutMode().onModeChanged(this.ijV);
        this.dVN.getLayoutMode().onModeChanged(this.ijH);
        ao.setBackgroundResource(this.hBU, R.drawable.frs_exp_progress);
        ao.setBackgroundResource(this.hOn, R.drawable.bg_frs_header_round_corner);
        ao.setBackgroundColor(this.ijU, R.color.cp_bg_line_b);
        ao.setBackgroundColor(this.hOp, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hOq, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hBV, R.color.cp_cont_a);
        ao.setBackgroundColor(this.ijN, R.color.black_alpha0);
        ao.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.ijR, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.ijT, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.hOo, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.hEa, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijM, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijG, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOg, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijE, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOh, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijF, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOt, R.color.cp_cont_a);
        ao.setViewTextColor(this.hOw, R.color.cp_cont_a);
        ao.setViewTextColor(this.ijF, R.color.cp_cont_a);
        if (this.ika != null) {
            this.ika.setBorderWidth(l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds1));
            this.ika.setBorderColor(ao.getColor(R.color.cp_mask_b_alpha16));
            this.ika.setStrokeColorResId(R.color.cp_bg_line_d);
            this.ika.setPlaceHolder(2);
            this.ika.invalidate();
        }
        if (this.hOs != null) {
            this.hOs.invalidate();
        }
        if (this.ikb != null) {
            this.ikb.onChangeSkin(i);
        }
        if (this.iep != null) {
            this.iep.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.hOi.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cfa();
        wR(this.iko ? 1 : 0);
        ceP();
        vp(i);
        U(ceT(), ceU());
        if (this.ijQ != null) {
            this.ijQ.onChangeSkinType(i);
        }
        if (this.ijT != null) {
            this.ijT.onChangeSkinType(i);
        }
        if (this.ijS != null) {
            this.ijS.onChangeSkinType(i);
        }
        if (this.hOx != null) {
            this.hOx.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bE(boolean z) {
        super.bE(z);
        if (this.ijS != null) {
            this.ijS.bE(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.iki = forumData.getPost_num();
            this.ikf = forumData.getTag_color();
            this.bGf = forumData.getImage_url();
            this.ike = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.ikj = forumData.getSignData().count_sign_num;
                this.ikk = forumData.getSignData().miss_sign_num;
            }
            this.ikl = forumData.getCurScore();
            this.ifV = forumData.getLevelupScore();
            this.ikc = forumData.getBadgeData();
            this.ikg = forumData.getAccelerateContent();
            this.ikq = forumData.isBrandForum;
            this.igX = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.igX != null && this.igX.getHotUserRankData() != null && this.igX.getHotUserRankData().hot_user != null && this.igX.getHotUserRankData().hot_user.size() >= 3) {
                this.hOx.setVisibility(0);
                this.hOx.setData(this.igX.getHotUserRankData(), this.hOk);
            } else {
                this.hOx.setVisibility(8);
            }
            if (this.igX != null && this.igX.serviceAreaData != null) {
                this.ijQ.setVisibility(0);
                this.ijQ.setData(this.igX.serviceAreaData);
            } else {
                this.ijQ.setVisibility(8);
            }
            this.ikh = new bv();
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
                this.hOt.setText(str);
                this.hOs.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.hOr.setVisibility(0);
            } else {
                this.hOr.setVisibility(8);
            }
            if (this.hOu.getVisibility() == 0) {
                this.hOu.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hOr.getVisibility() == 0) {
            this.hOr.setVisibility(8);
        }
        if (this.hOu.getVisibility() == 8) {
            this.hOu.setVisibility(0);
        }
    }

    protected void ceM() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bGf);
        this.ikh.aWu().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void ceN() {
        if (this.igi != null) {
            this.igi.wq(this.ikk);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void ceO() {
        if (this.igi != null) {
            this.igi.ceO();
        }
    }

    protected void ceP() {
        if (this.igj != null) {
            this.igj.ceP();
        }
    }

    protected void ceQ() {
        if (this.ijE != null) {
            this.ijE.setText(as.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.ijF != null) {
            this.ijF.setText(as.numberUniformFormatExtra(this.iki));
        }
        if (this.ikc != null && this.ikc.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.ikq) {
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
        this.hOk = ceW();
        if (this.hOk) {
            this.iep.setVisibility(8);
            this.gfn.setVisibility(0);
        } else {
            this.gfn.setVisibility(8);
            this.iep.setVisibility(0);
            this.ijP.setOnClickListener(null);
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
                Gt = new e(this.hOl, ceT);
            } else {
                Gt.ox(this.hOl);
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
                this.hOm.setVisibility(8);
            } else {
                this.hOm.setVisibility(0);
            }
            this.hHU.cbu().W(z, z2);
        }
    }

    private void U(boolean z, boolean z2) {
        int dimens;
        if (this.ijO != null && this.ijO.getLayoutParams() != null) {
            if (this.hOx.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.ijN.getLayoutParams()).topMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.dVN.getPageActivity());
                ((RelativeLayout.LayoutParams) this.hOx.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.hOk) {
                dimens -= l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds80);
            } else if (this.hOk) {
                int dimens3 = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds782);
                int V = V(z, z2);
                int i = dimens3 + V;
                ((RelativeLayout.LayoutParams) this.ijP.getLayoutParams()).bottomMargin = V;
                ((RelativeLayout.LayoutParams) this.gfn.getLayoutParams()).bottomMargin = V;
                if (V != 0) {
                    ((RelativeLayout.LayoutParams) this.ijN.getLayoutParams()).topMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.ijN.getLayoutParams()).topMargin = l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.hOk) {
                if (ceS() != null) {
                    ceS().setVisibility(8);
                }
            } else if (ceS() != null) {
                ceS().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.ijO.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.ijO.setLayoutParams(layoutParams);
            }
        }
    }

    private int V(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.igX.serviceAreaData == null || this.igX.serviceAreaData.dataList == null || this.igX.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.hOy != null) {
            i += Math.min(this.hOy.size(), 2) * l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds83);
        }
        if (this.ijR.getVisibility() == 0) {
            i += l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.ijR.getVisibility() == 0) {
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
        return this.ijT != null && this.ijT.getVisibility() == 0;
    }

    private boolean ceU() {
        return this.ijQ != null && this.ijQ.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ceV() {
        if (this.hHU != null && this.igX != null) {
            List<q> showTopThreadList = this.igX.getShowTopThreadList();
            this.hOl = showTopThreadList.size() > 2;
            a(showTopThreadList, this.igX.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.ijT != null) {
            this.hOy = list;
            if (iVar != null) {
                this.ijS = new g(this.dVN.getPageActivity());
                this.ijR.setVisibility(0);
                this.ijR.addView(this.ijS.getView());
                this.ijS.a(this.igX != null ? this.igX.getForum() : null, iVar);
            } else {
                this.ijR.setVisibility(8);
            }
            if (this.hHU != null && this.hHU.cbD()) {
                this.ijT.setVisibility(0);
                this.ijT.setFragmentUniqueId(this.hHU.getUniqueId());
                this.ijT.setForum(this.mForumId, this.mForumName, this.igX != null ? this.igX.getForum() : null);
                this.ijT.setDatas(list, iVar);
                if (this.hOj == null) {
                    this.hOj = new ax() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.ax
                        public void al(bv bvVar) {
                            h.a(b.this.hHU, b.this.igX, bvVar);
                        }
                    };
                }
                this.ijT.setStatListener(this.hOj);
                return;
            }
            this.ijT.setVisibility(8);
        }
    }

    private boolean ceW() {
        final x xVar;
        if (this.igX == null) {
            return false;
        }
        final FrsViewData frsViewData = this.igX;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dkw())) {
            xVar = new x();
            xVar.setLinkUrl("");
            xVar.setImageUrl(frsViewData.getStar().dkw());
        } else {
            xVar = (frsViewData.getActivityHeadData() == null || com.baidu.tbadk.core.util.x.getCount(frsViewData.getActivityHeadData().aUp()) < 1) ? null : frsViewData.getActivityHeadData().aUp().get(0);
        }
        if (xVar != null) {
            if (this.ijP != null) {
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
                this.ijP.startLoad(xVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(xVar.getLinkUrl())) {
                    this.ijP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
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
        if (this.igX != null && (forum = this.igX.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hOk) {
                LinearGradientView ceS = ceS();
                if (this.iep != null && ceS != null) {
                    this.iep.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    ceS.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.ijP != null) {
                    this.ijP.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.ijQ != null) {
                this.ijQ.setThemeFontColor(com.baidu.tieba.lego.card.d.a.dU(themeElement.font_color));
            }
            if (this.ijT != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.ijT.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.dU(str));
            }
        }
    }

    protected void ceX() {
        this.ika.startLoad(this.bGf, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.ikw);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.dVN.getPageActivity());
                this.mPopup.setContentView(this.ijV);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.ijW = (TextView) this.ijV.findViewById(R.id.cur_experience);
            this.ijX = (TextView) this.ijV.findViewById(R.id.levelup_experience);
            ao.setBackgroundResource(this.ijV.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ao.setViewTextColor((TextView) this.ijV.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ao.setViewTextColor(this.ijW, R.color.common_color_10047, 1);
            ao.setViewTextColor(this.ijX, R.color.cp_cont_g, 1);
            a(this.ijW, this.ijX);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.dVN.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.dVN.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.ikw, 2000L);
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
            if (!TextUtils.isEmpty(this.ikg) && !TextUtils.isEmpty(this.ikg.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ikg);
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
        if (this.ijZ == null) {
            this.ijZ = new PopupWindow(this.dVN.getPageActivity());
            View inflate = LayoutInflater.from(this.dVN.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.ijZ.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dVN != null && b.this.dVN.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.ijZ, b.this.dVN.getPageActivity());
                        b.this.hHU.hFm = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.dVN.getPageActivity(), b.this.dVN.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.ijZ.setWidth(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.ijZ.setHeight(this.dVN.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.ijZ.setBackgroundDrawable(new BitmapDrawable());
            this.ijZ.setOutsideTouchable(true);
            this.ijZ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.ijZ);
                        b.this.hHU.hFm = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.ijZ.getContentView();
        }
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.ijY.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.ijZ, this.mParent, 0, (iArr[0] - (this.ijZ.getWidth() / 2)) + (this.ijY.getWidth() / 2), iArr[1] + this.ijY.getWidth());
        this.ijZ.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.ikp = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.ijG != null && this.hBU != null && this.ijM != null && cashBitmap.getWidth() > 0) {
            if (this.ikp) {
                this.ijG.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cbZ = this.hHU.cbZ();
                if (cbZ != null && cbZ.getForum() != null) {
                    cbZ.getForum().setUser_level(i);
                }
                this.ijM.setText(this.dVN.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.ijG.setText(this.ike);
                this.ijM.setText(this.dVN.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hBU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, uq(this.mLevel)));
            if (this.ikp) {
                if (f >= 1.0f) {
                    b(this.hBU, this.ikr, f);
                } else {
                    c(this.hBU, this.ikr, f);
                }
            } else {
                b(this.hBU, this.ikr, f);
            }
            this.ikr = f;
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
            ao.setImageResource(this.ijY, R.drawable.icon_sml_speed_orange);
        } else {
            ao.setImageResource(this.ijY, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ijZ != null && this.ijZ.isShowing()) {
            this.ijZ.dismiss();
        }
        if (this.ijS != null) {
            this.ijS.onDestroy();
        }
    }
}
