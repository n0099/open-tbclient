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
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.aYF = floatingPersonalChatActivity;
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
                str = this.aYF.ahu;
                if (TextUtils.equals(str, userData.getUserId())) {
                    floatingPersonalChatView = this.aYF.aYD;
                    str2 = this.aYF.ahu;
                    int gD = floatingPersonalChatView.gD(str2);
                    if (gD == 0) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Context context = this.aYF.getPageContext().getContext();
                        str4 = this.aYF.ahu;
                        messageManager.sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(context, String.valueOf(str4), userData.getUserName(), userData.getPortrait(), null, false, AddFriendActivityConfig.TYPE_FRS_RECOM)));
                        return;
                    } else if (gD == 4) {
                        com.baidu.tbadk.newFriends.a yC = com.baidu.tbadk.newFriends.a.yC();
                        str3 = this.aYF.ahu;
                        yC.c(com.baidu.adp.lib.g.c.a(str3, 0L), AddFriendActivityConfig.TYPE_STRANGER_CHAT);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
