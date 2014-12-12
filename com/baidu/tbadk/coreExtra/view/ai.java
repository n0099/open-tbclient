package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView Ut;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(LivePlayingImageView livePlayingImageView) {
        this.Ut = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.Ut.getStatisticsKey())) {
            com.baidu.tbadk.core.i.B(this.Ut.getContext(), this.Ut.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.ty().getGid() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(this.Ut.getContext(), LivePlayingStatusMgr.ty().getGid())));
        }
    }
}
