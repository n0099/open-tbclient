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
    private static f ciL;
    private a ciM = aoG();

    public static f aoF() {
        if (ciL == null) {
            synchronized (f.class) {
                if (ciL == null) {
                    ciL = new f();
                }
            }
        }
        return ciL;
    }

    private a aoG() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.ciM != null) {
            return this.ciM.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.ciM != null) {
            this.ciM.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.ciM != null) {
            return this.ciM.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.ciM != null) {
            return this.ciM.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.ciM != null) {
            this.ciM.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.ciM != null) {
            this.ciM.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.ciM != null) {
            this.ciM.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.ciM != null) {
            return this.ciM.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.ciM != null) {
            return this.ciM.b(activity, relativeLayout);
        }
        return null;
    }
}
