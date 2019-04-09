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
    private static f bZI;
    private a bZJ = aiA();

    public static f aiz() {
        if (bZI == null) {
            synchronized (f.class) {
                if (bZI == null) {
                    bZI = new f();
                }
            }
        }
        return bZI;
    }

    private a aiA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.bZJ != null) {
            return this.bZJ.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.bZJ != null) {
            this.bZJ.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.bZJ != null) {
            return this.bZJ.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.bZJ != null) {
            return this.bZJ.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.bZJ != null) {
            this.bZJ.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.bZJ != null) {
            this.bZJ.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.bZJ != null) {
            this.bZJ.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.bZJ != null) {
            return this.bZJ.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.bZJ != null) {
            return this.bZJ.b(activity, relativeLayout);
        }
        return null;
    }
}
