package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bdn = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdn.mContext == null || this.bdn.mContext.getOrignalPage() == null || this.bdn.mContext.getOrignalPage().checkUpIsLogin()) {
            az.uT().b(this.bdn.mContext, new String[]{(String) view.getTag()});
        }
    }
}
