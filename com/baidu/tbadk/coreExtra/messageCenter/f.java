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
    private static f cwJ;
    private a cwK = aru();

    public static f art() {
        if (cwJ == null) {
            synchronized (f.class) {
                if (cwJ == null) {
                    cwJ = new f();
                }
            }
        }
        return cwJ;
    }

    private a aru() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.cwK != null) {
            return this.cwK.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.cwK != null) {
            this.cwK.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.cwK != null) {
            return this.cwK.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.cwK != null) {
            return this.cwK.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.cwK != null) {
            this.cwK.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.cwK != null) {
            this.cwK.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.cwK != null) {
            this.cwK.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.cwK != null) {
            return this.cwK.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.cwK != null) {
            return this.cwK.b(activity, relativeLayout);
        }
        return null;
    }
}
