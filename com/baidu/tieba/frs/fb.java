package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.ax bjh;
    final /* synthetic */ fa bmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(fa faVar, com.baidu.tbadk.core.data.ax axVar) {
        this.bmw = faVar;
        this.bjh = axVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (this.bjh != null) {
            if (this.bjh.getAuthor() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.bmw.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bjh.getAuthor().getUserId(), this.bjh.getAuthor().getName_show(), this.bmw.bgq.avA().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
            }
            if (this.bjh.rt()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10241").ac("fid", String.valueOf(this.bjh.getFid())).s("obj_type", 2));
            }
        }
    }
}
