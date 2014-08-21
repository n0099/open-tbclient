package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag() instanceof com.baidu.tieba.im.searchfriend.a.c) {
            com.baidu.tieba.im.searchfriend.a.c cVar = (com.baidu.tieba.im.searchfriend.a.c) view.getTag();
            if (!UtilHelper.isNetOk() || cVar == null) {
                searchFriendActivity = this.a.b;
                searchFriendActivity.showToast(x.im_error_default);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.a.b;
            messageManager.sendMessage(new CustomMessage(2002003, new bh(searchFriendActivity2, String.valueOf(cVar.c()), cVar.e(), null, "add_frd")));
        }
    }
}
