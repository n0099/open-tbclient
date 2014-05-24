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
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
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
    private de p;
    private com.baidu.tieba.model.o q;
    private com.baidu.tieba.model.af w;
    private com.baidu.tieba.model.bd x;
    private int d = 0;
    private String e = null;
    private com.baidu.tbadk.core.util.b f = null;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private FooterType j = FooterType.GONE;
    private int k = 0;
    private int l = 1;
    private String m = null;
    private int n = 0;
    private cq o = null;
    private boolean r = false;
    private boolean s = false;
    private di t = null;
    private df u = null;
    private boolean v = false;
    private int y = 0;
    private int z = 0;
    private final cp A = new bu(this);
    private final cp B = new cf(this);
    public final CustomMessageListener c = new cj(this, CmdConfig.MSG_NEW);
    private final View.OnClickListener C = new ck(this);
    private final com.baidu.tieba.frs.view.q D = new cl(this);
    private final View.OnClickListener E = new cm(this);
    private final com.baidu.tbadk.imageManager.d F = new cn(this);
    private final com.baidu.tbadk.imageManager.d G = new co(this);
    private final SlidingMenu.OnClosedListener H = new bv(this);
    private final com.baidu.tbadk.core.view.m I = new bw(this);
    private final com.baidu.adp.widget.ScrollView.m J = new bx(this);
    private final SlidingMenu.OnOpenedListener K = new by(this);
    private final CustomMessageListener L = new bz(this, MessageTypes.CMD_MESSAGE_NOTIFY_LOCAL);

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
        CustomMessageTask customMessageTask = new CustomMessageTask(2005002, new ci());
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
        registerListener(this.c);
        MessageManager.getInstance().sendMessage(new CustomMessage(2009001, new com.baidu.tbadk.core.atomData.z(this, false)));
    }

    private void e() {
        this.o = new cq(this, this.C);
        this.o.m().b();
        b(this.o.l().getLineWidth());
        this.o.a(this.D);
        this.o.a(this.H);
        this.o.a(this.K);
        this.g = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_size_21);
        this.h = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_size_18);
        this.i = getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_image_block);
        a(FooterType.GONE);
        this.o.l().setOnPullDownListener(this.J);
        this.o.a(this.I);
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
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f != null) {
            this.f.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.t != null && this.t.f() != null) {
                this.t.f().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11016);
            }
        } else if (this.t != null) {
            if (i == 0) {
                if (this.t.f() != null && this.t.f().getIfpost() == 0) {
                    com.baidu.adp.lib.util.k.a((Context) this, this.t.f().getForbid_info());
                    return;
                } else if (this.t.b() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bi(this, 0, this.t.b().getId(), this.t.b().getName(), null, null, 0, this.t.f(), 13003, false, false, null, false, false, null, null, null)));
                    return;
                } else {
                    return;
                }
            }
            this.o.q().show();
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
                    this.o.q().show();
                    return;
                case 11036:
                    c();
                    return;
                case 12001:
                    if (this.t != null && this.t.b() != null) {
                        if (this.t.f() != null && this.t.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.k.a((Context) this, this.t.f().getForbid_info());
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bj(this, 12001, 12010, null, this.t.b().getId(), this.t.b().getName(), this.t.f())));
                        return;
                    }
                    return;
                case 12002:
                    if (this.t != null && this.t.b() != null && intent != null && intent.getData() != null) {
                        if (this.t.f() != null && this.t.f().getIfpost() == 0) {
                            com.baidu.adp.lib.util.k.a((Context) this, this.t.f().getForbid_info());
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bj(this, 12002, 12009, intent.getData(), this.t.b().getId(), this.t.b().getName(), this.t.f())));
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.t != null && this.t.b() != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bi(this, 0, this.t.b().getId(), this.t.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, null, null, null)));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bi(this, 0, this.t.b().getId(), this.t.b().getName(), null, null, 0, null, 13003, false, false, null, false, true, intent.getStringExtra("filename"), null, null)));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12009:
                    com.baidu.tbadk.core.util.bb.b(this);
                    return;
                case 12010:
                    com.baidu.tbadk.core.util.bb.a(this);
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
    public void g() {
        boolean z;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this);
        this.f.a();
        if (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI || netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG) {
            z = true;
        } else {
            z = false;
        }
        int c = com.baidu.adp.lib.util.k.c(this) * 2;
        this.f.a(z);
        int bigImageMaxUsedMemory = TbConfig.getBigImageMaxUsedMemory() >> 1;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                LinearLayout a2 = this.o.l().a(i2);
                int childCount = a2.getChildCount();
                int b2 = this.o.l().b(i2);
                int c2 = this.o.l().c(i2);
                if (b2 >= 0 && c2 >= 0) {
                    int i3 = 0;
                    int i4 = b2;
                    int i5 = 0;
                    while (true) {
                        if ((i4 <= c2 || z) && i4 < childCount) {
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) a2.getChildAt(i4);
                            if (frsWaterFallItem != null) {
                                com.baidu.tieba.data.at atVar = (com.baidu.tieba.data.at) frsWaterFallItem.getTag();
                                i3 += atVar.b().d() * atVar.b().e() * 2;
                                if (i3 > bigImageMaxUsedMemory) {
                                    break;
                                }
                                if (i2 == 1) {
                                    this.f.b(atVar.b().c(), this.F);
                                } else {
                                    this.f.b(atVar.b().c(), this.G);
                                }
                                int d = atVar.b().d() + i5;
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_fall_item, (ViewGroup) null);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), 0);
        this.d = linearLayout.findViewById(com.baidu.tieba.v.image).getMeasuredWidth();
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
    }

    private View h() {
        View footer = this.o.l().getFooter();
        if (footer == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_page, (ViewGroup) null);
            this.o.l().b(inflate);
            com.baidu.tbadk.core.util.bc.b((TextView) inflate.findViewById(com.baidu.tieba.v.page_text), TbadkApplication.m252getInst().getSkinType());
            inflate.setOnClickListener(new ca(this));
            return inflate;
        }
        return footer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View i() {
        View header2 = this.o.l().getHeader2();
        if (header2 == null) {
            View inflate = LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_page, (ViewGroup) null);
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.page_text);
            textView.setText(com.baidu.tieba.y.pre_page);
            textView.setVisibility(0);
            com.baidu.tbadk.core.util.bc.b(textView, TbadkApplication.m252getInst().getSkinType());
            ((ProgressBar) inflate.findViewById(com.baidu.tieba.v.progress)).setVisibility(8);
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
        this.j = footerType;
        com.baidu.tbadk.core.util.bc.b(textView, this.mSkinType);
    }

    private void a(Bundle bundle) {
        this.y = com.baidu.adp.lib.util.k.b(this);
        this.z = com.baidu.adp.lib.util.k.c(this);
        this.f = new com.baidu.tbadk.core.util.b(this);
        this.f.a(this.d, TbConfig.POST_IMAGE_SMALL);
        this.f.b("_water");
        this.f.c(true);
        this.f.f("frs");
        Intent intent = getIntent();
        this.m = intent.getStringExtra("from");
        this.n = intent.getIntExtra("add_search", 0);
        this.e = intent.getStringExtra("name");
        if (this.e == null) {
            this.e = TbadkApplication.m252getInst().getForumName();
        } else {
            TbadkApplication.m252getInst().setForumName(this.e);
            this.o.a(this.e);
        }
        if (bundle != null) {
            this.l = bundle.getInt("current_page");
        }
        if (this.l < 1) {
            this.l = 1;
        }
        c(this.l);
        this.p = new de(this);
        this.q = new com.baidu.tieba.model.o();
        this.q.setLoadDataCallBack(new cc(this));
        this.w = new com.baidu.tieba.model.af();
        this.w.setLoadDataCallBack(new cd(this));
        this.x = new com.baidu.tieba.model.bd();
        this.x.a(new ce(this));
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            k();
            m();
            this.q.b(true);
        }
        this.r = false;
    }

    private void k() {
        this.p.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
        this.p.c(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
        this.p.b(com.baidu.tbadk.coreExtra.messageCenter.a.a().l());
        this.p.d(com.baidu.tbadk.coreExtra.messageCenter.a.a().n());
        this.o.a(this.p, a, b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.q != null && this.q.e() != null && this.q.e().g() != null) {
            this.o.m().b(this.q.e().g().a());
        }
    }

    private void m() {
        registerListener(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.t == null) {
            this.t = new di();
        }
        this.t.a(this.m, this.e);
        this.t.a(this.A);
        this.t.a(i, this.y, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (this.t != null && this.t.d().size() > i && this.j == FooterType.NORMAL) {
            this.t.a(this.m, this.e);
            this.t.b(this.B);
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
        CompatibleUtile.setAnim(this, com.baidu.tieba.p.frs_browser_enter, com.baidu.tieba.p.no_effect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Intent a2;
        if (str != null && (a2 = FrsActivity.a(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(com.baidu.tieba.y.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", a2);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.u.icon));
            sendBroadcast(intent);
            showToast(getString(com.baidu.tieba.y.add_to_window_succ));
            new com.baidu.tbadk.core.util.az(TbConfig.ST_TYPE_ADD_TO_LAUNCHER).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.tieba.data.at> arrayList) {
        int i;
        if (arrayList != null) {
            try {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.tieba.data.at atVar = arrayList.get(i2);
                    if (atVar != null) {
                        int a2 = atVar.b().a();
                        int b2 = atVar.b().b();
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
                            Bitmap a3 = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.u.image_default);
                            int height = b2 < a3.getHeight() ? a3.getHeight() : b2;
                            FrsWaterFallItem frsWaterFallItem = (FrsWaterFallItem) LayoutInflater.from(this).inflate(com.baidu.tieba.w.water_fall_item, (ViewGroup) null);
                            frsWaterFallItem.a(this.mSkinType);
                            TbImageView tbImageView = (TbImageView) frsWaterFallItem.findViewById(com.baidu.tieba.v.image);
                            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
                            layoutParams.height = height;
                            tbImageView.setLayoutParams(layoutParams);
                            frsWaterFallItem.setTag(atVar);
                            tbImageView.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d);
                            tbImageView.setNightDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d_1);
                            tbImageView.setTag(atVar.b().c());
                            tbImageView.setSuffix("_water");
                            frsWaterFallItem.setOnClickListener(this.E);
                            int a4 = com.baidu.adp.lib.util.k.a((Context) this, 1.0f);
                            int paddingBottom = height + (this.i * 2) + frsWaterFallItem.getPaddingBottom();
                            frsWaterFallItem.a(this.g, this.h, a4, this.i);
                            this.o.l().a(frsWaterFallItem, paddingBottom);
                            atVar.b().a(paddingBottom);
                            atVar.b().b(i);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "setData", e.getMessage());
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
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11002);
            return;
        }
        this.w.a("from_frs");
        this.w.a(this.t.b().getName(), this.t.b().getId());
    }

    protected void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.y.alerm_title));
        builder.setPositiveButton(getString(com.baidu.tieba.y.attention_cancel), new cg(this));
        builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new ch(this));
        builder.create().show();
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
                    new com.baidu.tbadk.core.util.az(TbConfig.ST_TYPE_EYESHIELD_MODE).start();
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
            com.baidu.tbadk.core.util.g.a();
            com.baidu.tieba.pb.main.bn.a().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgFans = newsNotifyMessage.getMsgFans();
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.p != null) {
                this.p.a(msgFans);
                this.p.c(msgReplyme);
                this.p.b(msgAtme);
                this.p.d(msgChat);
                this.o.a(this.p, a, b);
            }
        }
    }
}
