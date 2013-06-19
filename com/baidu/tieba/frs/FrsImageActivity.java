package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tieba.e implements com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.c.x p;
    private com.baidu.tieba.c.j q;
    private int c = 0;
    private String d = null;
    private com.baidu.tieba.d.a e = null;
    private int f = 0;
    private int g = 0;
    private aw h = aw.GONE;
    private int i = 0;
    private int j = 1;
    private String k = null;
    private int l = 0;
    private Rect m = new Rect();
    private ay n = null;
    private BroadcastReceiver o = null;
    private boolean r = false;
    private boolean s = false;
    private com.baidu.tieba.c.z t = null;
    private com.baidu.tieba.c.y u = null;
    private ax v = new ai(this);
    private ax w = new ao(this);
    private View.OnClickListener x = new ap(this);
    private com.baidu.tieba.view.ax y = new aq(this);
    private View.OnClickListener z = new ar(this);
    private com.baidu.tbadk.a.d A = new as(this);
    private com.baidu.tbadk.a.d B = new at(this);
    private SlidingMenu.OnClosedListener C = new au(this);
    private com.baidu.adp.widget.ScrollView.o D = new av(this);
    private SlidingMenu.OnOpenedListener E = new aj(this);

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.e().s();
    }

    public static void a(Context context, String str, String str2, int i) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, FrsImageActivity.class);
            intent.putExtra("name", str);
            intent.putExtra("from", str2);
            intent.putExtra("add_search", i);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frs_image_activity);
        c();
        a(bundle);
    }

    private void c() {
        this.n = new ay(this, this.x);
        this.n.b().b();
        d(this.n.a().getLineWidth());
        this.n.a(this.y);
        this.n.a(this.C);
        this.n.a(this.E);
        this.f = com.baidu.tieba.d.ag.b(this, 12.0f);
        this.g = com.baidu.tieba.d.ag.b(this, 10.0f);
        a(aw.GONE);
        this.n.a().setOnPullDownListener(this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.n.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.n.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            this.n.b().a(true);
        } else {
            this.n.b().a(false);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.e != null) {
            this.e.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            if (this.t != null && this.t.e() != null) {
                this.t.e().a(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
            }
        } else if (this.t != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.t.a().a(), this.t.a().b(), this.t.e(), false, (String) null);
            } else {
                this.n.d().show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100001:
                    c(0);
                    return;
                case 1100016:
                    this.n.d().show();
                    return;
                case 1200001:
                    if (this.t != null && this.t.a() != null) {
                        WriteImageActivity.a(this, 1200001, 1200010, null, this.t.a().a(), this.t.a().b(), this.t.e());
                        return;
                    }
                    return;
                case 1200002:
                    if (this.t != null && this.t.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200009, intent.getData(), this.t.a().a(), this.t.a().b(), this.t.e());
                        return;
                    }
                    return;
                case 1200009:
                case 1200010:
                    if (this.t != null && this.t.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.t.a().a(), this.t.a().b(), (com.baidu.tieba.a.b) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.t.a().a(), this.t.a().b(), (com.baidu.tieba.a.b) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1200009:
                    com.baidu.tieba.write.bb.b(this);
                    return;
                case 1200010:
                    com.baidu.tieba.write.bb.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.j = bundle.getInt("current_page");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_page", this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        boolean z;
        com.baidu.tieba.d.z c = com.baidu.tieba.d.w.c(this);
        this.e.a();
        if (c == com.baidu.tieba.d.z.WIFI || c == com.baidu.tieba.d.z.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int b = com.baidu.tieba.d.ag.b((Context) this) * 2;
        this.e.a(z);
        int d = com.baidu.tieba.a.i.d() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                LinearLayout a = this.n.a().a(i2);
                int childCount = a.getChildCount();
                int b2 = this.n.a().b(i2);
                int c2 = this.n.a().c(i2);
                if (b2 >= 0 && c2 >= 0) {
                    int i3 = 0;
                    int i4 = b2;
                    int i5 = 0;
                    while (true) {
                        if ((i4 <= c2 || z) && i4 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a.getChildAt(i4);
                            if (frsWaterFallItem != null) {
                                com.baidu.tieba.a.bd bdVar = (com.baidu.tieba.a.bd) frsWaterFallItem.getTag();
                                i3 += bdVar.b().d() * bdVar.b().e() * 2;
                                if (i3 > d) {
                                    break;
                                }
                                if (i2 == 1) {
                                    this.e.a(bdVar.b().c(), this.A);
                                } else {
                                    this.e.a(bdVar.b().c(), this.B);
                                }
                                int d2 = bdVar.b().d() + i5;
                                int i6 = i4 + 1;
                                if (i6 <= c2 || d2 < b) {
                                    i4 = i6;
                                    i5 = d2;
                                }
                            }
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void d(int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.c = linearLayout.findViewById(R.id.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.o != null) {
            unregisterReceiver(this.o);
        }
        if (this.t != null) {
            this.t.f();
        }
        if (this.q != null) {
            this.q.e();
        }
        this.n.e();
    }

    private View m() {
        View footer = this.n.a().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.n.a().b(inflate);
            com.baidu.tieba.d.ac.b((TextView) inflate.findViewById(R.id.page_text), TiebaApplication.e().as());
            inflate.setOnClickListener(new ak(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View n() {
        View header2 = this.n.a().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            com.baidu.tieba.d.ac.b(textView, TiebaApplication.e().as());
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            this.n.a().a(inflate);
            inflate.setOnClickListener(new al(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.n.a().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aw awVar) {
        View m = m();
        TextView textView = (TextView) m.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) m.findViewById(R.id.progress);
        if (awVar == aw.NEXT) {
            m.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (awVar == aw.LOADING) {
            m.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
        } else if (awVar == aw.NORMAL) {
            m.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
        } else if (awVar == aw.NO_ITEM) {
            m.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            m.setVisibility(8);
        }
        this.h = awVar;
        com.baidu.tieba.d.ac.b(textView, this.b);
    }

    private void a(Bundle bundle) {
        this.e = new com.baidu.tieba.d.a(this);
        this.e.a(this.c, 600);
        this.e.a("_water");
        this.e.c(true);
        Intent intent = getIntent();
        this.k = intent.getStringExtra("from");
        this.l = intent.getIntExtra("add_search", 0);
        this.d = intent.getStringExtra("name");
        this.n.a(this.d);
        if (bundle != null) {
            this.j = bundle.getInt("current_page");
        }
        if (this.j < 1) {
            this.j = 1;
        }
        e(this.j);
        this.p = new com.baidu.tieba.c.x(this);
        this.q = new com.baidu.tieba.c.j();
        this.q.a(new am(this));
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            p();
            r();
            this.q.a(false, true, true);
        }
        this.r = false;
    }

    private void p() {
        this.p.a(TiebaApplication.e().ae());
        this.p.c(TiebaApplication.e().ac());
        this.p.b(TiebaApplication.e().ad());
        this.p.d(TiebaApplication.e().af());
        this.n.a(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.n.b().a(this.q.d());
    }

    private void r() {
        if (this.o == null) {
            this.o = new an(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.o, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        if (this.t == null) {
            this.t = new com.baidu.tieba.c.z();
        }
        this.t.a(this.k, this.d);
        this.t.a(this.v);
        this.t.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        if (this.t != null && this.t.c().size() > i && this.h == aw.NORMAL) {
            this.t.a(this.k, this.d);
            this.t.b(this.w);
            this.t.b(i);
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.n.c().isMenuShowing()) {
                this.n.c().toggle(true);
                if (this.r) {
                    this.r = false;
                    e(1);
                    return true;
                }
                return true;
            }
            f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.n.e();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Intent a;
        if (str != null && (a = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            a(getString(R.string.add_to_window_succ));
            new com.baidu.tieba.account.af("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.a.bd bdVar = (com.baidu.tieba.a.bd) arrayList.get(i2);
                    if (bdVar != null) {
                        int a = bdVar.b().a();
                        int b = bdVar.b().b();
                        if (a >= 100 && b >= 50) {
                            if (a > this.c) {
                                float f = this.c / a;
                                a = this.c;
                                b = (int) (b * f);
                            }
                            if (b > 600) {
                                i = (int) ((600.0f / b) * a);
                                b = 600;
                            } else {
                                i = a;
                            }
                            Bitmap a2 = com.baidu.tieba.d.d.a((int) R.drawable.image_default);
                            int height = b < a2.getHeight() ? a2.getHeight() : b;
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
                            frsWaterFallItem.a(this.b);
                            ImageViewDrawer imageViewDrawer = (ImageViewDrawer) frsWaterFallItem.findViewById(R.id.image);
                            ViewGroup.LayoutParams layoutParams = imageViewDrawer.getLayoutParams();
                            layoutParams.height = height;
                            imageViewDrawer.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(bdVar);
                            imageViewDrawer.setImageSearchUrl(String.valueOf(bdVar.b().c()) + "_water");
                            imageViewDrawer.setDefaultId(R.drawable.pic_image_h_not);
                            imageViewDrawer.setNightDefaultId(R.drawable.pic_image_h_not_1);
                            imageViewDrawer.setTag(bdVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.z);
                            int a3 = com.baidu.tieba.d.ag.a(this, 5.0f);
                            int paddingBottom = height + this.f + this.g + (a3 * 2) + frsWaterFallItem.getPaddingBottom() + com.baidu.tieba.d.ag.a(this, 10.0f);
                            frsWaterFallItem.a(this.f, this.g, a3);
                            this.n.a().a(frsWaterFallItem, paddingBottom);
                            bdVar.b().a(paddingBottom);
                            bdVar.b().b(i);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "setData", e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, com.baidu.adp.widget.BdSwitchView.d dVar) {
        if (view == this.n.b().c()) {
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                if (!TiebaApplication.e().aq() && TiebaApplication.e().p()) {
                    StatService.onEvent(this, "frs_abstract", "frsclick", 1);
                }
                TiebaApplication.e().r(true);
                return;
            }
            if (TiebaApplication.e().aq() && TiebaApplication.e().p()) {
                StatService.onEvent(this, "frs_abstract", "frsclick", 1);
            }
            TiebaApplication.e().r(false);
        } else if (view == this.n.b().d()) {
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                if (TiebaApplication.e().as() != 1) {
                    if (TiebaApplication.e().p()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.e().j(1);
                    this.b = 1;
                    b(this.b);
                    new com.baidu.tieba.account.af("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.e().as() != 0) {
                TiebaApplication.e().j(0);
                this.b = 0;
                b(this.b);
            } else {
                return;
            }
            com.baidu.tieba.d.d.a();
        }
    }
}
