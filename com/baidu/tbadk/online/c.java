package com.baidu.tbadk.online;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import protobuf.GetOnlineInfo.Game;
/* loaded from: classes.dex */
class c extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Game game;
        if ((socketResponsedMessage instanceof GetOnLineInfoSocketResMessage) && ((GetOnLineInfoSocketResMessage) socketResponsedMessage).getError() == 0 && (game = ((GetOnLineInfoSocketResMessage) socketResponsedMessage).getGame()) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHOW_GAME_ICON, game));
        }
    }
}
