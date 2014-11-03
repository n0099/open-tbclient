package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ EmotionManageActivity asQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionManageActivity emotionManageActivity) {
        this.asQ = emotionManageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        boolean z;
        r rVar;
        List list;
        textView = this.asQ.asJ;
        if (view != textView) {
            textView2 = this.asQ.aes;
            if (view != textView2) {
                textView3 = this.asQ.asM;
                if (view == textView3) {
                    FacePurchaseRecordsActivity.startActivity(this.asQ, "emotion_manage");
                    this.asQ.CN();
                    this.asQ.bC(true);
                    return;
                }
                return;
            }
            z = this.asQ.asP;
            if (!z) {
                this.asQ.CM();
            } else {
                this.asQ.CN();
                list = this.asQ.asE;
                list.clear();
            }
            rVar = this.asQ.asO;
            rVar.notifyDataSetChanged();
            return;
        }
        this.asQ.CP();
    }
}
