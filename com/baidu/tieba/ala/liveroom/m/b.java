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
    private Activity bMo;
    private CustomMessageListener bMq;
    private a.InterfaceC0679a hiD;
    private a hiF;

    public b(Activity activity) {
        this.bMo = activity;
        Wp();
    }

    public void ev(String str, String str2) {
        this.hiF = new a(this.bMo);
        this.hiF.a(this.hiD);
        this.hiF.Wq().setBackgroundColor(hQ(str));
        g gVar = new g();
        gVar.x(this.bMo).a(this.hiF).a(this.hiF.Wq().getSchemeCallback());
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.hiF.Wq().addJavascriptInterface(aVar, aVar.getName());
        }
        if (!this.hiF.isShowing()) {
            this.hiF.eu(str, str2);
        }
    }

    public void resume() {
        if (this.hiF != null && this.hiF.isShowing() && this.hiF.Wq() != null) {
            this.hiF.Wq().onResume();
        }
    }

    public void pause() {
        if (this.hiF != null && this.hiF.isShowing() && this.hiF.Wq() != null) {
            this.hiF.Wq().onPause();
        }
    }

    public void dismiss() {
        if (this.hiF != null) {
            this.hiF.Wr();
        }
    }

    public void dE(int i) {
        if (this.hiF != null && this.hiF.isShowing()) {
            this.hiF.dE(i);
        }
    }

    public void GK() {
        dismiss();
    }

    public void release() {
        GK();
        MessageManager.getInstance().unRegisterListener(this.bMq);
        this.bMq = null;
    }

    private void Wp() {
        if (this.bMq == null) {
            this.bMq = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.m.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.hiF != null && b.this.hiF.isShowing()) {
                        b.this.hiF.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bMq);
        }
    }

    private int hQ(String str) {
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

    public void a(a.InterfaceC0679a interfaceC0679a) {
        this.hiD = interfaceC0679a;
    }

    public a.InterfaceC0679a cbC() {
        return this.hiD;
    }
}
