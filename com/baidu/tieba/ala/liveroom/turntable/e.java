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
    private Activity clq;
    private CustomMessageListener flM;
    private d.a geX;
    private d geZ;

    public e(Activity activity) {
        this.clq = activity;
        brZ();
    }

    public void a(String str, long j, long j2, long j3) {
        this.geZ = new d(this.clq);
        this.geZ.a(this.geX);
        this.geZ.bsa().setBackgroundColor(AZ(str));
        g gVar = new g();
        gVar.u(this.clq).a(this.geZ).a(this.geZ.bsa().getSchemeCallback());
        com.baidu.live.view.web.a[] JF = gVar.JF();
        for (com.baidu.live.view.web.a aVar : JF) {
            this.geZ.bsa().addJavascriptInterface(aVar, aVar.getName());
        }
        this.geZ.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.geZ != null && this.geZ.isShowing() && this.geZ.bsa() != null) {
            this.geZ.bsa().onResume();
        }
    }

    public void pause() {
        if (this.geZ != null && this.geZ.isShowing() && this.geZ.bsa() != null) {
            this.geZ.bsa().onPause();
        }
    }

    public void dismiss() {
        if (this.geZ != null) {
            this.geZ.bsb();
        }
    }

    public void cs(int i) {
        if (this.geZ != null && this.geZ.isShowing()) {
            this.geZ.cs(i);
        }
    }

    public void yw() {
        dismiss();
    }

    public void release() {
        yw();
        MessageManager.getInstance().unRegisterListener(this.flM);
    }

    private void brZ() {
        this.flM = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.geZ != null && e.this.geZ.isShowing()) {
                    e.this.geZ.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.flM);
    }

    private int AZ(String str) {
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
        sb.append(q.Id());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.geX = aVar;
    }

    public d.a bGs() {
        return this.geX;
    }
}
