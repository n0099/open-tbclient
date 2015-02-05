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
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x xVar;
        xVar = this.aBS.aBA;
        Object item = xVar.FC().getItem(i);
        if (item instanceof FriendFeedThreadData) {
            com.baidu.tbadk.core.i.A(this.aBS.getPageContext().getPageActivity(), "frd_news_topb");
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aBS.getPageContext().getPageActivity()).createNormalCfg(((FriendFeedThreadData) item).getId(), null, null)));
        }
    }
}
