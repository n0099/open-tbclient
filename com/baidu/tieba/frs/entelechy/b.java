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
    private String ccQ;
    private View gVf;
    private TextView iKO;
    private TextView iKP;
    private az iKR;
    private boolean iKS;
    private LinearLayout iKU;
    private View iKV;
    private View iKW;
    private View iKX;
    private View iKY;
    private final View iKZ;
    private final HeadImageView iLa;
    private final TextView iLb;
    private final View iLc;
    private final ImageView iLd;
    private final TextView iLe;
    private HotRankEntryView iLf;
    private List<q> iLg;
    private RelativeLayout mContainer;
    private boolean iKT = false;
    private ArrayList<TbImageView> iKQ = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.iDN = frsFragment;
        this.eCn = frsFragment.getPageContext();
        this.jgt = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jgu = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jgv = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = czg();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jgG = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jbe = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jgH = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jgH.setPageId(this.iDN.getUniqueId());
        this.jgH.setDefaultBgResource(R.color.transparent);
        this.jgH.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jgH.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.gVf = this.mParent.findViewById(R.id.header_top_cover);
        this.iKU = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.iKV = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.iKW = this.mParent.findViewById(R.id.no_service_space);
        this.jgI = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jgJ = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jgL = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.iKX = this.mParent.findViewById(R.id.frs_topview_space);
        this.iKY = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jgM = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jgQ = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.iKO = (TextView) this.mParent.findViewById(R.id.member_image);
        this.iKP = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jgy = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jgE = (TextView) this.mParent.findViewById(R.id.level);
        this.jcD = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jcD.setText(frsFragment.getResources().getString(R.string.attention));
        this.jcD.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_btn_a, R.color.cp_cont_b);
        bVar.pT(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
        bVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pX(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
        this.jcD.setConfig(bVar);
        this.jcK = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jcK.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pZ(R.color.cp_cont_b);
        bVar2.pT(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.jcK.setConfig(bVar2);
        this.jcK.setText(frsFragment.getResources().getString(R.string.sign));
        this.ixM = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.ixN = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jgw = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jgx = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.izR = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jgA = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jgS = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jgS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jgS.setPageId(this.iDN.getUniqueId());
        this.jgS.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jgS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jgS.setShowOval(true);
        this.jgS.setPlaceHolder(2);
        this.jgD = this.mParent.findViewById(R.id.level_container);
        this.jgC = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jgB = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jgF = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.iKZ = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.iLb = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.iLa = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.iLa.setIsRound(true);
        this.iLa.setDrawBorder(true);
        this.iLa.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iLa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iLc = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.iLd = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.iLe = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.boN().a(this.iLd, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.jgN = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jgz = LayoutInflater.from(this.iDN.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.iLf = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jgz.setVisibility(8);
        this.jgV = new com.baidu.tieba.frs.f.b(this.eCn);
    }

    protected View czg() {
        return LayoutInflater.from(this.iDN.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void A(View.OnClickListener onClickListener) {
        this.jgS.setOnClickListener(onClickListener);
        this.izR.setOnClickListener(onClickListener);
        this.jcK.setOnClickListener(onClickListener);
        this.jcD.setOnClickListener(onClickListener);
        this.jgD.setOnClickListener(onClickListener);
        if (this.iLf != null) {
            this.iLf.setOnClickListener(onClickListener);
        }
        if (this.iKZ != null) {
            this.iKZ.setOnClickListener(onClickListener);
        }
        if (this.iLc != null) {
            this.iLc.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void czh() {
        this.jgA.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eCn.getLayoutMode().setNightMode(i == 1);
        this.eCn.getLayoutMode().onModeChanged(this.mParent);
        this.eCn.getLayoutMode().onModeChanged(this.jgN);
        this.eCn.getLayoutMode().onModeChanged(this.jgz);
        ap.setBackgroundResource(this.ixM, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.iKV, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.jgM, R.color.cp_bg_line_b);
        ap.setBackgroundColor(this.iKX, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iKY, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ixN, R.color.cp_cont_a);
        ap.setBackgroundColor(this.jgF, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jgJ, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.jgL, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iKW, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.izR, R.color.cp_cont_a);
        ap.setViewTextColor(this.jgE, R.color.cp_cont_a);
        ap.setViewTextColor(this.jgy, R.color.cp_cont_a);
        ap.setViewTextColor(this.iKO, R.color.cp_cont_a);
        ap.setViewTextColor(this.jgw, R.color.cp_cont_a);
        ap.setViewTextColor(this.iKP, R.color.cp_cont_a);
        ap.setViewTextColor(this.jgx, R.color.cp_cont_a);
        ap.setViewTextColor(this.iLb, R.color.cp_cont_a);
        ap.setViewTextColor(this.iLe, R.color.cp_cont_a);
        ap.setViewTextColor(this.jgx, R.color.cp_cont_a);
        if (this.jgS != null) {
            this.jgS.setBorderWidth(l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds1));
            this.jgS.setBorderColor(ap.getColor(R.color.cp_mask_b_alpha16));
            this.jgS.setStrokeColorResId(R.color.cp_bg_line_d);
            this.jgS.setPlaceHolder(2);
            this.jgS.invalidate();
        }
        if (this.iLa != null) {
            this.iLa.invalidate();
        }
        if (this.jgT != null) {
            this.jgT.onChangeSkin(i);
        }
        if (this.jbe != null) {
            this.jbe.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.iKQ.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        czw();
        AI(this.jhg ? 1 : 0);
        czl();
        zf(i);
        ac(czp(), czq());
        if (this.jgI != null) {
            this.jgI.onChangeSkinType(i);
        }
        if (this.jgL != null) {
            this.jgL.onChangeSkinType(i);
        }
        if (this.jgK != null) {
            this.jgK.onChangeSkinType(i);
        }
        if (this.iLf != null) {
            this.iLf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bP(boolean z) {
        super.bP(z);
        if (this.jgK != null) {
            this.jgK.bP(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jha = forumData.getPost_num();
            this.jgX = forumData.getTag_color();
            this.ccQ = forumData.getImage_url();
            this.jgW = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jhb = forumData.getSignData().count_sign_num;
                this.jhc = forumData.getSignData().miss_sign_num;
            }
            this.jhd = forumData.getCurScore();
            this.jcN = forumData.getLevelupScore();
            this.jgU = forumData.getBadgeData();
            this.jgY = forumData.getAccelerateContent();
            this.jhi = forumData.isBrandForum;
            this.jdP = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jdP != null && this.jdP.getHotUserRankData() != null && this.jdP.getHotUserRankData().hot_user != null && this.jdP.getHotUserRankData().hot_user.size() >= 3) {
                this.iLf.setVisibility(0);
                this.iLf.setData(this.jdP.getHotUserRankData(), this.iKS);
            } else {
                this.iLf.setVisibility(8);
            }
            if (this.jdP != null && this.jdP.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bET()) {
                this.jgI.setVisibility(0);
                this.jgI.setData(this.jdP.serviceAreaData);
            } else {
                this.jgI.setVisibility(8);
            }
            this.jgZ = new bw();
            czi();
            czm();
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
                this.iLb.setText(str);
                this.iLa.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.iKZ.setVisibility(0);
            } else {
                this.iKZ.setVisibility(8);
            }
            if (this.iLc.getVisibility() == 0) {
                this.iLc.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iKZ.getVisibility() == 0) {
            this.iKZ.setVisibility(8);
        }
        if (this.iLc.getVisibility() == 8) {
            this.iLc.setVisibility(0);
        }
    }

    protected void czi() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.ccQ);
        this.jgZ.bkj().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void czj() {
        if (this.jda != null) {
            this.jda.Ah(this.jhc);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void czk() {
        if (this.jda != null) {
            this.jda.czk();
        }
    }

    protected void czl() {
        if (this.jdb != null) {
            this.jdb.czl();
        }
    }

    protected void czm() {
        if (this.jgw != null) {
            this.jgw.setText(at.dc(this.mMemberNum));
        }
        if (this.jgx != null) {
            this.jgx.setText(at.dc(this.jha));
        }
        if (this.jgU != null && this.jgU.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jhi) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eCn.getString(R.string.forum);
        if (this.byL != null) {
            this.byL.setText(str);
        }
        if (this.izR != null) {
            this.izR.setText(str);
        }
        czt();
        this.iKS = czs();
        if (this.iKS) {
            this.jbe.setVisibility(8);
            this.gVf.setVisibility(0);
        } else {
            this.gVf.setVisibility(8);
            this.jbe.setVisibility(0);
            this.jgH.setOnClickListener(null);
        }
        czr();
        zf(TbadkCoreApplication.getInst().getSkinType());
        czn();
    }

    private void czn() {
        boolean czp = czp();
        boolean czq = czq();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e KG = d.cCA().KG(this.mForumName);
            if (KG == null) {
                KG = new e(this.iKT, czp);
            } else {
                KG.qg(this.iKT);
                KG.qh(czp);
            }
            d.cCA().a(this.mForumName, KG);
        }
        ab(czp, czq);
        ac(czp, czq);
    }

    private void ab(boolean z, boolean z2) {
        if (this.iDN.cvI() != null) {
            if (!z && !z2) {
                this.iKU.setVisibility(8);
            } else {
                this.iKU.setVisibility(0);
            }
            this.iDN.cvI().ae(z, z2);
        }
    }

    private void ac(boolean z, boolean z2) {
        int dimens;
        if (this.jgG != null && this.jgG.getLayoutParams() != null) {
            if (this.iLf.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jgF.getLayoutParams()).topMargin = l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eCn.getPageActivity());
                ((RelativeLayout.LayoutParams) this.iLf.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.iKS) {
                dimens -= l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds80);
            } else if (this.iKS) {
                int dimens3 = l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds782);
                int ad = ad(z, z2);
                int i = dimens3 + ad;
                ((RelativeLayout.LayoutParams) this.jgH.getLayoutParams()).bottomMargin = ad;
                ((RelativeLayout.LayoutParams) this.gVf.getLayoutParams()).bottomMargin = ad;
                if (ad != 0) {
                    ((RelativeLayout.LayoutParams) this.jgF.getLayoutParams()).topMargin = l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jgF.getLayoutParams()).topMargin = l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.iKS) {
                if (czo() != null) {
                    czo().setVisibility(8);
                }
            } else if (czo() != null) {
                czo().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.jgG.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jgG.setLayoutParams(layoutParams);
            }
        }
    }

    private int ad(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jdP.serviceAreaData == null || this.jdP.serviceAreaData.dataList == null || this.jdP.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.iLg != null) {
            i += Math.min(this.iLg.size(), 2) * l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jgJ.getVisibility() == 0) {
            i += l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jgJ.getVisibility() == 0) {
            return i + l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView czo() {
        if (this.iDN == null || this.iDN.cvI() == null) {
            return null;
        }
        View cDK = this.iDN.cvI().cDK();
        if (cDK instanceof LinearGradientView) {
            return (LinearGradientView) cDK;
        }
        return null;
    }

    private boolean czp() {
        return this.jgL != null && this.jgL.getVisibility() == 0;
    }

    private boolean czq() {
        return this.jgI != null && this.jgI.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void czr() {
        if (this.iDN != null && this.jdP != null) {
            List<q> showTopThreadList = this.jdP.getShowTopThreadList();
            this.iKT = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jdP.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.jgL != null) {
            this.iLg = list;
            if (iVar != null) {
                this.jgK = new g(this.eCn.getPageActivity());
                this.jgJ.setVisibility(0);
                this.jgJ.addView(this.jgK.getView());
                this.jgK.a(this.jdP != null ? this.jdP.getForum() : null, iVar);
            } else {
                this.jgJ.setVisibility(8);
            }
            if (this.iDN != null && this.iDN.cvR()) {
                this.jgL.setVisibility(0);
                this.jgL.setFragmentUniqueId(this.iDN.getUniqueId());
                ForumData forum = this.jdP != null ? this.jdP.getForum() : null;
                this.jgL.setForum(this.mForumId, this.mForumName, forum);
                if (forum != null && !at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !y.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                this.jgL.setDatas(list, iVar);
                if (this.iKR == null) {
                    this.iKR = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void am(bw bwVar) {
                            j.a(b.this.iDN, b.this.jdP, bwVar);
                        }
                    };
                }
                this.jgL.setStatListener(this.iKR);
                return;
            }
            this.jgL.setVisibility(8);
        }
    }

    private boolean czs() {
        final com.baidu.tbadk.core.data.y yVar;
        if (this.jdP == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jdP;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dGK())) {
            yVar = new com.baidu.tbadk.core.data.y();
            yVar.setLinkUrl("");
            yVar.setImageUrl(frsViewData.getStar().dGK());
        } else {
            yVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().bie()) < 1) ? null : frsViewData.getActivityHeadData().bie().get(0);
        }
        if (yVar != null) {
            if (this.jgH != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bif())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dR("fid", frsViewData.getForum().getId());
                    aqVar.dR("obj_id", frsViewData.getActivityHeadData().bif());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dR("page_type", PageStayDurationConstants.PageName.FRS).aj("obj_isad", 1).aj("obj_floor", 1).dR("fid", frsViewData.getForum().getId()).dR("obj_id", frsViewData.getActivityHeadData().bif()).aj("obj_adlocate", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eWH);
                    }
                    com.baidu.tieba.s.c.dGv().a(this.iDN.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().bif(), "", (BaijiahaoData) null), aqVar2);
                }
                this.jgH.startLoad(yVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(yVar.getLinkUrl())) {
                    this.jgH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eCn != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bif())) {
                                    String id = frsViewData.getForum().getId();
                                    String bif = frsViewData.getActivityHeadData().bif();
                                    aq aqVar3 = new aq("c13330");
                                    aqVar3.dR("fid", id);
                                    aqVar3.dR("obj_id", bif);
                                    TiebaStatic.log(aqVar3);
                                    aq aqVar4 = new aq("common_click");
                                    aqVar4.dR("page_type", PageStayDurationConstants.PageName.FRS).aj("obj_isad", 1).dR("fid", id).dR("obj_id", bif).aj("obj_adlocate", 1).aj("obj_floor", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aqVar3.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eWH);
                                    }
                                    com.baidu.tieba.s.c.dGv().b(b.this.iDN.getUniqueId(), aqVar4);
                                }
                                be.boR().a(b.this.eCn, new String[]{yVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void zf(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jdP != null && (forum = this.jdP.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iKS) {
                LinearGradientView czo = czo();
                if (this.jbe != null && czo != null) {
                    this.jbe.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    czo.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jgH != null) {
                    this.jgH.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jgI != null) {
                this.jgI.setThemeFontColor(com.baidu.tieba.lego.card.d.b.fv(themeElement.font_color));
            }
            if (this.jgL != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.jgL.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.fv(str));
            }
        }
    }

    protected void czt() {
        this.jgS.startLoad(this.ccQ, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jho);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eCn.getPageActivity());
                this.mPopup.setContentView(this.jgN);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eCn.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eCn.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jgO = (TextView) this.jgN.findViewById(R.id.cur_experience);
            this.jgP = (TextView) this.jgN.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jgN.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jgN.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ap.setViewTextColor(this.jgO, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jgP, R.color.cp_cont_g, 1);
            a(this.jgO, this.jgP);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eCn.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eCn.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jho, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eCn.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
            aVar.bb(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jgY) && !TextUtils.isEmpty(this.jgY.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jgY);
            } else {
                textView3.setVisibility(8);
            }
            aVar.on(R.color.cp_link_tip_d);
            d(aVar);
            e(aVar);
            aVar.b(this.eCn);
            aVar.bmC();
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
                if (b.this.eCn != null && b.this.eCn.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eCn.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void czu() {
        View contentView;
        if (this.jgR == null) {
            this.jgR = new PopupWindow(this.eCn.getPageActivity());
            View inflate = LayoutInflater.from(this.eCn.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jgR.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eCn != null && b.this.eCn.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jgR, b.this.eCn.getPageActivity());
                        b.this.iDN.iBf = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eCn.getPageActivity(), b.this.eCn.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jgR.setWidth(this.eCn.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jgR.setHeight(this.eCn.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jgR.setBackgroundDrawable(new BitmapDrawable());
            this.jgR.setOutsideTouchable(true);
            this.jgR.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jgR);
                        b.this.iDN.iBf = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jgR.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.jgQ.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jgR, this.mParent, 0, (iArr[0] - (this.jgR.getWidth() / 2)) + (this.jgQ.getWidth() / 2), iArr[1] + this.jgQ.getWidth());
        this.jgR.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jhh = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jgy != null && this.ixM != null && this.jgE != null && cashBitmap.getWidth() > 0) {
            if (this.jhh) {
                this.jgy.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cwo = this.iDN.cwo();
                if (cwo != null && cwo.getForum() != null) {
                    cwo.getForum().setUser_level(i);
                }
                this.jgE.setText(this.eCn.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jgy.setText(this.jgW);
                this.jgE.setText(this.eCn.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.ixM.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yd(this.mLevel)));
            if (this.jhh) {
                if (f >= 1.0f) {
                    b(this.ixM, this.jhj, f);
                } else {
                    c(this.ixM, this.jhj, f);
                }
            } else {
                b(this.ixM, this.jhj, f);
            }
            this.jhj = f;
        }
    }

    private int[] yd(int i) {
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
    protected void czv() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void czw() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jgQ, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jgQ, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jgR != null && this.jgR.isShowing()) {
            this.jgR.dismiss();
        }
        if (this.jgK != null) {
            this.jgK.onDestroy();
        }
    }
}
