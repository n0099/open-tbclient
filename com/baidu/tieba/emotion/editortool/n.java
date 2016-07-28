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
    final /* synthetic */ EmotionTabHorizonScrollView btM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.btM = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.editortools.l lVar;
        String str;
        com.baidu.tbadk.editortools.l lVar2;
        h hVar;
        textView = this.btM.auj;
        if (textView != null) {
            hVar = this.btM.btE;
            hVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m10getInst().setFaceShopVersion(TbadkCoreApplication.m10getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m10getInst().setFaceShopNew(false);
        lVar = this.btM.Cw;
        if (lVar != null) {
            lVar2 = this.btM.Cw;
            lVar2.b(new com.baidu.tbadk.editortools.a(2, 5, null));
        }
        switch (this.btM.from) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceShopActivityConfig(this.btM.getContext(), str)));
    }
}
