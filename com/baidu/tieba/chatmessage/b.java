package com.baidu.tieba.chatmessage;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChatMessageActivity ajo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatMessageActivity chatMessageActivity) {
        this.ajo = chatMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        imageView = this.ajo.ajm;
        if (view == imageView && TbadkApplication.isLogin()) {
            TiebaStatic.eventStat(this.ajo, "msg_newchat_tab_c", "click", 1, new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig(this.ajo, true)));
        }
    }
}
