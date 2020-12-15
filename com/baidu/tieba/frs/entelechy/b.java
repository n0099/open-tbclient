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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.a;
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
import com.baidu.tieba.d.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.g;
import com.baidu.tieba.frs.az;
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
import tbclient.ForumRuleStatus;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String cny;
    private View hkB;
    private View jcA;
    private View jcB;
    private View jcC;
    private final View jcD;
    private final HeadImageView jcE;
    private final TextView jcF;
    private final View jcG;
    private final ImageView jcH;
    private final TextView jcI;
    private HotRankEntryView jcJ;
    private List<q> jcK;
    private e jcL;
    private TextView jcs;
    private TextView jct;
    private az jcv;
    private boolean jcw;
    private LinearLayout jcy;
    private View jcz;
    private RelativeLayout mContainer;
    private boolean jcx = false;
    private int jcM = -1;
    private ArrayList<TbImageView> jcu = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.iVs = frsFragment;
        this.eNx = frsFragment.getPageContext();
        this.jAG = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jAH = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jAI = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cFB();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jAT = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jvr = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jAU = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jAU.setPageId(this.iVs.getUniqueId());
        this.jAU.setDefaultBgResource(R.color.transparent);
        this.jAU.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jAU.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.hkB = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.hkB).pA(R.string.J_X11).py(R.array.Mask_X005);
        this.jcy = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.jcz = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.jcA = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.jcB = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jAV = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jAW = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jAY = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.jcC = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jAZ = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jBa = this.mParent.findViewById(R.id.service_topview_space);
        this.jBe = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.jcs = (TextView) this.mParent.findViewById(R.id.member_image);
        this.jct = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jAL = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jAR = (TextView) this.mParent.findViewById(R.id.level);
        this.jwQ = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jwQ.setText(frsFragment.getResources().getString(R.string.attention));
        this.jwQ.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jwQ.setConfig(bVar);
        this.jwX = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jwX.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.ri(R.color.CAM_X0105);
        bVar2.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jwX.setConfig(bVar2);
        this.jwX.setText(frsFragment.getResources().getString(R.string.sign));
        this.iPr = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.iPs = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jAJ = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jAK = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.iRw = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jAN = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jBg = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jBg.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jBg.setPageId(this.iVs.getUniqueId());
        this.jBg.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jBg.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jBg.setShowOval(true);
        this.jBg.setPlaceHolder(1);
        this.jAQ = this.mParent.findViewById(R.id.level_container);
        this.jAP = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jAO = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jAS = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.jcD = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.jcF = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.jcE = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.jcE.setIsRound(true);
        this.jcE.setDrawBorder(true);
        this.jcE.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jcE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jcG = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.jcH = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.jcI = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.jcH, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jBb = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jAM = LayoutInflater.from(this.iVs.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.jcJ = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jAM.setVisibility(8);
        this.jBj = new com.baidu.tieba.frs.f.b(this.eNx);
    }

    protected View cFB() {
        return LayoutInflater.from(this.iVs.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void B(View.OnClickListener onClickListener) {
        this.jBg.setOnClickListener(onClickListener);
        this.iRw.setOnClickListener(onClickListener);
        this.jwX.setOnClickListener(onClickListener);
        this.jwQ.setOnClickListener(onClickListener);
        this.jAQ.setOnClickListener(onClickListener);
        if (this.jcJ != null) {
            this.jcJ.setOnClickListener(onClickListener);
        }
        if (this.jcD != null) {
            this.jcD.setOnClickListener(onClickListener);
        }
        if (this.jcG != null) {
            this.jcG.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFC() {
        this.jAN.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eNx.getLayoutMode().setNightMode(i == 1);
        this.eNx.getLayoutMode().onModeChanged(this.mParent);
        this.eNx.getLayoutMode().onModeChanged(this.jBb);
        this.eNx.getLayoutMode().onModeChanged(this.jAM);
        ap.setBackgroundResource(this.iPr, R.drawable.frs_exp_progress);
        if (d.bkA()) {
            ap.setBackgroundResource(this.jcz, R.drawable.bg_frs_header_round_corner_ab);
            ap.setBackgroundColor(this.jcA, R.color.CAM_X0205);
            ap.setBackgroundColor(this.jcB, R.color.CAM_X0205);
            ap.setBackgroundColor(this.jAY, R.color.CAM_X0205);
        } else {
            ap.setBackgroundResource(this.jcz, R.drawable.bg_frs_header_round_corner);
            ap.setBackgroundColor(this.jcA, R.color.CAM_X0204);
            ap.setBackgroundColor(this.jcB, R.color.CAM_X0204);
            ap.setBackgroundColor(this.jAY, R.color.CAM_X0204);
        }
        ap.setBackgroundColor(this.jAZ, R.color.CAM_X0624);
        ap.setBackgroundColor(this.jcC, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iPs, R.color.CAM_X0101);
        ap.setBackgroundColor(this.jAS, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ap.setViewTextColor(this.iRw, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAR, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAL, R.color.CAM_X0101);
        ap.setViewTextColor(this.jcs, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAJ, R.color.CAM_X0101);
        ap.setViewTextColor(this.jct, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAK, R.color.CAM_X0101);
        ap.setViewTextColor(this.jcF, R.color.CAM_X0101);
        ap.setViewTextColor(this.jcI, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAK, R.color.CAM_X0101);
        if (this.jBg != null) {
            this.jBg.setBorderWidth(l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds1));
            this.jBg.setBorderColor(ap.getColor(R.color.CAM_X0603));
            this.jBg.setStrokeColorResId(R.color.CAM_X0201);
            this.jBg.setPlaceHolder(1);
            this.jBg.invalidate();
        }
        if (this.jcE != null) {
            this.jcE.invalidate();
        }
        if (this.jBh != null) {
            this.jBh.onChangeSkin(i);
        }
        if (this.jvr != null) {
            this.jvr.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.jcu.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cFU();
        Ci(this.jBu ? 1 : 0);
        cFG();
        Av(i);
        ac(cFK(), cFL());
        if (this.jAV != null) {
            this.jAV.onChangeSkinType(i);
        }
        if (this.jAY != null) {
            this.jAY.onChangeSkinType(i);
        }
        if (this.jAX != null) {
            this.jAX.onChangeSkinType(i);
        }
        if (this.jcJ != null) {
            this.jcJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cb(boolean z) {
        super.cb(z);
        if (this.jAX != null) {
            this.jAX.cb(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jBo = forumData.getPost_num();
            this.jBl = forumData.getTag_color();
            this.cny = forumData.getImage_url();
            this.jBk = forumData.getLevelName();
            this.fth = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jBp = forumData.getSignData().count_sign_num;
                this.jBq = forumData.getSignData().miss_sign_num;
            }
            this.jBr = forumData.getCurScore();
            this.jxa = forumData.getLevelupScore();
            this.jBi = forumData.getBadgeData();
            this.jBm = forumData.getAccelerateContent();
            this.jBw = forumData.isBrandForum;
            this.jtc = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jtc != null && this.jtc.getHotUserRankData() != null && this.jtc.getHotUserRankData().hot_user != null && this.jtc.getHotUserRankData().hot_user.size() >= 3) {
                this.jAV.setHasHotRankList(true);
            } else {
                this.jAV.setHasHotRankList(false);
            }
            if ((this.jtc != null && this.jtc.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bKl()) || this.jAV.cJC()) {
                this.jAV.setVisibility(0);
                this.jcA.setVisibility(0);
                this.jAV.setData(this.jtc.serviceAreaData, this.jtc);
            } else {
                this.jAV.setVisibility(8);
                this.jcA.setVisibility(8);
            }
            this.jBn = new by();
            cFD();
            cFH();
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
                this.jcF.setText(str);
                this.jcE.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.jcD.setVisibility(0);
            } else {
                this.jcD.setVisibility(8);
            }
            if (this.jcG.getVisibility() == 0) {
                this.jcG.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jcD.getVisibility() == 0) {
            this.jcD.setVisibility(8);
        }
        if (this.jcG.getVisibility() == 8) {
            this.jcG.setVisibility(0);
        }
    }

    protected void cFD() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.cny);
        this.jBn.boY().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cFE() {
        if (this.jxn != null) {
            this.jxn.BG(this.jBq);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cFF() {
        if (this.jxn != null) {
            this.jxn.cFF();
        }
    }

    protected void cFG() {
        if (this.jxo != null) {
            this.jxo.cFG();
        }
    }

    protected void cFH() {
        if (this.jAJ != null) {
            this.jAJ.setText(au.dX(this.mMemberNum));
        }
        if (this.jAK != null) {
            this.jAK.setText(au.dX(this.jBo));
        }
        if (this.jBi != null && this.jBi.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jBw) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eNx.getString(R.string.forum);
        if (this.bIt != null) {
            this.bIt.setText(str);
        }
        if (this.iRw != null) {
            this.iRw.setText(str);
        }
        cFO();
        this.jcw = cFN();
        if (this.jcw) {
            this.jvr.setVisibility(8);
            this.hkB.setVisibility(0);
        } else {
            this.hkB.setVisibility(8);
            this.jvr.setVisibility(0);
            this.jAU.setOnClickListener(null);
        }
        cFM();
        Av(TbadkCoreApplication.getInst().getSkinType());
        cFI();
    }

    private void cFI() {
        boolean cFK = cFK();
        boolean cFL = cFL();
        if (!TextUtils.isEmpty(this.mForumName)) {
            com.baidu.tieba.frs.e.e LF = com.baidu.tieba.frs.e.d.cJU().LF(this.mForumName);
            if (LF == null) {
                LF = new com.baidu.tieba.frs.e.e(this.jcx, cFK);
            } else {
                LF.qT(this.jcx);
                LF.qU(cFK);
            }
            com.baidu.tieba.frs.e.d.cJU().a(this.mForumName, LF);
        }
        ab(cFK, cFL);
        ac(cFK, cFL);
    }

    private void ab(boolean z, boolean z2) {
        if (this.iVs.cCd() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcy.getLayoutParams();
            if (!z && !z2) {
                this.jcy.setVisibility(0);
                this.jcA.setVisibility(8);
                this.jcB.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds50);
            } else {
                this.jcy.setVisibility(0);
                this.jcA.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds55);
            }
            this.iVs.cCd().ae(z, z2);
        }
    }

    private void ac(boolean z, boolean z2) {
        int dimens;
        if (this.jAT != null && this.jAT.getLayoutParams() != null) {
            if (this.jcJ.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jAS.getLayoutParams()).topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eNx.getPageActivity());
                ((RelativeLayout.LayoutParams) this.jcJ.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.jcw) {
                dimens -= l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds80);
            } else if (this.jcw) {
                int dimens3 = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds782);
                int ad = ad(z, z2);
                int i = dimens3 + ad;
                ((RelativeLayout.LayoutParams) this.jAU.getLayoutParams()).bottomMargin = ad;
                ((RelativeLayout.LayoutParams) this.hkB.getLayoutParams()).bottomMargin = ad;
                if (ad != 0) {
                    ((RelativeLayout.LayoutParams) this.jAS.getLayoutParams()).topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jAS.getLayoutParams()).topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds493);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jAT.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jAT.setLayoutParams(layoutParams);
            }
        }
    }

    private int ad(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jtc.serviceAreaData == null || this.jtc.serviceAreaData.dataList == null || this.jtc.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.jcK != null) {
            i += Math.min(this.jcK.size(), 2) * l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jAW.getVisibility() == 0) {
            i += l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jAW.getVisibility() == 0) {
            return i + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cFJ() {
        if (this.iVs == null || this.iVs.cCd() == null) {
            return null;
        }
        View cLh = this.iVs.cCd().cLh();
        if (cLh instanceof LinearGradientView) {
            return (LinearGradientView) cLh;
        }
        return null;
    }

    private boolean cFK() {
        return this.jAY != null && this.jAY.getVisibility() == 0;
    }

    private boolean cFL() {
        return this.jAV != null && this.jAV.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFM() {
        if (this.iVs != null && this.jtc != null) {
            List<q> showTopThreadList = this.jtc.getShowTopThreadList();
            this.jcx = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jtc.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.jAY != null) {
            this.jcK = list;
            if (iVar != null) {
                this.jAX = new g(this.eNx.getPageActivity());
                this.jAW.setVisibility(0);
                this.jAW.addView(this.jAX.getView());
                this.jAX.a(this.jtc != null ? this.jtc.getForum() : null, iVar);
            } else {
                this.jAW.setVisibility(8);
            }
            if (this.iVs != null && this.iVs.cCm()) {
                this.jAY.setVisibility(0);
                this.jAY.setFragmentUniqueId(this.iVs.getUniqueId());
                ForumData forum = this.jtc != null ? this.jtc.getForum() : null;
                this.jAY.setForum(this.mForumId, this.mForumName, forum, this.jtc != null ? this.jtc.getUserData() : null, this.iVs.getFrom());
                if (forum != null && !au.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !y.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                ForumRuleStatus forumRuleStatus = this.jtc.forumRule;
                this.jcM = -1;
                if (this.jtc.getForum().getIsShowRule() && forumRuleStatus != null && (this.jtc.getUserData().getIs_manager() == 1 || forumRuleStatus.has_forum_rule.intValue() == 1)) {
                    p pVar = new p(forum, forumRuleStatus);
                    if (list.size() > 1 && (list.get(0) instanceof k) && ((k) list.get(0)) != null && ((k) list.get(0)).dOn() == 1) {
                        list.add(1, pVar);
                        this.jcM = 1;
                    } else {
                        list.add(0, pVar);
                        this.jcM = 0;
                    }
                }
                this.jAY.setDatas(list, iVar);
                if (this.jcv == null) {
                    this.jcv = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void ao(by byVar) {
                            com.baidu.tieba.frs.f.k.a(b.this.iVs, b.this.jtc, byVar);
                        }
                    };
                }
                this.jAY.setStatListener(this.jcv);
                return;
            }
            this.jAY.setVisibility(8);
        }
    }

    private boolean cFN() {
        final z zVar;
        if (this.jtc == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jtc;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dOu())) {
            zVar = new z();
            zVar.setLinkUrl("");
            zVar.setImageUrl(frsViewData.getStar().dOu());
        } else {
            zVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().bmT()) < 1) ? null : frsViewData.getActivityHeadData().bmT().get(0);
        }
        if (zVar != null) {
            if (this.jAU != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bmU())) {
                    ar arVar = new ar("c13326");
                    arVar.dY("fid", frsViewData.getForum().getId());
                    arVar.dY("obj_id", frsViewData.getActivityHeadData().bmU());
                    TiebaStatic.log(arVar);
                    ar arVar2 = new ar("common_exp");
                    arVar2.dY("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).al("obj_floor", 1).dY("fid", frsViewData.getForum().getId()).dY("obj_id", frsViewData.getActivityHeadData().bmU()).al("obj_adlocate", 1).dY("first_dir", frsViewData.getForum().getFirst_class()).dY("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        arVar.dY("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fje);
                    }
                    com.baidu.tieba.t.c.dOf().a(this.iVs.getUniqueId(), com.baidu.tieba.t.a.a("", frsViewData.getActivityHeadData().bmU(), "", (BaijiahaoData) null), arVar2);
                }
                this.jAU.startLoad(zVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(zVar.getLinkUrl())) {
                    this.jAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eNx != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bmU())) {
                                    String id = frsViewData.getForum().getId();
                                    String bmU = frsViewData.getActivityHeadData().bmU();
                                    ar arVar3 = new ar("c13330");
                                    arVar3.dY("fid", id);
                                    arVar3.dY("obj_id", bmU);
                                    TiebaStatic.log(arVar3);
                                    ar arVar4 = new ar("common_click");
                                    arVar4.dY("page_type", PageStayDurationConstants.PageName.FRS).al("obj_isad", 1).dY("fid", id).dY("obj_id", bmU).al("obj_adlocate", 1).al("obj_floor", 1).dY("first_dir", frsViewData.getForum().getFirst_class()).dY("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        arVar3.dY("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fje);
                                    }
                                    com.baidu.tieba.t.c.dOf().b(b.this.iVs.getUniqueId(), arVar4);
                                }
                                bf.bua().a(b.this.eNx, new String[]{zVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void Av(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jtc != null && (forum = this.jtc.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jcw) {
                LinearGradientView cFJ = cFJ();
                if (this.jvr != null && cFJ != null) {
                    this.jvr.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jAU != null) {
                    this.jAU.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jAV != null) {
                this.jAV.setThemeFontColor(com.baidu.tieba.lego.card.d.b.sI(themeElement.common_color));
            }
            if (this.jAY != null) {
                this.jAY.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.sI(themeElement.common_color));
            }
        }
    }

    protected void cFO() {
        this.jBg.startLoad(this.cny, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void m(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jBB);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eNx.getPageActivity());
                this.mPopup.setContentView(this.jBb);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jBc = (TextView) this.jBb.findViewById(R.id.cur_experience);
            this.jBd = (TextView) this.jBb.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jBb.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jBb.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ap.setViewTextColor(this.jBc, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jBd, R.color.CAM_X0111, 1);
            a(this.jBc, this.jBd);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eNx.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eNx.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jBB, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eNx.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView3, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
            aVar.bi(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jBm) && !TextUtils.isEmpty(this.jBm.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jBm);
            } else {
                textView3.setVisibility(8);
            }
            aVar.oR(R.color.CAM_X0305);
            d(aVar);
            e(aVar);
            aVar.b(this.eNx);
            aVar.brv();
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
                if (b.this.eNx != null && b.this.eNx.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eNx.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFP() {
        View contentView;
        if (this.jBf == null) {
            this.jBf = new PopupWindow(this.eNx.getPageActivity());
            View inflate = LayoutInflater.from(this.eNx.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jBf.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eNx != null && b.this.eNx.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jBf, b.this.eNx.getPageActivity());
                        b.this.iVs.iSK = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eNx.getPageActivity(), b.this.eNx.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jBf.setWidth(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jBf.setHeight(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jBf.setBackgroundDrawable(new BitmapDrawable());
            this.jBf.setOutsideTouchable(true);
            this.jBf.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jBf);
                        b.this.iVs.iSK = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jBf.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jBe.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jBf, this.mParent, 0, (iArr[0] - (this.jBf.getWidth() / 2)) + (this.jBe.getWidth() / 2), iArr[1] + this.jBe.getWidth());
        this.jBf.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFQ() {
        String string;
        String str;
        View view;
        if (this.jcM != -1 && this.jtc != null && this.jtc.forumRule != null && this.jtc.getUserData() != null && this.jAY != null) {
            if (this.jtc.getUserData().getIs_manager() == 1) {
                if (this.jtc.forumRule.has_forum_rule.intValue() != 1 && this.jtc.forumRule.audit_status.intValue() == 0) {
                    string = this.eNx.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.eNx.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            if (this.jAY.getmTopViews() != null && this.jAY.getmTopViews().size() > 0 && (this.jAY.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.jAY.getmTopViews().get(0);
                if (this.jcM < adapterLinearLayout.getChildCount()) {
                    view = adapterLinearLayout.getChildAt(this.jcM);
                    if (this.jcL != null && view != null) {
                        this.jcL = new e(this.eNx, view);
                        this.jcL.fO(R.drawable.bg_tip_blue_up_left);
                        this.jcL.fN(16);
                        this.jcL.pf(true);
                        this.jcL.yt(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                        this.jcL.setYOffset(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                        this.jcL.setUseDirectOffset(true);
                        this.jcL.fP(4000);
                        if (!this.jcL.isShowing() && !this.iVs.cCL()) {
                            this.jcL.aP(string, str);
                            return;
                        }
                        return;
                    }
                }
            }
            view = null;
            if (this.jcL != null) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFR() {
        if (this.jcL != null) {
            this.jcL.UG();
            this.jcM = -1;
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFS() {
        this.jAY.BU(this.jcM);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jBv = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jAL != null && this.iPr != null && this.jAR != null && cashBitmap.getWidth() > 0) {
            if (this.jBv) {
                this.jAL.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.fth;
                } else {
                    i = this.fth + 1;
                }
                FrsViewData cCK = this.iVs.cCK();
                if (cCK != null && cCK.getForum() != null) {
                    cCK.getForum().setUser_level(i);
                }
                this.jAR.setText(this.eNx.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jAL.setText(this.jBk);
                this.jAR.setText(this.eNx.getResources().getString(R.string.lv_num, Integer.valueOf(this.fth)));
            }
            this.iPr.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, zt(this.fth)));
            if (this.jBv) {
                if (f >= 1.0f) {
                    b(this.iPr, this.jBx, f);
                } else {
                    c(this.iPr, this.jBx, f);
                }
            } else {
                b(this.iPr, this.jBx, f);
            }
            this.jBx = f;
        }
    }

    private int[] zt(int i) {
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
    protected void cFT() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFU() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jBe, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jBe, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jBf != null && this.jBf.isShowing()) {
            this.jBf.dismiss();
        }
        cFR();
        if (this.jAX != null) {
            this.jAX.onDestroy();
        }
    }
}
