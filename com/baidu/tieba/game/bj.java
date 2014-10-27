package com.baidu.tieba.game;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameClassifyActivityConfig;
import com.baidu.tbadk.core.atomData.GameNewActivityConfig;
import com.baidu.tbadk.core.atomData.HotGameActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnClickListener {
    final /* synthetic */ bi aJf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.aJf = biVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bmVar = this.aJf.aIY;
        if (bmVar != null) {
            bmVar2 = this.aJf.aIY;
            if (view != bmVar2.getGameNewView()) {
                bmVar3 = this.aJf.aIY;
                if (view != bmVar3.getGameHotView()) {
                    bmVar4 = this.aJf.aIY;
                    if (view == bmVar4.getGameCategoryView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameClassifyActivityConfig(this.aJf.getActivity())));
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotGameActivityConfig(this.aJf.getActivity())));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameNewActivityConfig(this.aJf.getActivity())));
        }
    }
}
