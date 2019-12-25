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
    private static f dku;
    private a dkv = aIS();
    private String dkw;

    public static f aIR() {
        if (dku == null) {
            synchronized (f.class) {
                if (dku == null) {
                    dku = new f();
                }
            }
        }
        return dku;
    }

    private a aIS() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.dkv != null) {
            return this.dkv.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.dkv != null) {
            this.dkv.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.dkv != null) {
            return this.dkv.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.dkv != null) {
            return this.dkv.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.dkv != null) {
            this.dkv.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.dkv != null) {
            this.dkv.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.dkv != null) {
            this.dkv.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.dkv != null) {
            return this.dkv.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.dkv != null) {
            return this.dkv.a(activity, viewGroup);
        }
        return null;
    }

    public void tV(String str) {
        this.dkw = str;
    }

    public String aIT() {
        return this.dkw;
    }
}
