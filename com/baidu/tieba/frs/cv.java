package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class cv implements View.OnClickListener {
    final /* synthetic */ ct aDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ct ctVar) {
        this.aDZ = ctVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view.getTag(com.baidu.tieba.v.tag_second) instanceof com.baidu.tbadk.core.data.p) {
            com.baidu.tbadk.core.data.p pVar = (com.baidu.tbadk.core.data.p) view.getTag(com.baidu.tieba.v.tag_second);
            if (UtilHelper.isNetOk()) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.aDZ.mContext;
                messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, String.valueOf(pVar.getUserId()), pVar.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
                return;
            }
            this.aDZ.aBz.showToast(com.baidu.tieba.y.im_error_default);
        }
    }
}
