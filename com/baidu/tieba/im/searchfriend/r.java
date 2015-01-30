package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ n boi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.boi = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) view.getTag(w.tag_first);
        int intValue = ((Integer) view.getTag(w.tag_second)).intValue();
        searchFriendActivity = this.boi.boh;
        searchFriendActivity2 = this.boi.boh;
        searchFriendActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(searchFriendActivity2.getPageContext().getPageActivity()).createConfig(bVar.nj(), intValue, bVar.nf(), "", "", true, bVar.nj().get(bVar.nj().size() - 1), true)));
    }
}
