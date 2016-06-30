package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a {
    private static a cpQ;
    public BdUniqueId aSq;
    public boolean cpN;
    public int cpK = -1;
    public int cpL = 0;
    public int cpM = -1;
    public boolean cpO = false;
    private CustomMessageListener cpP = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener aex = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a agG() {
        a aVar;
        synchronized (a.class) {
            if (cpQ == null) {
                cpQ = new a();
            }
            aVar = cpQ;
        }
        return aVar;
    }

    public void onDestory() {
        this.cpL = 0;
        if (this.aSq != null) {
            MessageManager.getInstance().unRegisterListener(this.aSq);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aSq = bdUniqueId;
            this.cpP.setTag(bdUniqueId);
            this.aex.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cpP);
            MessageManager.getInstance().registerListener(this.aex);
        }
    }

    public void bn(List<TagInfo> list) {
        if (!y.t(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) y.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.cpK = i2;
                            return;
                        }
                        this.cpK = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
