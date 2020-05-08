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
    private static f dPq;
    private a dPr = aUh();
    private String dPs;

    public static f aUg() {
        if (dPq == null) {
            synchronized (f.class) {
                if (dPq == null) {
                    dPq = new f();
                }
            }
        }
        return dPq;
    }

    private a aUh() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.dPr != null) {
            return this.dPr.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.dPr != null) {
            this.dPr.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.dPr != null) {
            return this.dPr.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.dPr != null) {
            return this.dPr.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.dPr != null) {
            this.dPr.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.dPr != null) {
            this.dPr.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.dPr != null) {
            this.dPr.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.dPr != null) {
            return this.dPr.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.dPr != null) {
            return this.dPr.a(activity, viewGroup);
        }
        return null;
    }

    public void vJ(String str) {
        this.dPs = str;
    }

    public String aUi() {
        return this.dPs;
    }
}
