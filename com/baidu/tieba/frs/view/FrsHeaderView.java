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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.WorldCupView;
import com.baidu.tieba.frs.bq;
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
    private static final int[] Z = {u.label_green, u.label_blue, u.label_orange, u.label_red, u.label_purple};
    private static final int[] aa = {u.label_green_1, u.label_blue_1, u.label_orange_1, u.label_red_1, u.label_purple_1};
    private Activity C;
    private String D;
    private String E;
    private Handler N;
    private HeadImageView O;
    private TextView P;
    private a Q;
    private String R;
    private int S;
    private int T;
    private int U;
    private boolean ab;
    private int ac;
    private int ad;
    private final bq af;
    private final ViewGroup ag;
    private ImageView ah;
    private UserIconBox ai;
    private boolean al;
    private com.baidu.tbadk.core.data.p am;
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
    private o x;
    private View z;
    private PopupWindow y = null;
    private TextView A = null;
    private TextView B = null;
    private int F = 0;
    private int G = 0;
    private int H = -1;
    private String I = null;
    private String J = null;
    private String K = null;
    private com.baidu.tieba.frs.g L = null;
    private boolean M = false;
    com.baidu.tbadk.core.data.m a = null;
    private float V = 0.0f;
    private float W = 0.0f;
    private boolean X = false;
    private boolean Y = false;
    private boolean ae = false;
    private String aj = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/133_1";
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
        this.z = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.ah = null;
        this.ai = null;
        this.N = new Handler();
        this.C = activity;
        this.D = str;
        this.E = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.t = from.inflate(w.frs_header, (ViewGroup) null);
        this.u = this.t.findViewById(v.container);
        this.z = from.inflate(w.frs_show_experience, (ViewGroup) null);
        if (this.D == null || this.E == null) {
            this.t.setVisibility(8);
        }
        this.p = (RelativeLayout) this.t.findViewById(v.btn_love_content);
        this.ag = (ViewGroup) this.t.findViewById(v.frs_forum_entry);
        this.ah = (ImageView) this.t.findViewById(v.frs_enter_detail);
        this.ag.setVisibility(8);
        this.Q = new a(this.t, this.C);
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
        this.P = (TextView) this.t.findViewById(v.frs_tag_text);
        this.O = (HeadImageView) this.t.findViewById(v.frs_image);
        this.O.setGifIconSupport(false);
        this.ai = (UserIconBox) this.t.findViewById(v.frs_badge_box);
        this.v = (FrameLayout) this.t.findViewById(v.frs_header_groups);
        this.w = (TextView) this.t.findViewById(v.frs_header_groups_text);
        this.x = new o(this.t);
        this.af = new bq(this.C);
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
        this.Q.a(onClickListener);
        this.P.setOnClickListener(new f(this));
    }

    public void a(int i) {
        this.ac = i;
        ((FrsActivity) this.C).getLayoutMode().a(i == 1);
        ((FrsActivity) this.C).getLayoutMode().a(this.t);
        ((FrsActivity) this.C).getLayoutMode().a(this.z);
        if (this.M) {
            c(1);
        } else {
            c(0);
        }
        this.O.invalidate();
        this.r.setBackgroundResource(com.baidu.tbadk.core.util.h.b(this.S));
        if (i == 1) {
            this.u.setBackgroundColor(this.C.getResources().getColor(s.frs_header_bg_1));
            if (this.H >= 0 && this.H < Z.length) {
                bk.e((View) this.P, aa[this.H]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(u.icon_like_1, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_1, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.C.getResources().getColor(s.frs_like_shadow_1));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.C.getResources().getColor(s.frs_sign_shadow_1));
            bk.e(this.ah, u.icon_arrow_right_1);
            this.v.setBackgroundResource(u.frs_top_item_bg_1);
        } else {
            this.u.setBackgroundColor(this.C.getResources().getColor(s.frs_header_bg));
            if (this.H >= 0 && this.H < Z.length) {
                bk.e((View) this.P, Z[this.H]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(u.icon_like, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.C.getResources().getColor(s.frs_like_shadow));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.C.getResources().getColor(s.frs_sign_shadow));
            bk.e(this.ah, u.icon_arrow_right);
            this.v.setBackgroundResource(u.frs_top_item_bg);
        }
        if (this.x != null) {
            this.x.a(i);
        }
        if (this.an != null) {
            this.an.a(i);
        }
    }

    public View a() {
        return this.t;
    }

    public void a(ForumData forumData, com.baidu.tieba.frs.g gVar) {
        this.D = forumData.getName();
        this.E = forumData.getId();
        this.F = forumData.getMember_num();
        this.G = forumData.getPost_num();
        this.I = forumData.getTag_name();
        this.J = forumData.getTag_color();
        this.K = forumData.getImage_url();
        this.R = forumData.getLevelName();
        this.S = forumData.getUser_level();
        this.ad = forumData.getSignData().getCountSignNum();
        this.T = forumData.getCurScore();
        this.U = forumData.getLevelupScore();
        this.ak = forumData.getBadgeData();
        this.am = forumData.getWorldCupData();
        this.L = gVar;
        this.t.setVisibility(0);
        this.a = new com.baidu.tbadk.core.data.m();
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.K);
        this.a.F().add(mediaData);
        this.Q.a(forumData.getName());
        j();
    }

    private void j() {
        if (this.d != null) {
            this.d.setText(String.valueOf(this.F));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.G));
        }
        if (this.f != null) {
            if (this.ak != null && this.ak.size() > 0) {
                this.D = UtilHelper.getFixedText(this.D, 7);
            }
            this.f.setText(String.valueOf(this.D) + this.C.getString(y.forum));
        }
        if (this.I != null && this.I.length() > 0) {
            if (this.P != null) {
                this.P.setText(this.I);
            }
            if (this.P != null && this.J != null && this.J.length() > 0) {
                this.H = Integer.parseInt(this.J);
                if (this.H >= 0 && this.H < Z.length) {
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        bk.e((View) this.P, aa[this.H]);
                    } else {
                        bk.e((View) this.P, Z[this.H]);
                    }
                }
            }
            if (this.P != null) {
                this.P.setVisibility(0);
            }
        } else if (this.P != null) {
            this.P.setVisibility(8);
        }
        if (this.L != null && this.L.j() != null && this.L.j().getIfpost() == 0) {
            if (this.L.h().isEmpty()) {
                this.v.setVisibility(8);
            } else {
                this.v.setVisibility(0);
                if (this.L.p().a() > 0) {
                    this.w.setText(String.format(this.C.getString(y.frs_forum_groups), Integer.valueOf(this.L.p().a())));
                } else {
                    this.w.setText(this.C.getString(y.frsgroup_title));
                }
            }
        } else {
            this.v.setVisibility(0);
            if (this.L != null && this.L.p().a() > 0) {
                this.w.setText(String.format(this.C.getString(y.frs_forum_groups), Integer.valueOf(this.L.p().a())));
            } else {
                this.w.setText(this.C.getString(y.frsgroup_title));
            }
        }
        if (this.L != null) {
            this.x.a(this.L.l(), this.L.g());
        } else {
            this.x.a(null, null);
        }
        this.O.setDefaultResource(u.pic_avatar_ba_140);
        this.O.setNightDefaultResource(u.pic_avatar_ba_140_1);
        this.O.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.O.a(this.K, 15, false);
        if (this.ai != null && this.ak != null && this.ak.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.ak.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.ak.get(i).b());
                iconData.setIcon(this.ak.get(i).a());
                this.aj = this.ak.get(i).c();
                linkedList.add(iconData);
            }
            this.ai.setOnClickListener(this.c);
            this.ai.a(linkedList, 2, this.C.getResources().getDimensionPixelSize(t.frs_header_badge_width), this.C.getResources().getDimensionPixelSize(t.frs_header_badge_height), this.C.getResources().getDimensionPixelSize(t.frs_header_badge_margin));
        }
        if (this.ao) {
            this.an.setVisibility(0);
            this.an.setData(this.am);
            return;
        }
        this.an.setVisibility(8);
    }

    public void a(View view) {
        if (this.y == null) {
            this.y = new PopupWindow(this.C);
            this.y.setContentView(this.z);
            this.y.setBackgroundDrawable(new BitmapDrawable());
            this.y.setOutsideTouchable(true);
            this.y.setFocusable(true);
            this.y.setWidth(this.C.getResources().getDimensionPixelSize(t.frs_header_btn_width));
            this.y.setHeight(this.C.getResources().getDimensionPixelSize(t.frs_header_exp_height));
            this.A = (TextView) this.z.findViewById(v.cur_experience);
            this.B = (TextView) this.z.findViewById(v.levelup_experience);
            k();
        }
        if (this.y.isShowing()) {
            this.y.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        k();
        if (iArr[1] - this.y.getHeight() <= 50) {
            this.y.dismiss();
            return;
        }
        this.y.showAtLocation(this.t, 0, iArr[0], iArr[1] - this.y.getHeight());
        this.y.update();
        this.N.postDelayed(this.b, 2000L);
    }

    private void k() {
        this.A.setText(String.valueOf(this.T));
        if (this.Y) {
            this.B.setVisibility(8);
            return;
        }
        this.B.setVisibility(0);
        if (this.U >= 10000) {
            if (this.U % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                this.B.setText(String.valueOf(this.C.getString(y.experience_divider)) + String.valueOf(this.U / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.C.getString(y.member_count_unit));
                return;
            } else {
                this.B.setText(String.valueOf(this.C.getString(y.experience_divider)) + String.valueOf(this.U / 10000.0f) + this.C.getString(y.member_count_unit));
                return;
            }
        }
        this.B.setText(String.valueOf(this.C.getString(y.experience_divider)) + String.valueOf(this.U));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
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

    public void b(int i) {
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

    private void c(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tbadk.core.util.h.a(u.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.q.setText(y.level_up);
                this.r.setText(String.valueOf(this.S + 1));
            } else {
                this.q.setText(this.R);
                this.r.setText(String.valueOf(this.S));
                this.r.setBackgroundResource(com.baidu.tbadk.core.util.h.b(this.S));
            }
            float f2 = this.V * width;
            float f3 = f2 > 0.001f ? this.W / f2 : 0.0f;
            this.W = f2;
            if (this.X) {
                this.X = false;
            } else {
                f = f3;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams.width = (int) this.W;
            this.s.setLayoutParams(layoutParams);
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(1000L);
            this.s.startAnimation(scaleAnimation);
        }
    }

    public void c(int i) {
        if (i == 0) {
            this.M = false;
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            if (this.ac == 1) {
                this.k.setBackgroundResource(u.frs_btn_sign_1);
                return;
            } else {
                this.k.setBackgroundResource(u.frs_btn_sign);
                return;
            }
        }
        this.M = true;
        this.j.setVisibility(8);
        if (this.ac == 1) {
            this.o.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_d_1, 0, 0, 0);
        } else {
            this.o.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_d, 0, 0, 0);
        }
        if (this.ad <= 1) {
            this.o.setText(this.C.getString(y.signed));
        } else {
            this.o.setText(String.valueOf(this.C.getString(y.signed_less)) + String.valueOf(this.ad) + this.C.getString(y.day));
        }
        this.n.setVisibility(0);
    }

    public boolean b() {
        return this.M;
    }

    public void a(boolean z) {
        this.ab = z;
        if (this.ab) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public void a(float f) {
        if (this.V >= 0.999f) {
            this.X = true;
        }
        this.V = f >= 1.0f ? 1.0f : f;
        this.Y = f >= 1.0f;
        c(this.Y);
    }

    public boolean c() {
        return this.ae;
    }

    public View d() {
        return this.p;
    }

    public ProgressBar e() {
        return this.m;
    }

    public boolean f() {
        return this.Y;
    }

    public boolean b(View view) {
        return this.Q.a(view);
    }

    public void g() {
        this.Q.b();
    }

    public void h() {
        this.Q.a();
    }

    public void i() {
        this.al = true;
    }

    public void b(boolean z) {
        this.ao = z;
    }
}
