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
public class dz implements View.OnClickListener {
    final /* synthetic */ dx blc;
    private final /* synthetic */ com.baidu.tbadk.core.data.y bld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(dx dxVar, com.baidu.tbadk.core.data.y yVar) {
        this.blc = dxVar;
        this.bld = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tbadk.core.data.aa sE = this.bld.sE();
        if (com.baidu.adp.lib.util.i.iZ()) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.blc.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(sE.getUserId()), sE.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
            return;
        }
        this.blc.bdK.showToast(t.j.im_error_default);
    }
}
