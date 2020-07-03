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
    private static f emp;
    private a emq = bcr();
    private String emr;

    public static f bcq() {
        if (emp == null) {
            synchronized (f.class) {
                if (emp == null) {
                    emp = new f();
                }
            }
        }
        return emp;
    }

    private a bcr() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.emq != null) {
            return this.emq.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.emq != null) {
            this.emq.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.emq != null) {
            return this.emq.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.emq != null) {
            return this.emq.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.emq != null) {
            this.emq.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.emq != null) {
            this.emq.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.emq != null) {
            this.emq.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.emq != null) {
            return this.emq.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.emq != null) {
            return this.emq.a(activity, viewGroup);
        }
        return null;
    }

    public void xI(String str) {
        this.emr = str;
    }

    public String bcs() {
        return this.emr;
    }
}
