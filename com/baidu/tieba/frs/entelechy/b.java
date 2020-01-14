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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private View eRf;
    private TextView gtZ;
    private TextView gua;
    private am guc;
    private boolean gud;
    private RelativeLayout guf;
    private RelativeLayout mContainer;
    private String mImageUrl;
    private boolean gue = false;
    private ArrayList<TbImageView> gub = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.gnW = frsFragment;
        this.cRe = frsFragment.getPageContext();
        this.gNh = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.gNi = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.gNj = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bFe();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.gNu = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.gIJ = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.gNv = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.gNv.setPageId(this.gnW.getUniqueId());
        this.gNv.setDefaultBgResource(R.color.transparent);
        this.gNv.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gNv.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.eRf = this.mParent.findViewById(R.id.header_top_cover);
        this.guf = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.gNw = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.gNA = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.gtZ = (TextView) this.mParent.findViewById(R.id.member_image);
        this.gua = (TextView) this.mParent.findViewById(R.id.post_image);
        this.gNm = (TextView) this.mParent.findViewById(R.id.level_name);
        this.gNs = (TextView) this.mParent.findViewById(R.id.level);
        this.gJU = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.gJU.setText(frsFragment.getResources().getString(R.string.attention));
        this.gJU.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lc(R.color.cp_cont_b);
        this.gJU.setConfig(cVar);
        this.gKb = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.gKb.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lc(R.color.cp_cont_b);
        cVar2.la(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.j(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.gKb.setConfig(cVar2);
        this.gKb.setText(frsFragment.getResources().getString(R.string.sign));
        this.giU = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.giV = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.gNk = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.gNl = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.gkX = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.gNo = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.gNC = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.gNC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gNC.setPageId(this.gnW.getUniqueId());
        this.gNC.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.gNC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.gNC.setShowOval(true);
        this.gNC.setPlaceHolder(2);
        this.gNr = this.mParent.findViewById(R.id.level_container);
        this.gNq = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.gNp = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.gNt = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.gNx = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.gNn = LayoutInflater.from(this.gnW.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.gNn.setVisibility(8);
        this.gNF = new com.baidu.tieba.frs.f.b(this.cRe);
    }

    protected View bFe() {
        return LayoutInflater.from(this.gnW.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void x(View.OnClickListener onClickListener) {
        this.gNC.setOnClickListener(onClickListener);
        this.gkX.setOnClickListener(onClickListener);
        this.gKb.setOnClickListener(onClickListener);
        this.gJU.setOnClickListener(onClickListener);
        this.gNr.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bFf() {
        this.gNo.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.cRe.getLayoutMode().setNightMode(i == 1);
        this.cRe.getLayoutMode().onModeChanged(this.mParent);
        this.cRe.getLayoutMode().onModeChanged(this.gNx);
        this.cRe.getLayoutMode().onModeChanged(this.gNn);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.giU, R.drawable.frs_exp_progress);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.giV, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gNt, R.color.black_alpha0);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gkX, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gNs, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gNm, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gtZ, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gNk, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gua, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gNl, (int) R.color.cp_cont_a);
        if (this.gNC != null) {
            this.gNC.setBorderWidth(l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds1));
            this.gNC.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_mask_b_alpha16));
            this.gNC.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gNC.setPlaceHolder(2);
            this.gNC.invalidate();
        }
        if (this.gND != null) {
            this.gND.onChangeSkin(i);
        }
        if (this.gIJ != null) {
            this.gIJ.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.gub.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bFs();
        uA(this.gNQ ? 1 : 0);
        bFj();
        td(i);
        if (this.gNw != null) {
            this.gNw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void lg(boolean z) {
        super.lg(z);
        if (this.gNw != null) {
            this.gNw.lg(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.gNK = forumData.getPost_num();
            this.gNH = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.gNG = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.gNL = forumData.getSignData().count_sign_num;
                this.gNM = forumData.getSignData().miss_sign_num;
            }
            this.gNN = forumData.getCurScore();
            this.gKe = forumData.getLevelupScore();
            this.gNE = forumData.getBadgeData();
            this.gNI = forumData.getAccelerateContent();
            this.gNS = forumData.isBrandForum;
            this.gKI = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.gNJ = new bj();
            bFg();
            bFk();
        }
    }

    protected void bFg() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.gNJ.aAh().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bFh() {
        if (this.gKr != null) {
            this.gKr.uc(this.gNM);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bFi() {
        if (this.gKr != null) {
            this.gKr.bFi();
        }
    }

    protected void bFj() {
        if (this.gKs != null) {
            this.gKs.bFj();
        }
    }

    protected void bFk() {
        if (this.gNk != null) {
            this.gNk.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.gNl != null) {
            this.gNl.setText(aq.numberUniformFormatExtra(this.gNK));
        }
        if (this.gNE != null && this.gNE.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.gNS) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.cRe.getString(R.string.forum);
        if (this.ayC != null) {
            this.ayC.setText(str);
        }
        if (this.gkX != null) {
            this.gkX.setText(str);
        }
        bFp();
        this.gud = bFo();
        if (this.gud) {
            this.gIJ.setVisibility(8);
            this.eRf.setVisibility(0);
        } else {
            this.eRf.setVisibility(8);
            this.gIJ.setVisibility(0);
            this.gNv.setOnClickListener(null);
        }
        bFn();
        td(TbadkCoreApplication.getInst().getSkinType());
        N(this.gud, bFm());
    }

    private void N(boolean z, boolean z2) {
        e Bv = d.bIr().Bv(this.mForumName);
        if (Bv == null) {
            Bv = new e(this.gue, z2);
        } else {
            Bv.lZ(this.gue);
            Bv.ma(z2);
        }
        d.bIr().a(this.mForumName, Bv);
        O(z, z2);
        P(z, z2);
    }

    private void O(boolean z, boolean z2) {
        int dimens;
        if (this.gNu != null && this.gNu.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.cRe.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gNt.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.cRe.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.cRe.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.gNt.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.gNu.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.gNu.setLayoutParams(layoutParams2);
            }
        }
    }

    private void P(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bFl = bFl();
        if (bFl != null) {
            bFl.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.guf != null) {
            RelativeLayout relativeLayout = this.guf;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bFl() {
        if (this.gnW == null || this.gnW.bCi() == null) {
            return null;
        }
        View bJq = this.gnW.bCi().bJq();
        if (bJq instanceof LinearGradientView) {
            return (LinearGradientView) bJq;
        }
        return null;
    }

    private boolean bFm() {
        return this.gNw != null && this.gNw.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bFn() {
        if (this.gnW != null && this.gKI != null) {
            List<m> showTopThreadList = this.gKI.getShowTopThreadList();
            this.gue = showTopThreadList.size() > 2;
            a(showTopThreadList, this.gKI.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.gNw != null) {
            if (this.gnW != null && this.gnW.bCr()) {
                this.gNw.setVisibility(0);
                this.gNw.setFragmentUniqueId(this.gnW.getUniqueId());
                this.gNw.setForum(this.mForumId, this.mForumName, this.gKI != null ? this.gKI.getForum() : null);
                this.gNw.setDatas(list, hVar);
                if (this.guc == null) {
                    this.guc = new am() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.am
                        public void aj(bj bjVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.gnW, b.this.gKI, bjVar);
                        }
                    };
                }
                this.gNw.setStatListener(this.guc);
                return;
            }
            this.gNw.setVisibility(8);
        }
    }

    private boolean bFo() {
        final t tVar;
        if (this.gKI == null) {
            return false;
        }
        final FrsViewData frsViewData = this.gKI;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cIJ())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cIJ());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().ayh()) < 1) ? null : frsViewData.getActivityHeadData().ayh().get(0);
        }
        if (tVar != null) {
            if (this.gNv != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().ayi())) {
                    an anVar = new an("c13326");
                    anVar.cp("fid", frsViewData.getForum().getId());
                    anVar.cp("obj_id", frsViewData.getActivityHeadData().ayi());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.cp("page_type", PageStayDurationConstants.PageName.FRS).Z("obj_isad", 1).Z("obj_floor", 1).cp("fid", frsViewData.getForum().getId()).cp("obj_id", frsViewData.getActivityHeadData().ayi()).Z("obj_adlocate", 1).cp("first_dir", frsViewData.getForum().getFirst_class()).cp("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhR);
                    }
                    com.baidu.tieba.r.c.cIu().a(this.gnW.getUniqueId(), com.baidu.tieba.r.a.a("", frsViewData.getActivityHeadData().ayi(), "", null), anVar2);
                }
                this.gNv.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.gNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.cRe != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().ayi())) {
                                    String id = frsViewData.getForum().getId();
                                    String ayi = frsViewData.getActivityHeadData().ayi();
                                    an anVar3 = new an("c13330");
                                    anVar3.cp("fid", id);
                                    anVar3.cp("obj_id", ayi);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.cp("page_type", PageStayDurationConstants.PageName.FRS).Z("obj_isad", 1).cp("fid", id).cp("obj_id", ayi).Z("obj_adlocate", 1).Z("obj_floor", 1).cp("first_dir", frsViewData.getForum().getFirst_class()).cp("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhR);
                                    }
                                    com.baidu.tieba.r.c.cIu().b(b.this.gnW.getUniqueId(), anVar4);
                                }
                                ba.aEt().a(b.this.cRe, new String[]{tVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void td(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gKI != null && (forum = this.gKI.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gud) {
                LinearGradientView bFl = bFl();
                if (this.gIJ != null && bFl != null) {
                    this.gIJ.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bFl.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.gNv != null) {
                    this.gNv.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.gNw != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.gNw.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cy(str));
            }
        }
    }

    protected void bFp() {
        this.gNC.startLoad(this.mImageUrl, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.gNY);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.cRe.getPageActivity());
                this.mPopup.setContentView(this.gNx);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.cRe.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.cRe.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.gNy = (TextView) this.gNx.findViewById(R.id.cur_experience);
            this.gNz = (TextView) this.gNx.findViewById(R.id.levelup_experience);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.gNx.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) this.gNx.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gNy, R.color.common_color_10047, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gNz, R.color.cp_cont_g, 1);
            a(this.gNy, this.gNz);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.cRe.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.cRe.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.gNY, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.cRe.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.gNI) && !TextUtils.isEmpty(this.gNI.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.gNI);
            } else {
                textView3.setVisibility(8);
            }
            aVar.jG(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.cRe);
            aVar.aCp();
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
                if (b.this.cRe != null && b.this.cRe.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.cRe.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bFq() {
        View contentView;
        if (this.gNB == null) {
            this.gNB = new PopupWindow(this.cRe.getPageActivity());
            View inflate = LayoutInflater.from(this.cRe.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.gNB.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.cRe != null && b.this.cRe.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.gNB, b.this.cRe.getPageActivity());
                        b.this.gnW.glW = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.cRe.getPageActivity(), b.this.cRe.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.gNB.setWidth(this.cRe.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.gNB.setHeight(this.cRe.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.gNB.setBackgroundDrawable(new BitmapDrawable());
            this.gNB.setOutsideTouchable(true);
            this.gNB.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.gNB);
                        b.this.gnW.glW = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.gNB.getContentView();
        }
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.gNA.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.gNB, this.mParent, 0, (iArr[0] - (this.gNB.getWidth() / 2)) + (this.gNA.getWidth() / 2), iArr[1] + this.gNA.getWidth());
        this.gNB.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.gNR = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.gNm != null && this.giU != null && this.gNs != null && cashBitmap.getWidth() > 0) {
            if (this.gNR) {
                this.gNm.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bCK = this.gnW.bCK();
                if (bCK != null && bCK.getForum() != null) {
                    bCK.getForum().setUser_level(i);
                }
                this.gNs.setText(this.cRe.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.gNm.setText(this.gNG);
                this.gNs.setText(this.cRe.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.giU.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sl(this.mLevel)));
            if (this.gNR) {
                if (f >= 1.0f) {
                    a(this.gnW.getBaseFragmentActivity(), this.giU, this.gNT, f);
                } else {
                    b(this.gnW.getBaseFragmentActivity(), this.giU, this.gNT, f);
                }
            } else {
                a(this.gnW.getBaseFragmentActivity(), this.giU, this.gNT, f);
            }
            this.gNT = f;
        }
    }

    private int[] sl(int i) {
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
    protected void bFr() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bFs() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.am.setImageResource(this.gNA, R.drawable.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.am.setImageResource(this.gNA, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gNB != null && this.gNB.isShowing()) {
            this.gNB.dismiss();
        }
        if (this.gNw != null) {
            this.gNw.onDestroy();
        }
    }
}
