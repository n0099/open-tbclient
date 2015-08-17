package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView alu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LivePlayingImageView livePlayingImageView) {
        this.alu = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.alu.getStatisticsKey())) {
            TiebaStatic.log(this.alu.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.zg().getGid() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(this.alu.getContext(), LivePlayingStatusMgr.zg().getGid())));
        }
    }
}
