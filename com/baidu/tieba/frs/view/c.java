package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bcO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bcO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bcO.LS == null || this.bcO.LS.getOrignalPage() == null || this.bcO.LS.getOrignalPage().checkUpIsLogin()) {
            ax.uR().b(this.bcO.LS, new String[]{(String) view.getTag()});
        }
    }
}
