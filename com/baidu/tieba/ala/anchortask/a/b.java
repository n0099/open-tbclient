package com.baidu.tieba.ala.anchortask.a;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes7.dex */
public class b implements com.baidu.live.b.b {
    private Activity cAc;
    private c fNM;
    private CustomMessageListener fNN;
    private PopupWindow.OnDismissListener fNO;

    public b(Activity activity) {
        this.cAc = activity;
        bHh();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.fNM = new c(this.cAc);
        this.fNM.setOnDismissListener(this.fNO);
        this.fNM.bHi().setBackgroundColor(EE(str));
        g gVar = new g();
        gVar.v(this.cAc).a(this.fNM).a(this.fNM.bHi().getSchemeCallback());
        com.baidu.live.view.web.a[] QV = gVar.QV();
        for (com.baidu.live.view.web.a aVar : QV) {
            this.fNM.bHi().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fNM.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.fNM != null && this.fNM.isShowing() && this.fNM.bHi() != null) {
            this.fNM.bHi().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.fNM != null && this.fNM.isShowing() && this.fNM.bHi() != null) {
            this.fNM.bHi().onPause();
        }
    }

    public void dismiss() {
        if (this.fNM != null) {
            this.fNM.bHj();
        }
    }

    public void Fb() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        Fb();
        MessageManager.getInstance().unRegisterListener(this.fNN);
    }

    private void bHh() {
        this.fNN = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.fNM != null && b.this.fNM.isShowing()) {
                    b.this.fNM.dismiss();
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
