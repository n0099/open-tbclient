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
    private static f bZH;
    private a bZI = aiA();

    public static f aiz() {
        if (bZH == null) {
            synchronized (f.class) {
                if (bZH == null) {
                    bZH = new f();
                }
            }
        }
        return bZH;
    }

    private a aiA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.bZI != null) {
            return this.bZI.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.bZI != null) {
            this.bZI.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.bZI != null) {
            return this.bZI.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.bZI != null) {
            return this.bZI.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.bZI != null) {
            this.bZI.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.bZI != null) {
            this.bZI.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.bZI != null) {
            this.bZI.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.bZI != null) {
            return this.bZI.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.bZI != null) {
            return this.bZI.b(activity, relativeLayout);
        }
        return null;
    }
}
