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
/* loaded from: classes11.dex */
public class b implements com.baidu.live.b.b {
    private CustomMessageListener bXd;
    private c gMY;
    private PopupWindow.OnDismissListener gMZ;
    private Activity mContext;

    public b(Activity activity) {
        this.mContext = activity;
        aaf();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.gMY = new c(this.mContext);
        this.gMY.setOnDismissListener(this.gMZ);
        this.gMY.getWebView().setBackgroundColor(ih(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.gMY).a(this.gMY.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] aae = gVar.aae();
        for (com.baidu.live.view.web.a aVar : aae) {
            this.gMY.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gMY.GB(str + "?anchor_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(j2)) + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.gMY != null && this.gMY.isShowing() && this.gMY.getWebView() != null) {
            this.gMY.getWebView().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.gMY != null && this.gMY.isShowing() && this.gMY.getWebView() != null) {
            this.gMY.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.gMY != null) {
            this.gMY.aag();
        }
    }

    public void Id() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        Id();
        MessageManager.getInstance().unRegisterListener(this.bXd);
    }

    private void aaf() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gMY != null && b.this.gMY.isShowing()) {
                    b.this.gMY.dismiss();
                }
            }
        };
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
