package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BackupLiveRoomChatActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView OI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LivePlayingImageView livePlayingImageView) {
        this.OI = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.OI.getStatisticsKey())) {
            com.baidu.tbadk.core.j.l(this.OI.getContext(), this.OI.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.qg().getGid() != 0) {
            if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.OI.getContext(), LivePlayingStatusMgr.qg().getGid())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BackupLiveRoomChatActivityConfig(this.OI.getContext(), LivePlayingStatusMgr.qg().getGid())));
            }
        }
    }
}
