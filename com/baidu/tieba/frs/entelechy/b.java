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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
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
    private String bGA;
    private RelativeLayout cWk;
    private View dKc;
    private TextView fCs;
    private TextView fCt;
    private al fCv;
    private boolean fCw;
    private RelativeLayout fCy;
    private boolean fCx = false;
    private ArrayList<TbImageView> fCu = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fwg = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fVa = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.fVb = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.fVc = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = boR();
        this.cWk = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.fVp = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.fQQ = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.eVX = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.eVX.setPageId(this.fwg.getUniqueId());
        this.eVX.setDefaultBgResource(R.color.transparent);
        this.eVX.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eVX.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.dKc = this.mParent.findViewById(R.id.header_top_cover);
        this.fCy = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.fVq = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.fVu = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.fCs = (TextView) this.mParent.findViewById(R.id.member_image);
        this.fCt = (TextView) this.mParent.findViewById(R.id.post_image);
        this.fVh = (TextView) this.mParent.findViewById(R.id.level_name);
        this.fVn = (TextView) this.mParent.findViewById(R.id.level);
        this.fVf = (TextView) this.mParent.findViewById(R.id.tv_love);
        this.fVg = (TextView) this.mParent.findViewById(R.id.tv_sign);
        this.fVg.setContentDescription(frsFragment.getResources().getString(R.string.sign));
        this.fre = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.frf = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.fVd = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.fVe = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.ftg = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.fVj = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.fVw = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.fVw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVw.setPageId(this.fwg.getUniqueId());
        this.fVw.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.fVw.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.fVw.setShowOval(true);
        this.fVm = this.mParent.findViewById(R.id.level_container);
        this.fVl = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.fVk = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.fVo = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.fVz = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fVr = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.fVi = LayoutInflater.from(this.fwg.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.fVi.setVisibility(8);
    }

    protected View boR() {
        return LayoutInflater.from(this.fwg.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void v(View.OnClickListener onClickListener) {
        this.fVw.setOnClickListener(onClickListener);
        this.ftg.setOnClickListener(onClickListener);
        this.fVg.setOnClickListener(onClickListener);
        this.fVf.setOnClickListener(onClickListener);
        this.fVm.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void boS() {
        this.fVj.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fVr);
        this.mContext.getLayoutMode().onModeChanged(this.fVi);
        am.k(this.fre, R.drawable.frs_exp_progress);
        am.l(this.frf, R.color.cp_btn_a);
        am.l(this.fVo, R.color.black_alpha0);
        am.l(this.cWk, R.color.cp_bg_line_e);
        am.j(this.ftg, R.color.cp_btn_a);
        am.j(this.fVn, R.color.cp_btn_a);
        am.j(this.fVh, R.color.cp_btn_a);
        am.j(this.fCs, R.color.cp_btn_a);
        am.j(this.fVd, R.color.cp_btn_a);
        am.j(this.fCt, R.color.cp_btn_a);
        am.j(this.fVe, R.color.cp_btn_a);
        if (this.fVw != null) {
            this.fVw.setBorderWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds1));
            this.fVw.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fVw.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fVw.invalidate();
        }
        if (this.fVx != null) {
            this.fVx.jd(i);
        }
        if (this.fQQ != null) {
            this.fQQ.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fCu.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bpf();
        tq(this.fVK ? 1 : 0);
        boW();
        rW(i);
        if (this.fVq != null) {
            this.fVq.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void jS(boolean z) {
        super.jS(z);
        if (this.fVq != null) {
            this.fVq.jS(z);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fVE = forumData.getPost_num();
            this.fVB = forumData.getTag_color();
            this.bGA = forumData.getImage_url();
            this.fVA = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fVF = forumData.getSignData().count_sign_num;
                this.fVG = forumData.getSignData().miss_sign_num;
            }
            this.fVH = forumData.getCurScore();
            this.fRY = forumData.getLevelupScore();
            this.fVy = forumData.getBadgeData();
            this.fVC = forumData.getAccelerateContent();
            this.fVM = forumData.isBrandForum;
            this.fSC = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fVD = new bh();
            boT();
            boX();
        }
    }

    protected void boT() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bGA);
        this.fVD.aeI().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void boU() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        if (this.fVG > 0) {
            am.f(this.fVg, R.color.cp_cont_f, 1);
            Drawable drawable = am.getDrawable(R.drawable.icon_frs_sign_add_n);
            drawable.setBounds(0, 0, g, g);
            this.fVg.setPadding(g2, 0, g2, 0);
            this.fVg.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fVg.setText(String.format(this.mContext.getString(R.string.miss_sign_days), Integer.valueOf(this.fVG)));
            am.k(this.fVg, R.drawable.btn_white_alpha95_corners_selector);
        } else {
            Drawable drawable2 = am.getDrawable(R.drawable.icon_frs_sign_n);
            am.f(this.fVg, R.color.cp_cont_f, 1);
            drawable2.setBounds(0, 0, g, g);
            this.fVg.setCompoundDrawables(drawable2, null, null, null);
            this.fVg.setText(this.mContext.getString(R.string.signed));
            this.fVg.setPadding(g2, 0, g2, 0);
            this.fVg.setBackgroundDrawable(null);
            am.k(this.fVg, R.drawable.btn_white_alpha95_corners_selector);
        }
        this.fVg.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds34));
        this.fVg.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void boV() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        Drawable drawable = am.getDrawable(R.drawable.icon_frs_sign_n);
        drawable.setBounds(0, 0, g, g);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        this.fVg.setPadding(g2, 0, g2, 0);
        this.fVg.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fVg.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        this.fVg.setText(this.mContext.getString(R.string.sign));
        am.f(this.fVg, R.color.cp_cont_f, 1);
        am.k(this.fVg, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void boW() {
        this.fVf.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        am.f(this.fVf, R.color.cp_cont_f, 1);
        am.k(this.fVf, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void boX() {
        if (this.fVd != null) {
            this.fVd.setText(aq.aJ(this.mMemberNum));
        }
        if (this.fVe != null) {
            this.fVe.setText(aq.aJ(this.fVE));
        }
        if (this.fVy != null && this.fVy.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fVM) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(R.string.forum);
        if (this.ffR != null) {
            this.ffR.setText(str);
        }
        if (this.ftg != null) {
            this.ftg.setText(str);
        }
        bpc();
        this.fCw = bpb();
        if (this.fCw) {
            this.fQQ.setVisibility(8);
            this.dKc.setVisibility(0);
        } else {
            this.dKc.setVisibility(8);
            this.fQQ.setVisibility(0);
            this.eVX.setOnClickListener(null);
        }
        bpa();
        rW(TbadkCoreApplication.getInst().getSkinType());
        K(this.fCw, boZ());
    }

    private void K(boolean z, boolean z2) {
        e xF = d.bsf().xF(this.mForumName);
        if (xF == null) {
            xF = new e(this.fCx, z2);
        } else {
            xF.kM(this.fCx);
            xF.kN(z2);
        }
        d.bsf().a(this.mForumName, xF);
        L(z, z2);
        M(z, z2);
    }

    private void L(boolean z, boolean z2) {
        int g;
        if (this.fVp != null && this.fVp.getLayoutParams() != null) {
            if (z) {
                int af = (l.af(this.mContext.getPageActivity()) * 3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVo.getLayoutParams();
                if (layoutParams != null) {
                    if (z2) {
                        layoutParams.topMargin = af - this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds272);
                    } else {
                        layoutParams.topMargin = af - this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    }
                    this.fVo.setLayoutParams(layoutParams);
                }
                g = af;
            } else if (!z2) {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds487);
            } else {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.fVp.getLayoutParams();
            if (layoutParams2.height != g) {
                layoutParams2.height = g;
                this.fVp.setLayoutParams(layoutParams2);
            }
        }
    }

    private void M(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView boY = boY();
        if (boY != null) {
            boY.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fCy != null) {
            RelativeLayout relativeLayout = this.fCy;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView boY() {
        if (this.fwg == null || this.fwg.blW() == null) {
            return null;
        }
        View bsZ = this.fwg.blW().bsZ();
        if (bsZ instanceof LinearGradientView) {
            return (LinearGradientView) bsZ;
        }
        return null;
    }

    private boolean boZ() {
        return this.fVq != null && this.fVq.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bpa() {
        if (this.fwg != null && this.fSC != null) {
            List<m> showTopThreadList = this.fSC.getShowTopThreadList();
            this.fCx = showTopThreadList.size() > 2;
            a(showTopThreadList, this.fSC.getBusinessPromot());
        }
    }

    private void a(List<m> list, h hVar) {
        if (this.fVq != null) {
            if (this.fwg != null && this.fwg.bmf()) {
                this.fVq.setVisibility(0);
                this.fVq.setFragmentUniqueId(this.fwg.getUniqueId());
                this.fVq.setForum(this.mForumId, this.mForumName);
                this.fVq.setDatas(list, hVar);
                if (this.fCv == null) {
                    this.fCv = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ac(bh bhVar) {
                            com.baidu.tieba.frs.f.h.a(b.this.fwg, b.this.fSC, bhVar);
                        }
                    };
                }
                this.fVq.setStatListener(this.fCv);
                return;
            }
            this.fVq.setVisibility(8);
        }
    }

    private boolean bpb() {
        if (this.fSC == null) {
            return false;
        }
        final FrsViewData frsViewData = this.fSC;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().coV())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().coV());
        } else if (frsViewData.getActivityHeadData() != null && v.Z(frsViewData.getActivityHeadData().acM()) >= 1) {
            sVar = frsViewData.getActivityHeadData().acM().get(0);
        }
        if (sVar != null) {
            if (this.eVX != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().acN())) {
                    an anVar = new an("c13326");
                    anVar.bT("fid", frsViewData.getForum().getId());
                    anVar.bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().acN());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.bT("page_type", "a006").P("obj_isad", 1).bT("fid", frsViewData.getForum().getId()).bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().acN()).P("obj_adlocate", 1);
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cfT);
                    }
                    com.baidu.tieba.q.c.coG().a(this.fwg.getUniqueId(), frsViewData.getActivityHeadData().acN(), anVar2);
                }
                this.eVX.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eVX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.mContext != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().acN())) {
                                    String id = frsViewData.getForum().getId();
                                    String acN = frsViewData.getActivityHeadData().acN();
                                    an anVar3 = new an("c13330");
                                    anVar3.bT("fid", id);
                                    anVar3.bT(VideoPlayActivityConfig.OBJ_ID, acN);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.bT("page_type", "a006").P("obj_isad", 1).bT("fid", id).bT(VideoPlayActivityConfig.OBJ_ID, acN).P("obj_adlocate", 1);
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cfT);
                                    }
                                    com.baidu.tieba.q.c.coG().b(b.this.fwg.getUniqueId(), anVar4);
                                }
                                bb.ajE().a(b.this.mContext, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void rW(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fSC != null && this.fSC.getForum() != null && (themeColorInfo = (forum = this.fSC.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fCw) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView boY = boY();
                if (this.fQQ != null && boY != null) {
                    this.fQQ.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    boY.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eVX != null) {
                    this.eVX.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fVq != null) {
                String str = themeElement.font_color;
                this.fVq.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cE(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bpc() {
        this.fVw.startLoad(this.bGA, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fVS);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fVr);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.fVs = (TextView) this.fVr.findViewById(R.id.cur_experience);
            this.fVt = (TextView) this.fVr.findViewById(R.id.levelup_experience);
            am.k(this.fVr.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.f((TextView) this.fVr.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.f(this.fVs, R.color.common_color_10047, 1);
            am.f(this.fVt, R.color.cp_cont_g, 1);
            a(this.fVs, this.fVt);
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
            this.mHandler.postDelayed(this.fVS, 2000L);
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
            if (!TextUtils.isEmpty(this.fVC) && !TextUtils.isEmpty(this.fVC.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fVC);
            } else {
                textView3.setVisibility(8);
            }
            aVar.hv(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.agK();
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
    public void bpd() {
        View contentView;
        if (this.fVv == null) {
            this.fVv = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.fVv.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fVv, b.this.mContext.getPageActivity());
                        b.this.fwg.fub = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fVv.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.fVv.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.fVv.setBackgroundDrawable(new BitmapDrawable());
            this.fVv.setOutsideTouchable(true);
            this.fVv.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fVv);
                        b.this.fwg.fub = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fVv.getContentView();
        }
        am.f((TextView) contentView.findViewById(R.id.mem), R.color.cp_btn_a, 1);
        am.f((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.f((TextView) contentView.findViewById(R.id.tequan), R.color.cp_btn_a, 1);
        int[] iArr = new int[2];
        this.fVu.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fVv, this.mParent, 0, (iArr[0] - (this.fVv.getWidth() / 2)) + (this.fVu.getWidth() / 2), iArr[1] + this.fVu.getWidth());
        this.fVv.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fVL = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fVh != null && this.fre != null && this.fVn != null && cashBitmap.getWidth() > 0) {
            if (this.fVL) {
                this.fVh.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bmy = this.fwg.bmy();
                if (bmy != null && bmy.getForum() != null) {
                    bmy.getForum().setUser_level(i);
                }
                this.fVn.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.fVh.setText(this.fVA);
                this.fVn.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.fre.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, rf(this.mLevel)));
            if (this.fVL) {
                if (f >= 1.0f) {
                    a(this.fwg.getBaseFragmentActivity(), this.fre, this.fVN, f);
                } else {
                    b(this.fwg.getBaseFragmentActivity(), this.fre, this.fVN, f);
                }
            } else {
                a(this.fwg.getBaseFragmentActivity(), this.fre, this.fVN, f);
            }
            this.fVN = f;
        }
    }

    private int[] rf(int i) {
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
    protected void bpe() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bpf() {
        if (this.mMemberType != 0) {
            am.c(this.fVu, (int) R.drawable.icon_sml_speed_orange);
        } else {
            am.c(this.fVu, (int) R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fVv != null && this.fVv.isShowing()) {
            this.fVv.dismiss();
        }
        if (this.fVq != null) {
            this.fVq.onDestroy();
        }
    }
}
