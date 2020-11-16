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
import com.baidu.tbadk.core.data.bx;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad.g;
import com.baidu.tieba.frs.az;
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
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String cgQ;
    private View haQ;
    private az iRB;
    private boolean iRC;
    private LinearLayout iRE;
    private View iRF;
    private View iRG;
    private View iRH;
    private View iRI;
    private final View iRJ;
    private final HeadImageView iRK;
    private final TextView iRL;
    private final View iRM;
    private final ImageView iRN;
    private final TextView iRO;
    private HotRankEntryView iRP;
    private List<q> iRQ;
    private TextView iRy;
    private TextView iRz;
    private RelativeLayout mContainer;
    private boolean iRD = false;
    private ArrayList<TbImageView> iRA = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.iKx = frsFragment;
        this.eGu = frsFragment.getPageContext();
        this.jnc = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.jnd = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.jne = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = cBk();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.jnp = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.jhM = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.jnq = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.jnq.setPageId(this.iKx.getUniqueId());
        this.jnq.setDefaultBgResource(R.color.transparent);
        this.jnq.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jnq.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.haQ = this.mParent.findViewById(R.id.header_top_cover);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.haQ).pb(R.string.J_X11).oZ(R.array.Mask_X005);
        this.iRE = (LinearLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.iRF = this.mParent.findViewById(R.id.header_round_corner_layout);
        this.iRG = this.mParent.findViewById(R.id.service_and_top_view_layout);
        this.iRH = this.mParent.findViewById(R.id.banner_and_bottom_view_layout);
        this.jnr = (ServiceAreaView) this.mParent.findViewById(R.id.service_area_view);
        this.jns = (FrameLayout) this.mParent.findViewById(R.id.frs_ad_banner);
        this.jnu = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.iRI = this.mParent.findViewById(R.id.frs_top_divider_layout);
        this.jnv = this.mParent.findViewById(R.id.frs_top_divider_line);
        this.jnw = this.mParent.findViewById(R.id.service_topview_space);
        this.jnA = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.iRy = (TextView) this.mParent.findViewById(R.id.member_image);
        this.iRz = (TextView) this.mParent.findViewById(R.id.post_image);
        this.jnh = (TextView) this.mParent.findViewById(R.id.level_name);
        this.jnn = (TextView) this.mParent.findViewById(R.id.level);
        this.jjm = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.jjm.setText(frsFragment.getResources().getString(R.string.attention));
        this.jjm.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0901, R.color.CAM_X0105);
        this.jjm.setConfig(bVar);
        this.jjt = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.jjt.setTextSize(R.dimen.T_X08);
        com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar2.qH(R.color.CAM_X0105);
        bVar2.qB(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.a(R.drawable.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.jjt.setConfig(bVar2);
        this.jjt.setText(frsFragment.getResources().getString(R.string.sign));
        this.iEx = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.iEy = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.jnf = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.jng = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.iGC = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.jnj = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.jnC = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.jnC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jnC.setPageId(this.iKx.getUniqueId());
        this.jnC.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.jnC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jnC.setShowOval(true);
        this.jnC.setPlaceHolder(1);
        this.jnm = this.mParent.findViewById(R.id.level_container);
        this.jnl = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.jnk = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.jno = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.iRJ = this.mParent.findViewById(R.id.frs_manager_info_layout);
        this.iRL = (TextView) this.mParent.findViewById(R.id.frs_manager_name);
        this.iRK = (HeadImageView) this.mParent.findViewById(R.id.frs_manager_portrait);
        this.iRK.setIsRound(true);
        this.iRK.setDrawBorder(true);
        this.iRK.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iRK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iRM = this.mParent.findViewById(R.id.frs_manager_application_layout);
        this.iRN = (ImageView) this.mParent.findViewById(R.id.frs_manager_application_icon);
        this.iRO = (TextView) this.mParent.findViewById(R.id.frs_manager_application_desc);
        WebPManager.a(this.iRN, R.drawable.icon_mask_frs_apply14, R.color.CAM_X0101, null);
        this.jnx = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.jni = LayoutInflater.from(this.iKx.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.iRP = (HotRankEntryView) this.mParent.findViewById(R.id.frs_hot_rank_entry);
        this.jni.setVisibility(8);
        this.jnF = new com.baidu.tieba.frs.f.b(this.eGu);
    }

    protected View cBk() {
        return LayoutInflater.from(this.iKx.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void B(View.OnClickListener onClickListener) {
        this.jnC.setOnClickListener(onClickListener);
        this.iGC.setOnClickListener(onClickListener);
        this.jjt.setOnClickListener(onClickListener);
        this.jjm.setOnClickListener(onClickListener);
        this.jnm.setOnClickListener(onClickListener);
        if (this.iRP != null) {
            this.iRP.setOnClickListener(onClickListener);
        }
        if (this.iRJ != null) {
            this.iRJ.setOnClickListener(onClickListener);
        }
        if (this.iRM != null) {
            this.iRM.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBl() {
        this.jnj.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.eGu.getLayoutMode().setNightMode(i == 1);
        this.eGu.getLayoutMode().onModeChanged(this.mParent);
        this.eGu.getLayoutMode().onModeChanged(this.jnx);
        this.eGu.getLayoutMode().onModeChanged(this.jni);
        ap.setBackgroundResource(this.iEx, R.drawable.frs_exp_progress);
        if (d.bhw()) {
            ap.setBackgroundResource(this.iRF, R.drawable.bg_frs_header_round_corner_ab);
            ap.setBackgroundColor(this.iRG, R.color.CAM_X0205);
            ap.setBackgroundColor(this.iRH, R.color.CAM_X0205);
            ap.setBackgroundColor(this.jnu, R.color.CAM_X0205);
        } else {
            ap.setBackgroundResource(this.iRF, R.drawable.bg_frs_header_round_corner);
            ap.setBackgroundColor(this.iRG, R.color.CAM_X0204);
            ap.setBackgroundColor(this.iRH, R.color.CAM_X0204);
            ap.setBackgroundColor(this.jnu, R.color.CAM_X0204);
        }
        ap.setBackgroundColor(this.jnv, R.color.CAM_X0624);
        ap.setBackgroundColor(this.iRI, R.color.CAM_X0201);
        ap.setBackgroundColor(this.iEy, R.color.CAM_X0101);
        ap.setBackgroundColor(this.jno, R.color.black_alpha0);
        ap.setBackgroundColor(this.mContainer, R.color.CAM_X0204);
        ap.setViewTextColor(this.iGC, R.color.CAM_X0101);
        ap.setViewTextColor(this.jnn, R.color.CAM_X0101);
        ap.setViewTextColor(this.jnh, R.color.CAM_X0101);
        ap.setViewTextColor(this.iRy, R.color.CAM_X0101);
        ap.setViewTextColor(this.jnf, R.color.CAM_X0101);
        ap.setViewTextColor(this.iRz, R.color.CAM_X0101);
        ap.setViewTextColor(this.jng, R.color.CAM_X0101);
        ap.setViewTextColor(this.iRL, R.color.CAM_X0101);
        ap.setViewTextColor(this.iRO, R.color.CAM_X0101);
        ap.setViewTextColor(this.jng, R.color.CAM_X0101);
        if (this.jnC != null) {
            this.jnC.setBorderWidth(l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds1));
            this.jnC.setBorderColor(ap.getColor(R.color.CAM_X0603));
            this.jnC.setStrokeColorResId(R.color.CAM_X0201);
            this.jnC.setPlaceHolder(1);
            this.jnC.invalidate();
        }
        if (this.iRK != null) {
            this.iRK.invalidate();
        }
        if (this.jnD != null) {
            this.jnD.onChangeSkin(i);
        }
        if (this.jhM != null) {
            this.jhM.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.iRA.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        cBA();
        Bt(this.jnQ ? 1 : 0);
        cBp();
        zQ(i);
        ac(cBt(), cBu());
        if (this.jnr != null) {
            this.jnr.onChangeSkinType(i);
        }
        if (this.jnu != null) {
            this.jnu.onChangeSkinType(i);
        }
        if (this.jnt != null) {
            this.jnt.onChangeSkinType(i);
        }
        if (this.iRP != null) {
            this.iRP.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bS(boolean z) {
        super.bS(z);
        if (this.jnt != null) {
            this.jnt.bS(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.jnK = forumData.getPost_num();
            this.jnH = forumData.getTag_color();
            this.cgQ = forumData.getImage_url();
            this.jnG = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.jnL = forumData.getSignData().count_sign_num;
                this.jnM = forumData.getSignData().miss_sign_num;
            }
            this.jnN = forumData.getCurScore();
            this.jjw = forumData.getLevelupScore();
            this.jnE = forumData.getBadgeData();
            this.jnI = forumData.getAccelerateContent();
            this.jnS = forumData.isBrandForum;
            this.jfx = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            if (this.jfx != null && this.jfx.getHotUserRankData() != null && this.jfx.getHotUserRankData().hot_user != null && this.jfx.getHotUserRankData().hot_user.size() >= 3) {
                this.jnr.setHasHotRankList(true);
            } else {
                this.jnr.setHasHotRankList(false);
            }
            if ((this.jfx != null && this.jfx.serviceAreaData != null && !com.baidu.tbadk.youngster.b.c.bGL()) || this.jnr.cEo()) {
                this.jnr.setVisibility(0);
                this.iRG.setVisibility(0);
                this.jnr.setData(this.jfx.serviceAreaData, this.jfx);
            } else {
                this.jnr.setVisibility(8);
                this.iRG.setVisibility(8);
            }
            this.jnJ = new bx();
            cBm();
            cBq();
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
                this.iRL.setText(str);
                this.iRK.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                this.iRJ.setVisibility(0);
            } else {
                this.iRJ.setVisibility(8);
            }
            if (this.iRM.getVisibility() == 0) {
                this.iRM.setVisibility(8);
                return;
            }
            return;
        }
        if (this.iRJ.getVisibility() == 0) {
            this.iRJ.setVisibility(8);
        }
        if (this.iRM.getVisibility() == 8) {
            this.iRM.setVisibility(0);
        }
    }

    protected void cBm() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.cgQ);
        this.jnJ.blL().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cBn() {
        if (this.jjJ != null) {
            this.jjJ.AS(this.jnM);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void cBo() {
        if (this.jjJ != null) {
            this.jjJ.cBo();
        }
    }

    protected void cBp() {
        if (this.jjK != null) {
            this.jjK.cBp();
        }
    }

    protected void cBq() {
        if (this.jnf != null) {
            this.jnf.setText(au.dy(this.mMemberNum));
        }
        if (this.jng != null) {
            this.jng.setText(au.dy(this.jnK));
        }
        if (this.jnE != null && this.jnE.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.jnS) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.eGu.getString(R.string.forum);
        if (this.bDl != null) {
            this.bDl.setText(str);
        }
        if (this.iGC != null) {
            this.iGC.setText(str);
        }
        cBx();
        this.iRC = cBw();
        if (this.iRC) {
            this.jhM.setVisibility(8);
            this.haQ.setVisibility(0);
        } else {
            this.haQ.setVisibility(8);
            this.jhM.setVisibility(0);
            this.jnq.setOnClickListener(null);
        }
        cBv();
        zQ(TbadkCoreApplication.getInst().getSkinType());
        cBr();
    }

    private void cBr() {
        boolean cBt = cBt();
        boolean cBu = cBu();
        if (!TextUtils.isEmpty(this.mForumName)) {
            e Ky = com.baidu.tieba.frs.e.d.cEG().Ky(this.mForumName);
            if (Ky == null) {
                Ky = new e(this.iRD, cBt);
            } else {
                Ky.qs(this.iRD);
                Ky.qt(cBt);
            }
            com.baidu.tieba.frs.e.d.cEG().a(this.mForumName, Ky);
        }
        ab(cBt, cBu);
        ac(cBt, cBu);
    }

    private void ab(boolean z, boolean z2) {
        if (this.iKx.cxM() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iRE.getLayoutParams();
            if (!z && !z2) {
                this.iRE.setVisibility(0);
                this.iRG.setVisibility(8);
                this.iRH.setVisibility(8);
                layoutParams.topMargin = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds50);
            } else {
                this.iRE.setVisibility(0);
                this.iRG.setVisibility(0);
                layoutParams.topMargin = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds55);
            }
            this.iKx.cxM().ae(z, z2);
        }
    }

    private void ac(boolean z, boolean z2) {
        int dimens;
        if (this.jnp != null && this.jnp.getLayoutParams() != null) {
            if (this.iRP.getVisibility() == 0) {
                int dimens2 = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.jno.getLayoutParams()).topMargin = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds384);
                int statusBarHeight = l.getStatusBarHeight(this.eGu.getPageActivity());
                ((RelativeLayout.LayoutParams) this.iRP.getLayoutParams()).topMargin = (statusBarHeight + l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds226)) - l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds72);
                dimens = dimens2;
            } else {
                dimens = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.iRC) {
                dimens -= l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds80);
            } else if (this.iRC) {
                int dimens3 = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds782);
                int ad = ad(z, z2);
                int i = dimens3 + ad;
                ((RelativeLayout.LayoutParams) this.jnq.getLayoutParams()).bottomMargin = ad;
                ((RelativeLayout.LayoutParams) this.haQ.getLayoutParams()).bottomMargin = ad;
                if (ad != 0) {
                    ((RelativeLayout.LayoutParams) this.jno.getLayoutParams()).topMargin = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds782) - l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds282);
                    dimens = i;
                } else {
                    ((RelativeLayout.LayoutParams) this.jno.getLayoutParams()).topMargin = l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds462);
                    dimens = i;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.jnp.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.jnp.setLayoutParams(layoutParams);
            }
        }
    }

    private int ad(boolean z, boolean z2) {
        int i = 0;
        if (z2) {
            i = (this.jfx.serviceAreaData == null || this.jfx.serviceAreaData.dataList == null || this.jfx.serviceAreaData.dataList.size() != 1) ? 0 + l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds84) : 0 + l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds83);
        }
        if (z && this.iRQ != null) {
            i += Math.min(this.iRQ.size(), 2) * l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds83);
        }
        if (this.jns.getVisibility() == 0) {
            i += l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds231);
        }
        if (z2 || z || this.jns.getVisibility() == 0) {
            return i + l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds45);
        }
        return i;
    }

    private LinearGradientView cBs() {
        if (this.iKx == null || this.iKx.cxM() == null) {
            return null;
        }
        View cFQ = this.iKx.cxM().cFQ();
        if (cFQ instanceof LinearGradientView) {
            return (LinearGradientView) cFQ;
        }
        return null;
    }

    private boolean cBt() {
        return this.jnu != null && this.jnu.getVisibility() == 0;
    }

    private boolean cBu() {
        return this.jnr != null && this.jnr.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBv() {
        if (this.iKx != null && this.jfx != null) {
            List<q> showTopThreadList = this.jfx.getShowTopThreadList();
            this.iRD = showTopThreadList.size() > 2;
            a(showTopThreadList, this.jfx.getBusinessPromot());
        }
    }

    private void a(List<q> list, i iVar) {
        if (this.jnu != null) {
            this.iRQ = list;
            if (iVar != null) {
                this.jnt = new g(this.eGu.getPageActivity());
                this.jns.setVisibility(0);
                this.jns.addView(this.jnt.getView());
                this.jnt.a(this.jfx != null ? this.jfx.getForum() : null, iVar);
            } else {
                this.jns.setVisibility(8);
            }
            if (this.iKx != null && this.iKx.cxV()) {
                this.jnu.setVisibility(0);
                this.jnu.setFragmentUniqueId(this.iKx.getUniqueId());
                ForumData forum = this.jfx != null ? this.jfx.getForum() : null;
                this.jnu.setForum(this.mForumId, this.mForumName, forum);
                if (forum != null && !au.isEmpty(forum.getRiskTipNotice())) {
                    list.add(0, new o(forum, false));
                } else if (forum != null && !y.isEmpty(forum.getTipInfos())) {
                    list.add(0, new o(forum, true));
                }
                this.jnu.setDatas(list, iVar);
                if (this.iRB == null) {
                    this.iRB = new az() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.az
                        public void ao(bx bxVar) {
                            j.a(b.this.iKx, b.this.jfx, bxVar);
                        }
                    };
                }
                this.jnu.setStatListener(this.iRB);
                return;
            }
            this.jnu.setVisibility(8);
        }
    }

    private boolean cBw() {
        final z zVar;
        if (this.jfx == null) {
            return false;
        }
        final FrsViewData frsViewData = this.jfx;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().dJd())) {
            zVar = new z();
            zVar.setLinkUrl("");
            zVar.setImageUrl(frsViewData.getStar().dJd());
        } else {
            zVar = (frsViewData.getActivityHeadData() == null || y.getCount(frsViewData.getActivityHeadData().bjG()) < 1) ? null : frsViewData.getActivityHeadData().bjG().get(0);
        }
        if (zVar != null) {
            if (this.jnq != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bjH())) {
                    ar arVar = new ar("c13326");
                    arVar.dR("fid", frsViewData.getForum().getId());
                    arVar.dR("obj_id", frsViewData.getActivityHeadData().bjH());
                    TiebaStatic.log(arVar);
                    ar arVar2 = new ar("common_exp");
                    arVar2.dR("page_type", PageStayDurationConstants.PageName.FRS).ak("obj_isad", 1).ak("obj_floor", 1).dR("fid", frsViewData.getForum().getId()).dR("obj_id", frsViewData.getActivityHeadData().bjH()).ak("obj_adlocate", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fbE);
                    }
                    com.baidu.tieba.t.c.dIO().a(this.iKx.getUniqueId(), com.baidu.tieba.t.a.a("", frsViewData.getActivityHeadData().bjH(), "", (BaijiahaoData) null), arVar2);
                }
                this.jnq.startLoad(zVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(zVar.getLinkUrl())) {
                    this.jnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.eGu != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().bjH())) {
                                    String id = frsViewData.getForum().getId();
                                    String bjH = frsViewData.getActivityHeadData().bjH();
                                    ar arVar3 = new ar("c13330");
                                    arVar3.dR("fid", id);
                                    arVar3.dR("obj_id", bjH);
                                    TiebaStatic.log(arVar3);
                                    ar arVar4 = new ar("common_click");
                                    arVar4.dR("page_type", PageStayDurationConstants.PageName.FRS).ak("obj_isad", 1).dR("fid", id).dR("obj_id", bjH).ak("obj_adlocate", 1).ak("obj_floor", 1).dR("first_dir", frsViewData.getForum().getFirst_class()).dR("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        arVar3.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fbE);
                                    }
                                    com.baidu.tieba.t.c.dIO().b(b.this.iKx.getUniqueId(), arVar4);
                                }
                                bf.bqF().a(b.this.eGu, new String[]{zVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void zQ(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jfx != null && (forum = this.jfx.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iRC) {
                LinearGradientView cBs = cBs();
                if (this.jhM != null && cBs != null) {
                    this.jhM.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.jnq != null) {
                    this.jnq.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.jnr != null) {
                this.jnr.setThemeFontColor(com.baidu.tieba.lego.card.d.b.sa(themeElement.common_color));
            }
            if (this.jnu != null) {
                this.jnu.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.b.sa(themeElement.common_color));
            }
        }
    }

    protected void cBx() {
        this.jnC.startLoad(this.cgQ, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void m(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.jnX);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.eGu.getPageActivity());
                this.mPopup.setContentView(this.jnx);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.jny = (TextView) this.jnx.findViewById(R.id.cur_experience);
            this.jnz = (TextView) this.jnx.findViewById(R.id.levelup_experience);
            ap.setBackgroundResource(this.jnx.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            ap.setViewTextColor((TextView) this.jnx.findViewById(R.id.experience), R.color.CAM_X0111, 1);
            ap.setViewTextColor(this.jny, R.color.common_color_10047, 1);
            ap.setViewTextColor(this.jnz, R.color.CAM_X0111, 1);
            a(this.jny, this.jnz);
            if (this.mPopup.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eGu.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.mPopup, this.eGu.getPageActivity());
                return;
            }
            com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.jnX, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.eGu.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView2, R.color.CAM_X0105, 1);
            ap.setViewTextColor(textView3, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
            aVar.bg(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.jnI) && !TextUtils.isEmpty(this.jnI.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.jnI);
            } else {
                textView3.setVisibility(8);
            }
            aVar.ot(R.color.CAM_X0305);
            d(aVar);
            e(aVar);
            aVar.b(this.eGu);
            aVar.bog();
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
                if (b.this.eGu != null && b.this.eGu.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.eGu.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBy() {
        View contentView;
        if (this.jnB == null) {
            this.jnB = new PopupWindow(this.eGu.getPageActivity());
            View inflate = LayoutInflater.from(this.eGu.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.jnB.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.eGu != null && b.this.eGu.getPageActivity() != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jnB, b.this.eGu.getPageActivity());
                        b.this.iKx.iHQ = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.eGu.getPageActivity(), b.this.eGu.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.jnB.setWidth(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.jnB.setHeight(this.eGu.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.jnB.setBackgroundDrawable(new BitmapDrawable());
            this.jnB.setOutsideTouchable(true);
            this.jnB.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(b.this.jnB);
                        b.this.iKx.iHQ = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.jnB.getContentView();
        }
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.CAM_X0101, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.CAM_X0305, 1);
        ap.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.CAM_X0101, 1);
        int[] iArr = new int[2];
        this.jnA.getLocationOnScreen(iArr);
        com.baidu.adp.lib.f.g.showPopupWindowAtLocation(this.jnB, this.mParent, 0, (iArr[0] - (this.jnB.getWidth() / 2)) + (this.jnA.getWidth() / 2), iArr[1] + this.jnA.getWidth());
        this.jnB.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.jnR = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.jnh != null && this.iEx != null && this.jnn != null && cashBitmap.getWidth() > 0) {
            if (this.jnR) {
                this.jnh.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData cys = this.iKx.cys();
                if (cys != null && cys.getForum() != null) {
                    cys.getForum().setUser_level(i);
                }
                this.jnn.setText(this.eGu.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.jnh.setText(this.jnG);
                this.jnn.setText(this.eGu.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.iEx.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, yO(this.mLevel)));
            if (this.jnR) {
                if (f >= 1.0f) {
                    b(this.iEx, this.jnT, f);
                } else {
                    c(this.iEx, this.jnT, f);
                }
            } else {
                b(this.iEx, this.jnT, f);
            }
            this.jnT = f;
        }
    }

    private int[] yO(int i) {
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
    protected void cBz() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void cBA() {
        if (this.mMemberType != 0) {
            ap.setImageResource(this.jnA, R.drawable.icon_sml_speed_orange);
        } else {
            ap.setImageResource(this.jnA, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jnB != null && this.jnB.isShowing()) {
            this.jnB.dismiss();
        }
        if (this.jnt != null) {
            this.jnt.onDestroy();
        }
    }
}
