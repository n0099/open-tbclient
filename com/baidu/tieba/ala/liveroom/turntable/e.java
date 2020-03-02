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
    private CustomMessageListener euT;
    private d.a fkX;
    private d fkZ;
    private Activity mContext;

    public e(Activity activity) {
        this.mContext = activity;
        bdG();
    }

    public void a(String str, long j, long j2, long j3) {
        this.fkZ = new d(this.mContext);
        this.fkZ.a(this.fkX);
        this.fkZ.bdH().setBackgroundColor(xK(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.fkZ).a(this.fkZ.bdH().getSchemeCallback());
        com.baidu.live.view.web.a[] BC = fVar.BC();
        for (com.baidu.live.view.web.a aVar : BC) {
            this.fkZ.bdH().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fkZ.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.fkZ != null && this.fkZ.isShowing() && this.fkZ.bdH() != null) {
            this.fkZ.bdH().onResume();
        }
    }

    public void pause() {
        if (this.fkZ != null && this.fkZ.isShowing() && this.fkZ.bdH() != null) {
            this.fkZ.bdH().onPause();
        }
    }

    public void dismiss() {
        if (this.fkZ != null) {
            this.fkZ.bdI();
        }
    }

    public void bW(int i) {
        if (this.fkZ != null && this.fkZ.isShowing()) {
            this.fkZ.bW(i);
        }
    }

    public void sL() {
        dismiss();
    }

    public void release() {
        sL();
        MessageManager.getInstance().unRegisterListener(this.euT);
    }

    private void bdG() {
        this.euT = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.fkZ != null && e.this.fkZ.isShowing()) {
                    e.this.fkZ.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.euT);
    }

    private int xK(String str) {
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
        sb.append(q.Bg());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.fkX = aVar;
    }

    public d.a bqC() {
        return this.fkX;
    }
}
