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
    private static f eFd;
    private a eFe = bpP();
    private String eFf;

    public static f bpO() {
        if (eFd == null) {
            synchronized (f.class) {
                if (eFd == null) {
                    eFd = new f();
                }
            }
        }
        return eFd;
    }

    private a bpP() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.eFe != null) {
            return this.eFe.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.eFe != null) {
            this.eFe.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.eFe != null) {
            return this.eFe.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.eFe != null) {
            return this.eFe.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.eFe != null) {
            this.eFe.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.eFe != null) {
            this.eFe.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.eFe != null) {
            this.eFe.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.eFe != null) {
            return this.eFe.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.eFe != null) {
            return this.eFe.a(activity, viewGroup);
        }
        return null;
    }

    public void BB(String str) {
        this.eFf = str;
    }

    public String bpQ() {
        return this.eFf;
    }
}
