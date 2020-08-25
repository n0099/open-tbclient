package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class f {
    private static f eCU;
    private a eCV = boU();
    private String eCW;

    public static f boT() {
        if (eCU == null) {
            synchronized (f.class) {
                if (eCU == null) {
                    eCU = new f();
                }
            }
        }
        return eCU;
    }

    private a boU() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.eCV != null) {
            return this.eCV.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.eCV != null) {
            this.eCV.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.eCV != null) {
            return this.eCV.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.eCV != null) {
            return this.eCV.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.eCV != null) {
            this.eCV.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.eCV != null) {
            this.eCV.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.eCV != null) {
            this.eCV.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.eCV != null) {
            return this.eCV.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.eCV != null) {
            return this.eCV.a(activity, viewGroup);
        }
        return null;
    }

    public void Be(String str) {
        this.eCW = str;
    }

    public String boV() {
        return this.eCW;
    }
}
