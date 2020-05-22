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
    private Activity clq;
    private CustomMessageListener flM;
    private PopupWindow.OnDismissListener flN;
    private d gbn;

    public c(Activity activity) {
        this.clq = activity;
        brZ();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void Cm(String str) {
        this.gbn = new d(this.clq);
        this.gbn.setOnDismissListener(this.flN);
        this.gbn.bsa().setBackgroundColor(AZ(str));
        g gVar = new g();
        gVar.u(this.clq).a(this.gbn).a(this.gbn.bsa().getSchemeCallback());
        com.baidu.live.view.web.a[] JF = gVar.JF();
        for (com.baidu.live.view.web.a aVar : JF) {
            this.gbn.bsa().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gbn.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void resume() {
        if (this.gbn != null && this.gbn.isShowing() && this.gbn.bsa() != null) {
            this.gbn.bsa().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void pause() {
        if (this.gbn != null && this.gbn.isShowing() && this.gbn.bsa() != null) {
            this.gbn.bsa().onPause();
        }
    }

    public void dismiss() {
        if (this.gbn != null) {
            this.gbn.bsb();
        }
    }

    public void yw() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void release() {
        yw();
        MessageManager.getInstance().unRegisterListener(this.flM);
    }

    private void brZ() {
        this.flM = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.gbn != null && c.this.gbn.isShowing()) {
                    c.this.gbn.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.flM);
    }

    private int AZ(String str) {
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
