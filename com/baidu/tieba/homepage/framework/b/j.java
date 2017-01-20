package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ e cwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.cwc = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        ImageView imageView;
        Context context2;
        Context context3;
        context = this.cwc.mContext;
        if (context != null) {
            this.cwc.fc(false);
            imageView = this.cwc.cvX;
            imageView.setVisibility(8);
            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("game_is_show_tip", false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.cwc.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(context2)));
            context3 = this.cwc.mContext;
            TiebaStatic.eventStat(context3, "tb_gamecenter", "click", 1, "ref_type", "601");
        }
    }
}
