package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.util.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ y bvS;
    private final /* synthetic */ String bvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, String str) {
        this.bvS = yVar;
        this.bvU = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        bi us = bi.us();
        kVar = this.bvS.bvO;
        us.a(kVar.aNO.getPageContext(), new String[]{this.bvU}, true);
    }
}
