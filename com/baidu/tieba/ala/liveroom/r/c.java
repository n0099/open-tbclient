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
    private Activity byQ;
    private CustomMessageListener byS;
    private PopupWindow.OnDismissListener fRb;
    private d gJY;

    public c(Activity activity) {
        this.byQ = activity;
        RF();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void hn(String str) {
        this.gJY = new d(this.byQ);
        this.gJY.setOnDismissListener(this.fRb);
        this.gJY.RG().setBackgroundColor(hq(str));
        g gVar = new g();
        gVar.w(this.byQ).a(this.gJY).a(this.gJY.RG().getSchemeCallback());
        com.baidu.live.view.web.a[] RE = gVar.RE();
        for (com.baidu.live.view.web.a aVar : RE) {
            this.gJY.RG().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gJY.EO(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void resume() {
        if (this.gJY != null && this.gJY.isShowing() && this.gJY.RG() != null) {
            this.gJY.RG().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void pause() {
        if (this.gJY != null && this.gJY.isShowing() && this.gJY.RG() != null) {
            this.gJY.RG().onPause();
        }
    }

    public void dismiss() {
        if (this.gJY != null) {
            this.gJY.RH();
        }
    }

    public void dD(int i) {
        if (this.gJY != null && this.gJY.isShowing()) {
            this.gJY.dD(i);
        }
    }

    public void FB() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.r.a
    public void release() {
        FB();
        MessageManager.getInstance().unRegisterListener(this.byS);
    }

    private void RF() {
        this.byS = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.r.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.gJY != null && c.this.gJY.isShowing()) {
                    c.this.gJY.dismiss();
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
}
