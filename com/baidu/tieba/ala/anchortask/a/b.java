package com.baidu.tieba.ala.anchortask.a;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.PopupWindow;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.view.web.g;
/* loaded from: classes10.dex */
public class b implements com.baidu.live.b.b {
    private CustomMessageListener bSr;
    private c gIs;
    private PopupWindow.OnDismissListener gIt;
    private Activity mContext;

    public b(Activity activity) {
        this.mContext = activity;
        Wn();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.gIs = new c(this.mContext);
        this.gIs.setOnDismissListener(this.gIt);
        this.gIs.getWebView().setBackgroundColor(gW(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.gIs).a(this.gIs.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] Wm = gVar.Wm();
        for (com.baidu.live.view.web.a aVar : Wm) {
            this.gIs.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gIs.Fp(str + "?anchor_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(j2)) + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.gIs != null && this.gIs.isShowing() && this.gIs.getWebView() != null) {
            this.gIs.getWebView().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.gIs != null && this.gIs.isShowing() && this.gIs.getWebView() != null) {
            this.gIs.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.gIs != null) {
            this.gIs.Wo();
        }
    }

    public void Ei() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        Ei();
        MessageManager.getInstance().unRegisterListener(this.bSr);
    }

    private void Wn() {
        this.bSr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gIs != null && b.this.gIs.isShowing()) {
                    b.this.gIs.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bSr);
    }

    private int gW(String str) {
        int indexOf;
        String queryParameter = Uri.parse(str).getQueryParameter("background");
        if ((TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) && (indexOf = str.indexOf("background=")) >= 0 && indexOf + 19 <= str.length()) {
            queryParameter = str.substring(indexOf + 11, indexOf + 19);
        }
        if (TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(queryParameter.substring(6, 8), 16);
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor('#' + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
