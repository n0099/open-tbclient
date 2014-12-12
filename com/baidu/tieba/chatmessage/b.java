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
    final /* synthetic */ ChatMessageActivity arG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChatMessageActivity chatMessageActivity) {
        this.arG = chatMessageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        imageView = this.arG.arE;
        if (view == imageView && TbadkApplication.isLogin()) {
            TiebaStatic.eventStat(this.arG.getPageContext().getContext(), "msg_newchat_tab_c", "click", 1, new Object[0]);
            TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new InviteFriendListActivityConfig(this.arG.getPageContext().getPageActivity(), true)));
        }
    }
}
