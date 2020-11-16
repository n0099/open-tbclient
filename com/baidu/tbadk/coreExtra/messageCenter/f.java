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
    private static f feF;
    private a feG = bwi();
    private String feH;

    public static f bwh() {
        if (feF == null) {
            synchronized (f.class) {
                if (feF == null) {
                    feF = new f();
                }
            }
        }
        return feF;
    }

    private a bwi() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.feG != null) {
            return this.feG.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.feG != null) {
            this.feG.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.feG != null) {
            return this.feG.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.feG != null) {
            return this.feG.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.feG != null) {
            this.feG.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.feG != null) {
            this.feG.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.feG != null) {
            this.feG.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.feG != null) {
            return this.feG.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.feG != null) {
            return this.feG.a(activity, viewGroup);
        }
        return null;
    }

    public void Ct(String str) {
        this.feH = str;
    }

    public String bwj() {
        return this.feH;
    }
}
