package com.baidu.tieba.friendfeed;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x xVar;
        xVar = this.aBV.aBD;
        Object item = xVar.FI().getItem(i);
        if (item instanceof FriendFeedThreadData) {
            com.baidu.tbadk.core.i.A(this.aBV.getPageContext().getPageActivity(), "frd_news_topb");
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aBV.getPageContext().getPageActivity()).createNormalCfg(((FriendFeedThreadData) item).getId(), null, null)));
        }
    }
}
