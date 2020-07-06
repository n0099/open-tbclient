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
/* loaded from: classes3.dex */
public class e {
    private Activity bdo;
    private CustomMessageListener fxk;
    private d.a gse;
    private d gsg;

    public e(Activity activity) {
        this.bdo = activity;
        buY();
    }

    public void a(String str, long j, long j2, long j3) {
        this.gsg = new d(this.bdo);
        this.gsg.a(this.gse);
        this.gsg.Hf().setBackgroundColor(fI(str));
        g gVar = new g();
        gVar.u(this.bdo).b(this.gsg).a(this.gsg.Hf().getSchemeCallback());
        com.baidu.live.view.web.a[] KO = gVar.KO();
        for (com.baidu.live.view.web.a aVar : KO) {
            this.gsg.Hf().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gsg.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.gsg != null && this.gsg.isShowing() && this.gsg.Hf() != null) {
            this.gsg.Hf().onResume();
        }
    }

    public void pause() {
        if (this.gsg != null && this.gsg.isShowing() && this.gsg.Hf() != null) {
            this.gsg.Hf().onPause();
        }
    }

    public void dismiss() {
        if (this.gsg != null) {
            this.gsg.buZ();
        }
    }

    public void cA(int i) {
        if (this.gsg != null && this.gsg.isShowing()) {
            this.gsg.cA(i);
        }
    }

    public void yW() {
        dismiss();
    }

    public void release() {
        yW();
        MessageManager.getInstance().unRegisterListener(this.fxk);
    }

    private void buY() {
        this.fxk = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.gsg != null && e.this.gsg.isShowing()) {
                    e.this.gsg.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fxk);
    }

    private int fI(String str) {
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
        sb.append(p.Jq());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.gse = aVar;
    }

    public d.a bJC() {
        return this.gse;
    }
}
