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
    private static f bZE;
    private a bZF = aiD();

    public static f aiC() {
        if (bZE == null) {
            synchronized (f.class) {
                if (bZE == null) {
                    bZE = new f();
                }
            }
        }
        return bZE;
    }

    private a aiD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.bZF != null) {
            return this.bZF.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.bZF != null) {
            this.bZF.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.bZF != null) {
            return this.bZF.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.bZF != null) {
            return this.bZF.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.bZF != null) {
            this.bZF.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.bZF != null) {
            this.bZF.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.bZF != null) {
            this.bZF.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.bZF != null) {
            return this.bZF.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.bZF != null) {
            return this.bZF.b(activity, relativeLayout);
        }
        return null;
    }
}
