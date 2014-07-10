package com.baidu.tieba.im.chat.notify;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        if (view.getId() == com.baidu.tieba.v.chat_head) {
            HeadImageView headImageView = (HeadImageView) view;
            String userId = headImageView.getUserId();
            String userName = headImageView.getUserName();
            String userName2 = headImageView.getUserName();
            if (TextUtils.isEmpty(userName2)) {
                if (userId != null && userId.length() > 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    fragmentActivity2 = this.a.e;
                    messageManager.sendMessage(new CustomMessage(2002003, new bb(fragmentActivity2, userId, userName)));
                }
            } else if (!userName2.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK) && !userName2.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) && !userName2.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE) && !userName2.equals("6") && userId != null && userId.length() > 0) {
                MessageManager messageManager2 = MessageManager.getInstance();
                fragmentActivity = this.a.e;
                messageManager2.sendMessage(new CustomMessage(2002003, new bb(fragmentActivity, userId, userName)));
            }
        }
    }
}
