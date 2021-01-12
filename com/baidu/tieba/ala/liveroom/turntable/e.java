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
/* loaded from: classes10.dex */
public class e {
    private CustomMessageListener bSr;
    private d.a hKn;
    private d hKp;
    private Activity mContext;

    public e(Activity activity) {
        this.mContext = activity;
        Wn();
    }

    public void b(String str, long j, long j2, long j3) {
        this.hKp = new d(this.mContext);
        this.hKp.a(this.hKn);
        this.hKp.getWebView().setBackgroundColor(gW(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.hKp).a(this.hKp.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] Wm = gVar.Wm();
        for (com.baidu.live.view.web.a aVar : Wm) {
            this.hKp.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hKp.Fp(a(str, j, ExtraParamsManager.getEncryptionUserId(String.valueOf(j2)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3))));
    }

    public void resume() {
        if (this.hKp != null && this.hKp.isShowing() && this.hKp.getWebView() != null) {
            this.hKp.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.hKp != null && this.hKp.isShowing() && this.hKp.getWebView() != null) {
            this.hKp.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.hKp != null) {
            this.hKp.Wo();
        }
    }

    public void co(int i) {
        if (this.hKp != null && this.hKp.isShowing()) {
            this.hKp.co(i);
        }
    }

    public void Ei() {
        dismiss();
    }

    public void release() {
        Ei();
        MessageManager.getInstance().unRegisterListener(this.bSr);
    }

    private void Wn() {
        this.bSr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.hKp != null && e.this.hKp.isShowing()) {
                    e.this.hKp.dismiss();
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
        sb.append(q.TN());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.hKn = aVar;
    }

    public d.a cjI() {
        return this.hKn;
    }
}
