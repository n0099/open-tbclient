package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a aRp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aRp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aRp.LH == null || this.aRp.LH.getOrignalPage() == null || this.aRp.LH.getOrignalPage().checkUpIsLogin()) {
            bi.tO().b(this.aRp.LH, new String[]{(String) view.getTag()});
        }
    }
}
