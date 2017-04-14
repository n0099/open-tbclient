package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
class ar implements com.baidu.tbadk.ala.f {
    @Override // com.baidu.tbadk.ala.f
    public View aq(Context context) {
        TextView ap = com.baidu.tbadk.ala.d.ap(context);
        if (ap != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            ap.setLayoutParams(layoutParams);
        }
        return ap;
    }
}
