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
    private static f eCY;
    private a eCZ = boV();
    private String eDa;

    public static f boU() {
        if (eCY == null) {
            synchronized (f.class) {
                if (eCY == null) {
                    eCY = new f();
                }
            }
        }
        return eCY;
    }

    private a boV() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.eCZ != null) {
            return this.eCZ.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.eCZ != null) {
            this.eCZ.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.eCZ != null) {
            return this.eCZ.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.eCZ != null) {
            return this.eCZ.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.eCZ != null) {
            this.eCZ.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.eCZ != null) {
            this.eCZ.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.eCZ != null) {
            this.eCZ.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.eCZ != null) {
            return this.eCZ.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.eCZ != null) {
            return this.eCZ.a(activity, viewGroup);
        }
        return null;
    }

    public void Bf(String str) {
        this.eDa = str;
    }

    public String boW() {
        return this.eDa;
    }
}
