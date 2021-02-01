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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
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
import com.baidu.tieba.frs.d.k;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.view.AdapterLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private boolean chi;
    private String dcS;
    private ScheduledExecutorService eCO;
    private CountDownTimer gNY;
    private View hwa;
    private TextView jpK;
    private TextView jpL;
    private aw jpN;
    private boolean jpO;
    private LinearLayout jpQ;
    private View jpR;
    private View jpS;
    private View jpT;
    private View jpU;
    private final View jpV;
    private final HeadImageView jpW;
    private final TextView jpX;
    private final View jpY;
    private final ImageView jpZ;
    private final TextView jqa;
    private HotRankEntryView jqb;
    private List<n> jqc;
    private e jqd;
    private boolean jqg;
    private boolean jqh;
    private RelativeLayout mContainer;
    private boolean jpP = false;
    private int jqe = -1;
    private long jqf = 1000;
    private ArrayList<TbImageView> jpM = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.jiE = frsFragment;
        this.eUY = frsFragment.getPageContext();
        this.jPw = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jPx = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jPy = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cFT();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jPJ = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jIK = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jPK = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jPK.setPageId(this.jiE.getUniqueId());
        this.jPK.setDefaultBgResource(R.color.transparent);
        this.jPK.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hwa = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.br(this.hwa).og(R.string.J_X11).oe(R.array.Mask_X005);
        this.jpQ = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.jpR = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.jpS = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.jpT = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jPL = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jPM = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jPO = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.jpU = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jPP = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jPQ = this.mParent.findViewById(R.id.service_topview_space);
        this.jPV = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.jpK = (TextView) this.mParent.findViewById(R.id.member_image);
        this.jpL = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jPB = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jPH = (TextView) this.mParent.findViewById(R.id.level);
        this.jKj = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jKj.setText(frsFragment.getResources().getString(R.string.attention));
        this.jKj.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jKj.setConfig(bVar);
        this.jKq = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jKq.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pS(R.color.CAM_X0105);
        bVar2.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jKq.setConfig(bVar2);
        this.jKq.setText(frsFragment.getResources().getString(R.string.sign));
        this.jcD = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.jcE = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jPz = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jPA = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.jeI = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jPD = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jPX = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jPX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jPX.setPageId(this.jiE.getUniqueId());
        this.jPX.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jPX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jPX.setShowOval(true);
        this.jPX.setPlaceHolder(1);
        this.jPG = this.mParent.findViewById(R.id.level_container);
        this.jPF = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jPE = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jPI = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.jpV = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.jpX = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.jpW = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.jpW.setIsRound(true);
        this.jpW.setDrawBorder(true);
        this.jpW.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jpW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jpY = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.jpZ = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.jqa = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.jpZ, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jPS = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jPC = LayoutInflater.from(this.jiE.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.jqb = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jPC.setVisibility(8);
        this.jQa = new com.baidu.tieba.frs.d.b(this.eUY);
        this.jPR = (EMTextView) this.mParent.findViewById(R.id.count_down);
    }

    protected View cFT() {
        return LayoutInflater.from(this.jiE.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void C(View.OnClickListener onClickListener) {
        this.jPX.setOnClickListener(onClickListener);
        this.jeI.setOnClickListener(onClickListener);
        this.jKq.setOnClickListener(onClickListener);
        this.jKj.setOnClickListener(onClickListener);
        this.jPG.setOnClickListener(onClickListener);
        if (this.jqb != null) {
            this.jqb.setOnClickListener(onClickListener);
        }
        if (this.jpV != null) {
            this.jpV.setOnClickListener(onClickListener);
        }
        if (this.jpY != null) {
            this.jpY.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFU() {
        this.jPD.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eUY.getLayoutMode().setNightMode(i == 1);
        this.eUY.getLayoutMode().onModeChanged(this.mParent);
        this.eUY.getLayoutMode().onModeChanged(this.jPS);
        this.eUY.getLayoutMode().onModeChanged(this.jPC);
        ap.setBackgroundResource(this.jcD, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.jpR, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.jpS, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jpT, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jPO, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jPP, R.color.CAM_X0624);
        ap.setBackgroundColor(this.jpU, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jcE, R.color.CAM_X0101);
        ap.setBackgroundColor(this.jPI, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ap.setViewTextColor(this.jeI, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPH, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPB, R.color.CAM_X0101);
        ap.setViewTextColor(this.jpK, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPz, R.color.CAM_X0101);
        ap.setViewTextColor(this.jpL, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPA, R.color.CAM_X0101);
        ap.setViewTextColor(this.jpX, R.color.CAM_X0101);
        ap.setViewTextColor(this.jqa, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPA, R.color.CAM_X0101);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jPR).oa(R.string.F_X01).nY(R.color.CAM_X0101);
        if (this.jPX != null) {
            this.jPX.setBorderWidth(l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds1));
            this.jPX.setBorderColor(ap.getColor(R.color.CAM_X0603));
            this.jPX.setStrokeColorResId(R.color.CAM_X0201);
            this.jPX.setPlaceHolder(1);
            this.jPX.invalidate();
        }
        if (this.jpW != null) {
            this.jpW.invalidate();
        }
        if (this.jPY != null) {
            this.jPY.onChangeSkin(i);
        }
        if (this.jIK != null) {
            this.jIK.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.jpM.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cGo();
        Bd(this.jQl ? 1 : 0);
        cFY();
        zl(i);
        ae(cGc(), cGd());
        if (this.jPL != null) {
            this.jPL.onChangeSkinType(i);
        }
        if (this.jPO != null) {
            this.jPO.onChangeSkinType(i);
        }
        if (this.jPN != null) {
            this.jPN.onChangeSkinType(i);
        }
        if (this.jqb != null) {
            this.jqb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cb(boolean z) {
        super.cb(z);
        if (this.jPN != null) {
            this.jPN.cb(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jQf = forumData.getPost_num();
            this.jQc = forumData.getTag_color();
            this.dcS = forumData.getImage_url();
            this.jQb = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jQg = forumData.getSignData().count_sign_num;
                this.jQh = forumData.getSignData().miss_sign_num;
            }
            this.jQi = forumData.getCurScore();
            this.jKt = forumData.getLevelupScore();
            this.jPZ = forumData.getBadgeData();
            this.jQd = forumData.getAccelerateContent();
            this.jQn = forumData.isBrandForum;
            this.jGv = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jGv != null && this.jGv.getHotUserRankData() != null && this.jGv.getHotUserRankData().hot_user != null && this.jGv.getHotUserRankData().hot_user.size() >= 3) {
                this.jPL.setHasHotRankList(true);
            } else {
                this.jPL.setHasHotRankList(false);
            }
            if ((this.jGv != null && this.jGv.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bJf()) || this.jPL.cJY()) {
                this.jPL.setVisibility(0);
                this.jpS.setVisibility(0);
                this.jPL.setData(this.jGv.serviceAreaData, this.jGv);
            } else {
                this.jPL.setVisibility(8);
                this.jpS.setVisibility(8);
            }
            this.jQe = new cb();
            cFV();
            cFZ();
            b(forumData);
            if (frsViewData != null) {
                this.mSignActivityInfo = frsViewData.mSignActivityInfo;
                cGp();
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
                this.jpX.setText(str);
                this.jpW.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.jpV.setVisibility(0);
            } else {
                this.jpV.setVisibility(8);
            }
            if (this.jpY.getVisibility() == 0) {
                this.jpY.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jpV.getVisibility() == 0) {
            this.jpV.setVisibility(8);
        }
        if (this.jpY.getVisibility() == 8) {
            this.jpY.setVisibility(0);
        }
    }

    protected void cFV() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.dcS);
        this.jQe.bnZ().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cFW() {
        if (this.jKI != null) {
            this.jKI.Aw(this.jQh);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cFX() {
        if (this.jKI != null) {
            this.jKI.rB(this.jKv);
        }
    }

    protected void cFY() {
        if (this.jKJ != null) {
            this.jKJ.cFY();
        }
    }

    protected void cFZ() {
        if (this.jPz != null) {
            this.jPz.setText(au.ed(this.mMemberNum));
        }
        if (this.jPA != null) {
            this.jPA.setText(au.ed(this.jQf));
        }
        if (this.jPZ != null && this.jPZ.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jQn) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eUY.getString(R.string.forum);
        if (this.bMg != null) {
            this.bMg.setText(str);
        }
        if (this.jeI != null) {
            this.jeI.setText(str);
        }
        cGi();
        this.jpO = cGh();
        if (this.jpO) {
            this.jIK.setVisibility(8);
            this.hwa.setVisibility(0);
        } else {
            this.hwa.setVisibility(8);
            this.jIK.setVisibility(0);
            this.jPK.setOnClickListener(null);
        }
        cGe();
        zl(TbadkCoreApplication.getInst().getSkinType());
        cGa();
    }

    private void cGa() {
        boolean cGc = cGc();
        boolean cGd = cGd();
        if (!TextUtils.isEmpty(this.mForumName)) {
            com.baidu.tieba.frs.c.e Lf = d.cKr().Lf(this.mForumName);
            if (Lf == null) {
                Lf = new com.baidu.tieba.frs.c.e(this.jpP, cGc);
            } else {
                Lf.rx(this.jpP);
                Lf.ry(cGc);
            }
            d.cKr().a(this.mForumName, Lf);
        }
        ad(cGc, cGd);
        ae(cGc, cGd);
    }

    private void ad(boolean z, boolean z2) {
        if (this.jiE.cCs() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jpQ.getLayoutParams();
            if (!z && !z2) {
                this.jpQ.setVisibility(0);
                this.jpS.setVisibility(8);
                this.jpT.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds50);
            } else {
                this.jpQ.setVisibility(0);
                this.jpS.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds55);
            }
            this.jiE.cCs().ag(z, z2);
        }
    }

    private void ae(boolean z, boolean z2) {
        int dimens;
        if (this.jPJ != null && this.jPJ.getLayoutParams() != null) {
            if (this.jqb.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jPI.getLayoutParams()).topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eUY.getPageActivity());
                ((RelativeLayout.LayoutParams) this.jqb.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.jpO) {
                dimens -= l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds80);
            } else if (this.jpO) {
                int dimens3 = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds782);
                int af = af(z, z2);
                int i = dimens3 + af;
                ((RelativeLayout.LayoutParams) this.jPK.getLayoutParams()).bottomMargin = af;
                ((RelativeLayout.LayoutParams) this.hwa.getLayoutParams()).bottomMargin = af;
                if (af != 0) {
                    ((RelativeLayout.LayoutParams) this.jPI.getLayoutParams()).topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jPI.getLayoutParams()).topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds493);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jPJ.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jPJ.setLayoutParams(layoutParams);
            }
        }
    }

    private int af(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jGv.serviceAreaData == null || this.jGv.serviceAreaData.dataList == null || this.jGv.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.jqc != null) {
            i += Math.min(this.jqc.size(), 2) * l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jPM.getVisibility() == 0) {
            i += l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jPM.getVisibility() == 0) {
            return i + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cGb() {
        if (this.jiE == null || this.jiE.cCs() == null) {
            return null;
        }
        View cLG = this.jiE.cCs().cLG();
        if (cLG instanceof LinearGradientView) {
            return (LinearGradientView) cLG;
        }
        return null;
    }

    private boolean cGc() {
        return this.jPO != null && this.jPO.getVisibility() == 0;
    }

    private boolean cGd() {
        return this.jPL != null && this.jPL.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGe() {
        if (this.jiE != null && this.jGv != null) {
            List<n> showTopThreadList = this.jGv.getShowTopThreadList();
            this.jpP = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jGv.getBusinessPromot());
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
    public boolean cGf() {
        return this.jKv;
    }

    @Override // com.baidu.tieba.frs.view.b
    public SignActivityInfo cGg() {
        return this.mSignActivityInfo;
    }

    private void a(List<n> list, i iVar) {
        if (this.jPO != null) {
            this.jqc = list;
            if (iVar != null) {
                this.jPN = new g(this.eUY.getPageActivity());
                this.jPM.setVisibility(0);
                this.jPM.addView(this.jPN.getView());
                this.jPN.a(this.jGv != null ? this.jGv.getForum() : null, iVar);
            } else {
                this.jPM.setVisibility(8);
            }
            if (this.jiE != null && this.jiE.cCB()) {
                this.jPO.setVisibility(0);
                this.jPO.setFragmentUniqueId(this.jiE.getUniqueId());
                this.jPO.setForum(this.mForumId, this.mForumName, this.jGv != null ? this.jGv.getForum() : null, this.jGv != null ? this.jGv.getUserData() : null, this.jiE.getFrom());
                if (list.size() > 0 && (list.get(0) instanceof p)) {
                    this.jqe = 0;
                } else if (list.size() > 1 && (list.get(1) instanceof p)) {
                    this.jqe = 1;
                } else {
                    this.jqe = -1;
                }
                this.jPO.setDatas(list, iVar);
                if (this.jpN == null) {
                    this.jpN = new aw() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.aw
                        public void ap(cb cbVar) {
                            k.a(b.this.jiE, b.this.jGv, cbVar);
                        }
                    };
                }
                this.jPO.setStatListener(this.jpN);
                return;
            }
            this.jPO.setVisibility(8);
        }
    }

    private boolean cGh() {
        final aa aaVar;
        if (this.jGv == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jGv;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dMG())) {
            aaVar = new aa();
            aaVar.setLinkUrl("");
            aaVar.setImageUrl(frsViewData.getStar().dMG());
        } else {
            aaVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().blR()) < 1) ? null : frsViewData.getActivityHeadData().blR().get(0);
        }
        if (aaVar != null) {
            if (this.jPK != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().blS())) {
                    ar arVar = new ar("c13326");
                    arVar.dR("fid", frsViewData.getForum().getId());
                    arVar.dR("obj_id", frsViewData.getActivityHeadData().blS());
                    TiebaStatic.log(arVar);
                    ar arVar2 = new ar("common_exp");
                    arVar2.dR("page_type", PageStayDurationConstants.PageName.FRS).ap("obj_isad", 1).ap("obj_floor", 1).dR("fid", frsViewData.getForum().getId()).dR("obj_id", frsViewData.getActivityHeadData().blS()).ap("obj_adlocate", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fqv);
                    }
                    com.baidu.tieba.s.c.dMr().a(this.jiE.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().blS(), "", (BaijiahaoData) null), arVar2);
                }
                this.jPK.startLoad(aaVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(aaVar.getLinkUrl())) {
                    this.jPK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eUY != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().blS())) {
                                    String id = frsViewData.getForum().getId();
                                    String blS = frsViewData.getActivityHeadData().blS();
                                    ar arVar3 = new ar("c13330");
                                    arVar3.dR("fid", id);
                                    arVar3.dR("obj_id", blS);
                                    TiebaStatic.log(arVar3);
                                    ar arVar4 = new ar("common_click");
                                    arVar4.dR("page_type", PageStayDurationConstants.PageName.FRS).ap("obj_isad", 1).dR("fid", id).dR("obj_id", blS).ap("obj_adlocate", 1).ap("obj_floor", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        arVar3.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fqv);
                                    }
                                    com.baidu.tieba.s.c.dMr().b(b.this.jiE.getUniqueId(), arVar4);
                                }
                                bf.bsV().a(b.this.eUY, new String[]{aaVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void zl(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jGv != null && (forum = this.jGv.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jpO) {
                LinearGradientView cGb = cGb();
                if (this.jIK != null && cGb != null) {
                    this.jIK.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jPK != null) {
                    this.jPK.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jPL != null) {
                this.jPL.setThemeFontColor(com.baidu.tieba.lego.card.c.b.rM(themeElement.common_color));
            }
            if (this.jPO != null) {
                this.jPO.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.c.b.rM(themeElement.common_color));
            }
        }
    }

    protected void cGi() {
        this.jPX.startLoad(this.dcS, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jQs);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eUY.getPageActivity());
                this.mPopup.setContentView(this.jPS);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jPT = (TextView) this.jPS.findViewById(R.id.cur_experience);
            this.jPU = (TextView) this.jPS.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jPS.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jPS.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ap.setViewTextColor(this.jPT, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jPU, R.color.CAM_X0111, 1);
            a(this.jPT, this.jPU);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eUY.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eUY.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jQs, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eUY.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView3, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
            aVar.bn(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jQd) && !TextUtils.isEmpty(this.jQd.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jQd);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ny(R.color.CAM_X0305);
            d(aVar);
            e(aVar);
            aVar.b(this.eUY);
            aVar.bqx();
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
                if (b.this.eUY != null && b.this.eUY.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eUY.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGj() {
        View contentView;
        if (this.jPW == null) {
            this.jPW = new PopupWindow(this.eUY.getPageActivity());
            View inflate = LayoutInflater.from(this.eUY.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jPW.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eUY != null && b.this.eUY.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jPW, b.this.eUY.getPageActivity());
                        b.this.jiE.jfU = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eUY.getPageActivity(), b.this.eUY.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jPW.setWidth(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jPW.setHeight(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jPW.setBackgroundDrawable(new BitmapDrawable());
            this.jPW.setOutsideTouchable(true);
            this.jPW.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jPW);
                        b.this.jiE.jfU = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jPW.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jPV.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jPW, this.mParent, 0, (iArr[0] - (this.jPW.getWidth() / 2)) + (this.jPV.getWidth() / 2), iArr[1] + this.jPV.getWidth());
        this.jPW.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGk() {
        String string;
        String str;
        View view;
        if (this.jqe != -1 && this.jGv != null && this.jGv.forumRule != null && this.jGv.getUserData() != null && this.jPO != null) {
            if (this.jGv.getUserData().getIs_manager() == 1) {
                if (this.jGv.forumRule.has_forum_rule.intValue() != 1 && this.jGv.forumRule.audit_status.intValue() == 0) {
                    string = this.eUY.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.eUY.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            if (this.jPO.getmTopViews() != null && this.jPO.getmTopViews().size() > 0 && (this.jPO.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.jPO.getmTopViews().get(0);
                if (this.jqe < adapterLinearLayout.getChildCount()) {
                    view = adapterLinearLayout.getChildAt(this.jqe);
                    if (this.jqd != null && view != null) {
                        this.jqd = new e(this.eUY, view);
                        this.jqd.en(R.drawable.bg_tip_blue_up_left);
                        this.jqd.em(16);
                        this.jqd.pJ(true);
                        this.jqd.xl(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                        this.jqd.setYOffset(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                        this.jqd.setUseDirectOffset(true);
                        this.jqd.eo(4000);
                        if (!this.jqd.isShowing() && !this.jiE.cDa()) {
                            this.jqd.aJ(string, str);
                            return;
                        }
                        return;
                    }
                }
            }
            view = null;
            if (this.jqd != null) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGl() {
        if (this.jqd != null) {
            this.jqd.Tz();
            this.jqe = -1;
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGm() {
        this.jPO.AK(this.jqe);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jQm = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jPB != null && this.jcD != null && this.jPH != null && cashBitmap.getWidth() > 0) {
            if (this.jQm) {
                this.jPB.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cCZ = this.jiE.cCZ();
                if (cCZ != null && cCZ.getForum() != null) {
                    cCZ.getForum().setUser_level(i);
                }
                this.jPH.setText(this.eUY.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jPB.setText(this.jQb);
                this.jPH.setText(this.eUY.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.jcD.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yk(this.mLevel)));
            if (this.jQm) {
                if (f >= 1.0f) {
                    b(this.jcD, this.jQo, f);
                } else {
                    c(this.jcD, this.jQo, f);
                }
            } else {
                b(this.jcD, this.jQo, f);
            }
            this.jQo = f;
        }
    }

    private int[] yk(int i) {
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
    protected void cGn() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGo() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jPV, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jPV, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jPW != null && this.jPW.isShowing()) {
            this.jPW.dismiss();
        }
        cGl();
        if (this.jPN != null) {
            this.jPN.onDestroy();
        }
        if (this.gNY != null) {
            this.gNY.cancel();
            this.gNY = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.frs.entelechy.b$7] */
    private void c(final String str, long j, long j2) {
        this.jKv = true;
        this.gNY = new CountDownTimer(j, j2) { // from class: com.baidu.tieba.frs.entelechy.b.7
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (b.this.jPR != null) {
                    b.this.jPR.setVisibility(0);
                    b.this.jPR.setText(str + (j3 / 1000) + "s");
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.jKv = false;
                if (b.this.jPR != null) {
                    b.this.jPR.setVisibility(8);
                }
                if (b.this.jKI != null && !b.this.cLs()) {
                    b.this.jKI.rB(b.this.jKv);
                }
            }
        }.start();
        if (this.jKI != null && !cLs()) {
            this.jKI.rB(this.jKv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGp() {
        if (this.mSignActivityInfo != null) {
            if (this.gNY != null) {
                this.gNY.cancel();
                this.gNY.onFinish();
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.jqg = ((long) (this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue())) - currentTimeMillis < 0;
            this.chi = ((long) this.mSignActivityInfo.activity_time.intValue()) - currentTimeMillis <= 0;
            this.jqh = ((long) (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue())) - currentTimeMillis <= 0;
            if (this.jqg) {
                this.jPR.setVisibility(8);
                return;
            }
            if (this.chi && !this.jqg) {
                c(this.mSignActivityInfo.activity_msg, ((this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue()) - currentTimeMillis) * 1000, this.jqf);
            }
            if (!this.chi && this.jqh) {
                this.jPR.setVisibility(0);
                this.jPR.setText(this.mSignActivityInfo.countdown_msg);
                F(this.mSignActivityInfo.activity_msg, this.mSignActivityInfo.activity_time.intValue() - currentTimeMillis);
            }
            if (!this.jqh) {
                F(this.mSignActivityInfo.countdown_msg, (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue()) - currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(final String str, long j) {
        this.jKv = false;
        this.eCO = Executors.newScheduledThreadPool(1);
        this.eCO.schedule(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.jPR != null) {
                            if (b.this.jPR.getVisibility() == 8) {
                                b.this.jPR.setVisibility(0);
                                b.this.jPR.setText(str);
                                if (b.this.mSignActivityInfo != null) {
                                    b.this.F(b.this.mSignActivityInfo.activity_msg, b.this.mSignActivityInfo.countdown_time.intValue());
                                }
                            } else if (b.this.jPR.getVisibility() == 0) {
                                b.this.cGp();
                            }
                        }
                    }
                });
            }
        }, j, TimeUnit.SECONDS);
    }
}
