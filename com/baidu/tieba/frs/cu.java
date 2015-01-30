package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class cu implements View.OnClickListener {
    final /* synthetic */ cs aGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cs csVar) {
        this.aGO = csVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (view.getTag(com.baidu.tieba.w.tag_second) instanceof com.baidu.tbadk.core.data.u) {
            com.baidu.tbadk.core.data.u uVar = (com.baidu.tbadk.core.data.u) view.getTag(com.baidu.tieba.w.tag_second);
            if (UtilHelper.isNetOk()) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.aGO.mContext;
                messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, String.valueOf(uVar.getUserId()), uVar.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
                return;
            }
            this.aGO.aEd.showToast(com.baidu.tieba.z.im_error_default);
        }
    }
}
