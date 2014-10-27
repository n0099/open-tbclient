package com.baidu.tieba.game;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements AdapterView.OnItemClickListener {
    final /* synthetic */ bi aJf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar) {
        this.aJf = biVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bg bgVar;
        if (UtilHelper.isNetOk()) {
            bgVar = this.aJf.aJc;
            GameInfoData item = bgVar.getItem(i);
            if (item != null) {
                com.baidu.tieba.game.a.a.Ij().a(view, item);
                this.aJf.sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aJf.getActivity(), item.getGameId(), "1000101")));
                return;
            }
            return;
        }
        this.aJf.showToast(com.baidu.tieba.y.neterror);
    }
}
