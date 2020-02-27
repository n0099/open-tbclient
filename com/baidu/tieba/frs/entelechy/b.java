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
    private View eUW;
    private TextView gwa;
    private TextView gwb;
    private am gwd;
    private boolean gwe;
    private RelativeLayout gwg;
    private RelativeLayout mContainer;
    private String mImageUrl;
    private boolean gwf = false;
    private ArrayList<TbImageView> gwc = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.gpX = frsFragment;
        this.cVg = frsFragment.getPageContext();
        this.gPh = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.gPi = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.gPj = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bGG();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.gPu = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.gKI = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.gPv = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.gPv.setPageId(this.gpX.getUniqueId());
        this.gPv.setDefaultBgResource(R.color.transparent);
        this.gPv.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gPv.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.eUW = this.mParent.findViewById(R.id.header_top_cover);
        this.gwg = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.gPw = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.gPA = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.gwa = (TextView) this.mParent.findViewById(R.id.member_image);
        this.gwb = (TextView) this.mParent.findViewById(R.id.post_image);
        this.gPm = (TextView) this.mParent.findViewById(R.id.level_name);
        this.gPs = (TextView) this.mParent.findViewById(R.id.level);
        this.gLT = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.gLT.setText(frsFragment.getResources().getString(R.string.attention));
        this.gLT.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lt(R.color.cp_cont_b);
        this.gLT.setConfig(cVar);
        this.gMa = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.gMa.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lt(R.color.cp_cont_b);
        cVar2.lr(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.gMa.setConfig(cVar2);
        this.gMa.setText(frsFragment.getResources().getString(R.string.sign));
        this.gkV = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.gkW = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.gPk = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.gPl = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.gmY = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.gPo = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.gPC = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.gPC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gPC.setPageId(this.gpX.getUniqueId());
        this.gPC.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.gPC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.gPC.setShowOval(true);
        this.gPC.setPlaceHolder(2);
        this.gPr = this.mParent.findViewById(R.id.level_container);
        this.gPq = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.gPp = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.gPt = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.gPx = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.gPn = LayoutInflater.from(this.gpX.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.gPn.setVisibility(8);
        this.gPF = new com.baidu.tieba.frs.f.b(this.cVg);
    }

    protected View bGG() {
        return LayoutInflater.from(this.gpX.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void y(View.OnClickListener onClickListener) {
        this.gPC.setOnClickListener(onClickListener);
        this.gmY.setOnClickListener(onClickListener);
        this.gMa.setOnClickListener(onClickListener);
        this.gLT.setOnClickListener(onClickListener);
        this.gPr.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGH() {
        this.gPo.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.cVg.getLayoutMode().setNightMode(i == 1);
        this.cVg.getLayoutMode().onModeChanged(this.mParent);
        this.cVg.getLayoutMode().onModeChanged(this.gPx);
        this.cVg.getLayoutMode().onModeChanged(this.gPn);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.gkV, R.drawable.frs_exp_progress);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gkW, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gPt, R.color.black_alpha0);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gmY, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPs, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPm, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gwa, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPk, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gwb, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gPl, (int) R.color.cp_cont_a);
        if (this.gPC != null) {
            this.gPC.setBorderWidth(l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds1));
            this.gPC.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_mask_b_alpha16));
            this.gPC.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gPC.setPlaceHolder(2);
            this.gPC.invalidate();
        }
        if (this.gPD != null) {
            this.gPD.onChangeSkin(i);
        }
        if (this.gKI != null) {
            this.gKI.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.gwc.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bGU();
        uG(this.gPQ ? 1 : 0);
        bGL();
        tj(i);
        if (this.gPw != null) {
            this.gPw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onPrimary(boolean z) {
        super.onPrimary(z);
        if (this.gPw != null) {
            this.gPw.onPrimary(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.gPK = forumData.getPost_num();
            this.gPH = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.gPG = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.gPL = forumData.getSignData().count_sign_num;
                this.gPM = forumData.getSignData().miss_sign_num;
            }
            this.gPN = forumData.getCurScore();
            this.gMd = forumData.getLevelupScore();
            this.gPE = forumData.getBadgeData();
            this.gPI = forumData.getAccelerateContent();
            this.gPS = forumData.isBrandForum;
            this.gMH = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.gPJ = new bj();
            bGI();
            bGM();
        }
    }

    protected void bGI() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.gPJ.aCw().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bGJ() {
        if (this.gMq != null) {
            this.gMq.ui(this.gPM);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bGK() {
        if (this.gMq != null) {
            this.gMq.bGK();
        }
    }

    protected void bGL() {
        if (this.gMr != null) {
            this.gMr.bGL();
        }
    }

    protected void bGM() {
        if (this.gPk != null) {
            this.gPk.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.gPl != null) {
            this.gPl.setText(aq.numberUniformFormatExtra(this.gPK));
        }
        if (this.gPE != null && this.gPE.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.gPS) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.cVg.getString(R.string.forum);
        if (this.aCS != null) {
            this.aCS.setText(str);
        }
        if (this.gmY != null) {
            this.gmY.setText(str);
        }
        bGR();
        this.gwe = bGQ();
        if (this.gwe) {
            this.gKI.setVisibility(8);
            this.eUW.setVisibility(0);
        } else {
            this.eUW.setVisibility(8);
            this.gKI.setVisibility(0);
            this.gPv.setOnClickListener(null);
        }
        bGP();
        tj(TbadkCoreApplication.getInst().getSkinType());
        P(this.gwe, bGO());
    }

    private void P(boolean z, boolean z2) {
        e BL = d.bJT().BL(this.mForumName);
        if (BL == null) {
            BL = new e(this.gwf, z2);
        } else {
            BL.mb(this.gwf);
            BL.mc(z2);
        }
        d.bJT().a(this.mForumName, BL);
        Q(z, z2);
        R(z, z2);
    }

    private void Q(boolean z, boolean z2) {
        int dimens;
        if (this.gPu != null && this.gPu.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.cVg.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gPt.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.cVg.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.cVg.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.gPt.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.gPu.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.gPu.setLayoutParams(layoutParams2);
            }
        }
    }

    private void R(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bGN = bGN();
        if (bGN != null) {
            bGN.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.gwg != null) {
            RelativeLayout relativeLayout = this.gwg;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bGN() {
        if (this.gpX == null || this.gpX.bDL() == null) {
            return null;
        }
        View bKR = this.gpX.bDL().bKR();
        if (bKR instanceof LinearGradientView) {
            return (LinearGradientView) bKR;
        }
        return null;
    }

    private boolean bGO() {
        return this.gPw != null && this.gPw.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGP() {
        if (this.gpX != null && this.gMH != null) {
            List<m> showTopThreadList = this.gMH.getShowTopThreadList();
            this.gwf = showTopThreadList.size() > 2;
            a(showTopThreadList, this.gMH.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.gPw != null) {
            if (this.gpX != null && this.gpX.bDU()) {
                this.gPw.setVisibility(0);
                this.gPw.setFragmentUniqueId(this.gpX.getUniqueId());
                this.gPw.setForum(this.mForumId, this.mForumName, this.gMH != null ? this.gMH.getForum() : null);
                this.gPw.setDatas(list, hVar);
                if (this.gwd == null) {
                    this.gwd = new am() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.am
                        public void ak(bj bjVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.gpX, b.this.gMH, bjVar);
                        }
                    };
                }
                this.gPw.setStatListener(this.gwd);
                return;
            }
            this.gPw.setVisibility(8);
        }
    }

    private boolean bGQ() {
        final t tVar;
        if (this.gMH == null) {
            return false;
        }
        final FrsViewData frsViewData = this.gMH;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cKn())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cKn());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aAv()) < 1) ? null : frsViewData.getActivityHeadData().aAv().get(0);
        }
        if (tVar != null) {
            if (this.gPv != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aAw())) {
                    an anVar = new an("c13326");
                    anVar.cy("fid", frsViewData.getForum().getId());
                    anVar.cy("obj_id", frsViewData.getActivityHeadData().aAw());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.cy("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).X("obj_floor", 1).cy("fid", frsViewData.getForum().getId()).cy("obj_id", frsViewData.getActivityHeadData().aAw()).X("obj_adlocate", 1).cy("first_dir", frsViewData.getForum().getFirst_class()).cy("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cy(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dlX);
                    }
                    com.baidu.tieba.s.c.cJY().a(this.gpX.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aAw(), "", null), anVar2);
                }
                this.gPv.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.gPv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.cVg != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aAw())) {
                                    String id = frsViewData.getForum().getId();
                                    String aAw = frsViewData.getActivityHeadData().aAw();
                                    an anVar3 = new an("c13330");
                                    anVar3.cy("fid", id);
                                    anVar3.cy("obj_id", aAw);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.cy("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).cy("fid", id).cy("obj_id", aAw).X("obj_adlocate", 1).X("obj_floor", 1).cy("first_dir", frsViewData.getForum().getFirst_class()).cy("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.cy(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dlX);
                                    }
                                    com.baidu.tieba.s.c.cJY().b(b.this.gpX.getUniqueId(), anVar4);
                                }
                                ba.aGE().a(b.this.cVg, new String[]{tVar.getLinkUrl()}, true);
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
        if (this.gMH != null && (forum = this.gMH.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gwe) {
                LinearGradientView bGN = bGN();
                if (this.gKI != null && bGN != null) {
                    this.gKI.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bGN.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.gPv != null) {
                    this.gPv.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.gPw != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.gPw.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cG(str));
            }
        }
    }

    protected void bGR() {
        this.gPC.startLoad(this.mImageUrl, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.gPY);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.cVg.getPageActivity());
                this.mPopup.setContentView(this.gPx);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.cVg.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.cVg.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.gPy = (TextView) this.gPx.findViewById(R.id.cur_experience);
            this.gPz = (TextView) this.gPx.findViewById(R.id.levelup_experience);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.gPx.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) this.gPx.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gPy, R.color.common_color_10047, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gPz, R.color.cp_cont_g, 1);
            a(this.gPy, this.gPz);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.cVg.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.cVg.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.gPY, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.cVg.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.gPI) && !TextUtils.isEmpty(this.gPI.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.gPI);
            } else {
                textView3.setVisibility(8);
            }
            aVar.jX(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.cVg);
            aVar.aEA();
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
                if (b.this.cVg != null && b.this.cVg.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.cVg.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGS() {
        View contentView;
        if (this.gPB == null) {
            this.gPB = new PopupWindow(this.cVg.getPageActivity());
            View inflate = LayoutInflater.from(this.cVg.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.gPB.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.cVg != null && b.this.cVg.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.gPB, b.this.cVg.getPageActivity());
                        b.this.gpX.gnX = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.cVg.getPageActivity(), b.this.cVg.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.gPB.setWidth(this.cVg.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.gPB.setHeight(this.cVg.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.gPB.setBackgroundDrawable(new BitmapDrawable());
            this.gPB.setOutsideTouchable(true);
            this.gPB.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.gPB);
                        b.this.gpX.gnX = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.gPB.getContentView();
        }
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.gPA.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.gPB, this.mParent, 0, (iArr[0] - (this.gPB.getWidth() / 2)) + (this.gPA.getWidth() / 2), iArr[1] + this.gPA.getWidth());
        this.gPB.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.gPR = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.gPm != null && this.gkV != null && this.gPs != null && cashBitmap.getWidth() > 0) {
            if (this.gPR) {
                this.gPm.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bEn = this.gpX.bEn();
                if (bEn != null && bEn.getForum() != null) {
                    bEn.getForum().setUser_level(i);
                }
                this.gPs.setText(this.cVg.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.gPm.setText(this.gPG);
                this.gPs.setText(this.cVg.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.gkV.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sr(this.mLevel)));
            if (this.gPR) {
                if (f >= 1.0f) {
                    b(this.gkV, this.gPT, f);
                } else {
                    c(this.gkV, this.gPT, f);
                }
            } else {
                b(this.gkV, this.gPT, f);
            }
            this.gPT = f;
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
    protected void bGT() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGU() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.am.setImageResource(this.gPA, R.drawable.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.am.setImageResource(this.gPA, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gPB != null && this.gPB.isShowing()) {
            this.gPB.dismiss();
        }
        if (this.gPw != null) {
            this.gPw.onDestroy();
        }
    }
}
