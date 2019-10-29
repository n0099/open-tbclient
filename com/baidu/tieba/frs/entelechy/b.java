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
    private String bYJ;
    private View eaA;
    private boolean fDA;
    private RelativeLayout fDC;
    private TextView fDw;
    private TextView fDx;
    private al fDz;
    private RelativeLayout mContainer;
    private boolean fDB = false;
    private ArrayList<TbImageView> fDy = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fxh = frsFragment;
        this.cfl = frsFragment.getPageContext();
        this.fWm = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.fWn = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.fWo = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bmH();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.fWB = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.fSa = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.fap = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.fap.setPageId(this.fxh.getUniqueId());
        this.fap.setDefaultBgResource(R.color.transparent);
        this.fap.setDefaultResource(R.drawable.pic_frs_head_default);
        this.fap.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.eaA = this.mParent.findViewById(R.id.header_top_cover);
        this.fDC = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.fWC = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.fWG = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.fDw = (TextView) this.mParent.findViewById(R.id.member_image);
        this.fDx = (TextView) this.mParent.findViewById(R.id.post_image);
        this.fWt = (TextView) this.mParent.findViewById(R.id.level_name);
        this.fWz = (TextView) this.mParent.findViewById(R.id.level);
        this.fWr = (TextView) this.mParent.findViewById(R.id.tv_love);
        this.fWs = (TextView) this.mParent.findViewById(R.id.tv_sign);
        this.fWs.setContentDescription(frsFragment.getResources().getString(R.string.sign));
        this.fsf = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.fsg = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.fWp = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.fWq = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.fug = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.fWv = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.fWI = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.fWI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fWI.setPageId(this.fxh.getUniqueId());
        this.fWI.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.fWI.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.fWI.setShowOval(true);
        this.fWy = this.mParent.findViewById(R.id.level_container);
        this.fWx = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.fWw = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.fWA = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.fWL = new com.baidu.tieba.frs.f.b(this.cfl);
        this.fWD = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.fWu = LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.fWu.setVisibility(8);
    }

    protected View bmH() {
        return LayoutInflater.from(this.fxh.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void w(View.OnClickListener onClickListener) {
        this.fWI.setOnClickListener(onClickListener);
        this.fug.setOnClickListener(onClickListener);
        this.fWs.setOnClickListener(onClickListener);
        this.fWr.setOnClickListener(onClickListener);
        this.fWy.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmI() {
        this.fWv.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.cfl.getLayoutMode().setNightMode(i == 1);
        this.cfl.getLayoutMode().onModeChanged(this.mParent);
        this.cfl.getLayoutMode().onModeChanged(this.fWD);
        this.cfl.getLayoutMode().onModeChanged(this.fWu);
        am.setBackgroundResource(this.fsf, R.drawable.frs_exp_progress);
        am.setBackgroundColor(this.fsg, R.color.cp_cont_a);
        am.setBackgroundColor(this.fWA, R.color.black_alpha0);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fug, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fWz, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fWt, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fDw, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fWp, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fDx, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fWq, (int) R.color.cp_cont_a);
        if (this.fWI != null) {
            this.fWI.setBorderWidth(l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds1));
            this.fWI.setBorderColor(am.getColor(R.color.cp_border_a));
            this.fWI.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fWI.invalidate();
        }
        if (this.fWJ != null) {
            this.fWJ.onChangeSkin(i);
        }
        if (this.fSa != null) {
            this.fSa.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fDy.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bmV();
        so(this.fWW ? 1 : 0);
        bmM();
        qT(i);
        if (this.fWC != null) {
            this.fWC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void jJ(boolean z) {
        super.jJ(z);
        if (this.fWC != null) {
            this.fWC.jJ(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fWQ = forumData.getPost_num();
            this.fWN = forumData.getTag_color();
            this.bYJ = forumData.getImage_url();
            this.fWM = forumData.getLevelName();
            this.arR = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fWR = forumData.getSignData().count_sign_num;
                this.fWS = forumData.getSignData().miss_sign_num;
            }
            this.fWT = forumData.getCurScore();
            this.fTj = forumData.getLevelupScore();
            this.fWK = forumData.getBadgeData();
            this.fWO = forumData.getAccelerateContent();
            this.fWY = forumData.isBrandForum;
            this.fTN = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fWP = new bh();
            bmJ();
            bmN();
        }
    }

    protected void bmJ() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bYJ);
        this.fWP.aiQ().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmK() {
        int dimens = l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds39);
        int dimens2 = l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds20);
        if (this.fWS > 0) {
            am.setViewTextColor(this.fWs, R.color.cp_cont_b, 1);
            Drawable a = SvgManager.amN().a(R.drawable.icon_pure_frs_sign_add_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            if (a != null) {
                a.setBounds(0, 0, dimens, dimens);
            }
            this.fWs.setPadding(dimens2, 0, dimens2, 0);
            this.fWs.setCompoundDrawablesWithIntrinsicBounds(a, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fWs.setText(String.format(this.cfl.getString(R.string.miss_sign_days), Integer.valueOf(this.fWS)));
        } else {
            Drawable a2 = SvgManager.amN().a(R.drawable.icon_pure_frs_sign_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            am.setViewTextColor(this.fWs, R.color.cp_cont_b, 1);
            if (a2 != null) {
                a2.setBounds(0, 0, dimens, dimens);
            }
            this.fWs.setCompoundDrawables(a2, null, null, null);
            this.fWs.setText(this.cfl.getString(R.string.signed));
            this.fWs.setPadding(dimens2, 0, dimens2, 0);
            this.fWs.setBackgroundDrawable(null);
        }
        am.e(this.fWs, l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
        this.fWs.setTextSize(0, l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds34));
        this.fWs.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmL() {
        int dimens = l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds39);
        Drawable a = SvgManager.amN().a(R.drawable.icon_pure_frs_sign_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        if (a != null) {
            a.setBounds(0, 0, dimens, dimens);
        }
        int dimens2 = l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds20);
        this.fWs.setPadding(dimens2, 0, dimens2, 0);
        this.fWs.setCompoundDrawablesWithIntrinsicBounds(a, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fWs.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        this.fWs.setText(this.cfl.getString(R.string.sign));
        am.setViewTextColor(this.fWs, R.color.cp_cont_b, 1);
        am.e(this.fWs, l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
    }

    protected void bmM() {
        this.fWr.setTextSize(0, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        am.setViewTextColor(this.fWr, R.color.cp_cont_b, 1);
        am.e(this.fWr, l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
    }

    protected void bmN() {
        if (this.fWp != null) {
            this.fWp.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.fWq != null) {
            this.fWq.setText(aq.numberUniformFormatExtra(this.fWQ));
        }
        if (this.fWK != null && this.fWK.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fWY) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.cfl.getString(R.string.forum);
        if (this.aqv != null) {
            this.aqv.setText(str);
        }
        if (this.fug != null) {
            this.fug.setText(str);
        }
        bmS();
        this.fDA = bmR();
        if (this.fDA) {
            this.fSa.setVisibility(8);
            this.eaA.setVisibility(0);
        } else {
            this.eaA.setVisibility(8);
            this.fSa.setVisibility(0);
            this.fap.setOnClickListener(null);
        }
        bmQ();
        qT(TbadkCoreApplication.getInst().getSkinType());
        N(this.fDA, bmP());
    }

    private void N(boolean z, boolean z2) {
        e ww = d.bpW().ww(this.mForumName);
        if (ww == null) {
            ww = new e(this.fDB, z2);
        } else {
            ww.kC(this.fDB);
            ww.kD(z2);
        }
        d.bpW().a(this.mForumName, ww);
        O(z, z2);
        P(z, z2);
    }

    private void O(boolean z, boolean z2) {
        int dimens;
        if (this.fWB != null && this.fWB.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.cfl.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWA.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.cfl.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.cfl.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.fWA.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.fWB.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.fWB.setLayoutParams(layoutParams2);
            }
        }
    }

    private void P(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bmO = bmO();
        if (bmO != null) {
            bmO.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fDC != null) {
            RelativeLayout relativeLayout = this.fDC;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bmO() {
        if (this.fxh == null || this.fxh.bjN() == null) {
            return null;
        }
        View bqP = this.fxh.bjN().bqP();
        if (bqP instanceof LinearGradientView) {
            return (LinearGradientView) bqP;
        }
        return null;
    }

    private boolean bmP() {
        return this.fWC != null && this.fWC.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmQ() {
        if (this.fxh != null && this.fTN != null) {
            List<m> showTopThreadList = this.fTN.getShowTopThreadList();
            this.fDB = showTopThreadList.size() > 2;
            a(showTopThreadList, this.fTN.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.fWC != null) {
            if (this.fxh != null && this.fxh.bjW()) {
                this.fWC.setVisibility(0);
                this.fWC.setFragmentUniqueId(this.fxh.getUniqueId());
                this.fWC.setForum(this.mForumId, this.mForumName);
                this.fWC.setDatas(list, hVar);
                if (this.fDz == null) {
                    this.fDz = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ab(bh bhVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.fxh, b.this.fTN, bhVar);
                        }
                    };
                }
                this.fWC.setStatListener(this.fDz);
                return;
            }
            this.fWC.setVisibility(8);
        }
    }

    private boolean bmR() {
        if (this.fTN == null) {
            return false;
        }
        final FrsViewData frsViewData = this.fTN;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cnz())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().cnz());
        } else if (frsViewData.getActivityHeadData() != null && v.getCount(frsViewData.getActivityHeadData().agW()) >= 1) {
            sVar = frsViewData.getActivityHeadData().agW().get(0);
        }
        if (sVar != null) {
            if (this.fap != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().agX())) {
                    an anVar = new an("c13326");
                    anVar.bS("fid", frsViewData.getForum().getId());
                    anVar.bS("obj_id", frsViewData.getActivityHeadData().agX());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.bS("page_type", PageStayDurationConstants.PageName.FRS).O("obj_isad", 1).bS("fid", frsViewData.getForum().getId()).bS("obj_id", frsViewData.getActivityHeadData().agX()).O("obj_adlocate", 1);
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().cuL);
                    }
                    com.baidu.tieba.q.c.cnk().a(this.fxh.getUniqueId(), frsViewData.getActivityHeadData().agX(), anVar2);
                }
                this.fap.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.fap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.cfl != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().agX())) {
                                    String id = frsViewData.getForum().getId();
                                    String agX = frsViewData.getActivityHeadData().agX();
                                    an anVar3 = new an("c13330");
                                    anVar3.bS("fid", id);
                                    anVar3.bS("obj_id", agX);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.bS("page_type", PageStayDurationConstants.PageName.FRS).O("obj_isad", 1).bS("fid", id).bS("obj_id", agX).O("obj_adlocate", 1);
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().cuL);
                                    }
                                    com.baidu.tieba.q.c.cnk().b(b.this.fxh.getUniqueId(), anVar4);
                                }
                                ba.amQ().a(b.this.cfl, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void qT(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fTN != null && this.fTN.getForum() != null && (themeColorInfo = (forum = this.fTN.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1 || i == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fDA) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bmO = bmO();
                if (this.fSa != null && bmO != null) {
                    this.fSa.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bmO.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.fap != null) {
                    this.fap.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fWC != null) {
                String str = themeElement.font_color;
                this.fWC.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.bR(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bmS() {
        this.fWI.startLoad(this.bYJ, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fXe);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.cfl.getPageActivity());
                this.mPopup.setContentView(this.fWD);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.fWE = (TextView) this.fWD.findViewById(R.id.cur_experience);
            this.fWF = (TextView) this.fWD.findViewById(R.id.levelup_experience);
            am.setBackgroundResource(this.fWD.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.setViewTextColor((TextView) this.fWD.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.setViewTextColor(this.fWE, R.color.common_color_10047, 1);
            am.setViewTextColor(this.fWF, R.color.cp_cont_g, 1);
            a(this.fWE, this.fWF);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.cfl.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.cfl.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.fXe, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.cfl.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
            aVar.aM(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.fWO) && !TextUtils.isEmpty(this.fWO.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fWO);
            } else {
                textView3.setVisibility(8);
            }
            aVar.hV(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.cfl);
            aVar.akO();
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
                if (b.this.cfl != null && b.this.cfl.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.cfl.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmT() {
        View contentView;
        if (this.fWH == null) {
            this.fWH = new PopupWindow(this.cfl.getPageActivity());
            View inflate = LayoutInflater.from(this.cfl.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.fWH.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.cfl != null && b.this.cfl.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.fWH, b.this.cfl.getPageActivity());
                        b.this.fxh.fvb = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.cfl.getPageActivity(), b.this.cfl.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fWH.setWidth(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.fWH.setHeight(this.cfl.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.fWH.setBackgroundDrawable(new BitmapDrawable());
            this.fWH.setOutsideTouchable(true);
            this.fWH.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.fWH);
                        b.this.fxh.fvb = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fWH.getContentView();
        }
        am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.fWG.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fWH, this.mParent, 0, (iArr[0] - (this.fWH.getWidth() / 2)) + (this.fWG.getWidth() / 2), iArr[1] + this.fWG.getWidth());
        this.fWH.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fWX = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fWt != null && this.fsf != null && this.fWz != null && cashBitmap.getWidth() > 0) {
            if (this.fWX) {
                this.fWt.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.arR;
                } else {
                    i = this.arR + 1;
                }
                FrsViewData bkp = this.fxh.bkp();
                if (bkp != null && bkp.getForum() != null) {
                    bkp.getForum().setUser_level(i);
                }
                this.fWz.setText(this.cfl.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.fWt.setText(this.fWM);
                this.fWz.setText(this.cfl.getResources().getString(R.string.lv_num, Integer.valueOf(this.arR)));
            }
            this.fsf.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, qb(this.arR)));
            if (this.fWX) {
                if (f >= 1.0f) {
                    a(this.fxh.getBaseFragmentActivity(), this.fsf, this.fWZ, f);
                } else {
                    b(this.fxh.getBaseFragmentActivity(), this.fsf, this.fWZ, f);
                }
            } else {
                a(this.fxh.getBaseFragmentActivity(), this.fsf, this.fWZ, f);
            }
            this.fWZ = f;
        }
    }

    private int[] qb(int i) {
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
    protected void bmU() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmV() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.fWG, R.drawable.icon_sml_speed_orange);
        } else {
            am.setImageResource(this.fWG, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fWH != null && this.fWH.isShowing()) {
            this.fWH.dismiss();
        }
        if (this.fWC != null) {
            this.fWC.onDestroy();
        }
    }
}
