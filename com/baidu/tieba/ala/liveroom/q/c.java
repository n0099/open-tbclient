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
    private Activity czY;
    private CustomMessageListener fNJ;
    private PopupWindow.OnDismissListener fNK;
    private d gGv;

    public c(Activity activity) {
        this.czY = activity;
        bHg();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void Gn(String str) {
        this.gGv = new d(this.czY);
        this.gGv.setOnDismissListener(this.fNK);
        this.gGv.bHh().setBackgroundColor(ED(str));
        g gVar = new g();
        gVar.v(this.czY).a(this.gGv).a(this.gGv.bHh().getSchemeCallback());
        com.baidu.live.view.web.a[] QV = gVar.QV();
        for (com.baidu.live.view.web.a aVar : QV) {
            this.gGv.bHh().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gGv.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void resume() {
        if (this.gGv != null && this.gGv.isShowing() && this.gGv.bHh() != null) {
            this.gGv.bHh().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void pause() {
        if (this.gGv != null && this.gGv.isShowing() && this.gGv.bHh() != null) {
            this.gGv.bHh().onPause();
        }
    }

    public void dismiss() {
        if (this.gGv != null) {
            this.gGv.bHi();
        }
    }

    public void Fb() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.q.a
    public void release() {
        Fb();
        MessageManager.getInstance().unRegisterListener(this.fNJ);
    }

    private void bHg() {
        this.fNJ = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.q.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.gGv != null && c.this.gGv.isShowing()) {
                    c.this.gGv.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fNJ);
    }

    private int ED(String str) {
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
