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
/* loaded from: classes7.dex */
public class e {
    private Activity czY;
    private CustomMessageListener fNJ;
    private d.a gJA;
    private d gJC;

    public e(Activity activity) {
        this.czY = activity;
        bHg();
    }

    public void a(String str, long j, long j2, long j3) {
        this.gJC = new d(this.czY);
        this.gJC.a(this.gJA);
        this.gJC.bHh().setBackgroundColor(ED(str));
        g gVar = new g();
        gVar.v(this.czY).a(this.gJC).a(this.gJC.bHh().getSchemeCallback());
        com.baidu.live.view.web.a[] QV = gVar.QV();
        for (com.baidu.live.view.web.a aVar : QV) {
            this.gJC.bHh().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gJC.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.gJC != null && this.gJC.isShowing() && this.gJC.bHh() != null) {
            this.gJC.bHh().onResume();
        }
    }

    public void pause() {
        if (this.gJC != null && this.gJC.isShowing() && this.gJC.bHh() != null) {
            this.gJC.bHh().onPause();
        }
    }

    public void dismiss() {
        if (this.gJC != null) {
            this.gJC.bHi();
        }
    }

    public void dz(int i) {
        if (this.gJC != null && this.gJC.isShowing()) {
            this.gJC.dz(i);
        }
    }

    public void Fb() {
        dismiss();
    }

    public void release() {
        Fb();
        MessageManager.getInstance().unRegisterListener(this.fNJ);
    }

    private void bHg() {
        this.fNJ = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.gJC != null && e.this.gJC.isShowing()) {
                    e.this.gJC.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fNJ);
    }

    private int ED(String str) {
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
        sb.append(p.Pp());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.gJA = aVar;
    }

    public d.a bWF() {
        return this.gJA;
    }
}
