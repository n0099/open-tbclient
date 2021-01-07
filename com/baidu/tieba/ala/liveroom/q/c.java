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
/* loaded from: classes11.dex */
public class c implements a {
    private CustomMessageListener bXd;
    private PopupWindow.OnDismissListener gMZ;
    private d hLr;
    private Activity mContext;

    public c(Activity activity) {
        this.mContext = activity;
        aag();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void ie(String str) {
        this.hLr = new d(this.mContext);
        this.hLr.setOnDismissListener(this.gMZ);
        this.hLr.getWebView().setBackgroundColor(ih(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.hLr).a(this.hLr.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] aaf = gVar.aaf();
        for (com.baidu.live.view.web.a aVar : aaf) {
            this.hLr.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hLr.GA(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void resume() {
        if (this.hLr != null && this.hLr.isShowing() && this.hLr.getWebView() != null) {
            this.hLr.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void pause() {
        if (this.hLr != null && this.hLr.isShowing() && this.hLr.getWebView() != null) {
            this.hLr.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.hLr != null) {
            this.hLr.aah();
        }
    }

    public void dU(int i) {
        if (this.hLr != null && this.hLr.isShowing()) {
            this.hLr.dU(i);
        }
    }

    public void Id() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void release() {
        Id();
        MessageManager.getInstance().unRegisterListener(this.bXd);
        this.bXd = null;
    }

    private void aag() {
        if (this.bXd == null) {
            this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.q.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (c.this.hLr != null && c.this.hLr.isShowing()) {
                        c.this.hLr.dismiss();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bXd);
    }

    private int ih(String str) {
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
