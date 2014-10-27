package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrsHeaderView extends a {
    private static final int[] aFE = {com.baidu.tieba.u.label_green, com.baidu.tieba.u.label_blue, com.baidu.tieba.u.label_orange, com.baidu.tieba.u.label_red, com.baidu.tieba.u.label_purple};
    private Activity aBF;
    private int aCY;
    private TextView aEQ;
    private TextView aER;
    private FrameLayout aES;
    private Button aET;
    private TextView aEU;
    private FrameLayout aEV;
    private Button aEW;
    private TextView aEX;
    private ProgressBar aEY;
    private FrameLayout aEZ;
    private int aFA;
    private String aFD;
    private boolean aFF;
    private int aFG;
    private final bf aFH;
    private ImageView aFI;
    private int aFJ;
    private final ViewGroup aFK;
    private ImageView aFL;
    private UserIconBox aFM;
    private boolean aFO;
    private U9InfoView aFP;
    private boolean aFQ;
    private TextView aFa;
    private RelativeLayout aFb;
    private TextView aFc;
    private TextView aFd;
    private ImageView aFe;
    private View aFf;
    private FrameLayout aFg;
    private TextView aFh;
    private FrameLayout aFi;
    private TextView aFj;
    private ab aFk;
    private View aFm;
    private BarImageView aFv;
    private TextView aFw;
    private d aFy;
    private String aFz;
    private View agA;
    private int alk;
    private TextView atA;
    private Handler handler;
    private String mForumId;
    private String mForumName;
    private com.baidu.tbadk.core.data.u news_info;
    private com.baidu.tbadk.core.data.r top_code;
    private PopupWindow aFl = null;
    private TextView aFn = null;
    private TextView aFo = null;
    private int aFp = 0;
    private int aFq = 0;
    private int aFr = -1;
    private String aFs = null;
    private String aFt = null;
    private String awL = null;
    private com.baidu.tieba.frs.b aBV = null;
    private boolean aFu = false;
    com.baidu.tbadk.core.data.q aFx = null;
    private float aFB = 0.0f;
    private boolean aFC = false;
    private String aFN = String.valueOf(com.baidu.tieba.data.e.ajt) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.c> mBadgeData = null;
    final Runnable aFR = new f(this);
    View.OnClickListener aFS = new g(this);

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (aFV) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PAGE[] valuesCustom() {
            PAGE[] valuesCustom = values();
            int length = valuesCustom.length;
            PAGE[] pageArr = new PAGE[length];
            System.arraycopy(valuesCustom, 0, pageArr, 0, length);
            return pageArr;
        }
    }

    public FrsHeaderView(Activity activity, PAGE page, String str, String str2, int i) {
        this.aEQ = null;
        this.aER = null;
        this.atA = null;
        this.aES = null;
        this.aET = null;
        this.aEU = null;
        this.aEV = null;
        this.aEW = null;
        this.aEX = null;
        this.aEY = null;
        this.aEZ = null;
        this.aFa = null;
        this.aFb = null;
        this.aFc = null;
        this.aFd = null;
        this.aFe = null;
        this.agA = null;
        this.aFf = null;
        this.aFg = null;
        this.aFh = null;
        this.aFi = null;
        this.aFj = null;
        this.aFm = null;
        this.aBF = null;
        this.mForumName = null;
        this.mForumId = null;
        this.handler = null;
        this.aFv = null;
        this.aFw = null;
        this.aFy = null;
        this.aFJ = 0;
        this.aFL = null;
        this.aFM = null;
        this.aFJ = i;
        this.handler = new Handler();
        this.aBF = activity;
        this.mForumName = str;
        this.mForumId = str2;
        this.agA = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.frs_header, null);
        this.aFf = this.agA.findViewById(com.baidu.tieba.v.container);
        this.aFm = com.baidu.adp.lib.g.b.ek().inflate(activity, com.baidu.tieba.w.frs_show_experience, null);
        if (StringUtils.isNull(this.mForumName) || StringUtils.isNull(this.mForumId)) {
            this.agA.setVisibility(8);
        }
        this.aFb = (RelativeLayout) this.agA.findViewById(com.baidu.tieba.v.btn_love_content);
        this.aFI = (ImageView) this.agA.findViewById(com.baidu.tieba.v.speed_icon);
        this.aFK = (ViewGroup) this.agA.findViewById(com.baidu.tieba.v.frs_forum_entry);
        this.aFL = (ImageView) this.agA.findViewById(com.baidu.tieba.v.frs_enter_detail);
        this.aFK.setVisibility(8);
        this.aFy = new d(this.agA, this.aBF);
        this.aFc = (TextView) this.agA.findViewById(com.baidu.tieba.v.level_name);
        this.aFd = (TextView) this.agA.findViewById(com.baidu.tieba.v.level);
        this.aFe = (ImageView) this.agA.findViewById(com.baidu.tieba.v.love_level_top);
        this.aES = (FrameLayout) this.agA.findViewById(com.baidu.tieba.v.love);
        this.aET = (Button) this.agA.findViewById(com.baidu.tieba.v.btn_love);
        this.aEU = (TextView) this.agA.findViewById(com.baidu.tieba.v.tv_love);
        this.aEV = (FrameLayout) this.agA.findViewById(com.baidu.tieba.v.sign);
        this.aEW = (Button) this.agA.findViewById(com.baidu.tieba.v.btn_sign);
        this.aEX = (TextView) this.agA.findViewById(com.baidu.tieba.v.tv_sign);
        this.aEY = (ProgressBar) this.agA.findViewById(com.baidu.tieba.v.sign_progress);
        this.aEZ = (FrameLayout) this.agA.findViewById(com.baidu.tieba.v.sign_done);
        this.aFa = (TextView) this.agA.findViewById(com.baidu.tieba.v.sign_done_text);
        this.aEQ = (TextView) this.agA.findViewById(com.baidu.tieba.v.member_num_text);
        this.aER = (TextView) this.agA.findViewById(com.baidu.tieba.v.post_num_text);
        this.atA = (TextView) this.agA.findViewById(com.baidu.tieba.v.title_text);
        this.aFw = (TextView) this.agA.findViewById(com.baidu.tieba.v.frs_tag_text);
        this.aFv = (BarImageView) this.agA.findViewById(com.baidu.tieba.v.frs_image);
        this.aFv.setGifIconSupport(false);
        this.aFM = (UserIconBox) this.agA.findViewById(com.baidu.tieba.v.frs_badge_box);
        this.aFg = (FrameLayout) this.agA.findViewById(com.baidu.tieba.v.frs_header_groups);
        this.aFh = (TextView) this.agA.findViewById(com.baidu.tieba.v.frs_header_groups_text);
        this.aFi = (FrameLayout) this.agA.findViewById(com.baidu.tieba.v.frs_header_games);
        this.aFj = (TextView) this.agA.findViewById(com.baidu.tieba.v.frs_header_games_text);
        this.aFk = new ab(this.agA);
        this.aFH = new bf(this.aBF);
        this.aFP = (U9InfoView) this.agA.findViewById(com.baidu.tieba.v.frs_header_enter_u9);
    }

    public boolean GS() {
        int[] iArr = new int[2];
        try {
            this.aFI.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.aET.setOnClickListener(onClickListener);
        this.aEW.setOnClickListener(onClickListener);
        this.aFg.setOnClickListener(onClickListener);
        if (this.aFi != null) {
            this.aFi.setOnClickListener(onClickListener);
        }
        this.aFb.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.db().U(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.agA.setOnClickListener(new h(this));
        }
        this.aFy.setOnClickListener(onClickListener);
        this.aFw.setOnClickListener(new i(this));
    }

    public void setIsMem(int i) {
        this.aFJ = i;
    }

    public void changeSkinType(int i) {
        ((FrsActivity) this.aBF).getLayoutMode().L(i == 1);
        ((FrsActivity) this.aBF).getLayoutMode().h(this.agA);
        ((FrsActivity) this.aBF).getLayoutMode().h(this.aFm);
        if (this.aFu) {
            eY(1);
        } else {
            eY(0);
        }
        this.aFv.invalidate();
        aw.h((View) this.aFd, com.baidu.tbadk.core.util.d.bn(this.alk));
        aw.h(this.aFL, com.baidu.tieba.u.icon_arrow_right);
        aw.i(this.aFf, com.baidu.tieba.s.frs_header_bg);
        if (this.aFr >= 0 && this.aFr < aFE.length) {
            aw.h((View) this.aFw, aFE[this.aFr]);
        }
        this.aEU.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aEX.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aEU.setShadowLayer(1.0f, 0.0f, 1.0f, aw.getColor(com.baidu.tieba.s.frs_like_shadow));
        this.aEX.setShadowLayer(1.0f, 0.0f, 1.0f, aw.getColor(com.baidu.tieba.s.frs_sign_shadow));
        aw.h(this.aFg, com.baidu.tieba.u.frs_top_item_bg);
        if (this.aFi != null) {
            aw.h(this.aFi, com.baidu.tieba.u.frs_top_item_bg);
        }
        if (this.aFJ != 0) {
            aw.c(this.aFI, com.baidu.tieba.u.icon_speed_orange);
        } else {
            aw.c(this.aFI, com.baidu.tieba.u.icon_speed_gray);
        }
        if (this.aFk != null) {
            this.aFk.changeSkinType(i);
        }
        if (this.aFP != null) {
            this.aFP.bN(i);
        }
        if (this.aFM != null) {
            this.aFM.bN(i);
        }
    }

    public void GT() {
        if (this.aFJ != 0) {
            aw.c(this.aFI, com.baidu.tieba.u.icon_speed_orange);
        } else {
            aw.c(this.aFI, com.baidu.tieba.u.icon_speed_gray);
        }
    }

    public View getView() {
        return this.agA;
    }

    public void c(ForumData forumData, com.baidu.tieba.frs.b bVar) {
        this.mForumName = forumData.getName();
        this.mForumId = forumData.getId();
        this.aFp = forumData.getMember_num();
        this.aFq = forumData.getPost_num();
        this.aFs = forumData.getTag_name();
        this.aFt = forumData.getTag_color();
        this.awL = forumData.getImage_url();
        this.aFz = forumData.getLevelName();
        this.alk = forumData.getUser_level();
        this.aFG = forumData.getSignData().getCountSignNum();
        this.aFA = forumData.getCurScore();
        this.aCY = forumData.getLevelupScore();
        this.mBadgeData = forumData.getBadgeData();
        this.top_code = forumData.getTopCode();
        this.news_info = forumData.getNewsInfo();
        this.aFD = forumData.getAccelerateContent();
        this.aBV = bVar;
        if (StringUtils.isNull(this.mForumId) || StringUtils.isNull(this.mForumName)) {
            this.agA.setVisibility(8);
        } else {
            this.agA.setVisibility(0);
        }
        this.aFx = new com.baidu.tbadk.core.data.q();
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.awL);
        this.aFx.getMedias().add(mediaData);
        this.aFy.setForumName(forumData.getName());
        GU();
    }

    private void GU() {
        int i = 0;
        if (this.aEQ != null) {
            this.aEQ.setText(String.valueOf(this.aFp));
        }
        if (this.aER != null) {
            this.aER.setText(String.valueOf(this.aFq));
        }
        if (this.atA != null) {
            if (this.mBadgeData != null && this.mBadgeData.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            if (!StringUtils.isNull(this.mForumName)) {
                this.atA.setText(String.valueOf(this.mForumName) + this.aBF.getString(com.baidu.tieba.y.forum));
            }
        }
        if (this.aFs != null && this.aFs.length() > 0) {
            if (this.aFw != null) {
                this.aFw.setText(this.aFs);
            }
            if (this.aFw != null && this.aFt != null && this.aFt.length() > 0) {
                this.aFr = Integer.parseInt(this.aFt);
                if (this.aFr >= 0 && this.aFr < aFE.length) {
                    aw.h((View) this.aFw, aFE[this.aFr]);
                }
            }
            if (this.aFw != null) {
                this.aFw.setVisibility(0);
            }
        } else if (this.aFw != null) {
            this.aFw.setVisibility(8);
        }
        if (this.aBV != null && this.aBV.jZ() != null && this.aBV.jZ().getIfpost() == 0) {
            if (this.aBV.Fe().isEmpty()) {
                this.aFg.setVisibility(8);
            } else {
                this.aFg.setVisibility(0);
                if (this.aBV.Fg().yr() > 0) {
                    this.aFh.setText(String.format(this.aBF.getString(com.baidu.tieba.y.frs_forum_groups), Integer.valueOf(this.aBV.Fg().yr())));
                } else {
                    this.aFh.setText(this.aBF.getString(com.baidu.tieba.y.frsgroup_title));
                }
            }
        } else {
            this.aFg.setVisibility(0);
            if (this.aBV != null && this.aBV.Fg().yr() > 0) {
                this.aFh.setText(String.format(this.aBF.getString(com.baidu.tieba.y.frs_forum_groups), Integer.valueOf(this.aBV.Fg().yr())));
            } else {
                this.aFh.setText(this.aBF.getString(com.baidu.tieba.y.frsgroup_title));
            }
        }
        if (this.aFi != null && this.aFj != null) {
            if (this.aBV != null && this.aBV.EW()) {
                this.aFi.setVisibility(0);
                this.aFj.setText(com.baidu.tieba.y.frsgame_title);
            } else {
                this.aFi.setVisibility(8);
            }
        }
        if (this.aBV != null) {
            this.aFk.a(this.aBV.Ff(), this.aBV.zJ());
        } else {
            this.aFk.a(null, null);
        }
        this.aFv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aFv.c(this.awL, 15, false);
        if (this.aFM != null && this.mBadgeData != null && this.mBadgeData.size() > 0) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int i2 = i;
                if (i2 >= this.mBadgeData.size()) {
                    break;
                }
                IconData iconData = new IconData();
                iconData.setIconName(this.mBadgeData.get(i2).jJ());
                iconData.setIcon(this.mBadgeData.get(i2).jI());
                this.aFN = this.mBadgeData.get(i2).jK();
                linkedList.add(iconData);
                i = i2 + 1;
            }
            this.aFM.setOnClickListener(this.aFS);
            this.aFM.a(linkedList, 2, this.aBF.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_badge_width), this.aBF.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_badge_height), this.aBF.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_badge_margin));
        }
        this.aFP.a(this.top_code, this.news_info);
    }

    public void e(View view, boolean z) {
        if (this.aFJ != 0) {
            if (this.aFl == null) {
                this.aFl = new PopupWindow(this.aBF);
                this.aFl.setContentView(this.aFm);
                this.aFl.setBackgroundDrawable(new BitmapDrawable());
                this.aFl.setOutsideTouchable(true);
                this.aFl.setFocusable(true);
                this.aFl.setWidth(this.aBF.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_btn_width));
                this.aFl.setHeight(this.aBF.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_exp_height));
                this.aFn = (TextView) this.aFm.findViewById(com.baidu.tieba.v.cur_experience);
                this.aFo = (TextView) this.aFm.findViewById(com.baidu.tieba.v.levelup_experience);
                a(this.aFn, this.aFo);
            }
            if (this.aFl.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.aFl, this.aBF);
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aFn, this.aFo);
            if (iArr[1] - this.aFl.getHeight() <= 50) {
                com.baidu.adp.lib.g.j.a(this.aFl, this.aBF);
                return;
            }
            com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this.aFl, this.agA, 0, iArr[0], iArr[1] - this.aFl.getHeight());
            this.aFl.update();
            this.handler.postDelayed(this.aFR, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aBF, com.baidu.tieba.w.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.v.speed_tip);
            aw.b((TextView) inflate.findViewById(com.baidu.tieba.v.experience), com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView3, com.baidu.tieba.s.cp_cont_b, 1);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aBF);
            aVar.j(inflate);
            a(textView, textView2);
            if (!TextUtils.isEmpty(this.aFD) && !TextUtils.isEmpty(this.aFD.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aFD);
            } else {
                textView3.setVisibility(8);
            }
            aVar.b(com.baidu.tieba.y.cancel_text, new j(this));
            aVar.a(com.baidu.tieba.y.open_now, new k(this));
            aVar.kT().kW();
        }
    }

    private void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aFA));
        if (this.aCY >= 10000) {
            if (this.aCY % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                textView2.setText(String.valueOf(this.aBF.getString(com.baidu.tieba.y.experience_divider)) + String.valueOf(this.aCY / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.aBF.getString(com.baidu.tieba.y.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.aBF.getString(com.baidu.tieba.y.experience_divider)) + String.valueOf(this.aCY / 10000.0f) + this.aBF.getString(com.baidu.tieba.y.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.aBF.getString(com.baidu.tieba.y.experience_divider)) + String.valueOf(this.aCY));
    }

    public void FZ() {
        PopupWindow popupWindow = new PopupWindow(this.aBF);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aBF, com.baidu.tieba.w.speed_tip, null);
        if (this.aBF instanceof BaseActivity) {
            ((BaseActivity) this.aBF).getLayoutMode().h(inflate);
        }
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new l(this, popupWindow));
        popupWindow.setWidth(this.aBF.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds300));
        popupWindow.setHeight(this.aBF.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new m(this, popupWindow));
        int[] iArr = new int[2];
        this.aFI.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(popupWindow, this.agA, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aFI.getWidth() / 2), iArr[1] + this.aFI.getWidth());
        popupWindow.update();
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aFz = str;
        this.alk = i2;
        if (i == 0) {
            this.aEK = false;
            this.aES.setVisibility(0);
            this.aFb.setVisibility(8);
            return;
        }
        this.aEK = true;
        this.aES.setVisibility(8);
        if (z) {
            this.aFH.A(this.aES);
        }
        a(false, f);
        this.aFb.setVisibility(0);
    }

    public void eX(int i) {
        if (i == 0) {
            this.aEK = false;
            this.aES.setVisibility(0);
            this.aFb.setVisibility(8);
            return;
        }
        this.aEK = true;
        this.aES.setVisibility(8);
        this.aFb.setVisibility(0);
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aFC = z;
        Bitmap bl = com.baidu.tbadk.core.util.d.bl(com.baidu.tieba.u.bg_frs_signin_bar_down);
        if (bl != null && bl.getWidth() > 0) {
            if (this.aFC) {
                this.aFc.setText(com.baidu.tieba.y.level_up);
                this.aFd.setText(String.valueOf(this.alk + 1));
            } else {
                this.aFc.setText(this.aFz);
                this.aFd.setText(String.valueOf(this.alk));
                aw.h((View) this.aFd, com.baidu.tbadk.core.util.d.bn(this.alk));
            }
            if (this.aFC) {
                b(this.aBF, this.aFe, this.aFB, f);
            } else {
                a(this.aBF, this.aFe, this.aFB, f);
            }
            this.aFB = f;
        }
    }

    public void eY(int i) {
        if (i == 0) {
            this.aFu = false;
            this.aEZ.setVisibility(8);
            this.aEV.setVisibility(0);
            aw.h((View) this.aEW, com.baidu.tieba.u.frs_btn_sign);
            return;
        }
        this.aFu = true;
        this.aEV.setVisibility(8);
        this.aFa.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aFG <= 1) {
            this.aFa.setText(this.aBF.getString(com.baidu.tieba.y.signed));
        } else {
            this.aFa.setText(String.valueOf(this.aBF.getString(com.baidu.tieba.y.signed_less)) + String.valueOf(this.aFG) + this.aBF.getString(com.baidu.tieba.y.day));
        }
        this.aEZ.setVisibility(0);
    }

    public boolean Gx() {
        return this.aFu;
    }

    public void ci(boolean z) {
        this.aFF = z;
        if (this.aFF) {
            this.aEV.setVisibility(0);
        } else {
            this.aEV.setVisibility(8);
        }
    }

    public BarImageView GV() {
        return this.aFv;
    }

    public View GW() {
        return this.aFb;
    }

    public ProgressBar GX() {
        return this.aEY;
    }

    public boolean Gh() {
        return this.aFC;
    }

    public boolean E(View view) {
        return this.aFy.D(view);
    }

    public void GY() {
        this.aFy.hide();
    }

    public void GZ() {
        this.aFy.show();
    }

    public void onDestory() {
        this.aFO = true;
    }

    public void cj(boolean z) {
        this.aFQ = z;
    }
}
