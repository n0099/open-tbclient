package com.baidu.tieba.im;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialHistoryImageActivity;
import com.baidu.tieba.im.mygroup.PersonGroupActivity;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
/* loaded from: classes.dex */
public class TiebaIMActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(GroupChatActivityConfig.class, GroupChatActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialMsgImageActivityConfig.class, OfficialMsgImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialBarHistoryActivityConfig.class, OfficialBarHistoryActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialHistoryImageActivityConfig.class, OfficialHistoryImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(AddGroupActivityConfig.class, AddGroupActivity.class);
    }
}
