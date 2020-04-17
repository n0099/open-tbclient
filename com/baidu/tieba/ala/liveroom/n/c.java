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
    private Activity caH;
    private CustomMessageListener eYX;
    private PopupWindow.OnDismissListener eYY;
    private d fNd;

    public c(Activity activity) {
        this.caH = activity;
        bmD();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void AB(String str) {
        this.fNd = new d(this.caH);
        this.fNd.setOnDismissListener(this.eYY);
        this.fNd.bmE().setBackgroundColor(zq(str));
        g gVar = new g();
        gVar.u(this.caH).a(this.fNd).a(this.fNd.bmE().getSchemeCallback());
        com.baidu.live.view.web.a[] HN = gVar.HN();
        for (com.baidu.live.view.web.a aVar : HN) {
            this.fNd.bmE().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fNd.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void resume() {
        if (this.fNd != null && this.fNd.isShowing() && this.fNd.bmE() != null) {
            this.fNd.bmE().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void pause() {
        if (this.fNd != null && this.fNd.isShowing() && this.fNd.bmE() != null) {
            this.fNd.bmE().onPause();
        }
    }

    public void dismiss() {
        if (this.fNd != null) {
            this.fNd.bmF();
        }
    }

    public void xj() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void release() {
        xj();
        MessageManager.getInstance().unRegisterListener(this.eYX);
    }

    private void bmD() {
        this.eYX = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.fNd != null && c.this.fNd.isShowing()) {
                    c.this.fNd.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eYX);
    }

    private int zq(String str) {
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
