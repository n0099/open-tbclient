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
    private CustomMessageListener euS;
    private PopupWindow.OnDismissListener euT;
    private d fif;
    private Activity mContext;

    public c(Activity activity) {
        this.mContext = activity;
        bdE();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void yR(String str) {
        this.fif = new d(this.mContext);
        this.fif.setOnDismissListener(this.euT);
        this.fif.bdF().setBackgroundColor(xK(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.fif).a(this.fif.bdF().getSchemeCallback());
        com.baidu.live.view.web.a[] BA = fVar.BA();
        for (com.baidu.live.view.web.a aVar : BA) {
            this.fif.bdF().addJavascriptInterface(aVar, aVar.getName());
        }
        this.fif.show(str);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void resume() {
        if (this.fif != null && this.fif.isShowing() && this.fif.bdF() != null) {
            this.fif.bdF().onResume();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void pause() {
        if (this.fif != null && this.fif.isShowing() && this.fif.bdF() != null) {
            this.fif.bdF().onPause();
        }
    }

    public void dismiss() {
        if (this.fif != null) {
            this.fif.bdG();
        }
    }

    public void sL() {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void release() {
        sL();
        MessageManager.getInstance().unRegisterListener(this.euS);
    }

    private void bdE() {
        this.euS = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.fif != null && c.this.fif.isShowing()) {
                    c.this.fif.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.euS);
    }

    private int xK(String str) {
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
