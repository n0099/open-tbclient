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
    private static b aYw;
    private com.baidu.tieba.im.floatwindow.view.f aYA;
    private k aYB;
    private com.baidu.tieba.im.floatwindow.view.a aYz;
    private boolean aYx = false;
    private boolean isBackground = false;
    private boolean aYy = false;
    private a aYC = new a();
    private ArrayList<String> aYD = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private i aYE = new i(this);
    private h aYF = new h(this);
    private e aYG = new e(this);
    private f aYH = new f(this);
    private g aYI = new g(this);
    private n aYJ = new c(this);
    private com.baidu.tieba.im.floatwindow.view.e aYK = new d(this);

    public static synchronized b Nt() {
        b bVar;
        synchronized (b.class) {
            if (aYw == null) {
                aYw = new b();
            }
            bVar = aYw;
        }
        return bVar;
    }

    public boolean gB(String str) {
        return this.aYD.contains(str);
    }

    public void gC(String str) {
        if (!StringUtils.isNull(str) && !this.aYD.contains(str)) {
            this.aYD.add(str);
        }
    }

    public void gD(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYD.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.aYF);
        MessageManager.getInstance().registerListener(this.aYG);
        MessageManager.getInstance().registerListener(this.aYE);
        MessageManager.getInstance().registerListener(this.aYH);
        MessageManager.getInstance().registerListener(this.aYI);
    }

    public void cJ(boolean z) {
        if (!Nu()) {
            if (this.aYC.Ns()) {
                Nw();
                if (!Ny().NI()) {
                    Ny().a(this.handler, z);
                    return;
                }
                return;
            }
            cK(false);
        }
    }

    private boolean Nu() {
        return TbadkCoreApplication.m255getInst().isMIUIRom() || !TbadkCoreApplication.m255getInst().isFloatingWindowOpened() || this.aYx || !Nv() || TbadkCoreApplication.m255getInst().getMsgFrequency() == 0 || !TbadkCoreApplication.m255getInst().isMsgChatOn();
    }

    private boolean Nv() {
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

    public void gE(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYC.gy(str);
            Ny().E(this.aYC.Np());
        }
    }

    public void gF(String str) {
        this.aYC.gz(str);
        if (!this.aYC.Ns()) {
            cK(false);
        } else {
            Nw();
        }
    }

    private void Nw() {
        Ny().E(this.aYC.Np());
        Ny().fN(this.aYC.No());
    }

    public void cK(boolean z) {
        if (this.aYz != null) {
            Nz().c(this.handler);
            this.aYz.NK();
            if (z) {
                this.aYz.U(0, getPaddingTop());
                this.aYC.removeAll();
            }
        }
    }

    public void D(String str, int i) {
        if (NA().NI()) {
            NA().E(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        NA().b(i, i2, str, i3);
        Nz().b(this.handler);
    }

    public void Q(int i, int i2) {
        NA().T(i, i2);
        if (a(NA().NG(), this.aYA.NX())) {
            Nz().NY();
        } else {
            Nz().NZ();
        }
    }

    public void a(com.baidu.tieba.im.floatwindow.view.m mVar) {
        if (a(NA().NG(), Nz().NX())) {
            mVar.Og();
        }
        NA().NK();
        Nz().c(this.handler);
    }

    public void Nx() {
        this.aYy = true;
        Ny().NV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(j jVar, j jVar2) {
        return jVar.a(jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.floatwindow.view.a Ny() {
        if (this.aYz == null) {
            this.aYz = new com.baidu.tieba.im.floatwindow.view.a(TbadkCoreApplication.m255getInst());
            this.aYz.a(this.aYJ);
            this.aYz.a(this.aYK);
            this.aYz.U(0, getPaddingTop());
        }
        return this.aYz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.floatwindow.view.f Nz() {
        if (this.aYA == null) {
            this.aYA = new com.baidu.tieba.im.floatwindow.view.f(TbadkCoreApplication.m255getInst());
        }
        return this.aYA;
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

    private k NA() {
        if (this.aYB == null) {
            this.aYB = new k();
        }
        return this.aYB;
    }

    public void NB() {
        this.aYx = true;
        this.aYC.Nm();
        Ny().setTouchable(false);
    }

    public void NC() {
        this.aYx = false;
        this.aYC.Nn();
        Ny().setTouchable(true);
    }
}
