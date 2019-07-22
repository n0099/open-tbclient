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
import com.baidu.tbadk.core.data.bg;
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
import com.baidu.tieba.frs.f.h;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String bGz;
    private RelativeLayout cWd;
    private View dJV;
    private TextView fBE;
    private TextView fBF;
    private al fBH;
    private boolean fBI;
    private RelativeLayout fBK;
    private boolean fBJ = false;
    private ArrayList<TbImageView> fBG = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fvH = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fUk = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.fUl = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.fUm = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = boE();
        this.cWd = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.fUz = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.fQc = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.eVP = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.eVP.setPageId(this.fvH.getUniqueId());
        this.eVP.setDefaultBgResource(R.color.transparent);
        this.eVP.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eVP.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.dJV = this.mParent.findViewById(R.id.header_top_cover);
        this.fBK = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.fUA = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.fUE = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.fBE = (TextView) this.mParent.findViewById(R.id.member_image);
        this.fBF = (TextView) this.mParent.findViewById(R.id.post_image);
        this.fUr = (TextView) this.mParent.findViewById(R.id.level_name);
        this.fUx = (TextView) this.mParent.findViewById(R.id.level);
        this.fUp = (TextView) this.mParent.findViewById(R.id.tv_love);
        this.fUq = (TextView) this.mParent.findViewById(R.id.tv_sign);
        this.fUq.setContentDescription(frsFragment.getResources().getString(R.string.sign));
        this.fqF = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.fqG = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.fUn = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.fUo = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.fsH = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.fUt = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.fUG = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.fUG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fUG.setPageId(this.fvH.getUniqueId());
        this.fUG.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.fUG.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.fUG.setShowOval(true);
        this.fUw = this.mParent.findViewById(R.id.level_container);
        this.fUv = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.fUu = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.fUy = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.fUJ = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fUB = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.fUs = LayoutInflater.from(this.fvH.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.fUs.setVisibility(8);
    }

    protected View boE() {
        return LayoutInflater.from(this.fvH.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void v(View.OnClickListener onClickListener) {
        this.fUG.setOnClickListener(onClickListener);
        this.fsH.setOnClickListener(onClickListener);
        this.fUq.setOnClickListener(onClickListener);
        this.fUp.setOnClickListener(onClickListener);
        this.fUw.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void boF() {
        this.fUt.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fUB);
        this.mContext.getLayoutMode().onModeChanged(this.fUs);
        am.k(this.fqF, R.drawable.frs_exp_progress);
        am.l(this.fqG, R.color.cp_btn_a);
        am.l(this.fUy, R.color.black_alpha0);
        am.l(this.cWd, R.color.cp_bg_line_e);
        am.j(this.fsH, R.color.cp_btn_a);
        am.j(this.fUx, R.color.cp_btn_a);
        am.j(this.fUr, R.color.cp_btn_a);
        am.j(this.fBE, R.color.cp_btn_a);
        am.j(this.fUn, R.color.cp_btn_a);
        am.j(this.fBF, R.color.cp_btn_a);
        am.j(this.fUo, R.color.cp_btn_a);
        if (this.fUG != null) {
            this.fUG.setBorderWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds1));
            this.fUG.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fUG.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fUG.invalidate();
        }
        if (this.fUH != null) {
            this.fUH.jc(i);
        }
        if (this.fQc != null) {
            this.fQc.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fBG.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        boS();
        to(this.fUU ? 1 : 0);
        boJ();
        rU(i);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fUO = forumData.getPost_num();
            this.fUL = forumData.getTag_color();
            this.bGz = forumData.getImage_url();
            this.fUK = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fUP = forumData.getSignData().count_sign_num;
                this.fUQ = forumData.getSignData().miss_sign_num;
            }
            this.fUR = forumData.getCurScore();
            this.fRk = forumData.getLevelupScore();
            this.fUI = forumData.getBadgeData();
            this.fUM = forumData.getAccelerateContent();
            this.fUW = forumData.isBrandForum;
            this.fRO = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fUN = new bg();
            boG();
            boK();
        }
    }

    protected void boG() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bGz);
        this.fUN.aeH().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void boH() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        if (this.fUQ > 0) {
            am.f(this.fUq, R.color.cp_cont_f, 1);
            Drawable drawable = am.getDrawable(R.drawable.icon_frs_sign_add_n);
            drawable.setBounds(0, 0, g, g);
            this.fUq.setPadding(g2, 0, g2, 0);
            this.fUq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fUq.setText(String.format(this.mContext.getString(R.string.miss_sign_days), Integer.valueOf(this.fUQ)));
            am.k(this.fUq, R.drawable.btn_white_alpha95_corners_selector);
        } else {
            Drawable drawable2 = am.getDrawable(R.drawable.icon_frs_sign_n);
            am.f(this.fUq, R.color.cp_cont_f, 1);
            drawable2.setBounds(0, 0, g, g);
            this.fUq.setCompoundDrawables(drawable2, null, null, null);
            this.fUq.setText(this.mContext.getString(R.string.signed));
            this.fUq.setPadding(g2, 0, g2, 0);
            this.fUq.setBackgroundDrawable(null);
            am.k(this.fUq, R.drawable.btn_white_alpha95_corners_selector);
        }
        this.fUq.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds34));
        this.fUq.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void boI() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        Drawable drawable = am.getDrawable(R.drawable.icon_frs_sign_n);
        drawable.setBounds(0, 0, g, g);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        this.fUq.setPadding(g2, 0, g2, 0);
        this.fUq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fUq.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        this.fUq.setText(this.mContext.getString(R.string.sign));
        am.f(this.fUq, R.color.cp_cont_f, 1);
        am.k(this.fUq, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void boJ() {
        this.fUp.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        am.f(this.fUp, R.color.cp_cont_f, 1);
        am.k(this.fUp, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void boK() {
        if (this.fUn != null) {
            this.fUn.setText(aq.aJ(this.mMemberNum));
        }
        if (this.fUo != null) {
            this.fUo.setText(aq.aJ(this.fUO));
        }
        if (this.fUI != null && this.fUI.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fUW) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(R.string.forum);
        if (this.ffr != null) {
            this.ffr.setText(str);
        }
        if (this.fsH != null) {
            this.fsH.setText(str);
        }
        boP();
        this.fBI = boO();
        if (this.fBI) {
            this.fQc.setVisibility(8);
            this.dJV.setVisibility(0);
        } else {
            this.dJV.setVisibility(8);
            this.fQc.setVisibility(0);
            this.eVP.setOnClickListener(null);
        }
        boN();
        rU(TbadkCoreApplication.getInst().getSkinType());
        K(this.fBI, boM());
    }

    private void K(boolean z, boolean z2) {
        e xE = d.brS().xE(this.mForumName);
        if (xE == null) {
            xE = new e(this.fBJ, z2);
        } else {
            xE.kM(this.fBJ);
            xE.kN(z2);
        }
        d.brS().a(this.mForumName, xE);
        L(z, z2);
        M(z, z2);
    }

    private void L(boolean z, boolean z2) {
        int g;
        if (this.fUz != null && this.fUz.getLayoutParams() != null) {
            if (z) {
                int af = (l.af(this.mContext.getPageActivity()) * 3) / 4;
                if (z2) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fUy.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.topMargin = af - this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds272);
                        this.fUy.setLayoutParams(layoutParams);
                    }
                    g = af;
                } else {
                    g = af;
                }
            } else if (!z2) {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds487);
            } else {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams2 = this.fUz.getLayoutParams();
            if (layoutParams2.height != g) {
                layoutParams2.height = g;
                this.fUz.setLayoutParams(layoutParams2);
            }
        }
    }

    private void M(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView boL = boL();
        if (boL != null) {
            boL.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fBK != null) {
            RelativeLayout relativeLayout = this.fBK;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView boL() {
        if (this.fvH == null || this.fvH.blP() == null) {
            return null;
        }
        View bsM = this.fvH.blP().bsM();
        if (bsM instanceof LinearGradientView) {
            return (LinearGradientView) bsM;
        }
        return null;
    }

    private boolean boM() {
        return this.fUA != null && this.fUA.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void boN() {
        if (this.fvH != null && this.fRO != null) {
            List<m> showTopThreadList = this.fRO.getShowTopThreadList();
            this.fBJ = showTopThreadList.size() > 2;
            ca(showTopThreadList);
        }
    }

    private void ca(List<m> list) {
        if (this.fUA != null) {
            if (!v.aa(list)) {
                this.fUA.setVisibility(0);
                this.fUA.setFragmentUniqueId(this.fvH.getUniqueId());
                this.fUA.setForum(this.mForumId, this.mForumName);
                this.fUA.setDatas(list);
                if (this.fBH == null) {
                    this.fBH = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ab(bg bgVar) {
                            h.a(b.this.fvH, b.this.fRO, bgVar);
                        }
                    };
                }
                this.fUA.setStatListener(this.fBH);
                return;
            }
            this.fUA.setVisibility(8);
        }
    }

    private boolean boO() {
        if (this.fRO == null) {
            return false;
        }
        final FrsViewData frsViewData = this.fRO;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().coz())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().coz());
        } else if (frsViewData.getActivityHeadData() != null && v.Z(frsViewData.getActivityHeadData().acL()) >= 1) {
            sVar = frsViewData.getActivityHeadData().acL().get(0);
        }
        if (sVar != null) {
            if (this.eVP != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().acM())) {
                    an anVar = new an("c13326");
                    anVar.bT("fid", frsViewData.getForum().getId());
                    anVar.bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().acM());
                    TiebaStatic.log(anVar);
                    an anVar2 = new an("common_exp");
                    anVar2.bT("page_type", "a006").P("obj_isad", 1).bT("fid", frsViewData.getForum().getId()).bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().acM()).P("obj_adlocate", 1);
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cfM);
                    }
                    com.baidu.tieba.q.c.coo().a(this.fvH.getUniqueId(), frsViewData.getActivityHeadData().acM(), anVar2);
                }
                this.eVP.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.mContext != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().acM())) {
                                    String id = frsViewData.getForum().getId();
                                    String acM = frsViewData.getActivityHeadData().acM();
                                    an anVar3 = new an("c13330");
                                    anVar3.bT("fid", id);
                                    anVar3.bT(VideoPlayActivityConfig.OBJ_ID, acM);
                                    TiebaStatic.log(anVar3);
                                    an anVar4 = new an("common_click");
                                    anVar4.bT("page_type", "a006").P("obj_isad", 1).bT("fid", id).bT(VideoPlayActivityConfig.OBJ_ID, acM).P("obj_adlocate", 1);
                                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                                        anVar3.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cfM);
                                    }
                                    com.baidu.tieba.q.c.coo().b(b.this.fvH.getUniqueId(), anVar4);
                                }
                                bb.ajC().a(b.this.mContext, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void rU(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fRO != null && this.fRO.getForum() != null && (themeColorInfo = (forum = this.fRO.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fBI) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView boL = boL();
                if (this.fQc != null && boL != null) {
                    this.fQc.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    boL.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eVP != null) {
                    this.eVP.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fUA != null) {
                String str = themeElement.font_color;
                this.fUA.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.cE(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void boP() {
        this.fUG.startLoad(this.bGz, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fVc);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fUB);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.fUC = (TextView) this.fUB.findViewById(R.id.cur_experience);
            this.fUD = (TextView) this.fUB.findViewById(R.id.levelup_experience);
            am.k(this.fUB.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            am.f((TextView) this.fUB.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            am.f(this.fUC, R.color.common_color_10047, 1);
            am.f(this.fUD, R.color.cp_cont_g, 1);
            a(this.fUC, this.fUD);
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
            this.mHandler.postDelayed(this.fVc, 2000L);
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
            if (!TextUtils.isEmpty(this.fUM) && !TextUtils.isEmpty(this.fUM.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fUM);
            } else {
                textView3.setVisibility(8);
            }
            aVar.hv(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.agI();
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
    public void boQ() {
        View contentView;
        if (this.fUF == null) {
            this.fUF = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.fUF.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fUF, b.this.mContext.getPageActivity());
                        b.this.fvH.ftC = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fUF.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.fUF.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.fUF.setBackgroundDrawable(new BitmapDrawable());
            this.fUF.setOutsideTouchable(true);
            this.fUF.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fUF);
                        b.this.fvH.ftC = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fUF.getContentView();
        }
        am.f((TextView) contentView.findViewById(R.id.mem), R.color.cp_btn_a, 1);
        am.f((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        am.f((TextView) contentView.findViewById(R.id.tequan), R.color.cp_btn_a, 1);
        int[] iArr = new int[2];
        this.fUE.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fUF, this.mParent, 0, (iArr[0] - (this.fUF.getWidth() / 2)) + (this.fUE.getWidth() / 2), iArr[1] + this.fUE.getWidth());
        this.fUF.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fUV = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fUr != null && this.fqF != null && this.fUx != null && cashBitmap.getWidth() > 0) {
            if (this.fUV) {
                this.fUr.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bmo = this.fvH.bmo();
                if (bmo != null && bmo.getForum() != null) {
                    bmo.getForum().setUser_level(i);
                }
                this.fUx.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.fUr.setText(this.fUK);
                this.fUx.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.fqF.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, rd(this.mLevel)));
            if (this.fUV) {
                if (f >= 1.0f) {
                    a(this.fvH.getBaseFragmentActivity(), this.fqF, this.fUX, f);
                } else {
                    b(this.fvH.getBaseFragmentActivity(), this.fqF, this.fUX, f);
                }
            } else {
                a(this.fvH.getBaseFragmentActivity(), this.fqF, this.fUX, f);
            }
            this.fUX = f;
        }
    }

    private int[] rd(int i) {
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
    protected void boR() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void boS() {
        if (this.mMemberType != 0) {
            am.c(this.fUE, (int) R.drawable.icon_sml_speed_orange);
        } else {
            am.c(this.fUE, (int) R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fUF != null && this.fUF.isShowing()) {
            this.fUF.dismiss();
        }
    }
}
