package com.baidu.tbadk.editortools.emotiontool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aqk = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tbadk.editortools.j jVar;
        String str;
        com.baidu.tbadk.editortools.j jVar2;
        b bVar;
        textView = this.aqk.aqe;
        if (textView != null) {
            bVar = this.aqk.apX;
            bVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m411getInst().setFaceShopVersion(TbadkCoreApplication.m411getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m411getInst().setFaceShopNew(false);
        jVar = this.aqk.Kz;
        if (jVar != null) {
            jVar2 = this.aqk.Kz;
            jVar2.b(new com.baidu.tbadk.editortools.a(2, 5, null));
        }
        switch (this.aqk.from) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(this.aqk.getContext(), str)));
    }
}
