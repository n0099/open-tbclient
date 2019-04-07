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
    private String byl;
    private RelativeLayout cMt;
    private View dvJ;
    private TextView fgp;
    private TextView fgq;
    private al fgs;
    private boolean fgt;
    private RelativeLayout fgv;
    private boolean fgu = false;
    private ArrayList<TbImageView> fgr = new ArrayList<>();

    public b(FrsFragment frsFragment, String str, String str2, int i) {
        this.mMemberType = i;
        this.mHandler = new Handler();
        this.fat = frsFragment;
        this.mContext = frsFragment.getPageContext();
        this.fyq = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds20);
        this.fyr = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds72);
        this.fys = l.h(frsFragment.getPageContext().getPageActivity(), d.e.ds150);
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = bfh();
        this.cMt = (RelativeLayout) this.mParent.findViewById(d.g.container);
        this.fyF = (RelativeLayout) this.mParent.findViewById(d.g.head_top_bg_container);
        this.fuk = (LinearGradientView) this.mParent.findViewById(d.g.head_top_gradient_bg);
        this.eBi = (TbImageView) this.mParent.findViewById(d.g.head_top_bg_mask);
        this.eBi.setPageId(this.fat.getUniqueId());
        this.eBi.setDefaultBgResource(d.C0277d.transparent);
        this.eBi.setDefaultResource(d.f.pic_frs_head_default);
        this.eBi.setDefaultErrorResource(d.f.pic_frs_head_default);
        this.dvJ = this.mParent.findViewById(d.g.header_top_cover);
        this.fgv = (RelativeLayout) this.mParent.findViewById(d.g.layout_banner_container);
        this.fyG = (FrsTopView) this.mParent.findViewById(d.g.frs_topview);
        this.fyK = (ImageView) this.mParent.findViewById(d.g.speed_icon);
        this.fgp = (TextView) this.mParent.findViewById(d.g.member_image);
        this.fgq = (TextView) this.mParent.findViewById(d.g.post_image);
        this.fyx = (TextView) this.mParent.findViewById(d.g.level_name);
        this.fyD = (TextView) this.mParent.findViewById(d.g.level);
        this.fyv = (TextView) this.mParent.findViewById(d.g.tv_love);
        this.fyw = (TextView) this.mParent.findViewById(d.g.tv_sign);
        this.fyw.setContentDescription(frsFragment.getResources().getString(d.j.sign));
        this.eVv = (ImageView) this.mParent.findViewById(d.g.love_level_top);
        this.eVw = (ImageView) this.mParent.findViewById(d.g.love_level_bg);
        this.fyt = (TextView) this.mParent.findViewById(d.g.member_num_text);
        this.fyu = (TextView) this.mParent.findViewById(d.g.post_num_text);
        this.eXA = (TextView) this.mParent.findViewById(d.g.forum_name);
        this.fyz = (TextView) this.mParent.findViewById(d.g.brand_label);
        this.fyM = (BarImageView) this.mParent.findViewById(d.g.frs_image);
        this.fyM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fyM.setPageId(this.fat.getUniqueId());
        this.fyM.setContentDescription(frsFragment.getResources().getString(d.j.bar_header));
        this.fyM.setStrokeWith(l.h(TbadkCoreApplication.getInst(), d.e.tbds4));
        this.fyM.setShowOval(true);
        this.fyC = this.mParent.findViewById(d.g.level_container);
        this.fyB = (RelativeLayout) this.mParent.findViewById(d.g.has_focused_container);
        this.fyA = (RelativeLayout) this.mParent.findViewById(d.g.not_focused_container);
        this.fyE = (RelativeLayout) this.mParent.findViewById(d.g.head_content_container);
        this.fyP = new com.baidu.tieba.frs.f.b(this.mContext);
        this.fyH = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(d.h.frs_show_experience, (ViewGroup) null);
        this.fyy = LayoutInflater.from(this.fat.getPageContext().getPageActivity()).inflate(d.h.frs_header_extra_entelechy, (ViewGroup) null);
        this.fyy.setVisibility(8);
    }

    protected View bfh() {
        return LayoutInflater.from(this.fat.getPageContext().getPageActivity()).inflate(d.h.frs_normal_header, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void t(View.OnClickListener onClickListener) {
        this.fyM.setOnClickListener(onClickListener);
        this.eXA.setOnClickListener(onClickListener);
        this.fyw.setOnClickListener(onClickListener);
        this.fyv.setOnClickListener(onClickListener);
        this.fyC.setOnClickListener(onClickListener);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfi() {
        this.fyz.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().setNightMode(i == 1);
        this.mContext.getLayoutMode().onModeChanged(this.mParent);
        this.mContext.getLayoutMode().onModeChanged(this.fyH);
        this.mContext.getLayoutMode().onModeChanged(this.fyy);
        com.baidu.tbadk.core.util.al.k(this.eVv, d.f.frs_exp_progress);
        com.baidu.tbadk.core.util.al.l(this.eVw, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.l(this.fyE, d.C0277d.black_alpha0);
        com.baidu.tbadk.core.util.al.l(this.cMt, d.C0277d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.j(this.eXA, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyD, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyx, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fgp, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyt, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fgq, d.C0277d.cp_btn_a);
        com.baidu.tbadk.core.util.al.j(this.fyu, d.C0277d.cp_btn_a);
        if (this.fyM != null) {
            this.fyM.setBorderWidth(l.h(this.mContext.getPageActivity(), d.e.tbds1));
            this.fyM.setBorderColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.black_alpha15));
            this.fyM.setStrokeColorResId(d.C0277d.cp_bg_line_d);
            this.fyM.invalidate();
        }
        if (this.fyN != null) {
            this.fyN.ii(i);
        }
        if (this.fuk != null) {
            this.fuk.changeSkinType(i);
        }
        Iterator<TbImageView> it = this.fgr.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
        bfv();
        rO(this.fza ? 1 : 0);
        bfm();
        qu(i);
    }

    @Override // com.baidu.tieba.frs.view.b
    public void a(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.mMemberNum = forumData.getMember_num();
            this.fyU = forumData.getPost_num();
            this.fyR = forumData.getTag_color();
            this.byl = forumData.getImage_url();
            this.fyQ = forumData.getLevelName();
            this.mLevel = forumData.getUser_level();
            if (forumData.getSignData() != null) {
                this.fyV = forumData.getSignData().count_sign_num;
                this.fyW = forumData.getSignData().miss_sign_num;
            }
            this.fyX = forumData.getCurScore();
            this.fvt = forumData.getLevelupScore();
            this.fyO = forumData.getBadgeData();
            this.fyS = forumData.getAccelerateContent();
            this.fzc = forumData.isBrandForum;
            this.fvY = frsViewData;
            if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
                this.mParent.setVisibility(8);
            } else {
                this.mParent.setVisibility(0);
            }
            this.fyT = new bg();
            bfj();
            bfn();
        }
    }

    protected void bfj() {
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.byl);
        this.fyT.YY().add(mediaData);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bfk() {
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds39);
        if (this.fyW > 0) {
            com.baidu.tbadk.core.util.al.d(this.fyw, d.C0277d.cp_cont_f, 1);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_add_n);
            drawable.setBounds(0, 0, h, h);
            int h2 = l.h(this.mContext.getPageActivity(), d.e.tbds20);
            this.fyw.setPadding(h2, 0, h2, 0);
            this.fyw.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.fyw.setText(String.format(this.mContext.getString(d.j.miss_sign_days), Integer.valueOf(this.fyW)));
            com.baidu.tbadk.core.util.al.k(this.fyw, d.f.btn_white_alpha95_corners_selector);
        } else {
            Drawable drawable2 = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_end_n);
            com.baidu.tbadk.core.util.al.d(this.fyw, d.C0277d.cp_btn_a, 1);
            drawable2.setBounds(0, 0, h, h);
            this.fyw.setCompoundDrawables(drawable2, null, null, null);
            this.fyw.setText(this.mContext.getString(d.j.signed));
            this.fyw.setPadding(0, 0, 0, 0);
            this.fyw.setBackgroundDrawable(null);
        }
        this.fyw.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.tbds34));
        this.fyw.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.b
    protected void bfl() {
        int h = l.h(this.mContext.getPageActivity(), d.e.tbds39);
        Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_frs_sign_n);
        drawable.setBounds(0, 0, h, h);
        int h2 = l.h(this.mContext.getPageActivity(), d.e.tbds20);
        this.fyw.setPadding(h2, 0, h2, 0);
        this.fyw.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fyw.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        this.fyw.setText(this.mContext.getString(d.j.sign));
        com.baidu.tbadk.core.util.al.d(this.fyw, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fyw, d.f.btn_white_alpha95_corners_selector);
    }

    protected void bfm() {
        this.fyv.setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        com.baidu.tbadk.core.util.al.d(this.fyv, d.C0277d.cp_cont_f, 1);
        com.baidu.tbadk.core.util.al.k(this.fyv, d.f.btn_white_alpha95_corners_selector);
    }

    protected void bfn() {
        if (this.fyt != null) {
            this.fyt.setText(ap.au(this.mMemberNum));
        }
        if (this.fyu != null) {
            this.fyu.setText(ap.au(this.fyU));
        }
        if (this.fyO != null && this.fyO.size() > 0) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
        } else if (this.fzc) {
            this.mForumName = UtilHelper.getFixedText(this.mForumName, 6);
        }
        String str = this.mForumName + this.mContext.getString(d.j.forum);
        if (this.eKf != null) {
            this.eKf.setText(str);
        }
        if (this.eXA != null) {
            this.eXA.setText(str);
        }
        bfs();
        this.fgt = bfr();
        if (this.fgt) {
            this.fuk.setVisibility(8);
            this.dvJ.setVisibility(0);
        } else {
            this.dvJ.setVisibility(8);
            this.fuk.setVisibility(0);
            this.eBi.setOnClickListener(null);
        }
        bfq();
        qu(TbadkCoreApplication.getInst().getSkinType());
        G(this.fgt, bfp());
    }

    private void G(boolean z, boolean z2) {
        com.baidu.tieba.frs.e.d.biw().a(this.mForumName, new e(this.fgu, z2));
        H(z, z2);
        I(z, z2);
    }

    private void H(boolean z, boolean z2) {
        int h;
        if (this.fyF != null && this.fyF.getLayoutParams() != null) {
            if (!z && !z2) {
                h = l.h(this.mContext.getPageActivity(), d.e.tbds487);
            } else {
                h = l.h(this.mContext.getPageActivity(), d.e.tbds600);
            }
            ViewGroup.LayoutParams layoutParams = this.fyF.getLayoutParams();
            if (layoutParams.height != h) {
                layoutParams.height = h;
                this.fyF.setLayoutParams(layoutParams);
            }
        }
    }

    private void I(boolean z, boolean z2) {
        int i = 8;
        LinearGradientView bfo = bfo();
        if (bfo != null) {
            bfo.setVisibility((z || z2) ? 8 : 0);
        }
        if (this.fgv != null) {
            RelativeLayout relativeLayout = this.fgv;
            if (z || z2) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    private LinearGradientView bfo() {
        if (this.fat == null || this.fat.bcq() == null) {
            return null;
        }
        View bjo = this.fat.bcq().bjo();
        if (bjo instanceof LinearGradientView) {
            return (LinearGradientView) bjo;
        }
        return null;
    }

    private boolean bfp() {
        return this.fyG != null && this.fyG.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfq() {
        if (this.fat != null && this.fvY != null) {
            List<m> showTopThreadList = this.fvY.getShowTopThreadList();
            this.fgu = showTopThreadList.size() > 2;
            bR(showTopThreadList);
        }
    }

    private void bR(List<m> list) {
        if (this.fyG != null) {
            if (!v.T(list)) {
                this.fyG.setVisibility(0);
                this.fyG.setFragmentUniqueId(this.fat.getUniqueId());
                this.fyG.setForum(this.mForumId, this.mForumName);
                this.fyG.setDatas(list);
                if (this.fgs == null) {
                    this.fgs = new al() { // from class: com.baidu.tieba.frs.entelechy.b.1
                        @Override // com.baidu.tieba.frs.al
                        public void ab(bg bgVar) {
                            h.a(b.this.fat, b.this.fvY, bgVar);
                        }
                    };
                }
                this.fyG.setStatListener(this.fgs);
                return;
            }
            this.fyG.setVisibility(8);
        }
    }

    private boolean bfr() {
        if (this.fvY == null) {
            return false;
        }
        FrsViewData frsViewData = this.fvY;
        final s sVar = null;
        if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().cdz())) {
            sVar = new s();
            sVar.setLinkUrl("");
            sVar.setImageUrl(frsViewData.getStar().cdz());
        } else if (frsViewData.getActivityHeadData() != null && v.S(frsViewData.getActivityHeadData().Xc()) >= 1) {
            sVar = frsViewData.getActivityHeadData().Xc().get(0);
        }
        if (sVar != null) {
            if (this.eBi != null) {
                this.eBi.startLoad(sVar.getImageUrl(), 10, false);
                if (!TextUtils.isEmpty(sVar.getLinkUrl())) {
                    this.eBi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (b.this.mContext != null) {
                                ba.adA().a(b.this.mContext, new String[]{sVar.getLinkUrl()}, true);
                            }
                        }
                    });
                }
            }
            return true;
        }
        return false;
    }

    private void qu(int i) {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fvY != null && this.fvY.getForum() != null && (themeColorInfo = (forum = this.fvY.getForum()).getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            if (i == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fgt) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                LinearGradientView bfo = bfo();
                if (this.fuk != null && bfo != null) {
                    this.fuk.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    bfo.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                }
                if (this.eBi != null) {
                    this.eBi.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            if (this.fyG != null) {
                String str = themeElement.font_color;
                this.fyG.setUrlAndColor(forum.getTopIcon(), com.baidu.tieba.lego.card.d.a.parseColor(TextUtils.isEmpty(str) ? themeElement.common_color : str));
            }
        }
    }

    protected void bfs() {
        this.fyM.startLoad(this.byl, 10, false);
    }

    @Override // com.baidu.tieba.frs.view.b
    @SuppressLint({"ResourceAsColor"})
    public void k(View view, boolean z) {
        if (this.mMemberType != 0 || TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.mHandler.removeCallbacks(this.fzi);
            if (this.mPopup == null) {
                this.mPopup = new PopupWindow(this.mContext.getPageActivity());
                this.mPopup.setContentView(this.fyH);
                this.mPopup.setBackgroundDrawable(new BitmapDrawable());
                this.mPopup.setOutsideTouchable(true);
                this.mPopup.setFocusable(true);
                this.mPopup.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds228));
                this.mPopup.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds100));
            }
            this.fyI = (TextView) this.fyH.findViewById(d.g.cur_experience);
            this.fyJ = (TextView) this.fyH.findViewById(d.g.levelup_experience);
            com.baidu.tbadk.core.util.al.k(this.fyH.findViewById(d.g.experience_container), d.f.icon_frs_experience_number);
            com.baidu.tbadk.core.util.al.d((TextView) this.fyH.findViewById(d.g.experience), d.C0277d.cp_cont_g, 1);
            com.baidu.tbadk.core.util.al.d(this.fyI, d.C0277d.common_color_10047, 1);
            com.baidu.tbadk.core.util.al.d(this.fyJ, d.C0277d.cp_cont_g, 1);
            a(this.fyI, this.fyJ);
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
            this.mHandler.postDelayed(this.fzi, 2000L);
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
            if (!TextUtils.isEmpty(this.fyS) && !TextUtils.isEmpty(this.fyS.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.fyS);
            } else {
                textView3.setVisibility(8);
            }
            aVar.gD(d.C0277d.cp_link_tip_d);
            b(aVar);
            c(aVar);
            aVar.b(this.mContext);
            aVar.aaW();
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
    public void bft() {
        View contentView;
        if (this.fyL == null) {
            this.fyL = new PopupWindow(this.mContext.getPageActivity());
            View inflate = LayoutInflater.from(this.mContext.getContext()).inflate(d.h.speed_tip, (ViewGroup) null);
            this.fyL.setContentView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.b.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.mContext != null && b.this.mContext.getPageActivity() != null) {
                        g.a(b.this.fyL, b.this.mContext.getPageActivity());
                        b.this.fat.eYr = false;
                        com.baidu.tbadk.browser.a.a(b.this.mContext.getPageActivity(), b.this.mContext.getResources().getString(d.j.experion_speed), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
                    }
                }
            });
            this.fyL.setWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds300));
            this.fyL.setHeight(this.mContext.getResources().getDimensionPixelSize(d.e.ds88));
            this.fyL.setBackgroundDrawable(new BitmapDrawable());
            this.fyL.setOutsideTouchable(true);
            this.fyL.setTouchInterceptor(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.entelechy.b.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 4) {
                        g.a(b.this.fyL);
                        b.this.fat.eYr = false;
                    }
                    return false;
                }
            });
            contentView = inflate;
        } else {
            contentView = this.fyL.getContentView();
        }
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.mem), d.C0277d.cp_btn_a, 1);
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.speed), d.C0277d.cp_link_tip_d, 1);
        com.baidu.tbadk.core.util.al.d((TextView) contentView.findViewById(d.g.tequan), d.C0277d.cp_btn_a, 1);
        int[] iArr = new int[2];
        this.fyK.getLocationOnScreen(iArr);
        g.showPopupWindowAtLocation(this.fyL, this.mParent, 0, (iArr[0] - (this.fyL.getWidth() / 2)) + (this.fyK.getWidth() / 2), iArr[1] + this.fyK.getWidth());
        this.fyL.update();
    }

    @Override // com.baidu.tieba.frs.view.b
    public void d(boolean z, float f) {
        int i;
        this.fzb = z;
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(d.f.bg_frs_signin_bar_down);
        if (cashBitmap != null && this.fyx != null && this.eVv != null && this.fyD != null && cashBitmap.getWidth() > 0) {
            if (this.fzb) {
                this.fyx.setText(d.j.level_up);
                if (f >= 1.0f) {
                    i = this.mLevel;
                } else {
                    i = this.mLevel + 1;
                }
                FrsViewData bcP = this.fat.bcP();
                if (bcP != null && bcP.getForum() != null) {
                    bcP.getForum().setUser_level(i);
                }
                this.fyD.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(i)));
            } else {
                this.fyx.setText(this.fyQ);
                this.fyD.setText(this.mContext.getResources().getString(d.j.lv_num, Integer.valueOf(this.mLevel)));
            }
            this.eVv.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, pF(this.mLevel)));
            if (this.fzb) {
                if (f >= 1.0f) {
                    a(this.fat.getBaseFragmentActivity(), this.eVv, this.fzd, f);
                } else {
                    b(this.fat.getBaseFragmentActivity(), this.eVv, this.fzd, f);
                }
            } else {
                a(this.fat.getBaseFragmentActivity(), this.eVv, this.fzd, f);
            }
            this.fzd = f;
        }
    }

    private int[] pF(int i) {
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
    protected void bfu() {
    }

    @Override // com.baidu.tieba.frs.view.b
    public void bfv() {
        if (this.mMemberType != 0) {
            com.baidu.tbadk.core.util.al.c(this.fyK, d.f.icon_sml_speed_orange);
        } else {
            com.baidu.tbadk.core.util.al.c(this.fyK, d.f.icon_sml_speed_gray);
        }
    }

    @Override // com.baidu.tieba.frs.view.b
    public void onDestory() {
        super.onDestory();
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyL != null && this.fyL.isShowing()) {
            this.fyL.dismiss();
        }
    }
}
