package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView afe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(LivePlayingImageView livePlayingImageView) {
        this.afe = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.afe.getStatisticsKey())) {
            com.baidu.tbadk.core.k.A(this.afe.getContext(), this.afe.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.xd().getGid() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.afe.getContext(), LivePlayingStatusMgr.xd().getGid())));
        }
    }
}
