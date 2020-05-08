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
import com.baidu.live.utils.q;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes3.dex */
public class e {
    private Activity caN;
    private CustomMessageListener eZc;
    private d.a fQm;
    private d fQo;

    public e(Activity activity) {
        this.caN = activity;
        bmB();
    }

    public void a(String str, long j, long j2, long j3) {
        this.fQo = new d(this.caN);
        this.fQo.a(this.fQm);
        this.fQo.bmC().setBackgroundColor(zt(str));
        g gVar = new g();
        gVar.u(this.caN).a(this.fQo).a(this.fQo.bmC().getSchemeCallback());
        com.baidu.live.view.web.a[] HM = gVar.HM();
        for (com.baidu.live.view.web.a aVar : HM) {
            this.fQo.bmC().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fQo.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.fQo != null && this.fQo.isShowing() && this.fQo.bmC() != null) {
            this.fQo.bmC().onResume();
        }
    }

    public void pause() {
        if (this.fQo != null && this.fQo.isShowing() && this.fQo.bmC() != null) {
            this.fQo.bmC().onPause();
        }
    }

    public void dismiss() {
        if (this.fQo != null) {
            this.fQo.bmD();
        }
    }

    public void cl(int i) {
        if (this.fQo != null && this.fQo.isShowing()) {
            this.fQo.cl(i);
        }
    }

    public void xi() {
        dismiss();
    }

    public void release() {
        xi();
        MessageManager.getInstance().unRegisterListener(this.eZc);
    }

    private void bmB() {
        this.eZc = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.fQo != null && e.this.fQo.isShowing()) {
                    e.this.fQo.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eZc);
    }

    private int zt(String str) {
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
        sb.append(q.Gk());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.fQm = aVar;
    }

    public d.a bAf() {
        return this.fQm;
    }
}
