package com.baidu.tieba.im.group;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.m;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<m> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<m> run(CustomMessage<m> customMessage) {
        int e;
        Context context;
        com.baidu.tieba.im.model.h hVar;
        com.baidu.tieba.im.model.h hVar2;
        Context context2;
        int e2;
        if (customMessage != null && customMessage.getData() != null) {
            EnterChatRoomStatic.b = customMessage.getData().getContext();
            e = EnterChatRoomStatic.e();
            if (e > 0) {
                context2 = EnterChatRoomStatic.b;
                Resources resources = TbadkApplication.m252getInst().getContext().getResources();
                int i = y.group_tab_enterchatroom_freeze;
                e2 = EnterChatRoomStatic.e();
                j.a(context2, resources.getString(i, new StringBuilder(String.valueOf(e2)).toString()));
            } else {
                context = EnterChatRoomStatic.b;
                EnterChatRoomStatic.c = j.a(context, TbadkApplication.m252getInst().getContext().getResources().getString(y.group_tab_enterchatroom_loading), new h(this));
                hVar = EnterChatRoomStatic.a;
                hVar2 = EnterChatRoomStatic.a;
                hVar.a(hVar2.a(), true);
            }
        }
        return null;
    }
}
