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
    private static f eRk;
    private a eRl = bsz();
    private String eRm;

    public static f bsy() {
        if (eRk == null) {
            synchronized (f.class) {
                if (eRk == null) {
                    eRk = new f();
                }
            }
        }
        return eRk;
    }

    private a bsz() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.eRl != null) {
            return this.eRl.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.eRl != null) {
            this.eRl.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.eRl != null) {
            return this.eRl.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.eRl != null) {
            return this.eRl.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.eRl != null) {
            this.eRl.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.eRl != null) {
            this.eRl.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.eRl != null) {
            this.eRl.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.eRl != null) {
            return this.eRl.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.eRl != null) {
            return this.eRl.a(activity, viewGroup);
        }
        return null;
    }

    public void Cn(String str) {
        this.eRm = str;
    }

    public String bsA() {
        return this.eRm;
    }
}
