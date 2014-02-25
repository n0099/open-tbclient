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
import com.baidu.tieba.util.cb;
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
    private bp l = null;
    private boolean o = false;
    private boolean p = false;
    private com.baidu.tieba.model.al q = null;
    private com.baidu.tieba.model.af r = null;
    private boolean s = false;
    private bo v = null;
    private bn w = new av(this);
    private bn x = new bf(this);
    private View.OnClickListener y = new bg(this);
    private di z = new bh(this);
    private View.OnClickListener A = new bi(this);
    private com.baidu.tbadk.imageManager.d B = new bj(this);
    private com.baidu.tbadk.imageManager.d C = new bk(this);
    private SlidingMenu.OnClosedListener D = new bl(this);
    private com.baidu.tieba.view.by E = new bm(this);
    private com.baidu.adp.widget.ScrollView.m F = new aw(this);
    private SlidingMenu.OnOpenedListener G = new ax(this);

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
        e();
        a(bundle);
        com.baidu.tieba.im.c.a.f().b(false, null);
    }

    private void e() {
        this.l = new bp(this, this.y);
        this.l.f().e();
        b(this.l.e().getLineWidth());
        this.l.a(this.z);
        this.l.a(this.D);
        this.l.a(this.G);
        this.d = getResources().getDimensionPixelSize(R.dimen.default_size_21);
        this.e = getResources().getDimensionPixelSize(R.dimen.default_size_18);
        this.f = getResources().getDimensionPixelSize(R.dimen.frs_image_block);
        a(FooterType.GONE);
        this.l.e().setOnPullDownListener(this.F);
        this.l.a(this.E);
    }

    public void a(String str) {
        this.l.e().c();
    }

    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.l.a(i);
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            this.l.f().b(true);
        } else {
            this.l.f().b(false);
        }
        g();
    }

    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.d();
        }
    }

    public void a(int i) {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
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
                    b();
                    return;
                case 11016:
                    this.l.j().show();
                    return;
                case 11036:
                    c();
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
                    com.baidu.tieba.write.bz.b(this);
                    return;
                case 12010:
                    com.baidu.tieba.write.bz.a(this);
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
            f();
        }
    }

    private void f() {
        this.l.g().toggle(true);
    }

    public void g() {
        boolean z;
        UtilHelper.NetworkStateInfo h = UtilHelper.h(this);
        this.c.a();
        if (h == UtilHelper.NetworkStateInfo.WIFI || h == UtilHelper.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int c = BdUtilHelper.c(this) * 2;
        this.c.a(z);
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

    private void b(int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.a = linearLayout.findViewById(R.id.image).getMeasuredWidth();
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        n();
        if (this.q != null) {
            this.q.g();
        }
        if (this.n != null) {
            this.n.cancelLoadData();
        }
        this.l.k();
    }

    private View h() {
        View footer = this.l.e().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            this.l.e().b(inflate);
            com.baidu.tieba.util.bq.b((TextView) inflate.findViewById(R.id.page_text), TiebaApplication.g().al());
            inflate.setOnClickListener(new ay(this));
            return inflate;
        }
        return footer;
    }

    public View i() {
        View header2 = this.l.e().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.page_text);
            textView.setText(R.string.pre_page);
            textView.setVisibility(0);
            com.baidu.tieba.util.bq.b(textView, TiebaApplication.g().al());
            ((ProgressBar) inflate.findViewById(R.id.progress)).setVisibility(8);
            this.l.e().a(inflate);
            inflate.setOnClickListener(new az(this));
            return inflate;
        }
        return header2;
    }

    public void j() {
        this.l.e().h();
    }

    public void a(FooterType footerType) {
        View h = h();
        TextView textView = (TextView) h.findViewById(R.id.page_text);
        ProgressBar progressBar = (ProgressBar) h.findViewById(R.id.progress);
        if (footerType == FooterType.NEXT) {
            h.setVisibility(0);
            textView.setText(R.string.next_page);
            textView.setVisibility(0);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.LOADING) {
            h.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(0);
        } else if (footerType == FooterType.NORMAL) {
            h.setVisibility(0);
            textView.setVisibility(4);
            progressBar.setVisibility(4);
        } else if (footerType == FooterType.NO_ITEM) {
            h.setVisibility(0);
            textView.setText(R.string.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            h.setVisibility(8);
        }
        this.g = footerType;
        com.baidu.tieba.util.bq.b(textView, this.mSkinType);
    }

    private void a(Bundle bundle) {
        this.c = new com.baidu.tieba.util.i(this);
        this.c.a(this.a, 600);
        this.c.b("_water");
        this.c.c(true);
        this.c.f("frs");
        Intent intent = getIntent();
        this.j = intent.getStringExtra("from");
        this.k = intent.getIntExtra("add_search", 0);
        this.b = intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME);
        if (this.b == null) {
            this.b = TiebaApplication.g().aN();
        } else {
            TiebaApplication.g().r(this.b);
        }
        if (bundle != null) {
            this.i = bundle.getInt("current_page");
        }
        if (this.i < 1) {
            this.i = 1;
        }
        c(this.i);
        this.m = new com.baidu.tieba.model.ae(this);
        this.n = new com.baidu.tieba.model.k();
        this.n.setLoadDataCallBack(new ba(this));
        this.t = new com.baidu.tieba.model.ar();
        this.t.setLoadDataCallBack(new bb(this));
        this.u = new com.baidu.tieba.model.bx();
        this.u.a(new bc(this));
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            k();
            m();
            this.n.b(true);
        }
        this.o = false;
    }

    private void k() {
        this.m.a(com.baidu.tieba.mention.v.a().o());
        this.m.c(com.baidu.tieba.mention.v.a().m());
        this.m.b(com.baidu.tieba.mention.v.a().n());
        this.m.d(com.baidu.tieba.mention.v.a().p());
        this.l.a(this.m);
    }

    public void l() {
        if (this.n != null && this.n.a() != null && this.n.a().e() != null) {
            this.l.f().a(this.n.a().e().a());
        }
    }

    private void m() {
        this.v = new bo(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.v);
    }

    private void n() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.v);
    }

    public void c(int i) {
        if (this.q == null) {
            this.q = new com.baidu.tieba.model.al();
        }
        this.q.a(this.j, this.b);
        this.q.a(this.w);
        this.q.a(i);
    }

    public void d(int i) {
        if (this.q != null && this.q.d().size() > i && this.g == FooterType.NORMAL) {
            this.q.a(this.j, this.b);
            this.q.b(this.x);
            this.q.b(i);
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.l.g().isMenuShowing()) {
                this.l.g().toggle(true);
                if (this.o) {
                    this.o = false;
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

    public void a() {
        this.l.k();
        finish();
        CompatibleUtile.setAnim(this, R.anim.frs_browser_enter, R.anim.no_effect);
    }

    public void b(String str) {
        Intent a;
        if (str != null && (a = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(R.string.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
            sendBroadcast(intent);
            showToast(getString(R.string.add_to_window_succ));
            new com.baidu.tieba.account.ax("add_to_launcher").start();
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.ba> arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.data.ba baVar = arrayList.get(i2);
                    if (baVar != null) {
                        int a = baVar.b().a();
                        int b = baVar.b().b();
                        if (a >= 100 && b >= 50) {
                            if (a > this.a) {
                                float f = this.a / a;
                                a = this.a;
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
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(R.layout.water_fall_item, (ViewGroup) null);
                            frsWaterFallItem.a(this.mSkinType);
                            TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(R.id.image);
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = height;
                            tbImageView.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(baVar);
                            tbImageView.setImageSearchUrl(String.valueOf(baVar.b().c()) + "_water");
                            tbImageView.setDefaultResource(R.drawable.pic_baidu_logo_d);
                            tbImageView.setNightDefaultResource(R.drawable.pic_baidu_logo_d_1);
                            tbImageView.setTag(baVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.A);
                            int a3 = BdUtilHelper.a((Context) this, 1.0f);
                            int paddingBottom = height + (this.f * 2) + frsWaterFallItem.getPaddingBottom();
                            frsWaterFallItem.a(this.d, this.e, a3, this.f);
                            this.l.e().a(frsWaterFallItem, paddingBottom);
                            baVar.b().a(paddingBottom);
                            baVar.b().b(i);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "setData", e.getMessage());
            }
        }
    }

    protected void b() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11002);
            return;
        }
        this.t.a("from_frs");
        this.t.a(this.q.b().getName(), this.q.b().getId());
    }

    protected void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.attention_cancel_info));
        builder.setTitle(getString(R.string.alerm_title));
        builder.setPositiveButton(getString(R.string.attention_cancel), new bd(this));
        builder.setNegativeButton(getString(R.string.cancel), new be(this));
        builder.create().show();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.l.f().f()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().al() != 1) {
                    cb.a(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    TiebaApplication.g().e(1);
                    this.mSkinType = 1;
                    onChangeSkinType(this.mSkinType);
                    new com.baidu.tieba.account.ax("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().al() != 0) {
                TiebaApplication.g().e(0);
                this.mSkinType = 0;
                onChangeSkinType(this.mSkinType);
            } else {
                return;
            }
            com.baidu.tieba.util.n.a();
        }
    }

    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            com.baidu.tieba.im.message.v vVar = (com.baidu.tieba.im.message.v) sVar;
            int c = vVar.c();
            int a = vVar.a();
            int b = vVar.b();
            int d = vVar.d();
            if (this.m != null) {
                this.m.a(c);
                this.m.c(a);
                this.m.b(b);
                this.m.d(d);
                this.l.a(this.m);
            }
        }
    }
}
