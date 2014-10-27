package com.baidu.tieba.game;

import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements bq {
    final /* synthetic */ bi aJf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar) {
        this.aJf = biVar;
    }

    @Override // com.baidu.tieba.game.bq
    public void b(an anVar) {
        RelativeLayout relativeLayout;
        bi biVar = this.aJf;
        relativeLayout = this.aJf.aJb;
        biVar.hideLoadingView(relativeLayout);
        this.aJf.a(anVar);
        this.aJf.aIk = true;
    }

    @Override // com.baidu.tieba.game.bq
    public void fw(String str) {
        RelativeLayout relativeLayout;
        bi biVar = this.aJf;
        relativeLayout = this.aJf.aJb;
        biVar.hideLoadingView(relativeLayout);
        this.aJf.showToast(str);
    }

    @Override // com.baidu.tieba.game.bq
    public void c(an anVar) {
        RelativeLayout relativeLayout;
        bn bnVar;
        this.aJf.aIl = true;
        bi biVar = this.aJf;
        relativeLayout = this.aJf.aJb;
        biVar.hideLoadingView(relativeLayout);
        this.aJf.a(anVar);
        if (UtilHelper.isNetOk()) {
            bnVar = this.aJf.aJd;
            bnVar.HO();
        }
    }
}
