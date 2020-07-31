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
    private static f esB;
    private a esC = bgk();
    private String esD;

    public static f bgj() {
        if (esB == null) {
            synchronized (f.class) {
                if (esB == null) {
                    esB = new f();
                }
            }
        }
        return esB;
    }

    private a bgk() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.esC != null) {
            return this.esC.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.esC != null) {
            this.esC.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.esC != null) {
            return this.esC.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.esC != null) {
            return this.esC.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.esC != null) {
            this.esC.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.esC != null) {
            this.esC.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.esC != null) {
            this.esC.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.esC != null) {
            return this.esC.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.esC != null) {
            return this.esC.a(activity, viewGroup);
        }
        return null;
    }

    public void yO(String str) {
        this.esD = str;
    }

    public String bgl() {
        return this.esD;
    }
}
