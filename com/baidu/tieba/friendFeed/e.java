package com.baidu.tieba.friendFeed;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        y yVar;
        yVar = this.aHM.aHt;
        Object item = yVar.Jb().getItem(i);
        if (item instanceof FriendFeedThreadData) {
            com.baidu.tbadk.core.k.A(this.aHM.getPageContext().getPageActivity(), "frd_news_topb");
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aHM.getPageContext().getPageActivity()).createNormalCfg(((FriendFeedThreadData) item).getId(), null, null)));
        }
    }
}
