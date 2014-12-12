package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ n bmL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.bmL = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) view.getTag(w.tag_first);
        int intValue = ((Integer) view.getTag(w.tag_second)).intValue();
        searchFriendActivity = this.bmL.bmK;
        searchFriendActivity2 = this.bmL.bmK;
        searchFriendActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(searchFriendActivity2.getPageContext().getPageActivity()).createConfig(bVar.nh(), intValue, bVar.nd(), "", "", true, bVar.nh().get(bVar.nh().size() - 1), true)));
    }
}
