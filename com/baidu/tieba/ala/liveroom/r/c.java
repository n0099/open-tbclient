package com.baidu.tieba.ala.liveroom.r;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes4.dex */
public class c implements a {
    private Activity bFt;
    private CustomMessageListener bFv;
    private d gYz;
    private PopupWindow.OnDismissListener gdt;

    public c(Activity activity) {
        this.bFt = activity;
        Ty();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void hE(String str) {
        this.gYz = new d(this.bFt);
        this.gYz.setOnDismissListener(this.gdt);
        this.gYz.Tz().setBackgroundColor(hH(str));
        g gVar = new g();
        gVar.x(this.bFt).a(this.gYz).a(this.gYz.Tz().getSchemeCallback());
        com.baidu.live.view.web.a[] Tx = gVar.Tx();
        for (com.baidu.live.view.web.a aVar : Tx) {
            this.gYz.Tz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gYz.Fz(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void resume() {
        if (this.gYz != null && this.gYz.isShowing() && this.gYz.Tz() != null) {
            this.gYz.Tz().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void pause() {
        if (this.gYz != null && this.gYz.isShowing() && this.gYz.Tz() != null) {
            this.gYz.Tz().onPause();
        }
    }

    public void dismiss() {
        if (this.gYz != null) {
            this.gYz.TA();
        }
    }

    public void dI(int i) {
        if (this.gYz != null && this.gYz.isShowing()) {
            this.gYz.dI(i);
        }
    }

    public void Gx() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void release() {
        Gx();
        MessageManager.getInstance().unRegisterListener(this.bFv);
        this.bFv = null;
    }

    private void Ty() {
        if (this.bFv == null) {
            this.bFv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.r.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (c.this.gYz != null && c.this.gYz.isShowing()) {
                        c.this.gYz.dismiss();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bFv);
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
}
