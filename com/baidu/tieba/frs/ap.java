package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class ap implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View Q(Context context) {
        TextView P = com.baidu.tbadk.ala.d.P(context);
        if (P != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            P.setLayoutParams(layoutParams);
        }
        return P;
    }
}
