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
    private Activity bNY;
    private CustomMessageListener bOa;
    private d.a htG;
    private d htI;

    public e(Activity activity) {
        this.bNY = activity;
        WY();
    }

    public void a(String str, long j, long j2, long j3) {
        this.htI = new d(this.bNY);
        this.htI.a(this.htG);
        this.htI.WZ().setBackgroundColor(hW(str));
        g gVar = new g();
        gVar.y(this.bNY).a(this.htI).a(this.htI.WZ().getSchemeCallback());
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.htI.WZ().addJavascriptInterface(aVar, aVar.getName());
        }
        this.htI.Gn(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.htI != null && this.htI.isShowing() && this.htI.WZ() != null) {
            this.htI.WZ().onResume();
        }
    }

    public void pause() {
        if (this.htI != null && this.htI.isShowing() && this.htI.WZ() != null) {
            this.htI.WZ().onPause();
        }
    }

    public void dismiss() {
        if (this.htI != null) {
            this.htI.Xa();
        }
    }

    public void dI(int i) {
        if (this.htI != null && this.htI.isShowing()) {
            this.htI.dI(i);
        }
    }

    public void Ht() {
        dismiss();
    }

    public void release() {
        Ht();
        MessageManager.getInstance().unRegisterListener(this.bOa);
    }

    private void WY() {
        this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.htI != null && e.this.htI.isShowing()) {
                    e.this.htI.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bOa);
    }

    private int hW(String str) {
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
        sb.append(p.UK());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.htG = aVar;
    }

    public d.a chu() {
        return this.htG;
    }
}
