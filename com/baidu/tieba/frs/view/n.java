package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.WorldCupView;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import com.baidu.tieba.view.CustomTimerView;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.imageManager.d {
    private static final int[] ae = {com.baidu.tieba.t.label_green, com.baidu.tieba.t.label_blue, com.baidu.tieba.t.label_orange, com.baidu.tieba.t.label_red, com.baidu.tieba.t.label_purple};
    private static final int[] af = {com.baidu.tieba.t.label_green_1, com.baidu.tieba.t.label_blue_1, com.baidu.tieba.t.label_orange_1, com.baidu.tieba.t.label_red_1, com.baidu.tieba.t.label_purple_1};
    private Activity B;
    private String C;
    private String D;
    private a G;
    private final TbImageView I;
    private final BarImageView J;
    private View L;
    private TextView O;
    private TextView P;
    private CustomTimerView Q;
    private TextView R;
    private String V;
    private int W;
    private int ab;
    private int ac;
    private int ad;
    private RelativeLayout ag;
    private RelativeLayout ah;
    private boolean ai;
    private int aj;
    private final bs am;
    private ImageView an;
    private int ao;
    private FrsOfficalBanner ap;
    private final ImageView aq;
    private UserIconBox ar;
    private com.baidu.tbadk.coreExtra.view.c au;
    private boolean av;
    private com.baidu.tbadk.core.data.q aw;
    private WorldCupView ax;
    private boolean ay;
    private TextView d;
    private TextView e;
    private TextView f;
    private FrameLayout g;
    private Button h;
    private TextView i;
    private FrameLayout j;
    private Button k;
    private TextView l;
    private ProgressBar m;
    private FrameLayout n;
    private TextView o;
    private RelativeLayout p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private View t;
    private FrameLayout u;
    private TextView v;
    private FrameLayout w;
    private TextView x;
    private w y;
    private com.baidu.tieba.frs.g z = null;
    private boolean A = false;
    private int E = 0;
    private int F = 0;
    private com.baidu.tieba.data.t H = null;
    com.baidu.tbadk.core.data.n a = null;
    private PopupWindow K = null;
    private TextView M = null;
    private TextView N = null;
    private int S = -1;
    private String T = null;
    private String U = null;
    private float X = 0.0f;
    private float Y = 0.0f;
    private boolean Z = false;
    private boolean aa = false;
    private boolean ak = false;
    private String as = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.c> at = null;
    final Runnable b = new o(this);
    View.OnClickListener c = new p(this);
    private Handler al = new Handler();

    public void a(com.baidu.tbadk.coreExtra.view.c cVar) {
        this.au = cVar;
        this.ap.setBannerViewClickListener(cVar);
    }

    public void a(String str) {
        this.ap.setText(str);
        this.ap.setVisibility(0);
    }

    public void a() {
        this.ap.setVisibility(0);
    }

    public void b() {
        this.ap.setVisibility(8);
    }

    public n(Activity activity, String str, String str2, int i) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.G = null;
        this.L = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.ag = null;
        this.ah = null;
        this.ao = 0;
        this.ar = null;
        this.ao = i;
        this.B = activity;
        this.C = str;
        this.D = str2;
        this.t = com.baidu.adp.lib.e.b.a().a(activity, com.baidu.tieba.v.frs_star_title, null);
        this.L = com.baidu.adp.lib.e.b.a().a(activity, com.baidu.tieba.v.frs_show_experience, null);
        if (this.C == null || this.D == null) {
            this.t.setVisibility(8);
        }
        this.ap = (FrsOfficalBanner) this.t.findViewById(com.baidu.tieba.u.frs_offical_banner);
        this.ap.setVisibility(8);
        this.p = (RelativeLayout) this.t.findViewById(com.baidu.tieba.u.btn_love_content);
        this.an = (ImageView) this.t.findViewById(com.baidu.tieba.u.speed_icon);
        this.q = (TextView) this.t.findViewById(com.baidu.tieba.u.level_name);
        this.r = (TextView) this.t.findViewById(com.baidu.tieba.u.level);
        this.s = (ImageView) this.t.findViewById(com.baidu.tieba.u.love_level_top);
        this.R = (TextView) this.t.findViewById(com.baidu.tieba.u.frs_tag_text);
        this.G = new a(this.t, this.B);
        this.g = (FrameLayout) this.t.findViewById(com.baidu.tieba.u.love);
        this.h = (Button) this.t.findViewById(com.baidu.tieba.u.btn_love);
        this.i = (TextView) this.t.findViewById(com.baidu.tieba.u.tv_love);
        this.j = (FrameLayout) this.t.findViewById(com.baidu.tieba.u.sign);
        this.k = (Button) this.t.findViewById(com.baidu.tieba.u.btn_sign);
        this.l = (TextView) this.t.findViewById(com.baidu.tieba.u.tv_sign);
        this.m = (ProgressBar) this.t.findViewById(com.baidu.tieba.u.sign_progress);
        this.n = (FrameLayout) this.t.findViewById(com.baidu.tieba.u.sign_done);
        this.o = (TextView) this.t.findViewById(com.baidu.tieba.u.sign_done_text);
        this.d = (TextView) this.t.findViewById(com.baidu.tieba.u.member_num_text);
        this.e = (TextView) this.t.findViewById(com.baidu.tieba.u.post_num_text);
        this.f = (TextView) this.t.findViewById(com.baidu.tieba.u.title_text);
        this.ag = (RelativeLayout) this.t.findViewById(com.baidu.tieba.u.fan_timer_layout);
        this.ah = (RelativeLayout) this.t.findViewById(com.baidu.tieba.u.fan_num_layout);
        this.I = (TbImageView) this.t.findViewById(com.baidu.tieba.u.frs_star_top_pic);
        this.I.setOnClickListener(new q(this));
        this.J = (BarImageView) this.t.findViewById(com.baidu.tieba.u.frs_star_bottom_photo);
        this.J.setGifIconSupport(false);
        this.O = (TextView) this.t.findViewById(com.baidu.tieba.u.add_fan);
        this.P = (TextView) this.t.findViewById(com.baidu.tieba.u.fan_num);
        this.Q = (CustomTimerView) this.t.findViewById(com.baidu.tieba.u.open_timer);
        this.Q.setTextColor(-11250604);
        this.Q.setNumColor(-13401629);
        this.Q.setTextMargin(3);
        this.Q.setNumMargin(2);
        this.aq = (ImageView) this.t.findViewById(com.baidu.tieba.u.frs_enter_detail);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.aq.setVisibility(0);
        } else {
            this.aq.setVisibility(8);
        }
        this.ar = (UserIconBox) this.t.findViewById(com.baidu.tieba.u.frs_badge_box);
        this.am = new bs(this.B);
        this.u = (FrameLayout) this.t.findViewById(com.baidu.tieba.u.frs_header_groups);
        this.v = (TextView) this.t.findViewById(com.baidu.tieba.u.frs_header_groups_text);
        this.w = (FrameLayout) this.t.findViewById(com.baidu.tieba.u.frs_header_games);
        this.x = (TextView) this.t.findViewById(com.baidu.tieba.u.frs_header_games_text);
        this.y = new w(this.t);
        this.ax = (WorldCupView) this.t.findViewById(com.baidu.tieba.u.worldcup);
    }

    public boolean c() {
        int[] iArr = new int[2];
        try {
            this.an.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.u.setOnClickListener(onClickListener);
        if (this.w != null) {
            this.w.setOnClickListener(onClickListener);
        }
        this.p.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.t.setOnClickListener(new r(this));
        }
        this.G.a(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.O.setOnClickListener(onClickListener);
        this.R.setOnClickListener(new s(this));
    }

    public void a(int i) {
        this.aj = i;
        ((FrsActivity) this.B).getLayoutMode().a(i == 1);
        ((FrsActivity) this.B).getLayoutMode().a(this.t);
        ((FrsActivity) this.B).getLayoutMode().a(this.L);
        if (this.ak) {
            d(1);
        } else {
            d(0);
        }
        this.r.setBackgroundResource(com.baidu.tbadk.core.util.d.b(this.W));
        this.J.invalidate();
        this.I.invalidate();
        if (i == 1) {
            if (this.S >= 0 && this.S < ae.length) {
                ay.e((View) this.R, af[this.S]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_like_1, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign_1, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.r.frs_like_shadow_1));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.r.frs_sign_shadow_1));
            this.Q.setTextColor(-9798255);
            this.Q.setNumColor(-13669967);
            this.u.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg_1);
            if (this.w != null) {
                this.w.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg_1);
            }
            this.aq.setImageResource(com.baidu.tieba.t.icon_arrow_right_1);
            if (this.ao != 0) {
                this.an.setBackgroundResource(com.baidu.tieba.t.icon_speed_orange_1);
            } else {
                this.an.setBackgroundResource(com.baidu.tieba.t.icon_speed_gray_1);
            }
        } else {
            this.aq.setImageResource(com.baidu.tieba.t.icon_arrow_right);
            if (this.S >= 0 && this.S < ae.length) {
                ay.e((View) this.R, ae[this.S]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_like, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.r.frs_like_shadow));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.r.frs_sign_shadow));
            this.Q.setTextColor(-11250604);
            this.Q.setNumColor(-13401629);
            this.u.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg);
            if (this.w != null) {
                this.w.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg);
            }
            if (this.ao != 0) {
                this.an.setBackgroundResource(com.baidu.tieba.t.icon_speed_orange);
            } else {
                this.an.setBackgroundResource(com.baidu.tieba.t.icon_speed_gray);
            }
        }
        if (this.y != null) {
            this.y.a(i);
        }
        if (this.ax != null) {
            this.ax.a(i);
        }
    }

    public void d() {
        if (this.aj == 1) {
            if (this.ao != 0) {
                this.an.setImageResource(com.baidu.tieba.t.icon_speed_orange_1);
            } else {
                this.an.setImageResource(com.baidu.tieba.t.icon_speed_gray_1);
            }
        } else if (this.ao != 0) {
            this.an.setImageResource(com.baidu.tieba.t.icon_speed_orange);
        } else {
            this.an.setImageResource(com.baidu.tieba.t.icon_speed_gray);
        }
    }

    public View e() {
        return this.t;
    }

    public void a(ForumData forumData, com.baidu.tieba.frs.g gVar) {
        if (gVar != null) {
            this.C = forumData.getName();
            this.D = forumData.getId();
            this.E = forumData.getMember_num();
            this.F = forumData.getPost_num();
            this.T = forumData.getTag_name();
            this.U = forumData.getTag_color();
            this.ab = forumData.getSignData().getCountSignNum();
            this.ac = forumData.getCurScore();
            this.ad = forumData.getLevelupScore();
            this.z = gVar;
            this.H = gVar.n();
            this.at = forumData.getBadgeData();
            this.a = new com.baidu.tbadk.core.data.n();
            this.aw = forumData.getWorldCupData();
            if (this.H != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.H.b());
                this.a.x().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.H.c());
                this.a.x().add(mediaData2);
            }
            this.t.setVisibility(0);
            this.G.a(forumData.getName());
            o();
        }
    }

    private void o() {
        if (this.d != null) {
            this.d.setText(String.valueOf(this.E));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.F));
        }
        if (this.f != null) {
            if (this.at != null && this.at.size() > 0) {
                this.C = UtilHelper.getFixedText(this.C, 7);
            }
            this.f.setText(String.valueOf(this.C) + this.B.getString(com.baidu.tieba.x.forum));
        }
        if (this.T != null && this.T.length() > 0) {
            if (this.R != null) {
                this.R.setText(this.T);
            }
            if (this.R != null && this.U != null && this.U.length() > 0) {
                this.S = Integer.parseInt(this.U);
                if (this.S >= 0 && this.S < ae.length) {
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        ay.e((View) this.R, af[this.S]);
                    } else {
                        ay.e((View) this.R, ae[this.S]);
                    }
                }
            }
            if (this.R != null) {
                this.R.setVisibility(0);
            }
        } else if (this.R != null) {
            this.R.setVisibility(8);
        }
        if (this.z != null && this.z.l() != null && this.z.l().getIfpost() == 0) {
            if (this.z.j().isEmpty()) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
                if (this.z.r().a() > 0) {
                    this.v.setText(String.format(this.B.getString(com.baidu.tieba.x.frs_forum_groups), Integer.valueOf(this.z.r().a())));
                } else {
                    this.v.setText(this.B.getString(com.baidu.tieba.x.frsgroup_title));
                }
            }
        } else {
            this.u.setVisibility(0);
            if (this.z != null && this.z.r().a() > 0) {
                this.v.setText(String.format(this.B.getString(com.baidu.tieba.x.frs_forum_groups), Integer.valueOf(this.z.r().a())));
            } else {
                this.v.setText(this.B.getString(com.baidu.tieba.x.frsgroup_title));
            }
        }
        if (this.w != null && this.x != null) {
            if (this.z != null && this.z.a()) {
                this.w.setVisibility(0);
                this.x.setText(com.baidu.tieba.x.frsgame_title);
            } else {
                this.w.setVisibility(8);
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.j.b(this.B);
        if (this.H.d() == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = (int) this.B.getResources().getDimension(com.baidu.tieba.s.ds300);
        }
        this.I.setLayoutParams(layoutParams);
        this.I.setDefaultResource(com.baidu.tieba.t.def_star_top_pic);
        this.I.setNightDefaultResource(com.baidu.tieba.t.def_star_top_pic);
        this.I.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.J.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.I.a(this.H.b(), 16, this.H.d(), this.H.e(), false);
        this.J.a(this.H.c(), 16, false);
        if (this.H.f() == 0) {
            this.ah.setVisibility(8);
            this.O.setVisibility(8);
            if (this.H.g() <= 0) {
                this.ag.setVisibility(8);
            } else {
                this.ag.setVisibility(0);
            }
        } else {
            this.ag.setVisibility(8);
            if (this.H.h() == 0) {
                this.ah.setVisibility(8);
                this.O.setVisibility(0);
            } else {
                this.O.setVisibility(8);
                this.ah.setVisibility(0);
                this.P.setText(String.valueOf(this.H.i()));
            }
        }
        if (this.ar != null && this.at != null && this.at.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.at.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.at.get(i).b());
                iconData.setIcon(this.at.get(i).a());
                this.as = this.at.get(i).c();
                linkedList.add(iconData);
            }
            this.ar.setOnClickListener(this.c);
            this.ar.a(linkedList, 2, this.B.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_starheader_badge_width), this.B.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_starheader_badge_height), this.B.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_starheader_badge_margin));
        }
        if (this.z != null) {
            this.y.a(this.z.n(), this.z.i());
        } else {
            this.y.a(null, null);
        }
        if (this.ay) {
            this.aw = new com.baidu.tbadk.core.data.q();
            this.ax.setVisibility(0);
            this.ax.setData(this.aw);
            return;
        }
        this.ax.setVisibility(8);
    }

    public void b(int i) {
        this.ao = i;
    }

    public void f() {
        PopupWindow popupWindow = new PopupWindow(this.B);
        View a = com.baidu.adp.lib.e.b.a().a(this.B, com.baidu.tieba.v.speed_tip, null);
        if (this.B instanceof BaseActivity) {
            ((BaseActivity) this.B).getLayoutMode().a(a);
        }
        popupWindow.setContentView(a);
        a.setOnClickListener(new t(this, popupWindow));
        popupWindow.setWidth(this.B.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds284));
        popupWindow.setHeight(this.B.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        int[] iArr = new int[2];
        this.an.getLocationOnScreen(iArr);
        com.baidu.adp.lib.e.e.a(popupWindow, this.t, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.an.getWidth() / 2), iArr[1] + this.an.getWidth());
        popupWindow.update();
    }

    private void c(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.q.setText(com.baidu.tieba.x.star_bar_level_up);
                this.r.setText(String.valueOf(this.W + 1));
            } else {
                this.q.setText(this.V);
                this.r.setText(String.valueOf(this.W));
                this.r.setBackgroundResource(com.baidu.tbadk.core.util.d.b(this.W));
            }
            float f2 = this.X * width;
            float f3 = f2 > 0.001f ? this.Y / f2 : 0.0f;
            this.Y = f2;
            if (this.Z) {
                this.Z = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams.width = (int) this.Y;
            this.s.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.s.startAnimation(scaleAnimation);
        }
    }

    public void a(float f) {
        if (this.X >= 0.999f) {
            this.Z = true;
        }
        this.X = f >= 1.0f ? 1.0f : f;
        this.aa = f >= 1.0f;
        c(this.aa);
    }

    public void a(View view, boolean z) {
        if (this.ao != 0) {
            if (this.K == null) {
                this.K = new PopupWindow(this.B);
                this.K.setContentView(this.L);
                this.K.setBackgroundDrawable(new BitmapDrawable());
                this.K.setOutsideTouchable(true);
                this.K.setFocusable(true);
                this.K.setWidth(this.B.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_btn_width));
                this.K.setHeight(this.B.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_exp_height));
                this.M = (TextView) this.L.findViewById(com.baidu.tieba.u.cur_experience);
                this.N = (TextView) this.L.findViewById(com.baidu.tieba.u.levelup_experience);
                a(this.M, this.N);
            }
            if (this.K.isShowing()) {
                com.baidu.adp.lib.e.e.a(this.K, this.B);
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.M, this.N);
            int height = iArr[1] - this.K.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.e.e.a(this.K, this.B);
                return;
            }
            com.baidu.adp.lib.e.e.a(this.K, this.t, 0, iArr[0], height);
            this.K.update();
            this.al.postDelayed(this.b, 2000L);
        } else if (!z) {
            View a = com.baidu.adp.lib.e.b.a().a(this.B, com.baidu.tieba.v.no_mem_dialog, null);
            TextView textView = (TextView) a.findViewById(com.baidu.tieba.u.experience);
            TextView textView2 = (TextView) a.findViewById(com.baidu.tieba.u.cur_experience_mem);
            TextView textView3 = (TextView) a.findViewById(com.baidu.tieba.u.levelup_experience_mem);
            TextView textView4 = (TextView) a.findViewById(com.baidu.tieba.u.speed_tip);
            if (1 == this.aj) {
                textView.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                textView2.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                textView3.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                textView4.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
            } else {
                textView.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                textView2.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                textView3.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                textView4.setTextColor(this.B.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.B);
            aVar.a(a);
            a(textView2, textView3);
            aVar.b(com.baidu.tieba.x.cancel_text, new u(this));
            aVar.a(com.baidu.tieba.x.open_now, new v(this));
            aVar.a().c();
        }
    }

    private void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.ac));
        if (this.aa) {
            textView2.setVisibility(8);
            return;
        }
        textView2.setVisibility(0);
        if (this.ad >= 10000) {
            if (this.ad % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                textView2.setText(String.valueOf(this.B.getString(com.baidu.tieba.x.experience_divider)) + String.valueOf(this.ad / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.B.getString(com.baidu.tieba.x.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.B.getString(com.baidu.tieba.x.experience_divider)) + String.valueOf(this.ad / 10000.0f) + this.B.getString(com.baidu.tieba.x.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.B.getString(com.baidu.tieba.x.experience_divider)) + String.valueOf(this.ad));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.V = str;
        this.W = i2;
        if (i == 0) {
            this.A = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.A = true;
        this.g.setVisibility(8);
        if (z) {
            this.am.a(this.g);
        }
        a(f);
        this.p.setVisibility(0);
    }

    public void c(int i) {
        if (i == 0) {
            this.A = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.A = true;
        this.g.setVisibility(8);
        this.p.setVisibility(0);
    }

    public void d(int i) {
        if (i == 0) {
            this.ak = false;
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            if (this.aj == 1) {
                this.k.setBackgroundResource(com.baidu.tieba.t.frs_btn_sign_1);
                return;
            } else {
                this.k.setBackgroundResource(com.baidu.tieba.t.frs_btn_sign);
                return;
            }
        }
        this.ak = true;
        this.j.setVisibility(8);
        if (this.aj == 1) {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign_d_1, 0, 0, 0);
        } else {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign_d, 0, 0, 0);
        }
        if (this.ab <= 1) {
            this.o.setText(this.B.getString(com.baidu.tieba.x.signed));
        } else {
            this.o.setText(String.valueOf(this.B.getString(com.baidu.tieba.x.signed_less)) + String.valueOf(this.ab) + this.B.getString(com.baidu.tieba.x.day));
        }
        this.n.setVisibility(0);
    }

    public boolean g() {
        return this.ak;
    }

    public void a(boolean z) {
        this.ai = z;
        if (this.ai) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(4);
        }
    }

    public boolean h() {
        return this.A;
    }

    public View i() {
        return this.p;
    }

    public boolean j() {
        return this.aa;
    }

    public boolean a(View view) {
        return this.G.a(view);
    }

    public void k() {
        this.G.b();
    }

    public void l() {
        this.G.a();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.t.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar m() {
        return this.m;
    }

    public void n() {
        this.av = true;
    }

    public void b(boolean z) {
        this.ay = z;
    }
}
