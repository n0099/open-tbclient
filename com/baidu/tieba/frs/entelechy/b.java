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
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
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
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String bNJ;
    private View guV;
    private LinearLayout ijB;
    private View ijC;
    private View ijD;
    private View ijE;
    private View ijF;
    private final View ijG;
    private final HeadImageView ijH;
    private final TextView ijI;
    private final View ijJ;
    private final ImageView ijK;
    private final TextView ijL;
    private HotRankEntryView ijM;
    private List<q> ijN;
    private TextView ijv;
    private TextView ijw;
    private az ijy;
    private boolean ijz;
    private RelativeLayout mContainer;
    private boolean ijA = false;
    private ArrayList<TbImageView> ijx = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.icq = frsFragment;
        this.ehG = frsFragment.getPageContext();
        this.iFh = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.iFi = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.iFj = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = csC();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.iFu = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.izP = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.iFv = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.iFv.setPageId(this.icq.getUniqueId());
        this.iFv.setDefaultBgResource(R.color.transparent);
        this.iFv.setDefaultResource(R.drawable.pic_frs_head_default);
        this.iFv.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.guV = this.mParent.findViewById(R.id.header_top_cover);
        this.ijB = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.ijC = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.ijD = this.mParent.findViewById(R.id.no_service_space);
        this.iFw = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.iFx = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.iFz = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.ijE = this.mParent.findViewById(R.id.frs_topview_space);
        this.ijF = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.iFA = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.iFE = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.ijv = (TextView) this.mParent.findViewById(R.id.member_image);
        this.ijw = (TextView) this.mParent.findViewById(R.id.post_image);
        this.iFm = (TextView) this.mParent.findViewById(R.id.level_name);
        this.iFs = (TextView) this.mParent.findViewById(R.id.level);
        this.iBr = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.iBr.setText(frsFragment.getResources().getString(R.string.attention));
        this.iBr.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_btn_a, R.color.cp_cont_b);
        bVar.pj(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
        bVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.po(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
        this.iBr.setConfig(bVar);
        this.iBy = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.iBy.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pq(R.color.cp_cont_b);
        bVar2.pj(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.iBy.setConfig(bVar2);
        this.iBy.setText(frsFragment.getResources().getString(R.string.sign));
        this.hWp = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hWq = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.iFk = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.iFl = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hYu = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.iFo = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.iFG = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.iFG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iFG.setPageId(this.icq.getUniqueId());
        this.iFG.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.iFG.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.iFG.setShowOval(true);
        this.iFG.setPlaceHolder(2);
        this.iFr = this.mParent.findViewById(R.id.level_container);
        this.iFq = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.iFp = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.iFt = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.ijG = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.ijI = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.ijH = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.ijH.setIsRound(true);
        this.ijH.setDrawBorder(true);
        this.ijH.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ijH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ijJ = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.ijK = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.ijL = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.bkl().a(this.ijK, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.iFB = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.iFn = LayoutInflater.from(this.icq.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.ijM = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.iFn.setVisibility(8);
        this.iFJ = new com.baidu.tieba.frs.f.b(this.ehG);
    }

    protected View csC() {
        return LayoutInflater.from(this.icq.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void A(View.OnClickListener onClickListener) {
        this.iFG.setOnClickListener(onClickListener);
        this.hYu.setOnClickListener(onClickListener);
        this.iBy.setOnClickListener(onClickListener);
        this.iBr.setOnClickListener(onClickListener);
        this.iFr.setOnClickListener(onClickListener);
        if (this.ijM != null) {
            this.ijM.setOnClickListener(onClickListener);
        }
        if (this.ijG != null) {
            this.ijG.setOnClickListener(onClickListener);
        }
        if (this.ijJ != null) {
            this.ijJ.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void csD() {
        this.iFo.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.ehG.getLayoutMode().setNightMode(i == 1);
        this.ehG.getLayoutMode().onModeChanged(this.mParent);
        this.ehG.getLayoutMode().onModeChanged(this.iFB);
        this.ehG.getLayoutMode().onModeChanged(this.iFn);
        ap.setBackgroundResource(this.hWp, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.ijC, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.iFA, R.color.cp_bg_line_b);
        ap.setBackgroundColor(this.ijE, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ijF, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hWq, R.color.cp_cont_a);
        ap.setBackgroundColor(this.iFt, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iFx, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iFz, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ijD, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hYu, R.color.cp_cont_a);
        ap.setViewTextColor(this.iFs, R.color.cp_cont_a);
        ap.setViewTextColor(this.iFm, R.color.cp_cont_a);
        ap.setViewTextColor(this.ijv, R.color.cp_cont_a);
        ap.setViewTextColor(this.iFk, R.color.cp_cont_a);
        ap.setViewTextColor(this.ijw, R.color.cp_cont_a);
        ap.setViewTextColor(this.iFl, R.color.cp_cont_a);
        ap.setViewTextColor(this.ijI, R.color.cp_cont_a);
        ap.setViewTextColor(this.ijL, R.color.cp_cont_a);
        ap.setViewTextColor(this.iFl, R.color.cp_cont_a);
        if (this.iFG != null) {
            this.iFG.setBorderWidth(l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds1));
            this.iFG.setBorderColor(ap.getColor(R.color.cp_mask_b_alpha16));
            this.iFG.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iFG.setPlaceHolder(2);
            this.iFG.invalidate();
        }
        if (this.ijH != null) {
            this.ijH.invalidate();
        }
        if (this.iFH != null) {
            this.iFH.onChangeSkin(i);
        }
        if (this.izP != null) {
            this.izP.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.ijx.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        csS();
        zJ(this.iFU ? 1 : 0);
        csH();
        yg(i);
        aa(csL(), csM());
        if (this.iFw != null) {
            this.iFw.onChangeSkinType(i);
        }
        if (this.iFz != null) {
            this.iFz.onChangeSkinType(i);
        }
        if (this.iFy != null) {
            this.iFy.onChangeSkinType(i);
        }
        if (this.ijM != null) {
            this.ijM.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bL(boolean z) {
        super.bL(z);
        if (this.iFy != null) {
            this.iFy.bL(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.iFO = forumData.getPost_num();
            this.iFL = forumData.getTag_color();
            this.bNJ = forumData.getImage_url();
            this.iFK = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.iFP = forumData.getSignData().count_sign_num;
                this.iFQ = forumData.getSignData().miss_sign_num;
            }
            this.iFR = forumData.getCurScore();
            this.iBB = forumData.getLevelupScore();
            this.iFI = forumData.getBadgeData();
            this.iFM = forumData.getAccelerateContent();
            this.iFW = forumData.isBrandForum;
            this.iCD = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.iCD != null && this.iCD.getHotUserRankData() != null && this.iCD.getHotUserRankData().hot_user != null && this.iCD.getHotUserRankData().hot_user.size() >= 3) {
                this.ijM.setVisibility(0);
                this.ijM.setData(this.iCD.getHotUserRankData(), this.ijz);
            } else {
                this.ijM.setVisibility(8);
            }
            if (this.iCD != null && this.iCD.serviceAreaData != null) {
                this.iFw.setVisibility(0);
                this.iFw.setData(this.iCD.serviceAreaData);
            } else {
                this.iFw.setVisibility(8);
            }
            this.iFN = new bw();
            csE();
            csI();
            c(forumData);
        }
    }

    private void c(ForumData forumData) {
        if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
            String str = forumData.getManagers().get(0).show_name;
            if (TextUtils.isEmpty(str)) {
                str = forumData.getManagers().get(0).name;
            }
            if (!TextUtils.isEmpty(str)) {
                this.ijI.setText(str);
                this.ijH.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.ijG.setVisibility(0);
            } else {
                this.ijG.setVisibility(8);
            }
            if (this.ijJ.getVisibility() == 0) {
                this.ijJ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.ijG.getVisibility() == 0) {
            this.ijG.setVisibility(8);
        }
        if (this.ijJ.getVisibility() == 8) {
            this.ijJ.setVisibility(0);
        }
    }

    protected void csE() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bNJ);
        this.iFN.bfH().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void csF() {
        if (this.iBO != null) {
            this.iBO.zi(this.iFQ);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void csG() {
        if (this.iBO != null) {
            this.iBO.csG();
        }
    }

    protected void csH() {
        if (this.iBP != null) {
            this.iBP.csH();
        }
    }

    protected void csI() {
        if (this.iFk != null) {
            this.iFk.setText(at.cS(this.mMemberNum));
        }
        if (this.iFl != null) {
            this.iFl.setText(at.cS(this.iFO));
        }
        if (this.iFI != null && this.iFI.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.iFW) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.ehG.getString(R.string.forum);
        if (this.bsJ != null) {
            this.bsJ.setText(str);
        }
        if (this.hYu != null) {
            this.hYu.setText(str);
        }
        csP();
        this.ijz = csO();
        if (this.ijz) {
            this.izP.setVisibility(8);
            this.guV.setVisibility(0);
        } else {
            this.guV.setVisibility(8);
            this.izP.setVisibility(0);
            this.iFv.setOnClickListener(null);
        }
        csN();
        yg(TbadkCoreApplication.getInst().getSkinType());
        csJ();
    }

    private void csJ() {
        boolean csL = csL();
        boolean csM = csM();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Ju = d.cvW().Ju(this.mForumName);
            if (Ju == null) {
                Ju = new e(this.ijA, csL);
            } else {
                Ju.pj(this.ijA);
                Ju.pk(csL);
            }
            d.cvW().a(this.mForumName, Ju);
        }
        Z(csL, csM);
        aa(csL, csM);
    }

    private void Z(boolean z, boolean z2) {
        if (this.icq.cpd() != null) {
            if (!z && !z2) {
                this.ijB.setVisibility(8);
            } else {
                this.ijB.setVisibility(0);
            }
            this.icq.cpd().ac(z, z2);
        }
    }

    private void aa(boolean z, boolean z2) {
        int dimens;
        if (this.iFu != null && this.iFu.getLayoutParams() != null) {
            if (this.ijM.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.iFt.getLayoutParams()).topMargin = l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.ehG.getPageActivity());
                ((RelativeLayout.LayoutParams) this.ijM.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.ijz) {
                dimens -= l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds80);
            } else if (this.ijz) {
                int dimens3 = l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds782);
                int ab = ab(z, z2);
                int i = dimens3 + ab;
                ((RelativeLayout.LayoutParams) this.iFv.getLayoutParams()).bottomMargin = ab;
                ((RelativeLayout.LayoutParams) this.guV.getLayoutParams()).bottomMargin = ab;
                if (ab != 0) {
                    ((RelativeLayout.LayoutParams) this.iFt.getLayoutParams()).topMargin = l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.iFt.getLayoutParams()).topMargin = l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.ijz) {
                if (csK() != null) {
                    csK().setVisibility(8);
                }
            } else if (csK() != null) {
                csK().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.iFu.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.iFu.setLayoutParams(layoutParams);
            }
        }
    }

    private int ab(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.iCD.serviceAreaData == null || this.iCD.serviceAreaData.dataList == null || this.iCD.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.ijN != null) {
            i += Math.min(this.ijN.size(), 2) * l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds83);
        }
        if (this.iFx.getVisibility() == 0) {
            i += l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.iFx.getVisibility() == 0) {
            return i + l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView csK() {
        if (this.icq == null || this.icq.cpd() == null) {
            return null;
        }
        View cxg = this.icq.cpd().cxg();
        if (cxg instanceof LinearGradientView) {
            return (LinearGradientView) cxg;
        }
        return null;
    }

    private boolean csL() {
        return this.iFz != null && this.iFz.getVisibility() == 0;
    }

    private boolean csM() {
        return this.iFw != null && this.iFw.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void csN() {
        if (this.icq != null && this.iCD != null) {
            List<q> showTopThreadList = this.iCD.getShowTopThreadList();
            this.ijA = showTopThreadList.size() > 2;
            a(showTopThreadList, this.iCD.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.iFz != null) {
            this.ijN = list;
            if (iVar != null) {
                this.iFy = new g(this.ehG.getPageActivity());
                this.iFx.setVisibility(0);
                this.iFx.addView(this.iFy.getView());
                this.iFy.a(this.iCD != null ? this.iCD.getForum() : null, iVar);
            } else {
                this.iFx.setVisibility(8);
            }
            if (this.icq != null && this.icq.cpm()) {
                this.iFz.setVisibility(0);
                this.iFz.setFragmentUniqueId(this.icq.getUniqueId());
                ForumData forum = this.iCD != null ? this.iCD.getForum() : null;
                this.iFz.setForum(this.mForumId, this.mForumName, forum);
                if (!at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum));
                }
                this.iFz.setDatas(list, iVar);
                if (this.ijy == null) {
                    this.ijy = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void am(bw bwVar) {
                            j.a(b.this.icq, b.this.iCD, bwVar);
                        }
                    };
                }
                this.iFz.setStatListener(this.ijy);
                return;
            }
            this.iFz.setVisibility(8);
        }
    }

    private boolean csO() {
        final y yVar;
        if (this.iCD == null) {
            return false;
        }
        final FrsViewData frsViewData = this.iCD;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dzR())) {
            yVar = new y();
            yVar.setLinkUrl("");
            yVar.setImageUrl(frsViewData.getStar().dzR());
        } else {
            yVar = (frsViewData.getActivityHeadData() == null || com.baidu.tbadk.core.util.y.getCount(frsViewData.getActivityHeadData().bdC()) < 1) ? null : frsViewData.getActivityHeadData().bdC().get(0);
        }
        if (yVar != null) {
            if (this.iFv != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bdD())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dF("fid", frsViewData.getForum().getId());
                    aqVar.dF("obj_id", frsViewData.getActivityHeadData().bdD());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dF("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).ai("obj_floor", 1).dF("fid", frsViewData.getForum().getId()).dF("obj_id", frsViewData.getActivityHeadData().bdD()).ai("obj_adlocate", 1).dF("first_dir", frsViewData.getForum().getFirst_class()).dF("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dF("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eCe);
                    }
                    com.baidu.tieba.s.c.dzC().a(this.icq.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().bdD(), "", (BaijiahaoData) null), aqVar2);
                }
                this.iFv.startLoad(yVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(yVar.getLinkUrl())) {
                    this.iFv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.ehG != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bdD())) {
                                    String id = frsViewData.getForum().getId();
                                    String bdD = frsViewData.getActivityHeadData().bdD();
                                    aq aqVar3 = new aq("c13330");
                                    aqVar3.dF("fid", id);
                                    aqVar3.dF("obj_id", bdD);
                                    TiebaStatic.log(aqVar3);
                                    aq aqVar4 = new aq("common_click");
                                    aqVar4.dF("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).dF("fid", id).dF("obj_id", bdD).ai("obj_adlocate", 1).ai("obj_floor", 1).dF("first_dir", frsViewData.getForum().getFirst_class()).dF("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aqVar3.dF("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eCe);
                                    }
                                    com.baidu.tieba.s.c.dzC().b(b.this.icq.getUniqueId(), aqVar4);
                                }
                                be.bkp().a(b.this.ehG, new String[]{yVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void yg(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iCD != null && (forum = this.iCD.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.ijz) {
                LinearGradientView csK = csK();
                if (this.izP != null && csK != null) {
                    this.izP.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    csK.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.iFv != null) {
                    this.iFv.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.iFw != null) {
                this.iFw.setThemeFontColor(com.baidu.tieba.lego.card.d.b.fq(themeElement.font_color));
            }
            if (this.iFz != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.iFz.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.fq(str));
            }
        }
    }

    protected void csP() {
        this.iFG.startLoad(this.bNJ, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.iGc);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.ehG.getPageActivity());
                this.mPopup.setContentView(this.iFB);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.iFC = (TextView) this.iFB.findViewById(R.id.cur_experience);
            this.iFD = (TextView) this.iFB.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.iFB.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.iFB.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ap.setViewTextColor(this.iFC, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.iFD, R.color.cp_cont_g, 1);
            a(this.iFC, this.iFD);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.ehG.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.ehG.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.iGc, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.ehG.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
            aVar.aZ(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.iFM) && !TextUtils.isEmpty(this.iFM.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.iFM);
            } else {
                textView3.setVisibility(8);
            }
            aVar.nF(R.color.cp_link_tip_d);
            d(aVar);
            e(aVar);
            aVar.b(this.ehG);
            aVar.bia();
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
                if (b.this.ehG != null && b.this.ehG.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.ehG.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void csQ() {
        View contentView;
        if (this.iFF == null) {
            this.iFF = new PopupWindow(this.ehG.getPageActivity());
            View inflate = LayoutInflater.from(this.ehG.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.iFF.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ehG != null && b.this.ehG.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iFF, b.this.ehG.getPageActivity());
                        b.this.icq.hZI = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.ehG.getPageActivity(), b.this.ehG.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.iFF.setWidth(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.iFF.setHeight(this.ehG.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.iFF.setBackgroundDrawable(new BitmapDrawable());
            this.iFF.setOutsideTouchable(true);
            this.iFF.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iFF);
                        b.this.icq.hZI = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.iFF.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.iFE.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.iFF, this.mParent, 0, (iArr[0] - (this.iFF.getWidth() / 2)) + (this.iFE.getWidth() / 2), iArr[1] + this.iFE.getWidth());
        this.iFF.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.iFV = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.iFm != null && this.hWp != null && this.iFs != null && cashBitmap.getWidth() > 0) {
            if (this.iFV) {
                this.iFm.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cpJ = this.icq.cpJ();
                if (cpJ != null && cpJ.getForum() != null) {
                    cpJ.getForum().setUser_level(i);
                }
                this.iFs.setText(this.ehG.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.iFm.setText(this.iFK);
                this.iFs.setText(this.ehG.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hWp.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, xe(this.mLevel)));
            if (this.iFV) {
                if (f >= 1.0f) {
                    b(this.hWp, this.iFX, f);
                } else {
                    c(this.hWp, this.iFX, f);
                }
            } else {
                b(this.hWp, this.iFX, f);
            }
            this.iFX = f;
        }
    }

    private int[] xe(int i) {
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
    protected void csR() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void csS() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iFE, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.iFE, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iFF != null && this.iFF.isShowing()) {
            this.iFF.dismiss();
        }
        if (this.iFy != null) {
            this.iFy.onDestroy();
        }
    }
}
