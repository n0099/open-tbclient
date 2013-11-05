package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.br;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.model.ap o;
    private com.baidu.tieba.model.x p;

    /* renamed from: a  reason: collision with root package name */
    private int f1244a = 0;
    private String b = null;
    private com.baidu.tieba.util.a c = null;
    private int d = 0;
    private int e = 0;
    private FooterType f = FooterType.GONE;
    private int g = 0;
    private int j = 1;
    private String k = null;
    private int l = 0;
    private ay m = null;
    private BroadcastReceiver n = null;
    private boolean q = false;
    private boolean r = false;
    private com.baidu.tieba.model.au s = null;
    private com.baidu.tieba.model.aq t = null;
    private ax u = new aj(this);
    private ax v = new ap(this);
    private View.OnClickListener w = new au(this);
    private br x = new av(this);
    private View.OnClickListener y = new aw(this);
    private com.baidu.tbadk.imageManager.c z = new ak(this);
    private com.baidu.tbadk.imageManager.c A = new al(this);
    private SlidingMenu.OnClosedListener B = new am(this);
    private com.baidu.adp.widget.ScrollView.o C = new an(this);
    private SlidingMenu.OnOpenedListener D = new ao(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum FooterType {
        NORMAL,
        LOADING,
        NEXT,
        LAST,
        GONE,
        NO_ITEM
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(FrsImageActivity frsImageActivity, int i) {
        int i2 = frsImageActivity.g + i;
        frsImageActivity.g = i2;
        return i2;
    }

    @Override // com.baidu.tieba.j
    public boolean g() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (UtilHelper.b()) {
            this.m.e();
        } else {
            this.m.d();
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, FrsImageActivity.class);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str);
            intent.putExtra("from", str2);
            intent.putExtra("add_search", i);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.frs_image_activity);
        d();
        a(bundle);
    }

    private void d() {
        this.m = new ay(this, this.w);
        this.m.b().e();
        e(this.m.a().getLineWidth());
        this.m.a(this.x);
        this.m.a(this.B);
        this.m.a(this.D);
        this.d = UtilHelper.c(this, 12.0f);
        this.e = UtilHelper.c(this, 10.0f);
        a(FooterType.GONE);
        this.m.a().setOnPullDownListener(this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.m.a().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.m.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            this.m.b().a(true);
        } else {
            this.m.b().a(false);
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            if (this.s != null && this.s.e() != null) {
                this.s.e().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.s != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.s.a().getId(), this.s.a().getName(), this.s.e(), false, (String) null);
            } else {
                this.m.f().show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    d(0);
                    return;
                case 11016:
                    this.m.f().show();
                    return;
                case 12001:
                    if (this.s != null && this.s.a() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.s.a().getId(), this.s.a().getName(), this.s.e());
                        return;
                    }
                    return;
                case 12002:
                    if (this.s != null && this.s.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.s.a().getId(), this.s.a().getName(), this.s.e());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.s != null && this.s.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.s.a().getId(), this.s.a().getName(), (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.s.a().getId(), this.s.a().getName(), (AntiData) null, true, intent.getStringExtra("filename"));
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
                    com.baidu.tieba.write.bg.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bg.a(this);
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
    public void e() {
        boolean z;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this);
        this.c.a();
        if (i == UtilHelper.NetworkStateInfo.WIFI || i == UtilHelper.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int b = UtilHelper.b((Context) this) * 2;
        this.c.a(z);
        int e = com.baidu.tieba.data.h.e() >> 1;
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 <= 2) {
                LinearLayout a2 = this.m.a().a(i3);
                int childCount = a2.getChildCount();
                int b2 = this.m.a().b(i3);
                int c = this.m.a().c(i3);
                if (b2 >= 0 && c >= 0) {
                    int i4 = 0;
                    int i5 = b2;
                    int i6 = 0;
                    while (true) {
                        if ((i5 <= c || z) && i5 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a2.getChildAt(i5);
                            if (frsWaterFallItem == null) {
                                break;
                            }
                            com.baidu.tieba.data.bg bgVar = (com.baidu.tieba.data.bg) frsWaterFallItem.getTag();
                            i4 += bgVar.b().d() * bgVar.b().e() * 2;
                            if (i4 > e) {
                                break;
                            }
                            if (i3 == 1) {
                                this.c.a(bgVar.b().c(), this.z);
                            } else {
                                this.c.a(bgVar.b().c(), this.A);
                            }
                            int d = bgVar.b().d() + i6;
                            int i7 = i5 + 1;
                            if (i7 <= c || d < b) {
                                i5 = i7;
                                i6 = d;
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void e(int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.f1244a = linearLayout.findViewById(R.id.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.n != null) {
            unregisterReceiver(this.n);
        }
        if (this.s != null) {
            this.s.f();
        }
        if (this.p != null) {
            this.p.cancelLoadData();
        }
        this.m.g();
    }

    private View f() {
        View footer = this.m.a().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.m.a().b(inflate);
            com.baidu.tieba.util.bb.b((TextView) inflate.findViewById(R.id.page_text), TiebaApplication.g().as());
            inflate.setOnClickListener(new aq(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View n() {
        View header2 = this.m.a().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            com.baidu.tieba.util.bb.b(textView, TiebaApplication.g().as());
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            this.m.a().a(inflate);
            inflate.setOnClickListener(new ar(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.m.a().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FooterType footerType) {
        View f = f();
        TextView textView = (TextView) f.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) f.findViewById(R.id.progress);
        if (footerType == FooterType.NEXT) {
            f.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.LOADING) {
            f.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
        } else if (footerType == FooterType.NORMAL) {
            f.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.NO_ITEM) {
            f.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            f.setVisibility(8);
        }
        this.f = footerType;
        com.baidu.tieba.util.bb.b(textView, this.i);
    }

    private void a(Bundle bundle) {
        this.c = new com.baidu.tieba.util.a(this);
        this.c.a(this.f1244a, 600);
        this.c.b("_water");
        this.c.c(true);
        Intent intent = getIntent();
        this.k = intent.getStringExtra("from");
        this.l = intent.getIntExtra("add_search", 0);
        this.b = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
        this.m.a(this.b);
        if (bundle != null) {
            this.j = bundle.getInt("current_page");
        }
        if (this.j < 1) {
            this.j = 1;
        }
        f(this.j);
        this.o = new com.baidu.tieba.model.ap(this);
        this.p = new com.baidu.tieba.model.x();
        this.p.setLoadDataCallBack(new as(this));
        String C = TiebaApplication.C();
        if (C != null && C.length() > 0) {
            p();
            r();
            this.p.a(false, true, true);
        }
        this.q = false;
    }

    private void p() {
        this.o.a(com.baidu.tieba.mention.t.a().n());
        this.o.c(com.baidu.tieba.mention.t.a().l());
        this.o.b(com.baidu.tieba.mention.t.a().m());
        this.o.d(com.baidu.tieba.mention.t.a().o());
        this.m.a(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.m.b().a(this.p.a());
    }

    private void r() {
        if (this.n == null) {
            this.n = new at(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.n, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        if (this.s == null) {
            this.s = new com.baidu.tieba.model.au();
        }
        this.s.a(this.k, this.b);
        this.s.a(this.u);
        this.s.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        if (this.s != null && this.s.c().size() > i && this.f == FooterType.NORMAL) {
            this.s.a(this.k, this.b);
            this.s.b(this.v);
            this.s.b(i);
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.m.c().isMenuShowing()) {
                this.m.c().toggle(true);
                if (this.q) {
                    this.q = false;
                    f(1);
                    return true;
                }
                return true;
            }
            h();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.m.g();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Intent a2;
        if (str != null && (a2 = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", str + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            a(getString(R.string.add_to_window_succ));
            new com.baidu.tieba.account.ah("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.tieba.data.bg> arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.data.bg bgVar = arrayList.get(i2);
                    if (bgVar != null) {
                        int a2 = bgVar.b().a();
                        int b = bgVar.b().b();
                        if (a2 >= 100 && b >= 50) {
                            if (a2 > this.f1244a) {
                                float f = this.f1244a / a2;
                                a2 = this.f1244a;
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
                            TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(R.id.image);
                            tbImageView.setAutoAnim(true);
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = height;
                            tbImageView.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(bgVar);
                            tbImageView.setImageSearchUrl(bgVar.b().c() + "_water");
                            tbImageView.setDefaultId(R.drawable.pic_image_h_not);
                            tbImageView.setNightDefaultId(R.drawable.pic_image_h_not_1);
                            tbImageView.setTag(bgVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.y);
                            int a4 = UtilHelper.a((Context) this, 5.0f);
                            int paddingBottom = height + this.d + this.e + (a4 * 2) + frsWaterFallItem.getPaddingBottom() + UtilHelper.a((Context) this, 10.0f);
                            frsWaterFallItem.a(this.d, this.e, a4);
                            this.m.a().a(frsWaterFallItem, paddingBottom);
                            bgVar.b().a(paddingBottom);
                            bgVar.b().b(i);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "setData", e.getMessage());
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.m.b().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().as() != 1) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.g().i(1);
                    this.i = 1;
                    a(this.i);
                    new com.baidu.tieba.account.ah("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().as() != 0) {
                TiebaApplication.g().i(0);
                this.i = 0;
                a(this.i);
            } else {
                return;
            }
            com.baidu.tieba.util.e.a();
        }
    }
}
