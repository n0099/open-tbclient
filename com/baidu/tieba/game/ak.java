package com.baidu.tieba.game;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SelectFriendActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ GameWebViewActivity aIq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(GameWebViewActivity gameWebViewActivity) {
        this.aIq = gameWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        GameInfoData gameInfoData;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.aIq.aIl;
        if (dVar != null) {
            dVar2 = this.aIq.aIl;
            dVar2.dismiss();
            this.aIq.aIl = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectFriendActivityConfig(this.aIq, 23007, 0)));
        GameWebViewActivity gameWebViewActivity = this.aIq;
        gameInfoData = this.aIq.aIn;
        TiebaStatic.eventStat(gameWebViewActivity, "game_share_tbf", "click", 1, "dev_id", gameInfoData.getGameId(), "share_type", 5);
    }
}
