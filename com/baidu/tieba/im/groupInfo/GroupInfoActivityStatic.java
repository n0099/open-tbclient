package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes3.dex */
public class GroupInfoActivityStatic {
    static {
        aJJ();
        aAj();
    }

    private static void aJJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008011, new CustomMessageTask.CustomRunnable<GroupInfoActivityConfig>() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<GroupInfoActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    int intExtra = customMessage.getData().getIntent().getIntExtra(GroupInfoActivityConfig.REQUEST_CODE, -1);
                    if (intExtra != -1) {
                        customMessage.getData().startActivityForResult(intExtra, GroupInfoActivity.class);
                    } else {
                        customMessage.getData().startActivity(GroupInfoActivity.class);
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aAj() {
        ay.Ef().a(new ay.a() { // from class: com.baidu.tieba.im.groupInfo.GroupInfoActivityStatic.2
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("tieba.baidu.com/group/index?id=")) {
                    int indexOf = str.indexOf("tieba.baidu.com/group/index?id=") + "tieba.baidu.com/group/index?id=".length();
                    int lastIndexOf = str.lastIndexOf(38);
                    if (lastIndexOf == -1 || lastIndexOf < indexOf) {
                        lastIndexOf = str.length();
                    }
                    long d = com.baidu.adp.lib.g.b.d(str.substring(indexOf, lastIndexOf), 0L);
                    if (d <= 0) {
                        return 3;
                    }
                    GroupInfoActivityConfig groupInfoActivityConfig = new GroupInfoActivityConfig(tbPageContext.getPageActivity(), d, 0);
                    if (tbPageContext.getOrignalPage() instanceof BaseActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                        return 1;
                    } else if (tbPageContext.getOrignalPage() instanceof BaseFragmentActivity) {
                        tbPageContext.sendMessage(new CustomMessage(2008011, groupInfoActivityConfig));
                        return 1;
                    }
                }
                return 3;
            }
        });
    }
}
