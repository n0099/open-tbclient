package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bky = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bky.mContext == null || this.bky.mContext.getOrignalPage() == null || this.bky.mContext.getOrignalPage().checkUpIsLogin()) {
            bf.vD().b(this.bky.mContext, new String[]{(String) view.getTag()});
        }
    }
}
