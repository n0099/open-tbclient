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
import com.baidu.live.view.web.f;
import com.baidu.tieba.ala.liveroom.turntable.d;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes2.dex */
public class e {
    private CustomMessageListener eqH;
    private d.a fhQ;
    private d fhS;
    private Activity mContext;

    public e(Activity activity) {
        this.mContext = activity;
        bbp();
    }

    public void a(String str, long j, long j2, long j3) {
        this.fhS = new d(this.mContext);
        this.fhS.a(this.fhQ);
        this.fhS.bbq().setBackgroundColor(xq(str));
        f fVar = new f();
        fVar.x(this.mContext).a(this.fhS).a(this.fhS.bbq().getSchemeCallback());
        com.baidu.live.view.web.a[] zk = fVar.zk();
        for (com.baidu.live.view.web.a aVar : zk) {
            this.fhS.bbq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fhS.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.fhS != null && this.fhS.isShowing() && this.fhS.bbq() != null) {
            this.fhS.bbq().onResume();
        }
    }

    public void pause() {
        if (this.fhS != null && this.fhS.isShowing() && this.fhS.bbq() != null) {
            this.fhS.bbq().onPause();
        }
    }

    public void dismiss() {
        if (this.fhS != null) {
            this.fhS.bbr();
        }
    }

    public void bN(int i) {
        if (this.fhS != null && this.fhS.isShowing()) {
            this.fhS.bN(i);
        }
    }

    public void tz() {
        dismiss();
    }

    public void release() {
        tz();
        MessageManager.getInstance().unRegisterListener(this.eqH);
    }

    private void bbp() {
        this.eqH = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.fhS != null && e.this.fhS.isShowing()) {
                    e.this.fhS.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eqH);
    }

    private int xq(String str) {
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
        sb.append(q.yO());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.fhQ = aVar;
    }

    public d.a boU() {
        return this.fhQ;
    }
}
