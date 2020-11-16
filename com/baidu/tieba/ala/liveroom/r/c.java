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
    private Activity bMo;
    private CustomMessageListener bMq;
    private PopupWindow.OnDismissListener gsR;
    private d hpN;

    public c(Activity activity) {
        this.bMo = activity;
        Wp();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void hN(String str) {
        this.hpN = new d(this.bMo);
        this.hpN.setOnDismissListener(this.gsR);
        this.hpN.Wq().setBackgroundColor(hQ(str));
        g gVar = new g();
        gVar.x(this.bMo).a(this.hpN).a(this.hpN.Wq().getSchemeCallback());
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.hpN.Wq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hpN.FO(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void resume() {
        if (this.hpN != null && this.hpN.isShowing() && this.hpN.Wq() != null) {
            this.hpN.Wq().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void pause() {
        if (this.hpN != null && this.hpN.isShowing() && this.hpN.Wq() != null) {
            this.hpN.Wq().onPause();
        }
    }

    public void dismiss() {
        if (this.hpN != null) {
            this.hpN.Wr();
        }
    }

    public void dE(int i) {
        if (this.hpN != null && this.hpN.isShowing()) {
            this.hpN.dE(i);
        }
    }

    public void GK() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void release() {
        GK();
        MessageManager.getInstance().unRegisterListener(this.bMq);
        this.bMq = null;
    }

    private void Wp() {
        if (this.bMq == null) {
            this.bMq = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.r.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (c.this.hpN != null && c.this.hpN.isShowing()) {
                        c.this.hpN.dismiss();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bMq);
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
}
