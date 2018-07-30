package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.db.l;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class OfficialBarChatActivityStatic {
    static {
        OfficalBarChatActivityConfig.IS_SUPPORT_OFFICIAL_CHAT = true;
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new CustomMessageTask.CustomRunnable<OfficalBarChatActivityConfig>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<OfficalBarChatActivityConfig> run(final CustomMessage<OfficalBarChatActivityConfig> customMessage) {
                UserData userData;
                if (customMessage != null && customMessage.getData() != null && (userData = customMessage.getData().getUserData()) != null) {
                    final LinkedList linkedList = new LinkedList();
                    linkedList.add(String.valueOf(userData.getUserId()));
                    v.b(new u<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivityStatic.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.u
                        /* renamed from: Rs */
                        public Void doInBackground() {
                            return l.aJP().o(linkedList);
                        }
                    }, new g<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivityStatic.1.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tbadk.util.g
                        /* renamed from: a */
                        public void onReturnDataInUI(Void r5) {
                            if (((OfficalBarChatActivityConfig) customMessage.getData()).getUserData().getUserIdLong() != 0) {
                                ((OfficalBarChatActivityConfig) customMessage.getData()).startActivity(OfficialBarChatActivity.class);
                            }
                        }
                    });
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ay.zK().a(new ay.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivityStatic.2
            @Override // com.baidu.tbadk.core.util.ay.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("jump_official_chat=1")) {
                    String at = z.at(str, "barid=");
                    String at2 = z.at(str, "barname=");
                    String at3 = z.at(str, "portrait=");
                    if (at != null && at.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(at, 0L), at2, at3, 0)));
                    }
                    return 1;
                }
                return 3;
            }
        });
    }
}
