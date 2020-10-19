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
    private String bUs;
    private View gJq;
    private View iyA;
    private View iyB;
    private View iyC;
    private final View iyD;
    private final HeadImageView iyE;
    private final TextView iyF;
    private final View iyG;
    private final ImageView iyH;
    private final TextView iyI;
    private HotRankEntryView iyJ;
    private List<q> iyK;
    private TextView iys;
    private TextView iyt;
    private az iyv;
    private boolean iyw;
    private LinearLayout iyy;
    private View iyz;
    private RelativeLayout mContainer;
    private boolean iyx = false;
    private ArrayList<TbImageView> iyu = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.irr = frsFragment;
        this.etO = frsFragment.getPageContext();
        this.iTX = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.iTY = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.iTZ = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cvZ();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.iUk = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.iOI = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.iUl = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.iUl.setPageId(this.irr.getUniqueId());
        this.iUl.setDefaultBgResource(R.color.transparent);
        this.iUl.setDefaultResource(R.drawable.pic_frs_head_default);
        this.iUl.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.gJq = this.mParent.findViewById(R.id.header_top_cover);
        this.iyy = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.iyz = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.iyA = this.mParent.findViewById(R.id.no_service_space);
        this.iUm = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.iUn = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.iUp = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.iyB = this.mParent.findViewById(R.id.frs_topview_space);
        this.iyC = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.iUq = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.iUu = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.iys = (TextView) this.mParent.findViewById(R.id.member_image);
        this.iyt = (TextView) this.mParent.findViewById(R.id.post_image);
        this.iUc = (TextView) this.mParent.findViewById(R.id.level_name);
        this.iUi = (TextView) this.mParent.findViewById(R.id.level);
        this.iQh = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.iQh.setText(frsFragment.getResources().getString(R.string.attention));
        this.iQh.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.ba(R.color.cp_btn_a, R.color.cp_cont_b);
        bVar.pI(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
        bVar.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pM(UtilHelper.getDimenPixelSize(R.dimen.tbds13));
        this.iQh.setConfig(bVar);
        this.iQo = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.iQo.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pO(R.color.cp_cont_b);
        bVar2.pI(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.iQo.setConfig(bVar2);
        this.iQo.setText(frsFragment.getResources().getString(R.string.sign));
        this.ilo = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.ilp = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.iUa = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.iUb = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.inv = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.iUe = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.iUw = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.iUw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iUw.setPageId(this.irr.getUniqueId());
        this.iUw.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.iUw.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.iUw.setShowOval(true);
        this.iUw.setPlaceHolder(2);
        this.iUh = this.mParent.findViewById(R.id.level_container);
        this.iUg = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.iUf = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.iUj = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.iyD = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.iyF = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.iyE = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.iyE.setIsRound(true);
        this.iyE.setDrawBorder(true);
        this.iyE.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iyE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iyG = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.iyH = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.iyI = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        SvgManager.bmU().a(this.iyH, R.drawable.ic_icon_pure_frs_application16_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        this.iUr = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.iUd = LayoutInflater.from(this.irr.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.iyJ = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.iUd.setVisibility(8);
        this.iUz = new com.baidu.tieba.frs.f.b(this.etO);
    }

    protected View cvZ() {
        return LayoutInflater.from(this.irr.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void A(View.OnClickListener onClickListener) {
        this.iUw.setOnClickListener(onClickListener);
        this.inv.setOnClickListener(onClickListener);
        this.iQo.setOnClickListener(onClickListener);
        this.iQh.setOnClickListener(onClickListener);
        this.iUh.setOnClickListener(onClickListener);
        if (this.iyJ != null) {
            this.iyJ.setOnClickListener(onClickListener);
        }
        if (this.iyD != null) {
            this.iyD.setOnClickListener(onClickListener);
        }
        if (this.iyG != null) {
            this.iyG.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cwa() {
        this.iUe.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.etO.getLayoutMode().setNightMode(i == 1);
        this.etO.getLayoutMode().onModeChanged(this.mParent);
        this.etO.getLayoutMode().onModeChanged(this.iUr);
        this.etO.getLayoutMode().onModeChanged(this.iUd);
        ap.setBackgroundResource(this.ilo, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.iyz, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.iUq, R.color.cp_bg_line_b);
        ap.setBackgroundColor(this.iyB, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iyC, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ilp, R.color.cp_cont_a);
        ap.setBackgroundColor(this.iUj, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iUn, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iUp, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.iyA, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.inv, R.color.cp_cont_a);
        ap.setViewTextColor(this.iUi, R.color.cp_cont_a);
        ap.setViewTextColor(this.iUc, R.color.cp_cont_a);
        ap.setViewTextColor(this.iys, R.color.cp_cont_a);
        ap.setViewTextColor(this.iUa, R.color.cp_cont_a);
        ap.setViewTextColor(this.iyt, R.color.cp_cont_a);
        ap.setViewTextColor(this.iUb, R.color.cp_cont_a);
        ap.setViewTextColor(this.iyF, R.color.cp_cont_a);
        ap.setViewTextColor(this.iyI, R.color.cp_cont_a);
        ap.setViewTextColor(this.iUb, R.color.cp_cont_a);
        if (this.iUw != null) {
            this.iUw.setBorderWidth(l.getDimens(this.etO.getPageActivity(), R.dimen.tbds1));
            this.iUw.setBorderColor(ap.getColor(R.color.cp_mask_b_alpha16));
            this.iUw.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iUw.setPlaceHolder(2);
            this.iUw.invalidate();
        }
        if (this.iyE != null) {
            this.iyE.invalidate();
        }
        if (this.iUx != null) {
            this.iUx.onChangeSkin(i);
        }
        if (this.iOI != null) {
            this.iOI.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.iyu.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cwp();
        Ap(this.iUK ? 1 : 0);
        cwe();
        yM(i);
        Z(cwi(), cwj());
        if (this.iUm != null) {
            this.iUm.onChangeSkinType(i);
        }
        if (this.iUp != null) {
            this.iUp.onChangeSkinType(i);
        }
        if (this.iUo != null) {
            this.iUo.onChangeSkinType(i);
        }
        if (this.iyJ != null) {
            this.iyJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bO(boolean z) {
        super.bO(z);
        if (this.iUo != null) {
            this.iUo.bO(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.iUE = forumData.getPost_num();
            this.iUB = forumData.getTag_color();
            this.bUs = forumData.getImage_url();
            this.iUA = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.iUF = forumData.getSignData().count_sign_num;
                this.iUG = forumData.getSignData().miss_sign_num;
            }
            this.iUH = forumData.getCurScore();
            this.iQr = forumData.getLevelupScore();
            this.iUy = forumData.getBadgeData();
            this.iUC = forumData.getAccelerateContent();
            this.iUM = forumData.isBrandForum;
            this.iRt = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.iRt != null && this.iRt.getHotUserRankData() != null && this.iRt.getHotUserRankData().hot_user != null && this.iRt.getHotUserRankData().hot_user.size() >= 3) {
                this.iyJ.setVisibility(0);
                this.iyJ.setData(this.iRt.getHotUserRankData(), this.iyw);
            } else {
                this.iyJ.setVisibility(8);
            }
            if (this.iRt != null && this.iRt.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bDa()) {
                this.iUm.setVisibility(0);
                this.iUm.setData(this.iRt.serviceAreaData);
            } else {
                this.iUm.setVisibility(8);
            }
            this.iUD = new bw();
            cwb();
            cwf();
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
                this.iyF.setText(str);
                this.iyE.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.iyD.setVisibility(0);
            } else {
                this.iyD.setVisibility(8);
            }
            if (this.iyG.getVisibility() == 0) {
                this.iyG.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iyD.getVisibility() == 0) {
            this.iyD.setVisibility(8);
        }
        if (this.iyG.getVisibility() == 8) {
            this.iyG.setVisibility(0);
        }
    }

    protected void cwb() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bUs);
        this.iUD.biq().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cwc() {
        if (this.iQE != null) {
            this.iQE.zO(this.iUG);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cwd() {
        if (this.iQE != null) {
            this.iQE.cwd();
        }
    }

    protected void cwe() {
        if (this.iQF != null) {
            this.iQF.cwe();
        }
    }

    protected void cwf() {
        if (this.iUa != null) {
            this.iUa.setText(at.da(this.mMemberNum));
        }
        if (this.iUb != null) {
            this.iUb.setText(at.da(this.iUE));
        }
        if (this.iUy != null && this.iUy.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.iUM) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.etO.getString(R.string.forum);
        if (this.bwx != null) {
            this.bwx.setText(str);
        }
        if (this.inv != null) {
            this.inv.setText(str);
        }
        cwm();
        this.iyw = cwl();
        if (this.iyw) {
            this.iOI.setVisibility(8);
            this.gJq.setVisibility(0);
        } else {
            this.gJq.setVisibility(8);
            this.iOI.setVisibility(0);
            this.iUl.setOnClickListener(null);
        }
        cwk();
        yM(TbadkCoreApplication.getInst().getSkinType());
        cwg();
    }

    private void cwg() {
        boolean cwi = cwi();
        boolean cwj = cwj();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Kh = d.czt().Kh(this.mForumName);
            if (Kh == null) {
                Kh = new e(this.iyx, cwi);
            } else {
                Kh.pO(this.iyx);
                Kh.pP(cwi);
            }
            d.czt().a(this.mForumName, Kh);
        }
        Y(cwi, cwj);
        Z(cwi, cwj);
    }

    private void Y(boolean z, boolean z2) {
        if (this.irr.csB() != null) {
            if (!z && !z2) {
                this.iyy.setVisibility(8);
            } else {
                this.iyy.setVisibility(0);
            }
            this.irr.csB().ab(z, z2);
        }
    }

    private void Z(boolean z, boolean z2) {
        int dimens;
        if (this.iUk != null && this.iUk.getLayoutParams() != null) {
            if (this.iyJ.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.etO.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.iUj.getLayoutParams()).topMargin = l.getDimens(this.etO.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.etO.getPageActivity());
                ((RelativeLayout.LayoutParams) this.iyJ.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.etO.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.etO.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.etO.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.iyw) {
                dimens -= l.getDimens(this.etO.getPageActivity(), R.dimen.tbds80);
            } else if (this.iyw) {
                int dimens3 = l.getDimens(this.etO.getPageActivity(), R.dimen.tbds782);
                int aa = aa(z, z2);
                int i = dimens3 + aa;
                ((RelativeLayout.LayoutParams) this.iUl.getLayoutParams()).bottomMargin = aa;
                ((RelativeLayout.LayoutParams) this.gJq.getLayoutParams()).bottomMargin = aa;
                if (aa != 0) {
                    ((RelativeLayout.LayoutParams) this.iUj.getLayoutParams()).topMargin = l.getDimens(this.etO.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.etO.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.iUj.getLayoutParams()).topMargin = l.getDimens(this.etO.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            if (!z && !z2 && this.iyw) {
                if (cwh() != null) {
                    cwh().setVisibility(8);
                }
            } else if (cwh() != null) {
                cwh().setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = this.iUk.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.iUk.setLayoutParams(layoutParams);
            }
        }
    }

    private int aa(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.iRt.serviceAreaData == null || this.iRt.serviceAreaData.dataList == null || this.iRt.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.etO.getPageActivity(), R.dimen.tbds142) : 0 + l.getDimens(this.etO.getPageActivity(), R.dimen.tbds88);
        }
        if (z && this.iyK != null) {
            i += Math.min(this.iyK.size(), 2) * l.getDimens(this.etO.getPageActivity(), R.dimen.tbds83);
        }
        if (this.iUn.getVisibility() == 0) {
            i += l.getDimens(this.etO.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.iUn.getVisibility() == 0) {
            return i + l.getDimens(this.etO.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cwh() {
        if (this.irr == null || this.irr.csB() == null) {
            return null;
        }
        View cAD = this.irr.csB().cAD();
        if (cAD instanceof LinearGradientView) {
            return (LinearGradientView) cAD;
        }
        return null;
    }

    private boolean cwi() {
        return this.iUp != null && this.iUp.getVisibility() == 0;
    }

    private boolean cwj() {
        return this.iUm != null && this.iUm.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cwk() {
        if (this.irr != null && this.iRt != null) {
            List<q> showTopThreadList = this.iRt.getShowTopThreadList();
            this.iyx = showTopThreadList.size() > 2;
            a(showTopThreadList, this.iRt.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.iUp != null) {
            this.iyK = list;
            if (iVar != null) {
                this.iUo = new g(this.etO.getPageActivity());
                this.iUn.setVisibility(0);
                this.iUn.addView(this.iUo.getView());
                this.iUo.a(this.iRt != null ? this.iRt.getForum() : null, iVar);
            } else {
                this.iUn.setVisibility(8);
            }
            if (this.irr != null && this.irr.csK()) {
                this.iUp.setVisibility(0);
                this.iUp.setFragmentUniqueId(this.irr.getUniqueId());
                ForumData forum = this.iRt != null ? this.iRt.getForum() : null;
                this.iUp.setForum(this.mForumId, this.mForumName, forum);
                if (forum != null && !at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !y.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                this.iUp.setDatas(list, iVar);
                if (this.iyv == null) {
                    this.iyv = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void am(bw bwVar) {
                            j.a(b.this.irr, b.this.iRt, bwVar);
                        }
                    };
                }
                this.iUp.setStatListener(this.iyv);
                return;
            }
            this.iUp.setVisibility(8);
        }
    }

    private boolean cwl() {
        final com.baidu.tbadk.core.data.y yVar;
        if (this.iRt == null) {
            return false;
        }
        final FrsViewData frsViewData = this.iRt;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dDC())) {
            yVar = new com.baidu.tbadk.core.data.y();
            yVar.setLinkUrl("");
            yVar.setImageUrl(frsViewData.getStar().dDC());
        } else {
            yVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().bgl()) < 1) ? null : frsViewData.getActivityHeadData().bgl().get(0);
        }
        if (yVar != null) {
            if (this.iUl != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bgm())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dK("fid", frsViewData.getForum().getId());
                    aqVar.dK("obj_id", frsViewData.getActivityHeadData().bgm());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dK("page_type", PageStayDurationConstants.PageName.FRS).aj("obj_isad", 1).aj("obj_floor", 1).dK("fid", frsViewData.getForum().getId()).dK("obj_id", frsViewData.getActivityHeadData().bgm()).aj("obj_adlocate", 1).dK("first_dir", frsViewData.getForum().getFirst_class()).dK("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dK("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eOl);
                    }
                    com.baidu.tieba.s.c.dDn().a(this.irr.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().bgm(), "", (BaijiahaoData) null), aqVar2);
                }
                this.iUl.startLoad(yVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(yVar.getLinkUrl())) {
                    this.iUl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.etO != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bgm())) {
                                    String id = frsViewData.getForum().getId();
                                    String bgm = frsViewData.getActivityHeadData().bgm();
                                    aq aqVar3 = new aq("c13330");
                                    aqVar3.dK("fid", id);
                                    aqVar3.dK("obj_id", bgm);
                                    TiebaStatic.log(aqVar3);
                                    aq aqVar4 = new aq("common_click");
                                    aqVar4.dK("page_type", PageStayDurationConstants.PageName.FRS).aj("obj_isad", 1).dK("fid", id).dK("obj_id", bgm).aj("obj_adlocate", 1).aj("obj_floor", 1).dK("first_dir", frsViewData.getForum().getFirst_class()).dK("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aqVar3.dK("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eOl);
                                    }
                                    com.baidu.tieba.s.c.dDn().b(b.this.irr.getUniqueId(), aqVar4);
                                }
                                be.bmY().a(b.this.etO, new String[]{yVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void yM(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iRt != null && (forum = this.iRt.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iyw) {
                LinearGradientView cwh = cwh();
                if (this.iOI != null && cwh != null) {
                    this.iOI.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    cwh.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.iUl != null) {
                    this.iUl.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.iUm != null) {
                this.iUm.setThemeFontColor(com.baidu.tieba.lego.card.d.b.fv(themeElement.font_color));
            }
            if (this.iUp != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.iUp.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.fv(str));
            }
        }
    }

    protected void cwm() {
        this.iUw.startLoad(this.bUs, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.iUS);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.etO.getPageActivity());
                this.mPopup.setContentView(this.iUr);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.etO.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.etO.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.iUs = (TextView) this.iUr.findViewById(R.id.cur_experience);
            this.iUt = (TextView) this.iUr.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.iUr.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.iUr.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            ap.setViewTextColor(this.iUs, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.iUt, R.color.cp_cont_g, 1);
            a(this.iUs, this.iUt);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.etO.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.etO.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.iUS, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.etO.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            ap.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
            aVar.ba(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.iUC) && !TextUtils.isEmpty(this.iUC.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.iUC);
            } else {
                textView3.setVisibility(8);
            }
            aVar.oc(R.color.cp_link_tip_d);
            d(aVar);
            e(aVar);
            aVar.b(this.etO);
            aVar.bkJ();
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
                if (b.this.etO != null && b.this.etO.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.etO.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cwn() {
        View contentView;
        if (this.iUv == null) {
            this.iUv = new PopupWindow(this.etO.getPageActivity());
            View inflate = LayoutInflater.from(this.etO.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.iUv.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.etO != null && b.this.etO.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iUv, b.this.etO.getPageActivity());
                        b.this.irr.ioJ = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.etO.getPageActivity(), b.this.etO.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.iUv.setWidth(this.etO.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.iUv.setHeight(this.etO.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.iUv.setBackgroundDrawable(new BitmapDrawable());
            this.iUv.setOutsideTouchable(true);
            this.iUv.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.iUv);
                        b.this.irr.ioJ = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.iUv.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.iUu.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.iUv, this.mParent, 0, (iArr[0] - (this.iUv.getWidth() / 2)) + (this.iUu.getWidth() / 2), iArr[1] + this.iUu.getWidth());
        this.iUv.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.iUL = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.iUc != null && this.ilo != null && this.iUi != null && cashBitmap.getWidth() > 0) {
            if (this.iUL) {
                this.iUc.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cth = this.irr.cth();
                if (cth != null && cth.getForum() != null) {
                    cth.getForum().setUser_level(i);
                }
                this.iUi.setText(this.etO.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.iUc.setText(this.iUA);
                this.iUi.setText(this.etO.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.ilo.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, xK(this.mLevel)));
            if (this.iUL) {
                if (f >= 1.0f) {
                    b(this.ilo, this.iUN, f);
                } else {
                    c(this.ilo, this.iUN, f);
                }
            } else {
                b(this.ilo, this.iUN, f);
            }
            this.iUN = f;
        }
    }

    private int[] xK(int i) {
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
    protected void cwo() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cwp() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.iUu, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.iUu, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.iUv != null && this.iUv.isShowing()) {
            this.iUv.dismiss();
        }
        if (this.iUo != null) {
            this.iUo.onDestroy();
        }
    }
}
