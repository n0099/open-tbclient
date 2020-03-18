package com.baidu.tieba.ala.liveroom.n;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.f;
/* loaded from: classes3.dex */
public class c implements a {
    private CustomMessageListener evC;
    private PopupWindow.OnDismissListener evD;
    private d fiU;
    private Activity mContext;

    public c(Activity activity) {
        this.mContext = activity;
        bdM();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void yS(String str) {
        this.fiU = new d(this.mContext);
        this.fiU.setOnDismissListener(this.evD);
        this.fiU.bdN().setBackgroundColor(xL(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.fiU).a(this.fiU.bdN().getSchemeCallback());
        com.baidu.live.view.web.a[] BJ = fVar.BJ();
        for (com.baidu.live.view.web.a aVar : BJ) {
            this.fiU.bdN().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fiU.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void resume() {
        if (this.fiU != null && this.fiU.isShowing() && this.fiU.bdN() != null) {
            this.fiU.bdN().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void pause() {
        if (this.fiU != null && this.fiU.isShowing() && this.fiU.bdN() != null) {
            this.fiU.bdN().onPause();
        }
    }

    public void dismiss() {
        if (this.fiU != null) {
            this.fiU.bdO();
        }
    }

    public void sQ() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void release() {
        sQ();
        MessageManager.getInstance().unRegisterListener(this.evC);
    }

    private void bdM() {
        this.evC = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.fiU != null && c.this.fiU.isShowing()) {
                    c.this.fiU.dismiss();
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
