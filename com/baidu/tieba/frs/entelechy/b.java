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
    private boolean ciJ;
    private String dev;
    private ScheduledExecutorService eEp;
    private CountDownTimer gPV;
    private View hxX;
    private TextView jrH;
    private TextView jrI;
    private aw jrK;
    private boolean jrL;
    private LinearLayout jrN;
    private View jrO;
    private View jrP;
    private View jrQ;
    private View jrR;
    private final View jrS;
    private final HeadImageView jrT;
    private final TextView jrU;
    private final View jrV;
    private final ImageView jrW;
    private final TextView jrX;
    private HotRankEntryView jrY;
    private List<n> jrZ;
    private e jsa;
    private boolean jsd;
    private boolean jse;
    private RelativeLayout mContainer;
    private boolean jrM = false;
    private int jsb = -1;
    private long jsc = 1000;
    private ArrayList<TbImageView> jrJ = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.jkB = frsFragment;
        this.eWx = frsFragment.getPageContext();
        this.jRt = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jRu = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jRv = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cGg();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jRG = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jKH = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jRH = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jRH.setPageId(this.jkB.getUniqueId());
        this.jRH.setDefaultBgResource(R.color.transparent);
        this.jRH.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hxX = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.br(this.hxX).oh(R.string.J_X11).of(R.array.Mask_X005);
        this.jrN = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.jrO = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.jrP = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.jrQ = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jRI = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jRJ = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jRL = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.jrR = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jRM = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jRN = this.mParent.findViewById(R.id.service_topview_space);
        this.jRS = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.jrH = (TextView) this.mParent.findViewById(R.id.member_image);
        this.jrI = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jRy = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jRE = (TextView) this.mParent.findViewById(R.id.level);
        this.jMg = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jMg.setText(frsFragment.getResources().getString(R.string.attention));
        this.jMg.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jMg.setConfig(bVar);
        this.jMn = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jMn.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pT(R.color.CAM_X0105);
        bVar2.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jMn.setConfig(bVar2);
        this.jMn.setText(frsFragment.getResources().getString(R.string.sign));
        this.jeA = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.jeB = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jRw = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jRx = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.jgF = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jRA = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jRU = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jRU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jRU.setPageId(this.jkB.getUniqueId());
        this.jRU.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jRU.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jRU.setShowOval(true);
        this.jRU.setPlaceHolder(1);
        this.jRD = this.mParent.findViewById(R.id.level_container);
        this.jRC = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jRB = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jRF = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.jrS = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.jrU = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.jrT = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.jrT.setIsRound(true);
        this.jrT.setDrawBorder(true);
        this.jrT.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jrT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jrV = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.jrW = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.jrX = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.jrW, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jRP = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jRz = LayoutInflater.from(this.jkB.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.jrY = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jRz.setVisibility(8);
        this.jRX = new com.baidu.tieba.frs.d.b(this.eWx);
        this.jRO = (EMTextView) this.mParent.findViewById(R.id.count_down);
    }

    protected View cGg() {
        return LayoutInflater.from(this.jkB.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void C(View.OnClickListener onClickListener) {
        this.jRU.setOnClickListener(onClickListener);
        this.jgF.setOnClickListener(onClickListener);
        this.jMn.setOnClickListener(onClickListener);
        this.jMg.setOnClickListener(onClickListener);
        this.jRD.setOnClickListener(onClickListener);
        if (this.jrY != null) {
            this.jrY.setOnClickListener(onClickListener);
        }
        if (this.jrS != null) {
            this.jrS.setOnClickListener(onClickListener);
        }
        if (this.jrV != null) {
            this.jrV.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGh() {
        this.jRA.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eWx.getLayoutMode().setNightMode(i == 1);
        this.eWx.getLayoutMode().onModeChanged(this.mParent);
        this.eWx.getLayoutMode().onModeChanged(this.jRP);
        this.eWx.getLayoutMode().onModeChanged(this.jRz);
        ap.setBackgroundResource(this.jeA, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.jrO, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.jrP, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jrQ, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jRL, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jRM, R.color.CAM_X0624);
        ap.setBackgroundColor(this.jrR, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jeB, R.color.CAM_X0101);
        ap.setBackgroundColor(this.jRF, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ap.setViewTextColor(this.jgF, R.color.CAM_X0101);
        ap.setViewTextColor(this.jRE, R.color.CAM_X0101);
        ap.setViewTextColor(this.jRy, R.color.CAM_X0101);
        ap.setViewTextColor(this.jrH, R.color.CAM_X0101);
        ap.setViewTextColor(this.jRw, R.color.CAM_X0101);
        ap.setViewTextColor(this.jrI, R.color.CAM_X0101);
        ap.setViewTextColor(this.jRx, R.color.CAM_X0101);
        ap.setViewTextColor(this.jrU, R.color.CAM_X0101);
        ap.setViewTextColor(this.jrX, R.color.CAM_X0101);
        ap.setViewTextColor(this.jRx, R.color.CAM_X0101);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRO).ob(R.string.F_X01).nZ(R.color.CAM_X0101);
        if (this.jRU != null) {
            this.jRU.setBorderWidth(l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds1));
            this.jRU.setBorderColor(ap.getColor(R.color.CAM_X0603));
            this.jRU.setStrokeColorResId(R.color.CAM_X0201);
            this.jRU.setPlaceHolder(1);
            this.jRU.invalidate();
        }
        if (this.jrT != null) {
            this.jrT.invalidate();
        }
        if (this.jRV != null) {
            this.jRV.onChangeSkin(i);
        }
        if (this.jKH != null) {
            this.jKH.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.jrJ.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cGB();
        Be(this.jSi ? 1 : 0);
        cGl();
        zm(i);
        ae(cGp(), cGq());
        if (this.jRI != null) {
            this.jRI.onChangeSkinType(i);
        }
        if (this.jRL != null) {
            this.jRL.onChangeSkinType(i);
        }
        if (this.jRK != null) {
            this.jRK.onChangeSkinType(i);
        }
        if (this.jrY != null) {
            this.jrY.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cb(boolean z) {
        super.cb(z);
        if (this.jRK != null) {
            this.jRK.cb(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jSc = forumData.getPost_num();
            this.jRZ = forumData.getTag_color();
            this.dev = forumData.getImage_url();
            this.jRY = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jSd = forumData.getSignData().count_sign_num;
                this.jSe = forumData.getSignData().miss_sign_num;
            }
            this.jSf = forumData.getCurScore();
            this.jMq = forumData.getLevelupScore();
            this.jRW = forumData.getBadgeData();
            this.jSa = forumData.getAccelerateContent();
            this.jSk = forumData.isBrandForum;
            this.jIs = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jIs != null && this.jIs.getHotUserRankData() != null && this.jIs.getHotUserRankData().hot_user != null && this.jIs.getHotUserRankData().hot_user.size() >= 3) {
                this.jRI.setHasHotRankList(true);
            } else {
                this.jRI.setHasHotRankList(false);
            }
            if ((this.jIs != null && this.jIs.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bJj()) || this.jRI.cKl()) {
                this.jRI.setVisibility(0);
                this.jrP.setVisibility(0);
                this.jRI.setData(this.jIs.serviceAreaData, this.jIs);
            } else {
                this.jRI.setVisibility(8);
                this.jrP.setVisibility(8);
            }
            this.jSb = new cb();
            cGi();
            cGm();
            b(forumData);
            if (frsViewData != null) {
                this.mSignActivityInfo = frsViewData.mSignActivityInfo;
                cGC();
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
                this.jrU.setText(str);
                this.jrT.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.jrS.setVisibility(0);
            } else {
                this.jrS.setVisibility(8);
            }
            if (this.jrV.getVisibility() == 0) {
                this.jrV.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jrS.getVisibility() == 0) {
            this.jrS.setVisibility(8);
        }
        if (this.jrV.getVisibility() == 8) {
            this.jrV.setVisibility(0);
        }
    }

    protected void cGi() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.dev);
        this.jSb.bob().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cGj() {
        if (this.jMF != null) {
            this.jMF.Ax(this.jSe);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cGk() {
        if (this.jMF != null) {
            this.jMF.rB(this.jMs);
        }
    }

    protected void cGl() {
        if (this.jMG != null) {
            this.jMG.cGl();
        }
    }

    protected void cGm() {
        if (this.jRw != null) {
            this.jRw.setText(au.ed(this.mMemberNum));
        }
        if (this.jRx != null) {
            this.jRx.setText(au.ed(this.jSc));
        }
        if (this.jRW != null && this.jRW.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jSk) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eWx.getString(R.string.forum);
        if (this.bNG != null) {
            this.bNG.setText(str);
        }
        if (this.jgF != null) {
            this.jgF.setText(str);
        }
        cGv();
        this.jrL = cGu();
        if (this.jrL) {
            this.jKH.setVisibility(8);
            this.hxX.setVisibility(0);
        } else {
            this.hxX.setVisibility(8);
            this.jKH.setVisibility(0);
            this.jRH.setOnClickListener(null);
        }
        cGr();
        zm(TbadkCoreApplication.getInst().getSkinType());
        cGn();
    }

    private void cGn() {
        boolean cGp = cGp();
        boolean cGq = cGq();
        if (!TextUtils.isEmpty(this.mForumName)) {
            com.baidu.tieba.frs.c.e Lp = d.cKE().Lp(this.mForumName);
            if (Lp == null) {
                Lp = new com.baidu.tieba.frs.c.e(this.jrM, cGp);
            } else {
                Lp.rx(this.jrM);
                Lp.ry(cGp);
            }
            d.cKE().a(this.mForumName, Lp);
        }
        ad(cGp, cGq);
        ae(cGp, cGq);
    }

    private void ad(boolean z, boolean z2) {
        if (this.jkB.cCF() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jrN.getLayoutParams();
            if (!z && !z2) {
                this.jrN.setVisibility(0);
                this.jrP.setVisibility(8);
                this.jrQ.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds50);
            } else {
                this.jrN.setVisibility(0);
                this.jrP.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds55);
            }
            this.jkB.cCF().ag(z, z2);
        }
    }

    private void ae(boolean z, boolean z2) {
        int dimens;
        if (this.jRG != null && this.jRG.getLayoutParams() != null) {
            if (this.jrY.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jRF.getLayoutParams()).topMargin = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eWx.getPageActivity());
                ((RelativeLayout.LayoutParams) this.jrY.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.jrL) {
                dimens -= l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds80);
            } else if (this.jrL) {
                int dimens3 = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds782);
                int af = af(z, z2);
                int i = dimens3 + af;
                ((RelativeLayout.LayoutParams) this.jRH.getLayoutParams()).bottomMargin = af;
                ((RelativeLayout.LayoutParams) this.hxX.getLayoutParams()).bottomMargin = af;
                if (af != 0) {
                    ((RelativeLayout.LayoutParams) this.jRF.getLayoutParams()).topMargin = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jRF.getLayoutParams()).topMargin = l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds493);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jRG.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jRG.setLayoutParams(layoutParams);
            }
        }
    }

    private int af(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jIs.serviceAreaData == null || this.jIs.serviceAreaData.dataList == null || this.jIs.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.jrZ != null) {
            i += Math.min(this.jrZ.size(), 2) * l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jRJ.getVisibility() == 0) {
            i += l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jRJ.getVisibility() == 0) {
            return i + l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cGo() {
        if (this.jkB == null || this.jkB.cCF() == null) {
            return null;
        }
        View cLT = this.jkB.cCF().cLT();
        if (cLT instanceof LinearGradientView) {
            return (LinearGradientView) cLT;
        }
        return null;
    }

    private boolean cGp() {
        return this.jRL != null && this.jRL.getVisibility() == 0;
    }

    private boolean cGq() {
        return this.jRI != null && this.jRI.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGr() {
        if (this.jkB != null && this.jIs != null) {
            List<n> showTopThreadList = this.jIs.getShowTopThreadList();
            this.jrM = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jIs.getBusinessPromot());
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
    public boolean cGs() {
        return this.jMs;
    }

    @Override // com.baidu.tieba.frs.view.b
    public SignActivityInfo cGt() {
        return this.mSignActivityInfo;
    }

    private void a(List<n> list, i iVar) {
        if (this.jRL != null) {
            this.jrZ = list;
            if (iVar != null) {
                this.jRK = new g(this.eWx.getPageActivity());
                this.jRJ.setVisibility(0);
                this.jRJ.addView(this.jRK.getView());
                this.jRK.a(this.jIs != null ? this.jIs.getForum() : null, iVar);
            } else {
                this.jRJ.setVisibility(8);
            }
            if (this.jkB != null && this.jkB.cCO()) {
                this.jRL.setVisibility(0);
                this.jRL.setFragmentUniqueId(this.jkB.getUniqueId());
                this.jRL.setForum(this.mForumId, this.mForumName, this.jIs != null ? this.jIs.getForum() : null, this.jIs != null ? this.jIs.getUserData() : null, this.jkB.getFrom());
                if (list.size() > 0 && (list.get(0) instanceof p)) {
                    this.jsb = 0;
                } else if (list.size() > 1 && (list.get(1) instanceof p)) {
                    this.jsb = 1;
                } else {
                    this.jsb = -1;
                }
                this.jRL.setDatas(list, iVar);
                if (this.jrK == null) {
                    this.jrK = new aw() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.aw
                        public void ap(cb cbVar) {
                            k.a(b.this.jkB, b.this.jIs, cbVar);
                        }
                    };
                }
                this.jRL.setStatListener(this.jrK);
                return;
            }
            this.jRL.setVisibility(8);
        }
    }

    private boolean cGu() {
        final aa aaVar;
        if (this.jIs == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jIs;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dMW())) {
            aaVar = new aa();
            aaVar.setLinkUrl("");
            aaVar.setImageUrl(frsViewData.getStar().dMW());
        } else {
            aaVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().blT()) < 1) ? null : frsViewData.getActivityHeadData().blT().get(0);
        }
        if (aaVar != null) {
            if (this.jRH != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().blU())) {
                    ar arVar = new ar("c13326");
                    arVar.dR("fid", frsViewData.getForum().getId());
                    arVar.dR("obj_id", frsViewData.getActivityHeadData().blU());
                    TiebaStatic.log(arVar);
                    ar arVar2 = new ar("common_exp");
                    arVar2.dR("page_type", PageStayDurationConstants.PageName.FRS).aq("obj_isad", 1).aq("obj_floor", 1).dR("fid", frsViewData.getForum().getId()).dR("obj_id", frsViewData.getActivityHeadData().blU()).aq("obj_adlocate", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().frW);
                    }
                    com.baidu.tieba.s.c.dMH().a(this.jkB.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().blU(), "", (BaijiahaoData) null), arVar2);
                }
                this.jRH.startLoad(aaVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(aaVar.getLinkUrl())) {
                    this.jRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eWx != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().blU())) {
                                    String id = frsViewData.getForum().getId();
                                    String blU = frsViewData.getActivityHeadData().blU();
                                    ar arVar3 = new ar("c13330");
                                    arVar3.dR("fid", id);
                                    arVar3.dR("obj_id", blU);
                                    TiebaStatic.log(arVar3);
                                    ar arVar4 = new ar("common_click");
                                    arVar4.dR("page_type", PageStayDurationConstants.PageName.FRS).aq("obj_isad", 1).dR("fid", id).dR("obj_id", blU).aq("obj_adlocate", 1).aq("obj_floor", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        arVar3.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().frW);
                                    }
                                    com.baidu.tieba.s.c.dMH().b(b.this.jkB.getUniqueId(), arVar4);
                                }
                                bf.bsY().a(b.this.eWx, new String[]{aaVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void zm(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jIs != null && (forum = this.jIs.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jrL) {
                LinearGradientView cGo = cGo();
                if (this.jKH != null && cGo != null) {
                    this.jKH.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jRH != null) {
                    this.jRH.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jRI != null) {
                this.jRI.setThemeFontColor(com.baidu.tieba.lego.card.c.b.rT(themeElement.common_color));
            }
            if (this.jRL != null) {
                this.jRL.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.c.b.rT(themeElement.common_color));
            }
        }
    }

    protected void cGv() {
        this.jRU.startLoad(this.dev, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jSp);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eWx.getPageActivity());
                this.mPopup.setContentView(this.jRP);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jRQ = (TextView) this.jRP.findViewById(R.id.cur_experience);
            this.jRR = (TextView) this.jRP.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jRP.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jRP.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ap.setViewTextColor(this.jRQ, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jRR, R.color.CAM_X0111, 1);
            a(this.jRQ, this.jRR);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eWx.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eWx.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jSp, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eWx.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView3, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
            aVar.bn(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jSa) && !TextUtils.isEmpty(this.jSa.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jSa);
            } else {
                textView3.setVisibility(8);
            }
            aVar.nz(R.color.CAM_X0305);
            d(aVar);
            e(aVar);
            aVar.b(this.eWx);
            aVar.bqz();
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
                if (b.this.eWx != null && b.this.eWx.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eWx.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGw() {
        View contentView;
        if (this.jRT == null) {
            this.jRT = new PopupWindow(this.eWx.getPageActivity());
            View inflate = LayoutInflater.from(this.eWx.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jRT.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eWx != null && b.this.eWx.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jRT, b.this.eWx.getPageActivity());
                        b.this.jkB.jhR = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eWx.getPageActivity(), b.this.eWx.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jRT.setWidth(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jRT.setHeight(this.eWx.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jRT.setBackgroundDrawable(new BitmapDrawable());
            this.jRT.setOutsideTouchable(true);
            this.jRT.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jRT);
                        b.this.jkB.jhR = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jRT.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jRS.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jRT, this.mParent, 0, (iArr[0] - (this.jRT.getWidth() / 2)) + (this.jRS.getWidth() / 2), iArr[1] + this.jRS.getWidth());
        this.jRT.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGx() {
        String string;
        String str;
        View view;
        if (this.jsb != -1 && this.jIs != null && this.jIs.forumRule != null && this.jIs.getUserData() != null && this.jRL != null) {
            if (this.jIs.getUserData().getIs_manager() == 1) {
                if (this.jIs.forumRule.has_forum_rule.intValue() != 1 && this.jIs.forumRule.audit_status.intValue() == 0) {
                    string = this.eWx.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.eWx.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            if (this.jRL.getmTopViews() != null && this.jRL.getmTopViews().size() > 0 && (this.jRL.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.jRL.getmTopViews().get(0);
                if (this.jsb < adapterLinearLayout.getChildCount()) {
                    view = adapterLinearLayout.getChildAt(this.jsb);
                    if (this.jsa != null && view != null) {
                        this.jsa = new e(this.eWx, view);
                        this.jsa.eo(R.drawable.bg_tip_blue_up_left);
                        this.jsa.en(16);
                        this.jsa.pJ(true);
                        this.jsa.xm(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                        this.jsa.setYOffset(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                        this.jsa.setUseDirectOffset(true);
                        this.jsa.ep(4000);
                        if (!this.jsa.isShowing() && !this.jkB.cDn()) {
                            this.jsa.aJ(string, str);
                            return;
                        }
                        return;
                    }
                }
            }
            view = null;
            if (this.jsa != null) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGy() {
        if (this.jsa != null) {
            this.jsa.TC();
            this.jsb = -1;
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGz() {
        this.jRL.AL(this.jsb);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jSj = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jRy != null && this.jeA != null && this.jRE != null && cashBitmap.getWidth() > 0) {
            if (this.jSj) {
                this.jRy.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cDm = this.jkB.cDm();
                if (cDm != null && cDm.getForum() != null) {
                    cDm.getForum().setUser_level(i);
                }
                this.jRE.setText(this.eWx.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jRy.setText(this.jRY);
                this.jRE.setText(this.eWx.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.jeA.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yl(this.mLevel)));
            if (this.jSj) {
                if (f >= 1.0f) {
                    b(this.jeA, this.jSl, f);
                } else {
                    c(this.jeA, this.jSl, f);
                }
            } else {
                b(this.jeA, this.jSl, f);
            }
            this.jSl = f;
        }
    }

    private int[] yl(int i) {
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
    protected void cGA() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGB() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jRS, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jRS, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jRT != null && this.jRT.isShowing()) {
            this.jRT.dismiss();
        }
        cGy();
        if (this.jRK != null) {
            this.jRK.onDestroy();
        }
        if (this.gPV != null) {
            this.gPV.cancel();
            this.gPV = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.frs.entelechy.b$7] */
    private void c(final String str, long j, long j2) {
        this.jMs = true;
        this.gPV = new CountDownTimer(j, j2) { // from class: com.baidu.tieba.frs.entelechy.b.7
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (b.this.jRO != null) {
                    b.this.jRO.setVisibility(0);
                    b.this.jRO.setText(str + (j3 / 1000) + "s");
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.jMs = false;
                if (b.this.jRO != null) {
                    b.this.jRO.setVisibility(8);
                }
                if (b.this.jMF != null && !b.this.cLF()) {
                    b.this.jMF.rB(b.this.jMs);
                }
            }
        }.start();
        if (this.jMF != null && !cLF()) {
            this.jMF.rB(this.jMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGC() {
        if (this.mSignActivityInfo != null) {
            if (this.gPV != null) {
                this.gPV.cancel();
                this.gPV.onFinish();
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.jsd = ((long) (this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue())) - currentTimeMillis < 0;
            this.ciJ = ((long) this.mSignActivityInfo.activity_time.intValue()) - currentTimeMillis <= 0;
            this.jse = ((long) (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue())) - currentTimeMillis <= 0;
            if (this.jsd) {
                this.jRO.setVisibility(8);
                return;
            }
            if (this.ciJ && !this.jsd) {
                c(this.mSignActivityInfo.activity_msg, ((this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue()) - currentTimeMillis) * 1000, this.jsc);
            }
            if (!this.ciJ && this.jse) {
                this.jRO.setVisibility(0);
                this.jRO.setText(this.mSignActivityInfo.countdown_msg);
                F(this.mSignActivityInfo.activity_msg, this.mSignActivityInfo.activity_time.intValue() - currentTimeMillis);
            }
            if (!this.jse) {
                F(this.mSignActivityInfo.countdown_msg, (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue()) - currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(final String str, long j) {
        this.jMs = false;
        this.eEp = Executors.newScheduledThreadPool(1);
        this.eEp.schedule(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.jRO != null) {
                            if (b.this.jRO.getVisibility() == 8) {
                                b.this.jRO.setVisibility(0);
                                b.this.jRO.setText(str);
                                if (b.this.mSignActivityInfo != null) {
                                    b.this.F(b.this.mSignActivityInfo.activity_msg, b.this.mSignActivityInfo.countdown_time.intValue());
                                }
                            } else if (b.this.jRO.getVisibility() == 0) {
                                b.this.cGC();
                            }
                        }
                    }
                });
            }
        }, j, TimeUnit.SECONDS);
    }
}
