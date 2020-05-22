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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.s;
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
    private String bAT;
    private View fOe;
    private TextView hvb;
    private TextView hvc;
    private ar hve;
    private boolean hvf;
    private LinearLayout hvh;
    private View hvi;
    private View hvj;
    private View hvk;
    private View hvl;
    private final View hvm;
    private final HeadImageView hvn;
    private final TextView hvo;
    private final View hvp;
    private final ImageView hvq;
    private final TextView hvr;
    private HotRankEntryView hvs;
    private RelativeLayout mContainer;
    private boolean hvg = false;
    private ArrayList<TbImageView> hvd = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hpb = frsFragment;
        this.dIF = frsFragment.getPageContext();
        this.hPt = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hPu = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.hPv = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bXU();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.hPG = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.hKm = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.hPH = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.hPH.setPageId(this.hpb.getUniqueId());
        this.hPH.setDefaultBgResource(R.color.transparent);
        this.hPH.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hPH.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.fOe = this.mParent.findViewById(R.id.header_top_cover);
        this.hvh = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.hvi = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.hvj = this.mParent.findViewById(R.id.no_service_space);
        this.hPI = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.hPJ = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.hPL = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.hvk = this.mParent.findViewById(R.id.frs_topview_space);
        this.hvl = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.hPM = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.hPQ = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.hvb = (TextView) this.mParent.findViewById(R.id.member_image);
        this.hvc = (TextView) this.mParent.findViewById(R.id.post_image);
        this.hPy = (TextView) this.mParent.findViewById(R.id.level_name);
        this.hPE = (TextView) this.mParent.findViewById(R.id.level);
        this.hLI = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.hLI.setText(frsFragment.getResources().getString(R.string.attention));
        this.hLI.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mj(R.color.cp_cont_b);
        this.hLI.setConfig(cVar);
        this.hLP = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.hLP.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.mj(R.color.cp_cont_b);
        cVar2.mf(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.hLP.setConfig(cVar2);
        this.hLP.setText(frsFragment.getResources().getString(R.string.sign));
        this.hjQ = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hjR = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.hPw = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.hPx = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hlU = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.hPA = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.hPS = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.hPS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hPS.setPageId(this.hpb.getUniqueId());
        this.hPS.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.hPS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.hPS.setShowOval(true);
        this.hPS.setPlaceHolder(2);
        this.hPD = this.mParent.findViewById(R.id.level_container);
        this.hPC = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.hPB = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.hPF = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.hvm = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.hvo = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.hvn = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.hvn.setIsRound(true);
        this.hvn.setDrawBorder(true);
        this.hvn.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hvn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hvp = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.hvq = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.hvr = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.aUV().a(this.hvq, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.hPN = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.hPz = LayoutInflater.from(this.hpb.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.hvs = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.hPz.setVisibility(8);
        this.hPV = new com.baidu.tieba.frs.f.b(this.dIF);
    }

    protected View bXU() {
        return LayoutInflater.from(this.hpb.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void y(View.OnClickListener onClickListener) {
        this.hPS.setOnClickListener(onClickListener);
        this.hlU.setOnClickListener(onClickListener);
        this.hLP.setOnClickListener(onClickListener);
        this.hLI.setOnClickListener(onClickListener);
        this.hPD.setOnClickListener(onClickListener);
        if (this.hvs != null) {
            this.hvs.setOnClickListener(onClickListener);
        }
        if (this.hvm != null) {
            this.hvm.setOnClickListener(onClickListener);
        }
        if (this.hvp != null) {
            this.hvp.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bXV() {
        this.hPA.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.dIF.getLayoutMode().setNightMode(i == 1);
        this.dIF.getLayoutMode().onModeChanged(this.mParent);
        this.dIF.getLayoutMode().onModeChanged(this.hPN);
        this.dIF.getLayoutMode().onModeChanged(this.hPz);
        am.setBackgroundResource(this.hjQ, R.drawable.frs_exp_progress);
        am.setBackgroundResource(this.hvi, R.drawable.bg_frs_header_round_corner);
        am.setBackgroundColor(this.hPM, R.color.cp_bg_line_b);
        am.setBackgroundColor(this.hvk, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hvl, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hjR, R.color.cp_cont_a);
        am.setBackgroundColor(this.hPF, R.color.black_alpha0);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hPJ, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hPL, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hvj, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hlU, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hPE, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hPy, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvb, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hPw, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvc, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hPx, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvo, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvr, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hPx, (int) R.color.cp_cont_a);
        if (this.hPS != null) {
            this.hPS.setBorderWidth(l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds1));
            this.hPS.setBorderColor(am.getColor(R.color.cp_mask_b_alpha16));
            this.hPS.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hPS.setPlaceHolder(2);
            this.hPS.invalidate();
        }
        if (this.hvn != null) {
            this.hvn.invalidate();
        }
        if (this.hPT != null) {
            this.hPT.onChangeSkin(i);
        }
        if (this.hKm != null) {
            this.hKm.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.hvd.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bYk();
        vR(this.hQg ? 1 : 0);
        bXZ();
        uq(i);
        T(bYd(), bYe());
        if (this.hPI != null) {
            this.hPI.onChangeSkinType(i);
        }
        if (this.hPL != null) {
            this.hPL.onChangeSkinType(i);
        }
        if (this.hPK != null) {
            this.hPK.onChangeSkinType(i);
        }
        if (this.hvs != null) {
            this.hvs.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bB(boolean z) {
        super.bB(z);
        if (this.hPK != null) {
            this.hPK.bB(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.hQa = forumData.getPost_num();
            this.hPX = forumData.getTag_color();
            this.bAT = forumData.getImage_url();
            this.hPW = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.hQb = forumData.getSignData().count_sign_num;
                this.hQc = forumData.getSignData().miss_sign_num;
            }
            this.hQd = forumData.getCurScore();
            this.hLS = forumData.getLevelupScore();
            this.hPU = forumData.getBadgeData();
            this.hPY = forumData.getAccelerateContent();
            this.hQi = forumData.isBrandForum;
            this.hMU = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.hMU != null && this.hMU.getHotUserRankData() != null && this.hMU.getHotUserRankData().hot_user != null && this.hMU.getHotUserRankData().hot_user.size() >= 3) {
                this.hvs.setVisibility(0);
                this.hvs.setData(this.hMU.getHotUserRankData(), this.hvf);
            } else {
                this.hvs.setVisibility(8);
            }
            if (this.hMU != null && this.hMU.serviceAreaData != null) {
                this.hPI.setVisibility(0);
                this.hPI.setData(this.hMU.serviceAreaData);
            } else {
                this.hPI.setVisibility(8);
            }
            this.hPZ = new bk();
            bXW();
            bYa();
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
                this.hvo.setText(str);
                this.hvn.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.hvm.setVisibility(0);
            } else {
                this.hvm.setVisibility(8);
            }
            if (this.hvp.getVisibility() == 0) {
                this.hvp.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hvm.getVisibility() == 0) {
            this.hvm.setVisibility(8);
        }
        if (this.hvp.getVisibility() == 8) {
            this.hvp.setVisibility(0);
        }
    }

    protected void bXW() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bAT);
        this.hPZ.aQH().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bXX() {
        if (this.hMf != null) {
            this.hMf.vr(this.hQc);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bXY() {
        if (this.hMf != null) {
            this.hMf.bXY();
        }
    }

    protected void bXZ() {
        if (this.hMg != null) {
            this.hMg.bXZ();
        }
    }

    protected void bYa() {
        if (this.hPw != null) {
            this.hPw.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.hPx != null) {
            this.hPx.setText(aq.numberUniformFormatExtra(this.hQa));
        }
        if (this.hPU != null && this.hPU.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.hQi) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.dIF.getString(R.string.forum);
        if (this.bem != null) {
            this.bem.setText(str);
        }
        if (this.hlU != null) {
            this.hlU.setText(str);
        }
        bYh();
        this.hvf = bYg();
        if (this.hvf) {
            this.hKm.setVisibility(8);
            this.fOe.setVisibility(0);
        } else {
            this.fOe.setVisibility(8);
            this.hKm.setVisibility(0);
            this.hPH.setOnClickListener(null);
        }
        bYf();
        uq(TbadkCoreApplication.getInst().getSkinType());
        bYb();
    }

    private void bYb() {
        boolean bYd = bYd();
        boolean bYe = bYe();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Fg = d.cbc().Fg(this.mForumName);
            if (Fg == null) {
                Fg = new e(this.hvg, bYd);
            } else {
                Fg.nG(this.hvg);
                Fg.nH(bYd);
            }
            d.cbc().a(this.mForumName, Fg);
        }
        S(bYd, bYe);
        T(bYd, bYe);
    }

    private void S(boolean z, boolean z2) {
        if (this.hpb.bUP() != null) {
            if (!z && !z2) {
                this.hvh.setVisibility(8);
            } else {
                this.hvh.setVisibility(0);
            }
            this.hpb.bUP().U(z, z2);
        }
    }

    private void T(boolean z, boolean z2) {
        int dimens;
        if (this.hPG != null && this.hPG.getLayoutParams() != null) {
            if (this.hvs.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.hPF.getLayoutParams()).topMargin = l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds384);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.hvf) {
                dimens -= l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds80);
            }
            if (!z && !z2 && this.hvf) {
                if (bYc() != null) {
                    bYc().setVisibility(8);
                }
            } else if (bYc() != null) {
                bYc().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.hPG.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.hPG.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearGradientView bYc() {
        if (this.hpb == null || this.hpb.bUP() == null) {
            return null;
        }
        View cci = this.hpb.bUP().cci();
        if (cci instanceof LinearGradientView) {
            return (LinearGradientView) cci;
        }
        return null;
    }

    private boolean bYd() {
        return this.hPL != null && this.hPL.getVisibility() == 0;
    }

    private boolean bYe() {
        return this.hPI != null && this.hPI.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bYf() {
        if (this.hpb != null && this.hMU != null) {
            List<o> showTopThreadList = this.hMU.getShowTopThreadList();
            this.hvg = showTopThreadList.size() > 2;
            a(showTopThreadList, this.hMU.getBusinessPromot());
        }
    }

    private void a(List<o> list, i iVar) {
        if (this.hPL != null) {
            if (iVar != null) {
                this.hPK = new g(this.dIF.getPageActivity());
                this.hPJ.setVisibility(0);
                this.hPJ.addView(this.hPK.getView());
                this.hPK.a(this.hMU != null ? this.hMU.getForum() : null, iVar);
            } else {
                this.hPJ.setVisibility(8);
            }
            if (this.hpb != null && this.hpb.bUY()) {
                this.hPL.setVisibility(0);
                this.hPL.setFragmentUniqueId(this.hpb.getUniqueId());
                this.hPL.setForum(this.mForumId, this.mForumName, this.hMU != null ? this.hMU.getForum() : null);
                this.hPL.setDatas(list, iVar);
                if (this.hve == null) {
                    this.hve = new ar() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.ar
                        public void ao(bk bkVar) {
                            h.a(b.this.hpb, b.this.hMU, bkVar);
                        }
                    };
                }
                this.hPL.setStatListener(this.hve);
                return;
            }
            this.hPL.setVisibility(8);
        }
    }

    private boolean bYg() {
        final s sVar;
        if (this.hMU == null) {
            return false;
        }
        final FrsViewData frsViewData = this.hMU;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dcI())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().dcI());
        } else {
            sVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aOG()) < 1) ? null : frsViewData.getActivityHeadData().aOG().get(0);
        }
        if (sVar != null) {
            if (this.hPH != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aOH())) {
                    an anVar = new an("c13326");
                    anVar.dh("fid", frsViewData.getForum().getId());
                    anVar.dh("obj_id", frsViewData.getActivityHeadData().aOH());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.dh("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).ag("obj_floor", 1).dh("fid", frsViewData.getForum().getId()).dh("obj_id", frsViewData.getActivityHeadData().aOH()).ag("obj_adlocate", 1).dh("first_dir", frsViewData.getForum().getFirst_class()).dh("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.dh("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eaO);
                    }
                    com.baidu.tieba.s.c.dct().a(this.hpb.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aOH(), "", (BaijiahaoData) null), anVar2);
                }
                this.hPH.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.hPH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.dIF != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aOH())) {
                                    String id = frsViewData.getForum().getId();
                                    String aOH = frsViewData.getActivityHeadData().aOH();
                                    an anVar3 = new an("c13330");
                                    anVar3.dh("fid", id);
                                    anVar3.dh("obj_id", aOH);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.dh("page_type", PageStayDurationConstants.PageName.FRS).ag("obj_isad", 1).dh("fid", id).dh("obj_id", aOH).ag("obj_adlocate", 1).ag("obj_floor", 1).dh("first_dir", frsViewData.getForum().getFirst_class()).dh("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.dh("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eaO);
                                    }
                                    com.baidu.tieba.s.c.dct().b(b.this.hpb.getUniqueId(), anVar4);
                                }
                                ba.aUZ().a(b.this.dIF, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void uq(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hMU != null && (forum = this.hMU.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hvf) {
                LinearGradientView bYc = bYc();
                if (this.hKm != null && bYc != null) {
                    this.hKm.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bYc.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.hPH != null) {
                    this.hPH.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.hPI != null) {
                this.hPI.setThemeFontColor(com.baidu.tieba.lego.card.d.a.dT(themeElement.font_color));
            }
            if (this.hPL != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.hPL.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.dT(str));
            }
        }
    }

    protected void bYh() {
        this.hPS.startLoad(this.bAT, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.hQo);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.dIF.getPageActivity());
                this.mPopup.setContentView(this.hPN);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.hPO = (TextView) this.hPN.findViewById(R.id.cur_experience);
            this.hPP = (TextView) this.hPN.findViewById(R.id.levelup_experience);
            am.setBackgroundResource(this.hPN.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.setViewTextColor((TextView) this.hPN.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.setViewTextColor(this.hPO, R.color.common_color_10047, 1);
            am.setViewTextColor(this.hPP, R.color.cp_cont_g, 1);
            a(this.hPO, this.hPP);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.dIF.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.dIF.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.hQo, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.dIF.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
            aVar.aP(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.hPY) && !TextUtils.isEmpty(this.hPY.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.hPY);
            } else {
                textView3.setVisibility(8);
            }
            aVar.kE(R.color.cp_link_tip_d);
            a(aVar);
            b(aVar);
            aVar.b(this.dIF);
            aVar.aST();
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
                if (b.this.dIF != null && b.this.dIF.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.dIF.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bYi() {
        View contentView;
        if (this.hPR == null) {
            this.hPR = new PopupWindow(this.dIF.getPageActivity());
            View inflate = LayoutInflater.from(this.dIF.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.hPR.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dIF != null && b.this.dIF.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hPR, b.this.dIF.getPageActivity());
                        b.this.hpb.hmV = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.dIF.getPageActivity(), b.this.dIF.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.hPR.setWidth(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.hPR.setHeight(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.hPR.setBackgroundDrawable(new BitmapDrawable());
            this.hPR.setOutsideTouchable(true);
            this.hPR.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hPR);
                        b.this.hpb.hmV = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.hPR.getContentView();
        }
        am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.hPQ.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.hPR, this.mParent, 0, (iArr[0] - (this.hPR.getWidth() / 2)) + (this.hPQ.getWidth() / 2), iArr[1] + this.hPQ.getWidth());
        this.hPR.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.hQh = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.hPy != null && this.hjQ != null && this.hPE != null && cashBitmap.getWidth() > 0) {
            if (this.hQh) {
                this.hPy.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bVs = this.hpb.bVs();
                if (bVs != null && bVs.getForum() != null) {
                    bVs.getForum().setUser_level(i);
                }
                this.hPE.setText(this.dIF.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.hPy.setText(this.hPW);
                this.hPE.setText(this.dIF.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hjQ.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, tv(this.mLevel)));
            if (this.hQh) {
                if (f >= 1.0f) {
                    b(this.hjQ, this.hQj, f);
                } else {
                    c(this.hjQ, this.hQj, f);
                }
            } else {
                b(this.hjQ, this.hQj, f);
            }
            this.hQj = f;
        }
    }

    private int[] tv(int i) {
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
    protected void bYj() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bYk() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hPQ, R.drawable.icon_sml_speed_orange);
        } else {
            am.setImageResource(this.hPQ, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hPR != null && this.hPR.isShowing()) {
            this.hPR.dismiss();
        }
        if (this.hPK != null) {
            this.hPK.onDestroy();
        }
    }
}
