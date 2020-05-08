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
    private Activity caN;
    private c eZb;
    private CustomMessageListener eZc;
    private PopupWindow.OnDismissListener eZd;

    public b(Activity activity) {
        this.caN = activity;
        bmB();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.eZb = new c(this.caN);
        this.eZb.setOnDismissListener(this.eZd);
        this.eZb.bmC().setBackgroundColor(zt(str));
        g gVar = new g();
        gVar.u(this.caN).a(this.eZb).a(this.eZb.bmC().getSchemeCallback());
        com.baidu.live.view.web.a[] HM = gVar.HM();
        for (com.baidu.live.view.web.a aVar : HM) {
            this.eZb.bmC().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eZb.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.eZb != null && this.eZb.isShowing() && this.eZb.bmC() != null) {
            this.eZb.bmC().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.eZb != null && this.eZb.isShowing() && this.eZb.bmC() != null) {
            this.eZb.bmC().onPause();
        }
    }

    public void dismiss() {
        if (this.eZb != null) {
            this.eZb.bmD();
        }
    }

    public void xi() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        xi();
        MessageManager.getInstance().unRegisterListener(this.eZc);
    }

    private void bmB() {
        this.eZc = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.eZb != null && b.this.eZb.isShowing()) {
                    b.this.eZb.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eZc);
    }

    private int zt(String str) {
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
