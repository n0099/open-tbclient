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
    private static a csv;
    public BdUniqueId aTm;
    public boolean css;
    public int csp = -1;
    public int csq = 0;
    public int csr = -1;
    public boolean cst = false;
    private CustomMessageListener csu = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener afl = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a ahm() {
        a aVar;
        synchronized (a.class) {
            if (csv == null) {
                csv = new a();
            }
            aVar = csv;
        }
        return aVar;
    }

    public void onDestory() {
        this.csq = 0;
        if (this.aTm != null) {
            MessageManager.getInstance().unRegisterListener(this.aTm);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aTm = bdUniqueId;
            this.csu.setTag(bdUniqueId);
            this.afl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.csu);
            MessageManager.getInstance().registerListener(this.afl);
        }
    }

    public void br(List<TagInfo> list) {
        if (!y.t(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) y.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.csp = i2;
                            return;
                        }
                        this.csp = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
