package com.baidu.tieba.game;

import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements bs {
    final /* synthetic */ bj aJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar) {
        this.aJs = bjVar;
    }

    @Override // com.baidu.tieba.game.bs
    public void b(an anVar) {
        RelativeLayout relativeLayout;
        bj bjVar = this.aJs;
        relativeLayout = this.aJs.aJo;
        bjVar.hideLoadingView(relativeLayout);
        this.aJs.a(anVar);
        this.aJs.aIw = true;
    }

    @Override // com.baidu.tieba.game.bs
    public void fw(String str) {
        RelativeLayout relativeLayout;
        bj bjVar = this.aJs;
        relativeLayout = this.aJs.aJo;
        bjVar.hideLoadingView(relativeLayout);
        this.aJs.showToast(str);
    }

    @Override // com.baidu.tieba.game.bs
    public void c(an anVar) {
        RelativeLayout relativeLayout;
        bp bpVar;
        this.aJs.aIx = true;
        if (!UtilHelper.isNetOk() || (anVar != null && anVar.getGameList() != null && !anVar.getGameList().isEmpty())) {
            bj bjVar = this.aJs;
            relativeLayout = this.aJs.aJo;
            bjVar.hideLoadingView(relativeLayout);
            this.aJs.a(anVar);
        }
        if (UtilHelper.isNetOk()) {
            bpVar = this.aJs.aJq;
            bpVar.HS();
        }
    }
}
