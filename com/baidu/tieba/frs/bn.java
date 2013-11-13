package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableString;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsHeaderView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.zeus.bouncycastle.DERTags;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bn {
    private View.OnClickListener E;
    private int H;
    private int I;
    private int J;
    private NoNetworkView K;
    private NavigationBar L;
    private com.baidu.tieba.j d;
    private boolean c = false;
    private RelativeLayout e = null;
    private ImageView f = null;
    private TextView g = null;
    private ImageView h = null;
    private Button i = null;
    private FrameLayout j = null;
    private ImageView k = null;
    private ImageView l = null;
    private BdListView m = null;
    private ah n = null;
    private TextView o = null;
    private LinearLayout p = null;
    private TextView q = null;
    private AlertDialog r = null;
    private FrsHeaderView s = null;
    private com.baidu.tieba.view.aa t = null;
    private com.baidu.tieba.view.v u = null;
    private ap v = null;
    private TextView w = null;
    private View x = null;
    private int y = 0;
    private com.baidu.tieba.view.bi z = null;
    private bs A = null;
    private com.baidu.tieba.view.am B = null;
    private SlidingMenu C = null;
    private String D = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1339a = null;
    Animation b = null;
    private DialogInterface.OnClickListener F = null;
    private com.baidu.tieba.view.az G = null;
    private View.OnTouchListener M = new bq(this);

    public bn(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.d = null;
        this.E = null;
        this.d = frsActivity;
        this.E = onClickListener;
        K();
    }

    private void K() {
        this.d.setContentView(R.layout.frs_activity);
        this.A = new bs(this.d);
        this.A.a(R.id.show_all);
        this.e = (RelativeLayout) this.d.findViewById(R.id.frs);
        this.C = new SlidingMenu(this.d);
        this.C.setMode(1);
        this.C.setTouchModeAbove(1);
        this.C.setBehindOffset(UtilHelper.a((Context) this.d, 48.0f));
        this.C.setBehindScrollScale(0.5f);
        this.C.setFadeDegree(0.35f);
        this.C.attachToActivity(this.d, 1);
        this.C.setMenu(this.A.a());
        this.L = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.g = this.L.a("");
        this.f = this.L.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.E);
        this.h = this.L.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.EDIT_BUTTON, this.E);
        View a2 = this.L.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_frs_more, (View.OnClickListener) null);
        this.x = a2.findViewById(R.id.frs_top_more);
        this.x.setOnClickListener(this.E);
        this.w = (TextView) a2.findViewById(R.id.frs_more_mes_text);
        this.j = (FrameLayout) this.d.findViewById(R.id.refresh_layout);
        this.k = (ImageView) this.d.findViewById(R.id.refresh_bg);
        this.l = (ImageView) this.d.findViewById(R.id.refresh_icon);
        String[] strArr = {this.d.getString(R.string.take_photo), this.d.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getString(R.string.operation));
        builder.setItems(strArr, new bo(this));
        if (this.r == null) {
            this.r = builder.create();
            this.r.setCanceledOnTouchOutside(true);
        }
        this.m = (BdListView) this.d.findViewById(R.id.frs_lv_thread);
        this.z = new com.baidu.tieba.view.bi(this.d);
        this.m.setPullRefresh(this.z);
        this.m.setDivider(null);
        this.m.setDividerHeight(0);
        this.m.setRecyclerListener(new bp(this));
        this.s = new FrsHeaderView(this.d, FrsHeaderView.PAGE.FRS_LIST, null, null);
        this.t = new com.baidu.tieba.view.aa(this.d, null, null);
        this.u = new com.baidu.tieba.view.v(this.d);
        this.n = new ah(this.d, null, UtilHelper.a((Context) this.d), com.baidu.tieba.util.bf.a().b());
        this.b = AnimationUtils.loadAnimation(this.d, R.anim.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.o = (TextView) this.d.findViewById(R.id.frs_noexist);
        this.o.setVisibility(8);
        this.q = (TextView) this.d.findViewById(R.id.frs_noexist_text);
        this.p = (LinearLayout) this.d.findViewById(R.id.frs_noexist_layout);
        this.i = (Button) this.d.findViewById(R.id.frs_bt_create);
        this.A.a(this.E);
        this.j.setOnClickListener(this.E);
        this.i.setOnClickListener(this.E);
        this.s.a(this.E);
        this.t.a(this.E);
        this.g.setOnClickListener(this.E);
        this.j.setOnTouchListener(this.M);
        this.K = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView a() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View d() {
        return this.x;
    }

    public void a(com.baidu.tieba.view.az azVar) {
        this.G = azVar;
        if (this.K != null) {
            this.K.a(this.G);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.C.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.C.setOnOpenedListener(onOpenedListener);
    }

    public bs e() {
        return this.A;
    }

    public SlidingMenu f() {
        return this.C;
    }

    public void a(boolean z) {
        this.C.showMenu(z);
    }

    public void g() {
        this.K.setVisibility(0);
    }

    public void h() {
        this.K.setVisibility(8);
    }

    public NoNetworkView i() {
        return this.K;
    }

    public void a(com.baidu.tieba.data.ba baVar, boolean z) {
        String string = this.d.getString(R.string.view);
        String string2 = this.d.getString(R.string.view_host);
        String string3 = this.d.getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.F);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.F);
        }
        this.f1339a = builder.create();
        this.f1339a.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.z.a(bVar);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.m.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.m.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.m.setOnSrollToTopListener(sVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.m.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.m.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.F = onClickListener;
    }

    public void j() {
        if (this.f1339a != null) {
            this.f1339a.show();
        }
    }

    public void a(String str) {
        this.d.showToast(str);
    }

    public void b(boolean z) {
        this.c = z;
        if (z) {
            if (this.b != null) {
                this.j.setOnTouchListener(null);
                this.l.startAnimation(this.b);
                if (this.y == 1) {
                    this.k.setImageResource(R.drawable.pic_fresh_s_1);
                    return;
                } else {
                    this.k.setImageResource(R.drawable.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.j.setOnTouchListener(this.M);
        this.m.a();
        this.l.clearAnimation();
        if (this.y == 1) {
            this.k.setImageResource(R.drawable.pic_fresh_n_1);
        } else {
            this.k.setImageResource(R.drawable.pic_fresh_n);
        }
    }

    public boolean k() {
        return this.c;
    }

    public ah l() {
        return this.n;
    }

    public FrsHeaderView m() {
        return this.s;
    }

    public com.baidu.tieba.view.aa n() {
        return this.t;
    }

    public void b(String str) {
        this.o.setText(R.string.frs_noforum);
        SpannableString spannableString = new SpannableString(str + this.d.getString(R.string.frs_remind_noforum));
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, str.length(), 33);
        this.p.setVisibility(0);
        this.q.setText(spannableString);
        this.g.setText(R.string.frs_create_forum);
        this.m.setVisibility(8);
        this.h.setVisibility(4);
        this.h.setClickable(false);
        this.j.setVisibility(4);
        this.x.setVisibility(8);
        this.w.setVisibility(8);
        this.C.setTouchModeAbove(2);
    }

    public void o() {
        this.m.setVisibility(0);
    }

    public void c(String str) {
        this.g.setText(str + this.d.getString(R.string.forum));
    }

    public void p() {
        if (this.n != null) {
            this.n.notifyDataSetChanged();
        }
    }

    public void q() {
        L();
        this.D = "normal_page";
        this.m.addHeaderView(this.s.c());
    }

    public void r() {
        L();
        this.D = "frs_page";
        this.m.addHeaderView(this.t.c());
    }

    public void s() {
        if (!"good_page".equals(this.D)) {
            L();
            this.D = "good_page";
            this.m.addHeaderView(this.u.a());
        }
    }

    private void L() {
        if ("normal_page".equals(this.D)) {
            this.m.removeHeaderView(this.s.c());
        } else if ("frs_page".equals(this.D)) {
            this.m.removeHeaderView(this.t.c());
        } else if ("good_page".equals(this.D)) {
            this.m.removeHeaderView(this.u.a());
        }
    }

    public void t() {
        if (this.s != null) {
            this.s.g().setVisibility(0);
        }
    }

    public void u() {
        if (this.s != null) {
            this.s.g().setVisibility(8);
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

    public boolean x() {
        if ("normal_page".equals(this.D)) {
            return this.s.d();
        }
        if ("frs_page".equals(this.D)) {
            return this.t.d();
        }
        return false;
    }

    public boolean y() {
        if ("normal_page".equals(this.D)) {
            return this.s.e();
        }
        if ("frs_page".equals(this.D)) {
            return this.t.e();
        }
        return false;
    }

    public void z() {
        this.m.setAdapter((ListAdapter) this.n);
    }

    public void c(boolean z) {
        this.n.b(z);
    }

    public void d(boolean z) {
        this.n.c(z);
    }

    public void A() {
        this.r.show();
    }

    public void a(ArrayList<com.baidu.tieba.data.ba> arrayList, int i, com.baidu.tieba.model.ak akVar) {
        this.n.a(arrayList);
        if (arrayList == null || arrayList.size() <= 0) {
            this.o.setText(R.string.frs_nodata);
            this.o.setVisibility(0);
            return;
        }
        this.o.setVisibility(8);
    }

    public View d(String str) {
        return this.m.findViewWithTag(str);
    }

    public View a(int i) {
        return this.m.findViewById(i);
    }

    public BdListView B() {
        return this.m;
    }

    public void b(int i) {
        if (i > 1) {
            this.n.d(true);
        } else {
            this.n.d(false);
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.n.e(true);
        } else {
            this.n.e(false);
        }
    }

    public void C() {
        this.n.b(false);
        this.n.c(false);
        this.n.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.m.setSelection(i);
    }

    public void a(ForumData forumData, com.baidu.tieba.model.ak akVar) {
        if (this.t != null) {
            this.t.a(forumData, akVar);
        }
        this.t.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a(forumData), false);
        this.t.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.t.a(false);
        }
    }

    public void a(int i, int i2, ForumData forumData, com.baidu.tieba.model.ak akVar) {
        this.t.a(forumData, akVar);
        this.t.c(i);
        if (this.J >= 0 && i2 > 0 && this.t.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.t.a(forumData, akVar);
            this.t.a(k(i2));
            this.t.a(this.t.f());
        }
    }

    public void e(int i) {
        this.t.c(i);
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.model.ak akVar, boolean z) {
        if (this.t != null) {
            this.t.a(forumData, akVar);
        }
        this.t.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
        if (forumData.getSignData().getForumRank() == -2) {
            this.t.a(false);
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.model.ak akVar) {
        if (this.s != null) {
            this.s.a(forumData, akVar);
        }
        this.s.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a(forumData), false);
        this.s.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.s.a(false);
        }
    }

    public void f(int i) {
        this.s.c(i);
    }

    public void b(int i, int i2, ForumData forumData, com.baidu.tieba.model.ak akVar) {
        this.s.a(forumData, akVar);
        this.s.c(i);
        if (this.J >= 0 && i2 > 0 && this.s.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.s.a(forumData, akVar);
            this.s.a(k(i2));
            this.s.a(this.s.f());
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.model.ak akVar, boolean z) {
        if (this.s != null) {
            this.s.a(forumData, akVar);
        }
        if (forumData != null) {
            this.s.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.s.a(false);
            }
        }
    }

    public void g(int i) {
        if (this.s != null) {
            this.s.b(i);
        }
    }

    public void h(int i) {
        if (this.t != null) {
            this.t.b(i);
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.H = forumData.getLevelupScore();
        this.I = forumData.getCurScore();
        this.J = this.H - this.I;
        if (this.H > 0) {
            return this.I / this.H;
        }
        return 0.0f;
    }

    private float k(int i) {
        if (this.J < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.J) {
            return 1.0f;
        }
        return (this.I + i) / this.H;
    }

    public void a(View view) {
        if (this.s != null) {
            this.s.a(view);
        }
    }

    public void b(View view) {
        if (this.t != null) {
            this.t.a(view);
        }
    }

    public void D() {
        if (this.B != null) {
            this.B.dismiss();
        }
        l().a().b();
        n().a().b();
    }

    public void E() {
        if (this.K != null && this.G != null) {
            this.K.b(this.G);
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.z> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        s();
        if (this.v == null) {
            this.v = new ap(this.d, arrayList);
            this.u.a(this.v);
            this.u.a(onItemClickListener);
            this.A.a(R.id.show_good);
            return;
        }
        this.v.a(arrayList);
        this.v.notifyDataSetChanged();
        this.A.a(R.id.show_good);
    }

    public void F() {
        if (this.B != null) {
            this.B.a();
        }
    }

    public void a(com.baidu.adp.widget.ImageView.e eVar, boolean z) {
        if (this.B == null) {
            this.B = new com.baidu.tieba.view.am(this.d, this.e.getWidth(), this.e.getHeight());
        }
        if (this.B.isShowing()) {
            this.B.a(eVar);
        } else {
            this.B.a(eVar, z);
        }
    }

    public com.baidu.tieba.view.am G() {
        return this.B;
    }

    public void H() {
        if (this.B != null) {
            this.B.a(null);
        }
    }

    public void i(int i) {
        if (this.v != null) {
            this.v.a(i);
        }
    }

    public void a(com.baidu.tieba.model.ap apVar) {
        this.A.a(apVar);
        long a2 = apVar.a() + apVar.b();
        if (a2 > 0) {
            this.w.setVisibility(0);
            this.w.setText(String.valueOf(a2 <= 99 ? a2 : 99L));
            return;
        }
        this.w.setVisibility(4);
    }

    public void j(int i) {
        this.y = i;
        this.t.a(i);
        if (this.z != null) {
            this.z.a(i);
        }
        if (this.n != null) {
            this.n.d();
            this.n.notifyDataSetChanged();
        }
        if (this.v != null) {
            this.v.notifyDataSetChanged();
        }
        this.u.a(i);
        this.A.b(i);
        this.s.a(i);
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.e);
        this.L.c(i);
    }

    public void e(boolean z) {
        if (z) {
            this.k.setAlpha(DERTags.TAGGED);
            this.l.setAlpha(DERTags.TAGGED);
            return;
        }
        this.k.setAlpha(Util.MASK_8BIT);
        this.l.setAlpha(Util.MASK_8BIT);
    }

    public void I() {
        this.m.b();
    }

    public int J() {
        return R.id.user_icon_box;
    }
}
