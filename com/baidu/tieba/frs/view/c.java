package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a aON;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aON = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bk.tl().b(this.aON.LN, new String[]{(String) view.getTag()});
    }
}
