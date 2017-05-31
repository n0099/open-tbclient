package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a cAy;
    public BdUniqueId aKZ;
    public int cAw = -1;
    public boolean cAx = false;
    private CustomMessageListener amV = new b(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a aiG() {
        a aVar;
        synchronized (a.class) {
            if (cAy == null) {
                cAy = new a();
            }
            aVar = cAy;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aKZ != null) {
            MessageManager.getInstance().unRegisterListener(this.aKZ);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aKZ = bdUniqueId;
            this.amV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.amV);
        }
    }
}
