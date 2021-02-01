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
    private static f fty;
    private String ftA;
    private a ftz = byB();

    public static f byA() {
        if (fty == null) {
            synchronized (f.class) {
                if (fty == null) {
                    fty = new f();
                }
            }
        }
        return fty;
    }

    private a byB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.ftz != null) {
            return this.ftz.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.ftz != null) {
            this.ftz.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.ftz != null) {
            return this.ftz.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.ftz != null) {
            return this.ftz.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.ftz != null) {
            this.ftz.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.ftz != null) {
            this.ftz.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.ftz != null) {
            this.ftz.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.ftz != null) {
            return this.ftz.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.ftz != null) {
            return this.ftz.a(activity, viewGroup);
        }
        return null;
    }

    public void Ce(String str) {
        this.ftA = str;
    }

    public String byC() {
        return this.ftA;
    }
}
