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
    private static f fuX;
    private a fuY = byE();
    private String fuZ;

    public static f byD() {
        if (fuX == null) {
            synchronized (f.class) {
                if (fuX == null) {
                    fuX = new f();
                }
            }
        }
        return fuX;
    }

    private a byE() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.fuY != null) {
            return this.fuY.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.fuY != null) {
            this.fuY.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.fuY != null) {
            return this.fuY.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.fuY != null) {
            return this.fuY.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.fuY != null) {
            this.fuY.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.fuY != null) {
            this.fuY.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.fuY != null) {
            this.fuY.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.fuY != null) {
            return this.fuY.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.fuY != null) {
            return this.fuY.a(activity, viewGroup);
        }
        return null;
    }

    public void Cl(String str) {
        this.fuZ = str;
    }

    public String byF() {
        return this.fuZ;
    }
}
