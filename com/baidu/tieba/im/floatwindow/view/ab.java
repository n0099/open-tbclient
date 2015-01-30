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
    final /* synthetic */ FloatingPersonalChatActivity bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bab = floatingPersonalChatActivity;
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
                str = this.bab.ahS;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.bab.aZZ;
                    str2 = this.bab.ahS;
                    int gI = floatingPersonalChatView.gI(str2);
                    if (gI == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.bab.getPageContext().getContext();
                        str4 = this.bab.ahS;
                        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (gI == 4) {
                        com.baidu.tbadk.newFriends.a yS = com.baidu.tbadk.newFriends.a.yS();
                        str3 = this.bab.ahS;
                        yS.c(com.baidu.adp.lib.g.c.a(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
