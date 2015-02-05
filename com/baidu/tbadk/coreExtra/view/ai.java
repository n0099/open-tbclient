package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView UX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(LivePlayingImageView livePlayingImageView) {
        this.UX = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.UX.getStatisticsKey())) {
            com.baidu.tbadk.core.i.A(this.UX.getContext(), this.UX.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.tJ().getGid() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.UX.getContext(), LivePlayingStatusMgr.tJ().getGid())));
        }
    }
}
