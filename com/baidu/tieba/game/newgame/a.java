package com.baidu.tieba.game.newgame;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ GameNewActivity aKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GameNewActivity gameNewActivity) {
        this.aKg = gameNewActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar;
        if (UtilHelper.isNetOk()) {
            dVar = this.aKg.aKe;
            GameInfoData item = dVar.getItem(i);
            if (item != null) {
                com.baidu.tieba.game.a.a.In().a(this.aKg.getUniqueId(), view, item);
                this.aKg.sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aKg, item.getGameId(), "1000102")));
                return;
            }
            return;
        }
        this.aKg.showToast(y.neterror);
    }
}
