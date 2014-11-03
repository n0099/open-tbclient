package com.baidu.tieba.game;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements AdapterView.OnItemClickListener {
    final /* synthetic */ av aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(av avVar) {
        this.aJj = avVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        List list2;
        GameCenterActivity gameCenterActivity;
        GameCenterActivity gameCenterActivity2;
        GameCenterActivity gameCenterActivity3;
        GameCenterActivity gameCenterActivity4;
        if (!UtilHelper.isNetOk()) {
            gameCenterActivity4 = this.aJj.aIs;
            gameCenterActivity4.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        list = this.aJj.aIN;
        if (i < list.size()) {
            list2 = this.aJj.aIN;
            GameInfoData gameInfoData = (GameInfoData) list2.get(i);
            if (gameInfoData != null && gameInfoData.getMark() != 1) {
                MessageManager messageManager = MessageManager.getInstance();
                gameCenterActivity = this.aJj.aIs;
                messageManager.sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(gameCenterActivity, gameInfoData.getGameId(), "3000201")));
                com.baidu.tieba.game.a.a In = com.baidu.tieba.game.a.a.In();
                gameCenterActivity2 = this.aJj.aIs;
                In.a(gameCenterActivity2.getUniqueId(), view, gameInfoData);
                gameCenterActivity3 = this.aJj.aIs;
                TiebaStatic.eventStat(gameCenterActivity3, "game_detail", "click", 1, gameInfoData.getGameId());
            }
        }
    }
}
