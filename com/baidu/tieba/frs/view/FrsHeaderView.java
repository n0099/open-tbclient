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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class FrsHeaderView {
    private static final int[] Z = {com.baidu.tieba.a.g.label_green, com.baidu.tieba.a.g.label_blue, com.baidu.tieba.a.g.label_orange, com.baidu.tieba.a.g.label_red, com.baidu.tieba.a.g.label_purple};
    private static final int[] aa = {com.baidu.tieba.a.g.label_green_1, com.baidu.tieba.a.g.label_blue_1, com.baidu.tieba.a.g.label_orange_1, com.baidu.tieba.a.g.label_red_1, com.baidu.tieba.a.g.label_purple_1};
    private Activity B;
    private String C;
    private String D;
    private Handler M;
    private HeadImageView N;
    private com.baidu.tbadk.core.util.b O;
    private TextView P;
    private e Q;
    private String R;
    private int S;
    private int T;
    private int U;
    private boolean ab;
    private int ac;
    private int ad;
    private final bj af;
    private final ViewGroup ag;
    private ImageView ah;
    private UserIconBox ai;
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
    private View u;
    private FrameLayout v;
    private TextView w;
    private View y;
    private PopupWindow x = null;
    private TextView z = null;
    private TextView A = null;
    private int E = 0;
    private int F = 0;
    private int G = -1;
    private String H = null;
    private String I = null;
    private String J = null;
    private com.baidu.tieba.frs.g K = null;
    private boolean L = false;
    com.baidu.tbadk.core.data.o a = null;
    private float V = 0.0f;
    private float W = 0.0f;
    private boolean X = false;
    private boolean Y = false;
    private boolean ae = false;
    private final int aj = 2;
    private String ak = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.a> al = null;
    final Runnable b = new g(this);
    View.OnClickListener c = new h(this);

    /* loaded from: classes.dex */
    public enum PAGE {
        FRS_LIST,
        FRS_IMAGE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PAGE[] valuesCustom() {
            PAGE[] valuesCustom = values();
            int length = valuesCustom.length;
            PAGE[] pageArr = new PAGE[length];
            System.arraycopy(valuesCustom, 0, pageArr, 0, length);
            return pageArr;
        }
    }

    public FrsHeaderView(Activity activity, String str, String str2) {
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
        this.y = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.ah = null;
        this.ai = null;
        this.M = new Handler();
        this.B = activity;
        this.C = null;
        this.D = null;
        LayoutInflater from = LayoutInflater.from(activity);
        this.t = from.inflate(com.baidu.tieba.a.i.frs_header, (ViewGroup) null);
        this.u = this.t.findViewById(com.baidu.tieba.a.h.container);
        this.y = from.inflate(com.baidu.tieba.a.i.frs_show_experience, (ViewGroup) null);
        if (this.C == null || this.D == null) {
            this.t.setVisibility(8);
        }
        this.p = (RelativeLayout) this.t.findViewById(com.baidu.tieba.a.h.btn_love_content);
        this.ag = (ViewGroup) this.t.findViewById(com.baidu.tieba.a.h.frs_forum_entry);
        this.ah = (ImageView) this.t.findViewById(com.baidu.tieba.a.h.frs_enter_detail);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.ag.setVisibility(0);
        } else {
            this.ag.setVisibility(8);
        }
        this.Q = new e(this.t, this.B);
        this.q = (TextView) this.t.findViewById(com.baidu.tieba.a.h.level_name);
        this.r = (TextView) this.t.findViewById(com.baidu.tieba.a.h.level);
        this.s = (ImageView) this.t.findViewById(com.baidu.tieba.a.h.love_level_top);
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
        this.P = (TextView) this.t.findViewById(com.baidu.tieba.a.h.frs_tag_text);
        this.N = (HeadImageView) this.t.findViewById(com.baidu.tieba.a.h.frs_image);
        this.N.setGifIconSupport(false);
        this.ai = (UserIconBox) this.t.findViewById(com.baidu.tieba.a.h.frs_badge_box);
        this.v = (FrameLayout) this.t.findViewById(com.baidu.tieba.a.h.frs_header_groups);
        this.w = (TextView) this.t.findViewById(com.baidu.tieba.a.h.frs_header_groups_text);
        this.O = new com.baidu.tbadk.core.util.b(this.B);
        this.O.a(this.B.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_photo_width), this.B.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_photo_height));
        this.af = new bj(this.B);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.v.setOnClickListener(onClickListener);
        this.p.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.t.setOnClickListener(new i(this));
        }
        this.Q.a(onClickListener);
        this.P.setOnClickListener(new j(this));
    }

    public final com.baidu.tbadk.core.util.b a() {
        return this.O;
    }

    public final com.baidu.tbadk.core.data.o b() {
        return this.a;
    }

    public final void a(int i) {
        this.ac = i;
        ((FrsActivity) this.B).getLayoutMode().a(i == 1);
        ((FrsActivity) this.B).getLayoutMode().a(this.t);
        ((FrsActivity) this.B).getLayoutMode().a(this.y);
        if (this.L) {
            c(1);
        } else {
            c(0);
        }
        this.N.invalidate();
        this.r.setBackgroundResource(com.baidu.tbadk.core.util.g.b(this.S));
        if (i == 1) {
            this.u.setBackgroundColor(this.B.getResources().getColor(com.baidu.tieba.a.e.frs_header_bg_1));
            if (this.G >= 0 && this.G < Z.length) {
                ba.e((View) this.P, aa[this.G]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_like_1, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign_1, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.a.e.frs_like_shadow_1));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.a.e.frs_sign_shadow_1));
            ba.e(this.ah, com.baidu.tieba.a.g.icon_arrow_right_1);
            this.v.setBackgroundResource(com.baidu.tieba.a.g.frs_top_item_bg_1);
            return;
        }
        this.u.setBackgroundColor(this.B.getResources().getColor(com.baidu.tieba.a.e.frs_header_bg));
        if (this.G >= 0 && this.G < Z.length) {
            ba.e((View) this.P, Z[this.G]);
        }
        this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_like, 0, 0, 0);
        this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign, 0, 0, 0);
        this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.a.e.frs_like_shadow));
        this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(com.baidu.tieba.a.e.frs_sign_shadow));
        ba.e(this.ah, com.baidu.tieba.a.g.icon_arrow_right);
        this.v.setBackgroundResource(com.baidu.tieba.a.g.frs_top_item_bg);
    }

    public final View c() {
        return this.t;
    }

    public final void a(ForumData forumData, com.baidu.tieba.frs.g gVar) {
        int i = 0;
        this.C = forumData.getName();
        this.D = forumData.getId();
        this.E = forumData.getMember_num();
        this.F = forumData.getPost_num();
        this.H = forumData.getTag_name();
        this.I = forumData.getTag_color();
        this.J = forumData.getImage_url();
        this.R = forumData.getLevelName();
        this.S = forumData.getUser_level();
        this.ad = forumData.getSignData().getCountSignNum();
        this.T = forumData.getCurScore();
        this.U = forumData.getLevelupScore();
        this.al = forumData.getBadgeData();
        this.K = gVar;
        this.t.setVisibility(0);
        this.a = new com.baidu.tbadk.core.data.o();
        com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
        jVar.a(3);
        jVar.a(this.J);
        this.a.z().add(jVar);
        this.Q.a(forumData.getName());
        if (this.d != null) {
            this.d.setText(String.valueOf(this.E));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.F));
        }
        if (this.f != null) {
            if (this.al != null && this.al.size() > 0) {
                this.C = UtilHelper.a(this.C, 7);
            }
            this.f.setText(String.valueOf(this.C) + this.B.getString(com.baidu.tieba.a.k.forum));
        }
        if (this.H != null && this.H.length() > 0) {
            if (this.P != null) {
                this.P.setText(this.H);
            }
            if (this.P != null && this.I != null && this.I.length() > 0) {
                this.G = Integer.parseInt(this.I);
                if (this.G >= 0 && this.G < Z.length) {
                    if (TbadkApplication.j().l() == 1) {
                        ba.e((View) this.P, aa[this.G]);
                    } else {
                        ba.e((View) this.P, Z[this.G]);
                    }
                }
            }
            if (this.P != null) {
                this.P.setVisibility(0);
            }
        } else if (this.P != null) {
            this.P.setVisibility(8);
        }
        if (this.K == null || this.K.i() == null || this.K.i().getIfpost() != 0) {
            this.v.setVisibility(0);
            if (this.K == null || this.K.o().a() <= 0) {
                this.w.setText(this.B.getString(com.baidu.tieba.a.k.frsgroup_title));
            } else {
                this.w.setText(String.format(this.B.getString(com.baidu.tieba.a.k.frs_forum_groups), Integer.valueOf(this.K.o().a())));
            }
        } else if (this.K.g().isEmpty()) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
            if (this.K.o().a() > 0) {
                this.w.setText(String.format(this.B.getString(com.baidu.tieba.a.k.frs_forum_groups), Integer.valueOf(this.K.o().a())));
            } else {
                this.w.setText(this.B.getString(com.baidu.tieba.a.k.frsgroup_title));
            }
        }
        this.N.setDefaultResource(com.baidu.tieba.a.g.pic_avatar_ba_140);
        this.N.setNightDefaultResource(com.baidu.tieba.a.g.pic_avatar_ba_140_1);
        this.N.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setTag(this.J);
        if (this.ai == null || this.al == null || this.al.size() <= 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int i2 = i;
            if (i2 >= this.al.size()) {
                this.ai.setOnClickListener(this.c);
                this.ai.a(linkedList, 2, this.B.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_badge_width), this.B.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_badge_height), this.B.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_badge_margin));
                return;
            }
            IconData iconData = new IconData();
            iconData.setIconName(this.al.get(i2).b());
            iconData.setIcon(this.al.get(i2).a());
            this.ak = this.al.get(i2).c();
            linkedList.add(iconData);
            i = i2 + 1;
        }
    }

    public final void a(View view) {
        if (this.x == null) {
            this.x = new PopupWindow(this.B);
            this.x.setContentView(this.y);
            this.x.setBackgroundDrawable(new BitmapDrawable());
            this.x.setOutsideTouchable(true);
            this.x.setFocusable(true);
            this.x.setWidth(this.B.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_btn_width));
            this.x.setHeight(this.B.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_exp_height));
            this.z = (TextView) this.y.findViewById(com.baidu.tieba.a.h.cur_experience);
            this.A = (TextView) this.y.findViewById(com.baidu.tieba.a.h.levelup_experience);
            k();
        }
        if (this.x.isShowing()) {
            this.x.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        k();
        this.x.showAtLocation(this.t, 0, iArr[0], iArr[1] - this.x.getHeight());
        this.x.update();
        this.M.postDelayed(this.b, 2000L);
    }

    private void k() {
        this.z.setText(String.valueOf(this.T));
        if (this.Y) {
            this.A.setVisibility(8);
            return;
        }
        this.A.setVisibility(0);
        if (this.U >= 10000) {
            if (this.U % 10000 == 0) {
                this.A.setText(String.valueOf(this.B.getString(com.baidu.tieba.a.k.experience_divider)) + String.valueOf(this.U / 10000) + this.B.getString(com.baidu.tieba.a.k.member_count_unit));
                return;
            } else {
                this.A.setText(String.valueOf(this.B.getString(com.baidu.tieba.a.k.experience_divider)) + String.valueOf(this.U / 10000.0f) + this.B.getString(com.baidu.tieba.a.k.member_count_unit));
                return;
            }
        }
        this.A.setText(String.valueOf(this.B.getString(com.baidu.tieba.a.k.experience_divider)) + String.valueOf(this.U));
    }

    public final void a(int i, String str, int i2, float f, boolean z) {
        this.R = str;
        this.S = i2;
        if (i == 0) {
            this.ae = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.ae = true;
        this.g.setVisibility(8);
        if (z) {
            this.af.a(this.g);
        }
        a(f);
        this.p.setVisibility(0);
    }

    public final void b(int i) {
        if (i == 0) {
            this.ae = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.ae = true;
        this.g.setVisibility(8);
        this.p.setVisibility(0);
    }

    public final void c(int i) {
        if (i == 0) {
            this.L = false;
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            if (this.ac == 1) {
                this.k.setBackgroundResource(com.baidu.tieba.a.g.frs_btn_sign_1);
                return;
            } else {
                this.k.setBackgroundResource(com.baidu.tieba.a.g.frs_btn_sign);
                return;
            }
        }
        this.L = true;
        this.j.setVisibility(8);
        if (this.ac == 1) {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign_d_1, 0, 0, 0);
        } else {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.a.g.icon_sign_d, 0, 0, 0);
        }
        if (this.ad == 1) {
            this.o.setText(this.B.getString(com.baidu.tieba.a.k.signed));
        } else {
            this.o.setText(String.valueOf(this.B.getString(com.baidu.tieba.a.k.signed_less)) + String.valueOf(this.ad) + this.B.getString(com.baidu.tieba.a.k.day));
        }
        this.n.setVisibility(0);
    }

    public final boolean d() {
        return this.L;
    }

    public final void a(boolean z) {
        this.ab = false;
        if (this.ab) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public final void a(float f) {
        int width;
        float f2 = 0.0f;
        if (this.V >= 0.999f) {
            this.X = true;
        }
        this.V = f >= 1.0f ? 1.0f : f;
        this.Y = f >= 1.0f;
        boolean z = this.Y;
        Bitmap a = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.bg_frs_signin_bar_down);
        if (a == null || (width = a.getWidth()) <= 0) {
            return;
        }
        if (z) {
            this.q.setText(com.baidu.tieba.a.k.level_up);
            this.r.setText(String.valueOf(this.S + 1));
        } else {
            this.q.setText(this.R);
            this.r.setText(String.valueOf(this.S));
            this.r.setBackgroundResource(com.baidu.tbadk.core.util.g.b(this.S));
        }
        float f3 = width * this.V;
        float f4 = f3 > 0.001f ? this.W / f3 : 0.0f;
        this.W = f3;
        if (this.X) {
            this.X = false;
        } else {
            f2 = f4;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams.width = (int) this.W;
        this.s.setLayoutParams(layoutParams);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        this.s.startAnimation(scaleAnimation);
    }

    public final boolean e() {
        return this.ae;
    }

    public final View f() {
        return this.p;
    }

    public final ProgressBar g() {
        return this.m;
    }

    public final boolean h() {
        return this.Y;
    }

    public final boolean b(View view) {
        return this.Q.a(view);
    }

    public final void i() {
        this.Q.b();
    }

    public final void j() {
        this.Q.a();
    }
}
