package com.baidu.tieba.game.classify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameCategoryDetailActivityConfig;
import tbclient.GameCategory;
/* loaded from: classes.dex */
class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ GameClassifyActivity aJp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(GameClassifyActivity gameClassifyActivity) {
        this.aJp = gameClassifyActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar;
        bVar = this.aJp.aJo;
        Object item = bVar.getItem(i);
        if (item != null) {
            GameCategory gameCategory = (GameCategory) item;
            this.aJp.sendMessage(new CustomMessage(2002001, new GameCategoryDetailActivityConfig(this.aJp, gameCategory.id.intValue(), gameCategory.name)));
        }
    }
}
