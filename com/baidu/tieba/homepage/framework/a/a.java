package com.baidu.tieba.homepage.framework.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.w;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a {
    private static a cvS;
    public BdUniqueId aUC;
    public boolean cvP;
    public int cvM = -1;
    public int cvN = 0;
    public int cvO = -1;
    public boolean cvQ = false;
    private CustomMessageListener cvR = new b(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener ahk = new c(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized a ajO() {
        a aVar;
        synchronized (a.class) {
            if (cvS == null) {
                cvS = new a();
            }
            aVar = cvS;
        }
        return aVar;
    }

    public void onDestory() {
        this.cvN = 0;
        if (this.aUC != null) {
            MessageManager.getInstance().unRegisterListener(this.aUC);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aUC = bdUniqueId;
            this.cvR.setTag(bdUniqueId);
            this.ahk.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvR);
            MessageManager.getInstance().registerListener(this.ahk);
        }
    }

    public void bt(List<TagInfo> list) {
        if (!w.s(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) w.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.cvM = i2;
                            return;
                        }
                        this.cvM = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
