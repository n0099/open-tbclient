package com.baidu.tbadk.editortool;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ EmotionTabHorizonScrollView RZ;
    private final String mGroupId;

    private q(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str) {
        this.RZ = emotionTabHorizonScrollView;
        this.mGroupId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(EmotionTabHorizonScrollView emotionTabHorizonScrollView, String str, q qVar) {
        this(emotionTabHorizonScrollView, str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        String str;
        i = this.RZ.from;
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.RZ.getContext(), this.mGroupId, false, str)));
    }
}
