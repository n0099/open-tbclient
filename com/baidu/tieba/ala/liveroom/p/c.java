package com.baidu.tieba.ala.liveroom.p;

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
    private Activity bdG;
    private CustomMessageListener fCr;
    private PopupWindow.OnDismissListener fCs;
    private d gtw;

    public c(Activity activity) {
        this.bdG = activity;
        byh();
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void DO(String str) {
        this.gtw = new d(this.bdG);
        this.gtw.setOnDismissListener(this.fCs);
        this.gtw.Hl().setBackgroundColor(fG(str));
        g gVar = new g();
        gVar.v(this.bdG).b(this.gtw).a(this.gtw.Hl().getSchemeCallback());
        com.baidu.live.view.web.a[] KV = gVar.KV();
        for (com.baidu.live.view.web.a aVar : KV) {
            this.gtw.Hl().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gtw.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void resume() {
        if (this.gtw != null && this.gtw.isShowing() && this.gtw.Hl() != null) {
            this.gtw.Hl().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void pause() {
        if (this.gtw != null && this.gtw.isShowing() && this.gtw.Hl() != null) {
            this.gtw.Hl().onPause();
        }
    }

    public void dismiss() {
        if (this.gtw != null) {
            this.gtw.byi();
        }
    }

    public void zy() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void release() {
        zy();
        MessageManager.getInstance().unRegisterListener(this.fCr);
    }

    private void byh() {
        this.fCr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.p.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.gtw != null && c.this.gtw.isShowing()) {
                    c.this.gtw.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fCr);
    }

    private int fG(String str) {
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
