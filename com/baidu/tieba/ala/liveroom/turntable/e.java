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
/* loaded from: classes3.dex */
public class e {
    private CustomMessageListener evC;
    private d.a flJ;
    private d flL;
    private Activity mContext;

    public e(Activity activity) {
        this.mContext = activity;
        bdM();
    }

    public void a(String str, long j, long j2, long j3) {
        this.flL = new d(this.mContext);
        this.flL.a(this.flJ);
        this.flL.bdN().setBackgroundColor(xM(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.flL).a(this.flL.bdN().getSchemeCallback());
        com.baidu.live.view.web.a[] BJ = fVar.BJ();
        for (com.baidu.live.view.web.a aVar : BJ) {
            this.flL.bdN().addJavascriptInterface(aVar, aVar.getName());
        }
        this.flL.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.flL != null && this.flL.isShowing() && this.flL.bdN() != null) {
            this.flL.bdN().onResume();
        }
    }

    public void pause() {
        if (this.flL != null && this.flL.isShowing() && this.flL.bdN() != null) {
            this.flL.bdN().onPause();
        }
    }

    public void dismiss() {
        if (this.flL != null) {
            this.flL.bdO();
        }
    }

    public void bW(int i) {
        if (this.flL != null && this.flL.isShowing()) {
            this.flL.bW(i);
        }
    }

    public void sQ() {
        dismiss();
    }

    public void release() {
        sQ();
        MessageManager.getInstance().unRegisterListener(this.evC);
    }

    private void bdM() {
        this.evC = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.flL != null && e.this.flL.isShowing()) {
                    e.this.flL.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.evC);
    }

    private int xM(String str) {
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
        sb.append(q.Bn());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.flJ = aVar;
    }

    public d.a bqI() {
        return this.flJ;
    }
}
