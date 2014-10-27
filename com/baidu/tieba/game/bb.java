package com.baidu.tieba.game;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ av aIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(av avVar) {
        this.aIW = avVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GameCenterActivity gameCenterActivity;
        GameCenterActivity gameCenterActivity2;
        GameCenterActivity gameCenterActivity3;
        if (!UtilHelper.isNetOk()) {
            gameCenterActivity3 = this.aIW.aIg;
            gameCenterActivity3.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        GameInfoData gameInfoData = (GameInfoData) view.getTag(com.baidu.tieba.v.tag_first);
        if (gameInfoData != null) {
            if (((Integer) view.getTag(com.baidu.tieba.v.tag_second)) != null) {
                gameCenterActivity2 = this.aIW.aIg;
                TiebaStatic.eventStat(gameCenterActivity2, "game_detail", "click", 1, new Object[0]);
            }
            if (gameInfoData.getMark() != 1) {
                MessageManager messageManager = MessageManager.getInstance();
                gameCenterActivity = this.aIW.aIg;
                messageManager.sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(gameCenterActivity, gameInfoData.getGameId(), "3000201")));
                com.baidu.tieba.game.a.a.Ij().a(view, gameInfoData);
            }
        }
    }
}
