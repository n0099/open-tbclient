package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ e cys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.cys = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        ImageView imageView;
        TbPageContext tbPageContext;
        Context context2;
        context = this.cys.mContext;
        if (context != null) {
            this.cys.fd(false);
            imageView = this.cys.cyn;
            imageView.setVisibility(8);
            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("game_is_show_tip", false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.cys.ajU;
            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_CENTER_START, tbPageContext));
            context2 = this.cys.mContext;
            TiebaStatic.eventStat(context2, "tb_gamecenter", "click", 1, "ref_type", "601");
        }
    }
}
