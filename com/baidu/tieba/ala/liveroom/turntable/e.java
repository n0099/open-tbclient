package com.baidu.tieba.ala.liveroom.turntable;

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
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes2.dex */
public class e {
    private CustomMessageListener epv;
    private PopupWindow.OnDismissListener epw;
    private d feL;
    private Activity mContext;

    public e(Activity activity) {
        this.mContext = activity;
        baU();
    }

    public void a(String str, long j, long j2, long j3) {
        this.feL = new d(this.mContext);
        this.feL.setOnDismissListener(this.epw);
        this.feL.baV().setBackgroundColor(xl(str));
        f fVar = new f();
        fVar.x(this.mContext).a(this.feL).a(this.feL.baV().getSchemeCallback());
        com.baidu.live.view.web.a[] yO = fVar.yO();
        for (com.baidu.live.view.web.a aVar : yO) {
            this.feL.baV().addJavascriptInterface(aVar, aVar.getName());
        }
        this.feL.show(b(str, j, j2, j3));
    }

    public void resume() {
        if (this.feL != null && this.feL.isShowing() && this.feL.baV() != null) {
            this.feL.baV().onResume();
        }
    }

    public void pause() {
        if (this.feL != null && this.feL.isShowing() && this.feL.baV() != null) {
            this.feL.baV().onPause();
        }
    }

    public void dismiss() {
        if (this.feL != null) {
            this.feL.baW();
        }
    }

    public void bN(int i) {
        if (this.feL != null && this.feL.isShowing()) {
            this.feL.bN(i);
        }
    }

    public void th() {
        dismiss();
    }

    public void release() {
        th();
        MessageManager.getInstance().unRegisterListener(this.epv);
    }

    private void baU() {
        this.epv = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.ala.liveroom.turntable.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.feL != null && e.this.feL.isShowing()) {
                    e.this.feL.dismiss();
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

    private String b(String str, long j, long j2, long j3) {
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(ETAG.ITEM_SEPARATOR);
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(j2);
        sb.append("&anchor_id=");
        sb.append(j3);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        return sb.toString();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.epw = onDismissListener;
    }

    public PopupWindow.OnDismissListener bnU() {
        return this.epw;
    }
}
