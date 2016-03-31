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
    final /* synthetic */ EmotionTabHorizonScrollView aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aZM = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.editortools.l lVar;
        String str;
        com.baidu.tbadk.editortools.l lVar2;
        h hVar;
        textView = this.aZM.awD;
        if (textView != null) {
            hVar = this.aZM.aZE;
            hVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m411getInst().setFaceShopVersion(TbadkCoreApplication.m411getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m411getInst().setFaceShopNew(false);
        lVar = this.aZM.LE;
        if (lVar != null) {
            lVar2 = this.aZM.LE;
            lVar2.b(new com.baidu.tbadk.editortools.a(2, 5, null));
        }
        switch (this.aZM.from) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(this.aZM.getContext(), str)));
    }
}
