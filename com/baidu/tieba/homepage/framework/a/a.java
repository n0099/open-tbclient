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
    private static a cyi;
    public BdUniqueId bbE;
    public boolean cyf;
    public int cyc = -1;
    public int cyd = 0;
    public int cye = -1;
    public boolean cyg = false;
    private CustomMessageListener cyh = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener amU = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a ajV() {
        a aVar;
        synchronized (a.class) {
            if (cyi == null) {
                cyi = new a();
            }
            aVar = cyi;
        }
        return aVar;
    }

    public void onDestory() {
        this.cyd = 0;
        if (this.bbE != null) {
            MessageManager.getInstance().unRegisterListener(this.bbE);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bbE = bdUniqueId;
            this.cyh.setTag(bdUniqueId);
            this.amU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cyh);
            MessageManager.getInstance().registerListener(this.amU);
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
                            this.cyc = i2;
                            return;
                        }
                        this.cyc = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
