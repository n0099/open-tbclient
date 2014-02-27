package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsWaterFallItem;
import com.baidu.tieba.view.di;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.BdSwitchView.c {
    private com.baidu.tieba.model.ae m;
    private com.baidu.tieba.model.k n;
    private com.baidu.tieba.model.ar t;
    private com.baidu.tieba.model.bx u;
    private int a = 0;
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
    private bq l = null;
    private boolean o = false;
    private boolean p = false;
    private com.baidu.tieba.model.al q = null;
    private com.baidu.tieba.model.af r = null;
    private boolean s = false;
    private bp v = null;
    private bo w = new aw(this);
    private bo x = new bg(this);
    private View.OnClickListener y = new bh(this);
    private di z = new bi(this);
    private View.OnClickListener A = new bj(this);
    private com.baidu.tbadk.imageManager.d B = new bk(this);
    private com.baidu.tbadk.imageManager.d C = new bl(this);
    private SlidingMenu.OnClosedListener D = new bm(this);
    private com.baidu.tieba.view.by E = new bn(this);
    private com.baidu.adp.widget.ScrollView.m F = new ax(this);
    private SlidingMenu.OnOpenedListener G = new ay(this);

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

    @Override // com.baidu.tieba.f
    public boolean getGpuSwitch() {
        return false;
    }

    public static /* synthetic */ void c(FrsImageActivity frsImageActivity) {
        if (UtilHelper.b()) {
            frsImageActivity.l.i();
        } else {
            frsImageActivity.l.h();
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, FrsImageActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str);
            intent.putExtra("from", str2);
            intent.putExtra("add_search", i);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            context.startActivity(intent);
        }
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new bq(this, this.y);
        this.l.f().d();
        int lineWidth = this.l.e().getLineWidth();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(lineWidth, 1073741824), 0);
        this.a = linearLayout.findViewById(R.id.image).getMeasuredWidth();
        this.l.a(this.z);
        this.l.a(this.D);
        this.l.a(this.G);
        this.d = getResources().getDimensionPixelSize(R.dimen.default_size_21);
        this.e = getResources().getDimensionPixelSize(R.dimen.default_size_18);
        this.f = getResources().getDimensionPixelSize(R.dimen.frs_image_block);
        a(FooterType.GONE);
        this.l.e().setOnPullDownListener(this.F);
        this.l.a(this.E);
        this.c = new com.baidu.tieba.util.i(this);
        this.c.a(this.a, 600);
        this.c.f = "_water";
        this.c.g = true;
        this.c.b("frs");
        Intent intent = getIntent();
        this.j = intent.getStringExtra("from");
        this.k = intent.getIntExtra("add_search", 0);
        this.b = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
        if (this.b == null) {
            TiebaApplication.g();
            this.b = TiebaApplication.aF();
        } else {
            TiebaApplication.g();
            TiebaApplication.r(this.b);
        }
        if (bundle != null) {
            this.i = bundle.getInt("current_page");
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        b(this.i);
        this.m = new com.baidu.tieba.model.ae();
        this.n = new com.baidu.tieba.model.k();
        this.n.setLoadDataCallBack(new bb(this));
        this.t = new com.baidu.tieba.model.ar();
        this.t.setLoadDataCallBack(new bc(this));
        this.u = new com.baidu.tieba.model.bx();
        this.u.a(new bd(this));
        String v = TiebaApplication.v();
        if (v != null && v.length() > 0) {
            this.m.a(com.baidu.tieba.mention.v.a().m());
            this.m.c(com.baidu.tieba.mention.v.a().k());
            this.m.b(com.baidu.tieba.mention.v.a().l());
            this.m.d(com.baidu.tieba.mention.v.a().n());
            this.l.a(this.m);
            this.v = new bp(this, (byte) 0);
            com.baidu.tieba.im.messageCenter.d.a().a(-124, this.v);
            this.n.b(true);
        }
        this.o = false;
        com.baidu.tieba.im.c.a.d().b(false, null);
    }

    public final void a() {
        this.l.e().a();
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.l.a(i);
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        String v = TiebaApplication.v();
        if (v != null && v.length() > 0) {
            this.l.f().b(true);
        } else {
            this.l.f().b(false);
        }
        c();
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.c();
        }
    }

    public void a(int i) {
        String v = TiebaApplication.v();
        if (v == null || v.length() <= 0) {
            if (this.q != null && this.q.f() != null) {
                this.q.f().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
            }
        } else if (this.q != null) {
            if (i == 0) {
                WriteActivity.a((Activity) this, this.q.b().getId(), this.q.b().getName(), this.q.f(), false, (String) null);
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
                    String v = TiebaApplication.v();
                    if (v == null || v.length() <= 0) {
                        LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
                        return;
                    }
                    this.t.a("from_frs");
                    this.t.a(this.q.b().getName(), this.q.b().getId());
                    return;
                case 11016:
                    this.l.j().show();
                    return;
                case 11036:
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getString(R.string.attention_cancel_info));
                    builder.setTitle(getString(R.string.alerm_title));
                    builder.setPositiveButton(getString(R.string.attention_cancel), new be(this));
                    builder.setNegativeButton(getString(R.string.cancel), new bf(this));
                    builder.create().show();
                    return;
                case 12001:
                    if (this.q != null && this.q.b() != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.q.b().getId(), this.q.b().getName(), this.q.f());
                        return;
                    }
                    return;
                case 12002:
                    if (this.q != null && this.q.b() != null && intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData(), this.q.b().getId(), this.q.b().getName(), this.q.f());
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.q != null && this.q.b() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a((Activity) this, this.q.b().getId(), this.q.b().getName(), (AntiData) null, true, (String) null);
                            return;
                        } else {
                            WriteActivity.a((Activity) this, this.q.b().getId(), this.q.b().getName(), (AntiData) null, true, intent.getStringExtra("filename"));
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
                    com.baidu.tieba.write.by.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.by.a(this);
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

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.s = intent.getBooleanExtra("refresh_all", false);
        if (this.s) {
            this.l.g().toggle(true);
        }
    }

    public void c() {
        boolean z;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(this);
        this.c.a();
        if (h == UtilHelper.NetworkStateInfo.WIFI || h == UtilHelper.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int c = BdUtilHelper.c(this) * 2;
        com.baidu.tieba.util.i iVar = this.c;
        int p = com.baidu.tieba.data.i.p() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                LinearLayout a = this.l.e().a(i2);
                int childCount = a.getChildCount();
                int b = this.l.e().b(i2);
                int c2 = this.l.e().c(i2);
                if (b >= 0 && c2 >= 0) {
                    int i3 = 0;
                    int i4 = b;
                    int i5 = 0;
                    while (true) {
                        if ((i4 <= c2 || z) && i4 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a.getChildAt(i4);
                            if (frsWaterFallItem != null) {
                                com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) frsWaterFallItem.getTag();
                                i3 += baVar.b().d() * baVar.b().e() * 2;
                                if (i3 > p) {
                                    break;
                                }
                                if (i2 == 1) {
                                    this.c.b(baVar.b().c(), this.B);
                                } else {
                                    this.c.b(baVar.b().c(), this.C);
                                }
                                int d = baVar.b().d() + i5;
                                int i6 = i4 + 1;
                                if (i6 <= c2 || d < c) {
                                    i4 = i6;
                                    i5 = d;
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

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this.v);
        if (this.q != null) {
            this.q.g();
        }
        if (this.n != null) {
            this.n.cancelLoadData();
        }
        this.l.k();
    }

    public static /* synthetic */ View h(FrsImageActivity frsImageActivity) {
        View header2 = frsImageActivity.l.e().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(frsImageActivity).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            com.baidu.tieba.util.bq.b(textView, TiebaApplication.g().ae());
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            frsImageActivity.l.e().a(inflate);
            inflate.setOnClickListener(new ba(frsImageActivity));
            return inflate;
        }
        return header2;
    }

    public void a(FooterType footerType) {
        View view;
        View footer = this.l.e().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.l.e().b(inflate);
            com.baidu.tieba.util.bq.b((TextView) inflate.findViewById(R.id.page_text), TiebaApplication.g().ae());
            inflate.setOnClickListener(new az(this));
            view = inflate;
        } else {
            view = footer;
        }
        TextView textView = (TextView) view.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
        if (footerType == FooterType.NEXT) {
            view.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.LOADING) {
            view.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
        } else if (footerType == FooterType.NORMAL) {
            view.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.NO_ITEM) {
            view.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            view.setVisibility(8);
        }
        this.g = footerType;
        com.baidu.tieba.util.bq.b(textView, this.mSkinType);
    }

    public static /* synthetic */ void p(FrsImageActivity frsImageActivity) {
        if (frsImageActivity.n == null || frsImageActivity.n.e() == null || frsImageActivity.n.e().e() == null) {
            return;
        }
        frsImageActivity.l.f().a(frsImageActivity.n.e().e().a());
    }

    public void b(int i) {
        if (this.q == null) {
            this.q = new com.baidu.tieba.model.al();
        }
        this.q.a(this.j, this.b);
        this.q.a(this.w);
        this.q.a(i);
    }

    public static /* synthetic */ void f(FrsImageActivity frsImageActivity, int i) {
        if (frsImageActivity.q == null || frsImageActivity.q.d().size() <= i || frsImageActivity.g != FooterType.NORMAL) {
            return;
        }
        frsImageActivity.q.a(frsImageActivity.j, frsImageActivity.b);
        frsImageActivity.q.b(frsImageActivity.x);
        frsImageActivity.q.b(i);
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.l.g().isMenuShowing()) {
                this.l.g().toggle(true);
                if (this.o) {
                    this.o = false;
                    b(1);
                    return true;
                }
                return true;
            }
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void b() {
        this.l.k();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    public static /* synthetic */ void a(FrsImageActivity frsImageActivity, String str) {
        Intent a;
        if (str == null || (a = FrsActivity.a(frsImageActivity, str)) == null) {
            return;
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + frsImageActivity.getString(R.string.bar));
        intent.putExtra("android.intent.extra.shortcut.INTENT", a);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(frsImageActivity, R.drawable.icon));
        frsImageActivity.sendBroadcast(intent);
        frsImageActivity.showToast(frsImageActivity.getString(R.string.add_to_window_succ));
        new com.baidu.tieba.account.ax("add_to_launcher").start();
    }

    public static /* synthetic */ void a(FrsImageActivity frsImageActivity, ArrayList arrayList) {
        int i;
        if (arrayList == null) {
            return;
        }
        try {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) arrayList.get(i2);
                if (baVar != null) {
                    int a = baVar.b().a();
                    int b = baVar.b().b();
                    if (a >= 100 && b >= 50) {
                        if (a > frsImageActivity.a) {
                            float f = frsImageActivity.a / a;
                            a = frsImageActivity.a;
                            b = (int) (b * f);
                        }
                        if (b > 600) {
                            i = (int) ((600.0f / b) * a);
                            b = 600;
                        } else {
                            i = a;
                        }
                        Bitmap a2 = com.baidu.tieba.util.n.a((int) R.drawable.image_default);
                        int height = b < a2.getHeight() ? a2.getHeight() : b;
                        FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(frsImageActivity).inflate(R.layout.water_fall_item, (ViewGroup) null);
                        frsWaterFallItem.a(frsImageActivity.mSkinType);
                        TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(R.id.image);
                        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                        layoutParams.height = height;
                        tbImageView.setLayoutParams(layoutParams);
                        frsWaterFallItem.setTag(baVar);
                        tbImageView.setImageSearchUrl(String.valueOf(baVar.b().c()) + "_water");
                        tbImageView.setDefaultResource(R.drawable.pic_baidu_logo_d);
                        tbImageView.setNightDefaultResource(R.drawable.pic_baidu_logo_d_1);
                        tbImageView.setTag(baVar.b().c());
                        frsWaterFallItem.setOnClickListener(frsImageActivity.A);
                        int a3 = BdUtilHelper.a((Context) frsImageActivity, 1.0f);
                        int paddingBottom = height + (frsImageActivity.f * 2) + frsWaterFallItem.getPaddingBottom();
                        frsWaterFallItem.a(frsImageActivity.d, frsImageActivity.e, a3, frsImageActivity.f);
                        frsImageActivity.l.e().a(frsWaterFallItem, paddingBottom);
                        baVar.b().a(paddingBottom);
                        baVar.b().b(i);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(frsImageActivity.getClass().getName(), "setData", e.getMessage());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.l.f().e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().ae() != 1) {
                    com.baidu.tieba.util.cb.a(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    TiebaApplication.g().e(1);
                    this.mSkinType = 1;
                    onChangeSkinType(this.mSkinType);
                    new com.baidu.tieba.account.ax("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().ae() != 0) {
                TiebaApplication.g().e(0);
                this.mSkinType = 0;
                onChangeSkinType(this.mSkinType);
            } else {
                return;
            }
            com.baidu.tieba.util.n.a();
        }
    }

    public static /* synthetic */ void a(FrsImageActivity frsImageActivity, com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.e.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            int c = vVar.c();
            int a = vVar.a();
            int b = vVar.b();
            int d = vVar.d();
            if (frsImageActivity.m != null) {
                frsImageActivity.m.a(c);
                frsImageActivity.m.c(a);
                frsImageActivity.m.b(b);
                frsImageActivity.m.d(d);
                frsImageActivity.l.a(frsImageActivity.m);
            }
        }
    }
}
