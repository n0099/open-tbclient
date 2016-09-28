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
    private static a cEh;
    public BdUniqueId aYW;
    public boolean cEe;
    public int cEb = -1;
    public int cEc = 0;
    public int cEd = -1;
    public boolean cEf = false;
    private CustomMessageListener cEg = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener ahO = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a aml() {
        a aVar;
        synchronized (a.class) {
            if (cEh == null) {
                cEh = new a();
            }
            aVar = cEh;
        }
        return aVar;
    }

    public void onDestory() {
        this.cEc = 0;
        if (this.aYW != null) {
            MessageManager.getInstance().unRegisterListener(this.aYW);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aYW = bdUniqueId;
            this.cEg.setTag(bdUniqueId);
            this.ahO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cEg);
            MessageManager.getInstance().registerListener(this.ahO);
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
                            this.cEb = i2;
                            return;
                        }
                        this.cEb = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
