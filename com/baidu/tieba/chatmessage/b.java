package com.baidu.tieba.chatmessage;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ag;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ ChatMessageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatMessageActivity chatMessageActivity) {
        this.a = chatMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        imageView = this.a.e;
        if (view == imageView && TbadkApplication.isLogin()) {
            TiebaStatic.eventStat(this.a, "msg_newchat_tab_c", "click", 1, new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ag(this.a, true)));
        }
    }
}
