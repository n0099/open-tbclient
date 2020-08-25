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
import com.baidu.tieba.frs.f.h;
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
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String bLF;
    private View grv;
    private final ImageView icA;
    private final TextView icB;
    private HotRankEntryView icC;
    private List<q> icD;
    private TextView icl;
    private TextView icm;
    private az ico;
    private boolean icp;
    private LinearLayout icr;
    private View ics;
    private View ict;
    private View icu;
    private View icv;
    private final View icw;
    private final HeadImageView icx;
    private final TextView icy;
    private final View icz;
    private RelativeLayout mContainer;
    private boolean icq = false;
    private ArrayList<TbImageView> icn = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hVk = frsFragment;
        this.efn = frsFragment.getPageContext();
        this.ixF = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.ixG = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.ixH = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cpo();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.ixS = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.ist = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.ixT = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.ixT.setPageId(this.hVk.getUniqueId());
        this.ixT.setDefaultBgResource(R.color.transparent);
        this.ixT.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ixT.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.grv = this.mParent.findViewById(R.id.header_top_cover);
        this.icr = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.ics = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.ict = this.mParent.findViewById(R.id.no_service_space);
        this.ixU = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.ixV = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.ixX = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.icu = this.mParent.findViewById(R.id.frs_topview_space);
        this.icv = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.ixY = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.iyc = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.icl = (TextView) this.mParent.findViewById(R.id.member_image);
        this.icm = (TextView) this.mParent.findViewById(R.id.post_image);
        this.ixK = (TextView) this.mParent.findViewById(R.id.level_name);
        this.ixQ = (TextView) this.mParent.findViewById(R.id.level);
        this.itP = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.itP.setText(frsFragment.getResources().getString(R.string.attention));
        this.itP.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pc(R.color.cp_cont_b);
        this.itP.setConfig(bVar);
        this.itW = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.itW.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pc(R.color.cp_cont_b);
        bVar2.oX(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.itW.setConfig(bVar2);
        this.itW.setText(frsFragment.getResources().getString(R.string.sign));
        this.hPj = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hPk = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.ixI = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.ixJ = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hRo = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.ixM = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.iye = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.iye.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iye.setPageId(this.hVk.getUniqueId());
        this.iye.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.iye.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.iye.setShowOval(true);
        this.iye.setPlaceHolder(2);
        this.ixP = this.mParent.findViewById(R.id.level_container);
        this.ixO = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.ixN = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.ixR = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.icw = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.icy = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.icx = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.icx.setIsRound(true);
        this.icx.setDrawBorder(true);
        this.icx.setDefaultResource(R.drawable.icon_default_avatar100);
        this.icx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.icz = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.icA = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.icB = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.bjq().a(this.icA, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.ixZ = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.ixL = LayoutInflater.from(this.hVk.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.icC = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.ixL.setVisibility(8);
        this.iyh = new com.baidu.tieba.frs.f.b(this.efn);
    }

    protected View cpo() {
        return LayoutInflater.from(this.hVk.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void A(View.OnClickListener onClickListener) {
        this.iye.setOnClickListener(onClickListener);
        this.hRo.setOnClickListener(onClickListener);
        this.itW.setOnClickListener(onClickListener);
        this.itP.setOnClickListener(onClickListener);
        this.ixP.setOnClickListener(onClickListener);
        if (this.icC != null) {
            this.icC.setOnClickListener(onClickListener);
        }
        if (this.icw != null) {
            this.icw.setOnClickListener(onClickListener);
        }
        if (this.icz != null) {
            this.icz.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpp() {
        this.ixM.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.efn.getLayoutMode().setNightMode(i == 1);
        this.efn.getLayoutMode().onModeChanged(this.mParent);
        this.efn.getLayoutMode().onModeChanged(this.ixZ);
        this.efn.getLayoutMode().onModeChanged(this.ixL);
        ap.setBackgroundResource(this.hPj, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.ics, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.ixY, R.color.cp_bg_line_b);
        ap.setBackgroundColor(this.icu, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.icv, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hPk, R.color.cp_cont_a);
        ap.setBackgroundColor(this.ixR, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.ixV, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ixX, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ict, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hRo, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixQ, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixK, R.color.cp_cont_a);
        ap.setViewTextColor(this.icl, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixI, R.color.cp_cont_a);
        ap.setViewTextColor(this.icm, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixJ, R.color.cp_cont_a);
        ap.setViewTextColor(this.icy, R.color.cp_cont_a);
        ap.setViewTextColor(this.icB, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixJ, R.color.cp_cont_a);
        if (this.iye != null) {
            this.iye.setBorderWidth(l.getDimens(this.efn.getPageActivity(), R.dimen.tbds1));
            this.iye.setBorderColor(ap.getColor(R.color.cp_mask_b_alpha16));
            this.iye.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iye.setPlaceHolder(2);
            this.iye.invalidate();
        }
        if (this.icx != null) {
            this.icx.invalidate();
        }
        if (this.iyf != null) {
            this.iyf.onChangeSkin(i);
        }
        if (this.ist != null) {
            this.ist.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.icn.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cpE();
        zl(this.iys ? 1 : 0);
        cpt();
        xH(i);
        Y(cpx(), cpy());
        if (this.ixU != null) {
            this.ixU.onChangeSkinType(i);
        }
        if (this.ixX != null) {
            this.ixX.onChangeSkinType(i);
        }
        if (this.ixW != null) {
            this.ixW.onChangeSkinType(i);
        }
        if (this.icC != null) {
            this.icC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bJ(boolean z) {
        super.bJ(z);
        if (this.ixW != null) {
            this.ixW.bJ(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.iym = forumData.getPost_num();
            this.iyj = forumData.getTag_color();
            this.bLF = forumData.getImage_url();
            this.iyi = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.iyn = forumData.getSignData().count_sign_num;
                this.iyo = forumData.getSignData().miss_sign_num;
            }
            this.iyp = forumData.getCurScore();
            this.itZ = forumData.getLevelupScore();
            this.iyg = forumData.getBadgeData();
            this.iyk = forumData.getAccelerateContent();
            this.iyu = forumData.isBrandForum;
            this.ivb = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.ivb != null && this.ivb.getHotUserRankData() != null && this.ivb.getHotUserRankData().hot_user != null && this.ivb.getHotUserRankData().hot_user.size() >= 3) {
                this.icC.setVisibility(0);
                this.icC.setData(this.ivb.getHotUserRankData(), this.icp);
            } else {
                this.icC.setVisibility(8);
            }
            if (this.ivb != null && this.ivb.serviceAreaData != null) {
                this.ixU.setVisibility(0);
                this.ixU.setData(this.ivb.serviceAreaData);
            } else {
                this.ixU.setVisibility(8);
            }
            this.iyl = new bw();
            cpq();
            cpu();
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
                this.icy.setText(str);
                this.icx.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.icw.setVisibility(0);
            } else {
                this.icw.setVisibility(8);
            }
            if (this.icz.getVisibility() == 0) {
                this.icz.setVisibility(8);
                return;
            }
            return;
        }
        if (this.icw.getVisibility() == 0) {
            this.icw.setVisibility(8);
        }
        if (this.icz.getVisibility() == 8) {
            this.icz.setVisibility(0);
        }
    }

    protected void cpq() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bLF);
        this.iyl.beN().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cpr() {
        if (this.ium != null) {
            this.ium.yJ(this.iyo);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cps() {
        if (this.ium != null) {
            this.ium.cps();
        }
    }

    protected void cpt() {
        if (this.iun != null) {
            this.iun.cpt();
        }
    }

    protected void cpu() {
        if (this.ixI != null) {
            this.ixI.setText(at.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.ixJ != null) {
            this.ixJ.setText(at.numberUniformFormatExtra(this.iym));
        }
        if (this.iyg != null && this.iyg.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.iyu) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.efn.getString(R.string.forum);
        if (this.bpx != null) {
            this.bpx.setText(str);
        }
        if (this.hRo != null) {
            this.hRo.setText(str);
        }
        cpB();
        this.icp = cpA();
        if (this.icp) {
            this.ist.setVisibility(8);
            this.grv.setVisibility(0);
        } else {
            this.grv.setVisibility(8);
            this.ist.setVisibility(0);
            this.ixT.setOnClickListener(null);
        }
        cpz();
        xH(TbadkCoreApplication.getInst().getSkinType());
        cpv();
    }

    private void cpv() {
        boolean cpx = cpx();
        boolean cpy = cpy();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e IV = d.csG().IV(this.mForumName);
            if (IV == null) {
                IV = new e(this.icq, cpx);
            } else {
                IV.pb(this.icq);
                IV.pc(cpx);
            }
            d.csG().a(this.mForumName, IV);
        }
        X(cpx, cpy);
        Y(cpx, cpy);
    }

    private void X(boolean z, boolean z2) {
        if (this.hVk.clQ() != null) {
            if (!z && !z2) {
                this.icr.setVisibility(8);
            } else {
                this.icr.setVisibility(0);
            }
            this.hVk.clQ().aa(z, z2);
        }
    }

    private void Y(boolean z, boolean z2) {
        int dimens;
        if (this.ixS != null && this.ixS.getLayoutParams() != null) {
            if (this.icC.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.efn.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.ixR.getLayoutParams()).topMargin = l.getDimens(this.efn.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.efn.getPageActivity());
                ((RelativeLayout.LayoutParams) this.icC.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.efn.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.efn.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.efn.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.icp) {
                dimens -= l.getDimens(this.efn.getPageActivity(), R.dimen.tbds80);
            } else if (this.icp) {
                int dimens3 = l.getDimens(this.efn.getPageActivity(), R.dimen.tbds782);
                int Z = Z(z, z2);
                int i = dimens3 + Z;
                ((RelativeLayout.LayoutParams) this.ixT.getLayoutParams()).bottomMargin = Z;
                ((RelativeLayout.LayoutParams) this.grv.getLayoutParams()).bottomMargin = Z;
                if (Z != 0) {
                    ((RelativeLayout.LayoutParams) this.ixR.getLayoutParams()).topMargin = l.getDimens(this.efn.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.efn.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.ixR.getLayoutParams()).topMargin = l.getDimens(this.efn.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.icp) {
                if (cpw() != null) {
                    cpw().setVisibility(8);
                }
            } else if (cpw() != null) {
                cpw().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.ixS.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.ixS.setLayoutParams(layoutParams);
            }
        }
    }

    private int Z(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.ivb.serviceAreaData == null || this.ivb.serviceAreaData.dataList == null || this.ivb.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.efn.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.efn.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.icD != null) {
            i += Math.min(this.icD.size(), 2) * l.getDimens(this.efn.getPageActivity(), R.dimen.tbds83);
        }
        if (this.ixV.getVisibility() == 0) {
            i += l.getDimens(this.efn.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.ixV.getVisibility() == 0) {
            return i + l.getDimens(this.efn.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cpw() {
        if (this.hVk == null || this.hVk.clQ() == null) {
            return null;
        }
        View ctM = this.hVk.clQ().ctM();
        if (ctM instanceof LinearGradientView) {
            return (LinearGradientView) ctM;
        }
        return null;
    }

    private boolean cpx() {
        return this.ixX != null && this.ixX.getVisibility() == 0;
    }

    private boolean cpy() {
        return this.ixU != null && this.ixU.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpz() {
        if (this.hVk != null && this.ivb != null) {
            List<q> showTopThreadList = this.ivb.getShowTopThreadList();
            this.icq = showTopThreadList.size() > 2;
            a(showTopThreadList, this.ivb.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.ixX != null) {
            this.icD = list;
            if (iVar != null) {
                this.ixW = new g(this.efn.getPageActivity());
                this.ixV.setVisibility(0);
                this.ixV.addView(this.ixW.getView());
                this.ixW.a(this.ivb != null ? this.ivb.getForum() : null, iVar);
            } else {
                this.ixV.setVisibility(8);
            }
            if (this.hVk != null && this.hVk.clZ()) {
                this.ixX.setVisibility(0);
                this.ixX.setFragmentUniqueId(this.hVk.getUniqueId());
                ForumData forum = this.ivb != null ? this.ivb.getForum() : null;
                this.ixX.setForum(this.mForumId, this.mForumName, forum);
                if (!at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum));
                }
                this.ixX.setDatas(list, iVar);
                if (this.ico == null) {
                    this.ico = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void al(bw bwVar) {
                            h.a(b.this.hVk, b.this.ivb, bwVar);
                        }
                    };
                }
                this.ixX.setStatListener(this.ico);
                return;
            }
            this.ixX.setVisibility(8);
        }
    }

    private boolean cpA() {
        final y yVar;
        if (this.ivb == null) {
            return false;
        }
        final FrsViewData frsViewData = this.ivb;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dvT())) {
            yVar = new y();
            yVar.setLinkUrl("");
            yVar.setImageUrl(frsViewData.getStar().dvT());
        } else {
            yVar = (frsViewData.getActivityHeadData() == null || com.baidu.tbadk.core.util.y.getCount(frsViewData.getActivityHeadData().bcI()) < 1) ? null : frsViewData.getActivityHeadData().bcI().get(0);
        }
        if (yVar != null) {
            if (this.ixT != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bcJ())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dD("fid", frsViewData.getForum().getId());
                    aqVar.dD("obj_id", frsViewData.getActivityHeadData().bcJ());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dD("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).ai("obj_floor", 1).dD("fid", frsViewData.getForum().getId()).dD("obj_id", frsViewData.getActivityHeadData().bcJ()).ai("obj_adlocate", 1).dD("first_dir", frsViewData.getForum().getFirst_class()).dD("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ezW);
                    }
                    com.baidu.tieba.s.c.dvE().a(this.hVk.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().bcJ(), "", (BaijiahaoData) null), aqVar2);
                }
                this.ixT.startLoad(yVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(yVar.getLinkUrl())) {
                    this.ixT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.efn != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bcJ())) {
                                    String id = frsViewData.getForum().getId();
                                    String bcJ = frsViewData.getActivityHeadData().bcJ();
                                    aq aqVar3 = new aq("c13330");
                                    aqVar3.dD("fid", id);
                                    aqVar3.dD("obj_id", bcJ);
                                    TiebaStatic.log(aqVar3);
                                    aq aqVar4 = new aq("common_click");
                                    aqVar4.dD("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).dD("fid", id).dD("obj_id", bcJ).ai("obj_adlocate", 1).ai("obj_floor", 1).dD("first_dir", frsViewData.getForum().getFirst_class()).dD("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aqVar3.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ezW);
                                    }
                                    com.baidu.tieba.s.c.dvE().b(b.this.hVk.getUniqueId(), aqVar4);
                                }
                                be.bju().a(b.this.efn, new String[]{yVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void xH(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.ivb != null && (forum = this.ivb.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.icp) {
                LinearGradientView cpw = cpw();
                if (this.ist != null && cpw != null) {
                    this.ist.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    cpw.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.ixT != null) {
                    this.ixT.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.ixU != null) {
                this.ixU.setThemeFontColor(com.baidu.tieba.lego.card.d.b.fn(themeElement.font_color));
            }
            if (this.ixX != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.ixX.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.fn(str));
            }
        }
    }

    protected void cpB() {
        this.iye.startLoad(this.bLF, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.iyA);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.efn.getPageActivity());
                this.mPopup.setContentView(this.ixZ);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.efn.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.efn.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.iya = (TextView) this.ixZ.findViewById(R.id.cur_experience);
            this.iyb = (TextView) this.ixZ.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.ixZ.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.ixZ.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ap.setViewTextColor(this.iya, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.iyb, R.color.cp_cont_g, 1);
            a(this.iya, this.iyb);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.efn.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.efn.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.iyA, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.efn.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
            aVar.aX(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.iyk) && !TextUtils.isEmpty(this.iyk.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.iyk);
            } else {
                textView3.setVisibility(8);
            }
            aVar.nu(R.color.cp_link_tip_d);
            d(aVar);
            e(aVar);
            aVar.b(this.efn);
            aVar.bhg();
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
                if (b.this.efn != null && b.this.efn.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.efn.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpC() {
        View contentView;
        if (this.iyd == null) {
            this.iyd = new PopupWindow(this.efn.getPageActivity());
            View inflate = LayoutInflater.from(this.efn.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.iyd.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.efn != null && b.this.efn.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iyd, b.this.efn.getPageActivity());
                        b.this.hVk.hSC = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.efn.getPageActivity(), b.this.efn.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.iyd.setWidth(this.efn.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.iyd.setHeight(this.efn.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.iyd.setBackgroundDrawable(new BitmapDrawable());
            this.iyd.setOutsideTouchable(true);
            this.iyd.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iyd);
                        b.this.hVk.hSC = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.iyd.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.iyc.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.iyd, this.mParent, 0, (iArr[0] - (this.iyd.getWidth() / 2)) + (this.iyc.getWidth() / 2), iArr[1] + this.iyc.getWidth());
        this.iyd.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.iyt = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.ixK != null && this.hPj != null && this.ixQ != null && cashBitmap.getWidth() > 0) {
            if (this.iyt) {
                this.ixK.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cmw = this.hVk.cmw();
                if (cmw != null && cmw.getForum() != null) {
                    cmw.getForum().setUser_level(i);
                }
                this.ixQ.setText(this.efn.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.ixK.setText(this.iyi);
                this.ixQ.setText(this.efn.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hPj.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, wF(this.mLevel)));
            if (this.iyt) {
                if (f >= 1.0f) {
                    b(this.hPj, this.iyv, f);
                } else {
                    c(this.hPj, this.iyv, f);
                }
            } else {
                b(this.hPj, this.iyv, f);
            }
            this.iyv = f;
        }
    }

    private int[] wF(int i) {
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
    protected void cpD() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpE() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iyc, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.iyc, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iyd != null && this.iyd.isShowing()) {
            this.iyd.dismiss();
        }
        if (this.ixW != null) {
            this.ixW.onDestroy();
        }
    }
}
