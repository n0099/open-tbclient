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
    private static f edH;
    private a edI = bao();
    private String edJ;

    public static f ban() {
        if (edH == null) {
            synchronized (f.class) {
                if (edH == null) {
                    edH = new f();
                }
            }
        }
        return edH;
    }

    private a bao() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2156675, a.class);
        if (runTask != null) {
            return (a) runTask.getData();
        }
        return null;
    }

    public boolean isSignAlertOn() {
        if (this.edI != null) {
            return this.edI.isSignAlertOn();
        }
        return false;
    }

    public void setSignAlertOn(boolean z) {
        if (this.edI != null) {
            this.edI.setSignAlertOn(z);
        }
    }

    public int getSignAlertHours() {
        if (this.edI != null) {
            return this.edI.getSignAlertHours();
        }
        return 0;
    }

    public int getSignAlertMins() {
        if (this.edI != null) {
            return this.edI.getSignAlertMins();
        }
        return 0;
    }

    public void setSignAlertTime(int i, int i2) {
        if (this.edI != null) {
            this.edI.setSignAlertTime(i, i2);
        }
    }

    public void updateSignAlarm() {
        if (this.edI != null) {
            this.edI.updateSignAlarm();
        }
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        if (this.edI != null) {
            this.edI.a(tbPageContext, viewGroup);
        }
    }

    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        if (this.edI != null) {
            return this.edI.a(tbPageContext, eVar);
        }
        return null;
    }

    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (this.edI != null) {
            return this.edI.a(activity, viewGroup);
        }
        return null;
    }

    public void xp(String str) {
        this.edJ = str;
    }

    public String bap() {
        return this.edJ;
    }
}
