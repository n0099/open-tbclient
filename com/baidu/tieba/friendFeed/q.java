package com.baidu.tieba.friendFeed;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aHY = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        FriendFeedActivity friendFeedActivity;
        z = this.aHY.aHO;
        if (z) {
            z2 = this.aHY.aHV;
            if (!z2) {
                this.aHY.aHV = true;
                ((ProgressBar) view.findViewById(com.baidu.tieba.v.more_progress)).setVisibility(0);
                ((TextView) view.findViewById(com.baidu.tieba.v.more_title)).setText(com.baidu.tieba.y.friendfeed_list_more);
                friendFeedActivity = this.aHY.aHN;
                friendFeedActivity.loadMore();
            }
        }
    }
}
