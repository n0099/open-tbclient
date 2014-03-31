package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import com.baidu.tieba.view.CustomTimerView;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class n implements com.baidu.tbadk.imageManager.d {
    private static final int[] ae = {com.baidu.tieba.a.g.label_green, com.baidu.tieba.a.g.label_blue, com.baidu.tieba.a.g.label_orange, com.baidu.tieba.a.g.label_red, com.baidu.tieba.a.g.label_purple};
    private static final int[] af = {com.baidu.tieba.a.g.label_green_1, com.baidu.tieba.a.g.label_blue_1, com.baidu.tieba.a.g.label_orange_1, com.baidu.tieba.a.g.label_red_1, com.baidu.tieba.a.g.label_purple_1};
    private static int ao;
    private String A;
    private e D;
    private com.baidu.tbadk.core.util.b E;
    private final com.baidu.tbadk.core.util.b G;
    private final TbImageView H;
    private final HeadImageView I;
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
    private final bj am;
    private final ImageView an;
    private UserIconBox ap;
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
    private Activity y;
    private String z;
    private com.baidu.tieba.frs.g w = null;
    private boolean x = false;
    private int B = 0;
    private int C = 0;
    private com.baidu.tieba.data.s F = null;
    com.baidu.tbadk.core.data.o a = null;
    private final float J = 0.36458334f;
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
    private final int aq = 2;
    private String ar = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.a> as = null;
    final Runnable b = new o(this);
    View.OnClickListener c = new p(this);
    private Handler al = new Handler();

    public n(Activity activity, String str, String str2) {
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
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = null;
        this.E = null;
        this.L = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.ag = null;
        this.ah = null;
        this.ap = null;
        this.y = activity;
        ao = this.y.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_starheader_photo_width);
        this.E = new com.baidu.tbadk.core.util.b(this.y);
        this.E.a(ao, ao);
        this.z = null;
        this.A = null;
        LayoutInflater from = LayoutInflater.from(activity);
        this.t = from.inflate(com.baidu.tieba.a.i.frs_star_title, (ViewGroup) null);
        this.L = from.inflate(com.baidu.tieba.a.i.frs_show_experience, (ViewGroup) null);
        if (this.z == null || this.A == null) {
            this.t.setVisibility(8);
        }
        this.p = (RelativeLayout) this.t.findViewById(com.baidu.tieba.a.h.btn_love_content);
        this.q = (TextView) this.t.findViewById(com.baidu.tieba.a.h.level_name);
        this.r = (TextView) this.t.findViewById(com.baidu.tieba.a.h.level);
        this.s = (ImageView) this.t.findViewById(com.baidu.tieba.a.h.love_level_top);
        this.R = (TextView) this.t.findViewById(com.baidu.tieba.a.h.frs_tag_text);
        this.D = new e(this.t, this.y);
        this.g = (FrameLayout) this.t.findViewById(com.baidu.tieba.a.h.love);
        this.h = (Button) this.t.findViewById(com.baidu.tieba.a.h.btn_love);
        this.i = (TextView) this.t.findViewById(com.baidu.tieba.a.h.tv_love);
        this.j = (FrameLayout) this.t.findViewById(com.baidu.tieba.a.h.sign);
        this.k = (Button) this.t.findViewById(com.baidu.tieba.a.h.btn_sign);
        this.l = (TextView) this.t.findViewById(com.baidu.tieba.a.h.tv_sign);
        this.m = (ProgressBar) this.t.findViewById(com.baidu.tieba.a.h.sign_progress);
        this.n = (FrameLayout) this.t.findViewById(com.baidu.tieba.a.h.sign_done);
        this.o = (TextView) this.t.findViewById(com.baidu.tieba.a.h.sign_done_text);
        this.d = (TextView) this.t.findViewById(com.baidu.tieba.a.h.member_num_text);
        this.e = (TextView) this.t.findViewById(com.baidu.tieba.a.h.post_num_text);
        this.f = (TextView) this.t.findViewById(com.baidu.tieba.a.h.title_text);
        this.ag = (RelativeLayout) this.t.findViewById(com.baidu.tieba.a.h.fan_timer_layout);
        this.ah = (RelativeLayout) this.t.findViewById(com.baidu.tieba.a.h.fan_num_layout);
        this.H = (TbImageView) this.t.findViewById(com.baidu.tieba.a.h.frs_star_top_pic);
        this.I = (HeadImageView) this.t.findViewById(com.baidu.tieba.a.h.frs_star_bottom_photo);
        this.I.setGifIconSupport(false);
        this.O = (TextView) this.t.findViewById(com.baidu.tieba.a.h.add_fan);
        this.P = (TextView) this.t.findViewById(com.baidu.tieba.a.h.fan_num);
        this.Q = (CustomTimerView) this.t.findViewById(com.baidu.tieba.a.h.open_timer);
        this.Q.setTextColor(-11250604);
        this.Q.setNumColor(-13401629);
        this.Q.setTextMargin(3);
        this.Q.setNumMargin(2);
        this.G = new com.baidu.tbadk.core.util.b(this.y);
        this.an = (ImageView) this.t.findViewById(com.baidu.tieba.a.h.frs_enter_detail);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.an.setVisibility(0);
        } else {
            this.an.setVisibility(8);
        }
        this.ap = (UserIconBox) this.t.findViewById(com.baidu.tieba.a.h.frs_badge_box);
        this.am = new bj(this.y);
        this.u = (FrameLayout) this.t.findViewById(com.baidu.tieba.a.h.frs_header_groups);
        this.v = (TextView) this.t.findViewById(com.baidu.tieba.a.h.frs_header_groups_text);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.u.setOnClickListener(onClickListener);
        this.p.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.t.setOnClickListener(new q(this));
        }
        this.D.a(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.O.setOnClickListener(onClickListener);
        this.R.setOnClickListener(new r(this));
    }

    public final com.baidu.tbadk.core.util.b a() {
        return this.G;
    }

    public final com.baidu.tbadk.core.data.o b() {
        return this.a;
    }

    public final void a(int i) {
        this.aj = i;
        ((FrsActivity) this.y).getLayoutMode().a(i == 1);
        ((FrsActivity) this.y).getLayoutMode().a(this.t);
        ((FrsActivity) this.y).getLayoutMode().a(this.L);
        if (this.ak) {
            c(1);
        } else {
            c(0);
        }
        this.r.setBackgroundResource(com.baidu.tbadk.core.util.g.b(this.W));
        this.I.invalidate();
        this.H.invalidate();
        if (i == 1) {
            if (this.S >= 0 && this.S < ae.length) {
                ba.e((View) this.R, af[this.S]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_like_1, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign_1, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(com.baidu.tieba.a.e.frs_like_shadow_1));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(com.baidu.tieba.a.e.frs_sign_shadow_1));
            this.Q.setTextColor(-9798255);
            this.Q.setNumColor(-13669967);
            this.u.setBackgroundResource(com.baidu.tieba.a.g.frs_top_item_bg_1);
            this.an.setImageResource(com.baidu.tieba.a.g.icon_arrow_right_1);
            return;
        }
        this.an.setImageResource(com.baidu.tieba.a.g.icon_arrow_right);
        if (this.S >= 0 && this.S < ae.length) {
            ba.e((View) this.R, ae[this.S]);
        }
        this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_like, 0, 0, 0);
        this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign, 0, 0, 0);
        this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(com.baidu.tieba.a.e.frs_like_shadow));
        this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.y.getResources().getColor(com.baidu.tieba.a.e.frs_sign_shadow));
        this.Q.setTextColor(-11250604);
        this.Q.setNumColor(-13401629);
        this.u.setBackgroundResource(com.baidu.tieba.a.g.frs_top_item_bg);
    }

    public final View c() {
        return this.t;
    }

    public final void a(ForumData forumData, com.baidu.tieba.frs.g gVar) {
        if (gVar != null) {
            this.z = forumData.getName();
            this.A = forumData.getId();
            this.B = forumData.getMember_num();
            this.C = forumData.getPost_num();
            this.T = forumData.getTag_name();
            this.U = forumData.getTag_color();
            this.ab = forumData.getSignData().getCountSignNum();
            this.ac = forumData.getCurScore();
            this.ad = forumData.getLevelupScore();
            this.w = gVar;
            this.F = gVar.k();
            this.as = forumData.getBadgeData();
            this.a = new com.baidu.tbadk.core.data.o();
            if (this.F != null) {
                com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
                jVar.a(3);
                jVar.a(this.F.b());
                this.a.z().add(jVar);
                com.baidu.tbadk.core.data.j jVar2 = new com.baidu.tbadk.core.data.j();
                jVar2.a(3);
                jVar2.a(this.F.c());
                this.a.z().add(jVar2);
            }
            this.t.setVisibility(0);
            this.D.a(forumData.getName());
            if (this.d != null) {
                this.d.setText(String.valueOf(this.B));
            }
            if (this.e != null) {
                this.e.setText(String.valueOf(this.C));
            }
            if (this.f != null) {
                if (this.as != null && this.as.size() > 0) {
                    this.z = UtilHelper.a(this.z, 7);
                }
                this.f.setText(String.valueOf(this.z) + this.y.getString(com.baidu.tieba.a.k.forum));
            }
            if (this.T != null && this.T.length() > 0) {
                if (this.R != null) {
                    this.R.setText(this.T);
                }
                if (this.R != null && this.U != null && this.U.length() > 0) {
                    this.S = Integer.parseInt(this.U);
                    if (this.S >= 0 && this.S < ae.length) {
                        if (TbadkApplication.j().l() == 1) {
                            ba.e((View) this.R, af[this.S]);
                        } else {
                            ba.e((View) this.R, ae[this.S]);
                        }
                    }
                }
                if (this.R != null) {
                    this.R.setVisibility(0);
                }
            } else if (this.R != null) {
                this.R.setVisibility(8);
            }
            if (this.w == null || this.w.i() == null || this.w.i().getIfpost() != 0) {
                this.u.setVisibility(0);
                if (this.w == null || this.w.o().a() <= 0) {
                    this.v.setText(this.y.getString(com.baidu.tieba.a.k.frsgroup_title));
                } else {
                    this.v.setText(String.format(this.y.getString(com.baidu.tieba.a.k.frs_forum_groups), Integer.valueOf(this.w.o().a())));
                }
            } else if (this.w.g().isEmpty()) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
                if (this.w.o().a() > 0) {
                    this.v.setText(String.format(this.y.getString(com.baidu.tieba.a.k.frs_forum_groups), Integer.valueOf(this.w.o().a())));
                } else {
                    this.v.setText(this.y.getString(com.baidu.tieba.a.k.frsgroup_title));
                }
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
            layoutParams.width = com.baidu.adp.lib.util.i.b(this.y);
            if (this.F.d() == 0) {
                layoutParams.height = 1;
            } else {
                layoutParams.height = (int) (layoutParams.width * 0.36458334f);
            }
            this.G.a(this.F.d(), this.F.e());
            this.H.setLayoutParams(layoutParams);
            this.H.setDefaultResource(com.baidu.tieba.a.g.def_star_top_pic);
            this.H.setNightDefaultResource(com.baidu.tieba.a.g.def_star_top_pic);
            this.I.setDefaultResource(com.baidu.tieba.a.g.pic_avatar_ba_140);
            this.I.setNightDefaultResource(com.baidu.tieba.a.g.pic_avatar_ba_140_1);
            this.H.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.I.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.H.setTag(this.F.b());
            this.I.setTag(this.F.c());
            if (this.F.f() == 0) {
                this.ah.setVisibility(8);
                this.O.setVisibility(8);
                if (this.F.g() <= 0) {
                    this.ag.setVisibility(8);
                } else {
                    this.ag.setVisibility(0);
                }
            } else {
                this.ag.setVisibility(8);
                if (this.F.h() == 0) {
                    this.ah.setVisibility(8);
                    this.O.setVisibility(0);
                } else {
                    this.O.setVisibility(8);
                    this.ah.setVisibility(0);
                    this.P.setText(String.valueOf(this.F.i()));
                }
            }
            if (this.ap == null || this.as == null || this.as.size() <= 0) {
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.as.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.as.get(i).b());
                iconData.setIcon(this.as.get(i).a());
                this.ar = this.as.get(i).c();
                linkedList.add(iconData);
            }
            this.ap.setOnClickListener(this.c);
            this.ap.a(linkedList, 2, this.y.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_starheader_badge_width), this.y.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_starheader_badge_height), this.y.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_starheader_badge_margin));
        }
    }

    public final void a(float f) {
        int width;
        float f2 = 0.0f;
        if (this.X >= 0.999f) {
            this.Z = true;
        }
        this.X = f >= 1.0f ? 1.0f : f;
        this.aa = f >= 1.0f;
        boolean z = this.aa;
        Bitmap a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.bg_frs_signin_bar_down);
        if (a == null || (width = a.getWidth()) <= 0) {
            return;
        }
        if (z) {
            this.q.setText(com.baidu.tieba.a.k.level_up);
            this.r.setText(String.valueOf(this.W + 1));
        } else {
            this.q.setText(this.V);
            this.r.setText(String.valueOf(this.W));
            this.r.setBackgroundResource(com.baidu.tbadk.core.util.g.b(this.W));
        }
        float f3 = width * this.X;
        float f4 = f3 > 0.001f ? this.Y / f3 : 0.0f;
        this.Y = f3;
        if (this.Z) {
            this.Z = false;
        } else {
            f2 = f4;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams.width = (int) this.Y;
        this.s.setLayoutParams(layoutParams);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        this.s.startAnimation(scaleAnimation);
    }

    public final void a(View view) {
        if (this.K == null) {
            this.K = new PopupWindow(this.y);
            this.K.setContentView(this.L);
            this.K.setBackgroundDrawable(new BitmapDrawable());
            this.K.setOutsideTouchable(true);
            this.K.setFocusable(true);
            this.K.setWidth(this.y.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_btn_width));
            this.K.setHeight(this.y.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_exp_height));
            this.M = (TextView) this.L.findViewById(com.baidu.tieba.a.h.cur_experience);
            this.N = (TextView) this.L.findViewById(com.baidu.tieba.a.h.levelup_experience);
            k();
        }
        if (this.K.isShowing()) {
            this.K.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        k();
        this.K.showAtLocation(this.t, 0, iArr[0], iArr[1] - this.K.getHeight());
        this.K.update();
        this.al.postDelayed(this.b, 2000L);
    }

    private void k() {
        this.M.setText(String.valueOf(this.ac));
        if (this.aa) {
            this.N.setVisibility(8);
            return;
        }
        this.N.setVisibility(0);
        if (this.ad >= 10000) {
            if (this.ad % 10000 == 0) {
                this.N.setText(String.valueOf(this.y.getString(com.baidu.tieba.a.k.experience_divider)) + String.valueOf(this.ad / 10000) + this.y.getString(com.baidu.tieba.a.k.member_count_unit));
                return;
            } else {
                this.N.setText(String.valueOf(this.y.getString(com.baidu.tieba.a.k.experience_divider)) + String.valueOf(this.ad / 10000.0f) + this.y.getString(com.baidu.tieba.a.k.member_count_unit));
                return;
            }
        }
        this.N.setText(String.valueOf(this.y.getString(com.baidu.tieba.a.k.experience_divider)) + String.valueOf(this.ad));
    }

    public final void a(int i, String str, int i2, float f, boolean z) {
        this.V = str;
        this.W = i2;
        if (i == 0) {
            this.x = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.x = true;
        this.g.setVisibility(8);
        if (z) {
            this.am.a(this.g);
        }
        a(f);
        this.p.setVisibility(0);
    }

    public final void b(int i) {
        if (i == 0) {
            this.x = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.x = true;
        this.g.setVisibility(8);
        this.p.setVisibility(0);
    }

    public final void c(int i) {
        if (i == 0) {
            this.ak = false;
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            if (this.aj == 1) {
                this.k.setBackgroundResource(com.baidu.tieba.a.g.frs_btn_sign_1);
                return;
            } else {
                this.k.setBackgroundResource(com.baidu.tieba.a.g.frs_btn_sign);
                return;
            }
        }
        this.ak = true;
        this.j.setVisibility(8);
        if (this.aj == 1) {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign_d_1, 0, 0, 0);
        } else {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign_d, 0, 0, 0);
        }
        if (this.ab == 1) {
            this.o.setText(this.y.getString(com.baidu.tieba.a.k.signed));
        } else {
            this.o.setText(String.valueOf(this.y.getString(com.baidu.tieba.a.k.signed_less)) + String.valueOf(this.ab) + this.y.getString(com.baidu.tieba.a.k.day));
        }
        this.n.setVisibility(0);
    }

    public final boolean d() {
        return this.ak;
    }

    public final void a(boolean z) {
        this.ai = false;
        if (this.ai) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public final boolean e() {
        return this.x;
    }

    public final View f() {
        return this.p;
    }

    public final boolean g() {
        return this.aa;
    }

    public final boolean b(View view) {
        return this.D.a(view);
    }

    public final void h() {
        this.D.b();
    }

    public final void i() {
        this.D.a();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        ImageView imageView;
        if (bVar != null && (imageView = (ImageView) this.t.findViewWithTag(str)) != null) {
            bVar.a(imageView);
            imageView.invalidate();
        }
    }

    public final ProgressBar j() {
        return this.m;
    }
}
