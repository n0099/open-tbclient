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
    private Activity bIs;
    private CustomMessageListener bIu;
    private c gnw;
    private PopupWindow.OnDismissListener gnx;

    public b(Activity activity) {
        this.bIs = activity;
        Uy();
    }

    @Override // com.baidu.live.a.b
    public void c(String str, long j, long j2) {
        this.gnw = new c(this.bIs);
        this.gnw.setOnDismissListener(this.gnx);
        this.gnw.Uz().setBackgroundColor(hP(str));
        g gVar = new g();
        gVar.x(this.bIs).a(this.gnw).a(this.gnw.Uz().getSchemeCallback());
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.gnw.Uz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.gnw.FZ(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.a.b
    public void resume() {
        if (this.gnw != null && this.gnw.isShowing() && this.gnw.Uz() != null) {
            this.gnw.Uz().onResume();
        }
    }

    @Override // com.baidu.live.a.b
    public void pause() {
        if (this.gnw != null && this.gnw.isShowing() && this.gnw.Uz() != null) {
            this.gnw.Uz().onPause();
        }
    }

    public void dismiss() {
        if (this.gnw != null) {
            this.gnw.UA();
        }
    }

    public void GS() {
        dismiss();
    }

    @Override // com.baidu.live.a.b
    public void release() {
        GS();
        MessageManager.getInstance().unRegisterListener(this.bIu);
    }

    private void Uy() {
        this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.gnw != null && b.this.gnw.isShowing()) {
                    b.this.gnw.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bIu);
    }

    private int hP(String str) {
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
