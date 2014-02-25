package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        boolean z;
        d dVar;
        List list;
        textView = this.a.h;
        if (view != textView) {
            textView2 = this.a.i;
            if (view != textView2) {
                textView3 = this.a.m;
                if (view == textView3) {
                    FacePurchaseRecordsActivity.a(this.a, "emotion_manage");
                    this.a.e();
                    this.a.a(true);
                    return;
                }
                return;
            }
            z = this.a.p;
            if (!z) {
                this.a.d();
            } else {
                this.a.e();
                list = this.a.b;
                list.clear();
            }
            dVar = this.a.o;
            dVar.notifyDataSetChanged();
            return;
        }
        this.a.g();
    }
}
