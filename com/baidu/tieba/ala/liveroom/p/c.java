package com.baidu.tieba.ala.liveroom.p;

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
/* loaded from: classes2.dex */
public class c implements a {
    private CustomMessageListener eqH;
    private PopupWindow.OnDismissListener eqI;
    private d feS;
    private Activity mContext;

    public c(Activity activity) {
        this.mContext = activity;
        bbp();
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void yw(String str) {
        this.feS = new d(this.mContext);
        this.feS.setOnDismissListener(this.eqI);
        this.feS.bbq().setBackgroundColor(xq(str));
        f fVar = new f();
        fVar.x(this.mContext).a(this.feS).a(this.feS.bbq().getSchemeCallback());
        com.baidu.live.view.web.a[] zk = fVar.zk();
        for (com.baidu.live.view.web.a aVar : zk) {
            this.feS.bbq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.feS.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void resume() {
        if (this.feS != null && this.feS.isShowing() && this.feS.bbq() != null) {
            this.feS.bbq().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void pause() {
        if (this.feS != null && this.feS.isShowing() && this.feS.bbq() != null) {
            this.feS.bbq().onPause();
        }
    }

    public void dismiss() {
        if (this.feS != null) {
            this.feS.bbr();
        }
    }

    public void tz() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.p.a
    public void release() {
        tz();
        MessageManager.getInstance().unRegisterListener(this.eqH);
    }

    private void bbp() {
        this.eqH = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.p.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.feS != null && c.this.feS.isShowing()) {
                    c.this.feS.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eqH);
    }

    private int xq(String str) {
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
