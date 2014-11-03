package com.baidu.tieba.game.hot;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aKd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aKd = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        List list3;
        HotGameActivity hotGameActivity;
        HotGameActivity hotGameActivity2;
        HotGameActivity hotGameActivity3;
        if (!UtilHelper.isNetOk()) {
            hotGameActivity3 = this.aKd.aKc;
            hotGameActivity3.showToast(y.neterror);
            return;
        }
        Integer num = (Integer) view.getTag();
        if (num != null && num.intValue() >= 0) {
            list = this.aKd.list;
            if (list != null) {
                list2 = this.aKd.list;
                if (list2.size() > num.intValue()) {
                    list3 = this.aKd.list;
                    GameInfoData gameInfoData = (GameInfoData) list3.get(num.intValue());
                    MessageManager messageManager = MessageManager.getInstance();
                    hotGameActivity = this.aKd.aKc;
                    messageManager.sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(hotGameActivity, gameInfoData.getGameId(), "1000103")));
                    com.baidu.tieba.game.a.a In = com.baidu.tieba.game.a.a.In();
                    hotGameActivity2 = this.aKd.aKc;
                    In.a(hotGameActivity2.getUniqueId(), view, gameInfoData);
                }
            }
        }
    }
}
