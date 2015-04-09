package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a aPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aPe = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk.tl().b(this.aPe.LP, new String[]{(String) view.getTag()});
    }
}
