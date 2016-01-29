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
    final /* synthetic */ EmotionTabHorizonScrollView aVd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aVd = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.editortools.k kVar;
        String str;
        com.baidu.tbadk.editortools.k kVar2;
        h hVar;
        textView = this.aVd.avW;
        if (textView != null) {
            hVar = this.aVd.aUV;
            hVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m411getInst().setFaceShopVersion(TbadkCoreApplication.m411getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m411getInst().setFaceShopNew(false);
        kVar = this.aVd.Lx;
        if (kVar != null) {
            kVar2 = this.aVd.Lx;
            kVar2.b(new com.baidu.tbadk.editortools.a(2, 5, null));
        }
        switch (this.aVd.from) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(this.aVd.getContext(), str)));
    }
}
