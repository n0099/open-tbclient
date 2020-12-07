package com.baidu.tieba.ala.anchortask.a;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.b.b {
    private CustomMessageListener bRw;
    private Activity beD;
    private c gBk;
    private PopupWindow.OnDismissListener gBl;

    public b(Activity activity) {
        this.beD = activity;
        YP();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.gBk = new c(this.beD);
        this.gBk.setOnDismissListener(this.gBl);
        this.gBk.getWebView().setBackgroundColor(iu(str));
        g gVar = new g();
        gVar.x(this.beD).a(this.gBk).a(this.gBk.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.gBk.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gBk.GD(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.gBk != null && this.gBk.isShowing() && this.gBk.getWebView() != null) {
            this.gBk.getWebView().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.gBk != null && this.gBk.isShowing() && this.gBk.getWebView() != null) {
            this.gBk.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.gBk != null) {
            this.gBk.YQ();
        }
    }

    public void IB() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        IB();
        MessageManager.getInstance().unRegisterListener(this.bRw);
    }

    private void YP() {
        this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gBk != null && b.this.gBk.isShowing()) {
                    b.this.gBk.dismiss();
                }
            }
        };
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
