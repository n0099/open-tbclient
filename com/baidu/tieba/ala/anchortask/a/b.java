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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.a.b {
    private Activity bMo;
    private CustomMessageListener bMq;
    private c gsQ;
    private PopupWindow.OnDismissListener gsR;

    public b(Activity activity) {
        this.bMo = activity;
        Wp();
    }

    @Override // com.baidu.live.a.b
    public void c(String str, long j, long j2) {
        this.gsQ = new c(this.bMo);
        this.gsQ.setOnDismissListener(this.gsR);
        this.gsQ.Wq().setBackgroundColor(hQ(str));
        g gVar = new g();
        gVar.x(this.bMo).a(this.gsQ).a(this.gsQ.Wq().getSchemeCallback());
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.gsQ.Wq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gsQ.FO(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.a.b
    public void resume() {
        if (this.gsQ != null && this.gsQ.isShowing() && this.gsQ.Wq() != null) {
            this.gsQ.Wq().onResume();
        }
    }

    @Override // com.baidu.live.a.b
    public void pause() {
        if (this.gsQ != null && this.gsQ.isShowing() && this.gsQ.Wq() != null) {
            this.gsQ.Wq().onPause();
        }
    }

    public void dismiss() {
        if (this.gsQ != null) {
            this.gsQ.Wr();
        }
    }

    public void GK() {
        dismiss();
    }

    @Override // com.baidu.live.a.b
    public void release() {
        GK();
        MessageManager.getInstance().unRegisterListener(this.bMq);
    }

    private void Wp() {
        this.bMq = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gsQ != null && b.this.gsQ.isShowing()) {
                    b.this.gsQ.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bMq);
    }

    private int hQ(String str) {
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
