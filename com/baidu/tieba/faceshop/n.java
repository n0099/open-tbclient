package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes.dex */
final class n implements View.OnClickListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        boolean z;
        r rVar;
        List list;
        textView = this.a.h;
        if (view != textView) {
            textView2 = this.a.i;
            if (view != textView2) {
                textView3 = this.a.m;
                if (view == textView3) {
                    FacePurchaseRecordsActivity.a(this.a, "emotion_manage");
                    this.a.b();
                    this.a.a(true);
                    return;
                }
                return;
            }
            z = this.a.p;
            if (!z) {
                EmotionManageActivity.g(this.a);
            } else {
                this.a.b();
                list = this.a.b;
                list.clear();
            }
            rVar = this.a.o;
            rVar.notifyDataSetChanged();
            return;
        }
        EmotionManageActivity.b(this.a);
    }
}
