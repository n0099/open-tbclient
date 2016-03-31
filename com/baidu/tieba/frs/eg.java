package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eg implements View.OnClickListener {
    final /* synthetic */ ee bqs;
    private final /* synthetic */ com.baidu.tbadk.core.data.ai bqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ee eeVar, com.baidu.tbadk.core.data.ai aiVar) {
        this.bqs = eeVar;
        this.bqt = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.ak sz = this.bqt.sz();
        if (com.baidu.adp.lib.util.i.jf()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bqs.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(sz.getUserId()), sz.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.bqs.bix.showToast(t.j.im_error_default);
    }
}
