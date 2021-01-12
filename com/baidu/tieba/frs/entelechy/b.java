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
    private boolean ccY;
    private String cpN;
    private ScheduledExecutorService eAI;
    private CountDownTimer gLs;
    private View hrQ;
    private boolean jkA;
    private TextView jkd;
    private TextView jke;
    private aw jkg;
    private boolean jkh;
    private LinearLayout jkj;
    private View jkk;
    private View jkl;
    private View jkm;
    private View jkn;
    private final View jko;
    private final HeadImageView jkp;
    private final TextView jkq;
    private final View jkr;
    private final ImageView jks;
    private final TextView jkt;
    private HotRankEntryView jku;
    private List<n> jkv;
    private e jkw;
    private boolean jkz;
    private RelativeLayout mContainer;
    private boolean jki = false;
    private int jkx = -1;
    private long jky = 1000;
    private ArrayList<TbImageView> jkf = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.jcX = frsFragment;
        this.eSJ = frsFragment.getPageContext();
        this.jIz = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jIA = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jIB = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cEG();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jIM = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jDg = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jIN = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jIN.setPageId(this.jcX.getUniqueId());
        this.jIN.setDefaultBgResource(R.color.transparent);
        this.jIN.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hrQ = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.hrQ).od(R.string.J_X11).ob(R.array.Mask_X005);
        this.jkj = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.jkk = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.jkl = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.jkm = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jIO = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jIP = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jIR = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.jkn = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jIS = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jIT = this.mParent.findViewById(R.id.service_topview_space);
        this.jIY = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.jkd = (TextView) this.mParent.findViewById(R.id.member_image);
        this.jke = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jIE = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jIK = (TextView) this.mParent.findViewById(R.id.level);
        this.jEF = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jEF.setText(frsFragment.getResources().getString(R.string.attention));
        this.jEF.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jEF.setConfig(bVar);
        this.jEM = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jEM.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.pN(R.color.CAM_X0105);
        bVar2.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jEM.setConfig(bVar2);
        this.jEM.setText(frsFragment.getResources().getString(R.string.sign));
        this.iWW = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.iWX = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jIC = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jID = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.iZb = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jIG = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jJa = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jJa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jJa.setPageId(this.jcX.getUniqueId());
        this.jJa.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jJa.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jJa.setShowOval(true);
        this.jJa.setPlaceHolder(1);
        this.jIJ = this.mParent.findViewById(R.id.level_container);
        this.jII = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jIH = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jIL = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.jko = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.jkq = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.jkp = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.jkp.setIsRound(true);
        this.jkp.setDrawBorder(true);
        this.jkp.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jkp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jkr = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.jks = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.jkt = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.jks, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jIV = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jIF = LayoutInflater.from(this.jcX.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.jku = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jIF.setVisibility(8);
        this.jJd = new com.baidu.tieba.frs.d.b(this.eSJ);
        this.jIU = (EMTextView) this.mParent.findViewById(R.id.count_down);
    }

    protected View cEG() {
        return LayoutInflater.from(this.jcX.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void C(View.OnClickListener onClickListener) {
        this.jJa.setOnClickListener(onClickListener);
        this.iZb.setOnClickListener(onClickListener);
        this.jEM.setOnClickListener(onClickListener);
        this.jEF.setOnClickListener(onClickListener);
        this.jIJ.setOnClickListener(onClickListener);
        if (this.jku != null) {
            this.jku.setOnClickListener(onClickListener);
        }
        if (this.jko != null) {
            this.jko.setOnClickListener(onClickListener);
        }
        if (this.jkr != null) {
            this.jkr.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cEH() {
        this.jIG.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eSJ.getLayoutMode().setNightMode(i == 1);
        this.eSJ.getLayoutMode().onModeChanged(this.mParent);
        this.eSJ.getLayoutMode().onModeChanged(this.jIV);
        this.eSJ.getLayoutMode().onModeChanged(this.jIF);
        ao.setBackgroundResource(this.iWW, R.drawable.frs_exp_progress);
        ao.setBackgroundResource(this.jkk, R.drawable.bg_frs_header_round_corner);
        ao.setBackgroundColor(this.jkl, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jkm, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jIR, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jIS, R.color.CAM_X0624);
        ao.setBackgroundColor(this.jkn, R.color.CAM_X0201);
        ao.setBackgroundColor(this.iWX, R.color.CAM_X0101);
        ao.setBackgroundColor(this.jIL, R.color.black_alpha0);
        ao.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ao.setViewTextColor(this.iZb, R.color.CAM_X0101);
        ao.setViewTextColor(this.jIK, R.color.CAM_X0101);
        ao.setViewTextColor(this.jIE, R.color.CAM_X0101);
        ao.setViewTextColor(this.jkd, R.color.CAM_X0101);
        ao.setViewTextColor(this.jIC, R.color.CAM_X0101);
        ao.setViewTextColor(this.jke, R.color.CAM_X0101);
        ao.setViewTextColor(this.jID, R.color.CAM_X0101);
        ao.setViewTextColor(this.jkq, R.color.CAM_X0101);
        ao.setViewTextColor(this.jkt, R.color.CAM_X0101);
        ao.setViewTextColor(this.jID, R.color.CAM_X0101);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jIU).nX(R.string.F_X01).nV(R.color.CAM_X0101);
        if (this.jJa != null) {
            this.jJa.setBorderWidth(l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds1));
            this.jJa.setBorderColor(ao.getColor(R.color.CAM_X0603));
            this.jJa.setStrokeColorResId(R.color.CAM_X0201);
            this.jJa.setPlaceHolder(1);
            this.jJa.invalidate();
        }
        if (this.jkp != null) {
            this.jkp.invalidate();
        }
        if (this.jJb != null) {
            this.jJb.onChangeSkin(i);
        }
        if (this.jDg != null) {
            this.jDg.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.jkf.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cFb();
        AO(this.jJo ? 1 : 0);
        cEL();
        zb(i);
        ae(cEP(), cEQ());
        if (this.jIO != null) {
            this.jIO.onChangeSkinType(i);
        }
        if (this.jIR != null) {
            this.jIR.onChangeSkinType(i);
        }
        if (this.jIQ != null) {
            this.jIQ.onChangeSkinType(i);
        }
        if (this.jku != null) {
            this.jku.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bW(boolean z) {
        super.bW(z);
        if (this.jIQ != null) {
            this.jIQ.bW(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jJi = forumData.getPost_num();
            this.jJf = forumData.getTag_color();
            this.cpN = forumData.getImage_url();
            this.jJe = forumData.getLevelName();
            this.fyf = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jJj = forumData.getSignData().count_sign_num;
                this.jJk = forumData.getSignData().miss_sign_num;
            }
            this.jJl = forumData.getCurScore();
            this.jEP = forumData.getLevelupScore();
            this.jJc = forumData.getBadgeData();
            this.jJg = forumData.getAccelerateContent();
            this.jJq = forumData.isBrandForum;
            this.jAR = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jAR != null && this.jAR.getHotUserRankData() != null && this.jAR.getHotUserRankData().hot_user != null && this.jAR.getHotUserRankData().hot_user.size() >= 3) {
                this.jIO.setHasHotRankList(true);
            } else {
                this.jIO.setHasHotRankList(false);
            }
            if ((this.jAR != null && this.jAR.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bIM()) || this.jIO.cIL()) {
                this.jIO.setVisibility(0);
                this.jkl.setVisibility(0);
                this.jIO.setData(this.jAR.serviceAreaData, this.jAR);
            } else {
                this.jIO.setVisibility(8);
                this.jkl.setVisibility(8);
            }
            this.jJh = new bz();
            cEI();
            cEM();
            b(forumData);
            if (frsViewData != null) {
                this.mSignActivityInfo = frsViewData.mSignActivityInfo;
                cFc();
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
                this.jkq.setText(str);
                this.jkp.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.jko.setVisibility(0);
            } else {
                this.jko.setVisibility(8);
            }
            if (this.jkr.getVisibility() == 0) {
                this.jkr.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jko.getVisibility() == 0) {
            this.jko.setVisibility(8);
        }
        if (this.jkr.getVisibility() == 8) {
            this.jkr.setVisibility(0);
        }
    }

    protected void cEI() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.cpN);
        this.jJh.bnG().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cEJ() {
        if (this.jFe != null) {
            this.jFe.Am(this.jJk);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cEK() {
        if (this.jFe != null) {
            this.jFe.rr(this.jER);
        }
    }

    protected void cEL() {
        if (this.jFf != null) {
            this.jFf.cEL();
        }
    }

    protected void cEM() {
        if (this.jIC != null) {
            this.jIC.setText(at.dX(this.mMemberNum));
        }
        if (this.jID != null) {
            this.jID.setText(at.dX(this.jJi));
        }
        if (this.jJc != null && this.jJc.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jJq) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eSJ.getString(R.string.forum);
        if (this.bIw != null) {
            this.bIw.setText(str);
        }
        if (this.iZb != null) {
            this.iZb.setText(str);
        }
        cEV();
        this.jkh = cEU();
        if (this.jkh) {
            this.jDg.setVisibility(8);
            this.hrQ.setVisibility(0);
        } else {
            this.hrQ.setVisibility(8);
            this.jDg.setVisibility(0);
            this.jIN.setOnClickListener(null);
        }
        cER();
        zb(TbadkCoreApplication.getInst().getSkinType());
        cEN();
    }

    private void cEN() {
        boolean cEP = cEP();
        boolean cEQ = cEQ();
        if (!TextUtils.isEmpty(this.mForumName)) {
            com.baidu.tieba.frs.c.e Ku = d.cJe().Ku(this.mForumName);
            if (Ku == null) {
                Ku = new com.baidu.tieba.frs.c.e(this.jki, cEP);
            } else {
                Ku.rn(this.jki);
                Ku.ro(cEP);
            }
            d.cJe().a(this.mForumName, Ku);
        }
        ad(cEP, cEQ);
        ae(cEP, cEQ);
    }

    private void ad(boolean z, boolean z2) {
        if (this.jcX.cBg() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jkj.getLayoutParams();
            if (!z && !z2) {
                this.jkj.setVisibility(0);
                this.jkl.setVisibility(8);
                this.jkm.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds50);
            } else {
                this.jkj.setVisibility(0);
                this.jkl.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds55);
            }
            this.jcX.cBg().ag(z, z2);
        }
    }

    private void ae(boolean z, boolean z2) {
        int dimens;
        if (this.jIM != null && this.jIM.getLayoutParams() != null) {
            if (this.jku.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jIL.getLayoutParams()).topMargin = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eSJ.getPageActivity());
                ((RelativeLayout.LayoutParams) this.jku.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.jkh) {
                dimens -= l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds80);
            } else if (this.jkh) {
                int dimens3 = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds782);
                int af = af(z, z2);
                int i = dimens3 + af;
                ((RelativeLayout.LayoutParams) this.jIN.getLayoutParams()).bottomMargin = af;
                ((RelativeLayout.LayoutParams) this.hrQ.getLayoutParams()).bottomMargin = af;
                if (af != 0) {
                    ((RelativeLayout.LayoutParams) this.jIL.getLayoutParams()).topMargin = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jIL.getLayoutParams()).topMargin = l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds493);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jIM.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jIM.setLayoutParams(layoutParams);
            }
        }
    }

    private int af(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jAR.serviceAreaData == null || this.jAR.serviceAreaData.dataList == null || this.jAR.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.jkv != null) {
            i += Math.min(this.jkv.size(), 2) * l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jIP.getVisibility() == 0) {
            i += l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jIP.getVisibility() == 0) {
            return i + l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cEO() {
        if (this.jcX == null || this.jcX.cBg() == null) {
            return null;
        }
        View cKs = this.jcX.cBg().cKs();
        if (cKs instanceof LinearGradientView) {
            return (LinearGradientView) cKs;
        }
        return null;
    }

    private boolean cEP() {
        return this.jIR != null && this.jIR.getVisibility() == 0;
    }

    private boolean cEQ() {
        return this.jIO != null && this.jIO.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cER() {
        if (this.jcX != null && this.jAR != null) {
            List<n> showTopThreadList = this.jAR.getShowTopThreadList();
            this.jki = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jAR.getBusinessPromot());
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
    public boolean cES() {
        return this.jER;
    }

    @Override // com.baidu.tieba.frs.view.b
    public SignActivityInfo cET() {
        return this.mSignActivityInfo;
    }

    private void a(List<n> list, i iVar) {
        if (this.jIR != null) {
            this.jkv = list;
            if (iVar != null) {
                this.jIQ = new g(this.eSJ.getPageActivity());
                this.jIP.setVisibility(0);
                this.jIP.addView(this.jIQ.getView());
                this.jIQ.a(this.jAR != null ? this.jAR.getForum() : null, iVar);
            } else {
                this.jIP.setVisibility(8);
            }
            if (this.jcX != null && this.jcX.cBp()) {
                this.jIR.setVisibility(0);
                this.jIR.setFragmentUniqueId(this.jcX.getUniqueId());
                ForumData forum = this.jAR != null ? this.jAR.getForum() : null;
                this.jIR.setForum(this.mForumId, this.mForumName, forum, this.jAR != null ? this.jAR.getUserData() : null, this.jcX.getFrom());
                if (forum != null && !at.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !x.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                ForumRuleStatus forumRuleStatus = this.jAR.forumRule;
                this.jkx = -1;
                if (this.jAR.getForum().getIsShowRule() && forumRuleStatus != null && (this.jAR.getUserData().getIs_manager() == 1 || forumRuleStatus.has_forum_rule.intValue() == 1)) {
                    p pVar = new p(forum, forumRuleStatus);
                    if (list.size() > 1 && (list.get(0) instanceof k) && ((k) list.get(0)) != null && ((k) list.get(0)).dKo() == 1) {
                        list.add(1, pVar);
                        this.jkx = 1;
                    } else {
                        list.add(0, pVar);
                        this.jkx = 0;
                    }
                }
                this.jIR.setDatas(list, iVar);
                if (this.jkg == null) {
                    this.jkg = new aw() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.aw
                        public void ao(bz bzVar) {
                            com.baidu.tieba.frs.d.k.a(b.this.jcX, b.this.jAR, bzVar);
                        }
                    };
                }
                this.jIR.setStatListener(this.jkg);
                return;
            }
            this.jIR.setVisibility(8);
        }
    }

    private boolean cEU() {
        final z zVar;
        if (this.jAR == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jAR;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dKv())) {
            zVar = new z();
            zVar.setLinkUrl("");
            zVar.setImageUrl(frsViewData.getStar().dKv());
        } else {
            zVar = (frsViewData.getActivityHeadData() == null || x.getCount(frsViewData.getActivityHeadData().blz()) < 1) ? null : frsViewData.getActivityHeadData().blz().get(0);
        }
        if (zVar != null) {
            if (this.jIN != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().blA())) {
                    aq aqVar = new aq("c13326");
                    aqVar.dW("fid", frsViewData.getForum().getId());
                    aqVar.dW("obj_id", frsViewData.getActivityHeadData().blA());
                    TiebaStatic.log(aqVar);
                    aq aqVar2 = new aq("common_exp");
                    aqVar2.dW("page_type", PageStayDurationConstants.PageName.FRS).an("obj_isad", 1).an("obj_floor", 1).dW("fid", frsViewData.getForum().getId()).dW("obj_id", frsViewData.getActivityHeadData().blA()).an("obj_adlocate", 1).dW("first_dir", frsViewData.getForum().getFirst_class()).dW("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        aqVar.dW("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().foc);
                    }
                    com.baidu.tieba.s.c.dKg().a(this.jcX.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().blA(), "", (BaijiahaoData) null), aqVar2);
                }
                this.jIN.startLoad(zVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(zVar.getLinkUrl())) {
                    this.jIN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eSJ != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().blA())) {
                                    String id = frsViewData.getForum().getId();
                                    String blA = frsViewData.getActivityHeadData().blA();
                                    aq aqVar3 = new aq("c13330");
                                    aqVar3.dW("fid", id);
                                    aqVar3.dW("obj_id", blA);
                                    TiebaStatic.log(aqVar3);
                                    aq aqVar4 = new aq("common_click");
                                    aqVar4.dW("page_type", PageStayDurationConstants.PageName.FRS).an("obj_isad", 1).dW("fid", id).dW("obj_id", blA).an("obj_adlocate", 1).an("obj_floor", 1).dW("first_dir", frsViewData.getForum().getFirst_class()).dW("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        aqVar3.dW("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().foc);
                                    }
                                    com.baidu.tieba.s.c.dKg().b(b.this.jcX.getUniqueId(), aqVar4);
                                }
                                be.bsB().a(b.this.eSJ, new String[]{zVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void zb(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jAR != null && (forum = this.jAR.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jkh) {
                LinearGradientView cEO = cEO();
                if (this.jDg != null && cEO != null) {
                    this.jDg.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jIN != null) {
                    this.jIN.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jIO != null) {
                this.jIO.setThemeFontColor(com.baidu.tieba.lego.card.c.b.rt(themeElement.common_color));
            }
            if (this.jIR != null) {
                this.jIR.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.c.b.rt(themeElement.common_color));
            }
        }
    }

    protected void cEV() {
        this.jJa.startLoad(this.cpN, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void l(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jJv);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eSJ.getPageActivity());
                this.mPopup.setContentView(this.jIV);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jIW = (TextView) this.jIV.findViewById(R.id.cur_experience);
            this.jIX = (TextView) this.jIV.findViewById(R.id.levelup_experience);
            ao.setBackgroundResource(this.jIV.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ao.setViewTextColor((TextView) this.jIV.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ao.setViewTextColor(this.jIW, R.color.common_color_10047, 1);
            ao.setViewTextColor(this.jIX, R.color.CAM_X0111, 1);
            a(this.jIW, this.jIX);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eSJ.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eSJ.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jJv, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eSJ.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.CAM_X0105, 1);
            ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
            ao.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            ao.setViewTextColor(textView3, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
            aVar.br(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jJg) && !TextUtils.isEmpty(this.jJg.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jJg);
            } else {
                textView3.setVisibility(8);
            }
            aVar.nv(R.color.CAM_X0305);
            d(aVar);
            e(aVar);
            aVar.b(this.eSJ);
            aVar.bqe();
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
                if (b.this.eSJ != null && b.this.eSJ.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eSJ.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cEW() {
        View contentView;
        if (this.jIZ == null) {
            this.jIZ = new PopupWindow(this.eSJ.getPageActivity());
            View inflate = LayoutInflater.from(this.eSJ.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jIZ.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eSJ != null && b.this.eSJ.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jIZ, b.this.eSJ.getPageActivity());
                        b.this.jcX.jao = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eSJ.getPageActivity(), b.this.eSJ.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jIZ.setWidth(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jIZ.setHeight(this.eSJ.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jIZ.setBackgroundDrawable(new BitmapDrawable());
            this.jIZ.setOutsideTouchable(true);
            this.jIZ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jIZ);
                        b.this.jcX.jao = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jIZ.getContentView();
        }
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ao.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jIY.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jIZ, this.mParent, 0, (iArr[0] - (this.jIZ.getWidth() / 2)) + (this.jIY.getWidth() / 2), iArr[1] + this.jIY.getWidth());
        this.jIZ.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cEX() {
        String string;
        String str;
        View view;
        if (this.jkx != -1 && this.jAR != null && this.jAR.forumRule != null && this.jAR.getUserData() != null && this.jIR != null) {
            if (this.jAR.getUserData().getIs_manager() == 1) {
                if (this.jAR.forumRule.has_forum_rule.intValue() != 1 && this.jAR.forumRule.audit_status.intValue() == 0) {
                    string = this.eSJ.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.eSJ.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            if (this.jIR.getmTopViews() != null && this.jIR.getmTopViews().size() > 0 && (this.jIR.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.jIR.getmTopViews().get(0);
                if (this.jkx < adapterLinearLayout.getChildCount()) {
                    view = adapterLinearLayout.getChildAt(this.jkx);
                    if (this.jkw != null && view != null) {
                        this.jkw = new e(this.eSJ, view);
                        this.jkw.ej(R.drawable.bg_tip_blue_up_left);
                        this.jkw.ei(16);
                        this.jkw.pz(true);
                        this.jkw.xb(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                        this.jkw.setYOffset(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                        this.jkw.setUseDirectOffset(true);
                        this.jkw.ek(4000);
                        if (!this.jkw.isShowing() && !this.jcX.cBO()) {
                            this.jkw.aJ(string, str);
                            return;
                        }
                        return;
                    }
                }
            }
            view = null;
            if (this.jkw != null) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cEY() {
        if (this.jkw != null) {
            this.jkw.RS();
            this.jkx = -1;
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cEZ() {
        this.jIR.AA(this.jkx);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jJp = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jIE != null && this.iWW != null && this.jIK != null && cashBitmap.getWidth() > 0) {
            if (this.jJp) {
                this.jIE.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.fyf;
                } else {
                    i = this.fyf + 1;
                }
                FrsViewData cBN = this.jcX.cBN();
                if (cBN != null && cBN.getForum() != null) {
                    cBN.getForum().setUser_level(i);
                }
                this.jIK.setText(this.eSJ.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jIE.setText(this.jJe);
                this.jIK.setText(this.eSJ.getResources().getString(R.string.lv_num, Integer.valueOf(this.fyf)));
            }
            this.iWW.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ya(this.fyf)));
            if (this.jJp) {
                if (f >= 1.0f) {
                    b(this.iWW, this.jJr, f);
                } else {
                    c(this.iWW, this.jJr, f);
                }
            } else {
                b(this.iWW, this.jJr, f);
            }
            this.jJr = f;
        }
    }

    private int[] ya(int i) {
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
    protected void cFa() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFb() {
        if (this.mMemberType != 0) {
            ao.setImageResource(this.jIY, R.drawable.icon_sml_speed_orange);
        } else {
            ao.setImageResource(this.jIY, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jIZ != null && this.jIZ.isShowing()) {
            this.jIZ.dismiss();
        }
        cEY();
        if (this.jIQ != null) {
            this.jIQ.onDestroy();
        }
        if (this.gLs != null) {
            this.gLs.cancel();
            this.gLs = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.frs.entelechy.b$7] */
    private void d(final String str, long j, long j2) {
        this.jER = true;
        this.gLs = new CountDownTimer(j, j2) { // from class: com.baidu.tieba.frs.entelechy.b.7
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (b.this.jIU != null) {
                    b.this.jIU.setVisibility(0);
                    b.this.jIU.setText(str + (j3 / 1000) + "s");
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                b.this.jER = false;
                if (b.this.jIU != null) {
                    b.this.jIU.setVisibility(8);
                }
                if (b.this.jFe != null && !b.this.cKe()) {
                    b.this.jFe.rr(b.this.jER);
                }
            }
        }.start();
        if (this.jFe != null && !cKe()) {
            this.jFe.rr(this.jER);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFc() {
        if (this.mSignActivityInfo != null) {
            if (this.gLs != null) {
                this.gLs.cancel();
                this.gLs.onFinish();
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            this.jkz = ((long) (this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue())) - currentTimeMillis < 0;
            this.ccY = ((long) this.mSignActivityInfo.activity_time.intValue()) - currentTimeMillis <= 0;
            this.jkA = ((long) (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue())) - currentTimeMillis <= 0;
            if (this.jkz) {
                this.jIU.setVisibility(8);
                return;
            }
            if (this.ccY && !this.jkz) {
                d(this.mSignActivityInfo.activity_msg, ((this.mSignActivityInfo.activity_time.intValue() + this.mSignActivityInfo.activity_duration.intValue()) - currentTimeMillis) * 1000, this.jky);
            }
            if (!this.ccY && this.jkA) {
                this.jIU.setVisibility(0);
                this.jIU.setText(this.mSignActivityInfo.countdown_msg);
                G(this.mSignActivityInfo.activity_msg, this.mSignActivityInfo.activity_time.intValue() - currentTimeMillis);
            }
            if (!this.jkA) {
                G(this.mSignActivityInfo.countdown_msg, (this.mSignActivityInfo.activity_time.intValue() - this.mSignActivityInfo.countdown_time.intValue()) - currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(final String str, long j) {
        this.jER = false;
        this.eAI = Executors.newScheduledThreadPool(1);
        this.eAI.schedule(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.b.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.jIU != null) {
                            if (b.this.jIU.getVisibility() == 8) {
                                b.this.jIU.setVisibility(0);
                                b.this.jIU.setText(str);
                                if (b.this.mSignActivityInfo != null) {
                                    b.this.G(b.this.mSignActivityInfo.activity_msg, b.this.mSignActivityInfo.countdown_time.intValue());
                                }
                            } else if (b.this.jIU.getVisibility() == 0) {
                                b.this.cFc();
                            }
                        }
                    }
                });
            }
        }, j, TimeUnit.SECONDS);
    }
}
