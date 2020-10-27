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
    private Activity bIs;
    private CustomMessageListener bIu;
    private a.InterfaceC0665a hda;
    private a hdc;

    public b(Activity activity) {
        this.bIs = activity;
        Uy();
    }

    public void ev(String str, String str2) {
        this.hdc = new a(this.bIs);
        this.hdc.a(this.hda);
        this.hdc.Uz().setBackgroundColor(hP(str));
        g gVar = new g();
        gVar.x(this.bIs).a(this.hdc).a(this.hdc.Uz().getSchemeCallback());
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.hdc.Uz().addJavascriptInterface(aVar, aVar.getName());
        }
        if (!this.hdc.isShowing()) {
            this.hdc.eu(str, str2);
        }
    }

    public void resume() {
        if (this.hdc != null && this.hdc.isShowing() && this.hdc.Uz() != null) {
            this.hdc.Uz().onResume();
        }
    }

    public void pause() {
        if (this.hdc != null && this.hdc.isShowing() && this.hdc.Uz() != null) {
            this.hdc.Uz().onPause();
        }
    }

    public void dismiss() {
        if (this.hdc != null) {
            this.hdc.UA();
        }
    }

    public void dI(int i) {
        if (this.hdc != null && this.hdc.isShowing()) {
            this.hdc.dI(i);
        }
    }

    public void GS() {
        dismiss();
    }

    public void release() {
        GS();
        MessageManager.getInstance().unRegisterListener(this.bIu);
        this.bIu = null;
    }

    private void Uy() {
        if (this.bIu == null) {
            this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.m.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.hdc != null && b.this.hdc.isShowing()) {
                        b.this.hdc.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bIu);
        }
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

    public void a(a.InterfaceC0665a interfaceC0665a) {
        this.hda = interfaceC0665a;
    }

    public a.InterfaceC0665a bZH() {
        return this.hda;
    }
}
