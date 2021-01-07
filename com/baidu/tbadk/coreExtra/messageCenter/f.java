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
    private static f fvP;
    private a fvQ = bCd();
    private String fvR;

    public static f bCc() {
        if (fvP == null) {
            synchronized (f.class) {
                if (fvP == null) {
                    fvP = new f();
                }
            }
        }
        return fvP;
    }

    private a bCd() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.fvQ != null) {
            return this.fvQ.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.fvQ != null) {
            this.fvQ.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.fvQ != null) {
            return this.fvQ.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.fvQ != null) {
            return this.fvQ.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.fvQ != null) {
            this.fvQ.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.fvQ != null) {
            this.fvQ.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.fvQ != null) {
            this.fvQ.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.fvQ != null) {
            return this.fvQ.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.fvQ != null) {
            return this.fvQ.a(activity, viewGroup);
        }
        return null;
    }

    public void CY(String str) {
        this.fvR = str;
    }

    public String bCe() {
        return this.fvR;
    }
}
