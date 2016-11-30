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
    private static a cJv;
    public BdUniqueId bcf;
    public boolean cJs;
    public int cJp = -1;
    public int cJq = 0;
    public int cJr = -1;
    public boolean cJt = false;
    private CustomMessageListener cJu = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener aiv = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a aog() {
        a aVar;
        synchronized (a.class) {
            if (cJv == null) {
                cJv = new a();
            }
            aVar = cJv;
        }
        return aVar;
    }

    public void onDestory() {
        this.cJq = 0;
        if (this.bcf != null) {
            MessageManager.getInstance().unRegisterListener(this.bcf);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bcf = bdUniqueId;
            this.cJu.setTag(bdUniqueId);
            this.aiv.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cJu);
            MessageManager.getInstance().registerListener(this.aiv);
        }
    }

    public void bv(List<TagInfo> list) {
        if (!x.t(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) x.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.cJp = i2;
                            return;
                        }
                        this.cJp = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
