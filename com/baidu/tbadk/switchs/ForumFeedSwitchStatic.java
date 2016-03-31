package com.baidu.tbadk.switchs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.c.e;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ForumFeedSwitchStatic extends a {
    static {
        e.gE().f(ForumFeedSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FORUM_FEED_SWITCH_CHANGE, Integer.valueOf(i)));
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "mygroup_states";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 2;
    }
}
