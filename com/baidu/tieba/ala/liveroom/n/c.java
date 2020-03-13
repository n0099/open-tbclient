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
    private CustomMessageListener evg;
    private PopupWindow.OnDismissListener evh;
    private d fiu;
    private Activity mContext;

    public c(Activity activity) {
        this.mContext = activity;
        bdH();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void yS(String str) {
        this.fiu = new d(this.mContext);
        this.fiu.setOnDismissListener(this.evh);
        this.fiu.bdI().setBackgroundColor(xL(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.fiu).a(this.fiu.bdI().getSchemeCallback());
        com.baidu.live.view.web.a[] BC = fVar.BC();
        for (com.baidu.live.view.web.a aVar : BC) {
            this.fiu.bdI().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fiu.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void resume() {
        if (this.fiu != null && this.fiu.isShowing() && this.fiu.bdI() != null) {
            this.fiu.bdI().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void pause() {
        if (this.fiu != null && this.fiu.isShowing() && this.fiu.bdI() != null) {
            this.fiu.bdI().onPause();
        }
    }

    public void dismiss() {
        if (this.fiu != null) {
            this.fiu.bdJ();
        }
    }

    public void sL() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void release() {
        sL();
        MessageManager.getInstance().unRegisterListener(this.evg);
    }

    private void bdH() {
        this.evg = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.fiu != null && c.this.fiu.isShowing()) {
                    c.this.fiu.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.evg);
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
