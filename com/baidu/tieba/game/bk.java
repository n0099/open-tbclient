package com.baidu.tieba.game;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GameClassifyActivityConfig;
import com.baidu.tbadk.core.atomData.GameNewActivityConfig;
import com.baidu.tbadk.core.atomData.HotGameActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnClickListener {
    final /* synthetic */ bj aJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.aJs = bjVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        boVar = this.aJs.aJl;
        if (boVar != null) {
            boVar2 = this.aJs.aJl;
            if (view != boVar2.getGameNewView()) {
                boVar3 = this.aJs.aJl;
                if (view != boVar3.getGameHotView()) {
                    boVar4 = this.aJs.aJl;
                    if (view == boVar4.getGameCategoryView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameClassifyActivityConfig(this.aJs.getActivity())));
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotGameActivityConfig(this.aJs.getActivity())));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameNewActivityConfig(this.aJs.getActivity())));
        }
    }
}
