package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a {
    private static a cIk;
    public BdUniqueId aMp;
    public int cIi = -1;
    public boolean cIj = false;
    private CustomMessageListener anV = new b(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a amr() {
        a aVar;
        synchronized (a.class) {
            if (cIk == null) {
                cIk = new a();
            }
            aVar = cIk;
        }
        return aVar;
    }

    public void onDestory() {
        if (this.aMp != null) {
            MessageManager.getInstance().unRegisterListener(this.aMp);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aMp = bdUniqueId;
            this.anV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.anV);
        }
    }
}
