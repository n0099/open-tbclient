package com.baidu.tieba.frs.entelechy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.e.d;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String bXS;
    private View dZJ;
    private TextView fCF;
    private TextView fCG;
    private al fCI;
    private boolean fCJ;
    private RelativeLayout fCL;
    private RelativeLayout mContainer;
    private boolean fCK = false;
    private ArrayList<TbImageView> fCH = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fwq = frsFragment;
        this.ceu = frsFragment.getPageContext();
        this.fVv = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.fVw = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.fVx = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bmF();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.fVK = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.fRj = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.eZy = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.eZy.setPageId(this.fwq.getUniqueId());
        this.eZy.setDefaultBgResource(R.color.transparent);
        this.eZy.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eZy.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.dZJ = this.mParent.findViewById(R.id.header_top_cover);
        this.fCL = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.fVL = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.fVP = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.fCF = (TextView) this.mParent.findViewById(R.id.member_image);
        this.fCG = (TextView) this.mParent.findViewById(R.id.post_image);
        this.fVC = (TextView) this.mParent.findViewById(R.id.level_name);
        this.fVI = (TextView) this.mParent.findViewById(R.id.level);
        this.fVA = (TextView) this.mParent.findViewById(R.id.tv_love);
        this.fVB = (TextView) this.mParent.findViewById(R.id.tv_sign);
        this.fVB.setContentDescription(frsFragment.getResources().getString(R.string.sign));
        this.frn = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.fro = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.fVy = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.fVz = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.ftp = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.fVE = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.fVR = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.fVR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVR.setPageId(this.fwq.getUniqueId());
        this.fVR.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.fVR.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.fVR.setShowOval(true);
        this.fVH = this.mParent.findViewById(R.id.level_container);
        this.fVG = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.fVF = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.fVJ = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.fVU = new com.baidu.tieba.frs.f.b(this.ceu);
        this.fVM = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.fVD = LayoutInflater.from(this.fwq.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.fVD.setVisibility(8);
    }

    protected View bmF() {
        return LayoutInflater.from(this.fwq.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void w(View.OnClickListener onClickListener) {
        this.fVR.setOnClickListener(onClickListener);
        this.ftp.setOnClickListener(onClickListener);
        this.fVB.setOnClickListener(onClickListener);
        this.fVA.setOnClickListener(onClickListener);
        this.fVH.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmG() {
        this.fVE.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.ceu.getLayoutMode().setNightMode(i == 1);
        this.ceu.getLayoutMode().onModeChanged(this.mParent);
        this.ceu.getLayoutMode().onModeChanged(this.fVM);
        this.ceu.getLayoutMode().onModeChanged(this.fVD);
        am.setBackgroundResource(this.frn, R.drawable.frs_exp_progress);
        am.setBackgroundColor(this.fro, R.color.cp_cont_a);
        am.setBackgroundColor(this.fVJ, R.color.black_alpha0);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        am.setViewTextColor(this.ftp, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fVI, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fVC, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fCF, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fVy, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fCG, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fVz, (int) R.color.cp_cont_a);
        if (this.fVR != null) {
            this.fVR.setBorderWidth(l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds1));
            this.fVR.setBorderColor(am.getColor(R.color.cp_border_a));
            this.fVR.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fVR.invalidate();
        }
        if (this.fVS != null) {
            this.fVS.onChangeSkin(i);
        }
        if (this.fRj != null) {
            this.fRj.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fCH.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bmT();
        sn(this.fWf ? 1 : 0);
        bmK();
        qS(i);
        if (this.fVL != null) {
            this.fVL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void jJ(boolean z) {
        super.jJ(z);
        if (this.fVL != null) {
            this.fVL.jJ(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fVZ = forumData.getPost_num();
            this.fVW = forumData.getTag_color();
            this.bXS = forumData.getImage_url();
            this.fVV = forumData.getLevelName();
            this.arz = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fWa = forumData.getSignData().count_sign_num;
                this.fWb = forumData.getSignData().miss_sign_num;
            }
            this.fWc = forumData.getCurScore();
            this.fSs = forumData.getLevelupScore();
            this.fVT = forumData.getBadgeData();
            this.fVX = forumData.getAccelerateContent();
            this.fWh = forumData.isBrandForum;
            this.fSW = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fVY = new bh();
            bmH();
            bmL();
        }
    }

    protected void bmH() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bXS);
        this.fVY.aiO().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmI() {
        int dimens = l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds39);
        int dimens2 = l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds20);
        if (this.fWb > 0) {
            am.setViewTextColor(this.fVB, R.color.cp_cont_b, 1);
            Drawable a = SvgManager.amL().a(R.drawable.icon_pure_frs_sign_add_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            if (a != null) {
                a.setBounds(0, 0, dimens, dimens);
            }
            this.fVB.setPadding(dimens2, 0, dimens2, 0);
            this.fVB.setCompoundDrawablesWithIntrinsicBounds(a, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fVB.setText(String.format(this.ceu.getString(R.string.miss_sign_days), Integer.valueOf(this.fWb)));
        } else {
            Drawable a2 = SvgManager.amL().a(R.drawable.icon_pure_frs_sign_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.fVB, R.color.cp_cont_b, 1);
            if (a2 != null) {
                a2.setBounds(0, 0, dimens, dimens);
            }
            this.fVB.setCompoundDrawables(a2, null, null, null);
            this.fVB.setText(this.ceu.getString(R.string.signed));
            this.fVB.setPadding(dimens2, 0, dimens2, 0);
            this.fVB.setBackgroundDrawable(null);
        }
        am.e(this.fVB, l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
        this.fVB.setTextSize(0, l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds34));
        this.fVB.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmJ() {
        int dimens = l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds39);
        Drawable a = SvgManager.amL().a(R.drawable.icon_pure_frs_sign_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        if (a != null) {
            a.setBounds(0, 0, dimens, dimens);
        }
        int dimens2 = l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds20);
        this.fVB.setPadding(dimens2, 0, dimens2, 0);
        this.fVB.setCompoundDrawablesWithIntrinsicBounds(a, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fVB.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        this.fVB.setText(this.ceu.getString(R.string.sign));
        am.setViewTextColor(this.fVB, R.color.cp_cont_b, 1);
        am.e(this.fVB, l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
    }

    protected void bmK() {
        this.fVA.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        am.setViewTextColor(this.fVA, R.color.cp_cont_b, 1);
        am.e(this.fVA, l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
    }

    protected void bmL() {
        if (this.fVy != null) {
            this.fVy.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.fVz != null) {
            this.fVz.setText(aq.numberUniformFormatExtra(this.fVZ));
        }
        if (this.fVT != null && this.fVT.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fWh) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.ceu.getString(R.string.forum);
        if (this.aqd != null) {
            this.aqd.setText(str);
        }
        if (this.ftp != null) {
            this.ftp.setText(str);
        }
        bmQ();
        this.fCJ = bmP();
        if (this.fCJ) {
            this.fRj.setVisibility(8);
            this.dZJ.setVisibility(0);
        } else {
            this.dZJ.setVisibility(8);
            this.fRj.setVisibility(0);
            this.eZy.setOnClickListener(null);
        }
        bmO();
        qS(TbadkCoreApplication.getInst().getSkinType());
        N(this.fCJ, bmN());
    }

    private void N(boolean z, boolean z2) {
        e ww = d.bpU().ww(this.mForumName);
        if (ww == null) {
            ww = new e(this.fCK, z2);
        } else {
            ww.kC(this.fCK);
            ww.kD(z2);
        }
        d.bpU().a(this.mForumName, ww);
        O(z, z2);
        P(z, z2);
    }

    private void O(boolean z, boolean z2) {
        int dimens;
        if (this.fVK != null && this.fVK.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.ceu.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVJ.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.ceu.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.ceu.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.fVJ.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.fVK.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.fVK.setLayoutParams(layoutParams2);
            }
        }
    }

    private void P(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bmM = bmM();
        if (bmM != null) {
            bmM.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fCL != null) {
            RelativeLayout relativeLayout = this.fCL;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bmM() {
        if (this.fwq == null || this.fwq.bjL() == null) {
            return null;
        }
        View bqN = this.fwq.bjL().bqN();
        if (bqN instanceof LinearGradientView) {
            return (LinearGradientView) bqN;
        }
        return null;
    }

    private boolean bmN() {
        return this.fVL != null && this.fVL.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmO() {
        if (this.fwq != null && this.fSW != null) {
            List<m> showTopThreadList = this.fSW.getShowTopThreadList();
            this.fCK = showTopThreadList.size() > 2;
            a(showTopThreadList, this.fSW.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.fVL != null) {
            if (this.fwq != null && this.fwq.bjU()) {
                this.fVL.setVisibility(0);
                this.fVL.setFragmentUniqueId(this.fwq.getUniqueId());
                this.fVL.setForum(this.mForumId, this.mForumName);
                this.fVL.setDatas(list, hVar);
                if (this.fCI == null) {
                    this.fCI = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ab(bh bhVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.fwq, b.this.fSW, bhVar);
                        }
                    };
                }
                this.fVL.setStatListener(this.fCI);
                return;
            }
            this.fVL.setVisibility(8);
        }
    }

    private boolean bmP() {
        if (this.fSW == null) {
            return false;
        }
        final FrsViewData frsViewData = this.fSW;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cnx())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().cnx());
        } else if (frsViewData.getActivityHeadData() != null && v.getCount(frsViewData.getActivityHeadData().agU()) >= 1) {
            sVar = frsViewData.getActivityHeadData().agU().get(0);
        }
        if (sVar != null) {
            if (this.eZy != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().agV())) {
                    an anVar = new an("c13326");
                    anVar.bS("fid", frsViewData.getForum().getId());
                    anVar.bS("obj_id", frsViewData.getActivityHeadData().agV());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.bS("page_type", PageStayDurationConstants.PageName.FRS).O("obj_isad", 1).bS("fid", frsViewData.getForum().getId()).bS("obj_id", frsViewData.getActivityHeadData().agV()).O("obj_adlocate", 1);
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().ctT);
                    }
                    com.baidu.tieba.q.c.cni().a(this.fwq.getUniqueId(), frsViewData.getActivityHeadData().agV(), anVar2);
                }
                this.eZy.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.ceu != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().agV())) {
                                    String id = frsViewData.getForum().getId();
                                    String agV = frsViewData.getActivityHeadData().agV();
                                    an anVar3 = new an("c13330");
                                    anVar3.bS("fid", id);
                                    anVar3.bS("obj_id", agV);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.bS("page_type", PageStayDurationConstants.PageName.FRS).O("obj_isad", 1).bS("fid", id).bS("obj_id", agV).O("obj_adlocate", 1);
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().ctT);
                                    }
                                    com.baidu.tieba.q.c.cni().b(b.this.fwq.getUniqueId(), anVar4);
                                }
                                ba.amO().a(b.this.ceu, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void qS(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fSW != null && this.fSW.getForum() != null && (themeColorInfo = (forum = this.fSW.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1 || i == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fCJ) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bmM = bmM();
                if (this.fRj != null && bmM != null) {
                    this.fRj.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bmM.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eZy != null) {
                    this.eZy.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fVL != null) {
                String str = themeElement.font_color;
                this.fVL.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.bR(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bmQ() {
        this.fVR.startLoad(this.bXS, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fWn);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.ceu.getPageActivity());
                this.mPopup.setContentView(this.fVM);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.fVN = (TextView) this.fVM.findViewById(R.id.cur_experience);
            this.fVO = (TextView) this.fVM.findViewById(R.id.levelup_experience);
            am.setBackgroundResource(this.fVM.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.setViewTextColor((TextView) this.fVM.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.setViewTextColor(this.fVN, R.color.common_color_10047, 1);
            am.setViewTextColor(this.fVO, R.color.cp_cont_g, 1);
            a(this.fVN, this.fVO);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.ceu.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.ceu.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.fWn, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.ceu.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
            aVar.aM(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.fVX) && !TextUtils.isEmpty(this.fVX.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fVX);
            } else {
                textView3.setVisibility(8);
            }
            aVar.hU(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.ceu);
            aVar.akM();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (b.this.ceu != null && b.this.ceu.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.ceu.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmR() {
        View contentView;
        if (this.fVQ == null) {
            this.fVQ = new PopupWindow(this.ceu.getPageActivity());
            View inflate = LayoutInflater.from(this.ceu.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.fVQ.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ceu != null && b.this.ceu.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.fVQ, b.this.ceu.getPageActivity());
                        b.this.fwq.fuk = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.ceu.getPageActivity(), b.this.ceu.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fVQ.setWidth(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.fVQ.setHeight(this.ceu.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.fVQ.setBackgroundDrawable(new BitmapDrawable());
            this.fVQ.setOutsideTouchable(true);
            this.fVQ.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.fVQ);
                        b.this.fwq.fuk = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fVQ.getContentView();
        }
        am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.fVP.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fVQ, this.mParent, 0, (iArr[0] - (this.fVQ.getWidth() / 2)) + (this.fVP.getWidth() / 2), iArr[1] + this.fVP.getWidth());
        this.fVQ.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fWg = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fVC != null && this.frn != null && this.fVI != null && cashBitmap.getWidth() > 0) {
            if (this.fWg) {
                this.fVC.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.arz;
                } else {
                    i = this.arz + 1;
                }
                FrsViewData bkn = this.fwq.bkn();
                if (bkn != null && bkn.getForum() != null) {
                    bkn.getForum().setUser_level(i);
                }
                this.fVI.setText(this.ceu.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.fVC.setText(this.fVV);
                this.fVI.setText(this.ceu.getResources().getString(R.string.lv_num, Integer.valueOf(this.arz)));
            }
            this.frn.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, qa(this.arz)));
            if (this.fWg) {
                if (f >= 1.0f) {
                    a(this.fwq.getBaseFragmentActivity(), this.frn, this.fWi, f);
                } else {
                    b(this.fwq.getBaseFragmentActivity(), this.frn, this.fWi, f);
                }
            } else {
                a(this.fwq.getBaseFragmentActivity(), this.frn, this.fWi, f);
            }
            this.fWi = f;
        }
    }

    private int[] qa(int i) {
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
    protected void bmS() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmT() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.fVP, R.drawable.icon_sml_speed_orange);
        } else {
            am.setImageResource(this.fVP, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fVQ != null && this.fVQ.isShowing()) {
            this.fVQ.dismiss();
        }
        if (this.fVL != null) {
            this.fVL.onDestroy();
        }
    }
}
