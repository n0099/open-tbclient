package com.baidu.tieba.addresslist.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ m aJD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar) {
        this.aJD = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        com.baidu.tieba.addresslist.im.searchfriend.a.b bVar = (com.baidu.tieba.addresslist.im.searchfriend.a.b) view.getTag(n.f.tag_first);
        int intValue = ((Integer) view.getTag(n.f.tag_second)).intValue();
        searchFriendActivity = this.aJD.aJC;
        searchFriendActivity2 = this.aJD.aJC;
        searchFriendActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(searchFriendActivity2.getPageContext().getPageActivity()).createConfig(bVar.sq(), intValue, bVar.sm(), "", "", true, bVar.sq().get(bVar.sq().size() - 1), true, bVar.getAssistUrls())));
    }
}
