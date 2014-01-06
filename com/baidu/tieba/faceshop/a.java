package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.TextView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
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
        if (view == textView) {
            this.a.g();
            return;
        }
        textView2 = this.a.i;
        if (view == textView2) {
            z = this.a.p;
            if (z) {
                this.a.e();
                list = this.a.b;
                list.clear();
            } else {
                this.a.d();
            }
            dVar = this.a.o;
            dVar.notifyDataSetChanged();
            return;
        }
        textView3 = this.a.m;
        if (view == textView3) {
            FacePurchaseRecordsActivity.a(this.a, "emotion_manage");
            this.a.e();
            this.a.a(true);
        }
    }
}
