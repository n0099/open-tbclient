package com.baidu.tieba.game;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import protobuf.GetOnlineInfo.Game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ GameCenterActivity aGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GameCenterActivity gameCenterActivity) {
        this.aGO = gameCenterActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Game Hj = l.Hi().Hj();
        String str = "";
        if (Hj != null && Hj.gameEnter != null) {
            str = Hj.gameEnter.libaoUrl;
        }
        if (TextUtils.isEmpty(str)) {
            str = "http://tieba.u9ka.yoyojie.com/";
        }
        this.aGO.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aGO, this.aGO.getString(com.baidu.tieba.y.game_tab_gift), str, true)));
        TiebaStatic.eventStat(this.aGO, "gamecenter_gift", "click");
    }
}
