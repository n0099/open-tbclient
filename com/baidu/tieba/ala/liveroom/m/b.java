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
    private Activity byQ;
    private CustomMessageListener byS;
    private a.InterfaceC0631a gCU;
    private a gCW;

    public b(Activity activity) {
        this.byQ = activity;
        RF();
    }

    public void eh(String str, String str2) {
        this.gCW = new a(this.byQ);
        this.gCW.a(this.gCU);
        this.gCW.RG().setBackgroundColor(hq(str));
        g gVar = new g();
        gVar.w(this.byQ).a(this.gCW).a(this.gCW.RG().getSchemeCallback());
        com.baidu.live.view.web.a[] RE = gVar.RE();
        for (com.baidu.live.view.web.a aVar : RE) {
            this.gCW.RG().addJavascriptInterface(aVar, aVar.getName());
        }
        if (!this.gCW.isShowing()) {
            this.gCW.eg(str, str2);
        }
    }

    public void resume() {
        if (this.gCW != null && this.gCW.isShowing() && this.gCW.RG() != null) {
            this.gCW.RG().onResume();
        }
    }

    public void pause() {
        if (this.gCW != null && this.gCW.isShowing() && this.gCW.RG() != null) {
            this.gCW.RG().onPause();
        }
    }

    public void dismiss() {
        if (this.gCW != null) {
            this.gCW.RH();
        }
    }

    public void dD(int i) {
        if (this.gCW != null && this.gCW.isShowing()) {
            this.gCW.dD(i);
        }
    }

    public void FB() {
        dismiss();
    }

    public void release() {
        FB();
        MessageManager.getInstance().unRegisterListener(this.byS);
    }

    private void RF() {
        this.byS = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.m.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gCW != null && b.this.gCW.isShowing()) {
                    b.this.gCW.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.byS);
    }

    private int hq(String str) {
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

    public void a(a.InterfaceC0631a interfaceC0631a) {
        this.gCU = interfaceC0631a;
    }

    public a.InterfaceC0631a bTp() {
        return this.gCU;
    }
}
