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
    private static b aYv;
    private k aYA;
    private com.baidu.tieba.im.floatwindow.view.a aYy;
    private com.baidu.tieba.im.floatwindow.view.f aYz;
    private boolean aYw = false;
    private boolean isBackground = false;
    private boolean aYx = false;
    private a aYB = new a();
    private ArrayList<String> aYC = new ArrayList<>();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private i aYD = new i(this);
    private h aYE = new h(this);
    private e aYF = new e(this);
    private f aYG = new f(this);
    private g aYH = new g(this);
    private n aYI = new c(this);
    private com.baidu.tieba.im.floatwindow.view.e aYJ = new d(this);

    public static synchronized b No() {
        b bVar;
        synchronized (b.class) {
            if (aYv == null) {
                aYv = new b();
            }
            bVar = aYv;
        }
        return bVar;
    }

    public boolean gy(String str) {
        return this.aYC.contains(str);
    }

    public void gz(String str) {
        if (!StringUtils.isNull(str) && !this.aYC.contains(str)) {
            this.aYC.add(str);
        }
    }

    public void gA(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYC.remove(str);
        }
    }

    public void registerListener() {
        MessageManager.getInstance().registerListener(this.aYE);
        MessageManager.getInstance().registerListener(this.aYF);
        MessageManager.getInstance().registerListener(this.aYD);
        MessageManager.getInstance().registerListener(this.aYG);
        MessageManager.getInstance().registerListener(this.aYH);
    }

    public void cJ(boolean z) {
        if (!Np()) {
            if (this.aYB.Nn()) {
                Nr();
                if (!Nt().ND()) {
                    Nt().a(this.handler, z);
                    return;
                }
                return;
            }
            cK(false);
        }
    }

    private boolean Np() {
        return TbadkCoreApplication.m255getInst().isMIUIRom() || !TbadkCoreApplication.m255getInst().isFloatingWindowOpened() || this.aYw || !Nq() || TbadkCoreApplication.m255getInst().getMsgFrequency() == 0 || !TbadkCoreApplication.m255getInst().isMsgChatOn();
    }

    private boolean Nq() {
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

    public void gB(String str) {
        if (!StringUtils.isNull(str)) {
            this.aYB.gv(str);
            Nt().E(this.aYB.Nk());
        }
    }

    public void gC(String str) {
        this.aYB.gw(str);
        if (!this.aYB.Nn()) {
            cK(false);
        } else {
            Nr();
        }
    }

    private void Nr() {
        Nt().E(this.aYB.Nk());
        Nt().fN(this.aYB.Nj());
    }

    public void cK(boolean z) {
        if (this.aYy != null) {
            Nu().c(this.handler);
            this.aYy.NF();
            if (z) {
                this.aYy.V(0, getPaddingTop());
                this.aYB.removeAll();
            }
        }
    }

    public void D(String str, int i) {
        if (Nv().ND()) {
            Nv().E(str, i);
        }
    }

    public void a(int i, int i2, String str, int i3) {
        Nv().b(i, i2, str, i3);
        Nu().b(this.handler);
    }

    public void R(int i, int i2) {
        Nv().U(i, i2);
        if (a(Nv().NB(), this.aYz.NS())) {
            Nu().NT();
        } else {
            Nu().NU();
        }
    }

    public void a(com.baidu.tieba.im.floatwindow.view.m mVar) {
        if (a(Nv().NB(), Nu().NS())) {
            mVar.Ob();
        }
        Nv().NF();
        Nu().c(this.handler);
    }

    public void Ns() {
        this.aYx = true;
        Nt().NQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(j jVar, j jVar2) {
        return jVar.a(jVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.floatwindow.view.a Nt() {
        if (this.aYy == null) {
            this.aYy = new com.baidu.tieba.im.floatwindow.view.a(TbadkCoreApplication.m255getInst());
            this.aYy.a(this.aYI);
            this.aYy.a(this.aYJ);
            this.aYy.V(0, getPaddingTop());
        }
        return this.aYy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.im.floatwindow.view.f Nu() {
        if (this.aYz == null) {
            this.aYz = new com.baidu.tieba.im.floatwindow.view.f(TbadkCoreApplication.m255getInst());
        }
        return this.aYz;
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

    private k Nv() {
        if (this.aYA == null) {
            this.aYA = new k();
        }
        return this.aYA;
    }

    public void Nw() {
        this.aYw = true;
        this.aYB.Nh();
        Nt().setTouchable(false);
    }

    public void Nx() {
        this.aYw = false;
        this.aYB.Ni();
        Nt().setTouchable(true);
    }
}
