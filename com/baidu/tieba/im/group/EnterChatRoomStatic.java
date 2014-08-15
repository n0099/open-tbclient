package com.baidu.tieba.im.group;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class EnterChatRoomStatic {
    private static com.baidu.tieba.im.model.h a;
    private static Context b;
    private static ProgressDialog c;

    static {
        g gVar = new g(0);
        a = new com.baidu.tieba.im.model.h(b);
        a.registerListener(gVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(2008020, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e() {
        String[] split;
        String a2 = com.baidu.tbadk.core.sharedPref.b.a().a("chat_room_cool_down", "");
        if (TextUtils.isEmpty(a2) || (split = a2.split("_")) == null || split.length != 2) {
            return 0;
        }
        String str = split[0];
        String str2 = split[1];
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount) || !currentAccount.equals(str)) {
            return 0;
        }
        long a3 = com.baidu.adp.lib.e.b.a(str2, 0L) - System.currentTimeMillis();
        if (a3 > 0) {
            int i = (int) ((a3 / 1000) / 60);
            if (i > 0) {
                return i;
            }
            return 1;
        }
        return 0;
    }
}
