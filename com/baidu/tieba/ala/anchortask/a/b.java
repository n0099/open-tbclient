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
/* loaded from: classes3.dex */
public class b implements com.baidu.live.b.b {
    private Activity clq;
    private c flW;
    private CustomMessageListener flX;
    private PopupWindow.OnDismissListener flY;

    public b(Activity activity) {
        this.clq = activity;
        bsb();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.flW = new c(this.clq);
        this.flW.setOnDismissListener(this.flY);
        this.flW.bsc().setBackgroundColor(AZ(str));
        g gVar = new g();
        gVar.u(this.clq).a(this.flW).a(this.flW.bsc().getSchemeCallback());
        com.baidu.live.view.web.a[] JF = gVar.JF();
        for (com.baidu.live.view.web.a aVar : JF) {
            this.flW.bsc().addJavascriptInterface(aVar, aVar.getName());
        }
        this.flW.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.flW != null && this.flW.isShowing() && this.flW.bsc() != null) {
            this.flW.bsc().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.flW != null && this.flW.isShowing() && this.flW.bsc() != null) {
            this.flW.bsc().onPause();
        }
    }

    public void dismiss() {
        if (this.flW != null) {
            this.flW.bsd();
        }
    }

    public void yw() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        yw();
        MessageManager.getInstance().unRegisterListener(this.flX);
    }

    private void bsb() {
        this.flX = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.flW != null && b.this.flW.isShowing()) {
                    b.this.flW.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.flX);
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
