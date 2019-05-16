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
    private String bFx;
    private RelativeLayout cUF;
    private View dGk;
    private TextView fwH;
    private TextView fwI;
    private al fwK;
    private boolean fwL;
    private RelativeLayout fwN;
    private boolean fwM = false;
    private ArrayList<TbImageView> fwJ = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fqI = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fPk = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds20);
        this.fPl = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds72);
        this.fPm = l.g(frsFragment.getPageContext().getPageActivity(), R.dimen.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bmA();
        this.cUF = (RelativeLayout) this.mParent.findViewById(R.id.container);
        this.fPz = (RelativeLayout) this.mParent.findViewById(R.id.head_top_bg_container);
        this.fLb = (LinearGradientView) this.mParent.findViewById(R.id.head_top_gradient_bg);
        this.eQO = (TbImageView) this.mParent.findViewById(R.id.head_top_bg_mask);
        this.eQO.setPageId(this.fqI.getUniqueId());
        this.eQO.setDefaultBgResource(R.color.transparent);
        this.eQO.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eQO.setDefaultErrorResource(R.drawable.pic_frs_head_default);
        this.dGk = this.mParent.findViewById(R.id.header_top_cover);
        this.fwN = (RelativeLayout) this.mParent.findViewById(R.id.layout_banner_container);
        this.fPA = (FrsTopView) this.mParent.findViewById(R.id.frs_topview);
        this.fPE = (ImageView) this.mParent.findViewById(R.id.speed_icon);
        this.fwH = (TextView) this.mParent.findViewById(R.id.member_image);
        this.fwI = (TextView) this.mParent.findViewById(R.id.post_image);
        this.fPr = (TextView) this.mParent.findViewById(R.id.level_name);
        this.fPx = (TextView) this.mParent.findViewById(R.id.level);
        this.fPp = (TextView) this.mParent.findViewById(R.id.tv_love);
        this.fPq = (TextView) this.mParent.findViewById(R.id.tv_sign);
        this.fPq.setContentDescription(frsFragment.getResources().getString(R.string.sign));
        this.flG = (ImageView) this.mParent.findViewById(R.id.love_level_top);
        this.flH = (ImageView) this.mParent.findViewById(R.id.love_level_bg);
        this.fPn = (TextView) this.mParent.findViewById(R.id.member_num_text);
        this.fPo = (TextView) this.mParent.findViewById(R.id.post_num_text);
        this.fnH = (TextView) this.mParent.findViewById(R.id.forum_name);
        this.fPt = (TextView) this.mParent.findViewById(R.id.brand_label);
        this.fPG = (BarImageView) this.mParent.findViewById(R.id.frs_image);
        this.fPG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fPG.setPageId(this.fqI.getUniqueId());
        this.fPG.setContentDescription(frsFragment.getResources().getString(R.string.bar_header));
        this.fPG.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.fPG.setShowOval(true);
        this.fPw = this.mParent.findViewById(R.id.level_container);
        this.fPv = (RelativeLayout) this.mParent.findViewById(R.id.has_focused_container);
        this.fPu = (RelativeLayout) this.mParent.findViewById(R.id.not_focused_container);
        this.fPy = (RelativeLayout) this.mParent.findViewById(R.id.head_content_container);
        this.fPJ = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fPB = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.frs_show_experience, (ViewGroup) null);
        this.fPs = LayoutInflater.from(this.fqI.getPageContext().getPageActivity()).inflate(R.layout.frs_header_extra_entelechy, (ViewGroup) null);
        this.fPs.setVisibility(8);
    }

    protected View bmA() {
        return LayoutInflater.from(this.fqI.getPageContext().getPageActivity()).inflate(R.layout.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void v(View.OnClickListener onClickListener) {
        this.fPG.setOnClickListener(onClickListener);
        this.fnH.setOnClickListener(onClickListener);
        this.fPq.setOnClickListener(onClickListener);
        this.fPp.setOnClickListener(onClickListener);
        this.fPw.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmB() {
        this.fPt.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fPB);
        this.mContext.getLayoutMode().onModeChanged(this.fPs);
        com.baidu.tbadk.core.util.al.k(this.flG, R.drawable.frs_exp_progress);
        com.baidu.tbadk.core.util.al.l(this.flH, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.l(this.fPy, R.color.black_alpha0);
        com.baidu.tbadk.core.util.al.l(this.cUF, R.color.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.fnH, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPx, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPr, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fwH, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPn, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fwI, R.color.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fPo, R.color.cp_btn_a);
        if (this.fPG != null) {
            this.fPG.setBorderWidth(l.g(this.mContext.getPageActivity(), R.dimen.tbds1));
            this.fPG.setBorderColor(com.baidu.tbadk.core.util.al.getColor(R.color.black_alpha15));
            this.fPG.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fPG.invalidate();
        }
        if (this.fPH != null) {
            this.fPH.iW(i);
        }
        if (this.fLb != null) {
            this.fLb.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fwJ.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bmO();
        sW(this.fPU ? 1 : 0);
        bmF();
        rC(i);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fPO = forumData.getPost_num();
            this.fPL = forumData.getTag_color();
            this.bFx = forumData.getImage_url();
            this.fPK = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fPP = forumData.getSignData().count_sign_num;
                this.fPQ = forumData.getSignData().miss_sign_num;
            }
            this.fPR = forumData.getCurScore();
            this.fMk = forumData.getLevelupScore();
            this.fPI = forumData.getBadgeData();
            this.fPM = forumData.getAccelerateContent();
            this.fPW = forumData.isBrandForum;
            this.fMO = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fPN = new bg();
            bmC();
            bmG();
        }
    }

    protected void bmC() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.bFx);
        this.fPN.adF().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmD() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        if (this.fPQ > 0) {
            com.baidu.tbadk.core.util.al.f(this.fPq, R.color.cp_cont_f, 1);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_frs_sign_add_n);
            drawable.setBounds(0, 0, g, g);
            this.fPq.setPadding(g2, 0, g2, 0);
            this.fPq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fPq.setText(String.format(this.mContext.getString(R.string.miss_sign_days), Integer.valueOf(this.fPQ)));
            com.baidu.tbadk.core.util.al.k(this.fPq, R.drawable.btn_white_alpha95_corners_selector);
        } else {
            Drawable drawable2 = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_frs_sign_n);
            com.baidu.tbadk.core.util.al.f(this.fPq, R.color.cp_cont_f, 1);
            drawable2.setBounds(0, 0, g, g);
            this.fPq.setCompoundDrawables(drawable2, null, null, null);
            this.fPq.setText(this.mContext.getString(R.string.signed));
            this.fPq.setPadding(g2, 0, g2, 0);
            this.fPq.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.al.k(this.fPq, R.drawable.btn_white_alpha95_corners_selector);
        }
        this.fPq.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds34));
        this.fPq.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bmE() {
        int g = l.g(this.mContext.getPageActivity(), R.dimen.tbds39);
        Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_frs_sign_n);
        drawable.setBounds(0, 0, g, g);
        int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds20);
        this.fPq.setPadding(g2, 0, g2, 0);
        this.fPq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fPq.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        this.fPq.setText(this.mContext.getString(R.string.sign));
        com.baidu.tbadk.core.util.al.f(this.fPq, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fPq, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void bmF() {
        this.fPp.setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        com.baidu.tbadk.core.util.al.f(this.fPp, R.color.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fPp, R.drawable.btn_white_alpha95_corners_selector);
    }

    protected void bmG() {
        if (this.fPn != null) {
            this.fPn.setText(ap.aI(this.mMemberNum));
        }
        if (this.fPo != null) {
            this.fPo.setText(ap.aI(this.fPO));
        }
        if (this.fPI != null && this.fPI.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fPW) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(R.string.forum);
        if (this.fap != null) {
            this.fap.setText(str);
        }
        if (this.fnH != null) {
            this.fnH.setText(str);
        }
        bmL();
        this.fwL = bmK();
        if (this.fwL) {
            this.fLb.setVisibility(8);
            this.dGk.setVisibility(0);
        } else {
            this.dGk.setVisibility(8);
            this.fLb.setVisibility(0);
            this.eQO.setOnClickListener(null);
        }
        bmJ();
        rC(TbadkCoreApplication.getInst().getSkinType());
        H(this.fwL, bmI());
    }

    private void H(boolean z, boolean z2) {
        e wX = d.bpM().wX(this.mForumName);
        if (wX == null) {
            wX = new e(this.fwM, z2);
        } else {
            wX.kB(this.fwM);
            wX.kC(z2);
        }
        d.bpM().a(this.mForumName, wX);
        I(z, z2);
        J(z, z2);
    }

    private void I(boolean z, boolean z2) {
        int g;
        if (this.fPz != null && this.fPz.getLayoutParams() != null) {
            if (!z && !z2) {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds487);
            } else {
                g = l.g(this.mContext.getPageActivity(), R.dimen.tbds600);
            }
            ViewGroup.LayoutParams layoutParams = this.fPz.getLayoutParams();
            if (layoutParams.height != g) {
                layoutParams.height = g;
                this.fPz.setLayoutParams(layoutParams);
            }
        }
    }

    private void J(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bmH = bmH();
        if (bmH != null) {
            bmH.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fwN != null) {
            RelativeLayout relativeLayout = this.fwN;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bmH() {
        if (this.fqI == null || this.fqI.bjK() == null) {
            return null;
        }
        View bqG = this.fqI.bjK().bqG();
        if (bqG instanceof LinearGradientView) {
            return (LinearGradientView) bqG;
        }
        return null;
    }

    private boolean bmI() {
        return this.fPA != null && this.fPA.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmJ() {
        if (this.fqI != null && this.fMO != null) {
            List<m> showTopThreadList = this.fMO.getShowTopThreadList();
            this.fwM = showTopThreadList.size() > 2;
            bZ(showTopThreadList);
        }
    }

    private void bZ(List<m> list) {
        if (this.fPA != null) {
            if (!v.aa(list)) {
                this.fPA.setVisibility(0);
                this.fPA.setFragmentUniqueId(this.fqI.getUniqueId());
                this.fPA.setForum(this.mForumId, this.mForumName);
                this.fPA.setDatas(list);
                if (this.fwK == null) {
                    this.fwK = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ab(bg bgVar) {
                            h.a(b.this.fqI, b.this.fMO, bgVar);
                        }
                    };
                }
                this.fPA.setStatListener(this.fwK);
                return;
            }
            this.fPA.setVisibility(8);
        }
    }

    private boolean bmK() {
        if (this.fMO == null) {
            return false;
        }
        final FrsViewData frsViewData = this.fMO;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().clE())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().clE());
        } else if (frsViewData.getActivityHeadData() != null && v.Z(frsViewData.getActivityHeadData().abJ()) >= 1) {
            sVar = frsViewData.getActivityHeadData().abJ().get(0);
        }
        if (sVar != null) {
            if (this.eQO != null) {
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().abK())) {
                    am amVar = new am("c13326");
                    amVar.bT("fid", frsViewData.getForum().getId());
                    amVar.bT(VideoPlayActivityConfig.OBJ_ID, frsViewData.getActivityHeadData().abK());
                    TiebaStatic.log(amVar);
                }
                this.eQO.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eQO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
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
        if (this.fMO != null && this.fMO.getForum() != null && (themeColorInfo = (forum = this.fMO.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fwL) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bmH = bmH();
                if (this.fLb != null && bmH != null) {
                    this.fLb.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bmH.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eQO != null) {
                    this.eQO.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fPA != null) {
                String str = themeElement.font_color;
                this.fPA.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.parseColor(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bmL() {
        this.fPG.startLoad(this.bFx, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fQc);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fPB);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds100));
            }
            this.fPC = (TextView) this.fPB.findViewById(R.id.cur_experience);
            this.fPD = (TextView) this.fPB.findViewById(R.id.levelup_experience);
            com.baidu.tbadk.core.util.al.k(this.fPB.findViewById(R.id.experience_container), R.drawable.icon_frs_experience_number);
            com.baidu.tbadk.core.util.al.f((TextView) this.fPB.findViewById(R.id.experience), R.color.cp_cont_g, 1);
            com.baidu.tbadk.core.util.al.f(this.fPC, R.color.common_color_10047, 1);
            com.baidu.tbadk.core.util.al.f(this.fPD, R.color.cp_cont_g, 1);
            a(this.fPC, this.fPD);
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
            this.mHandler.postDelayed(this.fQc, 2000L);
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
            if (!TextUtils.isEmpty(this.fPM) && !TextUtils.isEmpty(this.fPM.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fPM);
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
    public void bmM() {
        View contentView;
        if (this.fPF == null) {
            this.fPF = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(R.layout.speed_tip, (ViewGroup) null);
            this.fPF.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fPF, b.this.mContext.getPageActivity());
                        b.this.fqI.foC = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(R.string.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fPF.setWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds300));
            this.fPF.setHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds88));
            this.fPF.setBackgroundDrawable(new BitmapDrawable());
            this.fPF.setOutsideTouchable(true);
            this.fPF.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fPF);
                        b.this.fqI.foC = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fPF.getContentView();
        }
        com.baidu.tbadk.core.util.al.f((TextView) contentView.findViewById(R.id.mem), R.color.cp_btn_a, 1);
        com.baidu.tbadk.core.util.al.f((TextView) contentView.findViewById(R.id.speed), R.color.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.al.f((TextView) contentView.findViewById(R.id.tequan), R.color.cp_btn_a, 1);
        int[] iArr = new int[2];
        this.fPE.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fPF, this.mParent, 0, (iArr[0] - (this.fPF.getWidth() / 2)) + (this.fPE.getWidth() / 2), iArr[1] + this.fPE.getWidth());
        this.fPF.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fPV = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fPr != null && this.flG != null && this.fPx != null && cashBitmap.getWidth() > 0) {
            if (this.fPV) {
                this.fPr.setText(R.string.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bkj = this.fqI.bkj();
                if (bkj != null && bkj.getForum() != null) {
                    bkj.getForum().setUser_level(i);
                }
                this.fPx.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(i)));
            } else {
                this.fPr.setText(this.fPK);
                this.fPx.setText(this.mContext.getResources().getString(R.string.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.flG.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, qL(this.mLevel)));
            if (this.fPV) {
                if (f >= 1.0f) {
                    a(this.fqI.getBaseFragmentActivity(), this.flG, this.fPX, f);
                } else {
                    b(this.fqI.getBaseFragmentActivity(), this.flG, this.fPX, f);
                }
            } else {
                a(this.fqI.getBaseFragmentActivity(), this.flG, this.fPX, f);
            }
            this.fPX = f;
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
    protected void bmN() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bmO() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.al.c(this.fPE, (int) R.drawable.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.al.c(this.fPE, (int) R.drawable.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fPF != null && this.fPF.isShowing()) {
            this.fPF.dismiss();
        }
    }
}
