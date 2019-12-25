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
import com.baidu.live.view.web.f;
/* loaded from: classes2.dex */
public class b implements com.baidu.live.b.b {
    private c epu;
    private CustomMessageListener epv;
    private PopupWindow.OnDismissListener epw;
    private Activity mContext;

    public b(Activity activity) {
        this.mContext = activity;
        baU();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.epu = new c(this.mContext);
        this.epu.setOnDismissListener(this.epw);
        this.epu.baV().setBackgroundColor(xl(str));
        f fVar = new f();
        fVar.x(this.mContext).a(this.epu).a(this.epu.baV().getSchemeCallback());
        com.baidu.live.view.web.a[] yO = fVar.yO();
        for (com.baidu.live.view.web.a aVar : yO) {
            this.epu.baV().addJavascriptInterface(aVar, aVar.getName());
        }
        this.epu.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.epu != null && this.epu.isShowing() && this.epu.baV() != null) {
            this.epu.baV().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.epu != null && this.epu.isShowing() && this.epu.baV() != null) {
            this.epu.baV().onPause();
        }
    }

    public void dismiss() {
        if (this.epu != null) {
            this.epu.baW();
        }
    }

    public void th() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        th();
        MessageManager.getInstance().unRegisterListener(this.epv);
    }

    private void baU() {
        this.epv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.epu != null && b.this.epu.isShowing()) {
                    b.this.epu.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.epv);
    }

    private int xl(String str) {
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
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor('#' + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
