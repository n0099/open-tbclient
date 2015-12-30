package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bop = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bop.mContext == null || this.bop.mContext.getOrignalPage() == null || this.bop.mContext.getOrignalPage().checkUpIsLogin()) {
            bf.vn().b(this.bop.mContext, new String[]{(String) view.getTag()});
        }
    }
}
