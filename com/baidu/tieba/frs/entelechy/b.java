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
    private String byg;
    private RelativeLayout cMu;
    private View dvI;
    private TextView fgD;
    private TextView fgE;
    private al fgG;
    private RelationBarView fgH;
    private boolean fgI;
    private RelativeLayout fgK;
    private boolean fgJ = false;
    private ArrayList<TbImageView> fgF = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.faH = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fyD = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.fyE = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.fyF = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bfj();
        this.cMu = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.fyS = (RelativeLayout) this.mParent.findViewById(d.g.head_top_bg_container);
        this.fuz = (LinearGradientView) this.mParent.findViewById(d.g.head_top_gradient_bg);
        this.eBB = (TbImageView) this.mParent.findViewById(d.g.head_top_bg_mask);
        this.eBB.setPageId(this.faH.getUniqueId());
        this.eBB.setDefaultBgResource(d.C0236d.transparent);
        this.eBB.setDefaultResource(d.f.pic_frs_head_default);
        this.eBB.setDefaultErrorResource(d.f.pic_frs_head_default);
        this.dvI = this.mParent.findViewById(d.g.header_top_cover);
        this.fgK = (RelativeLayout) this.mParent.findViewById(d.g.layout_banner_container);
        this.fyT = (FrsTopView) this.mParent.findViewById(d.g.frs_topview);
        this.fgH = (RelationBarView) this.mParent.findViewById(d.g.frs_brand_relation_bar_list);
        this.fyX = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.fgD = (TextView) this.mParent.findViewById(d.g.member_image);
        this.fgE = (TextView) this.mParent.findViewById(d.g.post_image);
        this.fyK = (TextView) this.mParent.findViewById(d.g.level_name);
        this.fyQ = (TextView) this.mParent.findViewById(d.g.level);
        this.fyI = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.fyJ = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.fyJ.setContentDescription(frsFragment.getResources().getString(d.j.sign));
        this.eVN = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.eVO = (ImageView) this.mParent.findViewById(d.g.love_level_bg);
        this.fyG = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.fyH = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.eXP = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.fyM = (TextView) this.mParent.findViewById(d.g.brand_label);
        this.fyZ = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.fyZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fyZ.setPageId(this.faH.getUniqueId());
        this.fyZ.setContentDescription(frsFragment.getResources().getString(d.j.bar_header));
        this.fyZ.setStrokeWith(l.h(TbadkCoreApplication.getInst(), d.e.tbds4));
        this.fyZ.setShowOval(true);
        this.fyP = this.mParent.findViewById(d.g.level_container);
        this.fyO = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.fyN = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.fyR = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.fzc = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fyU = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        this.fyL = LayoutInflater.from(this.faH.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        this.fyL.setVisibility(8);
    }

    protected View bfj() {
        return LayoutInflater.from(this.faH.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void t(View.OnClickListener onClickListener) {
        this.fyZ.setOnClickListener(onClickListener);
        this.eXP.setOnClickListener(onClickListener);
        this.fyJ.setOnClickListener(onClickListener);
        this.fyI.setOnClickListener(onClickListener);
        this.fyP.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfk() {
        this.fyM.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fyU);
        this.mContext.getLayoutMode().onModeChanged(this.fyL);
        com.baidu.tbadk.core.util.al.k(this.eVN, d.f.frs_exp_progress);
        com.baidu.tbadk.core.util.al.l(this.eVO, d.C0236d.cp_btn_a);
        com.baidu.tbadk.core.util.al.l(this.fyR, d.C0236d.black_alpha0);
        com.baidu.tbadk.core.util.al.l(this.cMu, d.C0236d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.eXP, d.C0236d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyQ, d.C0236d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyK, d.C0236d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fgD, d.C0236d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyG, d.C0236d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fgE, d.C0236d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyH, d.C0236d.cp_btn_a);
        if (this.fyZ != null) {
            this.fyZ.setBorderWidth(l.h(this.mContext.getPageActivity(), d.e.tbds1));
            this.fyZ.setBorderColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.black_alpha15));
            this.fyZ.setStrokeColorResId(d.C0236d.cp_bg_line_d);
            this.fyZ.invalidate();
        }
        if (this.fza != null) {
            this.fza.ij(i);
        }
        if (this.fuz != null) {
            this.fuz.changeSkinType(i);
        }
        if (this.fgH != null) {
            this.fgH.onChangeSkinType();
        }
        Iterator<TbImageView> it = this.fgF.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bfx();
        rS(this.fzn ? 1 : 0);
        bfo();
        qy(i);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fzh = forumData.getPost_num();
            this.fze = forumData.getTag_color();
            this.byg = forumData.getImage_url();
            this.fzd = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fzi = forumData.getSignData().count_sign_num;
                this.fzj = forumData.getSignData().miss_sign_num;
            }
            this.fzk = forumData.getCurScore();
            this.fvI = forumData.getLevelupScore();
            this.fzb = forumData.getBadgeData();
            this.fzf = forumData.getAccelerateContent();
            this.fzp = forumData.isBrandForum;
            this.fwn = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fzg = new bg();
            bfl();
            bfp();
            if (this.fwn != null && this.fwn.isBrandForum) {
                bU(this.fwn.oriForumInfoList);
            }
        }
    }

    protected void bfl() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.byg);
        this.fzg.Zb().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bfm() {
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds39);
        if (this.fzj > 0) {
            com.baidu.tbadk.core.util.al.d(this.fyJ, d.C0236d.cp_cont_f, 1);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_add_n);
            drawable.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), d.e.tbds20);
            this.fyJ.setPadding(h2, 0, h2, 0);
            this.fyJ.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fyJ.setText(String.format(this.mContext.getString(d.j.miss_sign_days), Integer.valueOf(this.fzj)));
            com.baidu.tbadk.core.util.al.k(this.fyJ, d.f.btn_white_alpha95_corners_selector);
        } else {
            Drawable drawable2 = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_end_n);
            com.baidu.tbadk.core.util.al.d(this.fyJ, d.C0236d.cp_btn_a, 1);
            drawable2.setBounds(0, 0, h, h);
            this.fyJ.setCompoundDrawables(drawable2, null, null, null);
            this.fyJ.setText(this.mContext.getString(d.j.signed));
            this.fyJ.setPadding(0, 0, 0, 0);
            this.fyJ.setBackgroundDrawable(null);
        }
        this.fyJ.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds34));
        this.fyJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bfn() {
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds39);
        Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_n);
        drawable.setBounds(0, 0, h, h);
        int h2 = l.h(this.mContext.getPageActivity(), d.e.tbds20);
        this.fyJ.setPadding(h2, 0, h2, 0);
        this.fyJ.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fyJ.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.fyJ.setText(this.mContext.getString(d.j.sign));
        com.baidu.tbadk.core.util.al.d(this.fyJ, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fyJ, d.f.btn_white_alpha95_corners_selector);
    }

    protected void bfo() {
        this.fyI.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        com.baidu.tbadk.core.util.al.d(this.fyI, d.C0236d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fyI, d.f.btn_white_alpha95_corners_selector);
    }

    protected void bfp() {
        if (this.fyG != null) {
            this.fyG.setText(ap.au(this.mMemberNum));
        }
        if (this.fyH != null) {
            this.fyH.setText(ap.au(this.fzh));
        }
        if (this.fzb != null && this.fzb.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fzp) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(d.j.forum);
        if (this.eKx != null) {
            this.eKx.setText(str);
        }
        if (this.eXP != null) {
            this.eXP.setText(str);
        }
        bfu();
        this.fgI = bft();
        if (this.fgI) {
            this.fuz.setVisibility(8);
            this.dvI.setVisibility(0);
        } else {
            this.dvI.setVisibility(8);
            this.fuz.setVisibility(0);
            this.eBB.setOnClickListener(null);
        }
        bfs();
        qy(TbadkCoreApplication.getInst().getSkinType());
        I(this.fgI, bfr());
    }

    private void I(boolean z, boolean z2) {
        com.baidu.tieba.frs.e.d.biy().a(this.mForumName, new e(this.fgJ, z2));
        J(z, z2);
        K(z, z2);
    }

    private void J(boolean z, boolean z2) {
        int h;
        if (this.fyS != null && this.fyS.getLayoutParams() != null) {
            if (!z && !z2) {
                h = l.h(this.mContext.getPageActivity(), d.e.tbds487);
            } else {
                h = l.h(this.mContext.getPageActivity(), d.e.tbds600);
            }
            ViewGroup.LayoutParams layoutParams = this.fyS.getLayoutParams();
            if (layoutParams.height != h) {
                layoutParams.height = h;
                this.fyS.setLayoutParams(layoutParams);
            }
        }
    }

    private void K(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bfq = bfq();
        if (bfq != null) {
            bfq.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fgK != null) {
            RelativeLayout relativeLayout = this.fgK;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bfq() {
        if (this.faH == null || this.faH.bcs() == null) {
            return null;
        }
        View bjq = this.faH.bcs().bjq();
        if (bjq instanceof LinearGradientView) {
            return (LinearGradientView) bjq;
        }
        return null;
    }

    private boolean bfr() {
        return this.fyT != null && this.fyT.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfs() {
        if (this.faH != null && this.fwn != null) {
            List<m> showTopThreadList = this.fwn.getShowTopThreadList();
            this.fgJ = showTopThreadList.size() > 2;
            bT(showTopThreadList);
        }
    }

    private void bT(List<m> list) {
        if (this.fyT != null) {
            if (!v.T(list)) {
                this.fyT.setVisibility(0);
                this.fyT.setFragmentUniqueId(this.faH.getUniqueId());
                this.fyT.setForum(this.mForumId, this.mForumName);
                this.fyT.setDatas(list);
                if (this.fgG == null) {
                    this.fgG = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ac(bg bgVar) {
                            h.a(b.this.faH, b.this.fwn, bgVar);
                        }
                    };
                }
                this.fyT.setStatListener(this.fgG);
                return;
            }
            this.fyT.setVisibility(8);
        }
    }

    private boolean bft() {
        if (this.fwn == null) {
            return false;
        }
        FrsViewData frsViewData = this.fwn;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cdA())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().cdA());
        } else if (frsViewData.getActivityHeadData() != null && v.S(frsViewData.getActivityHeadData().Xf()) >= 1) {
            sVar = frsViewData.getActivityHeadData().Xf().get(0);
        }
        if (sVar != null) {
            if (this.eBB != null) {
                this.eBB.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eBB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
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
        if (this.fwn != null && this.fwn.getForum() != null && (themeColorInfo = (forum = this.fwn.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fgI) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bfq = bfq();
                if (this.fuz != null && bfq != null) {
                    this.fuz.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bfq.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eBB != null) {
                    this.eBB.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fyT != null) {
                String str = themeElement.font_color;
                this.fyT.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.parseColor(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bfu() {
        this.fyZ.startLoad(this.byg, 10, false);
    }

    private void bU(List<OriForumInfo> list) {
        if (this.fgH != null) {
            if (l.aQ(this.mContext.getPageActivity()) <= 1280) {
                this.fgH.setVisibility(8);
            } else {
                this.fgH.setData(list);
            }
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fzv);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fyU);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds100));
            }
            this.fyV = (TextView) this.fyU.findViewById(d.g.cur_experience);
            this.fyW = (TextView) this.fyU.findViewById(d.g.levelup_experience);
            com.baidu.tbadk.core.util.al.k(this.fyU.findViewById(d.g.experience_container), d.f.icon_frs_experience_number);
            com.baidu.tbadk.core.util.al.d((TextView) this.fyU.findViewById(d.g.experience), d.C0236d.cp_cont_g, 1);
            com.baidu.tbadk.core.util.al.d(this.fyV, d.C0236d.common_color_10047, 1);
            com.baidu.tbadk.core.util.al.d(this.fyW, d.C0236d.cp_cont_g, 1);
            a(this.fyV, this.fyW);
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
            this.mHandler.postDelayed(this.fzv, 2000L);
        } else if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(d.g.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(d.g.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(d.g.speed_tip);
            com.baidu.tbadk.core.util.al.d((TextView) inflate.findViewById(d.g.experience_txt), d.C0236d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(textView, d.C0236d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(textView2, d.C0236d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.d(textView3, d.C0236d.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.az(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.fzf) && !TextUtils.isEmpty(this.fzf.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fzf);
            } else {
                textView3.setVisibility(8);
            }
            aVar.gE(d.C0236d.cp_link_tip_d);
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
        if (this.fyY == null) {
            this.fyY = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.fyY.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fyY, b.this.mContext.getPageActivity());
                        b.this.faH.eYG = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fyY.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds300));
            this.fyY.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds88));
            this.fyY.setBackgroundDrawable(new BitmapDrawable());
            this.fyY.setOutsideTouchable(true);
            this.fyY.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fyY);
                        b.this.faH.eYG = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fyY.getContentView();
        }
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.mem), d.C0236d.cp_btn_a, 1);
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.speed), d.C0236d.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.tequan), d.C0236d.cp_btn_a, 1);
        int[] iArr = new int[2];
        this.fyX.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fyY, this.mParent, 0, (iArr[0] - (this.fyY.getWidth() / 2)) + (this.fyX.getWidth() / 2), iArr[1] + this.fyX.getWidth());
        this.fyY.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fzo = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fyK != null && this.eVN != null && this.fyQ != null && cashBitmap.getWidth() > 0) {
            if (this.fzo) {
                this.fyK.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bcR = this.faH.bcR();
                if (bcR != null && bcR.getForum() != null) {
                    bcR.getForum().setUser_level(i);
                }
                this.fyQ.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.fyK.setText(this.fzd);
                this.fyQ.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.eVN.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, pJ(this.mLevel)));
            if (this.fzo) {
                if (f >= 1.0f) {
                    a(this.faH.getBaseFragmentActivity(), this.eVN, this.fzq, f);
                } else {
                    b(this.faH.getBaseFragmentActivity(), this.eVN, this.fzq, f);
                }
            } else {
                a(this.faH.getBaseFragmentActivity(), this.eVN, this.fzq, f);
            }
            this.fzq = f;
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
            com.baidu.tbadk.core.util.al.c(this.fyX, d.f.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.al.c(this.fyX, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyY != null && this.fyY.isShowing()) {
            this.fyY.dismiss();
        }
    }
}
