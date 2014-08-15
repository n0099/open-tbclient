package com.baidu.tieba.frs.view;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.WorldCupView;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.switchs.features.BarDetailForFrsSwitchStatic;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FrsHeaderView {
    private static final int[] ab = {com.baidu.tieba.t.label_green, com.baidu.tieba.t.label_blue, com.baidu.tieba.t.label_orange, com.baidu.tieba.t.label_red, com.baidu.tieba.t.label_purple};
    private static final int[] ac = {com.baidu.tieba.t.label_green_1, com.baidu.tieba.t.label_blue_1, com.baidu.tieba.t.label_orange_1, com.baidu.tieba.t.label_red_1, com.baidu.tieba.t.label_purple_1};
    private View B;
    private Activity E;
    private String F;
    private String G;
    private Handler P;
    private BarImageView Q;
    private TextView R;
    private a S;
    private String T;
    private int U;
    private int V;
    private int W;
    private boolean ad;
    private int ae;
    private int af;
    private final br ah;
    private LayoutInflater ai;
    private ImageView aj;
    private int ak;
    private final ViewGroup al;
    private ImageView am;
    private UserIconBox an;
    private boolean aq;
    private com.baidu.tbadk.core.data.q ar;
    private WorldCupView as;
    private boolean at;
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
    private FrameLayout x;
    private TextView y;
    private w z;
    private PopupWindow A = null;
    private TextView C = null;
    private TextView D = null;
    private int H = 0;
    private int I = 0;
    private int J = -1;
    private String K = null;
    private String L = null;
    private String M = null;
    private com.baidu.tieba.frs.g N = null;
    private boolean O = false;
    com.baidu.tbadk.core.data.n a = null;
    private float X = 0.0f;
    private float Y = 0.0f;
    private boolean Z = false;
    private boolean aa = false;
    private boolean ag = false;
    private String ao = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.c> ap = null;
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

    public FrsHeaderView(Activity activity, PAGE page, String str, String str2, int i) {
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
        this.y = null;
        this.B = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.ak = 0;
        this.am = null;
        this.an = null;
        this.ak = i;
        this.P = new Handler();
        this.E = activity;
        this.F = str;
        this.G = str2;
        this.ai = LayoutInflater.from(activity);
        this.t = this.ai.inflate(com.baidu.tieba.v.frs_header, (ViewGroup) null);
        this.u = this.t.findViewById(com.baidu.tieba.u.container);
        this.B = this.ai.inflate(com.baidu.tieba.v.frs_show_experience, (ViewGroup) null);
        if (this.F == null || this.G == null) {
            this.t.setVisibility(8);
        }
        this.p = (RelativeLayout) this.t.findViewById(com.baidu.tieba.u.btn_love_content);
        this.aj = (ImageView) this.t.findViewById(com.baidu.tieba.u.speed_icon);
        this.al = (ViewGroup) this.t.findViewById(com.baidu.tieba.u.frs_forum_entry);
        this.am = (ImageView) this.t.findViewById(com.baidu.tieba.u.frs_enter_detail);
        this.al.setVisibility(8);
        this.S = new a(this.t, this.E);
        this.q = (TextView) this.t.findViewById(com.baidu.tieba.u.level_name);
        this.r = (TextView) this.t.findViewById(com.baidu.tieba.u.level);
        this.s = (ImageView) this.t.findViewById(com.baidu.tieba.u.love_level_top);
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
        this.R = (TextView) this.t.findViewById(com.baidu.tieba.u.frs_tag_text);
        this.Q = (BarImageView) this.t.findViewById(com.baidu.tieba.u.frs_image);
        this.Q.setGifIconSupport(false);
        this.an = (UserIconBox) this.t.findViewById(com.baidu.tieba.u.frs_badge_box);
        this.v = (FrameLayout) this.t.findViewById(com.baidu.tieba.u.frs_header_groups);
        this.w = (TextView) this.t.findViewById(com.baidu.tieba.u.frs_header_groups_text);
        this.x = (FrameLayout) this.t.findViewById(com.baidu.tieba.u.frs_header_games);
        this.y = (TextView) this.t.findViewById(com.baidu.tieba.u.frs_header_games_text);
        this.z = new w(this.t);
        this.ah = new br(this.E);
        this.as = (WorldCupView) this.t.findViewById(com.baidu.tieba.u.worldcup);
    }

    public boolean a() {
        int[] iArr = new int[2];
        this.aj.getLocationOnScreen(iArr);
        return iArr[0] >= 160 && iArr[1] >= 105;
    }

    public void a(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.v.setOnClickListener(onClickListener);
        if (this.x != null) {
            this.x.setOnClickListener(onClickListener);
        }
        this.p.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForFrsSwitchStatic.BAR_DETAIL_FRS) == 0) {
            this.t.setOnClickListener(new e(this));
        }
        this.S.a(onClickListener);
        this.R.setOnClickListener(new f(this));
    }

    public void a(int i) {
        this.ak = i;
    }

    public void b(int i) {
        this.ae = i;
        ((FrsActivity) this.E).getLayoutMode().a(i == 1);
        ((FrsActivity) this.E).getLayoutMode().a(this.t);
        ((FrsActivity) this.E).getLayoutMode().a(this.B);
        if (this.O) {
            d(1);
        } else {
            d(0);
        }
        this.Q.invalidate();
        this.r.setBackgroundResource(com.baidu.tbadk.core.util.d.b(this.U));
        if (i == 1) {
            this.u.setBackgroundColor(this.E.getResources().getColor(com.baidu.tieba.r.frs_header_bg_1));
            if (this.J >= 0 && this.J < ab.length) {
                ay.e((View) this.R, ac[this.J]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_like_1, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign_1, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(com.baidu.tieba.r.frs_like_shadow_1));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(com.baidu.tieba.r.frs_sign_shadow_1));
            ay.e(this.am, com.baidu.tieba.t.icon_arrow_right_1);
            this.v.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg_1);
            if (this.x != null) {
                this.x.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg_1);
            }
            if (this.ak != 0) {
                this.aj.setImageResource(com.baidu.tieba.t.icon_speed_orange_1);
            } else {
                this.aj.setImageResource(com.baidu.tieba.t.icon_speed_gray_1);
            }
        } else {
            this.u.setBackgroundColor(this.E.getResources().getColor(com.baidu.tieba.r.frs_header_bg));
            if (this.J >= 0 && this.J < ab.length) {
                ay.e((View) this.R, ab[this.J]);
            }
            this.i.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_like, 0, 0, 0);
            this.l.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign, 0, 0, 0);
            this.i.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(com.baidu.tieba.r.frs_like_shadow));
            this.l.setShadowLayer(1.0f, 0.0f, 1.0f, this.E.getResources().getColor(com.baidu.tieba.r.frs_sign_shadow));
            ay.e(this.am, com.baidu.tieba.t.icon_arrow_right);
            this.v.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg);
            if (this.x != null) {
                this.x.setBackgroundResource(com.baidu.tieba.t.frs_top_item_bg);
            }
            if (this.ak != 0) {
                this.aj.setImageResource(com.baidu.tieba.t.icon_speed_orange);
            } else {
                this.aj.setImageResource(com.baidu.tieba.t.icon_speed_gray);
            }
        }
        if (this.z != null) {
            this.z.a(i);
        }
        if (this.as != null) {
            this.as.a(i);
        }
    }

    public void b() {
        if (this.ae == 1) {
            if (this.ak != 0) {
                this.aj.setImageResource(com.baidu.tieba.t.icon_speed_orange_1);
            } else {
                this.aj.setImageResource(com.baidu.tieba.t.icon_speed_gray_1);
            }
        } else if (this.ak != 0) {
            this.aj.setImageResource(com.baidu.tieba.t.icon_speed_orange);
        } else {
            this.aj.setImageResource(com.baidu.tieba.t.icon_speed_gray);
        }
    }

    public View c() {
        return this.t;
    }

    public void a(ForumData forumData, com.baidu.tieba.frs.g gVar) {
        this.F = forumData.getName();
        this.G = forumData.getId();
        this.H = forumData.getMember_num();
        this.I = forumData.getPost_num();
        this.K = forumData.getTag_name();
        this.L = forumData.getTag_color();
        this.M = forumData.getImage_url();
        this.T = forumData.getLevelName();
        this.U = forumData.getUser_level();
        this.af = forumData.getSignData().getCountSignNum();
        this.V = forumData.getCurScore();
        this.W = forumData.getLevelupScore();
        this.ap = forumData.getBadgeData();
        this.ar = forumData.getWorldCupData();
        this.N = gVar;
        this.t.setVisibility(0);
        this.a = new com.baidu.tbadk.core.data.n();
        MediaData mediaData = new MediaData();
        mediaData.setType(3);
        mediaData.setPic(this.M);
        this.a.x().add(mediaData);
        this.S.a(forumData.getName());
        m();
    }

    private void m() {
        if (this.d != null) {
            this.d.setText(String.valueOf(this.H));
        }
        if (this.e != null) {
            this.e.setText(String.valueOf(this.I));
        }
        if (this.f != null) {
            if (this.ap != null && this.ap.size() > 0) {
                this.F = UtilHelper.getFixedText(this.F, 7);
            }
            this.f.setText(String.valueOf(this.F) + this.E.getString(com.baidu.tieba.x.forum));
        }
        if (this.K != null && this.K.length() > 0) {
            if (this.R != null) {
                this.R.setText(this.K);
            }
            if (this.R != null && this.L != null && this.L.length() > 0) {
                this.J = Integer.parseInt(this.L);
                if (this.J >= 0 && this.J < ab.length) {
                    if (TbadkApplication.m252getInst().getSkinType() == 1) {
                        ay.e((View) this.R, ac[this.J]);
                    } else {
                        ay.e((View) this.R, ab[this.J]);
                    }
                }
            }
            if (this.R != null) {
                this.R.setVisibility(0);
            }
        } else if (this.R != null) {
            this.R.setVisibility(8);
        }
        if (this.N != null && this.N.l() != null && this.N.l().getIfpost() == 0) {
            if (this.N.j().isEmpty()) {
                this.v.setVisibility(8);
            } else {
                this.v.setVisibility(0);
                if (this.N.r().a() > 0) {
                    this.w.setText(String.format(this.E.getString(com.baidu.tieba.x.frs_forum_groups), Integer.valueOf(this.N.r().a())));
                } else {
                    this.w.setText(this.E.getString(com.baidu.tieba.x.frsgroup_title));
                }
            }
        } else {
            this.v.setVisibility(0);
            if (this.N != null && this.N.r().a() > 0) {
                this.w.setText(String.format(this.E.getString(com.baidu.tieba.x.frs_forum_groups), Integer.valueOf(this.N.r().a())));
            } else {
                this.w.setText(this.E.getString(com.baidu.tieba.x.frsgroup_title));
            }
        }
        if (this.x != null && this.y != null) {
            if (this.N != null && this.N.a()) {
                this.x.setVisibility(0);
                this.y.setText(com.baidu.tieba.x.frsgame_title);
            } else {
                this.x.setVisibility(8);
            }
        }
        if (this.N != null) {
            this.z.a(this.N.n(), this.N.i());
        } else {
            this.z.a(null, null);
        }
        this.Q.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Q.a(this.M, 15, false);
        if (this.an != null && this.ap != null && this.ap.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.ap.size(); i++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.ap.get(i).b());
                iconData.setIcon(this.ap.get(i).a());
                this.ao = this.ap.get(i).c();
                linkedList.add(iconData);
            }
            this.an.setOnClickListener(this.c);
            this.an.a(linkedList, 2, this.E.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_badge_width), this.E.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_badge_height), this.E.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_badge_margin));
        }
        if (this.at) {
            this.as.setVisibility(0);
            this.as.setData(this.ar);
            return;
        }
        this.as.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public void a(View view, boolean z) {
        if (this.ak != 0) {
            if (this.A == null) {
                this.A = new PopupWindow(this.E);
                this.A.setContentView(this.B);
                this.A.setBackgroundDrawable(new BitmapDrawable());
                this.A.setOutsideTouchable(true);
                this.A.setFocusable(true);
                this.A.setWidth(this.E.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_btn_width));
                this.A.setHeight(this.E.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_exp_height));
                this.C = (TextView) this.B.findViewById(com.baidu.tieba.u.cur_experience);
                this.D = (TextView) this.B.findViewById(com.baidu.tieba.u.levelup_experience);
                a(this.C, this.D);
            }
            if (this.A.isShowing()) {
                com.baidu.adp.lib.e.d.a(this.A, this.E);
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.C, this.D);
            if (iArr[1] - this.A.getHeight() <= 50) {
                com.baidu.adp.lib.e.d.a(this.A, this.E);
                return;
            }
            com.baidu.adp.lib.e.d.a(this.A, this.t, 0, iArr[0], iArr[1] - this.A.getHeight());
            this.A.update();
            this.P.postDelayed(this.b, 2000L);
        } else if (!z) {
            View inflate = this.ai.inflate(com.baidu.tieba.v.no_mem_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.u.experience);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.u.cur_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.u.levelup_experience_mem);
            TextView textView4 = (TextView) inflate.findViewById(com.baidu.tieba.u.speed_tip);
            if (1 == this.ae) {
                textView.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                textView2.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                textView3.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
                textView4.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
            } else {
                textView.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                textView2.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                textView3.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
                textView4.setTextColor(this.E.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.E);
            aVar.a(inflate);
            a(textView2, textView3);
            aVar.b(com.baidu.tieba.x.cancel_text, new g(this));
            aVar.a(com.baidu.tieba.x.open_now, new h(this));
            aVar.a().b();
        }
    }

    private void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.V));
        if (this.aa) {
            textView2.setVisibility(8);
            return;
        }
        textView2.setVisibility(0);
        if (this.W >= 10000) {
            if (this.W % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                textView2.setText(String.valueOf(this.E.getString(com.baidu.tieba.x.experience_divider)) + String.valueOf(this.W / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.E.getString(com.baidu.tieba.x.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.E.getString(com.baidu.tieba.x.experience_divider)) + String.valueOf(this.W / 10000.0f) + this.E.getString(com.baidu.tieba.x.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.E.getString(com.baidu.tieba.x.experience_divider)) + String.valueOf(this.W));
    }

    public void d() {
        PopupWindow popupWindow = new PopupWindow(this.E);
        View inflate = this.ai.inflate(com.baidu.tieba.v.speed_tip, (ViewGroup) null);
        if (this.E instanceof BaseActivity) {
            ((BaseActivity) this.E).getLayoutMode().a(inflate);
        }
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new i(this, popupWindow));
        popupWindow.setWidth(this.E.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds284));
        popupWindow.setHeight(this.E.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        int[] iArr = new int[2];
        this.aj.getLocationOnScreen(iArr);
        com.baidu.adp.lib.e.d.a(popupWindow, this.t, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aj.getWidth() / 2), iArr[1] + this.aj.getWidth());
        popupWindow.update();
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.T = str;
        this.U = i2;
        if (i == 0) {
            this.ag = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.ag = true;
        this.g.setVisibility(8);
        if (z) {
            this.ah.a(this.g);
        }
        a(f);
        this.p.setVisibility(0);
    }

    public void c(int i) {
        if (i == 0) {
            this.ag = false;
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.ag = true;
        this.g.setVisibility(8);
        this.p.setVisibility(0);
    }

    private void c(boolean z) {
        int width;
        float f = 0.0f;
        Bitmap a = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.bg_frs_signin_bar_down);
        if (a != null && (width = a.getWidth()) > 0) {
            if (z) {
                this.q.setText(com.baidu.tieba.x.level_up);
                this.r.setText(String.valueOf(this.U + 1));
            } else {
                this.q.setText(this.T);
                this.r.setText(String.valueOf(this.U));
                this.r.setBackgroundResource(com.baidu.tbadk.core.util.d.b(this.U));
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

    public void d(int i) {
        if (i == 0) {
            this.O = false;
            this.n.setVisibility(8);
            this.j.setVisibility(0);
            if (this.ae == 1) {
                this.k.setBackgroundResource(com.baidu.tieba.t.frs_btn_sign_1);
                return;
            } else {
                this.k.setBackgroundResource(com.baidu.tieba.t.frs_btn_sign);
                return;
            }
        }
        this.O = true;
        this.j.setVisibility(8);
        if (this.ae == 1) {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign_d_1, 0, 0, 0);
        } else {
            this.o.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_sign_d, 0, 0, 0);
        }
        if (this.af <= 1) {
            this.o.setText(this.E.getString(com.baidu.tieba.x.signed));
        } else {
            this.o.setText(String.valueOf(this.E.getString(com.baidu.tieba.x.signed_less)) + String.valueOf(this.af) + this.E.getString(com.baidu.tieba.x.day));
        }
        this.n.setVisibility(0);
    }

    public boolean e() {
        return this.O;
    }

    public void a(boolean z) {
        this.ad = z;
        if (this.ad) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
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

    public boolean f() {
        return this.ag;
    }

    public View g() {
        return this.p;
    }

    public ProgressBar h() {
        return this.m;
    }

    public boolean i() {
        return this.aa;
    }

    public boolean a(View view) {
        return this.S.a(view);
    }

    public void j() {
        this.S.b();
    }

    public void k() {
        this.S.a();
    }

    public void l() {
        this.aq = true;
    }

    public void b(boolean z) {
        this.at = z;
    }
}
