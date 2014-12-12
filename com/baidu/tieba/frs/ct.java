package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class ct implements View.OnClickListener {
    final /* synthetic */ cr aFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.aFE = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view.getTag(com.baidu.tieba.w.tag_second) instanceof com.baidu.tbadk.core.data.t) {
            com.baidu.tbadk.core.data.t tVar = (com.baidu.tbadk.core.data.t) view.getTag(com.baidu.tieba.w.tag_second);
            if (UtilHelper.isNetOk()) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.aFE.mContext;
                messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, String.valueOf(tVar.getUserId()), tVar.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
                return;
            }
            this.aFE.aDc.showToast(com.baidu.tieba.z.im_error_default);
        }
    }
}
