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
    private String bLJ;
    private View grz;
    private View icA;
    private View icB;
    private final View icC;
    private final HeadImageView icD;
    private final TextView icE;
    private final View icF;
    private final ImageView icG;
    private final TextView icH;
    private HotRankEntryView icI;
    private List<q> icJ;
    private TextView icr;
    private TextView ics;
    private az icu;
    private boolean icv;
    private LinearLayout icx;
    private View icy;
    private View icz;
    private RelativeLayout mContainer;
    private boolean icw = false;
    private ArrayList<TbImageView> ict = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hVq = frsFragment;
        this.efr = frsFragment.getPageContext();
        this.ixL = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.ixM = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.ixN = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cpp();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.ixY = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.isz = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.ixZ = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.ixZ.setPageId(this.hVq.getUniqueId());
        this.ixZ.setDefaultBgResource(R.color.transparent);
        this.ixZ.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ixZ.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.grz = this.mParent.findViewById(R.id.header_top_cover);
        this.icx = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.icy = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.icz = this.mParent.findViewById(R.id.no_service_space);
        this.iya = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.iyb = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.iyd = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.icA = this.mParent.findViewById(R.id.frs_topview_space);
        this.icB = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.iye = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.iyi = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.icr = (TextView) this.mParent.findViewById(R.id.member_image);
        this.ics = (TextView) this.mParent.findViewById(R.id.post_image);
        this.ixQ = (TextView) this.mParent.findViewById(R.id.level_name);
        this.ixW = (TextView) this.mParent.findViewById(R.id.level);
        this.itV = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.itV.setText(frsFragment.getResources().getString(R.string.attention));
        this.itV.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pc(R.color.cp_cont_b);
        this.itV.setConfig(bVar);
        this.iuc = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.iuc.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pc(R.color.cp_cont_b);
        bVar2.oX(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.iuc.setConfig(bVar2);
        this.iuc.setText(frsFragment.getResources().getString(R.string.sign));
        this.hPp = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hPq = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.ixO = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.ixP = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hRu = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.ixS = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.iyk = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.iyk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iyk.setPageId(this.hVq.getUniqueId());
        this.iyk.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.iyk.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.iyk.setShowOval(true);
        this.iyk.setPlaceHolder(2);
        this.ixV = this.mParent.findViewById(R.id.level_container);
        this.ixU = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.ixT = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.ixX = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.icC = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.icE = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.icD = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.icD.setIsRound(true);
        this.icD.setDrawBorder(true);
        this.icD.setDefaultResource(R.drawable.icon_default_avatar100);
        this.icD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.icF = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.icG = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.icH = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.bjq().a(this.icG, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.iyf = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.ixR = LayoutInflater.from(this.hVq.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.icI = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.ixR.setVisibility(8);
        this.iyn = new com.baidu.tieba.frs.f.b(this.efr);
    }

    protected View cpp() {
        return LayoutInflater.from(this.hVq.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void A(View.OnClickListener onClickListener) {
        this.iyk.setOnClickListener(onClickListener);
        this.hRu.setOnClickListener(onClickListener);
        this.iuc.setOnClickListener(onClickListener);
        this.itV.setOnClickListener(onClickListener);
        this.ixV.setOnClickListener(onClickListener);
        if (this.icI != null) {
            this.icI.setOnClickListener(onClickListener);
        }
        if (this.icC != null) {
            this.icC.setOnClickListener(onClickListener);
        }
        if (this.icF != null) {
            this.icF.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpq() {
        this.ixS.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.efr.getLayoutMode().setNightMode(i == 1);
        this.efr.getLayoutMode().onModeChanged(this.mParent);
        this.efr.getLayoutMode().onModeChanged(this.iyf);
        this.efr.getLayoutMode().onModeChanged(this.ixR);
        ap.setBackgroundResource(this.hPp, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.icy, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.iye, R.color.cp_bg_line_b);
        ap.setBackgroundColor(this.icA, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.icB, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hPq, R.color.cp_cont_a);
        ap.setBackgroundColor(this.ixX, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iyb, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iyd, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.icz, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.hRu, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixW, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixQ, R.color.cp_cont_a);
        ap.setViewTextColor(this.icr, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixO, R.color.cp_cont_a);
        ap.setViewTextColor(this.ics, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixP, R.color.cp_cont_a);
        ap.setViewTextColor(this.icE, R.color.cp_cont_a);
        ap.setViewTextColor(this.icH, R.color.cp_cont_a);
        ap.setViewTextColor(this.ixP, R.color.cp_cont_a);
        if (this.iyk != null) {
            this.iyk.setBorderWidth(l.getDimens(this.efr.getPageActivity(), R.dimen.tbds1));
            this.iyk.setBorderColor(ap.getColor(R.color.cp_mask_b_alpha16));
            this.iyk.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iyk.setPlaceHolder(2);
            this.iyk.invalidate();
        }
        if (this.icD != null) {
            this.icD.invalidate();
        }
        if (this.iyl != null) {
            this.iyl.onChangeSkin(i);
        }
        if (this.isz != null) {
            this.isz.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.ict.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cpF();
        zl(this.iyy ? 1 : 0);
        cpu();
        xH(i);
        Y(cpy(), cpz());
        if (this.iya != null) {
            this.iya.onChangeSkinType(i);
        }
        if (this.iyd != null) {
            this.iyd.onChangeSkinType(i);
        }
        if (this.iyc != null) {
            this.iyc.onChangeSkinType(i);
        }
        if (this.icI != null) {
            this.icI.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bJ(boolean z) {
        super.bJ(z);
        if (this.iyc != null) {
            this.iyc.bJ(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.iys = forumData.getPost_num();
            this.iyp = forumData.getTag_color();
            this.bLJ = forumData.getImage_url();
            this.iyo = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.iyt = forumData.getSignData().count_sign_num;
                this.iyu = forumData.getSignData().miss_sign_num;
            }
            this.iyv = forumData.getCurScore();
            this.iuf = forumData.getLevelupScore();
            this.iym = forumData.getBadgeData();
            this.iyq = forumData.getAccelerateContent();
            this.iyA = forumData.isBrandForum;
            this.ivh = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.ivh != null && this.ivh.getHotUserRankData() != null && this.ivh.getHotUserRankData().hot_user != null && this.ivh.getHotUserRankData().hot_user.size() >= 3) {
                this.icI.setVisibility(0);
                this.icI.setData(this.ivh.getHotUserRankData(), this.icv);
            } else {
                this.icI.setVisibility(8);
            }
            if (this.ivh != null && this.ivh.serviceAreaData != null) {
                this.iya.setVisibility(0);
                this.iya.setData(this.ivh.serviceAreaData);
            } else {
                this.iya.setVisibility(8);
            }
            this.iyr = new bw();
            cpr();
            cpv();
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
                this.icE.setText(str);
                this.icD.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.icC.setVisibility(0);
            } else {
                this.icC.setVisibility(8);
            }
            if (this.icF.getVisibility() == 0) {
                this.icF.setVisibility(8);
                return;
            }
            return;
        }
        if (this.icC.getVisibility() == 0) {
            this.icC.setVisibility(8);
        }
        if (this.icF.getVisibility() == 8) {
            this.icF.setVisibility(0);
        }
    }

    protected void cpr() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bLJ);
        this.iyr.beN().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cps() {
        if (this.ius != null) {
            this.ius.yJ(this.iyu);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cpt() {
        if (this.ius != null) {
            this.ius.cpt();
        }
    }

    protected void cpu() {
        if (this.iut != null) {
            this.iut.cpu();
        }
    }

    protected void cpv() {
        if (this.ixO != null) {
            this.ixO.setText(at.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.ixP != null) {
            this.ixP.setText(at.numberUniformFormatExtra(this.iys));
        }
        if (this.iym != null && this.iym.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.iyA) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.efr.getString(R.string.forum);
        if (this.bpA != null) {
            this.bpA.setText(str);
        }
        if (this.hRu != null) {
            this.hRu.setText(str);
        }
        cpC();
        this.icv = cpB();
        if (this.icv) {
            this.isz.setVisibility(8);
            this.grz.setVisibility(0);
        } else {
            this.grz.setVisibility(8);
            this.isz.setVisibility(0);
            this.ixZ.setOnClickListener(null);
        }
        cpA();
        xH(TbadkCoreApplication.getInst().getSkinType());
        cpw();
    }

    private void cpw() {
        boolean cpy = cpy();
        boolean cpz = cpz();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e IW = d.csH().IW(this.mForumName);
            if (IW == null) {
                IW = new e(this.icw, cpy);
            } else {
                IW.pd(this.icw);
                IW.pe(cpy);
            }
            d.csH().a(this.mForumName, IW);
        }
        X(cpy, cpz);
        Y(cpy, cpz);
    }

    private void X(boolean z, boolean z2) {
        if (this.hVq.clR() != null) {
            if (!z && !z2) {
                this.icx.setVisibility(8);
            } else {
                this.icx.setVisibility(0);
            }
            this.hVq.clR().aa(z, z2);
        }
    }

    private void Y(boolean z, boolean z2) {
        int dimens;
        if (this.ixY != null && this.ixY.getLayoutParams() != null) {
            if (this.icI.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.efr.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.ixX.getLayoutParams()).topMargin = l.getDimens(this.efr.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.efr.getPageActivity());
                ((RelativeLayout.LayoutParams) this.icI.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.efr.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.efr.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.efr.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.icv) {
                dimens -= l.getDimens(this.efr.getPageActivity(), R.dimen.tbds80);
            } else if (this.icv) {
                int dimens3 = l.getDimens(this.efr.getPageActivity(), R.dimen.tbds782);
                int Z = Z(z, z2);
                int i = dimens3 + Z;
                ((RelativeLayout.LayoutParams) this.ixZ.getLayoutParams()).bottomMargin = Z;
                ((RelativeLayout.LayoutParams) this.grz.getLayoutParams()).bottomMargin = Z;
                if (Z != 0) {
                    ((RelativeLayout.LayoutParams) this.ixX.getLayoutParams()).topMargin = l.getDimens(this.efr.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.efr.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.ixX.getLayoutParams()).topMargin = l.getDimens(this.efr.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.icv) {
                if (cpx() != null) {
                    cpx().setVisibility(8);
                }
            } else if (cpx() != null) {
                cpx().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.ixY.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.ixY.setLayoutParams(layoutParams);
            }
        }
    }

    private int Z(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.ivh.serviceAreaData == null || this.ivh.serviceAreaData.dataList == null || this.ivh.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.efr.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.efr.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.icJ != null) {
            i += Math.min(this.icJ.size(), 2) * l.getDimens(this.efr.getPageActivity(), R.dimen.tbds83);
        }
        if (this.iyb.getVisibility() == 0) {
            i += l.getDimens(this.efr.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.iyb.getVisibility() == 0) {
            return i + l.getDimens(this.efr.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cpx() {
        if (this.hVq == null || this.hVq.clR() == null) {
            return null;
        }
        View ctN = this.hVq.clR().ctN();
        if (ctN instanceof LinearGradientView) {
            return (LinearGradientView) ctN;
        }
        return null;
    }

    private boolean cpy() {
        return this.iyd != null && this.iyd.getVisibility() == 0;
    }

    private boolean cpz() {
        return this.iya != null && this.iya.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpA() {
        if (this.hVq != null && this.ivh != null) {
            List<q> showTopThreadList = this.ivh.getShowTopThreadList();
            this.icw = showTopThreadList.size() > 2;
            a(showTopThreadList, this.ivh.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.iyd != null) {
            this.icJ = list;
            if (iVar != null) {
                this.iyc = new g(this.efr.getPageActivity());
                this.iyb.setVisibility(0);
                this.iyb.addView(this.iyc.getView());
                this.iyc.a(this.ivh != null ? this.ivh.getForum() : null, iVar);
            } else {
                this.iyb.setVisibility(8);
            }
            if (this.hVq != null && this.hVq.cma()) {
                this.iyd.setVisibility(0);
                this.iyd.setFragmentUniqueId(this.hVq.getUniqueId());
                ForumData forum = this.ivh != null ? this.ivh.getForum() : null;
                this.iyd.setForum(this.mForumId, this.mForumName, forum);
                if (!at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum));
                }
                this.iyd.setDatas(list, iVar);
                if (this.icu == null) {
                    this.icu = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void al(bw bwVar) {
                            h.a(b.this.hVq, b.this.ivh, bwVar);
                        }
                    };
                }
                this.iyd.setStatListener(this.icu);
                return;
            }
            this.iyd.setVisibility(8);
        }
    }

    private boolean cpB() {
        final y yVar;
        if (this.ivh == null) {
            return false;
        }
        final FrsViewData frsViewData = this.ivh;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dvY())) {
            yVar = new y();
            yVar.setLinkUrl("");
            yVar.setImageUrl(frsViewData.getStar().dvY());
        } else {
            yVar = (frsViewData.getActivityHeadData() == null || com.baidu.tbadk.core.util.y.getCount(frsViewData.getActivityHeadData().bcI()) < 1) ? null : frsViewData.getActivityHeadData().bcI().get(0);
        }
        if (yVar != null) {
            if (this.ixZ != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bcJ())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dD("fid", frsViewData.getForum().getId());
                    aqVar.dD("obj_id", frsViewData.getActivityHeadData().bcJ());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dD("page_type", PageStayDurationConstants.PageName.FRS).ai("obj_isad", 1).ai("obj_floor", 1).dD("fid", frsViewData.getForum().getId()).dD("obj_id", frsViewData.getActivityHeadData().bcJ()).ai("obj_adlocate", 1).dD("first_dir", frsViewData.getForum().getFirst_class()).dD("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eAa);
                    }
                    com.baidu.tieba.s.c.dvJ().a(this.hVq.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().bcJ(), "", (BaijiahaoData) null), aqVar2);
                }
                this.ixZ.startLoad(yVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(yVar.getLinkUrl())) {
                    this.ixZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.efr != null) {
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
                                        aqVar3.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eAa);
                                    }
                                    com.baidu.tieba.s.c.dvJ().b(b.this.hVq.getUniqueId(), aqVar4);
                                }
                                be.bju().a(b.this.efr, new String[]{yVar.getLinkUrl()}, true);
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
        if (this.ivh != null && (forum = this.ivh.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.icv) {
                LinearGradientView cpx = cpx();
                if (this.isz != null && cpx != null) {
                    this.isz.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    cpx.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.ixZ != null) {
                    this.ixZ.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.iya != null) {
                this.iya.setThemeFontColor(com.baidu.tieba.lego.card.d.b.fo(themeElement.font_color));
            }
            if (this.iyd != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.iyd.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.fo(str));
            }
        }
    }

    protected void cpC() {
        this.iyk.startLoad(this.bLJ, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.iyG);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.efr.getPageActivity());
                this.mPopup.setContentView(this.iyf);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.efr.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.efr.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.iyg = (TextView) this.iyf.findViewById(R.id.cur_experience);
            this.iyh = (TextView) this.iyf.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.iyf.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.iyf.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ap.setViewTextColor(this.iyg, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.iyh, R.color.cp_cont_g, 1);
            a(this.iyg, this.iyh);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.efr.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.efr.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.iyG, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.efr.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
            aVar.aX(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.iyq) && !TextUtils.isEmpty(this.iyq.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.iyq);
            } else {
                textView3.setVisibility(8);
            }
            aVar.nu(R.color.cp_link_tip_d);
            d(aVar);
            e(aVar);
            aVar.b(this.efr);
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
                if (b.this.efr != null && b.this.efr.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.efr.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpD() {
        View contentView;
        if (this.iyj == null) {
            this.iyj = new PopupWindow(this.efr.getPageActivity());
            View inflate = LayoutInflater.from(this.efr.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.iyj.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.efr != null && b.this.efr.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iyj, b.this.efr.getPageActivity());
                        b.this.hVq.hSI = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.efr.getPageActivity(), b.this.efr.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.iyj.setWidth(this.efr.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.iyj.setHeight(this.efr.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.iyj.setBackgroundDrawable(new BitmapDrawable());
            this.iyj.setOutsideTouchable(true);
            this.iyj.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iyj);
                        b.this.hVq.hSI = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.iyj.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.iyi.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.iyj, this.mParent, 0, (iArr[0] - (this.iyj.getWidth() / 2)) + (this.iyi.getWidth() / 2), iArr[1] + this.iyi.getWidth());
        this.iyj.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.iyz = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.ixQ != null && this.hPp != null && this.ixW != null && cashBitmap.getWidth() > 0) {
            if (this.iyz) {
                this.ixQ.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cmx = this.hVq.cmx();
                if (cmx != null && cmx.getForum() != null) {
                    cmx.getForum().setUser_level(i);
                }
                this.ixW.setText(this.efr.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.ixQ.setText(this.iyo);
                this.ixW.setText(this.efr.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hPp.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, wF(this.mLevel)));
            if (this.iyz) {
                if (f >= 1.0f) {
                    b(this.hPp, this.iyB, f);
                } else {
                    c(this.hPp, this.iyB, f);
                }
            } else {
                b(this.hPp, this.iyB, f);
            }
            this.iyB = f;
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
    protected void cpE() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cpF() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iyi, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.iyi, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iyj != null && this.iyj.isShowing()) {
            this.iyj.dismiss();
        }
        if (this.iyc != null) {
            this.iyc.onDestroy();
        }
    }
}
