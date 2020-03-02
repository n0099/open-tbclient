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
    private c euS;
    private CustomMessageListener euT;
    private PopupWindow.OnDismissListener euU;
    private Activity mContext;

    public b(Activity activity) {
        this.mContext = activity;
        bdG();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.euS = new c(this.mContext);
        this.euS.setOnDismissListener(this.euU);
        this.euS.bdH().setBackgroundColor(xK(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.euS).a(this.euS.bdH().getSchemeCallback());
        com.baidu.live.view.web.a[] BC = fVar.BC();
        for (com.baidu.live.view.web.a aVar : BC) {
            this.euS.bdH().addJavascriptInterface(aVar, aVar.getName());
        }
        this.euS.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.euS != null && this.euS.isShowing() && this.euS.bdH() != null) {
            this.euS.bdH().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.euS != null && this.euS.isShowing() && this.euS.bdH() != null) {
            this.euS.bdH().onPause();
        }
    }

    public void dismiss() {
        if (this.euS != null) {
            this.euS.bdI();
        }
    }

    public void sL() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        sL();
        MessageManager.getInstance().unRegisterListener(this.euT);
    }

    private void bdG() {
        this.euT = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.euS != null && b.this.euS.isShowing()) {
                    b.this.euS.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.euT);
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
