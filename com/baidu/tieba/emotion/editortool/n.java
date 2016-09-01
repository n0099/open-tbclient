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
public class n implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView bEY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.bEY = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.editortools.l lVar;
        String str;
        com.baidu.tbadk.editortools.l lVar2;
        h hVar;
        textView = this.bEY.axq;
        if (textView != null) {
            hVar = this.bEY.bEQ;
            hVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m9getInst().setFaceShopVersion(TbadkCoreApplication.m9getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m9getInst().setFaceShopNew(false);
        lVar = this.bEY.EJ;
        if (lVar != null) {
            lVar2 = this.bEY.EJ;
            lVar2.b(new com.baidu.tbadk.editortools.a(2, 5, null));
        }
        switch (this.bEY.from) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceShopActivityConfig(this.bEY.getContext(), str)));
    }
}
