package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
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
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.g;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.c.d;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tbclient.ForumRuleStatus;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private boolean chM;
    private String cuF;
    private ScheduledExecutorService eFu;
    private CountDownTimer gPY;
    private View hww;
    private TextView joK;
    private TextView joL;
    private aw joN;
    private boolean joO;
    private LinearLayout joQ;
    private View joR;
    private View joS;
    private View joT;
    private View joU;
    private final View joV;
    private final HeadImageView joW;
    private final TextView joX;
    private final View joY;
    private final ImageView joZ;
    private final TextView jpa;
    private HotRankEntryView jpb;
    private List<n> jpc;
    private e jpd;
    private boolean jpg;
    private boolean jph;
    private RelativeLayout mContainer;
    private boolean joP = false;
    private int jpe = -1;
    private long jpf = 1000;
    private ArrayList<TbImageView> joM = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.jhE = frsFragment;
        this.eXu = frsFragment.getPageContext();
        this.jNf = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jNg = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jNh = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cIx();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jNs = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jHM = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jNt = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jNt.setPageId(this.jhE.getUniqueId());
        this.jNt.setDefaultBgResource(R.color.transparent);
        this.jNt.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hww = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.hww).pK(R.string.J_X11).pI(R.array.Mask_X005);
        this.joQ = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.joR = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.joS = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.joT = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jNu = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jNv = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jNx = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.joU = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jNy = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jNz = this.mParent.findViewById(R.id.service_topview_space);
        this.jNE = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.joK = (TextView) this.mParent.findViewById(R.id.member_image);
        this.joL = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jNk = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jNq = (TextView) this.mParent.findViewById(R.id.level);
        this.jJl = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jJl.setText(frsFragment.getResources().getString(R.string.attention));
        this.jJl.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jJl.setConfig(bVar);
        this.jJs = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jJs.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.rt(R.color.CAM_X0105);
        bVar2.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jJs.setConfig(bVar2);
        this.jJs.setText(frsFragment.getResources().getString(R.string.sign));
        this.jbD = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.jbE = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jNi = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jNj = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.jdI = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jNm = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jNG = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jNG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jNG.setPageId(this.jhE.getUniqueId());
        this.jNG.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jNG.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jNG.setShowOval(true);
        this.jNG.setPlaceHolder(1);
        this.jNp = this.mParent.findViewById(R.id.level_container);
        this.jNo = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jNn = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jNr = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.joV = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.joX = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.joW = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.joW.setIsRound(true);
        this.joW.setDrawBorder(true);
        this.joW.setDefaultResource(R.drawable.icon_default_avatar100);
        this.joW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.joY = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.joZ = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.jpa = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.joZ, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jNB = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jNl = LayoutInflater.from(this.jhE.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.jpb = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jNl.setVisibility(8);
        this.jNJ = new com.baidu.tieba.frs.d.b(this.eXu);
        this.jNA = (EMTextView) this.mParent.findViewById(R.id.count_down);
    }

    protected View cIx() {
        return LayoutInflater.from(this.jhE.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void C(View.OnClickListener onClickListener) {
        this.jNG.setOnClickListener(onClickListener);
        this.jdI.setOnClickListener(onClickListener);
        this.jJs.setOnClickListener(onClickListener);
        this.jJl.setOnClickListener(onClickListener);
        this.jNp.setOnClickListener(onClickListener);
        if (this.jpb != null) {
            this.jpb.setOnClickListener(onClickListener);
        }
        if (this.joV != null) {
            this.joV.setOnClickListener(onClickListener);
        }
        if (this.joY != null) {
            this.joY.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cIy() {
        this.jNm.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eXu.getLayoutMode().setNightMode(i == 1);
        this.eXu.getLayoutMode().onModeChanged(this.mParent);
        this.eXu.getLayoutMode().onModeChanged(this.jNB);
        this.eXu.getLayoutMode().onModeChanged(this.jNl);
        ao.setBackgroundResource(this.jbD, R.drawable.frs_exp_progress);
        ao.setBackgroundResource(this.joR, R.drawable.bg_frs_header_round_corner);
        ao.setBackgroundColor(this.joS, R.color.CAM_X0204);
        ao.setBackgroundColor(this.joT, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jNx, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jNy, R.color.CAM_X0624);
        ao.setBackgroundColor(this.joU, R.color.CAM_X0201);
        ao.setBackgroundColor(this.jbE, R.color.CAM_X0101);
        ao.setBackgroundColor(this.jNr, R.color.black_alpha0);
        ao.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ao.setViewTextColor(this.jdI, R.color.CAM_X0101);
        ao.setViewTextColor(this.jNq, R.color.CAM_X0101);
        ao.setViewTextColor(this.jNk, R.color.CAM_X0101);
        ao.setViewTextColor(this.joK, R.color.CAM_X0101);
        ao.setViewTextColor(this.jNi, R.color.CAM_X0101);
        ao.setViewTextColor(this.joL, R.color.CAM_X0101);
        ao.setViewTextColor(this.jNj, R.color.CAM_X0101);
        ao.setViewTextColor(this.joX, R.color.CAM_X0101);
        ao.setViewTextColor(this.jpa, R.color.CAM_X0101);
        ao.setViewTextColor(this.jNj, R.color.CAM_X0101);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jNA).pE(R.string.F_X01).pC(R.color.CAM_X0101);
        if (this.jNG != null) {
            this.jNG.setBorderWidth(l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds1));
            this.jNG.setBorderColor(ao.getColor(R.color.CAM_X0603));
            this.jNG.setStrokeColorResId(R.color.CAM_X0201);
            this.jNG.setPlaceHolder(1);
            this.jNG.invalidate();
        }
        if (this.joW != null) {
            this.joW.invalidate();
        }
        if (this.jNH != null) {
            this.jNH.onChangeSkin(i);
        }
        if (this.jHM != null) {
            this.jHM.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.joM.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cIS();
        Cu(this.jNU ? 1 : 0);
        cIC();
        AH(i);
        ae(cIG(), cIH());
        if (this.jNu != null) {
            this.jNu.onChangeSkinType(i);
        }
        if (this.jNx != null) {
            this.jNx.onChangeSkinType(i);
        }
        if (this.jNw != null) {
            this.jNw.onChangeSkinType(i);
        }
        if (this.jpb != null) {
            this.jpb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void ca(boolean z) {
        super.ca(z);
        if (this.jNw != null) {
            this.jNw.ca(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jNO = forumData.getPost_num();
            this.jNL = forumData.getTag_color();
            this.cuF = forumData.getImage_url();
            this.jNK = forumData.getLevelName();
            this.fCN = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jNP = forumData.getSignData().count_sign_num;
                this.jNQ = forumData.getSignData().miss_sign_num;
            }
            this.jNR = forumData.getCurScore();
            this.jJv = forumData.getLevelupScore();
            this.jNI = forumData.getBadgeData();
            this.jNM = forumData.getAccelerateContent();
            this.jNW = forumData.isBrandForum;
            this.jFx = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jFx != null && this.jFx.getHotUserRankData() != null && this.jFx.getHotUserRankData().hot_user != null && this.jFx.getHotUserRankData().hot_user.size() >= 3) {
                this.jNu.setHasHotRankList(true);
            } else {
                this.jNu.setHasHotRankList(false);
            }
            if ((this.jFx != null && this.jFx.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bMD()) || this.jNu.cMC()) {
                this.jNu.setVisibility(0);
                this.joS.setVisibility(0);
                this.jNu.setData(this.jFx.serviceAreaData, this.jFx);
            } else {
                this.jNu.setVisibility(8);
                this.joS.setVisibility(8);
            }
            this.jNN = new bz();
            cIz();
            cID();
            b(forumData);
            if (frsViewData != null) {
                this.mSignActivityInfo = frsViewData.mSignActivityInfo;
                cIT();
            }
        }
    }

    private void b(ForumData forumData) {
        if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
            String str = forumData.getManagers().get(0).show_name;
            if (TextUtils.isEmpty(str)) {
                str = forumData.getManagers().get(0).name;
            }
            if (!TextUtils.isEmpty(str)) {
                this.joX.setText(str);
                this.joW.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.joV.setVisibility(0);
            } else {
                this.joV.setVisibility(8);
            }
            if (this.joY.getVisibility() == 0) {
                this.joY.setVisibility(8);
                return;
            }
            return;
        }
        if (this.joV.getVisibility() == 0) {
            this.joV.setVisibility(8);
        }
        if (this.joY.getVisibility() == 8) {
            this.joY.setVisibility(0);
        }
    }

    protected void cIz() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.cuF);
        this.jNN.brz().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cIA() {
        if (this.jJK != null) {
            this.jJK.BS(this.jNQ);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cIB() {
        if (this.jJK != null) {
            this.jJK.rv(this.jJx);
        }
    }

    protected void cIC() {
        if (this.jJL != null) {
            this.jJL.cIC();
        }
    }

    protected void cID() {
        if (this.jNi != null) {
            this.jNi.setText(at.dX(this.mMemberNum));
        }
        if (this.jNj != null) {
            this.jNj.setText(at.dX(this.jNO));
        }
        if (this.jNI != null && this.jNI.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jNW) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eXu.getString(R.string.forum);
        if (this.bNi != null) {
            this.bNi.setText(str);
        }
        if (this.jdI != null) {
            this.jdI.setText(str);
        }
        cIM();
        this.joO = cIL();
        if (this.joO) {
            this.jHM.setVisibility(8);
            this.hww.setVisibility(0);
        } else {
            this.hww.setVisibility(8);
            this.jHM.setVisibility(0);
            this.jNt.setOnClickListener(null);
        }
        cII();
        AH(TbadkCoreApplication.getInst().getSkinType());
        cIE();
    }

    private void cIE() {
        boolean cIG = cIG();
        boolean cIH = cIH();
        if (!TextUtils.isEmpty(this.mForumName)) {
            com.baidu.tieba.frs.c.e LF = d.cMV().LF(this.mForumName);
            if (LF == null) {
                LF = new com.baidu.tieba.frs.c.e(this.joP, cIG);
            } else {
                LF.rr(this.joP);
                LF.rs(cIG);
            }
            d.cMV().a(this.mForumName, LF);
        }
        ad(cIG, cIH);
        ae(cIG, cIH);
    }

    private void ad(boolean z, boolean z2) {
        if (this.jhE.cEX() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.joQ.getLayoutParams();
            if (!z && !z2) {
                this.joQ.setVisibility(0);
                this.joS.setVisibility(8);
                this.joT.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds50);
            } else {
                this.joQ.setVisibility(0);
                this.joS.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds55);
            }
            this.jhE.cEX().ag(z, z2);
        }
    }

    private void ae(boolean z, boolean z2) {
        int dimens;
        if (this.jNs != null && this.jNs.getLayoutParams() != null) {
            if (this.jpb.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jNr.getLayoutParams()).topMargin = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eXu.getPageActivity());
                ((RelativeLayout.LayoutParams) this.jpb.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.joO) {
                dimens -= l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds80);
            } else if (this.joO) {
                int dimens3 = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds782);
                int af = af(z, z2);
                int i = dimens3 + af;
                ((RelativeLayout.LayoutParams) this.jNt.getLayoutParams()).bottomMargin = af;
                ((RelativeLayout.LayoutParams) this.hww.getLayoutParams()).bottomMargin = af;
                if (af != 0) {
                    ((RelativeLayout.LayoutParams) this.jNr.getLayoutParams()).topMargin = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jNr.getLayoutParams()).topMargin = l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds493);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jNs.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jNs.setLayoutParams(layoutParams);
            }
        }
    }

    private int af(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jFx.serviceAreaData == null || this.jFx.serviceAreaData.dataList == null || this.jFx.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.jpc != null) {
            i += Math.min(this.jpc.size(), 2) * l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jNv.getVisibility() == 0) {
            i += l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jNv.getVisibility() == 0) {
            return i + l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cIF() {
        if (this.jhE == null || this.jhE.cEX() == null) {
            return null;
        }
        View cOj = this.jhE.cEX().cOj();
        if (cOj instanceof LinearGradientView) {
            return (LinearGradientView) cOj;
        }
        return null;
    }

    private boolean cIG() {
        return this.jNx != null && this.jNx.getVisibility() == 0;
    }

    private boolean cIH() {
        return this.jNu != null && this.jNu.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cII() {
        if (this.jhE != null && this.jFx != null) {
            List<n> showTopThreadList = this.jFx.getShowTopThreadList();
            this.joP = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jFx.getBusinessPromot());
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public String getActivityId() {
        if (this.mSignActivityInfo != null) {
            return String.valueOf(this.mSignActivityInfo.activity_id);
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.view.b
    public boolean cIJ() {
        return this.jJx;
    }

    @Override // com.baidu.tieba.frs.view.b
    public SignActivityInfo cIK() {
        return this.mSignActivityInfo;
    }

    private void a(List<n> list, i iVar) {
        if (this.jNx != null) {
            this.jpc = list;
            if (iVar != null) {
                this.jNw = new g(this.eXu.getPageActivity());
                this.jNv.setVisibility(0);
                this.jNv.addView(this.jNw.getView());
                this.jNw.a(this.jFx != null ? this.jFx.getForum() : null, iVar);
            } else {
                this.jNv.setVisibility(8);
            }
            if (this.jhE != null && this.jhE.cFg()) {
                this.jNx.setVisibility(0);
                this.jNx.setFragmentUniqueId(this.jhE.getUniqueId());
                ForumData forum = this.jFx != null ? this.jFx.getForum() : null;
                this.jNx.setForum(this.mForumId, this.mForumName, forum, this.jFx != null ? this.jFx.getUserData() : null, this.jhE.getFrom());
                if (forum != null && !at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !x.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                ForumRuleStatus forumRuleStatus = this.jFx.forumRule;
                this.jpe = -1;
                if (this.jFx.getForum().getIsShowRule() && forumRuleStatus != null && (this.jFx.getUserData().getIs_manager() == 1 || forumRuleStatus.has_forum_rule.intValue() == 1)) {
                    p pVar = new p(forum, forumRuleStatus);
                    if (list.size() > 1 && (list.get(0) instanceof k) && ((k) list.get(0)) != null && ((k) list.get(0)).dOf() == 1) {
                        list.add(1, pVar);
                        this.jpe = 1;
                    } else {
                        list.add(0, pVar);
                        this.jpe = 0;
                    }
                }
                this.jNx.setDatas(list, iVar);
                if (this.joN == null) {
                    this.joN = new aw() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.aw
                        public void ao(bz bzVar) {
                            com.baidu.tieba.frs.d.k.a(b.this.jhE, b.this.jFx, bzVar);
                        }
                    };
                }
                this.jNx.setStatListener(this.joN);
                return;
            }
            this.jNx.setVisibility(8);
        }
    }

    private boolean cIL() {
        final z zVar;
        if (this.jFx == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jFx;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dOm())) {
            zVar = new z();
            zVar.setLinkUrl("");
            zVar.setImageUrl(frsViewData.getStar().dOm());
        } else {
            zVar = (frsViewData.getActivityHeadData() == null || x.getCount(frsViewData.getActivityHeadData().bps()) < 1) ? null : frsViewData.getActivityHeadData().bps().get(0);
        }
        if (zVar != null) {
            if (this.jNt != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bpt())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dX("fid", frsViewData.getForum().getId());
                    aqVar.dX("obj_id", frsViewData.getActivityHeadData().bpt());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dX("page_type", PageStayDurationConstants.PageName.FRS).an("obj_isad", 1).an("obj_floor", 1).dX("fid", frsViewData.getForum().getId()).dX("obj_id", frsViewData.getActivityHeadData().bpt()).an("obj_adlocate", 1).dX("first_dir", frsViewData.getForum().getFirst_class()).dX("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dX("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fsN);
                    }
                    com.baidu.tieba.s.c.dNX().a(this.jhE.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().bpt(), "", (BaijiahaoData) null), aqVar2);
                }
                this.jNt.startLoad(zVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(zVar.getLinkUrl())) {
                    this.jNt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eXu != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bpt())) {
                                    String id = frsViewData.getForum().getId();
                                    String bpt = frsViewData.getActivityHeadData().bpt();
                                    aq aqVar3 = new aq("c13330");
                                    aqVar3.dX("fid", id);
                                    aqVar3.dX("obj_id", bpt);
                                    TiebaStatic.log(aqVar3);
                                    aq aqVar4 = new aq("common_click");
                                    aqVar4.dX("page_type", PageStayDurationConstants.PageName.FRS).an("obj_isad", 1).dX("fid", id).dX("obj_id", bpt).an("obj_adlocate", 1).an("obj_floor", 1).dX("first_dir", frsViewData.getForum().getFirst_class()).dX("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aqVar3.dX("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fsN);
                                    }
                                    com.baidu.tieba.s.c.dNX().b(b.this.jhE.getUniqueId(), aqVar4);
                                }
                                be.bwu().a(b.this.eXu, new String[]{zVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void AH(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jFx != null && (forum = this.jFx.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.joO) {
                LinearGradientView cIF = cIF();
                if (this.jHM != null && cIF != null) {
                    this.jHM.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jNt != null) {
                    this.jNt.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jNu != null) {
                this.jNu.setThemeFontColor(com.baidu.tieba.lego.card.c.b.sF(themeElement.common_color));
            }
            if (this.jNx != null) {
                this.jNx.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.c.b.sF(themeElement.common_color));
            }
        }
    }

    protected void cIM() {
        this.jNG.startLoad(this.cuF, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jOb);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eXu.getPageActivity());
                this.mPopup.setContentView(this.jNB);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eXu.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eXu.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jNC = (TextView) this.jNB.findViewById(R.id.cur_experience);
            this.jND = (TextView) this.jNB.findViewById(R.id.levelup_experience);
            ao.setBackgroundResource(this.jNB.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ao.setViewTextColor((TextView) this.jNB.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ao.setViewTextColor(this.jNC, R.color.common_color_10047, 1);
            ao.setViewTextColor(this.jND, R.color.CAM_X0111, 1);
            a(this.jNC, this.jND);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eXu.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eXu.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jOb, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eXu.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.CAM_X0105, 1);
            ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
            ao.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            ao.setViewTextColor(textView3, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
            aVar.br(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jNM) && !TextUtils.isEmpty(this.jNM.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jNM);
            } else {
                textView3.setVisibility(8);
            }
            aVar.pb(R.color.CAM_X0305);
            d(aVar);
            e(aVar);
            aVar.b(this.eXu);
            aVar.btX();
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
                if (b.this.eXu != null && b.this.eXu.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eXu.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cIN() {
        View contentView;
        if (this.jNF == null) {
            this.jNF = new PopupWindow(this.eXu.getPageActivity());
            View inflate = LayoutInflater.from(this.eXu.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jNF.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eXu != null && b.this.eXu.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jNF, b.this.eXu.getPageActivity());
                        b.this.jhE.jeV = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eXu.getPageActivity(), b.this.eXu.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jNF.setWidth(this.eXu.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jNF.setHeight(this.eXu.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jNF.setBackgroundDrawable(new BitmapDrawable());
            this.jNF.setOutsideTouchable(true);
            this.jNF.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jNF);
                        b.this.jhE.jeV = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jNF.getContentView();
        }
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jNE.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jNF, this.mParent, 0, (iArr[0] - (this.jNF.getWidth() / 2)) + (this.jNE.getWidth() / 2), iArr[1] + this.jNE.getWidth());
        this.jNF.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cIO() {
        String string;
        String str;
        View view;
        if (this.jpe != -1 && this.jFx != null && this.jFx.forumRule != null && this.jFx.getUserData() != null && this.jNx != null) {
            if (this.jFx.getUserData().getIs_manager() == 1) {
                if (this.jFx.forumRule.has_forum_rule.intValue() != 1 && this.jFx.forumRule.audit_status.intValue() == 0) {
                    string = this.eXu.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.eXu.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            if (this.jNx.getmTopViews() != null && this.jNx.getmTopViews().size() > 0 && (this.jNx.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.jNx.getmTopViews().get(0);
                if (this.jpe < adapterLinearLayout.getChildCount()) {
                    view = adapterLinearLayout.getChildAt(this.jpe);
                    if (this.jpd != null && view != null) {
                        this.jpd = new e(this.eXu, view);
                        this.jpd.fP(R.drawable.bg_tip_blue_up_left);
                        this.jpd.fO(16);
                        this.jpd.pD(true);
                        this.jpd.yH(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                        this.jpd.setYOffset(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                        this.jpd.setUseDirectOffset(true);
                        this.jpd.fQ(4000);
                        if (!this.jpd.isShowing() && !this.jhE.cFF()) {
                            this.jpd.aK(string, str);
                            return;
                        }
                        return;
                    }
                }
            }
            view = null;
            if (this.jpd != null) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cIP() {
        if (this.jpd != null) {
            this.jpd.VL();
            this.jpe = -1;
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cIQ() {
        this.jNx.Cg(this.jpe);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jNV = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jNk != null && this.jbD != null && this.jNq != null && cashBitmap.getWidth() > 0) {
            if (this.jNV) {
                this.jNk.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.fCN;
                } else {
                    i = this.fCN + 1;
                }
                FrsViewData cFE = this.jhE.cFE();
                if (cFE != null && cFE.getForum() != null) {
                    cFE.getForum().setUser_level(i);
                }
                this.jNq.setText(this.eXu.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jNk.setText(this.jNK);
                this.jNq.setText(this.eXu.getResources().getString(R.string.lv_num, Integer.valueOf(this.fCN)));
            }
            this.jbD.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, zG(this.fCN)));
            if (this.jNV) {
                if (f >= 1.0f) {
                    b(this.jbD, this.jNX, f);
                } else {
                    c(this.jbD, this.jNX, f);
                }
            } else {
                b(this.jbD, this.jNX, f);
            }
            this.jNX = f;
        }
    }

    private int[] zG(int i) {
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
    protected void cIR() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cIS() {
        if (this.mMemberType != 0) {
            ao.setImageResource(this.jNE, R.drawable.icon_sml_speed_orange);
        } else {
            ao.setImageResource(this.jNE, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jNF != null && this.jNF.isShowing()) {
            this.jNF.dismiss();
        }
        cIP();
        if (this.jNw != null) {
            this.jNw.onDestroy();
        }
        if (this.gPY != null) {
            this.gPY.cancel();
            this.gPY = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.frs.entelechy.b$7] */
    private void d(final String str, long j, long j2) {
        this.jJx = true;
        this.gPY = new CountDownTimer(j, j2) { // from class: com.baidu.tieba.frs.entelechy.b.7
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (b.this.jNA != null) {
                    b.this.jNA.setVisibility(0);
                    b.this.jNA.setText(str + (j3 / 1000) + "s");
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.jJx = false;
                if (b.this.jNA != null) {
                    b.this.jNA.setVisibility(8);
                }
                if (b.this.jJK != null && !b.this.cNV()) {
                    b.this.jJK.rv(b.this.jJx);
                }
            }
        }.start();
        if (this.jJK != null && !cNV()) {
            this.jJK.rv(this.jJx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIT() {
        if (this.mSignActivityInfo != null) {
            if (this.gPY != null) {
                this.gPY.cancel();
                this.gPY.onFinish();
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.jpg = ((long) (this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue())) - currentTimeMillis < 0;
            this.chM = ((long) this.mSignActivityInfo.activity_time.intValue()) - currentTimeMillis <= 0;
            this.jph = ((long) (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue())) - currentTimeMillis <= 0;
            if (this.jpg) {
                this.jNA.setVisibility(8);
                return;
            }
            if (this.chM && !this.jpg) {
                d(this.mSignActivityInfo.activity_msg, ((this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue()) - currentTimeMillis) * 1000, this.jpf);
            }
            if (!this.chM && this.jph) {
                this.jNA.setVisibility(0);
                this.jNA.setText(this.mSignActivityInfo.countdown_msg);
                G(this.mSignActivityInfo.activity_msg, this.mSignActivityInfo.activity_time.intValue() - currentTimeMillis);
            }
            if (!this.jph) {
                G(this.mSignActivityInfo.countdown_msg, (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue()) - currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(final String str, long j) {
        this.jJx = false;
        this.eFu = Executors.newScheduledThreadPool(1);
        this.eFu.schedule(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.jNA != null) {
                            if (b.this.jNA.getVisibility() == 8) {
                                b.this.jNA.setVisibility(0);
                                b.this.jNA.setText(str);
                                if (b.this.mSignActivityInfo != null) {
                                    b.this.G(b.this.mSignActivityInfo.activity_msg, b.this.mSignActivityInfo.countdown_time.intValue());
                                }
                            } else if (b.this.jNA.getVisibility() == 0) {
                                b.this.cIT();
                            }
                        }
                    }
                });
            }
        }, j, TimeUnit.SECONDS);
    }
}
