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
    private Activity bFt;
    private CustomMessageListener bFv;
    private c gds;
    private PopupWindow.OnDismissListener gdt;

    public b(Activity activity) {
        this.bFt = activity;
        Ty();
    }

    @Override // com.baidu.live.a.b
    public void c(String str, long j, long j2) {
        this.gds = new c(this.bFt);
        this.gds.setOnDismissListener(this.gdt);
        this.gds.Tz().setBackgroundColor(hH(str));
        g gVar = new g();
        gVar.x(this.bFt).a(this.gds).a(this.gds.Tz().getSchemeCallback());
        com.baidu.live.view.web.a[] Tx = gVar.Tx();
        for (com.baidu.live.view.web.a aVar : Tx) {
            this.gds.Tz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gds.Fz(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.a.b
    public void resume() {
        if (this.gds != null && this.gds.isShowing() && this.gds.Tz() != null) {
            this.gds.Tz().onResume();
        }
    }

    @Override // com.baidu.live.a.b
    public void pause() {
        if (this.gds != null && this.gds.isShowing() && this.gds.Tz() != null) {
            this.gds.Tz().onPause();
        }
    }

    public void dismiss() {
        if (this.gds != null) {
            this.gds.TA();
        }
    }

    public void Gx() {
        dismiss();
    }

    @Override // com.baidu.live.a.b
    public void release() {
        Gx();
        MessageManager.getInstance().unRegisterListener(this.bFv);
    }

    private void Ty() {
        this.bFv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gds != null && b.this.gds.isShowing()) {
                    b.this.gds.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bFv);
    }

    private int hH(String str) {
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
