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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.WorldCupView;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.s;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrsHeaderView {
    private static final int[] Y = {u.label_green, u.label_blue, u.label_orange, u.label_red, u.label_purple};
    private static final int[] Z = {u.label_green_1, u.label_blue_1, u.label_orange_1, u.label_red_1, u.label_purple_1};
    private Activity B;
    private String C;
    private String D;
    private Handler M;
    private HeadImageView N;
    private TextView O;
    private a P;
    private String Q;
    private int R;
    private int S;
    private int T;
    private boolean aa;
    private int ab;
    private int ac;
    private final bp ae;
    private final ViewGroup af;
    private ImageView ag;
    private UserIconBox ah;
    private boolean al;
    private com.baidu.tbadk.core.data.q am;
    private WorldCupView an;
    private boolean ao;
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
    com.baidu.tbadk.core.data.n a = null;
    private float U = 0.0f;
    private float V = 0.0f;
    private boolean W = false;
    private boolean X = false;
    private boolean ad = false;
    private final int ai = 2;
    private String aj = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.a> ak = null;
    final Runnable b = new c(this);
    View.OnClickListener c = new d(this);

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

    public FrsHeaderView(Activity activity, PAGE page, String str, String str2) {
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
        this.ag = null;
        this.ah = null;
        this.M = new Handler();
        this.B = activity;
        this.C = str;
        this.D = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.t = from.inflate(w.frs_header, (ViewGroup) null);
        this.u = this.t.findViewById(v.container);
        this.y = from.inflate(w.frs_show_experience, (ViewGroup) null);
        if (this.C == null || this.D == null) {
            this.t.setVisibility(8);
        }
        this.p = (RelativeLayout) this.t.findViewById(v.btn_love_content);
        this.af = (ViewGroup) this.t.findViewById(v.frs_forum_entry);
        this.ag = (ImageView) this.t.findViewById(v.frs_enter_detail);
        this.af.setVisibility(8);
        this.P = new a(this.t, this.B);
        this.q = (TextView) this.t.findViewById(v.level_name);
        this.r = (TextView) this.t.findViewById(v.level);
        this.s = (ImageView) this.t.findViewById(v.love_level_top);
        this.g = (FrameLayout) this.t.findViewById(v.love);
        this.h = (Button) this.t.findViewById(v.btn_love);
        this.i = (TextView) this.t.findViewById(v.tv_love);
        this.j = (FrameLayout) this.t.findViewById(v.sign);
        this.k = (Button) this.t.findViewById(v.btn_sign);
        this.l = (TextView) this.t.findViewById(v.tv_sign);
        this.m = (ProgressBar) this.t.findViewById(v.sign_progress);
        this.n = (FrameLayout) this.t.findViewById(v.sign_done);
        this.o = (TextView) this.t.findViewById(v.sign_done_text);
        this.d = (TextView) this.t.findViewById(v.member_num_text);
        this.e = (TextView) this.t.findViewById(v.post_num_text);
        this.f = (TextView) this.t.findViewById(v.title_text);
        this.O = (TextView) this.t.findViewById(v.frs_tag_text);
        this.N = (HeadImageView) this.t.findViewById(v.frs_image);
        this.N.setGifIconSupport(false);
        this.ah = (UserIconBox) this.t.findViewById(v.frs_badge_box);
        this.v = (FrameLayout) this.t.findViewById(v.frs_header_groups);
        this.w = (TextView) this.t.findViewById(v.frs_header_groups_text);
        this.ae = new bp(this.B);
        this.an = (WorldCupView) this.t.findViewById(v.worldcup);
    }

    public void a(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.v.setOnClickListener(onClickListener);
        this.p.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.t.setOnClickListener(new e(this));
        }
        this.P.a(onClickListener);
        this.O.setOnClickListener(new f(this));
    }

    public void a(int i) {
        this.ab = i;
        ((FrsActivity) this.B).getLayoutMode().a(i == 1);
        ((FrsActivity) this.B).getLayoutMode().a(this.t);
        ((FrsActivity) this.B).getLayoutMode().a(this.y);
        if (this.L) {
            c(1);
        } else {
            c(0);
        }
        this.N.invalidate();
        this.r.setBackgroundResource(com.baidu.tbadk.core.util.g.b(this.R));
        if (i == 1) {
            this.u.setBackgroundColor(this.B.getResources().getColor(s.frs_header_bg_1));
            if (this.G >= 0 && this.G < Y.length) {
                bc.e((View) this.O, Z[this.G]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(u.icon_like_1, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_1, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(s.frs_like_shadow_1));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(s.frs_sign_shadow_1));
            bc.e(this.ag, u.icon_arrow_right_1);
            this.v.setBackgroundResource(u.frs_top_item_bg_1);
        } else {
            this.u.setBackgroundColor(this.B.getResources().getColor(s.frs_header_bg));
            if (this.G >= 0 && this.G < Y.length) {
                bc.e((View) this.O, Y[this.G]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(u.icon_like, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(s.frs_like_shadow));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.B.getResources().getColor(s.frs_sign_shadow));
            bc.e(this.ag, u.icon_arrow_right);
            this.v.setBackgroundResource(u.frs_top_item_bg);
        }
        if (this.an != null) {
            this.an.a(i);
        }
    }

    public View a() {
        return this.t;
    }

    public void a(ForumData forumData, com.baidu.tieba.frs.g gVar) {
        this.C = forumData.getName();
        this.D = forumData.getId();
        this.E = forumData.getMember_num();
        this.F = forumData.getPost_num();
        this.H = forumData.getTag_name();
        this.I = forumData.getTag_color();
        this.J = forumData.getImage_url();
        this.Q = forumData.getLevelName();
        this.R = forumData.getUser_level();
        this.ac = forumData.getSignData().getCountSignNum();
        this.S = forumData.getCurScore();
        this.T = forumData.getLevelupScore();
        this.ak = forumData.getBadgeData();
        this.am = forumData.getWorldCupData();
        this.K = gVar;
        this.t.setVisibility(0);
        this.a = new com.baidu.tbadk.core.data.n();
        com.baidu.tbadk.core.data.j jVar = new com.baidu.tbadk.core.data.j();
        jVar.a(3);
        jVar.a(this.J);
        this.a.F().add(jVar);
        this.P.a(forumData.getName());
        j();
    }

    private void j() {
        if (this.d != null) {
            this.d.setText(String.valueOf(this.E));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.F));
        }
        if (this.f != null) {
            if (this.ak != null && this.ak.size() > 0) {
                this.C = UtilHelper.getFixedText(this.C, 7);
            }
            this.f.setText(String.valueOf(this.C) + this.B.getString(y.forum));
        }
        if (this.H != null && this.H.length() > 0) {
            if (this.O != null) {
                this.O.setText(this.H);
            }
            if (this.O != null && this.I != null && this.I.length() > 0) {
                this.G = Integer.parseInt(this.I);
                if (this.G >= 0 && this.G < Y.length) {
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        bc.e((View) this.O, Z[this.G]);
                    } else {
                        bc.e((View) this.O, Y[this.G]);
                    }
                }
            }
            if (this.O != null) {
                this.O.setVisibility(0);
            }
        } else if (this.O != null) {
            this.O.setVisibility(8);
        }
        if (this.K != null && this.K.j() != null && this.K.j().getIfpost() == 0) {
            if (this.K.h().isEmpty()) {
                this.v.setVisibility(8);
            } else {
                this.v.setVisibility(0);
                if (this.K.p().a() > 0) {
                    this.w.setText(String.format(this.B.getString(y.frs_forum_groups), Integer.valueOf(this.K.p().a())));
                } else {
                    this.w.setText(this.B.getString(y.frsgroup_title));
                }
            }
        } else {
            this.v.setVisibility(0);
            if (this.K != null && this.K.p().a() > 0) {
                this.w.setText(String.format(this.B.getString(y.frs_forum_groups), Integer.valueOf(this.K.p().a())));
            } else {
                this.w.setText(this.B.getString(y.frsgroup_title));
            }
        }
        this.N.setDefaultResource(u.pic_avatar_ba_140);
        this.N.setNightDefaultResource(u.pic_avatar_ba_140_1);
        this.N.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.a(this.J, 15, false);
        if (this.ah != null && this.ak != null && this.ak.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.ak.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.ak.get(i).b());
                iconData.setIcon(this.ak.get(i).a());
                this.aj = this.ak.get(i).c();
                linkedList.add(iconData);
            }
            this.ah.setOnClickListener(this.c);
            this.ah.a(linkedList, 2, this.B.getResources().getDimensionPixelSize(t.frs_header_badge_width), this.B.getResources().getDimensionPixelSize(t.frs_header_badge_height), this.B.getResources().getDimensionPixelSize(t.frs_header_badge_margin));
        }
        if (this.ao) {
            this.an.setVisibility(0);
            this.an.setData(this.am);
            return;
        }
        this.an.setVisibility(8);
    }

    public void a(View view) {
        if (this.x == null) {
            this.x = new PopupWindow(this.B);
            this.x.setContentView(this.y);
            this.x.setBackgroundDrawable(new BitmapDrawable());
            this.x.setOutsideTouchable(true);
            this.x.setFocusable(true);
            this.x.setWidth(this.B.getResources().getDimensionPixelSize(t.frs_header_btn_width));
            this.x.setHeight(this.B.getResources().getDimensionPixelSize(t.frs_header_exp_height));
            this.z = (TextView) this.y.findViewById(v.cur_experience);
            this.A = (TextView) this.y.findViewById(v.levelup_experience);
            k();
        }
        if (this.x.isShowing()) {
            this.x.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        k();
        if (iArr[1] - this.x.getHeight() <= 50) {
            this.x.dismiss();
            return;
        }
        this.x.showAtLocation(this.t, 0, iArr[0], iArr[1] - this.x.getHeight());
        this.x.update();
        this.M.postDelayed(this.b, 2000L);
    }

    private void k() {
        this.z.setText(String.valueOf(this.S));
        if (this.X) {
            this.A.setVisibility(8);
            return;
        }
        this.A.setVisibility(0);
        if (this.T >= 10000) {
            if (this.T % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                this.A.setText(String.valueOf(this.B.getString(y.experience_divider)) + String.valueOf(this.T / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.B.getString(y.member_count_unit));
                return;
            } else {
                this.A.setText(String.valueOf(this.B.getString(y.experience_divider)) + String.valueOf(this.T / 10000.0f) + this.B.getString(y.member_count_unit));
                return;
            }
        }
        this.A.setText(String.valueOf(this.B.getString(y.experience_divider)) + String.valueOf(this.T));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.Q = str;
        this.R = i2;
        if (i == 0) {
            this.ad = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.ad = true;
        this.g.setVisibility(8);
        if (z) {
            this.ae.a(this.g);
        }
        a(f);
        this.p.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.ad = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.ad = true;
        this.g.setVisibility(8);
        this.p.setVisibility(0);
    }

    private void c(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tbadk.core.util.g.a(u.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.q.setText(y.level_up);
                this.r.setText(String.valueOf(this.R + 1));
            } else {
                this.q.setText(this.Q);
                this.r.setText(String.valueOf(this.R));
                this.r.setBackgroundResource(com.baidu.tbadk.core.util.g.b(this.R));
            }
            float f2 = this.U * width;
            float f3 = f2 > 0.001f ? this.V / f2 : 0.0f;
            this.V = f2;
            if (this.W) {
                this.W = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams.width = (int) this.V;
            this.s.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.s.startAnimation(scaleAnimation);
        }
    }

    public void c(int i) {
        if (i == 0) {
            this.L = false;
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            if (this.ab == 1) {
                this.k.setBackgroundResource(u.frs_btn_sign_1);
                return;
            } else {
                this.k.setBackgroundResource(u.frs_btn_sign);
                return;
            }
        }
        this.L = true;
        this.j.setVisibility(8);
        if (this.ab == 1) {
            this.o.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_d_1, 0, 0, 0);
        } else {
            this.o.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_d, 0, 0, 0);
        }
        if (this.ac == 1) {
            this.o.setText(this.B.getString(y.signed));
        } else {
            this.o.setText(String.valueOf(this.B.getString(y.signed_less)) + String.valueOf(this.ac) + this.B.getString(y.day));
        }
        this.n.setVisibility(0);
    }

    public boolean b() {
        return this.L;
    }

    public void a(boolean z) {
        this.aa = z;
        if (this.aa) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.U >= 0.999f) {
            this.W = true;
        }
        this.U = f >= 1.0f ? 1.0f : f;
        this.X = f >= 1.0f;
        c(this.X);
    }

    public boolean c() {
        return this.ad;
    }

    public View d() {
        return this.p;
    }

    public ProgressBar e() {
        return this.m;
    }

    public boolean f() {
        return this.X;
    }

    public boolean b(View view) {
        return this.P.a(view);
    }

    public void g() {
        this.P.b();
    }

    public void h() {
        this.P.a();
    }

    public void i() {
        this.al = true;
    }

    public void b(boolean z) {
        this.ao = z;
    }
}
