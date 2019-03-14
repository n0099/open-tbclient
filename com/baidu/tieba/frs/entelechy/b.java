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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.brand.relationbar.RelationBarView;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.frs.f.h;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.OriForumInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.view.b {
    private String byi;
    private RelativeLayout cMr;
    private View dvE;
    private TextView fgC;
    private TextView fgD;
    private al fgF;
    private RelationBarView fgG;
    private boolean fgH;
    private RelativeLayout fgJ;
    private boolean fgI = false;
    private ArrayList<TbImageView> fgE = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.faG = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fyC = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.fyD = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.fyE = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bfj();
        this.cMr = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.fyR = (RelativeLayout) this.mParent.findViewById(d.g.head_top_bg_container);
        this.fuy = (LinearGradientView) this.mParent.findViewById(d.g.head_top_gradient_bg);
        this.eBx = (TbImageView) this.mParent.findViewById(d.g.head_top_bg_mask);
        this.eBx.setPageId(this.faG.getUniqueId());
        this.eBx.setDefaultBgResource(d.C0277d.transparent);
        this.eBx.setDefaultResource(d.f.pic_frs_head_default);
        this.eBx.setDefaultErrorResource(d.f.pic_frs_head_default);
        this.dvE = this.mParent.findViewById(d.g.header_top_cover);
        this.fgJ = (RelativeLayout) this.mParent.findViewById(d.g.layout_banner_container);
        this.fyS = (FrsTopView) this.mParent.findViewById(d.g.frs_topview);
        this.fgG = (RelationBarView) this.mParent.findViewById(d.g.frs_brand_relation_bar_list);
        this.fyW = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.fgC = (TextView) this.mParent.findViewById(d.g.member_image);
        this.fgD = (TextView) this.mParent.findViewById(d.g.post_image);
        this.fyJ = (TextView) this.mParent.findViewById(d.g.level_name);
        this.fyP = (TextView) this.mParent.findViewById(d.g.level);
        this.fyH = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.fyI = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.fyI.setContentDescription(frsFragment.getResources().getString(d.j.sign));
        this.eVJ = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.eVK = (ImageView) this.mParent.findViewById(d.g.love_level_bg);
        this.fyF = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.fyG = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.eXO = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.fyL = (TextView) this.mParent.findViewById(d.g.brand_label);
        this.fyY = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.fyY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fyY.setPageId(this.faG.getUniqueId());
        this.fyY.setContentDescription(frsFragment.getResources().getString(d.j.bar_header));
        this.fyY.setStrokeWith(l.h(TbadkCoreApplication.getInst(), d.e.tbds4));
        this.fyY.setShowOval(true);
        this.fyO = this.mParent.findViewById(d.g.level_container);
        this.fyN = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.fyM = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.fyQ = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.fzb = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fyT = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        this.fyK = LayoutInflater.from(this.faG.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        this.fyK.setVisibility(8);
    }

    protected View bfj() {
        return LayoutInflater.from(this.faG.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void t(View.OnClickListener onClickListener) {
        this.fyY.setOnClickListener(onClickListener);
        this.eXO.setOnClickListener(onClickListener);
        this.fyI.setOnClickListener(onClickListener);
        this.fyH.setOnClickListener(onClickListener);
        this.fyO.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfk() {
        this.fyL.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fyT);
        this.mContext.getLayoutMode().onModeChanged(this.fyK);
        com.baidu.tbadk.core.util.al.k(this.eVJ, d.f.frs_exp_progress);
        com.baidu.tbadk.core.util.al.l(this.eVK, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.l(this.fyQ, d.C0277d.black_alpha0);
        com.baidu.tbadk.core.util.al.l(this.cMr, d.C0277d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.eXO, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyP, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyJ, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fgC, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyF, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fgD, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyG, d.C0277d.cp_btn_a);
        if (this.fyY != null) {
            this.fyY.setBorderWidth(l.h(this.mContext.getPageActivity(), d.e.tbds1));
            this.fyY.setBorderColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.black_alpha15));
            this.fyY.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            this.fyY.invalidate();
        }
        if (this.fyZ != null) {
            this.fyZ.ij(i);
        }
        if (this.fuy != null) {
            this.fuy.changeSkinType(i);
        }
        if (this.fgG != null) {
            this.fgG.onChangeSkinType();
        }
        Iterator<TbImageView> it = this.fgE.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bfx();
        rS(this.fzm ? 1 : 0);
        bfo();
        qy(i);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fzg = forumData.getPost_num();
            this.fzd = forumData.getTag_color();
            this.byi = forumData.getImage_url();
            this.fzc = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fzh = forumData.getSignData().count_sign_num;
                this.fzi = forumData.getSignData().miss_sign_num;
            }
            this.fzj = forumData.getCurScore();
            this.fvH = forumData.getLevelupScore();
            this.fza = forumData.getBadgeData();
            this.fze = forumData.getAccelerateContent();
            this.fzo = forumData.isBrandForum;
            this.fwm = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fzf = new bg();
            bfl();
            bfp();
            if (this.fwm != null && this.fwm.isBrandForum) {
                bU(this.fwm.oriForumInfoList);
            }
        }
    }

    protected void bfl() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.byi);
        this.fzf.Zb().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bfm() {
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds39);
        if (this.fzi > 0) {
            com.baidu.tbadk.core.util.al.d(this.fyI, d.C0277d.cp_cont_f, 1);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_add_n);
            drawable.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), d.e.tbds20);
            this.fyI.setPadding(h2, 0, h2, 0);
            this.fyI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fyI.setText(String.format(this.mContext.getString(d.j.miss_sign_days), Integer.valueOf(this.fzi)));
            com.baidu.tbadk.core.util.al.k(this.fyI, d.f.btn_white_alpha95_corners_selector);
        } else {
            Drawable drawable2 = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_end_n);
            com.baidu.tbadk.core.util.al.d(this.fyI, d.C0277d.cp_btn_a, 1);
            drawable2.setBounds(0, 0, h, h);
            this.fyI.setCompoundDrawables(drawable2, null, null, null);
            this.fyI.setText(this.mContext.getString(d.j.signed));
            this.fyI.setPadding(0, 0, 0, 0);
            this.fyI.setBackgroundDrawable(null);
        }
        this.fyI.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds34));
        this.fyI.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bfn() {
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds39);
        Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_n);
        drawable.setBounds(0, 0, h, h);
        int h2 = l.h(this.mContext.getPageActivity(), d.e.tbds20);
        this.fyI.setPadding(h2, 0, h2, 0);
        this.fyI.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fyI.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.fyI.setText(this.mContext.getString(d.j.sign));
        com.baidu.tbadk.core.util.al.d(this.fyI, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fyI, d.f.btn_white_alpha95_corners_selector);
    }

    protected void bfo() {
        this.fyH.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        com.baidu.tbadk.core.util.al.d(this.fyH, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fyH, d.f.btn_white_alpha95_corners_selector);
    }

    protected void bfp() {
        if (this.fyF != null) {
            this.fyF.setText(ap.au(this.mMemberNum));
        }
        if (this.fyG != null) {
            this.fyG.setText(ap.au(this.fzg));
        }
        if (this.fza != null && this.fza.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fzo) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(d.j.forum);
        if (this.eKt != null) {
            this.eKt.setText(str);
        }
        if (this.eXO != null) {
            this.eXO.setText(str);
        }
        bfu();
        this.fgH = bft();
        if (this.fgH) {
            this.fuy.setVisibility(8);
            this.dvE.setVisibility(0);
        } else {
            this.dvE.setVisibility(8);
            this.fuy.setVisibility(0);
            this.eBx.setOnClickListener(null);
        }
        bfs();
        qy(TbadkCoreApplication.getInst().getSkinType());
        I(this.fgH, bfr());
    }

    private void I(boolean z, boolean z2) {
        com.baidu.tieba.frs.e.d.biy().a(this.mForumName, new e(this.fgI, z2));
        J(z, z2);
        K(z, z2);
    }

    private void J(boolean z, boolean z2) {
        int h;
        if (this.fyR != null && this.fyR.getLayoutParams() != null) {
            if (!z && !z2) {
                h = l.h(this.mContext.getPageActivity(), d.e.tbds487);
            } else {
                h = l.h(this.mContext.getPageActivity(), d.e.tbds600);
            }
            ViewGroup.LayoutParams layoutParams = this.fyR.getLayoutParams();
            if (layoutParams.height != h) {
                layoutParams.height = h;
                this.fyR.setLayoutParams(layoutParams);
            }
        }
    }

    private void K(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bfq = bfq();
        if (bfq != null) {
            bfq.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fgJ != null) {
            RelativeLayout relativeLayout = this.fgJ;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bfq() {
        if (this.faG == null || this.faG.bcs() == null) {
            return null;
        }
        View bjq = this.faG.bcs().bjq();
        if (bjq instanceof LinearGradientView) {
            return (LinearGradientView) bjq;
        }
        return null;
    }

    private boolean bfr() {
        return this.fyS != null && this.fyS.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfs() {
        if (this.faG != null && this.fwm != null) {
            List<m> showTopThreadList = this.fwm.getShowTopThreadList();
            this.fgI = showTopThreadList.size() > 2;
            bT(showTopThreadList);
        }
    }

    private void bT(List<m> list) {
        if (this.fyS != null) {
            if (!v.T(list)) {
                this.fyS.setVisibility(0);
                this.fyS.setFragmentUniqueId(this.faG.getUniqueId());
                this.fyS.setForum(this.mForumId, this.mForumName);
                this.fyS.setDatas(list);
                if (this.fgF == null) {
                    this.fgF = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ac(bg bgVar) {
                            h.a(b.this.faG, b.this.fwm, bgVar);
                        }
                    };
                }
                this.fyS.setStatListener(this.fgF);
                return;
            }
            this.fyS.setVisibility(8);
        }
    }

    private boolean bft() {
        if (this.fwm == null) {
            return false;
        }
        FrsViewData frsViewData = this.fwm;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cdD())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().cdD());
        } else if (frsViewData.getActivityHeadData() != null && v.S(frsViewData.getActivityHeadData().Xf()) >= 1) {
            sVar = frsViewData.getActivityHeadData().Xf().get(0);
        }
        if (sVar != null) {
            if (this.eBx != null) {
                this.eBx.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.mContext != null) {
                                ba.adD().a(b.this.mContext, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void qy(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fwm != null && this.fwm.getForum() != null && (themeColorInfo = (forum = this.fwm.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fgH) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bfq = bfq();
                if (this.fuy != null && bfq != null) {
                    this.fuy.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bfq.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eBx != null) {
                    this.eBx.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fyS != null) {
                String str = themeElement.font_color;
                this.fyS.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.parseColor(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bfu() {
        this.fyY.startLoad(this.byi, 10, false);
    }

    private void bU(List<OriForumInfo> list) {
        if (this.fgG != null) {
            if (l.aQ(this.mContext.getPageActivity()) <= 1280) {
                this.fgG.setVisibility(8);
            } else {
                this.fgG.setData(list);
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fzu);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fyT);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds100));
            }
            this.fyU = (TextView) this.fyT.findViewById(d.g.cur_experience);
            this.fyV = (TextView) this.fyT.findViewById(d.g.levelup_experience);
            com.baidu.tbadk.core.util.al.k(this.fyT.findViewById(d.g.experience_container), d.f.icon_frs_experience_number);
            com.baidu.tbadk.core.util.al.d((TextView) this.fyT.findViewById(d.g.experience), d.C0277d.cp_cont_g, 1);
            com.baidu.tbadk.core.util.al.d(this.fyU, d.C0277d.common_color_10047, 1);
            com.baidu.tbadk.core.util.al.d(this.fyV, d.C0277d.cp_cont_g, 1);
            a(this.fyU, this.fyV);
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
            this.mHandler.postDelayed(this.fzu, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            com.baidu.tbadk.core.util.al.d((TextView) inflate.findViewById(d.g.experience_txt), d.C0277d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(textView, d.C0277d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(textView2, d.C0277d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(textView3, d.C0277d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.az(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.fze) && !TextUtils.isEmpty(this.fze.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fze);
            } else {
                textView3.setVisibility(8);
            }
            aVar.gE(d.C0277d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.aaZ();
        }
    }

    protected void b(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
    }

    protected void c(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.frs.entelechy.b.4
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
    public void bfv() {
        View contentView;
        if (this.fyX == null) {
            this.fyX = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.fyX.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fyX, b.this.mContext.getPageActivity());
                        b.this.faG.eYF = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fyX.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds300));
            this.fyX.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds88));
            this.fyX.setBackgroundDrawable(new BitmapDrawable());
            this.fyX.setOutsideTouchable(true);
            this.fyX.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fyX);
                        b.this.faG.eYF = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fyX.getContentView();
        }
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.mem), d.C0277d.cp_btn_a, 1);
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.speed), d.C0277d.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.tequan), d.C0277d.cp_btn_a, 1);
        int[] iArr = new int[2];
        this.fyW.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fyX, this.mParent, 0, (iArr[0] - (this.fyX.getWidth() / 2)) + (this.fyW.getWidth() / 2), iArr[1] + this.fyW.getWidth());
        this.fyX.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fzn = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fyJ != null && this.eVJ != null && this.fyP != null && cashBitmap.getWidth() > 0) {
            if (this.fzn) {
                this.fyJ.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bcR = this.faG.bcR();
                if (bcR != null && bcR.getForum() != null) {
                    bcR.getForum().setUser_level(i);
                }
                this.fyP.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.fyJ.setText(this.fzc);
                this.fyP.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.eVJ.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, pJ(this.mLevel)));
            if (this.fzn) {
                if (f >= 1.0f) {
                    a(this.faG.getBaseFragmentActivity(), this.eVJ, this.fzp, f);
                } else {
                    b(this.faG.getBaseFragmentActivity(), this.eVJ, this.fzp, f);
                }
            } else {
                a(this.faG.getBaseFragmentActivity(), this.eVJ, this.fzp, f);
            }
            this.fzp = f;
        }
    }

    private int[] pJ(int i) {
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
    protected void bfw() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfx() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.al.c(this.fyW, d.f.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.al.c(this.fyW, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyX != null && this.fyX.isShowing()) {
            this.fyX.dismiss();
        }
    }
}
