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
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private View ePG;
    private TextView gqQ;
    private TextView gqR;
    private am gqT;
    private boolean gqU;
    private RelativeLayout gqW;
    private RelativeLayout mContainer;
    private String mImageUrl;
    private boolean gqV = false;
    private ArrayList<TbImageView> gqS = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.gkN = frsFragment;
        this.cQU = frsFragment.getPageContext();
        this.gJU = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.gJV = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.gJW = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bEc();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.gKh = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.gFu = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.gKi = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.gKi.setPageId(this.gkN.getUniqueId());
        this.gKi.setDefaultBgResource(R.color.transparent);
        this.gKi.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gKi.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.ePG = this.mParent.findViewById(R.id.header_top_cover);
        this.gqW = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.gKj = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.gKn = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.gqQ = (TextView) this.mParent.findViewById(R.id.member_image);
        this.gqR = (TextView) this.mParent.findViewById(R.id.post_image);
        this.gJZ = (TextView) this.mParent.findViewById(R.id.level_name);
        this.gKf = (TextView) this.mParent.findViewById(R.id.level);
        this.gGF = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.gGF.setText(frsFragment.getResources().getString(R.string.attention));
        this.gGF.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lc(R.color.cp_cont_b);
        this.gGF.setConfig(cVar);
        this.gGM = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.gGM.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lc(R.color.cp_cont_b);
        cVar2.la(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.j(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.gGM.setConfig(cVar2);
        this.gGM.setText(frsFragment.getResources().getString(R.string.sign));
        this.gfK = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.gfL = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.gJX = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.gJY = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.ghN = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.gKb = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.gKp = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.gKp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gKp.setPageId(this.gkN.getUniqueId());
        this.gKp.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.gKp.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.gKp.setShowOval(true);
        this.gKp.setPlaceHolder(2);
        this.gKe = this.mParent.findViewById(R.id.level_container);
        this.gKd = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.gKc = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.gKg = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.gKk = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.gKa = LayoutInflater.from(this.gkN.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.gKa.setVisibility(8);
        this.gKs = new com.baidu.tieba.frs.f.b(this.cQU);
    }

    protected View bEc() {
        return LayoutInflater.from(this.gkN.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void y(View.OnClickListener onClickListener) {
        this.gKp.setOnClickListener(onClickListener);
        this.ghN.setOnClickListener(onClickListener);
        this.gGM.setOnClickListener(onClickListener);
        this.gGF.setOnClickListener(onClickListener);
        this.gKe.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bEd() {
        this.gKb.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.cQU.getLayoutMode().setNightMode(i == 1);
        this.cQU.getLayoutMode().onModeChanged(this.mParent);
        this.cQU.getLayoutMode().onModeChanged(this.gKk);
        this.cQU.getLayoutMode().onModeChanged(this.gKa);
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.gfK, R.drawable.frs_exp_progress);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gfL, R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gKg, R.color.black_alpha0);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.ghN, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gKf, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gJZ, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gqQ, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gJX, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gqR, (int) R.color.cp_cont_a);
        com.baidu.tbadk.core.util.am.setViewTextColor(this.gJY, (int) R.color.cp_cont_a);
        if (this.gKp != null) {
            this.gKp.setBorderWidth(l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds1));
            this.gKp.setBorderColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_mask_b_alpha16));
            this.gKp.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gKp.setPlaceHolder(2);
            this.gKp.invalidate();
        }
        if (this.gKq != null) {
            this.gKq.onChangeSkin(i);
        }
        if (this.gFu != null) {
            this.gFu.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.gqS.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bEq();
        uv(this.gKD ? 1 : 0);
        bEh();
        sY(i);
        if (this.gKj != null) {
            this.gKj.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void kV(boolean z) {
        super.kV(z);
        if (this.gKj != null) {
            this.gKj.kV(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.gKx = forumData.getPost_num();
            this.gKu = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.gKt = forumData.getLevelName();
            this.azk = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.gKy = forumData.getSignData().count_sign_num;
                this.gKz = forumData.getSignData().miss_sign_num;
            }
            this.gKA = forumData.getCurScore();
            this.gGP = forumData.getLevelupScore();
            this.gKr = forumData.getBadgeData();
            this.gKv = forumData.getAccelerateContent();
            this.gKF = forumData.isBrandForum;
            this.gHv = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.gKw = new bj();
            bEe();
            bEi();
        }
    }

    protected void bEe() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.gKw.azO().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bEf() {
        if (this.gHc != null) {
            this.gHc.tX(this.gKz);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bEg() {
        if (this.gHc != null) {
            this.gHc.bEg();
        }
    }

    protected void bEh() {
        if (this.gHd != null) {
            this.gHd.bEh();
        }
    }

    protected void bEi() {
        if (this.gJX != null) {
            this.gJX.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.gJY != null) {
            this.gJY.setText(aq.numberUniformFormatExtra(this.gKx));
        }
        if (this.gKr != null && this.gKr.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.gKF) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.cQU.getString(R.string.forum);
        if (this.axT != null) {
            this.axT.setText(str);
        }
        if (this.ghN != null) {
            this.ghN.setText(str);
        }
        bEn();
        this.gqU = bEm();
        if (this.gqU) {
            this.gFu.setVisibility(8);
            this.ePG.setVisibility(0);
        } else {
            this.ePG.setVisibility(8);
            this.gFu.setVisibility(0);
            this.gKi.setOnClickListener(null);
        }
        bEl();
        sY(TbadkCoreApplication.getInst().getSkinType());
        N(this.gqU, bEk());
    }

    private void N(boolean z, boolean z2) {
        e Bl = d.bHp().Bl(this.mForumName);
        if (Bl == null) {
            Bl = new e(this.gqV, z2);
        } else {
            Bl.lO(this.gqV);
            Bl.lP(z2);
        }
        d.bHp().a(this.mForumName, Bl);
        O(z, z2);
        P(z, z2);
    }

    private void O(boolean z, boolean z2) {
        int dimens;
        if (this.gKh != null && this.gKh.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.cQU.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKg.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.cQU.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.cQU.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.gKg.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.gKh.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.gKh.setLayoutParams(layoutParams2);
            }
        }
    }

    private void P(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bEj = bEj();
        if (bEj != null) {
            bEj.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.gqW != null) {
            RelativeLayout relativeLayout = this.gqW;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bEj() {
        if (this.gkN == null || this.gkN.bBg() == null) {
            return null;
        }
        View bIo = this.gkN.bBg().bIo();
        if (bIo instanceof LinearGradientView) {
            return (LinearGradientView) bIo;
        }
        return null;
    }

    private boolean bEk() {
        return this.gKj != null && this.gKj.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bEl() {
        if (this.gkN != null && this.gHv != null) {
            List<m> showTopThreadList = this.gHv.getShowTopThreadList();
            this.gqV = showTopThreadList.size() > 2;
            a(showTopThreadList, this.gHv.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.gKj != null) {
            if (this.gkN != null && this.gkN.bBp()) {
                this.gKj.setVisibility(0);
                this.gKj.setFragmentUniqueId(this.gkN.getUniqueId());
                this.gKj.setForum(this.mForumId, this.mForumName, this.gHv != null ? this.gHv.getForum() : null);
                this.gKj.setDatas(list, hVar);
                if (this.gqT == null) {
                    this.gqT = new am() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.am
                        public void ai(bj bjVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.gkN, b.this.gHv, bjVar);
                        }
                    };
                }
                this.gKj.setStatListener(this.gqT);
                return;
            }
            this.gKj.setVisibility(8);
        }
    }

    private boolean bEm() {
        final t tVar;
        if (this.gHv == null) {
            return false;
        }
        final FrsViewData frsViewData = this.gHv;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cHD())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cHD());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().axO()) < 1) ? null : frsViewData.getActivityHeadData().axO().get(0);
        }
        if (tVar != null) {
            if (this.gKi != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().axP())) {
                    an anVar = new an("c13326");
                    anVar.cp("fid", frsViewData.getForum().getId());
                    anVar.cp("obj_id", frsViewData.getActivityHeadData().axP());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.cp("page_type", PageStayDurationConstants.PageName.FRS).Z("obj_isad", 1).Z("obj_floor", 1).cp("fid", frsViewData.getForum().getId()).cp("obj_id", frsViewData.getActivityHeadData().axP()).Z("obj_adlocate", 1).cp("first_dir", frsViewData.getForum().getFirst_class()).cp("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhF);
                    }
                    com.baidu.tieba.r.c.cHo().a(this.gkN.getUniqueId(), com.baidu.tieba.r.a.a("", frsViewData.getActivityHeadData().axP(), "", null), anVar2);
                }
                this.gKi.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.gKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.cQU != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().axP())) {
                                    String id = frsViewData.getForum().getId();
                                    String axP = frsViewData.getActivityHeadData().axP();
                                    an anVar3 = new an("c13330");
                                    anVar3.cp("fid", id);
                                    anVar3.cp("obj_id", axP);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.cp("page_type", PageStayDurationConstants.PageName.FRS).Z("obj_isad", 1).cp("fid", id).cp("obj_id", axP).Z("obj_adlocate", 1).Z("obj_floor", 1).cp("first_dir", frsViewData.getForum().getFirst_class()).cp("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhF);
                                    }
                                    com.baidu.tieba.r.c.cHo().b(b.this.gkN.getUniqueId(), anVar4);
                                }
                                ba.aEa().a(b.this.cQU, new String[]{tVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void sY(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gHv != null && (forum = this.gHv.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gqU) {
                LinearGradientView bEj = bEj();
                if (this.gFu != null && bEj != null) {
                    this.gFu.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bEj.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.gKi != null) {
                    this.gKi.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.gKj != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.gKj.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cy(str));
            }
        }
    }

    protected void bEn() {
        this.gKp.startLoad(this.mImageUrl, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.gKL);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.cQU.getPageActivity());
                this.mPopup.setContentView(this.gKk);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.cQU.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.cQU.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.gKl = (TextView) this.gKk.findViewById(R.id.cur_experience);
            this.gKm = (TextView) this.gKk.findViewById(R.id.levelup_experience);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.gKk.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) this.gKk.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gKl, R.color.common_color_10047, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gKm, R.color.cp_cont_g, 1);
            a(this.gKl, this.gKm);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.cQU.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.cQU.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.gKL, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.cQU.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            com.baidu.tbadk.core.util.am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
            aVar.aK(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.gKv) && !TextUtils.isEmpty(this.gKv.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.gKv);
            } else {
                textView3.setVisibility(8);
            }
            aVar.jG(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.cQU);
            aVar.aBW();
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
                if (b.this.cQU != null && b.this.cQU.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.cQU.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bEo() {
        View contentView;
        if (this.gKo == null) {
            this.gKo = new PopupWindow(this.cQU.getPageActivity());
            View inflate = LayoutInflater.from(this.cQU.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.gKo.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.cQU != null && b.this.cQU.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.gKo, b.this.cQU.getPageActivity());
                        b.this.gkN.giN = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.cQU.getPageActivity(), b.this.cQU.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.gKo.setWidth(this.cQU.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.gKo.setHeight(this.cQU.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.gKo.setBackgroundDrawable(new BitmapDrawable());
            this.gKo.setOutsideTouchable(true);
            this.gKo.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.gKo);
                        b.this.gkN.giN = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.gKo.getContentView();
        }
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.gKn.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.gKo, this.mParent, 0, (iArr[0] - (this.gKo.getWidth() / 2)) + (this.gKn.getWidth() / 2), iArr[1] + this.gKn.getWidth());
        this.gKo.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.gKE = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.gJZ != null && this.gfK != null && this.gKf != null && cashBitmap.getWidth() > 0) {
            if (this.gKE) {
                this.gJZ.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.azk;
                } else {
                    i = this.azk + 1;
                }
                FrsViewData bBI = this.gkN.bBI();
                if (bBI != null && bBI.getForum() != null) {
                    bBI.getForum().setUser_level(i);
                }
                this.gKf.setText(this.cQU.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.gJZ.setText(this.gKt);
                this.gKf.setText(this.cQU.getResources().getString(R.string.lv_num, Integer.valueOf(this.azk)));
            }
            this.gfK.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, sg(this.azk)));
            if (this.gKE) {
                if (f >= 1.0f) {
                    a(this.gkN.getBaseFragmentActivity(), this.gfK, this.gKG, f);
                } else {
                    b(this.gkN.getBaseFragmentActivity(), this.gfK, this.gKG, f);
                }
            } else {
                a(this.gkN.getBaseFragmentActivity(), this.gfK, this.gKG, f);
            }
            this.gKG = f;
        }
    }

    private int[] sg(int i) {
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
    protected void bEp() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bEq() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.am.setImageResource(this.gKn, R.drawable.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.am.setImageResource(this.gKn, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gKo != null && this.gKo.isShowing()) {
            this.gKo.dismiss();
        }
        if (this.gKj != null) {
            this.gKj.onDestroy();
        }
    }
}
