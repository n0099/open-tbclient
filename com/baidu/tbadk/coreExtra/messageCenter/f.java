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
    private static f dpf;
    private a dpg = aLI();
    private String dph;

    public static f aLH() {
        if (dpf == null) {
            synchronized (f.class) {
                if (dpf == null) {
                    dpf = new f();
                }
            }
        }
        return dpf;
    }

    private a aLI() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.dpg != null) {
            return this.dpg.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.dpg != null) {
            this.dpg.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.dpg != null) {
            return this.dpg.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.dpg != null) {
            return this.dpg.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.dpg != null) {
            this.dpg.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.dpg != null) {
            this.dpg.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.dpg != null) {
            this.dpg.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.dpg != null) {
            return this.dpg.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.dpg != null) {
            return this.dpg.a(activity, viewGroup);
        }
        return null;
    }

    public void us(String str) {
        this.dph = str;
    }

    public String aLJ() {
        return this.dph;
    }
}
