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
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.bn;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.ImageViewDrawer;
import com.baidu.tieba.view.bm;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tieba.g implements com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.model.af p;
    private com.baidu.tieba.model.m q;

    /* renamed from: a  reason: collision with root package name */
    private int f1050a = 0;
    private String b = null;
    private com.baidu.tieba.util.a c = null;
    private int d = 0;
    private int e = 0;
    private FooterType f = FooterType.GONE;
    private int g = 0;
    private int j = 1;
    private String k = null;
    private int l = 0;
    private Rect m = new Rect();
    private ax n = null;
    private BroadcastReceiver o = null;
    private boolean r = false;
    private boolean s = false;
    private com.baidu.tieba.model.ak t = null;
    private com.baidu.tieba.model.ag u = null;
    private aw v = new ai(this);
    private aw w = new ao(this);
    private View.OnClickListener x = new ap(this);
    private bm y = new aq(this);
    private View.OnClickListener z = new ar(this);
    private com.baidu.tbadk.a.d A = new as(this);
    private com.baidu.tbadk.a.d B = new at(this);
    private SlidingMenu.OnClosedListener C = new au(this);
    private com.baidu.adp.widget.ScrollView.n D = new av(this);
    private SlidingMenu.OnOpenedListener E = new aj(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum FooterType {
        NORMAL,
        LOADING,
        NEXT,
        LAST,
        GONE,
        NO_ITEM;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static FooterType[] valuesCustom() {
            FooterType[] valuesCustom = values();
            int length = valuesCustom.length;
            FooterType[] footerTypeArr = new FooterType[length];
            System.arraycopy(valuesCustom, 0, footerTypeArr, 0, length);
            return footerTypeArr;
        }
    }

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().w();
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
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frs_image_activity);
        c();
        a(bundle);
    }

    private void c() {
        this.n = new ax(this, this.x);
        this.n.b().c();
        e(this.n.a().getLineWidth());
        this.n.a(this.y);
        this.n.a(this.C);
        this.n.a(this.E);
        this.d = com.baidu.tieba.util.am.b(this, 12.0f);
        this.e = com.baidu.tieba.util.am.b(this, 10.0f);
        a(FooterType.GONE);
        this.n.a().setOnPullDownListener(this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.n.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.n.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            this.n.b().a(true);
        } else {
            this.n.b().a(false);
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            if (this.t != null && this.t.e() != null) {
                this.t.e().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
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
                case 11001:
                    b(0);
                    return;
                case 11016:
                    this.n.d().show();
                    return;
                case 12001:
                    if (this.t != null && this.t.a() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.t.a().a(), this.t.a().b(), this.t.e());
                        return;
                    }
                    return;
                case 12002:
                    if (this.t != null && this.t.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.t.a().a(), this.t.a().b(), this.t.e());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.t != null && this.t.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.t.a().a(), this.t.a().b(), (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.t.a().a(), this.t.a().b(), (AntiData) null, true, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tieba.write.ba.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.ba.a(this);
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
        NetWorkCore.NetworkStateInfo c = NetWorkCore.c(this);
        this.c.a();
        if (c == NetWorkCore.NetworkStateInfo.WIFI || c == NetWorkCore.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int b = com.baidu.tieba.util.am.b((Context) this) * 2;
        this.c.a(z);
        int d = com.baidu.tieba.data.g.d() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                LinearLayout a2 = this.n.a().a(i2);
                int childCount = a2.getChildCount();
                int b2 = this.n.a().b(i2);
                int c2 = this.n.a().c(i2);
                if (b2 >= 0 && c2 >= 0) {
                    int i3 = 0;
                    int i4 = b2;
                    int i5 = 0;
                    while (true) {
                        if ((i4 <= c2 || z) && i4 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a2.getChildAt(i4);
                            if (frsWaterFallItem != null) {
                                bn bnVar = (bn) frsWaterFallItem.getTag();
                                i3 += bnVar.b().d() * bnVar.b().e() * 2;
                                if (i3 > d) {
                                    break;
                                }
                                if (i2 == 1) {
                                    this.c.a(bnVar.b().c(), this.A);
                                } else {
                                    this.c.a(bnVar.b().c(), this.B);
                                }
                                int d2 = bnVar.b().d() + i5;
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

    private void e(int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.f1050a = linearLayout.findViewById(R.id.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.o != null) {
            unregisterReceiver(this.o);
        }
        if (this.t != null) {
            this.t.f();
        }
        if (this.q != null) {
            this.q.cancelLoadData();
        }
        this.n.e();
    }

    private View k() {
        View footer = this.n.a().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.n.a().b(inflate);
            com.baidu.tieba.util.ah.b((TextView) inflate.findViewById(R.id.page_text), TiebaApplication.f().au());
            inflate.setOnClickListener(new ak(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View l() {
        View header2 = this.n.a().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            com.baidu.tieba.util.ah.b(textView, TiebaApplication.f().au());
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            this.n.a().a(inflate);
            inflate.setOnClickListener(new al(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.n.a().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FooterType footerType) {
        View k = k();
        TextView textView = (TextView) k.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) k.findViewById(R.id.progress);
        if (footerType == FooterType.NEXT) {
            k.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.LOADING) {
            k.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
        } else if (footerType == FooterType.NORMAL) {
            k.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.NO_ITEM) {
            k.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            k.setVisibility(8);
        }
        this.f = footerType;
        com.baidu.tieba.util.ah.b(textView, this.i);
    }

    private void a(Bundle bundle) {
        this.c = new com.baidu.tieba.util.a(this);
        this.c.a(this.f1050a, 600);
        this.c.b("_water");
        this.c.c(true);
        Intent intent = getIntent();
        this.k = intent.getStringExtra("from");
        this.l = intent.getIntExtra("add_search", 0);
        this.b = intent.getStringExtra("name");
        this.n.a(this.b);
        if (bundle != null) {
            this.j = bundle.getInt("current_page");
        }
        if (this.j < 1) {
            this.j = 1;
        }
        f(this.j);
        this.p = new com.baidu.tieba.model.af(this);
        this.q = new com.baidu.tieba.model.m();
        this.q.setLoadDataCallBack(new am(this));
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            n();
            p();
            this.q.a(false, true, true);
        }
        this.r = false;
    }

    private void n() {
        this.p.a(TiebaApplication.f().ag());
        this.p.c(TiebaApplication.f().ae());
        this.p.b(TiebaApplication.f().af());
        this.p.d(TiebaApplication.f().ah());
        this.n.a(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.n.b().a(this.q.a());
    }

    private void p() {
        if (this.o == null) {
            this.o = new an(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.o, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        if (this.t == null) {
            this.t = new com.baidu.tieba.model.ak();
        }
        this.t.a(this.k, this.b);
        this.t.a(this.v);
        this.t.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        if (this.t != null && this.t.c().size() > i && this.f == FooterType.NORMAL) {
            this.t.a(this.k, this.b);
            this.t.b(this.w);
            this.t.b(i);
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.n.c().isMenuShowing()) {
                this.n.c().toggle(true);
                if (this.r) {
                    this.r = false;
                    f(1);
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
        Intent a2;
        if (str != null && (a2 = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            a(getString(R.string.add_to_window_succ));
            new com.baidu.tieba.account.ag("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bn bnVar = (bn) arrayList.get(i2);
                    if (bnVar != null) {
                        int a2 = bnVar.b().a();
                        int b = bnVar.b().b();
                        if (a2 >= 100 && b >= 50) {
                            if (a2 > this.f1050a) {
                                float f = this.f1050a / a2;
                                a2 = this.f1050a;
                                b = (int) (b * f);
                            }
                            if (b > 600) {
                                i = (int) ((600.0f / b) * a2);
                                b = 600;
                            } else {
                                i = a2;
                            }
                            Bitmap a3 = com.baidu.tieba.util.e.a((int) R.drawable.image_default);
                            int height = b < a3.getHeight() ? a3.getHeight() : b;
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
                            frsWaterFallItem.a(this.i);
                            ImageViewDrawer imageViewDrawer = (ImageViewDrawer) frsWaterFallItem.findViewById(R.id.image);
                            ViewGroup.LayoutParams layoutParams = imageViewDrawer.getLayoutParams();
                            layoutParams.height = height;
                            imageViewDrawer.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(bnVar);
                            imageViewDrawer.setImageSearchUrl(String.valueOf(bnVar.b().c()) + "_water");
                            imageViewDrawer.setDefaultId(R.drawable.pic_image_h_not);
                            imageViewDrawer.setNightDefaultId(R.drawable.pic_image_h_not_1);
                            imageViewDrawer.setTag(bnVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.z);
                            int a4 = com.baidu.tieba.util.am.a((Context) this, 5.0f);
                            int paddingBottom = height + this.d + this.e + (a4 * 2) + frsWaterFallItem.getPaddingBottom() + com.baidu.tieba.util.am.a((Context) this, 10.0f);
                            frsWaterFallItem.a(this.d, this.e, a4);
                            this.n.a().a(frsWaterFallItem, paddingBottom);
                            bnVar.b().a(paddingBottom);
                            bnVar.b().b(i);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "setData", e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.n.b().d()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (!TiebaApplication.f().as() && TiebaApplication.f().t()) {
                    StatService.onEvent(this, "frs_abstract", "frsclick", 1);
                }
                TiebaApplication.f().s(true);
                return;
            }
            if (TiebaApplication.f().as() && TiebaApplication.f().t()) {
                StatService.onEvent(this, "frs_abstract", "frsclick", 1);
            }
            TiebaApplication.f().s(false);
        } else if (view == this.n.b().e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.f().au() != 1) {
                    if (TiebaApplication.f().t()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.f().h(1);
                    this.i = 1;
                    a(this.i);
                    new com.baidu.tieba.account.ag("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.f().au() != 0) {
                TiebaApplication.f().h(0);
                this.i = 0;
                a(this.i);
            } else {
                return;
            }
            com.baidu.tieba.util.e.a();
        }
    }
}
