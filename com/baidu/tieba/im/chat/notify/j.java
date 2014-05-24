package com.baidu.tieba.im.chat.notify;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        Activity activity2;
        if (view.getId() == v.chat_head) {
            HeadImageView headImageView = (HeadImageView) view;
            String userId = headImageView.getUserId();
            String userName = headImageView.getUserName();
            String userName2 = headImageView.getUserName();
            if (TextUtils.isEmpty(userName2)) {
                if (userId != null && userId.length() > 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    activity2 = this.a.e;
                    messageManager.sendMessage(new CustomMessage(2003003, new at(activity2, userId, userName)));
                }
            } else if (!userName2.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK) && !userName2.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) && !userName2.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE) && !userName2.equals("6") && userId != null && userId.length() > 0) {
                MessageManager messageManager2 = MessageManager.getInstance();
                activity = this.a.e;
                messageManager2.sendMessage(new CustomMessage(2003003, new at(activity, userId, userName)));
            }
        }
    }
}
