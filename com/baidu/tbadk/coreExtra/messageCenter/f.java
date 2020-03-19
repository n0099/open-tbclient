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
    private static f dps;
    private a dpt = aLM();
    private String dpu;

    public static f aLL() {
        if (dps == null) {
            synchronized (f.class) {
                if (dps == null) {
                    dps = new f();
                }
            }
        }
        return dps;
    }

    private a aLM() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.dpt != null) {
            return this.dpt.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.dpt != null) {
            this.dpt.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.dpt != null) {
            return this.dpt.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.dpt != null) {
            return this.dpt.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.dpt != null) {
            this.dpt.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.dpt != null) {
            this.dpt.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.dpt != null) {
            this.dpt.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.dpt != null) {
            return this.dpt.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.dpt != null) {
            return this.dpt.a(activity, viewGroup);
        }
        return null;
    }

    public void us(String str) {
        this.dpu = str;
    }

    public String aLN() {
        return this.dpu;
    }
}
