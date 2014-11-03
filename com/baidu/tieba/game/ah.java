package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.game.GameShareJsBridge;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ GameWebViewActivity aIq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(GameWebViewActivity gameWebViewActivity) {
        this.aIq = gameWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebView baseWebView;
        Object tag = view.getTag();
        if (this.aIq.getString(com.baidu.tieba.y.back).equals(tag)) {
            this.aIq.finish();
        } else if (this.aIq.getString(com.baidu.tieba.y.refresh).equals(tag)) {
            this.aIq.refresh();
        } else if (this.aIq.getString(com.baidu.tieba.y.share).equals(tag)) {
            if (UtilHelper.getNetStatusInfo(this.aIq.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aIq.showToast(this.aIq.getString(com.baidu.tieba.y.no_network_guide));
            }
            GameShareJsBridge.getInstance().startShare();
            baseWebView = this.aIq.mWebView;
            baseWebView.loadUrl("javascript:TbJsBridge._gameShare()");
            this.aIq.Hw();
        }
    }
}
