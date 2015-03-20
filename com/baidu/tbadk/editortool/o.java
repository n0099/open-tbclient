package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView aiJ;
    private final String mGroupId;

    private o(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
        this.aiJ = emotionTabHorizonScrollView;
        this.mGroupId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, o oVar) {
        this(emotionTabHorizonScrollView, str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        String str;
        i = this.aiJ.from;
        switch (i) {
            case 1:
                str = "faceshop_from_write_promotion";
                break;
            case 2:
                str = "faceshop_from_pchat_promotion";
                break;
            case 3:
                str = "faceshop_from_gchat_promotion";
                break;
            default:
                str = "";
                break;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aiJ.getContext(), this.mGroupId, false, str)));
    }
}
