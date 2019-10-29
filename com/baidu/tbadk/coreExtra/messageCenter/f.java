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
    private static f cxA;
    private a cxB = arw();

    public static f arv() {
        if (cxA == null) {
            synchronized (f.class) {
                if (cxA == null) {
                    cxA = new f();
                }
            }
        }
        return cxA;
    }

    private a arw() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.cxB != null) {
            return this.cxB.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.cxB != null) {
            this.cxB.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.cxB != null) {
            return this.cxB.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.cxB != null) {
            return this.cxB.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.cxB != null) {
            this.cxB.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.cxB != null) {
            this.cxB.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, RelativeLayout relativeLayout) {
        if (this.cxB != null) {
            this.cxB.a(tbPageContext, relativeLayout);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.cxB != null) {
            return this.cxB.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (this.cxB != null) {
            return this.cxB.b(activity, relativeLayout);
        }
        return null;
    }
}
