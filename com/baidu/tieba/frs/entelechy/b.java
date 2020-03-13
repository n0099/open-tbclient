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
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.am;
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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private View eVk;
    private TextView gwo;
    private TextView gwp;
    private am gwr;
    private boolean gws;
    private RelativeLayout gwu;
    private RelativeLayout mContainer;
    private String mImageUrl;
    private boolean gwt = false;
    private ArrayList<TbImageView> gwq = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.gqm = frsFragment;
        this.cVi = frsFragment.getPageContext();
        this.gPv = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.gPw = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.gPx = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bGJ();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.gPI = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.gKW = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.gPJ = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.gPJ.setPageId(this.gqm.getUniqueId());
        this.gPJ.setDefaultBgResource(R.color.transparent);
        this.gPJ.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gPJ.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.eVk = this.mParent.findViewById(R.id.header_top_cover);
        this.gwu = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.gPK = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.gPO = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.gwo = (TextView) this.mParent.findViewById(R.id.member_image);
        this.gwp = (TextView) this.mParent.findViewById(R.id.post_image);
        this.gPA = (TextView) this.mParent.findViewById(R.id.level_name);
        this.gPG = (TextView) this.mParent.findViewById(R.id.level);
        this.gMh = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.gMh.setText(frsFragment.getResources().getString(R.string.attention));
        this.gMh.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lt(R.color.cp_cont_b);
        this.gMh.setConfig(cVar);
        this.gMo = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.gMo.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lt(R.color.cp_cont_b);
        cVar2.lr(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.gMo.setConfig(cVar2);
        this.gMo.setText(frsFragment.getResources().getString(R.string.sign));
        this.glk = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.gll = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.gPy = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.gPz = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.gnn = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.gPC = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.gPQ = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.gPQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gPQ.setPageId(this.gqm.getUniqueId());
        this.gPQ.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.gPQ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.gPQ.setShowOval(true);
        this.gPQ.setPlaceHolder(2);
        this.gPF = this.mParent.findViewById(R.id.level_container);
        this.gPE = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.gPD = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.gPH = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.gPL = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.gPB = LayoutInflater.from(this.gqm.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.gPB.setVisibility(8);
        this.gPT = new com.baidu.tieba.frs.f.b(this.cVi);
    }

    protected View bGJ() {
        return LayoutInflater.from(this.gqm.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void y(View.OnClickListener onClickListener) {
        this.gPQ.setOnClickListener(onClickListener);
        this.gnn.setOnClickListener(onClickListener);
        this.gMo.setOnClickListener(onClickListener);
        this.gMh.setOnClickListener(onClickListener);
        this.gPF.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGK() {
        this.gPC.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.cVi.getLayoutMode().setNightMode(i == 1);
        this.cVi.getLayoutMode().onModeChanged(this.mParent);
        this.cVi.getLayoutMode().onModeChanged(this.gPL);
        this.cVi.getLayoutMode().onModeChanged(this.gPB);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.glk, R.drawable.frs_exp_progress);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gll, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gPH, R.color.black_alpha0);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gnn, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPG, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPA, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gwo, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPy, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gwp, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPz, (int) R.color.cp_cont_a);
        if (this.gPQ != null) {
            this.gPQ.setBorderWidth(l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds1));
            this.gPQ.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_mask_b_alpha16));
            this.gPQ.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gPQ.setPlaceHolder(2);
            this.gPQ.invalidate();
        }
        if (this.gPR != null) {
            this.gPR.onChangeSkin(i);
        }
        if (this.gKW != null) {
            this.gKW.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.gwq.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bGX();
        uG(this.gQe ? 1 : 0);
        bGO();
        tj(i);
        if (this.gPK != null) {
            this.gPK.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onPrimary(boolean z) {
        super.onPrimary(z);
        if (this.gPK != null) {
            this.gPK.onPrimary(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.gPY = forumData.getPost_num();
            this.gPV = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.gPU = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.gPZ = forumData.getSignData().count_sign_num;
                this.gQa = forumData.getSignData().miss_sign_num;
            }
            this.gQb = forumData.getCurScore();
            this.gMr = forumData.getLevelupScore();
            this.gPS = forumData.getBadgeData();
            this.gPW = forumData.getAccelerateContent();
            this.gQg = forumData.isBrandForum;
            this.gMV = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.gPX = new bj();
            bGL();
            bGP();
        }
    }

    protected void bGL() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.gPX.aCy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bGM() {
        if (this.gME != null) {
            this.gME.ui(this.gQa);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bGN() {
        if (this.gME != null) {
            this.gME.bGN();
        }
    }

    protected void bGO() {
        if (this.gMF != null) {
            this.gMF.bGO();
        }
    }

    protected void bGP() {
        if (this.gPy != null) {
            this.gPy.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.gPz != null) {
            this.gPz.setText(aq.numberUniformFormatExtra(this.gPY));
        }
        if (this.gPS != null && this.gPS.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.gQg) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.cVi.getString(R.string.forum);
        if (this.aCU != null) {
            this.aCU.setText(str);
        }
        if (this.gnn != null) {
            this.gnn.setText(str);
        }
        bGU();
        this.gws = bGT();
        if (this.gws) {
            this.gKW.setVisibility(8);
            this.eVk.setVisibility(0);
        } else {
            this.eVk.setVisibility(8);
            this.gKW.setVisibility(0);
            this.gPJ.setOnClickListener(null);
        }
        bGS();
        tj(TbadkCoreApplication.getInst().getSkinType());
        P(this.gws, bGR());
    }

    private void P(boolean z, boolean z2) {
        e BM = d.bJW().BM(this.mForumName);
        if (BM == null) {
            BM = new e(this.gwt, z2);
        } else {
            BM.mb(this.gwt);
            BM.mc(z2);
        }
        d.bJW().a(this.mForumName, BM);
        Q(z, z2);
        R(z, z2);
    }

    private void Q(boolean z, boolean z2) {
        int dimens;
        if (this.gPI != null && this.gPI.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.cVi.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPH.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.cVi.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.cVi.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.gPH.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.gPI.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.gPI.setLayoutParams(layoutParams2);
            }
        }
    }

    private void R(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bGQ = bGQ();
        if (bGQ != null) {
            bGQ.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.gwu != null) {
            RelativeLayout relativeLayout = this.gwu;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bGQ() {
        if (this.gqm == null || this.gqm.bDO() == null) {
            return null;
        }
        View bKU = this.gqm.bDO().bKU();
        if (bKU instanceof LinearGradientView) {
            return (LinearGradientView) bKU;
        }
        return null;
    }

    private boolean bGR() {
        return this.gPK != null && this.gPK.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGS() {
        if (this.gqm != null && this.gMV != null) {
            List<m> showTopThreadList = this.gMV.getShowTopThreadList();
            this.gwt = showTopThreadList.size() > 2;
            a(showTopThreadList, this.gMV.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.gPK != null) {
            if (this.gqm != null && this.gqm.bDX()) {
                this.gPK.setVisibility(0);
                this.gPK.setFragmentUniqueId(this.gqm.getUniqueId());
                this.gPK.setForum(this.mForumId, this.mForumName, this.gMV != null ? this.gMV.getForum() : null);
                this.gPK.setDatas(list, hVar);
                if (this.gwr == null) {
                    this.gwr = new am() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.am
                        public void ak(bj bjVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.gqm, b.this.gMV, bjVar);
                        }
                    };
                }
                this.gPK.setStatListener(this.gwr);
                return;
            }
            this.gPK.setVisibility(8);
        }
    }

    private boolean bGT() {
        final t tVar;
        if (this.gMV == null) {
            return false;
        }
        final FrsViewData frsViewData = this.gMV;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cKq())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cKq());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aAx()) < 1) ? null : frsViewData.getActivityHeadData().aAx().get(0);
        }
        if (tVar != null) {
            if (this.gPJ != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aAy())) {
                    an anVar = new an("c13326");
                    anVar.cy("fid", frsViewData.getForum().getId());
                    anVar.cy("obj_id", frsViewData.getActivityHeadData().aAy());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.cy("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).X("obj_floor", 1).cy("fid", frsViewData.getForum().getId()).cy("obj_id", frsViewData.getActivityHeadData().aAy()).X("obj_adlocate", 1).cy("first_dir", frsViewData.getForum().getFirst_class()).cy("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cy(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dml);
                    }
                    com.baidu.tieba.s.c.cKb().a(this.gqm.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aAy(), "", null), anVar2);
                }
                this.gPJ.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.gPJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.cVi != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aAy())) {
                                    String id = frsViewData.getForum().getId();
                                    String aAy = frsViewData.getActivityHeadData().aAy();
                                    an anVar3 = new an("c13330");
                                    anVar3.cy("fid", id);
                                    anVar3.cy("obj_id", aAy);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.cy("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).cy("fid", id).cy("obj_id", aAy).X("obj_adlocate", 1).X("obj_floor", 1).cy("first_dir", frsViewData.getForum().getFirst_class()).cy("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.cy(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dml);
                                    }
                                    com.baidu.tieba.s.c.cKb().b(b.this.gqm.getUniqueId(), anVar4);
                                }
                                ba.aGG().a(b.this.cVi, new String[]{tVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void tj(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gMV != null && (forum = this.gMV.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gws) {
                LinearGradientView bGQ = bGQ();
                if (this.gKW != null && bGQ != null) {
                    this.gKW.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bGQ.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.gPJ != null) {
                    this.gPJ.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.gPK != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.gPK.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cG(str));
            }
        }
    }

    protected void bGU() {
        this.gPQ.startLoad(this.mImageUrl, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.gQm);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.cVi.getPageActivity());
                this.mPopup.setContentView(this.gPL);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.cVi.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.cVi.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.gPM = (TextView) this.gPL.findViewById(R.id.cur_experience);
            this.gPN = (TextView) this.gPL.findViewById(R.id.levelup_experience);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.gPL.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) this.gPL.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gPM, R.color.common_color_10047, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gPN, R.color.cp_cont_g, 1);
            a(this.gPM, this.gPN);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.cVi.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.cVi.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.gQm, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.cVi.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.gPW) && !TextUtils.isEmpty(this.gPW.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.gPW);
            } else {
                textView3.setVisibility(8);
            }
            aVar.jX(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.cVi);
            aVar.aEC();
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
                if (b.this.cVi != null && b.this.cVi.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.cVi.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGV() {
        View contentView;
        if (this.gPP == null) {
            this.gPP = new PopupWindow(this.cVi.getPageActivity());
            View inflate = LayoutInflater.from(this.cVi.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.gPP.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.cVi != null && b.this.cVi.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.gPP, b.this.cVi.getPageActivity());
                        b.this.gqm.gom = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.cVi.getPageActivity(), b.this.cVi.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.gPP.setWidth(this.cVi.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.gPP.setHeight(this.cVi.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.gPP.setBackgroundDrawable(new BitmapDrawable());
            this.gPP.setOutsideTouchable(true);
            this.gPP.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.gPP);
                        b.this.gqm.gom = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.gPP.getContentView();
        }
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.gPO.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.gPP, this.mParent, 0, (iArr[0] - (this.gPP.getWidth() / 2)) + (this.gPO.getWidth() / 2), iArr[1] + this.gPO.getWidth());
        this.gPP.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.gQf = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.gPA != null && this.glk != null && this.gPG != null && cashBitmap.getWidth() > 0) {
            if (this.gQf) {
                this.gPA.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bEq = this.gqm.bEq();
                if (bEq != null && bEq.getForum() != null) {
                    bEq.getForum().setUser_level(i);
                }
                this.gPG.setText(this.cVi.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.gPA.setText(this.gPU);
                this.gPG.setText(this.cVi.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.glk.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sr(this.mLevel)));
            if (this.gQf) {
                if (f >= 1.0f) {
                    b(this.glk, this.gQh, f);
                } else {
                    c(this.glk, this.gQh, f);
                }
            } else {
                b(this.glk, this.gQh, f);
            }
            this.gQh = f;
        }
    }

    private int[] sr(int i) {
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
    protected void bGW() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGX() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.am.setImageResource(this.gPO, R.drawable.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.am.setImageResource(this.gPO, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gPP != null && this.gPP.isShowing()) {
            this.gPP.dismiss();
        }
        if (this.gPK != null) {
            this.gPK.onDestroy();
        }
    }
}
