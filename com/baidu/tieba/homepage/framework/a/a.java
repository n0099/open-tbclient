package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a cug;
    public BdUniqueId aLk;
    public int cue = -1;
    public boolean cuf = false;
    private CustomMessageListener amZ = new b(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a ahr() {
        a aVar;
        synchronized (a.class) {
            if (cug == null) {
                cug = new a();
            }
            aVar = cug;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aLk != null) {
            MessageManager.getInstance().unRegisterListener(this.aLk);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aLk = bdUniqueId;
            this.amZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amZ);
        }
    }
}
