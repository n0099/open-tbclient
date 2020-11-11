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
    private Activity bNY;
    private CustomMessageListener bOa;
    private a.InterfaceC0679a hiW;
    private a hiY;

    public b(Activity activity) {
        this.bNY = activity;
        WY();
    }

    public void ev(String str, String str2) {
        this.hiY = new a(this.bNY);
        this.hiY.a(this.hiW);
        this.hiY.WZ().setBackgroundColor(hW(str));
        g gVar = new g();
        gVar.y(this.bNY).a(this.hiY).a(this.hiY.WZ().getSchemeCallback());
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.hiY.WZ().addJavascriptInterface(aVar, aVar.getName());
        }
        if (!this.hiY.isShowing()) {
            this.hiY.eu(str, str2);
        }
    }

    public void resume() {
        if (this.hiY != null && this.hiY.isShowing() && this.hiY.WZ() != null) {
            this.hiY.WZ().onResume();
        }
    }

    public void pause() {
        if (this.hiY != null && this.hiY.isShowing() && this.hiY.WZ() != null) {
            this.hiY.WZ().onPause();
        }
    }

    public void dismiss() {
        if (this.hiY != null) {
            this.hiY.Xa();
        }
    }

    public void dI(int i) {
        if (this.hiY != null && this.hiY.isShowing()) {
            this.hiY.dI(i);
        }
    }

    public void Ht() {
        dismiss();
    }

    public void release() {
        Ht();
        MessageManager.getInstance().unRegisterListener(this.bOa);
        this.bOa = null;
    }

    private void WY() {
        if (this.bOa == null) {
            this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.m.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (b.this.hiY != null && b.this.hiY.isShowing()) {
                        b.this.hiY.dismiss();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bOa);
        }
    }

    private int hW(String str) {
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
        this.hiW = interfaceC0679a;
    }

    public a.InterfaceC0679a ccj() {
        return this.hiW;
    }
}
