package com.baidu.tieba.game;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements AdapterView.OnItemClickListener {
    final /* synthetic */ bj aJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj bjVar) {
        this.aJs = bjVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bh bhVar;
        if (UtilHelper.isNetOk()) {
            bhVar = this.aJs.aJp;
            GameInfoData item = bhVar.getItem(i);
            if (item != null) {
                com.baidu.tieba.game.a.a.In().a(this.aJs.getUniqueId(), view, item);
                this.aJs.sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aJs.getActivity(), item.getGameId(), "1000101")));
                return;
            }
            return;
        }
        this.aJs.showToast(com.baidu.tieba.y.neterror);
    }
}
