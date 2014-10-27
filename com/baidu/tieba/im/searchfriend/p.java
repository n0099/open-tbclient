package com.baidu.tieba.im.searchfriend;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ l bhU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bhU = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SearchFriendActivity searchFriendActivity;
        SearchFriendActivity searchFriendActivity2;
        com.baidu.tieba.im.searchfriend.a.b bVar = (com.baidu.tieba.im.searchfriend.a.b) view.getTag(v.tag_first);
        int intValue = ((Integer) view.getTag(v.tag_second)).intValue();
        searchFriendActivity = this.bhU.bhT;
        searchFriendActivity2 = this.bhU.bhT;
        searchFriendActivity.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(searchFriendActivity2).createConfig(bVar.ko(), intValue, bVar.kk(), "", "", true, bVar.ko().get(bVar.ko().size() - 1), true)));
    }
}
