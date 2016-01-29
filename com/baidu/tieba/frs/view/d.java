package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b brj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.brj = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.brj.MR == null || this.brj.MR.getOrignalPage() == null || this.brj.MR.getOrignalPage().checkUpIsLogin()) {
            be.wt().c(this.brj.MR, new String[]{(String) view.getTag()});
        }
    }
}
