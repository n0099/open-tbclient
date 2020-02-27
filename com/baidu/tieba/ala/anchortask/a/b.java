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
    private c euR;
    private CustomMessageListener euS;
    private PopupWindow.OnDismissListener euT;
    private Activity mContext;

    public b(Activity activity) {
        this.mContext = activity;
        bdE();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.euR = new c(this.mContext);
        this.euR.setOnDismissListener(this.euT);
        this.euR.bdF().setBackgroundColor(xK(str));
        f fVar = new f();
        fVar.y(this.mContext).a(this.euR).a(this.euR.bdF().getSchemeCallback());
        com.baidu.live.view.web.a[] BA = fVar.BA();
        for (com.baidu.live.view.web.a aVar : BA) {
            this.euR.bdF().addJavascriptInterface(aVar, aVar.getName());
        }
        this.euR.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.euR != null && this.euR.isShowing() && this.euR.bdF() != null) {
            this.euR.bdF().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.euR != null && this.euR.isShowing() && this.euR.bdF() != null) {
            this.euR.bdF().onPause();
        }
    }

    public void dismiss() {
        if (this.euR != null) {
            this.euR.bdG();
        }
    }

    public void sL() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        sL();
        MessageManager.getInstance().unRegisterListener(this.euS);
    }

    private void bdE() {
        this.euS = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.euR != null && b.this.euR.isShowing()) {
                    b.this.euR.dismiss();
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
