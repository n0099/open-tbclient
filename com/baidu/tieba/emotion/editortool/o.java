package com.baidu.tieba.emotion.editortool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bFq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bFq = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.editortools.j jVar;
        String str;
        com.baidu.tbadk.editortools.j jVar2;
        i iVar;
        textView = this.bFq.aBX;
        if (textView != null) {
            iVar = this.bFq.bFi;
            iVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m9getInst().setFaceShopVersion(TbadkCoreApplication.m9getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m9getInst().setFaceShopNew(false);
        jVar = this.bFq.Kg;
        if (jVar != null) {
            jVar2 = this.bFq.Kg;
            jVar2.b(new com.baidu.tbadk.editortools.a(2, 5, null));
        }
        switch (this.bFq.from) {
            case 1:
                str = "faceshop_from_write_shop";
                break;
            case 2:
                str = "faceshop_from_pchat_shop";
                break;
            case 3:
                str = "faceshop_from_gchat_shop";
                break;
            default:
                str = "";
                break;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceShopActivityConfig(this.bFq.getContext(), str)));
    }
}
