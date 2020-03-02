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
    private View eUX;
    private TextView gwc;
    private TextView gwd;
    private am gwf;
    private boolean gwg;
    private RelativeLayout gwi;
    private RelativeLayout mContainer;
    private String mImageUrl;
    private boolean gwh = false;
    private ArrayList<TbImageView> gwe = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.gpZ = frsFragment;
        this.cVh = frsFragment.getPageContext();
        this.gPj = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.gPk = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.gPl = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bGI();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.gPw = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.gKK = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.gPx = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.gPx.setPageId(this.gpZ.getUniqueId());
        this.gPx.setDefaultBgResource(R.color.transparent);
        this.gPx.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gPx.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.eUX = this.mParent.findViewById(R.id.header_top_cover);
        this.gwi = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.gPy = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.gPC = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.gwc = (TextView) this.mParent.findViewById(R.id.member_image);
        this.gwd = (TextView) this.mParent.findViewById(R.id.post_image);
        this.gPo = (TextView) this.mParent.findViewById(R.id.level_name);
        this.gPu = (TextView) this.mParent.findViewById(R.id.level);
        this.gLV = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.gLV.setText(frsFragment.getResources().getString(R.string.attention));
        this.gLV.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lt(R.color.cp_cont_b);
        this.gLV.setConfig(cVar);
        this.gMc = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.gMc.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lt(R.color.cp_cont_b);
        cVar2.lr(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.gMc.setConfig(cVar2);
        this.gMc.setText(frsFragment.getResources().getString(R.string.sign));
        this.gkX = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.gkY = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.gPm = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.gPn = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.gna = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.gPq = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.gPE = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.gPE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gPE.setPageId(this.gpZ.getUniqueId());
        this.gPE.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.gPE.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.gPE.setShowOval(true);
        this.gPE.setPlaceHolder(2);
        this.gPt = this.mParent.findViewById(R.id.level_container);
        this.gPs = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.gPr = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.gPv = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.gPz = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.gPp = LayoutInflater.from(this.gpZ.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.gPp.setVisibility(8);
        this.gPH = new com.baidu.tieba.frs.f.b(this.cVh);
    }

    protected View bGI() {
        return LayoutInflater.from(this.gpZ.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void y(View.OnClickListener onClickListener) {
        this.gPE.setOnClickListener(onClickListener);
        this.gna.setOnClickListener(onClickListener);
        this.gMc.setOnClickListener(onClickListener);
        this.gLV.setOnClickListener(onClickListener);
        this.gPt.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGJ() {
        this.gPq.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.cVh.getLayoutMode().setNightMode(i == 1);
        this.cVh.getLayoutMode().onModeChanged(this.mParent);
        this.cVh.getLayoutMode().onModeChanged(this.gPz);
        this.cVh.getLayoutMode().onModeChanged(this.gPp);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.gkX, R.drawable.frs_exp_progress);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gkY, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gPv, R.color.black_alpha0);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gna, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPu, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPo, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gwc, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPm, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gwd, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPn, (int) R.color.cp_cont_a);
        if (this.gPE != null) {
            this.gPE.setBorderWidth(l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds1));
            this.gPE.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_mask_b_alpha16));
            this.gPE.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gPE.setPlaceHolder(2);
            this.gPE.invalidate();
        }
        if (this.gPF != null) {
            this.gPF.onChangeSkin(i);
        }
        if (this.gKK != null) {
            this.gKK.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.gwe.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bGW();
        uG(this.gPS ? 1 : 0);
        bGN();
        tj(i);
        if (this.gPy != null) {
            this.gPy.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onPrimary(boolean z) {
        super.onPrimary(z);
        if (this.gPy != null) {
            this.gPy.onPrimary(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.gPM = forumData.getPost_num();
            this.gPJ = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.gPI = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.gPN = forumData.getSignData().count_sign_num;
                this.gPO = forumData.getSignData().miss_sign_num;
            }
            this.gPP = forumData.getCurScore();
            this.gMf = forumData.getLevelupScore();
            this.gPG = forumData.getBadgeData();
            this.gPK = forumData.getAccelerateContent();
            this.gPU = forumData.isBrandForum;
            this.gMJ = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.gPL = new bj();
            bGK();
            bGO();
        }
    }

    protected void bGK() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.gPL.aCy().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bGL() {
        if (this.gMs != null) {
            this.gMs.ui(this.gPO);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bGM() {
        if (this.gMs != null) {
            this.gMs.bGM();
        }
    }

    protected void bGN() {
        if (this.gMt != null) {
            this.gMt.bGN();
        }
    }

    protected void bGO() {
        if (this.gPm != null) {
            this.gPm.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.gPn != null) {
            this.gPn.setText(aq.numberUniformFormatExtra(this.gPM));
        }
        if (this.gPG != null && this.gPG.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.gPU) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.cVh.getString(R.string.forum);
        if (this.aCT != null) {
            this.aCT.setText(str);
        }
        if (this.gna != null) {
            this.gna.setText(str);
        }
        bGT();
        this.gwg = bGS();
        if (this.gwg) {
            this.gKK.setVisibility(8);
            this.eUX.setVisibility(0);
        } else {
            this.eUX.setVisibility(8);
            this.gKK.setVisibility(0);
            this.gPx.setOnClickListener(null);
        }
        bGR();
        tj(TbadkCoreApplication.getInst().getSkinType());
        P(this.gwg, bGQ());
    }

    private void P(boolean z, boolean z2) {
        e BL = d.bJV().BL(this.mForumName);
        if (BL == null) {
            BL = new e(this.gwh, z2);
        } else {
            BL.mb(this.gwh);
            BL.mc(z2);
        }
        d.bJV().a(this.mForumName, BL);
        Q(z, z2);
        R(z, z2);
    }

    private void Q(boolean z, boolean z2) {
        int dimens;
        if (this.gPw != null && this.gPw.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.cVh.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPv.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.cVh.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.cVh.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.gPv.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.gPw.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.gPw.setLayoutParams(layoutParams2);
            }
        }
    }

    private void R(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bGP = bGP();
        if (bGP != null) {
            bGP.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.gwi != null) {
            RelativeLayout relativeLayout = this.gwi;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bGP() {
        if (this.gpZ == null || this.gpZ.bDN() == null) {
            return null;
        }
        View bKT = this.gpZ.bDN().bKT();
        if (bKT instanceof LinearGradientView) {
            return (LinearGradientView) bKT;
        }
        return null;
    }

    private boolean bGQ() {
        return this.gPy != null && this.gPy.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGR() {
        if (this.gpZ != null && this.gMJ != null) {
            List<m> showTopThreadList = this.gMJ.getShowTopThreadList();
            this.gwh = showTopThreadList.size() > 2;
            a(showTopThreadList, this.gMJ.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.gPy != null) {
            if (this.gpZ != null && this.gpZ.bDW()) {
                this.gPy.setVisibility(0);
                this.gPy.setFragmentUniqueId(this.gpZ.getUniqueId());
                this.gPy.setForum(this.mForumId, this.mForumName, this.gMJ != null ? this.gMJ.getForum() : null);
                this.gPy.setDatas(list, hVar);
                if (this.gwf == null) {
                    this.gwf = new am() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.am
                        public void ak(bj bjVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.gpZ, b.this.gMJ, bjVar);
                        }
                    };
                }
                this.gPy.setStatListener(this.gwf);
                return;
            }
            this.gPy.setVisibility(8);
        }
    }

    private boolean bGS() {
        final t tVar;
        if (this.gMJ == null) {
            return false;
        }
        final FrsViewData frsViewData = this.gMJ;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cKp())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cKp());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aAx()) < 1) ? null : frsViewData.getActivityHeadData().aAx().get(0);
        }
        if (tVar != null) {
            if (this.gPx != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aAy())) {
                    an anVar = new an("c13326");
                    anVar.cy("fid", frsViewData.getForum().getId());
                    anVar.cy("obj_id", frsViewData.getActivityHeadData().aAy());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.cy("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).X("obj_floor", 1).cy("fid", frsViewData.getForum().getId()).cy("obj_id", frsViewData.getActivityHeadData().aAy()).X("obj_adlocate", 1).cy("first_dir", frsViewData.getForum().getFirst_class()).cy("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cy(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dlY);
                    }
                    com.baidu.tieba.s.c.cKa().a(this.gpZ.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aAy(), "", null), anVar2);
                }
                this.gPx.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.gPx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.cVh != null) {
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
                                        anVar3.cy(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dlY);
                                    }
                                    com.baidu.tieba.s.c.cKa().b(b.this.gpZ.getUniqueId(), anVar4);
                                }
                                ba.aGG().a(b.this.cVh, new String[]{tVar.getLinkUrl()}, true);
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
        if (this.gMJ != null && (forum = this.gMJ.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gwg) {
                LinearGradientView bGP = bGP();
                if (this.gKK != null && bGP != null) {
                    this.gKK.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bGP.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.gPx != null) {
                    this.gPx.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.gPy != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.gPy.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cG(str));
            }
        }
    }

    protected void bGT() {
        this.gPE.startLoad(this.mImageUrl, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.gQa);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.cVh.getPageActivity());
                this.mPopup.setContentView(this.gPz);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.gPA = (TextView) this.gPz.findViewById(R.id.cur_experience);
            this.gPB = (TextView) this.gPz.findViewById(R.id.levelup_experience);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.gPz.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) this.gPz.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gPA, R.color.common_color_10047, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gPB, R.color.cp_cont_g, 1);
            a(this.gPA, this.gPB);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.cVh.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.cVh.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.gQa, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.cVh.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.gPK) && !TextUtils.isEmpty(this.gPK.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.gPK);
            } else {
                textView3.setVisibility(8);
            }
            aVar.jX(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.cVh);
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
                if (b.this.cVh != null && b.this.cVh.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.cVh.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGU() {
        View contentView;
        if (this.gPD == null) {
            this.gPD = new PopupWindow(this.cVh.getPageActivity());
            View inflate = LayoutInflater.from(this.cVh.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.gPD.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.cVh != null && b.this.cVh.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.gPD, b.this.cVh.getPageActivity());
                        b.this.gpZ.gnZ = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.cVh.getPageActivity(), b.this.cVh.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.gPD.setWidth(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.gPD.setHeight(this.cVh.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.gPD.setBackgroundDrawable(new BitmapDrawable());
            this.gPD.setOutsideTouchable(true);
            this.gPD.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.gPD);
                        b.this.gpZ.gnZ = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.gPD.getContentView();
        }
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.gPC.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.gPD, this.mParent, 0, (iArr[0] - (this.gPD.getWidth() / 2)) + (this.gPC.getWidth() / 2), iArr[1] + this.gPC.getWidth());
        this.gPD.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.gPT = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.gPo != null && this.gkX != null && this.gPu != null && cashBitmap.getWidth() > 0) {
            if (this.gPT) {
                this.gPo.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bEp = this.gpZ.bEp();
                if (bEp != null && bEp.getForum() != null) {
                    bEp.getForum().setUser_level(i);
                }
                this.gPu.setText(this.cVh.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.gPo.setText(this.gPI);
                this.gPu.setText(this.cVh.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.gkX.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sr(this.mLevel)));
            if (this.gPT) {
                if (f >= 1.0f) {
                    b(this.gkX, this.gPV, f);
                } else {
                    c(this.gkX, this.gPV, f);
                }
            } else {
                b(this.gkX, this.gPV, f);
            }
            this.gPV = f;
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
    protected void bGV() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGW() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.am.setImageResource(this.gPC, R.drawable.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.am.setImageResource(this.gPC, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gPD != null && this.gPD.isShowing()) {
            this.gPD.dismiss();
        }
        if (this.gPy != null) {
            this.gPy.onDestroy();
        }
    }
}
