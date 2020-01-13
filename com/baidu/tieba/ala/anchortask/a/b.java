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
    private c eqG;
    private CustomMessageListener eqH;
    private PopupWindow.OnDismissListener eqI;
    private Activity mContext;

    public b(Activity activity) {
        this.mContext = activity;
        bbp();
    }

    @Override // com.baidu.live.b.b
    public void c(String str, long j, long j2) {
        this.eqG = new c(this.mContext);
        this.eqG.setOnDismissListener(this.eqI);
        this.eqG.bbq().setBackgroundColor(xq(str));
        f fVar = new f();
        fVar.x(this.mContext).a(this.eqG).a(this.eqG.bbq().getSchemeCallback());
        com.baidu.live.view.web.a[] zk = fVar.zk();
        for (com.baidu.live.view.web.a aVar : zk) {
            this.eqG.bbq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.eqG.show(str + "?anchor_id=" + j2 + "&live_id=" + j + "&subapp_type=" + TbConfig.getSubappType());
    }

    @Override // com.baidu.live.b.b
    public void resume() {
        if (this.eqG != null && this.eqG.isShowing() && this.eqG.bbq() != null) {
            this.eqG.bbq().onResume();
        }
    }

    @Override // com.baidu.live.b.b
    public void pause() {
        if (this.eqG != null && this.eqG.isShowing() && this.eqG.bbq() != null) {
            this.eqG.bbq().onPause();
        }
    }

    public void dismiss() {
        if (this.eqG != null) {
            this.eqG.bbr();
        }
    }

    public void tz() {
        dismiss();
    }

    @Override // com.baidu.live.b.b
    public void release() {
        tz();
        MessageManager.getInstance().unRegisterListener(this.eqH);
    }

    private void bbp() {
        this.eqH = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.anchortask.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.eqG != null && b.this.eqG.isShowing()) {
                    b.this.eqG.dismiss();
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
