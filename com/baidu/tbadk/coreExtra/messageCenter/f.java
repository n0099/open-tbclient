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
    private static f ciS;
    private a ciT = aoI();

    public static f aoH() {
        if (ciS == null) {
            synchronized (f.class) {
                if (ciS == null) {
                    ciS = new f();
                }
            }
        }
        return ciS;
    }

    private a aoI() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.ciT != null) {
            return this.ciT.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.ciT != null) {
            this.ciT.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.ciT != null) {
            return this.ciT.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.ciT != null) {
            return this.ciT.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.ciT != null) {
            this.ciT.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.ciT != null) {
            this.ciT.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.ciT != null) {
            this.ciT.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.ciT != null) {
            return this.ciT.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.ciT != null) {
            return this.ciT.b(activity, relativeLayout);
        }
        return null;
    }
}
