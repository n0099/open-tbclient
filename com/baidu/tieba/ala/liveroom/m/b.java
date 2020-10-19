package com.baidu.tieba.ala.liveroom.m;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.ala.liveroom.m.a;
/* loaded from: classes4.dex */
public class b {
    private Activity bFt;
    private CustomMessageListener bFv;
    private a.InterfaceC0649a gRn;
    private a gRp;

    public b(Activity activity) {
        this.bFt = activity;
        Ty();
    }

    public void eo(String str, String str2) {
        this.gRp = new a(this.bFt);
        this.gRp.a(this.gRn);
        this.gRp.Tz().setBackgroundColor(hH(str));
        g gVar = new g();
        gVar.x(this.bFt).a(this.gRp).a(this.gRp.Tz().getSchemeCallback());
        com.baidu.live.view.web.a[] Tx = gVar.Tx();
        for (com.baidu.live.view.web.a aVar : Tx) {
            this.gRp.Tz().addJavascriptInterface(aVar, aVar.getName());
        }
        if (!this.gRp.isShowing()) {
            this.gRp.en(str, str2);
        }
    }

    public void resume() {
        if (this.gRp != null && this.gRp.isShowing() && this.gRp.Tz() != null) {
            this.gRp.Tz().onResume();
        }
    }

    public void pause() {
        if (this.gRp != null && this.gRp.isShowing() && this.gRp.Tz() != null) {
            this.gRp.Tz().onPause();
        }
    }

    public void dismiss() {
        if (this.gRp != null) {
            this.gRp.TA();
        }
    }

    public void dI(int i) {
        if (this.gRp != null && this.gRp.isShowing()) {
            this.gRp.dI(i);
        }
    }

    public void Gx() {
        dismiss();
    }

    public void release() {
        Gx();
        MessageManager.getInstance().unRegisterListener(this.bFv);
        this.bFv = null;
    }

    private void Ty() {
        if (this.bFv == null) {
            this.bFv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.m.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.gRp != null && b.this.gRp.isShowing()) {
                        b.this.gRp.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bFv);
        }
    }

    private int hH(String str) {
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

    public void a(a.InterfaceC0649a interfaceC0649a) {
        this.gRn = interfaceC0649a;
    }

    public a.InterfaceC0649a bWI() {
        return this.gRn;
    }
}
