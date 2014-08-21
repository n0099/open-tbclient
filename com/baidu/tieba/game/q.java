package com.baidu.tieba.game;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AdapterView.OnItemClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.a = nVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        List list2;
        GameCenterHomeActivity gameCenterHomeActivity;
        GameCenterHomeActivity gameCenterHomeActivity2;
        list = this.a.m;
        if (i < list.size()) {
            list2 = this.a.m;
            com.baidu.tbadk.game.b bVar = (com.baidu.tbadk.game.b) list2.get(i);
            if (bVar != null && bVar.i() != 1) {
                MessageManager messageManager = MessageManager.getInstance();
                gameCenterHomeActivity = this.a.b;
                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.w(gameCenterHomeActivity, bVar.a())));
                this.a.b(bVar.a());
                gameCenterHomeActivity2 = this.a.b;
                TiebaStatic.eventStat(gameCenterHomeActivity2, "game_detail", "click", 1, bVar.a());
            }
        }
    }
}
