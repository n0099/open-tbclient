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
    private static f chE;
    private a chF = anB();

    public static f anA() {
        if (chE == null) {
            synchronized (f.class) {
                if (chE == null) {
                    chE = new f();
                }
            }
        }
        return chE;
    }

    private a anB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.chF != null) {
            return this.chF.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.chF != null) {
            this.chF.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.chF != null) {
            return this.chF.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.chF != null) {
            return this.chF.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.chF != null) {
            this.chF.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.chF != null) {
            this.chF.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.chF != null) {
            this.chF.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.chF != null) {
            return this.chF.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.chF != null) {
            return this.chF.b(activity, relativeLayout);
        }
        return null;
    }
}
