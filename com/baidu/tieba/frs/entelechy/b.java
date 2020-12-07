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
    private View hkz;
    private View jcA;
    private final View jcB;
    private final HeadImageView jcC;
    private final TextView jcD;
    private final View jcE;
    private final ImageView jcF;
    private final TextView jcG;
    private HotRankEntryView jcH;
    private List<q> jcI;
    private e jcJ;
    private TextView jcq;
    private TextView jcr;
    private az jct;
    private boolean jcu;
    private LinearLayout jcw;
    private View jcx;
    private View jcy;
    private View jcz;
    private RelativeLayout mContainer;
    private boolean jcv = false;
    private int jcK = -1;
    private ArrayList<TbImageView> jcs = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.iVq = frsFragment;
        this.eNx = frsFragment.getPageContext();
        this.jAE = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jAF = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jAG = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cFA();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jAR = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jvp = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jAS = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jAS.setPageId(this.iVq.getUniqueId());
        this.jAS.setDefaultBgResource(R.color.transparent);
        this.jAS.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jAS.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.hkz = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.hkz).pA(R.string.J_X11).py(R.array.Mask_X005);
        this.jcw = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.jcx = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.jcy = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.jcz = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jAT = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jAU = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jAW = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.jcA = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jAX = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jAY = this.mParent.findViewById(R.id.service_topview_space);
        this.jBc = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.jcq = (TextView) this.mParent.findViewById(R.id.member_image);
        this.jcr = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jAJ = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jAP = (TextView) this.mParent.findViewById(R.id.level);
        this.jwO = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jwO.setText(frsFragment.getResources().getString(R.string.attention));
        this.jwO.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jwO.setConfig(bVar);
        this.jwV = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jwV.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.ri(R.color.CAM_X0105);
        bVar2.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jwV.setConfig(bVar2);
        this.jwV.setText(frsFragment.getResources().getString(R.string.sign));
        this.iPp = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.iPq = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jAH = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jAI = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.iRu = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jAL = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jBe = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jBe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jBe.setPageId(this.iVq.getUniqueId());
        this.jBe.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jBe.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jBe.setShowOval(true);
        this.jBe.setPlaceHolder(1);
        this.jAO = this.mParent.findViewById(R.id.level_container);
        this.jAN = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jAM = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jAQ = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.jcB = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.jcD = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.jcC = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.jcC.setIsRound(true);
        this.jcC.setDrawBorder(true);
        this.jcC.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jcC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jcE = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.jcF = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.jcG = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.jcF, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jAZ = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jAK = LayoutInflater.from(this.iVq.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.jcH = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jAK.setVisibility(8);
        this.jBh = new com.baidu.tieba.frs.f.b(this.eNx);
    }

    protected View cFA() {
        return LayoutInflater.from(this.iVq.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void B(View.OnClickListener onClickListener) {
        this.jBe.setOnClickListener(onClickListener);
        this.iRu.setOnClickListener(onClickListener);
        this.jwV.setOnClickListener(onClickListener);
        this.jwO.setOnClickListener(onClickListener);
        this.jAO.setOnClickListener(onClickListener);
        if (this.jcH != null) {
            this.jcH.setOnClickListener(onClickListener);
        }
        if (this.jcB != null) {
            this.jcB.setOnClickListener(onClickListener);
        }
        if (this.jcE != null) {
            this.jcE.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFB() {
        this.jAL.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eNx.getLayoutMode().setNightMode(i == 1);
        this.eNx.getLayoutMode().onModeChanged(this.mParent);
        this.eNx.getLayoutMode().onModeChanged(this.jAZ);
        this.eNx.getLayoutMode().onModeChanged(this.jAK);
        ap.setBackgroundResource(this.iPp, R.drawable.frs_exp_progress);
        if (d.bkA()) {
            ap.setBackgroundResource(this.jcx, R.drawable.bg_frs_header_round_corner_ab);
            ap.setBackgroundColor(this.jcy, R.color.CAM_X0205);
            ap.setBackgroundColor(this.jcz, R.color.CAM_X0205);
            ap.setBackgroundColor(this.jAW, R.color.CAM_X0205);
        } else {
            ap.setBackgroundResource(this.jcx, R.drawable.bg_frs_header_round_corner);
            ap.setBackgroundColor(this.jcy, R.color.CAM_X0204);
            ap.setBackgroundColor(this.jcz, R.color.CAM_X0204);
            ap.setBackgroundColor(this.jAW, R.color.CAM_X0204);
        }
        ap.setBackgroundColor(this.jAX, R.color.CAM_X0624);
        ap.setBackgroundColor(this.jcA, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iPq, R.color.CAM_X0101);
        ap.setBackgroundColor(this.jAQ, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ap.setViewTextColor(this.iRu, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAP, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAJ, R.color.CAM_X0101);
        ap.setViewTextColor(this.jcq, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAH, R.color.CAM_X0101);
        ap.setViewTextColor(this.jcr, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAI, R.color.CAM_X0101);
        ap.setViewTextColor(this.jcD, R.color.CAM_X0101);
        ap.setViewTextColor(this.jcG, R.color.CAM_X0101);
        ap.setViewTextColor(this.jAI, R.color.CAM_X0101);
        if (this.jBe != null) {
            this.jBe.setBorderWidth(l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds1));
            this.jBe.setBorderColor(ap.getColor(R.color.CAM_X0603));
            this.jBe.setStrokeColorResId(R.color.CAM_X0201);
            this.jBe.setPlaceHolder(1);
            this.jBe.invalidate();
        }
        if (this.jcC != null) {
            this.jcC.invalidate();
        }
        if (this.jBf != null) {
            this.jBf.onChangeSkin(i);
        }
        if (this.jvp != null) {
            this.jvp.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.jcs.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cFT();
        Ci(this.jBs ? 1 : 0);
        cFF();
        Av(i);
        ac(cFJ(), cFK());
        if (this.jAT != null) {
            this.jAT.onChangeSkinType(i);
        }
        if (this.jAW != null) {
            this.jAW.onChangeSkinType(i);
        }
        if (this.jAV != null) {
            this.jAV.onChangeSkinType(i);
        }
        if (this.jcH != null) {
            this.jcH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cb(boolean z) {
        super.cb(z);
        if (this.jAV != null) {
            this.jAV.cb(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jBm = forumData.getPost_num();
            this.jBj = forumData.getTag_color();
            this.cny = forumData.getImage_url();
            this.jBi = forumData.getLevelName();
            this.fth = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jBn = forumData.getSignData().count_sign_num;
                this.jBo = forumData.getSignData().miss_sign_num;
            }
            this.jBp = forumData.getCurScore();
            this.jwY = forumData.getLevelupScore();
            this.jBg = forumData.getBadgeData();
            this.jBk = forumData.getAccelerateContent();
            this.jBu = forumData.isBrandForum;
            this.jta = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jta != null && this.jta.getHotUserRankData() != null && this.jta.getHotUserRankData().hot_user != null && this.jta.getHotUserRankData().hot_user.size() >= 3) {
                this.jAT.setHasHotRankList(true);
            } else {
                this.jAT.setHasHotRankList(false);
            }
            if ((this.jta != null && this.jta.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bKl()) || this.jAT.cJB()) {
                this.jAT.setVisibility(0);
                this.jcy.setVisibility(0);
                this.jAT.setData(this.jta.serviceAreaData, this.jta);
            } else {
                this.jAT.setVisibility(8);
                this.jcy.setVisibility(8);
            }
            this.jBl = new by();
            cFC();
            cFG();
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
                this.jcD.setText(str);
                this.jcC.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.jcB.setVisibility(0);
            } else {
                this.jcB.setVisibility(8);
            }
            if (this.jcE.getVisibility() == 0) {
                this.jcE.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jcB.getVisibility() == 0) {
            this.jcB.setVisibility(8);
        }
        if (this.jcE.getVisibility() == 8) {
            this.jcE.setVisibility(0);
        }
    }

    protected void cFC() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.cny);
        this.jBl.boY().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cFD() {
        if (this.jxl != null) {
            this.jxl.BG(this.jBo);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cFE() {
        if (this.jxl != null) {
            this.jxl.cFE();
        }
    }

    protected void cFF() {
        if (this.jxm != null) {
            this.jxm.cFF();
        }
    }

    protected void cFG() {
        if (this.jAH != null) {
            this.jAH.setText(au.dX(this.mMemberNum));
        }
        if (this.jAI != null) {
            this.jAI.setText(au.dX(this.jBm));
        }
        if (this.jBg != null && this.jBg.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jBu) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eNx.getString(R.string.forum);
        if (this.bIt != null) {
            this.bIt.setText(str);
        }
        if (this.iRu != null) {
            this.iRu.setText(str);
        }
        cFN();
        this.jcu = cFM();
        if (this.jcu) {
            this.jvp.setVisibility(8);
            this.hkz.setVisibility(0);
        } else {
            this.hkz.setVisibility(8);
            this.jvp.setVisibility(0);
            this.jAS.setOnClickListener(null);
        }
        cFL();
        Av(TbadkCoreApplication.getInst().getSkinType());
        cFH();
    }

    private void cFH() {
        boolean cFJ = cFJ();
        boolean cFK = cFK();
        if (!TextUtils.isEmpty(this.mForumName)) {
            com.baidu.tieba.frs.e.e LF = com.baidu.tieba.frs.e.d.cJT().LF(this.mForumName);
            if (LF == null) {
                LF = new com.baidu.tieba.frs.e.e(this.jcv, cFJ);
            } else {
                LF.qT(this.jcv);
                LF.qU(cFJ);
            }
            com.baidu.tieba.frs.e.d.cJT().a(this.mForumName, LF);
        }
        ab(cFJ, cFK);
        ac(cFJ, cFK);
    }

    private void ab(boolean z, boolean z2) {
        if (this.iVq.cCc() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcw.getLayoutParams();
            if (!z && !z2) {
                this.jcw.setVisibility(0);
                this.jcy.setVisibility(8);
                this.jcz.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds50);
            } else {
                this.jcw.setVisibility(0);
                this.jcy.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds55);
            }
            this.iVq.cCc().ae(z, z2);
        }
    }

    private void ac(boolean z, boolean z2) {
        int dimens;
        if (this.jAR != null && this.jAR.getLayoutParams() != null) {
            if (this.jcH.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jAQ.getLayoutParams()).topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eNx.getPageActivity());
                ((RelativeLayout.LayoutParams) this.jcH.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.jcu) {
                dimens -= l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds80);
            } else if (this.jcu) {
                int dimens3 = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds782);
                int ad = ad(z, z2);
                int i = dimens3 + ad;
                ((RelativeLayout.LayoutParams) this.jAS.getLayoutParams()).bottomMargin = ad;
                ((RelativeLayout.LayoutParams) this.hkz.getLayoutParams()).bottomMargin = ad;
                if (ad != 0) {
                    ((RelativeLayout.LayoutParams) this.jAQ.getLayoutParams()).topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jAQ.getLayoutParams()).topMargin = l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds493);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jAR.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jAR.setLayoutParams(layoutParams);
            }
        }
    }

    private int ad(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jta.serviceAreaData == null || this.jta.serviceAreaData.dataList == null || this.jta.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.jcI != null) {
            i += Math.min(this.jcI.size(), 2) * l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jAU.getVisibility() == 0) {
            i += l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jAU.getVisibility() == 0) {
            return i + l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cFI() {
        if (this.iVq == null || this.iVq.cCc() == null) {
            return null;
        }
        View cLg = this.iVq.cCc().cLg();
        if (cLg instanceof LinearGradientView) {
            return (LinearGradientView) cLg;
        }
        return null;
    }

    private boolean cFJ() {
        return this.jAW != null && this.jAW.getVisibility() == 0;
    }

    private boolean cFK() {
        return this.jAT != null && this.jAT.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFL() {
        if (this.iVq != null && this.jta != null) {
            List<q> showTopThreadList = this.jta.getShowTopThreadList();
            this.jcv = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jta.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.jAW != null) {
            this.jcI = list;
            if (iVar != null) {
                this.jAV = new g(this.eNx.getPageActivity());
                this.jAU.setVisibility(0);
                this.jAU.addView(this.jAV.getView());
                this.jAV.a(this.jta != null ? this.jta.getForum() : null, iVar);
            } else {
                this.jAU.setVisibility(8);
            }
            if (this.iVq != null && this.iVq.cCl()) {
                this.jAW.setVisibility(0);
                this.jAW.setFragmentUniqueId(this.iVq.getUniqueId());
                ForumData forum = this.jta != null ? this.jta.getForum() : null;
                this.jAW.setForum(this.mForumId, this.mForumName, forum, this.jta != null ? this.jta.getUserData() : null, this.iVq.getFrom());
                if (forum != null && !au.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !y.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                ForumRuleStatus forumRuleStatus = this.jta.forumRule;
                this.jcK = -1;
                if (this.jta.getForum().getIsShowRule() && forumRuleStatus != null && (this.jta.getUserData().getIs_manager() == 1 || forumRuleStatus.has_forum_rule.intValue() == 1)) {
                    p pVar = new p(forum, forumRuleStatus);
                    if (list.size() > 1 && (list.get(0) instanceof k) && ((k) list.get(0)) != null && ((k) list.get(0)).dOm() == 1) {
                        list.add(1, pVar);
                        this.jcK = 1;
                    } else {
                        list.add(0, pVar);
                        this.jcK = 0;
                    }
                }
                this.jAW.setDatas(list, iVar);
                if (this.jct == null) {
                    this.jct = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void ao(by byVar) {
                            com.baidu.tieba.frs.f.k.a(b.this.iVq, b.this.jta, byVar);
                        }
                    };
                }
                this.jAW.setStatListener(this.jct);
                return;
            }
            this.jAW.setVisibility(8);
        }
    }

    private boolean cFM() {
        final z zVar;
        if (this.jta == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jta;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dOt())) {
            zVar = new z();
            zVar.setLinkUrl("");
            zVar.setImageUrl(frsViewData.getStar().dOt());
        } else {
            zVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().bmT()) < 1) ? null : frsViewData.getActivityHeadData().bmT().get(0);
        }
        if (zVar != null) {
            if (this.jAS != null) {
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
                    com.baidu.tieba.t.c.dOe().a(this.iVq.getUniqueId(), com.baidu.tieba.t.a.a("", frsViewData.getActivityHeadData().bmU(), "", (BaijiahaoData) null), arVar2);
                }
                this.jAS.startLoad(zVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(zVar.getLinkUrl())) {
                    this.jAS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
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
                                    com.baidu.tieba.t.c.dOe().b(b.this.iVq.getUniqueId(), arVar4);
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
        if (this.jta != null && (forum = this.jta.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jcu) {
                LinearGradientView cFI = cFI();
                if (this.jvp != null && cFI != null) {
                    this.jvp.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jAS != null) {
                    this.jAS.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jAT != null) {
                this.jAT.setThemeFontColor(com.baidu.tieba.lego.card.d.b.sI(themeElement.common_color));
            }
            if (this.jAW != null) {
                this.jAW.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.sI(themeElement.common_color));
            }
        }
    }

    protected void cFN() {
        this.jBe.startLoad(this.cny, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void m(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jBz);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eNx.getPageActivity());
                this.mPopup.setContentView(this.jAZ);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jBa = (TextView) this.jAZ.findViewById(R.id.cur_experience);
            this.jBb = (TextView) this.jAZ.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jAZ.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jAZ.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ap.setViewTextColor(this.jBa, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jBb, R.color.CAM_X0111, 1);
            a(this.jBa, this.jBb);
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
            this.mHandler.postDelayed(this.jBz, 2000L);
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
            if (!TextUtils.isEmpty(this.jBk) && !TextUtils.isEmpty(this.jBk.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jBk);
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
    public void cFO() {
        View contentView;
        if (this.jBd == null) {
            this.jBd = new PopupWindow(this.eNx.getPageActivity());
            View inflate = LayoutInflater.from(this.eNx.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jBd.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eNx != null && b.this.eNx.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jBd, b.this.eNx.getPageActivity());
                        b.this.iVq.iSI = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eNx.getPageActivity(), b.this.eNx.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jBd.setWidth(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jBd.setHeight(this.eNx.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jBd.setBackgroundDrawable(new BitmapDrawable());
            this.jBd.setOutsideTouchable(true);
            this.jBd.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jBd);
                        b.this.iVq.iSI = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jBd.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jBc.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jBd, this.mParent, 0, (iArr[0] - (this.jBd.getWidth() / 2)) + (this.jBc.getWidth() / 2), iArr[1] + this.jBc.getWidth());
        this.jBd.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFP() {
        String string;
        String str;
        View view;
        if (this.jcK != -1 && this.jta != null && this.jta.forumRule != null && this.jta.getUserData() != null && this.jAW != null) {
            if (this.jta.getUserData().getIs_manager() == 1) {
                if (this.jta.forumRule.has_forum_rule.intValue() != 1 && this.jta.forumRule.audit_status.intValue() == 0) {
                    string = this.eNx.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.eNx.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            if (this.jAW.getmTopViews() != null && this.jAW.getmTopViews().size() > 0 && (this.jAW.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.jAW.getmTopViews().get(0);
                if (this.jcK < adapterLinearLayout.getChildCount()) {
                    view = adapterLinearLayout.getChildAt(this.jcK);
                    if (this.jcJ != null && view != null) {
                        this.jcJ = new e(this.eNx, view);
                        this.jcJ.fO(R.drawable.bg_tip_blue_up_left);
                        this.jcJ.fN(16);
                        this.jcJ.pf(true);
                        this.jcJ.yt(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                        this.jcJ.setYOffset(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                        this.jcJ.setUseDirectOffset(true);
                        this.jcJ.fP(4000);
                        if (!this.jcJ.isShowing() && !this.iVq.cCK()) {
                            this.jcJ.aP(string, str);
                            return;
                        }
                        return;
                    }
                }
            }
            view = null;
            if (this.jcJ != null) {
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFQ() {
        if (this.jcJ != null) {
            this.jcJ.UG();
            this.jcK = -1;
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFR() {
        this.jAW.BU(this.jcK);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jBt = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jAJ != null && this.iPp != null && this.jAP != null && cashBitmap.getWidth() > 0) {
            if (this.jBt) {
                this.jAJ.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.fth;
                } else {
                    i = this.fth + 1;
                }
                FrsViewData cCJ = this.iVq.cCJ();
                if (cCJ != null && cCJ.getForum() != null) {
                    cCJ.getForum().setUser_level(i);
                }
                this.jAP.setText(this.eNx.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jAJ.setText(this.jBi);
                this.jAP.setText(this.eNx.getResources().getString(R.string.lv_num, Integer.valueOf(this.fth)));
            }
            this.iPp.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, zt(this.fth)));
            if (this.jBt) {
                if (f >= 1.0f) {
                    b(this.iPp, this.jBv, f);
                } else {
                    c(this.iPp, this.jBv, f);
                }
            } else {
                b(this.iPp, this.jBv, f);
            }
            this.jBv = f;
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
    protected void cFS() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cFT() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jBc, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jBc, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jBd != null && this.jBd.isShowing()) {
            this.jBd.dismiss();
        }
        cFQ();
        if (this.jAV != null) {
            this.jAV.onDestroy();
        }
    }
}
