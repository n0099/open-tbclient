package com.baidu.tbadk.editortool;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView RZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionTabHorizonScrollView emotionTabHorizonScrollView) {
        this.RZ = emotionTabHorizonScrollView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        int i;
        String str;
        g gVar;
        textView = this.RZ.RV;
        if (textView != null) {
            gVar = this.RZ.RN;
            gVar.setNewViewVisible(false);
        }
        TbadkApplication.m251getInst().setFaceShopVersion(TbadkApplication.m251getInst().getTempFaceShopVersion());
        TbadkApplication.m251getInst().setFaceShopNew(false);
        i = this.RZ.from;
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceShopActivityConfig(this.RZ.getContext(), str)));
    }
}
