package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.view.FrsWaterFallItem;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FrsImageActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    public static boolean a = true;
    public static boolean b = true;
    private Context A;
    private df o;
    private com.baidu.tieba.model.m p;
    private com.baidu.tieba.model.ae v;
    private com.baidu.tieba.model.be w;
    private co x;
    private int d = 0;
    private String e = null;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private FooterType i = FooterType.GONE;
    private int j = 0;
    private int k = 1;
    private String l = null;
    private int m = 0;
    private cq n = null;
    private boolean q = false;
    private boolean r = false;
    private dj s = null;
    private dg t = null;
    private boolean u = false;
    private int y = 0;
    private int z = 0;
    private final cp B = new bv(this);
    private final cp C = new cg(this);
    public final CustomMessageListener c = new ci(this, 2012111);
    private final View.OnClickListener D = new cj(this);
    private final com.baidu.tieba.frs.view.r E = new ck(this);
    private final View.OnClickListener F = new cl(this);
    private final SlidingMenu.OnClosedListener G = new cm(this);
    private final com.baidu.tbadk.core.view.m H = new cn(this);
    private final com.baidu.adp.widget.ScrollView.m I = new bw(this);
    private final SlidingMenu.OnOpenedListener J = new bx(this);
    private final CustomMessageListener K = new by(this, 2001124);

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

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003002, new ch());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (UtilHelper.isNetOk()) {
            this.n.p();
        } else {
            this.n.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.A = this;
        e();
        a(bundle);
        registerListener(this.c);
        MessageManager.getInstance().sendMessage(new CustomMessage(2007001, new com.baidu.tbadk.core.atomData.ae(this, false)));
    }

    private void e() {
        this.n = new cq(this, this.D);
        this.n.m().b();
        b(this.n.l().getLineWidth());
        this.n.a(this.E);
        this.n.a(this.G);
        this.n.a(this.J);
        this.f = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_size_21);
        this.g = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_size_18);
        this.h = getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_image_block);
        a(FooterType.GONE);
        this.n.l().setOnPullDownListener(this.I);
        this.n.a(this.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.n.l().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.n.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.s != null && this.s.f() != null) {
                this.s.f().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11016);
            }
        } else if (this.s != null) {
            if (i == 0) {
                if (this.s.f() != null && this.s.f().getIfpost() == 0) {
                    com.baidu.adp.lib.util.j.a((Context) this, this.s.f().getForbid_info());
                    return;
                } else if (this.s.b() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bv(this, 0, this.s.b().getId(), this.s.b().getName(), null, null, 0, this.s.f(), 13003, false, false, null, false, false, null, null, null, 0)));
                    return;
                } else {
                    return;
                }
            }
            this.n.q().show();
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
                    this.n.q().show();
                    return;
                case 11036:
                    c();
                    return;
                case 12001:
                    if (this.s != null && this.s.b() != null) {
                        if (this.s.f() != null && this.s.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.j.a((Context) this, this.s.f().getForbid_info());
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bw(this, 12001, 12010, null, this.s.b().getId(), this.s.b().getName(), this.s.f())));
                        return;
                    }
                    return;
                case 12002:
                    if (this.s != null && this.s.b() != null && intent != null && intent.getData() != null) {
                        if (this.s.f() != null && this.s.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.j.a((Context) this, this.s.f().getForbid_info());
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bw(this, 12002, 12009, intent.getData(), this.s.b().getId(), this.s.b().getName(), this.s.f())));
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.s != null && this.s.b() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bv(this, 0, this.s.b().getId(), this.s.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, null, null, null, 0)));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bv(this, 0, this.s.b().getId(), this.s.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, intent.getStringExtra("filename"), null, null, 0)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tbadk.core.util.bj.b(this);
                    return;
                case 12010:
                    com.baidu.tbadk.core.util.bj.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.k = bundle.getInt("current_page");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_page", this.k);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.u = intent.getBooleanExtra("refresh_all", false);
        if (this.u) {
            f();
        }
    }

    private void f() {
        this.n.n().toggle(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        boolean z;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this);
        if (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI || netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int c = com.baidu.adp.lib.util.j.c(this) * 2;
        int bigImageMaxUsedMemory = TbConfig.getBigImageMaxUsedMemory() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                LinearLayout a2 = this.n.l().a(i2);
                int childCount = a2.getChildCount();
                int b2 = this.n.l().b(i2);
                int c2 = this.n.l().c(i2);
                if (b2 >= 0 && c2 >= 0) {
                    int i3 = b2;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if ((i3 <= c2 || z) && i3 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a2.getChildAt(i3);
                            if (frsWaterFallItem != null) {
                                com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) frsWaterFallItem.getTag();
                                int d = (awVar.b().d() * awVar.b().e() * 2) + i4;
                                if (d <= bigImageMaxUsedMemory) {
                                    String c3 = awVar.b().c();
                                    if (i2 == 1) {
                                        View findViewWithTag = this.n.l().a(1).findViewWithTag(c3);
                                        if (findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
                                            ((TbImageView) findViewWithTag).a(c3, 22, false);
                                        }
                                    } else {
                                        View findViewWithTag2 = this.n.l().a(2).findViewWithTag(c3);
                                        if (findViewWithTag2 != null && (findViewWithTag2 instanceof TbImageView)) {
                                            ((TbImageView) findViewWithTag2).a(c3, 22, false);
                                        }
                                    }
                                    int d2 = awVar.b().d() + i5;
                                    int i6 = i3 + 1;
                                    if (i6 <= c2 || d2 < c) {
                                        i5 = d2;
                                        i3 = i6;
                                        i4 = d;
                                    }
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.d = linearLayout.findViewById(com.baidu.tieba.v.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.s != null) {
            this.s.h();
        }
        if (this.p != null) {
            this.p.cancelLoadData();
        }
        this.n.r();
        if (this.x != null) {
            this.x.cancel(true);
            this.x = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String str2;
        String str3 = Build.MODEL;
        if (!TextUtils.isEmpty(str3) && str3.startsWith("MI")) {
            str2 = "content://com.miui.home.launcher.settings/favorites?notify=true";
        } else if (!TextUtils.isEmpty(str3) && str3.equals("MT788")) {
            str2 = "content://com.motorola.mmsp.motohomex.settings/favorites?notify=true";
        } else if (Build.VERSION.SDK_INT < 8) {
            str2 = "content://com.android.launcher.settings/favorites?notify=true";
        } else {
            str2 = "content://com.android.launcher2.settings/favorites?notify=true";
        }
        Cursor query = getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{String.valueOf(str) + getString(com.baidu.tieba.y.bar)}, null);
        return query != null && query.getCount() > 0;
    }

    private View h() {
        View footer = this.n.l().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_page, (ViewGroup) null);
            this.n.l().b(inflate);
            com.baidu.tbadk.core.util.bk.b((TextView) inflate.findViewById(com.baidu.tieba.v.page_text), TbadkApplication.m252getInst().getSkinType());
            inflate.setOnClickListener(new bz(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View i() {
        View header2 = this.n.l().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.page_text);
            textView.setText(com.baidu.tieba.y.pre_page);
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.bk.b(textView, TbadkApplication.m252getInst().getSkinType());
            ((ProgressBar) inflate.findViewById(com.baidu.tieba.v.progress)).setVisibility(8);
            this.n.l().a(inflate);
            inflate.setOnClickListener(new ca(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.n.l().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FooterType footerType) {
        View h = h();
        TextView textView = (TextView) h.findViewById(com.baidu.tieba.v.page_text);
        ProgressBar progressBar = (ProgressBar) h.findViewById(com.baidu.tieba.v.progress);
        if (footerType == FooterType.NEXT) {
            h.setVisibility(0);
            textView.setText(com.baidu.tieba.y.next_page);
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
            textView.setText(com.baidu.tieba.y.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            h.setVisibility(8);
        }
        this.i = footerType;
        com.baidu.tbadk.core.util.bk.b(textView, this.mSkinType);
    }

    private void a(Bundle bundle) {
        this.y = com.baidu.adp.lib.util.j.b(this);
        this.z = com.baidu.adp.lib.util.j.c(this);
        Intent intent = getIntent();
        this.l = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
        this.m = intent.getIntExtra("add_search", 0);
        this.e = intent.getStringExtra("name");
        if (this.e == null) {
            this.e = TbadkApplication.m252getInst().getForumName();
        } else {
            TbadkApplication.m252getInst().setForumName(this.e);
            this.n.a(this.e);
        }
        if (bundle != null) {
            this.k = bundle.getInt("current_page");
        }
        if (this.k < 1) {
            this.k = 1;
        }
        c(this.k);
        this.o = new df(this);
        this.p = new com.baidu.tieba.model.m();
        this.p.setLoadDataCallBack(new cb(this));
        this.v = new com.baidu.tieba.model.ae();
        this.v.setLoadDataCallBack(new cc(this));
        this.w = new com.baidu.tieba.model.be();
        this.w.a(new cd(this));
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            k();
            m();
            this.p.b(true);
        }
        this.q = false;
    }

    private void k() {
        this.o.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
        this.o.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().l());
        this.o.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
        this.n.a(this.o, a, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.p != null && this.p.e() != null && this.p.e().g() != null) {
            this.n.m().b(this.p.e().g().a());
        }
    }

    private void m() {
        registerListener(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.s == null) {
            this.s = new dj();
        }
        this.s.a(this.l, this.e);
        this.s.a(this.B);
        this.s.a(i, this.y, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.s != null && this.s.d().size() > i && this.i == FooterType.NORMAL) {
            this.s.a(this.l, this.e);
            this.s.b(this.C);
            this.s.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.n.n().isMenuShowing()) {
                this.n.n().toggle(true);
                if (this.q) {
                    this.q = false;
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
        this.n.r();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.p.frs_browser_enter, com.baidu.tieba.p.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent a2;
        if (str != null && (a2 = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(com.baidu.tieba.y.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.u.icon));
            sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.tieba.data.aw> arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.data.aw awVar = arrayList.get(i2);
                    if (awVar != null) {
                        int a2 = awVar.b().a();
                        int b2 = awVar.b().b();
                        if (a2 >= 100 && b2 >= 50) {
                            if (a2 > this.d) {
                                float f = this.d / a2;
                                a2 = this.d;
                                b2 = (int) (b2 * f);
                            }
                            if (b2 > 600) {
                                i = (int) ((600.0f / b2) * a2);
                                b2 = 600;
                            } else {
                                i = a2;
                            }
                            Bitmap a3 = com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.image_default);
                            int height = b2 < a3.getHeight() ? a3.getHeight() : b2;
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_fall_item, (ViewGroup) null);
                            frsWaterFallItem.a(this.mSkinType);
                            TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(com.baidu.tieba.v.image);
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = height;
                            tbImageView.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(awVar);
                            tbImageView.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d);
                            tbImageView.setNightDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d_1);
                            tbImageView.setTag(awVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.F);
                            int a4 = com.baidu.adp.lib.util.j.a((Context) this, 1.0f);
                            int paddingBottom = height + (this.h * 2) + frsWaterFallItem.getPaddingBottom();
                            frsWaterFallItem.a(this.f, this.g, a4, this.h);
                            this.n.l().a(frsWaterFallItem, paddingBottom);
                            awVar.b().a(paddingBottom);
                            awVar.b().b(i);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.n.a();
    }

    protected void b() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11002);
            return;
        }
        this.v.a("from_frs");
        this.v.a(this.s.b().getName(), this.s.b().getId());
    }

    protected void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.y.alerm_title));
        builder.setPositiveButton(getString(com.baidu.tieba.y.attention_cancel), new ce(this));
        builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new cf(this));
        builder.create().show();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.n.m().c()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkApplication.m252getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    com.baidu.tieba.ai.c().c(1);
                    this.mSkinType = 1;
                    onChangeSkinType(this.mSkinType);
                    TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkApplication.m252getInst().getSkinType() != 0) {
                com.baidu.tieba.ai.c().c(0);
                this.mSkinType = 0;
                onChangeSkinType(this.mSkinType);
            } else {
                return;
            }
            com.baidu.tbadk.core.util.h.a();
            com.baidu.tieba.pb.main.bq.a().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.o != null) {
                this.o.b(msgReplyme);
                this.o.a(msgAtme);
                this.o.c(msgChat);
                this.n.a(this.o, a, b);
            }
        }
    }
}
