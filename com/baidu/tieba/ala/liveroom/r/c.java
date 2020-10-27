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
    private Activity bIs;
    private CustomMessageListener bIu;
    private PopupWindow.OnDismissListener gnx;
    private d hkp;

    public c(Activity activity) {
        this.bIs = activity;
        Uy();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void hM(String str) {
        this.hkp = new d(this.bIs);
        this.hkp.setOnDismissListener(this.gnx);
        this.hkp.Uz().setBackgroundColor(hP(str));
        g gVar = new g();
        gVar.x(this.bIs).a(this.hkp).a(this.hkp.Uz().getSchemeCallback());
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.hkp.Uz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hkp.FZ(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void resume() {
        if (this.hkp != null && this.hkp.isShowing() && this.hkp.Uz() != null) {
            this.hkp.Uz().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void pause() {
        if (this.hkp != null && this.hkp.isShowing() && this.hkp.Uz() != null) {
            this.hkp.Uz().onPause();
        }
    }

    public void dismiss() {
        if (this.hkp != null) {
            this.hkp.UA();
        }
    }

    public void dI(int i) {
        if (this.hkp != null && this.hkp.isShowing()) {
            this.hkp.dI(i);
        }
    }

    public void GS() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void release() {
        GS();
        MessageManager.getInstance().unRegisterListener(this.bIu);
        this.bIu = null;
    }

    private void Uy() {
        if (this.bIu == null) {
            this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.r.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (c.this.hkp != null && c.this.hkp.isShowing()) {
                        c.this.hkp.dismiss();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bIu);
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
}
