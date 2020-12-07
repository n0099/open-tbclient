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
    private static f fme;
    private a fmf = bzI();
    private String fmg;

    public static f bzH() {
        if (fme == null) {
            synchronized (f.class) {
                if (fme == null) {
                    fme = new f();
                }
            }
        }
        return fme;
    }

    private a bzI() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.fmf != null) {
            return this.fmf.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.fmf != null) {
            this.fmf.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.fmf != null) {
            return this.fmf.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.fmf != null) {
            return this.fmf.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.fmf != null) {
            this.fmf.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.fmf != null) {
            this.fmf.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.fmf != null) {
            this.fmf.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.fmf != null) {
            return this.fmf.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.fmf != null) {
            return this.fmf.a(activity, viewGroup);
        }
        return null;
    }

    public void Db(String str) {
        this.fmg = str;
    }

    public String bzJ() {
        return this.fmg;
    }
}
