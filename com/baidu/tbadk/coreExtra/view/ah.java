package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView afm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(LivePlayingImageView livePlayingImageView) {
        this.afm = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.afm.getStatisticsKey())) {
            com.baidu.tbadk.core.k.A(this.afm.getContext(), this.afm.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.xj().getGid() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.afm.getContext(), LivePlayingStatusMgr.xj().getGid())));
        }
    }
}
