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
    private CountDownTimer gOm;
    private View hwo;
    private TextView jpY;
    private TextView jpZ;
    private aw jqb;
    private boolean jqc;
    private LinearLayout jqe;
    private View jqf;
    private View jqg;
    private View jqh;
    private View jqi;
    private final View jqj;
    private final HeadImageView jqk;
    private final TextView jql;
    private final View jqm;
    private final ImageView jqn;
    private final TextView jqo;
    private HotRankEntryView jqp;
    private List<n> jqq;
    private e jqr;
    private boolean jqu;
    private boolean jqv;
    private RelativeLayout mContainer;
    private boolean jqd = false;
    private int jqs = -1;
    private long jqt = 1000;
    private ArrayList<TbImageView> jqa = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.jiS = frsFragment;
        this.eUY = frsFragment.getPageContext();
        this.jPK = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jPL = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jPM = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cGa();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jPX = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jIY = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jPY = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jPY.setPageId(this.jiS.getUniqueId());
        this.jPY.setDefaultBgResource(R.color.transparent);
        this.jPY.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hwo = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.br(this.hwo).og(R.string.J_X11).oe(R.array.Mask_X005);
        this.jqe = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.jqf = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.jqg = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.jqh = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jPZ = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jQa = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jQc = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.jqi = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jQd = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jQe = this.mParent.findViewById(R.id.service_topview_space);
        this.jQj = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.jpY = (TextView) this.mParent.findViewById(R.id.member_image);
        this.jpZ = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jPP = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jPV = (TextView) this.mParent.findViewById(R.id.level);
        this.jKx = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jKx.setText(frsFragment.getResources().getString(R.string.attention));
        this.jKx.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jKx.setConfig(bVar);
        this.jKE = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jKE.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pS(R.color.CAM_X0105);
        bVar2.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jKE.setConfig(bVar2);
        this.jKE.setText(frsFragment.getResources().getString(R.string.sign));
        this.jcR = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.jcS = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jPN = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jPO = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.jeW = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jPR = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jQl = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jQl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jQl.setPageId(this.jiS.getUniqueId());
        this.jQl.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jQl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jQl.setShowOval(true);
        this.jQl.setPlaceHolder(1);
        this.jPU = this.mParent.findViewById(R.id.level_container);
        this.jPT = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jPS = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jPW = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.jqj = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.jql = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.jqk = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.jqk.setIsRound(true);
        this.jqk.setDrawBorder(true);
        this.jqk.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jqk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jqm = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.jqn = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.jqo = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.jqn, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jQg = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jPQ = LayoutInflater.from(this.jiS.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.jqp = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jPQ.setVisibility(8);
        this.jQo = new com.baidu.tieba.frs.d.b(this.eUY);
        this.jQf = (EMTextView) this.mParent.findViewById(R.id.count_down);
    }

    protected View cGa() {
        return LayoutInflater.from(this.jiS.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void C(View.OnClickListener onClickListener) {
        this.jQl.setOnClickListener(onClickListener);
        this.jeW.setOnClickListener(onClickListener);
        this.jKE.setOnClickListener(onClickListener);
        this.jKx.setOnClickListener(onClickListener);
        this.jPU.setOnClickListener(onClickListener);
        if (this.jqp != null) {
            this.jqp.setOnClickListener(onClickListener);
        }
        if (this.jqj != null) {
            this.jqj.setOnClickListener(onClickListener);
        }
        if (this.jqm != null) {
            this.jqm.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGb() {
        this.jPR.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eUY.getLayoutMode().setNightMode(i == 1);
        this.eUY.getLayoutMode().onModeChanged(this.mParent);
        this.eUY.getLayoutMode().onModeChanged(this.jQg);
        this.eUY.getLayoutMode().onModeChanged(this.jPQ);
        ap.setBackgroundResource(this.jcR, R.drawable.frs_exp_progress);
        ap.setBackgroundResource(this.jqf, R.drawable.bg_frs_header_round_corner);
        ap.setBackgroundColor(this.jqg, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jqh, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jQc, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jQd, R.color.CAM_X0624);
        ap.setBackgroundColor(this.jqi, R.color.CAM_X0201);
        ap.setBackgroundColor(this.jcS, R.color.CAM_X0101);
        ap.setBackgroundColor(this.jPW, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ap.setViewTextColor(this.jeW, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPV, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPP, R.color.CAM_X0101);
        ap.setViewTextColor(this.jpY, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPN, R.color.CAM_X0101);
        ap.setViewTextColor(this.jpZ, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPO, R.color.CAM_X0101);
        ap.setViewTextColor(this.jql, R.color.CAM_X0101);
        ap.setViewTextColor(this.jqo, R.color.CAM_X0101);
        ap.setViewTextColor(this.jPO, R.color.CAM_X0101);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jQf).oa(R.string.F_X01).nY(R.color.CAM_X0101);
        if (this.jQl != null) {
            this.jQl.setBorderWidth(l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds1));
            this.jQl.setBorderColor(ap.getColor(R.color.CAM_X0603));
            this.jQl.setStrokeColorResId(R.color.CAM_X0201);
            this.jQl.setPlaceHolder(1);
            this.jQl.invalidate();
        }
        if (this.jqk != null) {
            this.jqk.invalidate();
        }
        if (this.jQm != null) {
            this.jQm.onChangeSkin(i);
        }
        if (this.jIY != null) {
            this.jIY.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.jqa.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cGv();
        Bd(this.jQz ? 1 : 0);
        cGf();
        zl(i);
        ae(cGj(), cGk());
        if (this.jPZ != null) {
            this.jPZ.onChangeSkinType(i);
        }
        if (this.jQc != null) {
            this.jQc.onChangeSkinType(i);
        }
        if (this.jQb != null) {
            this.jQb.onChangeSkinType(i);
        }
        if (this.jqp != null) {
            this.jqp.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cb(boolean z) {
        super.cb(z);
        if (this.jQb != null) {
            this.jQb.cb(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jQt = forumData.getPost_num();
            this.jQq = forumData.getTag_color();
            this.dcS = forumData.getImage_url();
            this.jQp = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jQu = forumData.getSignData().count_sign_num;
                this.jQv = forumData.getSignData().miss_sign_num;
            }
            this.jQw = forumData.getCurScore();
            this.jKH = forumData.getLevelupScore();
            this.jQn = forumData.getBadgeData();
            this.jQr = forumData.getAccelerateContent();
            this.jQB = forumData.isBrandForum;
            this.jGJ = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jGJ != null && this.jGJ.getHotUserRankData() != null && this.jGJ.getHotUserRankData().hot_user != null && this.jGJ.getHotUserRankData().hot_user.size() >= 3) {
                this.jPZ.setHasHotRankList(true);
            } else {
                this.jPZ.setHasHotRankList(false);
            }
            if ((this.jGJ != null && this.jGJ.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bJf()) || this.jPZ.cKf()) {
                this.jPZ.setVisibility(0);
                this.jqg.setVisibility(0);
                this.jPZ.setData(this.jGJ.serviceAreaData, this.jGJ);
            } else {
                this.jPZ.setVisibility(8);
                this.jqg.setVisibility(8);
            }
            this.jQs = new cb();
            cGc();
            cGg();
            b(forumData);
            if (frsViewData != null) {
                this.mSignActivityInfo = frsViewData.mSignActivityInfo;
                cGw();
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
                this.jql.setText(str);
                this.jqk.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.jqj.setVisibility(0);
            } else {
                this.jqj.setVisibility(8);
            }
            if (this.jqm.getVisibility() == 0) {
                this.jqm.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jqj.getVisibility() == 0) {
            this.jqj.setVisibility(8);
        }
        if (this.jqm.getVisibility() == 8) {
            this.jqm.setVisibility(0);
        }
    }

    protected void cGc() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.dcS);
        this.jQs.bnZ().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cGd() {
        if (this.jKW != null) {
            this.jKW.Aw(this.jQv);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cGe() {
        if (this.jKW != null) {
            this.jKW.rB(this.jKJ);
        }
    }

    protected void cGf() {
        if (this.jKX != null) {
            this.jKX.cGf();
        }
    }

    protected void cGg() {
        if (this.jPN != null) {
            this.jPN.setText(au.ed(this.mMemberNum));
        }
        if (this.jPO != null) {
            this.jPO.setText(au.ed(this.jQt));
        }
        if (this.jQn != null && this.jQn.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jQB) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eUY.getString(R.string.forum);
        if (this.bMg != null) {
            this.bMg.setText(str);
        }
        if (this.jeW != null) {
            this.jeW.setText(str);
        }
        cGp();
        this.jqc = cGo();
        if (this.jqc) {
            this.jIY.setVisibility(8);
            this.hwo.setVisibility(0);
        } else {
            this.hwo.setVisibility(8);
            this.jIY.setVisibility(0);
            this.jPY.setOnClickListener(null);
        }
        cGl();
        zl(TbadkCoreApplication.getInst().getSkinType());
        cGh();
    }

    private void cGh() {
        boolean cGj = cGj();
        boolean cGk = cGk();
        if (!TextUtils.isEmpty(this.mForumName)) {
            com.baidu.tieba.frs.c.e Lg = d.cKy().Lg(this.mForumName);
            if (Lg == null) {
                Lg = new com.baidu.tieba.frs.c.e(this.jqd, cGj);
            } else {
                Lg.rx(this.jqd);
                Lg.ry(cGj);
            }
            d.cKy().a(this.mForumName, Lg);
        }
        ad(cGj, cGk);
        ae(cGj, cGk);
    }

    private void ad(boolean z, boolean z2) {
        if (this.jiS.cCz() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jqe.getLayoutParams();
            if (!z && !z2) {
                this.jqe.setVisibility(0);
                this.jqg.setVisibility(8);
                this.jqh.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds50);
            } else {
                this.jqe.setVisibility(0);
                this.jqg.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds55);
            }
            this.jiS.cCz().ag(z, z2);
        }
    }

    private void ae(boolean z, boolean z2) {
        int dimens;
        if (this.jPX != null && this.jPX.getLayoutParams() != null) {
            if (this.jqp.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jPW.getLayoutParams()).topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eUY.getPageActivity());
                ((RelativeLayout.LayoutParams) this.jqp.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.jqc) {
                dimens -= l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds80);
            } else if (this.jqc) {
                int dimens3 = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds782);
                int af = af(z, z2);
                int i = dimens3 + af;
                ((RelativeLayout.LayoutParams) this.jPY.getLayoutParams()).bottomMargin = af;
                ((RelativeLayout.LayoutParams) this.hwo.getLayoutParams()).bottomMargin = af;
                if (af != 0) {
                    ((RelativeLayout.LayoutParams) this.jPW.getLayoutParams()).topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jPW.getLayoutParams()).topMargin = l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds493);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jPX.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jPX.setLayoutParams(layoutParams);
            }
        }
    }

    private int af(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jGJ.serviceAreaData == null || this.jGJ.serviceAreaData.dataList == null || this.jGJ.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.jqq != null) {
            i += Math.min(this.jqq.size(), 2) * l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jQa.getVisibility() == 0) {
            i += l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jQa.getVisibility() == 0) {
            return i + l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cGi() {
        if (this.jiS == null || this.jiS.cCz() == null) {
            return null;
        }
        View cLN = this.jiS.cCz().cLN();
        if (cLN instanceof LinearGradientView) {
            return (LinearGradientView) cLN;
        }
        return null;
    }

    private boolean cGj() {
        return this.jQc != null && this.jQc.getVisibility() == 0;
    }

    private boolean cGk() {
        return this.jPZ != null && this.jPZ.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGl() {
        if (this.jiS != null && this.jGJ != null) {
            List<n> showTopThreadList = this.jGJ.getShowTopThreadList();
            this.jqd = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jGJ.getBusinessPromot());
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
    public boolean cGm() {
        return this.jKJ;
    }

    @Override // com.baidu.tieba.frs.view.b
    public SignActivityInfo cGn() {
        return this.mSignActivityInfo;
    }

    private void a(List<n> list, i iVar) {
        if (this.jQc != null) {
            this.jqq = list;
            if (iVar != null) {
                this.jQb = new g(this.eUY.getPageActivity());
                this.jQa.setVisibility(0);
                this.jQa.addView(this.jQb.getView());
                this.jQb.a(this.jGJ != null ? this.jGJ.getForum() : null, iVar);
            } else {
                this.jQa.setVisibility(8);
            }
            if (this.jiS != null && this.jiS.cCI()) {
                this.jQc.setVisibility(0);
                this.jQc.setFragmentUniqueId(this.jiS.getUniqueId());
                this.jQc.setForum(this.mForumId, this.mForumName, this.jGJ != null ? this.jGJ.getForum() : null, this.jGJ != null ? this.jGJ.getUserData() : null, this.jiS.getFrom());
                if (list.size() > 0 && (list.get(0) instanceof p)) {
                    this.jqs = 0;
                } else if (list.size() > 1 && (list.get(1) instanceof p)) {
                    this.jqs = 1;
                } else {
                    this.jqs = -1;
                }
                this.jQc.setDatas(list, iVar);
                if (this.jqb == null) {
                    this.jqb = new aw() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.aw
                        public void ap(cb cbVar) {
                            k.a(b.this.jiS, b.this.jGJ, cbVar);
                        }
                    };
                }
                this.jQc.setStatListener(this.jqb);
                return;
            }
            this.jQc.setVisibility(8);
        }
    }

    private boolean cGo() {
        final aa aaVar;
        if (this.jGJ == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jGJ;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dMO())) {
            aaVar = new aa();
            aaVar.setLinkUrl("");
            aaVar.setImageUrl(frsViewData.getStar().dMO());
        } else {
            aaVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().blR()) < 1) ? null : frsViewData.getActivityHeadData().blR().get(0);
        }
        if (aaVar != null) {
            if (this.jPY != null) {
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
                    com.baidu.tieba.s.c.dMz().a(this.jiS.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().blS(), "", (BaijiahaoData) null), arVar2);
                }
                this.jPY.startLoad(aaVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(aaVar.getLinkUrl())) {
                    this.jPY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
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
                                    com.baidu.tieba.s.c.dMz().b(b.this.jiS.getUniqueId(), arVar4);
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
        if (this.jGJ != null && (forum = this.jGJ.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jqc) {
                LinearGradientView cGi = cGi();
                if (this.jIY != null && cGi != null) {
                    this.jIY.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jPY != null) {
                    this.jPY.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jPZ != null) {
                this.jPZ.setThemeFontColor(com.baidu.tieba.lego.card.c.b.rM(themeElement.common_color));
            }
            if (this.jQc != null) {
                this.jQc.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.c.b.rM(themeElement.common_color));
            }
        }
    }

    protected void cGp() {
        this.jQl.startLoad(this.dcS, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jQG);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eUY.getPageActivity());
                this.mPopup.setContentView(this.jQg);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jQh = (TextView) this.jQg.findViewById(R.id.cur_experience);
            this.jQi = (TextView) this.jQg.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jQg.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jQg.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ap.setViewTextColor(this.jQh, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jQi, R.color.CAM_X0111, 1);
            a(this.jQh, this.jQi);
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
            this.mHandler.postDelayed(this.jQG, 2000L);
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
            if (!TextUtils.isEmpty(this.jQr) && !TextUtils.isEmpty(this.jQr.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jQr);
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
    public void cGq() {
        View contentView;
        if (this.jQk == null) {
            this.jQk = new PopupWindow(this.eUY.getPageActivity());
            View inflate = LayoutInflater.from(this.eUY.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jQk.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eUY != null && b.this.eUY.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jQk, b.this.eUY.getPageActivity());
                        b.this.jiS.jgi = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eUY.getPageActivity(), b.this.eUY.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jQk.setWidth(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jQk.setHeight(this.eUY.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jQk.setBackgroundDrawable(new BitmapDrawable());
            this.jQk.setOutsideTouchable(true);
            this.jQk.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jQk);
                        b.this.jiS.jgi = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jQk.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jQj.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jQk, this.mParent, 0, (iArr[0] - (this.jQk.getWidth() / 2)) + (this.jQj.getWidth() / 2), iArr[1] + this.jQj.getWidth());
        this.jQk.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGr() {
        String string;
        String str;
        View view;
        if (this.jqs != -1 && this.jGJ != null && this.jGJ.forumRule != null && this.jGJ.getUserData() != null && this.jQc != null) {
            if (this.jGJ.getUserData().getIs_manager() == 1) {
                if (this.jGJ.forumRule.has_forum_rule.intValue() != 1 && this.jGJ.forumRule.audit_status.intValue() == 0) {
                    string = this.eUY.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.eUY.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            if (this.jQc.getmTopViews() != null && this.jQc.getmTopViews().size() > 0 && (this.jQc.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.jQc.getmTopViews().get(0);
                if (this.jqs < adapterLinearLayout.getChildCount()) {
                    view = adapterLinearLayout.getChildAt(this.jqs);
                    if (this.jqr != null && view != null) {
                        this.jqr = new e(this.eUY, view);
                        this.jqr.en(R.drawable.bg_tip_blue_up_left);
                        this.jqr.em(16);
                        this.jqr.pJ(true);
                        this.jqr.xl(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                        this.jqr.setYOffset(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                        this.jqr.setUseDirectOffset(true);
                        this.jqr.eo(4000);
                        if (!this.jqr.isShowing() && !this.jiS.cDh()) {
                            this.jqr.aJ(string, str);
                            return;
                        }
                        return;
                    }
                }
            }
            view = null;
            if (this.jqr != null) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGs() {
        if (this.jqr != null) {
            this.jqr.Tz();
            this.jqs = -1;
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGt() {
        this.jQc.AK(this.jqs);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jQA = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jPP != null && this.jcR != null && this.jPV != null && cashBitmap.getWidth() > 0) {
            if (this.jQA) {
                this.jPP.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cDg = this.jiS.cDg();
                if (cDg != null && cDg.getForum() != null) {
                    cDg.getForum().setUser_level(i);
                }
                this.jPV.setText(this.eUY.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jPP.setText(this.jQp);
                this.jPV.setText(this.eUY.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.jcR.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yk(this.mLevel)));
            if (this.jQA) {
                if (f >= 1.0f) {
                    b(this.jcR, this.jQC, f);
                } else {
                    c(this.jcR, this.jQC, f);
                }
            } else {
                b(this.jcR, this.jQC, f);
            }
            this.jQC = f;
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
    protected void cGu() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cGv() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jQj, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jQj, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jQk != null && this.jQk.isShowing()) {
            this.jQk.dismiss();
        }
        cGs();
        if (this.jQb != null) {
            this.jQb.onDestroy();
        }
        if (this.gOm != null) {
            this.gOm.cancel();
            this.gOm = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.frs.entelechy.b$7] */
    private void c(final String str, long j, long j2) {
        this.jKJ = true;
        this.gOm = new CountDownTimer(j, j2) { // from class: com.baidu.tieba.frs.entelechy.b.7
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (b.this.jQf != null) {
                    b.this.jQf.setVisibility(0);
                    b.this.jQf.setText(str + (j3 / 1000) + "s");
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.jKJ = false;
                if (b.this.jQf != null) {
                    b.this.jQf.setVisibility(8);
                }
                if (b.this.jKW != null && !b.this.cLz()) {
                    b.this.jKW.rB(b.this.jKJ);
                }
            }
        }.start();
        if (this.jKW != null && !cLz()) {
            this.jKW.rB(this.jKJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGw() {
        if (this.mSignActivityInfo != null) {
            if (this.gOm != null) {
                this.gOm.cancel();
                this.gOm.onFinish();
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.jqu = ((long) (this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue())) - currentTimeMillis < 0;
            this.chi = ((long) this.mSignActivityInfo.activity_time.intValue()) - currentTimeMillis <= 0;
            this.jqv = ((long) (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue())) - currentTimeMillis <= 0;
            if (this.jqu) {
                this.jQf.setVisibility(8);
                return;
            }
            if (this.chi && !this.jqu) {
                c(this.mSignActivityInfo.activity_msg, ((this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue()) - currentTimeMillis) * 1000, this.jqt);
            }
            if (!this.chi && this.jqv) {
                this.jQf.setVisibility(0);
                this.jQf.setText(this.mSignActivityInfo.countdown_msg);
                F(this.mSignActivityInfo.activity_msg, this.mSignActivityInfo.activity_time.intValue() - currentTimeMillis);
            }
            if (!this.jqv) {
                F(this.mSignActivityInfo.countdown_msg, (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue()) - currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(final String str, long j) {
        this.jKJ = false;
        this.eCO = Executors.newScheduledThreadPool(1);
        this.eCO.schedule(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.jQf != null) {
                            if (b.this.jQf.getVisibility() == 8) {
                                b.this.jQf.setVisibility(0);
                                b.this.jQf.setText(str);
                                if (b.this.mSignActivityInfo != null) {
                                    b.this.F(b.this.mSignActivityInfo.activity_msg, b.this.mSignActivityInfo.countdown_time.intValue());
                                }
                            } else if (b.this.jQf.getVisibility() == 0) {
                                b.this.cGw();
                            }
                        }
                    }
                });
            }
        }, j, TimeUnit.SECONDS);
    }
}
