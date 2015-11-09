package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bdS = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdS.mContext == null || this.bdS.mContext.getOrignalPage() == null || this.bdS.mContext.getOrignalPage().checkUpIsLogin()) {
            az.uX().b(this.bdS.mContext, new String[]{(String) view.getTag()});
        }
    }
}
