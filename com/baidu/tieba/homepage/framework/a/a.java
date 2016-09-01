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
    private static a cDD;
    public BdUniqueId aYu;
    public boolean cDA;
    public int cDx = -1;
    public int cDy = 0;
    public int cDz = -1;
    public boolean cDB = false;
    private CustomMessageListener cDC = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener aig = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a alX() {
        a aVar;
        synchronized (a.class) {
            if (cDD == null) {
                cDD = new a();
            }
            aVar = cDD;
        }
        return aVar;
    }

    public void onDestory() {
        this.cDy = 0;
        if (this.aYu != null) {
            MessageManager.getInstance().unRegisterListener(this.aYu);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aYu = bdUniqueId;
            this.cDC.setTag(bdUniqueId);
            this.aig.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cDC);
            MessageManager.getInstance().registerListener(this.aig);
        }
    }

    public void bt(List<TagInfo> list) {
        if (!y.t(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) y.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.cDx = i2;
                            return;
                        }
                        this.cDx = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
