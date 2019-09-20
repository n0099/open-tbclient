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
    private static f cjN;
    private a cjO = aoU();

    public static f aoT() {
        if (cjN == null) {
            synchronized (f.class) {
                if (cjN == null) {
                    cjN = new f();
                }
            }
        }
        return cjN;
    }

    private a aoU() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.cjO != null) {
            return this.cjO.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.cjO != null) {
            this.cjO.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.cjO != null) {
            return this.cjO.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.cjO != null) {
            return this.cjO.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.cjO != null) {
            this.cjO.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.cjO != null) {
            this.cjO.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.cjO != null) {
            this.cjO.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.cjO != null) {
            return this.cjO.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.cjO != null) {
            return this.cjO.b(activity, relativeLayout);
        }
        return null;
    }
}
