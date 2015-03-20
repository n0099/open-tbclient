package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
/* loaded from: classes.dex */
public class GroupMsgImageActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(GroupMsgImageActivityConfig.class, GroupMsgImageActivity.class);
    }
}
