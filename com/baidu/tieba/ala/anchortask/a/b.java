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
    private Activity bNY;
    private CustomMessageListener bOa;
    private c gtj;
    private PopupWindow.OnDismissListener gtk;

    public b(Activity activity) {
        this.bNY = activity;
        WY();
    }

    @Override // com.baidu.live.a.b
    public void c(String str, long j, long j2) {
        this.gtj = new c(this.bNY);
        this.gtj.setOnDismissListener(this.gtk);
        this.gtj.WZ().setBackgroundColor(hW(str));
        g gVar = new g();
        gVar.y(this.bNY).a(this.gtj).a(this.gtj.WZ().getSchemeCallback());
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.gtj.WZ().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gtj.Gn(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.a.b
    public void resume() {
        if (this.gtj != null && this.gtj.isShowing() && this.gtj.WZ() != null) {
            this.gtj.WZ().onResume();
        }
    }

    @Override // com.baidu.live.a.b
    public void pause() {
        if (this.gtj != null && this.gtj.isShowing() && this.gtj.WZ() != null) {
            this.gtj.WZ().onPause();
        }
    }

    public void dismiss() {
        if (this.gtj != null) {
            this.gtj.Xa();
        }
    }

    public void Ht() {
        dismiss();
    }

    @Override // com.baidu.live.a.b
    public void release() {
        Ht();
        MessageManager.getInstance().unRegisterListener(this.bOa);
    }

    private void WY() {
        this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gtj != null && b.this.gtj.isShowing()) {
                    b.this.gtj.dismiss();
                }
            }
        };
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
