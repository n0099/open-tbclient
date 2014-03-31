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
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.view.FrsWaterFallItem;
import com.baidu.tieba.person.PersonInfoActivity;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.BdSwitchView.c {
    private cu m;
    private com.baidu.tieba.model.o n;
    private com.baidu.tieba.model.af t;
    private com.baidu.tieba.model.bc u;
    private int a = 0;
    private String b = null;
    private com.baidu.tbadk.core.util.b c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private FooterType g = FooterType.GONE;
    private int h = 0;
    private int i = 1;
    private String j = null;
    private int k = 0;
    private cj l = null;
    private boolean o = false;
    private boolean p = false;
    private cy q = null;
    private cv r = null;
    private boolean s = false;
    private int v = 0;
    private int w = 0;
    private final ci x = new bo(this);
    private final ci y = new bz(this);
    private final View.OnClickListener z = new cc(this);
    private final com.baidu.tieba.frs.view.u A = new cd(this);
    private final View.OnClickListener B = new ce(this);
    private final com.baidu.tbadk.imageManager.d C = new cf(this);
    private final com.baidu.tbadk.imageManager.d D = new cg(this);
    private final SlidingMenu.OnClosedListener E = new ch(this);
    private final com.baidu.tbadk.core.view.m F = new bp(this);
    private final com.baidu.adp.widget.ScrollView.m G = new bq(this);
    private final SlidingMenu.OnOpenedListener H = new br(this);
    private final com.baidu.adp.framework.c.a I = new bs(this, 2001124);

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

    @Override // com.baidu.tbadk.a
    public boolean getGpuSwitch() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(FrsImageActivity frsImageActivity) {
        if (UtilHelper.a()) {
            frsImageActivity.l.o();
        } else {
            frsImageActivity.l.n();
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003002, new cb());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = new cj(this, this.z);
        this.l.l().d();
        int lineWidth = this.l.k().getLineWidth();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(com.baidu.tieba.a.i.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(lineWidth, 1073741824), 0);
        this.a = linearLayout.findViewById(com.baidu.tieba.a.h.image).getMeasuredWidth();
        this.l.a(this.A);
        this.l.a(this.E);
        this.l.a(this.H);
        this.d = getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_size_21);
        this.e = getResources().getDimensionPixelSize(com.baidu.tieba.a.f.default_size_18);
        this.f = getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_image_block);
        a(FooterType.GONE);
        this.l.k().setOnPullDownListener(this.G);
        this.l.a(this.F);
        this.v = com.baidu.adp.lib.util.i.b(this);
        this.w = com.baidu.adp.lib.util.i.c(this);
        this.c = new com.baidu.tbadk.core.util.b(this);
        this.c.a(this.a, 600);
        this.c.f = "_water";
        this.c.g = true;
        this.c.b("frs");
        Intent intent = getIntent();
        this.j = intent.getStringExtra("from");
        this.k = intent.getIntExtra("add_search", 0);
        this.b = intent.getStringExtra(PersonInfoActivity.TAG_NAME);
        if (this.b == null) {
            TbadkApplication.j();
            this.b = TbadkApplication.af();
        } else {
            TbadkApplication.j();
            TbadkApplication.l(this.b);
            this.l.a(this.b);
        }
        if (bundle != null) {
            this.i = bundle.getInt("current_page");
        }
        if (this.i <= 0) {
            this.i = 1;
        }
        b(this.i);
        this.m = new cu();
        this.n = new com.baidu.tieba.model.o();
        this.n.setLoadDataCallBack(new bv(this));
        this.t = new com.baidu.tieba.model.af();
        this.t.setLoadDataCallBack(new bw(this));
        this.u = new com.baidu.tieba.model.bc();
        this.u.a(new bx(this));
        String E = TbadkApplication.E();
        if (E != null && E.length() > 0) {
            this.m.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
            this.m.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().i());
            this.m.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().j());
            this.m.d(com.baidu.tbadk.coreExtra.messageCenter.a.a().l());
            this.l.a(this.m);
            registerListener(this.I);
            this.n.b(true);
        }
        this.o = false;
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2007001, new com.baidu.tbadk.core.b.w(this, false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.l.k().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.l.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.c != null) {
            this.c.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            if (this.q != null && this.q.f() != null) {
                this.q.f().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11016);
            }
        } else if (this.q != null) {
            if (i == 0) {
                if (this.q.f() != null && this.q.f().getIfpost() == 0) {
                    com.baidu.adp.lib.util.i.a((Context) this, this.q.f().getForbid_info());
                    return;
                }
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.av(this, 0, this.q.b().getId(), this.q.b().getName(), null, null, 0, this.q.f(), 13003, false, false, null, false, false, null, null, null)));
                return;
            }
            this.l.p().show();
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
                    String E = TbadkApplication.E();
                    if (E == null || E.length() <= 0) {
                        LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, 11002);
                        return;
                    }
                    this.t.a("from_frs");
                    this.t.a(this.q.b().getName(), this.q.b().getId());
                    return;
                case 11016:
                    this.l.p().show();
                    return;
                case 11036:
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(getString(com.baidu.tieba.a.k.attention_cancel_info));
                    builder.setTitle(getString(com.baidu.tieba.a.k.alerm_title));
                    builder.setPositiveButton(getString(com.baidu.tieba.a.k.attention_cancel), new by(this));
                    builder.setNegativeButton(getString(com.baidu.tieba.a.k.cancel), new ca(this));
                    builder.create().show();
                    return;
                case 12001:
                    if (this.q != null && this.q.b() != null) {
                        if (this.q.f() != null && this.q.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.i.a((Context) this, this.q.f().getForbid_info());
                            return;
                        }
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.aw(this, 12001, 12010, null, this.q.b().getId(), this.q.b().getName(), this.q.f())));
                        return;
                    }
                    return;
                case 12002:
                    if (this.q != null && this.q.b() != null && intent != null && intent.getData() != null) {
                        if (this.q.f() != null && this.q.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.i.a((Context) this, this.q.f().getForbid_info());
                            return;
                        }
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.aw(this, 12002, 12009, intent.getData(), this.q.b().getId(), this.q.b().getName(), this.q.f())));
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.q != null && this.q.b() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.av(this, 0, this.q.b().getId(), this.q.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, null, null, null)));
                            return;
                        }
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.av(this, 0, this.q.b().getId(), this.q.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, intent.getStringExtra("filename"), null, null)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tbadk.core.util.az.b(this);
                    return;
                case 12010:
                    com.baidu.tbadk.core.util.az.a(this);
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
            this.l.m().toggle(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        boolean z;
        UtilHelper.NetworkStateInfo d = UtilHelper.d(this);
        this.c.a();
        if (d == UtilHelper.NetworkStateInfo.WIFI || d == UtilHelper.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int c = com.baidu.adp.lib.util.i.c(this) * 2;
        com.baidu.tbadk.core.util.b bVar = this.c;
        int i = com.baidu.tbadk.core.data.n.i() >> 1;
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 <= 2) {
                LinearLayout a = this.l.k().a(i3);
                int childCount = a.getChildCount();
                int b = this.l.k().b(i3);
                int c2 = this.l.k().c(i3);
                if (b >= 0 && c2 >= 0) {
                    int i4 = 0;
                    int i5 = b;
                    int i6 = 0;
                    while (true) {
                        if ((i5 <= c2 || z) && i5 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a.getChildAt(i5);
                            if (frsWaterFallItem != null) {
                                com.baidu.tieba.data.ar arVar = (com.baidu.tieba.data.ar) frsWaterFallItem.getTag();
                                i4 += arVar.b().d() * arVar.b().e() * 2;
                                if (i4 > i) {
                                    break;
                                }
                                if (i3 == 1) {
                                    this.c.b(arVar.b().c(), this.C);
                                } else {
                                    this.c.b(arVar.b().c(), this.D);
                                }
                                int d2 = arVar.b().d() + i6;
                                int i7 = i5 + 1;
                                if (i7 <= c2 || d2 < c) {
                                    i5 = i7;
                                    i6 = d2;
                                }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.q != null) {
            this.q.g();
        }
        if (this.n != null) {
            this.n.cancelLoadData();
        }
        this.l.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ View g(FrsImageActivity frsImageActivity) {
        View header2 = frsImageActivity.l.k().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(frsImageActivity).inflate(com.baidu.tieba.a.i.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.a.h.page_text);
            textView.setText(com.baidu.tieba.a.k.pre_page);
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.ba.b(textView, TbadkApplication.j().l());
            ((ProgressBar) inflate.findViewById(com.baidu.tieba.a.h.progress)).setVisibility(8);
            frsImageActivity.l.k().a(inflate);
            inflate.setOnClickListener(new bu(frsImageActivity));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FooterType footerType) {
        View view;
        View footer = this.l.k().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.tieba.a.i.water_page, (ViewGroup) null);
            this.l.k().b(inflate);
            com.baidu.tbadk.core.util.ba.b((TextView) inflate.findViewById(com.baidu.tieba.a.h.page_text), TbadkApplication.j().l());
            inflate.setOnClickListener(new bt(this));
            view = inflate;
        } else {
            view = footer;
        }
        TextView textView = (TextView) view.findViewById(com.baidu.tieba.a.h.page_text);
        ProgressBar progressBar = (ProgressBar) view.findViewById(com.baidu.tieba.a.h.progress);
        if (footerType == FooterType.NEXT) {
            view.setVisibility(0);
            textView.setText(com.baidu.tieba.a.k.next_page);
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
            textView.setText(com.baidu.tieba.a.k.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            view.setVisibility(8);
        }
        this.g = footerType;
        com.baidu.tbadk.core.util.ba.b(textView, this.mSkinType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(FrsImageActivity frsImageActivity) {
        if (frsImageActivity.n == null || frsImageActivity.n.e() == null || frsImageActivity.n.e().f() == null) {
            return;
        }
        frsImageActivity.l.l().b(frsImageActivity.n.e().f().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.q == null) {
            this.q = new cy();
        }
        this.q.a(this.j, this.b);
        this.q.a(this.x);
        this.q.a(i, this.v, this.w);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(FrsImageActivity frsImageActivity, int i) {
        if (frsImageActivity.q == null || frsImageActivity.q.d().size() <= i || frsImageActivity.g != FooterType.NORMAL) {
            return;
        }
        frsImageActivity.q.a(frsImageActivity.j, frsImageActivity.b);
        frsImageActivity.q.b(frsImageActivity.y);
        frsImageActivity.q.a(i);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.l.m().isMenuShowing()) {
                this.l.m().toggle(true);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.l.q();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.a.b.frs_browser_enter, com.baidu.tieba.a.b.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsImageActivity frsImageActivity, String str) {
        Intent a;
        if (str == null || (a = FrsActivity.a(frsImageActivity, str)) == null) {
            return;
        }
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + frsImageActivity.getString(com.baidu.tieba.a.k.bar));
        intent.putExtra("android.intent.extra.shortcut.INTENT", a);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(frsImageActivity, com.baidu.tieba.a.g.icon));
        frsImageActivity.sendBroadcast(intent);
        frsImageActivity.showToast(frsImageActivity.getString(com.baidu.tieba.a.k.add_to_window_succ));
        new com.baidu.tbadk.core.util.ax("add_to_launcher").start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsImageActivity frsImageActivity, ArrayList arrayList) {
        int i;
        if (arrayList == null) {
            return;
        }
        try {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.tieba.data.ar arVar = (com.baidu.tieba.data.ar) arrayList.get(i2);
                if (arVar != null) {
                    int a = arVar.b().a();
                    int b = arVar.b().b();
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
                        Bitmap a2 = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.image_default);
                        int height = b < a2.getHeight() ? a2.getHeight() : b;
                        FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(frsImageActivity).inflate(com.baidu.tieba.a.i.water_fall_item, (ViewGroup) null);
                        frsWaterFallItem.a(frsImageActivity.mSkinType);
                        TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(com.baidu.tieba.a.h.image);
                        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                        layoutParams.height = height;
                        tbImageView.setLayoutParams(layoutParams);
                        frsWaterFallItem.setTag(arVar);
                        tbImageView.setImageSearchUrl(String.valueOf(arVar.b().c()) + "_water");
                        tbImageView.setDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d);
                        tbImageView.setNightDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
                        tbImageView.setTag(arVar.b().c());
                        frsWaterFallItem.setOnClickListener(frsImageActivity.B);
                        int a3 = com.baidu.adp.lib.util.i.a((Context) frsImageActivity, 1.0f);
                        int paddingBottom = height + (frsImageActivity.f * 2) + frsWaterFallItem.getPaddingBottom();
                        frsWaterFallItem.a(frsImageActivity.d, frsImageActivity.e, a3, frsImageActivity.f);
                        frsImageActivity.l.k().a(frsWaterFallItem, paddingBottom);
                        arVar.b().a(paddingBottom);
                        arVar.b().b(i);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(frsImageActivity.getClass().getName(), "setData", e.getMessage());
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.l.l().e()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkApplication.j().l() != 1) {
                    TiebaStatic.a(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    com.baidu.tieba.r.c().c(1);
                    this.mSkinType = 1;
                    onChangeSkinType(this.mSkinType);
                    new com.baidu.tbadk.core.util.ax("eyeshield").start();
                } else {
                    return;
                }
            } else if (TbadkApplication.j().l() != 0) {
                com.baidu.tieba.r.c().c(0);
                this.mSkinType = 0;
                onChangeSkinType(this.mSkinType);
            } else {
                return;
            }
            com.baidu.tbadk.core.util.g.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FrsImageActivity frsImageActivity, com.baidu.adp.framework.message.f fVar) {
        if (fVar != null) {
            if (!(fVar instanceof NewsNotifyMessage)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) fVar;
            int d = newsNotifyMessage.d();
            int b = newsNotifyMessage.b();
            int c = newsNotifyMessage.c();
            int i = newsNotifyMessage.i();
            if (frsImageActivity.m != null) {
                frsImageActivity.m.a(d);
                frsImageActivity.m.c(b);
                frsImageActivity.m.b(c);
                frsImageActivity.m.d(i);
                frsImageActivity.l.a(frsImageActivity.m);
            }
        }
    }
}
