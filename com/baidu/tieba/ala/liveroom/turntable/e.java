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
    private Activity bMo;
    private CustomMessageListener bMq;
    private d.a htn;
    private d htp;

    public e(Activity activity) {
        this.bMo = activity;
        Wp();
    }

    public void a(String str, long j, long j2, long j3) {
        this.htp = new d(this.bMo);
        this.htp.a(this.htn);
        this.htp.Wq().setBackgroundColor(hQ(str));
        g gVar = new g();
        gVar.x(this.bMo).a(this.htp).a(this.htp.Wq().getSchemeCallback());
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.htp.Wq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.htp.FO(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.htp != null && this.htp.isShowing() && this.htp.Wq() != null) {
            this.htp.Wq().onResume();
        }
    }

    public void pause() {
        if (this.htp != null && this.htp.isShowing() && this.htp.Wq() != null) {
            this.htp.Wq().onPause();
        }
    }

    public void dismiss() {
        if (this.htp != null) {
            this.htp.Wr();
        }
    }

    public void dE(int i) {
        if (this.htp != null && this.htp.isShowing()) {
            this.htp.dE(i);
        }
    }

    public void GK() {
        dismiss();
    }

    public void release() {
        GK();
        MessageManager.getInstance().unRegisterListener(this.bMq);
    }

    private void Wp() {
        this.bMq = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.htp != null && e.this.htp.isShowing()) {
                    e.this.htp.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bMq);
    }

    private int hQ(String str) {
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
        sb.append(p.Ub());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.htn = aVar;
    }

    public d.a cgN() {
        return this.htn;
    }
}
