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
    private Activity bdo;
    private c fxj;
    private CustomMessageListener fxk;
    private PopupWindow.OnDismissListener fxl;

    public b(Activity activity) {
        this.bdo = activity;
        buX();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.fxj = new c(this.bdo);
        this.fxj.setOnDismissListener(this.fxl);
        this.fxj.Hf().setBackgroundColor(fI(str));
        g gVar = new g();
        gVar.u(this.bdo).b(this.fxj).a(this.fxj.Hf().getSchemeCallback());
        com.baidu.live.view.web.a[] KO = gVar.KO();
        for (com.baidu.live.view.web.a aVar : KO) {
            this.fxj.Hf().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fxj.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.fxj != null && this.fxj.isShowing() && this.fxj.Hf() != null) {
            this.fxj.Hf().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.fxj != null && this.fxj.isShowing() && this.fxj.Hf() != null) {
            this.fxj.Hf().onPause();
        }
    }

    public void dismiss() {
        if (this.fxj != null) {
            this.fxj.buY();
        }
    }

    public void yW() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        yW();
        MessageManager.getInstance().unRegisterListener(this.fxk);
    }

    private void buX() {
        this.fxk = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.fxj != null && b.this.fxj.isShowing()) {
                    b.this.fxj.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fxk);
    }

    private int fI(String str) {
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
