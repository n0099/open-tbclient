package com.baidu.tieba.friendfeed;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemClickListener {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t tVar;
        tVar = this.a.c;
        Object item = tVar.c().getItem(i);
        if (item instanceof FriendFeedThreadData) {
            com.baidu.tbadk.core.f.a(this.a, "frd_news_topb");
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bb(this.a).a(((FriendFeedThreadData) item).getId(), null, null)));
        }
    }
}
