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
public class fk implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.as bnE;
    final /* synthetic */ fj bri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(fj fjVar, com.baidu.tbadk.core.data.as asVar) {
        this.bri = fjVar;
        this.bnE = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (this.bnE != null) {
            if (this.bnE.getAuthor() != null) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.bri.mContext;
                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bnE.getAuthor().getUserId(), this.bnE.getAuthor().getName_show(), this.bri.bkq.avu().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
            }
            if (this.bnE.tV()) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10241").ac("fid", String.valueOf(this.bnE.getFid())).r("obj_type", 2));
            }
        }
    }
}
