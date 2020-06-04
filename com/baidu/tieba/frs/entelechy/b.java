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
    private View fOp;
    private final View hvA;
    private final ImageView hvB;
    private final TextView hvC;
    private HotRankEntryView hvD;
    private TextView hvm;
    private TextView hvn;
    private ar hvp;
    private boolean hvq;
    private LinearLayout hvs;
    private View hvt;
    private View hvu;
    private View hvv;
    private View hvw;
    private final View hvx;
    private final HeadImageView hvy;
    private final TextView hvz;
    private RelativeLayout mContainer;
    private boolean hvr = false;
    private ArrayList<TbImageView> hvo = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.hpm = frsFragment;
        this.dIF = frsFragment.getPageContext();
        this.hQg = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.hQh = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.hQi = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bXX();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.hQt = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.hKZ = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.hQu = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.hQu.setPageId(this.hpm.getUniqueId());
        this.hQu.setDefaultBgResource(R.color.transparent);
        this.hQu.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hQu.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.fOp = this.mParent.findViewById(R.id.header_top_cover);
        this.hvs = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.hvt = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.hvu = this.mParent.findViewById(R.id.no_service_space);
        this.hQv = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.hQw = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.hQy = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.hvv = this.mParent.findViewById(R.id.frs_topview_space);
        this.hvw = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.hQz = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.hQD = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.hvm = (TextView) this.mParent.findViewById(R.id.member_image);
        this.hvn = (TextView) this.mParent.findViewById(R.id.post_image);
        this.hQl = (TextView) this.mParent.findViewById(R.id.level_name);
        this.hQr = (TextView) this.mParent.findViewById(R.id.level);
        this.hMv = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.hMv.setText(frsFragment.getResources().getString(R.string.attention));
        this.hMv.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ml(R.color.cp_cont_b);
        this.hMv.setConfig(cVar);
        this.hMC = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.hMC.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.ml(R.color.cp_cont_b);
        cVar2.mh(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.hMC.setConfig(cVar2);
        this.hMC.setText(frsFragment.getResources().getString(R.string.sign));
        this.hkb = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.hkc = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.hQj = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.hQk = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.hmf = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.hQn = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.hQF = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.hQF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hQF.setPageId(this.hpm.getUniqueId());
        this.hQF.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.hQF.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.hQF.setShowOval(true);
        this.hQF.setPlaceHolder(2);
        this.hQq = this.mParent.findViewById(R.id.level_container);
        this.hQp = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.hQo = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.hQs = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.hvx = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.hvz = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.hvy = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.hvy.setIsRound(true);
        this.hvy.setDrawBorder(true);
        this.hvy.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hvy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hvA = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.hvB = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.hvC = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.aUW().a(this.hvB, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.hQA = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.hQm = LayoutInflater.from(this.hpm.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.hvD = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.hQm.setVisibility(8);
        this.hQI = new com.baidu.tieba.frs.f.b(this.dIF);
    }

    protected View bXX() {
        return LayoutInflater.from(this.hpm.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void y(View.OnClickListener onClickListener) {
        this.hQF.setOnClickListener(onClickListener);
        this.hmf.setOnClickListener(onClickListener);
        this.hMC.setOnClickListener(onClickListener);
        this.hMv.setOnClickListener(onClickListener);
        this.hQq.setOnClickListener(onClickListener);
        if (this.hvD != null) {
            this.hvD.setOnClickListener(onClickListener);
        }
        if (this.hvx != null) {
            this.hvx.setOnClickListener(onClickListener);
        }
        if (this.hvA != null) {
            this.hvA.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bXY() {
        this.hQn.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.dIF.getLayoutMode().setNightMode(i == 1);
        this.dIF.getLayoutMode().onModeChanged(this.mParent);
        this.dIF.getLayoutMode().onModeChanged(this.hQA);
        this.dIF.getLayoutMode().onModeChanged(this.hQm);
        am.setBackgroundResource(this.hkb, R.drawable.frs_exp_progress);
        am.setBackgroundResource(this.hvt, R.drawable.bg_frs_header_round_corner);
        am.setBackgroundColor(this.hQz, R.color.cp_bg_line_b);
        am.setBackgroundColor(this.hvv, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hvw, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hkc, R.color.cp_cont_a);
        am.setBackgroundColor(this.hQs, R.color.black_alpha0);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hQw, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hQy, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hvu, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hmf, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hQr, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hQl, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvm, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hQj, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvn, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hQk, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvz, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hvC, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hQk, (int) R.color.cp_cont_a);
        if (this.hQF != null) {
            this.hQF.setBorderWidth(l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds1));
            this.hQF.setBorderColor(am.getColor(R.color.cp_mask_b_alpha16));
            this.hQF.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hQF.setPlaceHolder(2);
            this.hQF.invalidate();
        }
        if (this.hvy != null) {
            this.hvy.invalidate();
        }
        if (this.hQG != null) {
            this.hQG.onChangeSkin(i);
        }
        if (this.hKZ != null) {
            this.hKZ.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.hvo.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bYn();
        vT(this.hQT ? 1 : 0);
        bYc();
        us(i);
        T(bYg(), bYh());
        if (this.hQv != null) {
            this.hQv.onChangeSkinType(i);
        }
        if (this.hQy != null) {
            this.hQy.onChangeSkinType(i);
        }
        if (this.hQx != null) {
            this.hQx.onChangeSkinType(i);
        }
        if (this.hvD != null) {
            this.hvD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bB(boolean z) {
        super.bB(z);
        if (this.hQx != null) {
            this.hQx.bB(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.hQN = forumData.getPost_num();
            this.hQK = forumData.getTag_color();
            this.bAT = forumData.getImage_url();
            this.hQJ = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.hQO = forumData.getSignData().count_sign_num;
                this.hQP = forumData.getSignData().miss_sign_num;
            }
            this.hQQ = forumData.getCurScore();
            this.hMF = forumData.getLevelupScore();
            this.hQH = forumData.getBadgeData();
            this.hQL = forumData.getAccelerateContent();
            this.hQV = forumData.isBrandForum;
            this.hNH = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.hNH != null && this.hNH.getHotUserRankData() != null && this.hNH.getHotUserRankData().hot_user != null && this.hNH.getHotUserRankData().hot_user.size() >= 3) {
                this.hvD.setVisibility(0);
                this.hvD.setData(this.hNH.getHotUserRankData(), this.hvq);
            } else {
                this.hvD.setVisibility(8);
            }
            if (this.hNH != null && this.hNH.serviceAreaData != null) {
                this.hQv.setVisibility(0);
                this.hQv.setData(this.hNH.serviceAreaData);
            } else {
                this.hQv.setVisibility(8);
            }
            this.hQM = new bk();
            bXZ();
            bYd();
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
                this.hvz.setText(str);
                this.hvy.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.hvx.setVisibility(0);
            } else {
                this.hvx.setVisibility(8);
            }
            if (this.hvA.getVisibility() == 0) {
                this.hvA.setVisibility(8);
                return;
            }
            return;
        }
        if (this.hvx.getVisibility() == 0) {
            this.hvx.setVisibility(8);
        }
        if (this.hvA.getVisibility() == 8) {
            this.hvA.setVisibility(0);
        }
    }

    protected void bXZ() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bAT);
        this.hQM.aQH().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bYa() {
        if (this.hMS != null) {
            this.hMS.vt(this.hQP);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bYb() {
        if (this.hMS != null) {
            this.hMS.bYb();
        }
    }

    protected void bYc() {
        if (this.hMT != null) {
            this.hMT.bYc();
        }
    }

    protected void bYd() {
        if (this.hQj != null) {
            this.hQj.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.hQk != null) {
            this.hQk.setText(aq.numberUniformFormatExtra(this.hQN));
        }
        if (this.hQH != null && this.hQH.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.hQV) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.dIF.getString(R.string.forum);
        if (this.bem != null) {
            this.bem.setText(str);
        }
        if (this.hmf != null) {
            this.hmf.setText(str);
        }
        bYk();
        this.hvq = bYj();
        if (this.hvq) {
            this.hKZ.setVisibility(8);
            this.fOp.setVisibility(0);
        } else {
            this.fOp.setVisibility(8);
            this.hKZ.setVisibility(0);
            this.hQu.setOnClickListener(null);
        }
        bYi();
        us(TbadkCoreApplication.getInst().getSkinType());
        bYe();
    }

    private void bYe() {
        boolean bYg = bYg();
        boolean bYh = bYh();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Fg = d.cbk().Fg(this.mForumName);
            if (Fg == null) {
                Fg = new e(this.hvr, bYg);
            } else {
                Fg.nG(this.hvr);
                Fg.nH(bYg);
            }
            d.cbk().a(this.mForumName, Fg);
        }
        S(bYg, bYh);
        T(bYg, bYh);
    }

    private void S(boolean z, boolean z2) {
        if (this.hpm.bUR() != null) {
            if (!z && !z2) {
                this.hvs.setVisibility(8);
            } else {
                this.hvs.setVisibility(0);
            }
            this.hpm.bUR().U(z, z2);
        }
    }

    private void T(boolean z, boolean z2) {
        int dimens;
        if (this.hQt != null && this.hQt.getLayoutParams() != null) {
            if (this.hvD.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.hQs.getLayoutParams()).topMargin = l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds384);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.hvq) {
                dimens -= l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds80);
            }
            if (!z && !z2 && this.hvq) {
                if (bYf() != null) {
                    bYf().setVisibility(8);
                }
            } else if (bYf() != null) {
                bYf().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.hQt.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.hQt.setLayoutParams(layoutParams);
            }
        }
    }

    private LinearGradientView bYf() {
        if (this.hpm == null || this.hpm.bUR() == null) {
            return null;
        }
        View ccq = this.hpm.bUR().ccq();
        if (ccq instanceof LinearGradientView) {
            return (LinearGradientView) ccq;
        }
        return null;
    }

    private boolean bYg() {
        return this.hQy != null && this.hQy.getVisibility() == 0;
    }

    private boolean bYh() {
        return this.hQv != null && this.hQv.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bYi() {
        if (this.hpm != null && this.hNH != null) {
            List<o> showTopThreadList = this.hNH.getShowTopThreadList();
            this.hvr = showTopThreadList.size() > 2;
            a(showTopThreadList, this.hNH.getBusinessPromot());
        }
    }

    private void a(List<o> list, i iVar) {
        if (this.hQy != null) {
            if (iVar != null) {
                this.hQx = new g(this.dIF.getPageActivity());
                this.hQw.setVisibility(0);
                this.hQw.addView(this.hQx.getView());
                this.hQx.a(this.hNH != null ? this.hNH.getForum() : null, iVar);
            } else {
                this.hQw.setVisibility(8);
            }
            if (this.hpm != null && this.hpm.bVa()) {
                this.hQy.setVisibility(0);
                this.hQy.setFragmentUniqueId(this.hpm.getUniqueId());
                this.hQy.setForum(this.mForumId, this.mForumName, this.hNH != null ? this.hNH.getForum() : null);
                this.hQy.setDatas(list, iVar);
                if (this.hvp == null) {
                    this.hvp = new ar() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.ar
                        public void ao(bk bkVar) {
                            h.a(b.this.hpm, b.this.hNH, bkVar);
                        }
                    };
                }
                this.hQy.setStatListener(this.hvp);
                return;
            }
            this.hQy.setVisibility(8);
        }
    }

    private boolean bYj() {
        final s sVar;
        if (this.hNH == null) {
            return false;
        }
        final FrsViewData frsViewData = this.hNH;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dcX())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().dcX());
        } else {
            sVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aOG()) < 1) ? null : frsViewData.getActivityHeadData().aOG().get(0);
        }
        if (sVar != null) {
            if (this.hQu != null) {
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
                    com.baidu.tieba.s.c.dcI().a(this.hpm.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aOH(), "", (BaijiahaoData) null), anVar2);
                }
                this.hQu.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.hQu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
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
                                    com.baidu.tieba.s.c.dcI().b(b.this.hpm.getUniqueId(), anVar4);
                                }
                                ba.aVa().a(b.this.dIF, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void us(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hNH != null && (forum = this.hNH.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hvq) {
                LinearGradientView bYf = bYf();
                if (this.hKZ != null && bYf != null) {
                    this.hKZ.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bYf.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.hQu != null) {
                    this.hQu.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.hQv != null) {
                this.hQv.setThemeFontColor(com.baidu.tieba.lego.card.d.a.dT(themeElement.font_color));
            }
            if (this.hQy != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.hQy.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.dT(str));
            }
        }
    }

    protected void bYk() {
        this.hQF.startLoad(this.bAT, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.hRb);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.dIF.getPageActivity());
                this.mPopup.setContentView(this.hQA);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.hQB = (TextView) this.hQA.findViewById(R.id.cur_experience);
            this.hQC = (TextView) this.hQA.findViewById(R.id.levelup_experience);
            am.setBackgroundResource(this.hQA.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.setViewTextColor((TextView) this.hQA.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.setViewTextColor(this.hQB, R.color.common_color_10047, 1);
            am.setViewTextColor(this.hQC, R.color.cp_cont_g, 1);
            a(this.hQB, this.hQC);
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
            this.mHandler.postDelayed(this.hRb, 2000L);
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
            if (!TextUtils.isEmpty(this.hQL) && !TextUtils.isEmpty(this.hQL.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.hQL);
            } else {
                textView3.setVisibility(8);
            }
            aVar.kG(R.color.cp_link_tip_d);
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
    public void bYl() {
        View contentView;
        if (this.hQE == null) {
            this.hQE = new PopupWindow(this.dIF.getPageActivity());
            View inflate = LayoutInflater.from(this.dIF.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.hQE.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.dIF != null && b.this.dIF.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hQE, b.this.dIF.getPageActivity());
                        b.this.hpm.hng = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.dIF.getPageActivity(), b.this.dIF.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.hQE.setWidth(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.hQE.setHeight(this.dIF.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.hQE.setBackgroundDrawable(new BitmapDrawable());
            this.hQE.setOutsideTouchable(true);
            this.hQE.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.hQE);
                        b.this.hpm.hng = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.hQE.getContentView();
        }
        am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.hQD.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.hQE, this.mParent, 0, (iArr[0] - (this.hQE.getWidth() / 2)) + (this.hQD.getWidth() / 2), iArr[1] + this.hQD.getWidth());
        this.hQE.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.hQU = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.hQl != null && this.hkb != null && this.hQr != null && cashBitmap.getWidth() > 0) {
            if (this.hQU) {
                this.hQl.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bVu = this.hpm.bVu();
                if (bVu != null && bVu.getForum() != null) {
                    bVu.getForum().setUser_level(i);
                }
                this.hQr.setText(this.dIF.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.hQl.setText(this.hQJ);
                this.hQr.setText(this.dIF.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.hkb.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, tx(this.mLevel)));
            if (this.hQU) {
                if (f >= 1.0f) {
                    b(this.hkb, this.hQW, f);
                } else {
                    c(this.hkb, this.hQW, f);
                }
            } else {
                b(this.hkb, this.hQW, f);
            }
            this.hQW = f;
        }
    }

    private int[] tx(int i) {
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
    protected void bYm() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bYn() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.hQD, R.drawable.icon_sml_speed_orange);
        } else {
            am.setImageResource(this.hQD, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hQE != null && this.hQE.isShowing()) {
            this.hQE.dismiss();
        }
        if (this.hQx != null) {
            this.hQx.onDestroy();
        }
    }
}
