package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends a implements com.baidu.tbadk.imageManager.d {
    private static final int[] aFO = {com.baidu.tieba.u.label_green, com.baidu.tieba.u.label_blue, com.baidu.tieba.u.label_orange, com.baidu.tieba.u.label_red, com.baidu.tieba.u.label_purple};
    private com.baidu.tbadk.coreExtra.view.b Nz;
    private Activity aBP;
    private int aDi;
    private FrsOfficalBanner aDs;
    private TextView aFG;
    private d aFI;
    private String aFJ;
    private int aFK;
    private String aFN;
    private boolean aFP;
    private int aFQ;
    private final bf aFR;
    private ImageView aFS;
    private int aFT;
    private UserIconBox aFW;
    private boolean aFY;
    private U9InfoView aFZ;
    private TextView aFa;
    private TextView aFb;
    private FrameLayout aFc;
    private Button aFd;
    private TextView aFe;
    private FrameLayout aFf;
    private Button aFg;
    private TextView aFh;
    private ProgressBar aFi;
    private FrameLayout aFj;
    private TextView aFk;
    private RelativeLayout aFl;
    private TextView aFm;
    private TextView aFn;
    private ImageView aFo;
    private FrameLayout aFq;
    private TextView aFr;
    private FrameLayout aFs;
    private TextView aFt;
    private ab aFu;
    private View aFw;
    private boolean aGa;
    private final TbImageView aGr;
    private final BarImageView aGs;
    private final ImageView aGt;
    private View agI;
    private int alu;
    private TextView atJ;
    private String mForumId;
    private String mForumName;
    private com.baidu.tbadk.core.data.u news_info;
    private com.baidu.tbadk.core.data.r top_code;
    private com.baidu.tieba.frs.b aCf = null;
    private int aFz = 0;
    private int aFA = 0;
    private com.baidu.tieba.data.t aGp = null;
    com.baidu.tbadk.core.data.q aGq = null;
    private PopupWindow aFv = null;
    private TextView aFx = null;
    private TextView aFy = null;
    private int aFB = -1;
    private String aFC = null;
    private String aFD = null;
    private float aFL = 0.0f;
    private boolean aFM = false;
    private boolean aFE = false;
    private String aFX = String.valueOf(com.baidu.tieba.data.e.ajC) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.c> mBadgeData = null;
    final Runnable aGb = new s(this);
    View.OnClickListener aGc = new t(this);
    private Handler handler = new Handler();

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.Nz = bVar;
        this.aDs.setBannerViewClickListener(bVar);
    }

    public void Hc() {
        this.aDs.setVisibility(8);
    }

    public r(Activity activity, String str, String str2, int i) {
        this.aFa = null;
        this.aFb = null;
        this.atJ = null;
        this.aFc = null;
        this.aFd = null;
        this.aFe = null;
        this.aFf = null;
        this.aFg = null;
        this.aFh = null;
        this.aFi = null;
        this.aFj = null;
        this.aFk = null;
        this.aFl = null;
        this.aFm = null;
        this.aFn = null;
        this.aFo = null;
        this.agI = null;
        this.aFq = null;
        this.aFr = null;
        this.aFs = null;
        this.aFt = null;
        this.aBP = null;
        this.mForumName = null;
        this.mForumId = null;
        this.aFI = null;
        this.aFw = null;
        this.aFG = null;
        this.aFT = 0;
        this.aFW = null;
        this.aFT = i;
        this.aBP = activity;
        this.mForumName = str;
        this.mForumId = str2;
        this.agI = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.frs_star_title, null);
        this.aFw = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.frs_show_experience, null);
        if (this.mForumName == null || this.mForumId == null) {
            this.agI.setVisibility(8);
        }
        this.aDs = (FrsOfficalBanner) this.agI.findViewById(com.baidu.tieba.v.frs_offical_banner);
        this.aDs.setVisibility(8);
        this.aFl = (RelativeLayout) this.agI.findViewById(com.baidu.tieba.v.btn_love_content);
        this.aFS = (ImageView) this.agI.findViewById(com.baidu.tieba.v.speed_icon);
        this.aFm = (TextView) this.agI.findViewById(com.baidu.tieba.v.level_name);
        this.aFn = (TextView) this.agI.findViewById(com.baidu.tieba.v.level);
        this.aFo = (ImageView) this.agI.findViewById(com.baidu.tieba.v.love_level_top);
        this.aFG = (TextView) this.agI.findViewById(com.baidu.tieba.v.frs_tag_text);
        this.aFI = new d(this.agI, this.aBP);
        this.aFc = (FrameLayout) this.agI.findViewById(com.baidu.tieba.v.love);
        this.aFd = (Button) this.agI.findViewById(com.baidu.tieba.v.btn_love);
        this.aFe = (TextView) this.agI.findViewById(com.baidu.tieba.v.tv_love);
        this.aFf = (FrameLayout) this.agI.findViewById(com.baidu.tieba.v.sign);
        this.aFg = (Button) this.agI.findViewById(com.baidu.tieba.v.btn_sign);
        this.aFh = (TextView) this.agI.findViewById(com.baidu.tieba.v.tv_sign);
        this.aFi = (ProgressBar) this.agI.findViewById(com.baidu.tieba.v.sign_progress);
        this.aFj = (FrameLayout) this.agI.findViewById(com.baidu.tieba.v.sign_done);
        this.aFk = (TextView) this.agI.findViewById(com.baidu.tieba.v.sign_done_text);
        this.aFa = (TextView) this.agI.findViewById(com.baidu.tieba.v.member_num_text);
        this.aFb = (TextView) this.agI.findViewById(com.baidu.tieba.v.post_num_text);
        this.atJ = (TextView) this.agI.findViewById(com.baidu.tieba.v.title_text);
        this.aGr = (TbImageView) this.agI.findViewById(com.baidu.tieba.v.frs_star_top_pic);
        this.aGr.setOnClickListener(new u(this));
        this.aGs = (BarImageView) this.agI.findViewById(com.baidu.tieba.v.frs_star_bottom_photo);
        this.aGs.setGifIconSupport(false);
        this.aGt = (ImageView) this.agI.findViewById(com.baidu.tieba.v.frs_enter_detail);
        if (com.baidu.adp.lib.b.f.db().U(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.aGt.setVisibility(0);
        } else {
            this.aGt.setVisibility(8);
        }
        this.aFW = (UserIconBox) this.agI.findViewById(com.baidu.tieba.v.frs_badge_box);
        this.aFR = new bf(this.aBP);
        this.aFq = (FrameLayout) this.agI.findViewById(com.baidu.tieba.v.frs_header_groups);
        this.aFr = (TextView) this.agI.findViewById(com.baidu.tieba.v.frs_header_groups_text);
        this.aFs = (FrameLayout) this.agI.findViewById(com.baidu.tieba.v.frs_header_games);
        this.aFt = (TextView) this.agI.findViewById(com.baidu.tieba.v.frs_header_games_text);
        this.aFu = new ab(this.agI);
        this.aFZ = (U9InfoView) this.agI.findViewById(com.baidu.tieba.v.frs_header_enter_u9);
    }

    public boolean GU() {
        int[] iArr = new int[2];
        try {
            this.aFS.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.aFq.setOnClickListener(onClickListener);
        if (this.aFs != null) {
            this.aFs.setOnClickListener(onClickListener);
        }
        this.aFl.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.db().U(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.agI.setOnClickListener(new v(this));
        }
        this.aFI.setOnClickListener(onClickListener);
        this.aFd.setOnClickListener(onClickListener);
        this.aFg.setOnClickListener(onClickListener);
        this.aFG.setOnClickListener(new w(this));
    }

    public BarImageView GX() {
        return this.aGs;
    }

    public void changeSkinType(int i) {
        ((FrsActivity) this.aBP).getLayoutMode().L(i == 1);
        ((FrsActivity) this.aBP).getLayoutMode().h(this.agI);
        ((FrsActivity) this.aBP).getLayoutMode().h(this.aFw);
        if (this.aFE) {
            eY(1);
        } else {
            eY(0);
        }
        aw.h((View) this.aFn, com.baidu.tbadk.core.util.d.bn(this.alu));
        this.aGs.invalidate();
        this.aGr.invalidate();
        if (this.aFB >= 0 && this.aFB < aFO.length) {
            aw.h((View) this.aFG, aFO[this.aFB]);
        }
        aw.c(this.aGt, com.baidu.tieba.u.icon_arrow_right);
        this.aFe.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aFh.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aFe.setShadowLayer(1.0f, 0.0f, 1.0f, aw.getColor(com.baidu.tieba.s.frs_like_shadow));
        this.aFh.setShadowLayer(1.0f, 0.0f, 1.0f, aw.getColor(com.baidu.tieba.s.frs_sign_shadow));
        aw.h(this.aFq, com.baidu.tieba.u.frs_top_item_bg);
        if (this.aFs != null) {
            aw.h(this.aFs, com.baidu.tieba.u.frs_top_item_bg);
        }
        if (this.aFT != 0) {
            aw.c(this.aFS, com.baidu.tieba.u.icon_speed_orange);
        } else {
            aw.c(this.aFS, com.baidu.tieba.u.icon_speed_gray);
        }
        if (this.aFu != null) {
            this.aFu.changeSkinType(i);
        }
        if (this.aFZ != null) {
            this.aFZ.bN(i);
        }
        if (this.aFW != null) {
            this.aFW.bN(i);
        }
    }

    public void GV() {
        if (this.aFT != 0) {
            aw.c(this.aFS, com.baidu.tieba.u.icon_speed_orange);
        } else {
            aw.c(this.aFS, com.baidu.tieba.u.icon_speed_gray);
        }
    }

    public View getView() {
        return this.agI;
    }

    public void c(ForumData forumData, com.baidu.tieba.frs.b bVar) {
        if (bVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.aFz = forumData.getMember_num();
            this.aFA = forumData.getPost_num();
            this.aFC = forumData.getTag_name();
            this.aFD = forumData.getTag_color();
            this.aFQ = forumData.getSignData().getCountSignNum();
            this.aFK = forumData.getCurScore();
            this.aFN = forumData.getAccelerateContent();
            this.aDi = forumData.getLevelupScore();
            this.aCf = bVar;
            this.aGp = bVar.Fh();
            this.mBadgeData = forumData.getBadgeData();
            this.aGq = new com.baidu.tbadk.core.data.q();
            this.top_code = forumData.getTopCode();
            this.news_info = forumData.getNewsInfo();
            if (this.aGp != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.aGp.zj());
                this.aGq.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.aGp.zk());
                this.aGq.getMedias().add(mediaData2);
            }
            this.agI.setVisibility(0);
            this.aFI.setForumName(forumData.getName());
            GW();
        }
    }

    private void GW() {
        if (this.aFa != null) {
            this.aFa.setText(String.valueOf(this.aFz));
        }
        if (this.aFb != null) {
            this.aFb.setText(String.valueOf(this.aFA));
        }
        if (this.atJ != null) {
            if (this.mBadgeData != null && this.mBadgeData.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.atJ.setText(String.valueOf(this.mForumName) + this.aBP.getString(com.baidu.tieba.y.forum));
        }
        if (this.aFC != null && this.aFC.length() > 0) {
            if (this.aFG != null) {
                this.aFG.setText(this.aFC);
            }
            if (this.aFG != null && this.aFD != null && this.aFD.length() > 0) {
                this.aFB = Integer.parseInt(this.aFD);
                if (this.aFB >= 0 && this.aFB < aFO.length) {
                    aw.h((View) this.aFG, aFO[this.aFB]);
                }
            }
            if (this.aFG != null) {
                this.aFG.setVisibility(0);
            }
        } else if (this.aFG != null) {
            this.aFG.setVisibility(8);
        }
        if (this.aCf != null && this.aCf.jZ() != null && this.aCf.jZ().getIfpost() == 0) {
            if (this.aCf.Fg().isEmpty()) {
                this.aFq.setVisibility(8);
            } else {
                this.aFq.setVisibility(0);
                if (this.aCf.Fi().yt() > 0) {
                    this.aFr.setText(String.format(this.aBP.getString(com.baidu.tieba.y.frs_forum_groups), Integer.valueOf(this.aCf.Fi().yt())));
                } else {
                    this.aFr.setText(this.aBP.getString(com.baidu.tieba.y.frsgroup_title));
                }
            }
        } else {
            this.aFq.setVisibility(0);
            if (this.aCf != null && this.aCf.Fi().yt() > 0) {
                this.aFr.setText(String.format(this.aBP.getString(com.baidu.tieba.y.frs_forum_groups), Integer.valueOf(this.aCf.Fi().yt())));
            } else {
                this.aFr.setText(this.aBP.getString(com.baidu.tieba.y.frsgroup_title));
            }
        }
        if (this.aFs != null && this.aFt != null) {
            if (this.aCf != null && this.aCf.EY()) {
                this.aFs.setVisibility(0);
                this.aFt.setText(com.baidu.tieba.y.frsgame_title);
            } else {
                this.aFs.setVisibility(8);
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGr.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.m.n(this.aBP);
        layoutParams.height = this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300);
        this.aGr.setLayoutParams(layoutParams);
        this.aGr.setDefaultResource(com.baidu.tieba.u.def_star_top_pic);
        this.aGr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGs.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        int zl = this.aGp.zl();
        int zm = this.aGp.zm();
        if (zl == 0 || zm == 0) {
            zl = layoutParams.width;
            zm = layoutParams.height;
        }
        this.aGr.a(this.aGp.zj(), 16, zl, zm, false);
        this.aGs.c(this.aGp.zk(), 16, false);
        if (this.aFW != null && this.mBadgeData != null && this.mBadgeData.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.mBadgeData.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.mBadgeData.get(i).jJ());
                iconData.setIcon(this.mBadgeData.get(i).jI());
                this.aFX = this.mBadgeData.get(i).jK();
                linkedList.add(iconData);
            }
            this.aFW.setOnClickListener(this.aGc);
            this.aFW.a(linkedList, 2, this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_width), this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_height), this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_margin));
        }
        if (this.aCf != null) {
            this.aFu.a(this.aCf.Fh(), this.aCf.zL());
        } else {
            this.aFu.a(null, null);
        }
        this.aFZ.a(this.top_code, this.news_info);
    }

    public void setIsMem(int i) {
        this.aFT = i;
    }

    public void Gb() {
        PopupWindow popupWindow = new PopupWindow(this.aBP);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aBP, com.baidu.tieba.w.speed_tip, null);
        if (this.aBP instanceof BaseActivity) {
            ((BaseActivity) this.aBP).getLayoutMode().h(inflate);
        }
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new x(this, popupWindow));
        popupWindow.setWidth(this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300));
        popupWindow.setHeight(this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new y(this, popupWindow));
        int[] iArr = new int[2];
        this.aFS.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, this.agI, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aFS.getWidth() / 2), iArr[1] + this.aFS.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aFM = z;
        Bitmap bl = com.baidu.tbadk.core.util.d.bl(com.baidu.tieba.u.bg_frs_signin_bar_down);
        if (bl != null && bl.getWidth() > 0) {
            if (this.aFM) {
                this.aFm.setText(com.baidu.tieba.y.star_bar_level_up);
                this.aFn.setText(String.valueOf(this.alu + 1));
            } else {
                this.aFm.setText(this.aFJ);
                this.aFn.setText(String.valueOf(this.alu));
                aw.h((View) this.aFn, com.baidu.tbadk.core.util.d.bn(this.alu));
            }
            if (this.aFM) {
                b(this.aBP, this.aFo, this.aFL, f);
            } else {
                a(this.aBP, this.aFo, this.aFL, f);
            }
            this.aFL = f;
        }
    }

    public void e(View view, boolean z) {
        if (this.aFT != 0) {
            if (this.aFv == null) {
                this.aFv = new PopupWindow(this.aBP);
                this.aFv.setContentView(this.aFw);
                this.aFv.setBackgroundDrawable(new BitmapDrawable());
                this.aFv.setOutsideTouchable(true);
                this.aFv.setFocusable(true);
                this.aFv.setWidth(this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_btn_width));
                this.aFv.setHeight(this.aBP.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_exp_height));
                this.aFx = (TextView) this.aFw.findViewById(com.baidu.tieba.v.cur_experience);
                this.aFy = (TextView) this.aFw.findViewById(com.baidu.tieba.v.levelup_experience);
                a(this.aFx, this.aFy);
            }
            if (this.aFv.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.aFv, this.aBP);
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aFx, this.aFy);
            int height = iArr[1] - this.aFv.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.j.a(this.aFv, this.aBP);
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.aFv, this.agI, 0, iArr[0], height);
            this.aFv.update();
            this.handler.postDelayed(this.aGb, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aBP, com.baidu.tieba.w.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.v.speed_tip);
            aw.b((TextView) inflate.findViewById(com.baidu.tieba.v.experience), com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView3, com.baidu.tieba.s.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.aFN) && !TextUtils.isEmpty(this.aFN.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aFN);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aBP);
            aVar.j(inflate);
            a(textView, textView2);
            aVar.b(com.baidu.tieba.y.cancel_text, new z(this));
            aVar.a(com.baidu.tieba.y.open_now, new aa(this));
            aVar.kT().kW();
        }
    }

    private void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aFK));
        if (this.aDi >= 10000) {
            if (this.aDi % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                textView2.setText(String.valueOf(this.aBP.getString(com.baidu.tieba.y.experience_divider)) + String.valueOf(this.aDi / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.aBP.getString(com.baidu.tieba.y.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aBP.getString(com.baidu.tieba.y.experience_divider)) + String.valueOf(this.aDi / 10000.0f) + this.aBP.getString(com.baidu.tieba.y.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aBP.getString(com.baidu.tieba.y.experience_divider)) + String.valueOf(this.aDi));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aFJ = str;
        this.alu = i2;
        if (i == 0) {
            this.aEU = false;
            this.aFc.setVisibility(0);
            this.aFl.setVisibility(8);
            return;
        }
        this.aEU = true;
        this.aFc.setVisibility(8);
        if (z) {
            this.aFR.A(this.aFc);
        }
        a(false, f);
        this.aFl.setVisibility(0);
    }

    public void eX(int i) {
        if (i == 0) {
            this.aEU = false;
            this.aFc.setVisibility(0);
            this.aFl.setVisibility(8);
            return;
        }
        this.aEU = true;
        this.aFc.setVisibility(8);
        this.aFl.setVisibility(0);
    }

    public void eY(int i) {
        if (i == 0) {
            this.aFE = false;
            this.aFj.setVisibility(8);
            this.aFf.setVisibility(0);
            aw.h((View) this.aFg, com.baidu.tieba.u.frs_btn_sign);
            return;
        }
        this.aFE = true;
        this.aFf.setVisibility(8);
        this.aFk.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aFQ <= 1) {
            this.aFk.setText(this.aBP.getString(com.baidu.tieba.y.signed));
        } else {
            this.aFk.setText(String.valueOf(this.aBP.getString(com.baidu.tieba.y.signed_less)) + String.valueOf(this.aFQ) + this.aBP.getString(com.baidu.tieba.y.day));
        }
        this.aFj.setVisibility(0);
    }

    public boolean Gz() {
        return this.aFE;
    }

    public void ci(boolean z) {
        this.aFP = z;
        if (this.aFP) {
            this.aFf.setVisibility(0);
        } else {
            this.aFf.setVisibility(4);
        }
    }

    public View GY() {
        return this.aFl;
    }

    public boolean Gj() {
        return this.aFM;
    }

    public boolean E(View view) {
        return this.aFI.D(view);
    }

    public void Ha() {
        this.aFI.hide();
    }

    public void Hb() {
        this.aFI.show();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.agI.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar GZ() {
        return this.aFi;
    }

    public void onDestory() {
        this.aFY = true;
    }

    public void cj(boolean z) {
        this.aGa = z;
    }
}
