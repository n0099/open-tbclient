package com.baidu.tieba.im.floatwindow;

import android.app.ActivityManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aXa;
    private com.baidu.tieba.im.floatwindow.view.a aXd;
    private com.baidu.tieba.im.floatwindow.view.f aXe;
    private k aXf;
    private boolean aXb = false;
    private boolean isBackground = false;
    private boolean aXc = false;
    private a aXg = new a();
    private ArrayList<String> aXh = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private i aXi = new i(this);
    private h aXj = new h(this);
    private e aXk = new e(this);
    private f aXl = new f(this);
    private g aXm = new g(this);
    private n aXn = new c(this);
    private com.baidu.tieba.im.floatwindow.view.e aXo = new d(this);

    public static synchronized b MX() {
        b bVar;
        synchronized (b.class) {
            if (aXa == null) {
                aXa = new b();
            }
            bVar = aXa;
        }
        return bVar;
    }

    public boolean gw(String str) {
        return this.aXh.contains(str);
    }

    public void gx(String str) {
        if (!StringUtils.isNull(str) && !this.aXh.contains(str)) {
            this.aXh.add(str);
        }
    }

    public void gy(String str) {
        if (!StringUtils.isNull(str)) {
            this.aXh.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.aXj);
        MessageManager.getInstance().registerListener(this.aXk);
        MessageManager.getInstance().registerListener(this.aXi);
        MessageManager.getInstance().registerListener(this.aXl);
        MessageManager.getInstance().registerListener(this.aXm);
    }

    public void cE(boolean z) {
        if (!MY()) {
            if (this.aXg.MW()) {
                Na();
                if (!Nc().Nm()) {
                    Nc().a(this.handler, z);
                    return;
                }
                return;
            }
            cF(false);
        }
    }

    private boolean MY() {
        return TbadkCoreApplication.m255getInst().isMIUIRom() || !TbadkCoreApplication.m255getInst().isFloatingWindowOpened() || this.aXb || !MZ() || TbadkCoreApplication.m255getInst().getMsgFrequency() == 0 || !TbadkCoreApplication.m255getInst().isMsgChatOn();
    }

    private boolean MZ() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) TbadkCoreApplication.m255getInst().getSystemService("activity")).getRunningTasks(5);
        if (runningTasks == null || runningTasks.size() <= 0) {
            return false;
        }
        ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
        if (runningTaskInfo == null) {
            return false;
        }
        String className = runningTaskInfo.topActivity.getClassName();
        return ("com.baidu.tieba.LogoActivity".equalsIgnoreCase(className) || "com.baidu.tieba.guide.NewUserGuideActivity".equalsIgnoreCase(className) || "com.baidu.tieba.topRec.TopRecActivity".equalsIgnoreCase(className) || "com.baidu.tieba.screenlocknotify.ScreenLockActivity".equalsIgnoreCase(className)) ? false : true;
    }

    public void gz(String str) {
        if (!StringUtils.isNull(str)) {
            this.aXg.gt(str);
            Nc().D(this.aXg.MT());
        }
    }

    public void gA(String str) {
        this.aXg.gu(str);
        if (!this.aXg.MW()) {
            cF(false);
        } else {
            Na();
        }
    }

    private void Na() {
        Nc().D(this.aXg.MT());
        Nc().fI(this.aXg.MS());
    }

    public void cF(boolean z) {
        if (this.aXd != null) {
            Nd().c(this.handler);
            this.aXd.No();
            if (z) {
                this.aXd.T(0, getPaddingTop());
                this.aXg.removeAll();
            }
        }
    }

    public void D(String str, int i) {
        if (Ne().Nm()) {
            Ne().E(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        Ne().b(i, i2, str, i3);
        Nd().b(this.handler);
    }

    public void P(int i, int i2) {
        Ne().S(i, i2);
        if (a(Ne().Nk(), this.aXe.NB())) {
            Nd().NC();
        } else {
            Nd().ND();
        }
    }

    public void a(com.baidu.tieba.im.floatwindow.view.m mVar) {
        if (a(Ne().Nk(), Nd().NB())) {
            mVar.NK();
        }
        Ne().No();
        Nd().c(this.handler);
    }

    public void Nb() {
        this.aXc = true;
        Nc().Nz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(j jVar, j jVar2) {
        return jVar.a(jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.floatwindow.view.a Nc() {
        if (this.aXd == null) {
            this.aXd = new com.baidu.tieba.im.floatwindow.view.a(TbadkCoreApplication.m255getInst());
            this.aXd.a(this.aXn);
            this.aXd.a(this.aXo);
            this.aXd.T(0, getPaddingTop());
        }
        return this.aXd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.floatwindow.view.f Nd() {
        if (this.aXe == null) {
            this.aXe = new com.baidu.tieba.im.floatwindow.view.f(TbadkCoreApplication.m255getInst());
        }
        return this.aXe;
    }

    private int getPaddingTop() {
        int I = com.baidu.adp.lib.util.a.I(TbadkCoreApplication.m255getInst());
        if (I == 0) {
            I = 25;
        }
        Resources resources = TbadkCoreApplication.m255getInst().getResources();
        int J = com.baidu.adp.lib.util.a.J(TbadkCoreApplication.m255getInst());
        if (J == 0) {
            J = resources.getDimensionPixelSize(u.navigation_bar_height);
        }
        return I + J + resources.getDimensionPixelSize(u.ds40);
    }

    private k Ne() {
        if (this.aXf == null) {
            this.aXf = new k();
        }
        return this.aXf;
    }

    public void Nf() {
        this.aXb = true;
        this.aXg.MQ();
        Nc().setTouchable(false);
    }

    public void Ng() {
        this.aXb = false;
        this.aXg.MR();
        Nc().setTouchable(true);
    }
}
