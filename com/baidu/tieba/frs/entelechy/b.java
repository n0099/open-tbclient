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
import com.baidu.tbadk.core.util.ap;
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
    private String bFy;
    private RelativeLayout cUH;
    private View dGl;
    private TextView fwI;
    private TextView fwJ;
    private al fwL;
    private boolean fwM;
    private RelativeLayout fwO;
    private boolean fwN = false;
    private ArrayList<TbImageView> fwK = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fqJ = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fPn = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.fPo = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.fPp = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bmD();
        this.cUH = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.fPC = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.fLe = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.eQP = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.eQP.setPageId(this.fqJ.getUniqueId());
        this.eQP.setDefaultBgResource(R.color.transparent);
        this.eQP.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eQP.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.dGl = this.mParent.findViewById(R.id.header_top_cover);
        this.fwO = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.fPD = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.fPH = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.fwI = (TextView) this.mParent.findViewById(R.id.member_image);
        this.fwJ = (TextView) this.mParent.findViewById(R.id.post_image);
        this.fPu = (TextView) this.mParent.findViewById(R.id.level_name);
        this.fPA = (TextView) this.mParent.findViewById(R.id.level);
        this.fPs = (TextView) this.mParent.findViewById(R.id.tv_love);
        this.fPt = (TextView) this.mParent.findViewById(R.id.tv_sign);
        this.fPt.setContentDescription(frsFragment.getResources().getString(R.string.sign));
        this.flH = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.flI = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.fPq = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.fPr = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.fnI = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.fPw = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.fPJ = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.fPJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fPJ.setPageId(this.fqJ.getUniqueId());
        this.fPJ.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.fPJ.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.fPJ.setShowOval(true);
        this.fPz = this.mParent.findViewById(R.id.level_container);
        this.fPy = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.fPx = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.fPB = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.fPM = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fPE = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.fPv = LayoutInflater.from(this.fqJ.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.fPv.setVisibility(8);
    }

    protected View bmD() {
        return LayoutInflater.from(this.fqJ.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void v(View.OnClickListener onClickListener) {
        this.fPJ.setOnClickListener(onClickListener);
        this.fnI.setOnClickListener(onClickListener);
        this.fPt.setOnClickListener(onClickListener);
        this.fPs.setOnClickListener(onClickListener);
        this.fPz.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmE() {
        this.fPw.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fPE);
        this.mContext.getLayoutMode().onModeChanged(this.fPv);
        com.baidu.tbadk.core.util.al.k(this.flH, R.drawable.frs_exp_progress);
        com.baidu.tbadk.core.util.al.l(this.flI, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.l(this.fPB, R.color.black_alpha0);
        com.baidu.tbadk.core.util.al.l(this.cUH, R.color.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.fnI, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPA, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPu, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fwI, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPq, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fwJ, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPr, R.color.cp_btn_a);
        if (this.fPJ != null) {
            this.fPJ.setBorderWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds1));
            this.fPJ.setBorderColor(com.baidu.tbadk.core.util.al.getColor(R.color.black_alpha15));
            this.fPJ.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fPJ.invalidate();
        }
        if (this.fPK != null) {
            this.fPK.iW(i);
        }
        if (this.fLe != null) {
            this.fLe.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fwK.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bmR();
        sW(this.fPX ? 1 : 0);
        bmI();
        rC(i);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fPR = forumData.getPost_num();
            this.fPO = forumData.getTag_color();
            this.bFy = forumData.getImage_url();
            this.fPN = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fPS = forumData.getSignData().count_sign_num;
                this.fPT = forumData.getSignData().miss_sign_num;
            }
            this.fPU = forumData.getCurScore();
            this.fMn = forumData.getLevelupScore();
            this.fPL = forumData.getBadgeData();
            this.fPP = forumData.getAccelerateContent();
            this.fPZ = forumData.isBrandForum;
            this.fMR = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fPQ = new bg();
            bmF();
            bmJ();
        }
    }

    protected void bmF() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bFy);
        this.fPQ.adF().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmG() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        if (this.fPT > 0) {
            com.baidu.tbadk.core.util.al.f(this.fPt, R.color.cp_cont_f, 1);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_frs_sign_add_n);
            drawable.setBounds(0, 0, g, g);
            this.fPt.setPadding(g2, 0, g2, 0);
            this.fPt.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fPt.setText(String.format(this.mContext.getString(R.string.miss_sign_days), Integer.valueOf(this.fPT)));
            com.baidu.tbadk.core.util.al.k(this.fPt, R.drawable.btn_white_alpha95_corners_selector);
        } else {
            Drawable drawable2 = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_frs_sign_n);
            com.baidu.tbadk.core.util.al.f(this.fPt, R.color.cp_cont_f, 1);
            drawable2.setBounds(0, 0, g, g);
            this.fPt.setCompoundDrawables(drawable2, null, null, null);
            this.fPt.setText(this.mContext.getString(R.string.signed));
            this.fPt.setPadding(g2, 0, g2, 0);
            this.fPt.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.al.k(this.fPt, R.drawable.btn_white_alpha95_corners_selector);
        }
        this.fPt.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds34));
        this.fPt.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmH() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_frs_sign_n);
        drawable.setBounds(0, 0, g, g);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        this.fPt.setPadding(g2, 0, g2, 0);
        this.fPt.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fPt.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        this.fPt.setText(this.mContext.getString(R.string.sign));
        com.baidu.tbadk.core.util.al.f(this.fPt, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fPt, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void bmI() {
        this.fPs.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        com.baidu.tbadk.core.util.al.f(this.fPs, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fPs, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void bmJ() {
        if (this.fPq != null) {
            this.fPq.setText(ap.aI(this.mMemberNum));
        }
        if (this.fPr != null) {
            this.fPr.setText(ap.aI(this.fPR));
        }
        if (this.fPL != null && this.fPL.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fPZ) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(R.string.forum);
        if (this.faq != null) {
            this.faq.setText(str);
        }
        if (this.fnI != null) {
            this.fnI.setText(str);
        }
        bmO();
        this.fwM = bmN();
        if (this.fwM) {
            this.fLe.setVisibility(8);
            this.dGl.setVisibility(0);
        } else {
            this.dGl.setVisibility(8);
            this.fLe.setVisibility(0);
            this.eQP.setOnClickListener(null);
        }
        bmM();
        rC(TbadkCoreApplication.getInst().getSkinType());
        H(this.fwM, bmL());
    }

    private void H(boolean z, boolean z2) {
        e wZ = d.bpR().wZ(this.mForumName);
        if (wZ == null) {
            wZ = new e(this.fwN, z2);
        } else {
            wZ.kC(this.fwN);
            wZ.kD(z2);
        }
        d.bpR().a(this.mForumName, wZ);
        I(z, z2);
        J(z, z2);
    }

    private void I(boolean z, boolean z2) {
        int g;
        if (this.fPC != null && this.fPC.getLayoutParams() != null) {
            if (!z && !z2) {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds487);
            } else {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams = this.fPC.getLayoutParams();
            if (layoutParams.height != g) {
                layoutParams.height = g;
                this.fPC.setLayoutParams(layoutParams);
            }
        }
    }

    private void J(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bmK = bmK();
        if (bmK != null) {
            bmK.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fwO != null) {
            RelativeLayout relativeLayout = this.fwO;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bmK() {
        if (this.fqJ == null || this.fqJ.bjN() == null) {
            return null;
        }
        View bqL = this.fqJ.bjN().bqL();
        if (bqL instanceof LinearGradientView) {
            return (LinearGradientView) bqL;
        }
        return null;
    }

    private boolean bmL() {
        return this.fPD != null && this.fPD.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmM() {
        if (this.fqJ != null && this.fMR != null) {
            List<m> showTopThreadList = this.fMR.getShowTopThreadList();
            this.fwN = showTopThreadList.size() > 2;
            bZ(showTopThreadList);
        }
    }

    private void bZ(List<m> list) {
        if (this.fPD != null) {
            if (!v.aa(list)) {
                this.fPD.setVisibility(0);
                this.fPD.setFragmentUniqueId(this.fqJ.getUniqueId());
                this.fPD.setForum(this.mForumId, this.mForumName);
                this.fPD.setDatas(list);
                if (this.fwL == null) {
                    this.fwL = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ab(bg bgVar) {
                            h.a(b.this.fqJ, b.this.fMR, bgVar);
                        }
                    };
                }
                this.fPD.setStatListener(this.fwL);
                return;
            }
            this.fPD.setVisibility(8);
        }
    }

    private boolean bmN() {
        if (this.fMR == null) {
            return false;
        }
        final FrsViewData frsViewData = this.fMR;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().clH())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().clH());
        } else if (frsViewData.getActivityHeadData() != null && v.Z(frsViewData.getActivityHeadData().abJ()) >= 1) {
            sVar = frsViewData.getActivityHeadData().abJ().get(0);
        }
        if (sVar != null) {
            if (this.eQP != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().abK())) {
                    am amVar = new am("c13326");
                    amVar.bT("fid", frsViewData.getForum().getId());
                    amVar.bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().abK());
                    TiebaStatic.log(amVar);
                }
                this.eQP.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eQP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.mContext != null) {
                                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().abK())) {
                                    String id = frsViewData.getForum().getId();
                                    String abK = frsViewData.getActivityHeadData().abK();
                                    am amVar2 = new am("c13330");
                                    amVar2.bT("fid", id);
                                    amVar2.bT(VideoPlayActivityConfig.OBJ_ID, abK);
                                    TiebaStatic.log(amVar2);
                                }
                                ba.aiz().a(b.this.mContext, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void rC(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fMR != null && this.fMR.getForum() != null && (themeColorInfo = (forum = this.fMR.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fwM) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bmK = bmK();
                if (this.fLe != null && bmK != null) {
                    this.fLe.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bmK.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eQP != null) {
                    this.eQP.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fPD != null) {
                String str = themeElement.font_color;
                this.fPD.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.parseColor(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bmO() {
        this.fPJ.startLoad(this.bFy, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fQf);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fPE);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.fPF = (TextView) this.fPE.findViewById(R.id.cur_experience);
            this.fPG = (TextView) this.fPE.findViewById(R.id.levelup_experience);
            com.baidu.tbadk.core.util.al.k(this.fPE.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            com.baidu.tbadk.core.util.al.f((TextView) this.fPE.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            com.baidu.tbadk.core.util.al.f(this.fPF, R.color.common_color_10047, 1);
            com.baidu.tbadk.core.util.al.f(this.fPG, R.color.cp_cont_g, 1);
            a(this.fPF, this.fPG);
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
            this.mHandler.postDelayed(this.fQf, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(R.id.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(R.id.speed_tip);
            com.baidu.tbadk.core.util.al.f((TextView) inflate.findViewById(R.id.experience_txt), R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.f(textView, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.f(textView2, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.f(textView3, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.aF(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.fPP) && !TextUtils.isEmpty(this.fPP.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fPP);
            } else {
                textView3.setVisibility(8);
            }
            aVar.hp(R.color.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.afG();
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
    public void bmP() {
        View contentView;
        if (this.fPI == null) {
            this.fPI = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.fPI.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fPI, b.this.mContext.getPageActivity());
                        b.this.fqJ.foD = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fPI.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.fPI.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.fPI.setBackgroundDrawable(new BitmapDrawable());
            this.fPI.setOutsideTouchable(true);
            this.fPI.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fPI);
                        b.this.fqJ.foD = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fPI.getContentView();
        }
        com.baidu.tbadk.core.util.al.f((TextView) contentView.findViewById(R.id.mem), R.color.cp_btn_a, 1);
        com.baidu.tbadk.core.util.al.f((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.al.f((TextView) contentView.findViewById(R.id.tequan), R.color.cp_btn_a, 1);
        int[] iArr = new int[2];
        this.fPH.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fPI, this.mParent, 0, (iArr[0] - (this.fPI.getWidth() / 2)) + (this.fPH.getWidth() / 2), iArr[1] + this.fPH.getWidth());
        this.fPI.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fPY = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fPu != null && this.flH != null && this.fPA != null && cashBitmap.getWidth() > 0) {
            if (this.fPY) {
                this.fPu.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bkm = this.fqJ.bkm();
                if (bkm != null && bkm.getForum() != null) {
                    bkm.getForum().setUser_level(i);
                }
                this.fPA.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.fPu.setText(this.fPN);
                this.fPA.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.flH.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, qL(this.mLevel)));
            if (this.fPY) {
                if (f >= 1.0f) {
                    a(this.fqJ.getBaseFragmentActivity(), this.flH, this.fQa, f);
                } else {
                    b(this.fqJ.getBaseFragmentActivity(), this.flH, this.fQa, f);
                }
            } else {
                a(this.fqJ.getBaseFragmentActivity(), this.flH, this.fQa, f);
            }
            this.fQa = f;
        }
    }

    private int[] qL(int i) {
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
    protected void bmQ() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmR() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.al.c(this.fPH, (int) R.drawable.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.al.c(this.fPH, (int) R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fPI != null && this.fPI.isShowing()) {
            this.fPI.dismiss();
        }
    }
}
