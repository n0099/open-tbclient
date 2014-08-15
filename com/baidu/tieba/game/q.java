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
        list = this.a.l;
        if (i < list.size()) {
            list2 = this.a.l;
            ab abVar = (ab) list2.get(i);
            if (abVar != null && abVar.i() != 1) {
                MessageManager messageManager = MessageManager.getInstance();
                gameCenterHomeActivity = this.a.a;
                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.v(gameCenterHomeActivity, abVar.a())));
                this.a.b(abVar.a());
                gameCenterHomeActivity2 = this.a.a;
                TiebaStatic.eventStat(gameCenterHomeActivity2, "game_detail", "click", 1, abVar.a());
            }
        }
    }
}
