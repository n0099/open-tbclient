package com.baidu.tieba.ala.liveroom.n;

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
    private Activity caN;
    private CustomMessageListener eZc;
    private PopupWindow.OnDismissListener eZd;
    private d fNi;

    public c(Activity activity) {
        this.caN = activity;
        bmB();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void AE(String str) {
        this.fNi = new d(this.caN);
        this.fNi.setOnDismissListener(this.eZd);
        this.fNi.bmC().setBackgroundColor(zt(str));
        g gVar = new g();
        gVar.u(this.caN).a(this.fNi).a(this.fNi.bmC().getSchemeCallback());
        com.baidu.live.view.web.a[] HM = gVar.HM();
        for (com.baidu.live.view.web.a aVar : HM) {
            this.fNi.bmC().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fNi.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void resume() {
        if (this.fNi != null && this.fNi.isShowing() && this.fNi.bmC() != null) {
            this.fNi.bmC().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void pause() {
        if (this.fNi != null && this.fNi.isShowing() && this.fNi.bmC() != null) {
            this.fNi.bmC().onPause();
        }
    }

    public void dismiss() {
        if (this.fNi != null) {
            this.fNi.bmD();
        }
    }

    public void xi() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void release() {
        xi();
        MessageManager.getInstance().unRegisterListener(this.eZc);
    }

    private void bmB() {
        this.eZc = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.fNi != null && c.this.fNi.isShowing()) {
                    c.this.fNi.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eZc);
    }

    private int zt(String str) {
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
