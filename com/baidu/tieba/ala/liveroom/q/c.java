package com.baidu.tieba.ala.liveroom.q;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.PopupWindow;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
/* loaded from: classes10.dex */
public class c implements a {
    private CustomMessageListener bSr;
    private PopupWindow.OnDismissListener gIt;
    private d hGL;
    private Activity mContext;

    public c(Activity activity) {
        this.mContext = activity;
        Wn();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void gT(String str) {
        this.hGL = new d(this.mContext);
        this.hGL.setOnDismissListener(this.gIt);
        this.hGL.getWebView().setBackgroundColor(gW(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.hGL).a(this.hGL.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] Wm = gVar.Wm();
        for (com.baidu.live.view.web.a aVar : Wm) {
            this.hGL.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hGL.Fp(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void resume() {
        if (this.hGL != null && this.hGL.isShowing() && this.hGL.getWebView() != null) {
            this.hGL.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void pause() {
        if (this.hGL != null && this.hGL.isShowing() && this.hGL.getWebView() != null) {
            this.hGL.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.hGL != null) {
            this.hGL.Wo();
        }
    }

    public void co(int i) {
        if (this.hGL != null && this.hGL.isShowing()) {
            this.hGL.co(i);
        }
    }

    public void Ei() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void release() {
        Ei();
        MessageManager.getInstance().unRegisterListener(this.bSr);
        this.bSr = null;
    }

    private void Wn() {
        if (this.bSr == null) {
            this.bSr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.q.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (c.this.hGL != null && c.this.hGL.isShowing()) {
                        c.this.hGL.dismiss();
                    }
                }
            };
        }
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
