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
    public static boolean c = true;
    private di p;
    private com.baidu.tieba.model.n q;
    private com.baidu.tieba.model.af w;
    private com.baidu.tieba.model.bf x;
    private cp y;
    private int e = 0;
    private String f = null;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private FooterType j = FooterType.GONE;
    private int k = 0;
    private int l = 1;
    private String m = null;
    private int n = 0;
    private cr o = null;
    private boolean r = false;
    private boolean s = false;
    private dm t = null;
    private dj u = null;
    private boolean v = false;
    private int z = 0;
    private int A = 0;
    private final cq B = new bw(this);
    private final cq C = new ch(this);
    public final CustomMessageListener d = new cj(this, 2012111);
    private final View.OnClickListener D = new ck(this);
    private final com.baidu.tieba.frs.view.z E = new cl(this);
    private final View.OnClickListener F = new cm(this);
    private final SlidingMenu.OnClosedListener G = new cn(this);
    private final com.baidu.tbadk.core.view.q H = new co(this);
    private final com.baidu.adp.widget.ScrollView.m I = new bx(this);
    private final SlidingMenu.OnOpenedListener J = new by(this);
    private final CustomMessageListener K = new bz(this, 2001124);

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
        CustomMessageTask customMessageTask = new CustomMessageTask(2003002, new ci());
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
            this.o.p();
        } else {
            this.o.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        a(bundle);
        registerListener(this.d);
    }

    private void e() {
        this.o = new cr(this, this.D);
        this.o.m().b();
        b(this.o.l().getLineWidth());
        this.o.a(this.E);
        this.o.a(this.G);
        this.o.a(this.J);
        this.g = getResources().getDimensionPixelSize(com.baidu.tieba.s.default_size_21);
        this.h = getResources().getDimensionPixelSize(com.baidu.tieba.s.default_size_18);
        this.i = getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_image_block);
        a(FooterType.GONE);
        this.o.l().setOnPullDownListener(this.I);
        this.o.a(this.H);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.o.l().c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.o.a(i);
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
            if (this.t != null && this.t.f() != null) {
                this.t.f().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11016);
            }
        } else if (this.t != null) {
            if (i == 0) {
                if (this.t.f() != null && this.t.f().getIfpost() == 0) {
                    com.baidu.adp.lib.util.j.a((Context) this, this.t.f().getForbid_info());
                    return;
                } else if (this.t.b() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ce(this, 0, this.t.b().getId(), this.t.b().getName(), null, null, 0, this.t.f(), 13003, false, false, null, false, false, null, null, null, 0)));
                    return;
                } else {
                    return;
                }
            }
            com.baidu.adp.lib.e.d.a(this.o.q(), this);
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
                    com.baidu.adp.lib.e.d.a(this.o.q(), this);
                    return;
                case 11036:
                    c();
                    return;
                case 12001:
                    if (this.t != null && this.t.b() != null) {
                        if (this.t.f() != null && this.t.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.j.a((Context) this, this.t.f().getForbid_info());
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cf(this, 12001, 12010, null, this.t.b().getId(), this.t.b().getName(), this.t.f())));
                        return;
                    }
                    return;
                case 12002:
                    if (this.t != null && this.t.b() != null && intent != null && intent.getData() != null) {
                        if (this.t.f() != null && this.t.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.j.a((Context) this, this.t.f().getForbid_info());
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cf(this, 12002, 12009, intent.getData(), this.t.b().getId(), this.t.b().getName(), this.t.f())));
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.t != null && this.t.b() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ce(this, 0, this.t.b().getId(), this.t.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, null, null, null, 0)));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ce(this, 0, this.t.b().getId(), this.t.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, intent.getStringExtra("filename"), null, null, 0)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tbadk.core.util.ax.b(this);
                    return;
                case 12010:
                    com.baidu.tbadk.core.util.ax.a(this);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.l = bundle.getInt("current_page");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_page", this.l);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        this.v = intent.getBooleanExtra("refresh_all", false);
        if (this.v) {
            f();
        }
    }

    private void f() {
        this.o.n().toggle(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0054, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        boolean z;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this);
        if (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI || netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int c2 = com.baidu.adp.lib.util.j.c(this) * 2;
        int bigImageMaxUsedMemory = TbConfig.getBigImageMaxUsedMemory() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                LinearLayout a2 = this.o.l().a(i2);
                int childCount = a2.getChildCount();
                int b2 = this.o.l().b(i2);
                int c3 = this.o.l().c(i2);
                if (b2 >= 0 && c3 >= 0) {
                    int i3 = b2;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if ((i3 <= c3 || z) && i3 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a2.getChildAt(i3);
                            if (frsWaterFallItem == null) {
                                break;
                            }
                            com.baidu.tieba.data.ay ayVar = (com.baidu.tieba.data.ay) frsWaterFallItem.getTag();
                            if (ayVar != null) {
                                int d = (ayVar.b().d() * ayVar.b().e() * 2) + i4;
                                if (d <= bigImageMaxUsedMemory) {
                                    String c4 = ayVar.b().c();
                                    if (i2 == 1) {
                                        View findViewWithTag = this.o.l().a(1).findViewWithTag(c4);
                                        if (findViewWithTag != null && (findViewWithTag instanceof TbImageView)) {
                                            ((TbImageView) findViewWithTag).a(c4, 22, false);
                                        }
                                    } else {
                                        View findViewWithTag2 = this.o.l().a(2).findViewWithTag(c4);
                                        if (findViewWithTag2 != null && (findViewWithTag2 instanceof TbImageView)) {
                                            ((TbImageView) findViewWithTag2).a(c4, 22, false);
                                        }
                                    }
                                    int d2 = ayVar.b().d() + i5;
                                    int i6 = i3 + 1;
                                    if (i6 <= c3 || d2 < c2) {
                                        i5 = d2;
                                        i3 = i6;
                                        i4 = d;
                                    }
                                }
                            } else {
                                return;
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(com.baidu.tieba.v.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.e = linearLayout.findViewById(com.baidu.tieba.u.image).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.t != null) {
            this.t.h();
        }
        if (this.q != null) {
            this.q.cancelLoadData();
        }
        this.o.r();
        if (this.y != null) {
            this.y.cancel(true);
            this.y = null;
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
        Cursor query = getContentResolver().query(Uri.parse(str2), null, "title=?", new String[]{String.valueOf(str) + getString(com.baidu.tieba.x.bar)}, null);
        return query != null && query.getCount() > 0;
    }

    private View h() {
        View footer = this.o.l().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.tieba.v.water_page, (ViewGroup) null);
            this.o.l().b(inflate);
            com.baidu.tbadk.core.util.ay.b((TextView) inflate.findViewById(com.baidu.tieba.u.page_text), TbadkApplication.m252getInst().getSkinType());
            inflate.setOnClickListener(new ca(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View i() {
        View header2 = this.o.l().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.tieba.v.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.u.page_text);
            textView.setText(com.baidu.tieba.x.pre_page);
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.ay.b(textView, TbadkApplication.m252getInst().getSkinType());
            ((ProgressBar) inflate.findViewById(com.baidu.tieba.u.progress)).setVisibility(8);
            this.o.l().a(inflate);
            inflate.setOnClickListener(new cb(this));
            return inflate;
        }
        return header2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.o.l().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FooterType footerType) {
        View h = h();
        TextView textView = (TextView) h.findViewById(com.baidu.tieba.u.page_text);
        ProgressBar progressBar = (ProgressBar) h.findViewById(com.baidu.tieba.u.progress);
        if (footerType == FooterType.NEXT) {
            h.setVisibility(0);
            textView.setText(com.baidu.tieba.x.next_page);
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
            textView.setText(com.baidu.tieba.x.frs_no_image);
            textView.setVisibility(0);
            progressBar.setVisibility(8);
        } else {
            h.setVisibility(8);
        }
        this.j = footerType;
        com.baidu.tbadk.core.util.ay.b(textView, this.mSkinType);
    }

    private void a(Bundle bundle) {
        this.z = com.baidu.adp.lib.util.j.b(this);
        this.A = com.baidu.adp.lib.util.j.c(this);
        Intent intent = getIntent();
        this.m = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FROM);
        this.n = intent.getIntExtra("add_search", 0);
        this.f = intent.getStringExtra("name");
        if (this.f == null) {
            this.f = TbadkApplication.m252getInst().getForumName();
        } else {
            TbadkApplication.m252getInst().setForumName(this.f);
            this.o.a(this.f);
        }
        if (bundle != null) {
            this.l = bundle.getInt("current_page");
        }
        if (this.l < 1) {
            this.l = 1;
        }
        c(this.l);
        this.p = new di(this);
        this.q = new com.baidu.tieba.model.n();
        this.q.setLoadDataCallBack(new cc(this));
        this.w = new com.baidu.tieba.model.af();
        this.w.setLoadDataCallBack(new cd(this));
        this.x = new com.baidu.tieba.model.bf();
        this.x.a(new ce(this));
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            k();
            m();
            this.q.b(true);
        }
        this.r = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.p.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
        this.p.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
        this.p.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().o());
        this.o.a(this.p, a, b, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.q != null && this.q.e() != null && this.q.e().g() != null) {
            this.o.m().b(this.q.e().g().a());
        }
    }

    private void m() {
        registerListener(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.t == null) {
            this.t = new dm();
        }
        this.t.a(this.m, this.f);
        this.t.a(this.B);
        this.t.a(i, this.z, this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.t != null && this.t.d().size() > i && this.j == FooterType.NORMAL) {
            this.t.a(this.m, this.f);
            this.t.b(this.C);
            this.t.a(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.o.n().isMenuShowing()) {
                this.o.n().toggle(true);
                if (this.r) {
                    this.r = false;
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
        this.o.r();
        finish();
        CompatibleUtile.setAnim(this, com.baidu.tieba.o.frs_browser_enter, com.baidu.tieba.o.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Intent a2;
        if (str != null && (a2 = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(com.baidu.tieba.x.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.t.icon));
            sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.tieba.data.ay> arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.data.ay ayVar = arrayList.get(i2);
                    if (ayVar != null) {
                        int a2 = ayVar.b().a();
                        int b2 = ayVar.b().b();
                        if (a2 >= 100 && b2 >= 50) {
                            if (a2 > this.e) {
                                float f = this.e / a2;
                                a2 = this.e;
                                b2 = (int) (b2 * f);
                            }
                            if (b2 > 600) {
                                i = (int) ((600.0f / b2) * a2);
                                b2 = 600;
                            } else {
                                i = a2;
                            }
                            Bitmap a3 = com.baidu.tbadk.core.util.d.a(com.baidu.tieba.t.image_default);
                            int height = b2 < a3.getHeight() ? a3.getHeight() : b2;
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(com.baidu.tieba.v.water_fall_item, (ViewGroup) null);
                            frsWaterFallItem.a(this.mSkinType);
                            TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(com.baidu.tieba.u.image);
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = height;
                            tbImageView.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(ayVar);
                            tbImageView.setTag(ayVar.b().c());
                            frsWaterFallItem.setOnClickListener(this.F);
                            int a4 = com.baidu.adp.lib.util.j.a((Context) this, 1.0f);
                            int paddingBottom = height + (this.i * 2) + frsWaterFallItem.getPaddingBottom();
                            frsWaterFallItem.a(this.g, this.h, a4, this.i);
                            this.o.l().a(frsWaterFallItem, paddingBottom);
                            ayVar.b().a(paddingBottom);
                            ayVar.b().b(i);
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
        this.o.a();
    }

    protected void b() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, 11002);
            return;
        }
        this.w.a("from_frs");
        this.w.a(this.t.b().getName(), this.t.b().getId());
    }

    protected void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.x.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.x.alert_title));
        builder.setPositiveButton(getString(com.baidu.tieba.x.attention_cancel), new cf(this));
        builder.setNegativeButton(getString(com.baidu.tieba.x.cancel), new cg(this));
        com.baidu.adp.lib.e.d.a(builder.create(), this);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.o.m().c()) {
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
            com.baidu.tbadk.core.util.d.a();
            com.baidu.tieba.pb.main.bp.a().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.p != null) {
                this.p.b(msgReplyme);
                this.p.a(msgAtme);
                this.p.c(msgChat);
                this.o.a(this.p, a, b, c);
            }
        }
    }
}
