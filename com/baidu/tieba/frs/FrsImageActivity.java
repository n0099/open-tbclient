package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
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
import com.baidu.tieba.model.ci;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.bx;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.model.ap n;
    private com.baidu.tieba.model.x o;
    private com.baidu.tieba.model.ax t;
    private ci u;

    /* renamed from: a  reason: collision with root package name */
    private int f1301a = 0;
    private String b = null;
    private com.baidu.tieba.util.i c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private FooterType g = FooterType.GONE;
    private int h = 0;
    private int i = 1;
    private String j = null;
    private int k = 0;
    private bl l = null;
    private BroadcastReceiver m = null;
    private boolean p = false;
    private boolean q = false;
    private com.baidu.tieba.model.ar r = null;
    private com.baidu.tieba.model.aq s = null;
    private bk v = new as(this);
    private bk w = new bc(this);
    private View.OnClickListener x = new bj(this);
    private bx y = new av(this);
    private View.OnClickListener z = new aw(this);
    private com.baidu.tbadk.imageManager.c A = new ax(this);
    private com.baidu.tbadk.imageManager.c B = new ay(this);
    private SlidingMenu.OnClosedListener C = new az(this);
    private com.baidu.adp.widget.ScrollView.n D = new ba(this);
    private SlidingMenu.OnOpenedListener E = new bb(this);

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
        int i2 = frsImageActivity.h + i;
        frsImageActivity.h = i2;
        return i2;
    }

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (UtilHelper.b()) {
            this.l.i();
        } else {
            this.l.h();
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
        e();
        a(bundle);
    }

    private void e() {
        this.l = new bl(this, this.x);
        this.l.f().e();
        b(this.l.e().getLineWidth());
        this.l.a(this.y);
        this.l.a(this.C);
        this.l.a(this.E);
        this.d = getResources().getDimensionPixelSize(R.dimen.default_size_21);
        this.e = getResources().getDimensionPixelSize(R.dimen.default_size_18);
        this.f = getResources().getDimensionPixelSize(R.dimen.frs_image_block);
        a(FooterType.GONE);
        this.l.e().setOnPullDownListener(this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.l.e().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.l.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            this.l.f().a(true);
        } else {
            this.l.f().a(false);
        }
        f();
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
    public void a(int i) {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            if (this.r != null && this.r.e() != null) {
                this.r.e().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.r != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.r.a().getId(), this.r.a().getName(), this.r.e(), false, (String) null);
            } else {
                this.l.j().show();
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    a(0);
                    return;
                case 11002:
                    b();
                    return;
                case 11016:
                    this.l.j().show();
                    return;
                case 11036:
                    c();
                    return;
                case 12001:
                    if (this.r != null && this.r.a() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.r.a().getId(), this.r.a().getName(), this.r.e());
                        return;
                    }
                    return;
                case 12002:
                    if (this.r != null && this.r.a() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.r.a().getId(), this.r.a().getName(), this.r.e());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.r != null && this.r.a() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.r.a().getId(), this.r.a().getName(), (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.r.a().getId(), this.r.a().getName(), (AntiData) null, true, intent.getStringExtra("filename"));
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
                    com.baidu.tieba.write.bc.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bc.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.i = bundle.getInt("current_page");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_page", this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
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
                LinearLayout a2 = this.l.e().a(i3);
                int childCount = a2.getChildCount();
                int b2 = this.l.e().b(i3);
                int c = this.l.e().c(i3);
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
                            com.baidu.tieba.data.bb bbVar = (com.baidu.tieba.data.bb) frsWaterFallItem.getTag();
                            i4 += bbVar.b().d() * bbVar.b().e() * 2;
                            if (i4 > e) {
                                break;
                            }
                            if (i3 == 1) {
                                this.c.a(bbVar.b().c(), this.A);
                            } else {
                                this.c.a(bbVar.b().c(), this.B);
                            }
                            int d = bbVar.b().d() + i6;
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

    private void b(int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.f1301a = linearLayout.findViewById(R.id.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.m != null) {
            unregisterReceiver(this.m);
        }
        if (this.r != null) {
            this.r.f();
        }
        if (this.o != null) {
            this.o.cancelLoadData();
        }
        this.l.k();
    }

    private View g() {
        View footer = this.l.e().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.l.e().b(inflate);
            com.baidu.tieba.util.bd.b((TextView) inflate.findViewById(R.id.page_text), TiebaApplication.g().ap());
            inflate.setOnClickListener(new bd(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View h() {
        View header2 = this.l.e().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            com.baidu.tieba.util.bd.b(textView, TiebaApplication.g().ap());
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            this.l.e().a(inflate);
            inflate.setOnClickListener(new be(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.l.e().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FooterType footerType) {
        View g = g();
        TextView textView = (TextView) g.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) g.findViewById(R.id.progress);
        if (footerType == FooterType.NEXT) {
            g.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.LOADING) {
            g.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
        } else if (footerType == FooterType.NORMAL) {
            g.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.NO_ITEM) {
            g.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            g.setVisibility(8);
        }
        this.g = footerType;
        com.baidu.tieba.util.bd.b(textView, this.mSkinType);
    }

    private void a(Bundle bundle) {
        this.c = new com.baidu.tieba.util.i(this);
        this.c.a(this.f1301a, 600);
        this.c.b("_water");
        this.c.c(true);
        this.c.f("frs");
        Intent intent = getIntent();
        this.j = intent.getStringExtra("from");
        this.k = intent.getIntExtra("add_search", 0);
        this.b = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
        this.l.a(this.b);
        if (bundle != null) {
            this.i = bundle.getInt("current_page");
        }
        if (this.i < 1) {
            this.i = 1;
        }
        c(this.i);
        this.n = new com.baidu.tieba.model.ap(this);
        this.o = new com.baidu.tieba.model.x();
        this.o.setLoadDataCallBack(new bf(this));
        this.t = new com.baidu.tieba.model.ax();
        this.t.setLoadDataCallBack(new bg(this));
        this.u = new ci();
        this.u.a(new bh(this));
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            j();
            l();
            this.o.a(false, true, true);
        }
        this.p = false;
    }

    private void j() {
        this.n.a(com.baidu.tieba.mention.t.a().n());
        this.n.c(com.baidu.tieba.mention.t.a().l());
        this.n.b(com.baidu.tieba.mention.t.a().m());
        this.n.d(com.baidu.tieba.mention.t.a().o());
        this.l.a(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.l.f().a(this.o.a());
    }

    private void l() {
        if (this.m == null) {
            this.m = new bi(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.m, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.r == null) {
            this.r = new com.baidu.tieba.model.ar();
        }
        this.r.a(this.j, this.b);
        this.r.a(this.v);
        this.r.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.r != null && this.r.c().size() > i && this.g == FooterType.NORMAL) {
            this.r.a(this.j, this.b);
            this.r.b(this.w);
            this.r.b(i);
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.l.g().isMenuShowing()) {
                this.l.g().toggle(true);
                if (this.p) {
                    this.p = false;
                    c(1);
                    return true;
                }
                return true;
            }
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.l.k();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Intent a2;
        if (str != null && (a2 = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", str + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            showToast(getString(R.string.add_to_window_succ));
            new com.baidu.tieba.account.ag("add_to_launcher").start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.tieba.data.bb> arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.data.bb bbVar = arrayList.get(i2);
                    if (bbVar != null) {
                        int a2 = bbVar.b().a();
                        int b = bbVar.b().b();
                        if (a2 >= 100 && b >= 50) {
                            if (a2 > this.f1301a) {
                                float f = this.f1301a / a2;
                                a2 = this.f1301a;
                                b = (int) (b * f);
                            }
                            if (b > 600) {
                                i = (int) ((600.0f / b) * a2);
                                b = 600;
                            } else {
                                i = a2;
                            }
                            Bitmap a3 = com.baidu.tieba.util.m.a((int) R.drawable.image_default);
                            int height = b < a3.getHeight() ? a3.getHeight() : b;
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
                            frsWaterFallItem.a(this.mSkinType);
                            TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(R.id.image);
                            tbImageView.setAutoAnim(true);
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = height;
                            tbImageView.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(bbVar);
                            tbImageView.setImageSearchUrl(bbVar.b().c() + "_water");
                            tbImageView.setDefaultResource(R.drawable.pic_baidu_logo_d);
                            tbImageView.setNightDefaultResource(R.drawable.pic_baidu_logo_d_1);
                            tbImageView.setTag(bbVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.z);
                            int a4 = UtilHelper.a((Context) this, 1.0f);
                            int paddingBottom = height + (this.f * 2) + frsWaterFallItem.getPaddingBottom();
                            frsWaterFallItem.a(this.d, this.e, a4, this.f);
                            this.l.e().a(frsWaterFallItem, paddingBottom);
                            bbVar.b().a(paddingBottom);
                            bbVar.b().b(i);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bg.b(getClass().getName(), "setData", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.t.a("from_frs");
        this.t.a(this.r.a().getName(), this.r.a().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.attention_cancel_info));
        builder.setTitle(getString(R.string.alerm_title));
        builder.setPositiveButton(getString(R.string.attention_cancel), new at(this));
        builder.setNegativeButton(getString(R.string.cancel), new au(this));
        builder.create().show();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.l.f().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().ap() != 1) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "frs_night_mode", "frsclick", 1);
                    }
                    TiebaApplication.g().f(1);
                    this.mSkinType = 1;
                    onChangeSkinType(this.mSkinType);
                    new com.baidu.tieba.account.ag("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().ap() != 0) {
                TiebaApplication.g().f(0);
                this.mSkinType = 0;
                onChangeSkinType(this.mSkinType);
            } else {
                return;
            }
            com.baidu.tieba.util.m.a();
        }
    }
}
