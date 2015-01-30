package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView Va;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(LivePlayingImageView livePlayingImageView) {
        this.Va = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.Va.getStatisticsKey())) {
            com.baidu.tbadk.core.i.A(this.Va.getContext(), this.Va.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.tP().getGid() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.Va.getContext(), LivePlayingStatusMgr.tP().getGid())));
        }
    }
}
