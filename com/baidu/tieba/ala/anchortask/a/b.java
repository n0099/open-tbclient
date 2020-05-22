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
    private c flL;
    private CustomMessageListener flM;
    private PopupWindow.OnDismissListener flN;

    public b(Activity activity) {
        this.clq = activity;
        brZ();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.flL = new c(this.clq);
        this.flL.setOnDismissListener(this.flN);
        this.flL.bsa().setBackgroundColor(AZ(str));
        g gVar = new g();
        gVar.u(this.clq).a(this.flL).a(this.flL.bsa().getSchemeCallback());
        com.baidu.live.view.web.a[] JF = gVar.JF();
        for (com.baidu.live.view.web.a aVar : JF) {
            this.flL.bsa().addJavascriptInterface(aVar, aVar.getName());
        }
        this.flL.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.flL != null && this.flL.isShowing() && this.flL.bsa() != null) {
            this.flL.bsa().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.flL != null && this.flL.isShowing() && this.flL.bsa() != null) {
            this.flL.bsa().onPause();
        }
    }

    public void dismiss() {
        if (this.flL != null) {
            this.flL.bsb();
        }
    }

    public void yw() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        yw();
        MessageManager.getInstance().unRegisterListener(this.flM);
    }

    private void brZ() {
        this.flM = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.flL != null && b.this.flL.isShowing()) {
                    b.this.flL.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.flM);
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
