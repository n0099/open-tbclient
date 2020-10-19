package com.baidu.tieba.ala.liveroom.turntable;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.utils.p;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class e {
    private Activity bFt;
    private CustomMessageListener bFv;
    private d.a hbS;
    private d hbU;

    public e(Activity activity) {
        this.bFt = activity;
        Ty();
    }

    public void a(String str, long j, long j2, long j3) {
        this.hbU = new d(this.bFt);
        this.hbU.a(this.hbS);
        this.hbU.Tz().setBackgroundColor(hH(str));
        g gVar = new g();
        gVar.x(this.bFt).a(this.hbU).a(this.hbU.Tz().getSchemeCallback());
        com.baidu.live.view.web.a[] Tx = gVar.Tx();
        for (com.baidu.live.view.web.a aVar : Tx) {
            this.hbU.Tz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hbU.Fz(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.hbU != null && this.hbU.isShowing() && this.hbU.Tz() != null) {
            this.hbU.Tz().onResume();
        }
    }

    public void pause() {
        if (this.hbU != null && this.hbU.isShowing() && this.hbU.Tz() != null) {
            this.hbU.Tz().onPause();
        }
    }

    public void dismiss() {
        if (this.hbU != null) {
            this.hbU.TA();
        }
    }

    public void dI(int i) {
        if (this.hbU != null && this.hbU.isShowing()) {
            this.hbU.dI(i);
        }
    }

    public void Gx() {
        dismiss();
    }

    public void release() {
        Gx();
        MessageManager.getInstance().unRegisterListener(this.bFv);
    }

    private void Ty() {
        this.bFv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.hbU != null && e.this.hbU.isShowing()) {
                    e.this.hbU.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bFv);
    }

    private int hH(String str) {
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

    private String b(String str, long j, long j2, long j3) {
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(ETAG.ITEM_SEPARATOR);
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(j2);
        sb.append("&anchor_id=");
        sb.append(j3);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        sb.append("&_sdk_version=");
        sb.append(TbConfig.SDK_VERSION);
        sb.append("&scene_from=");
        sb.append(p.QW());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.hbS = aVar;
    }

    public d.a cbN() {
        return this.hbS;
    }
}
