package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a {
    private static a cxr;
    public BdUniqueId baP;
    public boolean cxo;
    public int cxl = -1;
    public int cxm = 0;
    public int cxn = -1;
    public boolean cxp = false;
    private CustomMessageListener cxq = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener amG = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a aja() {
        a aVar;
        synchronized (a.class) {
            if (cxr == null) {
                cxr = new a();
            }
            aVar = cxr;
        }
        return aVar;
    }

    public void onDestory() {
        this.cxm = 0;
        if (this.baP != null) {
            MessageManager.getInstance().unRegisterListener(this.baP);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.baP = bdUniqueId;
            this.cxq.setTag(bdUniqueId);
            this.amG.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cxq);
            MessageManager.getInstance().registerListener(this.amG);
        }
    }

    public void ba(List<TagInfo> list) {
        if (!x.q(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) x.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.cxl = i2;
                            return;
                        }
                        this.cxl = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
