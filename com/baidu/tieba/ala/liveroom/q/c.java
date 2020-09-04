package com.baidu.tieba.ala.liveroom.q;

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
/* loaded from: classes7.dex */
public class c implements a {
    private Activity cAc;
    private CustomMessageListener fNN;
    private PopupWindow.OnDismissListener fNO;
    private d gGz;

    public c(Activity activity) {
        this.cAc = activity;
        bHh();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void Go(String str) {
        this.gGz = new d(this.cAc);
        this.gGz.setOnDismissListener(this.fNO);
        this.gGz.bHi().setBackgroundColor(EE(str));
        g gVar = new g();
        gVar.v(this.cAc).a(this.gGz).a(this.gGz.bHi().getSchemeCallback());
        com.baidu.live.view.web.a[] QV = gVar.QV();
        for (com.baidu.live.view.web.a aVar : QV) {
            this.gGz.bHi().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gGz.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void resume() {
        if (this.gGz != null && this.gGz.isShowing() && this.gGz.bHi() != null) {
            this.gGz.bHi().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void pause() {
        if (this.gGz != null && this.gGz.isShowing() && this.gGz.bHi() != null) {
            this.gGz.bHi().onPause();
        }
    }

    public void dismiss() {
        if (this.gGz != null) {
            this.gGz.bHj();
        }
    }

    public void Fb() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void release() {
        Fb();
        MessageManager.getInstance().unRegisterListener(this.fNN);
    }

    private void bHh() {
        this.fNN = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.q.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.gGz != null && c.this.gGz.isShowing()) {
                    c.this.gGz.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fNN);
    }

    private int EE(String str) {
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
