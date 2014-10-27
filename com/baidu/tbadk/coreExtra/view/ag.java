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
    final /* synthetic */ LivePlayingImageView OE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LivePlayingImageView livePlayingImageView) {
        this.OE = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.OE.getStatisticsKey())) {
            com.baidu.tbadk.core.i.l(this.OE.getContext(), this.OE.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.qe().getGid() != 0) {
            if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.OE.getContext(), LivePlayingStatusMgr.qe().getGid())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BackupLiveRoomChatActivityConfig(this.OE.getContext(), LivePlayingStatusMgr.qe().getGid())));
            }
        }
    }
}
