package com.baidu.tieba.game;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.game.GameShareJsBridge;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ GameWebViewActivity aIe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(GameWebViewActivity gameWebViewActivity) {
        this.aIe = gameWebViewActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseWebView baseWebView;
        Object tag = view.getTag();
        if (this.aIe.getString(com.baidu.tieba.y.back).equals(tag)) {
            this.aIe.finish();
        } else if (this.aIe.getString(com.baidu.tieba.y.refresh).equals(tag)) {
            this.aIe.refresh();
        } else if (this.aIe.getString(com.baidu.tieba.y.share).equals(tag)) {
            if (UtilHelper.getNetStatusInfo(this.aIe.getApplicationContext()) == UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aIe.showToast(this.aIe.getString(com.baidu.tieba.y.no_network_guide));
            }
            GameShareJsBridge.getInstance().startShare();
            baseWebView = this.aIe.mWebView;
            baseWebView.loadUrl("javascript:TbJsBridge._gameShare()");
            this.aIe.Hv();
        }
    }
}
