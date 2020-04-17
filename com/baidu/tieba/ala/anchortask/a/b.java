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
    private Activity caH;
    private c eYW;
    private CustomMessageListener eYX;
    private PopupWindow.OnDismissListener eYY;

    public b(Activity activity) {
        this.caH = activity;
        bmD();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.eYW = new c(this.caH);
        this.eYW.setOnDismissListener(this.eYY);
        this.eYW.bmE().setBackgroundColor(zq(str));
        g gVar = new g();
        gVar.u(this.caH).a(this.eYW).a(this.eYW.bmE().getSchemeCallback());
        com.baidu.live.view.web.a[] HN = gVar.HN();
        for (com.baidu.live.view.web.a aVar : HN) {
            this.eYW.bmE().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eYW.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.eYW != null && this.eYW.isShowing() && this.eYW.bmE() != null) {
            this.eYW.bmE().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.eYW != null && this.eYW.isShowing() && this.eYW.bmE() != null) {
            this.eYW.bmE().onPause();
        }
    }

    public void dismiss() {
        if (this.eYW != null) {
            this.eYW.bmF();
        }
    }

    public void xj() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        xj();
        MessageManager.getInstance().unRegisterListener(this.eYX);
    }

    private void bmD() {
        this.eYX = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.eYW != null && b.this.eYW.isShowing()) {
                    b.this.eYW.dismiss();
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
