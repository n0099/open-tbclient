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
    private static f ffx;
    private a ffy = bwS();
    private String ffz;

    public static f bwR() {
        if (ffx == null) {
            synchronized (f.class) {
                if (ffx == null) {
                    ffx = new f();
                }
            }
        }
        return ffx;
    }

    private a bwS() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.ffy != null) {
            return this.ffy.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.ffy != null) {
            this.ffy.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.ffy != null) {
            return this.ffy.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.ffy != null) {
            return this.ffy.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.ffy != null) {
            this.ffy.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.ffy != null) {
            this.ffy.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.ffy != null) {
            this.ffy.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.ffy != null) {
            return this.ffy.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.ffy != null) {
            return this.ffy.a(activity, viewGroup);
        }
        return null;
    }

    public void CU(String str) {
        this.ffz = str;
    }

    public String bwT() {
        return this.ffz;
    }
}
