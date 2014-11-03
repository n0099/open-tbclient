package com.baidu.tbadk.online;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import protobuf.GetOnlineInfo.Game;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Game game;
        boolean q;
        if (!(socketResponsedMessage instanceof GetOnLineInfoSocketResMessage) || ((GetOnLineInfoSocketResMessage) socketResponsedMessage).getError() != 0 || (game = ((GetOnLineInfoSocketResMessage) socketResponsedMessage).getGame()) == null) {
            return;
        }
        q = GetOnLineInfoStatic.q(game.game_last_launchtime.longValue());
        if (!q) {
            return;
        }
        GetOnLineInfoStatic.ut();
    }
}
