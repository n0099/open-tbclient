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
    private static f eZG;
    private a eZH = bus();
    private String eZI;

    public static f bur() {
        if (eZG == null) {
            synchronized (f.class) {
                if (eZG == null) {
                    eZG = new f();
                }
            }
        }
        return eZG;
    }

    private a bus() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.eZH != null) {
            return this.eZH.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.eZH != null) {
            this.eZH.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.eZH != null) {
            return this.eZH.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.eZH != null) {
            return this.eZH.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.eZH != null) {
            this.eZH.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.eZH != null) {
            this.eZH.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.eZH != null) {
            this.eZH.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.eZH != null) {
            return this.eZH.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.eZH != null) {
            return this.eZH.a(activity, viewGroup);
        }
        return null;
    }

    public void CG(String str) {
        this.eZI = str;
    }

    public String but() {
        return this.eZI;
    }
}
