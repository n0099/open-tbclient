package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.util.cd;
import com.baidu.tieba.view.FrsHeaderView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class br {
    private View.OnClickListener F;
    private int I;
    private int J;
    private int K;
    private NoNetworkView N;
    private NavigationBar O;
    private com.baidu.tieba.f d;
    private boolean c = false;
    private RelativeLayout e = null;
    private FrameLayout f = null;
    private ImageView g = null;
    private TextView h = null;
    private ImageView i = null;
    private Button j = null;
    private FrameLayout k = null;
    private ImageView l = null;
    private ImageView m = null;
    private BdListView n = null;
    private ak o = null;
    private TextView p = null;
    private LinearLayout q = null;
    private TextView r = null;
    private AlertDialog s = null;
    private FrsHeaderView t = null;
    private com.baidu.tieba.view.ar u = null;
    private com.baidu.tieba.view.an v = null;
    private at w = null;
    private TextView x = null;
    private View y = null;
    private int z = 0;
    private ct A = null;
    private bz B = null;
    private com.baidu.tieba.view.bn C = null;
    private SlidingMenu D = null;
    private String E = null;
    AlertDialog a = null;
    Animation b = null;
    private DialogInterface.OnClickListener G = null;
    private com.baidu.tieba.view.by H = null;
    private boolean L = false;
    private com.baidu.tieba.view.ae M = null;
    private View.OnTouchListener P = new bs(this);

    public br(com.baidu.tieba.f fVar, View.OnClickListener onClickListener) {
        this.d = null;
        this.F = null;
        this.d = fVar;
        this.F = onClickListener;
        L();
    }

    private void L() {
        this.d.setContentView(R.layout.frs_activity);
        this.B = new bz(this.d);
        this.B.a(R.id.show_all);
        this.e = (RelativeLayout) this.d.findViewById(R.id.frs);
        this.M = new com.baidu.tieba.view.ae(this.d);
        this.M.setLayoutParams(new AbsListView.LayoutParams(-1, this.d.getResources().getDimensionPixelSize(R.dimen.frs_header_banner_height)));
        this.M.setVisibility(8);
        this.M.setBannerCloseListener(new bt(this));
        this.D = new SlidingMenu(this.d);
        this.D.setMode(1);
        this.D.setTouchModeAbove(1);
        this.D.setBehindOffset(BdUtilHelper.a((Context) this.d, 48.0f));
        this.D.setBehindScrollScale(0.5f);
        this.D.setFadeDegree(0.35f);
        this.D.attachToActivity(this.d, 1);
        this.D.setMenu(this.B.a());
        this.O = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.h = this.O.a("");
        this.g = this.O.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.F);
        this.i = this.O.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.EDIT_BUTTON, this.F);
        View a = this.O.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_frs_more, (View.OnClickListener) null);
        this.y = a.findViewById(R.id.frs_top_more);
        this.y.setOnClickListener(this.F);
        this.x = (TextView) a.findViewById(R.id.frs_more_mes_text);
        this.k = (FrameLayout) this.d.findViewById(R.id.refresh_layout);
        this.l = (ImageView) this.d.findViewById(R.id.refresh_bg);
        this.m = (ImageView) this.d.findViewById(R.id.refresh_icon);
        String[] strArr = {this.d.getString(R.string.take_photo), this.d.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getString(R.string.operation));
        builder.setItems(strArr, new bu(this));
        if (this.s == null) {
            this.s = builder.create();
            this.s.setCanceledOnTouchOutside(true);
        }
        this.n = (BdListView) this.d.findViewById(R.id.frs_lv_thread);
        this.A = new ct(this.d);
        this.n.setPullRefresh(this.A);
        this.n.setDivider(null);
        this.n.setDividerHeight(0);
        this.n.setRecyclerListener(new bv(this));
        this.t = new FrsHeaderView(this.d, FrsHeaderView.PAGE.FRS_LIST, null, null);
        this.u = new com.baidu.tieba.view.ar(this.d, null, null);
        this.v = new com.baidu.tieba.view.an(this.d);
        this.o = new ak(this.d, null, BdUtilHelper.b(this.d), com.baidu.tieba.util.bv.a().b());
        this.b = AnimationUtils.loadAnimation(this.d, R.anim.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.p = (TextView) this.d.findViewById(R.id.frs_noexist);
        this.p.setVisibility(8);
        this.r = (TextView) this.d.findViewById(R.id.frs_noexist_text);
        this.q = (LinearLayout) this.d.findViewById(R.id.frs_noexist_layout);
        this.j = (Button) this.d.findViewById(R.id.frs_bt_create);
        this.B.a(this.F);
        this.k.setOnClickListener(this.F);
        this.t.a(this.F);
        this.u.a(this.F);
        this.h.setOnClickListener(this.F);
        this.j.setOnClickListener(this.F);
        this.k.setOnTouchListener(this.P);
        this.N = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView a() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d() {
        return this.y;
    }

    public boolean e() {
        if ("normal_page".equals(this.E)) {
            return this.t.h();
        }
        if ("frs_page".equals(this.E)) {
            return this.u.g();
        }
        return false;
    }

    public void a(com.baidu.tieba.view.by byVar) {
        this.H = byVar;
        if (this.N != null) {
            this.N.a(this.H);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.D.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.D.setOnOpenedListener(onOpenedListener);
    }

    public bz f() {
        return this.B;
    }

    public SlidingMenu g() {
        return this.D;
    }

    public void a(boolean z) {
        this.D.showMenu(z);
    }

    public void h() {
        this.N.setVisibility(0);
    }

    public void i() {
        this.N.setVisibility(8);
    }

    public NoNetworkView j() {
        return this.N;
    }

    public void a(com.baidu.tieba.data.az azVar, boolean z) {
        String string = this.d.getString(R.string.view);
        String string2 = this.d.getString(R.string.view_host);
        String string3 = this.d.getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.G);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.G);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.A.a(bVar);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.n.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.n.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.t tVar) {
        this.n.setOnSrollToTopListener(tVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.n.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.n.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.G = onClickListener;
    }

    public void k() {
        if (this.a != null) {
            this.a.show();
        }
    }

    public void a(String str) {
        this.d.showToast(str);
    }

    public void l() {
        if (this.M != null) {
            this.M.a();
        }
    }

    public void b(boolean z) {
        this.c = z;
        if (z) {
            if (this.b != null) {
                this.k.setOnTouchListener(null);
                this.m.startAnimation(this.b);
                if (this.z == 1) {
                    this.l.setImageResource(R.drawable.pic_fresh_s_1);
                    return;
                } else {
                    this.l.setImageResource(R.drawable.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.k.setOnTouchListener(this.P);
        this.n.a();
        this.m.clearAnimation();
        if (this.z == 1) {
            this.l.setImageResource(R.drawable.pic_fresh_n_1);
        } else {
            this.l.setImageResource(R.drawable.pic_fresh_n);
        }
    }

    public boolean m() {
        return this.c;
    }

    public ak n() {
        return this.o;
    }

    public FrsHeaderView o() {
        return this.t;
    }

    public com.baidu.tieba.view.ar p() {
        return this.u;
    }

    public void b(String str) {
        this.p.setText(R.string.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.d.getString(R.string.frs_remind_noforum));
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, str.length(), 33);
        this.q.setVisibility(0);
        this.r.setText(spannableString);
        this.h.setText(R.string.frs_create_forum);
        this.n.setVisibility(8);
        this.i.setVisibility(4);
        this.i.setClickable(false);
        this.k.setVisibility(4);
        this.y.setVisibility(8);
        this.x.setVisibility(8);
        this.D.setTouchModeAbove(2);
    }

    public void q() {
        this.n.setVisibility(0);
    }

    public void c(String str) {
        this.h.setText(String.valueOf(str) + this.d.getString(R.string.forum));
    }

    public void r() {
        if (this.o != null) {
            this.o.notifyDataSetChanged();
        }
    }

    public void s() {
        M();
        this.E = "normal_page";
        this.n.addHeaderView(this.t.c());
    }

    public void t() {
        M();
        this.E = "frs_page";
        this.n.addHeaderView(this.u.c());
    }

    public void u() {
        if (!"good_page".equals(this.E)) {
            M();
            this.E = "good_page";
            this.n.addHeaderView(this.v.a());
        }
    }

    private void M() {
        if ("normal_page".equals(this.E)) {
            this.n.removeHeaderView(this.t.c());
        } else if ("frs_page".equals(this.E)) {
            this.n.removeHeaderView(this.u.c());
        } else if ("good_page".equals(this.E)) {
            this.n.removeHeaderView(this.v.a());
        }
    }

    public void v() {
        if (this.t != null) {
            this.t.g().setVisibility(0);
        }
    }

    public void w() {
        if (this.t != null) {
            this.t.g().setVisibility(8);
        }
    }

    public void x() {
        if (this.u != null) {
            this.u.j().setVisibility(0);
        }
    }

    public void y() {
        if (this.u != null) {
            this.u.j().setVisibility(8);
        }
    }

    public boolean z() {
        if ("normal_page".equals(this.E)) {
            return this.t.d();
        }
        if ("frs_page".equals(this.E)) {
            return this.u.d();
        }
        return false;
    }

    public boolean A() {
        if ("normal_page".equals(this.E)) {
            return this.t.e();
        }
        if ("frs_page".equals(this.E)) {
            return this.u.e();
        }
        return false;
    }

    public void B() {
        this.n.setAdapter((ListAdapter) this.o);
    }

    public void c(boolean z) {
        this.o.b(z);
    }

    public void d(boolean z) {
        this.o.c(z);
    }

    public void C() {
        this.s.show();
    }

    public void a(ArrayList<com.baidu.tieba.data.az> arrayList, int i, com.baidu.tieba.model.z zVar) {
        this.o.a(arrayList);
        if (arrayList == null || arrayList.size() <= 0) {
            this.p.setText(R.string.frs_nodata);
            this.p.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
    }

    public View d(String str) {
        return this.n.findViewWithTag(str);
    }

    public View a(int i) {
        return this.n.findViewById(i);
    }

    public BdListView D() {
        return this.n;
    }

    public void b(int i) {
        if (i > 1) {
            this.o.d(true);
        } else {
            this.o.d(false);
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.o.e(true);
        } else {
            this.o.e(false);
        }
    }

    public void E() {
        this.o.b(false);
        this.o.c(false);
        this.o.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.n.setSelection(i);
    }

    public void a(ForumData forumData, com.baidu.tieba.model.z zVar) {
        if (this.u != null) {
            this.u.a(forumData, zVar);
        }
        this.u.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.u.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.u.a(false);
        }
    }

    public void a(int i, int i2, ForumData forumData, com.baidu.tieba.model.z zVar) {
        this.u.a(forumData, zVar);
        this.u.c(i);
        if (this.K >= 0 && i2 > 0 && this.u.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.u.a(forumData, zVar);
            this.u.a(k(i2));
            this.u.a(this.u.f());
        }
    }

    public void e(int i) {
        this.u.c(i);
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.model.z zVar, boolean z) {
        if (this.u != null) {
            this.u.a(forumData, zVar);
        }
        this.u.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
        if (forumData.getSignData().getForumRank() == -2) {
            this.u.a(false);
        }
    }

    public void a(ForumData forumData) {
        if (N() && forumData.getFrsBannerData() != null && !this.L && !TextUtils.isEmpty(forumData.getFrsBannerData().b())) {
            this.M.setData(forumData.getFrsBannerData());
            this.n.addHeaderView(this.M);
            this.L = true;
        }
    }

    public void F() {
        if (this.L) {
            this.n.removeHeaderView(this.M);
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.model.z zVar) {
        if (this.t != null) {
            this.t.a(forumData, zVar);
        }
        this.t.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.t.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.t.a(false);
        }
    }

    public void f(int i) {
        this.t.c(i);
    }

    public void b(int i, int i2, ForumData forumData, com.baidu.tieba.model.z zVar) {
        this.t.a(forumData, zVar);
        this.t.c(i);
        if (this.K >= 0 && i2 > 0 && this.t.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.t.a(forumData, zVar);
            this.t.a(k(i2));
            this.t.a(this.t.f());
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.model.z zVar, boolean z) {
        if (this.t != null) {
            this.t.a(forumData, zVar);
        }
        if (forumData != null) {
            this.t.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.t.a(false);
            }
        }
    }

    public void g(int i) {
        if (this.t != null) {
            this.t.b(i);
        }
    }

    public void h(int i) {
        if (this.u != null) {
            this.u.b(i);
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.I = forumData.getLevelupScore();
        this.J = forumData.getCurScore();
        this.K = this.I - this.J;
        if (this.I > 0) {
            return this.J / this.I;
        }
        return 0.0f;
    }

    private float k(int i) {
        if (this.K < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.K) {
            return 1.0f;
        }
        return (this.J + i) / this.I;
    }

    public void a(View view) {
        if (this.t != null) {
            this.t.a(view);
        }
    }

    public void b(View view) {
        if (this.u != null) {
            this.u.a(view);
        }
    }

    public void G() {
        if (this.C != null) {
            this.C.dismiss();
        }
        n().a().d();
        p().a().d();
    }

    public void H() {
        if (this.N != null && this.H != null) {
            this.N.b(this.H);
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.z> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        u();
        if (this.w == null) {
            this.w = new at(this.d, arrayList);
            this.v.a(this.w);
            this.v.a(onItemClickListener);
            this.B.a(R.id.show_good);
            return;
        }
        this.w.a(arrayList);
        this.w.notifyDataSetChanged();
        this.B.a(R.id.show_good);
    }

    public void i(int i) {
        if (this.w != null) {
            this.w.a(i);
        }
    }

    public void a(com.baidu.tieba.model.ae aeVar) {
        this.B.a(aeVar);
        long a = aeVar.a() + aeVar.b();
        boolean z = TiebaApplication.g().al() == 1;
        if (a > 0 && this.y.getVisibility() == 0) {
            this.x.setVisibility(0);
            if (a < 10) {
                this.x.setText(String.valueOf(a));
                this.x.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.x.setText(String.valueOf(a));
                this.x.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
                return;
            } else {
                this.x.setText("   ");
                this.x.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                return;
            }
        }
        this.x.setVisibility(8);
    }

    public void j(int i) {
        this.z = i;
        this.u.a(i);
        if (this.A != null) {
            this.A.a(i);
        }
        if (this.o != null) {
            this.o.e();
            this.o.notifyDataSetChanged();
        }
        if (this.w != null) {
            this.w.notifyDataSetChanged();
        }
        this.v.a(i);
        this.B.b(i);
        this.t.a(i);
        if (this.d instanceof FrsActivity) {
            ((FrsActivity) this.d).f();
        }
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a((View) this.e);
        this.O.c(i);
        if (this.N != null) {
            this.N.a(i);
        }
    }

    public void I() {
        this.e.removeView(this.f);
        this.f = null;
    }

    public void e(boolean z) {
        if (z) {
            this.l.setAlpha(128);
            this.m.setAlpha(128);
            return;
        }
        this.l.setAlpha(MotionEventCompat.ACTION_MASK);
        this.m.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void J() {
        this.n.b();
    }

    public int K() {
        return R.id.user_icon_box;
    }

    private boolean N() {
        long ba = TiebaApplication.g().ba();
        if (ba == 0) {
            return true;
        }
        try {
            return cd.a(cd.a(), new Date(ba)) >= 72;
        } catch (Exception e) {
            return true;
        }
    }

    public void f(boolean z) {
        this.B.a(z);
    }
}
