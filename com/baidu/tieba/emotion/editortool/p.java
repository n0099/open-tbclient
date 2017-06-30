package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewFaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bRD = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        i iVar;
        textView = this.bRD.aCN;
        if (textView != null) {
            iVar = this.bRD.bRv;
            iVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m9getInst().setFaceShopVersion(TbadkCoreApplication.m9getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m9getInst().setFaceShopNew(false);
        jVar = this.bRD.JT;
        if (jVar != null) {
            jVar2 = this.bRD.JT;
            jVar2.b(new com.baidu.tbadk.editortools.a(2, 5, null));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewFaceShopActivityConfig(this.bRD.getContext(), "")));
    }
}
