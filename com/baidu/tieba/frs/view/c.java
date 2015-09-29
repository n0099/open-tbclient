package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bdc = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdc.mContext == null || this.bdc.mContext.getOrignalPage() == null || this.bdc.mContext.getOrignalPage().checkUpIsLogin()) {
            ay.uV().b(this.bdc.mContext, new String[]{(String) view.getTag()});
        }
    }
}
