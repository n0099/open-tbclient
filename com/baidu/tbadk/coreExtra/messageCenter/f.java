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
    private static f dPl;
    private a dPm = aUj();
    private String dPn;

    public static f aUi() {
        if (dPl == null) {
            synchronized (f.class) {
                if (dPl == null) {
                    dPl = new f();
                }
            }
        }
        return dPl;
    }

    private a aUj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.dPm != null) {
            return this.dPm.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.dPm != null) {
            this.dPm.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.dPm != null) {
            return this.dPm.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.dPm != null) {
            return this.dPm.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.dPm != null) {
            this.dPm.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.dPm != null) {
            this.dPm.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.dPm != null) {
            this.dPm.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.dPm != null) {
            return this.dPm.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.dPm != null) {
            return this.dPm.a(activity, viewGroup);
        }
        return null;
    }

    public void vG(String str) {
        this.dPn = str;
    }

    public String aUk() {
        return this.dPn;
    }
}
