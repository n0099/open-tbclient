package com.baidu.tieba.game;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameSearchActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ GameCenterActivity aGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GameCenterActivity gameCenterActivity) {
        this.aGY = gameCenterActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aGY.sendMessage(new CustomMessage(2002001, new GameSearchActivityConfig(this.aGY)));
    }
}
