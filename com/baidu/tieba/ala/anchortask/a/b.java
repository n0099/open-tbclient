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
/* loaded from: classes3.dex */
public class b implements com.baidu.live.b.b {
    private c evB;
    private CustomMessageListener evC;
    private PopupWindow.OnDismissListener evD;
    private Activity mContext;

    public b(Activity activity) {
        this.mContext = activity;
        bdM();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.evB = new c(this.mContext);
        this.evB.setOnDismissListener(this.evD);
        this.evB.bdN().setBackgroundColor(xL(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.evB).a(this.evB.bdN().getSchemeCallback());
        com.baidu.live.view.web.a[] BJ = fVar.BJ();
        for (com.baidu.live.view.web.a aVar : BJ) {
            this.evB.bdN().addJavascriptInterface(aVar, aVar.getName());
        }
        this.evB.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.evB != null && this.evB.isShowing() && this.evB.bdN() != null) {
            this.evB.bdN().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.evB != null && this.evB.isShowing() && this.evB.bdN() != null) {
            this.evB.bdN().onPause();
        }
    }

    public void dismiss() {
        if (this.evB != null) {
            this.evB.bdO();
        }
    }

    public void sQ() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        sQ();
        MessageManager.getInstance().unRegisterListener(this.evC);
    }

    private void bdM() {
        this.evC = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.evB != null && b.this.evB.isShowing()) {
                    b.this.evB.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.evC);
    }

    private int xL(String str) {
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
