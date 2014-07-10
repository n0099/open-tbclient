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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.data.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.WorldCupView;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.s;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.CustomTimerView;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.imageManager.d {
    private static final int[] ac = {u.label_green, u.label_blue, u.label_orange, u.label_red, u.label_purple};
    private static final int[] ad = {u.label_green_1, u.label_blue_1, u.label_orange_1, u.label_red_1, u.label_purple_1};
    private String A;
    private String B;
    private a E;
    private final TbImageView G;
    private final HeadImageView H;
    private View J;
    private TextView M;
    private TextView N;
    private CustomTimerView O;
    private TextView P;
    private String T;
    private int U;
    private int Z;
    private int aa;
    private int ab;
    private RelativeLayout ae;
    private RelativeLayout af;
    private boolean ag;
    private int ah;
    private final bq ak;
    private final ImageView al;
    private UserIconBox am;
    private boolean ap;
    private com.baidu.tbadk.core.data.p aq;
    private WorldCupView ar;
    private boolean as;
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
    private o w;
    private Activity z;
    private com.baidu.tieba.frs.g x = null;
    private boolean y = false;
    private int C = 0;
    private int D = 0;
    private t F = null;
    com.baidu.tbadk.core.data.m a = null;
    private PopupWindow I = null;
    private TextView K = null;
    private TextView L = null;
    private int Q = -1;
    private String R = null;
    private String S = null;
    private float V = 0.0f;
    private float W = 0.0f;
    private boolean X = false;
    private boolean Y = false;
    private boolean ai = false;
    private String an = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.a> ao = null;
    final Runnable b = new k(this);
    View.OnClickListener c = new l(this);
    private Handler aj = new Handler();

    public j(Activity activity, String str, String str2) {
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
        this.z = null;
        this.A = null;
        this.B = null;
        this.E = null;
        this.J = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.ae = null;
        this.af = null;
        this.am = null;
        this.z = activity;
        this.A = str;
        this.B = str2;
        LayoutInflater from = LayoutInflater.from(activity);
        this.t = from.inflate(w.frs_star_title, (ViewGroup) null);
        this.J = from.inflate(w.frs_show_experience, (ViewGroup) null);
        if (this.A == null || this.B == null) {
            this.t.setVisibility(8);
        }
        this.p = (RelativeLayout) this.t.findViewById(v.btn_love_content);
        this.q = (TextView) this.t.findViewById(v.level_name);
        this.r = (TextView) this.t.findViewById(v.level);
        this.s = (ImageView) this.t.findViewById(v.love_level_top);
        this.P = (TextView) this.t.findViewById(v.frs_tag_text);
        this.E = new a(this.t, this.z);
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
        this.ae = (RelativeLayout) this.t.findViewById(v.fan_timer_layout);
        this.af = (RelativeLayout) this.t.findViewById(v.fan_num_layout);
        this.G = (TbImageView) this.t.findViewById(v.frs_star_top_pic);
        this.H = (HeadImageView) this.t.findViewById(v.frs_star_bottom_photo);
        this.H.setGifIconSupport(false);
        this.M = (TextView) this.t.findViewById(v.add_fan);
        this.N = (TextView) this.t.findViewById(v.fan_num);
        this.O = (CustomTimerView) this.t.findViewById(v.open_timer);
        this.O.setTextColor(-11250604);
        this.O.setNumColor(-13401629);
        this.O.setTextMargin(3);
        this.O.setNumMargin(2);
        this.al = (ImageView) this.t.findViewById(v.frs_enter_detail);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.al.setVisibility(0);
        } else {
            this.al.setVisibility(8);
        }
        this.am = (UserIconBox) this.t.findViewById(v.frs_badge_box);
        this.ak = new bq(this.z);
        this.u = (FrameLayout) this.t.findViewById(v.frs_header_groups);
        this.v = (TextView) this.t.findViewById(v.frs_header_groups_text);
        this.w = new o(this.t);
        this.ar = (WorldCupView) this.t.findViewById(v.worldcup);
    }

    public void a(View.OnClickListener onClickListener) {
        this.u.setOnClickListener(onClickListener);
        this.p.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.t.setOnClickListener(new m(this));
        }
        this.E.a(onClickListener);
        this.h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.M.setOnClickListener(onClickListener);
        this.P.setOnClickListener(new n(this));
    }

    public void a(int i) {
        this.ah = i;
        ((FrsActivity) this.z).getLayoutMode().a(i == 1);
        ((FrsActivity) this.z).getLayoutMode().a(this.t);
        ((FrsActivity) this.z).getLayoutMode().a(this.J);
        if (this.ai) {
            c(1);
        } else {
            c(0);
        }
        this.r.setBackgroundResource(com.baidu.tbadk.core.util.h.b(this.U));
        this.H.invalidate();
        this.G.invalidate();
        if (i == 1) {
            if (this.Q >= 0 && this.Q < ac.length) {
                bk.e((View) this.P, ad[this.Q]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(u.icon_like_1, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_1, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.z.getResources().getColor(s.frs_like_shadow_1));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.z.getResources().getColor(s.frs_sign_shadow_1));
            this.O.setTextColor(-9798255);
            this.O.setNumColor(-13669967);
            this.u.setBackgroundResource(u.frs_top_item_bg_1);
            this.al.setImageResource(u.icon_arrow_right_1);
        } else {
            this.al.setImageResource(u.icon_arrow_right);
            if (this.Q >= 0 && this.Q < ac.length) {
                bk.e((View) this.P, ac[this.Q]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(u.icon_like, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.z.getResources().getColor(s.frs_like_shadow));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.z.getResources().getColor(s.frs_sign_shadow));
            this.O.setTextColor(-11250604);
            this.O.setNumColor(-13401629);
            this.u.setBackgroundResource(u.frs_top_item_bg);
        }
        if (this.w != null) {
            this.w.a(i);
        }
        if (this.ar != null) {
            this.ar.a(i);
        }
    }

    public View a() {
        return this.t;
    }

    public void a(ForumData forumData, com.baidu.tieba.frs.g gVar) {
        if (gVar != null) {
            this.A = forumData.getName();
            this.B = forumData.getId();
            this.C = forumData.getMember_num();
            this.D = forumData.getPost_num();
            this.R = forumData.getTag_name();
            this.S = forumData.getTag_color();
            this.Z = forumData.getSignData().getCountSignNum();
            this.aa = forumData.getCurScore();
            this.ab = forumData.getLevelupScore();
            this.x = gVar;
            this.F = gVar.l();
            this.ao = forumData.getBadgeData();
            this.a = new com.baidu.tbadk.core.data.m();
            this.aq = forumData.getWorldCupData();
            if (this.F != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.F.b());
                this.a.F().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.F.c());
                this.a.F().add(mediaData2);
            }
            this.t.setVisibility(0);
            this.E.a(forumData.getName());
            j();
        }
    }

    private void j() {
        if (this.d != null) {
            this.d.setText(String.valueOf(this.C));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.D));
        }
        if (this.f != null) {
            if (this.ao != null && this.ao.size() > 0) {
                this.A = UtilHelper.getFixedText(this.A, 7);
            }
            this.f.setText(String.valueOf(this.A) + this.z.getString(y.forum));
        }
        if (this.R != null && this.R.length() > 0) {
            if (this.P != null) {
                this.P.setText(this.R);
            }
            if (this.P != null && this.S != null && this.S.length() > 0) {
                this.Q = Integer.parseInt(this.S);
                if (this.Q >= 0 && this.Q < ac.length) {
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        bk.e((View) this.P, ad[this.Q]);
                    } else {
                        bk.e((View) this.P, ac[this.Q]);
                    }
                }
            }
            if (this.P != null) {
                this.P.setVisibility(0);
            }
        } else if (this.P != null) {
            this.P.setVisibility(8);
        }
        if (this.x != null && this.x.j() != null && this.x.j().getIfpost() == 0) {
            if (this.x.h().isEmpty()) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
                if (this.x.p().a() > 0) {
                    this.v.setText(String.format(this.z.getString(y.frs_forum_groups), Integer.valueOf(this.x.p().a())));
                } else {
                    this.v.setText(this.z.getString(y.frsgroup_title));
                }
            }
        } else {
            this.u.setVisibility(0);
            if (this.x != null && this.x.p().a() > 0) {
                this.v.setText(String.format(this.z.getString(y.frs_forum_groups), Integer.valueOf(this.x.p().a())));
            } else {
                this.v.setText(this.z.getString(y.frsgroup_title));
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.j.b(this.z);
        if (this.F.d() == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = (int) (layoutParams.width * 0.36458334f);
        }
        this.G.setLayoutParams(layoutParams);
        this.G.setDefaultResource(u.def_star_top_pic);
        this.G.setNightDefaultResource(u.def_star_top_pic);
        this.H.setDefaultResource(u.pic_avatar_ba_140);
        this.H.setNightDefaultResource(u.pic_avatar_ba_140_1);
        this.G.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.H.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.G.a(this.F.b(), 16, this.F.d(), this.F.e(), false);
        this.H.a(this.F.c(), 16, false);
        if (this.F.f() == 0) {
            this.af.setVisibility(8);
            this.M.setVisibility(8);
            if (this.F.g() <= 0) {
                this.ae.setVisibility(8);
            } else {
                this.ae.setVisibility(0);
            }
        } else {
            this.ae.setVisibility(8);
            if (this.F.h() == 0) {
                this.af.setVisibility(8);
                this.M.setVisibility(0);
            } else {
                this.M.setVisibility(8);
                this.af.setVisibility(0);
                this.N.setText(String.valueOf(this.F.i()));
            }
        }
        if (this.am != null && this.ao != null && this.ao.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.ao.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.ao.get(i).b());
                iconData.setIcon(this.ao.get(i).a());
                this.an = this.ao.get(i).c();
                linkedList.add(iconData);
            }
            this.am.setOnClickListener(this.c);
            this.am.a(linkedList, 2, this.z.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_width), this.z.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_height), this.z.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_starheader_badge_margin));
        }
        if (this.x != null) {
            this.w.a(this.x.l(), this.x.g());
        } else {
            this.w.a(null, null);
        }
        if (this.as) {
            this.aq = new com.baidu.tbadk.core.data.p();
            this.ar.setVisibility(0);
            this.ar.setData(this.aq);
            return;
        }
        this.ar.setVisibility(8);
    }

    private void c(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tbadk.core.util.h.a(u.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.q.setText(y.star_bar_level_up);
                this.r.setText(String.valueOf(this.U + 1));
            } else {
                this.q.setText(this.T);
                this.r.setText(String.valueOf(this.U));
                this.r.setBackgroundResource(com.baidu.tbadk.core.util.h.b(this.U));
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

    public void a(float f) {
        if (this.V >= 0.999f) {
            this.X = true;
        }
        this.V = f >= 1.0f ? 1.0f : f;
        this.Y = f >= 1.0f;
        c(this.Y);
    }

    public void a(View view) {
        if (this.I == null) {
            this.I = new PopupWindow(this.z);
            this.I.setContentView(this.J);
            this.I.setBackgroundDrawable(new BitmapDrawable());
            this.I.setOutsideTouchable(true);
            this.I.setFocusable(true);
            this.I.setWidth(this.z.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_btn_width));
            this.I.setHeight(this.z.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_exp_height));
            this.K = (TextView) this.J.findViewById(v.cur_experience);
            this.L = (TextView) this.J.findViewById(v.levelup_experience);
            k();
        }
        if (this.I.isShowing()) {
            this.I.dismiss();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        k();
        int height = iArr[1] - this.I.getHeight();
        if (height <= 50) {
            this.I.dismiss();
            return;
        }
        this.I.showAtLocation(this.t, 0, iArr[0], height);
        this.I.update();
        this.aj.postDelayed(this.b, 2000L);
    }

    private void k() {
        this.K.setText(String.valueOf(this.aa));
        if (this.Y) {
            this.L.setVisibility(8);
            return;
        }
        this.L.setVisibility(0);
        if (this.ab >= 10000) {
            if (this.ab % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                this.L.setText(String.valueOf(this.z.getString(y.experience_divider)) + String.valueOf(this.ab / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.z.getString(y.member_count_unit));
                return;
            } else {
                this.L.setText(String.valueOf(this.z.getString(y.experience_divider)) + String.valueOf(this.ab / 10000.0f) + this.z.getString(y.member_count_unit));
                return;
            }
        }
        this.L.setText(String.valueOf(this.z.getString(y.experience_divider)) + String.valueOf(this.ab));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.T = str;
        this.U = i2;
        if (i == 0) {
            this.y = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.y = true;
        this.g.setVisibility(8);
        if (z) {
            this.ak.a(this.g);
        }
        a(f);
        this.p.setVisibility(0);
    }

    public void b(int i) {
        if (i == 0) {
            this.y = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.y = true;
        this.g.setVisibility(8);
        this.p.setVisibility(0);
    }

    public void c(int i) {
        if (i == 0) {
            this.ai = false;
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            if (this.ah == 1) {
                this.k.setBackgroundResource(u.frs_btn_sign_1);
                return;
            } else {
                this.k.setBackgroundResource(u.frs_btn_sign);
                return;
            }
        }
        this.ai = true;
        this.j.setVisibility(8);
        if (this.ah == 1) {
            this.o.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_d_1, 0, 0, 0);
        } else {
            this.o.setCompoundDrawablesWithIntrinsicBounds(u.icon_sign_d, 0, 0, 0);
        }
        if (this.Z <= 1) {
            this.o.setText(this.z.getString(y.signed));
        } else {
            this.o.setText(String.valueOf(this.z.getString(y.signed_less)) + String.valueOf(this.Z) + this.z.getString(y.day));
        }
        this.n.setVisibility(0);
    }

    public boolean b() {
        return this.ai;
    }

    public void a(boolean z) {
        this.ag = z;
        if (this.ag) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public boolean c() {
        return this.y;
    }

    public View d() {
        return this.p;
    }

    public boolean e() {
        return this.Y;
    }

    public boolean b(View view) {
        return this.E.a(view);
    }

    public void f() {
        this.E.b();
    }

    public void g() {
        this.E.a();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.t.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar h() {
        return this.m;
    }

    public void i() {
        this.ap = true;
    }

    public void b(boolean z) {
        this.as = z;
    }
}
