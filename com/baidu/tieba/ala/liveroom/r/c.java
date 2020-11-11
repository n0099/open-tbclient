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
    private Activity bNY;
    private CustomMessageListener bOa;
    private PopupWindow.OnDismissListener gtk;
    private d hqg;

    public c(Activity activity) {
        this.bNY = activity;
        WY();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void hT(String str) {
        this.hqg = new d(this.bNY);
        this.hqg.setOnDismissListener(this.gtk);
        this.hqg.WZ().setBackgroundColor(hW(str));
        g gVar = new g();
        gVar.y(this.bNY).a(this.hqg).a(this.hqg.WZ().getSchemeCallback());
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.hqg.WZ().addJavascriptInterface(aVar, aVar.getName());
        }
        this.hqg.Gn(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void resume() {
        if (this.hqg != null && this.hqg.isShowing() && this.hqg.WZ() != null) {
            this.hqg.WZ().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void pause() {
        if (this.hqg != null && this.hqg.isShowing() && this.hqg.WZ() != null) {
            this.hqg.WZ().onPause();
        }
    }

    public void dismiss() {
        if (this.hqg != null) {
            this.hqg.Xa();
        }
    }

    public void dI(int i) {
        if (this.hqg != null && this.hqg.isShowing()) {
            this.hqg.dI(i);
        }
    }

    public void Ht() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void release() {
        Ht();
        MessageManager.getInstance().unRegisterListener(this.bOa);
        this.bOa = null;
    }

    private void WY() {
        if (this.bOa == null) {
            this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.r.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (c.this.hqg != null && c.this.hqg.isShowing()) {
                        c.this.hqg.dismiss();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bOa);
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
}
