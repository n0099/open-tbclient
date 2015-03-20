package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ n azf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.azf = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        com.baidu.tieba.addresslist.im.searchfriend.a.b bVar = (com.baidu.tieba.addresslist.im.searchfriend.a.b) view.getTag(com.baidu.tieba.v.tag_first);
        int intValue = ((Integer) view.getTag(com.baidu.tieba.v.tag_second)).intValue();
        searchFriendActivity = this.azf.aze;
        searchFriendActivity2 = this.azf.aze;
        searchFriendActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(searchFriendActivity2.getPageContext().getPageActivity()).createConfig(bVar.qs(), intValue, bVar.qo(), "", "", true, bVar.qs().get(bVar.qs().size() - 1), true, bVar.getAssistUrls())));
    }
}
