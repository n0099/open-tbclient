package com.baidu.tieba.ala.liveroom.turntable;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.utils.q;
import com.baidu.live.view.web.g;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public class e {
    private CustomMessageListener bXd;
    private d.a hOT;
    private d hOV;
    private Activity mContext;

    public e(Activity activity) {
        this.mContext = activity;
        aag();
    }

    public void b(String str, long j, long j2, long j3) {
        this.hOV = new d(this.mContext);
        this.hOV.a(this.hOT);
        this.hOV.getWebView().setBackgroundColor(ih(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.hOV).a(this.hOV.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] aaf = gVar.aaf();
        for (com.baidu.live.view.web.a aVar : aaf) {
            this.hOV.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hOV.GA(a(str, j, ExtraParamsManager.getEncryptionUserId(String.valueOf(j2)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3))));
    }

    public void resume() {
        if (this.hOV != null && this.hOV.isShowing() && this.hOV.getWebView() != null) {
            this.hOV.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.hOV != null && this.hOV.isShowing() && this.hOV.getWebView() != null) {
            this.hOV.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.hOV != null) {
            this.hOV.aah();
        }
    }

    public void dU(int i) {
        if (this.hOV != null && this.hOV.isShowing()) {
            this.hOV.dU(i);
        }
    }

    public void Id() {
        dismiss();
    }

    public void release() {
        Id();
        MessageManager.getInstance().unRegisterListener(this.bXd);
    }

    private void aag() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.hOV != null && e.this.hOV.isShowing()) {
                    e.this.hOV.dismiss();
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

    private String a(String str, long j, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(ETAG.ITEM_SEPARATOR);
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(str2);
        sb.append("&anchor_id=");
        sb.append(str3);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        sb.append("&_sdk_version=");
        sb.append(TbConfig.SDK_VERSION);
        sb.append("&scene_from=");
        sb.append(q.XG());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.hOT = aVar;
    }

    public d.a cnA() {
        return this.hOT;
    }
}
