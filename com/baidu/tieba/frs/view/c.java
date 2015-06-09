package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a aRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aRq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRq.LH == null || this.aRq.LH.getOrignalPage() == null || this.aRq.LH.getOrignalPage().checkUpIsLogin()) {
            bi.tO().b(this.aRq.LH, new String[]{(String) view.getTag()});
        }
    }
}
