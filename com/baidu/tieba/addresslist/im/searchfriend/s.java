package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ n azf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(n nVar) {
        this.azf = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        if (view.getTag(com.baidu.tieba.v.tag_second) instanceof com.baidu.tieba.addresslist.im.searchfriend.a.c) {
            com.baidu.tieba.addresslist.im.searchfriend.a.c cVar = (com.baidu.tieba.addresslist.im.searchfriend.a.c) view.getTag(com.baidu.tieba.v.tag_second);
            if (!UtilHelper.isNetOk()) {
                searchFriendActivity = this.azf.aze;
                searchFriendActivity.showToast(y.im_error_default);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            searchFriendActivity2 = this.azf.aze;
            messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(searchFriendActivity2.getPageContext().getPageActivity(), String.valueOf(cVar.getUserId()), cVar.getName(), null, AddFriendActivityConfig.TYPE_ADD_FRD)));
        }
    }
}
