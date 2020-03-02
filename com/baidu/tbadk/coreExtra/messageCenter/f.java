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
    private static f doS;
    private a doT = aLH();
    private String doU;

    public static f aLG() {
        if (doS == null) {
            synchronized (f.class) {
                if (doS == null) {
                    doS = new f();
                }
            }
        }
        return doS;
    }

    private a aLH() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.doT != null) {
            return this.doT.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.doT != null) {
            this.doT.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.doT != null) {
            return this.doT.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.doT != null) {
            return this.doT.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.doT != null) {
            this.doT.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.doT != null) {
            this.doT.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.doT != null) {
            this.doT.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.doT != null) {
            return this.doT.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.doT != null) {
            return this.doT.a(activity, viewGroup);
        }
        return null;
    }

    public void ur(String str) {
        this.doU = str;
    }

    public String aLI() {
        return this.doU;
    }
}
