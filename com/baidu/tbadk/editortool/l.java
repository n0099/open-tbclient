package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aiJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.aiJ = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        int i;
        String str;
        c cVar;
        textView = this.aiJ.aiD;
        if (textView != null) {
            cVar = this.aiJ.aiw;
            cVar.setNewViewVisible(false);
        }
        TbadkCoreApplication.m411getInst().setFaceShopVersion(TbadkCoreApplication.m411getInst().getTempFaceShopVersion());
        TbadkCoreApplication.m411getInst().setFaceShopNew(false);
        i = this.aiJ.from;
        switch (i) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(this.aiJ.getContext(), str)));
    }
}
