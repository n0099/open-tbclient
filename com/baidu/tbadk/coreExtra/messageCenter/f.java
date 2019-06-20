package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.Dialog;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class f {
    private static f chF;
    private a chG = anB();

    public static f anA() {
        if (chF == null) {
            synchronized (f.class) {
                if (chF == null) {
                    chF = new f();
                }
            }
        }
        return chF;
    }

    private a anB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.chG != null) {
            return this.chG.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.chG != null) {
            this.chG.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.chG != null) {
            return this.chG.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.chG != null) {
            return this.chG.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.chG != null) {
            this.chG.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.chG != null) {
            this.chG.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.chG != null) {
            this.chG.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.chG != null) {
            return this.chG.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.chG != null) {
            return this.chG.b(activity, relativeLayout);
        }
        return null;
    }
}
