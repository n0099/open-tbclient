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
    private Activity bIs;
    private CustomMessageListener bIu;
    private d.a hnI;
    private d hnK;

    public e(Activity activity) {
        this.bIs = activity;
        Uy();
    }

    public void a(String str, long j, long j2, long j3) {
        this.hnK = new d(this.bIs);
        this.hnK.a(this.hnI);
        this.hnK.Uz().setBackgroundColor(hP(str));
        g gVar = new g();
        gVar.x(this.bIs).a(this.hnK).a(this.hnK.Uz().getSchemeCallback());
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.hnK.Uz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hnK.FZ(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.hnK != null && this.hnK.isShowing() && this.hnK.Uz() != null) {
            this.hnK.Uz().onResume();
        }
    }

    public void pause() {
        if (this.hnK != null && this.hnK.isShowing() && this.hnK.Uz() != null) {
            this.hnK.Uz().onPause();
        }
    }

    public void dismiss() {
        if (this.hnK != null) {
            this.hnK.UA();
        }
    }

    public void dI(int i) {
        if (this.hnK != null && this.hnK.isShowing()) {
            this.hnK.dI(i);
        }
    }

    public void GS() {
        dismiss();
    }

    public void release() {
        GS();
        MessageManager.getInstance().unRegisterListener(this.bIu);
    }

    private void Uy() {
        this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.hnK != null && e.this.hnK.isShowing()) {
                    e.this.hnK.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bIu);
    }

    private int hP(String str) {
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
        sb.append(p.Sc());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.hnI = aVar;
    }

    public d.a ceR() {
        return this.hnI;
    }
}
