package com.baidu.tieba.ala.liveroom.q;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes4.dex */
public class c implements a {
    private CustomMessageListener bRw;
    private Activity beD;
    private PopupWindow.OnDismissListener gBn;
    private d hzt;

    public c(Activity activity) {
        this.beD = activity;
        YP();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void ir(String str) {
        this.hzt = new d(this.beD);
        this.hzt.setOnDismissListener(this.gBn);
        this.hzt.getWebView().setBackgroundColor(iu(str));
        g gVar = new g();
        gVar.x(this.beD).a(this.hzt).a(this.hzt.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.hzt.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hzt.GD(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void resume() {
        if (this.hzt != null && this.hzt.isShowing() && this.hzt.getWebView() != null) {
            this.hzt.getWebView().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void pause() {
        if (this.hzt != null && this.hzt.isShowing() && this.hzt.getWebView() != null) {
            this.hzt.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.hzt != null) {
            this.hzt.YQ();
        }
    }

    public void dX(int i) {
        if (this.hzt != null && this.hzt.isShowing()) {
            this.hzt.dX(i);
        }
    }

    public void IB() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void release() {
        IB();
        MessageManager.getInstance().unRegisterListener(this.bRw);
        this.bRw = null;
    }

    private void YP() {
        if (this.bRw == null) {
            this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.q.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (c.this.hzt != null && c.this.hzt.isShowing()) {
                        c.this.hzt.dismiss();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bRw);
    }

    private int iu(String str) {
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
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
