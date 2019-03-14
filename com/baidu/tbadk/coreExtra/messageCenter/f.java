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
    private static f bZF;
    private a bZG = aiD();

    public static f aiC() {
        if (bZF == null) {
            synchronized (f.class) {
                if (bZF == null) {
                    bZF = new f();
                }
            }
        }
        return bZF;
    }

    private a aiD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.bZG != null) {
            return this.bZG.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.bZG != null) {
            this.bZG.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.bZG != null) {
            return this.bZG.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.bZG != null) {
            return this.bZG.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.bZG != null) {
            this.bZG.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.bZG != null) {
            this.bZG.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.bZG != null) {
            this.bZG.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.bZG != null) {
            return this.bZG.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.bZG != null) {
            return this.bZG.b(activity, relativeLayout);
        }
        return null;
    }
}
