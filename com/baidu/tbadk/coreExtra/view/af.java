package com.baidu.tbadk.coreExtra.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ LivePlayingImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(LivePlayingImageView livePlayingImageView) {
        this.a = livePlayingImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.a.getStatisticsKey())) {
            com.baidu.tbadk.core.g.a(this.a.getContext(), this.a.getStatisticsKey());
        }
        if (LivePlayingStatusMgr.a().c() != 0) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ae(this.a.getContext(), LivePlayingStatusMgr.a().c())));
        }
    }
}
