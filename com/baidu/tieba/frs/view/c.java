package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bdi = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bdi.mContext == null || this.bdi.mContext.getOrignalPage() == null || this.bdi.mContext.getOrignalPage().checkUpIsLogin()) {
            ax.uX().b(this.bdi.mContext, new String[]{(String) view.getTag()});
        }
    }
}
