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
    private static a coQ;
    public BdUniqueId bbl;
    public boolean coN;
    public int coK = -1;
    public int coL = 0;
    public int coM = -1;
    public boolean coO = false;
    private CustomMessageListener coP = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener ahW = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a aiG() {
        a aVar;
        synchronized (a.class) {
            if (coQ == null) {
                coQ = new a();
            }
            aVar = coQ;
        }
        return aVar;
    }

    public void onDestory() {
        this.coL = 0;
        if (this.bbl != null) {
            MessageManager.getInstance().unRegisterListener(this.bbl);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bbl = bdUniqueId;
            this.coP.setTag(bdUniqueId);
            this.ahW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.coP);
            MessageManager.getInstance().registerListener(this.ahW);
        }
    }

    public void bn(List<TagInfo> list) {
        if (!x.t(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) x.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.coK = i2;
                            return;
                        }
                        this.coK = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
