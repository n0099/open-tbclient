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
    private static f frf;
    private a frg = byj();
    private String frh;

    public static f byi() {
        if (frf == null) {
            synchronized (f.class) {
                if (frf == null) {
                    frf = new f();
                }
            }
        }
        return frf;
    }

    private a byj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.frg != null) {
            return this.frg.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.frg != null) {
            this.frg.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.frg != null) {
            return this.frg.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.frg != null) {
            return this.frg.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.frg != null) {
            this.frg.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.frg != null) {
            this.frg.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.frg != null) {
            this.frg.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.frg != null) {
            return this.frg.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.frg != null) {
            return this.frg.a(activity, viewGroup);
        }
        return null;
    }

    public void BN(String str) {
        this.frh = str;
    }

    public String byk() {
        return this.frh;
    }
}
