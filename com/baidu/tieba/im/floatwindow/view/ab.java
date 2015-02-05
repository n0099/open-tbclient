package com.baidu.tieba.im.floatwindow.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ FloatingPersonalChatActivity baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.baa = floatingPersonalChatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<UserData> list;
        String str;
        FloatingPersonalChatView floatingPersonalChatView;
        String str2;
        String str3;
        String str4;
        list = FloatingPersonalChatActivity.mUserDataList;
        for (UserData userData : list) {
            if (userData != null) {
                str = this.baa.ahP;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.baa.aZY;
                    str2 = this.baa.ahP;
                    int gF = floatingPersonalChatView.gF(str2);
                    if (gF == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.baa.getPageContext().getContext();
                        str4 = this.baa.ahP;
                        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (gF == 4) {
                        com.baidu.tbadk.newFriends.a yM = com.baidu.tbadk.newFriends.a.yM();
                        str3 = this.baa.ahP;
                        yM.c(com.baidu.adp.lib.g.c.a(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
