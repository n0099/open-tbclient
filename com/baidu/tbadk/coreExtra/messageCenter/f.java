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
    private static f doR;
    private a doS = aLF();
    private String doT;

    public static f aLE() {
        if (doR == null) {
            synchronized (f.class) {
                if (doR == null) {
                    doR = new f();
                }
            }
        }
        return doR;
    }

    private a aLF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.doS != null) {
            return this.doS.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.doS != null) {
            this.doS.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.doS != null) {
            return this.doS.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.doS != null) {
            return this.doS.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.doS != null) {
            this.doS.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.doS != null) {
            this.doS.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.doS != null) {
            this.doS.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.doS != null) {
            return this.doS.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.doS != null) {
            return this.doS.a(activity, viewGroup);
        }
        return null;
    }

    public void ur(String str) {
        this.doT = str;
    }

    public String aLG() {
        return this.doT;
    }
}
