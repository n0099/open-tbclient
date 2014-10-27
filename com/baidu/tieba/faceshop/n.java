package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ EmotionManageActivity asH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionManageActivity emotionManageActivity) {
        this.asH = emotionManageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        boolean z;
        r rVar;
        List list;
        textView = this.asH.asA;
        if (view != textView) {
            textView2 = this.asH.aek;
            if (view != textView2) {
                textView3 = this.asH.asD;
                if (view == textView3) {
                    FacePurchaseRecordsActivity.startActivity(this.asH, "emotion_manage");
                    this.asH.CL();
                    this.asH.bC(true);
                    return;
                }
                return;
            }
            z = this.asH.asG;
            if (!z) {
                this.asH.CK();
            } else {
                this.asH.CL();
                list = this.asH.asv;
                list.clear();
            }
            rVar = this.asH.asF;
            rVar.notifyDataSetChanged();
            return;
        }
        this.asH.CN();
    }
}
