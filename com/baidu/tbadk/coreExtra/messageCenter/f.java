package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public class f {
    private static f dkK;
    private a dkL = aJm();
    private String dkM;

    public static f aJl() {
        if (dkK == null) {
            synchronized (f.class) {
                if (dkK == null) {
                    dkK = new f();
                }
            }
        }
        return dkK;
    }

    private a aJm() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.dkL != null) {
            return this.dkL.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.dkL != null) {
            this.dkL.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.dkL != null) {
            return this.dkL.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.dkL != null) {
            return this.dkL.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.dkL != null) {
            this.dkL.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.dkL != null) {
            this.dkL.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.dkL != null) {
            this.dkL.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.dkL != null) {
            return this.dkL.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.dkL != null) {
            return this.dkL.a(activity, viewGroup);
        }
        return null;
    }

    public void ua(String str) {
        this.dkM = str;
    }

    public String aJn() {
        return this.dkM;
    }
}
