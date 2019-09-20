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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
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
    private String bGY;
    private RelativeLayout cXd;
    private View dLN;
    private TextView fEf;
    private TextView fEg;
    private al fEi;
    private boolean fEj;
    private RelativeLayout fEl;
    private boolean fEk = false;
    private ArrayList<TbImageView> fEh = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fxT = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fWR = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.fWS = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.fWT = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bpC();
        this.cXd = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.fXg = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.fSH = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.eXD = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.eXD.setPageId(this.fxT.getUniqueId());
        this.eXD.setDefaultBgResource(R.color.transparent);
        this.eXD.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eXD.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.dLN = this.mParent.findViewById(R.id.header_top_cover);
        this.fEl = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.fXh = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.fXl = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.fEf = (TextView) this.mParent.findViewById(R.id.member_image);
        this.fEg = (TextView) this.mParent.findViewById(R.id.post_image);
        this.fWY = (TextView) this.mParent.findViewById(R.id.level_name);
        this.fXe = (TextView) this.mParent.findViewById(R.id.level);
        this.fWW = (TextView) this.mParent.findViewById(R.id.tv_love);
        this.fWX = (TextView) this.mParent.findViewById(R.id.tv_sign);
        this.fWX.setContentDescription(frsFragment.getResources().getString(R.string.sign));
        this.fsS = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.fsT = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.fWU = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.fWV = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.fuT = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.fXa = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.fXn = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.fXn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fXn.setPageId(this.fxT.getUniqueId());
        this.fXn.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.fXn.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.fXn.setShowOval(true);
        this.fXd = this.mParent.findViewById(R.id.level_container);
        this.fXc = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.fXb = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.fXf = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.fXq = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fXi = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.fWZ = LayoutInflater.from(this.fxT.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.fWZ.setVisibility(8);
    }

    protected View bpC() {
        return LayoutInflater.from(this.fxT.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void v(View.OnClickListener onClickListener) {
        this.fXn.setOnClickListener(onClickListener);
        this.fuT.setOnClickListener(onClickListener);
        this.fWX.setOnClickListener(onClickListener);
        this.fWW.setOnClickListener(onClickListener);
        this.fXd.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bpD() {
        this.fXa.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fXi);
        this.mContext.getLayoutMode().onModeChanged(this.fWZ);
        am.k(this.fsS, R.drawable.frs_exp_progress);
        am.l(this.fsT, R.color.cp_cont_a);
        am.l(this.fXf, R.color.black_alpha0);
        am.l(this.cXd, R.color.cp_bg_line_c);
        am.j(this.fuT, R.color.cp_cont_a);
        am.j(this.fXe, R.color.cp_cont_a);
        am.j(this.fWY, R.color.cp_cont_a);
        am.j(this.fEf, R.color.cp_cont_a);
        am.j(this.fWU, R.color.cp_cont_a);
        am.j(this.fEg, R.color.cp_cont_a);
        am.j(this.fWV, R.color.cp_cont_a);
        if (this.fXn != null) {
            this.fXn.setBorderWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds1));
            this.fXn.setBorderColor(am.getColor(R.color.cp_border_a));
            this.fXn.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fXn.invalidate();
        }
        if (this.fXo != null) {
            this.fXo.jg(i);
        }
        if (this.fSH != null) {
            this.fSH.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fEh.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bpQ();
        tu(this.fXB ? 1 : 0);
        bpH();
        sa(i);
        if (this.fXh != null) {
            this.fXh.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void jV(boolean z) {
        super.jV(z);
        if (this.fXh != null) {
            this.fXh.jV(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fXv = forumData.getPost_num();
            this.fXs = forumData.getTag_color();
            this.bGY = forumData.getImage_url();
            this.fXr = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fXw = forumData.getSignData().count_sign_num;
                this.fXx = forumData.getSignData().miss_sign_num;
            }
            this.fXy = forumData.getCurScore();
            this.fTP = forumData.getLevelupScore();
            this.fXp = forumData.getBadgeData();
            this.fXt = forumData.getAccelerateContent();
            this.fXD = forumData.isBrandForum;
            this.fUt = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fXu = new bh();
            bpE();
            bpI();
        }
    }

    protected void bpE() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bGY);
        this.fXu.aeM().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bpF() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        if (this.fXx > 0) {
            am.f(this.fWX, R.color.cp_cont_b, 1);
            Drawable a = SvgManager.ajv().a(R.drawable.icon_pure_frs_sign_add_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            if (a != null) {
                a.setBounds(0, 0, g, g);
            }
            this.fWX.setPadding(g2, 0, g2, 0);
            this.fWX.setCompoundDrawablesWithIntrinsicBounds(a, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fWX.setText(String.format(this.mContext.getString(R.string.miss_sign_days), Integer.valueOf(this.fXx)));
        } else {
            Drawable a2 = SvgManager.ajv().a(R.drawable.icon_pure_frs_sign_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            am.f(this.fWX, R.color.cp_cont_b, 1);
            if (a2 != null) {
                a2.setBounds(0, 0, g, g);
            }
            this.fWX.setCompoundDrawables(a2, null, null, null);
            this.fWX.setText(this.mContext.getString(R.string.signed));
            this.fWX.setPadding(g2, 0, g2, 0);
            this.fWX.setBackgroundDrawable(null);
        }
        am.g(this.fWX, l.g(this.mContext.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
        this.fWX.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds34));
        this.fWX.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bpG() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        Drawable a = SvgManager.ajv().a(R.drawable.icon_pure_frs_sign_n_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        if (a != null) {
            a.setBounds(0, 0, g, g);
        }
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        this.fWX.setPadding(g2, 0, g2, 0);
        this.fWX.setCompoundDrawablesWithIntrinsicBounds(a, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fWX.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        this.fWX.setText(this.mContext.getString(R.string.sign));
        am.f(this.fWX, R.color.cp_cont_b, 1);
        am.g(this.fWX, l.g(this.mContext.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
    }

    protected void bpH() {
        this.fWW.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        am.f(this.fWW, R.color.cp_cont_b, 1);
        am.g(this.fWW, l.g(this.mContext.getPageActivity(), R.dimen.tbds10), R.color.cp_btn_a, R.color.cp_btn_a_alpha50);
    }

    protected void bpI() {
        if (this.fWU != null) {
            this.fWU.setText(aq.aJ(this.mMemberNum));
        }
        if (this.fWV != null) {
            this.fWV.setText(aq.aJ(this.fXv));
        }
        if (this.fXp != null && this.fXp.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fXD) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(R.string.forum);
        if (this.fhE != null) {
            this.fhE.setText(str);
        }
        if (this.fuT != null) {
            this.fuT.setText(str);
        }
        bpN();
        this.fEj = bpM();
        if (this.fEj) {
            this.fSH.setVisibility(8);
            this.dLN.setVisibility(0);
        } else {
            this.dLN.setVisibility(8);
            this.fSH.setVisibility(0);
            this.eXD.setOnClickListener(null);
        }
        bpL();
        sa(TbadkCoreApplication.getInst().getSkinType());
        K(this.fEj, bpK());
    }

    private void K(boolean z, boolean z2) {
        e ye = d.bsS().ye(this.mForumName);
        if (ye == null) {
            ye = new e(this.fEk, z2);
        } else {
            ye.kP(this.fEk);
            ye.kQ(z2);
        }
        d.bsS().a(this.mForumName, ye);
        L(z, z2);
        M(z, z2);
    }

    private void L(boolean z, boolean z2) {
        int g;
        if (this.fXg != null && this.fXg.getLayoutParams() != null) {
            if (z) {
                int af = (l.af(this.mContext.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXf.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = af - this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = af - this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.fXf.setLayoutParams(layoutParams);
                }
                g = af;
            } else if (!z2) {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds487);
            } else {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.fXg.getLayoutParams();
            if (layoutParams2.height != g) {
                layoutParams2.height = g;
                this.fXg.setLayoutParams(layoutParams2);
            }
        }
    }

    private void M(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bpJ = bpJ();
        if (bpJ != null) {
            bpJ.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fEl != null) {
            RelativeLayout relativeLayout = this.fEl;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bpJ() {
        if (this.fxT == null || this.fxT.bmH() == null) {
            return null;
        }
        View btM = this.fxT.bmH().btM();
        if (btM instanceof LinearGradientView) {
            return (LinearGradientView) btM;
        }
        return null;
    }

    private boolean bpK() {
        return this.fXh != null && this.fXh.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bpL() {
        if (this.fxT != null && this.fUt != null) {
            List<m> showTopThreadList = this.fUt.getShowTopThreadList();
            this.fEk = showTopThreadList.size() > 2;
            a(showTopThreadList, this.fUt.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.fXh != null) {
            if (this.fxT != null && this.fxT.bmQ()) {
                this.fXh.setVisibility(0);
                this.fXh.setFragmentUniqueId(this.fxT.getUniqueId());
                this.fXh.setForum(this.mForumId, this.mForumName);
                this.fXh.setDatas(list, hVar);
                if (this.fEi == null) {
                    this.fEi = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ad(bh bhVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.fxT, b.this.fUt, bhVar);
                        }
                    };
                }
                this.fXh.setStatListener(this.fEi);
                return;
            }
            this.fXh.setVisibility(8);
        }
    }

    private boolean bpM() {
        if (this.fUt == null) {
            return false;
        }
        final FrsViewData frsViewData = this.fUt;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cpI())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().cpI());
        } else if (frsViewData.getActivityHeadData() != null && v.Z(frsViewData.getActivityHeadData().acQ()) >= 1) {
            sVar = frsViewData.getActivityHeadData().acQ().get(0);
        }
        if (sVar != null) {
            if (this.eXD != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().acR())) {
                    an anVar = new an("c13326");
                    anVar.bT("fid", frsViewData.getForum().getId());
                    anVar.bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().acR());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.bT("page_type", "a006").P("obj_isad", 1).bT("fid", frsViewData.getForum().getId()).bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().acR()).P("obj_adlocate", 1);
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cgM);
                    }
                    com.baidu.tieba.q.c.cpt().a(this.fxT.getUniqueId(), frsViewData.getActivityHeadData().acR(), anVar2);
                }
                this.eXD.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eXD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.mContext != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().acR())) {
                                    String id = frsViewData.getForum().getId();
                                    String acR = frsViewData.getActivityHeadData().acR();
                                    an anVar3 = new an("c13330");
                                    anVar3.bT("fid", id);
                                    anVar3.bT(VideoPlayActivityConfig.OBJ_ID, acR);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.bT("page_type", "a006").P("obj_isad", 1).bT("fid", id).bT(VideoPlayActivityConfig.OBJ_ID, acR).P("obj_adlocate", 1);
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cgM);
                                    }
                                    com.baidu.tieba.q.c.cpt().b(b.this.fxT.getUniqueId(), anVar4);
                                }
                                ba.ajK().a(b.this.mContext, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void sa(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fUt != null && this.fUt.getForum() != null && (themeColorInfo = (forum = this.fUt.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1 || i == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fEj) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bpJ = bpJ();
                if (this.fSH != null && bpJ != null) {
                    this.fSH.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bpJ.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eXD != null) {
                    this.eXD.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fXh != null) {
                String str = themeElement.font_color;
                this.fXh.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cE(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bpN() {
        this.fXn.startLoad(this.bGY, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fXJ);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fXi);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.fXj = (TextView) this.fXi.findViewById(R.id.cur_experience);
            this.fXk = (TextView) this.fXi.findViewById(R.id.levelup_experience);
            am.k(this.fXi.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.f((TextView) this.fXi.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.f(this.fXj, R.color.common_color_10047, 1);
            am.f(this.fXk, R.color.cp_cont_g, 1);
            a(this.fXj, this.fXk);
            if (this.mPopup.isShowing()) {
                g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.mPopup.getHeight() <= 50) {
                g.a(this.mPopup, this.mContext.getPageActivity());
                return;
            }
            g.showPopupWindowAtLocation(this.mPopup, this.mParent, 0, iArr[0], iArr[1] - this.mPopup.getHeight());
            this.mPopup.update();
            this.mHandler.postDelayed(this.fXJ, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            am.f((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            am.f(textView, R.color.cp_cont_b, 1);
            am.f(textView2, R.color.cp_cont_b, 1);
            am.f(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.aH(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.fXt) && !TextUtils.isEmpty(this.fXt.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fXt);
            } else {
                textView3.setVisibility(8);
            }
            aVar.hw(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.agO();
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
                if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(b.this.mContext.getPageActivity(), b.this.mMemberType, "exp_acce", 2);
                    memberPayActivityConfig.setSceneId("4004001000");
                    memberPayActivityConfig.setReferPageClickZone("frs_V8.9", "pop_ups_opende_button_V8.9");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    aVar2.dismiss();
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bpO() {
        View contentView;
        if (this.fXm == null) {
            this.fXm = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.fXm.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fXm, b.this.mContext.getPageActivity());
                        b.this.fxT.fvO = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fXm.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.fXm.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.fXm.setBackgroundDrawable(new BitmapDrawable());
            this.fXm.setOutsideTouchable(true);
            this.fXm.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fXm);
                        b.this.fxT.fvO = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fXm.getContentView();
        }
        am.f((TextView) contentView.findViewById(R.id.mem), R.color.cp_cont_a, 1);
        am.f((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.f((TextView) contentView.findViewById(R.id.tequan), R.color.cp_cont_a, 1);
        int[] iArr = new int[2];
        this.fXl.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fXm, this.mParent, 0, (iArr[0] - (this.fXm.getWidth() / 2)) + (this.fXl.getWidth() / 2), iArr[1] + this.fXl.getWidth());
        this.fXm.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fXC = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fWY != null && this.fsS != null && this.fXe != null && cashBitmap.getWidth() > 0) {
            if (this.fXC) {
                this.fWY.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bnj = this.fxT.bnj();
                if (bnj != null && bnj.getForum() != null) {
                    bnj.getForum().setUser_level(i);
                }
                this.fXe.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.fWY.setText(this.fXr);
                this.fXe.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.fsS.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, ri(this.mLevel)));
            if (this.fXC) {
                if (f >= 1.0f) {
                    a(this.fxT.getBaseFragmentActivity(), this.fsS, this.fXE, f);
                } else {
                    b(this.fxT.getBaseFragmentActivity(), this.fsS, this.fXE, f);
                }
            } else {
                a(this.fxT.getBaseFragmentActivity(), this.fsS, this.fXE, f);
            }
            this.fXE = f;
        }
    }

    private int[] ri(int i) {
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
    protected void bpP() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bpQ() {
        if (this.mMemberType != 0) {
            am.c(this.fXl, (int) R.drawable.icon_sml_speed_orange);
        } else {
            am.c(this.fXl, (int) R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fXm != null && this.fXm.isShowing()) {
            this.fXm.dismiss();
        }
        if (this.fXh != null) {
            this.fXh.onDestroy();
        }
    }
}
