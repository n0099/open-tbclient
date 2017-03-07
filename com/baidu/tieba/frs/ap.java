package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class ap implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View ao(Context context) {
        TextView an = com.baidu.tbadk.ala.d.an(context);
        if (an != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            an.setLayoutParams(layoutParams);
        }
        return an;
    }
}
