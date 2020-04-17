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
    private Activity caH;
    private CustomMessageListener eYX;
    private d.a fQh;
    private d fQj;

    public e(Activity activity) {
        this.caH = activity;
        bmD();
    }

    public void a(String str, long j, long j2, long j3) {
        this.fQj = new d(this.caH);
        this.fQj.a(this.fQh);
        this.fQj.bmE().setBackgroundColor(zq(str));
        g gVar = new g();
        gVar.u(this.caH).a(this.fQj).a(this.fQj.bmE().getSchemeCallback());
        com.baidu.live.view.web.a[] HN = gVar.HN();
        for (com.baidu.live.view.web.a aVar : HN) {
            this.fQj.bmE().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fQj.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.fQj != null && this.fQj.isShowing() && this.fQj.bmE() != null) {
            this.fQj.bmE().onResume();
        }
    }

    public void pause() {
        if (this.fQj != null && this.fQj.isShowing() && this.fQj.bmE() != null) {
            this.fQj.bmE().onPause();
        }
    }

    public void dismiss() {
        if (this.fQj != null) {
            this.fQj.bmF();
        }
    }

    public void cl(int i) {
        if (this.fQj != null && this.fQj.isShowing()) {
            this.fQj.cl(i);
        }
    }

    public void xj() {
        dismiss();
    }

    public void release() {
        xj();
        MessageManager.getInstance().unRegisterListener(this.eYX);
    }

    private void bmD() {
        this.eYX = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.fQj != null && e.this.fQj.isShowing()) {
                    e.this.fQj.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eYX);
    }

    private int zq(String str) {
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
        sb.append(q.Gl());
        return sb.toString();
    }

    public void a(d.a aVar) {
        this.fQh = aVar;
    }

    public d.a bAh() {
        return this.fQh;
    }
}
