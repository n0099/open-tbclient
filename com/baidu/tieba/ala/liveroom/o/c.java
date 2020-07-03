package com.baidu.tieba.ala.liveroom.o;

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
/* loaded from: classes3.dex */
public class c implements a {
    private Activity bdo;
    private CustomMessageListener fxk;
    private PopupWindow.OnDismissListener fxl;
    private d gov;

    public c(Activity activity) {
        this.bdo = activity;
        buX();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void Dc(String str) {
        this.gov = new d(this.bdo);
        this.gov.setOnDismissListener(this.fxl);
        this.gov.Hf().setBackgroundColor(fI(str));
        g gVar = new g();
        gVar.u(this.bdo).b(this.gov).a(this.gov.Hf().getSchemeCallback());
        com.baidu.live.view.web.a[] KO = gVar.KO();
        for (com.baidu.live.view.web.a aVar : KO) {
            this.gov.Hf().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gov.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void resume() {
        if (this.gov != null && this.gov.isShowing() && this.gov.Hf() != null) {
            this.gov.Hf().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void pause() {
        if (this.gov != null && this.gov.isShowing() && this.gov.Hf() != null) {
            this.gov.Hf().onPause();
        }
    }

    public void dismiss() {
        if (this.gov != null) {
            this.gov.buY();
        }
    }

    public void yW() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void release() {
        yW();
        MessageManager.getInstance().unRegisterListener(this.fxk);
    }

    private void buX() {
        this.fxk = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.o.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.gov != null && c.this.gov.isShowing()) {
                    c.this.gov.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fxk);
    }

    private int fI(String str) {
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
