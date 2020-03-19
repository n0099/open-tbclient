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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.e.d;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.frs.f.h;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private View eVI;
    private TextView gwX;
    private TextView gwY;
    private an gxa;
    private boolean gxb;
    private RelativeLayout gxd;
    private RelativeLayout mContainer;
    private String mImageUrl;
    private boolean gxc = false;
    private ArrayList<TbImageView> gwZ = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.gqW = frsFragment;
        this.cVv = frsFragment.getPageContext();
        this.gQC = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.gQD = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.gQE = l.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bGY();
        this.mContainer = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.gQP = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.gMb = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.gQQ = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.gQQ.setPageId(this.gqW.getUniqueId());
        this.gQQ.setDefaultBgResource(R.color.transparent);
        this.gQQ.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gQQ.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.eVI = this.mParent.findViewById(R.id.header_top_cover);
        this.gxd = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.gQR = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.gQV = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.gwX = (TextView) this.mParent.findViewById(R.id.member_image);
        this.gwY = (TextView) this.mParent.findViewById(R.id.post_image);
        this.gQH = (TextView) this.mParent.findViewById(R.id.level_name);
        this.gQN = (TextView) this.mParent.findViewById(R.id.level);
        this.gNm = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_love);
        this.gNm.setText(frsFragment.getResources().getString(R.string.attention));
        this.gNm.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lv(R.color.cp_cont_b);
        this.gNm.setConfig(cVar);
        this.gNt = (TBSpecificationBtn) this.mParent.findViewById(R.id.tv_sign);
        this.gNt.setTextSize(R.dimen.tbds34);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.lv(R.color.cp_cont_b);
        cVar2.lr(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        cVar2.k(R.drawable.icon_pure_frs_sign16_svg, 0, true);
        this.gNt.setConfig(cVar2);
        this.gNt.setText(frsFragment.getResources().getString(R.string.sign));
        this.glS = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.glT = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.gQF = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.gQG = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.gnW = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.gQJ = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.gQX = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.gQX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gQX.setPageId(this.gqW.getUniqueId());
        this.gQX.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.gQX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.gQX.setShowOval(true);
        this.gQX.setPlaceHolder(2);
        this.gQM = this.mParent.findViewById(R.id.level_container);
        this.gQL = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.gQK = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.gQO = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.gQS = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.gQI = LayoutInflater.from(this.gqW.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.gQI.setVisibility(8);
        this.gRa = new com.baidu.tieba.frs.f.b(this.cVv);
    }

    protected View bGY() {
        return LayoutInflater.from(this.gqW.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void y(View.OnClickListener onClickListener) {
        this.gQX.setOnClickListener(onClickListener);
        this.gnW.setOnClickListener(onClickListener);
        this.gNt.setOnClickListener(onClickListener);
        this.gNm.setOnClickListener(onClickListener);
        this.gQM.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bGZ() {
        this.gQJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.cVv.getLayoutMode().setNightMode(i == 1);
        this.cVv.getLayoutMode().onModeChanged(this.mParent);
        this.cVv.getLayoutMode().onModeChanged(this.gQS);
        this.cVv.getLayoutMode().onModeChanged(this.gQI);
        am.setBackgroundResource(this.glS, R.drawable.frs_exp_progress);
        am.setBackgroundColor(this.glT, R.color.cp_cont_a);
        am.setBackgroundColor(this.gQO, R.color.black_alpha0);
        am.setBackgroundColor(this.mContainer, R.color.cp_bg_line_c);
        am.setViewTextColor(this.gnW, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gQN, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gQH, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gwX, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gQF, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gwY, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gQG, (int) R.color.cp_cont_a);
        if (this.gQX != null) {
            this.gQX.setBorderWidth(l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds1));
            this.gQX.setBorderColor(am.getColor(R.color.cp_mask_b_alpha16));
            this.gQX.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gQX.setPlaceHolder(2);
            this.gQX.invalidate();
        }
        if (this.gQY != null) {
            this.gQY.onChangeSkin(i);
        }
        if (this.gMb != null) {
            this.gMb.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.gwZ.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bHm();
        uN(this.gRl ? 1 : 0);
        bHd();
        tn(i);
        if (this.gQR != null) {
            this.gQR.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onPrimary(boolean z) {
        super.onPrimary(z);
        if (this.gQR != null) {
            this.gQR.onPrimary(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.gRf = forumData.getPost_num();
            this.gRc = forumData.getTag_color();
            this.mImageUrl = forumData.getImage_url();
            this.gRb = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.gRg = forumData.getSignData().count_sign_num;
                this.gRh = forumData.getSignData().miss_sign_num;
            }
            this.gRi = forumData.getCurScore();
            this.gNw = forumData.getLevelupScore();
            this.gQZ = forumData.getBadgeData();
            this.gRd = forumData.getAccelerateContent();
            this.gRn = forumData.isBrandForum;
            this.gOa = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.gRe = new bj();
            bHa();
            bHe();
        }
    }

    protected void bHa() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.mImageUrl);
        this.gRe.aCB().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bHb() {
        if (this.gNJ != null) {
            this.gNJ.uo(this.gRh);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bHc() {
        if (this.gNJ != null) {
            this.gNJ.bHc();
        }
    }

    protected void bHd() {
        if (this.gNK != null) {
            this.gNK.bHd();
        }
    }

    protected void bHe() {
        if (this.gQF != null) {
            this.gQF.setText(aq.numberUniformFormatExtra(this.mMemberNum));
        }
        if (this.gQG != null) {
            this.gQG.setText(aq.numberUniformFormatExtra(this.gRf));
        }
        if (this.gQZ != null && this.gQZ.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.gRn) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.cVv.getString(R.string.forum);
        if (this.aDi != null) {
            this.aDi.setText(str);
        }
        if (this.gnW != null) {
            this.gnW.setText(str);
        }
        bHj();
        this.gxb = bHi();
        if (this.gxb) {
            this.gMb.setVisibility(8);
            this.eVI.setVisibility(0);
        } else {
            this.eVI.setVisibility(8);
            this.gMb.setVisibility(0);
            this.gQQ.setOnClickListener(null);
        }
        bHh();
        tn(TbadkCoreApplication.getInst().getSkinType());
        P(this.gxb, bHg());
    }

    private void P(boolean z, boolean z2) {
        e BM = d.bKj().BM(this.mForumName);
        if (BM == null) {
            BM = new e(this.gxc, z2);
        } else {
            BM.mh(this.gxc);
            BM.mi(z2);
        }
        d.bKj().a(this.mForumName, BM);
        Q(z, z2);
        R(z, z2);
    }

    private void Q(boolean z, boolean z2) {
        int dimens;
        if (this.gQP != null && this.gQP.getLayoutParams() != null) {
            if (z) {
                int equipmentWidth = (l.getEquipmentWidth(this.cVv.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gQO.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = equipmentWidth - this.cVv.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = equipmentWidth - this.cVv.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.gQO.setLayoutParams(layoutParams);
                }
                dimens = equipmentWidth;
            } else if (!z2) {
                dimens = l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds487);
            } else {
                dimens = l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.gQP.getLayoutParams();
            if (layoutParams2.height != dimens) {
                layoutParams2.height = dimens;
                this.gQP.setLayoutParams(layoutParams2);
            }
        }
    }

    private void R(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bHf = bHf();
        if (bHf != null) {
            bHf.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.gxd != null) {
            RelativeLayout relativeLayout = this.gxd;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bHf() {
        if (this.gqW == null || this.gqW.bDW() == null) {
            return null;
        }
        View bLh = this.gqW.bDW().bLh();
        if (bLh instanceof LinearGradientView) {
            return (LinearGradientView) bLh;
        }
        return null;
    }

    private boolean bHg() {
        return this.gQR != null && this.gQR.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bHh() {
        if (this.gqW != null && this.gOa != null) {
            List<m> showTopThreadList = this.gOa.getShowTopThreadList();
            this.gxc = showTopThreadList.size() > 2;
            a(showTopThreadList, this.gOa.getBusinessPromot());
        }
    }

    private void a(List<m> list, i iVar) {
        if (this.gQR != null) {
            if (this.gqW != null && this.gqW.bEf()) {
                this.gQR.setVisibility(0);
                this.gQR.setFragmentUniqueId(this.gqW.getUniqueId());
                this.gQR.setForum(this.mForumId, this.mForumName, this.gOa != null ? this.gOa.getForum() : null);
                this.gQR.setDatas(list, iVar);
                if (this.gxa == null) {
                    this.gxa = new an() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.an
                        public void al(bj bjVar) {
                            h.a(b.this.gqW, b.this.gOa, bjVar);
                        }
                    };
                }
                this.gQR.setStatListener(this.gxa);
                return;
            }
            this.gQR.setVisibility(8);
        }
    }

    private boolean bHi() {
        final t tVar;
        if (this.gOa == null) {
            return false;
        }
        final FrsViewData frsViewData = this.gOa;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cKK())) {
            tVar = new t();
            tVar.setLinkUrl("");
            tVar.setImageUrl(frsViewData.getStar().cKK());
        } else {
            tVar = (frsViewData.getActivityHeadData() == null || v.getCount(frsViewData.getActivityHeadData().aAA()) < 1) ? null : frsViewData.getActivityHeadData().aAA().get(0);
        }
        if (tVar != null) {
            if (this.gQQ != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aAB())) {
                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13326");
                    anVar.cx("fid", frsViewData.getForum().getId());
                    anVar.cx("obj_id", frsViewData.getActivityHeadData().aAB());
                    TiebaStatic.log(anVar);
                    com.baidu.tbadk.core.util.an anVar2 = new com.baidu.tbadk.core.util.an("common_exp");
                    anVar2.cx("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).X("obj_floor", 1).cx("fid", frsViewData.getForum().getId()).cx("obj_id", frsViewData.getActivityHeadData().aAB()).X("obj_adlocate", 1).cx("first_dir", frsViewData.getForum().getFirst_class()).cx("second_dir", frsViewData.getForum().getSecond_class());
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.cx(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dmy);
                    }
                    com.baidu.tieba.s.c.cKv().a(this.gqW.getUniqueId(), com.baidu.tieba.s.a.a("", frsViewData.getActivityHeadData().aAB(), "", null), anVar2);
                }
                this.gQQ.startLoad(tVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(tVar.getLinkUrl())) {
                    this.gQQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.cVv != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().aAB())) {
                                    String id = frsViewData.getForum().getId();
                                    String aAB = frsViewData.getActivityHeadData().aAB();
                                    com.baidu.tbadk.core.util.an anVar3 = new com.baidu.tbadk.core.util.an("c13330");
                                    anVar3.cx("fid", id);
                                    anVar3.cx("obj_id", aAB);
                                    TiebaStatic.log(anVar3);
                                    com.baidu.tbadk.core.util.an anVar4 = new com.baidu.tbadk.core.util.an("common_click");
                                    anVar4.cx("page_type", PageStayDurationConstants.PageName.FRS).X("obj_isad", 1).cx("fid", id).cx("obj_id", aAB).X("obj_adlocate", 1).X("obj_floor", 1).cx("first_dir", frsViewData.getForum().getFirst_class()).cx("second_dir", frsViewData.getForum().getSecond_class());
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.cx(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dmy);
                                    }
                                    com.baidu.tieba.s.c.cKv().b(b.this.gqW.getUniqueId(), anVar4);
                                }
                                ba.aGK().a(b.this.cVv, new String[]{tVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void tn(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gOa != null && (forum = this.gOa.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            if (i == 4) {
                themeElement = themeColorInfo.dark;
            } else if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gxb) {
                LinearGradientView bHf = bHf();
                if (this.gMb != null && bHf != null) {
                    this.gMb.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    bHf.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                }
                if (this.gQQ != null) {
                    this.gQQ.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.gQR != null) {
                String str = themeElement.font_color;
                if (TextUtils.isEmpty(str)) {
                    str = themeElement.common_color;
                }
                this.gQR.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cF(str));
            }
        }
    }

    protected void bHj() {
        this.gQX.startLoad(this.mImageUrl, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void i(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.gRt);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.cVv.getPageActivity());
                this.mPopup.setContentView(this.gQS);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.cVv.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.cVv.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.gQT = (TextView) this.gQS.findViewById(R.id.cur_experience);
            this.gQU = (TextView) this.gQS.findViewById(R.id.levelup_experience);
            am.setBackgroundResource(this.gQS.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.setViewTextColor((TextView) this.gQS.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.setViewTextColor(this.gQT, R.color.common_color_10047, 1);
            am.setViewTextColor(this.gQU, R.color.cp_cont_g, 1);
            a(this.gQT, this.gQU);
            if (this.mPopup.isShowing()) {
                g.dismissPopupWindow(this.mPopup, this.cVv.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.dismissPopupWindow(this.mPopup, this.cVv.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.gRt, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.cVv.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            am.setViewTextColor(textView, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
            am.setViewTextColor(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
            aVar.aO(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.gRd) && !TextUtils.isEmpty(this.gRd.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.gRd);
            } else {
                textView3.setVisibility(8);
            }
            aVar.jX(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.cVv);
            aVar.aEG();
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
                if (b.this.cVv != null && b.this.cVv.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.cVv.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bHk() {
        View contentView;
        if (this.gQW == null) {
            this.gQW = new PopupWindow(this.cVv.getPageActivity());
            View inflate = LayoutInflater.from(this.cVv.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.gQW.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.cVv != null && b.this.cVv.getPageActivity() != null) {
                        g.dismissPopupWindow(b.this.gQW, b.this.cVv.getPageActivity());
                        b.this.gqW.goW = false;
                        com.baidu.tbadk.browser.a.startWebActivity(b.this.cVv.getPageActivity(), b.this.cVv.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.SPEED_EXPERIENCE + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.gQW.setWidth(this.cVv.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.gQW.setHeight(this.cVv.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.gQW.setBackgroundDrawable(new BitmapDrawable());
            this.gQW.setOutsideTouchable(true);
            this.gQW.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.dismissPopupWindow(b.this.gQW);
                        b.this.gqW.goW = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.gQW.getContentView();
        }
        am.setViewTextColor((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.setViewTextColor((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.gQV.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.gQW, this.mParent, 0, (iArr[0] - (this.gQW.getWidth() / 2)) + (this.gQV.getWidth() / 2), iArr[1] + this.gQV.getWidth());
        this.gQW.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void c(boolean z, float f) {
        int i;
        this.gRm = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.gQH != null && this.glS != null && this.gQN != null && cashBitmap.getWidth() > 0) {
            if (this.gRm) {
                this.gQH.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bEz = this.gqW.bEz();
                if (bEz != null && bEz.getForum() != null) {
                    bEz.getForum().setUser_level(i);
                }
                this.gQN.setText(this.cVv.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.gQH.setText(this.gRb);
                this.gQN.setText(this.cVv.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.glS.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, st(this.mLevel)));
            if (this.gRm) {
                if (f >= 1.0f) {
                    b(this.glS, this.gRo, f);
                } else {
                    c(this.glS, this.gRo, f);
                }
            } else {
                b(this.glS, this.gRo, f);
            }
            this.gRo = f;
        }
    }

    private int[] st(int i) {
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
    protected void bHl() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bHm() {
        if (this.mMemberType != 0) {
            am.setImageResource(this.gQV, R.drawable.icon_sml_speed_orange);
        } else {
            am.setImageResource(this.gQV, R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gQW != null && this.gQW.isShowing()) {
            this.gQW.dismiss();
        }
        if (this.gQR != null) {
            this.gQR.onDestroy();
        }
    }
}
