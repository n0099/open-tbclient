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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.g;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.e.d;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.frs.f.j;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String ciC;
    private View hbj;
    private TextView iQL;
    private TextView iQM;
    private az iQO;
    private boolean iQP;
    private LinearLayout iQR;
    private View iQS;
    private View iQT;
    private View iQU;
    private View iQV;
    private final View iQW;
    private final HeadImageView iQX;
    private final TextView iQY;
    private final View iQZ;
    private final ImageView iRa;
    private final TextView iRb;
    private HotRankEntryView iRc;
    private List<q> iRd;
    private RelativeLayout mContainer;
    private boolean iQQ = false;
    private ArrayList<TbImageView> iQN = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.iJK = frsFragment;
        this.eIc = frsFragment.getPageContext();
        this.jms = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jmt = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jmu = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cBH();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jmF = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jhb = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jmG = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jmG.setPageId(this.iJK.getUniqueId());
        this.jmG.setDefaultBgResource(R.color.transparent);
        this.jmG.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jmG.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.hbj = this.mParent.findViewById(R.id.header_top_cover);
        this.iQR = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.iQS = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.iQT = this.mParent.findViewById(R.id.no_service_space);
        this.jmH = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jmI = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jmK = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.iQU = this.mParent.findViewById(R.id.frs_topview_space);
        this.iQV = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jmL = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jmP = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.iQL = (TextView) this.mParent.findViewById(R.id.member_image);
        this.iQM = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jmx = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jmD = (TextView) this.mParent.findViewById(R.id.level);
        this.jiB = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jiB.setText(frsFragment.getResources().getString(R.string.attention));
        this.jiB.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_btn_a, R.color.cp_cont_b);
        bVar.qd(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
        bVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.qh(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
        this.jiB.setConfig(bVar);
        this.jiI = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jiI.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.qj(R.color.cp_cont_b);
        bVar2.qd(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jiI.setConfig(bVar2);
        this.jiI.setText(frsFragment.getResources().getString(R.string.sign));
        this.iDJ = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.iDK = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jmv = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jmw = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.iFO = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jmz = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jmR = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jmR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jmR.setPageId(this.iJK.getUniqueId());
        this.jmR.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jmR.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jmR.setShowOval(true);
        this.jmR.setPlaceHolder(2);
        this.jmC = this.mParent.findViewById(R.id.level_container);
        this.jmB = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jmA = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jmE = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.iQW = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.iQY = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.iQX = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.iQX.setIsRound(true);
        this.iQX.setDrawBorder(true);
        this.iQX.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iQX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iQZ = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.iRa = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.iRb = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.brn().a(this.iRa, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jmM = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jmy = LayoutInflater.from(this.iJK.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.iRc = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jmy.setVisibility(8);
        this.jmU = new com.baidu.tieba.frs.f.b(this.eIc);
    }

    protected View cBH() {
        return LayoutInflater.from(this.iJK.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void B(View.OnClickListener onClickListener) {
        this.jmR.setOnClickListener(onClickListener);
        this.iFO.setOnClickListener(onClickListener);
        this.jiI.setOnClickListener(onClickListener);
        this.jiB.setOnClickListener(onClickListener);
        this.jmC.setOnClickListener(onClickListener);
        if (this.iRc != null) {
            this.iRc.setOnClickListener(onClickListener);
        }
        if (this.iQW != null) {
            this.iQW.setOnClickListener(onClickListener);
        }
        if (this.iQZ != null) {
            this.iQZ.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBI() {
        this.jmz.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eIc.getLayoutMode().setNightMode(i == 1);
        this.eIc.getLayoutMode().onModeChanged(this.mParent);
        this.eIc.getLayoutMode().onModeChanged(this.jmM);
        this.eIc.getLayoutMode().onModeChanged(this.jmy);
        ap.setBackgroundResource(this.iDJ, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.iQS, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.jmL, R.color.cp_bg_line_b);
        ap.setBackgroundColor(this.iQU, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iQV, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iDK, R.color.cp_cont_a);
        ap.setBackgroundColor(this.jmE, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jmI, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.jmK, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iQT, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.iFO, R.color.cp_cont_a);
        ap.setViewTextColor(this.jmD, R.color.cp_cont_a);
        ap.setViewTextColor(this.jmx, R.color.cp_cont_a);
        ap.setViewTextColor(this.iQL, R.color.cp_cont_a);
        ap.setViewTextColor(this.jmv, R.color.cp_cont_a);
        ap.setViewTextColor(this.iQM, R.color.cp_cont_a);
        ap.setViewTextColor(this.jmw, R.color.cp_cont_a);
        ap.setViewTextColor(this.iQY, R.color.cp_cont_a);
        ap.setViewTextColor(this.iRb, R.color.cp_cont_a);
        ap.setViewTextColor(this.jmw, R.color.cp_cont_a);
        if (this.jmR != null) {
            this.jmR.setBorderWidth(l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds1));
            this.jmR.setBorderColor(ap.getColor(R.color.cp_mask_b_alpha16));
            this.jmR.setStrokeColorResId(R.color.cp_bg_line_d);
            this.jmR.setPlaceHolder(2);
            this.jmR.invalidate();
        }
        if (this.iQX != null) {
            this.iQX.invalidate();
        }
        if (this.jmS != null) {
            this.jmS.onChangeSkin(i);
        }
        if (this.jhb != null) {
            this.jhb.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.iQN.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cBX();
        AV(this.jnf ? 1 : 0);
        cBM();
        zs(i);
        ac(cBQ(), cBR());
        if (this.jmH != null) {
            this.jmH.onChangeSkinType(i);
        }
        if (this.jmK != null) {
            this.jmK.onChangeSkinType(i);
        }
        if (this.jmJ != null) {
            this.jmJ.onChangeSkinType(i);
        }
        if (this.iRc != null) {
            this.iRc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bQ(boolean z) {
        super.bQ(z);
        if (this.jmJ != null) {
            this.jmJ.bQ(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jmZ = forumData.getPost_num();
            this.jmW = forumData.getTag_color();
            this.ciC = forumData.getImage_url();
            this.jmV = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jna = forumData.getSignData().count_sign_num;
                this.jnb = forumData.getSignData().miss_sign_num;
            }
            this.jnc = forumData.getCurScore();
            this.jiL = forumData.getLevelupScore();
            this.jmT = forumData.getBadgeData();
            this.jmX = forumData.getAccelerateContent();
            this.jnh = forumData.isBrandForum;
            this.jjN = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jjN != null && this.jjN.getHotUserRankData() != null && this.jjN.getHotUserRankData().hot_user != null && this.jjN.getHotUserRankData().hot_user.size() >= 3) {
                this.iRc.setVisibility(0);
                this.iRc.setData(this.jjN.getHotUserRankData(), this.iQP);
            } else {
                this.iRc.setVisibility(8);
            }
            if (this.jjN != null && this.jjN.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bHs()) {
                this.jmH.setVisibility(0);
                this.jmH.setData(this.jjN.serviceAreaData);
            } else {
                this.jmH.setVisibility(8);
            }
            this.jmY = new bw();
            cBJ();
            cBN();
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
                this.iQY.setText(str);
                this.iQX.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.iQW.setVisibility(0);
            } else {
                this.iQW.setVisibility(8);
            }
            if (this.iQZ.getVisibility() == 0) {
                this.iQZ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iQW.getVisibility() == 0) {
            this.iQW.setVisibility(8);
        }
        if (this.iQZ.getVisibility() == 8) {
            this.iQZ.setVisibility(0);
        }
    }

    protected void cBJ() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.ciC);
        this.jmY.bmJ().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cBK() {
        if (this.jiY != null) {
            this.jiY.Au(this.jnb);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cBL() {
        if (this.jiY != null) {
            this.jiY.cBL();
        }
    }

    protected void cBM() {
        if (this.jiZ != null) {
            this.jiZ.cBM();
        }
    }

    protected void cBN() {
        if (this.jmv != null) {
            this.jmv.setText(at.dy(this.mMemberNum));
        }
        if (this.jmw != null) {
            this.jmw.setText(at.dy(this.jmZ));
        }
        if (this.jmT != null && this.jmT.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jnh) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eIc.getString(R.string.forum);
        if (this.bEW != null) {
            this.bEW.setText(str);
        }
        if (this.iFO != null) {
            this.iFO.setText(str);
        }
        cBU();
        this.iQP = cBT();
        if (this.iQP) {
            this.jhb.setVisibility(8);
            this.hbj.setVisibility(0);
        } else {
            this.hbj.setVisibility(8);
            this.jhb.setVisibility(0);
            this.jmG.setOnClickListener(null);
        }
        cBS();
        zs(TbadkCoreApplication.getInst().getSkinType());
        cBO();
    }

    private void cBO() {
        boolean cBQ = cBQ();
        boolean cBR = cBR();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e KX = d.cFb().KX(this.mForumName);
            if (KX == null) {
                KX = new e(this.iQQ, cBQ);
            } else {
                KX.qp(this.iQQ);
                KX.qq(cBQ);
            }
            d.cFb().a(this.mForumName, KX);
        }
        ab(cBQ, cBR);
        ac(cBQ, cBR);
    }

    private void ab(boolean z, boolean z2) {
        if (this.iJK.cyj() != null) {
            if (!z && !z2) {
                this.iQR.setVisibility(8);
            } else {
                this.iQR.setVisibility(0);
            }
            this.iJK.cyj().ae(z, z2);
        }
    }

    private void ac(boolean z, boolean z2) {
        int dimens;
        if (this.jmF != null && this.jmF.getLayoutParams() != null) {
            if (this.iRc.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jmE.getLayoutParams()).topMargin = l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eIc.getPageActivity());
                ((RelativeLayout.LayoutParams) this.iRc.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.iQP) {
                dimens -= l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds80);
            } else if (this.iQP) {
                int dimens3 = l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds782);
                int ad = ad(z, z2);
                int i = dimens3 + ad;
                ((RelativeLayout.LayoutParams) this.jmG.getLayoutParams()).bottomMargin = ad;
                ((RelativeLayout.LayoutParams) this.hbj.getLayoutParams()).bottomMargin = ad;
                if (ad != 0) {
                    ((RelativeLayout.LayoutParams) this.jmE.getLayoutParams()).topMargin = l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jmE.getLayoutParams()).topMargin = l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.iQP) {
                if (cBP() != null) {
                    cBP().setVisibility(8);
                }
            } else if (cBP() != null) {
                cBP().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.jmF.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jmF.setLayoutParams(layoutParams);
            }
        }
    }

    private int ad(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jjN.serviceAreaData == null || this.jjN.serviceAreaData.dataList == null || this.jjN.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.iRd != null) {
            i += Math.min(this.iRd.size(), 2) * l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jmI.getVisibility() == 0) {
            i += l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jmI.getVisibility() == 0) {
            return i + l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cBP() {
        if (this.iJK == null || this.iJK.cyj() == null) {
            return null;
        }
        View cGl = this.iJK.cyj().cGl();
        if (cGl instanceof LinearGradientView) {
            return (LinearGradientView) cGl;
        }
        return null;
    }

    private boolean cBQ() {
        return this.jmK != null && this.jmK.getVisibility() == 0;
    }

    private boolean cBR() {
        return this.jmH != null && this.jmH.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBS() {
        if (this.iJK != null && this.jjN != null) {
            List<q> showTopThreadList = this.jjN.getShowTopThreadList();
            this.iQQ = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jjN.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.jmK != null) {
            this.iRd = list;
            if (iVar != null) {
                this.jmJ = new g(this.eIc.getPageActivity());
                this.jmI.setVisibility(0);
                this.jmI.addView(this.jmJ.getView());
                this.jmJ.a(this.jjN != null ? this.jjN.getForum() : null, iVar);
            } else {
                this.jmI.setVisibility(8);
            }
            if (this.iJK != null && this.iJK.cys()) {
                this.jmK.setVisibility(0);
                this.jmK.setFragmentUniqueId(this.iJK.getUniqueId());
                ForumData forum = this.jjN != null ? this.jjN.getForum() : null;
                this.jmK.setForum(this.mForumId, this.mForumName, forum);
                if (forum != null && !at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !y.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                this.jmK.setDatas(list, iVar);
                if (this.iQO == null) {
                    this.iQO = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void am(bw bwVar) {
                            j.a(b.this.iJK, b.this.jjN, bwVar);
                        }
                    };
                }
                this.jmK.setStatListener(this.iQO);
                return;
            }
            this.jmK.setVisibility(8);
        }
    }

    private boolean cBT() {
        final com.baidu.tbadk.core.data.y yVar;
        if (this.jjN == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jjN;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dJm())) {
            yVar = new com.baidu.tbadk.core.data.y();
            yVar.setLinkUrl("");
            yVar.setImageUrl(frsViewData.getStar().dJm());
        } else {
            yVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().bkE()) < 1) ? null : frsViewData.getActivityHeadData().bkE().get(0);
        }
        if (yVar != null) {
            if (this.jmG != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bkF())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dR("fid", frsViewData.getForum().getId());
                    aqVar.dR("obj_id", frsViewData.getActivityHeadData().bkF());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dR("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).al("obj_floor", 1).dR("fid", frsViewData.getForum().getId()).dR("obj_id", frsViewData.getActivityHeadData().bkF()).al("obj_adlocate", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fcx);
                    }
                    com.baidu.tieba.s.c.dIX().a(this.iJK.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().bkF(), "", (BaijiahaoData) null), aqVar2);
                }
                this.jmG.startLoad(yVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(yVar.getLinkUrl())) {
                    this.jmG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eIc != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bkF())) {
                                    String id = frsViewData.getForum().getId();
                                    String bkF = frsViewData.getActivityHeadData().bkF();
                                    aq aqVar3 = new aq("c13330");
                                    aqVar3.dR("fid", id);
                                    aqVar3.dR("obj_id", bkF);
                                    TiebaStatic.log(aqVar3);
                                    aq aqVar4 = new aq("common_click");
                                    aqVar4.dR("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).dR("fid", id).dR("obj_id", bkF).al("obj_adlocate", 1).al("obj_floor", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aqVar3.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fcx);
                                    }
                                    com.baidu.tieba.s.c.dIX().b(b.this.iJK.getUniqueId(), aqVar4);
                                }
                                be.brr().a(b.this.eIc, new String[]{yVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void zs(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jjN != null && (forum = this.jjN.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iQP) {
                LinearGradientView cBP = cBP();
                if (this.jhb != null && cBP != null) {
                    this.jhb.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    cBP.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jmG != null) {
                    this.jmG.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jmH != null) {
                this.jmH.setThemeFontColor(com.baidu.tieba.lego.card.d.b.fv(themeElement.font_color));
            }
            if (this.jmK != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.jmK.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.fv(str));
            }
        }
    }

    protected void cBU() {
        this.jmR.startLoad(this.ciC, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jnn);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eIc.getPageActivity());
                this.mPopup.setContentView(this.jmM);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jmN = (TextView) this.jmM.findViewById(R.id.cur_experience);
            this.jmO = (TextView) this.jmM.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jmM.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jmM.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ap.setViewTextColor(this.jmN, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jmO, R.color.cp_cont_g, 1);
            a(this.jmN, this.jmO);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eIc.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eIc.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jnn, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eIc.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
            aVar.bf(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jmX) && !TextUtils.isEmpty(this.jmX.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jmX);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ox(R.color.cp_link_tip_d);
            d(aVar);
            e(aVar);
            aVar.b(this.eIc);
            aVar.bpc();
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
                if (b.this.eIc != null && b.this.eIc.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eIc.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBV() {
        View contentView;
        if (this.jmQ == null) {
            this.jmQ = new PopupWindow(this.eIc.getPageActivity());
            View inflate = LayoutInflater.from(this.eIc.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jmQ.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eIc != null && b.this.eIc.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jmQ, b.this.eIc.getPageActivity());
                        b.this.iJK.iHc = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eIc.getPageActivity(), b.this.eIc.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jmQ.setWidth(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jmQ.setHeight(this.eIc.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jmQ.setBackgroundDrawable(new BitmapDrawable());
            this.jmQ.setOutsideTouchable(true);
            this.jmQ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jmQ);
                        b.this.iJK.iHc = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jmQ.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.jmP.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jmQ, this.mParent, 0, (iArr[0] - (this.jmQ.getWidth() / 2)) + (this.jmP.getWidth() / 2), iArr[1] + this.jmP.getWidth());
        this.jmQ.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jng = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jmx != null && this.iDJ != null && this.jmD != null && cashBitmap.getWidth() > 0) {
            if (this.jng) {
                this.jmx.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cyP = this.iJK.cyP();
                if (cyP != null && cyP.getForum() != null) {
                    cyP.getForum().setUser_level(i);
                }
                this.jmD.setText(this.eIc.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jmx.setText(this.jmV);
                this.jmD.setText(this.eIc.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.iDJ.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yq(this.mLevel)));
            if (this.jng) {
                if (f >= 1.0f) {
                    b(this.iDJ, this.jni, f);
                } else {
                    c(this.iDJ, this.jni, f);
                }
            } else {
                b(this.iDJ, this.jni, f);
            }
            this.jni = f;
        }
    }

    private int[] yq(int i) {
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
    protected void cBW() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBX() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jmP, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jmP, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jmQ != null && this.jmQ.isShowing()) {
            this.jmQ.dismiss();
        }
        if (this.jmJ != null) {
            this.jmJ.onDestroy();
        }
    }
}
