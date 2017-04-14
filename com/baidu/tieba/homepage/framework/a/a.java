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
    private static a cvR;
    public BdUniqueId baI;
    public boolean cvO;
    public int cvL = -1;
    public int cvM = 0;
    public int cvN = -1;
    public boolean cvP = false;
    private CustomMessageListener cvQ = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener amU = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a aiU() {
        a aVar;
        synchronized (a.class) {
            if (cvR == null) {
                cvR = new a();
            }
            aVar = cvR;
        }
        return aVar;
    }

    public void onDestory() {
        this.cvM = 0;
        if (this.baI != null) {
            MessageManager.getInstance().unRegisterListener(this.baI);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.baI = bdUniqueId;
            this.cvQ.setTag(bdUniqueId);
            this.amU.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvQ);
            MessageManager.getInstance().registerListener(this.amU);
        }
    }

    public void aZ(List<TagInfo> list) {
        if (!x.q(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) x.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.cvL = i2;
                            return;
                        }
                        this.cvL = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
