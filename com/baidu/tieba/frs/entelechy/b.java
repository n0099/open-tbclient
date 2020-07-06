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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String bFH;
    private View gaf;
    private TextView hIe;
    private TextView hIf;
    private ax hIh;
    private boolean hIi;
    private LinearLayout hIk;
    private View hIl;
    private View hIm;
    private View hIn;
    private View hIo;
    private final View hIp;
    private final HeadImageView hIq;
    private final TextView hIr;
    private final View hIs;
    private final ImageView hIt;
    private final TextView hIu;
    private HotRankEntryView hIv;
    private List<q> hIw;
    private RelativeLayout mContainer;
    private boolean hIj = false;
    private ArrayList<TbImageView> hIg = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hBW = frsFragment;
        this.dPv = frsFragment.getPageContext();
        this.idB = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.idC = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.idD = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cbm();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.idO = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.hYl = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.idP = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.idP.setPageId(this.hBW.getUniqueId());
        this.idP.setDefaultBgResource(R.color.transparent);
        this.idP.setDefaultResource(R.drawable.pic_frs_head_default);
        this.idP.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.gaf = this.mParent.findViewById(R.id.header_top_cover);
        this.hIk = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.hIl = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.hIm = this.mParent.findViewById(R.id.no_service_space);
        this.idQ = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.idR = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.idT = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.hIn = this.mParent.findViewById(R.id.frs_topview_space);
        this.hIo = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.idU = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.idY = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.hIe = (TextView) this.mParent.findViewById(R.id.member_image);
        this.hIf = (TextView) this.mParent.findViewById(R.id.post_image);
        this.idG = (TextView) this.mParent.findViewById(R.id.level_name);
        this.idM = (TextView) this.mParent.findViewById(R.id.level);
        this.hZH = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.hZH.setText(frsFragment.getResources().getString(R.string.attention));
        this.hZH.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mD(R.color.cp_cont_b);
        this.hZH.setConfig(cVar);
        this.hZO = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.hZO.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.mD(R.color.cp_cont_b);
        cVar2.my(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.hZO.setConfig(cVar2);
        this.hZO.setText(frsFragment.getResources().getString(R.string.sign));
        this.hwi = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hwj = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.idE = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.idF = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hym = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.idI = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.iea = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.iea.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iea.setPageId(this.hBW.getUniqueId());
        this.iea.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.iea.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.iea.setShowOval(true);
        this.iea.setPlaceHolder(2);
        this.idL = this.mParent.findViewById(R.id.level_container);
        this.idK = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.idJ = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.idN = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.hIp = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.hIr = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.hIq = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.hIq.setIsRound(true);
        this.hIq.setDrawBorder(true);
        this.hIq.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hIq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hIs = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.hIt = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.hIu = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.aWQ().a(this.hIt, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.idV = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.idH = LayoutInflater.from(this.hBW.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.hIv = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.idH.setVisibility(8);
        this.ied = new com.baidu.tieba.frs.f.b(this.dPv);
    }

    protected View cbm() {
        return LayoutInflater.from(this.hBW.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void z(View.OnClickListener onClickListener) {
        this.iea.setOnClickListener(onClickListener);
        this.hym.setOnClickListener(onClickListener);
        this.hZO.setOnClickListener(onClickListener);
        this.hZH.setOnClickListener(onClickListener);
        this.idL.setOnClickListener(onClickListener);
        if (this.hIv != null) {
            this.hIv.setOnClickListener(onClickListener);
        }
        if (this.hIp != null) {
            this.hIp.setOnClickListener(onClickListener);
        }
        if (this.hIs != null) {
            this.hIs.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cbn() {
        this.idI.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.dPv.getLayoutMode().setNightMode(i == 1);
        this.dPv.getLayoutMode().onModeChanged(this.mParent);
        this.dPv.getLayoutMode().onModeChanged(this.idV);
        this.dPv.getLayoutMode().onModeChanged(this.idH);
        an.setBackgroundResource(this.hwi, R.drawable.frs_exp_progress);
        an.setBackgroundResource(this.hIl, R.drawable.bg_frs_header_round_corner);
        an.setBackgroundColor(this.idU, R.color.cp_bg_line_b);
        an.setBackgroundColor(this.hIn, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.hIo, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.hwj, R.color.cp_cont_a);
        an.setBackgroundColor(this.idN, R.color.black_alpha0);
        an.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.idR, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.idT, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.hIm, R.color.cp_bg_line_d);
        an.setViewTextColor(this.hym, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.idM, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.idG, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.hIe, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.idE, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.hIf, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.idF, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.hIr, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.hIu, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.idF, (int) R.color.cp_cont_a);
        if (this.iea != null) {
            this.iea.setBorderWidth(l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds1));
            this.iea.setBorderColor(an.getColor(R.color.cp_mask_b_alpha16));
            this.iea.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iea.setPlaceHolder(2);
            this.iea.invalidate();
        }
        if (this.hIq != null) {
            this.hIq.invalidate();
        }
        if (this.ieb != null) {
            this.ieb.onChangeSkin(i);
        }
        if (this.hYl != null) {
            this.hYl.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.hIg.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cbC();
        wz(this.ieo ? 1 : 0);
        cbr();
        uX(i);
        T(cbv(), cbw());
        if (this.idQ != null) {
            this.idQ.onChangeSkinType(i);
        }
        if (this.idT != null) {
            this.idT.onChangeSkinType(i);
        }
        if (this.idS != null) {
            this.idS.onChangeSkinType(i);
        }
        if (this.hIv != null) {
            this.hIv.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bB(boolean z) {
        super.bB(z);
        if (this.idS != null) {
            this.idS.bB(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.iei = forumData.getPost_num();
            this.ief = forumData.getTag_color();
            this.bFH = forumData.getImage_url();
            this.iee = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.iej = forumData.getSignData().count_sign_num;
                this.iek = forumData.getSignData().miss_sign_num;
            }
            this.iel = forumData.getCurScore();
            this.hZR = forumData.getLevelupScore();
            this.iec = forumData.getBadgeData();
            this.ieg = forumData.getAccelerateContent();
            this.ieq = forumData.isBrandForum;
            this.iaT = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.iaT != null && this.iaT.getHotUserRankData() != null && this.iaT.getHotUserRankData().hot_user != null && this.iaT.getHotUserRankData().hot_user.size() >= 3) {
                this.hIv.setVisibility(0);
                this.hIv.setData(this.iaT.getHotUserRankData(), this.hIi);
            } else {
                this.hIv.setVisibility(8);
            }
            if (this.iaT != null && this.iaT.serviceAreaData != null) {
                this.idQ.setVisibility(0);
                this.idQ.setData(this.iaT.serviceAreaData);
            } else {
                this.idQ.setVisibility(8);
            }
            this.ieh = new bu();
            cbo();
            cbs();
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
                this.hIr.setText(str);
                this.hIq.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.hIp.setVisibility(0);
            } else {
                this.hIp.setVisibility(8);
            }
            if (this.hIs.getVisibility() == 0) {
                this.hIs.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hIp.getVisibility() == 0) {
            this.hIp.setVisibility(8);
        }
        if (this.hIs.getVisibility() == 8) {
            this.hIs.setVisibility(0);
        }
    }

    protected void cbo() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bFH);
        this.ieh.aSy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cbp() {
        if (this.iae != null) {
            this.iae.vY(this.iek);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cbq() {
        if (this.iae != null) {
            this.iae.cbq();
        }
    }

    protected void cbr() {
        if (this.iaf != null) {
            this.iaf.cbr();
        }
    }

    protected void cbs() {
        if (this.idE != null) {
            this.idE.setText(ar.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.idF != null) {
            this.idF.setText(ar.numberUniformFormatExtra(this.iei));
        }
        if (this.iec != null && this.iec.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.ieq) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.dPv.getString(R.string.forum);
        if (this.bjy != null) {
            this.bjy.setText(str);
        }
        if (this.hym != null) {
            this.hym.setText(str);
        }
        cbz();
        this.hIi = cby();
        if (this.hIi) {
            this.hYl.setVisibility(8);
            this.gaf.setVisibility(0);
        } else {
            this.gaf.setVisibility(8);
            this.hYl.setVisibility(0);
            this.idP.setOnClickListener(null);
        }
        cbx();
        uX(TbadkCoreApplication.getInst().getSkinType());
        cbt();
    }

    private void cbt() {
        boolean cbv = cbv();
        boolean cbw = cbw();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e FH = d.ceD().FH(this.mForumName);
            if (FH == null) {
                FH = new e(this.hIj, cbv);
            } else {
                FH.nS(this.hIj);
                FH.nT(cbv);
            }
            d.ceD().a(this.mForumName, FH);
        }
        S(cbv, cbw);
        T(cbv, cbw);
    }

    private void S(boolean z, boolean z2) {
        if (this.hBW.bXY() != null) {
            if (!z && !z2) {
                this.hIk.setVisibility(8);
            } else {
                this.hIk.setVisibility(0);
            }
            this.hBW.bXY().V(z, z2);
        }
    }

    private void T(boolean z, boolean z2) {
        int dimens;
        if (this.idO != null && this.idO.getLayoutParams() != null) {
            if (this.hIv.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.idN.getLayoutParams()).topMargin = l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds384);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.hIi) {
                dimens -= l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds80);
            } else if (this.hIi) {
                int dimens3 = l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds782);
                int U = U(z, z2);
                int i = dimens3 + U;
                ((RelativeLayout.LayoutParams) this.idP.getLayoutParams()).bottomMargin = U;
                if (U != 0) {
                    ((RelativeLayout.LayoutParams) this.idN.getLayoutParams()).topMargin = l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.idN.getLayoutParams()).topMargin = l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.hIi) {
                if (cbu() != null) {
                    cbu().setVisibility(8);
                }
            } else if (cbu() != null) {
                cbu().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.idO.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.idO.setLayoutParams(layoutParams);
            }
        }
    }

    private int U(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.iaT.serviceAreaData == null || this.iaT.serviceAreaData.dataList == null || this.iaT.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.hIw != null) {
            i += Math.min(this.hIw.size(), 2) * l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds83);
        }
        if (this.idR.getVisibility() == 0) {
            i += l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.idR.getVisibility() == 0) {
            return i + l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cbu() {
        if (this.hBW == null || this.hBW.bXY() == null) {
            return null;
        }
        View cfJ = this.hBW.bXY().cfJ();
        if (cfJ instanceof LinearGradientView) {
            return (LinearGradientView) cfJ;
        }
        return null;
    }

    private boolean cbv() {
        return this.idT != null && this.idT.getVisibility() == 0;
    }

    private boolean cbw() {
        return this.idQ != null && this.idQ.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cbx() {
        if (this.hBW != null && this.iaT != null) {
            List<q> showTopThreadList = this.iaT.getShowTopThreadList();
            this.hIj = showTopThreadList.size() > 2;
            a(showTopThreadList, this.iaT.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.idT != null) {
            this.hIw = list;
            if (iVar != null) {
                this.idS = new g(this.dPv.getPageActivity());
                this.idR.setVisibility(0);
                this.idR.addView(this.idS.getView());
                this.idS.a(this.iaT != null ? this.iaT.getForum() : null, iVar);
            } else {
                this.idR.setVisibility(8);
            }
            if (this.hBW != null && this.hBW.bYh()) {
                this.idT.setVisibility(0);
                this.idT.setFragmentUniqueId(this.hBW.getUniqueId());
                this.idT.setForum(this.mForumId, this.mForumName, this.iaT != null ? this.iaT.getForum() : null);
                this.idT.setDatas(list, iVar);
                if (this.hIh == null) {
                    this.hIh = new ax() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.ax
                        public void ao(bu buVar) {
                            h.a(b.this.hBW, b.this.iaT, buVar);
                        }
                    };
                }
                this.idT.setStatListener(this.hIh);
                return;
            }
            this.idT.setVisibility(8);
        }
    }

    private boolean cby() {
        final w wVar;
        if (this.iaT == null) {
            return false;
        }
        final FrsViewData frsViewData = this.iaT;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dhn())) {
            wVar = new w();
            wVar.setLinkUrl("");
            wVar.setImageUrl(frsViewData.getStar().dhn());
        } else {
            wVar = (frsViewData.getActivityHeadData() == null || com.baidu.tbadk.core.util.w.getCount(frsViewData.getActivityHeadData().aQt()) < 1) ? null : frsViewData.getActivityHeadData().aQt().get(0);
        }
        if (wVar != null) {
            if (this.idP != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aQu())) {
                    ao aoVar = new ao("c13326");
                    aoVar.dk("fid", frsViewData.getForum().getId());
                    aoVar.dk("obj_id", frsViewData.getActivityHeadData().aQu());
                    TiebaStatic.log(aoVar);
                    ao aoVar2 = new ao("common_exp");
                    aoVar2.dk("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).ag("obj_floor", 1).dk("fid", frsViewData.getForum().getId()).dk("obj_id", frsViewData.getActivityHeadData().aQu()).ag("obj_adlocate", 1).dk("first_dir", frsViewData.getForum().getFirst_class()).dk("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aoVar.dk("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ejy);
                    }
                    com.baidu.tieba.s.c.dgY().a(this.hBW.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aQu(), "", (BaijiahaoData) null), aoVar2);
                }
                this.idP.startLoad(wVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(wVar.getLinkUrl())) {
                    this.idP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.dPv != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aQu())) {
                                    String id = frsViewData.getForum().getId();
                                    String aQu = frsViewData.getActivityHeadData().aQu();
                                    ao aoVar3 = new ao("c13330");
                                    aoVar3.dk("fid", id);
                                    aoVar3.dk("obj_id", aQu);
                                    TiebaStatic.log(aoVar3);
                                    ao aoVar4 = new ao("common_click");
                                    aoVar4.dk("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).dk("fid", id).dk("obj_id", aQu).ag("obj_adlocate", 1).ag("obj_floor", 1).dk("first_dir", frsViewData.getForum().getFirst_class()).dk("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aoVar3.dk("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ejy);
                                    }
                                    com.baidu.tieba.s.c.dgY().b(b.this.hBW.getUniqueId(), aoVar4);
                                }
                                bc.aWU().a(b.this.dPv, new String[]{wVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void uX(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iaT != null && (forum = this.iaT.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hIi) {
                LinearGradientView cbu = cbu();
                if (this.hYl != null && cbu != null) {
                    this.hYl.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    cbu.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.idP != null) {
                    this.idP.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.idQ != null) {
                this.idQ.setThemeFontColor(com.baidu.tieba.lego.card.d.a.dV(themeElement.font_color));
            }
            if (this.idT != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.idT.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.dV(str));
            }
        }
    }

    protected void cbz() {
        this.iea.startLoad(this.bFH, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.iew);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.dPv.getPageActivity());
                this.mPopup.setContentView(this.idV);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.idW = (TextView) this.idV.findViewById(R.id.cur_experience);
            this.idX = (TextView) this.idV.findViewById(R.id.levelup_experience);
            an.setBackgroundResource(this.idV.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            an.setViewTextColor((TextView) this.idV.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            an.setViewTextColor(this.idW, R.color.common_color_10047, 1);
            an.setViewTextColor(this.idX, R.color.cp_cont_g, 1);
            a(this.idW, this.idX);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.dPv.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.dPv.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.iew, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.dPv.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            an.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            an.setViewTextColor(textView, R.color.cp_cont_b, 1);
            an.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            an.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
            aVar.aP(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.ieg) && !TextUtils.isEmpty(this.ieg.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.ieg);
            } else {
                textView3.setVisibility(8);
            }
            aVar.kU(R.color.cp_link_tip_d);
            a(aVar);
            b(aVar);
            aVar.b(this.dPv);
            aVar.aUN();
        }
    }

    protected void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (b.this.dPv != null && b.this.dPv.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.dPv.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cbA() {
        View contentView;
        if (this.idZ == null) {
            this.idZ = new PopupWindow(this.dPv.getPageActivity());
            View inflate = LayoutInflater.from(this.dPv.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.idZ.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dPv != null && b.this.dPv.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.idZ, b.this.dPv.getPageActivity());
                        b.this.hBW.hzx = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.dPv.getPageActivity(), b.this.dPv.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.idZ.setWidth(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.idZ.setHeight(this.dPv.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.idZ.setBackgroundDrawable(new BitmapDrawable());
            this.idZ.setOutsideTouchable(true);
            this.idZ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.idZ);
                        b.this.hBW.hzx = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.idZ.getContentView();
        }
        an.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        an.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        an.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.idY.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.idZ, this.mParent, 0, (iArr[0] - (this.idZ.getWidth() / 2)) + (this.idY.getWidth() / 2), iArr[1] + this.idY.getWidth());
        this.idZ.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.iep = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.idG != null && this.hwi != null && this.idM != null && cashBitmap.getWidth() > 0) {
            if (this.iep) {
                this.idG.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bYC = this.hBW.bYC();
                if (bYC != null && bYC.getForum() != null) {
                    bYC.getForum().setUser_level(i);
                }
                this.idM.setText(this.dPv.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.idG.setText(this.iee);
                this.idM.setText(this.dPv.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hwi.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, tY(this.mLevel)));
            if (this.iep) {
                if (f >= 1.0f) {
                    b(this.hwi, this.ier, f);
                } else {
                    c(this.hwi, this.ier, f);
                }
            } else {
                b(this.hwi, this.ier, f);
            }
            this.ier = f;
        }
    }

    private int[] tY(int i) {
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
    protected void cbB() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cbC() {
        if (this.mMemberType != 0) {
            an.setImageResource(this.idY, R.drawable.icon_sml_speed_orange);
        } else {
            an.setImageResource(this.idY, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.idZ != null && this.idZ.isShowing()) {
            this.idZ.dismiss();
        }
        if (this.idS != null) {
            this.idS.onDestroy();
        }
    }
}
