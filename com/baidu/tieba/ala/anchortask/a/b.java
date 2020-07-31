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
public class b implements com.baidu.live.b.b {
    private Activity bdG;
    private c fCq;
    private CustomMessageListener fCr;
    private PopupWindow.OnDismissListener fCs;

    public b(Activity activity) {
        this.bdG = activity;
        byh();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.fCq = new c(this.bdG);
        this.fCq.setOnDismissListener(this.fCs);
        this.fCq.Hl().setBackgroundColor(fG(str));
        g gVar = new g();
        gVar.v(this.bdG).b(this.fCq).a(this.fCq.Hl().getSchemeCallback());
        com.baidu.live.view.web.a[] KV = gVar.KV();
        for (com.baidu.live.view.web.a aVar : KV) {
            this.fCq.Hl().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fCq.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.fCq != null && this.fCq.isShowing() && this.fCq.Hl() != null) {
            this.fCq.Hl().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.fCq != null && this.fCq.isShowing() && this.fCq.Hl() != null) {
            this.fCq.Hl().onPause();
        }
    }

    public void dismiss() {
        if (this.fCq != null) {
            this.fCq.byi();
        }
    }

    public void zy() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        zy();
        MessageManager.getInstance().unRegisterListener(this.fCr);
    }

    private void byh() {
        this.fCr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.fCq != null && b.this.fCq.isShowing()) {
                    b.this.fCq.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fCr);
    }

    private int fG(String str) {
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
