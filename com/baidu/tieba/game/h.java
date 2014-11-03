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
    final /* synthetic */ GameCenterActivity aGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GameCenterActivity gameCenterActivity) {
        this.aGY = gameCenterActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Game Hl = l.Hk().Hl();
        String str = "";
        if (Hl != null && Hl.gameEnter != null) {
            str = Hl.gameEnter.libaoUrl;
        }
        if (TextUtils.isEmpty(str)) {
            str = "http://tieba.u9ka.yoyojie.com/";
        }
        this.aGY.sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.aGY, this.aGY.getString(com.baidu.tieba.y.game_tab_gift), str, true)));
        TiebaStatic.eventStat(this.aGY, "gamecenter_gift", "click");
    }
}
